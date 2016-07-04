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

import com.roslin.mwicks.spring.variation.model.other.RatioData;

import com.roslin.mwicks.spring.variation.model.snpchromosome.SNPChromosome01;
import com.roslin.mwicks.spring.variation.model.snpchromosome.SNPChromosome02;
import com.roslin.mwicks.spring.variation.model.snpchromosome.SNPChromosome03;
import com.roslin.mwicks.spring.variation.model.snpchromosome.SNPChromosome04;
import com.roslin.mwicks.spring.variation.model.snpchromosome.SNPChromosome05;
import com.roslin.mwicks.spring.variation.model.snpchromosome.SNPChromosome06;
import com.roslin.mwicks.spring.variation.model.snpchromosome.SNPChromosome07;
import com.roslin.mwicks.spring.variation.model.snpchromosome.SNPChromosome08;
import com.roslin.mwicks.spring.variation.model.snpchromosome.SNPChromosome09;
import com.roslin.mwicks.spring.variation.model.snpchromosome.SNPChromosome10;
import com.roslin.mwicks.spring.variation.model.snpchromosome.SNPChromosome11;
import com.roslin.mwicks.spring.variation.model.snpchromosome.SNPChromosome12;
import com.roslin.mwicks.spring.variation.model.snpchromosome.SNPChromosome13;
import com.roslin.mwicks.spring.variation.model.snpchromosome.SNPChromosome14;
import com.roslin.mwicks.spring.variation.model.snpchromosome.SNPChromosome15;
import com.roslin.mwicks.spring.variation.model.snpchromosome.SNPChromosome16;
import com.roslin.mwicks.spring.variation.model.snpchromosome.SNPChromosome17;
import com.roslin.mwicks.spring.variation.model.snpchromosome.SNPChromosome18;
import com.roslin.mwicks.spring.variation.model.snpchromosome.SNPChromosome19;
import com.roslin.mwicks.spring.variation.model.snpchromosome.SNPChromosome20;
import com.roslin.mwicks.spring.variation.model.snpchromosome.SNPChromosome21;
import com.roslin.mwicks.spring.variation.model.snpchromosome.SNPChromosome22;
import com.roslin.mwicks.spring.variation.model.snpchromosome.SNPChromosome23;
import com.roslin.mwicks.spring.variation.model.snpchromosome.SNPChromosome24;
import com.roslin.mwicks.spring.variation.model.snpchromosome.SNPChromosome25;
import com.roslin.mwicks.spring.variation.model.snpchromosome.SNPChromosome26;
import com.roslin.mwicks.spring.variation.model.snpchromosome.SNPChromosome27;
import com.roslin.mwicks.spring.variation.model.snpchromosome.SNPChromosome28;
import com.roslin.mwicks.spring.variation.model.snpchromosome.SNPChromosome32;
import com.roslin.mwicks.spring.variation.model.snpchromosome.SNPChromosomeLGE22C19W28_E50C23;
import com.roslin.mwicks.spring.variation.model.snpchromosome.SNPChromosomeLGE64;
import com.roslin.mwicks.spring.variation.model.snpchromosome.SNPChromosomeW;
import com.roslin.mwicks.spring.variation.model.snpchromosome.SNPChromosomeZ;

import com.roslin.mwicks.spring.variation.routines.ConvertFiletoUpdateRatioDataList;

