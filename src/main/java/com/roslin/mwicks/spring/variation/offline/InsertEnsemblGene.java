package com.roslin.mwicks.spring.variation.offline;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import com.roslin.mwicks.spring.variation.config.MyOfflineApplicationContext;

import com.roslin.mwicks.spring.variation.model.ensemblgene.EnsemblGene;

import com.roslin.mwicks.spring.variation.routines.ConvertFiletoEnsemblGeneList;

import com.roslin.mwicks.spring.variation.serviceinterface.ensemblgene.ServiceEnsemblGene;

import com.roslin.mwicks.utility.FileUtil;
import com.roslin.mwicks.utility.ObjectConverter;
import com.roslin.mwicks.utility.StringUtility;
import com.roslin.mwicks.utility.Wrapper;


public class InsertEnsemblGene {

	// Constants ----------------------------------------------------------------------------------
    private static final String MSGLEVEL = "*";
	private static final String STOP = "*";
	
	private static final char PAD_CHAR = '0';

    private static final String PROPERTY_NAME_HIBERNATE_JDBC_BATCH_SIZE = "hibernate.jdbc.batch_size";
	
    public static final Logger LOG = LoggerFactory.getLogger(InsertEnsemblGene.class);

    @PersistenceContext
    private EntityManager entityManager;
     

    public static void main(String args[]){  

    	try {

        	LOG.trace("InsertEnsemblGene - main");

        	long startTime = Wrapper.printPrologue("*", Wrapper.getExecutingClass());
            
        	int intReturnCode = 0;

            final AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

            // setup configuration
            applicationContext.register(MyOfflineApplicationContext.class);

            applicationContext.refresh();
            applicationContext.start();
            
            LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = (LocalContainerEntityManagerFactoryBean) applicationContext.getBean(LocalContainerEntityManagerFactoryBean.class);

            Map<String, Object> jpaProperties = entityManagerFactoryBean.getJpaPropertyMap();
            String strBatchSize = (String) jpaProperties.get(PROPERTY_NAME_HIBERNATE_JDBC_BATCH_SIZE);
            int intBatchSize = ObjectConverter.convert(strBatchSize, Integer.class);
            
    		if (args.length != 1 ) {
    			
    		    Wrapper.printMessage("ERROR! There MUST be 1 Command Line Arguments passed to this program!", MSGLEVEL, MSGLEVEL);
    			intReturnCode = -1;
            }
            else {
                
        		String directory = args[0];
        		
                File dir = new File(directory);

                if ( dir.exists() ) {
                	
            		File[] filesFile = FileUtil.listAllFilesInDirectory(directory);
            		
            		int totalRecordCount = 0;
            		int totalFileCount = 0;
            		
                    int ensemblgeneTotal = 0;

            		for ( File file : filesFile ) {
            			
            			if ( !file.getName().equals(".DS_Store") ) {
            				
                			totalFileCount++;

                            List<EnsemblGene> ensemblgeneList = ConvertFiletoEnsemblGeneList.run(file);
                            
                            ServiceEnsemblGene serviceEnsemblGene = (ServiceEnsemblGene) applicationContext.getBean(ServiceEnsemblGene.class);
                            
                            totalRecordCount = totalRecordCount +  ensemblgeneList.size();
                            
                			System.out.println(StringUtility.pad(totalFileCount, 3, PAD_CHAR) + " : Directory : " + directory + " : " + file.getName() + " : records : " + StringUtility.pad(ensemblgeneList.size(), 8, PAD_CHAR));

                	     	ensemblgeneTotal = ensemblgeneTotal + ensemblgeneList.size();

                	     	serviceEnsemblGene.bulkSave(intBatchSize, ensemblgeneList);
            			}
            		}
            		
            		System.out.println(StringUtility.pad(ensemblgeneTotal, 8, PAD_CHAR) + " Records inserted into ENSEMBL_GENE");

        			System.out.println(StringUtility.pad(totalRecordCount, 8, PAD_CHAR) + " Records inserted from " + totalFileCount + " files in Directory " + directory );
                }
                else {
                	
                    System.out.println("Directory " + directory + " DOES NOT exist!!!");
                }
                    
            }
    		
            Wrapper.printEpilogue(STOP, Wrapper.getExecutingClass(), startTime);

            applicationContext.close();

        	System.exit(intReturnCode);
    	}
    	catch (Exception e) {
    		
    		e.printStackTrace();
    	}
	}  
}
