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
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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

public class FindEmployeeFrame extends JFrame{

	JPanel root;
	Container contain;
	String select; 
	JTable table;
	public FindEmployeeFrame(JPanel root)
	{
		this.root = root;
		faceSet();
		frameSet();
	}
	
	JTextField name;
	JComboBox gender;
	JTextField address;
	JComboBox study;
	String[] arrayGender = {"男","女","不限"};
	String[] arrayStudy = {"高中","专科","本科","硕士","博士","不限"};
	JButton ok;
	String str1;
	String str2;
	String str3;
	String str4;
	String sqlStr1;
	String sqlStr2;
	String sqlStr3;
	String sqlStr4;
	public void faceSet()
	{
		contain = getContentPane();
		JLabel label = new JLabel("查询员工",JLabel.CENTER);
		label.setForeground(Color.blue);
		label.setFont(new Font(null,Font2D.TTF_RANK,18));
		contain.add(label,BorderLayout.NORTH);
		
		JPanel jpanel = new JPanel(new GridLayout(2,2));
		JPanel everyPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		everyPanel.add(new JLabel("姓名："));
		name = new JTextField();
		name.addKeyListener(new KeyListener()
		{

			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if(name.getText().length()>5)
				{
					JOptionPane.showMessageDialog(null, "姓名长度不能超过5！");
					name.setText("");
				}
			}

			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
			
			}

			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		name.setPreferredSize(new Dimension(90,20));
		everyPanel.add(name);
		jpanel.add(everyPanel);
		
		everyPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		everyPanel.add(new JLabel("性别："));
		gender = new JComboBox(arrayGender);
		gender.setSelectedItem("不限");
		gender.setPreferredSize(new Dimension(90,20));
		everyPanel.add(gender);
		jpanel.add(everyPanel);
		
		everyPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		everyPanel.add(new JLabel("地址："));
		address = new JTextField();
		address.addKeyListener(new KeyListener()
		{

			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if(address.getText().length()>50)
				{
					JOptionPane.showMessageDialog(null, "地址长度不能超过50！");
					address.setText(address.getText().substring(0, 45));
				}
					
			}

			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		address.setPreferredSize(new Dimension(90,20));
		everyPanel.add(address);
		jpanel.add(everyPanel);
		
		everyPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		everyPanel.add(new JLabel("学历："));
		study = new JComboBox(arrayStudy);
		study.setSelectedItem("不限");
		study.setPreferredSize(new Dimension(90,20));
		everyPanel.add(study);
		jpanel.add(everyPanel);
		
		contain.add(jpanel);
		ok = new JButton("确定");
		ok.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				str1 = name.getText().trim();
				if(str1.length()==0)
					sqlStr1 = "";
				else
					sqlStr1 = " and name like '%"+str1+"%'";
				str2 = (String)gender.getSelectedItem();
				if(str2.equals("不限"))
					sqlStr2 = "";
				else
					sqlStr2 = " and gender = '"+str2+"'";
				str3 = address.getText();
				if(str3.length()==0)
					sqlStr3 = "";
				else
					sqlStr3 = " and address = '%"+str3+"%'";
				str4 = (String)study.getSelectedItem();
				if(str4.equals("不限"))
					sqlStr4 = "";
				else
					sqlStr4 = " and study = '"+str4+"'";
				select = "select number,name,gender,age,study,mobilephone,joindate,address from employee where description like '%' "+sqlStr1+sqlStr2+sqlStr3+sqlStr4;
				table = new EmployeeTable(select).getTable();
				root.removeAll();
				root.add(new JScrollPane(table));
				root.revalidate();
//				for(;root.getParent()!=null;root = root.getParent());
//				root.setVisible(true);
				dispose();
			}
			
		});
		everyPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		everyPanel.add(ok);
		contain.add(everyPanel,BorderLayout.SOUTH);
	}
	
	public void frameSet()
	{
		setTitle("查找员工");
		setLocation(300, 100);
		//setSize(new Dimension(350,300));
		pack();
		setResizable(false);
		setIconImage(new ImageIcon("icons/logo1.png").getImage());
		setVisible(true);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}
	
}
