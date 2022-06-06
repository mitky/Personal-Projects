package net.codejava.excel;

import java.lang.reflect.InvocationTargetException;
import javax.swing.JFrame;  
import javax.swing.SwingUtilities;  
import javax.swing.WindowConstants;
  
import org.jfree.chart.ChartFactory;  
import org.jfree.chart.ChartPanel;  
import org.jfree.chart.JFreeChart;  
import org.jfree.chart.plot.PlotOrientation;  
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;  
import org.jfree.data.category.DefaultCategoryDataset;  
  
public class CoordinatorCountryBarChartPart1 extends JFrame {  
  
  private static final long serialVersionUID = 1L;  
  
  public CoordinatorCountryBarChartPart1(String appTitle) {  
    super(appTitle);  
  
    // Create Dataset  
    CategoryDataset dataset = createDataset();  
      
    //Create chart  
    JFreeChart chart=ChartFactory.createBarChart(  
        "Coordinator Country Bar Chart Part I [AI-IS]", //Chart Title  
        "CountryId", // Category axis  
        "Amount for each Country", // Value axis  
        dataset,  
        PlotOrientation.VERTICAL,  
        true,true,false  
       );  
  
    //set thickness of bar to bigger
    BarRenderer renderer = (BarRenderer) chart.getCategoryPlot().getRenderer();
    renderer.setItemMargin(-15);
    
    
    
    ChartPanel panel=new ChartPanel(chart);  
    setContentPane(panel);  
  }  
  
  private CategoryDataset createDataset() {  
    DefaultCategoryDataset dataset = new DefaultCategoryDataset();  
   
    //show first 25 of 50 CountryId
    for(int i=0;i<25;i++)
    {
        dataset.addValue(LoadDataFromExcelFile.CountryIdNumber[i], LoadDataFromExcelFile.CountryId[i], LoadDataFromExcelFile.CountryId[i]);  
    }

    return dataset;  
  }  
  
  public static void main(String[] args) throws Exception {  
    SwingUtilities.invokeAndWait(()->{  
      CoordinatorCountryBarChartPart1 example=new CoordinatorCountryBarChartPart1("Coordinator Country Bar Chart Part I [AI-IS]");  
      example.setSize(800, 400);  
      example.setLocationRelativeTo(null);  
      example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);  
      example.setVisible(true);  
    });  
  } 
  public static void DrawCoordinatorCountryBarChartPart1() throws InterruptedException, InvocationTargetException
  {
      SwingUtilities.invokeAndWait(()->{  
      CoordinatorCountryBarChartPart1 example=new CoordinatorCountryBarChartPart1("Coordinator Country Bar Chart Part I [AI-IS]");  
      example.setSize(800, 400);  
      example.setLocationRelativeTo(null);  
      example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);  
      example.setVisible(true); 
  });
  }
}  