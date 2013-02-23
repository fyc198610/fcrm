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
			this.title = "第一题";
		else if(title.equals("number2"))
			this.title = "第二题";
		else if(title.equals("number3"))
			this.title = "第三题";
		else if(title.equals("number4"))
			this.title = "第四题";
		else if(title.equals("number5"))
			this.title = "第五题";
		else if(title.equals("number6"))
			this.title = "第六题";
		else if(title.equals("number7"))
			this.title = "第七题";
		else if(title.equals("number8"))
			this.title = "第八题";
		else if(title.equals("number9"))
			this.title = "第九题";
		else if(title.equals("number10"))
			this.title = "第十题";
		else if(title.equals("number11"))
			this.title = "第十一题";
		else if(title.equals("number12"))
			this.title = "第十二题";
		else if(title.equals("所有"))
			this.title = "所有题";
		this.data = data;
		pieChart();
		frameSet();
	}
	
	private void pieChart()
	{
		JPanel jpanel = new JPanel(new BorderLayout());
		JLabel chartTitle = new JLabel(title+"的统计图",JLabel.CENTER);
		chartTitle.setFont(new Font("楷体",Font.BOLD,16));
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
		setTitle("客户满意度统计图");
		setLocation(300, 200);
		setSize(new Dimension(510,360));
		setIconImage(new ImageIcon("icons/logo1.png").getImage());
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}
}
