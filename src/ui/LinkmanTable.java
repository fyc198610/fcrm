package ui;

import javax.swing.JTable;

public class LinkmanTable {
	
	String[] header;
	String[][] data;
	JTable table;
	public LinkmanTable(String[] header,String[][] data)
	{
		this.header = header;
		this.data = data;
		create();
	}

	public void create()
	{
		table = new JTable(data,header);
	}
	
	public JTable getTable()
	{
		return table;
	}
}
