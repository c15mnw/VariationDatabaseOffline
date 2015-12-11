package com.roslin.mwicks.spring.variation.routines;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.roslin.mwicks.utility.CsvUtil;
import com.roslin.mwicks.utility.FileUtil;
import com.roslin.mwicks.spring.variation.dto.DTOSNPChromosome;
import com.roslin.mwicks.spring.variation.model.snpchromosome.SNPChromosome;


public final class ConvertFiletoSNPChromosomeList {

    // Constants ----------------------------------------------------------------------------------
	protected static final String STRING_NA = "NA";
	protected static final String STRING_FIXED = "fixed";
	protected static final String STRING_NOT_FIXED = "not_fixed";
	protected static final String STRING_REFERENCE = "ref";

	protected static final String STRING_OUTPUT_NA = "N/A";
	protected static final String STRING_OUTPUT_FIXED = "Fixed";
	protected static final String STRING_OUTPUT_NOT_FIXED = "Not Fixed";
	protected static final String STRING_OUTPUT_REFERENCE = "Ref.";
	

	public static List<SNPChromosome> run ( File file ) throws Exception {

        // Create List of SNPChromosomes
        List<SNPChromosome> outputsnpchromosomeList = new ArrayList<SNPChromosome>();

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
	            
	            DTOSNPChromosome dtosnpchromosome = new DTOSNPChromosome();
	            
	         	while (iteratorColumn.hasNext()) {
	        		
	        		String column = iteratorColumn.next();
	        		
	        	    dtosnpchromosome.setStrain7AlleleRatio("0");
	        	    dtosnpchromosome.setStrainPAlleleRatio("0");
	        	    dtosnpchromosome.setStrainWAlleleRatio("0");
	        	    dtosnpchromosome.setStrainNAlleleRatio("0");
	        	    dtosnpchromosome.setStrain15IAlleleRatio("0");
	        	    dtosnpchromosome.setStrainZeroAlleleRatio("0");
	        	    dtosnpchromosome.setStrain6AlleleRatio("0");
	        	    dtosnpchromosome.setStrainCAlleleRatio("0");

	        		if ( i == 1 ) {
		        	    dtosnpchromosome.setSnpId(column.trim());
	        		}
	        		if ( i == 2 ) {
		        	    dtosnpchromosome.setChromosomeId(column.trim());
	        		}
	        		if ( i == 3 ) {
		        	    dtosnpchromosome.setPosition(column.trim());
	        		}
	        		if ( i == 4 ) {
		        	    dtosnpchromosome.setReference(column.trim());
	        		}
	        		if ( i == 5 ) {
		        	    dtosnpchromosome.setAlternative(column.trim());
	        		}
	        		if ( i == 6 ) {
		        	    dtosnpchromosome.setRegion(column.trim());
	        		}
	        		if ( i == 7 ) {
		        	    dtosnpchromosome.setEnsemblGene(column.trim());
	        		}
	        		if ( i == 8 ) {
		        	    dtosnpchromosome.setEnsemblTranscript(column.trim());
	        		}
	        		if ( i == 9 ) {
		        	    dtosnpchromosome.setEnsemblAnnotation(column.trim());
	        		}
	        		if ( i == 10 ) {
		        	    dtosnpchromosome.setStrain7Allele(column.trim());
	        		}
	        		if ( i == 11 ) {
	        			if ( column.trim().equals(STRING_NA) ) {
			        	    dtosnpchromosome.setStrain7AlleleFixed(STRING_OUTPUT_NA);
	        			}
	        			if ( column.trim().equals(STRING_FIXED) ) {
			        	    dtosnpchromosome.setStrain7AlleleFixed(STRING_OUTPUT_FIXED);
	        			}
	        			if ( column.trim().equals(STRING_NOT_FIXED) ) {
			        	    dtosnpchromosome.setStrain7AlleleFixed(STRING_OUTPUT_NOT_FIXED);
	        			}
	        			if ( column.trim().equals(STRING_REFERENCE) ) {
			        	    dtosnpchromosome.setStrain7AlleleFixed(STRING_OUTPUT_REFERENCE);
	        			}
	        		}
	        		if ( i == 12 ) {
		        	    dtosnpchromosome.setStrainPAllele(column.trim());
	        		}
	        		if ( i == 13 ) {
	        			if ( column.trim().equals(STRING_NA) ) {
			        	    dtosnpchromosome.setStrainPAlleleFixed(STRING_OUTPUT_NA);
	        			}
	        			if ( column.trim().equals(STRING_FIXED) ) {
			        	    dtosnpchromosome.setStrainPAlleleFixed(STRING_OUTPUT_FIXED);
	        			}
	        			if ( column.trim().equals(STRING_NOT_FIXED) ) {
			        	    dtosnpchromosome.setStrainPAlleleFixed(STRING_OUTPUT_NOT_FIXED);
	        			}
	        			if ( column.trim().equals(STRING_REFERENCE) ) {
			        	    dtosnpchromosome.setStrainPAlleleFixed(STRING_OUTPUT_REFERENCE);
	        			}
	        		}
	        		if ( i == 14 ) {
		        	    dtosnpchromosome.setStrainWAllele(column.trim());
	        		}
	        		if ( i == 15 ) {
	        			if ( column.trim().equals(STRING_NA) ) {
			        	    dtosnpchromosome.setStrainWAlleleFixed(STRING_OUTPUT_NA);
	        			}
	        			if ( column.trim().equals(STRING_FIXED) ) {
			        	    dtosnpchromosome.setStrainWAlleleFixed(STRING_OUTPUT_FIXED);
	        			}
	        			if ( column.trim().equals(STRING_NOT_FIXED) ) {
			        	    dtosnpchromosome.setStrainWAlleleFixed(STRING_OUTPUT_NOT_FIXED);
	        			}
	        			if ( column.trim().equals(STRING_REFERENCE) ) {
			        	    dtosnpchromosome.setStrainWAlleleFixed(STRING_OUTPUT_REFERENCE);
	        			}
	        		}
	        		if ( i == 16 ) {
		        	    dtosnpchromosome.setStrainNAllele(column.trim());
	        		}
	        		if ( i == 17 ) {
	        			if ( column.trim().equals(STRING_NA) ) {
			        	    dtosnpchromosome.setStrainNAlleleFixed(STRING_OUTPUT_NA);
	        			}
	        			if ( column.trim().equals(STRING_FIXED) ) {
			        	    dtosnpchromosome.setStrainNAlleleFixed(STRING_OUTPUT_FIXED);
	        			}
	        			if ( column.trim().equals(STRING_NOT_FIXED) ) {
			        	    dtosnpchromosome.setStrainNAlleleFixed(STRING_OUTPUT_NOT_FIXED);
	        			}
	        			if ( column.trim().equals(STRING_REFERENCE) ) {
			        	    dtosnpchromosome.setStrainNAlleleFixed(STRING_OUTPUT_REFERENCE);
	        			}
	        		}
	        		if ( i == 18 ) {
		        	    dtosnpchromosome.setStrain15IAllele(column.trim());
	        		}
	        		if ( i == 19 ) {
	        			if ( column.trim().equals(STRING_NA) ) {
			        	    dtosnpchromosome.setStrain15IAlleleFixed(STRING_OUTPUT_NA);
	        			}
	        			if ( column.trim().equals(STRING_FIXED) ) {
			        	    dtosnpchromosome.setStrain15IAlleleFixed(STRING_OUTPUT_FIXED);
	        			}
	        			if ( column.trim().equals(STRING_NOT_FIXED) ) {
			        	    dtosnpchromosome.setStrain15IAlleleFixed(STRING_OUTPUT_NOT_FIXED);
	        			}
	        			if ( column.trim().equals(STRING_REFERENCE) ) {
			        	    dtosnpchromosome.setStrain15IAlleleFixed(STRING_OUTPUT_REFERENCE);
	        			}
	        		}
	        		if ( i == 20 ) {
		        	    dtosnpchromosome.setStrainZeroAllele(column.trim());
	        		}
	        		if ( i == 21 ) {
	        			if ( column.trim().equals(STRING_NA) ) {
			        	    dtosnpchromosome.setStrainZeroAlleleFixed(STRING_OUTPUT_NA);
	        			}
	        			if ( column.trim().equals(STRING_FIXED) ) {
			        	    dtosnpchromosome.setStrainZeroAlleleFixed(STRING_OUTPUT_FIXED);
	        			}
	        			if ( column.trim().equals(STRING_NOT_FIXED) ) {
			        	    dtosnpchromosome.setStrainZeroAlleleFixed(STRING_OUTPUT_NOT_FIXED);
	        			}
	        			if ( column.trim().equals(STRING_REFERENCE) ) {
			        	    dtosnpchromosome.setStrainZeroAlleleFixed(STRING_OUTPUT_REFERENCE);
	        			}
	        		}
	        		if ( i == 22 ) {
		        	    dtosnpchromosome.setStrain6Allele(column.trim());
	        		}
	        		if ( i == 23 ) {
	        			if ( column.trim().equals(STRING_NA) ) {
			        	    dtosnpchromosome.setStrain6AlleleFixed(STRING_OUTPUT_NA);
	        			}
	        			if ( column.trim().equals(STRING_FIXED) ) {
			        	    dtosnpchromosome.setStrain6AlleleFixed(STRING_OUTPUT_FIXED);
	        			}
	        			if ( column.trim().equals(STRING_NOT_FIXED) ) {
			        	    dtosnpchromosome.setStrain6AlleleFixed(STRING_OUTPUT_NOT_FIXED);
	        			}
	        			if ( column.trim().equals(STRING_REFERENCE) ) {
			        	    dtosnpchromosome.setStrain6AlleleFixed(STRING_OUTPUT_REFERENCE);
	        			}
	        		}
	        		if ( i == 24 ) {
		        	    dtosnpchromosome.setStrainCAllele(column.trim());
	        		}
	        		if ( i == 25 ) {
	        			if ( column.trim().equals(STRING_NA) ) {
			        	    dtosnpchromosome.setStrainCAlleleFixed(STRING_OUTPUT_NA);
	        			}
	        			if ( column.trim().equals(STRING_FIXED) ) {
			        	    dtosnpchromosome.setStrainCAlleleFixed(STRING_OUTPUT_FIXED);
	        			}
	        			if ( column.trim().equals(STRING_NOT_FIXED) ) {
			        	    dtosnpchromosome.setStrainCAlleleFixed(STRING_OUTPUT_NOT_FIXED);
	        			}
	        			if ( column.trim().equals(STRING_REFERENCE) ) {
			        	    dtosnpchromosome.setStrainCAlleleFixed(STRING_OUTPUT_REFERENCE);
	        			}
	        		}
	        		
	        		i++;
	         	}
		     	
	         	if ( dtosnpchromosome.isThisAValidSNPChromosome() ) {
	         		
		         	outputsnpchromosomeList.add(dtosnpchromosome.convertToSNPChromosome());
	         	}
	         	else {
	         		
	         		error++;
	         		System.out.println("Error No." + error + " : " + dtosnpchromosome.toString());
	         	}

	     	}
		
		}
		catch (Exception e) {
			
	        System.out.println("Exception : " + e.toString() );
		}
		
		return outputsnpchromosomeList;

	}
}
