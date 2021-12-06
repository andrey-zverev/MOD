import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.statistics.HistogramDataset;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class Window {

	private JFrame frmFirstPicture;
	public void showWindow(double[] histogram) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					Window window = new Window(histogram);
					window.frmFirstPicture.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	public Window(double[] histogram) {
		initialize(histogram);
	}

	private void initialize(double[] histogram) {
		frmFirstPicture = new JFrame();
		frmFirstPicture.getContentPane().setEnabled(false);
		frmFirstPicture.setTitle("Ãטסעמדנאללא");
		frmFirstPicture.setBounds(100, 100, 1200, 900);
		frmFirstPicture.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frmFirstPicture.getContentPane().add(tabbedPane, BorderLayout.NORTH);
		
		JPanel secondPanel = new JPanel();
		JFreeChart chart = createChart(histogram);
		ChartPanel CP = new ChartPanel(chart);
		CP.setPreferredSize(new Dimension(1200,900));
		secondPanel.add(CP);
		tabbedPane.add("Second", secondPanel);
	}
	
	public JFreeChart createChart(double[] histogram) {
		HistogramDataset dataset = new HistogramDataset();
		dataset.addSeries("key", histogram, 20);
		
        JFreeChart chart = ChartFactory.createHistogram("Ãטסעמדנאללא", "i", "X" ,dataset, PlotOrientation.VERTICAL, false, false, false);
 
        return chart;

    }
	
}
