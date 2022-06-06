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
  
public class FundingSchemeBarChartPart1 extends JFrame {  
  
  private static final long serialVersionUID = 1L;  
  
  public FundingSchemeBarChartPart1(String appTitle) {  
    super(appTitle);  
  
    // Create Dataset  
    CategoryDataset dataset = createDataset();  
      
    //Create chart  
    JFreeChart chart=ChartFactory.createBarChart(  
        "Funding Scheme Bar Chart Part I", //Chart Title  
        "Funding Scheme ID", // Category axis  
        "Number of each Scheme", // Value axis  
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
  
  for(int i=0;i<20;i++)
    {
        dataset.addValue(LoadDataFromExcelFile.FundingSchemeIdNumber[i], LoadDataFromExcelFile.FundingSchemeId[i], LoadDataFromExcelFile.FundingSchemeId[i]);  
    }
  
    return dataset;  
  }  
  
  public static void main(String[] args) throws Exception {  
    SwingUtilities.invokeAndWait(()->{  
      FundingSchemeBarChartPart1 example=new FundingSchemeBarChartPart1("Funding Scheme Bar Chart Part I");  
      example.setSize(800, 400);  
      example.setLocationRelativeTo(null);  
      example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);  
      example.setVisible(true);  
    });  
  }  
  public static void DrawFundingSchemeBarChartPart1() throws InterruptedException, InvocationTargetException
  {
      SwingUtilities.invokeAndWait(()->{  
      FundingSchemeBarChartPart1 example=new FundingSchemeBarChartPart1("Funding Scheme Bar Chart Part I");  
      example.setSize(800, 400);  
      example.setLocationRelativeTo(null);  
      example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);  
      example.setVisible(true);  
    });  
  }
}  