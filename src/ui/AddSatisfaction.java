package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import sun.font.Font2D;

import db.DerbyConnection;

public class AddSatisfaction extends JFrame{

	Statement state;
	ResultSet rs;
	Container contain;
	String[] arrayCompany;
	public AddSatisfaction()
	{
		int row = 0;
		try {
			state = DerbyConnection.f_getConnect().createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String select = "select name from client where active = 1";
		try {
			rs = state.executeQuery(select);
			while(rs.next())
				row++;
			arrayCompany = new String[row];
			row = 0;
			rs = state.executeQuery(select);
			while(rs.next())
			{
				arrayCompany[row] = rs.getString(1).trim();
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
	JCheckBox checkBox1;
	JCheckBox checkBox2;
	JCheckBox checkBox3;
	JButton ok;
	String str1;
	String date;
	
	int title1=0;
	int title2=0;
	int title3=0;
	int title4=0;
	int title5=0;
	int title6=0;
	int title7=0;
	int title8=0;
	int title9=0;
	int title10=0;
	int title11=0;
	int title12=0;
	private void faceSet()
	{
		contain = getContentPane();
		JLabel label = new JLabel("�ͻ�����ȵ����",JLabel.CENTER);
		label.setFont(new Font("����",Font.BOLD,18));
		contain.add(label,BorderLayout.NORTH);
		
		JPanel centerPanel = new JPanel(new BorderLayout());
		Box everyBox = Box.createHorizontalBox();
		everyBox.setBorder(BorderFactory.createLineBorder(Color.gray));
		label = new JLabel("�ͻ����ƣ�");
		label.setFont(new Font("����",Font.PLAIN,12));
		everyBox.add(label);
		JPanel companyPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		company = new JComboBox(arrayCompany);
		company.setFont(new Font("����",Font.PLAIN,12));
		company.setPreferredSize(new Dimension(120,20));
		companyPanel.setAlignmentY(Component.CENTER_ALIGNMENT);
		companyPanel.add(company);
		everyBox.add(companyPanel);
		everyBox.add(Box.createHorizontalGlue());
//		everyBox.add(Box.createRigidArea(new Dimension(120,40)));
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy��M��d��");
		date = sdf.format(new Date());
		label = new JLabel(date);
		label.setFont(new Font("����",Font.PLAIN,12));
		everyBox.add(label);
		everyBox.add(Box.createHorizontalStrut(15));
		centerPanel.add(everyBox,BorderLayout.NORTH);
		
		JPanel jpanel = new JPanel(new GridLayout(12,1));
		everyBox = Box.createHorizontalBox();
		everyBox.setBorder(BorderFactory.createLineBorder(Color.gray));
		label = new JLabel("  1. �������ǵĲ�Ʒ��������� ");
		label.setFont(new Font("����",Font.PLAIN,14));
		everyBox.add(label);
		everyBox.add(Box.createHorizontalGlue());
//		everyBox.add(Box.createRigidArea(new Dimension(98,35)));
		checkBox1 = new JCheckBox("������");
		checkBox1.setFont(new Font("����",Font.PLAIN,12));
		checkBox1.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				title1 = 3;
			}
			
		});
		checkBox2 = new JCheckBox("һ��");
		checkBox2.setFont(new Font("����",Font.PLAIN,12));
		checkBox2.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				title1 = 2;
			}
			
		});
		checkBox3 = new JCheckBox("������");
		checkBox3.setFont(new Font("����",Font.PLAIN,12));
		checkBox3.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				title1 = 1;
			}
			
		});
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(checkBox1);
		buttonGroup.add(checkBox2);
		buttonGroup.add(checkBox3);
		everyBox.add(checkBox1);
		everyBox.add(checkBox2);
		everyBox.add(checkBox3);
		jpanel.add(everyBox);
		
		everyBox = Box.createHorizontalBox();
		label = new JLabel("  2. �������ǵĲ�Ʒ���������� ");
		label.setFont(new Font("����",Font.PLAIN,14));
		everyBox.add(label);
		everyBox.setBorder(BorderFactory.createLineBorder(Color.gray));
		everyBox.add(Box.createHorizontalGlue());
