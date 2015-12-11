package com.roslin.mwicks.spring.variation.routines;

import java.io.File;
import java.io.InputStream;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.roslin.mwicks.utility.CsvUtil;
import com.roslin.mwicks.utility.FileUtil;

import com.roslin.mwicks.spring.variation.dto.DTOEnsemblGene;

import com.roslin.mwicks.spring.variation.model.ensemblgene.EnsemblGene;


public final class ConvertFiletoEnsemblGeneList {

	public static List<EnsemblGene> run ( File file ) throws Exception {

        // Create List of SNPChromosomes
        List<EnsemblGene> outputEnsemblGeneList = new ArrayList<EnsemblGene>();

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
	            
	            DTOEnsemblGene dtoEnsemblGene = new DTOEnsemblGene();
	            
	         	while (iteratorColumn.hasNext()) {
	        		
	        		String column = iteratorColumn.next();

	        		if ( i == 1 ) {
	        			dtoEnsemblGene.setEnsemblId(column.trim());
	        		}
	        		if ( i == 2 ) {
	        			dtoEnsemblGene.setRegion(column.trim());
	        		}
	        		if ( i == 3 ) {
	        			dtoEnsemblGene.setChromosomeId(column.trim());
	        		}
	        		if ( i == 4 ) {
	        			dtoEnsemblGene.setStart(column.trim());
	        		}
	        		if ( i == 5 ) {
	        			dtoEnsemblGene.setEnd(column.trim());
	        		}
	        		if ( i == 6 ) {
	        			dtoEnsemblGene.setStrand(column.trim());
	        		}
	        		
	        		i++;
	         	}
	         	
		     	
	         	if ( dtoEnsemblGene.isThisAValidEnsemblGene() ) {
	         		
	         		outputEnsemblGeneList.add(dtoEnsemblGene.convertToEnsemblGene());
	         	}
	         	else {
	         		
	         		error++;
	         		System.out.println("Error No." + error + " : " + dtoEnsemblGene.toString());
	         	}

	     	}
		
		}
		catch (Exception e) {
			
	        System.out.println("Exception : " + e.toString() );
		}
		
		return outputEnsemblGeneList;

	}
}
