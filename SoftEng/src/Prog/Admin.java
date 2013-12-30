package Prog;

import Login.*;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;


public class Admin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField dest;
	private JTextField day;
	private JTextField time;
	private JTextField price;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin frame = new Admin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Admin() {
		setTitle("\u0394\u0399\u0391\u03A7\u0395\u0399\u03A1\u0399\u03A3\u03A4\u0397\u03A3");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//Ksana anoigei to Home otan kleisoume to Admin (thelei dispose kai OXI exit)
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				Home h = new Home();
				h.setVisible(true);
			}
		});
		
		
		setBounds(100, 100, 397, 476);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 288, 361, 96);
		contentPane.add(textArea);
		
		JButton publish = new JButton("\u0394\u0397\u039C\u039F\u03A3\u0399\u0395\u03A5\u03A3\u0397");
		publish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String anak = textArea.getText();
				Announce A = new Announce();
				A.writeFile(anak);
				
			}
		});
		publish.setBounds(232, 395, 129, 28);
		contentPane.add(publish);
		
		JLabel anak = new JLabel("\u0391\u039D\u0391\u039A\u039F\u0399\u039D\u03A9\u03A3\u0395\u0399\u03A3");
		anak.setHorizontalAlignment(SwingConstants.CENTER);
		anak.setFont(new Font("Tahoma", Font.PLAIN, 23));
		anak.setBounds(106, 249, 177, 28);
		contentPane.add(anak);
		
		JLabel label_1 = new JLabel("\u03A0\u03A1\u039F\u039F\u03A1\u0399\u03A3\u039C\u039F\u03A3");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(66, 61, 86, 14);
		contentPane.add(label_1);
		
		dest = new JTextField();
		dest.setBounds(66, 83, 86, 20);
		contentPane.add(dest);
		dest.setColumns(10);
		
		day = new JTextField();
		day.setBounds(256, 83, 86, 20);
		contentPane.add(day);
		day.setColumns(10);
		
		time = new JTextField();
		time.setBounds(256, 128, 86, 20);
		contentPane.add(time);
		time.setColumns(10);
		
		price = new JTextField();
		price.setBounds(256, 172, 86, 20);
		contentPane.add(price);
		price.setColumns(10);
		
		JLabel label_2 = new JLabel("\u0397\u039C\u0395\u03A1\u0391");
		label_2.setBounds(283, 61, 62, 14);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("\u03A9\u03A1\u0391");
		label_3.setBounds(283, 114, 46, 14);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("\u03A4\u0399\u039C\u0397");
		label_4.setBounds(280, 159, 46, 14);
		contentPane.add(label_4);
		
		JLabel label = new JLabel("\u0395\u0399\u03A3\u0391\u0393\u03A9\u0393\u0397 \u039D\u0395\u03A9\u039D \u0394\u03A1\u039F\u039C\u039F\u039B\u039F\u0393\u0399\u03A9\u039D");
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(43, 11, 286, 14);
		contentPane.add(label);
		
		
		
		
		
		final JButton insertCombo = new JButton("\u039A\u0391\u03A4\u0391\u03A7\u03A9\u03A1\u0397\u03A3\u0397");
		insertCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Data.insertRoutes(dest.getText(), day.getText());
				Data.insertTimes(dest.getText(),Double.parseDouble(price.getText()));
				Data.insertWres(dest.getText(),time.getText());
				
			}
		});
		insertCombo.setBounds(237, 203, 124, 23);
		contentPane.add(insertCombo);
		
		final JButton insertDest = new JButton("\u0395\u0399\u03A3\u0391\u0393\u03A9\u0393\u0397");
		insertDest.setBackground(Color.RED);
		insertDest.setForeground(Color.BLACK);
		insertDest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				Data.insertPerioxes(dest.getText());
	
			}
		});
		insertDest.setBounds(46, 114, 124, 23);
		contentPane.add(insertDest);
		
		JLabel label_5 = new JLabel("\u03A0\u03A1\u03A9\u03A4\u0391 \u0395\u0399\u03A3\u0391\u0393\u0395\u03A4\u0391\u0399 \u03A4\u039F\u039D \u03A0\u03A1\u039F\u039F\u03A1\u0399\u03A3\u039C\u039F !!!");
		label_5.setForeground(Color.RED);
		label_5.setBounds(10, 148, 229, 14);
		contentPane.add(label_5);
	
	}
}