//		everyBox.add(Box.createHorizontalStrut(98));
		checkBox1 = new JCheckBox("������");
		checkBox1.setFont(new Font("����",Font.PLAIN,12));
		checkBox1.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				title2 = 3;
			}
			
		});
		checkBox2 = new JCheckBox("һ��");
		checkBox2.setFont(new Font("����",Font.PLAIN,12));
		checkBox2.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				title2 = 2;
			}
			
		});
		checkBox3 = new JCheckBox("������");
		checkBox3.setFont(new Font("����",Font.PLAIN,12));
		checkBox3.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				title2 = 1;
			}
			
		});
		buttonGroup = new ButtonGroup();
		buttonGroup.add(checkBox1);
		buttonGroup.add(checkBox2);
		buttonGroup.add(checkBox3);
		everyBox.add(checkBox1);
		everyBox.add(checkBox2);
		everyBox.add(checkBox3);
		jpanel.add(everyBox);
		
		everyBox = Box.createHorizontalBox();
		label = new JLabel("  3. �������ǵĲ�Ʒ��װ������ ");
		label.setFont(new Font("����",Font.PLAIN,14));
		everyBox.add(label);
		everyBox.setBorder(BorderFactory.createLineBorder(Color.gray));
		everyBox.add(Box.createHorizontalGlue());
//		everyBox.add(Box.createHorizontalStrut(98));
		checkBox1 = new JCheckBox("������");
		checkBox1.setFont(new Font("����",Font.PLAIN,12));
		checkBox1.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				title3 = 3;
			}
			
		});
		checkBox2 = new JCheckBox("һ��");
		checkBox2.setFont(new Font("����",Font.PLAIN,12));
		checkBox2.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				title3 = 2;
			}
			
		});
		checkBox3 = new JCheckBox("������");
		checkBox3.setFont(new Font("����",Font.PLAIN,12));
		checkBox3.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				title3 = 1;
			}
			
		});
		buttonGroup = new ButtonGroup();
		buttonGroup.add(checkBox1);
		buttonGroup.add(checkBox2);
		buttonGroup.add(checkBox3);
		everyBox.add(checkBox1);
		everyBox.add(checkBox2);
		everyBox.add(checkBox3);
		jpanel.add(everyBox);
		
		everyBox = Box.createHorizontalBox();
		label = new JLabel("  4. �������ǵĽ���׼ʱ�������� ");
		label.setFont(new Font("����",Font.PLAIN,14));
		everyBox.add(label);
		everyBox.setBorder(BorderFactory.createLineBorder(Color.gray));
		everyBox.add(Box.createHorizontalGlue());
//		everyBox.add(Box.createHorizontalStrut(83));
		checkBox1 = new JCheckBox("������");
		checkBox1.setFont(new Font("����",Font.PLAIN,12));
		checkBox1.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				title4 = 3;
			}
			
		});
		checkBox2 = new JCheckBox("һ��");
		checkBox2.setFont(new Font("����",Font.PLAIN,12));
		checkBox2.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				title4 = 2;
			}
			
		});
		checkBox3 = new JCheckBox("������");
		checkBox3.setFont(new Font("����",Font.PLAIN,12));
		checkBox3.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				title4 = 1;
			}
			
		});
		buttonGroup = new ButtonGroup();
		buttonGroup.add(checkBox1);
		buttonGroup.add(checkBox2);
		buttonGroup.add(checkBox3);
		everyBox.add(checkBox1);
		everyBox.add(checkBox2);
		everyBox.add(checkBox3);
		jpanel.add(everyBox);
		
		everyBox = Box.createHorizontalBox();
		label = new JLabel("  5. �����ҹ�˾�Ľ���׼ȷ�������� ");
		label.setFont(new Font("����",Font.PLAIN,14));
		everyBox.add(label);
		everyBox.setBorder(BorderFactory.createLineBorder(Color.gray));
		everyBox.add(Box.createHorizontalGlue());
