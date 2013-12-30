package Prog;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;

import java.awt.Color;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Print extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Print frame = new Print();
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
	public Print() {
		

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 369, 257);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u03A0\u03A1\u039F\u039F\u03A1\u0399\u03A3\u039C\u039F\u03A3 :");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 11, 120, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel1 = new JLabel("\u039F\u039D\u039F\u039C\u0391 :");
		lblNewLabel1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel1.setBounds(10, 36, 120, 14);
		contentPane.add(lblNewLabel1);
		
		JLabel lblNewLabel_2 = new JLabel("\u0395\u03A0\u03A9\u039D\u03A5\u039C\u039F :");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(10, 61, 120, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u03A9\u03A1\u0391 :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setBounds(10, 86, 120, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\u0398\u0395\u03A3\u0397 :");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setBounds(10, 111, 120, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("\u03A4\u0399\u039C\u0397 :");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5.setBounds(10, 136, 120, 14);
		contentPane.add(lblNewLabel_5);
		
		/*------------------------------------------------------------*/
		
		
		JLabel dest = new JLabel("");
		dest.setHorizontalAlignment(SwingConstants.CENTER);
		dest.setBounds(140, 13, 120, 14);
		contentPane.add(dest);
		
		
		JLabel name = new JLabel("");
		name.setHorizontalAlignment(SwingConstants.CENTER);
		name.setBounds(140, 38, 120, 14);
		contentPane.add(name);
			
				//name.setText(Cashier.name);
			
		JLabel surname = new JLabel("");
		surname.setHorizontalAlignment(SwingConstants.CENTER);
		surname.setBounds(140, 63, 120, 14);
		contentPane.add(surname);
		
		
				//surname.setText(Cashier.sur);
				
		
		JLabel time = new JLabel("");
		time.setHorizontalAlignment(SwingConstants.CENTER);
		time.setBounds(140, 88, 120, 14);
		contentPane.add(time);
		
				//time.setText(Cashier.pr_time);
				
		
		JLabel seat = new JLabel("");
		seat.setHorizontalAlignment(SwingConstants.CENTER);
		seat.setBounds(140, 113, 120, 14);
		contentPane.add(seat);
		
		JLabel price = new JLabel("");
		price.setHorizontalAlignment(SwingConstants.CENTER);
		price.setBounds(140, 138, 120, 14);
		contentPane.add(price);
				
				price.setText(Cashier.pr_price + " €");
				
		final JButton print = new JButton("\u0395\u039A\u03A4\u03A5\u03A0\u03A9\u03A3\u0397");
		print.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				JOptionPane.showMessageDialog(
                        print, "Το Εισιτήριο Εκτυπώνεται...",
                        "Printing", JOptionPane.INFORMATION_MESSAGE);
				
			}
		});
		print.setBounds(223, 185, 120, 23);
		contentPane.add(print);
		

		
		
	}
}
