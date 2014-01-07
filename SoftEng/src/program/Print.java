package program;


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
		setBounds(100, 100, 365, 231);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel destLabel = new JLabel("\u03A0\u03A1\u039F\u039F\u03A1\u0399\u03A3\u039C\u039F\u03A3 :");
		destLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		destLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		destLabel.setBounds(10, 11, 120, 14);
		contentPane.add(destLabel);
		
		JLabel nameLabel = new JLabel("\u039F\u039D\u039F\u039C\u0391 :");
		nameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		nameLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		nameLabel.setBounds(10, 36, 120, 14);
		contentPane.add(nameLabel);
		
		JLabel surnameLabel = new JLabel("\u0395\u03A0\u03A9\u039D\u03A5\u039C\u039F :");
		surnameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		surnameLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		surnameLabel.setBounds(10, 61, 120, 14);
		contentPane.add(surnameLabel);
		
		JLabel timeLabel = new JLabel("\u03A9\u03A1\u0391 :");
		timeLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		timeLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		timeLabel.setBounds(10, 111, 120, 14);
		contentPane.add(timeLabel);
		
		JLabel priceLabel = new JLabel("\u03A4\u0399\u039C\u0397 :");
		priceLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		priceLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		priceLabel.setBounds(10, 134, 120, 14);
		contentPane.add(priceLabel);
		
		/*------------------------------------------------------------*/
		
		
		JLabel dest = new JLabel("");
		dest.setHorizontalAlignment(SwingConstants.CENTER);
		dest.setBounds(140, 13, 120, 14);
		contentPane.add(dest);
		
		dest.setText(Cashier.prDest);
		
		
		JLabel name = new JLabel("");
		name.setHorizontalAlignment(SwingConstants.CENTER);
		name.setBounds(140, 38, 120, 14);
		contentPane.add(name);
			
				name.setText(Cashier.name);
			
		JLabel surname = new JLabel("");
		surname.setHorizontalAlignment(SwingConstants.CENTER);
		surname.setBounds(140, 63, 120, 14);
		contentPane.add(surname);
		
		
				surname.setText(Cashier.sur);
				
		
		JLabel time = new JLabel("");
		time.setHorizontalAlignment(SwingConstants.CENTER);
		time.setBounds(140, 111, 120, 14);
		contentPane.add(time);
		
				time.setText(Cashier.prTime);
		
		JLabel price = new JLabel("");
		price.setHorizontalAlignment(SwingConstants.CENTER);
		price.setBounds(140, 136, 120, 14);
		contentPane.add(price);
				
				price.setText(Cashier.prPrice + " €");
				
		final JButton print = new JButton("\u0395\u039A\u03A4\u03A5\u03A0\u03A9\u03A3\u0397");
		print.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				JOptionPane.showMessageDialog(
                        print, "Το Εισιτήριο Εκτυπώνεται...",
                        "Printing", JOptionPane.INFORMATION_MESSAGE);
				
			}
		});
		print.setBounds(219, 159, 120, 23);
		contentPane.add(print);
		
		JLabel lblNewLabel = new JLabel("\u0397\u039C\u0395\u03A1\u0391 :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(70, 86, 60, 14);
		contentPane.add(lblNewLabel);
		
		JLabel day = new JLabel((String) null);
		day.setHorizontalAlignment(SwingConstants.CENTER);
		day.setBounds(140, 88, 120, 14);
		contentPane.add(day);
		
			day.setText(Cashier.prDay);
	
	}
}
