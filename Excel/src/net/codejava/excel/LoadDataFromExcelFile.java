package net.codejava.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class LoadDataFromExcelFile {
	
    
    //ALL ARRAYS WITH ALL DATA FROM EXCEL FILE.
    //ALL ARE CORRECTLY LOADED
        public static ArrayList<Integer> rcn = new ArrayList<Integer>();//0
        public static ArrayList<Integer> id = new ArrayList<Integer>();
        public static ArrayList<String> acronym = new ArrayList<String>();
        public static ArrayList<String> status = new ArrayList<String>();
        public static ArrayList<String> programme = new ArrayList<String>();
        public static ArrayList<String> topics = new ArrayList<String>();
        public static ArrayList<String> frameworkProgramme = new ArrayList<String>();
        public static ArrayList<String> title = new ArrayList<String>();
        public static ArrayList<String> startDate = new ArrayList<String>();
        public static ArrayList<String> endDate = new ArrayList<String>();
        public static ArrayList<String> projectUrl = new ArrayList<String>();
        public static ArrayList<String> objective = new ArrayList<String>();
        public static ArrayList<Float> totalCost = new ArrayList<Float>();
        public static ArrayList<Float> ecMaxContribution = new ArrayList<Float>();
        public static ArrayList<String> call = new ArrayList<String>();
        public static ArrayList<String> fundingScheme = new ArrayList<String>();
        public static ArrayList<String> coordinator = new ArrayList<String>();
        public static ArrayList<String> coordinatorCountry = new ArrayList<String>();
        public static ArrayList<String> participants = new ArrayList<String>();
        public static ArrayList<String> participantCountries = new ArrayList<String>();
        public static ArrayList<String> subjects = new ArrayList<String>();//19
        
        //thoes are needed to cast String to int and float data from excel. Need to cast static in static functions...
         public static int rcn_int;
         public static int id_int;
         public static float totalCost_int;
         public static float ecMaxContribution_int;
         
         //Specified Numbers of each Country From Excel File
         public static int CountryIdNumber[]= new int[50];
         //TAG of Country
         public static String[] CountryId={
             "AI",
             "AM",
             "AT",
             "BA",
             "BE",
             "BG",
             "CH",
             "CL",
             "CY",
             "CZ",
             "DE",
             "DK",
             "EE",
             "EL",
             "ES",
             "FI",
             "FO",
             "FR",
             "GE",
             "GL",
             "HR",
             "HU",
             "IE",
             "IL",
             "IS",
             "IT",
             "KE",
             "LT",
             "LU",
             "LV",
             "MD",
             "ME",
             "MK",
             "MT",
             "NL",
             "NO",
             "PL",
             "PT",
             "RO",
             "RS",
             "SE",
             "SI",
             "SK",
             "TN",
             "TR",
             "UA",
             "UK",
             "US",
             "UY",
             "ZA"};
            //Numbers of specified TAG of FundingScheme
          public static int FundingSchemeIdNumber[]=new int[58];
          //TAGS of FundingScheme
          public static String[] FundingSchemeId={
              "BBI-CSA",
              "BBI-IA-DEMO",
              "BBI-IA-FLAG",
              "BBI-RIA",
              "COFUND-EJP",
              "COFUND-PCP",
              "COFUND-PPI",
              "CS2-CSA",
              "CS2-IA",
              "CS2-RIA",
              "CSA",
              "CSA-LS",
              "ECSEL-CSA",
              "ECSEL-IA",
              "ECSEL-RIA",
              "ERA-NET-Cofund",
              "ERC-ADG",
              "ERC-COG",
              "ERC-LVG",
              "ERC-POC",
              "ERC-POC-LS",
              "ERC-STG",
              "ERC-SyG",
              "FCH2-CSA",
              "FCH2-IA",
              "FCH2-RIA",
              "H2020-EEN-SGA",
              "IA",
              "IA-LS",
              "IMI2-CSA",
              "IMI2-RIA",
              "MSCA-COFUND-DP",
              "MSCA-COFUND-FP",
              "MSCA-IF-EF-CAR",
              "MSCA-IF-EF-RI",
              "MSCA-IF-EF-SE",
              "MSCA-IF-EF-ST",
              "MSCA-IF-GF",
              "MSCA-ITN-EID",
              "MSCA-ITN-EJD",
              "MSCA-ITN-ETN",
              "MSCA-RISE",
              "PCP",
              "PPI",
              "RIA",
              "RIA-LS",
              "SESAR-CSA",
              "SESAR-IA",
              "SESAR-RIA",
              "SGA-CSA",
              "SGA-RIA",
              "SME-1",
              "SME-2",
              "Shift2Rail-CSA",
              "Shift2Rail-IA",
              "Shift2Rail-IA-LS",
              "Shift2Rail-RIA",
              "Shift2Rail-RIA-LS"};        
        
          //numbers of specifed Status possibilities. - counting them in function
        public static int SIGNED=0,CLOSED=0,TERMINATED=0;
        
	public static void main(String[] args) throws IOException, InvalidFormatException, InterruptedException, InvocationTargetException {
		
           
            readDataToArrays();
             
            //setting data from arrays into specified containers for charts
            setDataStatus();
            setDataCountryId();
            setDataFundingSchemeId();
         
            //Drawing Charts
            StatusPieChart1.DrawStatusPieChart1();
            CoordinatorCountryBarChartPart1.DrawCoordinatorCountryBarChartPart1();
            CoordinatorCountryBarChartPart2.DrawCoordinatorCountryBarChartPart2();
            FundingSchemeBarChartPart1.DrawFundingSchemeBarChartPart1();
            FundingSchemeBarChartPart2.DrawFundingSchemeBarChartPart2();
            FundingSchemeBarChartPart3.DrawFundingSchemeBarChartPart3();
            
            
            //setting Chart of Status,FundingScheme,CoordinatorCountry columns from Excel File....
	}
        
        
        
        
        
        
        
        public static void readDataToArrays() throws InvalidFormatException
        {
            //location of Excel's file folder
            String excellFolder = "C:\\Users\\mmiit\\Desktop\\New folder\\";
       
        DataFormatter dataFormatter = new DataFormatter();
        
        //open excel file   by adding file name to folder path
        try(InputStream inp = new FileInputStream(excellFolder + "cordis-h2020projects.xlsx"))
        {
             Workbook wb = WorkbookFactory.create(inp);
             
             //get first sheet from excel file
           Sheet sheet = wb.getSheetAt(0);
           
           //loops to reed all columns in all rows and set the value to arrays
           for(int r = sheet.getFirstRowNum()+1;r <= sheet.getLastRowNum();r++)
           {
               Row row = sheet.getRow(r);
               
              for(int c = row.getFirstCellNum(); c < row.getLastCellNum();c++)
               {
                   
                   Cell cell = row.getCell(c);
                   String cellValue1 = dataFormatter.formatCellValue(cell);
                   
                   //setting value of Empty or null to arrays - need it to provide null exception while reading
                    if(cell==null || cellValue1.equals(""))
                    {
                        switch(c)
                        {
                            case 0:
                            {  
                                rcn.add(0);
                                break;
                            }
                            case 1:
                            {
                                id.add(0);
                                break;
                            }
                            case 2:
                            {
                                acronym.add("Empty");
                                break;
                            }
                            case 3:
                            {
                                status.add("Empty");
                                break;
                            }
                            case 4:
                            {
                                programme.add("Empty");
                                break;
                            }
                            case 5:
                            {
                                topics.add("Empty");
                                break;
                            }
                            case 6:
                            {
                               
                                frameworkProgramme.add("Empty");
                                break;
                            }
                            case 7:
                            {
                                
                                title.add("Empty");
                                break;
                            }
                            
                            case 8:
                            {
                                
                                startDate.add("Empty");
                                break;
                            }
                            case 9:
                            {
                                
                                endDate.add("Empty");
                                break;
                            }
                            
                            case 10:
                            {
                                
                                projectUrl.add("Empty");
                                break;
                            }
                            
                            case 11:
                            {
                                
                                objective.add("Empty");
                                break;
                            }
                            
                            case 12:
                            {
                                
                                totalCost.add(0.0F);
                                break;
                            }
                            case 13:
                            {
                                
                                ecMaxContribution.add(0.0F);
                                break;
                            }
   
                            case 14:
                            {
                                call.add("Empty");
                                break;
                            }
                            case 15:
                            {
                                
                                fundingScheme.add("Empty");
                                break;
                            }
                            case 16:
                            {
                                
                                coordinator.add("Empty");
                                break;
                            }
                            case 17:
                            {
                                
                                coordinatorCountry.add("Empty");
                                break;
                            }
                            case 18:
                            {
                                
                                participants.add("Empty");
                                break;
                            }
                            case 19:
                            {
                                
                                participantCountries.add("Empty");
                                break;
                            }
                            case 20:
                            {
                                
                                subjects.add("Empty");
                                break;
                            }
                            
                        }
                    }
                    //reading elements greater then null
                    else
                    {
                        
                        String cellValue = dataFormatter.formatCellValue(cell);
                        Object typedCellValue = ExcelUtils.getTypedValue(cell);
                        //read
                        
                        switch(c)
                        {
                            case 0:
                            {  
                                rcn_int=Integer.parseInt(cellValue);
                                rcn.add(rcn_int );
                                break;
                            }
                            case 1:
                            {
                                id_int=Integer.parseInt(cellValue);
                                id.add(id_int );
                                break;
                            }
                            case 2:
                            {
                                acronym.add(cellValue);
                                break;
                            }
                            case 3:
                            {
                                status.add(cellValue);
                                break;
                            }
                            case 4:
                            {
                                programme.add(cellValue);
                                break;
                            }
                            
                            case 5:
                            {
                                topics.add(cellValue);
                                break;
                            }
                            case 6:
                            {
                                frameworkProgramme.add(cellValue);
                                break;
                            }
                            
                            case 7:
                            {
                                title.add(cellValue);
                                break;
                            }
                            
                            case 8:
                            {
                                startDate.add(cellValue);
                                break;
                            }
                            case 9:
                            {
                                endDate.add(cellValue);
                                break;
                            }
                            
                            case 10:
                            {
                                projectUrl.add(cellValue);
                                break;
                            }
                            
                            case 11:
                            {
                                objective.add(cellValue);
                                break;
                            }
                            
                            case 12:
                            {
                                totalCost_int=Float.parseFloat(cellValue);
                                totalCost.add(totalCost_int );
                                break;
                            }
                            
                            case 13:
                            {
                                ecMaxContribution_int=Float.parseFloat(cellValue);
                                ecMaxContribution.add(ecMaxContribution_int );
                                break;
                            }
                            
                            case 14:
                            {
                                call.add(cellValue);
                                break;
                            }
                            case 15:
                            {
                                fundingScheme.add(cellValue);
                                break;
                            }
                            case 16:
                            {
                                coordinator.add(cellValue);
                                break;
                            }
                            case 17:
                            {
                                coordinatorCountry.add(cellValue);
                                break;
                            }
                            case 18:
                            {
                                participants.add(cellValue);
                                break;
                            }
                            case 19:
                            {
                                participantCountries.add(cellValue);
                                break;
                            }
                            case 20:
                            {
                                subjects.add(cellValue);
                                break;
                            }
                            
                        }
                    }  
               }   
           }    
        }
       catch(IOException ex)
       {
           System.out.println("The file could not be read : "+ex.getMessage());
       }
        }
        public static void setDataStatus()
        {
             for(int i=0;i<status.size();i++)
             {
                 if(status.get(i).equals("SIGNED"))
                 {
                     
                     SIGNED++;
                 }
                 if(status.get(i).equals("CLOSED"))
                 {
                     
                     CLOSED++;
                 }
                 if(status.get(i).equals("TERMINATED"))
                 {
                     
                     TERMINATED++;
                 }
             }
        }
        public static void setDataCountryId()
        {
            for(int i=0;i<CountryId.length;i++)
            {
                for(int j=0;j<coordinatorCountry.size();j++)
                {
                    if(CountryId[i].equals(coordinatorCountry.get(j)))
                    {
                        CountryIdNumber[i]++;
                    }
                }
            }
        }
        public static void setDataFundingSchemeId()
        {
            for(int i=0;i<FundingSchemeId.length;i++)
            {
                for(int j=0;j<fundingScheme.size();j++)
                {
                    if(FundingSchemeId[i].equals(fundingScheme.get(j)))
                    {
                        FundingSchemeIdNumber[i]++;
                    }
                }
            }
        }
}
