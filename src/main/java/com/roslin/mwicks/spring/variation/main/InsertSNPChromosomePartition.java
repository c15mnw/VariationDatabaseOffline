	package com.roslin.mwicks.spring.variation.main;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import com.roslin.mwicks.spring.variation.config.MyOfflineApplicationContext;

import com.roslin.mwicks.spring.variation.routines.ConvertFiletoSNPChromosomeList;

import com.roslin.mwicks.spring.variation.model.snpchromosome.SNPChromosome;

import com.roslin.mwicks.spring.variation.serviceinterface.snpchromosome.ServiceSNPChromosome;

import com.roslin.mwicks.utility.FileUtil;
import com.roslin.mwicks.utility.ObjectConverter;
import com.roslin.mwicks.utility.StringUtility;
import com.roslin.mwicks.utility.Wrapper;


public class InsertSNPChromosomePartition {

	// Constants ----------------------------------------------------------------------------------
    private static final String MSGLEVEL = "*";
	private static final String STOP = "*";
	
	private static final char PAD_CHAR = ' ';

    private static final String PROPERTY_NAME_HIBERNATE_JDBC_BATCH_SIZE = "hibernate.jdbc.batch_size";
	
    public static final Logger LOG = LoggerFactory.getLogger(InsertSNPChromosomePartition.class);

    @PersistenceContext
    private EntityManager entityManager;
     

