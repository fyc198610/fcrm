package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.JTree;
import javax.swing.KeyStroke;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.Border;
import javax.swing.plaf.SeparatorUI;
import javax.swing.table.TableColumnModel;

import sun.security.krb5.internal.tools.Kinit;

import db.DerbyConnection;

public class UserFace extends JFrame{
	
	Statement state;
	String userName;
	Container contain;
	JPanel centerPane;
	JPanel westPane;
	
	public UserFace(String userName)
	{
		try {
//			DerbyConnection.f_setConnect();//测试时使用
			state = DerbyConnection.f_getConnect().createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.userName = userName;
		contain = getContentPane();
		centerPane = new JPanel(new BorderLayout());
		westPane = new JPanel(new BorderLayout());
		menubar();
		toolBar();
		contain.add(centerPane);
		contain.add(westPane,BorderLayout.WEST);
		FrameSet();
	}
	
	JMenu menu1 = f_getMenu("文件(F)");
	JMenu menu2 = f_getMenu("客户管理(M)");
	JMenu menu3 = f_getMenu("联系人(L)");
	JMenu menu4 = f_getMenu("客户发展计划(P)");
	JMenu menu5 = f_getMenu("客户价值管理(V)");
	JMenu menu6 = f_getMenu("客户信誉管理(C)");
	JMenu menu7 = f_getMenu("客户满意度(S)");
	JMenu menu8 = f_getMenu("我是经理(A)");
	JMenu menu9 = f_getMenu("help(H)");
	public void menubar()
	{
		JMenuBar menub = new JMenuBar();
		menuFile();
		menub.add(menu1);
		menu1.setMnemonic('F');
		menuClientManage();
		menub.add(menu2);
		menu2.setMnemonic('M');
		menuLinkMan();
		menub.add(menu3);
		menu3.setMnemonic('L');
		menuDevelop();
		menub.add(menu4);
		menu4.setMnemonic('P');
		menuClientValue();
		menub.add(menu5);
		menu5.setMnemonic('V');
		menuCredit();
		menub.add(menu6);
		menu6.setMnemonic('C');
		menuSatisfaction();
		menub.add(menu7);
		menu7.setMnemonic('S');
		menuManager();
		menub.add(menu8);
		menu8.setMnemonic('A');
		menuHelp();
		menub.add(menu9);
		menu9.setMnemonic('H');
		menub.setBackground(Color.LIGHT_GRAY);
		menub.setBorder(BorderFactory.createLineBorder(Color.gray));
		setJMenuBar(menub);
		
	}
	
	JMenuItem menuitem11;
	JMenuItem menuitem12;
	JMenuItem menuitem13;
	
	public void menuFile()
	{
		menuitem11 = f_getMenuitem("重新登陆");
		menuitem11.setIcon(new ImageIcon("icons/kong10.png"));
		menuitem11.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					state.execute("update client set active = 0 ");
					state.execute("update linkman set active=0 ");
					state.execute("update tradeamount set active=0 ");
					state.execute("update deveplan set active=0 ");
					state.execute("update satisfaction set active = 0 ");
					state.execute("update kindclient set active = 0 ");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
				new StartFace();
			}
			
		});
		menu1.add(menuitem11);
		menuitem12 = f_getMenuitem("修改密码");
		menuitem12.setIcon(new ImageIcon("icons/locked.png"));
		menuitem12.setMnemonic('P');
		menuitem12.setAccelerator(KeyStroke.getKeyStroke('P', Event.CTRL_MASK, false));
		menuitem12.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new ChangePassword(userName);
			}
			
		});
		menu1.add(menuitem12);
		menuitem13 = f_getMenuitem("退出系统");
		menuitem13.setIcon(new ImageIcon("icons/kong10.png"));
		menuitem13.setMnemonic('E');
		menuitem13.setAccelerator(KeyStroke.getKeyStroke('E', Event.CTRL_MASK, false));
		menuitem13.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				try {
					state.execute("update client set active = 0 ");
					state.execute("update linkman set active=0 ");
					state.execute("update tradeamount set active=0 ");
					state.execute("update deveplan set active=0 ");
					state.execute("update satisfaction set active = 0 ");
					state.execute("update kindclient set active = 0 ");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
				System.exit(0);
			}
			
		});
		menu1.add(menuitem13);
	}
	
	JMenuItem menuitem21;
	JMenuItem menuitem22;
	JMenuItem menuitem23;
	JMenuItem menuitem24;
	JButton button1;
	JButton button2;
	JButton button3;
	JTable table;
	
	public void menuClientManage()
	{
		menuitem21 = f_getMenuitem("所有客户");
		menuitem21.setIcon(new ImageIcon("icons/kong16.png"));
		menuitem21.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
					centerPane.removeAll();
					JLabel label = new JLabel("所 有 客 户",JLabel.CENTER);
					label.setFont(new Font("楷体",Font.BOLD,16));
					centerPane.add(label,BorderLayout.NORTH);
					
					table = new FindCustomer().toTable("all");
					table.addMouseListener(new MouseAdapter()
					{

						public void mouseClicked(MouseEvent e) {
							// TODO Auto-generated method stub
							int row = table.getSelectedRow();
							if(e.getButton()==e.BUTTON1)
							{
							if(e.getClickCount()==2)
							{
								String number = (String)table.getValueAt(row, 0);
								JOptionPane.showMessageDialog(null, "显示编号为'"+number+"'的客户详细信息");
							}
							}
							else if(e.getButton() == e.BUTTON3&&row != -1)
							{
								JPopupMenu popup = new JPopupMenu();
								JMenuItem menu1 = new JMenuItem("右键待实现");
								JMenuItem menu2 = new JMenuItem("选择了编号"+table.getValueAt(row, 0));
								popup.add(menu1);
								popup.add(menu2);
								menu2.setEnabled(false);
								popup.show(table, e.getX(), e.getY());
							}
						}

						
						
					});
					table.setRowHeight(23);
					TableColumnModel columnModel = table.getColumnModel();
					
					columnModel.getColumn(0).setMaxWidth(60);
					columnModel.getColumn(0).setPreferredWidth(60);
					columnModel.getColumn(0).setMinWidth(60);
					
					columnModel.getColumn(2).setMaxWidth(70);
					columnModel.getColumn(2).setPreferredWidth(70);
					columnModel.getColumn(2).setMinWidth(70);
					
					columnModel.getColumn(3).setMaxWidth(87);
					columnModel.getColumn(3).setPreferredWidth(87);
					columnModel.getColumn(3).setMinWidth(87);
					
					columnModel.getColumn(4).setMaxWidth(128);
					columnModel.getColumn(4).setPreferredWidth(128);
					columnModel.getColumn(4).setMinWidth(128);
					
					columnModel.getColumn(5).setMaxWidth(128);
					columnModel.getColumn(5).setPreferredWidth(128);
					columnModel.getColumn(5).setMinWidth(128);
					
					columnModel.getColumn(6).setMaxWidth(94);
					columnModel.getColumn(6).setPreferredWidth(94);
					columnModel.getColumn(6).setMinWidth(94);
					
					columnModel.getColumn(7).setMaxWidth(84);
					columnModel.getColumn(7).setPreferredWidth(84);
					columnModel.getColumn(7).setMinWidth(84);
					
					columnModel.getColumn(9).setMaxWidth(55);
					columnModel.getColumn(9).setPreferredWidth(55);
					columnModel.getColumn(9).setMinWidth(55);
					
					table.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					
					for(int i = 0,n = columnModel.getColumnCount();i<n;i++)
					{
						columnModel.getColumn(i).setCellRenderer(new RowColorRenderer());
					}
					
					JScrollPane jspane = new JScrollPane(table);
					centerPane.add(jspane);
					JPanel bottom = new JPanel();
					button1 = new JButton("查看详情");
					button1.addActionListener(new ActionListener()
					{

						public void actionPerformed(ActionEvent arg0) {
							// TODO Auto-generated method stub
							JDialog detailDialog = new JDialog();
							int row = table.getSelectedRow();
							if(row == -1)
								JOptionPane.showMessageDialog(null, "请选择一个客户");
							else
							{
							String number = (String)table.getValueAt(row, 0);
							detailDialog.add(new JLabel("显示编号'"+number+"'的详细信息",JLabel.CENTER));
							detailDialog.setTitle("详细信息");
							detailDialog.setSize(new Dimension(300,200));
							detailDialog.setLocation(200, 100);
							detailDialog.setVisible(true);
							}
						}
						
					});
					button2 = new JButton("修改");
					button2.addActionListener(new ActionListener()
					{

						public void actionPerformed(ActionEvent arg0) {
							// TODO Auto-generated method stub
							JDialog changeDialog = new JDialog();
							int row = table.getSelectedRow();
							if(row == -1)
								JOptionPane.showMessageDialog(null, "请选择一个客户");
							else
							{
							String number = (String)table.getValueAt(row, 0);
							changeDialog.add(new JLabel("修改客户编号为'"+number+"'的客户信息",JLabel.CENTER));
							changeDialog.setTitle("修改客户信息");
							changeDialog.setSize(new Dimension(300,200));
							changeDialog.setLocation(200, 100);
							changeDialog.setVisible(true);
							}
						}
						
					});
					button3 = new JButton("删除");
					button3.addActionListener(new ActionListener()
					{

						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							int row = table.getSelectedRow();
							if(row == -1)
								JOptionPane.showMessageDialog(null, "请选择一个客户");
							else
							{
							String number = (String)table.getValueAt(row, 0);
							JOptionPane.showMessageDialog(null, "删除编号为’"+number+"‘的客户信息需输入密码");
							}
						}
						
					});
					bottom.add(button1);
					button1.setFont(new Font("楷体",Font.PLAIN,13));
					button1.setMargin(new Insets(1,3,1,3));
					button1.setPreferredSize(new Dimension(70,20));
					bottom.add(button2);
					button2.setFont(new Font("楷体",Font.PLAIN,13));
					button2.setMargin(new Insets(1,3,1,3));
					button2.setPreferredSize(new Dimension(40,20));
					bottom.add(button3);
					button3.setFont(new Font("楷体",Font.PLAIN,13));
					button3.setMargin(new Insets(1,3,1,3));
					button3.setPreferredSize(new Dimension(40,20));
					centerPane.add(bottom,BorderLayout.SOUTH);
					centerPane.revalidate();
					
			}
			
		});
		menu2.add(menuitem21);
		menuitem22 = f_getMenuitem("客户分类");
		menuitem22.setIcon(new ImageIcon("icons/kong16.png"));
		menuitem22.setMnemonic('K');
		menuitem22.setAccelerator(KeyStroke.getKeyStroke('K', Event.CTRL_MASK, false));
		menu2.add(menuitem22);
		menuitem22.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				westPane.removeAll();
				JScrollPane kindScrollPane = new JScrollPane();
				JTree tree = new CustomerKind(userName).getTree();
				kindScrollPane.setViewportView(tree);
				westPane.add(kindScrollPane);
				westPane.revalidate();
			}
			
		});
		
		
		menuitem23 = f_getMenuitem("添加客户");
		menuitem23.setAlignmentY(SwingConstants.LEFT);
		menuitem23.setIcon(new ImageIcon("icons/addcustomer.png"));
		menuitem23.setMnemonic('A');
		menuitem23.setAccelerator(KeyStroke.getKeyStroke('A', Event.CTRL_MASK, false));
		menu2.add(menuitem23);
		menuitem23.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new AddCustomer(userName);
			}
			
		});
		menuitem24 = f_getMenuitem("客户查询");
		menuitem24.setIcon(new ImageIcon("icons/kong16.png"));
		menuitem24.setMnemonic('F');
		menuitem24.setAccelerator(KeyStroke.getKeyStroke('F', Event.CTRL_MASK, false));
		menu2.add(menuitem24);
		menuitem24.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			new FindCustomerFrame(centerPane);
			}
			
		});
	}
	
	JMenuItem menuitem31;
	JMenuItem menuitem32;
	public void menuLinkMan()
	{
		menuitem31 = f_getMenuitem("查找联系人");
		menuitem31.setIcon(new ImageIcon("icons/kong16.png"));
		menuitem31.setMnemonic('F');
		menuitem31.setAccelerator(KeyStroke.getKeyStroke('F', Event.CTRL_MASK|Event.SHIFT_MASK, false));
		menu3.add(menuitem31);
		menuitem31.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new FindLinkmanFrame(centerPane);
			}
			
		});
		menuitem32 = f_getMenuitem("添加联系人");
		menuitem32.setIcon(new ImageIcon("icons/addlinkman.png"));
		menu3.add(menuitem32);
		menuitem32.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new AddLinkman();
				
			}
			
		});
		
	}
	
	JMenuItem menuitem41;
	JMenuItem menuitem42;
	JMenuItem menuitem43;
	JMenuItem menuitem44;
	public void menuDevelop()
	{
		menuitem41 = f_getMenuitem("制定计划");
		menuitem41.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new AddPlan();
			}
			
		});
		menu4.add(menuitem41);
		menuitem42 = f_getMenuitem("已完成计划");
		menuitem42.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JTable table = new PlanTable("已完成计划").getTable();
				centerPane.removeAll();
				centerPane.add(new JScrollPane(table));
				centerPane.revalidate();
				
