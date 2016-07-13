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

import com.roslin.mwicks.spring.variation.model.other.ProveanData;

import com.roslin.mwicks.spring.variation.routines.ConvertFiletoUpdateProveanDataList;

import com.roslin.mwicks.spring.variation.serviceinterface.snpchromosome.ServiceSNPChromosome;

import com.roslin.mwicks.utility.FileUtil;
import com.roslin.mwicks.utility.StringUtility;
import com.roslin.mwicks.utility.Wrapper;


public class UpdateProveanData {

	// Constants ----------------------------------------------------------------------------------
    private static final String MSGLEVEL = "*";
	private static final String STOP = "*";
	
	private static final char PAD_CHAR = ' ';

    public static final Logger LOG = LoggerFactory.getLogger(UpdateProveanData.class);

    @PersistenceContext
    private EntityManager entityManager;
     

    public static void main(String args[]){  

    	try {

        	LOG.trace("InsertProveanData - main");

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
               
                File errorFile = new File("/Users/mwicks23/Desktop/Provean/error_provean.txt");

                List<String> errorRecords = new ArrayList<String>();

        		String directory = args[0];
        		
                File dir = new File(directory);

                if ( dir.exists() ) {
                	
            		File[] filesFile = FileUtil.listAllFilesInDirectory(directory);
            		
            		int totalRecordCount = 0;
            		int totalFileCount = 0;
            		
                    int proveandataTotal = 0;

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

                            List<ProveanData> proveandataList = ConvertFiletoUpdateProveanDataList.run(file, MSGLEVEL, MSGLEVEL);
 
                            totalRecordCount = totalRecordCount +  proveandataList.size();
                            
                            Wrapper.printMessage(StringUtility.pad(totalFileCount, 3, PAD_CHAR) + " : Directory : " + directory + " : " + file.getName() + " : records : " + StringUtility.pad(proveandataList.size(), 8, PAD_CHAR), MSGLEVEL, MSGLEVEL);

                	     	proveandataTotal = proveandataTotal + proveandataList.size();
                	     	
                	        Iterator<ProveanData> iteratorProveanData = proveandataList.iterator();
                	        
                	     	while (iteratorProveanData.hasNext()) {
                	    		
                	     		ProveanData proveandata = iteratorProveanData.next();
                	     		
                	     		if ( !proveandata.isThisAValidProveanData() ) {
                	     			
            	     				error++;

            	     				String errorRecord = "INVALID PROVEAN DATA!\t\t" + proveandata.getSnpId() + "\t" +
            	     						proveandata.getEnsemblGene() + "\t" +
            	     						proveandata.getEnsemblTranscript() + "\t" +
            	     						proveandata.getEnsemblAnnotation() + "\t" +
            	     						proveandata.getAminoAcidSubs() + "\t" +
            	     						proveandata.getScoreProvean() + "\t" +
            	     						proveandata.getProteinAlignNumber() + "\t" +
            	     						proveandata.getTotalAlignSequenceNumber();

            	     				errorRecords.add(errorRecord);

            	     				Wrapper.printMessage("Error No. " + error + " : SNP Id. " + proveandata.getSnpId() + " UNKNOWN CHROMOSOME : " + proveandata.toString(), MSGLEVEL, MSGLEVEL);
                	     		}
                	     		else {

                    	     		if ( proveandata.isChromosome1() ) {
                    	     			
                    	                List<SNPChromosome> snpchromosome1List = new ArrayList<SNPChromosome>();
                    	     			
                    	     			snpchromosome1List = serviceSNPChromosome.findBySnpId(proveandata.getSnpId());
                    	     			
                    	     			if ( snpchromosome1List.isEmpty() ) {
                    	     				
                    	     				error++;

                    	     				String errorRecord = "SNP NOT FOUND!\t" + proveandata.getSnpId() + "\t" +
                    	     						proveandata.getEnsemblGene() + "\t" +
                    	     						proveandata.getEnsemblTranscript() + "\t" +
                    	     						proveandata.getEnsemblAnnotation() + "\t" +
                    	     						proveandata.getAminoAcidSubs() + "\t" +
                    	     						proveandata.getScoreProvean() + "\t" +
                    	     						proveandata.getProteinAlignNumber() + "\t" +
                    	     						proveandata.getTotalAlignSequenceNumber();

                    	     				errorRecords.add(errorRecord);

                    	     				//Wrapper.printMessage("Error No. " + error + " : SNP Id. " + proveandata.getSnpId() + " NOT FOUND : " + proveandata.toString(), MSGLEVEL, MSGLEVEL);
                    	     			}
                    	     			else {
                    	     				
                        	     			if ( snpchromosome1List.size() > 1 ) {
                        	     				
                        	     				error++;

                        	     				String errorRecord = "MULTIPLE SNPs!\t" + proveandata.getSnpId() + "\t" +
                        	     						proveandata.getEnsemblGene() + "\t" +
                        	     						proveandata.getEnsemblTranscript() + "\t" +
                        	     						proveandata.getEnsemblAnnotation() + "\t" +
                        	     						proveandata.getAminoAcidSubs() + "\t" +
                        	     						proveandata.getScoreProvean() + "\t" +
                        	     						proveandata.getProteinAlignNumber() + "\t" +
                        	     						proveandata.getTotalAlignSequenceNumber();

                        	     				errorRecords.add(errorRecord);

                        	     				Wrapper.printMessage("Error No. " + error + " : SNP Id. " + proveandata.getSnpId() + " GREATER THAN 1 ROW FOR : " + proveandata.toString(), MSGLEVEL, MSGLEVEL);
                        	     			}
                        	     			else {
                        	     				
                                    	        Iterator<SNPChromosome> iteratorSNPChromosome = snpchromosome1List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome.hasNext()) {

                                    	     		SNPChromosome snpchromosome01 = iteratorSNPChromosome.next();
                                    	     		
                                    	     		if ( proveandata.getScoreProvean() == 0.0 &&
                                    	     				proveandata.getProteinAlignNumber() == 0 &&
                                    	     				proveandata.getTotalAlignSequenceNumber() == 0) {
                                    	     			
                                    	     			snpchromosome01.setPredictionCategory("NOT SCORED");
                                    	     		}
                                    	     		
                                    	     		snpchromosome01.setAminoAcidSubs(proveandata.getAminoAcidSubs());
                                    	     		snpchromosome01.setScoreProvean(proveandata.getScoreProvean());
                                    	     		snpchromosome01.setProteinAlignNumber(proveandata.getProteinAlignNumber());
                                    	     		snpchromosome01.setTotalAlignSequenceNumber(proveandata.getTotalAlignSequenceNumber());

                                    	     		serviceSNPChromosome.update(snpchromosome01);
                                    	     		
                                    	     		intSNPChromosomeCount01++;
                                    	     	}
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( proveandata.isChromosome2() ) {
                    	     			
                    	                List<SNPChromosome> snpchromosome2List = new ArrayList<SNPChromosome>();
                    	     			
                    	     			snpchromosome2List = serviceSNPChromosome.findBySnpId(proveandata.getSnpId());
                    	     			
                    	     			if ( snpchromosome2List.isEmpty() ) {
                    	     				
                    	     				error++;
                    	     				
                    	     				String errorRecord = "SNP NOT FOUND!\t" + proveandata.getSnpId() + "\t" +
                    	     						proveandata.getEnsemblGene() + "\t" +
                    	     						proveandata.getEnsemblTranscript() + "\t" +
                    	     						proveandata.getEnsemblAnnotation() + "\t" +
                    	     						proveandata.getAminoAcidSubs() + "\t" +
                    	     						proveandata.getScoreProvean() + "\t" +
                    	     						proveandata.getProteinAlignNumber() + "\t" +
                    	     						proveandata.getTotalAlignSequenceNumber();

                    	     				errorRecords.add(errorRecord);

                    	     				//Wrapper.printMessage("Error No. " + error + " : SNP Id. " + proveandata.getSnpId() + " NOT FOUND : " + proveandata.toString(), MSGLEVEL, MSGLEVEL);
                    	     			}
                    	     			else {
                    	     				
                        	     			if ( snpchromosome2List.size() > 1 ) {
                        	     				
                        	     				error++;

                        	     				String errorRecord = "MULTIPLE SNPs!\t" + proveandata.getSnpId() + "\t" +
                        	     						proveandata.getEnsemblGene() + "\t" +
                        	     						proveandata.getEnsemblTranscript() + "\t" +
                        	     						proveandata.getEnsemblAnnotation() + "\t" +
                        	     						proveandata.getAminoAcidSubs() + "\t" +
                        	     						proveandata.getScoreProvean() + "\t" +
                        	     						proveandata.getProteinAlignNumber() + "\t" +
                        	     						proveandata.getTotalAlignSequenceNumber();

                        	     				errorRecords.add(errorRecord);

                        	     				Wrapper.printMessage("Error No. " + error + " : SNP Id. " + proveandata.getSnpId() + " GREATER THAN 1 ROW FOR : " + proveandata.toString(), MSGLEVEL, MSGLEVEL);
                        	     			}
                        	     			else {
                        	     				
                                    	        Iterator<SNPChromosome> iteratorSNPChromosome = snpchromosome2List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome.hasNext()) {

                                    	     		SNPChromosome snpchromosome02 = iteratorSNPChromosome.next();
                                    	     		
                                    	     		if ( proveandata.getScoreProvean() == 0.0 &&
                                    	     				proveandata.getProteinAlignNumber() == 0 &&
                                    	     				proveandata.getTotalAlignSequenceNumber() == 0) {
                                    	     			
                                    	     			snpchromosome02.setPredictionCategory("NOT SCORED");
                                    	     		}

                                    	     		snpchromosome02.setAminoAcidSubs(proveandata.getAminoAcidSubs());
                                    	     		snpchromosome02.setScoreProvean(proveandata.getScoreProvean());
                                    	     		snpchromosome02.setProteinAlignNumber(proveandata.getProteinAlignNumber());
                                    	     		snpchromosome02.setTotalAlignSequenceNumber(proveandata.getTotalAlignSequenceNumber());

                                    	     		serviceSNPChromosome.update(snpchromosome02);
                                    	     		
                                    	     		intSNPChromosomeCount02++;
                                    	     	}
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( proveandata.isChromosome3() ) {

                    	                List<SNPChromosome> snpchromosome3List = new ArrayList<SNPChromosome>();

                    	     			snpchromosome3List = serviceSNPChromosome.findBySnpId(proveandata.getSnpId());
                    	     			
                    	     			if ( snpchromosome3List.isEmpty() ) {
                    	     				
                    	     				error++;

                    	     				String errorRecord = "SNP NOT FOUND!\t" + proveandata.getSnpId() + "\t" +
                    	     						proveandata.getEnsemblGene() + "\t" +
                    	     						proveandata.getEnsemblTranscript() + "\t" +
                    	     						proveandata.getEnsemblAnnotation() + "\t" +
                    	     						proveandata.getAminoAcidSubs() + "\t" +
                    	     						proveandata.getScoreProvean() + "\t" +
                    	     						proveandata.getProteinAlignNumber() + "\t" +
                    	     						proveandata.getTotalAlignSequenceNumber();

                    	     				errorRecords.add(errorRecord);

                    	     				//Wrapper.printMessage("Error No. " + error + " : SNP Id. " + proveandata.getSnpId() + " NOT FOUND : " + proveandata.toString(), MSGLEVEL, MSGLEVEL);
                    	     			}
                    	     			else {

                        	     			if ( snpchromosome3List.size() > 1 ) {
                        	     				
                        	     				error++;

                        	     				String errorRecord = "MULTIPLE SNPs!\t" + proveandata.getSnpId() + "\t" +
                        	     						proveandata.getEnsemblGene() + "\t" +
                        	     						proveandata.getEnsemblTranscript() + "\t" +
                        	     						proveandata.getEnsemblAnnotation() + "\t" +
                        	     						proveandata.getAminoAcidSubs() + "\t" +
                        	     						proveandata.getScoreProvean() + "\t" +
                        	     						proveandata.getProteinAlignNumber() + "\t" +
                        	     						proveandata.getTotalAlignSequenceNumber();

                        	     				errorRecords.add(errorRecord);

                        	     				Wrapper.printMessage("Error No. " + error + " : SNP Id. " + proveandata.getSnpId() + " GREATER THAN 1 ROW FOR : " + proveandata.toString(), MSGLEVEL, MSGLEVEL);
                        	     			}
                        	     			else {
                        	     				
                                    	        Iterator<SNPChromosome> iteratorSNPChromosome = snpchromosome3List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome.hasNext()) {

                                    	     		SNPChromosome snpchromosome03 = iteratorSNPChromosome.next();
                                    	     		
                                    	     		if ( proveandata.getScoreProvean() == 0.0 &&
                                    	     				proveandata.getProteinAlignNumber() == 0 &&
                                    	     				proveandata.getTotalAlignSequenceNumber() == 0) {
                                    	     			
                                    	     			snpchromosome03.setPredictionCategory("NOT SCORED");
                                    	     		}
                                    	     		
                                    	     		snpchromosome03.setAminoAcidSubs(proveandata.getAminoAcidSubs());
                                    	     		snpchromosome03.setScoreProvean(proveandata.getScoreProvean());
                                    	     		snpchromosome03.setProteinAlignNumber(proveandata.getProteinAlignNumber());
                                    	     		snpchromosome03.setTotalAlignSequenceNumber(proveandata.getTotalAlignSequenceNumber());

                                    	     		serviceSNPChromosome.update(snpchromosome03);

                                    	     		intSNPChromosomeCount03++;
                                    	        }
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( proveandata.isChromosome4() ) {
                    	     			
                    	                List<SNPChromosome> snpchromosome4List = new ArrayList<SNPChromosome>();

                    	                snpchromosome4List = serviceSNPChromosome.findBySnpId(proveandata.getSnpId());
                    	                
                    	     			if ( snpchromosome4List.isEmpty() ) {
                    	     				
                    	     				error++;

                    	     				String errorRecord = "SNP NOT FOUND!\t" + proveandata.getSnpId() + "\t" +
                    	     						proveandata.getEnsemblGene() + "\t" +
                    	     						proveandata.getEnsemblTranscript() + "\t" +
                    	     						proveandata.getEnsemblAnnotation() + "\t" +
                    	     						proveandata.getAminoAcidSubs() + "\t" +
                    	     						proveandata.getScoreProvean() + "\t" +
                    	     						proveandata.getProteinAlignNumber() + "\t" +
                    	     						proveandata.getTotalAlignSequenceNumber();

                    	     				errorRecords.add(errorRecord);

                    	     				//Wrapper.printMessage("Error No. " + error + " : SNP Id. " + proveandata.getSnpId() + " NOT FOUND : " + proveandata.toString(), MSGLEVEL, MSGLEVEL);
                    	     			}
                    	     			else {

                        	     			if ( snpchromosome4List.size() > 1 ) {
                        	     				
                        	     				error++;

                        	     				String errorRecord = "MULTIPLE SNPs!\t" + proveandata.getSnpId() + "\t" +
                        	     						proveandata.getEnsemblGene() + "\t" +
                        	     						proveandata.getEnsemblTranscript() + "\t" +
                        	     						proveandata.getEnsemblAnnotation() + "\t" +
                        	     						proveandata.getAminoAcidSubs() + "\t" +
                        	     						proveandata.getScoreProvean() + "\t" +
                        	     						proveandata.getProteinAlignNumber() + "\t" +
                        	     						proveandata.getTotalAlignSequenceNumber();

                        	     				errorRecords.add(errorRecord);

                        	     				Wrapper.printMessage("Error No. " + error + " : SNP Id. " + proveandata.getSnpId() + " GREATER THAN 1 ROW FOR : " + proveandata.toString(), MSGLEVEL, MSGLEVEL);
                        	     			}
                        	     			else {
                        	     				
                            	     			Iterator<SNPChromosome> iteratorSNPChromosome = snpchromosome4List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome.hasNext()) {

                                    	     		SNPChromosome snpchromosome04 = iteratorSNPChromosome.next();
                                    	     		
                                    	     		if ( proveandata.getScoreProvean() == 0.0 &&
                                    	     				proveandata.getProteinAlignNumber() == 0 &&
                                    	     				proveandata.getTotalAlignSequenceNumber() == 0) {
                                    	     			
                                    	     			snpchromosome04.setPredictionCategory("NOT SCORED");
                                    	     		}
                                    	     		
                                    	     		snpchromosome04.setAminoAcidSubs(proveandata.getAminoAcidSubs());
                                    	     		snpchromosome04.setScoreProvean(proveandata.getScoreProvean());
                                    	     		snpchromosome04.setProteinAlignNumber(proveandata.getProteinAlignNumber());
                                    	     		snpchromosome04.setTotalAlignSequenceNumber(proveandata.getTotalAlignSequenceNumber());

                                    	     		serviceSNPChromosome.update(snpchromosome04);
                                    	     		
                                    	     		intSNPChromosomeCount04++;
                                    	     	}
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( proveandata.isChromosome5() ) {
                    	     			
                    	                List<SNPChromosome> snpchromosome5List = new ArrayList<SNPChromosome>();

                    	                snpchromosome5List = serviceSNPChromosome.findBySnpId(proveandata.getSnpId());
                    	                
                    	     			if ( snpchromosome5List.isEmpty() ) {
                    	     				
                    	     				error++;

                    	     				String errorRecord = "SNP NOT FOUND!\t" + proveandata.getSnpId() + "\t" +
                    	     						proveandata.getEnsemblGene() + "\t" +
                    	     						proveandata.getEnsemblTranscript() + "\t" +
                    	     						proveandata.getEnsemblAnnotation() + "\t" +
                    	     						proveandata.getAminoAcidSubs() + "\t" +
                    	     						proveandata.getScoreProvean() + "\t" +
                    	     						proveandata.getProteinAlignNumber() + "\t" +
                    	     						proveandata.getTotalAlignSequenceNumber();

                    	     				errorRecords.add(errorRecord);

                    	     				//Wrapper.printMessage("Error No. " + error + " : SNP Id. " + proveandata.getSnpId() + " NOT FOUND : " + proveandata.toString(), MSGLEVEL, MSGLEVEL);
                    	     			}
                    	     			else {

                        	     			if ( snpchromosome5List.size() > 1 ) {
                        	     				
                        	     				error++;

                        	     				String errorRecord = "MULTIPLE SNPs!\t" + proveandata.getSnpId() + "\t" +
                        	     						proveandata.getEnsemblGene() + "\t" +
                        	     						proveandata.getEnsemblTranscript() + "\t" +
                        	     						proveandata.getEnsemblAnnotation() + "\t" +
                        	     						proveandata.getAminoAcidSubs() + "\t" +
                        	     						proveandata.getScoreProvean() + "\t" +
                        	     						proveandata.getProteinAlignNumber() + "\t" +
                        	     						proveandata.getTotalAlignSequenceNumber();

                        	     				errorRecords.add(errorRecord);

                        	     				Wrapper.printMessage("Error No. " + error + " : SNP Id. " + proveandata.getSnpId() + " GREATER THAN 1 ROW FOR : " + proveandata.toString(), MSGLEVEL, MSGLEVEL);
                        	     			}
                        	     			else {
                        	     				
                            	     			Iterator<SNPChromosome> iteratorSNPChromosome = snpchromosome5List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome.hasNext()) {

                                    	     		SNPChromosome snpchromosome05 = iteratorSNPChromosome.next();
                                    	     		
                                    	     		if ( proveandata.getScoreProvean() == 0.0 &&
                                    	     				proveandata.getProteinAlignNumber() == 0 &&
                                    	     				proveandata.getTotalAlignSequenceNumber() == 0) {
                                    	     			
                                    	     			snpchromosome05.setPredictionCategory("NOT SCORED");
                                    	     		}
                                    	     		
                                    	     		snpchromosome05.setAminoAcidSubs(proveandata.getAminoAcidSubs());
                                    	     		snpchromosome05.setScoreProvean(proveandata.getScoreProvean());
                                    	     		snpchromosome05.setProteinAlignNumber(proveandata.getProteinAlignNumber());
                                    	     		snpchromosome05.setTotalAlignSequenceNumber(proveandata.getTotalAlignSequenceNumber());

                                    	     		serviceSNPChromosome.update(snpchromosome05);
                                    	     		
                                    	     		intSNPChromosomeCount05++;
                                    	     	}
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( proveandata.isChromosome6() ) {
                    	     			
                    	                List<SNPChromosome> snpchromosome6List = new ArrayList<SNPChromosome>();

                    	                snpchromosome6List = serviceSNPChromosome.findBySnpId(proveandata.getSnpId());
                    	                
                    	     			if ( snpchromosome6List.isEmpty() ) {
                    	     				
                    	     				error++;

                    	     				String errorRecord = "SNP NOT FOUND!\t" + proveandata.getSnpId() + "\t" +
                    	     						proveandata.getEnsemblGene() + "\t" +
                    	     						proveandata.getEnsemblTranscript() + "\t" +
                    	     						proveandata.getEnsemblAnnotation() + "\t" +
                    	     						proveandata.getAminoAcidSubs() + "\t" +
                    	     						proveandata.getScoreProvean() + "\t" +
                    	     						proveandata.getProteinAlignNumber() + "\t" +
                    	     						proveandata.getTotalAlignSequenceNumber();

                    	     				errorRecords.add(errorRecord);

                    	     				//Wrapper.printMessage("Error No. " + error + " : SNP Id. " + proveandata.getSnpId() + " NOT FOUND : " + proveandata.toString(), MSGLEVEL, MSGLEVEL);
                    	     			}
                    	     			else {

                        	     			if ( snpchromosome6List.size() > 1 ) {
                        	     				
                        	     				error++;

                        	     				String errorRecord = "MULTIPLE SNPs!\t" + proveandata.getSnpId() + "\t" +
                        	     						proveandata.getEnsemblGene() + "\t" +
                        	     						proveandata.getEnsemblTranscript() + "\t" +
                        	     						proveandata.getEnsemblAnnotation() + "\t" +
                        	     						proveandata.getAminoAcidSubs() + "\t" +
                        	     						proveandata.getScoreProvean() + "\t" +
                        	     						proveandata.getProteinAlignNumber() + "\t" +
                        	     						proveandata.getTotalAlignSequenceNumber();

                        	     				errorRecords.add(errorRecord);

                        	     				Wrapper.printMessage("Error No. " + error + " : SNP Id. " + proveandata.getSnpId() + " GREATER THAN 1 ROW FOR : " + proveandata.toString(), MSGLEVEL, MSGLEVEL);
                        	     			}
                        	     			else {
                        	     				
                                    	        Iterator<SNPChromosome> iteratorSNPChromosome = snpchromosome6List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome.hasNext()) {

                                    	     		SNPChromosome snpchromosome06 = iteratorSNPChromosome.next();
                                    	     		
                                    	     		if ( proveandata.getScoreProvean() == 0.0 &&
                                    	     				proveandata.getProteinAlignNumber() == 0 &&
                                    	     				proveandata.getTotalAlignSequenceNumber() == 0) {
                                    	     			
                                    	     			snpchromosome06.setPredictionCategory("NOT SCORED");
                                    	     		}
                                    	     		
                                    	     		snpchromosome06.setAminoAcidSubs(proveandata.getAminoAcidSubs());
                                    	     		snpchromosome06.setScoreProvean(proveandata.getScoreProvean());
                                    	     		snpchromosome06.setProteinAlignNumber(proveandata.getProteinAlignNumber());
                                    	     		snpchromosome06.setTotalAlignSequenceNumber(proveandata.getTotalAlignSequenceNumber());

                                    	     		serviceSNPChromosome.update(snpchromosome06);
                                    	     		
                                    	     		intSNPChromosomeCount06++;
                                    	     	}
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( proveandata.isChromosome7() ) {
                    	     			
                    	                List<SNPChromosome> snpchromosome7List = new ArrayList<SNPChromosome>();

                    	                snpchromosome7List = serviceSNPChromosome.findBySnpId(proveandata.getSnpId());
                    	                
                    	     			if ( snpchromosome7List.isEmpty() ) {
                    	     				
                    	     				error++;

                    	     				String errorRecord = "SNP NOT FOUND!\t" + proveandata.getSnpId() + "\t" +
                    	     						proveandata.getEnsemblGene() + "\t" +
                    	     						proveandata.getEnsemblTranscript() + "\t" +
                    	     						proveandata.getEnsemblAnnotation() + "\t" +
                    	     						proveandata.getAminoAcidSubs() + "\t" +
                    	     						proveandata.getScoreProvean() + "\t" +
                    	     						proveandata.getProteinAlignNumber() + "\t" +
                    	     						proveandata.getTotalAlignSequenceNumber();

                    	     				errorRecords.add(errorRecord);

                    	     				//Wrapper.printMessage("Error No. " + error + " : SNP Id. " + proveandata.getSnpId() + " NOT FOUND : " + proveandata.toString(), MSGLEVEL, MSGLEVEL);
                    	     			}
                    	     			else {

                        	     			if ( snpchromosome7List.size() > 1 ) {
                        	     				
                        	     				error++;

                        	     				String errorRecord = "MULTIPLE SNPs!\t" + proveandata.getSnpId() + "\t" +
                        	     						proveandata.getEnsemblGene() + "\t" +
                        	     						proveandata.getEnsemblTranscript() + "\t" +
                        	     						proveandata.getEnsemblAnnotation() + "\t" +
                        	     						proveandata.getAminoAcidSubs() + "\t" +
                        	     						proveandata.getScoreProvean() + "\t" +
                        	     						proveandata.getProteinAlignNumber() + "\t" +
                        	     						proveandata.getTotalAlignSequenceNumber();

                        	     				errorRecords.add(errorRecord);

                        	     				Wrapper.printMessage("Error No. " + error + " : SNP Id. " + proveandata.getSnpId() + " GREATER THAN 1 ROW FOR : " + proveandata.toString(), MSGLEVEL, MSGLEVEL);
                        	     			}
                        	     			else {
                        	     				
                                    	        Iterator<SNPChromosome> iteratorSNPChromosome = snpchromosome7List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome.hasNext()) {

                                    	     		SNPChromosome snpchromosome07 = iteratorSNPChromosome.next();
                                    	     		
                                    	     		if ( proveandata.getScoreProvean() == 0.0 &&
                                    	     				proveandata.getProteinAlignNumber() == 0 &&
                                    	     				proveandata.getTotalAlignSequenceNumber() == 0) {
                                    	     			
                                    	     			snpchromosome07.setPredictionCategory("NOT SCORED");
                                    	     		}
                                    	     		
                                    	     		snpchromosome07.setAminoAcidSubs(proveandata.getAminoAcidSubs());
                                    	     		snpchromosome07.setScoreProvean(proveandata.getScoreProvean());
                                    	     		snpchromosome07.setProteinAlignNumber(proveandata.getProteinAlignNumber());
                                    	     		snpchromosome07.setTotalAlignSequenceNumber(proveandata.getTotalAlignSequenceNumber());

                                    	     		serviceSNPChromosome.update(snpchromosome07);
                                    	     		
                                    	     		intSNPChromosomeCount07++;
                                    	     	}
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( proveandata.isChromosome8() ) {

                    	                List<SNPChromosome> snpchromosome8List = new ArrayList<SNPChromosome>();

                    	     			snpchromosome8List = serviceSNPChromosome.findBySnpId(proveandata.getSnpId());
                    	     			
                    	     			if ( snpchromosome8List.isEmpty() ) {
                    	     				
                    	     				error++;

                    	     				String errorRecord = "SNP NOT FOUND!\t" + proveandata.getSnpId() + "\t" +
                    	     						proveandata.getEnsemblGene() + "\t" +
                    	     						proveandata.getEnsemblTranscript() + "\t" +
                    	     						proveandata.getEnsemblAnnotation() + "\t" +
                    	     						proveandata.getAminoAcidSubs() + "\t" +
                    	     						proveandata.getScoreProvean() + "\t" +
                    	     						proveandata.getProteinAlignNumber() + "\t" +
                    	     						proveandata.getTotalAlignSequenceNumber();

                    	     				errorRecords.add(errorRecord);

                    	     				//Wrapper.printMessage("Error No. " + error + " : SNP Id. " + proveandata.getSnpId() + " NOT FOUND : " + proveandata.toString(), MSGLEVEL, MSGLEVEL);
                    	     			}
                    	     			else {

                        	     			if ( snpchromosome8List.size() > 1 ) {
                        	     				
                        	     				error++;

                        	     				String errorRecord = "MULTIPLE SNPs!\t" + proveandata.getSnpId() + "\t" +
                        	     						proveandata.getEnsemblGene() + "\t" +
                        	     						proveandata.getEnsemblTranscript() + "\t" +
                        	     						proveandata.getEnsemblAnnotation() + "\t" +
                        	     						proveandata.getAminoAcidSubs() + "\t" +
                        	     						proveandata.getScoreProvean() + "\t" +
                        	     						proveandata.getProteinAlignNumber() + "\t" +
                        	     						proveandata.getTotalAlignSequenceNumber();

                        	     				errorRecords.add(errorRecord);

                        	     				Wrapper.printMessage("Error No. " + error + " : SNP Id. " + proveandata.getSnpId() + " GREATER THAN 1 ROW FOR : " + proveandata.toString(), MSGLEVEL, MSGLEVEL);
                        	     			}
                        	     			else {
                        	     				
                                    	        Iterator<SNPChromosome> iteratorSNPChromosome = snpchromosome8List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome.hasNext()) {

                                    	     		SNPChromosome snpchromosome08 = iteratorSNPChromosome.next();

                                    	     		if ( proveandata.getScoreProvean() == 0.0 &&
                                    	     				proveandata.getProteinAlignNumber() == 0 &&
                                    	     				proveandata.getTotalAlignSequenceNumber() == 0) {
                                    	     			
                                    	     			snpchromosome08.setPredictionCategory("NOT SCORED");
                                    	     		}
                                    	     		
                                    	     		snpchromosome08.setAminoAcidSubs(proveandata.getAminoAcidSubs());
                                    	     		snpchromosome08.setScoreProvean(proveandata.getScoreProvean());
                                    	     		snpchromosome08.setProteinAlignNumber(proveandata.getProteinAlignNumber());
                                    	     		snpchromosome08.setTotalAlignSequenceNumber(proveandata.getTotalAlignSequenceNumber());

                                    	     		serviceSNPChromosome.update(snpchromosome08);
                                    	     		
                                    	     		intSNPChromosomeCount08++;
                                    	     	}
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( proveandata.isChromosome9() ) {

                    	                List<SNPChromosome> snpchromosome9List = new ArrayList<SNPChromosome>();

                    	     			snpchromosome9List = serviceSNPChromosome.findBySnpId(proveandata.getSnpId());
                    	     			
                    	     			if ( snpchromosome9List.isEmpty() ) {
                    	     				
                    	     				error++;

                    	     				String errorRecord = "SNP NOT FOUND!\t" + proveandata.getSnpId() + "\t" +
                    	     						proveandata.getEnsemblGene() + "\t" +
                    	     						proveandata.getEnsemblTranscript() + "\t" +
                    	     						proveandata.getEnsemblAnnotation() + "\t" +
                    	     						proveandata.getAminoAcidSubs() + "\t" +
                    	     						proveandata.getScoreProvean() + "\t" +
                    	     						proveandata.getProteinAlignNumber() + "\t" +
                    	     						proveandata.getTotalAlignSequenceNumber();

                    	     				errorRecords.add(errorRecord);

                    	     				//Wrapper.printMessage("Error No. " + error + " : SNP Id. " + proveandata.getSnpId() + " NOT FOUND : " + proveandata.toString(), MSGLEVEL, MSGLEVEL);
                    	     			}
                    	     			else {

                        	     			if ( snpchromosome9List.size() > 1 ) {
                        	     				
                        	     				error++;

                        	     				String errorRecord = "MULTIPLE SNPs!\t" + proveandata.getSnpId() + "\t" +
                        	     						proveandata.getEnsemblGene() + "\t" +
                        	     						proveandata.getEnsemblTranscript() + "\t" +
                        	     						proveandata.getEnsemblAnnotation() + "\t" +
                        	     						proveandata.getAminoAcidSubs() + "\t" +
                        	     						proveandata.getScoreProvean() + "\t" +
                        	     						proveandata.getProteinAlignNumber() + "\t" +
                        	     						proveandata.getTotalAlignSequenceNumber();

                        	     				errorRecords.add(errorRecord);

                        	     				Wrapper.printMessage("Error No. " + error + " : SNP Id. " + proveandata.getSnpId() + " GREATER THAN 1 ROW FOR : " + proveandata.toString(), MSGLEVEL, MSGLEVEL);
                        	     			}
                        	     			else {
                        	     				
                                    	        Iterator<SNPChromosome> iteratorSNPChromosome = snpchromosome9List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome.hasNext()) {

                                    	     		SNPChromosome snpchromosome09 = iteratorSNPChromosome.next();
                                    	     		
                                    	     		if ( proveandata.getScoreProvean() == 0.0 &&
                                    	     				proveandata.getProteinAlignNumber() == 0 &&
                                    	     				proveandata.getTotalAlignSequenceNumber() == 0) {
                                    	     			
                                    	     			snpchromosome09.setPredictionCategory("NOT SCORED");
                                    	     		}
                                    	     		
                                    	     		snpchromosome09.setAminoAcidSubs(proveandata.getAminoAcidSubs());
                                    	     		snpchromosome09.setScoreProvean(proveandata.getScoreProvean());
                                    	     		snpchromosome09.setProteinAlignNumber(proveandata.getProteinAlignNumber());
                                    	     		snpchromosome09.setTotalAlignSequenceNumber(proveandata.getTotalAlignSequenceNumber());

                                    	     		serviceSNPChromosome.update(snpchromosome09);
                                    	     		
                                    	     		intSNPChromosomeCount09++;
                                    	     	}
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( proveandata.isChromosome10() ) {

                    	                List<SNPChromosome> snpchromosome10List = new ArrayList<SNPChromosome>();

                    	     			snpchromosome10List = serviceSNPChromosome.findBySnpId(proveandata.getSnpId());
                    	     			
                    	     			if ( snpchromosome10List.isEmpty() ) {
                    	     				
                    	     				error++;

                    	     				String errorRecord = "SNP NOT FOUND!\t" + proveandata.getSnpId() + "\t" +
                    	     						proveandata.getEnsemblGene() + "\t" +
                    	     						proveandata.getEnsemblTranscript() + "\t" +
                    	     						proveandata.getEnsemblAnnotation() + "\t" +
                    	     						proveandata.getAminoAcidSubs() + "\t" +
                    	     						proveandata.getScoreProvean() + "\t" +
                    	     						proveandata.getProteinAlignNumber() + "\t" +
                    	     						proveandata.getTotalAlignSequenceNumber();

                    	     				errorRecords.add(errorRecord);

                    	     				//Wrapper.printMessage("Error No. " + error + " : SNP Id. " + proveandata.getSnpId() + " NOT FOUND : " + proveandata.toString(), MSGLEVEL, MSGLEVEL);
                    	     			}
                    	     			else {

                        	     			if ( snpchromosome10List.size() > 1 ) {
                        	     				
                        	     				error++;

                        	     				String errorRecord = "MULTIPLE SNPs!\t" + proveandata.getSnpId() + "\t" +
                        	     						proveandata.getEnsemblGene() + "\t" +
                        	     						proveandata.getEnsemblTranscript() + "\t" +
                        	     						proveandata.getEnsemblAnnotation() + "\t" +
                        	     						proveandata.getAminoAcidSubs() + "\t" +
                        	     						proveandata.getScoreProvean() + "\t" +
                        	     						proveandata.getProteinAlignNumber() + "\t" +
                        	     						proveandata.getTotalAlignSequenceNumber();

                        	     				errorRecords.add(errorRecord);

                        	     				Wrapper.printMessage("Error No. " + error + " : SNP Id. " + proveandata.getSnpId() + " GREATER THAN 1 ROW FOR : " + proveandata.toString(), MSGLEVEL, MSGLEVEL);
                        	     			}
                        	     			else {
                        	     				
                                    	        Iterator<SNPChromosome> iteratorSNPChromosome = snpchromosome10List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome.hasNext()) {

                                    	     		SNPChromosome snpchromosome10 = iteratorSNPChromosome.next();
                                    	     		
                                    	     		if ( proveandata.getScoreProvean() == 0.0 &&
                                    	     				proveandata.getProteinAlignNumber() == 0 &&
                                    	     				proveandata.getTotalAlignSequenceNumber() == 0) {
                                    	     			
                                    	     			snpchromosome10.setPredictionCategory("NOT SCORED");
                                    	     		}
                                    	     		
                                    	     		snpchromosome10.setAminoAcidSubs(proveandata.getAminoAcidSubs());
                                    	     		snpchromosome10.setScoreProvean(proveandata.getScoreProvean());
                                    	     		snpchromosome10.setProteinAlignNumber(proveandata.getProteinAlignNumber());
                                    	     		snpchromosome10.setTotalAlignSequenceNumber(proveandata.getTotalAlignSequenceNumber());

                                    	     		serviceSNPChromosome.update(snpchromosome10);
                                    	     		
                                    	     		intSNPChromosomeCount10++;
                                    	     	}
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( proveandata.isChromosome11() ) {
                    	     			
                    	                List<SNPChromosome> snpchromosome11List = new ArrayList<SNPChromosome>();

                    	     			snpchromosome11List = serviceSNPChromosome.findBySnpId(proveandata.getSnpId());
                    	     			
                    	     			if ( snpchromosome11List.isEmpty() ) {
                    	     				
                    	     				error++;

                    	     				String errorRecord = "SNP NOT FOUND!\t" + proveandata.getSnpId() + "\t" +
                    	     						proveandata.getEnsemblGene() + "\t" +
                    	     						proveandata.getEnsemblTranscript() + "\t" +
                    	     						proveandata.getEnsemblAnnotation() + "\t" +
                    	     						proveandata.getAminoAcidSubs() + "\t" +
                    	     						proveandata.getScoreProvean() + "\t" +
                    	     						proveandata.getProteinAlignNumber() + "\t" +
                    	     						proveandata.getTotalAlignSequenceNumber();

                    	     				errorRecords.add(errorRecord);

                    	     				//Wrapper.printMessage("Error No. " + error + " : SNP Id. " + proveandata.getSnpId() + " NOT FOUND : " + proveandata.toString(), MSGLEVEL, MSGLEVEL);
                    	     			}
                    	     			else {

                        	     			if ( snpchromosome11List.size() > 1 ) {
                        	     				
                        	     				error++;

                        	     				String errorRecord = "MULTIPLE SNPs!\t" + proveandata.getSnpId() + "\t" +
                        	     						proveandata.getEnsemblGene() + "\t" +
                        	     						proveandata.getEnsemblTranscript() + "\t" +
                        	     						proveandata.getEnsemblAnnotation() + "\t" +
                        	     						proveandata.getAminoAcidSubs() + "\t" +
                        	     						proveandata.getScoreProvean() + "\t" +
                        	     						proveandata.getProteinAlignNumber() + "\t" +
                        	     						proveandata.getTotalAlignSequenceNumber();

                        	     				errorRecords.add(errorRecord);

                        	     				Wrapper.printMessage("Error No. " + error + " : SNP Id. " + proveandata.getSnpId() + " GREATER THAN 1 ROW FOR : " + proveandata.toString(), MSGLEVEL, MSGLEVEL);
                        	     			}
                        	     			else {
                        	     				
                                    	        Iterator<SNPChromosome> iteratorSNPChromosome = snpchromosome11List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome.hasNext()) {

                                    	     		SNPChromosome snpchromosome11 = iteratorSNPChromosome.next();
                                    	     		
                                    	     		if ( proveandata.getScoreProvean() == 0.0 &&
                                    	     				proveandata.getProteinAlignNumber() == 0 &&
                                    	     				proveandata.getTotalAlignSequenceNumber() == 0) {
                                    	     			
                                    	     			snpchromosome11.setPredictionCategory("NOT SCORED");
                                    	     		}
                                    	     		
                                    	     		snpchromosome11.setAminoAcidSubs(proveandata.getAminoAcidSubs());
                                    	     		snpchromosome11.setScoreProvean(proveandata.getScoreProvean());
                                    	     		snpchromosome11.setProteinAlignNumber(proveandata.getProteinAlignNumber());
                                    	     		snpchromosome11.setTotalAlignSequenceNumber(proveandata.getTotalAlignSequenceNumber());

                                    	     		serviceSNPChromosome.update(snpchromosome11);
                                    	     		
                                    	     		intSNPChromosomeCount11++;
                                    	     	}
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( proveandata.isChromosome12() ) {
                    	     			
                    	                List<SNPChromosome> snpchromosome12List = new ArrayList<SNPChromosome>();

                    	                snpchromosome12List = serviceSNPChromosome.findBySnpId(proveandata.getSnpId());
                    	                
                    	     			if ( snpchromosome12List.isEmpty() ) {
                    	     				
                    	     				error++;

                    	     				String errorRecord = "SNP NOT FOUND!\t" + proveandata.getSnpId() + "\t" +
                    	     						proveandata.getEnsemblGene() + "\t" +
                    	     						proveandata.getEnsemblTranscript() + "\t" +
                    	     						proveandata.getEnsemblAnnotation() + "\t" +
                    	     						proveandata.getAminoAcidSubs() + "\t" +
                    	     						proveandata.getScoreProvean() + "\t" +
                    	     						proveandata.getProteinAlignNumber() + "\t" +
                    	     						proveandata.getTotalAlignSequenceNumber();

                    	     				errorRecords.add(errorRecord);

                    	     				//Wrapper.printMessage("Error No. " + error + " : SNP Id. " + proveandata.getSnpId() + " NOT FOUND : " + proveandata.toString(), MSGLEVEL, MSGLEVEL);
                    	     			}
                    	     			else {
                    	     				
                        	     			if ( snpchromosome12List.size() > 1 ) {
                        	     				
                        	     				error++;

                        	     				String errorRecord = "MULTIPLE SNPs!\t" + proveandata.getSnpId() + "\t" +
                        	     						proveandata.getEnsemblGene() + "\t" +
                        	     						proveandata.getEnsemblTranscript() + "\t" +
                        	     						proveandata.getEnsemblAnnotation() + "\t" +
                        	     						proveandata.getAminoAcidSubs() + "\t" +
                        	     						proveandata.getScoreProvean() + "\t" +
                        	     						proveandata.getProteinAlignNumber() + "\t" +
                        	     						proveandata.getTotalAlignSequenceNumber();

                        	     				errorRecords.add(errorRecord);

                        	     				Wrapper.printMessage("Error No. " + error + " : SNP Id. " + proveandata.getSnpId() + " GREATER THAN 1 ROW FOR : " + proveandata.toString(), MSGLEVEL, MSGLEVEL);
                        	     			}
                        	     			else {
                        	     				
                                    	        Iterator<SNPChromosome> iteratorSNPChromosome = snpchromosome12List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome.hasNext()) {

                                    	     		SNPChromosome snpchromosome12 = iteratorSNPChromosome.next();
                                    	     		
                                    	     		if ( proveandata.getScoreProvean() == 0.0 &&
                                    	     				proveandata.getProteinAlignNumber() == 0 &&
                                    	     				proveandata.getTotalAlignSequenceNumber() == 0) {
                                    	     			
                                    	     			snpchromosome12.setPredictionCategory("NOT SCORED");
                                    	     		}
                                    	     		
                                    	     		snpchromosome12.setAminoAcidSubs(proveandata.getAminoAcidSubs());
                                    	     		snpchromosome12.setScoreProvean(proveandata.getScoreProvean());
                                    	     		snpchromosome12.setProteinAlignNumber(proveandata.getProteinAlignNumber());
                                    	     		snpchromosome12.setTotalAlignSequenceNumber(proveandata.getTotalAlignSequenceNumber());

                                    	     		serviceSNPChromosome.update(snpchromosome12);
                                    	     		
                                    	     		intSNPChromosomeCount12++;
                                    	     	}
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( proveandata.isChromosome13() ) {
                    	     			
                    	                List<SNPChromosome> snpchromosome13List = new ArrayList<SNPChromosome>();

                    	                snpchromosome13List = serviceSNPChromosome.findBySnpId(proveandata.getSnpId());

                    	     			if ( snpchromosome13List.isEmpty() ) {
                    	     				
                    	     				error++;

                    	     				String errorRecord = "SNP NOT FOUND!\t" + proveandata.getSnpId() + "\t" +
                    	     						proveandata.getEnsemblGene() + "\t" +
                    	     						proveandata.getEnsemblTranscript() + "\t" +
                    	     						proveandata.getEnsemblAnnotation() + "\t" +
                    	     						proveandata.getAminoAcidSubs() + "\t" +
                    	     						proveandata.getScoreProvean() + "\t" +
                    	     						proveandata.getProteinAlignNumber() + "\t" +
                    	     						proveandata.getTotalAlignSequenceNumber();

                    	     				errorRecords.add(errorRecord);

                    	     				//Wrapper.printMessage("Error No. " + error + " : SNP Id. " + proveandata.getSnpId() + " NOT FOUND : " + proveandata.toString(), MSGLEVEL, MSGLEVEL);
                    	     			}
                    	     			else {

                        	     			if ( snpchromosome13List.size() > 1 ) {
                        	     				
                        	     				error++;

                        	     				String errorRecord = "MULTIPLE SNPs!\t" + proveandata.getSnpId() + "\t" +
                        	     						proveandata.getEnsemblGene() + "\t" +
                        	     						proveandata.getEnsemblTranscript() + "\t" +
                        	     						proveandata.getEnsemblAnnotation() + "\t" +
                        	     						proveandata.getAminoAcidSubs() + "\t" +
                        	     						proveandata.getScoreProvean() + "\t" +
                        	     						proveandata.getProteinAlignNumber() + "\t" +
                        	     						proveandata.getTotalAlignSequenceNumber();

                        	     				errorRecords.add(errorRecord);

                        	     				Wrapper.printMessage("Error No. " + error + " : SNP Id. " + proveandata.getSnpId() + " GREATER THAN 1 ROW FOR : " + proveandata.toString(), MSGLEVEL, MSGLEVEL);
                        	     			}
                        	     			else {
                        	     				
                            	     			Iterator<SNPChromosome> iteratorSNPChromosome = snpchromosome13List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome.hasNext()) {

                                    	     		SNPChromosome snpchromosome13 = iteratorSNPChromosome.next();
                                    	     		
                                    	     		if ( proveandata.getScoreProvean() == 0.0 &&
                                    	     				proveandata.getProteinAlignNumber() == 0 &&
                                    	     				proveandata.getTotalAlignSequenceNumber() == 0) {
                                    	     			
                                    	     			snpchromosome13.setPredictionCategory("NOT SCORED");
                                    	     		}
                                    	     		
                                    	     		snpchromosome13.setAminoAcidSubs(proveandata.getAminoAcidSubs());
                                    	     		snpchromosome13.setScoreProvean(proveandata.getScoreProvean());
                                    	     		snpchromosome13.setProteinAlignNumber(proveandata.getProteinAlignNumber());
                                    	     		snpchromosome13.setTotalAlignSequenceNumber(proveandata.getTotalAlignSequenceNumber());

                                    	     		serviceSNPChromosome.update(snpchromosome13);
                                    	     		
                                    	     		intSNPChromosomeCount13++;
                                    	     	}
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( proveandata.isChromosome14() ) {
                    	     			
                    	                List<SNPChromosome> snpchromosome14List = new ArrayList<SNPChromosome>();

                    	                snpchromosome14List = serviceSNPChromosome.findBySnpId(proveandata.getSnpId());
                    	                
                    	     			if ( snpchromosome14List.isEmpty() ) {
                    	     				
                    	     				error++;

                    	     				String errorRecord = "SNP NOT FOUND!\t" + proveandata.getSnpId() + "\t" +
                    	     						proveandata.getEnsemblGene() + "\t" +
                    	     						proveandata.getEnsemblTranscript() + "\t" +
                    	     						proveandata.getEnsemblAnnotation() + "\t" +
                    	     						proveandata.getAminoAcidSubs() + "\t" +
                    	     						proveandata.getScoreProvean() + "\t" +
                    	     						proveandata.getProteinAlignNumber() + "\t" +
                    	     						proveandata.getTotalAlignSequenceNumber();

                    	     				errorRecords.add(errorRecord);

                    	     				//Wrapper.printMessage("Error No. " + error + " : SNP Id. " + proveandata.getSnpId() + " NOT FOUND : " + proveandata.toString(), MSGLEVEL, MSGLEVEL);
                    	     			}
                    	     			else {

                        	     			if ( snpchromosome14List.size() > 1 ) {
                        	     				
                        	     				error++;
                        	     				
                        	     				String errorRecord = "MULTIPLE SNPs!\t" + proveandata.getSnpId() + "\t" +
                        	     						proveandata.getEnsemblGene() + "\t" +
                        	     						proveandata.getEnsemblTranscript() + "\t" +
                        	     						proveandata.getEnsemblAnnotation() + "\t" +
                        	     						proveandata.getAminoAcidSubs() + "\t" +
                        	     						proveandata.getScoreProvean() + "\t" +
                        	     						proveandata.getProteinAlignNumber() + "\t" +
                        	     						proveandata.getTotalAlignSequenceNumber();

                        	     				errorRecords.add(errorRecord);

                        	     				Wrapper.printMessage("Error No. " + error + " : SNP Id. " + proveandata.getSnpId() + " GREATER THAN 1 ROW FOR : " + proveandata.toString(), MSGLEVEL, MSGLEVEL);
                        	     			}
                        	     			else {
                        	     				
                                    	        Iterator<SNPChromosome> iteratorSNPChromosome = snpchromosome14List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome.hasNext()) {

                                    	     		SNPChromosome snpchromosome14 = iteratorSNPChromosome.next();
                                    	     		
                                    	     		if ( proveandata.getScoreProvean() == 0.0 &&
                                    	     				proveandata.getProteinAlignNumber() == 0 &&
                                    	     				proveandata.getTotalAlignSequenceNumber() == 0) {
                                    	     			
                                    	     			snpchromosome14.setPredictionCategory("NOT SCORED");
                                    	     		}
                                    	     		
                                    	     		snpchromosome14.setAminoAcidSubs(proveandata.getAminoAcidSubs());
                                    	     		snpchromosome14.setScoreProvean(proveandata.getScoreProvean());
                                    	     		snpchromosome14.setProteinAlignNumber(proveandata.getProteinAlignNumber());
                                    	     		snpchromosome14.setTotalAlignSequenceNumber(proveandata.getTotalAlignSequenceNumber());

                                    	     		serviceSNPChromosome.update(snpchromosome14);
                                    	     		
                                    	     		intSNPChromosomeCount14++;
                                    	     	}
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( proveandata.isChromosome15() ) {
                    	     			
                    	                List<SNPChromosome> snpchromosome15List = new ArrayList<SNPChromosome>();

                    	                snpchromosome15List = serviceSNPChromosome.findBySnpId(proveandata.getSnpId());
                    	                
                    	     			if ( snpchromosome15List.isEmpty() ) {
                    	     				
                    	     				error++;

                    	     				String errorRecord = "SNP NOT FOUND!\t" + proveandata.getSnpId() + "\t" +
                    	     						proveandata.getEnsemblGene() + "\t" +
                    	     						proveandata.getEnsemblTranscript() + "\t" +
                    	     						proveandata.getEnsemblAnnotation() + "\t" +
                    	     						proveandata.getAminoAcidSubs() + "\t" +
                    	     						proveandata.getScoreProvean() + "\t" +
                    	     						proveandata.getProteinAlignNumber() + "\t" +
                    	     						proveandata.getTotalAlignSequenceNumber();

                    	     				errorRecords.add(errorRecord);

                    	     				//Wrapper.printMessage("Error No. " + error + " : SNP Id. " + proveandata.getSnpId() + " NOT FOUND : " + proveandata.toString(), MSGLEVEL, MSGLEVEL);
                    	     			}
                    	     			else {

                        	     			if ( snpchromosome15List.size() > 1 ) {
                        	     				
                        	     				error++;

                        	     				String errorRecord = "MULTIPLE SNPs!\t" + proveandata.getSnpId() + "\t" +
                        	     						proveandata.getEnsemblGene() + "\t" +
                        	     						proveandata.getEnsemblTranscript() + "\t" +
                        	     						proveandata.getEnsemblAnnotation() + "\t" +
                        	     						proveandata.getAminoAcidSubs() + "\t" +
                        	     						proveandata.getScoreProvean() + "\t" +
                        	     						proveandata.getProteinAlignNumber() + "\t" +
                        	     						proveandata.getTotalAlignSequenceNumber();

                        	     				errorRecords.add(errorRecord);

                        	     				Wrapper.printMessage("Error No. " + error + " : SNP Id. " + proveandata.getSnpId() + " GREATER THAN 1 ROW FOR : " + proveandata.toString(), MSGLEVEL, MSGLEVEL);
                        	     			}
                        	     			else {
                        	     				
                                    	        Iterator<SNPChromosome> iteratorSNPChromosome = snpchromosome15List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome.hasNext()) {

                                    	     		SNPChromosome snpchromosome15 = iteratorSNPChromosome.next();
                                    	     		
                                    	     		if ( proveandata.getScoreProvean() == 0.0 &&
                                    	     				proveandata.getProteinAlignNumber() == 0 &&
                                    	     				proveandata.getTotalAlignSequenceNumber() == 0) {
                                    	     			
                                    	     			snpchromosome15.setPredictionCategory("NOT SCORED");
                                    	     		}
                                    	     		
                                    	     		snpchromosome15.setAminoAcidSubs(proveandata.getAminoAcidSubs());
                                    	     		snpchromosome15.setScoreProvean(proveandata.getScoreProvean());
                                    	     		snpchromosome15.setProteinAlignNumber(proveandata.getProteinAlignNumber());
                                    	     		snpchromosome15.setTotalAlignSequenceNumber(proveandata.getTotalAlignSequenceNumber());

                                    	     		serviceSNPChromosome.update(snpchromosome15);
                                    	     		
                                    	     		intSNPChromosomeCount15++;
                                    	     	}
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( proveandata.isChromosome16() ) {

                    	                List<SNPChromosome> snpchromosome16List = new ArrayList<SNPChromosome>();

                    	     			snpchromosome16List = serviceSNPChromosome.findBySnpId(proveandata.getSnpId());
                    	     			
                    	     			if ( snpchromosome16List.isEmpty() ) {
                    	     				
                    	     				error++;

                    	     				String errorRecord = "SNP NOT FOUND!\t" + proveandata.getSnpId() + "\t" +
                    	     						proveandata.getEnsemblGene() + "\t" +
                    	     						proveandata.getEnsemblTranscript() + "\t" +
                    	     						proveandata.getEnsemblAnnotation() + "\t" +
                    	     						proveandata.getAminoAcidSubs() + "\t" +
                    	     						proveandata.getScoreProvean() + "\t" +
                    	     						proveandata.getProteinAlignNumber() + "\t" +
                    	     						proveandata.getTotalAlignSequenceNumber();

                    	     				errorRecords.add(errorRecord);

                    	     				//Wrapper.printMessage("Error No. " + error + " : SNP Id. " + proveandata.getSnpId() + " NOT FOUND : " + proveandata.toString(), MSGLEVEL, MSGLEVEL);
                    	     			}
                    	     			else {

                        	     			if ( snpchromosome16List.size() > 1 ) {
                        	     				
                        	     				error++;

                        	     				String errorRecord = "MULTIPLE SNPs!\t" + proveandata.getSnpId() + "\t" +
                        	     						proveandata.getEnsemblGene() + "\t" +
                        	     						proveandata.getEnsemblTranscript() + "\t" +
                        	     						proveandata.getEnsemblAnnotation() + "\t" +
                        	     						proveandata.getAminoAcidSubs() + "\t" +
                        	     						proveandata.getScoreProvean() + "\t" +
                        	     						proveandata.getProteinAlignNumber() + "\t" +
                        	     						proveandata.getTotalAlignSequenceNumber();

                        	     				errorRecords.add(errorRecord);

                        	     				Wrapper.printMessage("Error No. " + error + " : SNP Id. " + proveandata.getSnpId() + " GREATER THAN 1 ROW FOR : " + proveandata.toString(), MSGLEVEL, MSGLEVEL);
                        	     			}
                        	     			else {
                        	     				
                                    	        Iterator<SNPChromosome> iteratorSNPChromosome = snpchromosome16List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome.hasNext()) {

                                    	     		SNPChromosome snpchromosome16 = iteratorSNPChromosome.next();
                                    	     		
                                    	     		if ( proveandata.getScoreProvean() == 0.0 &&
                                    	     				proveandata.getProteinAlignNumber() == 0 &&
                                    	     				proveandata.getTotalAlignSequenceNumber() == 0) {
                                    	     			
                                    	     			snpchromosome16.setPredictionCategory("NOT SCORED");
                                    	     		}
                                    	     		
                                    	     		snpchromosome16.setAminoAcidSubs(proveandata.getAminoAcidSubs());
                                    	     		snpchromosome16.setScoreProvean(proveandata.getScoreProvean());
                                    	     		snpchromosome16.setProteinAlignNumber(proveandata.getProteinAlignNumber());
                                    	     		snpchromosome16.setTotalAlignSequenceNumber(proveandata.getTotalAlignSequenceNumber());

                                    	     		serviceSNPChromosome.update(snpchromosome16);
                                    	     		
                                    	     		intSNPChromosomeCount16++;
                                    	     	}
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( proveandata.isChromosome17() ) {
                    	     			
                    	                List<SNPChromosome> snpchromosome17List = new ArrayList<SNPChromosome>();

                    	     			snpchromosome17List = serviceSNPChromosome.findBySnpId(proveandata.getSnpId());
                    	     			
                    	     			if ( snpchromosome17List.isEmpty() ) {
                    	     				
                    	     				error++;

                    	     				String errorRecord = "SNP NOT FOUND!\t" + proveandata.getSnpId() + "\t" +
                    	     						proveandata.getEnsemblGene() + "\t" +
                    	     						proveandata.getEnsemblTranscript() + "\t" +
                    	     						proveandata.getEnsemblAnnotation() + "\t" +
                    	     						proveandata.getAminoAcidSubs() + "\t" +
                    	     						proveandata.getScoreProvean() + "\t" +
                    	     						proveandata.getProteinAlignNumber() + "\t" +
                    	     						proveandata.getTotalAlignSequenceNumber();

                    	     				errorRecords.add(errorRecord);

                    	     				//Wrapper.printMessage("Error No. " + error + " : SNP Id. " + proveandata.getSnpId() + " NOT FOUND : " + proveandata.toString(), MSGLEVEL, MSGLEVEL);
                    	     			}
                    	     			else {

                        	     			if ( snpchromosome17List.size() > 1 ) {
                        	     				
                        	     				error++;

                        	     				String errorRecord = "MULTIPLE SNPs!\t" + proveandata.getSnpId() + "\t" +
                        	     						proveandata.getEnsemblGene() + "\t" +
                        	     						proveandata.getEnsemblTranscript() + "\t" +
                        	     						proveandata.getEnsemblAnnotation() + "\t" +
                        	     						proveandata.getAminoAcidSubs() + "\t" +
                        	     						proveandata.getScoreProvean() + "\t" +
                        	     						proveandata.getProteinAlignNumber() + "\t" +
                        	     						proveandata.getTotalAlignSequenceNumber();

                        	     				errorRecords.add(errorRecord);

                        	     				Wrapper.printMessage("Error No. " + error + " : SNP Id. " + proveandata.getSnpId() + " GREATER THAN 1 ROW FOR : " + proveandata.toString(), MSGLEVEL, MSGLEVEL);
                        	     			}
                        	     			else {
                        	     				
                                    	        Iterator<SNPChromosome> iteratorSNPChromosome = snpchromosome17List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome.hasNext()) {

                                    	     		SNPChromosome snpchromosome17 = iteratorSNPChromosome.next();
                                    	     		
                                    	     		if ( proveandata.getScoreProvean() == 0.0 &&
                                    	     				proveandata.getProteinAlignNumber() == 0 &&
                                    	     				proveandata.getTotalAlignSequenceNumber() == 0) {
                                    	     			
                                    	     			snpchromosome17.setPredictionCategory("NOT SCORED");
                                    	     		}
                                    	     		
                                    	     		snpchromosome17.setAminoAcidSubs(proveandata.getAminoAcidSubs());
                                    	     		snpchromosome17.setScoreProvean(proveandata.getScoreProvean());
                                    	     		snpchromosome17.setProteinAlignNumber(proveandata.getProteinAlignNumber());
                                    	     		snpchromosome17.setTotalAlignSequenceNumber(proveandata.getTotalAlignSequenceNumber());

                                    	     		serviceSNPChromosome.update(snpchromosome17);
                                    	     		
                                    	     		intSNPChromosomeCount17++;
                                    	     	}
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( proveandata.isChromosome18() ) {

                    	                List<SNPChromosome> snpchromosome18List = new ArrayList<SNPChromosome>();

                    	     			snpchromosome18List = serviceSNPChromosome.findBySnpId(proveandata.getSnpId());
                    	     			
                    	     			if ( snpchromosome18List.isEmpty() ) {
                    	     				
                    	     				error++;

                    	     				String errorRecord = "SNP NOT FOUND!\t" + proveandata.getSnpId() + "\t" +
                    	     						proveandata.getEnsemblGene() + "\t" +
                    	     						proveandata.getEnsemblTranscript() + "\t" +
                    	     						proveandata.getEnsemblAnnotation() + "\t" +
                    	     						proveandata.getAminoAcidSubs() + "\t" +
                    	     						proveandata.getScoreProvean() + "\t" +
                    	     						proveandata.getProteinAlignNumber() + "\t" +
                    	     						proveandata.getTotalAlignSequenceNumber();

                    	     				errorRecords.add(errorRecord);

                    	     				//Wrapper.printMessage("Error No. " + error + " : SNP Id. " + proveandata.getSnpId() + " NOT FOUND : " + proveandata.toString(), MSGLEVEL, MSGLEVEL);
                    	     			}
                    	     			else {

                        	     			if ( snpchromosome18List.size() > 1 ) {
                        	     				
                        	     				error++;

                        	     				String errorRecord = "MULTIPLE SNPs!\t" + proveandata.getSnpId() + "\t" +
                        	     						proveandata.getEnsemblGene() + "\t" +
                        	     						proveandata.getEnsemblTranscript() + "\t" +
                        	     						proveandata.getEnsemblAnnotation() + "\t" +
                        	     						proveandata.getAminoAcidSubs() + "\t" +
                        	     						proveandata.getScoreProvean() + "\t" +
                        	     						proveandata.getProteinAlignNumber() + "\t" +
                        	     						proveandata.getTotalAlignSequenceNumber();

                        	     				errorRecords.add(errorRecord);

                        	     				Wrapper.printMessage("Error No. " + error + " : SNP Id. " + proveandata.getSnpId() + " GREATER THAN 1 ROW FOR : " + proveandata.toString(), MSGLEVEL, MSGLEVEL);
                        	     			}
                        	     			else {
                        	     				
                                    	        Iterator<SNPChromosome> iteratorSNPChromosome = snpchromosome18List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome.hasNext()) {

                                    	     		SNPChromosome snpchromosome18 = iteratorSNPChromosome.next();
                                    	     		
                                    	     		if ( proveandata.getScoreProvean() == 0.0 &&
                                    	     				proveandata.getProteinAlignNumber() == 0 &&
                                    	     				proveandata.getTotalAlignSequenceNumber() == 0) {
                                    	     			
                                    	     			snpchromosome18.setPredictionCategory("NOT SCORED");
                                    	     		}
                                    	     		
                                    	     		snpchromosome18.setAminoAcidSubs(proveandata.getAminoAcidSubs());
                                    	     		snpchromosome18.setScoreProvean(proveandata.getScoreProvean());
                                    	     		snpchromosome18.setProteinAlignNumber(proveandata.getProteinAlignNumber());
                                    	     		snpchromosome18.setTotalAlignSequenceNumber(proveandata.getTotalAlignSequenceNumber());

                                    	     		serviceSNPChromosome.update(snpchromosome18);
                                    	     		
                                    	     		intSNPChromosomeCount18++;
                                    	     	}
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( proveandata.isChromosome19() ) {

                    	                List<SNPChromosome> snpchromosome19List = new ArrayList<SNPChromosome>();

                    	     			snpchromosome19List = serviceSNPChromosome.findBySnpId(proveandata.getSnpId());
                    	     			
                    	     			if ( snpchromosome19List.isEmpty() ) {
                    	     				
                    	     				error++;

                    	     				String errorRecord = "SNP NOT FOUND!\t" + proveandata.getSnpId() + "\t" +
                    	     						proveandata.getEnsemblGene() + "\t" +
                    	     						proveandata.getEnsemblTranscript() + "\t" +
                    	     						proveandata.getEnsemblAnnotation() + "\t" +
                    	     						proveandata.getAminoAcidSubs() + "\t" +
                    	     						proveandata.getScoreProvean() + "\t" +
                    	     						proveandata.getProteinAlignNumber() + "\t" +
                    	     						proveandata.getTotalAlignSequenceNumber();

                    	     				errorRecords.add(errorRecord);

                    	     				//Wrapper.printMessage("Error No. " + error + " : SNP Id. " + proveandata.getSnpId() + " NOT FOUND : " + proveandata.toString(), MSGLEVEL, MSGLEVEL);
                    	     			}
                    	     			else {

                        	     			if ( snpchromosome19List.size() > 1 ) {
                        	     				
                        	     				error++;

                        	     				String errorRecord = "MULTIPLE SNPs!\t" + proveandata.getSnpId() + "\t" +
                        	     						proveandata.getEnsemblGene() + "\t" +
                        	     						proveandata.getEnsemblTranscript() + "\t" +
                        	     						proveandata.getEnsemblAnnotation() + "\t" +
                        	     						proveandata.getAminoAcidSubs() + "\t" +
                        	     						proveandata.getScoreProvean() + "\t" +
                        	     						proveandata.getProteinAlignNumber() + "\t" +
                        	     						proveandata.getTotalAlignSequenceNumber();

                        	     				errorRecords.add(errorRecord);

                        	     				Wrapper.printMessage("Error No. " + error + " : SNP Id. " + proveandata.getSnpId() + " GREATER THAN 1 ROW FOR : " + proveandata.toString(), MSGLEVEL, MSGLEVEL);
                        	     			}
                        	     			else {
                        	     				
                                    	        Iterator<SNPChromosome> iteratorSNPChromosome = snpchromosome19List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome.hasNext()) {

                                    	     		SNPChromosome snpchromosome19 = iteratorSNPChromosome.next();
                                    	     		
                                    	     		if ( proveandata.getScoreProvean() == 0.0 &&
                                    	     				proveandata.getProteinAlignNumber() == 0 &&
                                    	     				proveandata.getTotalAlignSequenceNumber() == 0) {
                                    	     			
                                    	     			snpchromosome19.setPredictionCategory("NOT SCORED");
                                    	     		}
                                    	     		
                                    	     		snpchromosome19.setAminoAcidSubs(proveandata.getAminoAcidSubs());
                                    	     		snpchromosome19.setScoreProvean(proveandata.getScoreProvean());
                                    	     		snpchromosome19.setProteinAlignNumber(proveandata.getProteinAlignNumber());
                                    	     		snpchromosome19.setTotalAlignSequenceNumber(proveandata.getTotalAlignSequenceNumber());

                                    	     		serviceSNPChromosome.update(snpchromosome19);
                                    	     		
                                    	     		intSNPChromosomeCount19++;
                                    	     	}
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( proveandata.isChromosome20() ) {
                    	     			
                    	                List<SNPChromosome> snpchromosome20List = new ArrayList<SNPChromosome>();

                    	     			snpchromosome20List = serviceSNPChromosome.findBySnpId(proveandata.getSnpId());
                    	     			
                    	     			if ( snpchromosome20List.isEmpty() ) {
                    	     				
                    	     				error++;

                    	     				String errorRecord = "SNP NOT FOUND!\t" + proveandata.getSnpId() + "\t" +
                    	     						proveandata.getEnsemblGene() + "\t" +
                    	     						proveandata.getEnsemblTranscript() + "\t" +
                    	     						proveandata.getEnsemblAnnotation() + "\t" +
                    	     						proveandata.getAminoAcidSubs() + "\t" +
                    	     						proveandata.getScoreProvean() + "\t" +
                    	     						proveandata.getProteinAlignNumber() + "\t" +
                    	     						proveandata.getTotalAlignSequenceNumber();

                    	     				errorRecords.add(errorRecord);

                    	     				//Wrapper.printMessage("Error No. " + error + " : SNP Id. " + proveandata.getSnpId() + " NOT FOUND : " + proveandata.toString(), MSGLEVEL, MSGLEVEL);
                    	     			}
                    	     			else {

                        	     			if ( snpchromosome20List.size() > 1 ) {
                        	     				
                        	     				error++;

                        	     				String errorRecord = "MULTIPLE SNPs!\t" + proveandata.getSnpId() + "\t" +
                        	     						proveandata.getEnsemblGene() + "\t" +
                        	     						proveandata.getEnsemblTranscript() + "\t" +
                        	     						proveandata.getEnsemblAnnotation() + "\t" +
                        	     						proveandata.getAminoAcidSubs() + "\t" +
                        	     						proveandata.getScoreProvean() + "\t" +
                        	     						proveandata.getProteinAlignNumber() + "\t" +
                        	     						proveandata.getTotalAlignSequenceNumber();

                        	     				errorRecords.add(errorRecord);

                        	     				Wrapper.printMessage("Error No. " + error + " : SNP Id. " + proveandata.getSnpId() + " GREATER THAN 1 ROW FOR : " + proveandata.toString(), MSGLEVEL, MSGLEVEL);
                        	     			}
                        	     			else {
                        	     				
                                    	        Iterator<SNPChromosome> iteratorSNPChromosome = snpchromosome20List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome.hasNext()) {

                                    	     		SNPChromosome snpchromosome20 = iteratorSNPChromosome.next();
                                    	     		
                                    	     		if ( proveandata.getScoreProvean() == 0.0 &&
                                    	     				proveandata.getProteinAlignNumber() == 0 &&
                                    	     				proveandata.getTotalAlignSequenceNumber() == 0) {
                                    	     			
                                    	     			snpchromosome20.setPredictionCategory("NOT SCORED");
                                    	     		}
                                    	     		
                                    	     		snpchromosome20.setAminoAcidSubs(proveandata.getAminoAcidSubs());
                                    	     		snpchromosome20.setScoreProvean(proveandata.getScoreProvean());
                                    	     		snpchromosome20.setProteinAlignNumber(proveandata.getProteinAlignNumber());
                                    	     		snpchromosome20.setTotalAlignSequenceNumber(proveandata.getTotalAlignSequenceNumber());

                                    	     		serviceSNPChromosome.update(snpchromosome20);
                                    	     		
                                    	     		intSNPChromosomeCount20++;
                                    	     	}
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( proveandata.isChromosome21() ) {

                    	                List<SNPChromosome> snpchromosome21List = new ArrayList<SNPChromosome>();

                    	     			snpchromosome21List = serviceSNPChromosome.findBySnpId(proveandata.getSnpId());
                    	     			
                    	     			if ( snpchromosome21List.isEmpty() ) {
                    	     				
                    	     				error++;

                    	     				String errorRecord = "SNP NOT FOUND!\t" + proveandata.getSnpId() + "\t" +
                    	     						proveandata.getEnsemblGene() + "\t" +
                    	     						proveandata.getEnsemblTranscript() + "\t" +
                    	     						proveandata.getEnsemblAnnotation() + "\t" +
                    	     						proveandata.getAminoAcidSubs() + "\t" +
                    	     						proveandata.getScoreProvean() + "\t" +
                    	     						proveandata.getProteinAlignNumber() + "\t" +
                    	     						proveandata.getTotalAlignSequenceNumber();

                    	     				errorRecords.add(errorRecord);

                    	     				//Wrapper.printMessage("Error No. " + error + " : SNP Id. " + proveandata.getSnpId() + " NOT FOUND : " + proveandata.toString(), MSGLEVEL, MSGLEVEL);
                    	     			}
                    	     			else {

                        	     			if ( snpchromosome21List.size() > 1 ) {
                        	     				
                        	     				error++;

                        	     				String errorRecord = "MULTIPLE SNPs!\t" + proveandata.getSnpId() + "\t" +
                        	     						proveandata.getEnsemblGene() + "\t" +
                        	     						proveandata.getEnsemblTranscript() + "\t" +
                        	     						proveandata.getEnsemblAnnotation() + "\t" +
                        	     						proveandata.getAminoAcidSubs() + "\t" +
                        	     						proveandata.getScoreProvean() + "\t" +
                        	     						proveandata.getProteinAlignNumber() + "\t" +
                        	     						proveandata.getTotalAlignSequenceNumber();

                        	     				errorRecords.add(errorRecord);

                        	     				Wrapper.printMessage("Error No. " + error + " : SNP Id. " + proveandata.getSnpId() + " GREATER THAN 1 ROW FOR : " + proveandata.toString(), MSGLEVEL, MSGLEVEL);
                        	     			}
                        	     			else {
                        	     				
                                    	        Iterator<SNPChromosome> iteratorSNPChromosome = snpchromosome21List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome.hasNext()) {

                                    	     		SNPChromosome snpchromosome21 = iteratorSNPChromosome.next();
                                    	     		
                                    	     		if ( proveandata.getScoreProvean() == 0.0 &&
                                    	     				proveandata.getProteinAlignNumber() == 0 &&
                                    	     				proveandata.getTotalAlignSequenceNumber() == 0) {
                                    	     			
                                    	     			snpchromosome21.setPredictionCategory("NOT SCORED");
                                    	     		}
                                    	     		
                                    	     		snpchromosome21.setAminoAcidSubs(proveandata.getAminoAcidSubs());
                                    	     		snpchromosome21.setScoreProvean(proveandata.getScoreProvean());
                                    	     		snpchromosome21.setProteinAlignNumber(proveandata.getProteinAlignNumber());
                                    	     		snpchromosome21.setTotalAlignSequenceNumber(proveandata.getTotalAlignSequenceNumber());

                                    	     		serviceSNPChromosome.update(snpchromosome21);
                                    	     		
                                    	     		intSNPChromosomeCount21++;
                                    	        }
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( proveandata.isChromosome22() ) {

                    	                List<SNPChromosome> snpchromosome22List = new ArrayList<SNPChromosome>();

                    	     			snpchromosome22List = serviceSNPChromosome.findBySnpId(proveandata.getSnpId());
                    	     			
                    	     			if ( snpchromosome22List.isEmpty() ) {
                    	     				
                    	     				error++;

                    	     				String errorRecord = "SNP NOT FOUND!\t" + proveandata.getSnpId() + "\t" +
                    	     						proveandata.getEnsemblGene() + "\t" +
                    	     						proveandata.getEnsemblTranscript() + "\t" +
                    	     						proveandata.getEnsemblAnnotation() + "\t" +
                    	     						proveandata.getAminoAcidSubs() + "\t" +
                    	     						proveandata.getScoreProvean() + "\t" +
                    	     						proveandata.getProteinAlignNumber() + "\t" +
                    	     						proveandata.getTotalAlignSequenceNumber();

                    	     				errorRecords.add(errorRecord);

                    	     				//Wrapper.printMessage("Error No. " + error + " : SNP Id. " + proveandata.getSnpId() + " NOT FOUND : " + proveandata.toString(), MSGLEVEL, MSGLEVEL);
                    	     			}
                    	     			else {

                        	     			if ( snpchromosome22List.size() > 1 ) {
                        	     				
                        	     				error++;

                        	     				String errorRecord = "MULTIPLE SNPs!\t" + proveandata.getSnpId() + "\t" +
                        	     						proveandata.getEnsemblGene() + "\t" +
                        	     						proveandata.getEnsemblTranscript() + "\t" +
                        	     						proveandata.getEnsemblAnnotation() + "\t" +
                        	     						proveandata.getAminoAcidSubs() + "\t" +
                        	     						proveandata.getScoreProvean() + "\t" +
                        	     						proveandata.getProteinAlignNumber() + "\t" +
                        	     						proveandata.getTotalAlignSequenceNumber();

                        	     				errorRecords.add(errorRecord);

                        	     				Wrapper.printMessage("Error No. " + error + " : SNP Id. " + proveandata.getSnpId() + " GREATER THAN 1 ROW FOR : " + proveandata.toString(), MSGLEVEL, MSGLEVEL);
                        	     			}
                        	     			else {
                        	     				
                                    	        Iterator<SNPChromosome> iteratorSNPChromosome = snpchromosome22List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome.hasNext()) {

                                    	     		SNPChromosome snpchromosome22 = iteratorSNPChromosome.next();
                                    	     		
                                    	     		if ( proveandata.getScoreProvean() == 0.0 &&
                                    	     				proveandata.getProteinAlignNumber() == 0 &&
                                    	     				proveandata.getTotalAlignSequenceNumber() == 0) {
                                    	     			
                                    	     			snpchromosome22.setPredictionCategory("NOT SCORED");
                                    	     		}
                                    	     		
                                    	     		snpchromosome22.setAminoAcidSubs(proveandata.getAminoAcidSubs());
                                    	     		snpchromosome22.setScoreProvean(proveandata.getScoreProvean());
                                    	     		snpchromosome22.setProteinAlignNumber(proveandata.getProteinAlignNumber());
                                    	     		snpchromosome22.setTotalAlignSequenceNumber(proveandata.getTotalAlignSequenceNumber());

                                    	     		serviceSNPChromosome.update(snpchromosome22);
                                    	     		
                                    	     		intSNPChromosomeCount22++;
                                    	     	}
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( proveandata.isChromosome23() ) {
                    	     			
                    	                List<SNPChromosome> snpchromosome23List = new ArrayList<SNPChromosome>();
                    	                
                    	                snpchromosome23List = serviceSNPChromosome.findBySnpId(proveandata.getSnpId());
                    	                
                    	     			if ( snpchromosome23List.isEmpty() ) {
                    	     				
                    	     				error++;

                    	     				String errorRecord = "SNP NOT FOUND!\t" + proveandata.getSnpId() + "\t" +
                    	     						proveandata.getEnsemblGene() + "\t" +
                    	     						proveandata.getEnsemblTranscript() + "\t" +
                    	     						proveandata.getEnsemblAnnotation() + "\t" +
                    	     						proveandata.getAminoAcidSubs() + "\t" +
                    	     						proveandata.getScoreProvean() + "\t" +
                    	     						proveandata.getProteinAlignNumber() + "\t" +
                    	     						proveandata.getTotalAlignSequenceNumber();

                    	     				errorRecords.add(errorRecord);

                    	     				//Wrapper.printMessage("Error No. " + error + " : SNP Id. " + proveandata.getSnpId() + " NOT FOUND : " + proveandata.toString(), MSGLEVEL, MSGLEVEL);
                    	     			}
                    	     			else {

                        	     			if ( snpchromosome23List.size() > 1 ) {
                        	     				
                        	     				error++;

                        	     				String errorRecord = "MULTIPLE SNPs!\t" + proveandata.getSnpId() + "\t" +
                        	     						proveandata.getEnsemblGene() + "\t" +
                        	     						proveandata.getEnsemblTranscript() + "\t" +
                        	     						proveandata.getEnsemblAnnotation() + "\t" +
                        	     						proveandata.getAminoAcidSubs() + "\t" +
                        	     						proveandata.getScoreProvean() + "\t" +
                        	     						proveandata.getProteinAlignNumber() + "\t" +
                        	     						proveandata.getTotalAlignSequenceNumber();

                        	     				errorRecords.add(errorRecord);

                        	     				Wrapper.printMessage("Error No. " + error + " : SNP Id. " + proveandata.getSnpId() + " GREATER THAN 1 ROW FOR : " + proveandata.toString(), MSGLEVEL, MSGLEVEL);
                        	     			}
                        	     			else {
                        	     				
                                    	        Iterator<SNPChromosome> iteratorSNPChromosome = snpchromosome23List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome.hasNext()) {

                                    	     		SNPChromosome snpchromosome23 = iteratorSNPChromosome.next();
                                    	     		
                                    	     		if ( proveandata.getScoreProvean() == 0.0 &&
                                    	     				proveandata.getProteinAlignNumber() == 0 &&
                                    	     				proveandata.getTotalAlignSequenceNumber() == 0) {
                                    	     			
                                    	     			snpchromosome23.setPredictionCategory("NOT SCORED");
                                    	     		}
                                    	     		
                                    	     		snpchromosome23.setAminoAcidSubs(proveandata.getAminoAcidSubs());
                                    	     		snpchromosome23.setScoreProvean(proveandata.getScoreProvean());
                                    	     		snpchromosome23.setProteinAlignNumber(proveandata.getProteinAlignNumber());
                                    	     		snpchromosome23.setTotalAlignSequenceNumber(proveandata.getTotalAlignSequenceNumber());

                                    	     		serviceSNPChromosome.update(snpchromosome23);
                                    	     		
                                    	     		intSNPChromosomeCount23++;
                                    	     	}
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( proveandata.isChromosome24() ) {
                    	     			
                    	     			List<SNPChromosome> snpchromosome24List = new ArrayList<SNPChromosome>();

                    	                snpchromosome24List = serviceSNPChromosome.findBySnpId(proveandata.getSnpId());
                    	                
                    	     			if ( snpchromosome24List.isEmpty() ) {
                    	     				
                    	     				error++;

                    	     				String errorRecord = "SNP NOT FOUND!\t" + proveandata.getSnpId() + "\t" +
                    	     						proveandata.getEnsemblGene() + "\t" +
                    	     						proveandata.getEnsemblTranscript() + "\t" +
                    	     						proveandata.getEnsemblAnnotation() + "\t" +
                    	     						proveandata.getAminoAcidSubs() + "\t" +
                    	     						proveandata.getScoreProvean() + "\t" +
                    	     						proveandata.getProteinAlignNumber() + "\t" +
                    	     						proveandata.getTotalAlignSequenceNumber();

                    	     				errorRecords.add(errorRecord);

                    	     				//Wrapper.printMessage("Error No. " + error + " : SNP Id. " + proveandata.getSnpId() + " NOT FOUND : " + proveandata.toString(), MSGLEVEL, MSGLEVEL);
                    	     			}
                    	     			else {

                        	     			if ( snpchromosome24List.size() > 1 ) {
                        	     				
                        	     				error++;

                        	     				String errorRecord = "MULTIPLE SNPs!\t" + proveandata.getSnpId() + "\t" +
                        	     						proveandata.getEnsemblGene() + "\t" +
                        	     						proveandata.getEnsemblTranscript() + "\t" +
                        	     						proveandata.getEnsemblAnnotation() + "\t" +
                        	     						proveandata.getAminoAcidSubs() + "\t" +
                        	     						proveandata.getScoreProvean() + "\t" +
                        	     						proveandata.getProteinAlignNumber() + "\t" +
                        	     						proveandata.getTotalAlignSequenceNumber();

                        	     				errorRecords.add(errorRecord);

                        	     				Wrapper.printMessage("Error No. " + error + " : SNP Id. " + proveandata.getSnpId() + " GREATER THAN 1 ROW FOR : " + proveandata.toString(), MSGLEVEL, MSGLEVEL);
                        	     			}
                        	     			else {
                        	     				
                                    	        Iterator<SNPChromosome> iteratorSNPChromosome = snpchromosome24List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome.hasNext()) {

                                    	     		SNPChromosome snpchromosome24 = iteratorSNPChromosome.next();
                                    	     		
                                    	     		if ( proveandata.getScoreProvean() == 0.0 &&
                                    	     				proveandata.getProteinAlignNumber() == 0 &&
                                    	     				proveandata.getTotalAlignSequenceNumber() == 0) {
                                    	     			
                                    	     			snpchromosome24.setPredictionCategory("NOT SCORED");
                                    	     		}
                                    	     		
                                    	     		snpchromosome24.setAminoAcidSubs(proveandata.getAminoAcidSubs());
                                    	     		snpchromosome24.setScoreProvean(proveandata.getScoreProvean());
                                    	     		snpchromosome24.setProteinAlignNumber(proveandata.getProteinAlignNumber());
                                    	     		snpchromosome24.setTotalAlignSequenceNumber(proveandata.getTotalAlignSequenceNumber());

                                    	     		serviceSNPChromosome.update(snpchromosome24);
                                    	     		
                                    	     		intSNPChromosomeCount24++;
                                    	     	}
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( proveandata.isChromosome25() ) {
                    	     			
                    	                List<SNPChromosome> snpchromosome25List = new ArrayList<SNPChromosome>();

                    	     			snpchromosome25List = serviceSNPChromosome.findBySnpId(proveandata.getSnpId());
                    	     			
                    	     			if ( snpchromosome25List.isEmpty() ) {
                    	     				
                    	     				error++;

                    	     				String errorRecord = "SNP NOT FOUND!\t" + proveandata.getSnpId() + "\t" +
                    	     						proveandata.getEnsemblGene() + "\t" +
                    	     						proveandata.getEnsemblTranscript() + "\t" +
                    	     						proveandata.getEnsemblAnnotation() + "\t" +
                    	     						proveandata.getAminoAcidSubs() + "\t" +
                    	     						proveandata.getScoreProvean() + "\t" +
                    	     						proveandata.getProteinAlignNumber() + "\t" +
                    	     						proveandata.getTotalAlignSequenceNumber();

                    	     				errorRecords.add(errorRecord);

                    	     				//Wrapper.printMessage("Error No. " + error + " : SNP Id. " + proveandata.getSnpId() + " NOT FOUND : " + proveandata.toString(), MSGLEVEL, MSGLEVEL);
                    	     			}
                    	     			else {

                        	     			if ( snpchromosome25List.size() > 1 ) {
                        	     				
                        	     				error++;

                        	     				String errorRecord = "MULTIPLE SNPs!\t" + proveandata.getSnpId() + "\t" +
                        	     						proveandata.getEnsemblGene() + "\t" +
                        	     						proveandata.getEnsemblTranscript() + "\t" +
                        	     						proveandata.getEnsemblAnnotation() + "\t" +
                        	     						proveandata.getAminoAcidSubs() + "\t" +
                        	     						proveandata.getScoreProvean() + "\t" +
                        	     						proveandata.getProteinAlignNumber() + "\t" +
                        	     						proveandata.getTotalAlignSequenceNumber();

                        	     				errorRecords.add(errorRecord);

                        	     				Wrapper.printMessage("Error No. " + error + " : SNP Id. " + proveandata.getSnpId() + " GREATER THAN 1 ROW FOR : " + proveandata.toString(), MSGLEVEL, MSGLEVEL);
                        	     			}
                        	     			else {
                        	     				
                                    	        Iterator<SNPChromosome> iteratorSNPChromosome = snpchromosome25List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome.hasNext()) {

                                    	     		SNPChromosome snpchromosome25 = iteratorSNPChromosome.next();
                                    	     		
                                    	     		if ( proveandata.getScoreProvean() == 0.0 &&
                                    	     				proveandata.getProteinAlignNumber() == 0 &&
                                    	     				proveandata.getTotalAlignSequenceNumber() == 0) {
                                    	     			
                                    	     			snpchromosome25.setPredictionCategory("NOT SCORED");
                                    	     		}
                                    	     		
                                    	     		snpchromosome25.setAminoAcidSubs(proveandata.getAminoAcidSubs());
                                    	     		snpchromosome25.setScoreProvean(proveandata.getScoreProvean());
                                    	     		snpchromosome25.setProteinAlignNumber(proveandata.getProteinAlignNumber());
                                    	     		snpchromosome25.setTotalAlignSequenceNumber(proveandata.getTotalAlignSequenceNumber());

                                    	     		serviceSNPChromosome.update(snpchromosome25);
                                    	     		
                                    	     		intSNPChromosomeCount25++;
                                    	     	}
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( proveandata.isChromosome26() ) {

                    	                List<SNPChromosome> snpchromosome26List = new ArrayList<SNPChromosome>();

                    	     			snpchromosome26List = serviceSNPChromosome.findBySnpId(proveandata.getSnpId());
                    	     			
                    	     			if ( snpchromosome26List.isEmpty() ) {
                    	     				
                    	     				error++;

                    	     				String errorRecord = "SNP NOT FOUND!\t" + proveandata.getSnpId() + "\t" +
                    	     						proveandata.getEnsemblGene() + "\t" +
                    	     						proveandata.getEnsemblTranscript() + "\t" +
                    	     						proveandata.getEnsemblAnnotation() + "\t" +
                    	     						proveandata.getAminoAcidSubs() + "\t" +
                    	     						proveandata.getScoreProvean() + "\t" +
                    	     						proveandata.getProteinAlignNumber() + "\t" +
                    	     						proveandata.getTotalAlignSequenceNumber();

                    	     				errorRecords.add(errorRecord);

                    	     				//Wrapper.printMessage("Error No. " + error + " : SNP Id. " + proveandata.getSnpId() + " NOT FOUND : " + proveandata.toString(), MSGLEVEL, MSGLEVEL);
                    	     			}
                    	     			else {

                        	     			if ( snpchromosome26List.size() > 1 ) {
                        	     				
                        	     				error++;

                        	     				String errorRecord = "MULTIPLE SNPs!\t" + proveandata.getSnpId() + "\t" +
                        	     						proveandata.getEnsemblGene() + "\t" +
                        	     						proveandata.getEnsemblTranscript() + "\t" +
                        	     						proveandata.getEnsemblAnnotation() + "\t" +
                        	     						proveandata.getAminoAcidSubs() + "\t" +
                        	     						proveandata.getScoreProvean() + "\t" +
                        	     						proveandata.getProteinAlignNumber() + "\t" +
                        	     						proveandata.getTotalAlignSequenceNumber();

                        	     				errorRecords.add(errorRecord);

                        	     				Wrapper.printMessage("Error No. " + error + " : SNP Id. " + proveandata.getSnpId() + " GREATER THAN 1 ROW FOR : " + proveandata.toString(), MSGLEVEL, MSGLEVEL);
                        	     			}
                        	     			else {
                        	     				
                                    	        Iterator<SNPChromosome> iteratorSNPChromosome = snpchromosome26List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome.hasNext()) {

                                    	     		SNPChromosome snpchromosome26 = iteratorSNPChromosome.next();
                                    	     		
                                    	     		if ( proveandata.getScoreProvean() == 0.0 &&
                                    	     				proveandata.getProteinAlignNumber() == 0 &&
                                    	     				proveandata.getTotalAlignSequenceNumber() == 0) {
                                    	     			
                                    	     			snpchromosome26.setPredictionCategory("NOT SCORED");
                                    	     		}
                                    	     		
                                    	     		snpchromosome26.setAminoAcidSubs(proveandata.getAminoAcidSubs());
                                    	     		snpchromosome26.setScoreProvean(proveandata.getScoreProvean());
                                    	     		snpchromosome26.setProteinAlignNumber(proveandata.getProteinAlignNumber());
                                    	     		snpchromosome26.setTotalAlignSequenceNumber(proveandata.getTotalAlignSequenceNumber());

                                    	     		serviceSNPChromosome.update(snpchromosome26);
                                    	     		
                                    	     		intSNPChromosomeCount26++;
                                    	     	}
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( proveandata.isChromosome27() ) {
                    	     			
                    	                List<SNPChromosome> snpchromosome27List = new ArrayList<SNPChromosome>();

                    	     			snpchromosome27List = serviceSNPChromosome.findBySnpId(proveandata.getSnpId());
                    	     			
                    	     			if ( snpchromosome27List.isEmpty() ) {
                    	     				
                    	     				error++;

                    	     				String errorRecord = "SNP NOT FOUND!\t" + proveandata.getSnpId() + "\t" +
                    	     						proveandata.getEnsemblGene() + "\t" +
                    	     						proveandata.getEnsemblTranscript() + "\t" +
                    	     						proveandata.getEnsemblAnnotation() + "\t" +
                    	     						proveandata.getAminoAcidSubs() + "\t" +
                    	     						proveandata.getScoreProvean() + "\t" +
                    	     						proveandata.getProteinAlignNumber() + "\t" +
                    	     						proveandata.getTotalAlignSequenceNumber();

                    	     				errorRecords.add(errorRecord);

                    	     				//Wrapper.printMessage("Error No. " + error + " : SNP Id. " + proveandata.getSnpId() + " NOT FOUND : " + proveandata.toString(), MSGLEVEL, MSGLEVEL);
                    	     			}
                    	     			else {

                        	     			if ( snpchromosome27List.size() > 1 ) {
                        	     				
                        	     				error++;

                        	     				String errorRecord = "MULTIPLE SNPs!\t" + proveandata.getSnpId() + "\t" +
                        	     						proveandata.getEnsemblGene() + "\t" +
                        	     						proveandata.getEnsemblTranscript() + "\t" +
                        	     						proveandata.getEnsemblAnnotation() + "\t" +
                        	     						proveandata.getAminoAcidSubs() + "\t" +
                        	     						proveandata.getScoreProvean() + "\t" +
                        	     						proveandata.getProteinAlignNumber() + "\t" +
                        	     						proveandata.getTotalAlignSequenceNumber();

                        	     				errorRecords.add(errorRecord);

                        	     				Wrapper.printMessage("Error No. " + error + " : SNP Id. " + proveandata.getSnpId() + " GREATER THAN 1 ROW FOR : " + proveandata.toString(), MSGLEVEL, MSGLEVEL);
                        	     			}
                        	     			else {
                        	     				
                                    	        Iterator<SNPChromosome> iteratorSNPChromosome = snpchromosome27List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome.hasNext()) {

                                    	     		SNPChromosome snpchromosome27 = iteratorSNPChromosome.next();
                                    	     		
                                    	     		if ( proveandata.getScoreProvean() == 0.0 &&
                                    	     				proveandata.getProteinAlignNumber() == 0 &&
                                    	     				proveandata.getTotalAlignSequenceNumber() == 0) {
                                    	     			
                                    	     			snpchromosome27.setPredictionCategory("NOT SCORED");
                                    	     		}
                                    	     		
                                    	     		snpchromosome27.setAminoAcidSubs(proveandata.getAminoAcidSubs());
                                    	     		snpchromosome27.setScoreProvean(proveandata.getScoreProvean());
                                    	     		snpchromosome27.setProteinAlignNumber(proveandata.getProteinAlignNumber());
                                    	     		snpchromosome27.setTotalAlignSequenceNumber(proveandata.getTotalAlignSequenceNumber());

                                    	     		serviceSNPChromosome.update(snpchromosome27);
                                    	     		
                                    	     		intSNPChromosomeCount27++;
                                    	     	}
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( proveandata.isChromosome28() ) {

                    	                List<SNPChromosome> snpchromosome28List = new ArrayList<SNPChromosome>();

                    	     			snpchromosome28List = serviceSNPChromosome.findBySnpId(proveandata.getSnpId());
                    	     			
                    	     			if ( snpchromosome28List.isEmpty() ) {
                    	     				
                    	     				error++;

                    	     				String errorRecord = "SNP NOT FOUND!\t" + proveandata.getSnpId() + "\t" +
                    	     						proveandata.getEnsemblGene() + "\t" +
                    	     						proveandata.getEnsemblTranscript() + "\t" +
                    	     						proveandata.getEnsemblAnnotation() + "\t" +
                    	     						proveandata.getAminoAcidSubs() + "\t" +
                    	     						proveandata.getScoreProvean() + "\t" +
                    	     						proveandata.getProteinAlignNumber() + "\t" +
                    	     						proveandata.getTotalAlignSequenceNumber();

                    	     				errorRecords.add(errorRecord);

                    	     				//Wrapper.printMessage("Error No. " + error + " : SNP Id. " + proveandata.getSnpId() + " NOT FOUND : " + proveandata.toString(), MSGLEVEL, MSGLEVEL);
                    	     			}
                    	     			else {
                    	     				
                        	     			if ( snpchromosome28List.size() > 1 ) {
                        	     				
                        	     				error++;

                        	     				String errorRecord = "MULTIPLE SNPs!\t" + proveandata.getSnpId() + "\t" +
                        	     						proveandata.getEnsemblGene() + "\t" +
                        	     						proveandata.getEnsemblTranscript() + "\t" +
                        	     						proveandata.getEnsemblAnnotation() + "\t" +
                        	     						proveandata.getAminoAcidSubs() + "\t" +
                        	     						proveandata.getScoreProvean() + "\t" +
                        	     						proveandata.getProteinAlignNumber() + "\t" +
                        	     						proveandata.getTotalAlignSequenceNumber();

                        	     				errorRecords.add(errorRecord);

                        	     				Wrapper.printMessage("Error No. " + error + " : SNP Id. " + proveandata.getSnpId() + " GREATER THAN 1 ROW FOR : " + proveandata.toString(), MSGLEVEL, MSGLEVEL);
                        	     			}
                        	     			else {
                        	     				
                                    	        Iterator<SNPChromosome> iteratorSNPChromosome = snpchromosome28List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome.hasNext()) {

                                    	     		SNPChromosome snpchromosome28 = iteratorSNPChromosome.next();
                                    	     		
                                    	     		if ( proveandata.getScoreProvean() == 0.0 &&
                                    	     				proveandata.getProteinAlignNumber() == 0 &&
                                    	     				proveandata.getTotalAlignSequenceNumber() == 0) {
                                    	     			
                                    	     			snpchromosome28.setPredictionCategory("NOT SCORED");
                                    	     		}
                                    	     		
                                    	     		snpchromosome28.setAminoAcidSubs(proveandata.getAminoAcidSubs());
                                    	     		snpchromosome28.setScoreProvean(proveandata.getScoreProvean());
                                    	     		snpchromosome28.setProteinAlignNumber(proveandata.getProteinAlignNumber());
                                    	     		snpchromosome28.setTotalAlignSequenceNumber(proveandata.getTotalAlignSequenceNumber());

                                    	     		serviceSNPChromosome.update(snpchromosome28);
                                    	     		
                                    	     		intSNPChromosomeCount28++;
                                    	     	}
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( proveandata.isChromosome32() ) {
                    	     			
                    	                List<SNPChromosome> snpchromosome32List = new ArrayList<SNPChromosome>();

                    	     			snpchromosome32List = serviceSNPChromosome.findBySnpId(proveandata.getSnpId());
                    	     			
                    	     			if ( snpchromosome32List.isEmpty() ) {
                    	     				
                    	     				error++;

                    	     				String errorRecord = "SNP NOT FOUND!\t" + proveandata.getSnpId() + "\t" +
                    	     						proveandata.getEnsemblGene() + "\t" +
                    	     						proveandata.getEnsemblTranscript() + "\t" +
                    	     						proveandata.getEnsemblAnnotation() + "\t" +
                    	     						proveandata.getAminoAcidSubs() + "\t" +
                    	     						proveandata.getScoreProvean() + "\t" +
                    	     						proveandata.getProteinAlignNumber() + "\t" +
                    	     						proveandata.getTotalAlignSequenceNumber();

                    	     				errorRecords.add(errorRecord);

                    	     				//Wrapper.printMessage("Error No. " + error + " : SNP Id. " + proveandata.getSnpId() + " NOT FOUND : " + proveandata.toString(), MSGLEVEL, MSGLEVEL);
                    	     			}
                    	     			else {

                        	     			if ( snpchromosome32List.size() > 1 ) {
                        	     				
                        	     				error++;

                        	     				String errorRecord = "MULTIPLE SNPs!\t" + proveandata.getSnpId() + "\t" +
                        	     						proveandata.getEnsemblGene() + "\t" +
                        	     						proveandata.getEnsemblTranscript() + "\t" +
                        	     						proveandata.getEnsemblAnnotation() + "\t" +
                        	     						proveandata.getAminoAcidSubs() + "\t" +
                        	     						proveandata.getScoreProvean() + "\t" +
                        	     						proveandata.getProteinAlignNumber() + "\t" +
                        	     						proveandata.getTotalAlignSequenceNumber();

                        	     				errorRecords.add(errorRecord);

                        	     				Wrapper.printMessage("Error No. " + error + " : SNP Id. " + proveandata.getSnpId() + " GREATER THAN 1 ROW FOR : " + proveandata.toString(), MSGLEVEL, MSGLEVEL);
                        	     			}
                        	     			else {
                        	     				
                                    	        Iterator<SNPChromosome> iteratorSNPChromosome = snpchromosome32List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome.hasNext()) {

                                    	     		SNPChromosome snpchromosome32 = iteratorSNPChromosome.next();
                                    	     		
                                    	     		if ( proveandata.getScoreProvean() == 0.0 &&
                                    	     				proveandata.getProteinAlignNumber() == 0 &&
                                    	     				proveandata.getTotalAlignSequenceNumber() == 0) {
                                    	     			
                                    	     			snpchromosome32.setPredictionCategory("NOT SCORED");
                                    	     		}
                                    	     		
                                    	     		snpchromosome32.setAminoAcidSubs(proveandata.getAminoAcidSubs());
                                    	     		snpchromosome32.setScoreProvean(proveandata.getScoreProvean());
                                    	     		snpchromosome32.setProteinAlignNumber(proveandata.getProteinAlignNumber());
                                    	     		snpchromosome32.setTotalAlignSequenceNumber(proveandata.getTotalAlignSequenceNumber());

                                    	     		serviceSNPChromosome.update(snpchromosome32);
                                    	     		
                                    	     		intSNPChromosomeCount32++;
                                    	     	}
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( proveandata.isChromosomeLGE64() ) {
                    	     			
                    	                List<SNPChromosome> snpchromosomeLGE64List = new ArrayList<SNPChromosome>();

                    	     			snpchromosomeLGE64List = serviceSNPChromosome.findBySnpId(proveandata.getSnpId());
                    	     			
                    	     			if ( snpchromosomeLGE64List.isEmpty() ) {
                    	     				
                    	     				error++;

                    	     				String errorRecord = "SNP NOT FOUND!\t" + proveandata.getSnpId() + "\t" +
                    	     						proveandata.getEnsemblGene() + "\t" +
                    	     						proveandata.getEnsemblTranscript() + "\t" +
                    	     						proveandata.getEnsemblAnnotation() + "\t" +
                    	     						proveandata.getAminoAcidSubs() + "\t" +
                    	     						proveandata.getScoreProvean() + "\t" +
                    	     						proveandata.getProteinAlignNumber() + "\t" +
                    	     						proveandata.getTotalAlignSequenceNumber();

                    	     				errorRecords.add(errorRecord);

                    	     				//Wrapper.printMessage("Error No. " + error + " : SNP Id. " + proveandata.getSnpId() + " NOT FOUND : " + proveandata.toString(), MSGLEVEL, MSGLEVEL);
                    	     			}
                    	     			else {

                        	     			if ( snpchromosomeLGE64List.size() > 1 ) {
                        	     				
                        	     				error++;

                        	     				String errorRecord = "MULTIPLE SNPs!\t" + proveandata.getSnpId() + "\t" +
                        	     						proveandata.getEnsemblGene() + "\t" +
                        	     						proveandata.getEnsemblTranscript() + "\t" +
                        	     						proveandata.getEnsemblAnnotation() + "\t" +
                        	     						proveandata.getAminoAcidSubs() + "\t" +
                        	     						proveandata.getScoreProvean() + "\t" +
                        	     						proveandata.getProteinAlignNumber() + "\t" +
                        	     						proveandata.getTotalAlignSequenceNumber();

                        	     				errorRecords.add(errorRecord);

                        	     				Wrapper.printMessage("Error No. " + error + " : SNP Id. " + proveandata.getSnpId() + " GREATER THAN 1 ROW FOR : " + proveandata.toString(), MSGLEVEL, MSGLEVEL);
                        	     			}
                        	     			else {
                        	     				
                                    	        Iterator<SNPChromosome> iteratorSNPChromosome = snpchromosomeLGE64List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome.hasNext()) {

                                    	     		SNPChromosome snpchromosomeLGE64 = iteratorSNPChromosome.next();
                                    	     		
                                    	     		if ( proveandata.getScoreProvean() == 0.0 &&
                                    	     				proveandata.getProteinAlignNumber() == 0 &&
                                    	     				proveandata.getTotalAlignSequenceNumber() == 0) {
                                    	     			
                                    	     			snpchromosomeLGE64.setPredictionCategory("NOT SCORED");
                                    	     		}
                                    	     		
                                    	     		snpchromosomeLGE64.setAminoAcidSubs(proveandata.getAminoAcidSubs());
                                    	     		snpchromosomeLGE64.setScoreProvean(proveandata.getScoreProvean());
                                    	     		snpchromosomeLGE64.setProteinAlignNumber(proveandata.getProteinAlignNumber());
                                    	     		snpchromosomeLGE64.setTotalAlignSequenceNumber(proveandata.getTotalAlignSequenceNumber());

                                    	     		serviceSNPChromosome.update(snpchromosomeLGE64);
                                    	     		
                                    	     		intSNPChromosomeCountLGE64++;
                                    	     	}
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( proveandata.isChromosomeLGE22C19W28_E50C23() ) {
                    	     			
                    	                List<SNPChromosome> snpchromosomeLGE22C19W28_E50C23List = new ArrayList<SNPChromosome>();

                    	     			snpchromosomeLGE22C19W28_E50C23List = serviceSNPChromosome.findBySnpId(proveandata.getSnpId());
                    	     			
                    	     			if ( snpchromosomeLGE22C19W28_E50C23List.isEmpty() ) {
                    	     				
                    	     				error++;

                    	     				String errorRecord = "SNP NOT FOUND!\t" + proveandata.getSnpId() + "\t" +
                    	     						proveandata.getEnsemblGene() + "\t" +
                    	     						proveandata.getEnsemblTranscript() + "\t" +
                    	     						proveandata.getEnsemblAnnotation() + "\t" +
                    	     						proveandata.getAminoAcidSubs() + "\t" +
                    	     						proveandata.getScoreProvean() + "\t" +
                    	     						proveandata.getProteinAlignNumber() + "\t" +
                    	     						proveandata.getTotalAlignSequenceNumber();

                    	     				errorRecords.add(errorRecord);

                    	     				//Wrapper.printMessage("Error No. " + error + " : SNP Id. " + proveandata.getSnpId() + " NOT FOUND : " + proveandata.toString(), MSGLEVEL, MSGLEVEL);
                    	     			}
                    	     			else {
                    	     				
                        	     			if ( snpchromosomeLGE22C19W28_E50C23List.size() > 1 ) {
                        	     				
                        	     				error++;

                        	     				String errorRecord = "MULTIPLE SNPs!\t" + proveandata.getSnpId() + "\t" +
                        	     						proveandata.getEnsemblGene() + "\t" +
                        	     						proveandata.getEnsemblTranscript() + "\t" +
                        	     						proveandata.getEnsemblAnnotation() + "\t" +
                        	     						proveandata.getAminoAcidSubs() + "\t" +
                        	     						proveandata.getScoreProvean() + "\t" +
                        	     						proveandata.getProteinAlignNumber() + "\t" +
                        	     						proveandata.getTotalAlignSequenceNumber();

                        	     				errorRecords.add(errorRecord);

                        	     				Wrapper.printMessage("Error No. " + error + " : SNP Id. " + proveandata.getSnpId() + " GREATER THAN 1 ROW FOR : " + proveandata.toString(), MSGLEVEL, MSGLEVEL);
                        	     			}
                        	     			else {
                        	     				
                                    	        Iterator<SNPChromosome> iteratorSNPChromosome = snpchromosomeLGE22C19W28_E50C23List.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome.hasNext()) {

                                    	     		SNPChromosome snpchromosomeLGE22C19W28_E50C23 = iteratorSNPChromosome.next();
                                    	     		
                                    	     		if ( proveandata.getScoreProvean() == 0.0 &&
                                    	     				proveandata.getProteinAlignNumber() == 0 &&
                                    	     				proveandata.getTotalAlignSequenceNumber() == 0) {
                                    	     			
                                    	     			snpchromosomeLGE22C19W28_E50C23.setPredictionCategory("NOT SCORED");
                                    	     		}
                                    	     		
                                    	     		snpchromosomeLGE22C19W28_E50C23.setAminoAcidSubs(proveandata.getAminoAcidSubs());
                                    	     		snpchromosomeLGE22C19W28_E50C23.setScoreProvean(proveandata.getScoreProvean());
                                    	     		snpchromosomeLGE22C19W28_E50C23.setProteinAlignNumber(proveandata.getProteinAlignNumber());
                                    	     		snpchromosomeLGE22C19W28_E50C23.setTotalAlignSequenceNumber(proveandata.getTotalAlignSequenceNumber());

                                    	     		serviceSNPChromosome.update(snpchromosomeLGE22C19W28_E50C23);
                                    	     		
                                    	     		intSNPChromosomeCountLGE22C19W28_E50C23++;
                                    	     	}
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( proveandata.isChromosomeW() ) {
                    	     			
                    	                List<SNPChromosome> snpchromosomeWList = new ArrayList<SNPChromosome>();

                    	     			snpchromosomeWList = serviceSNPChromosome.findBySnpId(proveandata.getSnpId());
                    	     			
                    	     			if ( snpchromosomeWList.isEmpty() ) {
                    	     				
                    	     				error++;

                    	     				String errorRecord = "SNP NOT FOUND!\t" + proveandata.getSnpId() + "\t" +
                    	     						proveandata.getEnsemblGene() + "\t" +
                    	     						proveandata.getEnsemblTranscript() + "\t" +
                    	     						proveandata.getEnsemblAnnotation() + "\t" +
                    	     						proveandata.getAminoAcidSubs() + "\t" +
                    	     						proveandata.getScoreProvean() + "\t" +
                    	     						proveandata.getProteinAlignNumber() + "\t" +
                    	     						proveandata.getTotalAlignSequenceNumber();

                    	     				errorRecords.add(errorRecord);

                    	     				//Wrapper.printMessage("Error No. " + error + " : SNP Id. " + proveandata.getSnpId() + " NOT FOUND : " + proveandata.toString(), MSGLEVEL, MSGLEVEL);
                    	     			}
                    	     			else {
                    	     				
                        	     			if ( snpchromosomeWList.size() > 1 ) {
                        	     				
                        	     				error++;

                        	     				String errorRecord = "MULTIPLE SNPs!\t" + proveandata.getSnpId() + "\t" +
                        	     						proveandata.getEnsemblGene() + "\t" +
                        	     						proveandata.getEnsemblTranscript() + "\t" +
                        	     						proveandata.getEnsemblAnnotation() + "\t" +
                        	     						proveandata.getAminoAcidSubs() + "\t" +
                        	     						proveandata.getScoreProvean() + "\t" +
                        	     						proveandata.getProteinAlignNumber() + "\t" +
                        	     						proveandata.getTotalAlignSequenceNumber();

                        	     				errorRecords.add(errorRecord);

                        	     				Wrapper.printMessage("Error No. " + error + " : SNP Id. " + proveandata.getSnpId() + " GREATER THAN 1 ROW FOR : " + proveandata.toString(), MSGLEVEL, MSGLEVEL);
                        	     			}
                        	     			else {

                                    	        Iterator<SNPChromosome> iteratorSNPChromosome = snpchromosomeWList.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome.hasNext()) {

                                    	     		SNPChromosome snpchromosomeW = iteratorSNPChromosome.next();
                                    	     		
                                    	     		if ( proveandata.getScoreProvean() == 0.0 &&
                                    	     				proveandata.getProteinAlignNumber() == 0 &&
                                    	     				proveandata.getTotalAlignSequenceNumber() == 0) {
                                    	     			
                                    	     			snpchromosomeW.setPredictionCategory("NOT SCORED");
                                    	     		}
                                    	     		
                                    	     		snpchromosomeW.setAminoAcidSubs(proveandata.getAminoAcidSubs());
                                    	     		snpchromosomeW.setScoreProvean(proveandata.getScoreProvean());
                                    	     		snpchromosomeW.setProteinAlignNumber(proveandata.getProteinAlignNumber());
                                    	     		snpchromosomeW.setTotalAlignSequenceNumber(proveandata.getTotalAlignSequenceNumber());

                                    	     		serviceSNPChromosome.update(snpchromosomeW);
                                    	     		
                                    	     		intSNPChromosomeCountW++;
                                    	     	}
                        	     			}
                    	     			}
                    	     		}

                    	     		if ( proveandata.isChromosomeZ() ) {
                    	     			
                    	                List<SNPChromosome> snpchromosomeZList = new ArrayList<SNPChromosome>();

                    	     			snpchromosomeZList = serviceSNPChromosome.findBySnpId(proveandata.getSnpId());
                    	     			
                    	     			if ( snpchromosomeZList.isEmpty() ) {
                    	     				
                    	     				error++;

                    	     				String errorRecord = "SNP NOT FOUND!\t" + proveandata.getSnpId() + "\t" +
                    	     						proveandata.getEnsemblGene() + "\t" +
                    	     						proveandata.getEnsemblTranscript() + "\t" +
                    	     						proveandata.getEnsemblAnnotation() + "\t" +
                    	     						proveandata.getAminoAcidSubs() + "\t" +
                    	     						proveandata.getScoreProvean() + "\t" +
                    	     						proveandata.getProteinAlignNumber() + "\t" +
                    	     						proveandata.getTotalAlignSequenceNumber();

                    	     				errorRecords.add(errorRecord);

                    	     				//Wrapper.printMessage("Error No. " + error + " : SNP Id. " + proveandata.getSnpId() + " NOT FOUND : " + proveandata.toString(), MSGLEVEL, MSGLEVEL);
                    	     			}
                    	     			else {
                    	     				
                        	     			if ( snpchromosomeZList.size() > 1 ) {
                        	     				
                        	     				error++;

                        	     				String errorRecord = "MULTIPLE SNPs!\t" + proveandata.getSnpId() + "\t" +
                        	     						proveandata.getEnsemblGene() + "\t" +
                        	     						proveandata.getEnsemblTranscript() + "\t" +
                        	     						proveandata.getEnsemblAnnotation() + "\t" +
                        	     						proveandata.getAminoAcidSubs() + "\t" +
                        	     						proveandata.getScoreProvean() + "\t" +
                        	     						proveandata.getProteinAlignNumber() + "\t" +
                        	     						proveandata.getTotalAlignSequenceNumber();

                        	     				errorRecords.add(errorRecord);

                        	     				Wrapper.printMessage("Error No. " + error + " : SNP Id. " + proveandata.getSnpId() + " GREATER THAN 1 ROW FOR : " + proveandata.toString(), MSGLEVEL, MSGLEVEL);
                        	     			}
                        	     			else {
                        	     				
                                    	        Iterator<SNPChromosome> iteratorSNPChromosome = snpchromosomeZList.iterator();
                                    	     	
                                    	        while (iteratorSNPChromosome.hasNext()) {

                                    	     		SNPChromosome snpchromosomeZ = iteratorSNPChromosome.next();
                                    	     		
                                    	     		if ( proveandata.getScoreProvean() == 0.0 &&
                                    	     				proveandata.getProteinAlignNumber() == 0 &&
                                    	     				proveandata.getTotalAlignSequenceNumber() == 0) {
                                    	     			
                                    	     			snpchromosomeZ.setPredictionCategory("NOT SCORED");
                                    	     		}
                                    	     		
                                    	     		snpchromosomeZ.setAminoAcidSubs(proveandata.getAminoAcidSubs());
                                    	     		snpchromosomeZ.setScoreProvean(proveandata.getScoreProvean());
                                    	     		snpchromosomeZ.setProteinAlignNumber(proveandata.getProteinAlignNumber());
                                    	     		snpchromosomeZ.setTotalAlignSequenceNumber(proveandata.getTotalAlignSequenceNumber());

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

        			Wrapper.printMessage(StringUtility.pad(totalRecordCount, 8, PAD_CHAR) + " updated inserted from " + totalFileCount + " files in Directory " + directory, MSGLEVEL, MSGLEVEL);

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