    public static void main(String args[]){  

    	try {

        	LOG.trace("InsertSNPChromosome - main");

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
            		
                    int snpchromosome1Total = 0;
                    int snpchromosome2Total = 0;
                    int snpchromosome3Total = 0;
                    int snpchromosome4Total = 0;
                    int snpchromosome5Total = 0;
                    int snpchromosome6Total = 0;
                    int snpchromosome7Total = 0;
                    int snpchromosome8Total = 0;
                    int snpchromosome9Total = 0;
                    int snpchromosome10Total = 0;
                    int snpchromosome11Total = 0;
                    int snpchromosome12Total = 0;
                    int snpchromosome13Total = 0;
                    int snpchromosome14Total = 0;
                    int snpchromosome15Total = 0;
                    int snpchromosome16Total = 0;
                    int snpchromosome17Total = 0;
                    int snpchromosome18Total = 0;
                    int snpchromosome19Total = 0;
                    int snpchromosome20Total = 0;
                    int snpchromosome21Total = 0;
                    int snpchromosome22Total = 0;
                    int snpchromosome23Total = 0;
                    int snpchromosome24Total = 0;
                    int snpchromosome25Total = 0;
                    int snpchromosome26Total = 0;
                    int snpchromosome27Total = 0;
                    int snpchromosome28Total = 0;
                    int snpchromosome32Total = 0;
                    int snpchromosomeWTotal = 0;
                    int snpchromosomeZTotal = 0;
                    int snpchromosomeLGE22C19W28_E50C23Total = 0;
                    int snpchromosomeLGE64Total = 0;

            		for ( File file : filesFile ) {
            			
            			if ( !file.getName().equals(".DS_Store") ) {
            				
                			totalFileCount++;

                            List<SNPChromosome> snpchromosomeList = ConvertFiletoSNPChromosomeList.run(file);
                            

                            ServiceSNPChromosome serviceSNPChromosome = (ServiceSNPChromosome) applicationContext.getBean(ServiceSNPChromosome.class);
                            
                            totalRecordCount = totalRecordCount +  snpchromosomeList.size();
                            
                			System.out.println(StringUtility.pad(totalFileCount, 4, PAD_CHAR) + " : Directory : " + directory + " : " + file.getName() + " : records : " + StringUtility.pad(snpchromosomeList.size(), 8, PAD_CHAR));

                            Iterator<SNPChromosome> iteratorsnpchromosomeList = snpchromosomeList.iterator();
                	        
                	     	while (iteratorsnpchromosomeList.hasNext()) {
                	    		
                	     		SNPChromosome snpchromosome = iteratorsnpchromosomeList.next();
                	     		
                	     		if ( snpchromosome.isSearchChromosome1() ){
                	     			snpchromosome1Total++;
                	     			snpchromosome.setPartitionId(1);
                	     		}
                	     		if ( snpchromosome.isSearchChromosome2() ){
                	     			snpchromosome2Total++;
                	     			snpchromosome.setPartitionId(1);
                	     		}
                	     		if ( snpchromosome.isSearchChromosome3() ){
                	     			snpchromosome3Total++;
                	     			snpchromosome.setPartitionId(1);
                	     		}
                	     		if ( snpchromosome.isSearchChromosome4() ){
                	     			snpchromosome4Total++;
                	     			snpchromosome.setPartitionId(1);
                	     		}
                	     		if ( snpchromosome.isSearchChromosome5() ){
                	     			snpchromosome5Total++;
                	     			snpchromosome.setPartitionId(1);
                	     		}
                	     		if ( snpchromosome.isSearchChromosome6() ){
                	     			snpchromosome6Total++;
                	     			snpchromosome.setPartitionId(1);
                	     		}
                	     		if ( snpchromosome.isSearchChromosome7() ){
                	     			snpchromosome7Total++;
                	     			snpchromosome.setPartitionId(1);
                	     		}
                	     		if ( snpchromosome.isSearchChromosome8() ){
                	     			snpchromosome8Total++;
                	     			snpchromosome.setPartitionId(1);
                	     		}
                	     		if ( snpchromosome.isSearchChromosome9() ){
                	     			snpchromosome9Total++;
                	     			snpchromosome.setPartitionId(1);
                	     		}
                	     		if ( snpchromosome.isSearchChromosome10() ){
                	     			snpchromosome10Total++;
                	     			snpchromosome.setPartitionId(1);
                	     		}
                	     		if ( snpchromosome.isSearchChromosome11() ){
                	     			snpchromosome11Total++;
                	     			snpchromosome.setPartitionId(1);
                	     		}
                	     		if ( snpchromosome.isSearchChromosome12() ){
                	     			snpchromosome12Total++;
                	     			snpchromosome.setPartitionId(1);
                	     		}
                	     		if ( snpchromosome.isSearchChromosome13() ){
                	     			snpchromosome13Total++;
                	     			snpchromosome.setPartitionId(1);
                	     		}
                	     		if ( snpchromosome.isSearchChromosome14() ){
                	     			snpchromosome14Total++;
                	     			snpchromosome.setPartitionId(1);
                	     		}
                	     		if ( snpchromosome.isSearchChromosome15() ){
                	     			snpchromosome15Total++;
                	     			snpchromosome.setPartitionId(1);
                	     		}
                	     		if ( snpchromosome.isSearchChromosome16() ){
                	     			snpchromosome16Total++;
                	     			snpchromosome.setPartitionId(1);
                	     		}
                	     		if ( snpchromosome.isSearchChromosome17() ){
                	     			snpchromosome17Total++;
                	     			snpchromosome.setPartitionId(1);
                	     		}
                	     		if ( snpchromosome.isSearchChromosome18() ){
                	     			snpchromosome18Total++;
                	     			snpchromosome.setPartitionId(1);
                	     		}
                	     		if ( snpchromosome.isSearchChromosome19() ){
                	     			snpchromosome19Total++;
                	     			snpchromosome.setPartitionId(1);
                	     		}
                	     		if ( snpchromosome.isSearchChromosome20() ){
                	     			snpchromosome20Total++;
                	     			snpchromosome.setPartitionId(1);
                	     		}
                	     		if ( snpchromosome.isSearchChromosome21() ){
                	     			snpchromosome21Total++;
                	     			snpchromosome.setPartitionId(1);
                	     		}
                	     		if ( snpchromosome.isSearchChromosome22() ){
                	     			snpchromosome22Total++;
                	     			snpchromosome.setPartitionId(1);
                	     		}
                	     		if ( snpchromosome.isSearchChromosome23() ){
                	     			snpchromosome23Total++;
                	     			snpchromosome.setPartitionId(1);
                	     		}
                	     		if ( snpchromosome.isSearchChromosome24() ){
                	     			snpchromosome24Total++;
                	     			snpchromosome.setPartitionId(1);
                	     		}
                	     		if ( snpchromosome.isSearchChromosome25() ){
                	     			snpchromosome25Total++;
                	     			snpchromosome.setPartitionId(1);
                	     		}
                	     		if ( snpchromosome.isSearchChromosome26() ){
                	     			snpchromosome26Total++;
                	     			snpchromosome.setPartitionId(1);
                	     		}
                	     		if ( snpchromosome.isSearchChromosome27() ){
                	     			snpchromosome27Total++;
                	     			snpchromosome.setPartitionId(1);
                	     		}
                	     		if ( snpchromosome.isSearchChromosome28() ){
                	     			snpchromosome28Total++;
                	     			snpchromosome.setPartitionId(28);
                	     		}
                	     		if ( snpchromosome.isSearchChromosomeLGE22C19W28_E50C23() ){
                	     			snpchromosomeLGE22C19W28_E50C23Total++;
                	     			snpchromosome.setPartitionId(29);
                	     		}
                	     		if ( snpchromosome.isSearchChromosomeLGE64() ){
                	     			snpchromosomeLGE64Total++;
                	     			snpchromosome.setPartitionId(30);
                	     		}
                	     		if ( snpchromosome.isSearchChromosomeW() ){
                	     			snpchromosomeWTotal++;
                	     			snpchromosome.setPartitionId(31);
                	     		}
                	     		if ( snpchromosome.isSearchChromosome32() ){
                	     			snpchromosome32Total++;
                	     			snpchromosome.setPartitionId(32);
                	     		}
                	     		if ( snpchromosome.isSearchChromosomeZ() ){
                	     			snpchromosomeZTotal++;
                	     			snpchromosome.setPartitionId(33);
                	     		}
                	     	}
                	     	

                	     	serviceSNPChromosome.bulkSave(intBatchSize, snpchromosomeList);
            			}
            		}
            		
            		System.out.println(StringUtility.pad(snpchromosome1Total, 8, PAD_CHAR) + " Records inserted into SNP_CHROMOSOME_1");
            		System.out.println(StringUtility.pad(snpchromosome2Total, 8, PAD_CHAR) + " Records inserted into SNP_CHROMOSOME_2");
            		System.out.println(StringUtility.pad(snpchromosome3Total, 8, PAD_CHAR) + " Records inserted into SNP_CHROMOSOME_3");
            		System.out.println(StringUtility.pad(snpchromosome4Total, 8, PAD_CHAR) + " Records inserted into SNP_CHROMOSOME_4");
            		System.out.println(StringUtility.pad(snpchromosome5Total, 8, PAD_CHAR) + " Records inserted into SNP_CHROMOSOME_5");
            		System.out.println(StringUtility.pad(snpchromosome6Total, 8, PAD_CHAR) + " Records inserted into SNP_CHROMOSOME_6");
            		System.out.println(StringUtility.pad(snpchromosome7Total, 8, PAD_CHAR) + " Records inserted into SNP_CHROMOSOME_7");
            		System.out.println(StringUtility.pad(snpchromosome8Total, 8, PAD_CHAR) + " Records inserted into SNP_CHROMOSOME_8");
            		System.out.println(StringUtility.pad(snpchromosome9Total, 8, PAD_CHAR) + " Records inserted into SNP_CHROMOSOME_9");
            		System.out.println(StringUtility.pad(snpchromosome10Total, 8, PAD_CHAR) + " Records inserted into SNP_CHROMOSOME_10");
            		System.out.println(StringUtility.pad(snpchromosome11Total, 8, PAD_CHAR) + " Records inserted into SNP_CHROMOSOME_11");
            		System.out.println(StringUtility.pad(snpchromosome12Total, 8, PAD_CHAR) + " Records inserted into SNP_CHROMOSOME_12");
            		System.out.println(StringUtility.pad(snpchromosome13Total, 8, PAD_CHAR) + " Records inserted into SNP_CHROMOSOME_13");
            		System.out.println(StringUtility.pad(snpchromosome14Total, 8, PAD_CHAR) + " Records inserted into SNP_CHROMOSOME_14");
            		System.out.println(StringUtility.pad(snpchromosome15Total, 8, PAD_CHAR) + " Records inserted into SNP_CHROMOSOME_15");
            		System.out.println(StringUtility.pad(snpchromosome16Total, 8, PAD_CHAR) + " Records inserted into SNP_CHROMOSOME_16");
            		System.out.println(StringUtility.pad(snpchromosome17Total, 8, PAD_CHAR) + " Records inserted into SNP_CHROMOSOME_17");
            		System.out.println(StringUtility.pad(snpchromosome18Total, 8, PAD_CHAR) + " Records inserted into SNP_CHROMOSOME_18");
            		System.out.println(StringUtility.pad(snpchromosome19Total, 8, PAD_CHAR) + " Records inserted into SNP_CHROMOSOME_19");
            		System.out.println(StringUtility.pad(snpchromosome20Total, 8, PAD_CHAR) + " Records inserted into SNP_CHROMOSOME_20");
            		System.out.println(StringUtility.pad(snpchromosome21Total, 8, PAD_CHAR) + " Records inserted into SNP_CHROMOSOME_21");
            		System.out.println(StringUtility.pad(snpchromosome22Total, 8, PAD_CHAR) + " Records inserted into SNP_CHROMOSOME_22");
            		System.out.println(StringUtility.pad(snpchromosome23Total, 8, PAD_CHAR) + " Records inserted into SNP_CHROMOSOME_23");
            		System.out.println(StringUtility.pad(snpchromosome24Total, 8, PAD_CHAR) + " Records inserted into SNP_CHROMOSOME_24");
            		System.out.println(StringUtility.pad(snpchromosome25Total, 8, PAD_CHAR) + " Records inserted into SNP_CHROMOSOME_25");
            		System.out.println(StringUtility.pad(snpchromosome26Total, 8, PAD_CHAR) + " Records inserted into SNP_CHROMOSOME_26");
            		System.out.println(StringUtility.pad(snpchromosome27Total, 8, PAD_CHAR) + " Records inserted into SNP_CHROMOSOME_27");
            		System.out.println(StringUtility.pad(snpchromosome28Total, 8, PAD_CHAR) + " Records inserted into SNP_CHROMOSOME_28");
            		System.out.println(StringUtility.pad(snpchromosome32Total, 8, PAD_CHAR) + " Records inserted into SNP_CHROMOSOME_32");
            		System.out.println(StringUtility.pad(snpchromosomeWTotal, 8, PAD_CHAR) + " Records inserted into SNP_CHROMOSOME_W");
            		System.out.println(StringUtility.pad(snpchromosomeZTotal, 8, PAD_CHAR) + " Records inserted into SNP_CHROMOSOME_Z");
            		System.out.println(StringUtility.pad(snpchromosomeLGE22C19W28_E50C23Total, 8, PAD_CHAR) + " Records inserted into SNP_CHROMOSOME_LGE22C19W28_E50C23");
            		System.out.println(StringUtility.pad(snpchromosomeLGE64Total, 8, PAD_CHAR) + " Records inserted into SNP_CHROMOSOME_LGE64");

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
