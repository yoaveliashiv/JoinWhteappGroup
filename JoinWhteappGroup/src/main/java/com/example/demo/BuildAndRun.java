package com.example.demo;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;

import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;





import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;



import java.applet.Applet;
import java.awt.AWTException;

public class BuildAndRun extends Applet {
	
	@Override
	public  void init() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuildAndRun window = new BuildAndRun();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
	
	private OpenWebsite play=new OpenWebsite();
	
	private JFrame frame;
	private JTable table;
	
	private JTextField websiteF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuildAndRun window = new BuildAndRun();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BuildAndRun() throws AWTException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1035, 515);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(108, 197, 696, 251);
		frame.getContentPane().add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"NUM", "LINK"
				}
				) {
			/**
					 * 
					 */
					private static final long serialVersionUID = -6575234448947824088L;
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] {
					String.class,  String.class
			};
			@SuppressWarnings({ "rawtypes", "unchecked" })
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(38);
		table.getColumnModel().getColumn(1).setPreferredWidth(500);
		scrollPane.setViewportView(table);

//		start = new JTextField();
//		start.setBounds(97, 36, 84, 19);
//		frame.getContentPane().add(start);
//		start.setColumns(10);

//		end = new JTextField();
//		end.setBounds(265, 36, 93, 19);
//		frame.getContentPane().add(end);
//		end.setColumns(10);

		websiteF = new JTextField();
		websiteF.setBounds(100, 129, 84, 32);
		frame.getContentPane().add(websiteF);
		websiteF.setColumns(20);
		websiteF.setSize(400, 30);

		JButton btnPlay = new JButton("RUN");
		btnPlay.setBounds(948, 136, 63, 21);
		btnPlay.addActionListener(new ActionListener() {  //run the app
			public void actionPerformed(ActionEvent e) {
				System.out.println(2);
				try {
					if(play.links.size()==0) {
						JOptionPane.showMessageDialog(frame, "Error! add link first");

						return;
					}
					play.appJoinGroup();//run the app
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		JButton btnAdd = new JButton("ADD LINK");
		btnAdd.setBounds(702, 136, 133, 21);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //add link to list

//				if(ErrInput.Time(start.getText())) {
//					JOptionPane.showMessageDialog(frame, "Error! For an  start time:'"+start.getText()+"' the input is incorrect");
//					return;
//				}
//				if(ErrInput.Time(end.getText())) {
//					JOptionPane.showMessageDialog(frame, "Error! For an  end time:'"+end.getText()+"' the input is incorrect");
//					return;
//				}
				if(ErrInput.Website(websiteF.getText())) {
					JOptionPane.showMessageDialog(frame, "Error! For an  link:'"+websiteF.getText()+"' the input is incorrect");
					return;
				}

			//	play.type.put(start.getText(),true);
//				play.times.add(start.getText());
//				play.timesEnd.put(start.getText(),end.getText());
			//	play.website.put(start.getText(),websiteF.getText());
			//	Collections.sort( play.times, new  CompertorTimes());
				play.links.add(websiteF.getText());//add link to list

				System.out.println(play.links.get(0));
				DefaultTableModel model=(DefaultTableModel)table.getModel();
				for (int i = 0; i < play.links.size()-1; i++) {
					if(play.links.size()>1)model.removeRow(0);
				}
				for (int i = 0; i < play.links.size(); i++) {

					//	model.removeRow(i);
					Object[] o=new Object [] {i+1+"-",play.links.get(i)};
					model.addRow(o);
				}



			}
		});
		frame.getContentPane().add(btnAdd);
		frame.getContentPane().add(btnPlay);

//		JLabel lblTimeStart = new JLabel("TIME START :");
//		lblTimeStart.setForeground(new Color(0, 0, 0));
//		lblTimeStart.setFont(new Font("Tahoma", Font.BOLD, 12));
//		lblTimeStart.setBounds(10, 29, 84, 32);
//		frame.getContentPane().add(lblTimeStart);

//		JLabel lblTimeEnd = new JLabel("     TIME END :");
//		lblTimeEnd.setForeground(new Color(0, 0, 0));
//		lblTimeEnd.setFont(new Font("Tahoma", Font.BOLD, 12));
//		lblTimeEnd.setBounds(170, 29, 100, 32);
//		frame.getContentPane().add(lblTimeEnd);

		JLabel lblWebsite = new JLabel("    LINK:");
		lblWebsite.setForeground(new Color(0, 0, 0));
		lblWebsite.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblWebsite.setBounds(10, 129, 84, 32);
		frame.getContentPane().add(lblWebsite);

		
		JLabel userManual = new JLabel("User manual:");
		userManual.setForeground(new Color(0, 0, 0));
		userManual.setFont(new Font("Tahoma", Font.BOLD, 12));
		userManual.setBounds(10, 10, 84, 32);
		frame.getContentPane().add(userManual);
		
		JLabel userManual1 = new JLabel("1: Delete the WhatsApp app from this computer if you have one");
		userManual1.setForeground(new Color(0, 0, 0));
		//userManual1.setFont(new Font("Tahoma", 12));
		userManual1.setBounds(100, 25, 490, 32);
		frame.getContentPane().add(userManual1);
	
		JLabel userManual2 = new JLabel("2: Log in to WhatsApp Web in the WhatsApp app on your cell phone and you will be ready to scan the code");
		userManual2.setForeground(new Color(0, 0, 0));
		//userManual1.setFont(new Font("Tahoma", 12));
		userManual2.setBounds(100, 40, 1000, 32);
		frame.getContentPane().add(userManual2);
		
		JLabel userManual3 = new JLabel("3: Add all the links to the full WhatsApp groups you want to join, when everything is ready click Run");
		userManual3.setForeground(new Color(0, 0, 0));
		//userManual1.setFont(new Font("Tahoma", 12));
		userManual3.setBounds(100, 55, 1000, 32);
		frame.getContentPane().add(userManual3);
		
		JLabel userManual4 = new JLabel("4: When a window opens you need to connect to WhatsApp Web. You only have 25 seconds\r\n"
				+ "  Log in from the moment you click RUN");
		userManual4.setForeground(new Color(0, 0, 0));
		//userManual1.setFont(new Font("Tahoma", 12));
		userManual4.setBounds(100, 70, 1000, 32);
		frame.getContentPane().add(userManual4);
		
		JLabel userManual5 = new JLabel("5: You're done! Now the app will run all day as long as your cell phone is on and with an internet connection");
		userManual5.setForeground(new Color(0, 0, 0));
		//userManual1.setFont(new Font("Tahoma", 12));
		userManual5.setBounds(100, 85, 1000, 32);
		frame.getContentPane().add(userManual5);
//		JButton btnCheck = new JButton("CHECK");
//		btnCheck.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				String app=websiteF.getText();
//				if(app.contains("https://")){
//					WebDriver driver = new ChromeDriver();
//					try {
//						driver.get(app);
//					}
//					catch(Exception w) {
//						try {
//							driver.quit();
//							Desktop.getDesktop().open(new File(app));		
//						}
//						catch(Exception c) {
//							JOptionPane.showMessageDialog(frame, "Error! For an  website/app:'"+app+"' the input is incorrect");
//
//						}
//					}
//					
//				}
//				else {
//					try {
//						Desktop.getDesktop().open(new File(websiteF.getText()));		
//					}
//					catch(Exception c) {
//						JOptionPane.showMessageDialog(frame, "Error! For an  website/app:'"+app+"' the input is incorrect");
//					}
//				}
//			}
//		});
//		btnCheck.setBounds(610, 36, 82, 21);
//		frame.getContentPane().add(btnCheck);

//		JButton btnAddApp = new JButton("ADD APP");
//		btnAddApp.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//
//				if(ErrInput.Time(start.getText())) {
//					JOptionPane.showMessageDialog(frame, "Error! For an  start time:'"+start.getText()+"' the input is incorrect");
//					return;
//				}
//				if(ErrInput.Time(end.getText())) {
//					JOptionPane.showMessageDialog(frame, "Error! For an  end time:'"+end.getText()+"' the input is incorrect");
//					return;
//				}
//
//				play.type.put(start.getText(),false);
//				play.times.add(start.getText());
//				play.timesEnd.put(start.getText(),end.getText());
//				play.website.put(start.getText(),websiteF.getText());
//				Collections.sort( play.times, new  CompertorTimes());
//
//				System.out.println(play.website.get(play.times.get(0)));
//				DefaultTableModel model=(DefaultTableModel)table.getModel();
//				for (int i = 0; i < play.times.size()-1; i++) {
//					if(play.times.size()>1)model.removeRow(0);
//				}
//				for (int i = 0; i < play.times.size(); i++) {
//
//					//	model.removeRow(i);
//					Object[] o=new Object [] {i+1+"-",play.times.get(i),play.timesEnd.get(play.times.get(i)),play.website.get(play.times.get(i))};
//					model.addRow(o);
//				}
//
//
//
//
//
//
//
//
//			}
//		});
//		btnAddApp.setBounds(845, 36, 93, 21);
//		frame.getContentPane().add(btnAddApp);
	}
}
