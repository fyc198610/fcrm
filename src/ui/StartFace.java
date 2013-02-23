package ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import db.DerbyConnection;

public class StartFace extends JFrame{

	Statement state;
	public StartFace()
	{
		DerbyConnection.f_setConnect();
		try {
			state = DerbyConnection.f_getConnect().createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		f_createStartFace();
		f_windowSet();
	}
	
	JTextField f_username;
	JPasswordField f_password;
	JButton f_enter;
	JButton f_exitButton;
	Image image = Toolkit.getDefaultToolkit().getImage("icons/start.jpg");
	public void f_createStartFace()
	{
		System.setProperty("java.awt.im.style", "on-the-spot");
		JComponent backImage = new JComponent(){
	        protected void paintComponent(Graphics g) {
	            super.paintComponent(g);
	            g.drawImage(image,0,0,getWidth(),getHeight(),this);
	        }
	    };
		Container contain = getContentPane();
		
		JLabel label3 = new JLabel("用户名:");
		label3.setFont(new Font("宋体",Font.PLAIN,12));
		label3.setForeground(Color.white);
		label3.setBounds(260, 130, 45, 18);
		contain.add(label3);
		
		f_username = new JTextField();
		f_username.addKeyListener(new KeyListener(){

			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				String getName = new String();
				getName = f_username.getText();
				if(getName.length()>10)
				{
					JOptionPane.showMessageDialog(null, "用户名长度不能超过10");
					f_username.setText("");
				}
			}

			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});		
		f_username.setBounds(310, 130, 110, 18);
		contain.add(f_username);
		
		JLabel label4 = new JLabel("密  码:");
		label4.setFont(new Font("宋体",Font.PLAIN,12));
		label4.setForeground(Color.white);
		label4.setBounds(260, 155, 45, 18);
		contain.add(label4);
		
		f_password = new JPasswordField();
		f_password.addKeyListener(new KeyListener()
		{

			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				String getPassword = new String();
				getPassword = f_password.getText();
				if(getPassword.length()>10)
				{
					JOptionPane.showMessageDialog(null, "密码长度不能超过10");
					f_password.setText("");
				}
			}

			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		f_password.setBounds(310, 155, 110, 18);
		contain.add(f_password);
		
		f_enter = new JButton("登 录");
		f_enter.setFont(new Font("宋体",Font.PLAIN,13));
		f_enter.setForeground(Color.blue);
		f_enter.setMargin(new Insets(2,2,2,2));
		f_enter.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int sign = 0;
				ResultSet rs;
				String getName = new String();
				String getpd ;
				getName = f_username.getText().trim();
				try {
					rs = state.executeQuery("select name from employee");
					while(rs.next())
					{
						if(rs.getString("name").trim().equals(getName))
						{
							sign=1;
							break;
						}
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(sign == 0)
						JOptionPane.showMessageDialog(null, "用户名不存在");
				else
				{
					try {
						rs = state.executeQuery("select password from employee where name = '"+getName+"'");
						getpd = new String(f_password.getPassword());
						rs.next();
						if(!rs.getString(1).trim().equals(getpd))
							JOptionPane.showMessageDialog(null, "密码错误");
						else 
						{
							state.execute("update client set active = 1 where staffer='"+getName+"'");
							state.execute("update linkman set active=1 where company in (select name from client where active = 1)");
							state.execute("update tradeamount set active=1 where company in(select name from client where active = 1)");
							state.execute("update deveplan set active=1 where company in (select name from client where active = 1)");
							state.execute("update satisfaction set active = 1 where company in (select name from client where active = 1)");
							state.execute("update kindclient set active = 1 where empnumber =(select number from employee where name = '"+getName+"')");
							new UserFace(getName);
							dispose();
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			}
			
		});
		f_enter.setBounds(270, 185, 60, 20);
		contain.add(f_enter);
		
		f_exitButton = new JButton("取 消");
		f_exitButton.setFont(new Font("宋体",Font.PLAIN,13));
		f_exitButton.setForeground(Color.blue);
		f_exitButton.setMargin(new Insets(2,2,2,2));
		f_exitButton.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				System.exit(0);
			}
			
		});
		f_exitButton.setBounds(345, 185, 60, 20);
		contain.add(f_exitButton);
		
		getRootPane().setDefaultButton(f_enter);
		contain.add(backImage);
	}
	
	public void f_windowSet()
	{
		setUndecorated(true);
		setTitle("用户登录");
		setLocation(200, 150);
		setSize(new Dimension(600,320));
		setIconImage(new ImageIcon("icons/logo1.png").getImage());
		setVisible(true);
	}
	
}
