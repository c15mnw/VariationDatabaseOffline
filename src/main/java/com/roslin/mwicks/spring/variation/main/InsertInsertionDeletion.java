package com.roslin.mwicks.spring.variation.main;

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

import com.roslin.mwicks.spring.variation.model.snpinsertiondeletion.SNPInsertionDeletion;

import com.roslin.mwicks.spring.variation.routines.ConvertFiletoInsertionDeletionList;
import com.roslin.mwicks.spring.variation.routines.ExpandFiletoInsertionDeletionList;
import com.roslin.mwicks.spring.variation.serviceinterface.snpinsertiondeletion.ServiceSNPInsertionDeletion;

import com.roslin.mwicks.utility.FileUtil;
import com.roslin.mwicks.utility.ObjectConverter;
import com.roslin.mwicks.utility.StringUtility;
import com.roslin.mwicks.utility.Wrapper;


public class InsertInsertionDeletion {

	// Constants ----------------------------------------------------------------------------------
    private static final String MSGLEVEL = "*";
	private static final String STOP = "*";
	
	private static final char PAD_CHAR = ' ';

    private static final String PROPERTY_NAME_HIBERNATE_JDBC_BATCH_SIZE = "hibernate.jdbc.batch_size";
	
    public static final Logger LOG = LoggerFactory.getLogger(InsertInsertionDeletion.class);

    @PersistenceContext
    private EntityManager entityManager;
     

    public static void main(String args[]){  

    	try {

        	LOG.trace("InsertInsertionDeletion - main");

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
            		int totalRowCount = 0;
            		int totalFileCount = 0;
            		
            		for ( File file : filesFile ) {
            			
            			if ( !file.getName().equals(".DS_Store") ) {
            				
                			totalFileCount++;

                            List<SNPInsertionDeletion> snpinsertiondeletionList = ConvertFiletoInsertionDeletionList.run(file, totalRecordCount, MSGLEVEL, MSGLEVEL);

                            List<SNPInsertionDeletion> snpinsertiondeletionListExpanded = ExpandFiletoInsertionDeletionList.run(snpinsertiondeletionList, MSGLEVEL, MSGLEVEL);

                            ServiceSNPInsertionDeletion serviceSNPInsertionDeletion = (ServiceSNPInsertionDeletion) applicationContext.getBean(ServiceSNPInsertionDeletion.class);
                            
                            totalRecordCount = totalRecordCount +  snpinsertiondeletionList.size();
                            totalRowCount = totalRowCount +  snpinsertiondeletionListExpanded.size();
                            //totalRowCount = totalRowCount +  snpinsertiondeletionList.size();
                            
                			Wrapper.printMessage(StringUtility.pad(totalFileCount, 4, PAD_CHAR) + " : Directory : " + directory + " : " + file.getName() + " : records : " + StringUtility.pad(snpinsertiondeletionList.size(), 8, PAD_CHAR), MSGLEVEL, MSGLEVEL);
                			Wrapper.printMessage(StringUtility.pad(totalFileCount, 4, PAD_CHAR) + " : Directory : " + directory + " : " + file.getName() + " : rows    : " + StringUtility.pad(snpinsertiondeletionListExpanded.size(), 8, PAD_CHAR), MSGLEVEL, MSGLEVEL);
                			//Wrapper.printMessage(StringUtility.pad(totalFileCount, 4, PAD_CHAR) + " : Directory : " + directory + " : " + file.getName() + " : rows    : " + StringUtility.pad(snpinsertiondeletionList.size(), 8, PAD_CHAR), MSGLEVEL, MSGLEVEL);

                			serviceSNPInsertionDeletion.bulkSave(intBatchSize, snpinsertiondeletionListExpanded);
                			//serviceSNPInsertionDeletion.bulkSave(intBatchSize, snpinsertiondeletionList);
            			}
            		}
            		
            		Wrapper.printMessage(StringUtility.pad(totalRowCount, 8, PAD_CHAR) + " Rows inserted into VSC_SNP_INSERTION_DELETION", MSGLEVEL, MSGLEVEL);

        			Wrapper.printMessage(StringUtility.pad(totalRecordCount, 8, PAD_CHAR) + " Records from " + totalFileCount + " files in Directory " + directory, MSGLEVEL, MSGLEVEL);
                }
                else {
                	
                    Wrapper.printMessage("Directory " + directory + " DOES NOT exist!!!", MSGLEVEL, MSGLEVEL);
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
