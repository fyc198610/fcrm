package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import sun.font.Font2D;

import db.DerbyConnection;


public class FindLinkmanFrame extends JFrame{
	
	Container contain;
	JPanel root;
	Statement state;
	ResultSet rs;
	String[] arrayCompany;
	String[][] arrayTable;
	JTable table;
	String[] tableHeader = {"公司名称","姓名","性别","年龄","职务","手机","固话","传真","添加时间"};
	
	public FindLinkmanFrame(JPanel root)
	{
		this.root = root;
		int row = 0;
		try {
			//DerbyConnection.f_setConnect();//测试时使用
			state = DerbyConnection.f_getConnect().createStatement();
			rs = state.executeQuery("select name from client where active = 1");
			while(rs.next())
				row++;
			arrayCompany = new String[row];
			rs = state.executeQuery("select name from client where active = 1");
			row = 0;
			int length = arrayCompany.length;
			while(rs.next())
			{
				arrayCompany[row] = rs.getString(1);
				row++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		faceSet();
		frameSet();
	}
	
	JComboBox company;
	JTextField name;
	JComboBox gender;
	JComboBox business;
	JButton ok;
	String str1;
	String str2;
	String str3;
	String str4;
	String sqlstr1;
	String sqlstr2;
	String sqlstr3;
	String sqlstr4;
	String select;
	public void faceSet()
	{
		String[] arrayGender = new String[]{"男","女","不限"};
		String[] arrayBusiness = new String[]{"经理","职员","不限"};
		contain = getContentPane();
		
		JLabel header = new JLabel("查找联系人",JLabel.CENTER);
		header.setBorder(BorderFactory.createLineBorder(Color.gray));
		header.setForeground(Color.blue);
		header.setFont(new Font(null,Font2D.TTF_RANK,18));
		contain.add(header,BorderLayout.NORTH);
		
		JPanel jpanel = new JPanel();
		jpanel.setBorder(BorderFactory.createLineBorder(Color.gray));
		jpanel.setLayout(new GridLayout(2,2));
		JPanel everyPanel = new JPanel();
		everyPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		everyPanel.add(new JLabel("公司："));
		company = new JComboBox(arrayCompany);
		company.setPreferredSize(new Dimension(90,20));
		company.addItem("不限");
		company.setSelectedItem("不限");
		everyPanel.add(company);
		jpanel.add(everyPanel);
		
		everyPanel = new JPanel();
		everyPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		everyPanel.add(new JLabel("姓名："));
		name = new JTextField(8);
		name.addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				String getName = name.getText();
				if(getName.length()>5)
				{
					JOptionPane.showMessageDialog(null, "姓名长度不能超过5位");
					name.setText("");
				}
			}
		});
		everyPanel.add(name);
		jpanel.add(everyPanel);
		
		everyPanel = new JPanel();
		everyPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		everyPanel.add(new JLabel("性别："));
		gender = new JComboBox(arrayGender);
		gender.setPreferredSize(new Dimension(90,20));
		gender.setSelectedItem("不限");
		everyPanel.add(gender);
		jpanel.add(everyPanel);
		
		everyPanel = new JPanel();
		everyPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		everyPanel.add(new JLabel("职务："));
		business = new JComboBox(arrayBusiness);
		business.setPreferredSize(new Dimension(90,20));
		business.setSelectedItem("不限");
		everyPanel.add(business);
		jpanel.add(everyPanel);
		contain.add(jpanel);
		
		everyPanel = new JPanel();
		everyPanel.setBorder(BorderFactory.createLineBorder(Color.gray));
		everyPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		ok = new JButton("确定");
		ok.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent arg0) {
				str1 = (String)company.getSelectedItem();
				if(str1.equals("不限"))
					sqlstr1 = "";
				else
					sqlstr1 = " and company = '"+str1+"'";
				str2 = name.getText().trim();
				if(str2.length()==0)
					sqlstr2 = "";
				else
					sqlstr2 = " and name like '%"+str2+"%'";
				str3 = (String)gender.getSelectedItem();
				if(str3.equals("不限"))
					sqlstr3 = "";
				else
					sqlstr3 = " and gender = '"+str3+"'";
				str4 = (String)business.getSelectedItem();
				if(str4.equals("不限"))
					sqlstr4 = "";
				else 
					sqlstr4 = " and business = '"+str4+"'";
				select = "select company,name,gender,age,business,mobilephone,telephone,fax,joindate from linkman where active = 1 "+sqlstr1+sqlstr2+sqlstr3+sqlstr4;
				setArrayTable();
				table = new LinkmanTable(tableHeader,arrayTable).getTable();
				root.removeAll();
				root.add(new JScrollPane(table));
				root.revalidate();
//				for(;root.getParent()!=null;root = root.getParent());
//				root.setVisible(true);
				dispose();
			}
			
		});
		everyPanel.add(ok);
		contain.add(everyPanel,BorderLayout.SOUTH);
	}
	
	
	public void setArrayTable()
	{
		int row = 0;
		try {
			rs = state.executeQuery(select);
			while(rs.next())
				row++;
			System.out.println(row);
			arrayTable = new String[row][9];
			row = 0;
			int column = 0;
			rs = state.executeQuery(select);
			while(rs.next())
			{
				for(column = 0;column<9;column++)
				{
					if(rs.getString(column+1)==null)
						arrayTable[row][column] = "null";
					else
						arrayTable[row][column] = rs.getString(column+1);
				}
				row++;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void frameSet()
	{
		setTitle("查找联系人");
		setLocation(200, 100);
		//setSize(new Dimension(300,280));
		pack();
		setAlwaysOnTop(true);
		setIconImage(new ImageIcon("icons/logo1.png").getImage());
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}
	
//	public static void main(String[] args) {
//		new FindLinkmanFrame();
//	}
}
