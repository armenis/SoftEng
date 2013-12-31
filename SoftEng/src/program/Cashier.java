package program;

import java.awt.EventQueue;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JLabel;

import java.awt.Color;

import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import login.*;

public class Cashier extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField paymentField;
	private JTextField nameText;
	private JTextField surnameText;
	public static String prPrice; //Price for Print
	public static String prTime;
	public static String prDest;
	public static String name; //Name for Print	
	public static String sur;  //Surname for Print

	
	
	/**
	 * Launch the application.
	 */
public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cashier frame = new Cashier();
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
	public Cashier() {
		setTitle("\u0391\u0393\u039F\u03A1\u0391 \u0395\u0399\u03A3\u0397\u03A4\u0397\u03A1\u0399\u039F\u03A5");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//Ksana anoigei to Home otan kleisoume to Cashier (thelei dispose kai OXI exit)
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				HomeDialog h = new HomeDialog();
				h.setVisible(true);
			}
		});
		
		final Data data = new Data();
		
		
		setBounds(100, 100, 738, 515);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel routesLabel = new JLabel("\u0394\u03A1\u039F\u039C\u039F\u039B\u039F\u0393\u0399\u0391");
		routesLabel.setFont(routesLabel.getFont().deriveFont(routesLabel.getFont().getStyle() | Font.BOLD));
		routesLabel.setBounds(43, 23, 138, 20);
		contentPane.add(routesLabel);
		
		JLabel timeLabel = new JLabel("\u03A9\u03A1\u0395\u03A3");
		timeLabel.setFont(timeLabel.getFont().deriveFont(timeLabel.getFont().getStyle() | Font.BOLD));
		timeLabel.setBounds(326, 26, 46, 14);
		contentPane.add(timeLabel);
		
		JLabel daysLabel = new JLabel("\u0397\u039C\u0395\u03A1\u0395\u03A3");
		daysLabel.setFont(daysLabel.getFont().deriveFont(daysLabel.getFont().getStyle() | Font.BOLD));
		daysLabel.setBounds(201, 26, 57, 14);
		contentPane.add(daysLabel);
		
		
		final JList<Object> routes_list = new JList<Object>(data.getRoutes());
		routes_list.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		routes_list.setBounds(10, 42, 143, 211);
		contentPane.add(routes_list);
		

		final JList<Object> days_list = new JList<Object>();
		days_list.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		days_list.setBounds(163, 42, 112, 211);
		contentPane.add(days_list);
		
		
		final JList<Double> time_list = new JList<Double>();
		time_list.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		time_list.setBounds(285, 42, 112, 211);
		contentPane.add(time_list);
		
		JLabel paymentLabel = new JLabel("\u03A0\u039B\u0397\u03A1\u03A9\u039C\u0397");
		paymentLabel.setFont(paymentLabel.getFont().deriveFont(paymentLabel.getFont().getStyle() | Font.BOLD));
		paymentLabel.setBounds(605, 177, 66, 14);
		contentPane.add(paymentLabel);
		
		paymentField = new JTextField();
		paymentField.setBounds(588, 194, 96, 20);
		contentPane.add(paymentField);
		paymentField.setColumns(10);
		
		final JLabel change_label = new JLabel("0,00 \u20AC");
		change_label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		change_label.setBounds(614, 243, 57, 20);
		contentPane.add(change_label);
		
		
		JButton changeButton = new JButton("\u03A1\u0395\u03A3\u03A4\u0391");
		changeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//int index = price_list.getSelectedIndex(); 
				double price = Double.parseDouble(Cashier.prPrice);
				double change = data.calculateChange(getPayment(), price);
				change_label.setText(String.valueOf(change) + " €");
				 
			}
		});
		

		JButton printButton = new JButton("\u0395\u039A\u03A4\u03A5\u03A0\u03A9\u03A3\u0397");
		printButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Cashier.pr_price = String.valueOf((double) price_list.getSelectedValue());
				Cashier.prDest = (String) routes_list.getSelectedValue();
				Cashier.prTime = String.valueOf(time_list.getSelectedValue());
				Cashier.name = getClientName();
				Cashier.sur = getClientSurname();
				Print pr = new Print();
				pr.setVisible(true);
				
				
			}
		});
		printButton.setBounds(573, 269, 116, 32);
		contentPane.add(printButton);
		changeButton.setBounds(588, 219, 96, 23);
		contentPane.add(changeButton);
		
		JLabel customerLabel = new JLabel("\u03A3\u03A4\u039F\u0399\u03A7\u0395\u0399\u0391 \u03A0\u0395\u039B\u0391\u03A4\u0397");
		customerLabel.setFont(customerLabel.getFont().deriveFont(customerLabel.getFont().getStyle() | Font.BOLD));
		customerLabel.setBounds(588, 26, 102, 14);
		contentPane.add(customerLabel);
		
		nameText = new JTextField();
		nameText.setHorizontalAlignment(SwingConstants.CENTER);
		nameText.setBounds(573, 42, 117, 20);
		contentPane.add(nameText);
		nameText.setColumns(10);
		
		surnameText = new JTextField();
		surnameText.setHorizontalAlignment(SwingConstants.CENTER);
		surnameText.setBounds(573, 73, 117, 20);
		contentPane.add(surnameText);
		surnameText.setColumns(10);
		
		JLabel announceLabel = new JLabel("\u0391\u039D\u0391\u039A\u039F\u0399\u039D\u03A9\u03A3\u0395\u0399\u03A3");
		announceLabel.setFont(new Font("Tahoma", Font.PLAIN, 23));
		announceLabel.setBounds(276, 300, 213, 24);
		contentPane.add(announceLabel);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 335, 702, 131);
		contentPane.add(textArea);
		
		JLabel label = new JLabel("\u039F\u039D\u039F\u039C\u0391 :");
		label.setBounds(506, 45, 57, 14);
		contentPane.add(label);
		
		JLabel label1 = new JLabel("\u0395\u03A0\u03A9\u039D\u03A5\u039C\u039F :");
		label1.setBounds(497, 76, 66, 14);
		contentPane.add(label1);
		
		final JLabel ticket_price = new JLabel("0,00 \u20AC");
		ticket_price.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ticket_price.setBounds(605, 133, 57, 20);
		contentPane.add(ticket_price);
		
		JButton choose = new JButton("\u0395\u03A0\u0399\u039B\u039F\u0393\u0397");
		choose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String route = (String) routes_list.getSelectedValue();
				//Pernoume thn timh tou eishthriou me bash thn Perioxh pou epileksame
				String tp = String.valueOf(data.getPrice(route));
				Cashier.prPrice = tp;
				ticket_price.setText(tp + " €");
				
				days_list.setListData(data.getDays(route));
				time_list.setListData(data.getTimes(route));
				

			}
		});
		choose.setBounds(10, 257, 143, 32);
		contentPane.add(choose);
		
		JLabel label2 = new JLabel("\u03A4\u0399\u039C\u0397 \u0395\u0399\u03A3\u0397\u03A4\u0397\u03A1\u0399\u039F\u03A5");
		label2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label2.setBounds(588, 114, 96, 20);
		contentPane.add(label2);
		
	
		
		Announce an = new Announce();
		try {
			textArea.read(an.readFile(), "textArea");
		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}
	
	public String getPayment() {
        return paymentField.getText();
    } 
	 	
	public String getClientName(){
		return nameText.getText();
	}
	public String getClientSurname(){
		return surnameText.getText();
	}
}


