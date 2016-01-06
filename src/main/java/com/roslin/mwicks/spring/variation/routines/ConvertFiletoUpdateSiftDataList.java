package com.roslin.mwicks.spring.variation.routines;

import java.io.File;
import java.io.InputStream;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.roslin.mwicks.utility.CsvUtil;
import com.roslin.mwicks.utility.FileUtil;
import com.roslin.mwicks.utility.StringUtility;
import com.roslin.mwicks.spring.variation.dto.DTOSiftData;

import com.roslin.mwicks.spring.variation.model.other.SiftData;


public final class ConvertFiletoUpdateSiftDataList {

	private static final char PAD_CHAR = ' ';

	public static List<SiftData> run ( File file ) throws Exception {

        // Create List of SNPChromosomes
        List<SiftData> outputSiftDataList = new ArrayList<SiftData>();

		try {
		
	     	int error = 0;

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
	         	
		     	
	         	if ( dtoSiftData.isThisAValidSiftData() ) {
	         		
	         		outputSiftDataList.add( dtoSiftData.convertToSiftData() );
	         	}
	         	else {
	         		
	         		error++;
	         		//System.out.println("Error No." + error + " : " + dtoSiftData.toString());
	         	}

	     	}
	     	
     		System.out.println(StringUtility.pad(error, 8, PAD_CHAR) + " Error Records IGNORED - CSV File!");
		
		}
		catch (Exception e) {
			
	        System.out.println("Exception : " + e.toString() );
	        
    		e.printStackTrace();
    	}
		
		return outputSiftDataList;

	}
}
