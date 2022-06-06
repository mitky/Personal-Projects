
package library;
import java.awt.Container;
import java.awt.FlowLayout;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableCellRenderer;

//code for the table and GUI form tutorial

public class Gui extends JFrame{
    private String[] columnNames = {"ISBN", "Tilte", "Sector", "Borrowed"};
   private ArrayList<LibraryItem> list;
    
    public Gui(ArrayList<LibraryItem> list){
        
       
        
        Container cp = getContentPane();
        cp.setLayout(new FlowLayout());
        
        this.list=list;
        
        JTable table = new JTable();
        TableModel model = new TableModel(list, columnNames);
        
        
        table.setModel(model);
        JScrollPane scrollPane = new JScrollPane(table);
        table.setGridColor(Color.BLACK);
        add(scrollPane);
        ChangeName(table,0,"ISBN");//change the names because my set names for colums didn't work
        ChangeName(table,1,"Title");
        ChangeName(table,2,"Sector");
        ChangeName(table,3,"Borrowed");
        
        
        
        
        
        table.getColumnModel().getColumn(3).setCellRenderer(new DefaultTableCellRenderer(){
            Color originalCOlor = null;
            
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column){
                Component renderer = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                
                
                    
                
                if(value == "Borrowed"){
                    renderer.setBackground(Color.RED);
                }
                else{
                    renderer.setBackground(Color.GREEN);
                }
                
               
                return renderer;
            }
    });
        
        
        JFrame frame = new JFrame("my table");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(scrollPane);
        frame.setSize(500, 500);
        frame.setVisible(true);
        
    }

    private void ChangeName(JTable table, int col_index, String col_name) {//change names of colums which were default 1,2,3,4
       table.getColumnModel().getColumn(col_index).setHeaderValue(col_name);
    }
    
}
