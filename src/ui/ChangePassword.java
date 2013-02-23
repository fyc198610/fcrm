package ui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import db.DerbyConnection;

public class ChangePassword extends JDialog{

	Statement state;
	Container contain;
	String userName;
	public ChangePassword(String userName)
	{
		this.userName = userName;
		try {
			state = DerbyConnection.f_getConnect().createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		faceSet();
		frameSet();
	}
	
	JPasswordField password1;
	JPasswordField password2;
	JPasswordField password3;
	public void faceSet()
	{
		 contain = getContentPane();
		 JPanel content = new JPanel(null);
		 JLabel label = new JLabel("原密码:");
		 label.setBounds(10, 10, 100, 20);
		 content.add(label);
		 password1 = new JPasswordField();
			password1.addKeyListener(new KeyAdapter()
			{
				public void keyReleased(KeyEvent arg0) {
					// TODO Auto-generated method stub
					String getPassword = new String();
					getPassword = password1.getText();
					if(getPassword.length()>10)
					{
						JOptionPane.showMessageDialog(null, "密码长度不能超过10");
						password1.setText("");
					}
				}
			});
		 password1.setBounds(115, 10, 100, 20);
		 content.add(password1);
		 JLabel label2 = new JLabel("新密码:");
		 label2.setBounds(10, 35, 100, 20);
		 content.add(label2);
		 password2 = new JPasswordField();
			password2.addKeyListener(new KeyAdapter()
			{
				public void keyReleased(KeyEvent arg0) {
					// TODO Auto-generated method stub
					String getPassword = new String();
					getPassword = password2.getText();
					if(getPassword.length()>10)
					{
						JOptionPane.showMessageDialog(null, "密码长度不能超过10");
						password2.setText("");
					}
				}
			});
		 password2.setBounds(115, 35, 100, 20);
		 content.add(password2);
		 JLabel label3 = new JLabel("重新输入新密码:");
		 label3.setBounds(10, 60, 100, 20);
		 content.add(label3);
		 password3 = new JPasswordField();
		 password3.addKeyListener(new KeyAdapter()
			{
				public void keyReleased(KeyEvent arg0) {
					// TODO Auto-generated method stub
					String getPassword = new String();
					getPassword = password3.getText();
					if(getPassword.length()>10)
					{
						JOptionPane.showMessageDialog(null, "密码长度不能超过10");
						password3.setText("");
					}
				}
			});
		 password3.setBounds(115, 60, 100, 20);
		 content.add(password3);
		JButton button = new JButton("确定");
		button.addActionListener(new ActionListener()
		{

				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String password = null;
					ResultSet rs ;
					try {
						rs = state.executeQuery("select password from employee where name = '"+userName+"'");
						rs.next();
						password = rs.getString(1).trim();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					if(!password1.getText().equals(password))
					{
						JOptionPane.showMessageDialog(null, "原密码错误");
						password1.setText("");
						password2.setText("");
						password3.setText("");
					}
					else if(!password3.getText().equals(password2.getText()))
					{
						JOptionPane.showMessageDialog(null, "两次输入的新密码不同！");
						password1.setText("");
						password2.setText("");
						password3.setText("");
					}
					else
					{
						try {
							state.execute("update employee set password = '"+password2.getText()+"' where name = '"+userName+"'");
							dispose();
							JOptionPane.showMessageDialog(null, "密码修改成功");
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
						
				}
				
			});
		 button.setBounds(80, 100, 60, 25);
		 content.add(button);
		 
		 contain.add(content);
		 
	}
	
	private void frameSet()
	{
		setTitle("修改密码");
		setModal(true);
		setLocation(150, 100);
		setSize(240, 160);
		setVisible(true);
	}
	
}
