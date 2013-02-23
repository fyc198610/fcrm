package ui;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTable;

import db.DerbyConnection;

public class SatisTable {

	Statement state;
	ResultSet rs;
	String select;
	String[] header = {"日期","客户名称","number1","number2","number3","number4","number5","number6","number7","number8","number9","number10","number11","number12"};
	String[][] data;
	JTable table;
	public SatisTable(String select)
	{
		this.select = select;
		try {
			state = DerbyConnection.f_getConnect().createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		toData();
		createTable();
	}
	
	private void toData()
	{
		int row = 0;
		try {
			rs = state.executeQuery(select);
			while(rs.next())
				row++;
			data = new String[row][14];
			row = 0;
			rs = state.executeQuery(select);
			while(rs.next())
			{
				for(int column = 0;column<14;column++)
				{
					if(rs.getString(column+1)==null)
						data[row][column] = "null";
					else
						data[row][column] = rs.getString(column+1);
				}
				row++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void createTable()
	{
		table = new JTable(data,header);
	}
	
	public JTable getTable()
	{
		return table;
	}
}
