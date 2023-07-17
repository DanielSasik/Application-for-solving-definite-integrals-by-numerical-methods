package myPackage;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.EmptyStackException;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.ValueMarker;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.plot.Zoomable;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.renderer.xy.XYSplineRenderer;
import org.jfree.chart.renderer.xy.XYSplineRenderer.FillType;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import java.awt.SystemColor;
public class Main extends JFrame {

	private JPanel contentPane;

	// For menus
	private boolean jdOpenFlag = false;
	private boolean jdOpenFlag2 = false;

	// component vars
	private JTextField tfInput;
	private JTextField tfStart;
	private JTextField tfEnd;
	private JTextField tfNumOfSteps;

	private JCheckBox cbRectangle;
	private JCheckBox cbTrapezoid;
	private JCheckBox cbSimpson13;
	private JCheckBox cbSimpson38;
	private JCheckBox cbBoole;
	
	ChartPanel mainPanel;
	ChartPanel clearPanel;

	boolean flag = true;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public Main() throws Exception {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1400, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(6, 34, 966, 754);
		contentPane.add(panel);

		JButton btnCalculate = new JButton("Vypočítaj");

		btnCalculate.setBounds(980, 388, 124, 60);
		contentPane.add(btnCalculate);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1400, 22);
		contentPane.add(menuBar);

		JMenu mnNewMenu = new JMenu("Pomôcka");
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Používaťeľská príručka");

		mnNewMenu.add(mntmNewMenuItem_1);

		JMenuItem mntmNewMenuItem = new JMenuItem("Vzťahy pre numerické metódy");

		mnNewMenu.add(mntmNewMenuItem);

		JLabel lblNewLabel = new JLabel("Funkcia f(x):");
		lblNewLabel.setBounds(984, 34, 113, 16);
		contentPane.add(lblNewLabel);

		tfInput = new JTextField();
		tfInput.setText("sin(x)");
		tfInput.setBounds(984, 48, 410, 40);
		contentPane.add(tfInput);
		tfInput.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Počiatok intervalu:");
		lblNewLabel_1.setBounds(984, 530, 130, 16);
		contentPane.add(lblNewLabel_1);

		tfStart = new JTextField();
		tfStart.setText("0");
		tfStart.setBounds(984, 550, 130, 26);
		contentPane.add(tfStart);
		tfStart.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Koniec intervalu:");
		lblNewLabel_2.setBounds(984, 580, 113, 16);
		contentPane.add(lblNewLabel_2);

		tfEnd = new JTextField();
		tfEnd.setText("1");
		tfEnd.setBounds(984, 600, 130, 26);
		contentPane.add(tfEnd);
		tfEnd.setColumns(10);

		JTextArea textArea = new JTextArea();
		textArea.setBackground(SystemColor.window);
		textArea.setEditable(false);
		textArea.setBounds(984, 684, 410, 82);
		contentPane.add(textArea);

		cbRectangle = new JCheckBox("Obdĺžniková metóda");
		cbRectangle.setSelected(true);
		cbRectangle.setBounds(1175, 550, 191, 23);
		contentPane.add(cbRectangle);

		cbTrapezoid = new JCheckBox("Lichobežníková metóda");
		cbTrapezoid.setSelected(true);
		cbTrapezoid.setBounds(1175, 575, 191, 23);
		contentPane.add(cbTrapezoid);

		cbSimpson13 = new JCheckBox("Simpsonová 1/3 metóda");
		cbSimpson13.setSelected(true);
		cbSimpson13.setBounds(1175, 600, 191, 23);
		contentPane.add(cbSimpson13);

		cbSimpson38 = new JCheckBox("Simpsonová 3/8 metóda");
		cbSimpson38.setBounds(1175, 625, 191, 23);
		contentPane.add(cbSimpson38);

		cbBoole = new JCheckBox("Booleova metóda");
		cbBoole.setBounds(1175, 650, 191, 23);
		contentPane.add(cbBoole);

		JLabel lblNewLabel_3 = new JLabel("Výber metód:");
		lblNewLabel_3.setBounds(1175, 530, 130, 16);
		contentPane.add(lblNewLabel_3);

