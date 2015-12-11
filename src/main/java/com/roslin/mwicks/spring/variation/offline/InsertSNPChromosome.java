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

import com.roslin.mwicks.spring.variation.routines.ConvertFiletoSNPChromosomeList;

import com.roslin.mwicks.spring.variation.model.snpchromosome.SNPChromosome;
import com.roslin.mwicks.spring.variation.model.snpchromosome.SNPChromosome1;
import com.roslin.mwicks.spring.variation.model.snpchromosome.SNPChromosome3;
import com.roslin.mwicks.spring.variation.model.snpchromosome.SNPChromosome4;
import com.roslin.mwicks.spring.variation.model.snpchromosome.SNPChromosome5;
import com.roslin.mwicks.spring.variation.model.snpchromosome.SNPChromosome6;
import com.roslin.mwicks.spring.variation.model.snpchromosome.SNPChromosome7;
import com.roslin.mwicks.spring.variation.model.snpchromosome.SNPChromosome8;
import com.roslin.mwicks.spring.variation.model.snpchromosome.SNPChromosome9;
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
import com.roslin.mwicks.spring.variation.model.snpchromosome.SNPChromosomeW;
import com.roslin.mwicks.spring.variation.model.snpchromosome.SNPChromosomeZ;
import com.roslin.mwicks.spring.variation.model.snpchromosome.SNPChromosomeLGE22C19W28_E50C23;
import com.roslin.mwicks.spring.variation.model.snpchromosome.SNPChromosomeLGE64;

import com.roslin.mwicks.spring.variation.serviceinterface.snpchromosome.ServiceSNPChromosome1;
import com.roslin.mwicks.spring.variation.serviceinterface.snpchromosome.ServiceSNPChromosome10;
import com.roslin.mwicks.spring.variation.serviceinterface.snpchromosome.ServiceSNPChromosome11;
import com.roslin.mwicks.spring.variation.serviceinterface.snpchromosome.ServiceSNPChromosome12;
import com.roslin.mwicks.spring.variation.serviceinterface.snpchromosome.ServiceSNPChromosome13;
import com.roslin.mwicks.spring.variation.serviceinterface.snpchromosome.ServiceSNPChromosome14;
import com.roslin.mwicks.spring.variation.serviceinterface.snpchromosome.ServiceSNPChromosome15;
import com.roslin.mwicks.spring.variation.serviceinterface.snpchromosome.ServiceSNPChromosome16;
import com.roslin.mwicks.spring.variation.serviceinterface.snpchromosome.ServiceSNPChromosome17;
import com.roslin.mwicks.spring.variation.serviceinterface.snpchromosome.ServiceSNPChromosome3;
import com.roslin.mwicks.spring.variation.serviceinterface.snpchromosome.ServiceSNPChromosome4;
import com.roslin.mwicks.spring.variation.serviceinterface.snpchromosome.ServiceSNPChromosome5;
import com.roslin.mwicks.spring.variation.serviceinterface.snpchromosome.ServiceSNPChromosome6;
import com.roslin.mwicks.spring.variation.serviceinterface.snpchromosome.ServiceSNPChromosome7;
import com.roslin.mwicks.spring.variation.serviceinterface.snpchromosome.ServiceSNPChromosome8;
import com.roslin.mwicks.spring.variation.serviceinterface.snpchromosome.ServiceSNPChromosome9;
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


public class InsertSNPChromosome {

	// Constants ----------------------------------------------------------------------------------
    private static final String MSGLEVEL = "*";
	private static final String STOP = "*";
	
	private static final char PAD_CHAR = ' ';

    private static final String PROPERTY_NAME_HIBERNATE_JDBC_BATCH_SIZE = "hibernate.jdbc.batch_size";
	
    public static final Logger LOG = LoggerFactory.getLogger(InsertSNPChromosome.class);

    @PersistenceContext
    private EntityManager entityManager;
     

