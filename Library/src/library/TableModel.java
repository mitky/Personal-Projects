
package library;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
//code for table from tutorial
public class TableModel extends AbstractTableModel{
    
    private String[] columnNames;
    private ArrayList<LibraryItem> list;
   
    TableModel(ArrayList<LibraryItem> list, String[] columnNames){
        this.list = list;
        this.columnNames = columnNames;
        
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object temp = null;
        
        if(columnIndex == 0){
            temp = list.get(rowIndex).getISBN();
            
        }
        else if(columnIndex ==1){
            temp = list.get(rowIndex).getTitle();
            
        }
        else if(columnIndex ==2){
            temp = list.get(rowIndex).getSector();
            
        }
        else if(columnIndex ==3){
            
            if(list.get(rowIndex).getBorrowed()==true){
                temp = "Borrowed";
                
            }
            else{
                temp = "Not borrowed";
                
            }
        }
        
        return temp;
    }
    
    public String getColumnNames(int col){//sets the names of colums i din't know how ti put it in use coreectly
        return columnNames[col];
    }
    
    
    
}
