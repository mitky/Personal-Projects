package net.codejava.excel;

import java.lang.reflect.InvocationTargetException;
import javax.swing.JFrame;  
import javax.swing.SwingUtilities;  
import javax.swing.WindowConstants;
  
import org.jfree.chart.ChartFactory;  
import org.jfree.chart.ChartPanel;  
import org.jfree.chart.JFreeChart;  
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;  
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;  
import org.jfree.data.category.DefaultCategoryDataset;  
  
public class CoordinatorCountryBarChartPart2 extends JFrame {  
  
  private static final long serialVersionUID = 1L;  
  
  public CoordinatorCountryBarChartPart2(String appTitle2) {  
    super(appTitle2);  
  
    // Create Dataset  
    CategoryDataset dataset2 = createDataset2();  
      
    //Create chart  
    JFreeChart chart2=ChartFactory.createBarChart(  
            
        "Coordinator Country Bar Chart Part II [IT-ZA]", //Chart Title  
        "CountryId", // Category axis  
        "Number of each Country", // Value axis  
        dataset2,  
        PlotOrientation.VERTICAL,  
        true,true,false  
       );  
  
    
    //set thickness of bar to bigger
    BarRenderer renderer = (BarRenderer) chart2.getCategoryPlot().getRenderer();
    renderer.setItemMargin(-15);
    
    
 
    ChartPanel panel2=new ChartPanel(chart2);  
    setContentPane(panel2);  
  }  
  
  private CategoryDataset createDataset2() {  
    DefaultCategoryDataset dataset2 = new DefaultCategoryDataset();  
        
        //show second 25 of 50 CountryId
         for(int i=25;i<50;i++)
        {
            dataset2.addValue(LoadDataFromExcelFile.CountryIdNumber[i], LoadDataFromExcelFile.CountryId[i], LoadDataFromExcelFile.CountryId[i]);  
        }

    return dataset2;  
  }  
  
  public static void main(String[] args) throws Exception {  
    SwingUtilities.invokeAndWait(()->{  
      CoordinatorCountryBarChartPart2 chart2=new CoordinatorCountryBarChartPart2("Coordinator Country Bar Chart Part II [IT-ZA]");  
      chart2.setSize(800, 400);  
      chart2.setLocationRelativeTo(null);  
      chart2.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);  
      chart2.setVisible(true);  
    });  
  } 
  public static void DrawCoordinatorCountryBarChartPart2() throws InterruptedException, InvocationTargetException
  {
      SwingUtilities.invokeAndWait(()->{  
      CoordinatorCountryBarChartPart2 chart2=new CoordinatorCountryBarChartPart2("Coordinator Country Bar Chart Part II [IT-ZA]");  
      chart2.setSize(800, 400);  
      chart2.setLocationRelativeTo(null);  
      chart2.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);  
      chart2.setVisible(true); 
  });
  }
}  