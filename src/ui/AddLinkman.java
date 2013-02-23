package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import db.DerbyConnection;

public class AddLinkman extends JFrame{

	Container contain ;
	Statement state ;
	ResultSet rs ;
	String[] arrayCustomer;
	String[] arrayAge;
	String[] arrayBusiness;
	public AddLinkman()
	{
		try {
			state = DerbyConnection.f_getConnect().createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int row = 0;
		try {
			rs = state.executeQuery("select name from client where active = 1");
			while(rs.next())
				row++;
			arrayCustomer = new String[row];
			rs = state.executeQuery("select name from client where active = 1");
			row = 0;
			while(rs.next())
			{
				arrayCustomer[row] = rs.getString(1);
				row++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		arrayAge = new String[62];
		for(int i = 0;i<62;i++)
			arrayAge[i] = ""+(i+18);
		arrayBusiness = new String[]{"经理","职员"};
		faceSet();
		frameSet();
	}
	
	JComboBox company;
	JTextField name;
	JRadioButton man;
	JRadioButton woman;
	JComboBox age;
	JComboBox business;
	JTextField mobilephone;
	JTextField telephone;
	JTextField fax;
	JTextArea description;
	JButton ok;
	int signGender=1;
	
	String str1;
	String str2;
	String str3;
	String str4;
	String str5;
	String str6;
	String str7;
	String str8;
	String str9;
	public void faceSet()
	{
		contain = getContentPane();
	
		JLabel label = new JLabel("添加联系人",JLabel.CENTER);
		label.setFont(new Font(null,Font.BOLD,17));
		label.setForeground(Color.BLUE);
		contain.add(label,BorderLayout.NORTH);
		JPanel jpanel = new JPanel();
		jpanel.setLayout(null);
		
		
		label = new JLabel("公司");
		label.setBounds(10, 10, 30, 20);
		jpanel.add(label);
		company =new JComboBox(arrayCustomer);
		company.setBounds(45, 10, 90, 20);
		jpanel.add(company);
		
		label = new JLabel("姓名");
		label.setBounds(160, 10, 30, 20);
		jpanel.add(label);
		name = new JTextField();
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
		name.setBounds(195, 10, 90, 20);
		jpanel.add(name);
		
		label = new JLabel("性别");
		label.setBounds(10, 40, 30, 20);
		jpanel.add(label);
		man = new JRadioButton("男");
		man.setSelected(true);
		man.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				signGender = 1;
			}
		
		});
		man.setBounds(50, 40, 40, 20);
		jpanel.add(man);
		woman = new JRadioButton("女");
		woman.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				signGender = 2;
			}
		
		});
		woman.setBounds(100, 40, 40, 20);
		jpanel.add(woman);
		ButtonGroup buttons = new ButtonGroup();
		buttons.add(man);
		buttons.add(woman);
		
		label = new JLabel("年龄");
		label.setBounds(160, 40, 30, 20);
		jpanel.add(label);
		age = new JComboBox(arrayAge);
		age.setSelectedItem("20");
		age.setBounds(195, 40, 60, 20);
		jpanel.add(age);
		
		label = new JLabel("职务");
		label.setBounds(10, 70, 30, 20);
		jpanel.add(label);
		business = new JComboBox(arrayBusiness);
		business.setSelectedIndex(1);
		business.setBounds(45, 70, 70, 20);
		jpanel.add(business);
		
		label = new JLabel("手机");
		label.setBounds(160, 70, 30, 20);
		jpanel.add(label);
		mobilephone = new JTextField();
		mobilephone.addKeyListener(new KeyListener()
		{

			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				String getName = mobilephone.getText();
				if(getName.length()>11)
				{
					JOptionPane.showMessageDialog(null, "手机号码长度不能超过11位");
					mobilephone.setText("");
				}
				if(!(arg0.getKeyChar()>='0'&&arg0.getKeyChar()<='9'))
				{
					JOptionPane.showMessageDialog(null, "此处只能输入数字");
					mobilephone.setText("");
				}
			}

			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		mobilephone.setBounds(195, 70, 90, 20);
		jpanel.add(mobilephone);
		
		label = new JLabel("固话");
		label.setBounds(10, 100, 30, 20);
		jpanel.add(label);
		telephone = new JTextField();
		telephone.addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				String getName = telephone.getText();
				if(getName.length()>20)
				{
					JOptionPane.showMessageDialog(null, "固定电话长度不能超过20位");
					telephone.setText("");
				}
				if(!((arg0.getKeyChar()>='0'&&arg0.getKeyChar()<='9')||arg0.getKeyChar()=='-'))
				{
					JOptionPane.showMessageDialog(null, "此处只能输入数字或‘—’");
					telephone.setText("");
				}
			}

		});
		telephone.setBounds(45 , 100, 90, 20);
		jpanel.add(telephone);
		
		label = new JLabel("传真");
		label.setBounds(160, 100, 30, 20);
		jpanel.add(label);
		fax = new JTextField();
		fax.addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				String getName = fax.getText();
				if(getName.length()>20)
				{
					JOptionPane.showMessageDialog(null, "传真号码长度不能超过20位");
					fax.setText("");
				}
				if(!((arg0.getKeyChar()>='0'&&arg0.getKeyChar()<='9')||arg0.getKeyChar()=='-'))
				{
					JOptionPane.showMessageDialog(null, "此处只能输入数字或‘—’");
					fax.setText("");
				}
			}
		});
		fax.setBounds(195, 100, 90, 20);
		jpanel.add(fax);
		
		JSeparator sep = new JSeparator();
		sep.setBounds(10, 130, 270, 2);
		jpanel.add(sep);
		
		label = new JLabel("描述： (500字)");
		label.setBounds(10, 140, 90, 20);
		jpanel.add(label);
		description = new JTextArea();
		description.addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				String getName = description.getText();
				if(getName.length()>490)
				{
					JOptionPane.showMessageDialog(null, "描述长度不能超过500个字");
					description.setText(getName.substring(0, getName.length()-10));
				}
				
			}
		});
		description.setBorder(BorderFactory.createLineBorder(Color.gray));
		
		JScrollPane scrollPane1 = new JScrollPane(description);
		scrollPane1.setBounds(50, 165, 230, 120);
		jpanel.add(scrollPane1);
		
		ok = new JButton("确定");
		ok.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(company.getSelectedIndex()==-1)
					JOptionPane.showMessageDialog(null, "公司名称不能为空");
				else 
				{
					str1 = (String)company.getSelectedItem();
					str2 = name.getText().trim();
					if(str2.length()==0)
						JOptionPane.showMessageDialog(null, "姓名不能为空！");
					else
					{
						int row = 0;
						try {
							rs = state.executeQuery("select name from linkman where company = '"+str1+"'");
							while(rs.next())
								row++;
							String[] temp = new String[row];
							rs = state.executeQuery("select name from linkman where company = '"+str1+"'");
							row = 0;
							while(rs.next())
							{
								temp[row] = rs.getString(1).trim();
								if(temp[row].equals(str2))
								{
									row = -1;
									break;
								}
								row++;
							}
							
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						if(row == -1)
							JOptionPane.showMessageDialog(null, "此联系人已经在该公司中，不能重复添加！");
						else
						{
							if(signGender == 1)
								str3 = "男";
							else
								str3 = "女";
							str4 = (String)age.getSelectedItem();
							str5 = (String)business.getSelectedItem();
							str6 = mobilephone.getText().trim();
							str7 = telephone.getText().trim();
							str8 = fax.getText().trim();
							str9 = description.getText();
							Calendar ca = Calendar.getInstance();
							int year = ca.get(Calendar.YEAR);
							int month = ca.get(Calendar.MONTH)+1;
							int day = ca.get(Calendar.DAY_OF_MONTH);
							String strDate = year+"-"+month+"-"+day;
							try {
								state.execute("insert into linkman values ('"+str1+"','"+str2+"','"+str3+"',"+str4+",'"+str5+"','"+str6+"','"+str7+"','"+str8+"','"+str9+"','"+strDate+"','"+strDate+"',1)");
								dispose();
								JOptionPane.showMessageDialog(null, "添加联系人成功！");
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				}
			}
			
		});
		ok.setBounds(120, 300, 60, 20);
		jpanel.add(ok);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(jpanel);
		contain.add(scrollPane);
	}
	
	public void frameSet()
	{
		setTitle("添加联系人");
		setLocation(200, 100);
		setSize(new Dimension(300,380));
		setResizable(false);
		setIconImage(new ImageIcon("icons/logo1.png").getImage());
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}
}
