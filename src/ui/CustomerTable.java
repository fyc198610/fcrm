package ui;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

public class CustomerTable extends AbstractTableModel{

	String[] columnName;
	String[][] data;
	
	public CustomerTable(String[][] data, String[] columnName)
	{
		this.columnName = columnName;
		this.data = data;
	}
	
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnName.length;
	}

	public int getRowCount() {
		// TODO Auto-generated method stub
		return data.length;
	}

	public Object getValueAt(int row, int column) {
		// TODO Auto-generated method stub
		return data[row][column];
	}
	
	public boolean isCellEditable(int rowIndex, int columnIndex)
	{
		return false;
	}
	public String getColumnName(int column)
	{
		return columnName[column];
	}
}
