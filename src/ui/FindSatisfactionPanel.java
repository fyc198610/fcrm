package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import db.DerbyConnection;

public class FindSatisfactionPanel {

	Statement state;
	ResultSet rs;
	String select;
	JPanel root;
	String[] arrayCompany;
	public FindSatisfactionPanel(JPanel root)
	{
		this.root = root;
		try {
			state = DerbyConnection.f_getConnect().createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int row=0;
		String select = "select name from client where active = 1";
		try {
			rs = state.executeQuery(select);
			while(rs.next())
				row++;
			arrayCompany = new String[row];
			row = 0;
			rs = state.executeQuery(select);
			while(rs.next())
			{
				arrayCompany[row] = rs.getString(1);
				row++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		create();
	}
	
	JPanel all;
	JComboBox company;
	JButton ok;
	JTable table;
	String str1;
	public void create()
	{
		all = new JPanel(new BorderLayout());
		JPanel top = new JPanel();
		top.add(new JLabel("客户名称："));
		company = new JComboBox(arrayCompany);
		company.setPreferredSize(new Dimension(100,20));
		top.add(company);
		ok = new JButton("查看");
		top.add(ok);
		ok.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(company.getSelectedIndex()==-1)
					JOptionPane.showMessageDialog(null, "请选择客户名称");
				else
				{
					str1 = (String)company.getSelectedItem();
					select = "select filldate,company,number1,number2,number3,number4,number5 ,number6,number7,number8,number9,number10,number11,number12 from satisfaction where active = 1 and company = '"+str1+"'";
					table = new SatisTable(select).getTable();
					all.add(new JScrollPane(table));
					all.revalidate();
					
				}
			}
			
		});
		all.add(top,BorderLayout.NORTH);
		select = "select filldate from satisfaction where active = 2";
		table = new SatisTable(select).getTable();
		all.add(new JScrollPane(table));
		root.removeAll();
		root.add(all);
		root.revalidate();
	}
}
