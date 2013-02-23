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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import sun.font.Font2D;

public class FindCreditFrame extends JFrame{

	JPanel root;
	Container contain;
	String select;
	
	public FindCreditFrame(JPanel root)
	{
		this.root = root;
		faceSet();
		frameSet();
	}
	
	JTextField company;
	JTextField linkman;
	JButton star1;
	JButton star2;
	JButton star3;
	JButton star4;
	JButton star5;
	JButton star6;
	JButton star7;
	JButton star8;
	JButton star9;
	JButton star10;
	int creditSign1 = 1;
	int creditSign2 = 5;
	JButton ok;
	String str1;
	String str2;
	String sqlStr1;
	String sqlStr2;
	public void faceSet()
	{
		contain = getContentPane();
		JLabel label = new JLabel("按信誉度查询客户",JLabel.CENTER);
		label.setForeground(Color.blue);
		label.setFont(new Font(null,Font2D.TTF_RANK,18));
		contain.add(label,BorderLayout.NORTH);
		
		JPanel jpanel = new JPanel(new GridLayout(2,2));
		JPanel everyPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		everyPanel.add(new JLabel("公司名称："));
		company = new JTextField();
		company.addKeyListener(new KeyListener()
		{

			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if(company.getText().length()>50)
				{
					JOptionPane.showMessageDialog(null, "公司名称长度不能超过50！");
					company.setText(company.getText().substring(0,45));
				}
					
				
			}

			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		company.setPreferredSize(new Dimension(90,20));
		everyPanel.add(company);
		jpanel.add(everyPanel);
		
		everyPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		everyPanel.add(new JLabel("联系人："));
		linkman = new JTextField();
		linkman.addKeyListener(new KeyListener()
		{

			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if(linkman.getText().length()>5)
					linkman.setText("");
			}

			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		
		});
		linkman.setPreferredSize(new Dimension(90,20));
		everyPanel.add(linkman);
		jpanel.add(everyPanel);
		
		everyPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		everyPanel.add(new JLabel("信誉不低于:"));
		star1 = new JButton(new ImageIcon("icons/star2.jpg"));
		star1.setMargin(new Insets(0,0,0,0));
		star1.setPreferredSize(new Dimension(17,17));
		star1.setRolloverEnabled(true);
		star1.setRolloverIcon(new ImageIcon("icons/star2.jpg"));
		star1.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				star2.setIcon(new ImageIcon("icons/star1.jpg"));
				star3.setIcon(new ImageIcon("icons/star1.jpg"));
				star4.setIcon(new ImageIcon("icons/star1.jpg"));
				star5.setIcon(new ImageIcon("icons/star1.jpg"));
				creditSign1 = 1;
			}
			
		});
		star2 = new JButton(new ImageIcon("icons/star1.jpg"));
		star2.setMargin(new Insets(0,0,0,0));
		star2.setPreferredSize(new Dimension(17,17));
		star2.setRolloverEnabled(true);
		star2.setRolloverIcon(new ImageIcon("icons/star2.jpg"));
		star2.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				star2.setIcon(new ImageIcon("icons/star2.jpg"));
				star3.setIcon(new ImageIcon("icons/star1.jpg"));
				star4.setIcon(new ImageIcon("icons/star1.jpg"));
				star5.setIcon(new ImageIcon("icons/star1.jpg"));
				creditSign1 = 2;
			}
			
		});
		star3 = new JButton(new ImageIcon("icons/star1.jpg"));
		star3.setMargin(new Insets(0,0,0,0));
		star3.setPreferredSize(new Dimension(17,17));
		star3.setRolloverEnabled(true);
		star3.setRolloverIcon(new ImageIcon("icons/star2.jpg"));
		star3.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				star2.setIcon(new ImageIcon("icons/star2.jpg"));
				star3.setIcon(new ImageIcon("icons/star2.jpg"));
				star4.setIcon(new ImageIcon("icons/star1.jpg"));
				star5.setIcon(new ImageIcon("icons/star1.jpg"));
				creditSign1 = 3;
			}
			
		});
		star4 = new JButton(new ImageIcon("icons/star1.jpg"));
		star4.setMargin(new Insets(0,0,0,0));
		star4.setPreferredSize(new Dimension(17,17));
		star4.setRolloverEnabled(true);
		star4.setRolloverIcon(new ImageIcon("icons/star2.jpg"));
		star4.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				star2.setIcon(new ImageIcon("icons/star2.jpg"));
				star3.setIcon(new ImageIcon("icons/star2.jpg"));
				star4.setIcon(new ImageIcon("icons/star2.jpg"));
				star5.setIcon(new ImageIcon("icons/star1.jpg"));
				creditSign1 = 4;
			}
			
		});
		star5 = new JButton(new ImageIcon("icons/star1.jpg"));
		star5.setMargin(new Insets(0,0,0,0));
		star5.setPreferredSize(new Dimension(17,17));
		star5.setRolloverEnabled(true);
		star5.setRolloverIcon(new ImageIcon("icons/star2.jpg"));
		star5.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				star2.setIcon(new ImageIcon("icons/star2.jpg"));
				star3.setIcon(new ImageIcon("icons/star2.jpg"));
				star4.setIcon(new ImageIcon("icons/star2.jpg"));
				star5.setIcon(new ImageIcon("icons/star2.jpg"));
				creditSign1 = 5;
			}
			
		});
		everyPanel.add(star1);
		everyPanel.add(star2);
		everyPanel.add(star3);
		everyPanel.add(star4);
		everyPanel.add(star5);
		jpanel.add(everyPanel);
		
		everyPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		everyPanel.add(new JLabel("信誉不高于:"));
		star6 = new JButton(new ImageIcon("icons/star2.jpg"));
		star6.setMargin(new Insets(0,0,0,0));
		star6.setPreferredSize(new Dimension(17,17));
		star6.setRolloverEnabled(true);
		star6.setRolloverIcon(new ImageIcon("icons/star2.jpg"));
		star6.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				star7.setIcon(new ImageIcon("icons/star1.jpg"));
				star8.setIcon(new ImageIcon("icons/star1.jpg"));
				star9.setIcon(new ImageIcon("icons/star1.jpg"));
				star10.setIcon(new ImageIcon("icons/star1.jpg"));
				creditSign2 = 1;
			}
			
		});
		star7 = new JButton(new ImageIcon("icons/star2.jpg"));
		star7.setMargin(new Insets(0,0,0,0));
		star7.setPreferredSize(new Dimension(17,17));
		star7.setRolloverEnabled(true);
		star7.setRolloverIcon(new ImageIcon("icons/star2.jpg"));
		star7.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				star7.setIcon(new ImageIcon("icons/star2.jpg"));
				star8.setIcon(new ImageIcon("icons/star1.jpg"));
				star9.setIcon(new ImageIcon("icons/star1.jpg"));
				star10.setIcon(new ImageIcon("icons/star1.jpg"));
				creditSign2 = 2;
			}
			
		});
		star8 = new JButton(new ImageIcon("icons/star2.jpg"));
		star8.setMargin(new Insets(0,0,0,0));
		star8.setPreferredSize(new Dimension(17,17));
		star8.setRolloverEnabled(true);
		star8.setRolloverIcon(new ImageIcon("icons/star2.jpg"));
		star8.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				star7.setIcon(new ImageIcon("icons/star2.jpg"));
				star8.setIcon(new ImageIcon("icons/star2.jpg"));
				star9.setIcon(new ImageIcon("icons/star1.jpg"));
				star10.setIcon(new ImageIcon("icons/star1.jpg"));
				creditSign2 = 3;
			}
			
		});
		star9 = new JButton(new ImageIcon("icons/star2.jpg"));
		star9.setMargin(new Insets(0,0,0,0));
		star9.setPreferredSize(new Dimension(17,17));
		star9.setRolloverEnabled(true);
		star9.setRolloverIcon(new ImageIcon("icons/star2.jpg"));
		star9.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				star7.setIcon(new ImageIcon("icons/star2.jpg"));
				star8.setIcon(new ImageIcon("icons/star2.jpg"));
				star9.setIcon(new ImageIcon("icons/star2.jpg"));
				star10.setIcon(new ImageIcon("icons/star1.jpg"));
				creditSign2 = 4;
			}
			
		});
		star10 = new JButton(new ImageIcon("icons/star2.jpg"));
		star10.setMargin(new Insets(0,0,0,0));
		star10.setPreferredSize(new Dimension(17,17));
		star10.setRolloverEnabled(true);
		star10.setRolloverIcon(new ImageIcon("icons/star2.jpg"));
		star10.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				star7.setIcon(new ImageIcon("icons/star2.jpg"));
				star8.setIcon(new ImageIcon("icons/star2.jpg"));
				star9.setIcon(new ImageIcon("icons/star2.jpg"));
				star10.setIcon(new ImageIcon("icons/star2.jpg"));
				creditSign2 = 5;
			}
			
		});
		everyPanel.add(star6);
		everyPanel.add(star7);
		everyPanel.add(star8);
		everyPanel.add(star9);
		everyPanel.add(star10);
		jpanel.add(everyPanel);
		
		contain.add(jpanel);
		ok = new JButton("确定");
		ok.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				str1 = company.getText().trim();
				if(str1.length()==0)
					sqlStr1 = "";
				else
					sqlStr1 = " and company like '%"+str1+"%'";
				str2 = linkman.getText().trim();
				if(str2.length()==0)
					sqlStr2 = "";
				else
					sqlStr2 = " and linkman like '%"+str2+"%'";
				select = "select name,principal,linkman,zhucezijin,nianyingyee,jihuayuwosinianjiaoyie,yiwanchengjiaoyie,jiezhiriqi,qiankuan,creditlevel " +
					"from client where active = 1"+sqlStr1+sqlStr2+" and creditlevel >='"+creditSign1+"' and creditlevel<='"+creditSign2+"'";
				JTable table = new CreditTable(select).getTable();
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
		setTitle("按信誉度查找客户");
		setLocation(200, 100);
		//setSize(new Dimension(350,300));
		pack();
		setResizable(false);
		setIconImage(new ImageIcon("icons/logo1.png").getImage());
		setVisible(true);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}
}
