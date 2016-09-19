package view;

import javax.swing.table.AbstractTableModel;

import estruturas.OrderedList;
import estruturas.Node;
import model.SpreadsheetModel;

public class SpreadsheetTableModel extends AbstractTableModel {
	private static final long serialVersionUID = -7623344886451021182L;
	private SpreadsheetModel spreadsheet;
	
	public OrderedList<String> orderedList;
	
	public SpreadsheetTableModel(SpreadsheetModel spreadsheet) {
		this.spreadsheet = spreadsheet;
		orderedList = new OrderedList<>();
		
		orderedList.add("A");
		orderedList.find("A").ol.add("A2");

		String formula = "33";
		orderedList.find("A").ol.find("A2").setCalc(formula);
	}
	
	@Override
	public int getRowCount() {
		return 100;
	}

	@Override
	public int getColumnCount() {
		return 40;
	}

	private String translateIndexToColumnName(int index) {
		index--;
		String name = "";
		int b = 26;
		while (b <= index) {
			name = (char)(65 + (index % b)) + name;
			index /= b;
			index--;
		}
		name = (char)(65 + (index % b)) + name;
		return name;
	}
	
	@Override
	public Object getValueAt(int row, int column) {
		if (column > 0) {
			 if (orderedList.find(translateIndexToColumnName(column))== null){
				 return 0;
			 }
			  if(orderedList.find(translateIndexToColumnName(column)).ol.find(getCellName(row,column)) == null) {
				 return 0;
			 }
			return orderedList.find(translateIndexToColumnName(column)).ol.find(getCellName(row,column));
		}
		return row+1;
	}

	@Override
	public void setValueAt(Object o, int row, int column) {
		System.out.println(o.toString());
		if (column > 0) {
        	if(orderedList.find(translateIndexToColumnName(column)) == null) {
        		orderedList.add(translateIndexToColumnName(column));
        		orderedList.find(translateIndexToColumnName(column)).ol.add(getCellName(row,column));
        		orderedList.find(translateIndexToColumnName(column)).ol.find(getCellName(row,column)).setCalc(o.toString());
  
        	}else {
        		if(orderedList.find(translateIndexToColumnName(column)).ol.find(getCellName(row,column)) == null){
        			orderedList.find(translateIndexToColumnName(column)).ol.add(getCellName(row,column));
        			orderedList.find(translateIndexToColumnName(column)).ol.find(getCellName(row,column)).setCalc(o.toString());
        			
        		} else {
        			orderedList.find(translateIndexToColumnName(column)).ol.find(getCellName(row,column)).setCalc(o.toString());
        		}
        	}
		}
	}

	@Override
	public String getColumnName(int index) {
		if (index == 0)
			return " ";
		return translateIndexToColumnName(index);
	}
	
	@Override
	public boolean isCellEditable(int row, int column) {
		if (column >  0)
			return true;
		return false;
	}

	public String getFormula(int row, int column) {
		return spreadsheet.getFormula(getCellName(row,column));
	}

	private String getCellName(int row, int column) {
		return translateIndexToColumnName(column) + (row + 1);			
	}
}
