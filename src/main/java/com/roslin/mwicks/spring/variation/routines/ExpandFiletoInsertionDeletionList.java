package com.roslin.mwicks.spring.variation.routines;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.roslin.mwicks.utility.Combination;
import com.roslin.mwicks.utility.CsvUtil;
import com.roslin.mwicks.utility.FileUtil;
import com.roslin.mwicks.utility.Wrapper;

import com.roslin.mwicks.spring.variation.dto.offline.DTOInsertionDeletion;

import com.roslin.mwicks.spring.variation.model.snpinsertiondeletion.SNPInsertionDeletion;


public final class ExpandFiletoInsertionDeletionList {

    // Constants ----------------------------------------------------------------------------------
	protected static final String STRING_NA = "NA";
	protected static final String STRING_FIXED = "fixed";
	protected static final String STRING_NOT_FIXED = "not_fixed";
	protected static final String STRING_REFERENCE = "ref";

	protected static final String STRING_OUTPUT_NA = "N/A";
	protected static final String STRING_OUTPUT_FIXED = "Fixed";
	protected static final String STRING_OUTPUT_NOT_FIXED = "Not Fixed";
	protected static final String STRING_OUTPUT_REFERENCE = "Ref.";
	

	public static List<SNPInsertionDeletion> run (  List<SNPInsertionDeletion> inputsnpinsertiondeletionList, String messagePriority, String requestPriority ) throws Exception {

        // Create List of SNPChromosomes
        List<SNPInsertionDeletion> outputsnpinsertiondeletionList = new ArrayList<SNPInsertionDeletion>();

		try {

	     	long recordCount = 0;

	     	//System.out.println("In Rows : " + inputsnpinsertiondeletionList.size());
	     	
	        Iterator<SNPInsertionDeletion> iteratorInput = inputsnpinsertiondeletionList.iterator();
	        
	     	while (iteratorInput.hasNext()) {

	     		SNPInsertionDeletion inputsnpinsertiondeletion = iteratorInput.next();

		     	//System.out.println("inputsnpinsertiondeletion.toString() : " + inputsnpinsertiondeletion.toString());

	     		int start = inputsnpinsertiondeletion.getPositionStart();
	     		int stop = start + inputsnpinsertiondeletion.getReference().length() - 1;

		     	//System.out.println("start : " + start);
		     	//System.out.println("stop : " + stop);

	     		for (int i = start; i <= stop; i++) {
	            
			     	//System.out.println("i : " + i);

			     	recordCount++;
	     			
	     			SNPInsertionDeletion snpinsertiondeletion = new SNPInsertionDeletion();
	     			
		            //snpinsertiondeletion.setOid( recordCount );

	     			snpinsertiondeletion.setChromosomeId(inputsnpinsertiondeletion.getChromosomeId());
	     			snpinsertiondeletion.setPositionStart(i);
	     			snpinsertiondeletion.setInsertionDeletionId(inputsnpinsertiondeletion.getInsertionDeletionId());
	     			snpinsertiondeletion.setReference(inputsnpinsertiondeletion.getReference());
	     			snpinsertiondeletion.setAlternative(inputsnpinsertiondeletion.getAlternative());
	     			snpinsertiondeletion.setQuality(inputsnpinsertiondeletion.getQuality());
	     			snpinsertiondeletion.setFilter(inputsnpinsertiondeletion.getFilter());
	     			snpinsertiondeletion.setInformation(inputsnpinsertiondeletion.getInformation());
	     			snpinsertiondeletion.setBreedAllelesI(inputsnpinsertiondeletion.getBreedAllelesI());
	     			snpinsertiondeletion.setBreedAllelesJ(inputsnpinsertiondeletion.getBreedAllelesJ());
	     			snpinsertiondeletion.setBreedAllelesL(inputsnpinsertiondeletion.getBreedAllelesL());
	     			snpinsertiondeletion.setBreedAllelesN(inputsnpinsertiondeletion.getBreedAllelesN());
	     			snpinsertiondeletion.setBreedAllelesW(inputsnpinsertiondeletion.getBreedAllelesW());
	     			snpinsertiondeletion.setBreedAllelesZ(inputsnpinsertiondeletion.getBreedAllelesZ());
	     			snpinsertiondeletion.setAminoAcidSubs(inputsnpinsertiondeletion.getAminoAcidSubs());
	     			snpinsertiondeletion.setPredictionCategory(inputsnpinsertiondeletion.getPredictionCategory());
	     			snpinsertiondeletion.setScoreSift(inputsnpinsertiondeletion.getScoreSift());
	     			snpinsertiondeletion.setScoreConservation(inputsnpinsertiondeletion.getScoreConservation());
	     			snpinsertiondeletion.setProteinAlignNumber(inputsnpinsertiondeletion.getProteinAlignNumber());
	     			snpinsertiondeletion.setTotalAlignSequenceNumber(inputsnpinsertiondeletion.getTotalAlignSequenceNumber());
	     			snpinsertiondeletion.setScoreProvean(inputsnpinsertiondeletion.getScoreProvean());

			     	//System.out.println("snpinsertiondeletion.toString() : " + snpinsertiondeletion.toString());

	     			outputsnpinsertiondeletionList.add(snpinsertiondeletion);
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
