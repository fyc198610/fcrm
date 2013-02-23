package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;

public class SatisPieChart extends JFrame{

	String title;
	String[] data;
	public SatisPieChart(String title, String[] data)
	{
		if(title.equals("number1"))
			this.title = "��һ��";
		else if(title.equals("number2"))
			this.title = "�ڶ���";
		else if(title.equals("number3"))
			this.title = "������";
		else if(title.equals("number4"))
			this.title = "������";
		else if(title.equals("number5"))
			this.title = "������";
		else if(title.equals("number6"))
			this.title = "������";
		else if(title.equals("number7"))
			this.title = "������";
		else if(title.equals("number8"))
			this.title = "�ڰ���";
		else if(title.equals("number9"))
			this.title = "�ھ���";
		else if(title.equals("number10"))
			this.title = "��ʮ��";
		else if(title.equals("number11"))
			this.title = "��ʮһ��";
		else if(title.equals("number12"))
			this.title = "��ʮ����";
		else if(title.equals("����"))
			this.title = "������";
		this.data = data;
		pieChart();
		frameSet();
	}
	
	private void pieChart()
	{
		JPanel jpanel = new JPanel(new BorderLayout());
		JLabel chartTitle = new JLabel(title+"��ͳ��ͼ",JLabel.CENTER);
		chartTitle.setFont(new Font("����",Font.BOLD,16));
		jpanel.add(chartTitle,BorderLayout.NORTH);
		
		DefaultPieDataset dataset = new DefaultPieDataset();
		int count = data.length;
		if(count==3)
		{
			String[] con = {"perfect","good ","bad "}; 
			for(int i= 0;i<count;i++)
			{
				dataset.setValue(con[i]+"="+Integer.parseInt(data[i]), Float.parseFloat(data[i]));
			}
		}
		else if(count == 12)
		{
			String[] con = {"number1","number2","number3","number4","number5","number6","number7","number8","number9","number10","number11","number12"};
			for(int i= 0;i<count;i++)
			{
				dataset.setValue(con[i]+"="+Integer.parseInt(data[i]), Float.parseFloat(data[i]));
			}
		}
		JFreeChart chart = ChartFactory.createPieChart3D(null, dataset, false, false, false);
	    PiePlot3D plot3 = (PiePlot3D) chart.getPlot();
	    plot3.setForegroundAlpha(0.6f);
	    plot3.setCircular(true);
	    jpanel.add(new ChartPanel(chart));
        setContentPane(jpanel);
	}
	
	private void frameSet()
	{
		setTitle("�ͻ������ͳ��ͼ");
		setLocation(300, 200);
		setSize(new Dimension(510,360));
		setIconImage(new ImageIcon("icons/logo1.png").getImage());
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}
}
