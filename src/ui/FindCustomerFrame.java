package ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class FindCustomerFrame extends JFrame{
	
	Container contain;
	JPanel root;
	JTextField number ;
	JTextField name;
	JDatePicker jdp1;
	JDatePicker jdp2;
	JButton ok;
	String select;
	JTable table;
	
	String sqlNumber;
	String sqlName;
	String sqlJdp1;
	String sqlJdp2;
	String str1;
	String str2;
	public FindCustomerFrame(JPanel rootContentPane)
	{
		root = rootContentPane;
		contain = getContentPane();
		contain.setLayout(null);
		JLabel label = new JLabel("编号");
		label.setBounds(10, 10, 40, 20);
		contain.add(label);
		number = new JTextField();
		number.setBounds(75, 10, 100, 20);
		contain.add(number);
		
		
		label = new JLabel("客户名称");
		label.setBounds(190, 10, 60, 20);
		contain.add(label);
		name = new JTextField();
		name.setBounds(255, 10, 100, 20);
		contain.add(name);
		
		
		label = new JLabel("起始时间");
		label.setBounds(10, 40, 60, 20);
		contain.add(label);
		JPanel startPane = new JPanel(new BorderLayout());
		jdp1 = new JDatePicker(new Dimension(100,20));
		startPane.add(jdp1);
		startPane.setBounds(75, 40, 100, 20);
		contain.add(startPane);
		label = new JLabel("截止时间");
		label.setBounds(190, 40, 60, 20);
		contain.add(label);
		JPanel endPane = new JPanel(new BorderLayout());
		jdp2 = new JDatePicker(new Dimension(100,20));
		endPane.add(jdp2);
		endPane.setBounds(255, 40, 100, 20);
		contain.add(endPane);
		
		ok = new JButton("确定");
		ok.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				sqlNumber = number.getText().trim();
				sqlName = name.getText().trim();
				sqlJdp1 = jdp1.getTxtDate().getText().trim();
				sqlJdp2 = jdp2.getTxtDate().getText().trim();
				if(sqlNumber.length()==0)
					str1="";
				else
					str1 = " and number = '"+sqlNumber+"'";
				if(sqlName.length()==0)
					str2="";
				else 
					str2 = " and name like '%"+sqlName+"%'";
				select = "SELECT number, name, linkman, mobilephone, telephone, fax, jihuayuwosinianjiaoyie,  " +
						"yiwanchengjiaoyie, joindate, qiankuan FROM client WHERE joindate >='"+sqlJdp1+"' and joindate<='"+sqlJdp2+"'"+str1+str2+" and active = 1";
				table = new FindCustomer().toTable(select);
				root.removeAll();
				root.add(new JScrollPane(table));
				root.revalidate();
				dispose();
			}
		});
		ok.setBounds(165, 80, 60, 25);
		contain.add(ok);
		setLocation(100, 100);
		setTitle("查找客户");
		setSize(new Dimension (370,140));
		setIconImage(new ImageIcon("icons/logo1.png").getImage());
		setVisible(true);
	}
	
}
	
	