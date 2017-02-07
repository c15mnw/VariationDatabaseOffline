package com.roslin.mwicks.spring.variation.main;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.roslin.mwicks.spring.variation.config.MyOfflineApplicationContext;

import com.roslin.mwicks.spring.variation.routines.ConvertFiletoDTOSearchSNPChromosomeList;

import com.roslin.mwicks.spring.variation.dto.web.objects.snpchromosome.DTOSearchSNPChromosome;

import com.roslin.mwicks.spring.variation.serviceinterface.ensemblgene.ServiceEnsemblGene;
import com.roslin.mwicks.spring.variation.serviceinterface.snpchromosome.ServiceSNPChromosome;

import com.roslin.mwicks.spring.variation.exception.ensemblgene.ExceptionEnsemblGeneDownStreamNotNumeric;
import com.roslin.mwicks.spring.variation.exception.ensemblgene.ExceptionEnsemblGeneDownStreamSearchRangeGreaterThanTenThousand;
import com.roslin.mwicks.spring.variation.exception.ensemblgene.ExceptionEnsemblGeneMultiplesFound;
import com.roslin.mwicks.spring.variation.exception.ensemblgene.ExceptionEnsemblGeneNotFound;
import com.roslin.mwicks.spring.variation.exception.ensemblgene.ExceptionEnsemblGeneSearchRangeLessThanZero;
import com.roslin.mwicks.spring.variation.exception.ensemblgene.ExceptionEnsemblGeneUpStreamNotNumeric;
import com.roslin.mwicks.spring.variation.exception.ensemblgene.ExceptionEnsemblGeneUpStreamSearchRangeGreaterThanTenThousand;

import com.roslin.mwicks.spring.variation.exception.snpchromosome.ExceptionSNPChromosomeHighCoordinateNotSupplied;
import com.roslin.mwicks.spring.variation.exception.snpchromosome.ExceptionSNPChromosomeLowCoordinateNotSupplied;
import com.roslin.mwicks.spring.variation.exception.snpchromosome.ExceptionSNPChromosomeAlternativeAlleleNotSupplied;
import com.roslin.mwicks.spring.variation.exception.snpchromosome.ExceptionSNPChromosomeHighCoordinateNotNumeric;
import com.roslin.mwicks.spring.variation.exception.snpchromosome.ExceptionSNPChromosomeLowCoordinateGreaterThanHighCoordinate;
import com.roslin.mwicks.spring.variation.exception.snpchromosome.ExceptionSNPChromosomeLowCoordinateNotNumeric;
import com.roslin.mwicks.spring.variation.exception.snpchromosome.ExceptionSNPChromosomeNotSelected;
import com.roslin.mwicks.spring.variation.exception.snpchromosome.ExceptionSNPChromosomeReferenceAlleleEqualsAlternativeAllele;
import com.roslin.mwicks.spring.variation.exception.snpchromosome.ExceptionSNPChromosomeReferenceAlleleNotSupplied;
import com.roslin.mwicks.spring.variation.exception.snpchromosome.ExceptionSNPChromosomeSearchFilterProteinAlignNumberValueNotNumeric;
import com.roslin.mwicks.spring.variation.exception.snpchromosome.ExceptionSNPChromosomeSearchFilterProveanScoreValueNotNumeric;
import com.roslin.mwicks.spring.variation.exception.snpchromosome.ExceptionSNPChromosomeSearchFilterSiftConservationScoreValueNotNumeric;
import com.roslin.mwicks.spring.variation.exception.snpchromosome.ExceptionSNPChromosomeSearchFilterSiftScoreValueNotNumeric;
import com.roslin.mwicks.spring.variation.exception.snpchromosome.ExceptionSNPChromosomeSearchFilterTotalNumberSeqAlignedValueNotNumeric;
import com.roslin.mwicks.spring.variation.exception.snpchromosome.ExceptionSNPChromosomeSearchRangeGreaterThanOneMillion;
import com.roslin.mwicks.spring.variation.exception.snpchromosome.ExceptionSNPChromosomeSelectedWithGeneName;