		tfNumOfSteps = new JTextField();
		tfNumOfSteps.setText("12");
		tfNumOfSteps.setBounds(984, 650, 130, 26);
		contentPane.add(tfNumOfSteps);
		tfNumOfSteps.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Počet n intervalov:");
		lblNewLabel_4.setBounds(984, 630, 134, 16);
		contentPane.add(lblNewLabel_4);

		// init/set
		textArea.setText(initResults());
		panel.removeAll();
		clearPanel = emptyChartPanel();
		panel.add(clearPanel);
		
		JButton btnZoomOut = new JButton("Zoom Out");
		btnZoomOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainPanel.zoomOutBoth(0, 0);
			}
		});
		btnZoomOut.setBounds(1092, 489, 117, 29);
		contentPane.add(btnZoomOut);
		
		JButton btnZoomIn = new JButton("Zoom In");
		btnZoomIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainPanel.zoomInBoth(0, 0);
			}
		});
		btnZoomIn.setBounds(980, 489, 117, 29);
		contentPane.add(btnZoomIn);
		
		JButton btnBackspace = new JButton("⌫");
		btnBackspace.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfInput.setText(tfInput.getText().substring(0, tfInput.getText().length()-1));
			}
		});
		btnBackspace.setBounds(1284, 88, 60, 60);
		contentPane.add(btnBackspace);
		
		JButton btnClear = new JButton("C");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfInput.setText("");
			}
		});
		btnClear.setBounds(1224, 88, 60, 60);
		contentPane.add(btnClear);
		
		JButton btn9 = new JButton("9");
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfInput.setText(tfInput.getText() + "9");
			}
		});
		btn9.setBounds(984, 89, 60, 60);
		contentPane.add(btn9);
		
		JButton btnResetPosition = new JButton("Reset");
		btnResetPosition.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainPanel.restoreAutoBounds();
			}
		});
		btnResetPosition.setBounds(1209, 489, 117, 29);
		contentPane.add(btnResetPosition);
		
		JButton btn8 = new JButton("8");
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfInput.setText(tfInput.getText() + "8");
			}
		});
		btn8.setBounds(1044, 88, 60, 60);
		contentPane.add(btn8);
		
		JButton btnSin = new JButton("sin");
		btnSin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfInput.setText(tfInput.getText() + "sin(");
			}
		});
		btnSin.setBounds(1164, 148, 60, 60);
		contentPane.add(btnSin);
		
		JButton btnAsin = new JButton("asin");
		btnAsin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfInput.setText(tfInput.getText() + "asin(");
			}
		});
		btnAsin.setBounds(1224, 148, 60, 60);
		contentPane.add(btnAsin);
		
		JButton btn7 = new JButton("7");
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfInput.setText(tfInput.getText() + "7");
			}
		});
		btn7.setBounds(1104, 88, 60, 60);
		contentPane.add(btn7);
		
		JButton btn6 = new JButton("6");
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfInput.setText(tfInput.getText() + "6");
			}
		});
		btn6.setBounds(984, 148, 60, 60);
		contentPane.add(btn6);
		
		JButton btn5 = new JButton("5");
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfInput.setText(tfInput.getText() + "5");
			}
		});
		btn5.setBounds(1044, 148, 60, 60);
		contentPane.add(btn5);
		
		JButton btn4 = new JButton("4");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfInput.setText(tfInput.getText() + "4");
			}
		});
		btn4.setBounds(1104, 148, 60, 60);
		contentPane.add(btn4);
		
		JButton btn3 = new JButton("3");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfInput.setText(tfInput.getText() + "3");
			}
		});
		btn3.setBounds(984, 208, 60, 60);
		contentPane.add(btn3);
		
		JButton btn2 = new JButton("2");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfInput.setText(tfInput.getText() + "2");
			}
		});
		btn2.setBounds(1044, 208, 60, 60);
		contentPane.add(btn2);
		
		JButton btn1 = new JButton("1");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfInput.setText(tfInput.getText() + "1");
			}
		});
		btn1.setBounds(1104, 208, 60, 60);
		contentPane.add(btn1);
		
		JButton btn0 = new JButton("0");
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfInput.setText(tfInput.getText() + "0");
			}
		});
		btn0.setBounds(984, 268, 60, 60);
		contentPane.add(btn0);
		
		JButton btndot = new JButton(".");
		btndot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfInput.setText(tfInput.getText() + ".");
			}
		});
		btndot.setBounds(1044, 268, 60, 60);
		contentPane.add(btndot);
		
		JButton btnX = new JButton("\"x\"");
		btnX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfInput.setText(tfInput.getText() + "x");
			}
		});
		btnX.setBounds(1104, 268, 60, 60);
		contentPane.add(btnX);
		
		JButton btnPlus = new JButton("+");
		btnPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfInput.setText(tfInput.getText() + "+");
			}
		});
		btnPlus.setBounds(984, 328, 60, 60);
		contentPane.add(btnPlus);
		
		JButton btnMinus = new JButton("-");
		btnMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfInput.setText(tfInput.getText() + "-");
			}
		});
		btnMinus.setBounds(1044, 328, 60, 60);
		contentPane.add(btnMinus);
		
		JButton btnMultiplication = new JButton("*");
		btnMultiplication.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfInput.setText(tfInput.getText() + "*");
			}
		});
		btnMultiplication.setBounds(1104, 328, 60, 60);
		contentPane.add(btnMultiplication);
		
		JButton btnDivide = new JButton("/");
		btnDivide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfInput.setText(tfInput.getText() + "/");
			}
		});
		btnDivide.setBounds(1164, 328, 60, 60);
		contentPane.add(btnDivide);
		
		JButton btnCos = new JButton("cos");
		btnCos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfInput.setText(tfInput.getText() + "cos(");
			}
		});
		btnCos.setBounds(1164, 208, 60, 60);
		contentPane.add(btnCos);
		
		JButton btnTan = new JButton("tan");
		btnTan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfInput.setText(tfInput.getText() + "tan(");
			}
		});
		btnTan.setBounds(1164, 268, 60, 60);
		contentPane.add(btnTan);
		
		JButton btnToThePower = new JButton("^");
		btnToThePower.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfInput.setText(tfInput.getText() + "^");
			}
		});
		btnToThePower.setBounds(1224, 328, 60, 60);
		contentPane.add(btnToThePower);
		
		JButton btnAcos = new JButton("acos");
		btnAcos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfInput.setText(tfInput.getText() + "acos(");
			}
		});
		btnAcos.setBounds(1224, 208, 60, 60);
		contentPane.add(btnAcos);
		
		JButton btnAtan = new JButton("atan");
		btnAtan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfInput.setText(tfInput.getText() + "atan(");
			}
		});
		btnAtan.setBounds(1224, 268, 60, 60);
		contentPane.add(btnAtan);
		
		JButton btnSinh = new JButton("sinh");
		btnSinh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfInput.setText(tfInput.getText() + "sinh(");
			}
		});
		btnSinh.setBounds(1284, 148, 60, 60);
		contentPane.add(btnSinh);
		
		JButton btnCosh = new JButton("cosh");
		btnCosh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfInput.setText(tfInput.getText() + "cosh(");
			}
		});
		btnCosh.setBounds(1284, 208, 60, 60);
		contentPane.add(btnCosh);
		
		JButton btnTanh = new JButton("tanh");
		btnTanh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfInput.setText(tfInput.getText() + "tanh(");
			}
		});
		btnTanh.setBounds(1284, 268, 60, 60);
		contentPane.add(btnTanh);
		
		JButton btnLog = new JButton("log");
		btnLog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfInput.setText(tfInput.getText() + "log(");
			}
		});
		btnLog.setBounds(1164, 88, 60, 60);
		contentPane.add(btnLog);
		
		JButton btnLn = new JButton("ln");
		btnLn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfInput.setText(tfInput.getText() + "ln(");
			}
		});
		btnLn.setBounds(1284, 328, 60, 60);
		contentPane.add(btnLn);
		
		JButton btnleftCollum = new JButton("(");
		btnleftCollum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfInput.setText(tfInput.getText() + "(");
			}
		});
		btnleftCollum.setBounds(1104, 388, 60, 60);
		contentPane.add(btnleftCollum);
		
		JButton btnRightCollum = new JButton(")");
		btnRightCollum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfInput.setText(tfInput.getText() + ")");
			}
		});
		btnRightCollum.setBounds(1164, 388, 60, 60);
		contentPane.add(btnRightCollum);

		// actions
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					textArea.setText(calculateRules());
					//checkContinuity();
					//System.out.println(flag);

					if(flag == true) {
						panel.removeAll();
						mainPanel = createChartPanel();
						panel.add(mainPanel);
					}else if(flag == false){
						panel.removeAll();
						panel.add(clearPanel);
						//panel.add(createChartPanel());
					}
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					panel.removeAll();
					try {
						panel.add(clearPanel);
					} catch (Exception e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					panel.removeAll();
					try {
						panel.add(clearPanel);
					} catch (Exception e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
				}


				try {

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				revalidate();
				repaint();
				flag = true;
			}
		});
	}

	public String initResults() {
		String Rectangle =   "Obdĺžniková metóda \t= ";
		String Trapezoid =   "\nLichobežníková metóda \t= ";
		String Simpson13th = "\nSimpsonová 1/3 metóda \t= ";
		String Simpson38th = "\nSimpsonová 3/8 metóda \t= ";
		String Boole =       "\nBooleova metóda \t= ";
		String init = Rectangle + Trapezoid + Simpson13th + Simpson38th + Boole;

		return init;
	}

    public ChartPanel emptyChartPanel() throws Exception {
    	XYSeries series = new XYSeries("Frequency");
        XYDataset dataset = new XYSeriesCollection(series);
        
        series.add(1, 1);
        series.add(1, 2);
        series.add(2, 1);
        series.add(3, 9);
        series.add(4, 10);
        series.clear();

        
        ValueMarker marker = new ValueMarker(0);  // position is the value on the axis
        marker.setPaint(Color.black);
        marker.setStroke((new BasicStroke((float) 1)));

        NumberAxis domain = new NumberAxis("x");
        NumberAxis range = new NumberAxis("y");
        XYSplineRenderer r = new XYSplineRenderer(1 , FillType.TO_ZERO);
        r.setShapesVisible(false);
		//domain.setRange(5, 5);
        XYPlot xyplot = new XYPlot(dataset, domain, range, r);
        xyplot.addDomainMarker(marker);
        xyplot.addRangeMarker(marker);
       
        xyplot.getDomainAxis().setAutoRange(true);                            // uncomment
        ((NumberAxis)xyplot.getRangeAxis()).setAutoRangeIncludesZero(false); // add

        JFreeChart chart = new JFreeChart(xyplot);
        chart.removeLegend();

    	
    	ChartPanel chartPanel = new ChartPanel(chart)
    	{
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(960, 720);
            }

          
        };


    	return chartPanel;
    }
	public String calculateRules() throws NumberFormatException, Exception {
		double a = 0, b = 0;
		int n = 0;
		String input = "";
		String rectangleResult = "";
		String trapezoidResult = "";
		String simpson13Result = "";
		String simpson38Result = "";
		String booleResult = "";
		try {
			a = Double.valueOf(tfStart.getText());
			b = Double.valueOf(tfEnd.getText());
			n = Integer.valueOf(tfNumOfSteps.getText());
			input = tfInput.getText();

			//    	if(Double.isInfinite(Math.abs(result)))
			//    		flag = false;
			//   		if(Math.abs(result) == Double.NaN  ) {
			// 			flag = false;
			// 		}

			checkContinuity();
			if(input.equals("")) {
				input = "/";
				flag = false;
			}
			if(input.contains("/0")) {
				input = "/";
				flag = false;
			}
			if(a > b || a == b) {
				input = "/";
				flag = false;
			}
			
			if(!input.contains("x")) {
				input = "/";
				flag = false;
			}
			
			if(Double.isNaN(NumMethods.trapezoidMethod(a, b, n, input)))
			{
				input = "/";
				flag = false;
			}

			if(Double.isInfinite(Math.abs(NumMethods.trapezoidMethod(a, b, n, input))))
			{
				input = "/";
				flag = false;
			}
			
			if(flag == false)
				input = "/";
			//		if(input.length() == 0)
			//			throw new Exception("empty input");
			//		
			//		String.valueOf(NumMethods.rectangleMethod(a, b, n, input));

			//String Rectangle = "Rectangle = " + String.valueOf(NumMethods.rectangleRule(Double.valueOf(tfStart.getText()), Double.valueOf(tfEnd.getText()), Integer.valueOf(tfNumOfSteps.getText()), tfInput.getText()));


			if(cbRectangle.isSelected())
				rectangleResult = String.valueOf(NumMethods.rectangleMethod(a, b, n, input));
			else
				rectangleResult = "";

			if(cbTrapezoid.isSelected())
				trapezoidResult = String.valueOf(NumMethods.trapezoidMethod(a, b, n, input));
			else
				trapezoidResult = "";

			if(cbSimpson13.isSelected())
				simpson13Result = String.valueOf(NumMethods.simpsons13Method(a, b, n, input));
			else
				simpson13Result = "";

			if(cbSimpson38.isSelected())
				simpson38Result = String.valueOf(NumMethods.simpsons38thV3(a, b, n, input));
			else
				simpson38Result = "";

			if(cbBoole.isSelected())
				booleResult = String.valueOf(NumMethods.boole1(a, b, n, input));
			else
				booleResult = "";

		}catch(NumberFormatException e) {
			infoBox("Prosím skontrolujte zadané vstupy.", "Chyba: zĺý vstup");
		}catch(EmptyStackException e) {
			infoBox("Prosím skontrolujte zadané vstupy.", "Chyba: zĺý vstup");
		}catch(Exception e) {
			infoBox("Prosím skontrolujte zadané vstupy.", "Chyba: zĺý vstup");
		}

		String Rectangle =   "Obdĺžniková metóda \t= " + rectangleResult;
		String Trapezoid =   "\nLichobežníková metóda \t= " + trapezoidResult;
		String Simpson13th = "\nSimpsonová 1/3 metóda \t= " + simpson13Result;
		String Simpson38th = "\nSimpsonová 3/8 metóda \t= " + simpson38Result;
		String Boole =       "\nBooleova metóda \t= " + booleResult;

		String init = Rectangle + Trapezoid + Simpson13th + Simpson38th + Boole;

		return init;

	}

	public static void infoBox(String infoMessage, String titleBar)
	{
		JOptionPane.showMessageDialog(null, infoMessage, titleBar, JOptionPane.INFORMATION_MESSAGE);
	}

	public ChartPanel createChartPanel() throws Exception {
		XYSeries series = new XYSeries("Frequency");
		XYDataset dataset = new XYSeriesCollection(series);

		double a = Double.valueOf(tfStart.getText());
		double b = Double.valueOf(tfEnd.getText());
		double result = 0;

		Operation strOp = new Operation();
		String[] inputRPN = ReversePolish.rnp(ReversePolish.splitter(tfInput.getText()).toArray(new String[0])).toArray(new String[0]);
		HashMap<String, Double> funcX = new HashMap<>();
		funcX.put("x", 5.0);
		funcX.put("-x", -1 * 5.0);
		funcX.put("pi", Math.PI);
		funcX.put("-pi", Math.PI);
		funcX.put("e", Math.E);
		funcX.put("-e", Math.E);

		for(double x = a; x <= b + 0.01; x += 0.01) {
			funcX.replace("x", ((double) (Math.round(x*100))/100));
			funcX.replace("-x", -1 * ((double) (Math.round(x*100))/100));
			result = strOp.evalRPN(inputRPN, funcX);
			series.add(x, result);
			//System.out.println(((double) (Math.round(x*100))/100));
		}
		ValueMarker marker = new ValueMarker(0);  // position is the value on the axis
		marker.setPaint(Color.black);
		marker.setStroke((new BasicStroke((float) 1)));

		NumberAxis domain = new NumberAxis("x");
		NumberAxis range = new NumberAxis("y");
		XYSplineRenderer r = new XYSplineRenderer(1 , FillType.TO_ZERO);
		r.setShapesVisible(false);
		//        r.setIncludeBaseInRange(false);
		//setIncludeBaseInRange(false)
		//        domain.setLowerBound(a-.5);
		//        domain.setUpperBound(b+.5);
		double intervalT = b - a;

		        if(a < 0)
		        	domain.setRange(a - 0.05 * intervalT, b + 0.05 * intervalT);
		        else
		        	domain.setRange(a, b + 0.05 * intervalT);
		//domain.setRange(a, b);
		//        domain.setAutoRangeStickyZero(false);
		//        domain.setAutoRangeIncludesZero(false);

		//        r.setSeriesPaint(0, new Color(0xff, 0xff, 0x00)); 

		XYPlot xyplot = new XYPlot(dataset, domain, range, r);
		xyplot.addDomainMarker(marker);
		xyplot.addRangeMarker(marker);
//		if(a < 0)
//			xyplot.getDomainAxis().setRange(a - 0.05 * intervalT, b + 0.05 * intervalT);
//		else
//			xyplot.getDomainAxis().setRange(a, b + 0.05 * intervalT);

//		xyplot.getDomainAxis().setAutoRange(true);                            // uncomment
//		((NumberAxis)xyplot.getRangeAxis()).setAutoRangeIncludesZero(false); // add

		JFreeChart chart = new JFreeChart(xyplot);
		chart.removeLegend();


		ChartPanel chartPanel = new ChartPanel(chart) {
			@Override
			public Dimension getPreferredSize() {
				return new Dimension(960, 720);
			}
			@Override
			public void restoreAutoBounds() 
			{

				super.restoreAutoDomainBounds();
				super.restoreAutoRangeBounds();

				double intervalT = b - a;


				//    	        else
					//    	        	domain.setRange(a, b + 0.05 * intervalT);
				XYPlot plot=(XYPlot)getChart().getPlot();

				plot.getDomainAxis().setAutoRange(false);

				if(a < 0)
					plot.getDomainAxis().setRange(a - 0.05 * intervalT, b + 0.05 * intervalT);
				else
					plot.getDomainAxis().setRange(a, b + 0.05 * intervalT);
			}

		};


		return chartPanel;
	}

	public boolean checkContinuity() throws Exception {
		HashMap<String, Double> funcX = new HashMap<>();
		funcX.put("x", 5.0);
		funcX.put("-x", -1 * 5.0);
		funcX.put("pi", Math.PI);
		funcX.put("-pi", Math.PI);
		funcX.put("e", Math.E);
		funcX.put("-e", Math.E);

		String input = tfInput.getText();
		Operation strOp = new Operation();
		String[] inputRPN = ReversePolish.rnp(ReversePolish.splitter(input).toArray(new String[0])).toArray(new String[0]);

		double a = Double.valueOf(tfStart.getText());
		double b = Double.valueOf(tfEnd.getText());
		double result = 0;


		double step = 0.001;
		double realX, closeToPI = 0;
		int special;
		for(double x = a; x <= b + step; x += step) {
			realX = (double)Math.round(x*1000)/1000;
			//System.out.println(realX);
			//result = Math.sin(realX);

			if(realX*1000%785 == 0) {
				//System.out.println(realX);
				//System.out.println(realX*1000);
				int specialrealX = (int) (realX * 1000);
				special = specialrealX / 785;
				closeToPI = (Math.PI * special *1/4);

				funcX.replace("x", closeToPI);
				funcX.replace("-x", -1 * closeToPI);
				result = strOp.evalRPN(inputRPN, funcX);

			}else {
				funcX.replace("x", realX);
				funcX.replace("-x", -1 * realX);
			}
			

			result = strOp.evalRPN(inputRPN, funcX);
			System.out.println(result);
			
			// maybe fix for tan(x+1) the correct pi is the problem
			if(input.contains("x+") || input.contains("+x")) {
				
			}
			
			if(Double.isNaN(result))
				flag = false;
			if(Double.isInfinite(result)) {
				flag = false;
			}
			if(Double.isInfinite(Math.abs(result)))
				flag = false;
			if(Math.abs(result) == Double.NaN  ) {
				flag = false;
			}
		}
		//System.out.println("------");
		return flag;
	}
}
