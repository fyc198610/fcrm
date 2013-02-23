package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import sun.font.Font2D;

import db.DerbyConnection;


public class AddEmployee extends JFrame{
	
	Statement state;
	Container contain = getContentPane();
	
	public AddEmployee()
	{
		try {
			state = DerbyConnection.f_getConnect().createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		faceSet();
		frameSet();
	}
	
	JTextField number;
	JTextField name;
	JRadioButton man;
	JRadioButton woman;
	JComboBox age;
	JComboBox study;
	JTextField mobilePhone;
	JTextField telePhone;
	JComboBox business;
	JTextArea address;
	JTextArea description;
	JButton button ;
	String str1;
	String str2;
	String str3;
	int str4;
	String str5;
	String str6;
	String str7;
	String str8;
	String str9;
	String str10;
	String str11;
	public void faceSet()
	{
		Integer[] ageArray = new Integer[53];
		for(int i = 0; i<53;i++)
			ageArray[i] = i+18;
		String[] studyArray = {"高中","专科","本科","硕士","博士"};
		String[] businessArray = {"职员","经理"};
		
		JPanel jpanel = new JPanel();
		jpanel.setLayout(null);
		JLabel label1 = new JLabel("编号");
		label1.setBounds(15, 15, 30, 20);
		jpanel.add(label1);
		
		number = new JTextField();
		number.setBounds(60, 15, 90, 20);
		jpanel.add(number);
		number.addKeyListener(new KeyListener()
		{

			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				String getNumber = new String();
				getNumber = number.getText();
				if(getNumber.length()>10)
				{
					JOptionPane.showMessageDialog(null, "编号长度不能超过10");
					number.setText("");
					
				}
			}

			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		JLabel label2 = new JLabel("姓名");
		label2.setBounds(180, 15, 30, 20);
		jpanel.add(label2);
		
		name = new JTextField();
		name.setBounds(225, 15, 90, 20);
		jpanel.add(name);
		name.addKeyListener(new KeyListener()
		{

			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				String getName = new String();
				getName = name.getText();
				if(getName.length()>5)
				{
					JOptionPane.showMessageDialog(null, "姓名长度不能超过5");
					name.setText("");
				}
			}

			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		JLabel label3 = new JLabel("性别");
		label3.setBounds(15, 50, 30, 20);
		jpanel.add(label3);
		
		man = new JRadioButton("男");
		man.setSelected(true);
		man.setBounds(60, 50, 40, 20);
		jpanel.add(man);
		woman = new JRadioButton("女");
		woman.setBounds(110, 50, 40, 20);
		jpanel.add(woman);
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(man);
		buttonGroup.add(woman);
		
		JLabel label4 = new JLabel("年龄");
		label4.setBounds(180, 50, 30, 20);
		jpanel.add(label4);
		
		age = new JComboBox(ageArray);
		age.setBounds(225, 50, 75, 20);
		age.setSelectedIndex(2);
		jpanel.add(age);
		
		JLabel label5 = new JLabel("学历");
		label5.setBounds(15, 85, 30, 20);
		jpanel.add(label5);
		
		study = new JComboBox(studyArray);
		study.setSelectedIndex(2);
		study.setBounds(60, 85, 75, 20);
		jpanel.add(study);
		
		JLabel label6 = new JLabel("手机");
		label6.setBounds(15, 120, 30, 20);
		jpanel.add(label6);
		
		mobilePhone = new JTextField();
		mobilePhone.setBounds(60, 120, 90, 20);
		jpanel.add(mobilePhone);
		mobilePhone.addKeyListener(new KeyListener()
		{

			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				String getMobile = mobilePhone.getText();
				if(getMobile.length()>11)
				{
					JOptionPane.showMessageDialog(null, "手机号长度不能超过11位");
					mobilePhone.setText("");
					
				}
			}

			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		JLabel label8 = new JLabel("固话");
		label8.setBounds(180, 85, 30, 20);
		jpanel.add(label8);
		
		telePhone = new JTextField();
		telePhone.setBounds(225, 85, 90, 20);
		jpanel.add(telePhone);
		telePhone.addKeyListener(new KeyListener()
		{

			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				String gettele = telePhone.getText();
				if(gettele.length()>20)
				{
					JOptionPane.showMessageDialog(null, "固定电话长度不能超过20位");
					telePhone.setText("");
				}
			}

			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		JLabel label9 = new JLabel("职务");
		label9.setBounds(180, 120, 30, 20);
		jpanel.add(label9);
		
		business = new JComboBox(businessArray);
		business.setSelectedIndex(0);
		business.setBounds(225, 120, 75, 20);
		jpanel.add(business);
		
		JLabel label10 = new JLabel("地址");
		label10.setBounds(15, 155, 30, 20);
		jpanel.add(label10);
		
		JLabel label11 = new JLabel("请输入不要超过50个字");
		label11.setFont(new Font(null,Font.ITALIC,12));
		label11.setBounds(60, 155, 180, 20);
		jpanel.add(label11);
		
		address = new JTextArea();
		JScrollPane scrollPane1 = new JScrollPane(address);
		scrollPane1.setBounds(60, 180, 240, 60);
		jpanel.add(scrollPane1);
		
		JLabel label12 = new JLabel("描述");
		label12.setBounds(15, 250, 30, 20);
		jpanel.add(label12);
		
		JLabel label13 = new JLabel("请输入不要超过200个字");
		label13.setFont(new Font(null,Font.ITALIC,12));
		label13.setBounds(60, 250, 180, 20);
		jpanel.add(label13);
		
		description = new JTextArea();
		JScrollPane scrollPane2 = new JScrollPane(description);
		scrollPane2.setBounds(60, 275, 240, 90);
		jpanel.add(scrollPane2);
		
		button = new JButton("确定");
		button.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				str1 = number.getText();
				str2 = name.getText();
				if(man.isSelected())
					str3 = "男";
				else str3 = "女";
				str4 = (Integer)age.getSelectedItem();
				str5 = (String)study.getSelectedItem();
				str6 = mobilePhone.getText();
				str7 = telePhone.getText();
				str8 = (String)business.getSelectedItem();
				str9 = address.getText();
				str10 = description.getText();
				Calendar ca = Calendar.getInstance();
				int year = ca.get(Calendar.YEAR);
				int month = ca.get(Calendar.MONTH)+1;
				int day = ca.get(Calendar.DAY_OF_MONTH);
				str11 = year+"-"+month+"-"+day;
				
				int numberCount = 0;
				String[] allNumber = null;
				String[] allName = null;
				try {
					ResultSet rs = state.executeQuery("select number from employee");
					while(rs.next())
						numberCount++;
					allNumber = new String[numberCount];
					rs = state.executeQuery("select number from employee");
					int i = 0;
					while(rs.next())
					{
						allNumber[i] = rs.getString(1);
						i++;
					}
					
					allName = new String[numberCount];
					rs = state.executeQuery("select name from employee");
					i = 0;
					while(rs.next())
					{
						allName[i] = rs.getString(1);
						i++;
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				int sign0 = 1;
				int sign1 = 1;
				int sign2 = 1;
				int sign3 = 1;
				int sign4 = 1;
				
				char[] number = str1.toCharArray();
				char[] mobilePhone = str6.toCharArray();
				char[] telePhone = str7.toCharArray();
				for(int i = 0; i<number.length;i++)
					if(!((number[i]>='0'&&number[i]<='9')||(number[i]>='a'&&number[i]<='z')||(number[i]>='A'&&number[i]<='Z')))
						{
						sign0 = 0;
						break;
						}
				if(str1.trim().length()==0)
					JOptionPane.showMessageDialog(null, "编号不能为空");
				else
				{
					if(str2.trim().length()==0)
						JOptionPane.showMessageDialog(null, "姓名不能为空");
					else
					{
						if(sign0 == 0)
								JOptionPane.showMessageDialog(null, "编号只能为数字或字母");
						else
						{
							for(int j = 0;j<allNumber.length;j++)
								{
									if(str1.trim().equals(allNumber[j].trim()))
										sign1 = 0;
								}
								if(sign1 == 0)
								{
									JOptionPane.showMessageDialog(null, "此编号已存在");
								}
								else
								{
									for(int k = 0;k<allName.length;k++)
									{
										if(str2.trim().equals(allName[k].trim()))
											sign2 = 0;
									}
									if(sign2 == 0)
									{
										JOptionPane.showMessageDialog(null, "此姓名已存在");
									}
									else
									{
										for(int m = 0;m<mobilePhone.length;m++)
											if(!(mobilePhone[m]>='0'&&mobilePhone[m]<='9'))
											{
												sign3 = 0;
												break;
											}
										if(sign3 == 0)
											JOptionPane.showMessageDialog(null, "电话号码只能由数字组成");
										else
										{
											for(int n = 0;n<telePhone.length;n++)
												if(!((telePhone[n]>='0'&&telePhone[n]<='9')||(telePhone[n]=='-')))
												{
													sign4 = 0;
													System.out.println(telePhone[n]);
													break;
												}
											if(sign4 == 0)
												JOptionPane.showMessageDialog(null, "电话号码只能由数字或”-“组成");
											else
											{
												if(str9.length()>50)
													JOptionPane.showMessageDialog(null, "地址不能超过50个字");
												else
												{
													if(str10.length()>200)
														JOptionPane.showMessageDialog(null, "描述不能超过200个字");
													else
													{
														try {
															state.execute("insert into employee values ('"+str1+"','"+str2+"','"+str3+"',"+str4+",'"+str5+"','"+str6+"','"+str7+"','"+str8+"','"+str9+"','"+str10+"','"+str11+"','123456')");
															dispose();
															JOptionPane.showMessageDialog(null, "添加成功");
															
														} catch (SQLException e) {
															// TODO Auto-generated catch block
															e.printStackTrace();
														}
													}
												}
											}
										}
										
									}
								}
								
						}
					}
			}
					
				
			}
			
		});
		button.setBounds(135, 375, 60, 20);
		jpanel.setBorder(BorderFactory.createLineBorder(Color.gray));
		jpanel.add(button);
		contain.add(jpanel);
		JLabel header = new JLabel("添加新员工",JLabel.CENTER);
		header.setForeground(Color.blue);
		header.setFont(new Font(null,Font2D.TTF_RANK,18));
		contain.add(header,BorderLayout.NORTH);
	}
	
	public void frameSet()
	{
		setTitle("添加新员工");
		setSize(new Dimension(350,460));
		setLocation(100, 100);
		setIconImage(new ImageIcon("icons/logo1.png").getImage());
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
	}
	
}
