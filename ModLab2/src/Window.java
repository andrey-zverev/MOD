import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JTextField;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.statistics.HistogramDataset;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Window {

	private JFrame frame;
	private JTextField textFieldA;
	private JTextField textFieldB;
	private JTextField textFieldN;
	private JTextField textFieldGauss_n;
	private JTextField textFieldGauss_mx;
	private JTextField textFieldGauss_ox;
	private JTextField textFieldGauss_N;
	private JTextField textFieldExp_l;
	private JTextField textFieldExp_N;
	private JTextField textFieldGamma_n;
	private JTextField textFieldGamma_l;
	private JTextField textFieldGamma_N;
	private JTextField textFieldTriangle_a;
	private JTextField textFieldTriangle_b;
	private JTextField textFieldTriangle_n;
	private JTextField textFieldSimpson_a;
	private JTextField textFieldSimpson_b;
	private JTextField textFieldSimpson_n;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window window = new Window();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Window() {
		initialize();
	}


	private void initialize() 
	{
		frame = new JFrame("Ленько лабораторная работа №2");
		
		frame.setBounds(100, 100, 1000, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 984, 511);
		frame.getContentPane().add(tabbedPane);
		
		//инициализация
		JPanel panelInput = new JPanel();
		JPanel panel1 = new JPanel();
		panel1.add(new JPanel());
		JPanel panel2 = new JPanel();
		panel2.add(new JPanel());
		JPanel panel3 = new JPanel();
		panel3.add(new JPanel());
		JPanel panel4 = new JPanel();
		panel4.add(new JPanel());
		JPanel panel5 = new JPanel();
		panel5.add(new JPanel());
		JPanel panel6 = new JPanel();
		panel6.add(new JPanel());
		JPanel panel7 = new JPanel();
		panel7.add(new JPanel());
		
		tabbedPane.add("Входные значения", panelInput);
		tabbedPane.add("Равномерное", panel1);
		tabbedPane.add("Гауссовское", panel2);
		tabbedPane.add("Экспонциальное", panel3);
		tabbedPane.add("Гамма", panel4);
		tabbedPane.add("Треугольное", panel5);
		tabbedPane.add("Симпсон", panel6);
		tabbedPane.add("Треугольное MIN", panel7);
		
		panelInput.setLayout(null);
		
		
		//Обработка входной страницы
		
		
		//------------------------------------------------РАВНОМЕРНОЕ-------------------------------------------------------------------------------------
		JLabel label1 = new JLabel("Равномерное распределение: A =");
		label1.setBounds(10, 11, 217, 23);
		panelInput.add(label1);
		
		textFieldA = new JTextField();
		textFieldA.setBounds(220, 12, 86, 20);
		panelInput.add(textFieldA);
		textFieldA.setColumns(10);
		
		JLabel label2 = new JLabel("B =");
		label2.setBounds(316, 15, 46, 14);
		panelInput.add(label2);
		
		textFieldB = new JTextField();
		textFieldB.setBounds(372, 12, 86, 20);
		panelInput.add(textFieldB);
		textFieldB.setColumns(10);
		
		JLabel label3 = new JLabel(" N = ");
		label3.setBounds(468, 15, 46, 14);
		panelInput.add(label3);
		
		textFieldN = new JTextField();
		textFieldN.setBounds(524, 12, 86, 20);
		panelInput.add(textFieldN);
		textFieldN.setColumns(10);
		
		//------------------------------------------------ГАУСС-------------------------------------------------------------------------------------
		JLabel gauss = new JLabel("\u0413\u0430\u0443\u0441\u0441\u043E\u0432\u0441\u043A\u043E\u0435:                        n = ");
		gauss.setBounds(10, 48, 171, 14);
		panelInput.add(gauss);
		
		textFieldGauss_n = new JTextField();
		textFieldGauss_n.setBounds(220, 45, 86, 20);
		panelInput.add(textFieldGauss_n);
		textFieldGauss_n.setColumns(10);
		
		JLabel gauss_mx = new JLabel("Mx = ");
		gauss_mx.setBounds(316, 48, 46, 14);
		panelInput.add(gauss_mx);
		
		textFieldGauss_mx = new JTextField();
		textFieldGauss_mx.setBounds(372, 45, 86, 20);
		panelInput.add(textFieldGauss_mx);
		textFieldGauss_mx.setColumns(10);
		
		JLabel gauss_ox = new JLabel("\u03C3x =");
		gauss_ox.setBounds(468, 48, 46, 14);
		panelInput.add(gauss_ox);
		
		textFieldGauss_ox = new JTextField();
		textFieldGauss_ox.setBounds(524, 45, 86, 20);
		panelInput.add(textFieldGauss_ox);
		textFieldGauss_ox.setColumns(10);
		
		JLabel gauss_N = new JLabel("N = ");
		gauss_N.setBounds(620, 48, 46, 14);
		panelInput.add(gauss_N);
		
		textFieldGauss_N = new JTextField();
		textFieldGauss_N.setText("");
		textFieldGauss_N.setBounds(676, 45, 86, 20);
		panelInput.add(textFieldGauss_N);
		textFieldGauss_N.setColumns(10);
		
		
		//------------------------------------------------ЭКСПОНЦИАЛЬНОЕ-------------------------------------------------------------------------------------
		JLabel lblNewLabel = new JLabel("\u042D\u043A\u0441\u043F\u043E\u043D\u0446\u0438\u043E\u043D\u0430\u043B\u044C\u043D\u043E\u0435:            \u03BB =");
		lblNewLabel.setBounds(10, 79, 171, 14);
		panelInput.add(lblNewLabel);
		
		textFieldExp_l = new JTextField();
		textFieldExp_l.setBounds(220, 76, 86, 20);
		panelInput.add(textFieldExp_l);
		textFieldExp_l.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("N = ");
		lblNewLabel_1.setBounds(316, 79, 46, 14);
		panelInput.add(lblNewLabel_1);
		
		textFieldExp_N = new JTextField();
		textFieldExp_N.setBounds(372, 76, 86, 20);
		panelInput.add(textFieldExp_N);
		textFieldExp_N.setColumns(10);
		
		
		//------------------------------------------------ГАММА-------------------------------------------------------------------------------------
		JLabel lblNewLabel_2 = new JLabel("\u0413\u0430\u043C\u043C\u0430                                      \u03B7 =");
		lblNewLabel_2.setBounds(10, 111, 171, 14);
		panelInput.add(lblNewLabel_2);
		
		textFieldGamma_n = new JTextField();
		textFieldGamma_n.setBounds(220, 108, 86, 20);
		panelInput.add(textFieldGamma_n);
		textFieldGamma_n.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u03BB = ");
		lblNewLabel_3.setBounds(316, 111, 46, 14);
		panelInput.add(lblNewLabel_3);
		
		textFieldGamma_l = new JTextField();
		textFieldGamma_l.setBounds(372, 108, 86, 20);
		panelInput.add(textFieldGamma_l);
		textFieldGamma_l.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("N = ");
		lblNewLabel_4.setBounds(468, 111, 46, 14);
		panelInput.add(lblNewLabel_4);
		
		textFieldGamma_N = new JTextField();
		textFieldGamma_N.setBounds(524, 108, 86, 20);
		panelInput.add(textFieldGamma_N);
		textFieldGamma_N.setColumns(10);
		
		
		//------------------------------------------------ТРЕУГОЛЬНОЕ-------------------------------------------------------------------------------------
		JLabel lblNewLabel_5 = new JLabel("\u0422\u0440\u0435\u0443\u0433\u043E\u043B\u044C\u043D\u044B\u0435:                      a =");
		lblNewLabel_5.setBounds(10, 149, 171, 14);
		panelInput.add(lblNewLabel_5);
		
		textFieldTriangle_a = new JTextField();
		textFieldTriangle_a.setBounds(220, 146, 86, 20);
		panelInput.add(textFieldTriangle_a);
		textFieldTriangle_a.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("b =");
		lblNewLabel_6.setBounds(316, 149, 46, 14);
		panelInput.add(lblNewLabel_6);
		
		textFieldTriangle_b = new JTextField();
		textFieldTriangle_b.setBounds(372, 146, 86, 20);
		panelInput.add(textFieldTriangle_b);
		textFieldTriangle_b.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("N = ");
		lblNewLabel_7.setBounds(468, 149, 46, 14);
		panelInput.add(lblNewLabel_7);
		
		textFieldTriangle_n = new JTextField();
		textFieldTriangle_n.setBounds(524, 146, 86, 20);
		panelInput.add(textFieldTriangle_n);
		textFieldTriangle_n.setColumns(10);
		
		
		//------------------------------------------------СИМПСОН-------------------------------------------------------------------------------------
		JLabel lblNewLabel_8 = new JLabel("\u0421\u0438\u043C\u043F\u0441\u043E\u043D:                               a = ");
		lblNewLabel_8.setBounds(10, 185, 171, 14);
		panelInput.add(lblNewLabel_8);
		
		textFieldSimpson_a = new JTextField();
		textFieldSimpson_a.setBounds(220, 182, 86, 20);
		panelInput.add(textFieldSimpson_a);
		textFieldSimpson_a.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("b =");
		lblNewLabel_9.setBounds(316, 185, 46, 14);
		panelInput.add(lblNewLabel_9);
		
		textFieldSimpson_b = new JTextField();
		textFieldSimpson_b.setBounds(372, 182, 86, 20);
		panelInput.add(textFieldSimpson_b);
		textFieldSimpson_b.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("N = ");
		lblNewLabel_10.setBounds(468, 185, 46, 14);
		panelInput.add(lblNewLabel_10);
		
		textFieldSimpson_n = new JTextField();
		textFieldSimpson_n.setBounds(524, 182, 86, 20);
		panelInput.add(textFieldSimpson_n);
		textFieldSimpson_n.setColumns(10);
		
		
		JButton buttonMath = new JButton("Math");
		

		//начало рассчётов
		buttonMath.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				panel1.remove(0);panel2.remove(0);panel3.remove(0);panel4.remove(0);panel5.remove(0);panel6.remove(0);panel7.remove(0);

				//первый алгоритм
				System.out.println("Равномерное распределение");
				panel1.add(initPanel(Algoritmes.uniformDistribution(
						  Double.parseDouble(textFieldA.getText())
						, Double.parseDouble(textFieldB.getText())
						, Integer.parseInt(textFieldN.getText())),"Равномерное распределение"));
				//второй алгоритм
				System.out.println("Гауссовское распределение");
				panel2.add(initPanel(Algoritmes.gaussDistribution(
						  Integer.parseInt(textFieldGauss_N.getText())
						, Double.parseDouble(textFieldGauss_mx.getText())
						, Double.parseDouble(textFieldGauss_ox.getText())
						, Integer.parseInt(textFieldGauss_n.getText())), "Гауссовское распределение"));
				
				//третий алгоритм
				System.out.println("Экспоненциальное распределение");
				panel3.add(initPanel(Algoritmes.exponentalDistribution(
						Integer.parseInt(textFieldExp_N.getText()), 
						Double.parseDouble(textFieldExp_l.getText())), "Экспоненциальное распределение"));
				//четвёртый алгоритм
				System.out.println("Гамма распреледение");
				panel4.add(initPanel(Algoritmes.gammalDistribution(
						Integer.parseInt(textFieldGamma_N.getText()), 
						Integer.parseInt(textFieldGamma_n.getText()), 
						Double.parseDouble(textFieldGamma_l.getText())),"Гамма распреледение"));
				//пятый алгоритм
				System.out.println("Треугольное распредение");
				panel5.add(initPanel(Algoritmes.triangleDistribution(
						Integer.parseInt(textFieldTriangle_n.getText()), 
						Double.parseDouble(textFieldTriangle_a.getText()), 
						Double.parseDouble(textFieldTriangle_b.getText())),"Треугольное распределение"));
				//шестой алгоритм
				System.out.println("Распределение Симпсона");
				panel6.add(initPanel(Algoritmes.simpsonDistribution(
						Integer.parseInt(textFieldSimpson_n.getText()), 
						Double.parseDouble(textFieldSimpson_a.getText()), 
						Double.parseDouble(textFieldSimpson_b.getText())),"Распределение Симпсона"));
				//cедьмой алгоритм
				System.out.println("Треугольное МИН");
				panel7.add(initPanel(Algoritmes.triangleDistributionMin(
						Integer.parseInt(textFieldSimpson_n.getText()), 
						Double.parseDouble(textFieldSimpson_a.getText()), 
						Double.parseDouble(textFieldSimpson_b.getText())),"Треугольное МИН"));
			}
		});
		
		buttonMath.setBounds(811, 426, 158, 46);
		panelInput.add(buttonMath);
	}
	
	
	
	
	public JPanel initPanel(double[] histogram, String name)
	{
		JPanel panel = new JPanel();
		JFreeChart chart = createChart(histogram, name);
		ChartPanel CP = new ChartPanel(chart);
		CP.setPreferredSize(new Dimension(900,450));
		panel.add(CP);
		return panel;
	}
	
	public JFreeChart createChart(double[] histogram, String name) {
		HistogramDataset dataset = new HistogramDataset();
		dataset.addSeries("key", histogram, 20);
        JFreeChart chart = ChartFactory.createHistogram(name, "x", "y" , dataset, PlotOrientation.VERTICAL, true, true, false);
        return chart;

    }
}
