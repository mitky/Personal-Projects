/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airnalysisdb;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author w1710343
 */
public class PropertyTableModel extends AbstractTableModel{
    
    private final String[] columnNames = {"Name", "ID", "Reviews", "Min. Nights", "Price"};
    ArrayList<String> names = new ArrayList<>();
    ArrayList<Integer> IDs = new ArrayList<>();
    ArrayList<Integer> noReviews = new ArrayList<>();
    ArrayList<Integer> minNights = new ArrayList<>();
    ArrayList<Double> prices = new ArrayList<>();
    
    public PropertyTableModel(ArrayList<String> names, ArrayList<Integer> IDs, ArrayList<Integer> noReviews, ArrayList<Integer> minNights, ArrayList<Double> prices){
        this.names = names;
        this.IDs = IDs;
        this.noReviews = noReviews;
        this.minNights = minNights;
        this.prices = prices;
    }
    
    @Override
    public int getRowCount() {
        return this.names.size();
    }

    @Override
    public int getColumnCount() {
        return this.columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object obj = null;
        if(columnIndex == 0){
            obj = names.get(rowIndex);
        } else if(columnIndex == 1){
            obj = IDs.get(rowIndex);
        } else if(columnIndex == 2){
            obj = noReviews.get(rowIndex);
        } else if(columnIndex == 3){
            obj = minNights.get(rowIndex);
        } else if(columnIndex == 4){
            obj = prices.get(rowIndex);
        } else{
            obj = "  ";
        }
        return obj;
    }
    
    @Override
    public String getColumnName(int column){
        return columnNames[column];
    }
    
    
    
}
