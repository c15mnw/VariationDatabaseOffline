package com.roslin.mwicks.spring.variation.routines;

import java.io.File;
import java.io.InputStream;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.roslin.mwicks.utility.CsvUtil;
import com.roslin.mwicks.utility.FileUtil;
import com.roslin.mwicks.utility.StringUtility;
import com.roslin.mwicks.utility.Wrapper;
import com.roslin.mwicks.spring.variation.dto.offline.DTOSiftData;

import com.roslin.mwicks.spring.variation.model.other.SiftData;


public final class ConvertFiletoUpdateSiftDataList {

	private static final char PAD_CHAR = ' ';

	
	public static List<SiftData> run ( File file, String messagePriority, String requestPriority ) throws Exception {

        // Create List of SNPChromosomes
        List<SiftData> outputSiftDataList = new ArrayList<SiftData>();

		try {
		
	     	int error = 0;
	     	int good = 0;
	     	int total = 0;

            File errorFile = new File("/Users/mwicks23/Desktop/Sift/error_sift_conversion.txt");

            List<String> errorRecords = new ArrayList<String>();

	        // Format InputStream for CSV.
	        InputStream csvInput = FileUtil.readStream(file);
	        
	        // Create CSV List
	        List<List<String>> csvList = CsvUtil.parseCsv(csvInput, '\t');

	        // Create CSV List

	        Iterator<List<String>> iteratorRow = csvList.iterator();
	        
	     	while (iteratorRow.hasNext()) {
	    		
	    		List<String> row = iteratorRow.next();

	            Iterator<String> iteratorColumn = row.iterator();
	            
	            int i = 1;
	            
	            DTOSiftData dtoSiftData = new DTOSiftData();
	            
    			dtoSiftData.setSnpId("");
    			dtoSiftData.setEnsemblGene("");
    			dtoSiftData.setEnsemblTranscript("");
    			dtoSiftData.setEnsemblAnnotation("");
    			dtoSiftData.setAminoAcidSubs("");
    			dtoSiftData.setPredictionCategory("");
    			dtoSiftData.setScoreSift("");
    			dtoSiftData.setScoreConservation("");
    			dtoSiftData.setProteinAlignNumber("");
    			dtoSiftData.setTotalAlignSequenceNumber("");
	            
	         	while (iteratorColumn.hasNext()) {
	        		
	        		String column = iteratorColumn.next();

	        		if ( i == 1 ) {
	        			dtoSiftData.setSnpId(column.trim());
	        		}
	        		if ( i == 2 ) {
	        			dtoSiftData.setEnsemblGene(column.trim());
	        		}
	        		if ( i == 3 ) {
	        			dtoSiftData.setEnsemblTranscript(column.trim());
	        		}
	        		if ( i == 4 ) {
	        			dtoSiftData.setEnsemblAnnotation(column.trim());
	        		}
	        		if ( i == 5 ) {
	        			dtoSiftData.setAminoAcidSubs(column.trim());
	        		}
	        		if ( i == 6 ) {
	        			dtoSiftData.setPredictionCategory(column.trim());
	        		}
	        		if ( i == 7 ) {
	        			dtoSiftData.setScoreSift(column.trim());
	        		}
	        		if ( i == 8 ) {
	        			dtoSiftData.setScoreConservation(column.trim());
	        		}
	        		if ( i == 9 ) {
	        			dtoSiftData.setProteinAlignNumber(column.trim());
	        		}
	        		if ( i == 10 ) {
	        			dtoSiftData.setTotalAlignSequenceNumber(column.trim());
	        		}
	        		
	        		i++;
	         	}
	         	
	         	total++;
		     	
	         	if ( dtoSiftData.isThisAValidSiftData() ) {
	         		
	         		good++;
	         		
	         		outputSiftDataList.add( dtoSiftData.convertToSiftData() );
	         	}
	         	else {
	         		
	         		error++;
	         		
	         		String errorRecord = "INVALID SIFT DATA!\t" + 
	            			dtoSiftData.getSnpId() + "\t" +
	            			dtoSiftData.getEnsemblGene() + "\t" +
	            			dtoSiftData.getEnsemblTranscript() + "\t" +
	            			dtoSiftData.getEnsemblAnnotation() + "\t" +
	            			dtoSiftData.getAminoAcidSubs() + "\t" +
	            			dtoSiftData.getPredictionCategory() + "\t" +
	            			dtoSiftData.getScoreSift() + "\t" +
	            			dtoSiftData.getScoreConservation() + "\t" +
	            			dtoSiftData.getProteinAlignNumber() + "\t" +
	            			dtoSiftData.getTotalAlignSequenceNumber();

     				errorRecords.add(errorRecord);

	         		Wrapper.printMessage("Error No." + error + " : " + dtoSiftData.toString(), messagePriority, requestPriority);
	         	}
	     	}
	     	
    		FileUtil.write(errorFile, errorRecords);

     		Wrapper.printMessage(StringUtility.pad(total, 8, PAD_CHAR) + " Total Records in CSV File!", messagePriority, requestPriority);
     		Wrapper.printMessage(StringUtility.pad(good, 8, PAD_CHAR) + " Good Records in CSV File!", messagePriority, requestPriority);
     		Wrapper.printMessage(StringUtility.pad(error, 8, PAD_CHAR) + " Error Records IGNORED from CSV File!", messagePriority, requestPriority);
		}
		catch (Exception e) {
			
	        Wrapper.printMessage("Exception : " + e.toString(), messagePriority, requestPriority);
	        
    		e.printStackTrace();
    	}
		
		return outputSiftDataList;

	}
}
