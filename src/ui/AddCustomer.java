package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.WindowConstants;

import sun.font.Font2D;

import com.sun.java.swing.plaf.windows.WindowsTreeUI.CollapsedIcon;
import com.sun.org.apache.bcel.internal.generic.F2D;

import db.DerbyConnection;

public class AddCustomer extends JFrame{

	Statement state;
	String userName;
	Container contain ;
	
	public AddCustomer(String userName)
	{
		try {
//			DerbyConnection.f_setConnect();//测试时使用
			state = DerbyConnection.f_getConnect(). createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.userName = userName;
		contain = getContentPane();
		faceSet();
		frameSet();
	}
	
	
	JTabbedPane tabbedpane;
	JTextField number;
	JTextField name;
	JTextField principal;
	JComboBox vocation;
	String[] arrayVocation;
	JTextField zhucezijin;
	JTextField kaihuhang;
	JTextField zhanghao;
	JTextField shuihao;
	JTextField nianyingyee;
	JTextField wangzhi;
	JTextField yuwosnjye;
	JTextField yiwanchengjye;
	JTextField linkman;
	JTextField mobilePhone;
	JTextField telePhone;
	JTextField fax;
	JButton star1;
	JButton star2;
	JButton star3;
	JButton star4;
	JButton star5;
	JTextArea creditdes;
	JTextArea address;
	JButton ok;
	JButton cancel;
	int creditLog=1;
	ImageIcon image1;
	ImageIcon image2;
	
	String str1;
	String str2;
	String str3;
	String str4;
	int	   str5;
	String str6;
	String str7;
	String str8;
	int    str9;
	String str10;
	int    str11;
	int    str12;
	String str13;
	String str14;
	String str15;
	String str16;
	String str17;
	String str18;
	public void faceSet()
	{
		tabbedpane = new JTabbedPane();
		Box box1 = Box.createVerticalBox();
		Box box2 = Box.createVerticalBox();
		JLabel jlabel = null;
		JPanel jpanel= null;
		Box everyBox = null;
		
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JPanel panel4 = new JPanel();
		JPanel panel5 = new JPanel();
		JPanel panel6 = new JPanel();
		JPanel panel7 = new JPanel();
		JPanel bottom = new JPanel();
		
		JLabel header = new JLabel("添 加 新 客 户",JLabel.CENTER);
		header.setFont(new Font("楷体",Font.BOLD,18));
		contain.add(header,BorderLayout.NORTH);
		
		
		
		box1.add(panel1);
		panel1.setLayout(new GridLayout(4,2));
		panel1.setBorder(BorderFactory.createLineBorder(Color.gray));
		jpanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		everyBox = Box.createHorizontalBox();
		jlabel = new JLabel("客户编号");
		jlabel.setFont(new Font("宋体",Font.PLAIN,12));
		number = new JTextField();
		number.addKeyListener(new KeyListener()
		{

			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				String getName = new String();
				getName = number.getText();
				if(getName.length()>10)
				{
					JOptionPane.showMessageDialog(null, "编号长度不能超过10");
					number.setText("");
				}
			}

			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		number.setPreferredSize(new Dimension(100,20));
		everyBox.add(jlabel);
		everyBox.add(Box.createHorizontalStrut(40));
		everyBox.add(number);
		jpanel.add(everyBox);
		panel1.add(jpanel);
		
		jpanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		everyBox = Box.createHorizontalBox();
		jlabel = new JLabel("客户名称");
		jlabel.setFont(new Font("宋体",Font.PLAIN,12));
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
				if(getName.length()>50)
				{
					JOptionPane.showMessageDialog(null, "客户名称长度不能超过50");
					name.setText("");
				}
			}

			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		name.setPreferredSize(new Dimension(100,20));
		everyBox.add(jlabel);
		everyBox.add(Box.createHorizontalStrut(40));
		everyBox.add(name);
		jpanel.add(everyBox);
		panel1.add(jpanel);
		
		jpanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		everyBox = Box.createHorizontalBox();
		jlabel = new JLabel("负 责 人");
		jlabel.setFont(new Font("宋体",Font.PLAIN,12));
		principal = new JTextField();
		principal.addKeyListener(new KeyListener()
		{

			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				String getName = new String();
				getName = principal.getText();
				if(getName.length()>5)
				{
					JOptionPane.showMessageDialog(null, "负责人长度不能超过5");
					principal.setText("");
				}
			}

			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		principal.setPreferredSize(new Dimension(100,20));
		everyBox.add(jlabel);
		everyBox.add(Box.createHorizontalStrut(39));
		everyBox.add(principal);
		jpanel.add(everyBox);
		panel1.add(jpanel);
		
		arrayVocation = new String[]{"电子贸易商","太阳能","汽车整流器","摩托车","点焊机","豆浆机","音箱"};
		jpanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		everyBox = Box.createHorizontalBox();
		jlabel = new JLabel("行    业");
		jlabel.setFont(new Font("宋体",Font.PLAIN,12));
		vocation = new JComboBox(arrayVocation);
		vocation.setFont(new Font("宋体",Font.PLAIN,12));
		vocation.setPreferredSize(new Dimension(100,20));
		vocation.setSelectedIndex(0);
		everyBox.add(jlabel);
		everyBox.add(Box.createHorizontalStrut(40));
		everyBox.add(vocation);
		jpanel.add(everyBox);
		panel1.add(jpanel);
		
		jpanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		everyBox = Box.createHorizontalBox();
		jlabel = new JLabel("联 系 人");
		jlabel.setFont(new Font("宋体",Font.PLAIN,12));
		linkman = new JTextField();
		linkman.addKeyListener(new KeyListener()
		{

			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				String getName = new String();
				getName = linkman.getText();
				if(getName.length()>5)
				{
					JOptionPane.showMessageDialog(null, "联系人长度不能超过5");
					linkman.setText("");
				}
				
			}

			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		linkman.setPreferredSize(new Dimension(100,20));
		everyBox.add(jlabel);
		everyBox.add(Box.createHorizontalStrut(39));
		everyBox.add(linkman);
		jpanel.add(everyBox);
		panel1.add(jpanel);
		
		jpanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		everyBox = Box.createHorizontalBox();
		jlabel = new JLabel("手    机");
		jlabel.setFont(new Font("宋体",Font.PLAIN,12));
		mobilePhone = new JTextField();
		mobilePhone.addKeyListener(new KeyListener()
		{

			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				String getName = new String();
				getName = mobilePhone.getText();
				if(getName.length()>11)
				{
					JOptionPane.showMessageDialog(null, "手机号长度不能超过11位");
					mobilePhone.setText("");
				}
				char inputChar = e.getKeyChar();
				if(!(inputChar>='0'&&inputChar<='9'))
				{
					JOptionPane.showMessageDialog(null, "此处只能输入数字");
					mobilePhone.setText("");
				}
			}

			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		mobilePhone.setPreferredSize(new Dimension(100,20));
		everyBox.add(jlabel);
		everyBox.add(Box.createHorizontalStrut(40));
		everyBox.add(mobilePhone);
		jpanel.add(everyBox);
		panel1.add(jpanel);
		
		jpanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		everyBox = Box.createHorizontalBox();
		jlabel = new JLabel("固    话");
		jlabel.setFont(new Font("宋体",Font.PLAIN,12));
		telePhone = new JTextField();
		telePhone.addKeyListener(new KeyListener()
		{

			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				char inputChar = e.getKeyChar();
				if(!((inputChar>='0'&&inputChar<='9')||inputChar=='-'))
				{
					JOptionPane.showMessageDialog(null, "此处只能输入数字或“-”");
					telePhone.setText("");
				}
				String getName = new String();
				getName = telePhone.getText();
				if(getName.length()>20)
				{
					JOptionPane.showMessageDialog(null, "固话长度不能超过20位");
					telePhone.setText("");
				}
			}

			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		telePhone.setPreferredSize(new Dimension(100,20));
		everyBox.add(jlabel);
		everyBox.add(Box.createHorizontalStrut(40));
		everyBox.add(telePhone);
		jpanel.add(everyBox);
		panel1.add(jpanel);
		
		jpanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		everyBox = Box.createHorizontalBox();
		jlabel = new JLabel("传    真");
		jlabel.setFont(new Font("宋体",Font.PLAIN,12));
		fax = new JTextField();
		fax.addKeyListener(new KeyListener()
		{

			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				char inputChar = e.getKeyChar();
				if(!((inputChar>='0'&&inputChar<='9')||inputChar=='-'))
				{
					JOptionPane.showMessageDialog(null, "此处只能输入数字或“-”");
					fax.setText("");
				}
				String getName = new String();
				getName = fax.getText();
				if(getName.length()>20)
				{
					JOptionPane.showMessageDialog(null, "传真长度不能超过20位");
					fax.setText("");
				}
			}

			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		fax.setPreferredSize(new Dimension(100,20));
		everyBox.add(jlabel);
		everyBox.add(Box.createHorizontalStrut(40));
		everyBox.add(fax);
		jpanel.add(everyBox);
		panel1.add(jpanel);
		
		
		
		
		box1.add(panel2);
		panel2.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel2.setBorder(BorderFactory.createLineBorder(Color.gray));
		jlabel = new JLabel("所属业务员：");
		jlabel.setFont(new Font("宋体",Font.PLAIN,12));
		panel2.add(jlabel);
		jlabel = new JLabel(userName);
		jlabel.setFont(new Font("宋体",Font.PLAIN,12));
		panel2.add(jlabel);
		
		
		
		
		box1.add(panel3);
		panel3.setLayout(new BorderLayout());
		panel3.setBorder(BorderFactory.createLineBorder(Color.gray));
		jpanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		jlabel = new JLabel("客户信誉度：");
		jlabel.setFont(new Font("宋体",Font.PLAIN,12));
		image1 = new ImageIcon("icons/star1.jpg");
		image2 = new ImageIcon("icons/star2.jpg");
		star1 = new JButton(image1);
		star1.setRolloverEnabled(true);
		star1.setRolloverIcon(image2);
		star1.setMargin(new Insets(0,0,0,0));
		star1.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				star1.setIcon(image2);
				star2.setIcon(image1);
				star3.setIcon(image1);
				star4.setIcon(image1);
				star5.setIcon(image1);
				creditLog = 1;
			}
			
		});
		star2 = new JButton(new ImageIcon("icons/star1.jpg"));
		star2.setRolloverEnabled(true);
		star2.setRolloverIcon(new ImageIcon("icons/star2.jpg"));
		star2.setMargin(new Insets(0,0,0,0));
		star2.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				star1.setIcon(image2);
				star2.setIcon(image2);
				star3.setIcon(image1);
				star4.setIcon(image1);
				star5.setIcon(image1);
				creditLog = 2;
			}
			
		});
		star3 = new JButton(new ImageIcon("icons/star1.jpg"));
		star3.setRolloverEnabled(true);
		star3.setRolloverIcon(new ImageIcon("icons/star2.jpg"));
		star3.setMargin(new Insets(0,0,0,0));
		star3.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				star1.setIcon(image2);
				star2.setIcon(image2);
				star3.setIcon(image2);
				star4.setIcon(image1);
				star5.setIcon(image1);
				creditLog = 3;
			}
			
		});
		star4 = new JButton(new ImageIcon("icons/star1.jpg"));
		star4.setRolloverEnabled(true);
		star4.setRolloverIcon(new ImageIcon("icons/star2.jpg"));
		star4.setMargin(new Insets(0,0,0,0));
		star4.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				star1.setIcon(image2);
				star2.setIcon(image2);
				star3.setIcon(image2);
				star4.setIcon(image2);
				star5.setIcon(image1);
				creditLog = 4;
			}
			
		});
		star5 = new JButton(new ImageIcon("icons/star1.jpg"));
		star5.setRolloverEnabled(true);
		star5.setRolloverIcon(new ImageIcon("icons/star2.jpg"));
		star5.setMargin(new Insets(0,0,0,0));
		star5.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				star1.setIcon(image2);
				star2.setIcon(image2);
				star3.setIcon(image2);
				star4.setIcon(image2);
				star5.setIcon(image2);
				creditLog = 5;
			}
			
		});
		jpanel.add(jlabel);
		jpanel.add(star1);
		jpanel.add(star2);
		jpanel.add(star3);
		jpanel.add(star4);
		jpanel.add(star5);
		panel3.add(jpanel,BorderLayout.NORTH);
		
		box1.add(panel4);
		panel4.setLayout(new BorderLayout());
		Box box4 = Box.createHorizontalBox();
		box4.add(Box.createRigidArea(new Dimension(5,65)));
		jpanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		jlabel = new JLabel("地址：(50字)");
		jlabel.setFont(new Font("宋体",Font.PLAIN,12));
		jpanel.add(jlabel);
		panel4.add(jpanel,BorderLayout.NORTH);
		address = new JTextArea();
		address.addKeyListener(new KeyListener()
		{

			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				String getName = new String();
				getName = address.getText();
				if(getName.length()>50)
				{
					JOptionPane.showMessageDialog(null, "地址长度不能超过50位");
					creditdes.setText(getName.substring(0, 50));
				}
			}

			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		box4.add(new JScrollPane(address));
		box4.add(Box.createHorizontalStrut(5));
		panel4.add(box4);
		
		box1.add(Box.createVerticalStrut(5));
		
		JScrollPane boxScrollPane = new JScrollPane(box1);
		tabbedpane.add("基本信息", boxScrollPane);
		
		
		
		
		
		
		box2.add(panel5);
		panel5.setLayout(new GridLayout(4,2));
		panel5.setBorder(BorderFactory.createLineBorder(Color.gray));
		
		jpanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		everyBox = Box.createHorizontalBox();
		jlabel = new JLabel("注册资金");
		jlabel.setFont(new Font("宋体",Font.PLAIN,12));
		zhucezijin = new JTextField();
		zhucezijin.addKeyListener(new KeyListener()
		{

			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				char inputChar = arg0.getKeyChar();
				if(!(inputChar>='0'&&inputChar<='9'))
				{
					JOptionPane.showMessageDialog(null, "此处只能输入数字");
					zhucezijin.setText("");
				}
			}

			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		zhucezijin.setPreferredSize(new Dimension(100,20));
		everyBox.add(jlabel);
		everyBox.add(Box.createHorizontalStrut(42));
		everyBox.add(zhucezijin);
		jpanel.add(everyBox);
		panel5.add(jpanel);
		
		jpanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		everyBox = Box.createHorizontalBox();
		jlabel = new JLabel("开 户 行");
		jlabel.setFont(new Font("宋体",Font.PLAIN,12));
		kaihuhang = new JTextField();
		kaihuhang.addKeyListener(new KeyListener()
		{

			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				String getName = new String();
				getName = kaihuhang.getText();
				if(getName.length()>50)
				{
					JOptionPane.showMessageDialog(null, "开户行长度不能超过50");
					kaihuhang.setText("");
				}
			}

			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		kaihuhang.setPreferredSize(new Dimension(100,20));
		everyBox.add(jlabel);
		everyBox.add(Box.createHorizontalStrut(40));
		everyBox.add(kaihuhang);
		jpanel.add(everyBox);
		panel5.add(jpanel);
		
		jpanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		everyBox = Box.createHorizontalBox();
		jlabel = new JLabel("帐    号");
		jlabel.setFont(new Font("宋体",Font.PLAIN,12));
		zhanghao = new JTextField();
		zhanghao.addKeyListener(new KeyListener()
		{

			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				char inputChar = e.getKeyChar();
				if(!((inputChar>='0'&&inputChar<='9')||inputChar=='-'))
				{
					JOptionPane.showMessageDialog(null, "此处只能输入数字或“-”");
					zhanghao.setText("");
				}
				String getName = new String();
				getName = zhanghao.getText();
				if(getName.length()>30)
				{
					JOptionPane.showMessageDialog(null, "帐号长度不能超过30");
					zhanghao.setText("");
				}
			}

			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		zhanghao.setPreferredSize(new Dimension(100,20));
		everyBox.add(jlabel);
		everyBox.add(Box.createHorizontalStrut(42));
		everyBox.add(zhanghao);
		jpanel.add(everyBox);
		panel5.add(jpanel);
		
		jpanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		everyBox = Box.createHorizontalBox();
		jlabel = new JLabel("税    号");
		jlabel.setFont(new Font("宋体",Font.PLAIN,12));
		shuihao = new JTextField();
		shuihao.addKeyListener(new KeyListener()
		{

			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				char inputChar = e.getKeyChar();
				if(!((inputChar>='0'&&inputChar<='9')||inputChar=='-'))
				{
					JOptionPane.showMessageDialog(null, "此处只能输入数字或“-”");
					shuihao.setText("");
				}
				String getName = new String();
				getName = shuihao.getText();
				if(getName.length()>30)
				{
					JOptionPane.showMessageDialog(null, "税号长度不能超过30");
					shuihao.setText("");
				}
			}

			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		shuihao.setPreferredSize(new Dimension(100,20));
		everyBox.add(jlabel);
		everyBox.add(Box.createHorizontalStrut(40));
		everyBox.add(shuihao);
		jpanel.add(everyBox);
		panel5.add(jpanel);
		
		jpanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		everyBox = Box.createHorizontalBox();
		jlabel = new JLabel("年营业额");
		jlabel.setFont(new Font("宋体",Font.PLAIN,12));
		nianyingyee = new JTextField();
		nianyingyee.addKeyListener(new KeyListener()
		{

			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				char inputChar = e.getKeyChar();
				if(!(inputChar>='0'&&inputChar<='9'))
				{
					JOptionPane.showMessageDialog(null, "此处只能输入数字");
					nianyingyee.setText("");
				}
			}

			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		nianyingyee.setPreferredSize(new Dimension(100,20));
		everyBox.add(jlabel);
		everyBox.add(Box.createHorizontalStrut(42));
		everyBox.add(nianyingyee);
		jpanel.add(everyBox);
		panel5.add(jpanel);
		
		jpanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		everyBox = Box.createHorizontalBox();
		jlabel = new JLabel("网    址");
		jlabel.setFont(new Font("宋体",Font.PLAIN,12));
		wangzhi = new JTextField();
		wangzhi.addKeyListener(new KeyListener()
		{

			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				String getName = new String();
				getName = wangzhi.getText();
				if(getName.length()>50)
				{
					JOptionPane.showMessageDialog(null, "网址长度不能超过50");
					wangzhi.setText("");
				}
			}

			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		wangzhi.setPreferredSize(new Dimension(100,20));
		everyBox.add(jlabel);
		everyBox.add(Box.createHorizontalStrut(40));
		everyBox.add(wangzhi);
		jpanel.add(everyBox);
		panel5.add(jpanel);
		
		jpanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		everyBox = Box.createHorizontalBox();
		jlabel = new JLabel("与我司年交易额");
		jlabel.setFont(new Font("宋体",Font.PLAIN,12));
		yuwosnjye = new JTextField();
		yuwosnjye.addKeyListener(new KeyListener()
		{

			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				char inputChar = e.getKeyChar();
				if(!(inputChar>='0'&&inputChar<='9'))
				{
					JOptionPane.showMessageDialog(null, "此处只能输入数字");
					yuwosnjye.setText("");
				}
			}

			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		yuwosnjye.setPreferredSize(new Dimension(100,20));
		everyBox.add(jlabel);
		everyBox.add(Box.createHorizontalStrut(7));
		everyBox.add(yuwosnjye);
		jpanel.add(everyBox);
		panel5.add(jpanel);
		
		jpanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		everyBox = Box.createHorizontalBox();
		jlabel = new JLabel("已完成交易额");
		jlabel.setFont(new Font("宋体",Font.PLAIN,12));
		yiwanchengjye = new JTextField();
		yiwanchengjye.addKeyListener(new KeyListener()
		{

			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				char inputChar = e.getKeyChar();
				if(!(inputChar>='0'&&inputChar<='9'))
				{
					JOptionPane.showMessageDialog(null, "此处只能输入数字");
					yiwanchengjye.setText("");
				}
			}

			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		yiwanchengjye.setPreferredSize(new Dimension(100,20));
		everyBox.add(jlabel);
		everyBox.add(Box.createHorizontalStrut(16));
		everyBox.add(yiwanchengjye);
		jpanel.add(everyBox);
		panel5.add(jpanel);
		
		
		
		box2.add(panel6);
		panel6.setLayout(new BorderLayout());
		Box boxh = Box.createHorizontalBox();
		jpanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		boxh.add(Box.createHorizontalStrut(7));
		jlabel = new JLabel("说明：(500字)");
		jlabel.setFont(new Font("宋体",Font.PLAIN,12));
		jpanel.add(jlabel);
		creditdes = new JTextArea();
		creditdes.addKeyListener(new KeyListener()
		{

			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				String getName = new String();
				getName = creditdes.getText();
				if(getName.length()>500)
				{
					JOptionPane.showMessageDialog(null, "描述长度不能超过500位");
					creditdes.setText(getName.substring(0, 500));
				}
			}

			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		JScrollPane scrollPane1 = new JScrollPane(creditdes);
		jlabel = new JLabel("请将客户的信誉说明写在下面");
		jlabel.setFont(new Font("宋体",Font.PLAIN,12));
		jpanel.add(jlabel);
		panel6.add(jpanel,BorderLayout.NORTH);
		boxh.add(Box.createHorizontalStrut(5));
		boxh.add(new JScrollPane(creditdes));
		boxh.add(Box.createHorizontalStrut(5));
		panel6.add(boxh);
		box2.add(Box.createVerticalStrut(10));
		boxScrollPane = new JScrollPane(box2);
		tabbedpane.add("其他信息",boxScrollPane);
		
		
		
		/*
		 * 此部分功能未完成
		 */
//		box.add(panel6);
//		panel6.setBorder(BorderFactory.createLineBorder(Color.gray));
//		panel6.add(new JLabel("客户分类。。。"));
		tabbedpane.add("客户分类",panel7);
		
		contain.add(tabbedpane);
		
		
		ok = new JButton("确定");
		ok.setFont(new Font("宋体",Font.PLAIN,12));
		ok.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int signNumber = 1;
				int signName = 1;
				str1 = number.getText().trim();
				str2 = name.getText().trim();
				if(str1.length()==0)
					JOptionPane.showMessageDialog(null, "编号不能为空");
				else if(str2.length()==0)
					JOptionPane.showMessageDialog(null, "客户名称不能为空");
				else
				{
				try {
					ResultSet rs = state.executeQuery("select number,name from client");
					while(rs.next())
					{
						if(str1.equals(rs.getString(1).trim()))
						{
							signNumber = 0;
							break;
						}
						else if(str2.equals(rs.getString(2).trim()))
						{
							signName = 0;
							break;
						}
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(signNumber == 0)
					JOptionPane.showMessageDialog(null, "此客户编号已经存在");
				else
					if(signName == 0)
						JOptionPane.showMessageDialog(null, "此客户名称已经存在	");
					else 
					{
						str3 = principal.getText().trim();
						str4 = (String)vocation.getSelectedItem();
						str5 = Integer.parseInt("0"+zhucezijin.getText().trim());
						if(str5>=Integer.MAX_VALUE)
							JOptionPane.showMessageDialog(null, "注册资金的数额太大");
						else
						{
							str6 = kaihuhang.getText().trim();
							str7 = zhanghao.getText().trim();
							str8 = shuihao.getText().trim();
							str9 = Integer.parseInt("0"+nianyingyee.getText().trim());
							if(str9>=Integer.MAX_VALUE)
								JOptionPane.showMessageDialog(null, "年营业额的数额太大");
							else
							{
								str10 = wangzhi.getText().trim();
								str11 = Integer.parseInt("0"+yuwosnjye.getText().trim());
								if(str11>=Integer.MAX_VALUE)
									JOptionPane.showMessageDialog(null, "与我司年交易额的数额太大");
								else
								{
									str12 = Integer.parseInt("0"+yiwanchengjye.getText().trim());
									if(str12>=Integer.MAX_VALUE)
										JOptionPane.showMessageDialog(null, "已完成交易额的数额太大");
									else
									{
										str13 = linkman.getText().trim();
										str14 = mobilePhone.getText().trim();
										str15 = telePhone.getText().trim();
										str16 = fax.getText().trim();
										str17 = creditdes.getText().trim();
										str18 = address.getText().trim();
										Calendar ca = Calendar.getInstance();
										int year = ca.get(Calendar.YEAR);
										int month = ca.get(Calendar.MONTH)+1;
										int day = ca.get(Calendar.DAY_OF_MONTH);
										String strDate = year+"-"+month+"-"+day;
										try {
											state.execute("insert into client values ('"+str1+"','"+str2+"','"+str3+"','"+str4+"',"+str5+",'"+str6+"','"+str7+
													"','"+str8+"',"+str9+","+str11+","+str12+",'"+str10+"','"+str13+"','"+str14+"','"+str15+"','"+str16+"','"+creditLog+"','"+str17+
													"','"+userName+"','"+str18+"','"+strDate+"','"+strDate+"','"+strDate+"',"+0+",1)");
											if(str13.length()!=0)
												state.execute("insert into linkman (company,name,mobilephone,telephone,fax,active) values ('"+str2+"','"+str13+"','"+str14+"','"+str15+"','"+str16+"',1)");
											dispose();
											JOptionPane.showMessageDialog(null, "客户添加成功");
										} catch (SQLException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										}
									}
								}
							}
						}
					}
				}
			}
		});
		cancel = new JButton("取消");
		cancel.setFont(new Font("宋体",Font.PLAIN,12));
		cancel.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
			
		});
		bottom.add(ok);
		bottom.add(new JLabel("    "));
		bottom.add(cancel);
		contain.add(bottom,BorderLayout.SOUTH);
		
		
	}
	
	public void frameSet()
	{
		setTitle("添加客户");
		setSize(new Dimension(465,420));
		setLocation(300, 80);
		setVisible(true);
//		setResizable(false);
		setIconImage(new ImageIcon("icons/logo1.png").getImage());
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
	}
	
//	public static void main(String[] args) 
//	{
//		new AddCustomer("冯雅超");
//	}

}
