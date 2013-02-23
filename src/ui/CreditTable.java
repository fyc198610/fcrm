package ui;

import java.awt.Container;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTable;

import db.DerbyConnection;

public class CreditTable {

	Statement state;
	ResultSet rs;
	String select;
	String[] header = {"��˾����","������","��ϵ��","ע���ʽ�","��Ӫҵ��","�ƻ�����˾�꽻�׶�","����ɽ��׶�","��ֹ����","Ƿ����","�ͻ�������"};
	String[][] data;
	JTable table;
	public CreditTable(String select)
	{
		this.select = select;
		try {
			state = DerbyConnection.f_getConnect().createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(this.select.equals("all"))
			this.select = "select name,principal,linkman,zhucezijin,nianyingyee,jihuayuwosinianjiaoyie,yiwanchengjiaoyie,jiezhiriqi,qiankuan,creditlevel " +
					"from client where active = 1";
		toData();
		createTable();
		
	}
	public void toData()
	{
		int row=0;
		try {
			rs = state.executeQuery(select);
			while(rs.next())
				row++;
			data = new String[row][10];
			row = 0;
			rs = state.executeQuery(select);
			while(rs.next())
			{
				for(int column = 0;column<10;column++)
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
