package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Popup;
import javax.swing.PopupFactory;
import javax.swing.SwingUtilities;

public class JDatePicker extends JPanel {

	private static final long serialVersionUID = 7812042345563281978L;
	private static SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	private static SimpleDateFormat displaysdf=new SimpleDateFormat("yyyy��M��");
	private static Color bgcolor=new Color(160,185,215);
	private JLabel lblDate; 		 // ��ʾһ������СͼƬ
	private JTextField txtDate;      //һ��������ʾѡ��ʱ����ı���
	private Popup pop=null;  		 //��ʱ��������Ķ���
	private JPanel lblmain;  		 //����ѡ����������壬���Ĳ������
	private JPanelHead head; 		 //ͷ�����ַ������� "<<"��һ��    "2009-05" ��ǰ�·�   ">>"��һ��
	private JPanelWeek week; 		 //������ʾ����
	private JPanelCalendar calendar; //������ʾ����
	private JPanelBottom bottom;     //�ײ� ��ʾ��ǰ���ڣ��û����ٷ��ص�ǰ����
	static int year=0,month=0,day=1,selectday; //��������ֵ�ı�־ ��Ĭ��ֵ����ν��day=1���� ,year �û�����û���ѡ�꣬ 
	                                              //month�� selectday ��ѡ�� ,��������ֵ����ϱ����û���ѡ������
	
	static  Calendar calendar0=Calendar.getInstance();  //��������
	//static Date chooseDay=calendar0.getTime();
	public static void setSimpleDateFormat(SimpleDateFormat simpledateformat){
		sdf=simpledateformat;
	}
	public JDatePicker(Dimension dimension){
		this.lblDate=new JLabel(new ImageIcon("icons/datePicker.gif"));
		this.txtDate=new JTextField(20);
		this.lblDate.setToolTipText("�����ң�����������\n�������ڣ�"+sdf.format(new Date()));
		this.setBackground(Color.white);
		txtDate.setText(sdf.format(new Date()));
		this.setSize(dimension);
		this.setLayout(null);
		this.lblDate.setBounds(0, 0, 20, 20);
		this.txtDate.setBounds(22, 0, dimension.width-22, 20);
		this.add(this.lblDate);
		this.add(this.txtDate);
		this.initDatePicker();
	}
	public JDatePicker(){
		this.lblDate=new JLabel(new ImageIcon("icons/datePicker.gif"));
		this.txtDate=new JTextField(20);
		this.lblDate.setToolTipText("�����ң�����������\n�������ڣ�"+sdf.format(new Date()));
		this.setBackground(Color.white);
		txtDate.setText(sdf.format(new Date()));
		this.setSize(120, 25);
		this.setLayout(null);
		this.lblDate.setBounds(0, 0, 20, 25);
		this.txtDate.setBounds(22, 0, 98, 25);
		this.add(this.lblDate);
		this.add(this.txtDate);
		this.initDatePicker();
	}
	public void initDatePicker(){
		this.head=new JPanelHead();
		this.week=new JPanelWeek();
		this.calendar=new JPanelCalendar();
		this.bottom=new JPanelBottom();
	
		this.lblmain=new JPanel();
		this.lblmain.setBackground(Color.GRAY);
		this.lblmain.setSize(new Dimension(180,160));
		this.lblmain.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		
		this.lblmain.setLayout(null);
		this.head.setBounds(0, 0, 180, 20);
		this.week.setBounds(0, 20, 180, 20);
		this.calendar.setBounds(0, 40, 180, 100);
		this.bottom.setBounds(0, 140, 180, 20);
		this.lblmain.add(this.head);
		this.lblmain.add(this.week);
		this.lblmain.add(this.calendar);
		this.lblmain.add(this.bottom);
		
		this.lblDate.addMouseListener(new MouseAdapter(){   //��СͼƬ��Ӽ�������������ʱ����������ѡ��lblmain
			public void mousePressed(MouseEvent e) {
				showPanel(lblDate);
			}
		});
		
	}
	   private void showPanel(Component owner){        //����һ����ʾ�����������ķ��������ø��ֵ�
	        if(pop!=null){
	            pop.hide();
	            pop = null;
	        }
	        else
	        {
	        Point show=new Point(0,lblDate.getHeight());
	        SwingUtilities.convertPointToScreen(show,lblDate);
	        Dimension size=Toolkit.getDefaultToolkit().getScreenSize();
	        int x=show.x;
	        int y=show.y;
	        if(x<0){
	            x=0;
	        }
	        if(x>size.width-180){
	            x=size.width-180;
	        }
	        if(y<size.height-160){
	        }else{
	            y-=168;
	        }
	        pop=PopupFactory.getSharedInstance().getPopup(owner,lblmain,x,y);
	        pop.show();
	        }
	    }
	   class JPanelHead extends JPanel{
		
