
package net.codejava.excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.FormulaEvaluator;


public class ExcelUtils {
    
    private static int xmlID=0;
    
    public static Object getTypedValue(Cell cell)
    {
        CellType cellType = cell.getCellTypeEnum();
        
        if(cellType.equals(CellType.FORMULA))
        {
            cellType = cell.getCachedFormulaResultTypeEnum();
            
            FormulaEvaluator evaluator = cell.getSheet().getWorkbook().getCreationHelper().createFormulaEvaluator();
            evaluator.evaluateFormulaCell(cell);
            String formula = cell.getCellFormula();
        }
            switch(cellType)
            {
                case BOOLEAN:
                     return cell.getBooleanCellValue();
                case NUMERIC:
                    if(DateUtil.isCellDateFormatted(cell))
                    {
                        return cell.getDateCellValue();
                    }
                    else
                    {
                        return cell.getNumericCellValue();
                    }
                case STRING:
                    return cell.getStringCellValue();
            }
            return null;
    }
}