import com.roslin.mwicks.spring.variation.serviceinterface.snpchromosome.ServiceSNPChromosome01;
import com.roslin.mwicks.spring.variation.serviceinterface.snpchromosome.ServiceSNPChromosome02;
import com.roslin.mwicks.spring.variation.serviceinterface.snpchromosome.ServiceSNPChromosome03;
import com.roslin.mwicks.spring.variation.serviceinterface.snpchromosome.ServiceSNPChromosome04;
import com.roslin.mwicks.spring.variation.serviceinterface.snpchromosome.ServiceSNPChromosome05;
import com.roslin.mwicks.spring.variation.serviceinterface.snpchromosome.ServiceSNPChromosome06;
import com.roslin.mwicks.spring.variation.serviceinterface.snpchromosome.ServiceSNPChromosome07;
import com.roslin.mwicks.spring.variation.serviceinterface.snpchromosome.ServiceSNPChromosome08;
import com.roslin.mwicks.spring.variation.serviceinterface.snpchromosome.ServiceSNPChromosome09;
import com.roslin.mwicks.spring.variation.serviceinterface.snpchromosome.ServiceSNPChromosome10;
import com.roslin.mwicks.spring.variation.serviceinterface.snpchromosome.ServiceSNPChromosome11;
import com.roslin.mwicks.spring.variation.serviceinterface.snpchromosome.ServiceSNPChromosome12;
import com.roslin.mwicks.spring.variation.serviceinterface.snpchromosome.ServiceSNPChromosome13;
import com.roslin.mwicks.spring.variation.serviceinterface.snpchromosome.ServiceSNPChromosome14;
import com.roslin.mwicks.spring.variation.serviceinterface.snpchromosome.ServiceSNPChromosome15;
import com.roslin.mwicks.spring.variation.serviceinterface.snpchromosome.ServiceSNPChromosome16;
import com.roslin.mwicks.spring.variation.serviceinterface.snpchromosome.ServiceSNPChromosome17;
import com.roslin.mwicks.spring.variation.serviceinterface.snpchromosome.ServiceSNPChromosome18;
import com.roslin.mwicks.spring.variation.serviceinterface.snpchromosome.ServiceSNPChromosome19;
import com.roslin.mwicks.spring.variation.serviceinterface.snpchromosome.ServiceSNPChromosome20;
import com.roslin.mwicks.spring.variation.serviceinterface.snpchromosome.ServiceSNPChromosome21;
import com.roslin.mwicks.spring.variation.serviceinterface.snpchromosome.ServiceSNPChromosome22;
import com.roslin.mwicks.spring.variation.serviceinterface.snpchromosome.ServiceSNPChromosome23;
import com.roslin.mwicks.spring.variation.serviceinterface.snpchromosome.ServiceSNPChromosome24;
import com.roslin.mwicks.spring.variation.serviceinterface.snpchromosome.ServiceSNPChromosome25;
import com.roslin.mwicks.spring.variation.serviceinterface.snpchromosome.ServiceSNPChromosome26;
import com.roslin.mwicks.spring.variation.serviceinterface.snpchromosome.ServiceSNPChromosome27;
import com.roslin.mwicks.spring.variation.serviceinterface.snpchromosome.ServiceSNPChromosome28;
import com.roslin.mwicks.spring.variation.serviceinterface.snpchromosome.ServiceSNPChromosome32;
import com.roslin.mwicks.spring.variation.serviceinterface.snpchromosome.ServiceSNPChromosomeW;
import com.roslin.mwicks.spring.variation.serviceinterface.snpchromosome.ServiceSNPChromosomeZ;
import com.roslin.mwicks.spring.variation.serviceinterface.snpchromosome.ServiceSNPChromosomeLGE64;
import com.roslin.mwicks.spring.variation.serviceinterface.snpchromosome.ServiceSNPChromosomeLGE22C19W28_E50C23;

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
                
                ServiceSNPChromosome01 serviceSNPChromosome01 = (ServiceSNPChromosome01) applicationContext.getBean(ServiceSNPChromosome01.class);
                ServiceSNPChromosome02 serviceSNPChromosome02 = (ServiceSNPChromosome02) applicationContext.getBean(ServiceSNPChromosome02.class);
                ServiceSNPChromosome03 serviceSNPChromosome03 = (ServiceSNPChromosome03) applicationContext.getBean(ServiceSNPChromosome03.class);
                ServiceSNPChromosome04 serviceSNPChromosome04 = (ServiceSNPChromosome04) applicationContext.getBean(ServiceSNPChromosome04.class);
                ServiceSNPChromosome05 serviceSNPChromosome05 = (ServiceSNPChromosome05) applicationContext.getBean(ServiceSNPChromosome05.class);
                ServiceSNPChromosome06 serviceSNPChromosome06 = (ServiceSNPChromosome06) applicationContext.getBean(ServiceSNPChromosome06.class);
                ServiceSNPChromosome07 serviceSNPChromosome07 = (ServiceSNPChromosome07) applicationContext.getBean(ServiceSNPChromosome07.class);
                ServiceSNPChromosome08 serviceSNPChromosome08 = (ServiceSNPChromosome08) applicationContext.getBean(ServiceSNPChromosome08.class);
                ServiceSNPChromosome09 serviceSNPChromosome09 = (ServiceSNPChromosome09) applicationContext.getBean(ServiceSNPChromosome09.class);
                ServiceSNPChromosome10 serviceSNPChromosome10 = (ServiceSNPChromosome10) applicationContext.getBean(ServiceSNPChromosome10.class);
                ServiceSNPChromosome11 serviceSNPChromosome11 = (ServiceSNPChromosome11) applicationContext.getBean(ServiceSNPChromosome11.class);
                ServiceSNPChromosome12 serviceSNPChromosome12 = (ServiceSNPChromosome12) applicationContext.getBean(ServiceSNPChromosome12.class);
                ServiceSNPChromosome13 serviceSNPChromosome13 = (ServiceSNPChromosome13) applicationContext.getBean(ServiceSNPChromosome13.class);
                ServiceSNPChromosome14 serviceSNPChromosome14 = (ServiceSNPChromosome14) applicationContext.getBean(ServiceSNPChromosome14.class);
                ServiceSNPChromosome15 serviceSNPChromosome15 = (ServiceSNPChromosome15) applicationContext.getBean(ServiceSNPChromosome15.class);
                ServiceSNPChromosome16 serviceSNPChromosome16 = (ServiceSNPChromosome16) applicationContext.getBean(ServiceSNPChromosome16.class);
                ServiceSNPChromosome17 serviceSNPChromosome17 = (ServiceSNPChromosome17) applicationContext.getBean(ServiceSNPChromosome17.class);
                ServiceSNPChromosome18 serviceSNPChromosome18 = (ServiceSNPChromosome18) applicationContext.getBean(ServiceSNPChromosome18.class);
                ServiceSNPChromosome19 serviceSNPChromosome19 = (ServiceSNPChromosome19) applicationContext.getBean(ServiceSNPChromosome19.class);
                ServiceSNPChromosome20 serviceSNPChromosome20 = (ServiceSNPChromosome20) applicationContext.getBean(ServiceSNPChromosome20.class);
                ServiceSNPChromosome21 serviceSNPChromosome21 = (ServiceSNPChromosome21) applicationContext.getBean(ServiceSNPChromosome21.class);
                ServiceSNPChromosome22 serviceSNPChromosome22 = (ServiceSNPChromosome22) applicationContext.getBean(ServiceSNPChromosome22.class);
                ServiceSNPChromosome23 serviceSNPChromosome23 = (ServiceSNPChromosome23) applicationContext.getBean(ServiceSNPChromosome23.class);
                ServiceSNPChromosome24 serviceSNPChromosome24 = (ServiceSNPChromosome24) applicationContext.getBean(ServiceSNPChromosome24.class);
                ServiceSNPChromosome25 serviceSNPChromosome25 = (ServiceSNPChromosome25) applicationContext.getBean(ServiceSNPChromosome25.class);
                ServiceSNPChromosome26 serviceSNPChromosome26 = (ServiceSNPChromosome26) applicationContext.getBean(ServiceSNPChromosome26.class);
                ServiceSNPChromosome27 serviceSNPChromosome27 = (ServiceSNPChromosome27) applicationContext.getBean(ServiceSNPChromosome27.class);
                ServiceSNPChromosome28 serviceSNPChromosome28 = (ServiceSNPChromosome28) applicationContext.getBean(ServiceSNPChromosome28.class);
                ServiceSNPChromosome32 serviceSNPChromosome32 = (ServiceSNPChromosome32) applicationContext.getBean(ServiceSNPChromosome32.class);
                ServiceSNPChromosomeW serviceSNPChromosomeW = (ServiceSNPChromosomeW) applicationContext.getBean(ServiceSNPChromosomeW.class);
                ServiceSNPChromosomeZ serviceSNPChromosomeZ = (ServiceSNPChromosomeZ) applicationContext.getBean(ServiceSNPChromosomeZ.class);
                ServiceSNPChromosomeLGE64 serviceSNPChromosomeLGE64 = (ServiceSNPChromosomeLGE64) applicationContext.getBean(ServiceSNPChromosomeLGE64.class);
                ServiceSNPChromosomeLGE22C19W28_E50C23 serviceSNPChromosomeLGE22C19W28_E50C23 = (ServiceSNPChromosomeLGE22C19W28_E50C23) applicationContext.getBean(ServiceSNPChromosomeLGE22C19W28_E50C23.class);
               
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
                    	     			
                    	                List<SNPChromosome01> snpchromosome1List = new ArrayList<SNPChromosome01>();
                    	     			
                    	     			snpchromosome1List = serviceSNPChromosome01.findBySnpId(ratiodata.getSnpId());
                    	     			
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

                                    	        Iterator<SNPChromosome01> iteratorSNPChromosome01 = snpchromosome1List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome01.hasNext()) {

                                    	     		SNPChromosome01 snpchromosome = iteratorSNPChromosome01.next();
                                    	     		
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

                                    	     		serviceSNPChromosome01.update(snpchromosome);
                                    	     		
                                    	     		intSNPChromosomeCount01++;
                                    	     	}
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( ratiodata.isChromosome2() ) {
                    	     			
                    	                List<SNPChromosome02> snpchromosome2List = new ArrayList<SNPChromosome02>();
                    	     			
                    	     			snpchromosome2List = serviceSNPChromosome02.findBySnpId(ratiodata.getSnpId());
                    	     			
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

                                    	        Iterator<SNPChromosome02> iteratorSNPChromosome02 = snpchromosome2List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome02.hasNext()) {

                                    	     		SNPChromosome02 snpchromosome = iteratorSNPChromosome02.next();
                                    	     		
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

                                    	     		serviceSNPChromosome02.update(snpchromosome);
                                    	     		
                                    	     		intSNPChromosomeCount02++;
                                    	     	}
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( ratiodata.isChromosome3() ) {

                    	                List<SNPChromosome03> snpchromosome3List = new ArrayList<SNPChromosome03>();

                    	     			snpchromosome3List = serviceSNPChromosome03.findBySnpId(ratiodata.getSnpId());
                    	     			
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

                                    	        Iterator<SNPChromosome03> iteratorSNPChromosome03 = snpchromosome3List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome03.hasNext()) {

                                    	     		SNPChromosome03 snpchromosome = iteratorSNPChromosome03.next();

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

                                    	     		serviceSNPChromosome03.update(snpchromosome);

                                    	     		intSNPChromosomeCount03++;
                                    	        }
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( ratiodata.isChromosome4() ) {
                    	     			
                    	                List<SNPChromosome04> snpchromosome4List = new ArrayList<SNPChromosome04>();

                    	                snpchromosome4List = serviceSNPChromosome04.findBySnpId(ratiodata.getSnpId());
                    	                
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

                                    	        Iterator<SNPChromosome04> iteratorSNPChromosome04 = snpchromosome4List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome04.hasNext()) {

                                    	     		SNPChromosome04 snpchromosome = iteratorSNPChromosome04.next();

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

                                    	     		serviceSNPChromosome04.update(snpchromosome);
                                    	     		
                                    	     		intSNPChromosomeCount04++;
                                    	     	}
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( ratiodata.isChromosome5() ) {
                    	     			
                    	                List<SNPChromosome05> snpchromosome5List = new ArrayList<SNPChromosome05>();

                    	                snpchromosome5List = serviceSNPChromosome05.findBySnpId(ratiodata.getSnpId());
                    	                
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

                                    	        Iterator<SNPChromosome05> iteratorSNPChromosome05 = snpchromosome5List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome05.hasNext()) {

                                    	     		SNPChromosome05 snpchromosome = iteratorSNPChromosome05.next();

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

                                    	     		serviceSNPChromosome05.update(snpchromosome);
                                    	     		
                                    	     		intSNPChromosomeCount05++;
                                    	     	}
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( ratiodata.isChromosome6() ) {
                    	     			
                    	                List<SNPChromosome06> snpchromosome6List = new ArrayList<SNPChromosome06>();

                    	                snpchromosome6List = serviceSNPChromosome06.findBySnpId(ratiodata.getSnpId());
                    	                
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

                                    	        Iterator<SNPChromosome06> iteratorSNPChromosome06 = snpchromosome6List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome06.hasNext()) {

                                    	     		SNPChromosome06 snpchromosome = iteratorSNPChromosome06.next();

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

                                    	     		serviceSNPChromosome06.update(snpchromosome);
                                    	     		
                                    	     		intSNPChromosomeCount06++;
                                    	     	}
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( ratiodata.isChromosome7() ) {
                    	     			
                    	                List<SNPChromosome07> snpchromosome7List = new ArrayList<SNPChromosome07>();

                    	                snpchromosome7List = serviceSNPChromosome07.findBySnpId(ratiodata.getSnpId());
                    	                
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

                                    	        Iterator<SNPChromosome07> iteratorSNPChromosome07 = snpchromosome7List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome07.hasNext()) {

                                    	     		SNPChromosome07 snpchromosome = iteratorSNPChromosome07.next();

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

                                    	     		serviceSNPChromosome07.update(snpchromosome);
                                    	     		
                                    	     		intSNPChromosomeCount07++;
                                    	     	}
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( ratiodata.isChromosome8() ) {

                    	                List<SNPChromosome08> snpchromosome8List = new ArrayList<SNPChromosome08>();

                    	     			snpchromosome8List = serviceSNPChromosome08.findBySnpId(ratiodata.getSnpId());
                    	     			
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

                                    	        Iterator<SNPChromosome08> iteratorSNPChromosome08 = snpchromosome8List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome08.hasNext()) {

                                    	     		SNPChromosome08 snpchromosome = iteratorSNPChromosome08.next();

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

                                    	     		serviceSNPChromosome08.update(snpchromosome);
                                    	     		
                                    	     		intSNPChromosomeCount08++;
                                    	     	}
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( ratiodata.isChromosome9() ) {

                    	                List<SNPChromosome09> snpchromosome9List = new ArrayList<SNPChromosome09>();

                    	     			snpchromosome9List = serviceSNPChromosome09.findBySnpId(ratiodata.getSnpId());
                    	     			
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

                                    	        Iterator<SNPChromosome09> iteratorSNPChromosome09 = snpchromosome9List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome09.hasNext()) {

                                    	     		SNPChromosome09 snpchromosome = iteratorSNPChromosome09.next();

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

                                    	     		serviceSNPChromosome09.update(snpchromosome);
                                    	     		
                                    	     		intSNPChromosomeCount09++;
                                    	     	}
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( ratiodata.isChromosome10() ) {

                    	                List<SNPChromosome10> snpchromosome10List = new ArrayList<SNPChromosome10>();

                    	     			snpchromosome10List = serviceSNPChromosome10.findBySnpId(ratiodata.getSnpId());
                    	     			
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

                                    	        Iterator<SNPChromosome10> iteratorSNPChromosome10 = snpchromosome10List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome10.hasNext()) {

                                    	     		SNPChromosome10 snpchromosome = iteratorSNPChromosome10.next();

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

                                    	     		serviceSNPChromosome10.update(snpchromosome);
                                    	     		
                                    	     		intSNPChromosomeCount10++;
                                    	     	}
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( ratiodata.isChromosome11() ) {
                    	     			
                    	                List<SNPChromosome11> snpchromosome11List = new ArrayList<SNPChromosome11>();

                    	     			snpchromosome11List = serviceSNPChromosome11.findBySnpId(ratiodata.getSnpId());
                    	     			
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

                                    	        Iterator<SNPChromosome11> iteratorSNPChromosome11 = snpchromosome11List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome11.hasNext()) {

                                    	     		SNPChromosome11 snpchromosome = iteratorSNPChromosome11.next();

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

                                    	     		serviceSNPChromosome11.update(snpchromosome);
                                    	     		
                                    	     		intSNPChromosomeCount11++;
                                    	     	}
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( ratiodata.isChromosome12() ) {
                    	     			
                    	                List<SNPChromosome12> snpchromosome12List = new ArrayList<SNPChromosome12>();

                    	                snpchromosome12List = serviceSNPChromosome12.findBySnpId(ratiodata.getSnpId());
                    	                
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

                                    	        Iterator<SNPChromosome12> iteratorSNPChromosome12 = snpchromosome12List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome12.hasNext()) {

                                    	     		SNPChromosome12 snpchromosome = iteratorSNPChromosome12.next();

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

                                    	     		serviceSNPChromosome12.update(snpchromosome);
                                    	     		
                                    	     		intSNPChromosomeCount12++;
                                    	     	}
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( ratiodata.isChromosome13() ) {
                    	     			
                    	                List<SNPChromosome13> snpchromosome13List = new ArrayList<SNPChromosome13>();

                    	                snpchromosome13List = serviceSNPChromosome13.findBySnpId(ratiodata.getSnpId());

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

                            	     			Iterator<SNPChromosome13> iteratorSNPChromosome13 = snpchromosome13List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome13.hasNext()) {

                                    	     		SNPChromosome13 snpchromosome = iteratorSNPChromosome13.next();

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

                                    	     		serviceSNPChromosome13.update(snpchromosome);
                                    	     		
                                    	     		intSNPChromosomeCount13++;
                                    	     	}
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( ratiodata.isChromosome14() ) {
                    	     			
                    	                List<SNPChromosome14> snpchromosome14List = new ArrayList<SNPChromosome14>();

                    	                snpchromosome14List = serviceSNPChromosome14.findBySnpId(ratiodata.getSnpId());
                    	                
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

                                    	        Iterator<SNPChromosome14> iteratorSNPChromosome14 = snpchromosome14List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome14.hasNext()) {

                                    	     		SNPChromosome14 snpchromosome = iteratorSNPChromosome14.next();

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

                                    	     		serviceSNPChromosome14.update(snpchromosome);
                                    	     		
                                    	     		intSNPChromosomeCount14++;
                                    	     	}
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( ratiodata.isChromosome15() ) {
                    	     			
                    	                List<SNPChromosome15> snpchromosome15List = new ArrayList<SNPChromosome15>();

                    	                snpchromosome15List = serviceSNPChromosome15.findBySnpId(ratiodata.getSnpId());
                    	                
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

                                    	        Iterator<SNPChromosome15> iteratorSNPChromosome15 = snpchromosome15List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome15.hasNext()) {

                                    	     		SNPChromosome15 snpchromosome = iteratorSNPChromosome15.next();

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

                                    	     		serviceSNPChromosome15.update(snpchromosome);
                                    	     		
                                    	     		intSNPChromosomeCount15++;
                                    	     	}
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( ratiodata.isChromosome16() ) {

                    	                List<SNPChromosome16> snpchromosome16List = new ArrayList<SNPChromosome16>();

                    	     			snpchromosome16List = serviceSNPChromosome16.findBySnpId(ratiodata.getSnpId());
                    	     			
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

                                    	        Iterator<SNPChromosome16> iteratorSNPChromosome16 = snpchromosome16List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome16.hasNext()) {

                                    	     		SNPChromosome16 snpchromosome = iteratorSNPChromosome16.next();

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

                                    	     		serviceSNPChromosome16.update(snpchromosome);
                                    	     		
                                    	     		intSNPChromosomeCount16++;
                                    	     	}
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( ratiodata.isChromosome17() ) {
                    	     			
                    	                List<SNPChromosome17> snpchromosome17List = new ArrayList<SNPChromosome17>();

                    	     			snpchromosome17List = serviceSNPChromosome17.findBySnpId(ratiodata.getSnpId());
                    	     			
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

                                    	        Iterator<SNPChromosome17> iteratorSNPChromosome17 = snpchromosome17List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome17.hasNext()) {

                                    	     		SNPChromosome17 snpchromosome = iteratorSNPChromosome17.next();

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

                                    	     		serviceSNPChromosome17.update(snpchromosome);
                                    	     		
                                    	     		intSNPChromosomeCount17++;
                                    	     	}
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( ratiodata.isChromosome18() ) {

                    	                List<SNPChromosome18> snpchromosome18List = new ArrayList<SNPChromosome18>();

                    	     			snpchromosome18List = serviceSNPChromosome18.findBySnpId(ratiodata.getSnpId());
                    	     			
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

                                    	        Iterator<SNPChromosome18> iteratorSNPChromosome18 = snpchromosome18List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome18.hasNext()) {

                                    	     		SNPChromosome18 snpchromosome = iteratorSNPChromosome18.next();

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

                                    	     		serviceSNPChromosome18.update(snpchromosome);
                                    	     		
                                    	     		intSNPChromosomeCount18++;
                                    	     	}
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( ratiodata.isChromosome19() ) {

                    	                List<SNPChromosome19> snpchromosome19List = new ArrayList<SNPChromosome19>();

                    	     			snpchromosome19List = serviceSNPChromosome19.findBySnpId(ratiodata.getSnpId());
                    	     			
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

                                    	        Iterator<SNPChromosome19> iteratorSNPChromosome19 = snpchromosome19List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome19.hasNext()) {

                                    	     		SNPChromosome19 snpchromosome = iteratorSNPChromosome19.next();

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

                                    	     		serviceSNPChromosome19.update(snpchromosome);
                                    	     		
                                    	     		intSNPChromosomeCount19++;
                                    	     	}
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( ratiodata.isChromosome20() ) {
                    	     			
                    	                List<SNPChromosome20> snpchromosome20List = new ArrayList<SNPChromosome20>();

                    	     			snpchromosome20List = serviceSNPChromosome20.findBySnpId(ratiodata.getSnpId());
                    	     			
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

                                    	        Iterator<SNPChromosome20> iteratorSNPChromosome20 = snpchromosome20List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome20.hasNext()) {

                                    	     		SNPChromosome20 snpchromosome = iteratorSNPChromosome20.next();

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

                                    	     		serviceSNPChromosome20.update(snpchromosome);
                                    	     		
                                    	     		intSNPChromosomeCount20++;
                                    	     	}
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( ratiodata.isChromosome21() ) {

                    	                List<SNPChromosome21> snpchromosome21List = new ArrayList<SNPChromosome21>();

                    	     			snpchromosome21List = serviceSNPChromosome21.findBySnpId(ratiodata.getSnpId());
                    	     			
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

                                    	        Iterator<SNPChromosome21> iteratorSNPChromosome21 = snpchromosome21List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome21.hasNext()) {

                                    	     		SNPChromosome21 snpchromosome = iteratorSNPChromosome21.next();

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

                                    	     		serviceSNPChromosome21.update(snpchromosome);
                                    	     		
                                    	     		intSNPChromosomeCount21++;
                                    	        }
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( ratiodata.isChromosome22() ) {

                    	                List<SNPChromosome22> snpchromosome22List = new ArrayList<SNPChromosome22>();

                    	     			snpchromosome22List = serviceSNPChromosome22.findBySnpId(ratiodata.getSnpId());
                    	     			
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

                                    	        Iterator<SNPChromosome22> iteratorSNPChromosome22 = snpchromosome22List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome22.hasNext()) {

                                    	     		SNPChromosome22 snpchromosome = iteratorSNPChromosome22.next();

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

                                    	     		serviceSNPChromosome22.update(snpchromosome);
                                    	     		
                                    	     		intSNPChromosomeCount22++;
                                    	     	}
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( ratiodata.isChromosome23() ) {
                    	     			
                    	                List<SNPChromosome23> snpchromosome23List = new ArrayList<SNPChromosome23>();
                    	                
                    	                snpchromosome23List = serviceSNPChromosome23.findBySnpId(ratiodata.getSnpId());
                    	                
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

                                    	        Iterator<SNPChromosome23> iteratorSNPChromosome23 = snpchromosome23List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome23.hasNext()) {

                                    	     		SNPChromosome23 snpchromosome = iteratorSNPChromosome23.next();

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

                                    	     		serviceSNPChromosome23.update(snpchromosome);
                                    	     		
                                    	     		intSNPChromosomeCount23++;
                                    	     	}
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( ratiodata.isChromosome24() ) {
                    	     			
                    	     			List<SNPChromosome24> snpchromosome24List = new ArrayList<SNPChromosome24>();

                    	                snpchromosome24List = serviceSNPChromosome24.findBySnpId(ratiodata.getSnpId());
                    	                
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

                                    	        Iterator<SNPChromosome24> iteratorSNPChromosome24 = snpchromosome24List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome24.hasNext()) {

                                    	     		SNPChromosome24 snpchromosome = iteratorSNPChromosome24.next();

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

                                    	     		serviceSNPChromosome24.update(snpchromosome);
                                    	     		
                                    	     		intSNPChromosomeCount24++;
                                    	     	}
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( ratiodata.isChromosome25() ) {
                    	     			
                    	                List<SNPChromosome25> snpchromosome25List = new ArrayList<SNPChromosome25>();

                    	     			snpchromosome25List = serviceSNPChromosome25.findBySnpId(ratiodata.getSnpId());
                    	     			
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

                                    	        Iterator<SNPChromosome25> iteratorSNPChromosome25 = snpchromosome25List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome25.hasNext()) {

                                    	     		SNPChromosome25 snpchromosome = iteratorSNPChromosome25.next();

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

                                    	     		serviceSNPChromosome25.update(snpchromosome);
                                    	     		
                                    	     		intSNPChromosomeCount25++;
                                    	     	}
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( ratiodata.isChromosome26() ) {

                    	                List<SNPChromosome26> snpchromosome26List = new ArrayList<SNPChromosome26>();

                    	     			snpchromosome26List = serviceSNPChromosome26.findBySnpId(ratiodata.getSnpId());
                    	     			
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
                            	     			
                                    	        Iterator<SNPChromosome26> iteratorSNPChromosome26 = snpchromosome26List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome26.hasNext()) {

                                    	     		SNPChromosome26 snpchromosome = iteratorSNPChromosome26.next();

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

                                    	     		serviceSNPChromosome26.update(snpchromosome);
                                    	     		
                                    	     		intSNPChromosomeCount26++;
                                    	     	}
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( ratiodata.isChromosome27() ) {
                    	     			
                    	                List<SNPChromosome27> snpchromosome27List = new ArrayList<SNPChromosome27>();

                    	     			snpchromosome27List = serviceSNPChromosome27.findBySnpId(ratiodata.getSnpId());
                    	     			
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

                                    	        Iterator<SNPChromosome27> iteratorSNPChromosome27 = snpchromosome27List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome27.hasNext()) {

                                    	     		SNPChromosome27 snpchromosome = iteratorSNPChromosome27.next();

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

                                    	     		serviceSNPChromosome27.update(snpchromosome);
                                    	     		
                                    	     		intSNPChromosomeCount27++;
                                    	     	}
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( ratiodata.isChromosome28() ) {

                    	                List<SNPChromosome28> snpchromosome28List = new ArrayList<SNPChromosome28>();

                    	     			snpchromosome28List = serviceSNPChromosome28.findBySnpId(ratiodata.getSnpId());
                    	     			
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

                                    	        Iterator<SNPChromosome28> iteratorSNPChromosome28 = snpchromosome28List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome28.hasNext()) {

                                    	     		SNPChromosome28 snpchromosome = iteratorSNPChromosome28.next();

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

                                    	     		serviceSNPChromosome28.update(snpchromosome);
                                    	     		
                                    	     		intSNPChromosomeCount28++;
                                    	     	}
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( ratiodata.isChromosome32() ) {
                    	     			
                    	                List<SNPChromosome32> snpchromosome32List = new ArrayList<SNPChromosome32>();

                    	     			snpchromosome32List = serviceSNPChromosome32.findBySnpId(ratiodata.getSnpId());
                    	     			
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

                                    	        Iterator<SNPChromosome32> iteratorSNPChromosome32 = snpchromosome32List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome32.hasNext()) {

                                    	     		SNPChromosome32 snpchromosome = iteratorSNPChromosome32.next();

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

                                    	     		serviceSNPChromosome32.update(snpchromosome);
                                    	     		
                                    	     		intSNPChromosomeCount32++;
                                    	     	}
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( ratiodata.isChromosomeLGE64() ) {
                    	     			
                    	                List<SNPChromosomeLGE64> snpchromosomeLGE64List = new ArrayList<SNPChromosomeLGE64>();

                    	     			snpchromosomeLGE64List = serviceSNPChromosomeLGE64.findBySnpId(ratiodata.getSnpId());
                    	     			
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
                        	     				

                                    	        Iterator<SNPChromosomeLGE64> iteratorSNPChromosomeLGE64 = snpchromosomeLGE64List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosomeLGE64.hasNext()) {

                                    	     		SNPChromosomeLGE64 snpchromosome = iteratorSNPChromosomeLGE64.next();

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

                                    	     		serviceSNPChromosomeLGE64.update(snpchromosome);
                                    	     		
                                    	     		intSNPChromosomeCountLGE64++;
                                    	     	}
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( ratiodata.isChromosomeLGE22C19W28_E50C23() ) {
                    	     			
                    	                List<SNPChromosomeLGE22C19W28_E50C23> snpchromosomeLGE22C19W28_E50C23List = new ArrayList<SNPChromosomeLGE22C19W28_E50C23>();

                    	     			snpchromosomeLGE22C19W28_E50C23List = serviceSNPChromosomeLGE22C19W28_E50C23.findBySnpId(ratiodata.getSnpId());
                    	     			
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
                        	     				
                                    	        Iterator<SNPChromosomeLGE22C19W28_E50C23> iteratorSNPChromosomeLGE22C19W28_E50C23 = snpchromosomeLGE22C19W28_E50C23List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosomeLGE22C19W28_E50C23.hasNext()) {

                                    	     		SNPChromosomeLGE22C19W28_E50C23 snpchromosome = iteratorSNPChromosomeLGE22C19W28_E50C23.next();

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

                                    	     		serviceSNPChromosomeLGE22C19W28_E50C23.update(snpchromosome);
                                    	     		
                                    	     		intSNPChromosomeCountLGE22C19W28_E50C23++;
                                    	     	}
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( ratiodata.isChromosomeW() ) {
                    	     			
                    	                List<SNPChromosomeW> snpchromosomeWList = new ArrayList<SNPChromosomeW>();

                    	     			snpchromosomeWList = serviceSNPChromosomeW.findBySnpId(ratiodata.getSnpId());
                    	     			
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

                                    	        Iterator<SNPChromosomeW> iteratorSNPChromosomeW = snpchromosomeWList.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosomeW.hasNext()) {

                                    	     		SNPChromosomeW snpchromosome = iteratorSNPChromosomeW.next();

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

                                    	     		serviceSNPChromosomeW.update(snpchromosome);
                                    	     		
                                    	     		intSNPChromosomeCountW++;
                                    	     	}                        	     			}
                    	     			}
                    	     		}

                    	     		if ( ratiodata.isChromosomeZ() ) {
                    	     			
                    	                List<SNPChromosomeZ> snpchromosomeZList = new ArrayList<SNPChromosomeZ>();

                    	     			snpchromosomeZList = serviceSNPChromosomeZ.findBySnpId(ratiodata.getSnpId());
                    	     			
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
                        	     				
                                    	        Iterator<SNPChromosomeZ> iteratorSNPChromosomeZ = snpchromosomeZList.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosomeZ.hasNext()) {

                                    	     		SNPChromosomeZ snpchromosome = iteratorSNPChromosomeZ.next();
                                    	     		
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

                                    	     		serviceSNPChromosomeZ.update(snpchromosome);
                                    	     		
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
