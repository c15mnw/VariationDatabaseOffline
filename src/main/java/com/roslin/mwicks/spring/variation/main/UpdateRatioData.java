package com.roslin.mwicks.spring.variation.main;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import com.roslin.mwicks.spring.variation.config.MyOfflineApplicationContext;

import com.roslin.mwicks.spring.variation.model.snpchromosome.SNPChromosome;

import com.roslin.mwicks.spring.variation.model.other.RatioData;

import com.roslin.mwicks.spring.variation.routines.ConvertFiletoUpdateRatioDataList;

import com.roslin.mwicks.spring.variation.serviceinterface.snpchromosome.ServiceSNPChromosome;

import com.roslin.mwicks.utility.FileUtil;
import com.roslin.mwicks.utility.StringUtility;
import com.roslin.mwicks.utility.Wrapper;


public class UpdateRatioData {

	// Constants ----------------------------------------------------------------------------------
    private static final String MSGLEVEL = "*";
	private static final String STOP = "*";
	
	private static final char PAD_CHAR = ' ';

    public static final Logger LOG = LoggerFactory.getLogger(UpdateRatioData.class);

    @PersistenceContext
    private EntityManager entityManager;
     

    public static void main(String args[]){  

    	try {

        	LOG.trace("InsertRatioData - main");

        	long startTime = Wrapper.printPrologue("*", Wrapper.getExecutingClass());
            
        	int intReturnCode = 0;

            final AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

            // setup configuration
            applicationContext.register(MyOfflineApplicationContext.class);

            applicationContext.refresh();
            applicationContext.start();
            
            LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = (LocalContainerEntityManagerFactoryBean) applicationContext.getBean(LocalContainerEntityManagerFactoryBean.class);

    		if (args.length != 1 ) {
    			
    		    Wrapper.printMessage("ERROR! There MUST be 1 Command Line Arguments passed to this program!", MSGLEVEL, MSGLEVEL);
    			intReturnCode = -1;
            }
            else {
                
                ServiceSNPChromosome serviceSNPChromosome = (ServiceSNPChromosome) applicationContext.getBean(ServiceSNPChromosome.class);
               
                File errorFile = new File("/Users/mwicks23/Desktop/Ratio/error_ratio.txt");

                List<String> errorRecords = new ArrayList<String>();

        		String directory = args[0];
        		
                File dir = new File(directory);

                if ( dir.exists() ) {
                	
            		File[] filesFile = FileUtil.listAllFilesInDirectory(directory);
            		
            		int totalRecordCount = 0;
            		int totalFileCount = 0;
            		
                    int ratiodataTotal = 0;

        	     	int intSNPChromosomeCount01 = 0;
        	     	int intSNPChromosomeCount02 = 0;
        	     	int intSNPChromosomeCount03 = 0;
        	     	int intSNPChromosomeCount04 = 0;
        	     	int intSNPChromosomeCount05 = 0;
        	     	int intSNPChromosomeCount06 = 0;
        	     	int intSNPChromosomeCount07 = 0;
        	     	int intSNPChromosomeCount08 = 0;
        	     	int intSNPChromosomeCount09 = 0;
        	     	int intSNPChromosomeCount10 = 0;
        	     	int intSNPChromosomeCount11 = 0;
        	     	int intSNPChromosomeCount12 = 0;
        	     	int intSNPChromosomeCount13 = 0;
        	     	int intSNPChromosomeCount14 = 0;
        	     	int intSNPChromosomeCount15 = 0;
        	     	int intSNPChromosomeCount16 = 0;
        	     	int intSNPChromosomeCount17 = 0;
        	     	int intSNPChromosomeCount18 = 0;
        	     	int intSNPChromosomeCount19 = 0;
        	     	int intSNPChromosomeCount20 = 0;
        	     	int intSNPChromosomeCount21 = 0;
        	     	int intSNPChromosomeCount22 = 0;
        	     	int intSNPChromosomeCount23 = 0;
        	     	int intSNPChromosomeCount24 = 0;
        	     	int intSNPChromosomeCount25 = 0;
        	     	int intSNPChromosomeCount26 = 0;
        	     	int intSNPChromosomeCount27 = 0;
        	     	int intSNPChromosomeCount28 = 0;
        	     	int intSNPChromosomeCount32 = 0;
        	     	int intSNPChromosomeCountLGE22C19W28_E50C23 = 0;
        	     	int intSNPChromosomeCountLGE64 = 0;
        	     	int intSNPChromosomeCountW = 0;
        	     	int intSNPChromosomeCountZ = 0;

        	        int error = 0;
        	        
            		for ( File file : filesFile ) {
            			
            			if ( !file.getName().equals(".DS_Store") ) {
            				
                			totalFileCount++;

                            List<RatioData> ratiodataList = ConvertFiletoUpdateRatioDataList.run(file);
 
                            totalRecordCount = totalRecordCount +  ratiodataList.size();
                            
                			System.out.println(StringUtility.pad(totalFileCount, 3, PAD_CHAR) + " : Directory : " + directory + " : " + file.getName() + " : records : " + StringUtility.pad(ratiodataList.size(), 8, PAD_CHAR));

                	     	ratiodataTotal = ratiodataTotal + ratiodataList.size();
                	     	
                	        Iterator<RatioData> iteratorRatioData = ratiodataList.iterator();
                	        
                	     	while (iteratorRatioData.hasNext()) {
                	    		
                	     		RatioData ratiodata = iteratorRatioData.next();
                	     		
                	     		if ( !ratiodata.isThisAValidRatioData() ) {
                	     			
            	     				error++;

            	     				String errorRecord = "INVALID RATIO DATA!\t" + 
            	     				        ratiodata.getSnpId() + "\t" +
            	     						ratiodata.getStrain() + "\t" +
            	     						ratiodata.getStrainAlleleReferenceCount() + "\t" +
            	     						ratiodata.getStrainAlleleAlternativeCount() + "\t" +
            	     						ratiodata.getStrainAlleleRatio();
            	     						
            	     				errorRecords.add(errorRecord);
            	     				//System.out.println("Error No. " + error + " : SNP Id. " + ratiodata.getSnpId() + " UNKNOWN CHROMOSOME : " + ratiodata.toString());
                	     		}
                	     		else {
                	     			
                    	     		if ( ratiodata.isChromosome1() ) {
                    	     			
                    	                List<SNPChromosome> snpchromosome1List = new ArrayList<SNPChromosome>();
                    	     			
                    	     			snpchromosome1List = serviceSNPChromosome.findBySnpId(ratiodata.getSnpId());
                    	     			
                    	     			if ( snpchromosome1List.isEmpty() ) {
                    	     				
                    	     				error++;

                    	     				String errorRecord = "SNP NOT FOUND!\t" + 
                    	     				        ratiodata.getSnpId() + "\t" +
                    	     						ratiodata.getStrain() + "\t" +
                    	     						ratiodata.getStrainAlleleReferenceCount() + "\t" +
                    	     						ratiodata.getStrainAlleleAlternativeCount() + "\t" +
                    	     						ratiodata.getStrainAlleleRatio();
                    	     						
                    	     				errorRecords.add(errorRecord);
                    	     				//System.out.println("Error No. " + error + " : SNP Id. " + ratiodata.getSnpId() + " NOT FOUND : " + ratiodata.toString());
                    	     			}
                    	     			else {
                    	     				
                        	     			if ( snpchromosome1List.size() > 1 ) {
                        	     				
                        	     				error++;

                        	     				String errorRecord = "MULTIPLE SNPs!\t" + 
                        	     				        ratiodata.getSnpId() + "\t" +
                        	     						ratiodata.getStrain() + "\t" +
                        	     						ratiodata.getStrainAlleleReferenceCount() + "\t" +
                        	     						ratiodata.getStrainAlleleAlternativeCount() + "\t" +
                        	     						ratiodata.getStrainAlleleRatio();

                        	     				errorRecords.add(errorRecord);

                        	     				//System.out.println("Error No. " + error + " : SNP Id. " + siftdata.getSnpId() + " GREATER THAN 1 ROW FOR : " + siftdata.toString());
                        	     			}
                        	     			else {

                                    	        Iterator<SNPChromosome> iteratorSNPChromosome = snpchromosome1List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome.hasNext()) {

                                    	     		SNPChromosome snpchromosome = iteratorSNPChromosome.next();
                                    	     		
                            	     				if ( ratiodata.isStrain7() ) {
                                	     				snpchromosome.setStrain7AlleleRatio(ratiodata.getStrainAlleleRatio());
                                    	     			snpchromosome.setStrain7AlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                    	     			snpchromosome.setStrain7AlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainP() ) {
                                    	     			snpchromosome.setStrainPAlleleRatio(ratiodata.getStrainAlleleRatio());
                                    	     			snpchromosome.setStrainPAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                    	     			snpchromosome.setStrainPAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainW() ) {
                                    	     			snpchromosome.setStrainWAlleleRatio(ratiodata.getStrainAlleleRatio());
                                    	     			snpchromosome.setStrainWAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                    	     			snpchromosome.setStrainWAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainN() ) {
                                    	     			snpchromosome.setStrainNAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrainNAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrainNAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrain15I() ) {
                                        	     		snpchromosome.setStrain15IAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrain15IAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrain15IAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainZero() ) {
                                        	     		snpchromosome.setStrainZeroAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrainZeroAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrainZeroAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrain6() ) {
                                        	     		snpchromosome.setStrain6AlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrain6AlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrain6AlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainC() ) {
                                        	     		snpchromosome.setStrainCAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrainCAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrainCAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}

                                    	     		serviceSNPChromosome.update(snpchromosome);
                                    	     		
                                    	     		intSNPChromosomeCount01++;
                                    	     	}
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( ratiodata.isChromosome2() ) {
                    	     			
                    	                List<SNPChromosome> snpchromosome2List = new ArrayList<SNPChromosome>();
                    	     			
                    	     			snpchromosome2List = serviceSNPChromosome.findBySnpId(ratiodata.getSnpId());
                    	     			
                    	     			if ( snpchromosome2List.isEmpty() ) {
                    	     				
                    	     				error++;

                    	     				String errorRecord = "SNP NOT FOUND!\t" + 
                    	     				        ratiodata.getSnpId() + "\t" +
                    	     						ratiodata.getStrain() + "\t" +
                    	     						ratiodata.getStrainAlleleReferenceCount() + "\t" +
                    	     						ratiodata.getStrainAlleleAlternativeCount() + "\t" +
                    	     						ratiodata.getStrainAlleleRatio();
                    	     						
                    	     				errorRecords.add(errorRecord);

                    	     				//System.out.println("Error No. " + error + " : SNP Id. " + ratiodata.getSnpId() + " NOT FOUND : " + ratiodata.toString());
                    	     			}
                    	     			else {
                    	     				
                        	     			if ( snpchromosome2List.size() > 1 ) {
                        	     				
                        	     				error++;

                        	     				String errorRecord = "MULTIPLE SNPs!\t" + 
                        	     				        ratiodata.getSnpId() + "\t" +
                        	     						ratiodata.getStrain() + "\t" +
                        	     						ratiodata.getStrainAlleleReferenceCount() + "\t" +
                        	     						ratiodata.getStrainAlleleAlternativeCount() + "\t" +
                        	     						ratiodata.getStrainAlleleRatio();

                        	     				errorRecords.add(errorRecord);

                        	     				//System.out.println("Error No. " + error + " : SNP Id. " + siftdata.getSnpId() + " GREATER THAN 1 ROW FOR : " + siftdata.toString());
                        	     			}
                        	     			else {

                                    	        Iterator<SNPChromosome> iteratorSNPChromosome = snpchromosome2List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome.hasNext()) {

                                    	     		SNPChromosome snpchromosome = iteratorSNPChromosome.next();
                                    	     		
                            	     				if ( ratiodata.isStrain7() ) {
                                	     				snpchromosome.setStrain7AlleleRatio(ratiodata.getStrainAlleleRatio());
                                    	     			snpchromosome.setStrain7AlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                    	     			snpchromosome.setStrain7AlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainP() ) {
                                    	     			snpchromosome.setStrainPAlleleRatio(ratiodata.getStrainAlleleRatio());
                                    	     			snpchromosome.setStrainPAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                    	     			snpchromosome.setStrainPAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainW() ) {
                                    	     			snpchromosome.setStrainWAlleleRatio(ratiodata.getStrainAlleleRatio());
                                    	     			snpchromosome.setStrainWAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                    	     			snpchromosome.setStrainWAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainN() ) {
                                    	     			snpchromosome.setStrainNAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrainNAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrainNAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrain15I() ) {
                                        	     		snpchromosome.setStrain15IAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrain15IAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrain15IAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainZero() ) {
                                        	     		snpchromosome.setStrainZeroAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrainZeroAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrainZeroAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrain6() ) {
                                        	     		snpchromosome.setStrain6AlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrain6AlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrain6AlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainC() ) {
                                        	     		snpchromosome.setStrainCAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrainCAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrainCAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}

                                    	     		serviceSNPChromosome.update(snpchromosome);
                                    	     		
                                    	     		intSNPChromosomeCount02++;
                                    	     	}
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( ratiodata.isChromosome3() ) {

                    	                List<SNPChromosome> snpchromosome3List = new ArrayList<SNPChromosome>();

                    	     			snpchromosome3List = serviceSNPChromosome.findBySnpId(ratiodata.getSnpId());
                    	     			
                    	     			if ( snpchromosome3List.isEmpty() ) {
                    	     				
                    	     				error++;

                    	     				String errorRecord = "SNP NOT FOUND!\t" + 
                    	     				        ratiodata.getSnpId() + "\t" +
                    	     						ratiodata.getStrain() + "\t" +
                    	     						ratiodata.getStrainAlleleReferenceCount() + "\t" +
                    	     						ratiodata.getStrainAlleleAlternativeCount() + "\t" +
                    	     						ratiodata.getStrainAlleleRatio();
                    	     						
                    	     				errorRecords.add(errorRecord);

                    	     				//System.out.println("Error No. " + error + " : SNP Id. " + ratiodata.getSnpId() + " NOT FOUND : " + ratiodata.toString());
                    	     			}
                    	     			else {

                        	     			if ( snpchromosome3List.size() > 1 ) {
                        	     				
                        	     				error++;

                        	     				String errorRecord = "MULTIPLE SNPs!\t" + 
                        	     				        ratiodata.getSnpId() + "\t" +
                        	     						ratiodata.getStrain() + "\t" +
                        	     						ratiodata.getStrainAlleleReferenceCount() + "\t" +
                        	     						ratiodata.getStrainAlleleAlternativeCount() + "\t" +
                        	     						ratiodata.getStrainAlleleRatio();

                        	     				errorRecords.add(errorRecord);

                        	     				//System.out.println("Error No. " + error + " : SNP Id. " + siftdata.getSnpId() + " GREATER THAN 1 ROW FOR : " + siftdata.toString());
                        	     			}
                        	     			else {

                                    	        Iterator<SNPChromosome> iteratorSNPChromosome = snpchromosome3List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome.hasNext()) {

                                    	     		SNPChromosome snpchromosome = iteratorSNPChromosome.next();

                                    	     		if ( ratiodata.isStrain7() ) {
                                    	     			snpchromosome.setStrain7AlleleRatio(ratiodata.getStrainAlleleRatio());
                                    	     			snpchromosome.setStrain7AlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                    	     			snpchromosome.setStrain7AlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainP() ) {
                                    	     			snpchromosome.setStrainPAlleleRatio(ratiodata.getStrainAlleleRatio());
                                    	     			snpchromosome.setStrainPAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                    	     			snpchromosome.setStrainPAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainW() ) {
                                    	     			snpchromosome.setStrainWAlleleRatio(ratiodata.getStrainAlleleRatio());
                                    	     			snpchromosome.setStrainWAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                    	     			snpchromosome.setStrainWAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainN() ) {
                                    	     			snpchromosome.setStrainNAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrainNAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrainNAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrain15I() ) {
                                        	     		snpchromosome.setStrain15IAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrain15IAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrain15IAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainZero() ) {
                                        	     		snpchromosome.setStrainZeroAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrainZeroAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrainZeroAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrain6() ) {
                                        	     		snpchromosome.setStrain6AlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrain6AlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrain6AlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainC() ) {
                                        	     		snpchromosome.setStrainCAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrainCAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrainCAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}

                                    	     		serviceSNPChromosome.update(snpchromosome);

                                    	     		intSNPChromosomeCount03++;
                                    	        }
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( ratiodata.isChromosome4() ) {
                    	     			
                    	                List<SNPChromosome> snpchromosome4List = new ArrayList<SNPChromosome>();

                    	                snpchromosome4List = serviceSNPChromosome.findBySnpId(ratiodata.getSnpId());
                    	                
                    	     			if ( snpchromosome4List.isEmpty() ) {
                    	     				
                    	     				error++;

                    	     				String errorRecord = "SNP NOT FOUND!\t" + 
                    	     				        ratiodata.getSnpId() + "\t" +
                    	     						ratiodata.getStrain() + "\t" +
                    	     						ratiodata.getStrainAlleleReferenceCount() + "\t" +
                    	     						ratiodata.getStrainAlleleAlternativeCount() + "\t" +
                    	     						ratiodata.getStrainAlleleRatio();
                    	     						
                    	     				errorRecords.add(errorRecord);

                    	     				//System.out.println("Error No. " + error + " : SNP Id. " + ratiodata.getSnpId() + " NOT FOUND : " + ratiodata.toString());
                    	     			}
                    	     			else {

                        	     			if ( snpchromosome4List.size() > 1 ) {
                        	     				
                        	     				error++;

                        	     				String errorRecord = "MULTIPLE SNPs!\t" + 
                        	     				        ratiodata.getSnpId() + "\t" +
                        	     						ratiodata.getStrain() + "\t" +
                        	     						ratiodata.getStrainAlleleReferenceCount() + "\t" +
                        	     						ratiodata.getStrainAlleleAlternativeCount() + "\t" +
                        	     						ratiodata.getStrainAlleleRatio();

                        	     				errorRecords.add(errorRecord);

                        	     				//System.out.println("Error No. " + error + " : SNP Id. " + siftdata.getSnpId() + " GREATER THAN 1 ROW FOR : " + siftdata.toString());
                        	     			}
                        	     			else {

                                    	        Iterator<SNPChromosome> iteratorSNPChromosome = snpchromosome4List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome.hasNext()) {

                                    	     		SNPChromosome snpchromosome = iteratorSNPChromosome.next();

                                    	     		if ( ratiodata.isStrain7() ) {
                                    	     			snpchromosome.setStrain7AlleleRatio(ratiodata.getStrainAlleleRatio());
                                    	     			snpchromosome.setStrain7AlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                    	     			snpchromosome.setStrain7AlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainP() ) {
                                    	     			snpchromosome.setStrainPAlleleRatio(ratiodata.getStrainAlleleRatio());
                                    	     			snpchromosome.setStrainPAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                    	     			snpchromosome.setStrainPAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainW() ) {
                                    	     			snpchromosome.setStrainWAlleleRatio(ratiodata.getStrainAlleleRatio());
                                    	     			snpchromosome.setStrainWAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                    	     			snpchromosome.setStrainWAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainN() ) {
                                    	     			snpchromosome.setStrainNAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrainNAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrainNAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrain15I() ) {
                                        	     		snpchromosome.setStrain15IAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrain15IAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrain15IAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainZero() ) {
                                        	     		snpchromosome.setStrainZeroAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrainZeroAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrainZeroAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrain6() ) {
                                        	     		snpchromosome.setStrain6AlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrain6AlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrain6AlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainC() ) {
                                        	     		snpchromosome.setStrainCAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrainCAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrainCAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}

                                    	     		serviceSNPChromosome.update(snpchromosome);
                                    	     		
                                    	     		intSNPChromosomeCount04++;
                                    	     	}
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( ratiodata.isChromosome5() ) {
                    	     			
                    	                List<SNPChromosome> snpchromosome5List = new ArrayList<SNPChromosome>();

                    	                snpchromosome5List = serviceSNPChromosome.findBySnpId(ratiodata.getSnpId());
                    	                
                    	     			if ( snpchromosome5List.isEmpty() ) {
                    	     				
                    	     				error++;

                    	     				String errorRecord = "SNP NOT FOUND!\t" + 
                    	     				        ratiodata.getSnpId() + "\t" +
                    	     						ratiodata.getStrain() + "\t" +
                    	     						ratiodata.getStrainAlleleReferenceCount() + "\t" +
                    	     						ratiodata.getStrainAlleleAlternativeCount() + "\t" +
                    	     						ratiodata.getStrainAlleleRatio();
                    	     						
                    	     				errorRecords.add(errorRecord);

                    	     				//System.out.println("Error No. " + error + " : SNP Id. " + ratiodata.getSnpId() + " NOT FOUND : " + ratiodata.toString());
                    	     			}
                    	     			else {

                        	     			if ( snpchromosome5List.size() > 1 ) {
                        	     				
                        	     				error++;

                        	     				String errorRecord = "MULTIPLE SNPs!\t" + 
                        	     				        ratiodata.getSnpId() + "\t" +
                        	     						ratiodata.getStrain() + "\t" +
                        	     						ratiodata.getStrainAlleleReferenceCount() + "\t" +
                        	     						ratiodata.getStrainAlleleAlternativeCount() + "\t" +
                        	     						ratiodata.getStrainAlleleRatio();

                        	     				errorRecords.add(errorRecord);

                        	     				//System.out.println("Error No. " + error + " : SNP Id. " + siftdata.getSnpId() + " GREATER THAN 1 ROW FOR : " + siftdata.toString());
                        	     			}
                        	     			else {

                                    	        Iterator<SNPChromosome> iteratorSNPChromosome = snpchromosome5List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome.hasNext()) {

                                    	     		SNPChromosome snpchromosome = iteratorSNPChromosome.next();

                                    	     		if ( ratiodata.isStrain7() ) {
                                    	     			snpchromosome.setStrain7AlleleRatio(ratiodata.getStrainAlleleRatio());
                                    	     			snpchromosome.setStrain7AlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                    	     			snpchromosome.setStrain7AlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainP() ) {
                                    	     			snpchromosome.setStrainPAlleleRatio(ratiodata.getStrainAlleleRatio());
                                    	     			snpchromosome.setStrainPAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                    	     			snpchromosome.setStrainPAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainW() ) {
                                    	     			snpchromosome.setStrainWAlleleRatio(ratiodata.getStrainAlleleRatio());
                                    	     			snpchromosome.setStrainWAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                    	     			snpchromosome.setStrainWAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainN() ) {
                                    	     			snpchromosome.setStrainNAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrainNAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrainNAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrain15I() ) {
                                        	     		snpchromosome.setStrain15IAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrain15IAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrain15IAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainZero() ) {
                                        	     		snpchromosome.setStrainZeroAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrainZeroAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrainZeroAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrain6() ) {
                                        	     		snpchromosome.setStrain6AlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrain6AlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrain6AlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainC() ) {
                                        	     		snpchromosome.setStrainCAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrainCAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrainCAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}

                                    	     		serviceSNPChromosome.update(snpchromosome);
                                    	     		
                                    	     		intSNPChromosomeCount05++;
                                    	     	}
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( ratiodata.isChromosome6() ) {
                    	     			
                    	                List<SNPChromosome> snpchromosome6List = new ArrayList<SNPChromosome>();

                    	                snpchromosome6List = serviceSNPChromosome.findBySnpId(ratiodata.getSnpId());
                    	                
                    	     			if ( snpchromosome6List.isEmpty() ) {
                    	     				
                    	     				error++;

                    	     				String errorRecord = "SNP NOT FOUND!\t" + 
                    	     				        ratiodata.getSnpId() + "\t" +
                    	     						ratiodata.getStrain() + "\t" +
                    	     						ratiodata.getStrainAlleleReferenceCount() + "\t" +
                    	     						ratiodata.getStrainAlleleAlternativeCount() + "\t" +
                    	     						ratiodata.getStrainAlleleRatio();
                    	     						
                    	     				errorRecords.add(errorRecord);

                    	     				//System.out.println("Error No. " + error + " : SNP Id. " + ratiodata.getSnpId() + " NOT FOUND : " + ratiodata.toString());
                    	     			}
                    	     			else {

                        	     			if ( snpchromosome6List.size() > 1 ) {
                        	     				
                        	     				error++;

                        	     				String errorRecord = "MULTIPLE SNPs!\t" + 
                        	     				        ratiodata.getSnpId() + "\t" +
                        	     						ratiodata.getStrain() + "\t" +
                        	     						ratiodata.getStrainAlleleReferenceCount() + "\t" +
                        	     						ratiodata.getStrainAlleleAlternativeCount() + "\t" +
                        	     						ratiodata.getStrainAlleleRatio();

                        	     				errorRecords.add(errorRecord);

                        	     				//System.out.println("Error No. " + error + " : SNP Id. " + siftdata.getSnpId() + " GREATER THAN 1 ROW FOR : " + siftdata.toString());
                        	     			}
                        	     			else {

                                    	        Iterator<SNPChromosome> iteratorSNPChromosome = snpchromosome6List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome.hasNext()) {

                                    	     		SNPChromosome snpchromosome = iteratorSNPChromosome.next();

                                    	     		if ( ratiodata.isStrain7() ) {
                                    	     			snpchromosome.setStrain7AlleleRatio(ratiodata.getStrainAlleleRatio());
                                    	     			snpchromosome.setStrain7AlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                    	     			snpchromosome.setStrain7AlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainP() ) {
                                    	     			snpchromosome.setStrainPAlleleRatio(ratiodata.getStrainAlleleRatio());
                                    	     			snpchromosome.setStrainPAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                    	     			snpchromosome.setStrainPAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainW() ) {
                                    	     			snpchromosome.setStrainWAlleleRatio(ratiodata.getStrainAlleleRatio());
                                    	     			snpchromosome.setStrainWAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                    	     			snpchromosome.setStrainWAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainN() ) {
                                    	     			snpchromosome.setStrainNAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrainNAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrainNAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrain15I() ) {
                                        	     		snpchromosome.setStrain15IAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrain15IAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrain15IAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainZero() ) {
                                        	     		snpchromosome.setStrainZeroAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrainZeroAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrainZeroAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrain6() ) {
                                        	     		snpchromosome.setStrain6AlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrain6AlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrain6AlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainC() ) {
                                        	     		snpchromosome.setStrainCAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrainCAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrainCAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}

                                    	     		serviceSNPChromosome.update(snpchromosome);
                                    	     		
                                    	     		intSNPChromosomeCount06++;
                                    	     	}
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( ratiodata.isChromosome7() ) {
                    	     			
                    	                List<SNPChromosome> snpchromosome7List = new ArrayList<SNPChromosome>();

                    	                snpchromosome7List = serviceSNPChromosome.findBySnpId(ratiodata.getSnpId());
                    	                
                    	     			if ( snpchromosome7List.isEmpty() ) {
                    	     				
                    	     				error++;

                    	     				String errorRecord = "SNP NOT FOUND!\t" + 
                    	     				        ratiodata.getSnpId() + "\t" +
                    	     						ratiodata.getStrain() + "\t" +
                    	     						ratiodata.getStrainAlleleReferenceCount() + "\t" +
                    	     						ratiodata.getStrainAlleleAlternativeCount() + "\t" +
                    	     						ratiodata.getStrainAlleleRatio();
                    	     						
                    	     				errorRecords.add(errorRecord);

                    	     				//System.out.println("Error No. " + error + " : SNP Id. " + ratiodata.getSnpId() + " NOT FOUND : " + ratiodata.toString());
                    	     			}
                    	     			else {

                        	     			if ( snpchromosome7List.size() > 1 ) {
                        	     				
                        	     				error++;

                        	     				String errorRecord = "MULTIPLE SNPs!\t" + 
                        	     				        ratiodata.getSnpId() + "\t" +
                        	     						ratiodata.getStrain() + "\t" +
                        	     						ratiodata.getStrainAlleleReferenceCount() + "\t" +
                        	     						ratiodata.getStrainAlleleAlternativeCount() + "\t" +
                        	     						ratiodata.getStrainAlleleRatio();

                        	     				errorRecords.add(errorRecord);

                        	     				//System.out.println("Error No. " + error + " : SNP Id. " + siftdata.getSnpId() + " GREATER THAN 1 ROW FOR : " + siftdata.toString());
                        	     			}
                        	     			else {

                                    	        Iterator<SNPChromosome> iteratorSNPChromosome = snpchromosome7List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome.hasNext()) {

                                    	     		SNPChromosome snpchromosome = iteratorSNPChromosome.next();

                                    	     		if ( ratiodata.isStrain7() ) {
                                    	     			snpchromosome.setStrain7AlleleRatio(ratiodata.getStrainAlleleRatio());
                                    	     			snpchromosome.setStrain7AlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                    	     			snpchromosome.setStrain7AlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainP() ) {
                                    	     			snpchromosome.setStrainPAlleleRatio(ratiodata.getStrainAlleleRatio());
                                    	     			snpchromosome.setStrainPAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                    	     			snpchromosome.setStrainPAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainW() ) {
                                    	     			snpchromosome.setStrainWAlleleRatio(ratiodata.getStrainAlleleRatio());
                                    	     			snpchromosome.setStrainWAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                    	     			snpchromosome.setStrainWAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainN() ) {
                                    	     			snpchromosome.setStrainNAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrainNAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrainNAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrain15I() ) {
                                        	     		snpchromosome.setStrain15IAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrain15IAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrain15IAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainZero() ) {
                                        	     		snpchromosome.setStrainZeroAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrainZeroAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrainZeroAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrain6() ) {
                                        	     		snpchromosome.setStrain6AlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrain6AlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrain6AlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainC() ) {
                                        	     		snpchromosome.setStrainCAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrainCAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrainCAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}

                                    	     		serviceSNPChromosome.update(snpchromosome);
                                    	     		
                                    	     		intSNPChromosomeCount07++;
                                    	     	}
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( ratiodata.isChromosome8() ) {

                    	                List<SNPChromosome> snpchromosome8List = new ArrayList<SNPChromosome>();

                    	     			snpchromosome8List = serviceSNPChromosome.findBySnpId(ratiodata.getSnpId());
                    	     			
                    	     			if ( snpchromosome8List.isEmpty() ) {
                    	     				
                    	     				error++;

                    	     				String errorRecord = "SNP NOT FOUND!\t" + 
                    	     				        ratiodata.getSnpId() + "\t" +
                    	     						ratiodata.getStrain() + "\t" +
                    	     						ratiodata.getStrainAlleleReferenceCount() + "\t" +
                    	     						ratiodata.getStrainAlleleAlternativeCount() + "\t" +
                    	     						ratiodata.getStrainAlleleRatio();
                    	     						
                    	     				errorRecords.add(errorRecord);

                    	     				//System.out.println("Error No. " + error + " : SNP Id. " + ratiodata.getSnpId() + " NOT FOUND : " + ratiodata.toString());
                    	     			}
                    	     			else {

                        	     			if ( snpchromosome8List.size() > 1 ) {
                        	     				
                        	     				error++;

                        	     				String errorRecord = "MULTIPLE SNPs!\t" + 
                        	     				        ratiodata.getSnpId() + "\t" +
                        	     						ratiodata.getStrain() + "\t" +
                        	     						ratiodata.getStrainAlleleReferenceCount() + "\t" +
                        	     						ratiodata.getStrainAlleleAlternativeCount() + "\t" +
                        	     						ratiodata.getStrainAlleleRatio();

                        	     				errorRecords.add(errorRecord);

                        	     				//System.out.println("Error No. " + error + " : SNP Id. " + siftdata.getSnpId() + " GREATER THAN 1 ROW FOR : " + siftdata.toString());
                        	     			}
                        	     			else {

                                    	        Iterator<SNPChromosome> iteratorSNPChromosome = snpchromosome8List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome.hasNext()) {

                                    	     		SNPChromosome snpchromosome = iteratorSNPChromosome.next();

                                    	     		if ( ratiodata.isStrain7() ) {
                                    	     			snpchromosome.setStrain7AlleleRatio(ratiodata.getStrainAlleleRatio());
                                    	     			snpchromosome.setStrain7AlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                    	     			snpchromosome.setStrain7AlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainP() ) {
                                    	     			snpchromosome.setStrainPAlleleRatio(ratiodata.getStrainAlleleRatio());
                                    	     			snpchromosome.setStrainPAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                    	     			snpchromosome.setStrainPAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainW() ) {
                                    	     			snpchromosome.setStrainWAlleleRatio(ratiodata.getStrainAlleleRatio());
                                    	     			snpchromosome.setStrainWAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                    	     			snpchromosome.setStrainWAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainN() ) {
                                    	     			snpchromosome.setStrainNAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrainNAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrainNAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrain15I() ) {
                                        	     		snpchromosome.setStrain15IAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrain15IAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrain15IAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainZero() ) {
                                        	     		snpchromosome.setStrainZeroAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrainZeroAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrainZeroAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrain6() ) {
                                        	     		snpchromosome.setStrain6AlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrain6AlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrain6AlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainC() ) {
                                        	     		snpchromosome.setStrainCAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrainCAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrainCAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}

                                    	     		serviceSNPChromosome.update(snpchromosome);
                                    	     		
                                    	     		intSNPChromosomeCount08++;
                                    	     	}
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( ratiodata.isChromosome9() ) {

                    	                List<SNPChromosome> snpchromosome9List = new ArrayList<SNPChromosome>();

                    	     			snpchromosome9List = serviceSNPChromosome.findBySnpId(ratiodata.getSnpId());
                    	     			
                    	     			if ( snpchromosome9List.isEmpty() ) {
                    	     				
                    	     				error++;

                    	     				String errorRecord = "SNP NOT FOUND!\t" + 
                    	     				        ratiodata.getSnpId() + "\t" +
                    	     						ratiodata.getStrain() + "\t" +
                    	     						ratiodata.getStrainAlleleReferenceCount() + "\t" +
                    	     						ratiodata.getStrainAlleleAlternativeCount() + "\t" +
                    	     						ratiodata.getStrainAlleleRatio();
                    	     						
                    	     				errorRecords.add(errorRecord);

                    	     				//System.out.println("Error No. " + error + " : SNP Id. " + ratiodata.getSnpId() + " NOT FOUND : " + ratiodata.toString());
                    	     			}
                    	     			else {

                        	     			if ( snpchromosome9List.size() > 1 ) {
                        	     				
                        	     				error++;

                        	     				String errorRecord = "MULTIPLE SNPs!\t" + 
                        	     				        ratiodata.getSnpId() + "\t" +
                        	     						ratiodata.getStrain() + "\t" +
                        	     						ratiodata.getStrainAlleleReferenceCount() + "\t" +
                        	     						ratiodata.getStrainAlleleAlternativeCount() + "\t" +
                        	     						ratiodata.getStrainAlleleRatio();

                        	     				errorRecords.add(errorRecord);

                        	     				//System.out.println("Error No. " + error + " : SNP Id. " + siftdata.getSnpId() + " GREATER THAN 1 ROW FOR : " + siftdata.toString());
                        	     			}
                        	     			else {

                                    	        Iterator<SNPChromosome> iteratorSNPChromosome = snpchromosome9List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome.hasNext()) {

                                    	     		SNPChromosome snpchromosome = iteratorSNPChromosome.next();

                                    	     		if ( ratiodata.isStrain7() ) {
                                    	     			snpchromosome.setStrain7AlleleRatio(ratiodata.getStrainAlleleRatio());
                                    	     			snpchromosome.setStrain7AlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                    	     			snpchromosome.setStrain7AlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainP() ) {
                                    	     			snpchromosome.setStrainPAlleleRatio(ratiodata.getStrainAlleleRatio());
                                    	     			snpchromosome.setStrainPAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                    	     			snpchromosome.setStrainPAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainW() ) {
                                    	     			snpchromosome.setStrainWAlleleRatio(ratiodata.getStrainAlleleRatio());
                                    	     			snpchromosome.setStrainWAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                    	     			snpchromosome.setStrainWAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainN() ) {
                                    	     			snpchromosome.setStrainNAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrainNAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrainNAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrain15I() ) {
                                        	     		snpchromosome.setStrain15IAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrain15IAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrain15IAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainZero() ) {
                                        	     		snpchromosome.setStrainZeroAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrainZeroAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrainZeroAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrain6() ) {
                                        	     		snpchromosome.setStrain6AlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrain6AlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrain6AlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainC() ) {
                                        	     		snpchromosome.setStrainCAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrainCAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrainCAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}

                                    	     		serviceSNPChromosome.update(snpchromosome);
                                    	     		
                                    	     		intSNPChromosomeCount09++;
                                    	     	}
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( ratiodata.isChromosome10() ) {

                    	                List<SNPChromosome> snpchromosome10List = new ArrayList<SNPChromosome>();

                    	     			snpchromosome10List = serviceSNPChromosome.findBySnpId(ratiodata.getSnpId());
                    	     			
                    	     			if ( snpchromosome10List.isEmpty() ) {
                    	     				
                    	     				error++;

                    	     				String errorRecord = "SNP NOT FOUND!\t" + 
                    	     				        ratiodata.getSnpId() + "\t" +
                    	     						ratiodata.getStrain() + "\t" +
                    	     						ratiodata.getStrainAlleleReferenceCount() + "\t" +
                    	     						ratiodata.getStrainAlleleAlternativeCount() + "\t" +
                    	     						ratiodata.getStrainAlleleRatio();
                    	     						
                    	     				errorRecords.add(errorRecord);

                    	     				//System.out.println("Error No. " + error + " : SNP Id. " + ratiodata.getSnpId() + " NOT FOUND : " + ratiodata.toString());
                    	     			}
                    	     			else {

                        	     			if ( snpchromosome10List.size() > 1 ) {
                        	     				
                        	     				error++;

                        	     				String errorRecord = "MULTIPLE SNPs!\t" + 
                        	     				        ratiodata.getSnpId() + "\t" +
                        	     						ratiodata.getStrain() + "\t" +
                        	     						ratiodata.getStrainAlleleReferenceCount() + "\t" +
                        	     						ratiodata.getStrainAlleleAlternativeCount() + "\t" +
                        	     						ratiodata.getStrainAlleleRatio();

                        	     				errorRecords.add(errorRecord);

                        	     				//System.out.println("Error No. " + error + " : SNP Id. " + siftdata.getSnpId() + " GREATER THAN 1 ROW FOR : " + siftdata.toString());
                        	     			}
                        	     			else {

                                    	        Iterator<SNPChromosome> iteratorSNPChromosome = snpchromosome10List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome.hasNext()) {

                                    	     		SNPChromosome snpchromosome = iteratorSNPChromosome.next();

                                    	     		if ( ratiodata.isStrain7() ) {
                                    	     			snpchromosome.setStrain7AlleleRatio(ratiodata.getStrainAlleleRatio());
                                    	     			snpchromosome.setStrain7AlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                    	     			snpchromosome.setStrain7AlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainP() ) {
                                    	     			snpchromosome.setStrainPAlleleRatio(ratiodata.getStrainAlleleRatio());
                                    	     			snpchromosome.setStrainPAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                    	     			snpchromosome.setStrainPAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainW() ) {
                                    	     			snpchromosome.setStrainWAlleleRatio(ratiodata.getStrainAlleleRatio());
                                    	     			snpchromosome.setStrainWAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                    	     			snpchromosome.setStrainWAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainN() ) {
                                    	     			snpchromosome.setStrainNAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrainNAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrainNAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrain15I() ) {
                                        	     		snpchromosome.setStrain15IAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrain15IAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrain15IAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainZero() ) {
                                        	     		snpchromosome.setStrainZeroAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrainZeroAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrainZeroAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrain6() ) {
                                        	     		snpchromosome.setStrain6AlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrain6AlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrain6AlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainC() ) {
                                        	     		snpchromosome.setStrainCAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrainCAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrainCAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}

                                    	     		serviceSNPChromosome.update(snpchromosome);
                                    	     		
                                    	     		intSNPChromosomeCount10++;
                                    	     	}
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( ratiodata.isChromosome11() ) {
                    	     			
                    	                List<SNPChromosome> snpchromosome11List = new ArrayList<SNPChromosome>();

                    	     			snpchromosome11List = serviceSNPChromosome.findBySnpId(ratiodata.getSnpId());
                    	     			
                    	     			if ( snpchromosome11List.isEmpty() ) {
                    	     				
                    	     				error++;

                    	     				String errorRecord = "SNP NOT FOUND!\t" + 
                    	     				        ratiodata.getSnpId() + "\t" +
                    	     						ratiodata.getStrain() + "\t" +
                    	     						ratiodata.getStrainAlleleReferenceCount() + "\t" +
                    	     						ratiodata.getStrainAlleleAlternativeCount() + "\t" +
                    	     						ratiodata.getStrainAlleleRatio();
                    	     						
                    	     				errorRecords.add(errorRecord);

                    	     				//System.out.println("Error No. " + error + " : SNP Id. " + ratiodata.getSnpId() + " NOT FOUND : " + ratiodata.toString());
                    	     			}
                    	     			else {

                        	     			if ( snpchromosome11List.size() > 1 ) {
                        	     				
                        	     				error++;

                        	     				String errorRecord = "MULTIPLE SNPs!\t" + 
                        	     				        ratiodata.getSnpId() + "\t" +
                        	     						ratiodata.getStrain() + "\t" +
                        	     						ratiodata.getStrainAlleleReferenceCount() + "\t" +
                        	     						ratiodata.getStrainAlleleAlternativeCount() + "\t" +
                        	     						ratiodata.getStrainAlleleRatio();

                        	     				errorRecords.add(errorRecord);

                        	     				//System.out.println("Error No. " + error + " : SNP Id. " + siftdata.getSnpId() + " GREATER THAN 1 ROW FOR : " + siftdata.toString());
                        	     			}
                        	     			else {

                                    	        Iterator<SNPChromosome> iteratorSNPChromosome = snpchromosome11List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome.hasNext()) {

                                    	     		SNPChromosome snpchromosome = iteratorSNPChromosome.next();

                                    	     		if ( ratiodata.isStrain7() ) {
                                    	     			snpchromosome.setStrain7AlleleRatio(ratiodata.getStrainAlleleRatio());
                                    	     			snpchromosome.setStrain7AlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                    	     			snpchromosome.setStrain7AlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainP() ) {
                                    	     			snpchromosome.setStrainPAlleleRatio(ratiodata.getStrainAlleleRatio());
                                    	     			snpchromosome.setStrainPAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                    	     			snpchromosome.setStrainPAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainW() ) {
                                    	     			snpchromosome.setStrainWAlleleRatio(ratiodata.getStrainAlleleRatio());
                                    	     			snpchromosome.setStrainWAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                    	     			snpchromosome.setStrainWAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainN() ) {
                                    	     			snpchromosome.setStrainNAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrainNAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrainNAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrain15I() ) {
                                        	     		snpchromosome.setStrain15IAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrain15IAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrain15IAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainZero() ) {
                                        	     		snpchromosome.setStrainZeroAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrainZeroAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrainZeroAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrain6() ) {
                                        	     		snpchromosome.setStrain6AlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrain6AlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrain6AlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainC() ) {
                                        	     		snpchromosome.setStrainCAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrainCAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrainCAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}

                                    	     		serviceSNPChromosome.update(snpchromosome);
                                    	     		
                                    	     		intSNPChromosomeCount11++;
                                    	     	}
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( ratiodata.isChromosome12() ) {
                    	     			
                    	                List<SNPChromosome> snpchromosome12List = new ArrayList<SNPChromosome>();

                    	                snpchromosome12List = serviceSNPChromosome.findBySnpId(ratiodata.getSnpId());
                    	                
                    	     			if ( snpchromosome12List.isEmpty() ) {
                    	     				
                    	     				error++;

                    	     				String errorRecord = "SNP NOT FOUND!\t" + 
                    	     				        ratiodata.getSnpId() + "\t" +
                    	     						ratiodata.getStrain() + "\t" +
                    	     						ratiodata.getStrainAlleleReferenceCount() + "\t" +
                    	     						ratiodata.getStrainAlleleAlternativeCount() + "\t" +
                    	     						ratiodata.getStrainAlleleRatio();
                    	     						
                    	     				errorRecords.add(errorRecord);

                    	     				//System.out.println("Error No. " + error + " : SNP Id. " + ratiodata.getSnpId() + " NOT FOUND : " + ratiodata.toString());
                    	     			}
                    	     			else {

                        	     			if ( snpchromosome12List.size() > 1 ) {
                        	     				
                        	     				error++;

                        	     				String errorRecord = "MULTIPLE SNPs!\t" + 
                        	     				        ratiodata.getSnpId() + "\t" +
                        	     						ratiodata.getStrain() + "\t" +
                        	     						ratiodata.getStrainAlleleReferenceCount() + "\t" +
                        	     						ratiodata.getStrainAlleleAlternativeCount() + "\t" +
                        	     						ratiodata.getStrainAlleleRatio();

                        	     				errorRecords.add(errorRecord);

                        	     				//System.out.println("Error No. " + error + " : SNP Id. " + siftdata.getSnpId() + " GREATER THAN 1 ROW FOR : " + siftdata.toString());
                        	     			}
                        	     			else {

                                    	        Iterator<SNPChromosome> iteratorSNPChromosome = snpchromosome12List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome.hasNext()) {

                                    	     		SNPChromosome snpchromosome = iteratorSNPChromosome.next();

                                    	     		if ( ratiodata.isStrain7() ) {
                                    	     			snpchromosome.setStrain7AlleleRatio(ratiodata.getStrainAlleleRatio());
                                    	     			snpchromosome.setStrain7AlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                    	     			snpchromosome.setStrain7AlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainP() ) {
                                    	     			snpchromosome.setStrainPAlleleRatio(ratiodata.getStrainAlleleRatio());
                                    	     			snpchromosome.setStrainPAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                    	     			snpchromosome.setStrainPAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainW() ) {
                                    	     			snpchromosome.setStrainWAlleleRatio(ratiodata.getStrainAlleleRatio());
                                    	     			snpchromosome.setStrainWAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                    	     			snpchromosome.setStrainWAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainN() ) {
                                    	     			snpchromosome.setStrainNAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrainNAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrainNAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrain15I() ) {
                                        	     		snpchromosome.setStrain15IAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrain15IAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrain15IAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainZero() ) {
                                        	     		snpchromosome.setStrainZeroAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrainZeroAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrainZeroAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrain6() ) {
                                        	     		snpchromosome.setStrain6AlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrain6AlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrain6AlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainC() ) {
                                        	     		snpchromosome.setStrainCAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrainCAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrainCAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}

                                    	     		serviceSNPChromosome.update(snpchromosome);
                                    	     		
                                    	     		intSNPChromosomeCount12++;
                                    	     	}
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( ratiodata.isChromosome13() ) {
                    	     			
                    	                List<SNPChromosome> snpchromosome13List = new ArrayList<SNPChromosome>();

                    	                snpchromosome13List = serviceSNPChromosome.findBySnpId(ratiodata.getSnpId());

                    	     			if ( snpchromosome13List.isEmpty() ) {
                    	     				
                    	     				error++;

                    	     				String errorRecord = "SNP NOT FOUND!\t" + 
                    	     				        ratiodata.getSnpId() + "\t" +
                    	     						ratiodata.getStrain() + "\t" +
                    	     						ratiodata.getStrainAlleleReferenceCount() + "\t" +
                    	     						ratiodata.getStrainAlleleAlternativeCount() + "\t" +
                    	     						ratiodata.getStrainAlleleRatio();
                    	     						
                    	     				errorRecords.add(errorRecord);

                    	     				//System.out.println("Error No. " + error + " : SNP Id. " + ratiodata.getSnpId() + " NOT FOUND : " + ratiodata.toString());
                    	     			}
                    	     			else {

                        	     			if ( snpchromosome13List.size() > 1 ) {
                        	     				
                        	     				error++;

                        	     				String errorRecord = "MULTIPLE SNPs!\t" + 
                        	     				        ratiodata.getSnpId() + "\t" +
                        	     						ratiodata.getStrain() + "\t" +
                        	     						ratiodata.getStrainAlleleReferenceCount() + "\t" +
                        	     						ratiodata.getStrainAlleleAlternativeCount() + "\t" +
                        	     						ratiodata.getStrainAlleleRatio();

                        	     				errorRecords.add(errorRecord);

                        	     				//System.out.println("Error No. " + error + " : SNP Id. " + siftdata.getSnpId() + " GREATER THAN 1 ROW FOR : " + siftdata.toString());
                        	     			}
                        	     			else {

                            	     			Iterator<SNPChromosome> iteratorSNPChromosome = snpchromosome13List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome.hasNext()) {

                                    	     		SNPChromosome snpchromosome = iteratorSNPChromosome.next();

                                    	     		if ( ratiodata.isStrain7() ) {
                                    	     			snpchromosome.setStrain7AlleleRatio(ratiodata.getStrainAlleleRatio());
                                    	     			snpchromosome.setStrain7AlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                    	     			snpchromosome.setStrain7AlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainP() ) {
                                    	     			snpchromosome.setStrainPAlleleRatio(ratiodata.getStrainAlleleRatio());
                                    	     			snpchromosome.setStrainPAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                    	     			snpchromosome.setStrainPAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainW() ) {
                                    	     			snpchromosome.setStrainWAlleleRatio(ratiodata.getStrainAlleleRatio());
                                    	     			snpchromosome.setStrainWAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                    	     			snpchromosome.setStrainWAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainN() ) {
                                    	     			snpchromosome.setStrainNAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrainNAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrainNAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrain15I() ) {
                                        	     		snpchromosome.setStrain15IAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrain15IAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrain15IAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainZero() ) {
                                        	     		snpchromosome.setStrainZeroAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrainZeroAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrainZeroAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrain6() ) {
                                        	     		snpchromosome.setStrain6AlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrain6AlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrain6AlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainC() ) {
                                        	     		snpchromosome.setStrainCAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrainCAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrainCAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}

                                    	     		serviceSNPChromosome.update(snpchromosome);
                                    	     		
                                    	     		intSNPChromosomeCount13++;
                                    	     	}
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( ratiodata.isChromosome14() ) {
                    	     			
                    	                List<SNPChromosome> snpchromosome14List = new ArrayList<SNPChromosome>();

                    	                snpchromosome14List = serviceSNPChromosome.findBySnpId(ratiodata.getSnpId());
                    	                
                    	     			if ( snpchromosome14List.isEmpty() ) {
                    	     				
                    	     				error++;

                    	     				String errorRecord = "SNP NOT FOUND!\t" + 
                    	     				        ratiodata.getSnpId() + "\t" +
                    	     						ratiodata.getStrain() + "\t" +
                    	     						ratiodata.getStrainAlleleReferenceCount() + "\t" +
                    	     						ratiodata.getStrainAlleleAlternativeCount() + "\t" +
                    	     						ratiodata.getStrainAlleleRatio();
                    	     						
                    	     				errorRecords.add(errorRecord);

                    	     				//System.out.println("Error No. " + error + " : SNP Id. " + ratiodata.getSnpId() + " NOT FOUND : " + ratiodata.toString());
                    	     			}
                    	     			else {

                        	     			if ( snpchromosome14List.size() > 1 ) {
                        	     				
                        	     				error++;

                        	     				String errorRecord = "MULTIPLE SNPs!\t" + 
                        	     				        ratiodata.getSnpId() + "\t" +
                        	     						ratiodata.getStrain() + "\t" +
                        	     						ratiodata.getStrainAlleleReferenceCount() + "\t" +
                        	     						ratiodata.getStrainAlleleAlternativeCount() + "\t" +
                        	     						ratiodata.getStrainAlleleRatio();

                        	     				errorRecords.add(errorRecord);

                        	     				//System.out.println("Error No. " + error + " : SNP Id. " + siftdata.getSnpId() + " GREATER THAN 1 ROW FOR : " + siftdata.toString());
                        	     			}
                        	     			else {

                                    	        Iterator<SNPChromosome> iteratorSNPChromosome = snpchromosome14List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome.hasNext()) {

                                    	     		SNPChromosome snpchromosome = iteratorSNPChromosome.next();

                                    	     		if ( ratiodata.isStrain7() ) {
                                    	     			snpchromosome.setStrain7AlleleRatio(ratiodata.getStrainAlleleRatio());
                                    	     			snpchromosome.setStrain7AlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                    	     			snpchromosome.setStrain7AlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainP() ) {
                                    	     			snpchromosome.setStrainPAlleleRatio(ratiodata.getStrainAlleleRatio());
                                    	     			snpchromosome.setStrainPAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                    	     			snpchromosome.setStrainPAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainW() ) {
                                    	     			snpchromosome.setStrainWAlleleRatio(ratiodata.getStrainAlleleRatio());
                                    	     			snpchromosome.setStrainWAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                    	     			snpchromosome.setStrainWAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainN() ) {
                                    	     			snpchromosome.setStrainNAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrainNAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrainNAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrain15I() ) {
                                        	     		snpchromosome.setStrain15IAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrain15IAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrain15IAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainZero() ) {
                                        	     		snpchromosome.setStrainZeroAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrainZeroAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrainZeroAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrain6() ) {
                                        	     		snpchromosome.setStrain6AlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrain6AlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrain6AlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainC() ) {
                                        	     		snpchromosome.setStrainCAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrainCAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrainCAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}

                                    	     		serviceSNPChromosome.update(snpchromosome);
                                    	     		
                                    	     		intSNPChromosomeCount14++;
                                    	     	}
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( ratiodata.isChromosome15() ) {
                    	     			
                    	                List<SNPChromosome> snpchromosome15List = new ArrayList<SNPChromosome>();

                    	                snpchromosome15List = serviceSNPChromosome.findBySnpId(ratiodata.getSnpId());
                    	                
                    	     			if ( snpchromosome15List.isEmpty() ) {
                    	     				
                    	     				error++;

                    	     				String errorRecord = "SNP NOT FOUND!\t" + 
                    	     				        ratiodata.getSnpId() + "\t" +
                    	     						ratiodata.getStrain() + "\t" +
                    	     						ratiodata.getStrainAlleleReferenceCount() + "\t" +
                    	     						ratiodata.getStrainAlleleAlternativeCount() + "\t" +
                    	     						ratiodata.getStrainAlleleRatio();
                    	     						
                    	     				errorRecords.add(errorRecord);

                    	     				//System.out.println("Error No. " + error + " : SNP Id. " + ratiodata.getSnpId() + " NOT FOUND : " + ratiodata.toString());
                    	     			}
                    	     			else {

                        	     			if ( snpchromosome15List.size() > 1 ) {
                        	     				
                        	     				error++;

                        	     				String errorRecord = "MULTIPLE SNPs!\t" + 
                        	     				        ratiodata.getSnpId() + "\t" +
                        	     						ratiodata.getStrain() + "\t" +
                        	     						ratiodata.getStrainAlleleReferenceCount() + "\t" +
                        	     						ratiodata.getStrainAlleleAlternativeCount() + "\t" +
                        	     						ratiodata.getStrainAlleleRatio();

                        	     				errorRecords.add(errorRecord);

                        	     				//System.out.println("Error No. " + error + " : SNP Id. " + siftdata.getSnpId() + " GREATER THAN 1 ROW FOR : " + siftdata.toString());
                        	     			}
                        	     			else {

                                    	        Iterator<SNPChromosome> iteratorSNPChromosome = snpchromosome15List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome.hasNext()) {

                                    	     		SNPChromosome snpchromosome = iteratorSNPChromosome.next();

                                    	     		if ( ratiodata.isStrain7() ) {
                                    	     			snpchromosome.setStrain7AlleleRatio(ratiodata.getStrainAlleleRatio());
                                    	     			snpchromosome.setStrain7AlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                    	     			snpchromosome.setStrain7AlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainP() ) {
                                    	     			snpchromosome.setStrainPAlleleRatio(ratiodata.getStrainAlleleRatio());
                                    	     			snpchromosome.setStrainPAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                    	     			snpchromosome.setStrainPAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainW() ) {
                                    	     			snpchromosome.setStrainWAlleleRatio(ratiodata.getStrainAlleleRatio());
                                    	     			snpchromosome.setStrainWAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                    	     			snpchromosome.setStrainWAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainN() ) {
                                    	     			snpchromosome.setStrainNAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrainNAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrainNAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrain15I() ) {
                                        	     		snpchromosome.setStrain15IAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrain15IAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrain15IAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainZero() ) {
                                        	     		snpchromosome.setStrainZeroAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrainZeroAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrainZeroAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrain6() ) {
                                        	     		snpchromosome.setStrain6AlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrain6AlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrain6AlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainC() ) {
                                        	     		snpchromosome.setStrainCAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrainCAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrainCAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}

                                    	     		serviceSNPChromosome.update(snpchromosome);
                                    	     		
                                    	     		intSNPChromosomeCount15++;
                                    	     	}
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( ratiodata.isChromosome16() ) {

                    	                List<SNPChromosome> snpchromosome16List = new ArrayList<SNPChromosome>();

                    	     			snpchromosome16List = serviceSNPChromosome.findBySnpId(ratiodata.getSnpId());
                    	     			
                    	     			if ( snpchromosome16List.isEmpty() ) {
                    	     				
                    	     				error++;

                    	     				String errorRecord = "SNP NOT FOUND!\t" + 
                    	     				        ratiodata.getSnpId() + "\t" +
                    	     						ratiodata.getStrain() + "\t" +
                    	     						ratiodata.getStrainAlleleReferenceCount() + "\t" +
                    	     						ratiodata.getStrainAlleleAlternativeCount() + "\t" +
                    	     						ratiodata.getStrainAlleleRatio();
                    	     						
                    	     				errorRecords.add(errorRecord);

                    	     				//System.out.println("Error No. " + error + " : SNP Id. " + ratiodata.getSnpId() + " NOT FOUND : " + ratiodata.toString());
                    	     			}
                    	     			else {

                        	     			if ( snpchromosome16List.size() > 1 ) {
                        	     				
                        	     				error++;

                        	     				String errorRecord = "MULTIPLE SNPs!\t" + 
                        	     				        ratiodata.getSnpId() + "\t" +
                        	     						ratiodata.getStrain() + "\t" +
                        	     						ratiodata.getStrainAlleleReferenceCount() + "\t" +
                        	     						ratiodata.getStrainAlleleAlternativeCount() + "\t" +
                        	     						ratiodata.getStrainAlleleRatio();

                        	     				errorRecords.add(errorRecord);

                        	     				//System.out.println("Error No. " + error + " : SNP Id. " + siftdata.getSnpId() + " GREATER THAN 1 ROW FOR : " + siftdata.toString());
                        	     			}
                        	     			else {

                                    	        Iterator<SNPChromosome> iteratorSNPChromosome = snpchromosome16List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome.hasNext()) {

                                    	     		SNPChromosome snpchromosome = iteratorSNPChromosome.next();

                                    	     		if ( ratiodata.isStrain7() ) {
                                    	     			snpchromosome.setStrain7AlleleRatio(ratiodata.getStrainAlleleRatio());
                                    	     			snpchromosome.setStrain7AlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                    	     			snpchromosome.setStrain7AlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainP() ) {
                                    	     			snpchromosome.setStrainPAlleleRatio(ratiodata.getStrainAlleleRatio());
                                    	     			snpchromosome.setStrainPAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                    	     			snpchromosome.setStrainPAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainW() ) {
                                    	     			snpchromosome.setStrainWAlleleRatio(ratiodata.getStrainAlleleRatio());
                                    	     			snpchromosome.setStrainWAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                    	     			snpchromosome.setStrainWAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainN() ) {
                                    	     			snpchromosome.setStrainNAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrainNAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrainNAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrain15I() ) {
                                        	     		snpchromosome.setStrain15IAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrain15IAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrain15IAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainZero() ) {
                                        	     		snpchromosome.setStrainZeroAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrainZeroAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrainZeroAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrain6() ) {
                                        	     		snpchromosome.setStrain6AlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrain6AlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrain6AlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainC() ) {
                                        	     		snpchromosome.setStrainCAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrainCAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrainCAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}

                                    	     		serviceSNPChromosome.update(snpchromosome);
                                    	     		
                                    	     		intSNPChromosomeCount16++;
                                    	     	}
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( ratiodata.isChromosome17() ) {
                    	     			
                    	                List<SNPChromosome> snpchromosome17List = new ArrayList<SNPChromosome>();

                    	     			snpchromosome17List = serviceSNPChromosome.findBySnpId(ratiodata.getSnpId());
                    	     			
                    	     			if ( snpchromosome17List.isEmpty() ) {
                    	     				
                    	     				error++;

                    	     				String errorRecord = "SNP NOT FOUND!\t" + 
                    	     				        ratiodata.getSnpId() + "\t" +
                    	     						ratiodata.getStrain() + "\t" +
                    	     						ratiodata.getStrainAlleleReferenceCount() + "\t" +
                    	     						ratiodata.getStrainAlleleAlternativeCount() + "\t" +
                    	     						ratiodata.getStrainAlleleRatio();
                    	     						
                    	     				errorRecords.add(errorRecord);

                    	     				//System.out.println("Error No. " + error + " : SNP Id. " + ratiodata.getSnpId() + " NOT FOUND : " + ratiodata.toString());
                    	     			}
                    	     			else {

                        	     			if ( snpchromosome17List.size() > 1 ) {
                        	     				
                        	     				error++;

                        	     				String errorRecord = "MULTIPLE SNPs!\t" + 
                        	     				        ratiodata.getSnpId() + "\t" +
                        	     						ratiodata.getStrain() + "\t" +
                        	     						ratiodata.getStrainAlleleReferenceCount() + "\t" +
                        	     						ratiodata.getStrainAlleleAlternativeCount() + "\t" +
                        	     						ratiodata.getStrainAlleleRatio();

                        	     				errorRecords.add(errorRecord);

                        	     				//System.out.println("Error No. " + error + " : SNP Id. " + siftdata.getSnpId() + " GREATER THAN 1 ROW FOR : " + siftdata.toString());
                        	     			}
                        	     			else {

                                    	        Iterator<SNPChromosome> iteratorSNPChromosome = snpchromosome17List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome.hasNext()) {

                                    	     		SNPChromosome snpchromosome = iteratorSNPChromosome.next();

                                    	     		if ( ratiodata.isStrain7() ) {
                                    	     			snpchromosome.setStrain7AlleleRatio(ratiodata.getStrainAlleleRatio());
                                    	     			snpchromosome.setStrain7AlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                    	     			snpchromosome.setStrain7AlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainP() ) {
                                    	     			snpchromosome.setStrainPAlleleRatio(ratiodata.getStrainAlleleRatio());
                                    	     			snpchromosome.setStrainPAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                    	     			snpchromosome.setStrainPAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainW() ) {
                                    	     			snpchromosome.setStrainWAlleleRatio(ratiodata.getStrainAlleleRatio());
                                    	     			snpchromosome.setStrainWAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                    	     			snpchromosome.setStrainWAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainN() ) {
                                    	     			snpchromosome.setStrainNAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrainNAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrainNAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrain15I() ) {
                                        	     		snpchromosome.setStrain15IAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrain15IAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrain15IAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainZero() ) {
                                        	     		snpchromosome.setStrainZeroAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrainZeroAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrainZeroAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrain6() ) {
                                        	     		snpchromosome.setStrain6AlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrain6AlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrain6AlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainC() ) {
                                        	     		snpchromosome.setStrainCAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrainCAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrainCAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}

                                    	     		serviceSNPChromosome.update(snpchromosome);
                                    	     		
                                    	     		intSNPChromosomeCount17++;
                                    	     	}
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( ratiodata.isChromosome18() ) {

                    	                List<SNPChromosome> snpchromosome18List = new ArrayList<SNPChromosome>();

                    	     			snpchromosome18List = serviceSNPChromosome.findBySnpId(ratiodata.getSnpId());
                    	     			
                    	     			if ( snpchromosome18List.isEmpty() ) {
                    	     				
                    	     				error++;

                    	     				String errorRecord = "SNP NOT FOUND!\t" + 
                    	     				        ratiodata.getSnpId() + "\t" +
                    	     						ratiodata.getStrain() + "\t" +
                    	     						ratiodata.getStrainAlleleReferenceCount() + "\t" +
                    	     						ratiodata.getStrainAlleleAlternativeCount() + "\t" +
                    	     						ratiodata.getStrainAlleleRatio();
                    	     						
                    	     				errorRecords.add(errorRecord);

                    	     				//System.out.println("Error No. " + error + " : SNP Id. " + ratiodata.getSnpId() + " NOT FOUND : " + ratiodata.toString());
                    	     			}
                    	     			else {

                        	     			if ( snpchromosome18List.size() > 1 ) {
                        	     				
                        	     				error++;

                        	     				String errorRecord = "MULTIPLE SNPs!\t" + 
                        	     				        ratiodata.getSnpId() + "\t" +
                        	     						ratiodata.getStrain() + "\t" +
                        	     						ratiodata.getStrainAlleleReferenceCount() + "\t" +
                        	     						ratiodata.getStrainAlleleAlternativeCount() + "\t" +
                        	     						ratiodata.getStrainAlleleRatio();

                        	     				errorRecords.add(errorRecord);

                        	     				//System.out.println("Error No. " + error + " : SNP Id. " + siftdata.getSnpId() + " GREATER THAN 1 ROW FOR : " + siftdata.toString());
                        	     			}
                        	     			else {

                                    	        Iterator<SNPChromosome> iteratorSNPChromosome = snpchromosome18List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome.hasNext()) {

                                    	     		SNPChromosome snpchromosome = iteratorSNPChromosome.next();

                                    	     		if ( ratiodata.isStrain7() ) {
                                    	     			snpchromosome.setStrain7AlleleRatio(ratiodata.getStrainAlleleRatio());
                                    	     			snpchromosome.setStrain7AlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                    	     			snpchromosome.setStrain7AlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainP() ) {
                                    	     			snpchromosome.setStrainPAlleleRatio(ratiodata.getStrainAlleleRatio());
                                    	     			snpchromosome.setStrainPAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                    	     			snpchromosome.setStrainPAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainW() ) {
                                    	     			snpchromosome.setStrainWAlleleRatio(ratiodata.getStrainAlleleRatio());
                                    	     			snpchromosome.setStrainWAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                    	     			snpchromosome.setStrainWAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainN() ) {
                                    	     			snpchromosome.setStrainNAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrainNAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrainNAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrain15I() ) {
                                        	     		snpchromosome.setStrain15IAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrain15IAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrain15IAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainZero() ) {
                                        	     		snpchromosome.setStrainZeroAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrainZeroAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrainZeroAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrain6() ) {
                                        	     		snpchromosome.setStrain6AlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrain6AlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrain6AlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainC() ) {
                                        	     		snpchromosome.setStrainCAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrainCAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrainCAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}

                                    	     		serviceSNPChromosome.update(snpchromosome);
                                    	     		
                                    	     		intSNPChromosomeCount18++;
                                    	     	}
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( ratiodata.isChromosome19() ) {

                    	                List<SNPChromosome> snpchromosome19List = new ArrayList<SNPChromosome>();

                    	     			snpchromosome19List = serviceSNPChromosome.findBySnpId(ratiodata.getSnpId());
                    	     			
                    	     			if ( snpchromosome19List.isEmpty() ) {
                    	     				
                    	     				error++;

                    	     				String errorRecord = "SNP NOT FOUND!\t" + 
                    	     				        ratiodata.getSnpId() + "\t" +
                    	     						ratiodata.getStrain() + "\t" +
                    	     						ratiodata.getStrainAlleleReferenceCount() + "\t" +
                    	     						ratiodata.getStrainAlleleAlternativeCount() + "\t" +
                    	     						ratiodata.getStrainAlleleRatio();
                    	     						
                    	     				errorRecords.add(errorRecord);

                    	     				//System.out.println("Error No. " + error + " : SNP Id. " + ratiodata.getSnpId() + " NOT FOUND : " + ratiodata.toString());
                    	     			}
                    	     			else {

                        	     			if ( snpchromosome19List.size() > 1 ) {
                        	     				
                        	     				error++;

                        	     				String errorRecord = "MULTIPLE SNPs!\t" + 
                        	     				        ratiodata.getSnpId() + "\t" +
                        	     						ratiodata.getStrain() + "\t" +
                        	     						ratiodata.getStrainAlleleReferenceCount() + "\t" +
                        	     						ratiodata.getStrainAlleleAlternativeCount() + "\t" +
                        	     						ratiodata.getStrainAlleleRatio();

                        	     				errorRecords.add(errorRecord);

                        	     				//System.out.println("Error No. " + error + " : SNP Id. " + siftdata.getSnpId() + " GREATER THAN 1 ROW FOR : " + siftdata.toString());
                        	     			}
                        	     			else {

                                    	        Iterator<SNPChromosome> iteratorSNPChromosome = snpchromosome19List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome.hasNext()) {

                                    	     		SNPChromosome snpchromosome = iteratorSNPChromosome.next();

                                    	     		if ( ratiodata.isStrain7() ) {
                                    	     			snpchromosome.setStrain7AlleleRatio(ratiodata.getStrainAlleleRatio());
                                    	     			snpchromosome.setStrain7AlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                    	     			snpchromosome.setStrain7AlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainP() ) {
                                    	     			snpchromosome.setStrainPAlleleRatio(ratiodata.getStrainAlleleRatio());
                                    	     			snpchromosome.setStrainPAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                    	     			snpchromosome.setStrainPAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainW() ) {
                                    	     			snpchromosome.setStrainWAlleleRatio(ratiodata.getStrainAlleleRatio());
                                    	     			snpchromosome.setStrainWAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                    	     			snpchromosome.setStrainWAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainN() ) {
                                    	     			snpchromosome.setStrainNAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrainNAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrainNAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrain15I() ) {
                                        	     		snpchromosome.setStrain15IAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrain15IAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrain15IAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainZero() ) {
                                        	     		snpchromosome.setStrainZeroAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrainZeroAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrainZeroAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrain6() ) {
                                        	     		snpchromosome.setStrain6AlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrain6AlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrain6AlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainC() ) {
                                        	     		snpchromosome.setStrainCAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrainCAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrainCAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}

                                    	     		serviceSNPChromosome.update(snpchromosome);
                                    	     		
                                    	     		intSNPChromosomeCount19++;
                                    	     	}
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( ratiodata.isChromosome20() ) {
                    	     			
                    	                List<SNPChromosome> snpchromosome20List = new ArrayList<SNPChromosome>();

                    	     			snpchromosome20List = serviceSNPChromosome.findBySnpId(ratiodata.getSnpId());
                    	     			
                    	     			if ( snpchromosome20List.isEmpty() ) {
                    	     				
                    	     				error++;

                    	     				String errorRecord = "SNP NOT FOUND!\t" + 
                    	     				        ratiodata.getSnpId() + "\t" +
                    	     						ratiodata.getStrain() + "\t" +
                    	     						ratiodata.getStrainAlleleReferenceCount() + "\t" +
                    	     						ratiodata.getStrainAlleleAlternativeCount() + "\t" +
                    	     						ratiodata.getStrainAlleleRatio();
                    	     						
                    	     				errorRecords.add(errorRecord);

                    	     				//System.out.println("Error No. " + error + " : SNP Id. " + ratiodata.getSnpId() + " NOT FOUND : " + ratiodata.toString());
                    	     			}
                    	     			else {

                        	     			if ( snpchromosome20List.size() > 1 ) {
                        	     				
                        	     				error++;

                        	     				String errorRecord = "MULTIPLE SNPs!\t" + 
                        	     				        ratiodata.getSnpId() + "\t" +
                        	     						ratiodata.getStrain() + "\t" +
                        	     						ratiodata.getStrainAlleleReferenceCount() + "\t" +
                        	     						ratiodata.getStrainAlleleAlternativeCount() + "\t" +
                        	     						ratiodata.getStrainAlleleRatio();

                        	     				errorRecords.add(errorRecord);

                        	     				//System.out.println("Error No. " + error + " : SNP Id. " + siftdata.getSnpId() + " GREATER THAN 1 ROW FOR : " + siftdata.toString());
                        	     			}
                        	     			else {

                                    	        Iterator<SNPChromosome> iteratorSNPChromosome = snpchromosome20List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome.hasNext()) {

                                    	     		SNPChromosome snpchromosome = iteratorSNPChromosome.next();

                                    	     		if ( ratiodata.isStrain7() ) {
                                    	     			snpchromosome.setStrain7AlleleRatio(ratiodata.getStrainAlleleRatio());
                                    	     			snpchromosome.setStrain7AlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                    	     			snpchromosome.setStrain7AlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainP() ) {
                                    	     			snpchromosome.setStrainPAlleleRatio(ratiodata.getStrainAlleleRatio());
                                    	     			snpchromosome.setStrainPAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                    	     			snpchromosome.setStrainPAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainW() ) {
                                    	     			snpchromosome.setStrainWAlleleRatio(ratiodata.getStrainAlleleRatio());
                                    	     			snpchromosome.setStrainWAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                    	     			snpchromosome.setStrainWAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainN() ) {
                                    	     			snpchromosome.setStrainNAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrainNAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrainNAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrain15I() ) {
                                        	     		snpchromosome.setStrain15IAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrain15IAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrain15IAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainZero() ) {
                                        	     		snpchromosome.setStrainZeroAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrainZeroAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrainZeroAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrain6() ) {
                                        	     		snpchromosome.setStrain6AlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrain6AlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrain6AlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainC() ) {
                                        	     		snpchromosome.setStrainCAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrainCAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrainCAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}

                                    	     		serviceSNPChromosome.update(snpchromosome);
                                    	     		
                                    	     		intSNPChromosomeCount20++;
                                    	     	}
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( ratiodata.isChromosome21() ) {

                    	                List<SNPChromosome> snpchromosome21List = new ArrayList<SNPChromosome>();

                    	     			snpchromosome21List = serviceSNPChromosome.findBySnpId(ratiodata.getSnpId());
                    	     			
                    	     			if ( snpchromosome21List.isEmpty() ) {
                    	     				
                    	     				error++;

                    	     				String errorRecord = "SNP NOT FOUND!\t" + 
                    	     				        ratiodata.getSnpId() + "\t" +
                    	     						ratiodata.getStrain() + "\t" +
                    	     						ratiodata.getStrainAlleleReferenceCount() + "\t" +
                    	     						ratiodata.getStrainAlleleAlternativeCount() + "\t" +
                    	     						ratiodata.getStrainAlleleRatio();
                    	     						
                    	     				errorRecords.add(errorRecord);

                    	     				//System.out.println("Error No. " + error + " : SNP Id. " + ratiodata.getSnpId() + " NOT FOUND : " + ratiodata.toString());
                    	     			}
                    	     			else {

                        	     			if ( snpchromosome21List.size() > 1 ) {
                        	     				
                        	     				error++;

                        	     				String errorRecord = "MULTIPLE SNPs!\t" + 
                        	     				        ratiodata.getSnpId() + "\t" +
                        	     						ratiodata.getStrain() + "\t" +
                        	     						ratiodata.getStrainAlleleReferenceCount() + "\t" +
                        	     						ratiodata.getStrainAlleleAlternativeCount() + "\t" +
                        	     						ratiodata.getStrainAlleleRatio();

                        	     				errorRecords.add(errorRecord);

                        	     				//System.out.println("Error No. " + error + " : SNP Id. " + siftdata.getSnpId() + " GREATER THAN 1 ROW FOR : " + siftdata.toString());
                        	     			}
                        	     			else {

                                    	        Iterator<SNPChromosome> iteratorSNPChromosome = snpchromosome21List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome.hasNext()) {

                                    	     		SNPChromosome snpchromosome = iteratorSNPChromosome.next();

                                    	     		if ( ratiodata.isStrain7() ) {
                                    	     			snpchromosome.setStrain7AlleleRatio(ratiodata.getStrainAlleleRatio());
                                    	     			snpchromosome.setStrain7AlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                    	     			snpchromosome.setStrain7AlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainP() ) {
                                    	     			snpchromosome.setStrainPAlleleRatio(ratiodata.getStrainAlleleRatio());
                                    	     			snpchromosome.setStrainPAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                    	     			snpchromosome.setStrainPAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainW() ) {
                                    	     			snpchromosome.setStrainWAlleleRatio(ratiodata.getStrainAlleleRatio());
                                    	     			snpchromosome.setStrainWAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                    	     			snpchromosome.setStrainWAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainN() ) {
                                    	     			snpchromosome.setStrainNAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrainNAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrainNAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrain15I() ) {
                                        	     		snpchromosome.setStrain15IAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrain15IAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrain15IAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainZero() ) {
                                        	     		snpchromosome.setStrainZeroAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrainZeroAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrainZeroAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrain6() ) {
                                        	     		snpchromosome.setStrain6AlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrain6AlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrain6AlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainC() ) {
                                        	     		snpchromosome.setStrainCAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrainCAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrainCAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}

                                    	     		serviceSNPChromosome.update(snpchromosome);
                                    	     		
                                    	     		intSNPChromosomeCount21++;
                                    	        }
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( ratiodata.isChromosome22() ) {

                    	                List<SNPChromosome> snpchromosome22List = new ArrayList<SNPChromosome>();

                    	     			snpchromosome22List = serviceSNPChromosome.findBySnpId(ratiodata.getSnpId());
                    	     			
                    	     			if ( snpchromosome22List.isEmpty() ) {
                    	     				
                    	     				error++;

                    	     				String errorRecord = "SNP NOT FOUND!\t" + 
                    	     				        ratiodata.getSnpId() + "\t" +
                    	     						ratiodata.getStrain() + "\t" +
                    	     						ratiodata.getStrainAlleleReferenceCount() + "\t" +
                    	     						ratiodata.getStrainAlleleAlternativeCount() + "\t" +
                    	     						ratiodata.getStrainAlleleRatio();
                    	     						
                    	     				errorRecords.add(errorRecord);

                    	     				//System.out.println("Error No. " + error + " : SNP Id. " + ratiodata.getSnpId() + " NOT FOUND : " + ratiodata.toString());
                    	     			}
                    	     			else {

                        	     			if ( snpchromosome22List.size() > 1 ) {
                        	     				
                        	     				error++;

                        	     				String errorRecord = "MULTIPLE SNPs!\t" + 
                        	     				        ratiodata.getSnpId() + "\t" +
                        	     						ratiodata.getStrain() + "\t" +
                        	     						ratiodata.getStrainAlleleReferenceCount() + "\t" +
                        	     						ratiodata.getStrainAlleleAlternativeCount() + "\t" +
                        	     						ratiodata.getStrainAlleleRatio();

                        	     				errorRecords.add(errorRecord);

                        	     				//System.out.println("Error No. " + error + " : SNP Id. " + siftdata.getSnpId() + " GREATER THAN 1 ROW FOR : " + siftdata.toString());
                        	     			}
                        	     			else {

                                    	        Iterator<SNPChromosome> iteratorSNPChromosome = snpchromosome22List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome.hasNext()) {

                                    	     		SNPChromosome snpchromosome = iteratorSNPChromosome.next();

                                    	     		if ( ratiodata.isStrain7() ) {
                                    	     			snpchromosome.setStrain7AlleleRatio(ratiodata.getStrainAlleleRatio());
                                    	     			snpchromosome.setStrain7AlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                    	     			snpchromosome.setStrain7AlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainP() ) {
                                    	     			snpchromosome.setStrainPAlleleRatio(ratiodata.getStrainAlleleRatio());
                                    	     			snpchromosome.setStrainPAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                    	     			snpchromosome.setStrainPAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainW() ) {
                                    	     			snpchromosome.setStrainWAlleleRatio(ratiodata.getStrainAlleleRatio());
                                    	     			snpchromosome.setStrainWAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                    	     			snpchromosome.setStrainWAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainN() ) {
                                    	     			snpchromosome.setStrainNAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrainNAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrainNAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrain15I() ) {
                                        	     		snpchromosome.setStrain15IAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrain15IAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrain15IAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainZero() ) {
                                        	     		snpchromosome.setStrainZeroAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrainZeroAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrainZeroAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrain6() ) {
                                        	     		snpchromosome.setStrain6AlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrain6AlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrain6AlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainC() ) {
                                        	     		snpchromosome.setStrainCAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrainCAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrainCAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}

                                    	     		serviceSNPChromosome.update(snpchromosome);
                                    	     		
                                    	     		intSNPChromosomeCount22++;
                                    	     	}
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( ratiodata.isChromosome23() ) {
                    	     			
                    	                List<SNPChromosome> snpchromosome23List = new ArrayList<SNPChromosome>();
                    	                
                    	                snpchromosome23List = serviceSNPChromosome.findBySnpId(ratiodata.getSnpId());
                    	                
                    	     			if ( snpchromosome23List.isEmpty() ) {
                    	     				
                    	     				error++;

                    	     				String errorRecord = "SNP NOT FOUND!\t" + 
                    	     				        ratiodata.getSnpId() + "\t" +
                    	     						ratiodata.getStrain() + "\t" +
                    	     						ratiodata.getStrainAlleleReferenceCount() + "\t" +
                    	     						ratiodata.getStrainAlleleAlternativeCount() + "\t" +
                    	     						ratiodata.getStrainAlleleRatio();
                    	     						
                    	     				errorRecords.add(errorRecord);

                    	     				//System.out.println("Error No. " + error + " : SNP Id. " + ratiodata.getSnpId() + " NOT FOUND : " + ratiodata.toString());
                    	     			}
                    	     			else {
                    	     				
                        	     			if ( snpchromosome23List.size() > 1 ) {
                        	     				
                        	     				error++;

                        	     				String errorRecord = "MULTIPLE SNPs!\t" + 
                        	     				        ratiodata.getSnpId() + "\t" +
                        	     						ratiodata.getStrain() + "\t" +
                        	     						ratiodata.getStrainAlleleReferenceCount() + "\t" +
                        	     						ratiodata.getStrainAlleleAlternativeCount() + "\t" +
                        	     						ratiodata.getStrainAlleleRatio();

                        	     				errorRecords.add(errorRecord);

                        	     				//System.out.println("Error No. " + error + " : SNP Id. " + siftdata.getSnpId() + " GREATER THAN 1 ROW FOR : " + siftdata.toString());
                        	     			}
                        	     			else {

                                    	        Iterator<SNPChromosome> iteratorSNPChromosome = snpchromosome23List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome.hasNext()) {

                                    	     		SNPChromosome snpchromosome = iteratorSNPChromosome.next();

                                    	     		if ( ratiodata.isStrain7() ) {
                                    	     			snpchromosome.setStrain7AlleleRatio(ratiodata.getStrainAlleleRatio());
                                    	     			snpchromosome.setStrain7AlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                    	     			snpchromosome.setStrain7AlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainP() ) {
                                    	     			snpchromosome.setStrainPAlleleRatio(ratiodata.getStrainAlleleRatio());
                                    	     			snpchromosome.setStrainPAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                    	     			snpchromosome.setStrainPAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainW() ) {
                                    	     			snpchromosome.setStrainWAlleleRatio(ratiodata.getStrainAlleleRatio());
                                    	     			snpchromosome.setStrainWAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                    	     			snpchromosome.setStrainWAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainN() ) {
                                    	     			snpchromosome.setStrainNAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrainNAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrainNAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrain15I() ) {
                                        	     		snpchromosome.setStrain15IAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrain15IAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrain15IAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainZero() ) {
                                        	     		snpchromosome.setStrainZeroAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrainZeroAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrainZeroAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrain6() ) {
                                        	     		snpchromosome.setStrain6AlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrain6AlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrain6AlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainC() ) {
                                        	     		snpchromosome.setStrainCAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrainCAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrainCAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}

                                    	     		serviceSNPChromosome.update(snpchromosome);
                                    	     		
                                    	     		intSNPChromosomeCount23++;
                                    	     	}
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( ratiodata.isChromosome24() ) {
                    	     			
                    	     			List<SNPChromosome> snpchromosome24List = new ArrayList<SNPChromosome>();

                    	                snpchromosome24List = serviceSNPChromosome.findBySnpId(ratiodata.getSnpId());
                    	                
                    	     			if ( snpchromosome24List.isEmpty() ) {
                    	     				
                    	     				error++;

                    	     				String errorRecord = "SNP NOT FOUND!\t" + 
                    	     				        ratiodata.getSnpId() + "\t" +
                    	     						ratiodata.getStrain() + "\t" +
                    	     						ratiodata.getStrainAlleleReferenceCount() + "\t" +
                    	     						ratiodata.getStrainAlleleAlternativeCount() + "\t" +
                    	     						ratiodata.getStrainAlleleRatio();
                    	     						
                    	     				errorRecords.add(errorRecord);

                    	     				//System.out.println("Error No. " + error + " : SNP Id. " + ratiodata.getSnpId() + " NOT FOUND : " + ratiodata.toString());
                    	     			}
                    	     			else {

                        	     			if ( snpchromosome24List.size() > 1 ) {
                        	     				
                        	     				error++;

                        	     				String errorRecord = "MULTIPLE SNPs!\t" + 
                        	     				        ratiodata.getSnpId() + "\t" +
                        	     						ratiodata.getStrain() + "\t" +
                        	     						ratiodata.getStrainAlleleReferenceCount() + "\t" +
                        	     						ratiodata.getStrainAlleleAlternativeCount() + "\t" +
                        	     						ratiodata.getStrainAlleleRatio();

                        	     				errorRecords.add(errorRecord);

                        	     				//System.out.println("Error No. " + error + " : SNP Id. " + siftdata.getSnpId() + " GREATER THAN 1 ROW FOR : " + siftdata.toString());
                        	     			}
                        	     			else {

                                    	        Iterator<SNPChromosome> iteratorSNPChromosome = snpchromosome24List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome.hasNext()) {

                                    	     		SNPChromosome snpchromosome = iteratorSNPChromosome.next();

                                    	     		if ( ratiodata.isStrain7() ) {
                                    	     			snpchromosome.setStrain7AlleleRatio(ratiodata.getStrainAlleleRatio());
                                    	     			snpchromosome.setStrain7AlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                    	     			snpchromosome.setStrain7AlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainP() ) {
                                    	     			snpchromosome.setStrainPAlleleRatio(ratiodata.getStrainAlleleRatio());
                                    	     			snpchromosome.setStrainPAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                    	     			snpchromosome.setStrainPAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainW() ) {
                                    	     			snpchromosome.setStrainWAlleleRatio(ratiodata.getStrainAlleleRatio());
                                    	     			snpchromosome.setStrainWAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                    	     			snpchromosome.setStrainWAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainN() ) {
                                    	     			snpchromosome.setStrainNAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrainNAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrainNAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrain15I() ) {
                                        	     		snpchromosome.setStrain15IAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrain15IAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrain15IAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainZero() ) {
                                        	     		snpchromosome.setStrainZeroAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrainZeroAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrainZeroAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrain6() ) {
                                        	     		snpchromosome.setStrain6AlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrain6AlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrain6AlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainC() ) {
                                        	     		snpchromosome.setStrainCAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrainCAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrainCAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}

                                    	     		serviceSNPChromosome.update(snpchromosome);
                                    	     		
                                    	     		intSNPChromosomeCount24++;
                                    	     	}
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( ratiodata.isChromosome25() ) {
                    	     			
                    	                List<SNPChromosome> snpchromosome25List = new ArrayList<SNPChromosome>();

                    	     			snpchromosome25List = serviceSNPChromosome.findBySnpId(ratiodata.getSnpId());
                    	     			
                    	     			if ( snpchromosome25List.isEmpty() ) {
                    	     				
                    	     				error++;
                    	     				
                    	     				String errorRecord = "SNP NOT FOUND!\t" + 
                    	     				        ratiodata.getSnpId() + "\t" +
                    	     						ratiodata.getStrain() + "\t" +
                    	     						ratiodata.getStrainAlleleReferenceCount() + "\t" +
                    	     						ratiodata.getStrainAlleleAlternativeCount() + "\t" +
                    	     						ratiodata.getStrainAlleleRatio();
                    	     						
                    	     				errorRecords.add(errorRecord);

                    	     				//System.out.println("Error No. " + error + " : SNP Id. " + ratiodata.getSnpId() + " NOT FOUND : " + ratiodata.toString());
                    	     			}
                    	     			else {

                        	     			if ( snpchromosome25List.size() > 1 ) {
                        	     				
                        	     				error++;

                        	     				String errorRecord = "MULTIPLE SNPs!\t" + 
                        	     				        ratiodata.getSnpId() + "\t" +
                        	     						ratiodata.getStrain() + "\t" +
                        	     						ratiodata.getStrainAlleleReferenceCount() + "\t" +
                        	     						ratiodata.getStrainAlleleAlternativeCount() + "\t" +
                        	     						ratiodata.getStrainAlleleRatio();

                        	     				errorRecords.add(errorRecord);

                        	     				//System.out.println("Error No. " + error + " : SNP Id. " + siftdata.getSnpId() + " GREATER THAN 1 ROW FOR : " + siftdata.toString());
                        	     			}
                        	     			else {

                                    	        Iterator<SNPChromosome> iteratorSNPChromosome = snpchromosome25List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome.hasNext()) {

                                    	     		SNPChromosome snpchromosome = iteratorSNPChromosome.next();

                                    	     		if ( ratiodata.isStrain7() ) {
                                    	     			snpchromosome.setStrain7AlleleRatio(ratiodata.getStrainAlleleRatio());
                                    	     			snpchromosome.setStrain7AlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                    	     			snpchromosome.setStrain7AlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainP() ) {
                                    	     			snpchromosome.setStrainPAlleleRatio(ratiodata.getStrainAlleleRatio());
                                    	     			snpchromosome.setStrainPAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                    	     			snpchromosome.setStrainPAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainW() ) {
                                    	     			snpchromosome.setStrainWAlleleRatio(ratiodata.getStrainAlleleRatio());
                                    	     			snpchromosome.setStrainWAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                    	     			snpchromosome.setStrainWAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainN() ) {
                                    	     			snpchromosome.setStrainNAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrainNAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrainNAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrain15I() ) {
                                        	     		snpchromosome.setStrain15IAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrain15IAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrain15IAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainZero() ) {
                                        	     		snpchromosome.setStrainZeroAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrainZeroAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrainZeroAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrain6() ) {
                                        	     		snpchromosome.setStrain6AlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrain6AlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrain6AlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainC() ) {
                                        	     		snpchromosome.setStrainCAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrainCAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrainCAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}

                                    	     		serviceSNPChromosome.update(snpchromosome);
                                    	     		
                                    	     		intSNPChromosomeCount25++;
                                    	     	}
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( ratiodata.isChromosome26() ) {

                    	                List<SNPChromosome> snpchromosome26List = new ArrayList<SNPChromosome>();

                    	     			snpchromosome26List = serviceSNPChromosome.findBySnpId(ratiodata.getSnpId());
                    	     			
                    	     			if ( snpchromosome26List.isEmpty() ) {
                    	     				
                    	     				error++;

                    	     				String errorRecord = "SNP NOT FOUND!\t" + 
                    	     				        ratiodata.getSnpId() + "\t" +
                    	     						ratiodata.getStrain() + "\t" +
                    	     						ratiodata.getStrainAlleleReferenceCount() + "\t" +
                    	     						ratiodata.getStrainAlleleAlternativeCount() + "\t" +
                    	     						ratiodata.getStrainAlleleRatio();
                    	     						
                    	     				errorRecords.add(errorRecord);

                    	     				//System.out.println("Error No. " + error + " : SNP Id. " + ratiodata.getSnpId() + " NOT FOUND : " + ratiodata.toString());
                    	     			}
                    	     			else {
                    	     				
                        	     			if ( snpchromosome26List.size() > 1 ) {
                        	     				
                        	     				error++;

                        	     				String errorRecord = "MULTIPLE SNPs!\t" + 
                        	     				        ratiodata.getSnpId() + "\t" +
                        	     						ratiodata.getStrain() + "\t" +
                        	     						ratiodata.getStrainAlleleReferenceCount() + "\t" +
                        	     						ratiodata.getStrainAlleleAlternativeCount() + "\t" +
                        	     						ratiodata.getStrainAlleleRatio();

                        	     				errorRecords.add(errorRecord);

                        	     				//System.out.println("Error No. " + error + " : SNP Id. " + siftdata.getSnpId() + " GREATER THAN 1 ROW FOR : " + siftdata.toString());
                        	     			}
                        	     			else {
                            	     			
                                    	        Iterator<SNPChromosome> iteratorSNPChromosome = snpchromosome26List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome.hasNext()) {

                                    	     		SNPChromosome snpchromosome = iteratorSNPChromosome.next();

                                    	     		if ( ratiodata.isStrain7() ) {
                                    	     			snpchromosome.setStrain7AlleleRatio(ratiodata.getStrainAlleleRatio());
                                    	     			snpchromosome.setStrain7AlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                    	     			snpchromosome.setStrain7AlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainP() ) {
                                    	     			snpchromosome.setStrainPAlleleRatio(ratiodata.getStrainAlleleRatio());
                                    	     			snpchromosome.setStrainPAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                    	     			snpchromosome.setStrainPAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainW() ) {
                                    	     			snpchromosome.setStrainWAlleleRatio(ratiodata.getStrainAlleleRatio());
                                    	     			snpchromosome.setStrainWAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                    	     			snpchromosome.setStrainWAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainN() ) {
                                    	     			snpchromosome.setStrainNAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrainNAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrainNAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrain15I() ) {
                                        	     		snpchromosome.setStrain15IAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrain15IAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrain15IAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainZero() ) {
                                        	     		snpchromosome.setStrainZeroAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrainZeroAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrainZeroAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrain6() ) {
                                        	     		snpchromosome.setStrain6AlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrain6AlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrain6AlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainC() ) {
                                        	     		snpchromosome.setStrainCAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrainCAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrainCAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}

                                    	     		serviceSNPChromosome.update(snpchromosome);
                                    	     		
                                    	     		intSNPChromosomeCount26++;
                                    	     	}
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( ratiodata.isChromosome27() ) {
                    	     			
                    	                List<SNPChromosome> snpchromosome27List = new ArrayList<SNPChromosome>();

                    	     			snpchromosome27List = serviceSNPChromosome.findBySnpId(ratiodata.getSnpId());
                    	     			
                    	     			if ( snpchromosome27List.isEmpty() ) {
                    	     				
                    	     				error++;

                    	     				String errorRecord = "SNP NOT FOUND!\t" + 
                    	     				        ratiodata.getSnpId() + "\t" +
                    	     						ratiodata.getStrain() + "\t" +
                    	     						ratiodata.getStrainAlleleReferenceCount() + "\t" +
                    	     						ratiodata.getStrainAlleleAlternativeCount() + "\t" +
                    	     						ratiodata.getStrainAlleleRatio();
                    	     						
                    	     				errorRecords.add(errorRecord);

                    	     				//System.out.println("Error No. " + error + " : SNP Id. " + ratiodata.getSnpId() + " NOT FOUND : " + ratiodata.toString());
                    	     			}
                    	     			else {
                    	     				
                        	     			if ( snpchromosome27List.size() > 1 ) {
                        	     				
                        	     				error++;

                        	     				String errorRecord = "MULTIPLE SNPs!\t" + 
                        	     				        ratiodata.getSnpId() + "\t" +
                        	     						ratiodata.getStrain() + "\t" +
                        	     						ratiodata.getStrainAlleleReferenceCount() + "\t" +
                        	     						ratiodata.getStrainAlleleAlternativeCount() + "\t" +
                        	     						ratiodata.getStrainAlleleRatio();

                        	     				errorRecords.add(errorRecord);

                        	     				//System.out.println("Error No. " + error + " : SNP Id. " + siftdata.getSnpId() + " GREATER THAN 1 ROW FOR : " + siftdata.toString());
                        	     			}
                        	     			else {

                                    	        Iterator<SNPChromosome> iteratorSNPChromosome = snpchromosome27List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome.hasNext()) {

                                    	     		SNPChromosome snpchromosome = iteratorSNPChromosome.next();

                                    	     		if ( ratiodata.isStrain7() ) {
                                    	     			snpchromosome.setStrain7AlleleRatio(ratiodata.getStrainAlleleRatio());
                                    	     			snpchromosome.setStrain7AlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                    	     			snpchromosome.setStrain7AlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainP() ) {
                                    	     			snpchromosome.setStrainPAlleleRatio(ratiodata.getStrainAlleleRatio());
                                    	     			snpchromosome.setStrainPAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                    	     			snpchromosome.setStrainPAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainW() ) {
                                    	     			snpchromosome.setStrainWAlleleRatio(ratiodata.getStrainAlleleRatio());
                                    	     			snpchromosome.setStrainWAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                    	     			snpchromosome.setStrainWAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainN() ) {
                                    	     			snpchromosome.setStrainNAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrainNAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrainNAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrain15I() ) {
                                        	     		snpchromosome.setStrain15IAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrain15IAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrain15IAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainZero() ) {
                                        	     		snpchromosome.setStrainZeroAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrainZeroAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrainZeroAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrain6() ) {
                                        	     		snpchromosome.setStrain6AlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrain6AlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrain6AlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainC() ) {
                                        	     		snpchromosome.setStrainCAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrainCAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrainCAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}

                                    	     		serviceSNPChromosome.update(snpchromosome);
                                    	     		
                                    	     		intSNPChromosomeCount27++;
                                    	     	}
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( ratiodata.isChromosome28() ) {

                    	                List<SNPChromosome> snpchromosome28List = new ArrayList<SNPChromosome>();

                    	     			snpchromosome28List = serviceSNPChromosome.findBySnpId(ratiodata.getSnpId());
                    	     			
                    	     			if ( snpchromosome28List.isEmpty() ) {
                    	     				
                    	     				error++;

                    	     				String errorRecord = "SNP NOT FOUND!\t" + 
                    	     				        ratiodata.getSnpId() + "\t" +
                    	     						ratiodata.getStrain() + "\t" +
                    	     						ratiodata.getStrainAlleleReferenceCount() + "\t" +
                    	     						ratiodata.getStrainAlleleAlternativeCount() + "\t" +
                    	     						ratiodata.getStrainAlleleRatio();
                    	     						
                    	     				errorRecords.add(errorRecord);

                    	     				//System.out.println("Error No. " + error + " : SNP Id. " + ratiodata.getSnpId() + " NOT FOUND : " + ratiodata.toString());
                    	     			}
                    	     			else {
                    	     				
                        	     			if ( snpchromosome28List.size() > 1 ) {
                        	     				
                        	     				error++;

                        	     				String errorRecord = "MULTIPLE SNPs!\t" + 
                        	     				        ratiodata.getSnpId() + "\t" +
                        	     						ratiodata.getStrain() + "\t" +
                        	     						ratiodata.getStrainAlleleReferenceCount() + "\t" +
                        	     						ratiodata.getStrainAlleleAlternativeCount() + "\t" +
                        	     						ratiodata.getStrainAlleleRatio();

                        	     				errorRecords.add(errorRecord);

                        	     				//System.out.println("Error No. " + error + " : SNP Id. " + siftdata.getSnpId() + " GREATER THAN 1 ROW FOR : " + siftdata.toString());
                        	     			}
                        	     			else {

                                    	        Iterator<SNPChromosome> iteratorSNPChromosome = snpchromosome28List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome.hasNext()) {

                                    	     		SNPChromosome snpchromosome = iteratorSNPChromosome.next();

                                    	     		if ( ratiodata.isStrain7() ) {
                                    	     			snpchromosome.setStrain7AlleleRatio(ratiodata.getStrainAlleleRatio());
                                    	     			snpchromosome.setStrain7AlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                    	     			snpchromosome.setStrain7AlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainP() ) {
                                    	     			snpchromosome.setStrainPAlleleRatio(ratiodata.getStrainAlleleRatio());
                                    	     			snpchromosome.setStrainPAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                    	     			snpchromosome.setStrainPAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainW() ) {
                                    	     			snpchromosome.setStrainWAlleleRatio(ratiodata.getStrainAlleleRatio());
                                    	     			snpchromosome.setStrainWAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                    	     			snpchromosome.setStrainWAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainN() ) {
                                    	     			snpchromosome.setStrainNAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrainNAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrainNAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrain15I() ) {
                                        	     		snpchromosome.setStrain15IAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrain15IAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrain15IAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainZero() ) {
                                        	     		snpchromosome.setStrainZeroAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrainZeroAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrainZeroAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrain6() ) {
                                        	     		snpchromosome.setStrain6AlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrain6AlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrain6AlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainC() ) {
                                        	     		snpchromosome.setStrainCAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrainCAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrainCAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}

                                    	     		serviceSNPChromosome.update(snpchromosome);
                                    	     		
                                    	     		intSNPChromosomeCount28++;
                                    	     	}
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( ratiodata.isChromosome32() ) {
                    	     			
                    	                List<SNPChromosome> snpchromosome32List = new ArrayList<SNPChromosome>();

                    	     			snpchromosome32List = serviceSNPChromosome.findBySnpId(ratiodata.getSnpId());
                    	     			
                    	     			if ( snpchromosome32List.isEmpty() ) {
                    	     				
                    	     				error++;

                    	     				String errorRecord = "SNP NOT FOUND!\t" + 
                    	     				        ratiodata.getSnpId() + "\t" +
                    	     						ratiodata.getStrain() + "\t" +
                    	     						ratiodata.getStrainAlleleReferenceCount() + "\t" +
                    	     						ratiodata.getStrainAlleleAlternativeCount() + "\t" +
                    	     						ratiodata.getStrainAlleleRatio();
                    	     						
                    	     				errorRecords.add(errorRecord);

                    	     				//System.out.println("Error No. " + error + " : SNP Id. " + ratiodata.getSnpId() + " NOT FOUND : " + ratiodata.toString());
                    	     			}
                    	     			else {

                        	     			if ( snpchromosome32List.size() > 1 ) {
                        	     				
                        	     				error++;

                        	     				String errorRecord = "MULTIPLE SNPs!\t" + 
                        	     				        ratiodata.getSnpId() + "\t" +
                        	     						ratiodata.getStrain() + "\t" +
                        	     						ratiodata.getStrainAlleleReferenceCount() + "\t" +
                        	     						ratiodata.getStrainAlleleAlternativeCount() + "\t" +
                        	     						ratiodata.getStrainAlleleRatio();

                        	     				errorRecords.add(errorRecord);

                        	     				//System.out.println("Error No. " + error + " : SNP Id. " + siftdata.getSnpId() + " GREATER THAN 1 ROW FOR : " + siftdata.toString());
                        	     			}
                        	     			else {

                                    	        Iterator<SNPChromosome> iteratorSNPChromosome = snpchromosome32List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome.hasNext()) {

                                    	     		SNPChromosome snpchromosome = iteratorSNPChromosome.next();

                                    	     		if ( ratiodata.isStrain7() ) {
                                    	     			snpchromosome.setStrain7AlleleRatio(ratiodata.getStrainAlleleRatio());
                                    	     			snpchromosome.setStrain7AlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                    	     			snpchromosome.setStrain7AlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainP() ) {
                                    	     			snpchromosome.setStrainPAlleleRatio(ratiodata.getStrainAlleleRatio());
                                    	     			snpchromosome.setStrainPAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                    	     			snpchromosome.setStrainPAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainW() ) {
                                    	     			snpchromosome.setStrainWAlleleRatio(ratiodata.getStrainAlleleRatio());
                                    	     			snpchromosome.setStrainWAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                    	     			snpchromosome.setStrainWAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainN() ) {
                                    	     			snpchromosome.setStrainNAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrainNAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrainNAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrain15I() ) {
                                        	     		snpchromosome.setStrain15IAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrain15IAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrain15IAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainZero() ) {
                                        	     		snpchromosome.setStrainZeroAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrainZeroAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrainZeroAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrain6() ) {
                                        	     		snpchromosome.setStrain6AlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrain6AlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrain6AlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainC() ) {
                                        	     		snpchromosome.setStrainCAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrainCAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrainCAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}

                                    	     		serviceSNPChromosome.update(snpchromosome);
                                    	     		
                                    	     		intSNPChromosomeCount32++;
                                    	     	}
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( ratiodata.isChromosomeLGE64() ) {
                    	     			
                    	                List<SNPChromosome> snpchromosomeLGE64List = new ArrayList<SNPChromosome>();

                    	     			snpchromosomeLGE64List = serviceSNPChromosome.findBySnpId(ratiodata.getSnpId());
                    	     			
                    	     			if ( snpchromosomeLGE64List.isEmpty() ) {
                    	     				
                    	     				error++;

                    	     				String errorRecord = "SNP NOT FOUND!\t" + 
                    	     				        ratiodata.getSnpId() + "\t" +
                    	     						ratiodata.getStrain() + "\t" +
                    	     						ratiodata.getStrainAlleleReferenceCount() + "\t" +
                    	     						ratiodata.getStrainAlleleAlternativeCount() + "\t" +
                    	     						ratiodata.getStrainAlleleRatio();
                    	     						
                    	     				errorRecords.add(errorRecord);

                    	     				//System.out.println("Error No. " + error + " : SNP Id. " + ratiodata.getSnpId() + " NOT FOUND : " + ratiodata.toString());
                    	     			}
                    	     			else {

                        	     			if ( snpchromosomeLGE64List.size() > 1 ) {
                        	     				
                        	     				error++;

                        	     				String errorRecord = "MULTIPLE SNPs!\t" + 
                        	     				        ratiodata.getSnpId() + "\t" +
                        	     						ratiodata.getStrain() + "\t" +
                        	     						ratiodata.getStrainAlleleReferenceCount() + "\t" +
                        	     						ratiodata.getStrainAlleleAlternativeCount() + "\t" +
                        	     						ratiodata.getStrainAlleleRatio();

                        	     				errorRecords.add(errorRecord);

                        	     				//System.out.println("Error No. " + error + " : SNP Id. " + siftdata.getSnpId() + " GREATER THAN 1 ROW FOR : " + siftdata.toString());
                        	     			}
                        	     			else {
                        	     				

                                    	        Iterator<SNPChromosome> iteratorSNPChromosome = snpchromosomeLGE64List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome.hasNext()) {

                                    	     		SNPChromosome snpchromosome = iteratorSNPChromosome.next();

                                    	     		if ( ratiodata.isStrain7() ) {
                                    	     			snpchromosome.setStrain7AlleleRatio(ratiodata.getStrainAlleleRatio());
                                    	     			snpchromosome.setStrain7AlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                    	     			snpchromosome.setStrain7AlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainP() ) {
                                    	     			snpchromosome.setStrainPAlleleRatio(ratiodata.getStrainAlleleRatio());
                                    	     			snpchromosome.setStrainPAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                    	     			snpchromosome.setStrainPAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainW() ) {
                                    	     			snpchromosome.setStrainWAlleleRatio(ratiodata.getStrainAlleleRatio());
                                    	     			snpchromosome.setStrainWAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                    	     			snpchromosome.setStrainWAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainN() ) {
                                    	     			snpchromosome.setStrainNAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrainNAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrainNAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrain15I() ) {
                                        	     		snpchromosome.setStrain15IAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrain15IAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrain15IAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainZero() ) {
                                        	     		snpchromosome.setStrainZeroAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrainZeroAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrainZeroAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrain6() ) {
                                        	     		snpchromosome.setStrain6AlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrain6AlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrain6AlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainC() ) {
                                        	     		snpchromosome.setStrainCAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrainCAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrainCAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}

                                    	     		serviceSNPChromosome.update(snpchromosome);
                                    	     		
                                    	     		intSNPChromosomeCountLGE64++;
                                    	     	}
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( ratiodata.isChromosomeLGE22C19W28_E50C23() ) {
                    	     			
                    	                List<SNPChromosome> snpchromosomeLGE22C19W28_E50C23List = new ArrayList<SNPChromosome>();

                    	     			snpchromosomeLGE22C19W28_E50C23List = serviceSNPChromosome.findBySnpId(ratiodata.getSnpId());
                    	     			
                    	     			if ( snpchromosomeLGE22C19W28_E50C23List.isEmpty() ) {
                    	     				
                    	     				error++;

                    	     				String errorRecord = "SNP NOT FOUND!\t" + 
                    	     				        ratiodata.getSnpId() + "\t" +
                    	     						ratiodata.getStrain() + "\t" +
                    	     						ratiodata.getStrainAlleleReferenceCount() + "\t" +
                    	     						ratiodata.getStrainAlleleAlternativeCount() + "\t" +
                    	     						ratiodata.getStrainAlleleRatio();
                    	     						
                    	     				errorRecords.add(errorRecord);

                    	     				//System.out.println("Error No. " + error + " : SNP Id. " + ratiodata.getSnpId() + " NOT FOUND : " + ratiodata.toString());
                    	     			}
                    	     			else {
                    	     				
                        	     			if ( snpchromosomeLGE22C19W28_E50C23List.size() > 1 ) {
                        	     				
                        	     				error++;

                        	     				String errorRecord = "MULTIPLE SNPs!\t" + 
                        	     				        ratiodata.getSnpId() + "\t" +
                        	     						ratiodata.getStrain() + "\t" +
                        	     						ratiodata.getStrainAlleleReferenceCount() + "\t" +
                        	     						ratiodata.getStrainAlleleAlternativeCount() + "\t" +
                        	     						ratiodata.getStrainAlleleRatio();

                        	     				errorRecords.add(errorRecord);

                        	     				//System.out.println("Error No. " + error + " : SNP Id. " + siftdata.getSnpId() + " GREATER THAN 1 ROW FOR : " + siftdata.toString());
                        	     			}
                        	     			else {
                        	     				
                                    	        Iterator<SNPChromosome> iteratorSNPChromosome = snpchromosomeLGE22C19W28_E50C23List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome.hasNext()) {

                                    	     		SNPChromosome snpchromosome = iteratorSNPChromosome.next();

                                    	     		if ( ratiodata.isStrain7() ) {
                                    	     			snpchromosome.setStrain7AlleleRatio(ratiodata.getStrainAlleleRatio());
                                    	     			snpchromosome.setStrain7AlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                    	     			snpchromosome.setStrain7AlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainP() ) {
                                    	     			snpchromosome.setStrainPAlleleRatio(ratiodata.getStrainAlleleRatio());
                                    	     			snpchromosome.setStrainPAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                    	     			snpchromosome.setStrainPAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainW() ) {
                                    	     			snpchromosome.setStrainWAlleleRatio(ratiodata.getStrainAlleleRatio());
                                    	     			snpchromosome.setStrainWAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                    	     			snpchromosome.setStrainWAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainN() ) {
                                    	     			snpchromosome.setStrainNAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrainNAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrainNAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrain15I() ) {
                                        	     		snpchromosome.setStrain15IAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrain15IAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrain15IAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainZero() ) {
                                        	     		snpchromosome.setStrainZeroAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrainZeroAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrainZeroAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrain6() ) {
                                        	     		snpchromosome.setStrain6AlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrain6AlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrain6AlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainC() ) {
                                        	     		snpchromosome.setStrainCAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrainCAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrainCAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}

                                    	     		serviceSNPChromosome.update(snpchromosome);
                                    	     		
                                    	     		intSNPChromosomeCountLGE22C19W28_E50C23++;
                                    	     	}
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( ratiodata.isChromosomeW() ) {
                    	     			
                    	                List<SNPChromosome> snpchromosomeWList = new ArrayList<SNPChromosome>();

                    	     			snpchromosomeWList = serviceSNPChromosome.findBySnpId(ratiodata.getSnpId());
                    	     			
                    	     			if ( snpchromosomeWList.isEmpty() ) {
                    	     				
                    	     				error++;

                    	     				String errorRecord = "SNP NOT FOUND!\t" + 
                    	     				        ratiodata.getSnpId() + "\t" +
                    	     						ratiodata.getStrain() + "\t" +
                    	     						ratiodata.getStrainAlleleReferenceCount() + "\t" +
                    	     						ratiodata.getStrainAlleleAlternativeCount() + "\t" +
                    	     						ratiodata.getStrainAlleleRatio();
                    	     						
                    	     				errorRecords.add(errorRecord);

                    	     				//System.out.println("Error No. " + error + " : SNP Id. " + ratiodata.getSnpId() + " NOT FOUND : " + ratiodata.toString());
                    	     			}
                    	     			else {
                    	     				
                        	     			if ( snpchromosomeWList.size() > 1 ) {
                        	     				
                        	     				error++;

                        	     				String errorRecord = "MULTIPLE SNPs!\t" + 
                        	     				        ratiodata.getSnpId() + "\t" +
                        	     						ratiodata.getStrain() + "\t" +
                        	     						ratiodata.getStrainAlleleReferenceCount() + "\t" +
                        	     						ratiodata.getStrainAlleleAlternativeCount() + "\t" +
                        	     						ratiodata.getStrainAlleleRatio();

                        	     				errorRecords.add(errorRecord);

                        	     				//System.out.println("Error No. " + error + " : SNP Id. " + siftdata.getSnpId() + " GREATER THAN 1 ROW FOR : " + siftdata.toString());
                        	     			}
                        	     			else {

                                    	        Iterator<SNPChromosome> iteratorSNPChromosome = snpchromosomeWList.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome.hasNext()) {

                                    	     		SNPChromosome snpchromosome = iteratorSNPChromosome.next();

                                    	     		if ( ratiodata.isStrain7() ) {
                                    	     			snpchromosome.setStrain7AlleleRatio(ratiodata.getStrainAlleleRatio());
                                    	     			snpchromosome.setStrain7AlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                    	     			snpchromosome.setStrain7AlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainP() ) {
                                    	     			snpchromosome.setStrainPAlleleRatio(ratiodata.getStrainAlleleRatio());
                                    	     			snpchromosome.setStrainPAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                    	     			snpchromosome.setStrainPAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainW() ) {
                                    	     			snpchromosome.setStrainWAlleleRatio(ratiodata.getStrainAlleleRatio());
                                    	     			snpchromosome.setStrainWAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                    	     			snpchromosome.setStrainWAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainN() ) {
                                    	     			snpchromosome.setStrainNAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrainNAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrainNAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrain15I() ) {
                                        	     		snpchromosome.setStrain15IAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrain15IAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrain15IAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainZero() ) {
                                        	     		snpchromosome.setStrainZeroAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrainZeroAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrainZeroAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrain6() ) {
                                        	     		snpchromosome.setStrain6AlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrain6AlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrain6AlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainC() ) {
                                        	     		snpchromosome.setStrainCAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrainCAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrainCAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}

                                    	     		serviceSNPChromosome.update(snpchromosome);
                                    	     		
                                    	     		intSNPChromosomeCountW++;
                                    	     	}                        	     			}
                    	     			}
                    	     		}

                    	     		if ( ratiodata.isChromosomeZ() ) {
                    	     			
                    	                List<SNPChromosome> snpchromosomeZList = new ArrayList<SNPChromosome>();

                    	     			snpchromosomeZList = serviceSNPChromosome.findBySnpId(ratiodata.getSnpId());
                    	     			
                    	     			if ( snpchromosomeZList.isEmpty() ) {
                    	     				
                    	     				error++;

                    	     				String errorRecord = "SNP NOT FOUND!\t" + 
                    	     				        ratiodata.getSnpId() + "\t" +
                    	     						ratiodata.getStrain() + "\t" +
                    	     						ratiodata.getStrainAlleleReferenceCount() + "\t" +
                    	     						ratiodata.getStrainAlleleAlternativeCount() + "\t" +
                    	     						ratiodata.getStrainAlleleRatio();
                    	     						
                    	     				errorRecords.add(errorRecord);

                    	     				//System.out.println("Error No. " + error + " : SNP Id. " + ratiodata.getSnpId() + " NOT FOUND : " + ratiodata.toString());
                    	     			}
                    	     			else {
                    	     				
                        	     			if ( snpchromosomeZList.size() > 1 ) {
                        	     				
                        	     				error++;

                        	     				String errorRecord = "MULTIPLE SNPs!\t" + 
                        	     				        ratiodata.getSnpId() + "\t" +
                        	     						ratiodata.getStrain() + "\t" +
                        	     						ratiodata.getStrainAlleleReferenceCount() + "\t" +
                        	     						ratiodata.getStrainAlleleAlternativeCount() + "\t" +
                        	     						ratiodata.getStrainAlleleRatio();

                        	     				errorRecords.add(errorRecord);

                        	     				//System.out.println("Error No. " + error + " : SNP Id. " + siftdata.getSnpId() + " GREATER THAN 1 ROW FOR : " + siftdata.toString());
                        	     			}
                        	     			else {
                        	     				
                                    	        Iterator<SNPChromosome> iteratorSNPChromosome = snpchromosomeZList.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome.hasNext()) {

                                    	     		SNPChromosome snpchromosome = iteratorSNPChromosome.next();
                                    	     		
                                    	     		if ( ratiodata.isStrain7() ) {
                                    	     			snpchromosome.setStrain7AlleleRatio(ratiodata.getStrainAlleleRatio());
                                    	     			snpchromosome.setStrain7AlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                    	     			snpchromosome.setStrain7AlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainP() ) {
                                    	     			snpchromosome.setStrainPAlleleRatio(ratiodata.getStrainAlleleRatio());
                                    	     			snpchromosome.setStrainPAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                    	     			snpchromosome.setStrainPAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainW() ) {
                                    	     			snpchromosome.setStrainWAlleleRatio(ratiodata.getStrainAlleleRatio());
                                    	     			snpchromosome.setStrainWAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                    	     			snpchromosome.setStrainWAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainN() ) {
                                    	     			snpchromosome.setStrainNAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrainNAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrainNAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrain15I() ) {
                                        	     		snpchromosome.setStrain15IAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrain15IAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrain15IAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainZero() ) {
                                        	     		snpchromosome.setStrainZeroAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrainZeroAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrainZeroAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrain6() ) {
                                        	     		snpchromosome.setStrain6AlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrain6AlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrain6AlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}
                                    	     		if ( ratiodata.isStrainC() ) {
                                        	     		snpchromosome.setStrainCAlleleRatio(ratiodata.getStrainAlleleRatio());
                                        	     		snpchromosome.setStrainCAlleleAlternativeCount(ratiodata.getStrainAlleleAlternativeCount());
                                        	     		snpchromosome.setStrainCAlleleReferenceCount(ratiodata.getStrainAlleleReferenceCount());
                                    	     		}

                                    	     		serviceSNPChromosome.update(snpchromosome);
                                    	     		
                                    	     		intSNPChromosomeCountZ++;
                                    	     	}
                        	     			}
                    	     			}
                    	     		}
                	     		}
                	     	}
            			}
            		}
            		
            		FileUtil.write(errorFile, errorRecords);
            		
        			System.out.println(StringUtility.pad(totalRecordCount, 8, PAD_CHAR) + " to be updated from " + totalFileCount + " files in Directory " + directory );

        			System.out.println(StringUtility.pad(error, 8, PAD_CHAR) + " Error Records IGNORED!");
            		
             		System.out.println(StringUtility.pad(intSNPChromosomeCount01, 8, PAD_CHAR) + " Records updated into SNPChromosomeCount01");
             		System.out.println(StringUtility.pad(intSNPChromosomeCount02, 8, PAD_CHAR) + " Records updated into SNPChromosomeCount02");
            		System.out.println(StringUtility.pad(intSNPChromosomeCount03, 8, PAD_CHAR) + " Records updated into SNPChromosomeCount03");
            		System.out.println(StringUtility.pad(intSNPChromosomeCount04, 8, PAD_CHAR) + " Records updated into SNPChromosomeCount04");
             		System.out.println(StringUtility.pad(intSNPChromosomeCount05, 8, PAD_CHAR) + " Records updated into SNPChromosomeCount05");
            		System.out.println(StringUtility.pad(intSNPChromosomeCount06, 8, PAD_CHAR) + " Records updated into SNPChromosomeCount06");
            		System.out.println(StringUtility.pad(intSNPChromosomeCount07, 8, PAD_CHAR) + " Records updated into SNPChromosomeCount07");
            		System.out.println(StringUtility.pad(intSNPChromosomeCount08, 8, PAD_CHAR) + " Records updated into SNPChromosomeCount08");
            		System.out.println(StringUtility.pad(intSNPChromosomeCount09, 8, PAD_CHAR) + " Records updated into SNPChromosomeCount09");
            		System.out.println(StringUtility.pad(intSNPChromosomeCount10, 8, PAD_CHAR) + " Records updated into SNPChromosomeCount10");
            		System.out.println(StringUtility.pad(intSNPChromosomeCount11, 8, PAD_CHAR) + " Records updated into SNPChromosomeCount11");
            		System.out.println(StringUtility.pad(intSNPChromosomeCount12, 8, PAD_CHAR) + " Records updated into SNPChromosomeCount12");
            		System.out.println(StringUtility.pad(intSNPChromosomeCount13, 8, PAD_CHAR) + " Records updated into SNPChromosomeCount13");
            		System.out.println(StringUtility.pad(intSNPChromosomeCount14, 8, PAD_CHAR) + " Records updated into SNPChromosomeCount14");
            		System.out.println(StringUtility.pad(intSNPChromosomeCount15, 8, PAD_CHAR) + " Records updated into SNPChromosomeCount15");
            		System.out.println(StringUtility.pad(intSNPChromosomeCount16, 8, PAD_CHAR) + " Records updated into SNPChromosomeCount16");
            		System.out.println(StringUtility.pad(intSNPChromosomeCount17, 8, PAD_CHAR) + " Records updated into SNPChromosomeCount17");
            		System.out.println(StringUtility.pad(intSNPChromosomeCount18, 8, PAD_CHAR) + " Records updated into SNPChromosomeCount18");
            		System.out.println(StringUtility.pad(intSNPChromosomeCount19, 8, PAD_CHAR) + " Records updated into SNPChromosomeCount19");
            		System.out.println(StringUtility.pad(intSNPChromosomeCount20, 8, PAD_CHAR) + " Records updated into SNPChromosomeCount20");
            		System.out.println(StringUtility.pad(intSNPChromosomeCount21, 8, PAD_CHAR) + " Records updated into SNPChromosomeCount21");
            		System.out.println(StringUtility.pad(intSNPChromosomeCount22, 8, PAD_CHAR) + " Records updated into SNPChromosomeCount22");
            		System.out.println(StringUtility.pad(intSNPChromosomeCount23, 8, PAD_CHAR) + " Records updated into SNPChromosomeCount23");
            		System.out.println(StringUtility.pad(intSNPChromosomeCount24, 8, PAD_CHAR) + " Records updated into SNPChromosomeCount24");
            		System.out.println(StringUtility.pad(intSNPChromosomeCount25, 8, PAD_CHAR) + " Records updated into SNPChromosomeCount25");
            		System.out.println(StringUtility.pad(intSNPChromosomeCount26, 8, PAD_CHAR) + " Records updated into SNPChromosomeCount26");
            		System.out.println(StringUtility.pad(intSNPChromosomeCount27, 8, PAD_CHAR) + " Records updated into SNPChromosomeCount27");
            		System.out.println(StringUtility.pad(intSNPChromosomeCount28, 8, PAD_CHAR) + " Records updated into SNPChromosomeCount28");
            		System.out.println(StringUtility.pad(intSNPChromosomeCount32, 8, PAD_CHAR) + " Records updated into SNPChromosomeCount32");
            		System.out.println(StringUtility.pad(intSNPChromosomeCountLGE22C19W28_E50C23, 8, PAD_CHAR) + " Records updated into SNPChromosomeCountLGE22C19W28_E50C23");
            		System.out.println(StringUtility.pad(intSNPChromosomeCountLGE64, 8, PAD_CHAR) + " Records updated into SNPChromosomeCountLGE64");
            		System.out.println(StringUtility.pad(intSNPChromosomeCountW, 8, PAD_CHAR) + " Records updated into SNPChromosomeCountW");
            		System.out.println(StringUtility.pad(intSNPChromosomeCountZ, 8, PAD_CHAR) + " Records updated into SNPChromosomeCountZ");

        			totalRecordCount = intSNPChromosomeCount01 + intSNPChromosomeCount02 + intSNPChromosomeCount03 + intSNPChromosomeCount04 + intSNPChromosomeCount05 + intSNPChromosomeCount06 + intSNPChromosomeCount07 + intSNPChromosomeCount08 + intSNPChromosomeCount09 + intSNPChromosomeCount10 + intSNPChromosomeCount11 + intSNPChromosomeCount12 + intSNPChromosomeCount13 + intSNPChromosomeCount14 + intSNPChromosomeCount15 + intSNPChromosomeCount16 + intSNPChromosomeCount17 + intSNPChromosomeCount18 + intSNPChromosomeCount19 + intSNPChromosomeCount20 + intSNPChromosomeCount21 + intSNPChromosomeCount22 + intSNPChromosomeCount23 + intSNPChromosomeCount24 + intSNPChromosomeCount25 + intSNPChromosomeCount26 + intSNPChromosomeCount27 + intSNPChromosomeCount28 + intSNPChromosomeCount32 + intSNPChromosomeCountLGE22C19W28_E50C23 + intSNPChromosomeCountLGE64 + intSNPChromosomeCountW + intSNPChromosomeCountZ;
        			
        			System.out.println(StringUtility.pad(totalRecordCount, 8, PAD_CHAR) + " updated rows from " + totalFileCount + " files in Directory " + directory );

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
