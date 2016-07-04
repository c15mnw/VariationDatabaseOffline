package com.roslin.mwicks.spring.variation.routines;

import java.io.File;
import java.io.InputStream;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.roslin.mwicks.utility.CsvUtil;
import com.roslin.mwicks.utility.FileNamingDateTime;
import com.roslin.mwicks.utility.FileUtil;
import com.roslin.mwicks.utility.StringUtility;

import com.roslin.mwicks.spring.variation.dto.offline.DTORatioData;

import com.roslin.mwicks.spring.variation.model.other.RatioData;


public final class ConvertFiletoUpdateRatioDataList {

	private static final char PAD_CHAR = ' ';

	protected static final String OUT_STRAIN_7 = "STRAIN_7";
	protected static final String OUT_STRAIN_P = "STRAIN_P";
	protected static final String OUT_STRAIN_W = "STRAIN_W";
	protected static final String OUT_STRAIN_N = "STRAIN_N";
	protected static final String OUT_STRAIN_15I = "STRAIN_15I";
	protected static final String OUT_STRAIN_ZERO = "STRAIN_ZERO";
	protected static final String OUT_STRAIN_6 = "STRAIN_6";
	protected static final String OUT_STRAIN_C = "STRAIN_C";

	protected static final String IN_STRAIN_7 = "pk1";
	protected static final String IN_STRAIN_P = "pk2";
	protected static final String IN_STRAIN_W = "pk3";
	protected static final String IN_STRAIN_N = "pk4";
	protected static final String IN_STRAIN_15I = "pk5";
	protected static final String IN_STRAIN_ZERO = "pk6";
	protected static final String IN_STRAIN_6 = "pk7";
	protected static final String IN_STRAIN_C = "pk8";

	public static List<RatioData> run ( File file ) throws Exception {

        // Create List of SNPChromosomes
        List<RatioData> outputRatioDataList = new ArrayList<RatioData>();

		try {
		
	     	int error = 0;
	     	int good = 0;
	     	int newRecord = 0;
	     	int total = 0;

            File errorFile = new File("/Users/mwicks23/Desktop/Ratio/error_ratio_conversion_" + FileNamingDateTime.now() + ".txt");

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
	            
	            DTORatioData dtoRatioData = new DTORatioData();
	            
	         	while (iteratorColumn.hasNext()) {
	        		
	        		String column = iteratorColumn.next();

	        		if ( i == 1 ) {
	        			dtoRatioData.setSnpId(column.trim());
	        		}
	        		if ( i == 2 ) {
	        			if (column.trim().equals(IN_STRAIN_7)) {
		        			dtoRatioData.setStrain(OUT_STRAIN_7);
	        			}
	        			if (column.trim().equals(IN_STRAIN_P)) {
		        			dtoRatioData.setStrain(OUT_STRAIN_P);
	        			}
	        			if (column.trim().equals(IN_STRAIN_W)) {
		        			dtoRatioData.setStrain(OUT_STRAIN_W);
	        			}
	        			if (column.trim().equals(IN_STRAIN_N)) {
		        			dtoRatioData.setStrain(OUT_STRAIN_N);
	        			}
	        			if (column.trim().equals(IN_STRAIN_15I)) {
		        			dtoRatioData.setStrain(OUT_STRAIN_15I);
	        			}
	        			if (column.trim().equals(IN_STRAIN_ZERO)) {
		        			dtoRatioData.setStrain(OUT_STRAIN_ZERO);
	        			}
	        			if (column.trim().equals(IN_STRAIN_6)) {
		        			dtoRatioData.setStrain(OUT_STRAIN_6);
	        			}
	        			if (column.trim().equals(IN_STRAIN_C)) {
		        			dtoRatioData.setStrain(OUT_STRAIN_C);
	        			}
	        		}
	        		if ( i == 3 ) {
	        			dtoRatioData.setStrainAlleleReferenceCount(column.trim());
	        		}
	        		if ( i == 4 ) {
	        			dtoRatioData.setStrainAlleleAlternativeCount(column.trim());
	        		}
	        		if ( i == 5 ) {
	        			dtoRatioData.setStrainAlleleRatio(column.trim());
	        		}
	        		
	        		i++;
	         	}
	         	
	         	total++;
		     	
	         	if ( dtoRatioData.isThisAValidRatioData() ) {
	         		
	         		good++;
	         		
	         		if ( dtoRatioData.isThisNewRatioData() ) {
		         		
		         		newRecord++;
		         		
		         		outputRatioDataList.add( dtoRatioData.convertToRatioData() );
	         		}
	         	}
	         	else {
	         		
	         		error++;
	         		
	         		String errorRecord = "INVALID RATIO DATA!\t" + 
	         				dtoRatioData.getSnpId() + "\t" +
	         				dtoRatioData.getStrain() + "\t" +
	         				dtoRatioData.getStrainAlleleReferenceCount() + "\t" +
	         				dtoRatioData.getStrainAlleleAlternativeCount() + "\t" +
	         				dtoRatioData.getStrainAlleleRatio();

     				errorRecords.add(errorRecord);

	         		//System.out.println("Error No." + error + " : " + dtoRatioData.toString());
	         	}
	     	}
	     	
    		FileUtil.write(errorFile, errorRecords);

    		System.out.println(StringUtility.pad(total, 8, PAD_CHAR) + " Total Records in CSV File!");
     		System.out.println(StringUtility.pad(good, 8, PAD_CHAR) + " Good Records in CSV File!");
     		System.out.println(StringUtility.pad(newRecord, 8, PAD_CHAR) + " New Records in CSV File!");
     		System.out.println(StringUtility.pad(error, 8, PAD_CHAR) + " Error Records IGNORED from CSV File!");
		
		}
		catch (Exception e) {
			
	        System.out.println("Exception : " + e.toString() );
		}
		
		return outputRatioDataList;

	}
}
