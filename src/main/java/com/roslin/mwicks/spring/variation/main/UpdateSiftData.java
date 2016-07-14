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

import com.roslin.mwicks.spring.variation.model.snpchromosome.SNPChromosome;

import com.roslin.mwicks.spring.variation.model.other.SiftData;

import com.roslin.mwicks.spring.variation.routines.ConvertFiletoUpdateSiftDataList;

import com.roslin.mwicks.spring.variation.serviceinterface.snpchromosome.ServiceSNPChromosome;

import com.roslin.mwicks.utility.FileUtil;
import com.roslin.mwicks.utility.ObjectConverter;
import com.roslin.mwicks.utility.StringUtility;
import com.roslin.mwicks.utility.Wrapper;


public class UpdateSiftData {

	// Constants ----------------------------------------------------------------------------------
    private static final String MSGLEVEL = "*";
	private static final String STOP = "*";
	
	private static final char PAD_CHAR = ' ';

    public static final Logger LOG = LoggerFactory.getLogger(UpdateSiftData.class);

    @PersistenceContext
    private EntityManager entityManager;
     

    public static void main(String args[]){  

    	try {

        	LOG.trace("InsertSiftData - main");

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

                File errorFile = new File("/Users/mwicks23/Desktop/Sift/error_sift.txt");

                List<String> errorRecords = new ArrayList<String>();

        		String directory = args[0];
        		
                File dir = new File(directory);

                if ( dir.exists() ) {
                	
            		File[] filesFile = FileUtil.listAllFilesInDirectory(directory);
            		
            		int totalRecordCount = 0;
            		int totalFileCount = 0;
            		
                    int siftdataTotal = 0;

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

                            List<SiftData> siftdataList = ConvertFiletoUpdateSiftDataList.run(file, MSGLEVEL, MSGLEVEL);
 
                            totalRecordCount = totalRecordCount +  siftdataList.size();
                            
                			Wrapper.printMessage(StringUtility.pad(totalFileCount, 3, PAD_CHAR) + " : Directory : " + directory + " : " + file.getName() + " : records : " + StringUtility.pad(siftdataList.size(), 8, PAD_CHAR), MSGLEVEL, MSGLEVEL);

                	     	siftdataTotal = siftdataTotal + siftdataList.size();
                	     	
                	        Iterator<SiftData> iteratorSiftData = siftdataList.iterator();
                	        
                	     	while (iteratorSiftData.hasNext()) {
                	    		
                	     		SiftData siftdata = iteratorSiftData.next();
                	     		
                	     		if ( !siftdata.isThisAValidSiftData() ) {
                	     			
            	     				error++;

            	     				String errorRecord = "INVALID SIFT DATA!\t" + siftdata.getSnpId() + "\t" +
            	     						siftdata.getEnsemblGene() + "\t" +
            	     						siftdata.getEnsemblTranscript() + "\t" +
            	     						siftdata.getEnsemblAnnotation() + "\t" +
            	     						siftdata.getAminoAcidSubs() + "\t" +
            	     						siftdata.getPredictionCategory() + "\t" +
            	     						siftdata.getScoreSift() + "\t" +
            	     						siftdata.getScoreConservation() + "\t" +
            	     						siftdata.getProteinAlignNumber() + "\t" +
            	     						siftdata.getTotalAlignSequenceNumber();

            	     				errorRecords.add(errorRecord);
            	     				//Wrapper.printMessage("Error No. " + error + " : SNP Id. " + siftdata.getSnpId() + " UNKNOWN CHROMOSOME : " + siftdata.toString(), MSGLEVEL, MSGLEVEL);
                	     		}
                	     		else {
                	     			
                    	     		if ( siftdata.isChromosome1() ) {
                    	     			
                    	                List<SNPChromosome> snpchromosome1List = new ArrayList<SNPChromosome>();
                    	     			
                    	     			snpchromosome1List = serviceSNPChromosome.findBySnpId(siftdata.getSnpId());
                    	     			
                    	     			if ( snpchromosome1List.isEmpty() ) {
                    	     				
                    	     				error++;

                    	     				String errorRecord = "SNP NOT FOUND!\t" + 
                    	     				        siftdata.getSnpId() + "\t" +
                    	     						siftdata.getEnsemblGene() + "\t" +
                    	     						siftdata.getEnsemblTranscript() + "\t" +
                    	     						siftdata.getEnsemblAnnotation() + "\t" +
                    	     						siftdata.getAminoAcidSubs() + "\t" +
                    	     						siftdata.getPredictionCategory() + "\t" +
                    	     						siftdata.getScoreSift() + "\t" +
                    	     						siftdata.getScoreConservation() + "\t" +
                    	     						siftdata.getProteinAlignNumber() + "\t" +
                    	     						siftdata.getTotalAlignSequenceNumber();

                    	     				errorRecords.add(errorRecord);
                    	     				//Wrapper.printMessage("Error No. " + error + " : SNP Id. " + siftdata.getSnpId() + " NOT FOUND : " + siftdata.toString(), MSGLEVEL, MSGLEVEL);
                    	     			}
                    	     			else {

                        	     			if ( snpchromosome1List.size() > 1 ) {
                        	     				
                        	     				error++;

                        	     				String errorRecord = "SNP NOT FOUND!\t" + siftdata.getSnpId() + "\t" +
                        	     						siftdata.getEnsemblGene() + "\t" +
                        	     						siftdata.getEnsemblTranscript() + "\t" +
                        	     						siftdata.getEnsemblAnnotation() + "\t" +
                        	     						siftdata.getAminoAcidSubs() + "\t" +
                        	     						siftdata.getPredictionCategory() + "\t" +
                        	     						siftdata.getScoreSift() + "\t" +
                        	     						siftdata.getScoreConservation() + "\t" +
                        	     						siftdata.getProteinAlignNumber() + "\t" +
                        	     						siftdata.getTotalAlignSequenceNumber();

                        	     				errorRecords.add(errorRecord);

                        	     				//Wrapper.printMessage("Error No. " + error + " : SNP Id. " + siftdata.getSnpId() + " GREATER THAN 1 ROW FOR : " + siftdata.toString(), MSGLEVEL, MSGLEVEL);
                        	     			}
                        	     			else {

                                    	        Iterator<SNPChromosome> iteratorSNPChromosome = snpchromosome1List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome.hasNext()) {

                                    	     		SNPChromosome snpchromosome01 = iteratorSNPChromosome.next();
                                    	     		
                                    	     		snpchromosome01.setAminoAcidSubs(siftdata.getAminoAcidSubs());
                                    	     		snpchromosome01.setPredictionCategory(siftdata.getPredictionCategory());
                                    	     		snpchromosome01.setScoreSift(siftdata.getScoreSift());
                                    	     		snpchromosome01.setScoreConservation(siftdata.getScoreConservation());
                                    	     		snpchromosome01.setProteinAlignNumber(siftdata.getProteinAlignNumber());
                                    	     		snpchromosome01.setTotalAlignSequenceNumber(siftdata.getTotalAlignSequenceNumber());

                                    	     		serviceSNPChromosome.update(snpchromosome01);
                                    	     		
                                    	     		intSNPChromosomeCount01++;
                                    	     	}
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( siftdata.isChromosome2() ) {
                    	     			
                    	                List<SNPChromosome> snpchromosome2List = new ArrayList<SNPChromosome>();
                    	     			
                    	     			snpchromosome2List = serviceSNPChromosome.findBySnpId(siftdata.getSnpId());
                    	     			
                    	     			if ( snpchromosome2List.isEmpty() ) {
                    	     				
                    	     				error++;

                    	     				String errorRecord = "SNP NOT FOUND!\t" + siftdata.getSnpId() + "\t" +
                    	     						siftdata.getEnsemblGene() + "\t" +
                    	     						siftdata.getEnsemblTranscript() + "\t" +
                    	     						siftdata.getEnsemblAnnotation() + "\t" +
                    	     						siftdata.getAminoAcidSubs() + "\t" +
                    	     						siftdata.getPredictionCategory() + "\t" +
                    	     						siftdata.getScoreSift() + "\t" +
                    	     						siftdata.getScoreConservation() + "\t" +
                    	     						siftdata.getProteinAlignNumber() + "\t" +
                    	     						siftdata.getTotalAlignSequenceNumber();

                    	     				errorRecords.add(errorRecord);

                    	     				//Wrapper.printMessage("Error No. " + error + " : SNP Id. " + siftdata.getSnpId() + " NOT FOUND : " + siftdata.toString(), MSGLEVEL, MSGLEVEL);
                    	     			}
                    	     			else {

                        	     			if ( snpchromosome2List.size() > 1 ) {
                        	     				
                        	     				error++;

                        	     				String errorRecord = "MULTIPLE SNPs!\t" + siftdata.getSnpId() + "\t" +
                        	     						siftdata.getEnsemblGene() + "\t" +
                        	     						siftdata.getEnsemblTranscript() + "\t" +
                        	     						siftdata.getEnsemblAnnotation() + "\t" +
                        	     						siftdata.getAminoAcidSubs() + "\t" +
                        	     						siftdata.getPredictionCategory() + "\t" +
                        	     						siftdata.getScoreSift() + "\t" +
                        	     						siftdata.getScoreConservation() + "\t" +
                        	     						siftdata.getProteinAlignNumber() + "\t" +
                        	     						siftdata.getTotalAlignSequenceNumber();

                        	     				errorRecords.add(errorRecord);

                        	     				//Wrapper.printMessage("Error No. " + error + " : SNP Id. " + siftdata.getSnpId() + " GREATER THAN 1 ROW FOR : " + siftdata.toString(), MSGLEVEL, MSGLEVEL);
                        	     			}
                        	     			else {

                                    	        Iterator<SNPChromosome> iteratorSNPChromosome = snpchromosome2List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome.hasNext()) {

                                    	     		SNPChromosome snpchromosome02 = iteratorSNPChromosome.next();
                                    	     		
                                    	     		snpchromosome02.setAminoAcidSubs(siftdata.getAminoAcidSubs());
                                    	     		snpchromosome02.setPredictionCategory(siftdata.getPredictionCategory());
                                    	     		snpchromosome02.setScoreSift(siftdata.getScoreSift());
                                    	     		snpchromosome02.setScoreConservation(siftdata.getScoreConservation());
                                    	     		snpchromosome02.setProteinAlignNumber(siftdata.getProteinAlignNumber());
                                    	     		snpchromosome02.setTotalAlignSequenceNumber(siftdata.getTotalAlignSequenceNumber());

                                    	     		serviceSNPChromosome.update(snpchromosome02);
                                    	     		
                                    	     		intSNPChromosomeCount02++;
                                    	     	}
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( siftdata.isChromosome3() ) {

                    	                List<SNPChromosome> snpchromosome3List = new ArrayList<SNPChromosome>();

                    	     			snpchromosome3List = serviceSNPChromosome.findBySnpId(siftdata.getSnpId());
                    	     			
                    	     			if ( snpchromosome3List.isEmpty() ) {
                    	     				
                    	     				error++;

                    	     				String errorRecord = "SNP NOT FOUND!\t" + siftdata.getSnpId() + "\t" +
                    	     						siftdata.getEnsemblGene() + "\t" +
                    	     						siftdata.getEnsemblTranscript() + "\t" +
                    	     						siftdata.getEnsemblAnnotation() + "\t" +
                    	     						siftdata.getAminoAcidSubs() + "\t" +
                    	     						siftdata.getPredictionCategory() + "\t" +
                    	     						siftdata.getScoreSift() + "\t" +
                    	     						siftdata.getScoreConservation() + "\t" +
                    	     						siftdata.getProteinAlignNumber() + "\t" +
                    	     						siftdata.getTotalAlignSequenceNumber();

                    	     				errorRecords.add(errorRecord);

                    	     				//Wrapper.printMessage("Error No. " + error + " : SNP Id. " + siftdata.getSnpId() + " NOT FOUND : " + siftdata.toString(), MSGLEVEL, MSGLEVEL);
                    	     			}
                    	     			else {

                        	     			if ( snpchromosome3List.size() > 1 ) {
                        	     				
                        	     				error++;

                        	     				String errorRecord = "MULTIPLE SNPs!\t" + siftdata.getSnpId() + "\t" +
                        	     						siftdata.getEnsemblGene() + "\t" +
                        	     						siftdata.getEnsemblTranscript() + "\t" +
                        	     						siftdata.getEnsemblAnnotation() + "\t" +
                        	     						siftdata.getAminoAcidSubs() + "\t" +
                        	     						siftdata.getPredictionCategory() + "\t" +
                        	     						siftdata.getScoreSift() + "\t" +
                        	     						siftdata.getScoreConservation() + "\t" +
                        	     						siftdata.getProteinAlignNumber() + "\t" +
                        	     						siftdata.getTotalAlignSequenceNumber();

                        	     				errorRecords.add(errorRecord);

                        	     				//Wrapper.printMessage("Error No. " + error + " : SNP Id. " + siftdata.getSnpId() + " GREATER THAN 1 ROW FOR : " + siftdata.toString(), MSGLEVEL, MSGLEVEL);
                        	     			}
                        	     			else {

                                    	        Iterator<SNPChromosome> iteratorSNPChromosome = snpchromosome3List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome.hasNext()) {

                                    	     		SNPChromosome snpchromosome03 = iteratorSNPChromosome.next();
                                    	     		
                                    	     		snpchromosome03.setAminoAcidSubs(siftdata.getAminoAcidSubs());
                                    	     		snpchromosome03.setPredictionCategory(siftdata.getPredictionCategory());
                                    	     		snpchromosome03.setScoreSift(siftdata.getScoreSift());
                                    	     		snpchromosome03.setScoreConservation(siftdata.getScoreConservation());
                                    	     		snpchromosome03.setProteinAlignNumber(siftdata.getProteinAlignNumber());
                                    	     		snpchromosome03.setTotalAlignSequenceNumber(siftdata.getTotalAlignSequenceNumber());

                                    	     		serviceSNPChromosome.update(snpchromosome03);

                                    	     		intSNPChromosomeCount03++;
                                    	        }
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( siftdata.isChromosome4() ) {
                    	     			
                    	                List<SNPChromosome> snpchromosome4List = new ArrayList<SNPChromosome>();

                    	                snpchromosome4List = serviceSNPChromosome.findBySnpId(siftdata.getSnpId());
                    	                
                    	     			if ( snpchromosome4List.isEmpty() ) {
                    	     				
                    	     				error++;

                    	     				String errorRecord = "SNP NOT FOUND!\t" + siftdata.getSnpId() + "\t" +
                    	     						siftdata.getEnsemblGene() + "\t" +
                    	     						siftdata.getEnsemblTranscript() + "\t" +
                    	     						siftdata.getEnsemblAnnotation() + "\t" +
                    	     						siftdata.getAminoAcidSubs() + "\t" +
                    	     						siftdata.getPredictionCategory() + "\t" +
                    	     						siftdata.getScoreSift() + "\t" +
                    	     						siftdata.getScoreConservation() + "\t" +
                    	     						siftdata.getProteinAlignNumber() + "\t" +
                    	     						siftdata.getTotalAlignSequenceNumber();

                    	     				errorRecords.add(errorRecord);

                    	     				//Wrapper.printMessage("Error No. " + error + " : SNP Id. " + siftdata.getSnpId() + " NOT FOUND : " + siftdata.toString(), MSGLEVEL, MSGLEVEL);
                    	     			}
                    	     			else {

                        	     			if ( snpchromosome4List.size() > 1 ) {
                        	     				
                        	     				error++;

                        	     				String errorRecord = "MULTIPLE SNPs!\t" + siftdata.getSnpId() + "\t" +
                        	     						siftdata.getEnsemblGene() + "\t" +
                        	     						siftdata.getEnsemblTranscript() + "\t" +
                        	     						siftdata.getEnsemblAnnotation() + "\t" +
                        	     						siftdata.getAminoAcidSubs() + "\t" +
                        	     						siftdata.getPredictionCategory() + "\t" +
                        	     						siftdata.getScoreSift() + "\t" +
                        	     						siftdata.getScoreConservation() + "\t" +
                        	     						siftdata.getProteinAlignNumber() + "\t" +
                        	     						siftdata.getTotalAlignSequenceNumber();

                        	     				errorRecords.add(errorRecord);

                        	     				//Wrapper.printMessage("Error No. " + error + " : SNP Id. " + siftdata.getSnpId() + " GREATER THAN 1 ROW FOR : " + siftdata.toString(), MSGLEVEL, MSGLEVEL);
                        	     			}
                        	     			else {

                                    	        Iterator<SNPChromosome> iteratorSNPChromosome = snpchromosome4List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome.hasNext()) {

                                    	     		SNPChromosome snpchromosome04 = iteratorSNPChromosome.next();
                                    	     		
                                    	     		snpchromosome04.setAminoAcidSubs(siftdata.getAminoAcidSubs());
                                    	     		snpchromosome04.setPredictionCategory(siftdata.getPredictionCategory());
                                    	     		snpchromosome04.setScoreSift(siftdata.getScoreSift());
                                    	     		snpchromosome04.setScoreConservation(siftdata.getScoreConservation());
                                    	     		snpchromosome04.setProteinAlignNumber(siftdata.getProteinAlignNumber());
                                    	     		snpchromosome04.setTotalAlignSequenceNumber(siftdata.getTotalAlignSequenceNumber());

                                    	     		serviceSNPChromosome.update(snpchromosome04);
                                    	     		
                                    	     		intSNPChromosomeCount04++;
                                    	     	}
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( siftdata.isChromosome5() ) {
                    	     			
                    	                List<SNPChromosome> snpchromosome5List = new ArrayList<SNPChromosome>();

                    	                snpchromosome5List = serviceSNPChromosome.findBySnpId(siftdata.getSnpId());
                    	                
                    	     			if ( snpchromosome5List.isEmpty() ) {
                    	     				
                    	     				error++;

                    	     				String errorRecord = "SNP NOT FOUND!\t" + siftdata.getSnpId() + "\t" +
                    	     						siftdata.getEnsemblGene() + "\t" +
                    	     						siftdata.getEnsemblTranscript() + "\t" +
                    	     						siftdata.getEnsemblAnnotation() + "\t" +
                    	     						siftdata.getAminoAcidSubs() + "\t" +
                    	     						siftdata.getPredictionCategory() + "\t" +
                    	     						siftdata.getScoreSift() + "\t" +
                    	     						siftdata.getScoreConservation() + "\t" +
                    	     						siftdata.getProteinAlignNumber() + "\t" +
                    	     						siftdata.getTotalAlignSequenceNumber();

                    	     				errorRecords.add(errorRecord);

                    	     				//Wrapper.printMessage("Error No. " + error + " : SNP Id. " + siftdata.getSnpId() + " NOT FOUND : " + siftdata.toString(), MSGLEVEL, MSGLEVEL);
                    	     			}
                    	     			else {

                        	     			if ( snpchromosome5List.size() > 1 ) {
                        	     				
                        	     				error++;

                        	     				String errorRecord = "MULTIPLE SNPs!\t" + siftdata.getSnpId() + "\t" +
                        	     						siftdata.getEnsemblGene() + "\t" +
                        	     						siftdata.getEnsemblTranscript() + "\t" +
                        	     						siftdata.getEnsemblAnnotation() + "\t" +
                        	     						siftdata.getAminoAcidSubs() + "\t" +
                        	     						siftdata.getPredictionCategory() + "\t" +
                        	     						siftdata.getScoreSift() + "\t" +
                        	     						siftdata.getScoreConservation() + "\t" +
                        	     						siftdata.getProteinAlignNumber() + "\t" +
                        	     						siftdata.getTotalAlignSequenceNumber();

                        	     				errorRecords.add(errorRecord);

                        	     				//Wrapper.printMessage("Error No. " + error + " : SNP Id. " + siftdata.getSnpId() + " GREATER THAN 1 ROW FOR : " + siftdata.toString(), MSGLEVEL, MSGLEVEL);
                        	     			}
                        	     			else {

                                    	        Iterator<SNPChromosome> iteratorSNPChromosome = snpchromosome5List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome.hasNext()) {

                                    	     		SNPChromosome snpchromosome05 = iteratorSNPChromosome.next();
                                    	     		
                                    	     		snpchromosome05.setAminoAcidSubs(siftdata.getAminoAcidSubs());
                                    	     		snpchromosome05.setPredictionCategory(siftdata.getPredictionCategory());
                                    	     		snpchromosome05.setScoreSift(siftdata.getScoreSift());
                                    	     		snpchromosome05.setScoreConservation(siftdata.getScoreConservation());
                                    	     		snpchromosome05.setProteinAlignNumber(siftdata.getProteinAlignNumber());
                                    	     		snpchromosome05.setTotalAlignSequenceNumber(siftdata.getTotalAlignSequenceNumber());

                                    	     		serviceSNPChromosome.update(snpchromosome05);
                                    	     		
                                    	     		intSNPChromosomeCount05++;
                                    	     	}
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( siftdata.isChromosome6() ) {
                    	     			
                    	                List<SNPChromosome> snpchromosome6List = new ArrayList<SNPChromosome>();

                    	                snpchromosome6List = serviceSNPChromosome.findBySnpId(siftdata.getSnpId());
                    	                
                    	     			if ( snpchromosome6List.isEmpty() ) {
                    	     				
                    	     				error++;

                    	     				String errorRecord = "SNP NOT FOUND!\t" + siftdata.getSnpId() + "\t" +
                    	     						siftdata.getEnsemblGene() + "\t" +
                    	     						siftdata.getEnsemblTranscript() + "\t" +
                    	     						siftdata.getEnsemblAnnotation() + "\t" +
                    	     						siftdata.getAminoAcidSubs() + "\t" +
                    	     						siftdata.getPredictionCategory() + "\t" +
                    	     						siftdata.getScoreSift() + "\t" +
                    	     						siftdata.getScoreConservation() + "\t" +
                    	     						siftdata.getProteinAlignNumber() + "\t" +
                    	     						siftdata.getTotalAlignSequenceNumber();

                    	     				errorRecords.add(errorRecord);

                    	     				//Wrapper.printMessage("Error No. " + error + " : SNP Id. " + siftdata.getSnpId() + " NOT FOUND : " + siftdata.toString(), MSGLEVEL, MSGLEVEL);
                    	     			}
                    	     			else {

                        	     			if ( snpchromosome6List.size() > 1 ) {
                        	     				
                        	     				error++;

                        	     				String errorRecord = "MULTIPLE SNPs!\t" + siftdata.getSnpId() + "\t" +
                        	     						siftdata.getEnsemblGene() + "\t" +
                        	     						siftdata.getEnsemblTranscript() + "\t" +
                        	     						siftdata.getEnsemblAnnotation() + "\t" +
                        	     						siftdata.getAminoAcidSubs() + "\t" +
                        	     						siftdata.getPredictionCategory() + "\t" +
                        	     						siftdata.getScoreSift() + "\t" +
                        	     						siftdata.getScoreConservation() + "\t" +
                        	     						siftdata.getProteinAlignNumber() + "\t" +
                        	     						siftdata.getTotalAlignSequenceNumber();

                        	     				errorRecords.add(errorRecord);

                        	     				//Wrapper.printMessage("Error No. " + error + " : SNP Id. " + siftdata.getSnpId() + " GREATER THAN 1 ROW FOR : " + siftdata.toString(), MSGLEVEL, MSGLEVEL);
                        	     			}
                        	     			else {

                                    	        Iterator<SNPChromosome> iteratorSNPChromosome = snpchromosome6List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome.hasNext()) {

                                    	     		SNPChromosome snpchromosome06 = iteratorSNPChromosome.next();
                                    	     		
                                    	     		snpchromosome06.setAminoAcidSubs(siftdata.getAminoAcidSubs());
                                    	     		snpchromosome06.setPredictionCategory(siftdata.getPredictionCategory());
                                    	     		snpchromosome06.setScoreSift(siftdata.getScoreSift());
                                    	     		snpchromosome06.setScoreConservation(siftdata.getScoreConservation());
                                    	     		snpchromosome06.setProteinAlignNumber(siftdata.getProteinAlignNumber());
                                    	     		snpchromosome06.setTotalAlignSequenceNumber(siftdata.getTotalAlignSequenceNumber());

                                    	     		serviceSNPChromosome.update(snpchromosome06);
                                    	     		
                                    	     		intSNPChromosomeCount06++;
                                    	     	}
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( siftdata.isChromosome7() ) {
                    	     			
                    	                List<SNPChromosome> snpchromosome7List = new ArrayList<SNPChromosome>();

                    	                snpchromosome7List = serviceSNPChromosome.findBySnpId(siftdata.getSnpId());
                    	                
                    	     			if ( snpchromosome7List.isEmpty() ) {
                    	     				
                    	     				error++;

                    	     				String errorRecord = "SNP NOT FOUND!\t" + siftdata.getSnpId() + "\t" +
                    	     						siftdata.getEnsemblGene() + "\t" +
                    	     						siftdata.getEnsemblTranscript() + "\t" +
                    	     						siftdata.getEnsemblAnnotation() + "\t" +
                    	     						siftdata.getAminoAcidSubs() + "\t" +
                    	     						siftdata.getPredictionCategory() + "\t" +
                    	     						siftdata.getScoreSift() + "\t" +
                    	     						siftdata.getScoreConservation() + "\t" +
                    	     						siftdata.getProteinAlignNumber() + "\t" +
                    	     						siftdata.getTotalAlignSequenceNumber();

                    	     				errorRecords.add(errorRecord);

                    	     				//Wrapper.printMessage("Error No. " + error + " : SNP Id. " + siftdata.getSnpId() + " NOT FOUND : " + siftdata.toString(), MSGLEVEL, MSGLEVEL);
                    	     			}
                    	     			else {

                        	     			if ( snpchromosome7List.size() > 1 ) {
                        	     				
                        	     				error++;

                        	     				String errorRecord = "MULTIPLE SNPs!\t" + siftdata.getSnpId() + "\t" +
                        	     						siftdata.getEnsemblGene() + "\t" +
                        	     						siftdata.getEnsemblTranscript() + "\t" +
                        	     						siftdata.getEnsemblAnnotation() + "\t" +
                        	     						siftdata.getAminoAcidSubs() + "\t" +
                        	     						siftdata.getPredictionCategory() + "\t" +
                        	     						siftdata.getScoreSift() + "\t" +
                        	     						siftdata.getScoreConservation() + "\t" +
                        	     						siftdata.getProteinAlignNumber() + "\t" +
                        	     						siftdata.getTotalAlignSequenceNumber();

                        	     				errorRecords.add(errorRecord);

                        	     				//Wrapper.printMessage("Error No. " + error + " : SNP Id. " + siftdata.getSnpId() + " GREATER THAN 1 ROW FOR : " + siftdata.toString(), MSGLEVEL, MSGLEVEL);
                        	     			}
                        	     			else {

                                    	        Iterator<SNPChromosome> iteratorSNPChromosome = snpchromosome7List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome.hasNext()) {

                                    	     		SNPChromosome snpchromosome07 = iteratorSNPChromosome.next();
                                    	     		
                                    	     		snpchromosome07.setAminoAcidSubs(siftdata.getAminoAcidSubs());
                                    	     		snpchromosome07.setPredictionCategory(siftdata.getPredictionCategory());
                                    	     		snpchromosome07.setScoreSift(siftdata.getScoreSift());
                                    	     		snpchromosome07.setScoreConservation(siftdata.getScoreConservation());
                                    	     		snpchromosome07.setProteinAlignNumber(siftdata.getProteinAlignNumber());
                                    	     		snpchromosome07.setTotalAlignSequenceNumber(siftdata.getTotalAlignSequenceNumber());

                                    	     		serviceSNPChromosome.update(snpchromosome07);
                                    	     		
                                    	     		intSNPChromosomeCount07++;
                                    	     	}
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( siftdata.isChromosome8() ) {

                    	                List<SNPChromosome> snpchromosome8List = new ArrayList<SNPChromosome>();

                    	     			snpchromosome8List = serviceSNPChromosome.findBySnpId(siftdata.getSnpId());
                    	     			
                    	     			if ( snpchromosome8List.isEmpty() ) {
                    	     				
                    	     				error++;

                    	     				String errorRecord = "SNP NOT FOUND!\t" + siftdata.getSnpId() + "\t" +
                    	     						siftdata.getEnsemblGene() + "\t" +
                    	     						siftdata.getEnsemblTranscript() + "\t" +
                    	     						siftdata.getEnsemblAnnotation() + "\t" +
                    	     						siftdata.getAminoAcidSubs() + "\t" +
                    	     						siftdata.getPredictionCategory() + "\t" +
                    	     						siftdata.getScoreSift() + "\t" +
                    	     						siftdata.getScoreConservation() + "\t" +
                    	     						siftdata.getProteinAlignNumber() + "\t" +
                    	     						siftdata.getTotalAlignSequenceNumber();

                    	     				errorRecords.add(errorRecord);

                    	     				//Wrapper.printMessage("Error No. " + error + " : SNP Id. " + siftdata.getSnpId() + " NOT FOUND : " + siftdata.toString(), MSGLEVEL, MSGLEVEL);
                    	     			}
                    	     			else {

                        	     			if ( snpchromosome8List.size() > 1 ) {
                        	     				
                        	     				error++;

                        	     				String errorRecord = "MULTIPLE SNPs!\t" + siftdata.getSnpId() + "\t" +
                        	     						siftdata.getEnsemblGene() + "\t" +
                        	     						siftdata.getEnsemblTranscript() + "\t" +
                        	     						siftdata.getEnsemblAnnotation() + "\t" +
                        	     						siftdata.getAminoAcidSubs() + "\t" +
                        	     						siftdata.getPredictionCategory() + "\t" +
                        	     						siftdata.getScoreSift() + "\t" +
                        	     						siftdata.getScoreConservation() + "\t" +
                        	     						siftdata.getProteinAlignNumber() + "\t" +
                        	     						siftdata.getTotalAlignSequenceNumber();

                        	     				errorRecords.add(errorRecord);

                        	     				//Wrapper.printMessage("Error No. " + error + " : SNP Id. " + siftdata.getSnpId() + " GREATER THAN 1 ROW FOR : " + siftdata.toString(), MSGLEVEL, MSGLEVEL);
                        	     			}
                        	     			else {

                                    	        Iterator<SNPChromosome> iteratorSNPChromosome = snpchromosome8List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome.hasNext()) {

                                    	     		SNPChromosome snpchromosome08 = iteratorSNPChromosome.next();
                                    	     		
                                    	     		snpchromosome08.setAminoAcidSubs(siftdata.getAminoAcidSubs());
                                    	     		snpchromosome08.setPredictionCategory(siftdata.getPredictionCategory());
                                    	     		snpchromosome08.setScoreSift(siftdata.getScoreSift());
                                    	     		snpchromosome08.setScoreConservation(siftdata.getScoreConservation());
                                    	     		snpchromosome08.setProteinAlignNumber(siftdata.getProteinAlignNumber());
                                    	     		snpchromosome08.setTotalAlignSequenceNumber(siftdata.getTotalAlignSequenceNumber());

                                    	     		serviceSNPChromosome.update(snpchromosome08);
                                    	     		
                                    	     		intSNPChromosomeCount08++;
                                    	     	}
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( siftdata.isChromosome9() ) {

                    	                List<SNPChromosome> snpchromosome9List = new ArrayList<SNPChromosome>();

                    	     			snpchromosome9List = serviceSNPChromosome.findBySnpId(siftdata.getSnpId());
                    	     			
                    	     			if ( snpchromosome9List.isEmpty() ) {
                    	     				
                    	     				error++;

                    	     				String errorRecord = "SNP NOT FOUND!\t" + siftdata.getSnpId() + "\t" +
                    	     						siftdata.getEnsemblGene() + "\t" +
                    	     						siftdata.getEnsemblTranscript() + "\t" +
                    	     						siftdata.getEnsemblAnnotation() + "\t" +
                    	     						siftdata.getAminoAcidSubs() + "\t" +
                    	     						siftdata.getPredictionCategory() + "\t" +
                    	     						siftdata.getScoreSift() + "\t" +
                    	     						siftdata.getScoreConservation() + "\t" +
                    	     						siftdata.getProteinAlignNumber() + "\t" +
                    	     						siftdata.getTotalAlignSequenceNumber();

                    	     				errorRecords.add(errorRecord);

                    	     				//Wrapper.printMessage("Error No. " + error + " : SNP Id. " + siftdata.getSnpId() + " NOT FOUND : " + siftdata.toString(), MSGLEVEL, MSGLEVEL);
                    	     			}
                    	     			else {

                        	     			if ( snpchromosome9List.size() > 1 ) {
                        	     				
                        	     				error++;

                        	     				String errorRecord = "MULTIPLE SNPs!\t" + siftdata.getSnpId() + "\t" +
                        	     						siftdata.getEnsemblGene() + "\t" +
                        	     						siftdata.getEnsemblTranscript() + "\t" +
                        	     						siftdata.getEnsemblAnnotation() + "\t" +
                        	     						siftdata.getAminoAcidSubs() + "\t" +
                        	     						siftdata.getPredictionCategory() + "\t" +
                        	     						siftdata.getScoreSift() + "\t" +
                        	     						siftdata.getScoreConservation() + "\t" +
                        	     						siftdata.getProteinAlignNumber() + "\t" +
                        	     						siftdata.getTotalAlignSequenceNumber();

                        	     				errorRecords.add(errorRecord);

                        	     				//Wrapper.printMessage("Error No. " + error + " : SNP Id. " + siftdata.getSnpId() + " GREATER THAN 1 ROW FOR : " + siftdata.toString(), MSGLEVEL, MSGLEVEL);
                        	     			}
                        	     			else {

                                    	        Iterator<SNPChromosome> iteratorSNPChromosome = snpchromosome9List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome.hasNext()) {

                                    	     		SNPChromosome snpchromosome09 = iteratorSNPChromosome.next();
                                    	     		
                                    	     		snpchromosome09.setAminoAcidSubs(siftdata.getAminoAcidSubs());
                                    	     		snpchromosome09.setPredictionCategory(siftdata.getPredictionCategory());
                                    	     		snpchromosome09.setScoreSift(siftdata.getScoreSift());
                                    	     		snpchromosome09.setScoreConservation(siftdata.getScoreConservation());
                                    	     		snpchromosome09.setProteinAlignNumber(siftdata.getProteinAlignNumber());
                                    	     		snpchromosome09.setTotalAlignSequenceNumber(siftdata.getTotalAlignSequenceNumber());

                                    	     		serviceSNPChromosome.update(snpchromosome09);
                                    	     		
                                    	     		intSNPChromosomeCount09++;
                                    	     	}
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( siftdata.isChromosome10() ) {

                    	                List<SNPChromosome> snpchromosome10List = new ArrayList<SNPChromosome>();

                    	     			snpchromosome10List = serviceSNPChromosome.findBySnpId(siftdata.getSnpId());
                    	     			
                    	     			if ( snpchromosome10List.isEmpty() ) {
                    	     				
                    	     				error++;

                    	     				String errorRecord = "SNP NOT FOUND!\t" + siftdata.getSnpId() + "\t" +
                    	     						siftdata.getEnsemblGene() + "\t" +
                    	     						siftdata.getEnsemblTranscript() + "\t" +
                    	     						siftdata.getEnsemblAnnotation() + "\t" +
                    	     						siftdata.getAminoAcidSubs() + "\t" +
                    	     						siftdata.getPredictionCategory() + "\t" +
                    	     						siftdata.getScoreSift() + "\t" +
                    	     						siftdata.getScoreConservation() + "\t" +
                    	     						siftdata.getProteinAlignNumber() + "\t" +
                    	     						siftdata.getTotalAlignSequenceNumber();

                    	     				errorRecords.add(errorRecord);

                    	     				//Wrapper.printMessage("Error No. " + error + " : SNP Id. " + siftdata.getSnpId() + " NOT FOUND : " + siftdata.toString(), MSGLEVEL, MSGLEVEL);
                    	     			}
                    	     			else {

                        	     			if ( snpchromosome10List.size() > 1 ) {
                        	     				
                        	     				error++;

                        	     				String errorRecord = "MULTIPLE SNPs!\t" + siftdata.getSnpId() + "\t" +
                        	     						siftdata.getEnsemblGene() + "\t" +
                        	     						siftdata.getEnsemblTranscript() + "\t" +
                        	     						siftdata.getEnsemblAnnotation() + "\t" +
                        	     						siftdata.getAminoAcidSubs() + "\t" +
                        	     						siftdata.getPredictionCategory() + "\t" +
                        	     						siftdata.getScoreSift() + "\t" +
                        	     						siftdata.getScoreConservation() + "\t" +
                        	     						siftdata.getProteinAlignNumber() + "\t" +
                        	     						siftdata.getTotalAlignSequenceNumber();

                        	     				errorRecords.add(errorRecord);

                        	     				//Wrapper.printMessage("Error No. " + error + " : SNP Id. " + siftdata.getSnpId() + " GREATER THAN 1 ROW FOR : " + siftdata.toString(), MSGLEVEL, MSGLEVEL);
                        	     			}
                        	     			else {

                                    	        Iterator<SNPChromosome> iteratorSNPChromosome = snpchromosome10List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome.hasNext()) {

                                    	     		SNPChromosome snpchromosome10 = iteratorSNPChromosome.next();
                                    	     		
                                    	     		snpchromosome10.setAminoAcidSubs(siftdata.getAminoAcidSubs());
                                    	     		snpchromosome10.setPredictionCategory(siftdata.getPredictionCategory());
                                    	     		snpchromosome10.setScoreSift(siftdata.getScoreSift());
                                    	     		snpchromosome10.setScoreConservation(siftdata.getScoreConservation());
                                    	     		snpchromosome10.setProteinAlignNumber(siftdata.getProteinAlignNumber());
                                    	     		snpchromosome10.setTotalAlignSequenceNumber(siftdata.getTotalAlignSequenceNumber());

                                    	     		serviceSNPChromosome.update(snpchromosome10);
                                    	     		
                                    	     		intSNPChromosomeCount10++;
                                    	     	}
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( siftdata.isChromosome11() ) {
                    	     			
                    	                List<SNPChromosome> snpchromosome11List = new ArrayList<SNPChromosome>();

                    	     			snpchromosome11List = serviceSNPChromosome.findBySnpId(siftdata.getSnpId());
                    	     			
                    	     			if ( snpchromosome11List.isEmpty() ) {
                    	     				
                    	     				error++;

                    	     				String errorRecord = "SNP NOT FOUND!\t" + siftdata.getSnpId() + "\t" +
                    	     						siftdata.getEnsemblGene() + "\t" +
                    	     						siftdata.getEnsemblTranscript() + "\t" +
                    	     						siftdata.getEnsemblAnnotation() + "\t" +
                    	     						siftdata.getAminoAcidSubs() + "\t" +
                    	     						siftdata.getPredictionCategory() + "\t" +
                    	     						siftdata.getScoreSift() + "\t" +
                    	     						siftdata.getScoreConservation() + "\t" +
                    	     						siftdata.getProteinAlignNumber() + "\t" +
                    	     						siftdata.getTotalAlignSequenceNumber();

                    	     				errorRecords.add(errorRecord);

                    	     				//Wrapper.printMessage("Error No. " + error + " : SNP Id. " + siftdata.getSnpId() + " NOT FOUND : " + siftdata.toString(), MSGLEVEL, MSGLEVEL);
                    	     			}
                    	     			else {

                        	     			if ( snpchromosome11List.size() > 1 ) {
                        	     				
                        	     				error++;

                        	     				String errorRecord = "MULTIPLE SNPs!\t" + siftdata.getSnpId() + "\t" +
                        	     						siftdata.getEnsemblGene() + "\t" +
                        	     						siftdata.getEnsemblTranscript() + "\t" +
                        	     						siftdata.getEnsemblAnnotation() + "\t" +
                        	     						siftdata.getAminoAcidSubs() + "\t" +
                        	     						siftdata.getPredictionCategory() + "\t" +
                        	     						siftdata.getScoreSift() + "\t" +
                        	     						siftdata.getScoreConservation() + "\t" +
                        	     						siftdata.getProteinAlignNumber() + "\t" +
                        	     						siftdata.getTotalAlignSequenceNumber();

                        	     				errorRecords.add(errorRecord);

                        	     				//Wrapper.printMessage("Error No. " + error + " : SNP Id. " + siftdata.getSnpId() + " GREATER THAN 1 ROW FOR : " + siftdata.toString(), MSGLEVEL, MSGLEVEL);
                        	     			}
                        	     			else {

                                    	        Iterator<SNPChromosome> iteratorSNPChromosome = snpchromosome11List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome.hasNext()) {

                                    	     		SNPChromosome snpchromosome11 = iteratorSNPChromosome.next();
                                    	     		
                                    	     		snpchromosome11.setAminoAcidSubs(siftdata.getAminoAcidSubs());
                                    	     		snpchromosome11.setPredictionCategory(siftdata.getPredictionCategory());
                                    	     		snpchromosome11.setScoreSift(siftdata.getScoreSift());
                                    	     		snpchromosome11.setScoreConservation(siftdata.getScoreConservation());
                                    	     		snpchromosome11.setProteinAlignNumber(siftdata.getProteinAlignNumber());
                                    	     		snpchromosome11.setTotalAlignSequenceNumber(siftdata.getTotalAlignSequenceNumber());

                                    	     		serviceSNPChromosome.update(snpchromosome11);
                                    	     		
                                    	     		intSNPChromosomeCount11++;
                                    	     	}
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( siftdata.isChromosome12() ) {
                    	     			
                    	                List<SNPChromosome> snpchromosome12List = new ArrayList<SNPChromosome>();

                    	                snpchromosome12List = serviceSNPChromosome.findBySnpId(siftdata.getSnpId());
                    	                
                    	     			if ( snpchromosome12List.isEmpty() ) {
                    	     				
                    	     				error++;

                    	     				String errorRecord = "SNP NOT FOUND!\t" + siftdata.getSnpId() + "\t" +
                    	     						siftdata.getEnsemblGene() + "\t" +
                    	     						siftdata.getEnsemblTranscript() + "\t" +
                    	     						siftdata.getEnsemblAnnotation() + "\t" +
                    	     						siftdata.getAminoAcidSubs() + "\t" +
                    	     						siftdata.getPredictionCategory() + "\t" +
                    	     						siftdata.getScoreSift() + "\t" +
                    	     						siftdata.getScoreConservation() + "\t" +
                    	     						siftdata.getProteinAlignNumber() + "\t" +
                    	     						siftdata.getTotalAlignSequenceNumber();

                    	     				errorRecords.add(errorRecord);

                    	     				//Wrapper.printMessage("Error No. " + error + " : SNP Id. " + siftdata.getSnpId() + " NOT FOUND : " + siftdata.toString(), MSGLEVEL, MSGLEVEL);
                    	     			}
                    	     			else {

                        	     			if ( snpchromosome12List.size() > 1 ) {
                        	     				
                        	     				error++;

                        	     				String errorRecord = "MULTIPLE SNPs!\t" + siftdata.getSnpId() + "\t" +
                        	     						siftdata.getEnsemblGene() + "\t" +
                        	     						siftdata.getEnsemblTranscript() + "\t" +
                        	     						siftdata.getEnsemblAnnotation() + "\t" +
                        	     						siftdata.getAminoAcidSubs() + "\t" +
                        	     						siftdata.getPredictionCategory() + "\t" +
                        	     						siftdata.getScoreSift() + "\t" +
                        	     						siftdata.getScoreConservation() + "\t" +
                        	     						siftdata.getProteinAlignNumber() + "\t" +
                        	     						siftdata.getTotalAlignSequenceNumber();

                        	     				errorRecords.add(errorRecord);

                        	     				//Wrapper.printMessage("Error No. " + error + " : SNP Id. " + siftdata.getSnpId() + " GREATER THAN 1 ROW FOR : " + siftdata.toString(), MSGLEVEL, MSGLEVEL);
                        	     			}
                        	     			else {

                                    	        Iterator<SNPChromosome> iteratorSNPChromosome = snpchromosome12List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome.hasNext()) {

                                    	     		SNPChromosome snpchromosome12 = iteratorSNPChromosome.next();
                                    	     		
                                    	     		snpchromosome12.setAminoAcidSubs(siftdata.getAminoAcidSubs());
                                    	     		snpchromosome12.setPredictionCategory(siftdata.getPredictionCategory());
                                    	     		snpchromosome12.setScoreSift(siftdata.getScoreSift());
                                    	     		snpchromosome12.setScoreConservation(siftdata.getScoreConservation());
                                    	     		snpchromosome12.setProteinAlignNumber(siftdata.getProteinAlignNumber());
                                    	     		snpchromosome12.setTotalAlignSequenceNumber(siftdata.getTotalAlignSequenceNumber());

                                    	     		serviceSNPChromosome.update(snpchromosome12);
                                    	     		
                                    	     		intSNPChromosomeCount12++;
                                    	     	}
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( siftdata.isChromosome13() ) {
                    	     			
                    	                List<SNPChromosome> snpchromosome13List = new ArrayList<SNPChromosome>();

                    	                snpchromosome13List = serviceSNPChromosome.findBySnpId(siftdata.getSnpId());
                    	                
                    	     			if ( snpchromosome13List.isEmpty() ) {
                    	     				
                    	     				error++;

                    	     				String errorRecord = "SNP NOT FOUND!\t" + siftdata.getSnpId() + "\t" +
                    	     						siftdata.getEnsemblGene() + "\t" +
                    	     						siftdata.getEnsemblTranscript() + "\t" +
                    	     						siftdata.getEnsemblAnnotation() + "\t" +
                    	     						siftdata.getAminoAcidSubs() + "\t" +
                    	     						siftdata.getPredictionCategory() + "\t" +
                    	     						siftdata.getScoreSift() + "\t" +
                    	     						siftdata.getScoreConservation() + "\t" +
                    	     						siftdata.getProteinAlignNumber() + "\t" +
                    	     						siftdata.getTotalAlignSequenceNumber();

                    	     				errorRecords.add(errorRecord);

                    	     				//Wrapper.printMessage("Error No. " + error + " : SNP Id. " + siftdata.getSnpId() + " NOT FOUND : " + siftdata.toString(), MSGLEVEL, MSGLEVEL);
                    	     			}
                    	     			else {

                        	     			if ( snpchromosome13List.size() > 1 ) {
                        	     				
                        	     				error++;

                        	     				String errorRecord = "MULTIPLE SNPs!\t" + siftdata.getSnpId() + "\t" +
                        	     						siftdata.getEnsemblGene() + "\t" +
                        	     						siftdata.getEnsemblTranscript() + "\t" +
                        	     						siftdata.getEnsemblAnnotation() + "\t" +
                        	     						siftdata.getAminoAcidSubs() + "\t" +
                        	     						siftdata.getPredictionCategory() + "\t" +
                        	     						siftdata.getScoreSift() + "\t" +
                        	     						siftdata.getScoreConservation() + "\t" +
                        	     						siftdata.getProteinAlignNumber() + "\t" +
                        	     						siftdata.getTotalAlignSequenceNumber();

                        	     				errorRecords.add(errorRecord);

                        	     				//Wrapper.printMessage("Error No. " + error + " : SNP Id. " + siftdata.getSnpId() + " GREATER THAN 1 ROW FOR : " + siftdata.toString(), MSGLEVEL, MSGLEVEL);
                        	     			}
                        	     			else {

                                    	        Iterator<SNPChromosome> iteratorSNPChromosome = snpchromosome13List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome.hasNext()) {

                                    	     		SNPChromosome snpchromosome13 = iteratorSNPChromosome.next();
                                    	     		
                                    	     		snpchromosome13.setAminoAcidSubs(siftdata.getAminoAcidSubs());
                                    	     		snpchromosome13.setPredictionCategory(siftdata.getPredictionCategory());
                                    	     		snpchromosome13.setScoreSift(siftdata.getScoreSift());
                                    	     		snpchromosome13.setScoreConservation(siftdata.getScoreConservation());
                                    	     		snpchromosome13.setProteinAlignNumber(siftdata.getProteinAlignNumber());
                                    	     		snpchromosome13.setTotalAlignSequenceNumber(siftdata.getTotalAlignSequenceNumber());

                                    	     		serviceSNPChromosome.update(snpchromosome13);
                                    	     		
                                    	     		intSNPChromosomeCount13++;
                                    	     	}
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( siftdata.isChromosome14() ) {
                    	     			
                    	                List<SNPChromosome> snpchromosome14List = new ArrayList<SNPChromosome>();

                    	                snpchromosome14List = serviceSNPChromosome.findBySnpId(siftdata.getSnpId());
                    	                
                    	     			if ( snpchromosome14List.isEmpty() ) {
                    	     				
                    	     				error++;

                    	     				String errorRecord = "SNP NOT FOUND!\t" + siftdata.getSnpId() + "\t" +
                    	     						siftdata.getEnsemblGene() + "\t" +
                    	     						siftdata.getEnsemblTranscript() + "\t" +
                    	     						siftdata.getEnsemblAnnotation() + "\t" +
                    	     						siftdata.getAminoAcidSubs() + "\t" +
                    	     						siftdata.getPredictionCategory() + "\t" +
                    	     						siftdata.getScoreSift() + "\t" +
                    	     						siftdata.getScoreConservation() + "\t" +
                    	     						siftdata.getProteinAlignNumber() + "\t" +
                    	     						siftdata.getTotalAlignSequenceNumber();

                    	     				errorRecords.add(errorRecord);

                    	     				//Wrapper.printMessage("Error No. " + error + " : SNP Id. " + siftdata.getSnpId() + " NOT FOUND : " + siftdata.toString(), MSGLEVEL, MSGLEVEL);
                    	     			}
                    	     			else {

                        	     			if ( snpchromosome14List.size() > 1 ) {
                        	     				
                        	     				error++;

                        	     				String errorRecord = "MULTIPLE SNPs!\t" + siftdata.getSnpId() + "\t" +
                        	     						siftdata.getEnsemblGene() + "\t" +
                        	     						siftdata.getEnsemblTranscript() + "\t" +
                        	     						siftdata.getEnsemblAnnotation() + "\t" +
                        	     						siftdata.getAminoAcidSubs() + "\t" +
                        	     						siftdata.getPredictionCategory() + "\t" +
                        	     						siftdata.getScoreSift() + "\t" +
                        	     						siftdata.getScoreConservation() + "\t" +
                        	     						siftdata.getProteinAlignNumber() + "\t" +
                        	     						siftdata.getTotalAlignSequenceNumber();

                        	     				errorRecords.add(errorRecord);

                        	     				//Wrapper.printMessage("Error No. " + error + " : SNP Id. " + siftdata.getSnpId() + " GREATER THAN 1 ROW FOR : " + siftdata.toString(), MSGLEVEL, MSGLEVEL);
                        	     			}
                        	     			else {

                                    	        Iterator<SNPChromosome> iteratorSNPChromosome = snpchromosome14List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome.hasNext()) {

                                    	     		SNPChromosome snpchromosome14 = iteratorSNPChromosome.next();
                                    	     		
                                    	     		snpchromosome14.setAminoAcidSubs(siftdata.getAminoAcidSubs());
                                    	     		snpchromosome14.setPredictionCategory(siftdata.getPredictionCategory());
                                    	     		snpchromosome14.setScoreSift(siftdata.getScoreSift());
                                    	     		snpchromosome14.setScoreConservation(siftdata.getScoreConservation());
                                    	     		snpchromosome14.setProteinAlignNumber(siftdata.getProteinAlignNumber());
                                    	     		snpchromosome14.setTotalAlignSequenceNumber(siftdata.getTotalAlignSequenceNumber());

                                    	     		serviceSNPChromosome.update(snpchromosome14);
                                    	     		
                                    	     		intSNPChromosomeCount14++;
                                    	     	}
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( siftdata.isChromosome15() ) {
                    	     			
                    	                List<SNPChromosome> snpchromosome15List = new ArrayList<SNPChromosome>();

                    	                snpchromosome15List = serviceSNPChromosome.findBySnpId(siftdata.getSnpId());
                    	                
                    	     			if ( snpchromosome15List.isEmpty() ) {
                    	     				
                    	     				error++;

                    	     				String errorRecord = "SNP NOT FOUND!\t" + siftdata.getSnpId() + "\t" +
                    	     						siftdata.getEnsemblGene() + "\t" +
                    	     						siftdata.getEnsemblTranscript() + "\t" +
                    	     						siftdata.getEnsemblAnnotation() + "\t" +
                    	     						siftdata.getAminoAcidSubs() + "\t" +
                    	     						siftdata.getPredictionCategory() + "\t" +
                    	     						siftdata.getScoreSift() + "\t" +
                    	     						siftdata.getScoreConservation() + "\t" +
                    	     						siftdata.getProteinAlignNumber() + "\t" +
                    	     						siftdata.getTotalAlignSequenceNumber();

                    	     				errorRecords.add(errorRecord);

                    	     				//Wrapper.printMessage("Error No. " + error + " : SNP Id. " + siftdata.getSnpId() + " NOT FOUND : " + siftdata.toString(), MSGLEVEL, MSGLEVEL);
                    	     			}
                    	     			else {

                        	     			if ( snpchromosome15List.size() > 1 ) {
                        	     				
                        	     				error++;

                        	     				String errorRecord = "MULTIPLE SNPs!\t" + siftdata.getSnpId() + "\t" +
                        	     						siftdata.getEnsemblGene() + "\t" +
                        	     						siftdata.getEnsemblTranscript() + "\t" +
                        	     						siftdata.getEnsemblAnnotation() + "\t" +
                        	     						siftdata.getAminoAcidSubs() + "\t" +
                        	     						siftdata.getPredictionCategory() + "\t" +
                        	     						siftdata.getScoreSift() + "\t" +
                        	     						siftdata.getScoreConservation() + "\t" +
                        	     						siftdata.getProteinAlignNumber() + "\t" +
                        	     						siftdata.getTotalAlignSequenceNumber();

                        	     				errorRecords.add(errorRecord);

                        	     				//Wrapper.printMessage("Error No. " + error + " : SNP Id. " + siftdata.getSnpId() + " GREATER THAN 1 ROW FOR : " + siftdata.toString(), MSGLEVEL, MSGLEVEL);
                        	     			}
                        	     			else {

                                    	        Iterator<SNPChromosome> iteratorSNPChromosome = snpchromosome15List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome.hasNext()) {

                                    	     		SNPChromosome snpchromosome15 = iteratorSNPChromosome.next();
                                    	     		
                                    	     		snpchromosome15.setAminoAcidSubs(siftdata.getAminoAcidSubs());
                                    	     		snpchromosome15.setPredictionCategory(siftdata.getPredictionCategory());
                                    	     		snpchromosome15.setScoreSift(siftdata.getScoreSift());
                                    	     		snpchromosome15.setScoreConservation(siftdata.getScoreConservation());
                                    	     		snpchromosome15.setProteinAlignNumber(siftdata.getProteinAlignNumber());
                                    	     		snpchromosome15.setTotalAlignSequenceNumber(siftdata.getTotalAlignSequenceNumber());

                                    	     		serviceSNPChromosome.update(snpchromosome15);
                                    	     		
                                    	     		intSNPChromosomeCount15++;
                                    	     	}
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( siftdata.isChromosome16() ) {

                    	                List<SNPChromosome> snpchromosome16List = new ArrayList<SNPChromosome>();

                    	     			snpchromosome16List = serviceSNPChromosome.findBySnpId(siftdata.getSnpId());
                    	     			
                    	     			if ( snpchromosome16List.isEmpty() ) {
                    	     				
                    	     				error++;

                    	     				String errorRecord = "SNP NOT FOUND!\t" + siftdata.getSnpId() + "\t" +
                    	     						siftdata.getEnsemblGene() + "\t" +
                    	     						siftdata.getEnsemblTranscript() + "\t" +
                    	     						siftdata.getEnsemblAnnotation() + "\t" +
                    	     						siftdata.getAminoAcidSubs() + "\t" +
                    	     						siftdata.getPredictionCategory() + "\t" +
                    	     						siftdata.getScoreSift() + "\t" +
                    	     						siftdata.getScoreConservation() + "\t" +
                    	     						siftdata.getProteinAlignNumber() + "\t" +
                    	     						siftdata.getTotalAlignSequenceNumber();

                    	     				errorRecords.add(errorRecord);

                    	     				//Wrapper.printMessage("Error No. " + error + " : SNP Id. " + siftdata.getSnpId() + " NOT FOUND : " + siftdata.toString(), MSGLEVEL, MSGLEVEL);
                    	     			}
                    	     			else {

                        	     			if ( snpchromosome16List.size() > 1 ) {
                        	     				
                        	     				error++;

                        	     				String errorRecord = "MULTIPLE SNPs!\t" + siftdata.getSnpId() + "\t" +
                        	     						siftdata.getEnsemblGene() + "\t" +
                        	     						siftdata.getEnsemblTranscript() + "\t" +
                        	     						siftdata.getEnsemblAnnotation() + "\t" +
                        	     						siftdata.getAminoAcidSubs() + "\t" +
                        	     						siftdata.getPredictionCategory() + "\t" +
                        	     						siftdata.getScoreSift() + "\t" +
                        	     						siftdata.getScoreConservation() + "\t" +
                        	     						siftdata.getProteinAlignNumber() + "\t" +
                        	     						siftdata.getTotalAlignSequenceNumber();

                        	     				errorRecords.add(errorRecord);

                        	     				//Wrapper.printMessage("Error No. " + error + " : SNP Id. " + siftdata.getSnpId() + " GREATER THAN 1 ROW FOR : " + siftdata.toString(), MSGLEVEL, MSGLEVEL);
                        	     			}
                        	     			else {

                                    	        Iterator<SNPChromosome> iteratorSNPChromosome = snpchromosome16List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome.hasNext()) {

                                    	     		SNPChromosome snpchromosome16 = iteratorSNPChromosome.next();
                                    	     		
                                    	     		snpchromosome16.setAminoAcidSubs(siftdata.getAminoAcidSubs());
                                    	     		snpchromosome16.setPredictionCategory(siftdata.getPredictionCategory());
                                    	     		snpchromosome16.setScoreSift(siftdata.getScoreSift());
                                    	     		snpchromosome16.setScoreConservation(siftdata.getScoreConservation());
                                    	     		snpchromosome16.setProteinAlignNumber(siftdata.getProteinAlignNumber());
                                    	     		snpchromosome16.setTotalAlignSequenceNumber(siftdata.getTotalAlignSequenceNumber());

                                    	     		serviceSNPChromosome.update(snpchromosome16);
                                    	     		
                                    	     		intSNPChromosomeCount16++;
                                    	     	}
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( siftdata.isChromosome17() ) {
                    	     			
                    	                List<SNPChromosome> snpchromosome17List = new ArrayList<SNPChromosome>();

                    	     			snpchromosome17List = serviceSNPChromosome.findBySnpId(siftdata.getSnpId());
                    	     			
                    	     			if ( snpchromosome17List.isEmpty() ) {
                    	     				
                    	     				error++;

                    	     				String errorRecord = "SNP NOT FOUND!\t" + siftdata.getSnpId() + "\t" +
                    	     						siftdata.getEnsemblGene() + "\t" +
                    	     						siftdata.getEnsemblTranscript() + "\t" +
                    	     						siftdata.getEnsemblAnnotation() + "\t" +
                    	     						siftdata.getAminoAcidSubs() + "\t" +
                    	     						siftdata.getPredictionCategory() + "\t" +
                    	     						siftdata.getScoreSift() + "\t" +
                    	     						siftdata.getScoreConservation() + "\t" +
                    	     						siftdata.getProteinAlignNumber() + "\t" +
                    	     						siftdata.getTotalAlignSequenceNumber();

                    	     				errorRecords.add(errorRecord);

                    	     				//Wrapper.printMessage("Error No. " + error + " : SNP Id. " + siftdata.getSnpId() + " NOT FOUND : " + siftdata.toString(), MSGLEVEL, MSGLEVEL);
                    	     			}
                    	     			else {

                        	     			if ( snpchromosome17List.size() > 1 ) {
                        	     				
                        	     				error++;

                        	     				String errorRecord = "MULTIPLE SNPs!\t" + siftdata.getSnpId() + "\t" +
                        	     						siftdata.getEnsemblGene() + "\t" +
                        	     						siftdata.getEnsemblTranscript() + "\t" +
                        	     						siftdata.getEnsemblAnnotation() + "\t" +
                        	     						siftdata.getAminoAcidSubs() + "\t" +
                        	     						siftdata.getPredictionCategory() + "\t" +
                        	     						siftdata.getScoreSift() + "\t" +
                        	     						siftdata.getScoreConservation() + "\t" +
                        	     						siftdata.getProteinAlignNumber() + "\t" +
                        	     						siftdata.getTotalAlignSequenceNumber();

                        	     				errorRecords.add(errorRecord);

                        	     				//Wrapper.printMessage("Error No. " + error + " : SNP Id. " + siftdata.getSnpId() + " GREATER THAN 1 ROW FOR : " + siftdata.toString(), MSGLEVEL, MSGLEVEL);
                        	     			}
                        	     			else {

                                    	        Iterator<SNPChromosome> iteratorSNPChromosome = snpchromosome17List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome.hasNext()) {

                                    	     		SNPChromosome snpchromosome17 = iteratorSNPChromosome.next();
                                    	     		
                                    	     		snpchromosome17.setAminoAcidSubs(siftdata.getAminoAcidSubs());
                                    	     		snpchromosome17.setPredictionCategory(siftdata.getPredictionCategory());
                                    	     		snpchromosome17.setScoreSift(siftdata.getScoreSift());
                                    	     		snpchromosome17.setScoreConservation(siftdata.getScoreConservation());
                                    	     		snpchromosome17.setProteinAlignNumber(siftdata.getProteinAlignNumber());
                                    	     		snpchromosome17.setTotalAlignSequenceNumber(siftdata.getTotalAlignSequenceNumber());

                                    	     		serviceSNPChromosome.update(snpchromosome17);
                                    	     		
                                    	     		intSNPChromosomeCount17++;
                                    	     	}
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( siftdata.isChromosome18() ) {

                    	                List<SNPChromosome> snpchromosome18List = new ArrayList<SNPChromosome>();

                    	     			snpchromosome18List = serviceSNPChromosome.findBySnpId(siftdata.getSnpId());
                    	     			
                    	     			if ( snpchromosome18List.isEmpty() ) {
                    	     				
                    	     				error++;

                    	     				String errorRecord = "SNP NOT FOUND!\t" + siftdata.getSnpId() + "\t" +
                    	     						siftdata.getEnsemblGene() + "\t" +
                    	     						siftdata.getEnsemblTranscript() + "\t" +
                    	     						siftdata.getEnsemblAnnotation() + "\t" +
                    	     						siftdata.getAminoAcidSubs() + "\t" +
                    	     						siftdata.getPredictionCategory() + "\t" +
                    	     						siftdata.getScoreSift() + "\t" +
                    	     						siftdata.getScoreConservation() + "\t" +
                    	     						siftdata.getProteinAlignNumber() + "\t" +
                    	     						siftdata.getTotalAlignSequenceNumber();

                    	     				errorRecords.add(errorRecord);

                    	     				//Wrapper.printMessage("Error No. " + error + " : SNP Id. " + siftdata.getSnpId() + " NOT FOUND : " + siftdata.toString(), MSGLEVEL, MSGLEVEL);
                    	     			}
                    	     			else {

                        	     			if ( snpchromosome18List.size() > 1 ) {
                        	     				
                        	     				error++;

                        	     				String errorRecord = "MULTIPLE SNPs!\t" + siftdata.getSnpId() + "\t" +
                        	     						siftdata.getEnsemblGene() + "\t" +
                        	     						siftdata.getEnsemblTranscript() + "\t" +
                        	     						siftdata.getEnsemblAnnotation() + "\t" +
                        	     						siftdata.getAminoAcidSubs() + "\t" +
                        	     						siftdata.getPredictionCategory() + "\t" +
                        	     						siftdata.getScoreSift() + "\t" +
                        	     						siftdata.getScoreConservation() + "\t" +
                        	     						siftdata.getProteinAlignNumber() + "\t" +
                        	     						siftdata.getTotalAlignSequenceNumber();

                        	     				errorRecords.add(errorRecord);

                        	     				//Wrapper.printMessage("Error No. " + error + " : SNP Id. " + siftdata.getSnpId() + " GREATER THAN 1 ROW FOR : " + siftdata.toString(), MSGLEVEL, MSGLEVEL);
                        	     			}
                        	     			else {

                                    	        Iterator<SNPChromosome> iteratorSNPChromosome = snpchromosome18List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome.hasNext()) {

                                    	     		SNPChromosome snpchromosome18 = iteratorSNPChromosome.next();
                                    	     		
                                    	     		snpchromosome18.setAminoAcidSubs(siftdata.getAminoAcidSubs());
                                    	     		snpchromosome18.setPredictionCategory(siftdata.getPredictionCategory());
                                    	     		snpchromosome18.setScoreSift(siftdata.getScoreSift());
                                    	     		snpchromosome18.setScoreConservation(siftdata.getScoreConservation());
                                    	     		snpchromosome18.setProteinAlignNumber(siftdata.getProteinAlignNumber());
                                    	     		snpchromosome18.setTotalAlignSequenceNumber(siftdata.getTotalAlignSequenceNumber());

                                    	     		serviceSNPChromosome.update(snpchromosome18);
                                    	     		
                                    	     		intSNPChromosomeCount18++;
                                    	     	}
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( siftdata.isChromosome19() ) {

                    	                List<SNPChromosome> snpchromosome19List = new ArrayList<SNPChromosome>();

                    	     			snpchromosome19List = serviceSNPChromosome.findBySnpId(siftdata.getSnpId());
                    	     			
                    	     			if ( snpchromosome19List.isEmpty() ) {
                    	     				
                    	     				error++;

                    	     				String errorRecord = "SNP NOT FOUND!\t" + siftdata.getSnpId() + "\t" +
                    	     						siftdata.getEnsemblGene() + "\t" +
                    	     						siftdata.getEnsemblTranscript() + "\t" +
                    	     						siftdata.getEnsemblAnnotation() + "\t" +
                    	     						siftdata.getAminoAcidSubs() + "\t" +
                    	     						siftdata.getPredictionCategory() + "\t" +
                    	     						siftdata.getScoreSift() + "\t" +
                    	     						siftdata.getScoreConservation() + "\t" +
                    	     						siftdata.getProteinAlignNumber() + "\t" +
                    	     						siftdata.getTotalAlignSequenceNumber();

                    	     				errorRecords.add(errorRecord);

                    	     				//Wrapper.printMessage("Error No. " + error + " : SNP Id. " + siftdata.getSnpId() + " NOT FOUND : " + siftdata.toString(), MSGLEVEL, MSGLEVEL);
                    	     			}
                    	     			else {

                        	     			if ( snpchromosome19List.size() > 1 ) {
                        	     				
                        	     				error++;

                        	     				String errorRecord = "MULTIPLE SNPs!\t" + siftdata.getSnpId() + "\t" +
                        	     						siftdata.getEnsemblGene() + "\t" +
                        	     						siftdata.getEnsemblTranscript() + "\t" +
                        	     						siftdata.getEnsemblAnnotation() + "\t" +
                        	     						siftdata.getAminoAcidSubs() + "\t" +
                        	     						siftdata.getPredictionCategory() + "\t" +
                        	     						siftdata.getScoreSift() + "\t" +
                        	     						siftdata.getScoreConservation() + "\t" +
                        	     						siftdata.getProteinAlignNumber() + "\t" +
                        	     						siftdata.getTotalAlignSequenceNumber();

                        	     				errorRecords.add(errorRecord);

                        	     				//Wrapper.printMessage("Error No. " + error + " : SNP Id. " + siftdata.getSnpId() + " GREATER THAN 1 ROW FOR : " + siftdata.toString(), MSGLEVEL, MSGLEVEL);
                        	     			}
                        	     			else {

                                    	        Iterator<SNPChromosome> iteratorSNPChromosome = snpchromosome19List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome.hasNext()) {

                                    	     		SNPChromosome snpchromosome19 = iteratorSNPChromosome.next();
                                    	     		
                                    	     		snpchromosome19.setAminoAcidSubs(siftdata.getAminoAcidSubs());
                                    	     		snpchromosome19.setPredictionCategory(siftdata.getPredictionCategory());
                                    	     		snpchromosome19.setScoreSift(siftdata.getScoreSift());
                                    	     		snpchromosome19.setScoreConservation(siftdata.getScoreConservation());
                                    	     		snpchromosome19.setProteinAlignNumber(siftdata.getProteinAlignNumber());
                                    	     		snpchromosome19.setTotalAlignSequenceNumber(siftdata.getTotalAlignSequenceNumber());

                                    	     		serviceSNPChromosome.update(snpchromosome19);
                                    	     		
                                    	     		intSNPChromosomeCount19++;
                                    	     	}
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( siftdata.isChromosome20() ) {
                    	     			
                    	                List<SNPChromosome> snpchromosome20List = new ArrayList<SNPChromosome>();

                    	     			snpchromosome20List = serviceSNPChromosome.findBySnpId(siftdata.getSnpId());
                    	     			
                    	     			if ( snpchromosome20List.isEmpty() ) {
                    	     				
                    	     				error++;

                    	     				String errorRecord = "SNP NOT FOUND!\t" + siftdata.getSnpId() + "\t" +
                    	     						siftdata.getEnsemblGene() + "\t" +
                    	     						siftdata.getEnsemblTranscript() + "\t" +
                    	     						siftdata.getEnsemblAnnotation() + "\t" +
                    	     						siftdata.getAminoAcidSubs() + "\t" +
                    	     						siftdata.getPredictionCategory() + "\t" +
                    	     						siftdata.getScoreSift() + "\t" +
                    	     						siftdata.getScoreConservation() + "\t" +
                    	     						siftdata.getProteinAlignNumber() + "\t" +
                    	     						siftdata.getTotalAlignSequenceNumber();

                    	     				errorRecords.add(errorRecord);

                    	     				//Wrapper.printMessage("Error No. " + error + " : SNP Id. " + siftdata.getSnpId() + " NOT FOUND : " + siftdata.toString(), MSGLEVEL, MSGLEVEL);
                    	     			}
                    	     			else {

                        	     			if ( snpchromosome20List.size() > 1 ) {
                        	     				
                        	     				error++;

                        	     				String errorRecord = "MULTIPLE SNPs!\t" + siftdata.getSnpId() + "\t" +
                        	     						siftdata.getEnsemblGene() + "\t" +
                        	     						siftdata.getEnsemblTranscript() + "\t" +
                        	     						siftdata.getEnsemblAnnotation() + "\t" +
                        	     						siftdata.getAminoAcidSubs() + "\t" +
                        	     						siftdata.getPredictionCategory() + "\t" +
                        	     						siftdata.getScoreSift() + "\t" +
                        	     						siftdata.getScoreConservation() + "\t" +
                        	     						siftdata.getProteinAlignNumber() + "\t" +
                        	     						siftdata.getTotalAlignSequenceNumber();

                        	     				errorRecords.add(errorRecord);

                        	     				//Wrapper.printMessage("Error No. " + error + " : SNP Id. " + siftdata.getSnpId() + " GREATER THAN 1 ROW FOR : " + siftdata.toString(), MSGLEVEL, MSGLEVEL);
                        	     			}
                        	     			else {

                                    	        Iterator<SNPChromosome> iteratorSNPChromosome = snpchromosome20List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome.hasNext()) {

                                    	     		SNPChromosome snpchromosome20 = iteratorSNPChromosome.next();
                                    	     		
                                    	     		snpchromosome20.setAminoAcidSubs(siftdata.getAminoAcidSubs());
                                    	     		snpchromosome20.setPredictionCategory(siftdata.getPredictionCategory());
                                    	     		snpchromosome20.setScoreSift(siftdata.getScoreSift());
                                    	     		snpchromosome20.setScoreConservation(siftdata.getScoreConservation());
                                    	     		snpchromosome20.setProteinAlignNumber(siftdata.getProteinAlignNumber());
                                    	     		snpchromosome20.setTotalAlignSequenceNumber(siftdata.getTotalAlignSequenceNumber());

                                    	     		serviceSNPChromosome.update(snpchromosome20);
                                    	     		
                                    	     		intSNPChromosomeCount20++;
                                    	     	}
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( siftdata.isChromosome21() ) {

                    	                List<SNPChromosome> snpchromosome21List = new ArrayList<SNPChromosome>();

                    	     			snpchromosome21List = serviceSNPChromosome.findBySnpId(siftdata.getSnpId());
                    	     			
                    	     			if ( snpchromosome21List.isEmpty() ) {
                    	     				
                    	     				error++;

                    	     				String errorRecord = "SNP NOT FOUND!\t" + siftdata.getSnpId() + "\t" +
                    	     						siftdata.getEnsemblGene() + "\t" +
                    	     						siftdata.getEnsemblTranscript() + "\t" +
                    	     						siftdata.getEnsemblAnnotation() + "\t" +
                    	     						siftdata.getAminoAcidSubs() + "\t" +
                    	     						siftdata.getPredictionCategory() + "\t" +
                    	     						siftdata.getScoreSift() + "\t" +
                    	     						siftdata.getScoreConservation() + "\t" +
                    	     						siftdata.getProteinAlignNumber() + "\t" +
                    	     						siftdata.getTotalAlignSequenceNumber();

                    	     				errorRecords.add(errorRecord);

                    	     				//Wrapper.printMessage("Error No. " + error + " : SNP Id. " + siftdata.getSnpId() + " NOT FOUND : " + siftdata.toString(), MSGLEVEL, MSGLEVEL);
                    	     			}
                    	     			else {

                        	     			if ( snpchromosome21List.size() > 1 ) {
                        	     				
                        	     				error++;

                        	     				String errorRecord = "MULTIPLE SNPs!\t" + siftdata.getSnpId() + "\t" +
                        	     						siftdata.getEnsemblGene() + "\t" +
                        	     						siftdata.getEnsemblTranscript() + "\t" +
                        	     						siftdata.getEnsemblAnnotation() + "\t" +
                        	     						siftdata.getAminoAcidSubs() + "\t" +
                        	     						siftdata.getPredictionCategory() + "\t" +
                        	     						siftdata.getScoreSift() + "\t" +
                        	     						siftdata.getScoreConservation() + "\t" +
                        	     						siftdata.getProteinAlignNumber() + "\t" +
                        	     						siftdata.getTotalAlignSequenceNumber();

                        	     				errorRecords.add(errorRecord);

                        	     				//Wrapper.printMessage("Error No. " + error + " : SNP Id. " + siftdata.getSnpId() + " GREATER THAN 1 ROW FOR : " + siftdata.toString(), MSGLEVEL, MSGLEVEL);
                        	     			}
                        	     			else {

                                    	        Iterator<SNPChromosome> iteratorSNPChromosome = snpchromosome21List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome.hasNext()) {

                                    	     		SNPChromosome snpchromosome21 = iteratorSNPChromosome.next();
                                    	     		
                                    	     		snpchromosome21.setAminoAcidSubs(siftdata.getAminoAcidSubs());
                                    	     		snpchromosome21.setPredictionCategory(siftdata.getPredictionCategory());
                                    	     		snpchromosome21.setScoreSift(siftdata.getScoreSift());
                                    	     		snpchromosome21.setScoreConservation(siftdata.getScoreConservation());
                                    	     		snpchromosome21.setProteinAlignNumber(siftdata.getProteinAlignNumber());
                                    	     		snpchromosome21.setTotalAlignSequenceNumber(siftdata.getTotalAlignSequenceNumber());

                                    	     		serviceSNPChromosome.update(snpchromosome21);
                                    	     		
                                    	     		intSNPChromosomeCount21++;
                                    	        }
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( siftdata.isChromosome22() ) {

                    	                List<SNPChromosome> snpchromosome22List = new ArrayList<SNPChromosome>();

                    	     			snpchromosome22List = serviceSNPChromosome.findBySnpId(siftdata.getSnpId());
                    	     			
                    	     			if ( snpchromosome22List.isEmpty() ) {
                    	     				
                    	     				error++;

                    	     				String errorRecord = "SNP NOT FOUND!\t" + siftdata.getSnpId() + "\t" +
                    	     						siftdata.getEnsemblGene() + "\t" +
                    	     						siftdata.getEnsemblTranscript() + "\t" +
                    	     						siftdata.getEnsemblAnnotation() + "\t" +
                    	     						siftdata.getAminoAcidSubs() + "\t" +
                    	     						siftdata.getPredictionCategory() + "\t" +
                    	     						siftdata.getScoreSift() + "\t" +
                    	     						siftdata.getScoreConservation() + "\t" +
                    	     						siftdata.getProteinAlignNumber() + "\t" +
                    	     						siftdata.getTotalAlignSequenceNumber();

                    	     				errorRecords.add(errorRecord);

                    	     				//Wrapper.printMessage("Error No. " + error + " : SNP Id. " + siftdata.getSnpId() + " NOT FOUND : " + siftdata.toString(), MSGLEVEL, MSGLEVEL);
                    	     			}
                    	     			else {

                        	     			if ( snpchromosome22List.size() > 1 ) {
                        	     				
                        	     				error++;

                        	     				String errorRecord = "MULTIPLE SNPs!\t" + siftdata.getSnpId() + "\t" +
                        	     						siftdata.getEnsemblGene() + "\t" +
                        	     						siftdata.getEnsemblTranscript() + "\t" +
                        	     						siftdata.getEnsemblAnnotation() + "\t" +
                        	     						siftdata.getAminoAcidSubs() + "\t" +
                        	     						siftdata.getPredictionCategory() + "\t" +
                        	     						siftdata.getScoreSift() + "\t" +
                        	     						siftdata.getScoreConservation() + "\t" +
                        	     						siftdata.getProteinAlignNumber() + "\t" +
                        	     						siftdata.getTotalAlignSequenceNumber();

                        	     				errorRecords.add(errorRecord);

                        	     				//Wrapper.printMessage("Error No. " + error + " : SNP Id. " + siftdata.getSnpId() + " GREATER THAN 1 ROW FOR : " + siftdata.toString(), MSGLEVEL, MSGLEVEL);
                        	     			}
                        	     			else {

                                    	        Iterator<SNPChromosome> iteratorSNPChromosome = snpchromosome22List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome.hasNext()) {

                                    	     		SNPChromosome snpchromosome22 = iteratorSNPChromosome.next();
                                    	     		
                                    	     		snpchromosome22.setAminoAcidSubs(siftdata.getAminoAcidSubs());
                                    	     		snpchromosome22.setPredictionCategory(siftdata.getPredictionCategory());
                                    	     		snpchromosome22.setScoreSift(siftdata.getScoreSift());
                                    	     		snpchromosome22.setScoreConservation(siftdata.getScoreConservation());
                                    	     		snpchromosome22.setProteinAlignNumber(siftdata.getProteinAlignNumber());
                                    	     		snpchromosome22.setTotalAlignSequenceNumber(siftdata.getTotalAlignSequenceNumber());

                                    	     		serviceSNPChromosome.update(snpchromosome22);
                                    	     		
                                    	     		intSNPChromosomeCount22++;
                                    	     	}
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( siftdata.isChromosome23() ) {
                    	     			
                    	                List<SNPChromosome> snpchromosome23List = new ArrayList<SNPChromosome>();
                    	                
                    	                snpchromosome23List = serviceSNPChromosome.findBySnpId(siftdata.getSnpId());
                    	                
                    	     			if ( snpchromosome23List.isEmpty() ) {
                    	     				
                    	     				error++;

                    	     				String errorRecord = "SNP NOT FOUND!\t" + siftdata.getSnpId() + "\t" +
                    	     						siftdata.getEnsemblGene() + "\t" +
                    	     						siftdata.getEnsemblTranscript() + "\t" +
                    	     						siftdata.getEnsemblAnnotation() + "\t" +
                    	     						siftdata.getAminoAcidSubs() + "\t" +
                    	     						siftdata.getPredictionCategory() + "\t" +
                    	     						siftdata.getScoreSift() + "\t" +
                    	     						siftdata.getScoreConservation() + "\t" +
                    	     						siftdata.getProteinAlignNumber() + "\t" +
                    	     						siftdata.getTotalAlignSequenceNumber();

                    	     				errorRecords.add(errorRecord);

                    	     				//Wrapper.printMessage("Error No. " + error + " : SNP Id. " + siftdata.getSnpId() + " NOT FOUND : " + siftdata.toString(), MSGLEVEL, MSGLEVEL);
                    	     			}
                    	     			else {

                        	     			if ( snpchromosome23List.size() > 1 ) {
                        	     				
                        	     				error++;

                        	     				String errorRecord = "MULTIPLE SNPs!\t" + siftdata.getSnpId() + "\t" +
                        	     						siftdata.getEnsemblGene() + "\t" +
                        	     						siftdata.getEnsemblTranscript() + "\t" +
                        	     						siftdata.getEnsemblAnnotation() + "\t" +
                        	     						siftdata.getAminoAcidSubs() + "\t" +
                        	     						siftdata.getPredictionCategory() + "\t" +
                        	     						siftdata.getScoreSift() + "\t" +
                        	     						siftdata.getScoreConservation() + "\t" +
                        	     						siftdata.getProteinAlignNumber() + "\t" +
                        	     						siftdata.getTotalAlignSequenceNumber();

                        	     				errorRecords.add(errorRecord);

                        	     				//Wrapper.printMessage("Error No. " + error + " : SNP Id. " + siftdata.getSnpId() + " GREATER THAN 1 ROW FOR : " + siftdata.toString(), MSGLEVEL, MSGLEVEL);
                        	     			}
                        	     			else {

                                    	        Iterator<SNPChromosome> iteratorSNPChromosome = snpchromosome23List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome.hasNext()) {

                                    	     		SNPChromosome snpchromosome23 = iteratorSNPChromosome.next();
                                    	     		
                                    	     		snpchromosome23.setAminoAcidSubs(siftdata.getAminoAcidSubs());
                                    	     		snpchromosome23.setPredictionCategory(siftdata.getPredictionCategory());
                                    	     		snpchromosome23.setScoreSift(siftdata.getScoreSift());
                                    	     		snpchromosome23.setScoreConservation(siftdata.getScoreConservation());
                                    	     		snpchromosome23.setProteinAlignNumber(siftdata.getProteinAlignNumber());
                                    	     		snpchromosome23.setTotalAlignSequenceNumber(siftdata.getTotalAlignSequenceNumber());

                                    	     		serviceSNPChromosome.update(snpchromosome23);
                                    	     		
                                    	     		intSNPChromosomeCount23++;
                                    	     	}
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( siftdata.isChromosome24() ) {
                    	     			
                    	     			List<SNPChromosome> snpchromosome24List = new ArrayList<SNPChromosome>();

                    	                snpchromosome24List = serviceSNPChromosome.findBySnpId(siftdata.getSnpId());
                    	                
                    	     			if ( snpchromosome24List.isEmpty() ) {
                    	     				
                    	     				error++;

                    	     				String errorRecord = "SNP NOT FOUND!\t" + siftdata.getSnpId() + "\t" +
                    	     						siftdata.getEnsemblGene() + "\t" +
                    	     						siftdata.getEnsemblTranscript() + "\t" +
                    	     						siftdata.getEnsemblAnnotation() + "\t" +
                    	     						siftdata.getAminoAcidSubs() + "\t" +
                    	     						siftdata.getPredictionCategory() + "\t" +
                    	     						siftdata.getScoreSift() + "\t" +
                    	     						siftdata.getScoreConservation() + "\t" +
                    	     						siftdata.getProteinAlignNumber() + "\t" +
                    	     						siftdata.getTotalAlignSequenceNumber();

                    	     				errorRecords.add(errorRecord);

                    	     				//Wrapper.printMessage("Error No. " + error + " : SNP Id. " + siftdata.getSnpId() + " NOT FOUND : " + siftdata.toString(), MSGLEVEL, MSGLEVEL);
                    	     			}
                    	     			else {

                        	     			if ( snpchromosome24List.size() > 1 ) {
                        	     				
                        	     				error++;

                        	     				String errorRecord = "MULTIPLE SNPs!\t" + siftdata.getSnpId() + "\t" +
                        	     						siftdata.getEnsemblGene() + "\t" +
                        	     						siftdata.getEnsemblTranscript() + "\t" +
                        	     						siftdata.getEnsemblAnnotation() + "\t" +
                        	     						siftdata.getAminoAcidSubs() + "\t" +
                        	     						siftdata.getPredictionCategory() + "\t" +
                        	     						siftdata.getScoreSift() + "\t" +
                        	     						siftdata.getScoreConservation() + "\t" +
                        	     						siftdata.getProteinAlignNumber() + "\t" +
                        	     						siftdata.getTotalAlignSequenceNumber();

                        	     				errorRecords.add(errorRecord);

                        	     				//Wrapper.printMessage("Error No. " + error + " : SNP Id. " + siftdata.getSnpId() + " GREATER THAN 1 ROW FOR : " + siftdata.toString(), MSGLEVEL, MSGLEVEL);
                        	     			}
                        	     			else {

                                    	        Iterator<SNPChromosome> iteratorSNPChromosome = snpchromosome24List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome.hasNext()) {

                                    	     		SNPChromosome snpchromosome24 = iteratorSNPChromosome.next();
                                    	     		
                                    	     		snpchromosome24.setAminoAcidSubs(siftdata.getAminoAcidSubs());
                                    	     		snpchromosome24.setPredictionCategory(siftdata.getPredictionCategory());
                                    	     		snpchromosome24.setScoreSift(siftdata.getScoreSift());
                                    	     		snpchromosome24.setScoreConservation(siftdata.getScoreConservation());
                                    	     		snpchromosome24.setProteinAlignNumber(siftdata.getProteinAlignNumber());
                                    	     		snpchromosome24.setTotalAlignSequenceNumber(siftdata.getTotalAlignSequenceNumber());

                                    	     		serviceSNPChromosome.update(snpchromosome24);
                                    	     		
                                    	     		intSNPChromosomeCount24++;
                                    	     	}
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( siftdata.isChromosome25() ) {
                    	     			
                    	                List<SNPChromosome> snpchromosome25List = new ArrayList<SNPChromosome>();

                    	     			snpchromosome25List = serviceSNPChromosome.findBySnpId(siftdata.getSnpId());
                    	     			
                    	     			if ( snpchromosome25List.isEmpty() ) {
                    	     				
                    	     				error++;

                    	     				String errorRecord = "SNP NOT FOUND!\t" + siftdata.getSnpId() + "\t" +
                    	     						siftdata.getEnsemblGene() + "\t" +
                    	     						siftdata.getEnsemblTranscript() + "\t" +
                    	     						siftdata.getEnsemblAnnotation() + "\t" +
                    	     						siftdata.getAminoAcidSubs() + "\t" +
                    	     						siftdata.getPredictionCategory() + "\t" +
                    	     						siftdata.getScoreSift() + "\t" +
                    	     						siftdata.getScoreConservation() + "\t" +
                    	     						siftdata.getProteinAlignNumber() + "\t" +
                    	     						siftdata.getTotalAlignSequenceNumber();

                    	     				errorRecords.add(errorRecord);

                    	     				//Wrapper.printMessage("Error No. " + error + " : SNP Id. " + siftdata.getSnpId() + " NOT FOUND : " + siftdata.toString(), MSGLEVEL, MSGLEVEL);
                    	     			}
                    	     			else {

                        	     			if ( snpchromosome25List.size() > 1 ) {
                        	     				
                        	     				error++;

                        	     				String errorRecord = "MULTIPLE SNPs!\t" + siftdata.getSnpId() + "\t" +
                        	     						siftdata.getEnsemblGene() + "\t" +
                        	     						siftdata.getEnsemblTranscript() + "\t" +
                        	     						siftdata.getEnsemblAnnotation() + "\t" +
                        	     						siftdata.getAminoAcidSubs() + "\t" +
                        	     						siftdata.getPredictionCategory() + "\t" +
                        	     						siftdata.getScoreSift() + "\t" +
                        	     						siftdata.getScoreConservation() + "\t" +
                        	     						siftdata.getProteinAlignNumber() + "\t" +
                        	     						siftdata.getTotalAlignSequenceNumber();

                        	     				errorRecords.add(errorRecord);

                        	     				//Wrapper.printMessage("Error No. " + error + " : SNP Id. " + siftdata.getSnpId() + " GREATER THAN 1 ROW FOR : " + siftdata.toString(), MSGLEVEL, MSGLEVEL);
                        	     			}
                        	     			else {

                                    	        Iterator<SNPChromosome> iteratorSNPChromosome = snpchromosome25List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome.hasNext()) {

                                    	     		SNPChromosome snpchromosome25 = iteratorSNPChromosome.next();
                                    	     		
                                    	     		snpchromosome25.setAminoAcidSubs(siftdata.getAminoAcidSubs());
                                    	     		snpchromosome25.setPredictionCategory(siftdata.getPredictionCategory());
                                    	     		snpchromosome25.setScoreSift(siftdata.getScoreSift());
                                    	     		snpchromosome25.setScoreConservation(siftdata.getScoreConservation());
                                    	     		snpchromosome25.setProteinAlignNumber(siftdata.getProteinAlignNumber());
                                    	     		snpchromosome25.setTotalAlignSequenceNumber(siftdata.getTotalAlignSequenceNumber());

                                    	     		serviceSNPChromosome.update(snpchromosome25);
                                    	     		
                                    	     		intSNPChromosomeCount25++;
                                    	     	}
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( siftdata.isChromosome26() ) {

                    	                List<SNPChromosome> snpchromosome26List = new ArrayList<SNPChromosome>();

                    	     			snpchromosome26List = serviceSNPChromosome.findBySnpId(siftdata.getSnpId());
                    	     			
                    	     			if ( snpchromosome26List.isEmpty() ) {
                    	     				
                    	     				error++;

                    	     				String errorRecord = "SNP NOT FOUND!\t" + siftdata.getSnpId() + "\t" +
                    	     						siftdata.getEnsemblGene() + "\t" +
                    	     						siftdata.getEnsemblTranscript() + "\t" +
                    	     						siftdata.getEnsemblAnnotation() + "\t" +
                    	     						siftdata.getAminoAcidSubs() + "\t" +
                    	     						siftdata.getPredictionCategory() + "\t" +
                    	     						siftdata.getScoreSift() + "\t" +
                    	     						siftdata.getScoreConservation() + "\t" +
                    	     						siftdata.getProteinAlignNumber() + "\t" +
                    	     						siftdata.getTotalAlignSequenceNumber();

                    	     				errorRecords.add(errorRecord);

                    	     				//Wrapper.printMessage("Error No. " + error + " : SNP Id. " + siftdata.getSnpId() + " NOT FOUND : " + siftdata.toString(), MSGLEVEL, MSGLEVEL);
                    	     			}
                    	     			else {

                        	     			if ( snpchromosome26List.size() > 1 ) {
                        	     				
                        	     				error++;

                        	     				String errorRecord = "MULTIPLE SNPs!\t" + siftdata.getSnpId() + "\t" +
                        	     						siftdata.getEnsemblGene() + "\t" +
                        	     						siftdata.getEnsemblTranscript() + "\t" +
                        	     						siftdata.getEnsemblAnnotation() + "\t" +
                        	     						siftdata.getAminoAcidSubs() + "\t" +
                        	     						siftdata.getPredictionCategory() + "\t" +
                        	     						siftdata.getScoreSift() + "\t" +
                        	     						siftdata.getScoreConservation() + "\t" +
                        	     						siftdata.getProteinAlignNumber() + "\t" +
                        	     						siftdata.getTotalAlignSequenceNumber();

                        	     				errorRecords.add(errorRecord);

                        	     				//Wrapper.printMessage("Error No. " + error + " : SNP Id. " + siftdata.getSnpId() + " GREATER THAN 1 ROW FOR : " + siftdata.toString(), MSGLEVEL, MSGLEVEL);
                        	     			}
                        	     			else {

                                    	        Iterator<SNPChromosome> iteratorSNPChromosome = snpchromosome26List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome.hasNext()) {

                                    	     		SNPChromosome snpchromosome26 = iteratorSNPChromosome.next();
                                    	     		
                                    	     		snpchromosome26.setAminoAcidSubs(siftdata.getAminoAcidSubs());
                                    	     		snpchromosome26.setPredictionCategory(siftdata.getPredictionCategory());
                                    	     		snpchromosome26.setScoreSift(siftdata.getScoreSift());
                                    	     		snpchromosome26.setScoreConservation(siftdata.getScoreConservation());
                                    	     		snpchromosome26.setProteinAlignNumber(siftdata.getProteinAlignNumber());
                                    	     		snpchromosome26.setTotalAlignSequenceNumber(siftdata.getTotalAlignSequenceNumber());

                                    	     		serviceSNPChromosome.update(snpchromosome26);
                                    	     		
                                    	     		intSNPChromosomeCount26++;
                                    	     	}
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( siftdata.isChromosome27() ) {
                    	     			
                    	                List<SNPChromosome> snpchromosome27List = new ArrayList<SNPChromosome>();

                    	     			snpchromosome27List = serviceSNPChromosome.findBySnpId(siftdata.getSnpId());
                    	     			
                    	     			if ( snpchromosome27List.isEmpty() ) {
                    	     				
                    	     				error++;

                    	     				String errorRecord = "SNP NOT FOUND!\t" + siftdata.getSnpId() + "\t" +
                    	     						siftdata.getEnsemblGene() + "\t" +
                    	     						siftdata.getEnsemblTranscript() + "\t" +
                    	     						siftdata.getEnsemblAnnotation() + "\t" +
                    	     						siftdata.getAminoAcidSubs() + "\t" +
                    	     						siftdata.getPredictionCategory() + "\t" +
                    	     						siftdata.getScoreSift() + "\t" +
                    	     						siftdata.getScoreConservation() + "\t" +
                    	     						siftdata.getProteinAlignNumber() + "\t" +
                    	     						siftdata.getTotalAlignSequenceNumber();

                    	     				errorRecords.add(errorRecord);

                    	     				//Wrapper.printMessage("Error No. " + error + " : SNP Id. " + siftdata.getSnpId() + " NOT FOUND : " + siftdata.toString(), MSGLEVEL, MSGLEVEL);
                    	     			}
                    	     			else {

                        	     			if ( snpchromosome27List.size() > 1 ) {
                        	     				
                        	     				error++;

                        	     				String errorRecord = "MULTIPLE SNPs!\t" + siftdata.getSnpId() + "\t" +
                        	     						siftdata.getEnsemblGene() + "\t" +
                        	     						siftdata.getEnsemblTranscript() + "\t" +
                        	     						siftdata.getEnsemblAnnotation() + "\t" +
                        	     						siftdata.getAminoAcidSubs() + "\t" +
                        	     						siftdata.getPredictionCategory() + "\t" +
                        	     						siftdata.getScoreSift() + "\t" +
                        	     						siftdata.getScoreConservation() + "\t" +
                        	     						siftdata.getProteinAlignNumber() + "\t" +
                        	     						siftdata.getTotalAlignSequenceNumber();

                        	     				errorRecords.add(errorRecord);

                        	     				//Wrapper.printMessage("Error No. " + error + " : SNP Id. " + siftdata.getSnpId() + " GREATER THAN 1 ROW FOR : " + siftdata.toString(), MSGLEVEL, MSGLEVEL);
                        	     			}
                        	     			else {

                                    	        Iterator<SNPChromosome> iteratorSNPChromosome = snpchromosome27List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome.hasNext()) {

                                    	     		SNPChromosome snpchromosome27 = iteratorSNPChromosome.next();
                                    	     		
                                    	     		snpchromosome27.setAminoAcidSubs(siftdata.getAminoAcidSubs());
                                    	     		snpchromosome27.setPredictionCategory(siftdata.getPredictionCategory());
                                    	     		snpchromosome27.setScoreSift(siftdata.getScoreSift());
                                    	     		snpchromosome27.setScoreConservation(siftdata.getScoreConservation());
                                    	     		snpchromosome27.setProteinAlignNumber(siftdata.getProteinAlignNumber());
                                    	     		snpchromosome27.setTotalAlignSequenceNumber(siftdata.getTotalAlignSequenceNumber());

                                    	     		serviceSNPChromosome.update(snpchromosome27);
                                    	     		
                                    	     		intSNPChromosomeCount27++;
                                    	     	}
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( siftdata.isChromosome28() ) {

                    	                List<SNPChromosome> snpchromosome28List = new ArrayList<SNPChromosome>();

                    	     			snpchromosome28List = serviceSNPChromosome.findBySnpId(siftdata.getSnpId());
                    	     			
                    	     			if ( snpchromosome28List.isEmpty() ) {
                    	     				
                    	     				error++;

                    	     				String errorRecord = "SNP NOT FOUND!\t" + siftdata.getSnpId() + "\t" +
                    	     						siftdata.getEnsemblGene() + "\t" +
                    	     						siftdata.getEnsemblTranscript() + "\t" +
                    	     						siftdata.getEnsemblAnnotation() + "\t" +
                    	     						siftdata.getAminoAcidSubs() + "\t" +
                    	     						siftdata.getPredictionCategory() + "\t" +
                    	     						siftdata.getScoreSift() + "\t" +
                    	     						siftdata.getScoreConservation() + "\t" +
                    	     						siftdata.getProteinAlignNumber() + "\t" +
                    	     						siftdata.getTotalAlignSequenceNumber();

                    	     				errorRecords.add(errorRecord);

                    	     				//Wrapper.printMessage("Error No. " + error + " : SNP Id. " + siftdata.getSnpId() + " NOT FOUND : " + siftdata.toString(), MSGLEVEL, MSGLEVEL);
                    	     			}
                    	     			else {

                        	     			if ( snpchromosome28List.size() > 1 ) {
                        	     				
                        	     				error++;

                        	     				String errorRecord = "MULTIPLE SNPs!\t" + siftdata.getSnpId() + "\t" +
                        	     						siftdata.getEnsemblGene() + "\t" +
                        	     						siftdata.getEnsemblTranscript() + "\t" +
                        	     						siftdata.getEnsemblAnnotation() + "\t" +
                        	     						siftdata.getAminoAcidSubs() + "\t" +
                        	     						siftdata.getPredictionCategory() + "\t" +
                        	     						siftdata.getScoreSift() + "\t" +
                        	     						siftdata.getScoreConservation() + "\t" +
                        	     						siftdata.getProteinAlignNumber() + "\t" +
                        	     						siftdata.getTotalAlignSequenceNumber();

                        	     				errorRecords.add(errorRecord);

                        	     				//Wrapper.printMessage("Error No. " + error + " : SNP Id. " + siftdata.getSnpId() + " GREATER THAN 1 ROW FOR : " + siftdata.toString(), MSGLEVEL, MSGLEVEL);
                        	     			}
                        	     			else {

                                    	        Iterator<SNPChromosome> iteratorSNPChromosome = snpchromosome28List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome.hasNext()) {

                                    	     		SNPChromosome snpchromosome28 = iteratorSNPChromosome.next();
                                    	     		
                                    	     		snpchromosome28.setAminoAcidSubs(siftdata.getAminoAcidSubs());
                                    	     		snpchromosome28.setPredictionCategory(siftdata.getPredictionCategory());
                                    	     		snpchromosome28.setScoreSift(siftdata.getScoreSift());
                                    	     		snpchromosome28.setScoreConservation(siftdata.getScoreConservation());
                                    	     		snpchromosome28.setProteinAlignNumber(siftdata.getProteinAlignNumber());
                                    	     		snpchromosome28.setTotalAlignSequenceNumber(siftdata.getTotalAlignSequenceNumber());

                                    	     		serviceSNPChromosome.update(snpchromosome28);
                                    	     		
                                    	     		intSNPChromosomeCount28++;
                                    	     	}
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( siftdata.isChromosome32() ) {
                    	     			
                    	                List<SNPChromosome> snpchromosome32List = new ArrayList<SNPChromosome>();

                    	     			snpchromosome32List = serviceSNPChromosome.findBySnpId(siftdata.getSnpId());
                    	     			
                    	     			if ( snpchromosome32List.isEmpty() ) {
                    	     				
                    	     				error++;

                    	     				String errorRecord = "SNP NOT FOUND!\t" + siftdata.getSnpId() + "\t" +
                    	     						siftdata.getEnsemblGene() + "\t" +
                    	     						siftdata.getEnsemblTranscript() + "\t" +
                    	     						siftdata.getEnsemblAnnotation() + "\t" +
                    	     						siftdata.getAminoAcidSubs() + "\t" +
                    	     						siftdata.getPredictionCategory() + "\t" +
                    	     						siftdata.getScoreSift() + "\t" +
                    	     						siftdata.getScoreConservation() + "\t" +
                    	     						siftdata.getProteinAlignNumber() + "\t" +
                    	     						siftdata.getTotalAlignSequenceNumber();

                    	     				errorRecords.add(errorRecord);

                    	     				//Wrapper.printMessage("Error No. " + error + " : SNP Id. " + siftdata.getSnpId() + " NOT FOUND : " + siftdata.toString(), MSGLEVEL, MSGLEVEL);
                    	     			}
                    	     			else {

                        	     			if ( snpchromosome32List.size() > 1 ) {
                        	     				
                        	     				error++;

                        	     				String errorRecord = "MULTIPLE SNPs!\t" + siftdata.getSnpId() + "\t" +
                        	     						siftdata.getEnsemblGene() + "\t" +
                        	     						siftdata.getEnsemblTranscript() + "\t" +
                        	     						siftdata.getEnsemblAnnotation() + "\t" +
                        	     						siftdata.getAminoAcidSubs() + "\t" +
                        	     						siftdata.getPredictionCategory() + "\t" +
                        	     						siftdata.getScoreSift() + "\t" +
                        	     						siftdata.getScoreConservation() + "\t" +
                        	     						siftdata.getProteinAlignNumber() + "\t" +
                        	     						siftdata.getTotalAlignSequenceNumber();

                        	     				errorRecords.add(errorRecord);

                        	     				//Wrapper.printMessage("Error No. " + error + " : SNP Id. " + siftdata.getSnpId() + " GREATER THAN 1 ROW FOR : " + siftdata.toString(), MSGLEVEL, MSGLEVEL);
                        	     			}
                        	     			else {

                                    	        Iterator<SNPChromosome> iteratorSNPChromosome = snpchromosome32List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome.hasNext()) {

                                    	     		SNPChromosome snpchromosome32 = iteratorSNPChromosome.next();
                                    	     		
                                    	     		snpchromosome32.setAminoAcidSubs(siftdata.getAminoAcidSubs());
                                    	     		snpchromosome32.setPredictionCategory(siftdata.getPredictionCategory());
                                    	     		snpchromosome32.setScoreSift(siftdata.getScoreSift());
                                    	     		snpchromosome32.setScoreConservation(siftdata.getScoreConservation());
                                    	     		snpchromosome32.setProteinAlignNumber(siftdata.getProteinAlignNumber());
                                    	     		snpchromosome32.setTotalAlignSequenceNumber(siftdata.getTotalAlignSequenceNumber());

                                    	     		serviceSNPChromosome.update(snpchromosome32);
                                    	     		
                                    	     		intSNPChromosomeCount32++;
                                    	     	}
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( siftdata.isChromosomeLGE64() ) {
                    	     			
                    	                List<SNPChromosome> snpchromosomeLGE64List = new ArrayList<SNPChromosome>();

                    	     			snpchromosomeLGE64List = serviceSNPChromosome.findBySnpId(siftdata.getSnpId());
                    	     			
                    	     			if ( snpchromosomeLGE64List.isEmpty() ) {
                    	     				
                    	     				error++;

                    	     				String errorRecord = "SNP NOT FOUND!\t" + siftdata.getSnpId() + "\t" +
                    	     						siftdata.getEnsemblGene() + "\t" +
                    	     						siftdata.getEnsemblTranscript() + "\t" +
                    	     						siftdata.getEnsemblAnnotation() + "\t" +
                    	     						siftdata.getAminoAcidSubs() + "\t" +
                    	     						siftdata.getPredictionCategory() + "\t" +
                    	     						siftdata.getScoreSift() + "\t" +
                    	     						siftdata.getScoreConservation() + "\t" +
                    	     						siftdata.getProteinAlignNumber() + "\t" +
                    	     						siftdata.getTotalAlignSequenceNumber();

                    	     				errorRecords.add(errorRecord);

                    	     				//Wrapper.printMessage("Error No. " + error + " : SNP Id. " + siftdata.getSnpId() + " NOT FOUND : " + siftdata.toString(), MSGLEVEL, MSGLEVEL);
                    	     			}
                    	     			else {

                        	     			if ( snpchromosomeLGE64List.size() > 1 ) {
                        	     				
                        	     				error++;

                        	     				String errorRecord = "MULTIPLE SNPs!\t" + siftdata.getSnpId() + "\t" +
                        	     						siftdata.getEnsemblGene() + "\t" +
                        	     						siftdata.getEnsemblTranscript() + "\t" +
                        	     						siftdata.getEnsemblAnnotation() + "\t" +
                        	     						siftdata.getAminoAcidSubs() + "\t" +
                        	     						siftdata.getPredictionCategory() + "\t" +
                        	     						siftdata.getScoreSift() + "\t" +
                        	     						siftdata.getScoreConservation() + "\t" +
                        	     						siftdata.getProteinAlignNumber() + "\t" +
                        	     						siftdata.getTotalAlignSequenceNumber();

                        	     				errorRecords.add(errorRecord);

                        	     				//Wrapper.printMessage("Error No. " + error + " : SNP Id. " + siftdata.getSnpId() + " GREATER THAN 1 ROW FOR : " + siftdata.toString(), MSGLEVEL, MSGLEVEL);
                        	     			}
                        	     			else {

                                    	        Iterator<SNPChromosome> iteratorSNPChromosome = snpchromosomeLGE64List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome.hasNext()) {

                                    	     		SNPChromosome snpchromosomeLGE64 = iteratorSNPChromosome.next();
                                    	     		
                                    	     		snpchromosomeLGE64.setAminoAcidSubs(siftdata.getAminoAcidSubs());
                                    	     		snpchromosomeLGE64.setPredictionCategory(siftdata.getPredictionCategory());
                                    	     		snpchromosomeLGE64.setScoreSift(siftdata.getScoreSift());
                                    	     		snpchromosomeLGE64.setScoreConservation(siftdata.getScoreConservation());
                                    	     		snpchromosomeLGE64.setProteinAlignNumber(siftdata.getProteinAlignNumber());
                                    	     		snpchromosomeLGE64.setTotalAlignSequenceNumber(siftdata.getTotalAlignSequenceNumber());

                                    	     		serviceSNPChromosome.update(snpchromosomeLGE64);
                                    	     		
                                    	     		intSNPChromosomeCountLGE64++;
                                    	     	}
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( siftdata.isChromosomeLGE22C19W28_E50C23() ) {
                    	     			
                    	                List<SNPChromosome> snpchromosomeLGE22C19W28_E50C23List = new ArrayList<SNPChromosome>();

                    	     			snpchromosomeLGE22C19W28_E50C23List = serviceSNPChromosome.findBySnpId(siftdata.getSnpId());
                    	     			
                    	     			if ( snpchromosomeLGE22C19W28_E50C23List.isEmpty() ) {
                    	     				
                    	     				error++;

                    	     				String errorRecord = "SNP NOT FOUND!\t" + siftdata.getSnpId() + "\t" +
                    	     						siftdata.getEnsemblGene() + "\t" +
                    	     						siftdata.getEnsemblTranscript() + "\t" +
                    	     						siftdata.getEnsemblAnnotation() + "\t" +
                    	     						siftdata.getAminoAcidSubs() + "\t" +
                    	     						siftdata.getPredictionCategory() + "\t" +
                    	     						siftdata.getScoreSift() + "\t" +
                    	     						siftdata.getScoreConservation() + "\t" +
                    	     						siftdata.getProteinAlignNumber() + "\t" +
                    	     						siftdata.getTotalAlignSequenceNumber();

                    	     				errorRecords.add(errorRecord);

                    	     				//Wrapper.printMessage("Error No. " + error + " : SNP Id. " + siftdata.getSnpId() + " NOT FOUND : " + siftdata.toString(), MSGLEVEL, MSGLEVEL);
                    	     			}
                    	     			else {

                        	     			if ( snpchromosomeLGE22C19W28_E50C23List.size() > 1 ) {
                        	     				
                        	     				error++;

                        	     				String errorRecord = "MULTIPLE SNPs!\t" + siftdata.getSnpId() + "\t" +
                        	     						siftdata.getEnsemblGene() + "\t" +
                        	     						siftdata.getEnsemblTranscript() + "\t" +
                        	     						siftdata.getEnsemblAnnotation() + "\t" +
                        	     						siftdata.getAminoAcidSubs() + "\t" +
                        	     						siftdata.getPredictionCategory() + "\t" +
                        	     						siftdata.getScoreSift() + "\t" +
                        	     						siftdata.getScoreConservation() + "\t" +
                        	     						siftdata.getProteinAlignNumber() + "\t" +
                        	     						siftdata.getTotalAlignSequenceNumber();

                        	     				errorRecords.add(errorRecord);

                        	     				//Wrapper.printMessage("Error No. " + error + " : SNP Id. " + siftdata.getSnpId() + " GREATER THAN 1 ROW FOR : " + siftdata.toString(), MSGLEVEL, MSGLEVEL);
                        	     			}
                        	     			else {

                                    	        Iterator<SNPChromosome> iteratorSNPChromosome = snpchromosomeLGE22C19W28_E50C23List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome.hasNext()) {

                                    	     		SNPChromosome snpchromosomeLGE22C19W28_E50C23 = iteratorSNPChromosome.next();
                                    	     		
                                    	     		snpchromosomeLGE22C19W28_E50C23.setAminoAcidSubs(siftdata.getAminoAcidSubs());
                                    	     		snpchromosomeLGE22C19W28_E50C23.setPredictionCategory(siftdata.getPredictionCategory());
                                    	     		snpchromosomeLGE22C19W28_E50C23.setScoreSift(siftdata.getScoreSift());
                                    	     		snpchromosomeLGE22C19W28_E50C23.setScoreConservation(siftdata.getScoreConservation());
                                    	     		snpchromosomeLGE22C19W28_E50C23.setProteinAlignNumber(siftdata.getProteinAlignNumber());
                                    	     		snpchromosomeLGE22C19W28_E50C23.setTotalAlignSequenceNumber(siftdata.getTotalAlignSequenceNumber());

                                    	     		serviceSNPChromosome.update(snpchromosomeLGE22C19W28_E50C23);
                                    	     		
                                    	     		intSNPChromosomeCountLGE22C19W28_E50C23++;
                                    	     	}
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( siftdata.isChromosomeW() ) {
                    	     			
                    	                List<SNPChromosome> snpchromosomeWList = new ArrayList<SNPChromosome>();

                    	     			snpchromosomeWList = serviceSNPChromosome.findBySnpId(siftdata.getSnpId());
                    	     			
                    	     			if ( snpchromosomeWList.isEmpty() ) {
                    	     				
                    	     				error++;

                    	     				String errorRecord = "SNP NOT FOUND!\t" + siftdata.getSnpId() + "\t" +
                    	     						siftdata.getEnsemblGene() + "\t" +
                    	     						siftdata.getEnsemblTranscript() + "\t" +
                    	     						siftdata.getEnsemblAnnotation() + "\t" +
                    	     						siftdata.getAminoAcidSubs() + "\t" +
                    	     						siftdata.getPredictionCategory() + "\t" +
                    	     						siftdata.getScoreSift() + "\t" +
                    	     						siftdata.getScoreConservation() + "\t" +
                    	     						siftdata.getProteinAlignNumber() + "\t" +
                    	     						siftdata.getTotalAlignSequenceNumber();

                    	     				errorRecords.add(errorRecord);

                    	     				//Wrapper.printMessage("Error No. " + error + " : SNP Id. " + siftdata.getSnpId() + " NOT FOUND : " + siftdata.toString(), MSGLEVEL, MSGLEVEL);
                    	     			}
                    	     			else {

                        	     			if ( snpchromosomeWList.size() > 1 ) {
                        	     				
                        	     				error++;

                        	     				String errorRecord = "MULTIPLE SNPs!\t" + siftdata.getSnpId() + "\t" +
                        	     						siftdata.getEnsemblGene() + "\t" +
                        	     						siftdata.getEnsemblTranscript() + "\t" +
                        	     						siftdata.getEnsemblAnnotation() + "\t" +
                        	     						siftdata.getAminoAcidSubs() + "\t" +
                        	     						siftdata.getPredictionCategory() + "\t" +
                        	     						siftdata.getScoreSift() + "\t" +
                        	     						siftdata.getScoreConservation() + "\t" +
                        	     						siftdata.getProteinAlignNumber() + "\t" +
                        	     						siftdata.getTotalAlignSequenceNumber();

                        	     				errorRecords.add(errorRecord);

                        	     				//Wrapper.printMessage("Error No. " + error + " : SNP Id. " + siftdata.getSnpId() + " GREATER THAN 1 ROW FOR : " + siftdata.toString(), MSGLEVEL, MSGLEVEL);
                        	     			}
                        	     			else {

                                    	        Iterator<SNPChromosome> iteratorSNPChromosome = snpchromosomeWList.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome.hasNext()) {

                                    	     		SNPChromosome snpchromosomeW = iteratorSNPChromosome.next();
                                    	     		
                                    	     		snpchromosomeW.setAminoAcidSubs(siftdata.getAminoAcidSubs());
                                    	     		snpchromosomeW.setPredictionCategory(siftdata.getPredictionCategory());
                                    	     		snpchromosomeW.setScoreSift(siftdata.getScoreSift());
                                    	     		snpchromosomeW.setScoreConservation(siftdata.getScoreConservation());
                                    	     		snpchromosomeW.setProteinAlignNumber(siftdata.getProteinAlignNumber());
                                    	     		snpchromosomeW.setTotalAlignSequenceNumber(siftdata.getTotalAlignSequenceNumber());

                                    	     		serviceSNPChromosome.update(snpchromosomeW);
                                    	     		
                                    	     		intSNPChromosomeCountW++;
                                    	     	}
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( siftdata.isChromosomeZ() ) {
                    	     			
                    	                List<SNPChromosome> snpchromosomeZList = new ArrayList<SNPChromosome>();

                    	     			snpchromosomeZList = serviceSNPChromosome.findBySnpId(siftdata.getSnpId());
                    	     			
                    	     			if ( snpchromosomeZList.isEmpty() ) {
                    	     				
                    	     				error++;

                    	     				String errorRecord = "SNP NOT FOUND!\t" + siftdata.getSnpId() + "\t" +
                    	     						siftdata.getEnsemblGene() + "\t" +
                    	     						siftdata.getEnsemblTranscript() + "\t" +
                    	     						siftdata.getEnsemblAnnotation() + "\t" +
                    	     						siftdata.getAminoAcidSubs() + "\t" +
                    	     						siftdata.getPredictionCategory() + "\t" +
                    	     						siftdata.getScoreSift() + "\t" +
                    	     						siftdata.getScoreConservation() + "\t" +
                    	     						siftdata.getProteinAlignNumber() + "\t" +
                    	     						siftdata.getTotalAlignSequenceNumber();

                    	     				errorRecords.add(errorRecord);

                    	     				//Wrapper.printMessage("Error No. " + error + " : SNP Id. " + siftdata.getSnpId() + " NOT FOUND : " + siftdata.toString(), MSGLEVEL, MSGLEVEL);
                    	     			}
                    	     			else {

                        	     			if ( snpchromosomeZList.size() > 1 ) {
                        	     				
                        	     				error++;

                        	     				String errorRecord = "MULTIPLE SNPs!\t" + siftdata.getSnpId() + "\t" +
                        	     						siftdata.getEnsemblGene() + "\t" +
                        	     						siftdata.getEnsemblTranscript() + "\t" +
                        	     						siftdata.getEnsemblAnnotation() + "\t" +
                        	     						siftdata.getAminoAcidSubs() + "\t" +
                        	     						siftdata.getPredictionCategory() + "\t" +
                        	     						siftdata.getScoreSift() + "\t" +
                        	     						siftdata.getScoreConservation() + "\t" +
                        	     						siftdata.getProteinAlignNumber() + "\t" +
                        	     						siftdata.getTotalAlignSequenceNumber();

                        	     				errorRecords.add(errorRecord);

                        	     				//Wrapper.printMessage("Error No. " + error + " : SNP Id. " + siftdata.getSnpId() + " GREATER THAN 1 ROW FOR : " + siftdata.toString(), MSGLEVEL, MSGLEVEL);
                        	     			}
                        	     			else {
                        	     				
                            	     			Iterator<SNPChromosome> iteratorSNPChromosome = snpchromosomeZList.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome.hasNext()) {

                                    	     		SNPChromosome snpchromosomeZ = iteratorSNPChromosome.next();
                                    	     		
                                    	     		snpchromosomeZ.setAminoAcidSubs(siftdata.getAminoAcidSubs());
                                    	     		snpchromosomeZ.setPredictionCategory(siftdata.getPredictionCategory());
                                    	     		snpchromosomeZ.setScoreSift(siftdata.getScoreSift());
                                    	     		snpchromosomeZ.setScoreConservation(siftdata.getScoreConservation());
                                    	     		snpchromosomeZ.setProteinAlignNumber(siftdata.getProteinAlignNumber());
                                    	     		snpchromosomeZ.setTotalAlignSequenceNumber(siftdata.getTotalAlignSequenceNumber());

                                    	     		serviceSNPChromosome.update(snpchromosomeZ);
                                    	     		
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
            		
        			Wrapper.printMessage(StringUtility.pad(totalRecordCount, 8, PAD_CHAR) + " to be updated from " + totalFileCount + " files in Directory " + directory, MSGLEVEL, MSGLEVEL);

        			Wrapper.printMessage(StringUtility.pad(error, 8, PAD_CHAR) + " Error Records IGNORED!", MSGLEVEL, MSGLEVEL);
            		
             		Wrapper.printMessage(StringUtility.pad(intSNPChromosomeCount01, 8, PAD_CHAR) + " Records updated into SNPChromosomeCount01", MSGLEVEL, MSGLEVEL);
             		Wrapper.printMessage(StringUtility.pad(intSNPChromosomeCount02, 8, PAD_CHAR) + " Records updated into SNPChromosomeCount02", MSGLEVEL, MSGLEVEL);
            		Wrapper.printMessage(StringUtility.pad(intSNPChromosomeCount03, 8, PAD_CHAR) + " Records updated into SNPChromosomeCount03", MSGLEVEL, MSGLEVEL);
            		Wrapper.printMessage(StringUtility.pad(intSNPChromosomeCount04, 8, PAD_CHAR) + " Records updated into SNPChromosomeCount04", MSGLEVEL, MSGLEVEL);
             		Wrapper.printMessage(StringUtility.pad(intSNPChromosomeCount05, 8, PAD_CHAR) + " Records updated into SNPChromosomeCount05", MSGLEVEL, MSGLEVEL);
            		Wrapper.printMessage(StringUtility.pad(intSNPChromosomeCount06, 8, PAD_CHAR) + " Records updated into SNPChromosomeCount06", MSGLEVEL, MSGLEVEL);
            		Wrapper.printMessage(StringUtility.pad(intSNPChromosomeCount07, 8, PAD_CHAR) + " Records updated into SNPChromosomeCount07", MSGLEVEL, MSGLEVEL);
            		Wrapper.printMessage(StringUtility.pad(intSNPChromosomeCount08, 8, PAD_CHAR) + " Records updated into SNPChromosomeCount08", MSGLEVEL, MSGLEVEL);
            		Wrapper.printMessage(StringUtility.pad(intSNPChromosomeCount09, 8, PAD_CHAR) + " Records updated into SNPChromosomeCount09", MSGLEVEL, MSGLEVEL);
            		Wrapper.printMessage(StringUtility.pad(intSNPChromosomeCount10, 8, PAD_CHAR) + " Records updated into SNPChromosomeCount10", MSGLEVEL, MSGLEVEL);
            		Wrapper.printMessage(StringUtility.pad(intSNPChromosomeCount11, 8, PAD_CHAR) + " Records updated into SNPChromosomeCount11", MSGLEVEL, MSGLEVEL);
            		Wrapper.printMessage(StringUtility.pad(intSNPChromosomeCount12, 8, PAD_CHAR) + " Records updated into SNPChromosomeCount12", MSGLEVEL, MSGLEVEL);
            		Wrapper.printMessage(StringUtility.pad(intSNPChromosomeCount13, 8, PAD_CHAR) + " Records updated into SNPChromosomeCount13", MSGLEVEL, MSGLEVEL);
            		Wrapper.printMessage(StringUtility.pad(intSNPChromosomeCount14, 8, PAD_CHAR) + " Records updated into SNPChromosomeCount14", MSGLEVEL, MSGLEVEL);
            		Wrapper.printMessage(StringUtility.pad(intSNPChromosomeCount15, 8, PAD_CHAR) + " Records updated into SNPChromosomeCount15", MSGLEVEL, MSGLEVEL);
            		Wrapper.printMessage(StringUtility.pad(intSNPChromosomeCount16, 8, PAD_CHAR) + " Records updated into SNPChromosomeCount16", MSGLEVEL, MSGLEVEL);
            		Wrapper.printMessage(StringUtility.pad(intSNPChromosomeCount17, 8, PAD_CHAR) + " Records updated into SNPChromosomeCount17", MSGLEVEL, MSGLEVEL);
            		Wrapper.printMessage(StringUtility.pad(intSNPChromosomeCount18, 8, PAD_CHAR) + " Records updated into SNPChromosomeCount18", MSGLEVEL, MSGLEVEL);
            		Wrapper.printMessage(StringUtility.pad(intSNPChromosomeCount19, 8, PAD_CHAR) + " Records updated into SNPChromosomeCount19", MSGLEVEL, MSGLEVEL);
            		Wrapper.printMessage(StringUtility.pad(intSNPChromosomeCount20, 8, PAD_CHAR) + " Records updated into SNPChromosomeCount20", MSGLEVEL, MSGLEVEL);
            		Wrapper.printMessage(StringUtility.pad(intSNPChromosomeCount21, 8, PAD_CHAR) + " Records updated into SNPChromosomeCount21", MSGLEVEL, MSGLEVEL);
            		Wrapper.printMessage(StringUtility.pad(intSNPChromosomeCount22, 8, PAD_CHAR) + " Records updated into SNPChromosomeCount22", MSGLEVEL, MSGLEVEL);
            		Wrapper.printMessage(StringUtility.pad(intSNPChromosomeCount23, 8, PAD_CHAR) + " Records updated into SNPChromosomeCount23", MSGLEVEL, MSGLEVEL);
            		Wrapper.printMessage(StringUtility.pad(intSNPChromosomeCount24, 8, PAD_CHAR) + " Records updated into SNPChromosomeCount24", MSGLEVEL, MSGLEVEL);
            		Wrapper.printMessage(StringUtility.pad(intSNPChromosomeCount25, 8, PAD_CHAR) + " Records updated into SNPChromosomeCount25", MSGLEVEL, MSGLEVEL);
            		Wrapper.printMessage(StringUtility.pad(intSNPChromosomeCount26, 8, PAD_CHAR) + " Records updated into SNPChromosomeCount26", MSGLEVEL, MSGLEVEL);
            		Wrapper.printMessage(StringUtility.pad(intSNPChromosomeCount27, 8, PAD_CHAR) + " Records updated into SNPChromosomeCount27", MSGLEVEL, MSGLEVEL);
            		Wrapper.printMessage(StringUtility.pad(intSNPChromosomeCount28, 8, PAD_CHAR) + " Records updated into SNPChromosomeCount28", MSGLEVEL, MSGLEVEL);
            		Wrapper.printMessage(StringUtility.pad(intSNPChromosomeCount32, 8, PAD_CHAR) + " Records updated into SNPChromosomeCount32", MSGLEVEL, MSGLEVEL);
            		Wrapper.printMessage(StringUtility.pad(intSNPChromosomeCountLGE22C19W28_E50C23, 8, PAD_CHAR) + " Records updated into SNPChromosomeCountLGE22C19W28_E50C23", MSGLEVEL, MSGLEVEL);
            		Wrapper.printMessage(StringUtility.pad(intSNPChromosomeCountLGE64, 8, PAD_CHAR) + " Records updated into SNPChromosomeCountLGE64", MSGLEVEL, MSGLEVEL);
            		Wrapper.printMessage(StringUtility.pad(intSNPChromosomeCountW, 8, PAD_CHAR) + " Records updated into SNPChromosomeCountW", MSGLEVEL, MSGLEVEL);
            		Wrapper.printMessage(StringUtility.pad(intSNPChromosomeCountZ, 8, PAD_CHAR) + " Records updated into SNPChromosomeCountZ", MSGLEVEL, MSGLEVEL);

        			totalRecordCount = intSNPChromosomeCount01 + intSNPChromosomeCount02 + intSNPChromosomeCount03 + intSNPChromosomeCount04 + intSNPChromosomeCount05 + intSNPChromosomeCount06 + intSNPChromosomeCount07 + intSNPChromosomeCount08 + intSNPChromosomeCount09 + intSNPChromosomeCount10 + intSNPChromosomeCount11 + intSNPChromosomeCount12 + intSNPChromosomeCount13 + intSNPChromosomeCount14 + intSNPChromosomeCount15 + intSNPChromosomeCount16 + intSNPChromosomeCount17 + intSNPChromosomeCount18 + intSNPChromosomeCount19 + intSNPChromosomeCount20 + intSNPChromosomeCount21 + intSNPChromosomeCount22 + intSNPChromosomeCount23 + intSNPChromosomeCount24 + intSNPChromosomeCount25 + intSNPChromosomeCount26 + intSNPChromosomeCount27 + intSNPChromosomeCount28 + intSNPChromosomeCount32 + intSNPChromosomeCountLGE22C19W28_E50C23 + intSNPChromosomeCountLGE64 + intSNPChromosomeCountW + intSNPChromosomeCountZ;
        			
        			Wrapper.printMessage(StringUtility.pad(totalRecordCount, 8, PAD_CHAR) + " updated rows from " + totalFileCount + " files in Directory " + directory, MSGLEVEL, MSGLEVEL);

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