//		everyBox.add(Box.createHorizontalStrut(68));
		checkBox1 = new JCheckBox("������");
		checkBox1.setFont(new Font("����",Font.PLAIN,12));
		checkBox1.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				title5 = 3;
			}
			
		});
		checkBox2 = new JCheckBox("һ��");
		checkBox2.setFont(new Font("����",Font.PLAIN,12));
		checkBox2.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				title5 = 2;
			}
			
		});
		checkBox3 = new JCheckBox("������");
		checkBox3.setFont(new Font("����",Font.PLAIN,12));
		checkBox3.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				title5 = 1;
			}
			
		});
		buttonGroup = new ButtonGroup();
		buttonGroup.add(checkBox1);
		buttonGroup.add(checkBox2);
		buttonGroup.add(checkBox3);
		everyBox.add(checkBox1);
		everyBox.add(checkBox2);
		everyBox.add(checkBox3);
		jpanel.add(everyBox);
		
		everyBox = Box.createHorizontalBox();
		label = new JLabel("  6. �����ҹ�˾�ı��۷����ٶ������� ");
		label.setFont(new Font("����",Font.PLAIN,14));
		everyBox.add(label);
		everyBox.setBorder(BorderFactory.createLineBorder(Color.gray));
		everyBox.add(Box.createHorizontalGlue());
//		everyBox.add(Box.createHorizontalStrut(54));
		checkBox1 = new JCheckBox("������");
		checkBox1.setFont(new Font("����",Font.PLAIN,12));
		checkBox1.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				title6 = 3;
			}
			
		});
		checkBox2 = new JCheckBox("һ��");
		checkBox2.setFont(new Font("����",Font.PLAIN,12));
		checkBox2.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				title6 = 2;
			}
			
		});
		checkBox3 = new JCheckBox("������");
		checkBox3.setFont(new Font("����",Font.PLAIN,12));
		checkBox3.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				title6 = 1;
			}
			
		});
		buttonGroup = new ButtonGroup();
		buttonGroup.add(checkBox1);
		buttonGroup.add(checkBox2);
		buttonGroup.add(checkBox3);
		everyBox.add(checkBox1);
		everyBox.add(checkBox2);
		everyBox.add(checkBox3);
		jpanel.add(everyBox);
		
		everyBox = Box.createHorizontalBox();
		label = new JLabel("  7. �����ҹ�˾������ظ��ٶ������� ");
		label.setFont(new Font("����",Font.PLAIN,14));
		everyBox.add(label);
		everyBox.setBorder(BorderFactory.createLineBorder(Color.gray));
		everyBox.add(Box.createHorizontalGlue());
//		everyBox.add(Box.createHorizontalStrut(54));
		checkBox1 = new JCheckBox("������");
		checkBox1.setFont(new Font("����",Font.PLAIN,12));
		checkBox1.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				title7 = 3;
			}
			
		});
		checkBox2 = new JCheckBox("һ��");
		checkBox2.setFont(new Font("����",Font.PLAIN,12));
		checkBox2.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				title7 = 2;
			}
			
		});
		checkBox3 = new JCheckBox("������");
		checkBox3.setFont(new Font("����",Font.PLAIN,12));
		checkBox3.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				title7 = 1;
			}
			
		});
		buttonGroup = new ButtonGroup();
		buttonGroup.add(checkBox1);
		buttonGroup.add(checkBox2);
		buttonGroup.add(checkBox3);
		everyBox.add(checkBox1);
		everyBox.add(checkBox2);
		everyBox.add(checkBox3);
		jpanel.add(everyBox);
		
		everyBox = Box.createHorizontalBox();
		label = new JLabel("  8. �����ҹ�˾ҵ��Ա�ķ���̬�������� ");
		label.setFont(new Font("����",Font.PLAIN,14));
		everyBox.add(label);
		everyBox.setBorder(BorderFactory.createLineBorder(Color.gray));
		everyBox.add(Box.createHorizontalStrut(60));