		private static final long serialVersionUID = -2516097436496081975L;
		JLabel left,center,right;
		   public JPanelHead(){
			   this.left=new JLabel("<<",JLabel.CENTER);
			   this.left.setToolTipText("��һ��");
			   this.center=new JLabel(displaysdf.format(new Date()),JLabel.CENTER);
			   this.right=new JLabel(">>",JLabel.CENTER);
			   this.right.setToolTipText("��һ��");
			   this.setLayout(new BorderLayout());
			   this.add(this.left,BorderLayout.WEST);
			   this.add(this.center,BorderLayout.CENTER);
			   this.add(this.right,BorderLayout.EAST);
			   this.setBackground(bgcolor);
			   this.setSize(new Dimension(180,20));
			   
			   this.left.addMouseListener(new MouseAdapter(){

				public void mouseClicked(MouseEvent e) {
					lastMonth();
					calendar.displayFace(year, month);
					center.setText(displaysdf.format(getChooseDay()));
					
				}

				public void mouseEntered(MouseEvent e) {
					left.setCursor(new Cursor(Cursor.HAND_CURSOR));
					left.setForeground(Color.RED);
					
				}

				public void mouseExited(MouseEvent e) {
					left.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
					left.setForeground(Color.BLACK);
				}
 
			   });
			   this.right.addMouseListener(new MouseAdapter(){

					public void mouseClicked(MouseEvent e) {
						nextMonth();
						calendar.displayFace(year, month);
						center.setText(displaysdf.format(getChooseDay()));
						
					}

					public void mouseEntered(MouseEvent e) {
						right.setCursor(new Cursor(Cursor.HAND_CURSOR));
						right.setForeground(Color.RED);
						
					}

					public void mouseExited(MouseEvent e) {
						right.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
						right.setForeground(Color.BLACK);
					}
	 
				   });
		   }
	   }
	   class JPanelWeek extends JPanel{

		private static final long serialVersionUID = 1281505412525766486L;
		   String weeks[]={"��","һ","��","��","��","��","��"};
		   Label labs[];
		   public JPanelWeek(){
			  this.setBackground(Color.WHITE);
			  this.setBorder(BorderFactory.createLineBorder(bgcolor, 2));
			  labs=new Label[weeks.length];
			  Font font=new Font("����",Font.PLAIN,12);
			  this.setSize(new Dimension(175,20));
			  this.setLayout(null);
			  int w=this.getSize().width/7;
			  for(int i=0;i<weeks.length;i++){
				  labs[i]=new Label(weeks[i],JLabel.CENTER);
				  labs[i].setForeground(Color.darkGray);
				  labs[i].setBackground(Color.GRAY);
				  labs[i].setFont(font);
				  labs[i].setBounds(2+w*i, 0, w, 20);
				  this.add(labs[i]);
			  }
		   }
	   }
	   class JPanelCalendar extends JPanel{
		
