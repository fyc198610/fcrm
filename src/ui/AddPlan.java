package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import sun.font.Font2D;

import db.DerbyConnection;

public class AddPlan extends JFrame{
	
	Container contain ;
	Statement state;
	ResultSet rs;
	String[] arrayCompany;
	public AddPlan()
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
			arrayCompany = new String[row];
			rs = state.executeQuery("select name from client where active = 1");
			row = 0;
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
	JDatePicker startDate;
	JDatePicker endDate;
	JTextArea content;
	JTextArea aim;
	JButton ok;
	String str1;
	String str2;
	String str3;
	String str4;
	String str5;
	String str6;
	public void faceSet()
	{
		contain = getContentPane();
		JPanel jpanel = new JPanel();
		jpanel.setBorder(BorderFactory.createLineBorder(Color.gray));
		jpanel.setLayout(null);
		
		JLabel label = new JLabel("�ͻ����ƣ�");
		label.setBounds(10, 10, 75, 20);
		jpanel.add(label);
		company = new JComboBox(arrayCompany);
		company.setBounds(78, 10, 110, 20);
		jpanel.add(company);
		
		label = new JLabel("�ƻ����ƣ�");
		label.setBounds(193, 10, 75,20);
		jpanel.add(label);
		name = new JTextField();
		name.addKeyListener(new KeyListener()
		{

			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if(name.getText().length()>25)
				{
					JOptionPane.showMessageDialog(null, "�ƻ����Ʋ��ܶ���25����");
					name.setText(name.getText().substring(0,20));
				}
			}

			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		name.setBounds(263, 10, 110, 20);
		jpanel.add(name);
		
		JPanel everyPanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
		everyPanel.add(new JLabel("��ʼʱ�䣺"));
		startDate = new JDatePicker(new Dimension(110,20));
		startDate.setPreferredSize(new Dimension(110,20));
		everyPanel.add(startDate);
		everyPanel.add(new JLabel("����ʱ�䣺"));
		endDate = new JDatePicker(new Dimension(110,20));
		endDate.setPreferredSize(new Dimension(110,20));
		everyPanel.add(endDate);
		everyPanel.setBounds(3, 40, 370, 25);
		jpanel.add(everyPanel);
		
		label = new JLabel("�ƻ����ݣ�(��Ҫ����500��)");
		label.setBounds(10, 75, 200, 20);
		jpanel.add(label);
		content = new JTextArea();
		content.addKeyListener(new KeyListener()
		{

			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				String getName = content.getText();
				if(getName.length()>499)
				{
					content.setText(getName.substring(0,490));
					JOptionPane.showMessageDialog(null, "���ݲ��ܳ���500��");
				}
			}

			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		content.setBorder(BorderFactory.createLineBorder(Color.gray));
		JScrollPane scrollPane = new JScrollPane(content);
		scrollPane.setBounds(70, 100, 305, 120);
		jpanel.add(scrollPane);
		
		label = new JLabel("�ƻ�Ŀ�ģ�(��Ҫ����500��)");
		label.setBounds(10, 230, 200, 20);
		jpanel.add(label);
		aim = new JTextArea();
		aim.addKeyListener(new KeyListener()
		{

			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				String getName = aim.getText();
				if(getName.length()>499)
				{
					aim.setText(getName.substring(0,490));
					JOptionPane.showMessageDialog(null, "���ݲ��ܳ���500��");
				}
			}

			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		aim.setBorder(BorderFactory.createLineBorder(Color.gray));
		scrollPane = new JScrollPane(aim);
		scrollPane.setBounds(70, 255, 305, 120);
		jpanel.add(scrollPane);
		
		contain.add(jpanel);
		label = new JLabel(" ��ӿͻ���չ�ƻ�",JLabel.CENTER);
		label.setFont(new Font(null,Font2D.TTF_RANK,18));
		contain.add(label,BorderLayout.NORTH);
		everyPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		everyPanel.setBorder(BorderFactory.createLineBorder(Color.gray));
		ok = new JButton("ȷ��");
		everyPanel.add(ok);
		ok.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(company.getSelectedIndex()==-1)
					JOptionPane.showMessageDialog(null, "�ͻ����Ʋ���Ϊ��");
				else 
				{
					str1 = (String)company.getSelectedItem();
					str2 = name.getText().trim();
					if(str2.length()==0)
						JOptionPane.showMessageDialog(null, "�ƻ����Ʋ���Ϊ��");
					else
					{
						int sign = 1;
						try {
							rs = state.executeQuery("select planname from deveplan where active = 1 and company = '"+str1+"'");
							while(rs.next())
								if(rs.getString(1).trim().equals(str2))
									{
									sign = 0;
									break;
									}
						} catch (SQLException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
						if(sign==0)
							JOptionPane.showMessageDialog(null, "�˼ƻ������Ѿ��ڴ˿ͻ��д��ڣ�");
						else
						{
							str3 = startDate.getTxtDate().getText().trim();
							str4 = endDate.getTxtDate().getText().trim();
							str5 = content.getText();
							str6 = aim.getText();
							try {
								state.execute("insert into deveplan values ('"+str1+"','"+str2+"','"+str3+"','"+str4+"','"+str5+"','"+str6+"',0,1)");
								dispose();
								JOptionPane.showMessageDialog(null, "��Ӽƻ��ɹ�");
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					}
				}
			}
			
		});
		contain.add(everyPanel,BorderLayout.SOUTH);
	}

	public void frameSet()
	{
		setTitle("��ӿͻ���չ�ƻ�");
		setLocation(200, 100);
		setSize(new Dimension(390,470));
		setAlwaysOnTop(true);
		setIconImage(new ImageIcon("icons/logo1.png").getImage());
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}
	
//	public static void main(String[] args) {
//		new AddPlan();
//	}
}
