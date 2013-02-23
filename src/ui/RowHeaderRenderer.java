package ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.TableCellRenderer;

	class RowHeaderRenderer implements TableCellRenderer{
	 private JLabel label = new JLabel();      
	    // 获取表头的字体、前景色和背景色，用来将Label伪装成表头的样子      
	    private static Font font = new Font("楷体",Font.PLAIN,12);      
	    private static Color fgc = (Color) UIManager.get("TableHeader.foreground");      
	    private static Color bgc = (Color) UIManager.get("TableHeader.background");      
	    public Component getTableCellRendererComponent(JTable table, Object value,      
	            boolean isSelected, boolean hasFocus, int row, int column) {      
	        // TODO Auto-generated method stub      
	        label.setFont(font);      
	        label.setHorizontalAlignment(SwingConstants.LEFT);      
	        label.setText(value.toString());      
	        label.setOpaque(true);      
	        label.setForeground(fgc);      
	        label.setBackground(bgc);      
	        return label;      
	    }
}
