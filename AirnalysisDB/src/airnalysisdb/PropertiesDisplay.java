/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airnalysisdb;

import java.awt.BorderLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.RowFilter;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableRowSorter;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author w1710343
 */
public class PropertiesDisplay extends javax.swing.JFrame {

    /**
     * Creates new form PropertiesDisplay
     */
    public PropertiesDisplay() {
        initComponents();
        myInitComponents();
    }
    
    private void populateComboBox(){
        int i=0;
        while(i<=maxNoReviews){
            jComboBox1.addItem(i);
            jComboBox2.addItem(i);
            i++;
        }
    }
    
    private void myInitComponents() {
                
        maxNoReviews = AirnalysisDB.retrieveMaxNoReviews();
        chosenMinRev = 0;
        chosenMaxRev = maxNoReviews;
        PropertyTableModel propertyTableModel = AirnalysisDB.propertyTableUpdate(chosenMinRev, chosenMaxRev);
        jTable1.setModel(propertyTableModel);
        jTable1.setAutoCreateRowSorter(true);
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(230);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(10);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(6);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(6);
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(6);
        sorter = new TableRowSorter<PropertyTableModel>(propertyTableModel);
        jTable1.setRowSorter(sorter);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        jTable1.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        jTable1.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        jTable1.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        jTable1.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
        this.setLocationRelativeTo(null);
        populateComboBox();
        MinReviewsListener minListener = new MinReviewsListener();
        MaxReviewsListener maxListener = new MaxReviewsListener();
        jComboBox1.addItemListener(minListener);
        jComboBox2.addItemListener(maxListener);
        JFrame thisFrame = this;
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
        @Override
        public void windowClosing(WindowEvent event) {
            AirnalysisDB.exitFrame(thisFrame);
        }});    
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        lineChart2 = new airnalysisdb.LineChart();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<Integer>();
        jComboBox1 = new javax.swing.JComboBox<Integer>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(219, 224, 235));
        setMinimumSize(new java.awt.Dimension(1500, 900));
        setPreferredSize(new java.awt.Dimension(1500, 900));

        jScrollPane1.setBackground(new java.awt.Color(219, 224, 235));
        jScrollPane1.setFont(new java.awt.Font("Perpetua", 0, 24)); // NOI18N
        jScrollPane1.setMaximumSize(new java.awt.Dimension(500, 500));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(600, 500));

        jTable1.setFont(new java.awt.Font("Perpetua", 0, 20)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.setRowHeight(35);
        jTable1.setRowMargin(2);
        jScrollPane1.setViewportView(jTable1);

        jButton3.setBackground(new java.awt.Color(250, 250, 250));
        jButton3.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        jButton3.setText("Logout");
        jButton3.setFocusPainted(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(219, 224, 235));
        jLabel2.setFont(new java.awt.Font("Vivaldi", 0, 55)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Properties");

        jButton4.setBackground(new java.awt.Color(250, 250, 250));
        jButton4.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        jButton4.setText("Admin Panel");
        jButton4.setFocusPainted(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        lineChart2.setTitle("");
        lineChart2.setFocusCycleRoot(false);
        lineChart2.setFocusable(false);
        lineChart2.setRequestFocusEnabled(false);
        lineChart2.setVerifyInputWhenFocusTarget(false);
        lineChart2.setVisible(true);

        jButton1.setBackground(new java.awt.Color(250, 250, 250));
        jButton1.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        jButton1.setText("Filter");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setFocusPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Perpetua", 1, 22)); // NOI18N
        jLabel1.setText("Choose the range of reviews:");

        jComboBox2.setFont(new java.awt.Font("Perpetua", 0, 20)); // NOI18N
        jComboBox2.setToolTipText("");

        jComboBox1.setFont(new java.awt.Font("Perpetua", 0, 20)); // NOI18N
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jButton1)
                        .addGap(206, 206, 206))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(198, 198, 198))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lineChart2, javax.swing.GroupLayout.DEFAULT_SIZE, 698, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 602, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lineChart2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /*  jButton1ActionPerformed method allows the user to sort both the table and the chart according to the values chosen by the user
     * [HCI] - the visual data display is very interactive, can be easily adjusted to the needs of the user with the combo boxes and the 'Filter' button
     * [HCI] - the filters are designed in such a way that they include the values chosen by the user 
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(evt.getSource() == jButton1){
                List<RowFilter<PropertyTableModel,Object>> filters = new ArrayList<RowFilter<PropertyTableModel,Object>>(2);
                RowFilter<PropertyTableModel, Object> rf = null;
                try {
                    if(chosenMinRev<=chosenMaxRev){
                        filters.add(RowFilter.numberFilter(RowFilter.ComparisonType.AFTER, chosenMinRev-1, 2));
                        filters.add(RowFilter.numberFilter(RowFilter.ComparisonType.BEFORE, chosenMaxRev+1, 2));
                    } else{
                        filters.add(RowFilter.numberFilter(RowFilter.ComparisonType.AFTER, chosenMaxRev-1, 2));
                        filters.add(RowFilter.numberFilter(RowFilter.ComparisonType.BEFORE, chosenMinRev+1, 2));
                    }
                    rf = RowFilter.andFilter(filters);
                } catch (java.util.regex.PatternSyntaxException e) {
                    return;
                }
                sorter.setRowFilter(rf);
                
                XYSeries series = AirnalysisDB.getLineChartList();
                XYSeriesCollection dataset = new XYSeriesCollection();
                dataset.addSeries(series);
                lineChart2.getChart().getXYPlot().setDataset(dataset);
                lineChart2.getChart().fireChartChanged();
            }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        AirnalysisDB.logLogInOut();
        LoginFrame login = new LoginFrame();
        login.setVisible(true);
        login.pack();
        login.setLocationRelativeTo(null);
        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    class MinReviewsListener implements ItemListener {
        // This method is called only if a new item has been selected.
        public void itemStateChanged(ItemEvent event) {
            chosenMinRev = (int) event.getItem();
            AirnalysisDB.setChosenMinRevInTable(chosenMinRev);
        }
    }
    
    class MaxReviewsListener implements ItemListener {
        // This method is called only if a new item has been selected.
        public void itemStateChanged(ItemEvent event) {
            chosenMaxRev = (int) event.getItem();
            AirnalysisDB.setChosenMaxRevInTable(chosenMaxRev);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<Integer> jComboBox1;
    private javax.swing.JComboBox<Integer> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private airnalysisdb.LineChart lineChart2;
    // End of variables declaration//GEN-END:variables
    private int chosenMinRev;
    private int chosenMaxRev;
    private int maxNoReviews;
    private TableRowSorter<PropertyTableModel> sorter;

}
