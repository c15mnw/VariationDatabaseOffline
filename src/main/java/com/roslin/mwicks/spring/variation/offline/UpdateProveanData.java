package com.roslin.mwicks.spring.variation.offline;

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

import com.roslin.mwicks.spring.variation.model.other.ProveanData;

import com.roslin.mwicks.spring.variation.model.snpchromosome.SNPChromosome01;
import com.roslin.mwicks.spring.variation.model.snpchromosome.SNPChromosome03;
import com.roslin.mwicks.spring.variation.model.snpchromosome.SNPChromosome04;
import com.roslin.mwicks.spring.variation.model.snpchromosome.SNPChromosome05;
import com.roslin.mwicks.spring.variation.model.snpchromosome.SNPChromosome06;
import com.roslin.mwicks.spring.variation.model.snpchromosome.SNPChromosome07;
import com.roslin.mwicks.spring.variation.model.snpchromosome.SNPChromosome08;
import com.roslin.mwicks.spring.variation.model.snpchromosome.SNPChromosome09;
import com.roslin.mwicks.spring.variation.model.snpchromosome.SNPChromosome10;
import com.roslin.mwicks.spring.variation.model.snpchromosome.SNPChromosome11;
import com.roslin.mwicks.spring.variation.model.snpchromosome.SNPChromosome12;
import com.roslin.mwicks.spring.variation.model.snpchromosome.SNPChromosome13;
import com.roslin.mwicks.spring.variation.model.snpchromosome.SNPChromosome14;
import com.roslin.mwicks.spring.variation.model.snpchromosome.SNPChromosome15;
import com.roslin.mwicks.spring.variation.model.snpchromosome.SNPChromosome16;
import com.roslin.mwicks.spring.variation.model.snpchromosome.SNPChromosome17;
import com.roslin.mwicks.spring.variation.model.snpchromosome.SNPChromosome18;
import com.roslin.mwicks.spring.variation.model.snpchromosome.SNPChromosome19;
import com.roslin.mwicks.spring.variation.model.snpchromosome.SNPChromosome20;
import com.roslin.mwicks.spring.variation.model.snpchromosome.SNPChromosome21;
import com.roslin.mwicks.spring.variation.model.snpchromosome.SNPChromosome22;
import com.roslin.mwicks.spring.variation.model.snpchromosome.SNPChromosome23;
import com.roslin.mwicks.spring.variation.model.snpchromosome.SNPChromosome24;
import com.roslin.mwicks.spring.variation.model.snpchromosome.SNPChromosome25;
import com.roslin.mwicks.spring.variation.model.snpchromosome.SNPChromosome26;
import com.roslin.mwicks.spring.variation.model.snpchromosome.SNPChromosome27;
import com.roslin.mwicks.spring.variation.model.snpchromosome.SNPChromosome28;
import com.roslin.mwicks.spring.variation.model.snpchromosome.SNPChromosome32;
import com.roslin.mwicks.spring.variation.model.snpchromosome.SNPChromosomeLGE22C19W28_E50C23;
import com.roslin.mwicks.spring.variation.model.snpchromosome.SNPChromosomeLGE64;
import com.roslin.mwicks.spring.variation.model.snpchromosome.SNPChromosomeW;
import com.roslin.mwicks.spring.variation.model.snpchromosome.SNPChromosomeZ;
import com.roslin.mwicks.spring.variation.routines.ConvertFiletoUpdateProveanDataList;

import com.roslin.mwicks.spring.variation.serviceinterface.snpchromosome.ServiceSNPChromosome01;
import com.roslin.mwicks.spring.variation.serviceinterface.snpchromosome.ServiceSNPChromosome03;
import com.roslin.mwicks.spring.variation.serviceinterface.snpchromosome.ServiceSNPChromosome04;
import com.roslin.mwicks.spring.variation.serviceinterface.snpchromosome.ServiceSNPChromosome05;
import com.roslin.mwicks.spring.variation.serviceinterface.snpchromosome.ServiceSNPChromosome06;
import com.roslin.mwicks.spring.variation.serviceinterface.snpchromosome.ServiceSNPChromosome07;
import com.roslin.mwicks.spring.variation.serviceinterface.snpchromosome.ServiceSNPChromosome08;
import com.roslin.mwicks.spring.variation.serviceinterface.snpchromosome.ServiceSNPChromosome09;
import com.roslin.mwicks.spring.variation.serviceinterface.snpchromosome.ServiceSNPChromosome10;
import com.roslin.mwicks.spring.variation.serviceinterface.snpchromosome.ServiceSNPChromosome11;
import com.roslin.mwicks.spring.variation.serviceinterface.snpchromosome.ServiceSNPChromosome12;
import com.roslin.mwicks.spring.variation.serviceinterface.snpchromosome.ServiceSNPChromosome13;
import com.roslin.mwicks.spring.variation.serviceinterface.snpchromosome.ServiceSNPChromosome14;
import com.roslin.mwicks.spring.variation.serviceinterface.snpchromosome.ServiceSNPChromosome15;
import com.roslin.mwicks.spring.variation.serviceinterface.snpchromosome.ServiceSNPChromosome16;
import com.roslin.mwicks.spring.variation.serviceinterface.snpchromosome.ServiceSNPChromosome17;
import com.roslin.mwicks.spring.variation.serviceinterface.snpchromosome.ServiceSNPChromosome18;
import com.roslin.mwicks.spring.variation.serviceinterface.snpchromosome.ServiceSNPChromosome19;
import com.roslin.mwicks.spring.variation.serviceinterface.snpchromosome.ServiceSNPChromosome20;
import com.roslin.mwicks.spring.variation.serviceinterface.snpchromosome.ServiceSNPChromosome21;
import com.roslin.mwicks.spring.variation.serviceinterface.snpchromosome.ServiceSNPChromosome22;
import com.roslin.mwicks.spring.variation.serviceinterface.snpchromosome.ServiceSNPChromosome23;
import com.roslin.mwicks.spring.variation.serviceinterface.snpchromosome.ServiceSNPChromosome24;
import com.roslin.mwicks.spring.variation.serviceinterface.snpchromosome.ServiceSNPChromosome25;
import com.roslin.mwicks.spring.variation.serviceinterface.snpchromosome.ServiceSNPChromosome26;
import com.roslin.mwicks.spring.variation.serviceinterface.snpchromosome.ServiceSNPChromosome27;
import com.roslin.mwicks.spring.variation.serviceinterface.snpchromosome.ServiceSNPChromosome28;
import com.roslin.mwicks.spring.variation.serviceinterface.snpchromosome.ServiceSNPChromosome32;
import com.roslin.mwicks.spring.variation.serviceinterface.snpchromosome.ServiceSNPChromosomeW;
import com.roslin.mwicks.spring.variation.serviceinterface.snpchromosome.ServiceSNPChromosomeZ;
import com.roslin.mwicks.spring.variation.serviceinterface.snpchromosome.ServiceSNPChromosomeLGE64;
import com.roslin.mwicks.spring.variation.serviceinterface.snpchromosome.ServiceSNPChromosomeLGE22C19W28_E50C23;

import com.roslin.mwicks.utility.FileUtil;
import com.roslin.mwicks.utility.ObjectConverter;
import com.roslin.mwicks.utility.StringUtility;
import com.roslin.mwicks.utility.Wrapper;