//				setVisible(true);
			}
			
		});
		menu4.add(menuitem42);
		menuitem43 = f_getMenuitem("未完成计划");
		menuitem43.setMnemonic('U');
		menuitem43.setAccelerator(KeyStroke.getKeyStroke('U', Event.CTRL_MASK, false));
		menuitem43.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JTable table = new PlanTable("未完成计划").getTable();
				centerPane.removeAll();
				centerPane.add(new JScrollPane(table));
				centerPane.revalidate();
//				setVisible(true);
			}
			
		});
		menu4.add(menuitem43);
		menuitem44 = f_getMenuitem("过期计划");
		menuitem44.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JTable table = new PlanTable("过期计划").getTable();
				centerPane.removeAll();
				centerPane.add(new JScrollPane(table));
				centerPane.revalidate();
//				setVisible(true);
			}
			
		});
		menu4.add(menuitem44);
	}
	
	JMenuItem menuitem51;
	JMenuItem menuitem52;
	JMenuItem menuitem53;
	JMenuItem menuitem54;
	JMenuItem menuitem55;
	public void menuClientValue()
	{
		menuitem51 = f_getMenuitem("稳定大客户");
		menu5.add(menuitem51);
		menuitem52 = f_getMenuitem("百分比增长快速");
		menu5.add(menuitem52);
		menuitem53 = f_getMenuitem("交易额增长快速");
		menu5.add(menuitem53);
		menuitem54 = f_getMenuitem("客户交易额");
		menu5.add(menuitem54);
		menuitem55 = f_getMenuitem("本月交易额");
		menu5.add(menuitem55);
	}
	
	JMenuItem menuitem61;
	JMenuItem menuitem62;
	JMenuItem menuitem63;
	public void menuCredit()
	{
		menuitem61 = f_getMenuitem("信誉列表");
		menuitem61.setMnemonic('C');
		menuitem61.setAccelerator(KeyStroke.getKeyStroke('C', Event.CTRL_MASK, false));
		menu6.add(menuitem61);
		menuitem61.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JTable table = new CreditTable("all").getTable();
				centerPane.removeAll();
				centerPane.add(new JScrollPane(table));
				centerPane.revalidate();
//				setVisible(true);
			}
			
		});
		
		menuitem62 = f_getMenuitem("客户查找");
		menu6.add(menuitem62);
		menuitem62.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new FindCreditFrame(centerPane);
			}
			
		});
	}
	
	JMenuItem menuitem71;
	JMenuItem menuitem72;
	JMenuItem menuitem73;
	public void menuSatisfaction()
	{
		menuitem71 = f_getMenuitem("满意度调查表");
		menu7.add(menuitem71);
		menuitem71.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new AddSatisfaction();
			}
			
		});
		
		menuitem72 = f_getMenuitem("满意度分析");
		menuitem72.setMnemonic('S');
		menuitem72.setAccelerator(KeyStroke.getKeyStroke('S', Event.CTRL_MASK, false));
		menu7.add(menuitem72);
		menuitem72.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new SatisAnalyse(centerPane);
			}
			
		});
		menuitem73 = f_getMenuitem("查看满意度");
		menu7.add(menuitem73);
		menuitem73.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new FindSatisfactionPanel(centerPane);
			}
			
		});
	}
	
	JMenuItem menuitem81;
	JMenuItem menuitem82;
	public void menuManager()
	{
		String business = null;
		menuitem81 = f_getMenuitem("增加员工");
		menuitem81.setMnemonic('E');
		menuitem81.setAccelerator(KeyStroke.getKeyStroke('E', Event.CTRL_MASK|Event.SHIFT_MASK, false));
		menu8.add(menuitem81);
		menuitem81.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new AddEmployee();
			}
			
		});
		menuitem82 = f_getMenuitem("查询员工");
		menuitem82.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new FindEmployeeFrame(centerPane);
			}
			
		});
		menu8.add(menuitem82);
		try {
			ResultSet rs = state.executeQuery("select business from employee where name = '"+userName+"'");
			rs.next();
			business = rs.getString(1).trim();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(!business.equals("经理"))
		{
			menuitem81.setEnabled(false);
			menuitem82.setEnabled(false);
		}
		
	}
	
	JMenuItem menuitem91;
	public void menuHelp()
	{
		menuitem91 = f_getMenuitem("关于本软件");
		menu9.add(menuitem91);
	}
	
	
	JButton addCustomerTool;
	JButton addLinkManTool;
	JButton saveTool;
	JButton passwordTool;
	JButton deleteTool;
	JButton refreshTool;
	JButton searchTool;
	JButton downTool;
	JButton undoTool;
	JButton redoTool ;
	public void toolBar()
	{
		JSeparator toolSep1 = new JSeparator(JSeparator.VERTICAL);
		toolSep1.setMaximumSize(new Dimension(5,15));
		toolSep1.setMinimumSize(new Dimension(5,15));
		toolSep1.setPreferredSize(new Dimension(5,15));
		
		JSeparator toolSep2 = new JSeparator(JSeparator.VERTICAL);
		toolSep2.setMaximumSize(new Dimension(5,15));
		toolSep2.setMinimumSize(new Dimension(5,15));
		toolSep2.setPreferredSize(new Dimension(5,15));
		
		JSeparator toolSep3 = new JSeparator(JSeparator.VERTICAL);
		toolSep3.setMaximumSize(new Dimension(10,15));
		toolSep3.setMinimumSize(new Dimension(10,15));
		toolSep3.setPreferredSize(new Dimension(10,15));
		
		JToolBar toolbar = new JToolBar();
		toolbar.setFloatable(true);
		toolbar.addSeparator();
		
		addCustomerTool = new JButton(new ImageIcon("icons/addcustomer.png"));
		f_setTool(addCustomerTool);
		addCustomerTool.addMouseListener(new MouseListener()
		{

			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				new AddCustomer(userName);
			}

			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				addCustomerTool.setBackground(new Color(177,191,242));
				addCustomerTool.setOpaque(true);
			}

			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				addCustomerTool.setBackground(null);
			}

			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				addCustomerTool.setBackground(new Color(71,114,124));
				addCustomerTool.setOpaque(true);
			}

			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				addCustomerTool.setBackground(new Color(177,191,242));
				addCustomerTool.setOpaque(true);
			}
			
		});
		addCustomerTool.setToolTipText("增加客户");
		toolbar.add(addCustomerTool);
		
		toolbar.addSeparator();
		addLinkManTool = new JButton(new ImageIcon("icons/addlinkman.png"));
		f_setTool(addLinkManTool);
		addLinkManTool.addMouseListener(new MouseListener()
		{

			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				new AddLinkman();
			}

			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				addLinkManTool.setBackground(new Color(177,191,242));
				addLinkManTool.setOpaque(true);
			}

			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				addLinkManTool.setBackground(null);
			}

			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				addLinkManTool.setBackground(new Color(71,114,124));
				addLinkManTool.setOpaque(true);
			}

			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				addLinkManTool.setBackground(new Color(177,191,242));
				addLinkManTool.setOpaque(true);
			}
			
		});
		addLinkManTool.setToolTipText("增加联系人");
		toolbar.add(addLinkManTool);
		
		
		toolbar.addSeparator(new Dimension(5,15));
		toolbar.add(toolSep1);
		saveTool = new JButton(new ImageIcon("icons/save.png"));
		saveTool.setBorder(null);
		saveTool.setMaximumSize(new Dimension(22,22));
		saveTool.setMinimumSize(new Dimension(22,22));
		saveTool.setPreferredSize(new Dimension(22,22));
		saveTool.addMouseListener(new MouseListener()
		{

			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
//				saveTool.setBorder(BorderFactory.createEtchedBorder());
				saveTool.setBackground(new Color(177,191,242));
				saveTool.setOpaque(true);
			}

			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				saveTool.setBackground(null);
			}

			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				saveTool.setBackground(new Color(201,16,25));
				saveTool.setOpaque(true);
			}

			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				saveTool.setBackground(new Color(177,191,242));
				saveTool.setOpaque(true);
			}
			
		});
		saveTool.setToolTipText("保存");
		toolbar.add(saveTool);
		
		
		toolbar.addSeparator();
		passwordTool = new JButton(new ImageIcon("icons/locked.png"));
		f_setTool(passwordTool);
		passwordTool.addMouseListener(new MouseListener()
		{

			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				new ChangePassword(userName);
			}

			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				passwordTool.setBorder(BorderFactory.createLineBorder(new Color(177,191,242)));
			}

			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				passwordTool.setBorder(null);
			}

			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		passwordTool.setToolTipText("修改密码");
		toolbar.add(passwordTool);
		
		toolbar.addSeparator();
		deleteTool = new JButton(new ImageIcon("icons/delete.png"));
		f_setTool(deleteTool);
		deleteTool.addMouseListener(new MouseListener()
		{

			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				deleteTool.setBorder(BorderFactory.createLineBorder(new Color(177,191,242)));
			}

			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				deleteTool.setBorder(null);
			}

			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		deleteTool.setToolTipText("删除");
		toolbar.add(deleteTool);
		
		toolbar.addSeparator();
		refreshTool = new JButton(new ImageIcon("icons/refresh.png"));
		f_setTool(refreshTool);
		refreshTool.addMouseListener(new MouseListener()
		{

			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				refreshTool.setBorder(BorderFactory.createLineBorder(new Color(177,191,242)));
			}

			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				refreshTool.setBorder(null);
			}

			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		refreshTool.setToolTipText("刷新");
		toolbar.add(refreshTool);
		
		toolbar.addSeparator(new Dimension(10,15));
		toolbar.add(toolSep2);
		searchTool = new JButton(new ImageIcon("icons/search.png"));
		f_setTool(searchTool);
		searchTool.addMouseListener(new MouseListener()
		{

			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				new FindCustomerFrame(centerPane);
			}

			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				searchTool.setBorder(BorderFactory.createLineBorder(new Color(177,191,242)));
				
				
			}

			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				searchTool.setBorder(null);
			}

			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		searchTool.setToolTipText("查找");
		toolbar.add(searchTool);
		downTool = new JButton(new ImageIcon("icons/down.png"));
		downTool.setBorder(null);
		downTool.setMaximumSize(new Dimension(10,22));
		downTool.setMinimumSize(new Dimension(10,22));
		downTool.setPreferredSize(new Dimension(10,22));
		downTool.addMouseListener(new MouseListener()
		{

			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				JPopupMenu pop = new JPopupMenu();
				JMenuItem menu1 = f_getMenuitem("查找客户");
				menu1.addActionListener(new ActionListener()
				{

					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						new FindCustomerFrame(centerPane);
					}
					
				});
				JMenuItem menu2 = f_getMenuitem("查找联系人");
				menu2.addActionListener(new ActionListener()
				{

					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						new FindLinkmanFrame(centerPane);
					}
					
				});
				pop.add(menu1);
				pop.add(menu2);
				pop.show(contain, searchTool.getX(), searchTool.getY()+searchTool.getHeight());
			}

			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				searchTool.setBorder(BorderFactory.createLineBorder(new Color(177,191,242)));
				downTool.setBorder(BorderFactory.createLineBorder(new Color(177,191,242)));
			}

			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				searchTool.setBorder(null);
				downTool.setBorder(null);
			}

			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		downTool.setToolTipText("查找");
		toolbar.add(downTool);
		
		toolbar.addSeparator(new Dimension(5,15));
		toolbar.add(toolSep3);
		
		undoTool = new JButton(new ImageIcon("icons/undo.png"));
		f_setTool(undoTool);
		undoTool.addMouseListener(new MouseListener()
		{

			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				undoTool.setBorder(BorderFactory.createLineBorder(new Color(177,191,242)));
			}

			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				undoTool.setBorder(null);
			}

			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		undoTool.setToolTipText("撤销");
		toolbar.add(undoTool);
		
		toolbar.addSeparator();
		redoTool = new JButton(new ImageIcon("icons/redo.png"));
		f_setTool(redoTool);
		redoTool.addMouseListener(new MouseListener()
		{

			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				redoTool.setBorder(BorderFactory.createLineBorder(new Color(177,191,242)));
			}

			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				redoTool.setBorder(null);
			}

			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		redoTool.setToolTipText("恢复");
		toolbar.add(redoTool);
		
		
		toolbar.add(Box.createRigidArea(new Dimension(5,26)));
		toolbar.add(Box.createHorizontalGlue());
		
		Calendar ca = Calendar.getInstance();
		int year = ca.get(Calendar.YEAR);
		int month = ca.get(Calendar.MONTH)+1;
		int day = ca.get(Calendar.DAY_OF_MONTH);
		String date = year+"年"+month+"月"+day+"日";
		StringBuffer week = new StringBuffer("星期");
		int weekday = ca.get(Calendar.DAY_OF_WEEK);
		switch (weekday) {
		case 1:week.append("日");break;
		case 2:week.append("一");break;
		case 3:week.append("二");break;
		case 4:week.append("三");break;
		case 5:week.append("四");break;
		case 6:week.append("五");break;
		case 7:week.append("六");break;
		default:;break;
			
		}
		JLabel label1 = new JLabel(date+"   "+week);
		toolbar.add(label1);
		
		toolbar.add(Box.createHorizontalStrut(20));
		
		JLabel label2 = new JLabel("欢迎您："+userName);
		toolbar.add(label2);
		
		toolbar.add(Box.createHorizontalStrut(15));
		
		contain.add(toolbar,BorderLayout.NORTH);
		
	}
	
	public void FrameSet()
	{
		setTitle(" F-CRM");
		setIconImage(Toolkit.getDefaultToolkit().getImage("icons/logo1.png"));
		setSize(new Dimension(700,500));
		setLocation(150, 100);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				
				try {
					state.execute("update client set active = 0 ");
					state.execute("update linkman set active=0 ");
					state.execute("update tradeamount set active=0 ");
					state.execute("update deveplan set active=0 ");
					state.execute("update satisfaction set active = 0 ");
					state.execute("update kindclient set active = 0 ");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
	}
	
	public JMenu f_getMenu(String title)
	{
		JMenu menu = new JMenu(title);
		menu.setFont(new Font("宋体",Font.PLAIN,12));
		return menu;
	}
	
	public JMenuItem f_getMenuitem(String title)
	{
		JMenuItem menuitem = new JMenuItem(title);
		menuitem.setFont(new Font("宋体",Font.PLAIN,12));
		return menuitem;
	}
	
	public void f_setTool(JButton toolButton)
	{
		toolButton.setBorder(null);
		toolButton.setMaximumSize(new Dimension(22,22));
		toolButton.setMinimumSize(new Dimension(22,22));
		toolButton.setPreferredSize(new Dimension(22,22));
	}
	
//	public static void main(String[] args) {
//		UserFace uf = new UserFace("冯雅超");
//	}
}