//		everyBox.add(Box.createHorizontalStrut(40));
		checkBox1 = new JCheckBox("������");
		checkBox1.setFont(new Font("����",Font.PLAIN,12));
		checkBox1.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				title8 = 3;
			}
			
		});
		checkBox2 = new JCheckBox("һ��");
		checkBox2.setFont(new Font("����",Font.PLAIN,12));
		checkBox2.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				title8 = 2;
			}
			
		});
		checkBox3 = new JCheckBox("������");
		checkBox3.setFont(new Font("����",Font.PLAIN,12));
		checkBox3.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				title8 = 1;
			}
			
		});
		buttonGroup = new ButtonGroup();
		buttonGroup.add(checkBox1);
		buttonGroup.add(checkBox2);
		buttonGroup.add(checkBox3);
		everyBox.add(checkBox1);
		everyBox.add(checkBox2);
		everyBox.add(checkBox3);
		jpanel.add(everyBox);
		
		everyBox = Box.createHorizontalBox();
		label = new JLabel("  9. �����ҹ�˾�Ĳ�Ʒ�۸������� ");
		label.setFont(new Font("����",Font.PLAIN,14));
		everyBox.add(label);
		everyBox.setBorder(BorderFactory.createLineBorder(Color.gray));
		everyBox.add(Box.createHorizontalGlue());
//		everyBox.add(Box.createHorizontalStrut(85));
		checkBox1 = new JCheckBox("������");
		checkBox1.setFont(new Font("����",Font.PLAIN,12));
		checkBox1.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				title9 = 3;
			}
			
		});
		checkBox2 = new JCheckBox("һ��");
		checkBox2.setFont(new Font("����",Font.PLAIN,12));
		checkBox2.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				title9 = 2;
			}
			
		});
		checkBox3 = new JCheckBox("������");
		checkBox3.setFont(new Font("����",Font.PLAIN,12));
		checkBox3.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				title9 = 1;
			}
			
		});
		buttonGroup = new ButtonGroup();
		buttonGroup.add(checkBox1);
		buttonGroup.add(checkBox2);
		buttonGroup.add(checkBox3);
		everyBox.add(checkBox1);
		everyBox.add(checkBox2);
		everyBox.add(checkBox3);
		jpanel.add(everyBox);
		
		everyBox = Box.createHorizontalBox();
		label = new JLabel("  10. �����ҹ�˾�Ľ��㷽ʽ������ ");
		label.setFont(new Font("����",Font.PLAIN,14));
		everyBox.add(label);
		everyBox.setBorder(BorderFactory.createLineBorder(Color.gray));
		everyBox.add(Box.createHorizontalGlue());
//		everyBox.add(Box.createHorizontalStrut(77));
		checkBox1 = new JCheckBox("������");
		checkBox1.setFont(new Font("����",Font.PLAIN,12));
		checkBox1.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				title10 = 3;
			}
			
		});
		checkBox2 = new JCheckBox("һ��");
		checkBox2.setFont(new Font("����",Font.PLAIN,12));
		checkBox2.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				title10 = 2;
			}
			
		});
		checkBox3 = new JCheckBox("������");
		checkBox3.setFont(new Font("����",Font.PLAIN,12));
		checkBox3.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				title10 = 1;
			}
			
		});
		buttonGroup = new ButtonGroup();
		buttonGroup.add(checkBox1);
		buttonGroup.add(checkBox2);
		buttonGroup.add(checkBox3);
		everyBox.add(checkBox1);
		everyBox.add(checkBox2);
		everyBox.add(checkBox3);
		jpanel.add(everyBox);
		
		everyBox = Box.createHorizontalBox();
		label = new JLabel("  11. �����ҹ�˾����Ʒ�����ٶ������� ");
		label.setFont(new Font("����",Font.PLAIN,14));
		everyBox.add(label);
		everyBox.setBorder(BorderFactory.createLineBorder(Color.gray));
		everyBox.add(Box.createHorizontalGlue());