public class UpdateProveanData {

	// Constants ----------------------------------------------------------------------------------
    private static final String MSGLEVEL = "*";
	private static final String STOP = "*";
	
	private static final char PAD_CHAR = '0';

    private static final String PROPERTY_NAME_HIBERNATE_JDBC_BATCH_SIZE = "hibernate.jdbc.batch_size";
	
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

            Map<String, Object> jpaProperties = entityManagerFactoryBean.getJpaPropertyMap();
            String strBatchSize = (String) jpaProperties.get(PROPERTY_NAME_HIBERNATE_JDBC_BATCH_SIZE);
            int intBatchSize = ObjectConverter.convert(strBatchSize, Integer.class);
            
    		if (args.length != 1 ) {
    			
    		    Wrapper.printMessage("ERROR! There MUST be 1 Command Line Arguments passed to this program!", MSGLEVEL, MSGLEVEL);
    			intReturnCode = -1;
            }
            else {
                
                ServiceSNPChromosome01 serviceSNPChromosome01 = (ServiceSNPChromosome01) applicationContext.getBean(ServiceSNPChromosome01.class);
                ServiceSNPChromosome03 serviceSNPChromosome03 = (ServiceSNPChromosome03) applicationContext.getBean(ServiceSNPChromosome03.class);
                ServiceSNPChromosome04 serviceSNPChromosome04 = (ServiceSNPChromosome04) applicationContext.getBean(ServiceSNPChromosome04.class);
                ServiceSNPChromosome05 serviceSNPChromosome05 = (ServiceSNPChromosome05) applicationContext.getBean(ServiceSNPChromosome05.class);
                ServiceSNPChromosome06 serviceSNPChromosome06 = (ServiceSNPChromosome06) applicationContext.getBean(ServiceSNPChromosome06.class);
                ServiceSNPChromosome07 serviceSNPChromosome07 = (ServiceSNPChromosome07) applicationContext.getBean(ServiceSNPChromosome07.class);
                ServiceSNPChromosome08 serviceSNPChromosome08 = (ServiceSNPChromosome08) applicationContext.getBean(ServiceSNPChromosome08.class);
                ServiceSNPChromosome09 serviceSNPChromosome09 = (ServiceSNPChromosome09) applicationContext.getBean(ServiceSNPChromosome09.class);
                ServiceSNPChromosome10 serviceSNPChromosome10 = (ServiceSNPChromosome10) applicationContext.getBean(ServiceSNPChromosome10.class);
                ServiceSNPChromosome11 serviceSNPChromosome11 = (ServiceSNPChromosome11) applicationContext.getBean(ServiceSNPChromosome11.class);
                ServiceSNPChromosome12 serviceSNPChromosome12 = (ServiceSNPChromosome12) applicationContext.getBean(ServiceSNPChromosome12.class);
                ServiceSNPChromosome13 serviceSNPChromosome13 = (ServiceSNPChromosome13) applicationContext.getBean(ServiceSNPChromosome13.class);
                ServiceSNPChromosome14 serviceSNPChromosome14 = (ServiceSNPChromosome14) applicationContext.getBean(ServiceSNPChromosome14.class);
                ServiceSNPChromosome15 serviceSNPChromosome15 = (ServiceSNPChromosome15) applicationContext.getBean(ServiceSNPChromosome15.class);
                ServiceSNPChromosome16 serviceSNPChromosome16 = (ServiceSNPChromosome16) applicationContext.getBean(ServiceSNPChromosome16.class);
                ServiceSNPChromosome17 serviceSNPChromosome17 = (ServiceSNPChromosome17) applicationContext.getBean(ServiceSNPChromosome17.class);
                ServiceSNPChromosome18 serviceSNPChromosome18 = (ServiceSNPChromosome18) applicationContext.getBean(ServiceSNPChromosome18.class);
                ServiceSNPChromosome19 serviceSNPChromosome19 = (ServiceSNPChromosome19) applicationContext.getBean(ServiceSNPChromosome19.class);
                ServiceSNPChromosome20 serviceSNPChromosome20 = (ServiceSNPChromosome20) applicationContext.getBean(ServiceSNPChromosome20.class);
                ServiceSNPChromosome21 serviceSNPChromosome21 = (ServiceSNPChromosome21) applicationContext.getBean(ServiceSNPChromosome21.class);
                ServiceSNPChromosome22 serviceSNPChromosome22 = (ServiceSNPChromosome22) applicationContext.getBean(ServiceSNPChromosome22.class);
                ServiceSNPChromosome23 serviceSNPChromosome23 = (ServiceSNPChromosome23) applicationContext.getBean(ServiceSNPChromosome23.class);
                ServiceSNPChromosome24 serviceSNPChromosome24 = (ServiceSNPChromosome24) applicationContext.getBean(ServiceSNPChromosome24.class);
                ServiceSNPChromosome25 serviceSNPChromosome25 = (ServiceSNPChromosome25) applicationContext.getBean(ServiceSNPChromosome25.class);
                ServiceSNPChromosome26 serviceSNPChromosome26 = (ServiceSNPChromosome26) applicationContext.getBean(ServiceSNPChromosome26.class);
                ServiceSNPChromosome27 serviceSNPChromosome27 = (ServiceSNPChromosome27) applicationContext.getBean(ServiceSNPChromosome27.class);
                ServiceSNPChromosome28 serviceSNPChromosome28 = (ServiceSNPChromosome28) applicationContext.getBean(ServiceSNPChromosome28.class);
                ServiceSNPChromosome32 serviceSNPChromosome32 = (ServiceSNPChromosome32) applicationContext.getBean(ServiceSNPChromosome32.class);
                ServiceSNPChromosomeW serviceSNPChromosomeW = (ServiceSNPChromosomeW) applicationContext.getBean(ServiceSNPChromosomeW.class);
                ServiceSNPChromosomeZ serviceSNPChromosomeZ = (ServiceSNPChromosomeZ) applicationContext.getBean(ServiceSNPChromosomeZ.class);
                ServiceSNPChromosomeLGE64 serviceSNPChromosomeLGE64 = (ServiceSNPChromosomeLGE64) applicationContext.getBean(ServiceSNPChromosomeLGE64.class);
                ServiceSNPChromosomeLGE22C19W28_E50C23 serviceSNPChromosomeLGE22C19W28_E50C23 = (ServiceSNPChromosomeLGE22C19W28_E50C23) applicationContext.getBean(ServiceSNPChromosomeLGE22C19W28_E50C23.class);
               

        		String directory = args[0];
        		
                File dir = new File(directory);

                if ( dir.exists() ) {
                	
            		File[] filesFile = FileUtil.listAllFilesInDirectory(directory);
            		
            		int totalRecordCount = 0;
            		int totalFileCount = 0;
            		
                    int proveandataTotal = 0;

        	     	int intSNPChromosomeCount01 = 0;
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


            		for ( File file : filesFile ) {
            			
            			if ( !file.getName().equals(".DS_Store") ) {
            				
                			totalFileCount++;

                            List<ProveanData> proveandataList = ConvertFiletoUpdateProveanDataList.run(file);
 
                            totalRecordCount = totalRecordCount +  proveandataList.size();
                            
                			System.out.println(StringUtility.pad(totalFileCount, 3, PAD_CHAR) + " : Directory : " + directory + " : " + file.getName() + " : records : " + StringUtility.pad(proveandataList.size(), 8, PAD_CHAR));

                	     	proveandataTotal = proveandataTotal + proveandataList.size();
                	     	
                	        Iterator<ProveanData> iteratorProveanData = proveandataList.iterator();
                	        
                	     	while (iteratorProveanData.hasNext()) {
                	    		
                	     		ProveanData proveandata = iteratorProveanData.next();
                	     		
                	     		if ( proveandata.isChromosome1() ) {
                	     			
                	                List<SNPChromosome01> snpchromosome1List = new ArrayList<SNPChromosome01>();
                	     			
                	     			snpchromosome1List = serviceSNPChromosome01.findBySnpId(proveandata.getSnpId());
                        	        Iterator<SNPChromosome01> iteratorSNPChromosome01 = snpchromosome1List.iterator();
                        	     	
                        	        while (iteratorSNPChromosome01.hasNext()) {

                        	     		SNPChromosome01 snpchromosome01 = iteratorSNPChromosome01.next();
                        	     		snpchromosome01.setAminoAcidSubs(proveandata.getAminoAcidSubs());
                        	     		snpchromosome01.setScoreProvean(proveandata.getScoreProvean());
                        	     		snpchromosome01.setProteinAlignNumber(proveandata.getProteinAlignNumber());
                        	     		snpchromosome01.setTotalAlignSequenceNumber(proveandata.getTotalAlignSequenceNumber());

                        	     		serviceSNPChromosome01.update(snpchromosome01);
                        	     		
                        	     		intSNPChromosomeCount01++;
                        	     	}
                	     		}

                	     		if ( proveandata.isChromosome3() ) {

                	                List<SNPChromosome03> snpchromosome3List = new ArrayList<SNPChromosome03>();

                	     			snpchromosome3List = serviceSNPChromosome03.findBySnpId(proveandata.getSnpId());
                        	        Iterator<SNPChromosome03> iteratorSNPChromosome03 = snpchromosome3List.iterator();
                        	     	
                        	        while (iteratorSNPChromosome03.hasNext()) {

                        	     		SNPChromosome03 snpchromosome03 = iteratorSNPChromosome03.next();
                        	     		snpchromosome03.setAminoAcidSubs(proveandata.getAminoAcidSubs());
                        	     		snpchromosome03.setScoreProvean(proveandata.getScoreProvean());
                        	     		snpchromosome03.setProteinAlignNumber(proveandata.getProteinAlignNumber());
                        	     		snpchromosome03.setTotalAlignSequenceNumber(proveandata.getTotalAlignSequenceNumber());

                        	     		serviceSNPChromosome03.update(snpchromosome03);

                        	     		intSNPChromosomeCount03++;
                        	        }
                	     		}

                	     		if ( proveandata.isChromosome4() ) {
                	     			
                	                List<SNPChromosome04> snpchromosome4List = new ArrayList<SNPChromosome04>();

                	                snpchromosome4List = serviceSNPChromosome04.findBySnpId(proveandata.getSnpId());
                        	        Iterator<SNPChromosome04> iteratorSNPChromosome04 = snpchromosome4List.iterator();
                        	     	
                        	        while (iteratorSNPChromosome04.hasNext()) {

                        	     		SNPChromosome04 snpchromosome04 = iteratorSNPChromosome04.next();
                        	     		snpchromosome04.setAminoAcidSubs(proveandata.getAminoAcidSubs());
                        	     		snpchromosome04.setScoreProvean(proveandata.getScoreProvean());
                        	     		snpchromosome04.setProteinAlignNumber(proveandata.getProteinAlignNumber());
                        	     		snpchromosome04.setTotalAlignSequenceNumber(proveandata.getTotalAlignSequenceNumber());

                        	     		serviceSNPChromosome04.update(snpchromosome04);
                        	     		
                        	     		intSNPChromosomeCount04++;
                        	     	}
                	     		}

                	     		if ( proveandata.isChromosome5() ) {
                	     			
                	                List<SNPChromosome05> snpchromosome5List = new ArrayList<SNPChromosome05>();

                	                snpchromosome5List = serviceSNPChromosome05.findBySnpId(proveandata.getSnpId());
                        	        Iterator<SNPChromosome05> iteratorSNPChromosome05 = snpchromosome5List.iterator();
                        	     	
                        	        while (iteratorSNPChromosome05.hasNext()) {

                        	     		SNPChromosome05 snpchromosome05 = iteratorSNPChromosome05.next();
                        	     		snpchromosome05.setAminoAcidSubs(proveandata.getAminoAcidSubs());
                        	     		snpchromosome05.setScoreProvean(proveandata.getScoreProvean());
                        	     		snpchromosome05.setProteinAlignNumber(proveandata.getProteinAlignNumber());
                        	     		snpchromosome05.setTotalAlignSequenceNumber(proveandata.getTotalAlignSequenceNumber());

                        	     		serviceSNPChromosome05.update(snpchromosome05);
                        	     		
                        	     		intSNPChromosomeCount05++;
                        	     	}
                	     		}

                	     		if ( proveandata.isChromosome6() ) {
                	     			
                	                List<SNPChromosome06> snpchromosome6List = new ArrayList<SNPChromosome06>();

                	                snpchromosome6List = serviceSNPChromosome06.findBySnpId(proveandata.getSnpId());
                        	        Iterator<SNPChromosome06> iteratorSNPChromosome06 = snpchromosome6List.iterator();
                        	     	
                        	        while (iteratorSNPChromosome06.hasNext()) {

                        	     		SNPChromosome06 snpchromosome06 = iteratorSNPChromosome06.next();
                        	     		snpchromosome06.setAminoAcidSubs(proveandata.getAminoAcidSubs());
                        	     		snpchromosome06.setScoreProvean(proveandata.getScoreProvean());
                        	     		snpchromosome06.setProteinAlignNumber(proveandata.getProteinAlignNumber());
                        	     		snpchromosome06.setTotalAlignSequenceNumber(proveandata.getTotalAlignSequenceNumber());

                        	     		serviceSNPChromosome06.update(snpchromosome06);
                        	     		
                        	     		intSNPChromosomeCount06++;
                        	     	}
                	     		}

                	     		if ( proveandata.isChromosome7() ) {
                	     			
                	                List<SNPChromosome07> snpchromosome7List = new ArrayList<SNPChromosome07>();

                	                snpchromosome7List = serviceSNPChromosome07.findBySnpId(proveandata.getSnpId());
                        	        Iterator<SNPChromosome07> iteratorSNPChromosome07 = snpchromosome7List.iterator();
                        	     	
                        	        while (iteratorSNPChromosome07.hasNext()) {

                        	     		SNPChromosome07 snpchromosome07 = iteratorSNPChromosome07.next();
                        	     		snpchromosome07.setAminoAcidSubs(proveandata.getAminoAcidSubs());
                        	     		snpchromosome07.setScoreProvean(proveandata.getScoreProvean());
                        	     		snpchromosome07.setProteinAlignNumber(proveandata.getProteinAlignNumber());
                        	     		snpchromosome07.setTotalAlignSequenceNumber(proveandata.getTotalAlignSequenceNumber());

                        	     		serviceSNPChromosome07.update(snpchromosome07);
                        	     		
                        	     		intSNPChromosomeCount07++;
                        	     	}
                	     		}

                	     		if ( proveandata.isChromosome8() ) {

                	                List<SNPChromosome08> snpchromosome8List = new ArrayList<SNPChromosome08>();

                	     			snpchromosome8List = serviceSNPChromosome08.findBySnpId(proveandata.getSnpId());
                        	        Iterator<SNPChromosome08> iteratorSNPChromosome08 = snpchromosome8List.iterator();
                        	     	
                        	        while (iteratorSNPChromosome08.hasNext()) {

                        	     		SNPChromosome08 snpchromosome08 = iteratorSNPChromosome08.next();
                        	     		snpchromosome08.setAminoAcidSubs(proveandata.getAminoAcidSubs());
                        	     		snpchromosome08.setScoreProvean(proveandata.getScoreProvean());
                        	     		snpchromosome08.setProteinAlignNumber(proveandata.getProteinAlignNumber());
                        	     		snpchromosome08.setTotalAlignSequenceNumber(proveandata.getTotalAlignSequenceNumber());

                        	     		serviceSNPChromosome08.update(snpchromosome08);
                        	     		
                        	     		intSNPChromosomeCount08++;
                        	     	}
                	     		}

                	     		if ( proveandata.isChromosome9() ) {

                	                List<SNPChromosome09> snpchromosome9List = new ArrayList<SNPChromosome09>();

                	     			snpchromosome9List = serviceSNPChromosome09.findBySnpId(proveandata.getSnpId());
                        	        Iterator<SNPChromosome09> iteratorSNPChromosome09 = snpchromosome9List.iterator();
                        	     	
                        	        while (iteratorSNPChromosome09.hasNext()) {

                        	     		SNPChromosome09 snpchromosome09 = iteratorSNPChromosome09.next();
                        	     		snpchromosome09.setAminoAcidSubs(proveandata.getAminoAcidSubs());
                        	     		snpchromosome09.setScoreProvean(proveandata.getScoreProvean());
                        	     		snpchromosome09.setProteinAlignNumber(proveandata.getProteinAlignNumber());
                        	     		snpchromosome09.setTotalAlignSequenceNumber(proveandata.getTotalAlignSequenceNumber());

                        	     		serviceSNPChromosome09.update(snpchromosome09);
                        	     		
                        	     		intSNPChromosomeCount09++;
                        	     	}
                	     		}

                	     		if ( proveandata.isChromosome10() ) {

                	                List<SNPChromosome10> snpchromosome10List = new ArrayList<SNPChromosome10>();

                	     			snpchromosome10List = serviceSNPChromosome10.findBySnpId(proveandata.getSnpId());
                        	        Iterator<SNPChromosome10> iteratorSNPChromosome10 = snpchromosome10List.iterator();
                        	     	
                        	        while (iteratorSNPChromosome10.hasNext()) {

                        	     		SNPChromosome10 snpchromosome10 = iteratorSNPChromosome10.next();
                        	     		snpchromosome10.setAminoAcidSubs(proveandata.getAminoAcidSubs());
                        	     		snpchromosome10.setScoreProvean(proveandata.getScoreProvean());
                        	     		snpchromosome10.setProteinAlignNumber(proveandata.getProteinAlignNumber());
                        	     		snpchromosome10.setTotalAlignSequenceNumber(proveandata.getTotalAlignSequenceNumber());

                        	     		serviceSNPChromosome10.update(snpchromosome10);
                        	     		
                        	     		intSNPChromosomeCount10++;
                        	     	}
                	     		}

                	     		if ( proveandata.isChromosome11() ) {
                	     			
                	                List<SNPChromosome11> snpchromosome11List = new ArrayList<SNPChromosome11>();

                	     			snpchromosome11List = serviceSNPChromosome11.findBySnpId(proveandata.getSnpId());
                        	        Iterator<SNPChromosome11> iteratorSNPChromosome11 = snpchromosome11List.iterator();
                        	     	
                        	        while (iteratorSNPChromosome11.hasNext()) {

                        	     		SNPChromosome11 snpchromosome11 = iteratorSNPChromosome11.next();
                        	     		snpchromosome11.setAminoAcidSubs(proveandata.getAminoAcidSubs());
                        	     		snpchromosome11.setScoreProvean(proveandata.getScoreProvean());
                        	     		snpchromosome11.setProteinAlignNumber(proveandata.getProteinAlignNumber());
                        	     		snpchromosome11.setTotalAlignSequenceNumber(proveandata.getTotalAlignSequenceNumber());

                        	     		serviceSNPChromosome11.update(snpchromosome11);
                        	     		
                        	     		intSNPChromosomeCount11++;
                        	     	}
                	     		}

                	     		if ( proveandata.isChromosome12() ) {
                	     			
                	                List<SNPChromosome12> snpchromosome12List = new ArrayList<SNPChromosome12>();

                	                snpchromosome12List = serviceSNPChromosome12.findBySnpId(proveandata.getSnpId());
                        	        Iterator<SNPChromosome12> iteratorSNPChromosome12 = snpchromosome12List.iterator();
                        	     	
                        	        while (iteratorSNPChromosome12.hasNext()) {

                        	     		SNPChromosome12 snpchromosome12 = iteratorSNPChromosome12.next();
                        	     		snpchromosome12.setAminoAcidSubs(proveandata.getAminoAcidSubs());
                        	     		snpchromosome12.setScoreProvean(proveandata.getScoreProvean());
                        	     		snpchromosome12.setProteinAlignNumber(proveandata.getProteinAlignNumber());
                        	     		snpchromosome12.setTotalAlignSequenceNumber(proveandata.getTotalAlignSequenceNumber());

                        	     		serviceSNPChromosome12.update(snpchromosome12);
                        	     		
                        	     		intSNPChromosomeCount12++;
                        	     	}
                	     		}

                	     		if ( proveandata.isChromosome13() ) {
                	     			
                	                List<SNPChromosome13> snpchromosome13List = new ArrayList<SNPChromosome13>();

                	                snpchromosome13List = serviceSNPChromosome13.findBySnpId(proveandata.getSnpId());
                        	        Iterator<SNPChromosome13> iteratorSNPChromosome13 = snpchromosome13List.iterator();
                        	     	
                        	        while (iteratorSNPChromosome13.hasNext()) {

                        	     		SNPChromosome13 snpchromosome13 = iteratorSNPChromosome13.next();
                        	     		snpchromosome13.setAminoAcidSubs(proveandata.getAminoAcidSubs());
                        	     		snpchromosome13.setScoreProvean(proveandata.getScoreProvean());
                        	     		snpchromosome13.setProteinAlignNumber(proveandata.getProteinAlignNumber());
                        	     		snpchromosome13.setTotalAlignSequenceNumber(proveandata.getTotalAlignSequenceNumber());

                        	     		serviceSNPChromosome13.update(snpchromosome13);
                        	     		
                        	     		intSNPChromosomeCount13++;
                        	     	}
                	     		}

                	     		if ( proveandata.isChromosome14() ) {
                	     			
                	                List<SNPChromosome14> snpchromosome14List = new ArrayList<SNPChromosome14>();

                	                snpchromosome14List = serviceSNPChromosome14.findBySnpId(proveandata.getSnpId());
                        	        Iterator<SNPChromosome14> iteratorSNPChromosome14 = snpchromosome14List.iterator();
                        	     	
                        	        while (iteratorSNPChromosome14.hasNext()) {

                        	     		SNPChromosome14 snpchromosome14 = iteratorSNPChromosome14.next();
                        	     		snpchromosome14.setAminoAcidSubs(proveandata.getAminoAcidSubs());
                        	     		snpchromosome14.setScoreProvean(proveandata.getScoreProvean());
                        	     		snpchromosome14.setProteinAlignNumber(proveandata.getProteinAlignNumber());
                        	     		snpchromosome14.setTotalAlignSequenceNumber(proveandata.getTotalAlignSequenceNumber());

                        	     		serviceSNPChromosome14.update(snpchromosome14);
                        	     		
                        	     		intSNPChromosomeCount14++;
                        	     	}
                	     		}

                	     		if ( proveandata.isChromosome15() ) {
                	     			
                	                List<SNPChromosome15> snpchromosome15List = new ArrayList<SNPChromosome15>();

                	                snpchromosome15List = serviceSNPChromosome15.findBySnpId(proveandata.getSnpId());
                        	        Iterator<SNPChromosome15> iteratorSNPChromosome15 = snpchromosome15List.iterator();
                        	     	
                        	        while (iteratorSNPChromosome15.hasNext()) {

                        	     		SNPChromosome15 snpchromosome15 = iteratorSNPChromosome15.next();
                        	     		snpchromosome15.setAminoAcidSubs(proveandata.getAminoAcidSubs());
                        	     		snpchromosome15.setScoreProvean(proveandata.getScoreProvean());
                        	     		snpchromosome15.setProteinAlignNumber(proveandata.getProteinAlignNumber());
                        	     		snpchromosome15.setTotalAlignSequenceNumber(proveandata.getTotalAlignSequenceNumber());

                        	     		serviceSNPChromosome15.update(snpchromosome15);
                        	     		
                        	     		intSNPChromosomeCount15++;
                        	     	}
                	     		}

                	     		if ( proveandata.isChromosome16() ) {

                	                List<SNPChromosome16> snpchromosome16List = new ArrayList<SNPChromosome16>();

                	     			snpchromosome16List = serviceSNPChromosome16.findBySnpId(proveandata.getSnpId());
                        	        Iterator<SNPChromosome16> iteratorSNPChromosome16 = snpchromosome16List.iterator();
                        	     	
                        	        while (iteratorSNPChromosome16.hasNext()) {

                        	     		SNPChromosome16 snpchromosome16 = iteratorSNPChromosome16.next();
                        	     		snpchromosome16.setAminoAcidSubs(proveandata.getAminoAcidSubs());
                        	     		snpchromosome16.setScoreProvean(proveandata.getScoreProvean());
                        	     		snpchromosome16.setProteinAlignNumber(proveandata.getProteinAlignNumber());
                        	     		snpchromosome16.setTotalAlignSequenceNumber(proveandata.getTotalAlignSequenceNumber());

                        	     		serviceSNPChromosome16.update(snpchromosome16);
                        	     		
                        	     		intSNPChromosomeCount16++;
                        	     	}
                	     		}

                	     		if ( proveandata.isChromosome17() ) {
                	     			
                	                List<SNPChromosome17> snpchromosome17List = new ArrayList<SNPChromosome17>();

                	     			snpchromosome17List = serviceSNPChromosome17.findBySnpId(proveandata.getSnpId());
                        	        Iterator<SNPChromosome17> iteratorSNPChromosome17 = snpchromosome17List.iterator();
                        	     	
                        	        while (iteratorSNPChromosome17.hasNext()) {

                        	     		SNPChromosome17 snpchromosome17 = iteratorSNPChromosome17.next();
                        	     		snpchromosome17.setAminoAcidSubs(proveandata.getAminoAcidSubs());
                        	     		snpchromosome17.setScoreProvean(proveandata.getScoreProvean());
                        	     		snpchromosome17.setProteinAlignNumber(proveandata.getProteinAlignNumber());
                        	     		snpchromosome17.setTotalAlignSequenceNumber(proveandata.getTotalAlignSequenceNumber());

                        	     		serviceSNPChromosome17.update(snpchromosome17);
                        	     		
                        	     		intSNPChromosomeCount17++;
                        	     	}
                	     		}

                	     		if ( proveandata.isChromosome18() ) {

                	                List<SNPChromosome18> snpchromosome18List = new ArrayList<SNPChromosome18>();

                	     			snpchromosome18List = serviceSNPChromosome18.findBySnpId(proveandata.getSnpId());
                        	        Iterator<SNPChromosome18> iteratorSNPChromosome18 = snpchromosome18List.iterator();
                        	     	
                        	        while (iteratorSNPChromosome18.hasNext()) {

                        	     		SNPChromosome18 snpchromosome18 = iteratorSNPChromosome18.next();
                        	     		snpchromosome18.setAminoAcidSubs(proveandata.getAminoAcidSubs());
                        	     		snpchromosome18.setScoreProvean(proveandata.getScoreProvean());
                        	     		snpchromosome18.setProteinAlignNumber(proveandata.getProteinAlignNumber());
                        	     		snpchromosome18.setTotalAlignSequenceNumber(proveandata.getTotalAlignSequenceNumber());

                        	     		serviceSNPChromosome18.update(snpchromosome18);
                        	     		
                        	     		intSNPChromosomeCount18++;
                        	     	}
                	     		}

                	     		if ( proveandata.isChromosome19() ) {

                	                List<SNPChromosome19> snpchromosome19List = new ArrayList<SNPChromosome19>();

                	     			snpchromosome19List = serviceSNPChromosome19.findBySnpId(proveandata.getSnpId());
                        	        Iterator<SNPChromosome19> iteratorSNPChromosome19 = snpchromosome19List.iterator();
                        	     	
                        	        while (iteratorSNPChromosome19.hasNext()) {

                        	     		SNPChromosome19 snpchromosome19 = iteratorSNPChromosome19.next();
                        	     		snpchromosome19.setAminoAcidSubs(proveandata.getAminoAcidSubs());
                        	     		snpchromosome19.setScoreProvean(proveandata.getScoreProvean());
                        	     		snpchromosome19.setProteinAlignNumber(proveandata.getProteinAlignNumber());
                        	     		snpchromosome19.setTotalAlignSequenceNumber(proveandata.getTotalAlignSequenceNumber());

                        	     		serviceSNPChromosome19.update(snpchromosome19);
                        	     		
                        	     		intSNPChromosomeCount19++;
                        	     	}
                	     		}

                	     		if ( proveandata.isChromosome20() ) {
                	     			
                	                List<SNPChromosome20> snpchromosome20List = new ArrayList<SNPChromosome20>();

                	     			snpchromosome20List = serviceSNPChromosome20.findBySnpId(proveandata.getSnpId());
                        	        Iterator<SNPChromosome20> iteratorSNPChromosome20 = snpchromosome20List.iterator();
                        	     	
                        	        while (iteratorSNPChromosome20.hasNext()) {

                        	     		SNPChromosome20 snpchromosome20 = iteratorSNPChromosome20.next();
                        	     		snpchromosome20.setAminoAcidSubs(proveandata.getAminoAcidSubs());
                        	     		snpchromosome20.setScoreProvean(proveandata.getScoreProvean());
                        	     		snpchromosome20.setProteinAlignNumber(proveandata.getProteinAlignNumber());
                        	     		snpchromosome20.setTotalAlignSequenceNumber(proveandata.getTotalAlignSequenceNumber());

                        	     		serviceSNPChromosome20.update(snpchromosome20);
                        	     		
                        	     		intSNPChromosomeCount20++;
                        	     	}
                	     		}

                	     		if ( proveandata.isChromosome21() ) {

                	                List<SNPChromosome21> snpchromosome21List = new ArrayList<SNPChromosome21>();

                	     			snpchromosome21List = serviceSNPChromosome21.findBySnpId(proveandata.getSnpId());
                        	        Iterator<SNPChromosome21> iteratorSNPChromosome21 = snpchromosome21List.iterator();
                        	     	
                        	        while (iteratorSNPChromosome21.hasNext()) {

                        	     		SNPChromosome21 snpchromosome21 = iteratorSNPChromosome21.next();
                        	     		snpchromosome21.setAminoAcidSubs(proveandata.getAminoAcidSubs());
                        	     		snpchromosome21.setScoreProvean(proveandata.getScoreProvean());
                        	     		snpchromosome21.setProteinAlignNumber(proveandata.getProteinAlignNumber());
                        	     		snpchromosome21.setTotalAlignSequenceNumber(proveandata.getTotalAlignSequenceNumber());

                        	     		serviceSNPChromosome21.update(snpchromosome21);
                        	     		
                        	     		intSNPChromosomeCount21++;
                        	     		                        	     	}
                	     		}

                	     		if ( proveandata.isChromosome22() ) {

                	                List<SNPChromosome22> snpchromosome22List = new ArrayList<SNPChromosome22>();

                	     			snpchromosome22List = serviceSNPChromosome22.findBySnpId(proveandata.getSnpId());
                        	        Iterator<SNPChromosome22> iteratorSNPChromosome22 = snpchromosome22List.iterator();
                        	     	
                        	        while (iteratorSNPChromosome22.hasNext()) {

                        	     		SNPChromosome22 snpchromosome22 = iteratorSNPChromosome22.next();
                        	     		snpchromosome22.setAminoAcidSubs(proveandata.getAminoAcidSubs());
                        	     		snpchromosome22.setScoreProvean(proveandata.getScoreProvean());
                        	     		snpchromosome22.setProteinAlignNumber(proveandata.getProteinAlignNumber());
                        	     		snpchromosome22.setTotalAlignSequenceNumber(proveandata.getTotalAlignSequenceNumber());

                        	     		serviceSNPChromosome22.update(snpchromosome22);
                        	     		
                        	     		intSNPChromosomeCount22++;
                        	     	}
                	     		}

                	     		if ( proveandata.isChromosome23() ) {
                	     			
                	                List<SNPChromosome23> snpchromosome23List = new ArrayList<SNPChromosome23>();
                	                
                	                snpchromosome23List = serviceSNPChromosome23.findBySnpId(proveandata.getSnpId());
                        	        Iterator<SNPChromosome23> iteratorSNPChromosome23 = snpchromosome23List.iterator();
                        	     	
                        	        while (iteratorSNPChromosome23.hasNext()) {

                        	     		SNPChromosome23 snpchromosome23 = iteratorSNPChromosome23.next();
                        	     		snpchromosome23.setAminoAcidSubs(proveandata.getAminoAcidSubs());
                        	     		snpchromosome23.setScoreProvean(proveandata.getScoreProvean());
                        	     		snpchromosome23.setProteinAlignNumber(proveandata.getProteinAlignNumber());
                        	     		snpchromosome23.setTotalAlignSequenceNumber(proveandata.getTotalAlignSequenceNumber());

                        	     		serviceSNPChromosome23.update(snpchromosome23);
                        	     		
                        	     		intSNPChromosomeCount23++;
                        	     	}
                	     		}

                	     		if ( proveandata.isChromosome24() ) {
                	     			
                	     			List<SNPChromosome24> snpchromosome24List = new ArrayList<SNPChromosome24>();

                	                snpchromosome24List = serviceSNPChromosome24.findBySnpId(proveandata.getSnpId());
                        	        Iterator<SNPChromosome24> iteratorSNPChromosome24 = snpchromosome24List.iterator();
                        	     	
                        	        while (iteratorSNPChromosome24.hasNext()) {

                        	     		SNPChromosome24 snpchromosome24 = iteratorSNPChromosome24.next();
                        	     		snpchromosome24.setAminoAcidSubs(proveandata.getAminoAcidSubs());
                        	     		snpchromosome24.setScoreProvean(proveandata.getScoreProvean());
                        	     		snpchromosome24.setProteinAlignNumber(proveandata.getProteinAlignNumber());
                        	     		snpchromosome24.setTotalAlignSequenceNumber(proveandata.getTotalAlignSequenceNumber());

                        	     		serviceSNPChromosome24.update(snpchromosome24);
                        	     		
                        	     		intSNPChromosomeCount24++;
                        	     	}
                	     		}

                	     		if ( proveandata.isChromosome25() ) {
                	     			
                	                List<SNPChromosome25> snpchromosome25List = new ArrayList<SNPChromosome25>();

                	     			snpchromosome25List = serviceSNPChromosome25.findBySnpId(proveandata.getSnpId());
                        	        Iterator<SNPChromosome25> iteratorSNPChromosome25 = snpchromosome25List.iterator();
                        	     	
                        	        while (iteratorSNPChromosome25.hasNext()) {

                        	     		SNPChromosome25 snpchromosome25 = iteratorSNPChromosome25.next();
                        	     		snpchromosome25.setAminoAcidSubs(proveandata.getAminoAcidSubs());
                        	     		snpchromosome25.setScoreProvean(proveandata.getScoreProvean());
                        	     		snpchromosome25.setProteinAlignNumber(proveandata.getProteinAlignNumber());
                        	     		snpchromosome25.setTotalAlignSequenceNumber(proveandata.getTotalAlignSequenceNumber());

                        	     		serviceSNPChromosome25.update(snpchromosome25);
                        	     		
                        	     		intSNPChromosomeCount25++;
                        	     	}
                	     		}

                	     		if ( proveandata.isChromosome26() ) {

                	                List<SNPChromosome26> snpchromosome26List = new ArrayList<SNPChromosome26>();

                	     			snpchromosome26List = serviceSNPChromosome26.findBySnpId(proveandata.getSnpId());
                        	        Iterator<SNPChromosome26> iteratorSNPChromosome26 = snpchromosome26List.iterator();
                        	     	
                        	        while (iteratorSNPChromosome26.hasNext()) {

                        	     		SNPChromosome26 snpchromosome26 = iteratorSNPChromosome26.next();
                        	     		snpchromosome26.setAminoAcidSubs(proveandata.getAminoAcidSubs());
                        	     		snpchromosome26.setScoreProvean(proveandata.getScoreProvean());
                        	     		snpchromosome26.setProteinAlignNumber(proveandata.getProteinAlignNumber());
                        	     		snpchromosome26.setTotalAlignSequenceNumber(proveandata.getTotalAlignSequenceNumber());

                        	     		serviceSNPChromosome26.update(snpchromosome26);
                        	     		
                        	     		intSNPChromosomeCount26++;
                        	     	}
                	     		}

                	     		if ( proveandata.isChromosome27() ) {
                	     			
                	                List<SNPChromosome27> snpchromosome27List = new ArrayList<SNPChromosome27>();

                	     			snpchromosome27List = serviceSNPChromosome27.findBySnpId(proveandata.getSnpId());
                        	        Iterator<SNPChromosome27> iteratorSNPChromosome27 = snpchromosome27List.iterator();
                        	     	
                        	        while (iteratorSNPChromosome27.hasNext()) {

                        	     		SNPChromosome27 snpchromosome27 = iteratorSNPChromosome27.next();
                        	     		snpchromosome27.setAminoAcidSubs(proveandata.getAminoAcidSubs());
                        	     		snpchromosome27.setScoreProvean(proveandata.getScoreProvean());
                        	     		snpchromosome27.setProteinAlignNumber(proveandata.getProteinAlignNumber());
                        	     		snpchromosome27.setTotalAlignSequenceNumber(proveandata.getTotalAlignSequenceNumber());

                        	     		serviceSNPChromosome27.update(snpchromosome27);
                        	     		
                        	     		intSNPChromosomeCount27++;
                        	     	}
                	     		}

                	     		if ( proveandata.isChromosome28() ) {

                	                List<SNPChromosome28> snpchromosome28List = new ArrayList<SNPChromosome28>();

                	     			snpchromosome28List = serviceSNPChromosome28.findBySnpId(proveandata.getSnpId());
                        	        Iterator<SNPChromosome28> iteratorSNPChromosome28 = snpchromosome28List.iterator();
                        	     	
                        	        while (iteratorSNPChromosome28.hasNext()) {

                        	     		SNPChromosome28 snpchromosome28 = iteratorSNPChromosome28.next();
                        	     		snpchromosome28.setAminoAcidSubs(proveandata.getAminoAcidSubs());
                        	     		snpchromosome28.setScoreProvean(proveandata.getScoreProvean());
                        	     		snpchromosome28.setProteinAlignNumber(proveandata.getProteinAlignNumber());
                        	     		snpchromosome28.setTotalAlignSequenceNumber(proveandata.getTotalAlignSequenceNumber());

                        	     		serviceSNPChromosome28.update(snpchromosome28);
                        	     		
                        	     		intSNPChromosomeCount28++;
                        	     	}
                	     		}

                	     		if ( proveandata.isChromosome32() ) {
                	     			
                	                List<SNPChromosome32> snpchromosome32List = new ArrayList<SNPChromosome32>();

                	     			snpchromosome32List = serviceSNPChromosome32.findBySnpId(proveandata.getSnpId());
                        	        Iterator<SNPChromosome32> iteratorSNPChromosome32 = snpchromosome32List.iterator();
                        	     	
                        	        while (iteratorSNPChromosome32.hasNext()) {

                        	     		SNPChromosome32 snpchromosome32 = iteratorSNPChromosome32.next();
                        	     		snpchromosome32.setAminoAcidSubs(proveandata.getAminoAcidSubs());
                        	     		snpchromosome32.setScoreProvean(proveandata.getScoreProvean());
                        	     		snpchromosome32.setProteinAlignNumber(proveandata.getProteinAlignNumber());
                        	     		snpchromosome32.setTotalAlignSequenceNumber(proveandata.getTotalAlignSequenceNumber());

                        	     		serviceSNPChromosome32.update(snpchromosome32);
                        	     		
                        	     		intSNPChromosomeCount32++;
                        	     	}
                	     		}

                	     		if ( proveandata.isChromosomeLGE64() ) {
                	     			
                	                List<SNPChromosomeLGE64> snpchromosomeLGE64List = new ArrayList<SNPChromosomeLGE64>();

                	     			snpchromosomeLGE64List = serviceSNPChromosomeLGE64.findBySnpId(proveandata.getSnpId());
                        	        Iterator<SNPChromosomeLGE64> iteratorSNPChromosomeLGE64 = snpchromosomeLGE64List.iterator();
                        	     	
                        	        while (iteratorSNPChromosomeLGE64.hasNext()) {

                        	     		SNPChromosomeLGE64 snpchromosomeLGE64 = iteratorSNPChromosomeLGE64.next();
                        	     		snpchromosomeLGE64.setAminoAcidSubs(proveandata.getAminoAcidSubs());
                        	     		snpchromosomeLGE64.setScoreProvean(proveandata.getScoreProvean());
                        	     		snpchromosomeLGE64.setProteinAlignNumber(proveandata.getProteinAlignNumber());
                        	     		snpchromosomeLGE64.setTotalAlignSequenceNumber(proveandata.getTotalAlignSequenceNumber());

                        	     		serviceSNPChromosomeLGE64.update(snpchromosomeLGE64);
                        	     		
                        	     		intSNPChromosomeCountLGE64++;
                        	     	}
                	     		}

                	     		if ( proveandata.isChromosomeLGE22C19W28_E50C23() ) {
                	     			
                	                List<SNPChromosomeLGE22C19W28_E50C23> snpchromosomeLGE22C19W28_E50C23List = new ArrayList<SNPChromosomeLGE22C19W28_E50C23>();

                	     			snpchromosomeLGE22C19W28_E50C23List = serviceSNPChromosomeLGE22C19W28_E50C23.findBySnpId(proveandata.getSnpId());
                        	        Iterator<SNPChromosomeLGE22C19W28_E50C23> iteratorSNPChromosomeLGE22C19W28_E50C23 = snpchromosomeLGE22C19W28_E50C23List.iterator();
                        	     	
                        	        while (iteratorSNPChromosomeLGE22C19W28_E50C23.hasNext()) {

                        	     		SNPChromosomeLGE22C19W28_E50C23 snpchromosomeLGE22C19W28_E50C23 = iteratorSNPChromosomeLGE22C19W28_E50C23.next();
                        	     		snpchromosomeLGE22C19W28_E50C23.setAminoAcidSubs(proveandata.getAminoAcidSubs());
                        	     		snpchromosomeLGE22C19W28_E50C23.setScoreProvean(proveandata.getScoreProvean());
                        	     		snpchromosomeLGE22C19W28_E50C23.setProteinAlignNumber(proveandata.getProteinAlignNumber());
                        	     		snpchromosomeLGE22C19W28_E50C23.setTotalAlignSequenceNumber(proveandata.getTotalAlignSequenceNumber());

                        	     		serviceSNPChromosomeLGE22C19W28_E50C23.update(snpchromosomeLGE22C19W28_E50C23);
                        	     		
                        	     		intSNPChromosomeCountLGE22C19W28_E50C23++;
                        	     	}
                	     		}

                	     		if ( proveandata.isChromosomeW() ) {
                	     			
                	                List<SNPChromosomeW> snpchromosomeWList = new ArrayList<SNPChromosomeW>();

                	     			snpchromosomeWList = serviceSNPChromosomeW.findBySnpId(proveandata.getSnpId());
                        	        Iterator<SNPChromosomeW> iteratorSNPChromosomeW = snpchromosomeWList.iterator();
                        	     	
                        	        while (iteratorSNPChromosomeW.hasNext()) {

                        	     		SNPChromosomeW snpchromosomeW = iteratorSNPChromosomeW.next();
                        	     		snpchromosomeW.setAminoAcidSubs(proveandata.getAminoAcidSubs());
                        	     		snpchromosomeW.setScoreProvean(proveandata.getScoreProvean());
                        	     		snpchromosomeW.setProteinAlignNumber(proveandata.getProteinAlignNumber());
                        	     		snpchromosomeW.setTotalAlignSequenceNumber(proveandata.getTotalAlignSequenceNumber());

                        	     		serviceSNPChromosomeW.update(snpchromosomeW);
                        	     		
                        	     		intSNPChromosomeCountW++;
                        	     	}
                	     		}

                	     		if ( proveandata.isChromosomeZ() ) {
                	     			
                	                List<SNPChromosomeZ> snpchromosomeZList = new ArrayList<SNPChromosomeZ>();

                	     			snpchromosomeZList = serviceSNPChromosomeZ.findBySnpId(proveandata.getSnpId());
                        	        Iterator<SNPChromosomeZ> iteratorSNPChromosomeZ = snpchromosomeZList.iterator();
                        	     	
                        	        while (iteratorSNPChromosomeZ.hasNext()) {

                        	     		SNPChromosomeZ snpchromosomeZ = iteratorSNPChromosomeZ.next();
                        	     		snpchromosomeZ.setAminoAcidSubs(proveandata.getAminoAcidSubs());
                        	     		snpchromosomeZ.setScoreProvean(proveandata.getScoreProvean());
                        	     		snpchromosomeZ.setProteinAlignNumber(proveandata.getProteinAlignNumber());
                        	     		snpchromosomeZ.setTotalAlignSequenceNumber(proveandata.getTotalAlignSequenceNumber());

                        	     		serviceSNPChromosomeZ.update(snpchromosomeZ);
                        	     		
                        	     		intSNPChromosomeCountZ++;
                        	     	}
                	     		}


                	     	}
            			}
            		}
            		
             		System.out.println(StringUtility.pad(intSNPChromosomeCount01, 8, PAD_CHAR) + " Records updated into SNPChromosomeCount01");
            		System.out.println(StringUtility.pad(intSNPChromosomeCount03, 8, PAD_CHAR) + " Records updated into SNPChromosomeCount03");
            		System.out.println(StringUtility.pad(intSNPChromosomeCount04, 8, PAD_CHAR) + " Records updated into SNPChromosomeCount04");
             		System.out.println(StringUtility.pad(intSNPChromosomeCount05, 8, PAD_CHAR) + " Records updated into SNPChromosomeCount05");
            		System.out.println(StringUtility.pad(intSNPChromosomeCount06, 8, PAD_CHAR) + " Records updated into SNPChromosomeCount06");
            		System.out.println(StringUtility.pad(intSNPChromosomeCount07, 8, PAD_CHAR) + " Records updated into SNPChromosomeCount07");
            		System.out.println(StringUtility.pad(intSNPChromosomeCount08, 8, PAD_CHAR) + " Records updated into SNPChromosomeCount08");
            		System.out.println(StringUtility.pad(intSNPChromosomeCount09, 8, PAD_CHAR) + " Records updated into SNPChromosomeCount09");
            		System.out.println(StringUtility.pad(intSNPChromosomeCount10, 8, PAD_CHAR) + " Records updated into SNPChromosomeCount10");
            		System.out.println(StringUtility.pad(intSNPChromosomeCount11, 8, PAD_CHAR) + " Records updated into SNPChromosomeCount11");
            		System.out.println(StringUtility.pad(intSNPChromosomeCount12, 8, PAD_CHAR) + " Records updated into SNPChromosomeCount12");
            		System.out.println(StringUtility.pad(intSNPChromosomeCount13, 8, PAD_CHAR) + " Records updated into SNPChromosomeCount13");
            		System.out.println(StringUtility.pad(intSNPChromosomeCount14, 8, PAD_CHAR) + " Records updated into SNPChromosomeCount14");
            		System.out.println(StringUtility.pad(intSNPChromosomeCount15, 8, PAD_CHAR) + " Records updated into SNPChromosomeCount15");
            		System.out.println(StringUtility.pad(intSNPChromosomeCount16, 8, PAD_CHAR) + " Records updated into SNPChromosomeCount16");
            		System.out.println(StringUtility.pad(intSNPChromosomeCount17, 8, PAD_CHAR) + " Records updated into SNPChromosomeCount17");
            		System.out.println(StringUtility.pad(intSNPChromosomeCount18, 8, PAD_CHAR) + " Records updated into SNPChromosomeCount18");
            		System.out.println(StringUtility.pad(intSNPChromosomeCount19, 8, PAD_CHAR) + " Records updated into SNPChromosomeCount19");
            		System.out.println(StringUtility.pad(intSNPChromosomeCount20, 8, PAD_CHAR) + " Records updated into SNPChromosomeCount20");
            		System.out.println(StringUtility.pad(intSNPChromosomeCount21, 8, PAD_CHAR) + " Records updated into SNPChromosomeCount21");
            		System.out.println(StringUtility.pad(intSNPChromosomeCount22, 8, PAD_CHAR) + " Records updated into SNPChromosomeCount22");
            		System.out.println(StringUtility.pad(intSNPChromosomeCount23, 8, PAD_CHAR) + " Records updated into SNPChromosomeCount23");
            		System.out.println(StringUtility.pad(intSNPChromosomeCount24, 8, PAD_CHAR) + " Records updated into SNPChromosomeCount24");
            		System.out.println(StringUtility.pad(intSNPChromosomeCount25, 8, PAD_CHAR) + " Records updated into SNPChromosomeCount25");
            		System.out.println(StringUtility.pad(intSNPChromosomeCount26, 8, PAD_CHAR) + " Records updated into SNPChromosomeCount26");
            		System.out.println(StringUtility.pad(intSNPChromosomeCount27, 8, PAD_CHAR) + " Records updated into SNPChromosomeCount27");
            		System.out.println(StringUtility.pad(intSNPChromosomeCount28, 8, PAD_CHAR) + " Records updated into SNPChromosomeCount28");
            		System.out.println(StringUtility.pad(intSNPChromosomeCount32, 8, PAD_CHAR) + " Records updated into SNPChromosomeCount32");
            		System.out.println(StringUtility.pad(intSNPChromosomeCountLGE22C19W28_E50C23, 8, PAD_CHAR) + " Records updated into SNPChromosomeCountLGE22C19W28_E50C23");
            		System.out.println(StringUtility.pad(intSNPChromosomeCountLGE64, 8, PAD_CHAR) + " Records updated into SNPChromosomeCountLGE64");
            		System.out.println(StringUtility.pad(intSNPChromosomeCountW, 8, PAD_CHAR) + " Records updated into SNPChromosomeCountW");
            		System.out.println(StringUtility.pad(intSNPChromosomeCountZ, 8, PAD_CHAR) + " Records updated into SNPChromosomeCountZ");

        			System.out.println(StringUtility.pad(totalRecordCount, 8, PAD_CHAR) + " updated inserted from " + totalFileCount + " files in Directory " + directory );
                }
                else {
                	
                    System.out.println("Directory " + directory + " DOES NOT exist!!!");
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
