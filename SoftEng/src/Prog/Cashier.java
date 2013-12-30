package Prog;

import Login.*;

import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.ListModel;

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
import java.util.Vector;

import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class Cashier extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField payment_field;
	private JTextField name_text;
	private JTextField surname_text;
	public static String pr_price; //Price for Print
	public static String pr_time;
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
				Home h = new Home();
				h.setVisible(true);
			}
		});
		
		final Data data = new Data();
		
		
		setBounds(100, 100, 738, 515);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel routes_label = new JLabel("\u0394\u03A1\u039F\u039C\u039F\u039B\u039F\u0393\u0399\u0391");
		routes_label.setFont(routes_label.getFont().deriveFont(routes_label.getFont().getStyle() | Font.BOLD));
		routes_label.setBounds(43, 23, 138, 20);
		contentPane.add(routes_label);
		
		JLabel time_label = new JLabel("\u03A9\u03A1\u0395\u03A3");
		time_label.setFont(time_label.getFont().deriveFont(time_label.getFont().getStyle() | Font.BOLD));
		time_label.setBounds(326, 26, 46, 14);
		contentPane.add(time_label);
		
		JLabel days_label = new JLabel("\u0397\u039C\u0395\u03A1\u0395\u03A3");
		days_label.setFont(days_label.getFont().deriveFont(days_label.getFont().getStyle() | Font.BOLD));
		days_label.setBounds(201, 26, 57, 14);
		contentPane.add(days_label);
		
		JLabel seat_label = new JLabel("\u0398\u0395\u03A3\u0397");
		seat_label.setFont(seat_label.getFont().deriveFont(seat_label.getFont().getStyle() | Font.BOLD));
		seat_label.setBounds(419, 26, 34, 14);
		contentPane.add(seat_label);
		
		
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
		
		
		JList<Object> seat_list = new JList<Object>();
		seat_list.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		seat_list.setBounds(407, 44, 57, 209);
		contentPane.add(seat_list);
		
		JLabel payment_label = new JLabel("\u03A0\u039B\u0397\u03A1\u03A9\u039C\u0397");
		payment_label.setFont(payment_label.getFont().deriveFont(payment_label.getFont().getStyle() | Font.BOLD));
		payment_label.setBounds(605, 177, 66, 14);
		contentPane.add(payment_label);
		
		payment_field = new JTextField();
		payment_field.setBounds(588, 194, 96, 20);
		contentPane.add(payment_field);
		payment_field.setColumns(10);
		
		final JLabel change_label = new JLabel("0,00 \u20AC");
		change_label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		change_label.setBounds(614, 243, 57, 20);
		contentPane.add(change_label);
		
		
		JButton change_button = new JButton("\u03A1\u0395\u03A3\u03A4\u0391");
		change_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//int index = price_list.getSelectedIndex(); 
				double price = Double.parseDouble(Cashier.pr_price);
				double change = data.calculateChange(getPayment(), price);
				change_label.setText(String.valueOf(change) + " €");
				 
			}
		});
		

		JButton print_button = new JButton("\u0395\u039A\u03A4\u03A5\u03A0\u03A9\u03A3\u0397");
		print_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Cashier.pr_price = String.valueOf((double) price_list.getSelectedValue());
				//Cashier.pr_time = (String) time_list.getSelectedValue();
				//Cashier.name = getClientName();
				//Cashier.sur = getClientSurname();
				Print pr = new Print();
				pr.setVisible(true);
				
				
			}
		});
		print_button.setBounds(573, 269, 116, 32);
		contentPane.add(print_button);
		change_button.setBounds(588, 219, 96, 23);
		contentPane.add(change_button);
		
		JLabel customer_label = new JLabel("\u03A3\u03A4\u039F\u0399\u03A7\u0395\u0399\u0391 \u03A0\u0395\u039B\u0391\u03A4\u0397");
		customer_label.setFont(customer_label.getFont().deriveFont(customer_label.getFont().getStyle() | Font.BOLD));
		customer_label.setBounds(588, 26, 102, 14);
		contentPane.add(customer_label);
		
		name_text = new JTextField();
		name_text.setHorizontalAlignment(SwingConstants.CENTER);
		name_text.setBounds(573, 42, 117, 20);
		contentPane.add(name_text);
		name_text.setColumns(10);
		
		surname_text = new JTextField();
		surname_text.setHorizontalAlignment(SwingConstants.CENTER);
		surname_text.setBounds(573, 73, 117, 20);
		contentPane.add(surname_text);
		surname_text.setColumns(10);
		
		JLabel announce_label = new JLabel("\u0391\u039D\u0391\u039A\u039F\u0399\u039D\u03A9\u03A3\u0395\u0399\u03A3");
		announce_label.setFont(new Font("Tahoma", Font.PLAIN, 23));
		announce_label.setBounds(276, 300, 213, 24);
		contentPane.add(announce_label);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 335, 702, 131);
		contentPane.add(textArea);
		
		JLabel label = new JLabel("\u039F\u039D\u039F\u039C\u0391 :");
		label.setBounds(506, 45, 57, 14);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u0395\u03A0\u03A9\u039D\u03A5\u039C\u039F :");
		label_1.setBounds(497, 76, 66, 14);
		contentPane.add(label_1);
		
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
				Cashier.pr_price = tp;
				ticket_price.setText(tp + " €");
				
				days_list.setListData(data.getDays(route));
				time_list.setListData(data.getTimes(route));
				

			}
		});
		choose.setBounds(10, 257, 143, 32);
		contentPane.add(choose);
		
		JLabel label_2 = new JLabel("\u03A4\u0399\u039C\u0397 \u0395\u0399\u03A3\u0397\u03A4\u0397\u03A1\u0399\u039F\u03A5");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_2.setBounds(588, 114, 96, 20);
		contentPane.add(label_2);
		
	
		
		Announce B = new Announce();
		try {
			textArea.read(B.readFile(), "textArea");
		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}
	
	public String getPayment() {
        return payment_field.getText();
    } 
	 	
	public String getClientName(){
		return name_text.getText();
	}
	public String getClientSurname(){
		return surname_text.getText();
	}
}