//		everyBox.add(Box.createHorizontalStrut(48));
		checkBox1 = new JCheckBox("������");
		checkBox1.setFont(new Font("����",Font.PLAIN,12));
		checkBox1.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				title11 = 3;
			}
			
		});
		checkBox2 = new JCheckBox("һ��");
		checkBox2.setFont(new Font("����",Font.PLAIN,12));
		checkBox2.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				title11 = 2;
			}
			
		});
		checkBox3 = new JCheckBox("������");
		checkBox3.setFont(new Font("����",Font.PLAIN,12));
		checkBox3.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				title11 = 1;
			}
			
		});
		buttonGroup = new ButtonGroup();
		buttonGroup.add(checkBox1);
		buttonGroup.add(checkBox2);
		buttonGroup.add(checkBox3);
		everyBox.add(checkBox1);
		everyBox.add(checkBox2);
		everyBox.add(checkBox3);
		jpanel.add(everyBox);
		
		everyBox = Box.createHorizontalBox();
		label = new JLabel("  12. �����ҹ�˾�����õĻ��˷�ʽ������ ");
		label.setFont(new Font("����",Font.PLAIN,14));
		everyBox.add(label);
		everyBox.setBorder(BorderFactory.createLineBorder(Color.gray));
		everyBox.add(Box.createHorizontalGlue());
//		everyBox.add(Box.createHorizontalStrut(35));
		checkBox1 = new JCheckBox("������");
		checkBox1.setFont(new Font("����",Font.PLAIN,12));
		checkBox1.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				title12 = 3;
			}
			
		});
		checkBox2 = new JCheckBox("һ��");
		checkBox2.setFont(new Font("����",Font.PLAIN,12));
		checkBox2.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				title12 = 2;
			}
			
		});
		checkBox3 = new JCheckBox("������");
		checkBox3.setFont(new Font("����",Font.PLAIN,12));
		checkBox3.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				title12 = 1;
			}
			
		});
		buttonGroup = new ButtonGroup();
		buttonGroup.add(checkBox1);
		buttonGroup.add(checkBox2);
		buttonGroup.add(checkBox3);
		everyBox.add(checkBox1);
		everyBox.add(checkBox2);
		everyBox.add(checkBox3);
		jpanel.add(everyBox);
		
		centerPanel.add(jpanel);
		JPanel bottom = new JPanel(new FlowLayout(FlowLayout.CENTER));
		ok = new JButton("�� ��");
		ok.setFont(new Font("����",Font.PLAIN,12));
		ok.setMargin(new Insets(1,3,1,3));
		ok.setPreferredSize(new Dimension(55,20));
		bottom.add(ok);
		ok.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(company.getSelectedIndex()==-1)
					JOptionPane.showMessageDialog(null, "�ͻ����Ʋ���Ϊ��!");
				else
				{
				str1 = (String)company.getSelectedItem();
				if(title1==0||title2==0||title3==0||title4==0||title5==0||title6==0||title7==0||title8==0||title9==0||title10==0||title11==0||title12==0)
					JOptionPane.showMessageDialog(null, "�뽫���е��ⶼѡ��");
				else
				{
					try {
							state.execute("insert into satisfaction values ('"+date+"','"+str1+"',"+title1+","+title2+","+title3+","+title4+","+title5+","+title6+","+title7+","+title8+","+title9+","+title10+","+title11+","+title12+",1)");
							dispose();
							JOptionPane.showMessageDialog(null, "�ύ�ɹ�");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				}
				
			}
			
		});
		centerPanel.add(bottom,BorderLayout.SOUTH);
		contain.add(centerPanel);
	}
	
	private void frameSet()
	{
		setTitle("�ͻ�����ȵ����");
		setLocation(300, 150);
		setSize(new Dimension(400,500));
		pack();
		setIconImage(new ImageIcon("icons/logo1.png").getImage());
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}
	
	
}
