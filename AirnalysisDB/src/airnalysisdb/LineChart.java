package airnalysisdb;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;


/* LineChart class extends the JInternalFrame which will make it possible for the graph to be independently embedded to the main Property frame
 * and display all the information requested.
 * [HCI] - The following rule: "Replace memory with visual information: A user should not need to retain important information solely in working 
 * memory or retrieve it from long-term memory" is followed using the chart. 
 */
public class LineChart extends JInternalFrame {
    
    // [Security Feature] - the variable is private and can be accessed only by a getter method
    private JFreeChart chart;

    public LineChart() {
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
        initUI();
    }
    
    public JFreeChart getChart() {
        return this.chart;
    }
    
    //[HCI] - the background of the chart is white while the data and the font are either red or black for high contrast and legibility
    private void initUI() {
        
        XYDataset dataset = createDataset();
        JFreeChart chart = createChart(dataset);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        chartPanel.setBackground(Color.white);
        add(chartPanel);

        pack();
        setTitle("Line chart");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }

    private XYDataset createDataset() {

        XYSeries series = AirnalysisDB.getLineChartList();

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series);

        return dataset;
    }
    
    /* There is a number of Human-Computer Interaction issues solved in the createChart method 
     * [HCI] - both axis, as well as the whole graph, have clear descriptions so the user can interpret it correctly
     * [HCI] - the colors are chosen to be of high contrast to increase legibility 
     * [HCI] - the font of the chart, as well as its size and weight, has been specified to match the font of the application and make the graph more legible
     */
    private JFreeChart createChart(XYDataset dataset) {

        JFreeChart chart = ChartFactory.createXYLineChart(
                "Quantity of properties with the certain number of reviews", 
                "Number of reviews", 
                "Number of properties", 
                dataset, 
                PlotOrientation.VERTICAL,
                true, 
                true, 
                false 
        );

        XYPlot plot = chart.getXYPlot();
        
        plot.getRangeAxis().setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        plot.getDomainAxis().setStandardTickUnits(NumberAxis.createIntegerTickUnits());

        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesPaint(0, Color.RED);
        renderer.setSeriesStroke(0, new BasicStroke(2.0f));

        plot.setRenderer(renderer);
        plot.setBackgroundPaint(Color.white);

        plot.setRangeGridlinesVisible(true);
        plot.setRangeGridlinePaint(Color.BLACK);

        plot.setDomainGridlinesVisible(true);
        plot.setDomainGridlinePaint(Color.BLACK);

        chart.getLegend().setFrame(BlockBorder.NONE);

        chart.setTitle(new TextTitle("Quantity of properties with certain number of reviews",
                        new Font("Perpetua", java.awt.Font.BOLD, 22)
                )
        );
        
        this.chart = chart;
        
        return chart;

    }
}