		   private static final long serialVersionUID = 4526880206567665933L;
		   String a[];
		   int days[]={31,28,31,30,31,30,31,31,30,31,30,31};
		   String nowday;
		   Label label[][];
		   File file;
		   FileWriter fw;
		   BufferedWriter bfw;
		   public JPanelCalendar(){
			    super(new GridLayout(6,7));
	            this.setSize(new Dimension(180,100));
	            this.setBorder(BorderFactory.createLineBorder(bgcolor, 2));
	            calendar0.setTime(new Date());
	            year=calendar0.get(Calendar.YEAR);                     //��ʼ��Ϊ�������ڵ���
	            month=calendar0.get(Calendar.MONTH);                   //��ʼ��Ϊ�������ڵ��£�0 ��January
	    		nowday=String.valueOf(calendar0.get(Calendar.DAY_OF_MONTH));
	    		label=new Label[6][7];
	    		a=new String[42];
	  
	            for(int i=0,k=0;i<6;i++)
	    		{
	    			for( int j=0;j<7;j++)
	    			{
	    				label[i][j]=new Label(a[k++],Label.CENTER);
	    				label[i][j].addMouseListener(new MouseAdapter(){
							public void mouseClicked(MouseEvent e) {
								Label lab=(Label)e.getSource();
								if(lab.getText().equals(nowday)){
									lab.setBackground(Color.ORANGE);
								}else{
									lab.setBackground(Color.WHITE);
								}
								
								if(pop!=null){
									pop.hide();
								}
								if(!lab.getText().trim().equals("")){
									selectday=Integer.parseInt(lab.getText().trim());
								}
								txtDate.setText(sdf.format(getChooseDay()));
							}

							public void mouseEntered(MouseEvent e) {
								Label lab=(Label)e.getSource();
								lab.setBackground(Color.PINK);
								
							}

							public void mouseExited(MouseEvent e) {
								Label lab=(Label)e.getSource();
								if(lab.getText().equals(nowday)){
									lab.setBackground(Color.ORANGE);
								}else{
									lab.setBackground(Color.WHITE);
								}
								
							}
	    				});
	    				this.add(label[i][j]);
	    			}
	    		}
	            this.displayFace(year,month);   //������ʾ���淽��
		   }
		   public void displayFace(int year,int month){ //������Ҫ������������Ҫ��ʾ�������Ӧ�����Ǹ��·�
				calendar0.set(year,month,1);                                      //���Ƚ������������õ�ĳ��ĳ�µ�1����
				int whatday=calendar0.get(Calendar.DAY_OF_WEEK)-1;                //���1�������ڼ�
				if(((year%4==0&&year%100!=0)||(year%4==0&&year%400==0))&&month==1)//���õ��·ݹ��ж����� Month==1 ������·�
					days[month]=days[month]+1;                                     //������Ļ�Ӧ�ü�1�죬29�죬����28��
				for(int i=0,n=1;i<42;i++)                              //ͨ��ѭ����Ϊ42���ַ�������ֵ
				{
					if(i<whatday)                                      //1��֮ǰ���⼸��Ϊ����ʾ
						a[i]="";
					else if(i<whatday+days[month])                     //֮�󵽳���Ϊ�����������a�϶�����ʾ��������
					{
						if(n<=9)
							a[i]=" "+n;
						else
							a[i]=""+n;
						n++;
					}
					else                                              //�����Щ���ǿ�
						a[i]="";
				}
				for(int i=0,k=0;i<6;i++)
				{
					for(int j=0;j<7;j++)
					{
						label[i][j].setBackground(Color.white);
						label[i][j].setText("");
						label[i][j].setText(a[k++]);
						label[i][j].setAlignment(Label.CENTER);
						if(j<1||j>5)
							label[i][j].setForeground(Color.red);
						if(label[i][j].getText().equals(nowday))
							label[i][j].setBackground(Color.orange);
					}
				}
				this.validate();
			}
	   }
	   class JPanelBottom extends JPanel{

		private static final long serialVersionUID = -1793770674245706004L;
		JLabel nowDate;
		public JPanelBottom(){
			this.setPreferredSize(new Dimension(180,20));
			this.nowDate=new JLabel("�����ǣ�"+sdf.format(new Date()));
			this.nowDate.setToolTipText("����ص�����ʱ��");
			this.setLayout(new BorderLayout());
			this.setBackground(bgcolor);
			this.add(this.nowDate,BorderLayout.CENTER);
			this.nowDate.addMouseListener(new MouseAdapter(){

				public void mouseClicked(MouseEvent e) {
					calendar0=Calendar.getInstance();
					year=calendar0.get(Calendar.YEAR);
					month=calendar0.get(Calendar.MONTH);
					calendar.displayFace(year,month);
					head.center.setText(displaysdf.format(getChooseDay()));
				}

				public void mouseEntered(MouseEvent e) {
					nowDate.setCursor(new Cursor(Cursor.HAND_CURSOR));
					nowDate.setForeground(Color.red);
				}

				public void mouseExited(MouseEvent e) {
					nowDate.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
					nowDate.setForeground(Color.BLACK);
					
				}
				
			});
		}
	   }
	   void lastMonth(){                            //ǰһ����
		   if(month<=0){
			   year--;
			   month=11;
		   }else{
			   month--;
		   }
	   }
	   void nextMonth(){                            //��һ����
		   if(month>=11){
			   year++;
			   month=0;
		   }else{
			   month++;
		   }
	   }
	   public static Date getChooseDay(){                 //���ض���ʽ������ѡ���·�
		   String tempmonth="0"+(month+1),tempday="0"+selectday;
		   tempmonth=tempmonth.substring(tempmonth.length()-2, tempmonth.length());
		   tempday=tempday.substring(tempday.length()-2, tempday.length());
		   try {
			   return sdf.parse(year+"-"+tempmonth+"-"+tempday);
		   } catch (ParseException e) {
			   e.printStackTrace();
			   return null;
		   }  
	   }
	public JTextField getTxtDate() {
		return txtDate;
	}
}
