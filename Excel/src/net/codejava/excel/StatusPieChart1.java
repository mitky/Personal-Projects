package net.codejava.excel;

import java.text.DecimalFormat;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
/**
 * @author imssbora
 */
public class StatusPieChart1 extends JFrame {
  private static final long serialVersionUID = 6294689542092367723L;

  public StatusPieChart1(String title) {
    super(title);

    // Create dataset
    PieDataset dataset = createDataset();

    // Create chart
    JFreeChart chart = ChartFactory.createPieChart(
        "Status Chart [SIGNED,CLOSED,TERMINATED]",
        dataset,
        true, 
        true,
        false);

    //Format Label
    PieSectionLabelGenerator labelGenerator = new StandardPieSectionLabelGenerator(
        "Status: {0} : ({2})", new DecimalFormat("0"), new DecimalFormat("0%"));
    ((PiePlot) chart.getPlot()).setLabelGenerator(labelGenerator);
    
    // Create Panel
    ChartPanel panel = new ChartPanel(chart);
    setContentPane(panel);
  }

  private PieDataset createDataset() {

    DefaultPieDataset dataset=new DefaultPieDataset();
    dataset.setValue("SIGNED", LoadDataFromExcelFile.SIGNED);
    dataset.setValue("CLOSED", LoadDataFromExcelFile.CLOSED);
    dataset.setValue("TERMINATED", LoadDataFromExcelFile.TERMINATED);
    return dataset;
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
      StatusPieChart1 example = new StatusPieChart1("Status Chart [SIGNED,CLOSED,TERMINATED]");
      example.setSize(800, 400);
      example.setLocationRelativeTo(null);
      example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      example.setVisible(true);
    });
  }
  public static void DrawStatusPieChart1()
  {
       SwingUtilities.invokeLater(() -> {
      StatusPieChart1 example = new StatusPieChart1("Status Chart [SIGNED,CLOSED,TERMINATED]");
      example.setSize(800, 400);
      example.setLocationRelativeTo(null);
      example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      example.setVisible(true);
  });
}
}