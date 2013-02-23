package ui;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class RowColorRenderer extends DefaultTableCellRenderer{

	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
	{
		if(row%2==0)
			setBackground(new Color(239,245,246));
		else
			setBackground(new Color(221,239,204));
		return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
	}
}
