package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import db.DerbyConnection;

public class SatisAnalyse {

	Statement state;
	ResultSet rs;
	JPanel root;
	JTable table;
	String[] header = {"选题","很满意","一般","不满意"};
	String[][] data;
	
	public SatisAnalyse(JPanel root)
	{
		this.root = root;
		try {
			state = DerbyConnection.f_getConnect().createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		toData();
		createTable();
		faceSet();
	}
	
	String[] titleNumber = {"number1","number2","number3","number4","number5","number6","number7","number8","number9","number10","number11","number12"};
	String[] t1 = {"3","2","1"};
	private void toData()
	{
		data = new String[12][4];
		for(int i = 0;i<12;i++)
			for(int j=0;j<4;j++)
			{
				
				if(i==0&&j==0)
					data[i][j] = "  1. 您对我们的产品质量满意吗？";
				else if(i==1&&j==0)
					data[i][j] = "  2. 您对我们的服务态度满意吗？";
				else if(i==2&&j==0)
					data[i][j] = "  3. 您对我们的产品价格满意吗？";
				else if(i==3&&j==0)
					data[i][j] = "  4. 您对我们的交货时间满意吗？";
				else if(i==4&&j==0)
					data[i][j] = "  5. 您对我公司的发展状况满意吗？";
				else if(i==5&&j==0)
					data[i][j] = "  6. 您对我公司的保价反馈速度满意吗？";
				else if(i==6&&j==0)
					data[i][j] = "  7. 您对我公司的问题回复速度满意吗？";
				else if(i==7&&j==0)
					data[i][j] = "  8. 您对我公司业务员的服务态度满意吗？";
				else if(i==8&&j==0)
					data[i][j] = "  9. 您对我公司的产品价格满意吗？";
				else if(i==9&&j==0)
					data[i][j] = "  10. 您对我公司的结算方式满意吗？";
				else if(i==10&&j==0)
					data[i][j] = "  11. 您对我公司的新品开发速度满意吗？";
				else if(i==11&&j==0)
					data[i][j] = "  12. 您对我公司所采用的货运方式满意吗？";
				else
					try {
						rs = state.executeQuery("select count(company) from satisfaction where active = 1 and "+titleNumber[i]+" = "+t1[j-1]);
						if(rs.next())
							data[i][j] = rs.getString(1);
						else
							data[i][j] = "0";
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
			}
	}
	
	private void createTable()
	{
		table= new JTable(data,header);
		table.getTableHeader().setFont(new Font("宋体",Font.PLAIN,14));
		table.setRowHeight(22);
		table.getColumnModel().getColumn(0).setPreferredWidth(300);
		table.getColumnModel().getColumn(0).setCellRenderer(new RowHeaderRenderer());  
		for(int i= 1 ,n = table.getColumnCount();i<n;i++)
		{
			table.getColumnModel().getColumn(i).setCellRenderer(new RowColorRenderer());
		}
	}
	
	JPanel all;
	JPanel top;
	JPanel centertop;
	JPanel center;
	JPanel chartPanel;
	JComboBox number;
	String[] arrayNumber = {"number1","number2","number3","number4","number5","number6","number7","number8","number9","number10","number11","number12","所有"};
	JButton ok;
	public void faceSet()
	{
		all = new JPanel(new BorderLayout());
		top = new JPanel(new BorderLayout());
		top.setPreferredSize(new Dimension(all.getSize().width,320));
		JLabel title = new JLabel("客户满意度统计分析",JLabel.CENTER);
		title.setPreferredSize(new Dimension(240,40));
		title.setFont(new Font("宋体",Font.BOLD,18));
		title.setForeground(new Color(55,59,60));
		top.add(title,BorderLayout.NORTH);
		top.add(new JScrollPane(table));
		all.add(top,BorderLayout.NORTH);
		
		center = new JPanel(new BorderLayout());
		centertop = new JPanel(new FlowLayout(FlowLayout.LEFT));
		centertop.add(new JLabel("查看统计图："));
		number = new JComboBox(arrayNumber);
		number.setPreferredSize(new Dimension(90,22));
		centertop.add(number);
		ok = new JButton("查看");
		ok.setMargin(new Insets(0,0,0,0));
		ok.setPreferredSize(new Dimension(50,22));
		centertop.add(ok);
		ok.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String str = (String)number.getSelectedItem();
				String[] data = null;
				if(str.equals("number1"))
				{
					data = new String[3];
					data[0] = (String)table.getValueAt(0, 1);
					data[1] = (String)table.getValueAt(0, 2);
					data[2] = (String)table.getValueAt(0, 3);
				}
				else if(str.equals("number2"))
				{
					data = new String[3];
					data[0] = (String)table.getValueAt(1, 1);
					data[1] = (String)table.getValueAt(1, 2);
					data[2] = (String)table.getValueAt(1, 3);
				}
				else if(str.equals("number3"))
				{
					data = new String[3];
					data[0] = (String)table.getValueAt(2, 1);
					data[1] = (String)table.getValueAt(2, 2);
					data[2] = (String)table.getValueAt(2, 3);
				}
				else if(str.equals("number4"))
				{
					data = new String[3];
					data[0] = (String)table.getValueAt(3, 1);
					data[1] = (String)table.getValueAt(3, 2);
					data[2] = (String)table.getValueAt(3, 3);
				}
				else if(str.equals("number5"))
				{
					data = new String[3];
					data[0] = (String)table.getValueAt(4, 1);
					data[1] = (String)table.getValueAt(4, 2);
					data[2] = (String)table.getValueAt(4, 3);
				}
				else if(str.equals("number6"))
				{
					data = new String[3];
					data[0] = (String)table.getValueAt(5, 1);
					data[1] = (String)table.getValueAt(5, 2);
					data[2] = (String)table.getValueAt(5, 3);
				}
				else if(str.equals("number7"))
				{
					data = new String[3];
					data[0] = (String)table.getValueAt(6, 1);
					data[1] = (String)table.getValueAt(6, 2);
					data[2] = (String)table.getValueAt(6, 3);
				}
				else if(str.equals("number8"))
				{
					data = new String[3];
					data[0] = (String)table.getValueAt(7, 1);
					data[1] = (String)table.getValueAt(7, 2);
					data[2] = (String)table.getValueAt(7, 3);
				}
				else if(str.equals("number9"))
				{
					data = new String[3];
					data[0] = (String)table.getValueAt(8, 1);
					data[1] = (String)table.getValueAt(8, 2);
					data[2] = (String)table.getValueAt(8, 3);
				}
				else if(str.equals("number10"))
				{
					data = new String[3];
					data[0] = (String)table.getValueAt(9, 1);
					data[1] = (String)table.getValueAt(9, 2);
					data[2] = (String)table.getValueAt(9, 3);
				}
				else if(str.equals("number11"))
				{
					data = new String[3];
					data[0] = (String)table.getValueAt(10, 1);
					data[1] = (String)table.getValueAt(10, 2);
					data[2] = (String)table.getValueAt(10, 3);
				}
				else if(str.equals("number12"))
				{
					data = new String[3];
					data[0] = (String)table.getValueAt(11, 1);
					data[1] = (String)table.getValueAt(11, 2);
					data[2] = (String)table.getValueAt(11, 3);
				}
				else if(str.equals("所有"))
				{
					int n1 = 0;
					int n2 = 0;
					int n3 = 0;
					data = new String[12];
					for(int i = 0;i<12;i++)
					{
					n1 = Integer.parseInt((String)table.getValueAt(i, 1));
					n2 = Integer.parseInt((String)table.getValueAt(i, 2));
					n3 = Integer.parseInt((String)table.getValueAt(i, 3));
					data[i] = ""+(n1*3+n2*2+n3*1);
					}
				}
				new SatisPieChart(str,data);
			}
			
		});
		center.add(centertop,BorderLayout.NORTH);
		
		chartPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		center.add(chartPanel);
		all.add(center);
		root.removeAll();
		root.add(all);
		root.revalidate();
	}
	
	

}
