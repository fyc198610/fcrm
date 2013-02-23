package ui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import db.DerbyConnection;

public class FindCustomer {

	Statement state;
	ResultSet rs;
	String[] columnName = {"客户编号","客户名称","联系人","手机","电话","传真","与我司年交易额","已完成交易额","加入日期","欠款"};
	String[][] data;
	int row = 0;
	
	public FindCustomer()
	{
		
		try {
			state = DerbyConnection.f_getConnect().createStatement();
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			
	}
	
	
	
	public JTable toTable(String select)
	{
		JTable table;
		if(select.equals("all"))
			select = "SELECT number, name, linkman, mobilephone, telephone, fax, jihuayuwosinianjiaoyie,  " +
					"yiwanchengjiaoyie, joindate, qiankuan FROM client WHERE (active = 1)";
		try {
			rs = state.executeQuery(select);
			while(rs.next())
				row++;
			rs = state.executeQuery(select);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		data = new String[row][10];
		row = 0;
		try {
			while(rs.next())
			{
				for(int i = 0;i<10;i++)
				{
					if(rs.getString(i+1)==null)
						data[row][i] = "null";
					else
						data[row][i] = rs.getString(i+1).trim();
				}
				row++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		table = new JTable(new CustomerTable(data,columnName));
		return table;
	}
	
	
}
