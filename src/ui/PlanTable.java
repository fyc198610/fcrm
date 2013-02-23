package ui;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JTable;

import db.DerbyConnection;

public class PlanTable {

	JTable table;
	String select;
	Statement state;
	ResultSet rs;
	String[] header = {"客户名称","计划名称","开始时间","结束时间","是否完成"};
	String[][] data;
	public PlanTable(String select)
	{
		this.select = select;
		try {
			state = DerbyConnection.f_getConnect().createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(this.select.equals("已完成计划"))
			this.select = "select company,planname,startdate,enddate,accomplish from deveplan where active = 1 and accomplish = 1";
		else 
			if(this.select.equals("未完成计划"))
				this.select = "select company,planname,startdate,enddate,accomplish from deveplan where active = 1 and accomplish = 0";
			else if(this.select.equals("过期计划"))
			{
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				String today = sdf.format(new Date());
				this.select = "select company,planname,startdate,enddate,accomplish from deveplan where active = 1 and accomplish = 0 " +
						"and enddate<'"+today+"'";
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
			data = new String[row][5];
			row = 0;
			rs = state.executeQuery(select);
			while(rs.next())
			{
				for(int column = 0;column<5;column++)
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
