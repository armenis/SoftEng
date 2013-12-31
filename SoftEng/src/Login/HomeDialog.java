package login;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.border.TitledBorder;

import program.Cashier;

import java.awt.Color;

public class HomeDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			HomeDialog dialog = new HomeDialog();
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public HomeDialog() {
		setBackground(Color.WHITE);
		setTitle("Home");
		setBounds(100, 100, 344, 158);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setForeground(Color.BLACK);
		contentPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel adminLabel = new JLabel("\u0394\u03B9\u03B1\u03C7\u03B5\u03B9\u03C1\u03B9\u03C3\u03C4\u03AE\u03C2 :");
		adminLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		adminLabel.setBounds(57, 30, 89, 21);
		contentPanel.add(adminLabel);
		
		JLabel cashierLabel = new JLabel("\u03A4\u03B1\u03BC\u03AF\u03B1\u03C2 :");
		cashierLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		cashierLabel.setBounds(90, 71, 56, 14);
		contentPanel.add(cashierLabel);
		
		JButton loginButton = new JButton("Login");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login log = new Login();
				log.setVisible(true);
				dispose();
			}
		});
		loginButton.setBounds(156, 30, 89, 23);
		contentPanel.add(loginButton);
		
		JButton enterButton = new JButton("Enter");
		enterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cashier tamias = new Cashier();
				tamias.setVisible(true);
				dispose();
				
			}
		});
		enterButton.setBounds(156, 68, 89, 23);
		contentPanel.add(enterButton);

	}
	
	
}
 



