package com.roslin.mwicks.spring.variation.routines;

import java.io.File;
import java.io.InputStream;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.roslin.mwicks.utility.CsvUtil;
import com.roslin.mwicks.utility.FileUtil;
import com.roslin.mwicks.utility.StringUtility;
import com.roslin.mwicks.spring.variation.dto.offline.DTOProveanData;
import com.roslin.mwicks.spring.variation.model.other.ProveanData;


public final class ConvertFiletoUpdateProveanDataList {

	private static final char PAD_CHAR = ' ';

	public static List<ProveanData> run ( File file ) throws Exception {

        // Create List of SNPChromosomes
        List<ProveanData> outputProveanDataList = new ArrayList<ProveanData>();

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
	            
	            DTOProveanData dtoProveanData = new DTOProveanData();
	            
	         	while (iteratorColumn.hasNext()) {
	        		
	        		String column = iteratorColumn.next();

	        		if ( i == 1 ) {
	        			dtoProveanData.setSnpId(column.trim());
	        		}
	        		if ( i == 2 ) {
	        			dtoProveanData.setEnsemblGene(column.trim());
	        		}
	        		if ( i == 3 ) {
	        			dtoProveanData.setEnsemblTranscript(column.trim());
	        		}
	        		if ( i == 4 ) {
	        			dtoProveanData.setEnsemblAnnotation(column.trim());
	        		}
	        		if ( i == 5 ) {
	        			dtoProveanData.setAminoAcidSubs(column.trim());
	        		}
	        		if ( i == 6 ) {
	        			dtoProveanData.setScoreProvean(column.trim());
	        		}
	        		if ( i == 7 ) {
	        			dtoProveanData.setProteinAlignNumber(column.trim());
	        		}
	        		if ( i == 8 ) {
	        			dtoProveanData.setTotalAlignSequenceNumber(column.trim());
	        		}
	        		
	        		i++;
	         	}
	         	
		     	
	         	if ( dtoProveanData.isThisAValidProveanData() ) {
	         		
	         		outputProveanDataList.add( dtoProveanData.convertToProveanData() );
	         	}
	         	else {
	         		
	         		error++;
	         		//System.out.println("Error No." + error + " : " + dtoProveanData.toString());
	         	}
	     	}
	     	
     		System.out.println(StringUtility.pad(error, 8, PAD_CHAR) + " Error Records IGNORED - CSV File!");
		
		}
		catch (Exception e) {
			
	        System.out.println("Exception : " + e.toString() );
		}
		
		return outputProveanDataList;

	}
}