    public static void main(String args[]){  

    	try {

        	LOG.trace("InsertSNPChromosome - main");

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
                
        		String directory = args[0];
        		
                File dir = new File(directory);

                if ( dir.exists() ) {
                	
            		File[] filesFile = FileUtil.listAllFilesInDirectory(directory);
            		
            		int totalRecordCount = 0;
            		int totalFileCount = 0;
            		
                    int snpchromosome1Total = 0;
                    int snpchromosome3Total = 0;
                    int snpchromosome4Total = 0;
                    int snpchromosome5Total = 0;
                    int snpchromosome6Total = 0;
                    int snpchromosome7Total = 0;
                    int snpchromosome8Total = 0;
                    int snpchromosome9Total = 0;
                    int snpchromosome10Total = 0;
                    int snpchromosome11Total = 0;
                    int snpchromosome12Total = 0;
                    int snpchromosome13Total = 0;
                    int snpchromosome14Total = 0;
                    int snpchromosome15Total = 0;
                    int snpchromosome16Total = 0;
                    int snpchromosome17Total = 0;
                    int snpchromosome18Total = 0;
                    int snpchromosome19Total = 0;
                    int snpchromosome20Total = 0;
                    int snpchromosome21Total = 0;
                    int snpchromosome22Total = 0;
                    int snpchromosome23Total = 0;
                    int snpchromosome24Total = 0;
                    int snpchromosome25Total = 0;
                    int snpchromosome26Total = 0;
                    int snpchromosome27Total = 0;
                    int snpchromosome28Total = 0;
                    int snpchromosome32Total = 0;
                    int snpchromosomeWTotal = 0;
                    int snpchromosomeZTotal = 0;
                    int snpchromosomeLGE22C19W28_E50C23Total = 0;
                    int snpchromosomeLGE64Total = 0;

            		for ( File file : filesFile ) {
            			
            			if ( !file.getName().equals(".DS_Store") ) {
            				
                			totalFileCount++;

                            List<SNPChromosome> snpchromosomeList = ConvertFiletoSNPChromosomeList.run(file);
                            
                            List<SNPChromosome1> snpchromosome1List = new ArrayList<SNPChromosome1>();
                            List<SNPChromosome3> snpchromosome3List = new ArrayList<SNPChromosome3>();
                            List<SNPChromosome4> snpchromosome4List = new ArrayList<SNPChromosome4>();
                            List<SNPChromosome5> snpchromosome5List = new ArrayList<SNPChromosome5>();
                            List<SNPChromosome6> snpchromosome6List = new ArrayList<SNPChromosome6>();
                            List<SNPChromosome7> snpchromosome7List = new ArrayList<SNPChromosome7>();
                            List<SNPChromosome8> snpchromosome8List = new ArrayList<SNPChromosome8>();
                            List<SNPChromosome9> snpchromosome9List = new ArrayList<SNPChromosome9>();
                            List<SNPChromosome10> snpchromosome10List = new ArrayList<SNPChromosome10>();
                            List<SNPChromosome11> snpchromosome11List = new ArrayList<SNPChromosome11>();
                            List<SNPChromosome12> snpchromosome12List = new ArrayList<SNPChromosome12>();
                            List<SNPChromosome13> snpchromosome13List = new ArrayList<SNPChromosome13>();
                            List<SNPChromosome14> snpchromosome14List = new ArrayList<SNPChromosome14>();
                            List<SNPChromosome15> snpchromosome15List = new ArrayList<SNPChromosome15>();
                            List<SNPChromosome16> snpchromosome16List = new ArrayList<SNPChromosome16>();
                            List<SNPChromosome17> snpchromosome17List = new ArrayList<SNPChromosome17>();
                            List<SNPChromosome18> snpchromosome18List = new ArrayList<SNPChromosome18>();
                            List<SNPChromosome19> snpchromosome19List = new ArrayList<SNPChromosome19>();
                            List<SNPChromosome20> snpchromosome20List = new ArrayList<SNPChromosome20>();
                            List<SNPChromosome21> snpchromosome21List = new ArrayList<SNPChromosome21>();
                            List<SNPChromosome22> snpchromosome22List = new ArrayList<SNPChromosome22>();
                            List<SNPChromosome23> snpchromosome23List = new ArrayList<SNPChromosome23>();
                            List<SNPChromosome24> snpchromosome24List = new ArrayList<SNPChromosome24>();
                            List<SNPChromosome25> snpchromosome25List = new ArrayList<SNPChromosome25>();
                            List<SNPChromosome26> snpchromosome26List = new ArrayList<SNPChromosome26>();
                            List<SNPChromosome27> snpchromosome27List = new ArrayList<SNPChromosome27>();
                            List<SNPChromosome28> snpchromosome28List = new ArrayList<SNPChromosome28>();
                            List<SNPChromosome32> snpchromosome32List = new ArrayList<SNPChromosome32>();
                            List<SNPChromosomeW> snpchromosomeWList = new ArrayList<SNPChromosomeW>();
                            List<SNPChromosomeZ> snpchromosomeZList = new ArrayList<SNPChromosomeZ>();
                            List<SNPChromosomeLGE22C19W28_E50C23> snpchromosomeLGE22C19W28_E50C23List = new ArrayList<SNPChromosomeLGE22C19W28_E50C23>();
                            List<SNPChromosomeLGE64> snpchromosomeLGE64List = new ArrayList<SNPChromosomeLGE64>();

                            ServiceSNPChromosome1 serviceSNPChromosome1 = (ServiceSNPChromosome1) applicationContext.getBean(ServiceSNPChromosome1.class);
                            ServiceSNPChromosome3 serviceSNPChromosome3 = (ServiceSNPChromosome3) applicationContext.getBean(ServiceSNPChromosome3.class);
                            ServiceSNPChromosome4 serviceSNPChromosome4 = (ServiceSNPChromosome4) applicationContext.getBean(ServiceSNPChromosome4.class);
                            ServiceSNPChromosome5 serviceSNPChromosome5 = (ServiceSNPChromosome5) applicationContext.getBean(ServiceSNPChromosome5.class);
                            ServiceSNPChromosome6 serviceSNPChromosome6 = (ServiceSNPChromosome6) applicationContext.getBean(ServiceSNPChromosome6.class);
                            ServiceSNPChromosome7 serviceSNPChromosome7 = (ServiceSNPChromosome7) applicationContext.getBean(ServiceSNPChromosome7.class);
                            ServiceSNPChromosome8 serviceSNPChromosome8 = (ServiceSNPChromosome8) applicationContext.getBean(ServiceSNPChromosome8.class);
                            ServiceSNPChromosome9 serviceSNPChromosome9 = (ServiceSNPChromosome9) applicationContext.getBean(ServiceSNPChromosome9.class);
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
                            ServiceSNPChromosomeLGE22C19W28_E50C23 serviceSNPChromosomeLGE22C19W28_E50C23 = (ServiceSNPChromosomeLGE22C19W28_E50C23) applicationContext.getBean(ServiceSNPChromosomeLGE22C19W28_E50C23.class);
                            ServiceSNPChromosomeLGE64 serviceSNPChromosomeLGE64 = (ServiceSNPChromosomeLGE64) applicationContext.getBean(ServiceSNPChromosomeLGE64.class);
                            
                            totalRecordCount = totalRecordCount +  snpchromosomeList.size();
                            
                			System.out.println(StringUtility.pad(totalFileCount, 4, PAD_CHAR) + " : Directory : " + directory + " : " + file.getName() + " : records : " + StringUtility.pad(snpchromosomeList.size(), 8, PAD_CHAR));

                            Iterator<SNPChromosome> iteratorsnpchromosomeList = snpchromosomeList.iterator();
                	        
                	     	while (iteratorsnpchromosomeList.hasNext()) {
                	    		
                	     		SNPChromosome snpchromosome = iteratorsnpchromosomeList.next();
                	     		
                	     		if ( snpchromosome.isSearchChromosome1() ){
                	     			SNPChromosome1 snpchromosome1 = snpchromosome.convertTo1();
                	     			snpchromosome1List.add(snpchromosome1);
                	     		}
                	     		if ( snpchromosome.isSearchChromosome3() ){
                	     			SNPChromosome3 snpchromosome3 = snpchromosome.convertTo3();
                	     			snpchromosome3List.add(snpchromosome3);
                	     		}
                	     		if ( snpchromosome.isSearchChromosome4() ){
                	     			SNPChromosome4 snpchromosome4 = snpchromosome.convertTo4();
                	     			snpchromosome4List.add(snpchromosome4);
                	     		}
                	     		if ( snpchromosome.isSearchChromosome5() ){
                	     			SNPChromosome5 snpchromosome5 = snpchromosome.convertTo5();
                	     			snpchromosome5List.add(snpchromosome5);
                	     		}
                	     		if ( snpchromosome.isSearchChromosome6() ){
                	     			SNPChromosome6 snpchromosome6 = snpchromosome.convertTo6();
                	     			snpchromosome6List.add(snpchromosome6);
                	     		}
                	     		if ( snpchromosome.isSearchChromosome7() ){
                	     			SNPChromosome7 snpchromosome7 = snpchromosome.convertTo7();
                	     			snpchromosome7List.add(snpchromosome7);
                	     		}
                	     		if ( snpchromosome.isSearchChromosome8() ){
                	     			SNPChromosome8 snpchromosome8 = snpchromosome.convertTo8();
                	     			snpchromosome8List.add(snpchromosome8);
                	     		}
                	     		if ( snpchromosome.isSearchChromosome9() ){
                	     			SNPChromosome9 snpchromosome9 = snpchromosome.convertTo9();
                	     			snpchromosome9List.add(snpchromosome9);
                	     		}
                	     		if ( snpchromosome.isSearchChromosome10() ){
                	     			SNPChromosome10 snpchromosome10 = snpchromosome.convertTo10();
                	     			snpchromosome10List.add(snpchromosome10);
                	     		}
                	     		if ( snpchromosome.isSearchChromosome11() ){
                	     			SNPChromosome11 snpchromosome11 = snpchromosome.convertTo11();
                	     			snpchromosome11List.add(snpchromosome11);
                	     		}
                	     		if ( snpchromosome.isSearchChromosome12() ){
                	     			SNPChromosome12 snpchromosome12 = snpchromosome.convertTo12();
                	     			snpchromosome12List.add(snpchromosome12);
                	     		}
                	     		if ( snpchromosome.isSearchChromosome13() ){
                	     			SNPChromosome13 snpchromosome13 = snpchromosome.convertTo13();
                	     			snpchromosome13List.add(snpchromosome13);
                	     		}
                	     		if ( snpchromosome.isSearchChromosome14() ){
                	     			SNPChromosome14 snpchromosome14 = snpchromosome.convertTo14();
                	     			snpchromosome14List.add(snpchromosome14);
                	     		}
                	     		if ( snpchromosome.isSearchChromosome15() ){
                	     			SNPChromosome15 snpchromosome15 = snpchromosome.convertTo15();
                	     			snpchromosome15List.add(snpchromosome15);
                	     		}
                	     		if ( snpchromosome.isSearchChromosome16() ){
                	     			SNPChromosome16 snpchromosome16 = snpchromosome.convertTo16();
                	     			snpchromosome16List.add(snpchromosome16);
                	     		}
                	     		if ( snpchromosome.isSearchChromosome17() ){
                	     			SNPChromosome17 snpchromosome17 = snpchromosome.convertTo17();
                	     			snpchromosome17List.add(snpchromosome17);
                	     		}
                	     		if ( snpchromosome.isSearchChromosome18() ){
                	     			SNPChromosome18 snpchromosome18 = snpchromosome.convertTo18();
                	     			snpchromosome18List.add(snpchromosome18);
                	     		}
                	     		if ( snpchromosome.isSearchChromosome19() ){
                	     			SNPChromosome19 snpchromosome19 = snpchromosome.convertTo19();
                	     			snpchromosome19List.add(snpchromosome19);
                	     		}
                	     		if ( snpchromosome.isSearchChromosome20() ){
                	     			SNPChromosome20 snpchromosome20 = snpchromosome.convertTo20();
                	     			snpchromosome20List.add(snpchromosome20);
                	     		}
                	     		if ( snpchromosome.isSearchChromosome21() ){
                	     			SNPChromosome21 snpchromosome21 = snpchromosome.convertTo21();
                	     			snpchromosome21List.add(snpchromosome21);
                	     		}
                	     		if ( snpchromosome.isSearchChromosome22() ){
                	     			SNPChromosome22 snpchromosome22 = snpchromosome.convertTo22();
                	     			snpchromosome22List.add(snpchromosome22);
                	     		}
                	     		if ( snpchromosome.isSearchChromosome23() ){
                	     			SNPChromosome23 snpchromosome23 = snpchromosome.convertTo23();
                	     			snpchromosome23List.add(snpchromosome23);
                	     		}
                	     		if ( snpchromosome.isSearchChromosome24() ){
                	     			SNPChromosome24 snpchromosome24 = snpchromosome.convertTo24();
                	     			snpchromosome24List.add(snpchromosome24);
                	     		}
                	     		if ( snpchromosome.isSearchChromosome25() ){
                	     			SNPChromosome25 snpchromosome25 = snpchromosome.convertTo25();
                	     			snpchromosome25List.add(snpchromosome25);
                	     		}
                	     		if ( snpchromosome.isSearchChromosome26() ){
                	     			SNPChromosome26 snpchromosome26 = snpchromosome.convertTo26();
                	     			snpchromosome26List.add(snpchromosome26);
                	     		}
                	     		if ( snpchromosome.isSearchChromosome27() ){
                	     			SNPChromosome27 snpchromosome27 = snpchromosome.convertTo27();
                	     			snpchromosome27List.add(snpchromosome27);
                	     		}
                	     		if ( snpchromosome.isSearchChromosome28() ){
                	     			SNPChromosome28 snpchromosome28 = snpchromosome.convertTo28();
                	     			snpchromosome28List.add(snpchromosome28);
                	     		}
                	     		if ( snpchromosome.isSearchChromosome32() ){
                	     			SNPChromosome32 snpchromosome32 = snpchromosome.convertTo32();
                	     			snpchromosome32List.add(snpchromosome32);
                	     		}
                	     		if ( snpchromosome.isSearchChromosomeW() ){
                	     			SNPChromosomeW snpchromosomeW = snpchromosome.convertToW();
                	     			snpchromosomeWList.add(snpchromosomeW);
                	     		}
                	     		if ( snpchromosome.isSearchChromosomeZ() ){
                	     			SNPChromosomeZ snpchromosomeZ = snpchromosome.convertToZ();
                	     			snpchromosomeZList.add(snpchromosomeZ);
                	     		}
                	     		if ( snpchromosome.isSearchChromosomeLGE64() ){
                	     			SNPChromosomeLGE64 snpchromosomeLGE64 = snpchromosome.convertToLGE64();
                	     			snpchromosomeLGE64List.add(snpchromosomeLGE64);
                	     		}
                	     		if ( snpchromosome.isSearchChromosomeLGE22C19W28_E50C23() ){
                	     			SNPChromosomeLGE22C19W28_E50C23 snpchromosomeLGE22C19W28_E50C23 = snpchromosome.convertToLGE22C19W28_E50C23();
                	     			snpchromosomeLGE22C19W28_E50C23List.add(snpchromosomeLGE22C19W28_E50C23);
                	     		}
                	     	}
                	     	
                	     	snpchromosome1Total = snpchromosome1Total + snpchromosome1List.size();
                	     	snpchromosome3Total = snpchromosome3Total + snpchromosome3List.size();
                	     	snpchromosome4Total = snpchromosome4Total + snpchromosome4List.size();
                	     	snpchromosome5Total = snpchromosome5Total + snpchromosome5List.size();
                	     	snpchromosome6Total = snpchromosome6Total + snpchromosome6List.size();
                	     	snpchromosome7Total = snpchromosome7Total + snpchromosome7List.size();
                	     	snpchromosome8Total = snpchromosome8Total + snpchromosome8List.size();
                	     	snpchromosome9Total = snpchromosome9Total + snpchromosome9List.size();
                	     	snpchromosome10Total = snpchromosome10Total + snpchromosome10List.size();
                	     	snpchromosome11Total = snpchromosome11Total + snpchromosome11List.size();
                	     	snpchromosome12Total = snpchromosome12Total + snpchromosome12List.size();
                	     	snpchromosome13Total = snpchromosome13Total + snpchromosome13List.size();
                	     	snpchromosome14Total = snpchromosome14Total + snpchromosome14List.size();
                	     	snpchromosome15Total = snpchromosome15Total + snpchromosome15List.size();
                	     	snpchromosome16Total = snpchromosome16Total + snpchromosome16List.size();
                	     	snpchromosome17Total = snpchromosome17Total + snpchromosome17List.size();
                	     	snpchromosome18Total = snpchromosome18Total + snpchromosome18List.size();
                	     	snpchromosome19Total = snpchromosome19Total + snpchromosome19List.size();
                	     	snpchromosome20Total = snpchromosome20Total + snpchromosome20List.size();
                	     	snpchromosome21Total = snpchromosome21Total + snpchromosome21List.size();
                	     	snpchromosome22Total = snpchromosome22Total + snpchromosome22List.size();
                	     	snpchromosome23Total = snpchromosome23Total + snpchromosome23List.size();
                	     	snpchromosome24Total = snpchromosome24Total + snpchromosome24List.size();
                	     	snpchromosome25Total = snpchromosome25Total + snpchromosome25List.size();
                	     	snpchromosome26Total = snpchromosome26Total + snpchromosome26List.size();
                	     	snpchromosome27Total = snpchromosome28Total + snpchromosome27List.size();
                	     	snpchromosome28Total = snpchromosome28Total + snpchromosome28List.size();
                	     	snpchromosome32Total = snpchromosome32Total + snpchromosome32List.size();
                	     	snpchromosomeWTotal = snpchromosomeWTotal + snpchromosomeWList.size();
                	     	snpchromosomeZTotal = snpchromosomeZTotal + snpchromosomeZList.size();
                	     	snpchromosomeLGE22C19W28_E50C23Total = snpchromosomeLGE22C19W28_E50C23Total + snpchromosomeLGE22C19W28_E50C23List.size();
                	     	snpchromosomeLGE64Total = snpchromosomeLGE64Total + snpchromosomeLGE64List.size();

                	     	serviceSNPChromosome1.bulkSave(intBatchSize, snpchromosome1List);
                	     	serviceSNPChromosome3.bulkSave(intBatchSize, snpchromosome3List);
                	     	serviceSNPChromosome4.bulkSave(intBatchSize, snpchromosome4List);
                	     	serviceSNPChromosome5.bulkSave(intBatchSize, snpchromosome5List);
                	     	serviceSNPChromosome6.bulkSave(intBatchSize, snpchromosome6List);
                	     	serviceSNPChromosome7.bulkSave(intBatchSize, snpchromosome7List);
                	     	serviceSNPChromosome8.bulkSave(intBatchSize, snpchromosome8List);
                	     	serviceSNPChromosome9.bulkSave(intBatchSize, snpchromosome9List);
                	     	serviceSNPChromosome10.bulkSave(intBatchSize, snpchromosome10List);
                	     	serviceSNPChromosome11.bulkSave(intBatchSize, snpchromosome11List);
                	     	serviceSNPChromosome12.bulkSave(intBatchSize, snpchromosome12List);
                	     	serviceSNPChromosome13.bulkSave(intBatchSize, snpchromosome13List);
                	     	serviceSNPChromosome14.bulkSave(intBatchSize, snpchromosome14List);
                	     	serviceSNPChromosome15.bulkSave(intBatchSize, snpchromosome15List);
                	     	serviceSNPChromosome16.bulkSave(intBatchSize, snpchromosome16List);
                	     	serviceSNPChromosome17.bulkSave(intBatchSize, snpchromosome17List);
                	     	serviceSNPChromosome18.bulkSave(intBatchSize, snpchromosome18List);
                	     	serviceSNPChromosome19.bulkSave(intBatchSize, snpchromosome19List);
                	     	serviceSNPChromosome20.bulkSave(intBatchSize, snpchromosome20List);
                	     	serviceSNPChromosome21.bulkSave(intBatchSize, snpchromosome21List);
                	     	serviceSNPChromosome22.bulkSave(intBatchSize, snpchromosome22List);
                	     	serviceSNPChromosome23.bulkSave(intBatchSize, snpchromosome23List);
                	     	serviceSNPChromosome24.bulkSave(intBatchSize, snpchromosome24List);
                	     	serviceSNPChromosome25.bulkSave(intBatchSize, snpchromosome25List);
                	     	serviceSNPChromosome26.bulkSave(intBatchSize, snpchromosome26List);
                	     	serviceSNPChromosome27.bulkSave(intBatchSize, snpchromosome27List);
                	     	serviceSNPChromosome28.bulkSave(intBatchSize, snpchromosome28List);
                	     	serviceSNPChromosome32.bulkSave(intBatchSize, snpchromosome32List);
                	     	serviceSNPChromosomeW.bulkSave(intBatchSize, snpchromosomeWList);
                	     	serviceSNPChromosomeZ.bulkSave(intBatchSize, snpchromosomeZList);
                	     	serviceSNPChromosomeLGE22C19W28_E50C23.bulkSave(intBatchSize, snpchromosomeLGE22C19W28_E50C23List);
                	     	serviceSNPChromosomeLGE64.bulkSave(intBatchSize, snpchromosomeLGE64List);
            			}
            		}
            		
            		System.out.println(StringUtility.pad(snpchromosome1Total, 8, PAD_CHAR) + " Records inserted into SNP_CHROMOSOME_1");
            		System.out.println(StringUtility.pad(snpchromosome3Total, 8, PAD_CHAR) + " Records inserted into SNP_CHROMOSOME_3");
            		System.out.println(StringUtility.pad(snpchromosome4Total, 8, PAD_CHAR) + " Records inserted into SNP_CHROMOSOME_4");
            		System.out.println(StringUtility.pad(snpchromosome5Total, 8, PAD_CHAR) + " Records inserted into SNP_CHROMOSOME_5");
            		System.out.println(StringUtility.pad(snpchromosome6Total, 8, PAD_CHAR) + " Records inserted into SNP_CHROMOSOME_6");
            		System.out.println(StringUtility.pad(snpchromosome7Total, 8, PAD_CHAR) + " Records inserted into SNP_CHROMOSOME_7");
            		System.out.println(StringUtility.pad(snpchromosome8Total, 8, PAD_CHAR) + " Records inserted into SNP_CHROMOSOME_8");
            		System.out.println(StringUtility.pad(snpchromosome9Total, 8, PAD_CHAR) + " Records inserted into SNP_CHROMOSOME_9");
            		System.out.println(StringUtility.pad(snpchromosome10Total, 8, PAD_CHAR) + " Records inserted into SNP_CHROMOSOME_10");
            		System.out.println(StringUtility.pad(snpchromosome11Total, 8, PAD_CHAR) + " Records inserted into SNP_CHROMOSOME_11");
            		System.out.println(StringUtility.pad(snpchromosome12Total, 8, PAD_CHAR) + " Records inserted into SNP_CHROMOSOME_12");
            		System.out.println(StringUtility.pad(snpchromosome13Total, 8, PAD_CHAR) + " Records inserted into SNP_CHROMOSOME_13");
            		System.out.println(StringUtility.pad(snpchromosome14Total, 8, PAD_CHAR) + " Records inserted into SNP_CHROMOSOME_14");
            		System.out.println(StringUtility.pad(snpchromosome15Total, 8, PAD_CHAR) + " Records inserted into SNP_CHROMOSOME_15");
            		System.out.println(StringUtility.pad(snpchromosome16Total, 8, PAD_CHAR) + " Records inserted into SNP_CHROMOSOME_16");
            		System.out.println(StringUtility.pad(snpchromosome17Total, 8, PAD_CHAR) + " Records inserted into SNP_CHROMOSOME_17");
            		System.out.println(StringUtility.pad(snpchromosome18Total, 8, PAD_CHAR) + " Records inserted into SNP_CHROMOSOME_18");
            		System.out.println(StringUtility.pad(snpchromosome19Total, 8, PAD_CHAR) + " Records inserted into SNP_CHROMOSOME_19");
            		System.out.println(StringUtility.pad(snpchromosome20Total, 8, PAD_CHAR) + " Records inserted into SNP_CHROMOSOME_20");
            		System.out.println(StringUtility.pad(snpchromosome21Total, 8, PAD_CHAR) + " Records inserted into SNP_CHROMOSOME_21");
            		System.out.println(StringUtility.pad(snpchromosome22Total, 8, PAD_CHAR) + " Records inserted into SNP_CHROMOSOME_22");
            		System.out.println(StringUtility.pad(snpchromosome23Total, 8, PAD_CHAR) + " Records inserted into SNP_CHROMOSOME_23");
            		System.out.println(StringUtility.pad(snpchromosome24Total, 8, PAD_CHAR) + " Records inserted into SNP_CHROMOSOME_24");
            		System.out.println(StringUtility.pad(snpchromosome25Total, 8, PAD_CHAR) + " Records inserted into SNP_CHROMOSOME_25");
            		System.out.println(StringUtility.pad(snpchromosome26Total, 8, PAD_CHAR) + " Records inserted into SNP_CHROMOSOME_26");
            		System.out.println(StringUtility.pad(snpchromosome27Total, 8, PAD_CHAR) + " Records inserted into SNP_CHROMOSOME_27");
            		System.out.println(StringUtility.pad(snpchromosome28Total, 8, PAD_CHAR) + " Records inserted into SNP_CHROMOSOME_28");
            		System.out.println(StringUtility.pad(snpchromosome32Total, 8, PAD_CHAR) + " Records inserted into SNP_CHROMOSOME_32");
            		System.out.println(StringUtility.pad(snpchromosomeWTotal, 8, PAD_CHAR) + " Records inserted into SNP_CHROMOSOME_W");
            		System.out.println(StringUtility.pad(snpchromosomeZTotal, 8, PAD_CHAR) + " Records inserted into SNP_CHROMOSOME_Z");
            		System.out.println(StringUtility.pad(snpchromosomeLGE22C19W28_E50C23Total, 8, PAD_CHAR) + " Records inserted into SNP_CHROMOSOME_LGE22C19W28_E50C23");
            		System.out.println(StringUtility.pad(snpchromosomeLGE64Total, 8, PAD_CHAR) + " Records inserted into SNP_CHROMOSOME_LGE64");

        			System.out.println(StringUtility.pad(totalRecordCount, 8, PAD_CHAR) + " Records inserted from " + totalFileCount + " files in Directory " + directory );
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