import com.roslin.mwicks.spring.variation.model.other.PageSNPChromosome;
import com.roslin.mwicks.spring.variation.model.snpchromosome.SNPChromosome;

import com.roslin.mwicks.utility.StringUtility;
import com.roslin.mwicks.utility.Wrapper;


public class searchMulltipleSNPChromosome {

	// Constants ----------------------------------------------------------------------------------
    private static final String MSGLEVEL = "*";
	private static final String STOP = "*";
	
	private static final char PAD_CHAR = ' ';

    public static final Logger LOG = LoggerFactory.getLogger(searchMulltipleSNPChromosome.class);

    @PersistenceContext
    private EntityManager entityManager;
     

    public static void main(String args[]){  

    	try {

        	LOG.trace("searchMulltipleSNPChromosome - main");

        	long startTime = Wrapper.printPrologue("*", Wrapper.getExecutingClass());
            
        	int intReturnCode = 0;

            final AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

            // setup configuration
            applicationContext.register(MyOfflineApplicationContext.class);

            applicationContext.refresh();
            applicationContext.start();

            ServiceEnsemblGene serviceEnsemblGene = (ServiceEnsemblGene) applicationContext.getBean(ServiceEnsemblGene.class);
            ServiceSNPChromosome serviceSNPChromosome = (ServiceSNPChromosome) applicationContext.getBean(ServiceSNPChromosome.class);

    		if (args.length != 1 ) {
    			
    		    Wrapper.printMessage("ERROR! There MUST be 1 Command Line Arguments passed to this program!", MSGLEVEL, MSGLEVEL);
    			intReturnCode = -1;
            }
            else {
                
                File file = new File(args[0]);

                if ( file.exists() ) {
                	
            		int totalRequestCount = 0;
            		int totalResponseCount = 0;
            		
                    List<DTOSearchSNPChromosome> dtosearchsnpchromosomeList = ConvertFiletoDTOSearchSNPChromosomeList.run(file, totalRequestCount, MSGLEVEL, MSGLEVEL);

        	        Iterator<DTOSearchSNPChromosome> iteratorDTOSearchSNPChromosome = dtosearchsnpchromosomeList.iterator();

        	        PageSNPChromosome pagesnpchromosomeTotal = new PageSNPChromosome();

        	    	String successMsg = "";
        	    	
        	     	while ( iteratorDTOSearchSNPChromosome.hasNext() ) {
        	    		
        	    		DTOSearchSNPChromosome dtosearchsnpchromosome = iteratorDTOSearchSNPChromosome.next();
        	    		
        	            PageSNPChromosome pagesnpchromosomeRequest = null;

        	        	try {
        	        		
        	    			successMsg = dtosearchsnpchromosome.isDTOSearchSNPChromosomeValid( serviceEnsemblGene );
        	    		} 
        	            catch (ExceptionSNPChromosomeSelectedWithGeneName e) {
        	            	
        	            	System.out.println("ERROR: Search Chromosome Supplied AND Ensembl Gene Name Supplied !!! dtoSearch.toString() : " + dtosearchsnpchromosome.toString() );
        	            }
        	            catch (ExceptionSNPChromosomeNotSelected e) {
        	            	
        	            	System.out.println("ERROR: The Search Chromosome has NOT been chosen !!! dtoSearch.toString() : " + dtosearchsnpchromosome.toString() );
        	            }
        	            catch (ExceptionSNPChromosomeSearchFilterProteinAlignNumberValueNotNumeric e) {
        	            	
        	            	System.out.println("ERROR: The Search Filter Protein Alignment Number is NOT Numeric !!! dtoSearch.toString() : " + dtosearchsnpchromosome.toString() );
        	            }
        	            catch (ExceptionSNPChromosomeSearchFilterProveanScoreValueNotNumeric e) {
        	            	
        	            	System.out.println("ERROR: The Search Filter PROVEAN Score is NOT Numeric !!! dtoSearch.toString() : " + dtosearchsnpchromosome.toString() );
        	            }
        	            catch (ExceptionSNPChromosomeSearchFilterSiftConservationScoreValueNotNumeric e) {
        	            	
        	            	System.out.println("ERROR: The Search Filter SIFT Conservation Score is NOT Numeric !!! dtoSearch.toString() : " + dtosearchsnpchromosome.toString() );
        	            }
        	            catch (ExceptionSNPChromosomeSearchFilterSiftScoreValueNotNumeric e) {
        	            	
        	            	System.out.println("ERROR: The Search Filter SIFT Score is NOT Numeric !!! dtoSearch.toString() : " + dtosearchsnpchromosome.toString() );
        	            }
        	            catch (ExceptionSNPChromosomeSearchFilterTotalNumberSeqAlignedValueNotNumeric e) {
        	            	
        	            	System.out.println("ERROR: The Search Filter Total Number of Sequence Aligned is NOT Numeric !!! dtoSearch.toString() : " + dtosearchsnpchromosome.toString() );
        	            }
        	            catch (ExceptionEnsemblGeneSearchRangeLessThanZero e) {
        	            	
        	            	System.out.println("ERROR: Search Range is LESS THAN Zero !!! dtoSearch.toString() : " + dtosearchsnpchromosome.toString() );
        	            }
        	            catch (ExceptionEnsemblGeneUpStreamSearchRangeGreaterThanTenThousand e) {
        	            	
        	            	System.out.println("ERROR: Up Stream Search Range is GREATER THAN Ten Thousand Base Pairs !!! dtoSearch.toString() : " + dtosearchsnpchromosome.toString() );
        	            }
        	            catch (ExceptionEnsemblGeneDownStreamSearchRangeGreaterThanTenThousand e) {
        	            	
        	            	System.out.println("ERROR: Down Stream Search Range is GREATER THAN Ten Thousand Base Pairs !!! dtoSearch.toString() : " + dtosearchsnpchromosome.toString() );
        	            }
        	            catch (ExceptionEnsemblGeneUpStreamNotNumeric e) {
        	            	
        	            	System.out.println("ERROR: Search Upstream Range is NOT Numeric !!! dtoSearch.toString() : " + dtosearchsnpchromosome.toString() );
        	            }
        	            catch (ExceptionEnsemblGeneDownStreamNotNumeric e) {
        	            	
        	            	System.out.println("ERROR: Search Downstream Range is NOT Numeric !!! dtoSearch.toString() : " + dtosearchsnpchromosome.toString() );
        	            }
        	            catch (ExceptionEnsemblGeneMultiplesFound e) {
        	            	
        	            	System.out.println("ERROR: Multiple Genes Found !!! dtoSearch.toString() : " + dtosearchsnpchromosome.toString() );
        	            }
        	            catch (ExceptionEnsemblGeneNotFound e) {
        	            	
        	            	System.out.println("ERROR: Requested Gene does NOT Exist !!! dtoSearch.toString() : " + dtosearchsnpchromosome.toString() );
        	            }
        	            catch (ExceptionSNPChromosomeSearchRangeGreaterThanOneMillion e) {
        	            	
        	            	System.out.println("ERROR: Search Range is GREATER THAN One Million Base Pairs !!! dtoSearch.toString() : " + dtosearchsnpchromosome.toString() );
        	            }
        	            catch (ExceptionSNPChromosomeLowCoordinateNotNumeric e) {
        	            	
        	            	System.out.println("ERROR: Search Low Co-ordinate is NOT Numeric !!! dtoSearch.toString() : " + dtosearchsnpchromosome.toString() );
        	            }
        	            catch (ExceptionSNPChromosomeHighCoordinateNotNumeric e) {
        	            	
        	            	System.out.println("ERROR: Search High Co-ordinate is NOT Numeric !!! dtoSearch.toString() : " + dtosearchsnpchromosome.toString() );
        	            }
        	            catch (ExceptionSNPChromosomeLowCoordinateGreaterThanHighCoordinate e) {
        	            	
        	            	System.out.println("ERROR: Search Low Co-ordinate is GREATER THAN Search High Co-ordinate !!! dtoSearch.toString() : " + dtosearchsnpchromosome.toString() );
        	            }
        	            catch (ExceptionSNPChromosomeReferenceAlleleNotSupplied e) {
        	            	
        	            	System.out.println("ERROR: Reference Allele Not Supplied !!! dtoSearch.toString() : " + dtosearchsnpchromosome.toString() );
        	            }
        	            catch (ExceptionSNPChromosomeAlternativeAlleleNotSupplied e) {
        	            	
        	            	System.out.println("ERROR: Alternative Allele Not Supplied !!! dtoSearch.toString() : " + dtosearchsnpchromosome.toString() );
        	            }
        	            catch (ExceptionSNPChromosomeReferenceAlleleEqualsAlternativeAllele e) {
        	            	
        	            	System.out.println("ERROR: Reference Allele EQUALS Alternative Allele !!! dtoSearch.toString() : " + dtosearchsnpchromosome.toString() );
        	            } 
        	        	catch (ExceptionSNPChromosomeHighCoordinateNotSupplied e) {
        	        		
        	            	System.out.println("ERROR: Search High Co-ordinate is NOT Supplied !!! dtoSearch.toString() : " + dtosearchsnpchromosome.toString() );
        	    		} 
        	        	catch (ExceptionSNPChromosomeLowCoordinateNotSupplied e) {
        	        		
        	            	System.out.println("ERROR: Search Low Co-ordinate is NOT Supplied !!! dtoSearch.toString() : " + dtosearchsnpchromosome.toString() );
        	        	}
        	        	catch (Exception e) {

        	        		e.printStackTrace();
        	        	}

                		//Wrapper.printMessage(successMsg, MSGLEVEL, MSGLEVEL);

        	        	if ( successMsg.equals("") ) {
        	        		
        	                Wrapper.printEpilogue(STOP, Wrapper.getExecutingClass(), startTime);

        	                applicationContext.close();

        	            	System.exit(intReturnCode);
        	        	}
        	        	else {
        	        		
            	        	pagesnpchromosomeRequest = serviceSNPChromosome.search(dtosearchsnpchromosome, 1, dtosearchsnpchromosome.getSearchSortFieldAsString(), dtosearchsnpchromosome.getSearchSortDirectionAsString());

            	            if ( pagesnpchromosomeRequest.size() == 0 ) {
            	            	
            	            	System.out.println("EMPTY SNPChromosomes !!! dtoSearch.toString() : " + dtosearchsnpchromosome.toString() );
            	            }
            	            else {
            	            	
                        		Iterator<SNPChromosome> iteratorSNPChromosome = pagesnpchromosomeRequest.iterator();

                        		int totalDuplicateCount = 0;

                    	     	while ( iteratorSNPChromosome.hasNext() ) {
                    	    		
                    	    		SNPChromosome snpchromosome = iteratorSNPChromosome.next();
                    	    		
                    	    		if ( pagesnpchromosomeTotal.contains( snpchromosome )) {
                    	    			
                    	    			totalDuplicateCount++;
                    	    		}
                    	    		else {
                    	    			
                    	            	pagesnpchromosomeTotal.add( snpchromosome );
                    	    		}
                    	     	}
                    	     	
                    	     	Wrapper.printMessage(StringUtility.pad(pagesnpchromosomeRequest.size(), 8, PAD_CHAR) + " Response Records with " + totalDuplicateCount + " Duplicates " + successMsg, MSGLEVEL, MSGLEVEL);
            	            }
        	        	}
        	     	}
                    
                    totalRequestCount = totalRequestCount +  dtosearchsnpchromosomeList.size();
                    totalResponseCount = totalResponseCount +  pagesnpchromosomeTotal.size();
                    
            		Wrapper.printMessage(StringUtility.pad(totalRequestCount, 8, PAD_CHAR) + " Request Records read from " + file, MSGLEVEL, MSGLEVEL);
        			Wrapper.printMessage(StringUtility.pad(totalResponseCount, 8, PAD_CHAR) + " Response Records returned from Database" , MSGLEVEL, MSGLEVEL);

                }
                else {
                	
                    Wrapper.printMessage("File " + file + " DOES NOT exist!!!", MSGLEVEL, MSGLEVEL);
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
