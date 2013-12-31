package login;





import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JPasswordField;

import program.Admin;

public class Login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField usernameText;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setTitle("Administrator Login");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//Ksana anoigei to Home otan kleisoume to Login (thelei dispose kai OXI exit)
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				HomeDialog h = new HomeDialog();
				h.setVisible(true);
			}
		});
		
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel usernameLabel = new JLabel("Username :");
		usernameLabel.setBounds(84, 56, 69, 14);
		contentPane.add(usernameLabel);
		
		JLabel passwordLabel = new JLabel("Password :");
		passwordLabel.setBounds(84, 91, 69, 14);
		contentPane.add(passwordLabel);
		
		usernameText = new JTextField();
		usernameText.setName("user"); //Set Name to textfield for TESTING
		usernameText.setBounds(171, 53, 105, 20);
		contentPane.add(usernameText);
		usernameText.setColumns(10);
		
		JButton loginButton = new JButton("Login");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (Login.authenticate(getUsername(), getPassword())) {
                    /*JOptionPane.showMessageDialog(Login.this,
                            "Hi " + getUsername() + "! You have successfully logged in.",
                            "Login",
                            JOptionPane.INFORMATION_MESSAGE);*/
                    Admin frame = new Admin();
                    frame.setVisible(true);
                    dispose();                
                } else {
                    JOptionPane.showMessageDialog(Login.this,
                            "Invalid username or password",
                            "Login",
                            JOptionPane.ERROR_MESSAGE);
                    // reset username and password
                    usernameText.setText("");
                    passwordField.setText("");
                  
 
                }
				
			}
		});
		loginButton.setBounds(168, 131, 89, 23);
		contentPane.add(loginButton);
		
		passwordField = new JPasswordField();
		passwordField.setName("psw");
		passwordField.setBounds(171, 88, 105, 20);
		contentPane.add(passwordField);
	}
	
	  public static boolean authenticate(String username, String password) {
	        // hardcoded username and password
	        if (username.equals("admin") && password.equals("1234")) {
	            return true;
	        }
	        	return false;
	    }
	  public String getUsername() {
	        return usernameText.getText().trim();
	    }
	  @SuppressWarnings("deprecation")
	  public String getPassword() {
	        //return new String(password_text.getText());
		  	return new String(passwordField.getText());
	    }

}


