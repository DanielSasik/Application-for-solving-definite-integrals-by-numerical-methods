package myPackage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class HelpInfo extends JFrame{

	private JPanel contentPane;

	
	public HelpInfo() {
		setResizable(false);

		setBounds(100, 100, 900, 600);
		setTitle("Help info");
		

		setSize(420,420);
		setLayout(null);
		setVisible(true);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea taHelpInfo = new JTextArea();
		taHelpInfo.setText("Truly fascinating");
		taHelpInfo.setBounds(6, 165, 438, 101);
		contentPane.add(taHelpInfo);
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setBounds(6, 6, 424, 147);
		contentPane.add(lblNewLabel);
	
		
		
		ImageIcon iconLogo = new ImageIcon("src/Screenshot 2023-03-19 at 14.42.04.png");
		lblNewLabel.setIcon(iconLogo);

	}
}
