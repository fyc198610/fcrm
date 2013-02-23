package ui;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTable;

import db.DerbyConnection;

public class EmployeeTable {

	Statement state;
	ResultSet rs;
	String select;
	JTable table;
	String[] header = {"编号","姓名","性别","年龄","学历","手机","加入日期","地址"};
	String[][] data;
	public EmployeeTable(String select)
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
	
	public void toData()
	{
		int row = 0;
		try {
			rs = state.executeQuery(select);
			while(rs.next())
				row++;
			data = new String[row][8];
			row = 0;
			rs = state.executeQuery(select);
			while(rs.next())
			{
				for(int column = 0;column<8;column++)
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
	
	public void createTable()
	{
		table = new JTable(data,header);
		
	}
	
	public JTable getTable()
	{
		return table;
	}
}
