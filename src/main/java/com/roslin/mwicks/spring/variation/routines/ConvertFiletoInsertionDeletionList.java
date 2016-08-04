package com.roslin.mwicks.spring.variation.routines;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.roslin.mwicks.utility.CsvUtil;
import com.roslin.mwicks.utility.FileUtil;
import com.roslin.mwicks.utility.Wrapper;

import com.roslin.mwicks.spring.variation.dto.offline.DTOInsertionDeletion;

import com.roslin.mwicks.spring.variation.model.snpinsertiondeletion.SNPInsertionDeletion;


public final class ConvertFiletoInsertionDeletionList {

    // Constants ----------------------------------------------------------------------------------
	protected static final String STRING_NA = "NA";
	protected static final String STRING_FIXED = "fixed";
	protected static final String STRING_NOT_FIXED = "not_fixed";
	protected static final String STRING_REFERENCE = "ref";

	protected static final String STRING_OUTPUT_NA = "N/A";
	protected static final String STRING_OUTPUT_FIXED = "Fixed";
	protected static final String STRING_OUTPUT_NOT_FIXED = "Not Fixed";
	protected static final String STRING_OUTPUT_REFERENCE = "Ref.";
	

	public static List<SNPInsertionDeletion> run ( File file, int startRecordCount, String messagePriority, String requestPriority ) throws Exception {

        // Create List of SNPChromosomes
        List<SNPInsertionDeletion> outputsnpinsertiondeletionList = new ArrayList<SNPInsertionDeletion>();

		try {

	     	int error = 0;

	     	long recordCount = startRecordCount + 1;

	        // Format InputStream for CSV.
	        InputStream csvInput = FileUtil.readStream(file);
	        
	        // Create CSV List
	        List<List<String>> csvList = CsvUtil.parseCsv(csvInput, '\t');

	        // Create CSV List

	        Iterator<List<String>> iteratorRow = csvList.iterator();
	        
	     	while (iteratorRow.hasNext()) {

	     		boolean ignoreRow = false;
	     		
	    		List<String> row = iteratorRow.next();

	            Iterator<String> iteratorColumn = row.iterator();
	            
	            int i = 1;
	            
	            DTOInsertionDeletion dtoinsertiondeletion = new DTOInsertionDeletion();
	            
        	    while (iteratorColumn.hasNext()) {
	        		
	        		String column = iteratorColumn.next();

	        		if ( !column.startsWith("#") ) {
	        			
		        		if ( i == 1 ) {
		        			dtoinsertiondeletion.setChromosomeId(column.trim());
		        		}
		        		if ( i == 2 ) {
		        			dtoinsertiondeletion.setPosition(column.trim());
		        		}
		        		if ( i == 3 ) {
		        			dtoinsertiondeletion.setInDelId(column.trim());
		        		}
		        		if ( i == 4 ) {
		        			dtoinsertiondeletion.setReference(column.trim());
		        		}
		        		if ( i == 5 ) {
		        			dtoinsertiondeletion.setAlternative(column.trim());
		        		}
		        		if ( i == 6 ) {
		        			dtoinsertiondeletion.setQuality(column.trim());
		        		}
		        		if ( i == 7 ) {
		        			dtoinsertiondeletion.setFilter(column.trim());
		        		}
		        		if ( i == 8 ) {
		        			dtoinsertiondeletion.setInformation(column.trim());
		        		}
		        		
		        		i++;
	        		}
	        		else {
	        		
	        			ignoreRow = true;
	        		}

	         		dtoinsertiondeletion.setAminoAcidSubs("");
	         		dtoinsertiondeletion.setPredictionCategory("");
	         		dtoinsertiondeletion.setScoreSift("0");
	         		dtoinsertiondeletion.setScoreConservation("0");
	         		dtoinsertiondeletion.setProteinAlignNumber("0");
	         		dtoinsertiondeletion.setTotalAlignSequenceNumber("0");
	         		dtoinsertiondeletion.setScoreProvean("0");

        	    }

        	    if ( !ignoreRow ) {
        	    	
    	         	if ( dtoinsertiondeletion.isThisAValidInsertionDeletion() ) {
    	         		
    	         		dtoinsertiondeletion.parseInformation();
    	         		
    		            //dtoinsertiondeletion.setOid( recordCount );

    	        	    recordCount++;
    	        	    
    	         		outputsnpinsertiondeletionList.add(dtoinsertiondeletion.convertToSNPInsertionDeletion() );
    	         	}
    	         	else {
    	         		
    	         		error++;
    	         		Wrapper.printMessage("Error No." + error + " : " + dtoinsertiondeletion.toString(), messagePriority, requestPriority);
    	    	        //System.exit(99);
    	         	}
        	    }
	     	}
		}
		catch (Exception e) {
			
	        Wrapper.printMessage("Exception : " + e.toString(), messagePriority, requestPriority);
	        
	        System.exit(99);
		}
		
		return outputsnpinsertiondeletionList;
	}
}
