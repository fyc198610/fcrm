package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

import com.sun.org.apache.regexp.internal.recompile;

import db.DerbyConnection;

public class CustomerKind {

	String userName;
	Statement state;
	Statement state1;
	Statement state2;
	Statement state3;
	Statement state4;
	Statement state5;
	JTree tree ;
	DefaultMutableTreeNode root;
	public CustomerKind(String userName)
	{
		try {
			state = DerbyConnection.f_getConnect().createStatement();
			state1 = DerbyConnection.f_getConnect().createStatement();
			state2 = DerbyConnection.f_getConnect().createStatement();
			state3 = DerbyConnection.f_getConnect().createStatement();
			state4 = DerbyConnection.f_getConnect().createStatement();
			state5 = DerbyConnection.f_getConnect().createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		try {
//			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InstantiationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (UnsupportedLookAndFeelException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		this.userName = userName;
		createTree();
	}
	
	String str1;
	String str2;
	String str3;
	DefaultMutableTreeNode node1;
	DefaultMutableTreeNode node2;
	DefaultMutableTreeNode node3;
	DefaultMutableTreeNode node4;
	DefaultMutableTreeNode node5;
	public void createTree()
	{
		root = new DefaultMutableTreeNode("客户分类");
		ResultSet rs1;
		ResultSet rs2;
		ResultSet rs3;
		ResultSet rs4;
		ResultSet rs5;
		try {
			rs1 = state1.executeQuery("select * from kind where parentkind = '000'");
			while(rs1.next())
			{
				str1 = rs1.getString(1).trim();
				str2 = rs1.getString(2).trim();
				str3 = "["+str1+"]"+str2;
				root.add(node1 = new DefaultMutableTreeNode(str3));
				rs2 = state2.executeQuery("select * from kind where parentkind = '"+str1+"'");
				while(rs2.next())
				{
					str1 = rs2.getString(1).trim();
					str2 = rs2.getString(2).trim();
					str3 = "["+str1+"]"+str2;
					node1.add(node2 = new DefaultMutableTreeNode(str3));
					rs3 = state3.executeQuery("select * from kind where parentkind = '"+str1+"'");
					while(rs3.next())
					{
						str1 = rs3.getString(1).trim();
						str2 = rs3.getString(2).trim();
						str3 = "["+str1+"]"+str2;
						node2.add(node3 = new DefaultMutableTreeNode(str3));
						rs4 = state4.executeQuery("select * from kind where parentkind = '"+str1+"'");
						while(rs4.next())
						{
							str1 = rs4.getString(1).trim();
							str2 = rs4.getString(2).trim();
							str3 = "["+str1+"]"+str2;
							node3.add(node4 = new DefaultMutableTreeNode(str3));
							rs5 = state5.executeQuery("select * from kind where parentkind = '"+str1+"'");
							while(rs5.next())
							{
								str1 = rs5.getString(1).trim();
								str2 = rs5.getString(2).trim();
								str3 = "["+str1+"]"+str2;
								node4.add(node5 = new DefaultMutableTreeNode(str3));
								
							}
						}
					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tree = new JTree(root);
		tree.addMouseListener(new MouseListener()
		{

			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int selectRow = tree.getRowForLocation(e.getX(), e.getY());
				if(selectRow!=-1)
				{
					if(e.getClickCount()==2&&e.getButton()==e.BUTTON1)
					{
						TreePath path = tree.getPathForRow(selectRow);
						TreeNode node = (TreeNode)path.getLastPathComponent();
						if(node.isLeaf())
						{
							String nodeNumber = node.toString().substring(1, 4);
							JOptionPane.showMessageDialog(null, "双击了"+nodeNumber+"号类别树叶节点");
						}
					}
					if(e.getButton() == e.BUTTON3)
					{
						TreePath path = tree.getPathForLocation(e.getX(), e.getY());
						tree.setSelectionPath(path);
						TreeNode node = (TreeNode)path.getLastPathComponent();
						JPopupMenu kindPopup = kindPopup(node);
						kindPopup.show(tree, e.getX(), e.getY());
					}
					
				}
			}

			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}
	
	JDialog addKindDialog;
	DefaultMutableTreeNode selectedNode;
	String kindNumber;
	String kindName;
	JTextField number;
	JTextField name;
	public JPopupMenu kindPopup(TreeNode node)
	{
		selectedNode = (DefaultMutableTreeNode)node;
		addKindDialog = new JDialog();
		String nodeName = node.toString().trim();
		if(selectedNode.toString().trim().equals("客户分类"))
		{
			kindNumber = "000";
			kindName = "客户分类";
		}
		else
		{
			kindNumber = nodeName.substring(1, 4);
			kindName = nodeName.substring(5, nodeName.length());
		}
		JPopupMenu kindPopup = new JPopupMenu();
		JMenuItem addKind = new JMenuItem("增加分类");
		addKind.addActionListener(new ActionListener()
		{
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					ResultSet rs = state.executeQuery("select kindnumber from kindclient where kindnumber = '"+kindNumber+"'");
					if(rs.next())
						JOptionPane.showMessageDialog(null, "请删除此分类中的所有客户再添加分类");
					else
					{
						
						Container contain = addKindDialog.getContentPane();
						JPanel center = new JPanel(new GridLayout(2,1));
						JPanel jpanel = new JPanel();
						JLabel jlabel = new JLabel("分类编号");
						number = new JTextField();
						number.addKeyListener(new KeyAdapter()
						{

							public void keyTyped(KeyEvent e) {
								// TODO Auto-generated method stub
								if(e.getKeyChar()<'0'||e.getKeyChar()>'9')
								{
									JOptionPane.showMessageDialog(null, "编号只能输入三位数字");
									number.setText("");
								}
								
							}
							public void keyReleased(KeyEvent e)
							{
								if(number.getText().length()>3)
								{
									JOptionPane.showMessageDialog(null, "编号只能输入三位数字");
									number.setText("");
								}	
							}
							
						});
						number.setPreferredSize(new Dimension(100,20));
						jpanel.add(jlabel);
						jpanel.add(number);
						center.add(jpanel);
						jpanel = new JPanel();
						jlabel = new JLabel("分类名称");
						name = new JTextField();
						name.addKeyListener(new KeyAdapter()
						{

							public void keyReleased(KeyEvent e) {
								// TODO Auto-generated method stub
								if(name.getText().length()>10)
								{
									JOptionPane.showMessageDialog(null, "分类名称长度不能超过10位");
									name.setText("");
								}
									
							}

						});
						name.setPreferredSize(new Dimension(100,20));
						jpanel.add(jlabel);
						jpanel.add(name);
						center.add(jpanel);
						contain.add(center);
						JButton ok = new JButton("确定");
						contain.add(ok,BorderLayout.SOUTH);
						ok.addActionListener(new ActionListener()
						{
							public void actionPerformed(ActionEvent e) {
								String numbers = number.getText().trim();
								if(numbers.length()!=3)
									JOptionPane.showMessageDialog(null, "编号只能输入三位数字");
								else
								{
								String names = name.getText().trim();
								if(numbers.length()==0||names.length()==0)
									JOptionPane.showMessageDialog(null, "编号或类别名的长度不能为0");
								else
								{
								try {
									ResultSet rs = state.executeQuery("select kindnumber from kind");
									int row = 0;
									while(rs.next())
										row++;
									String[] array1 = new String[row];
									rs = state.executeQuery("select kindnumber from kind");
									row = 0;
									while(rs.next())
									{
										array1[row] = rs.getString(1).trim();
										row++;
									}
									int i = 0;
									for(;i<row;i++)
										if(array1[i].equals(numbers))
										{
											JOptionPane.showMessageDialog(null, "此编号已经存在");
											break;
										}
									if(i==row)
									{
										rs = state.executeQuery("select kindname from kind");
										String[] array2 = new String[row];
										row = 0;
										while(rs.next())
										{
											array2[row] = rs.getString(1).trim();
											row++;
										}
										i = 0;
										for(;i<row;i++)
											if(array2[i].equals(names))
											{
												JOptionPane.showMessageDialog(null, "此类别名已经存在");
												break;
											}
										if(i==row)
										{
											state.execute("insert into kind values ('"+numbers+"','"+names+"','"+kindNumber+"')");
											selectedNode.add(new DefaultMutableTreeNode("["+numbers+"]"+names));
											tree.revalidate();
											addKindDialog.dispose();
											JOptionPane.showMessageDialog(null, "添加成功");
											
										}
									}
											
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								}
							}
							}
						});
						addKindDialog.setModal(true);
						addKindDialog.setTitle("增加分类");
						addKindDialog.pack();
						addKindDialog.setVisible(true);
						
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		JMenuItem delKind = new JMenuItem("删除分类");
		delKind.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					ResultSet rs = state.executeQuery("select kindnumber from kindclient where kindnumber = '"+kindNumber+"'");
					if(rs.next())
						JOptionPane.showMessageDialog(null, "请先删除此分类下的所有客户");
					else
					{
						int result = JOptionPane.showConfirmDialog(null, "你将删除该分类！","确定窗口",JOptionPane.OK_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE);
						if(result == 0)
						{
							state.execute("delete from kind where kindnumber = '"+kindNumber+"'");
							DefaultMutableTreeNode parent = (DefaultMutableTreeNode)selectedNode.getParent();
							if(parent!=null)
							{
								parent.remove(selectedNode);
								tree.revalidate();
							}
						}
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		JMenuItem addcus = new JMenuItem("增加客户");
		addcus.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				String[] companyName;
				try {
					ResultSet rs = state.executeQuery("select number,name from client where active = 1");
					int row = 0;
					while(rs.next())
						row++;
					companyName = new String[row];
					rs = state.executeQuery("select number,name from client where active = 1");
					row = 0;
					while(rs.next())
					{
						companyName[row] = rs.getString(1).trim();
						companyName[row] = companyName[row]+"  "+rs.getString(2).trim();
						row++;
					}
						String result = (String)JOptionPane.showInputDialog(null, "选择一个客户添加到"+kindNumber+"类别中", "向'"+kindName+"'中添加客户", JOptionPane.PLAIN_MESSAGE, null, companyName, null);
						if(result != null)
						{
							rs = state.executeQuery("select number from employee where name = '"+userName+"'");
							rs.next();
							String empNumber = rs.getString(1).trim();
							int index = result.indexOf(" ");
							String cusNumber = result.substring(0, index);
							state.execute("insert into kindclient values ('"+kindNumber+"','"+cusNumber+"','"+empNumber+"',1)");
							
							JOptionPane.showMessageDialog(null, "添加成功");
						}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		JMenuItem rename = new JMenuItem("重命名");
		rename.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String result = (String)JOptionPane.showInputDialog(null, "请输入类别编号"+kindNumber+"的新名称:", "修改类别名称", JOptionPane.PLAIN_MESSAGE,null,null,kindName);
				if(result != null&&result.length()!=0)
				{
					if(result.length()>10)
						JOptionPane.showMessageDialog(null, "类型名太长");
					else
					{
						try {
							state.execute("update kind set kindname = '"+result.trim()+"' where kindnumber = '"+kindNumber+"'");
							selectedNode.setUserObject("["+kindNumber+"]"+result.trim());
							tree.revalidate();
							JOptionPane.showMessageDialog(null, "修改成功");
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			}
			
		});
		String business = null;
		try {
			ResultSet rs = state.executeQuery("select business from employee where name = '"+userName+"'");
			rs.next();
			business = rs.getString(1).trim();
			if(!business.equals("经理"))
			{
				addKind.setEnabled(false);
				delKind.setEnabled(false);
				rename.setEnabled(false);
			}
			rs = state.executeQuery("select kindnumber from kind where parentkind = '"+kindNumber+"'");
			if(rs.next())
			{
				delKind.setEnabled(false);
				addcus.setEnabled(false);
			}
			if(selectedNode.toString().trim().equals("客户分类"))
			{
				delKind.setEnabled(false);
				addcus.setEnabled(false);
				rename.setEnabled(false);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		kindPopup.add(addKind);
		kindPopup.add(delKind);
		kindPopup.add(addcus);
		kindPopup.add(rename);
		return kindPopup;
	}
	
	public JTree getTree()
	{  
		return tree;
	}
}
