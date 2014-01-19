package database;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import login.HomeDialog;

import javax.swing.JPasswordField;

public class dbconfig extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JTextField txtJdbcmysql;
	private static JTextField txtRoot;
	private static JPasswordField txtPass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dbconfig frame = new dbconfig();
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
	public dbconfig() {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//Ksana anoigei to Home otan kleisoume to Cashier (thelei dispose kai OXI exit)
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				HomeDialog h = new HomeDialog();
				h.setVisible(true);
			}
		});
		
		
		
		setBounds(100, 100, 404, 231);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Configurate");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JDBCMySQLConnection.URL = dbconfig.getURL();
				JDBCMySQLConnection.USER = dbconfig.getUSER();
				JDBCMySQLConnection.PASSWORD = dbconfig.getPASSWORD();
				dispose();
				HomeDialog h = new HomeDialog();
				h.setVisible(true);
			}
		});
		btnNewButton.setBounds(121, 122, 191, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("URL :");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(65, 44, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("USER :");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(65, 69, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("PASSWORD :");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(26, 94, 85, 14);
		contentPane.add(lblNewLabel_2);
		
		txtJdbcmysql = new JTextField();
		txtJdbcmysql.setText("jdbc:mysql://localhost/test");
		txtJdbcmysql.setBounds(121, 41, 191, 20);
		contentPane.add(txtJdbcmysql);
		txtJdbcmysql.setColumns(10);
		
		txtRoot = new JTextField();
		txtRoot.setText("root");
		txtRoot.setBounds(121, 66, 191, 20);
		contentPane.add(txtRoot);
		txtRoot.setColumns(10);
		
		txtPass = new JPasswordField();
		txtPass.setBounds(121, 91, 191, 20);
		contentPane.add(txtPass);
	}
	
	public static String getURL(){
		return txtJdbcmysql.getText();
	}
	public static String getUSER(){
		return txtRoot.getText();
	}
	@SuppressWarnings("deprecation")
	public static String getPASSWORD(){
		return txtPass.getText();
	}
}
