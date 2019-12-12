import java.awt.EventQueue;
import java.awt.HeadlessException;
import javax.swing.JFrame;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Desktop;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;

public class Phase3GUI extends JFrame {

	private JFrame phase3Frame;
	private JTextField textField;
	private JPasswordField textField1;
	private JTextField textField2;
	private JTextField textField3;
	private JTextField textField4;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Phase3GUI window = new Phase3GUI();
					window.phase3Frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Phase3GUI() {
		initialize();
	}
//Creates the GUI ain components for the design
	private void initialize() {
		phase3Frame = new JFrame();
		phase3Frame.setSize(500, 300);
		phase3Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		phase3Frame.getContentPane().setLayout(new CardLayout(0, 0));

		final JPanel mPanel = new JPanel();
		mPanel.setBackground(Color.YELLOW);
		phase3Frame.getContentPane().add(mPanel, "MainPanel");
		mPanel.setVisible(true);

		final JPanel lPanel = new JPanel();
		phase3Frame.getContentPane().add(lPanel, "LoginPanel");
		lPanel.setLayout(null);

		JLabel uLbl = new JLabel("UserName:");
		uLbl.setBounds(150, 75, 70, 15);
		lPanel.add(uLbl);

		JLabel pLbl = new JLabel("PassWord:");
		pLbl.setBounds(150, 130, 70, 20);
		lPanel.add(pLbl);

		textField = new JTextField();
		textField.setBounds(240, 80, 235, 20);
		lPanel.add(textField);
		textField.setColumns(10);

		textField1 = new JPasswordField();
		textField1.setBounds(240, 130, 235, 20);
		lPanel.add(textField1);
		textField1.setColumns(10);

		final JPanel rPanel = new JPanel();
		phase3Frame.getContentPane().add(rPanel, "Register");
		rPanel.setLayout(null);

		JLabel NewUserLabel = new JLabel("Username:");
		NewUserLabel.setBounds(125, 80, 72, 15);
		rPanel.add(NewUserLabel);

		JLabel npLbl = new JLabel("Password:");
		npLbl.setBounds(125, 130, 72, 15);
		rPanel.add(npLbl);
		rPanel.setVisible(false);

		textField2 = new JTextField();
		textField2.setBounds(240, 82, 235, 20);
		rPanel.add(textField2);
		textField2.setColumns(10);

		textField3 = new JTextField();
		textField3.setBounds(240, 127, 235, 20);
		rPanel.add(textField3);
		textField3.setColumns(10);

		//From the MAT Widget, this will give all hte options to click on to use its pages for resources such as
		//Schedule, Planned Service, Fares, and Maps/Directions.
		JButton scheduleBtn = new JButton("MTA Schedule");
		scheduleBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				try {
					Desktop.getDesktop().open(new java.io.File("Schedules _ MTA.html"));
				}

				catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});

		scheduleBtn.setBounds(0, 0, 595, 23);
		// mtaPanel.add(scheduleBtn); For some reason there was an error on this part so
		// I left it there.

		JButton mapBtn = new JButton("MTA Maps");
		mapBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				try {
					Desktop.getDesktop().open(new java.io.File("mta.info _ MTA Maps.html"));
				}

				catch (Exception ex) {
					ex.printStackTrace();

				}
			}
		});

		mapBtn.setBounds(0, 44, 595, 23);
		// mtaPanel.add(mapBtn); For some reason there was an error on this part so I
		// left it there.

		JButton psBtn = new JButton("MTA Planned Service");
		psBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				try {
					Desktop.getDesktop().open(new java.io.File("mta.info _ MTA Planned Service Changes.html"));
				}

				catch (Exception ex) {
					ex.printStackTrace();

				}
			}
		});

		psBtn.setBounds(0, 88, 595, 23);
		// mtaPanel.add(psBtn); For some reason there was an error on this part so I
		// left it there.

		JButton fareBtn = new JButton("MTA Fare Tolls");
		fareBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				try {
					Desktop.getDesktop().open(new java.io.File("mta.info _ MTA Fares and Tolls.html"));
				}

				catch (Exception ex) {
					ex.printStackTrace();

				}
			}
		});

		fareBtn.setBounds(0, 133, 595, 23);
		// mtaPanel.add(fareBtn); For some reason there was an error on this part so I
		// left it there.

		JButton b2 = new JButton("Return to Main");
		b2.setBackground(Color.pink);
		b2.setOpaque(true);
		b2.setBorderPainted(false);
		b2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				mPanel.setVisible(true);
			}
		});
		b2.setBounds(0, 0, 91, 43);

		//This creates the Search 
		final JPanel sPanel = new JPanel();
		phase3Frame.getContentPane().add(sPanel, "SearchPanel");
		sPanel.setLayout(null);

		JLabel sBtn = new JLabel("Search:");
		sBtn.setBounds(87, 131, 93, 14);
		sPanel.add(sBtn);

		textField4 = new JTextField();
		textField4.setBounds(190, 128, 198, 20);
		sPanel.add(textField4);
		textField4.setColumns(10);

		JButton sBtn1 = new JButton("Search");
		sBtn1.setBackground(Color.orange);
		sBtn1.setOpaque(true);
		sBtn1.setBorderPainted(false);
		sBtn1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				try {
					String Search = textField4.getText();
					Desktop.getDesktop().browse(new URL("http://www.mta.info/gsearch/" + Search).toURI());
				} catch (Exception e) {

				}
			}
		});
		sBtn1.setBounds(398, 127, 89, 23);
		sPanel.add(sBtn1);

		//Returns to Main Window
		JButton b3 = new JButton("Return to Main");
		b3.setBackground(Color.pink);
		b3.setOpaque(true);
		b3.setBorderPainted(false);
		b3.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				sPanel.setVisible(false);
				mPanel.setVisible(true);
			}
		});
		b3.setBounds(0, 0, 99, 44);
		sPanel.add(b3);
		sPanel.setVisible(false);

		//Shows the Recent logs
		final JPanel tPanel = new JPanel();
		phase3Frame.getContentPane().add(tPanel, "Transaction");
		tPanel.setLayout(null);

		JButton tlBtn = new JButton("Transaction Log");
		tlBtn.setBackground(Color.red);
		tlBtn.setOpaque(true);
		tlBtn.setBorderPainted(false);
		tlBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				try {
					Desktop.getDesktop().open(new java.io.File("TransactionLog.txt"));
				}

				catch (Exception ex) {
					ex.printStackTrace();

				}
			}
		});
		tlBtn.setBounds(0, 94, 292, 92);
		tPanel.add(tlBtn);

		JButton b4 = new JButton("Return to Main");
		b4.setBackground(Color.pink);
		b4.setOpaque(true);
		b4.setBorderPainted(false);
		b4.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				tPanel.setVisible(false);
				mPanel.setVisible(true);
			}
		});
		b4.setBounds(0, 0, 104, 42);
		tPanel.add(b4);

		JButton btnEnter = new JButton("Enter");
		btnEnter.setBackground(Color.cyan);
		btnEnter.setOpaque(true);
		btnEnter.setBorderPainted(false);
		btnEnter.setBounds(240, 178, 124, 50);
		btnEnter.addActionListener(new ActionListener() {

		//Verifies whether the user and pass matches with the user or admin account.
			public void actionPerformed(ActionEvent e) {

				String userName = textField.getText();
				@SuppressWarnings("deprecation")
				String passWord = textField1.getText();

				try {
					BufferedReader BufferedReader = new BufferedReader(new FileReader("UserPassListtxt"));
					String Line;

					while ((Line = BufferedReader.readLine()) != null) {

						String LineArray[] = Line.split(" ");

						System.out.println(LineArray[0]);
						System.out.println(LineArray[1]);

						if (LineArray[0].equals(userName) && LineArray[1].equals(passWord)) {
							JOptionPane.showMessageDialog(null, "Successful!", "Welcome!",
									JOptionPane.INFORMATION_MESSAGE);
							lPanel.setVisible(false);
							BufferedReader.close();

							String string = textField2.getText() + " CREATED ACCOUNT!";
							String string2 = textField.getText() + " LOGGED IN!";
							BufferedWriter writer = new BufferedWriter(new FileWriter("TransactionLog.txt"));
							writer.write(string);
							writer.write(string2);
							writer.newLine();
							writer.close();

						} else {
							JOptionPane.showMessageDialog(null, "Error!", "Match Invalid", JOptionPane.ERROR_MESSAGE);
						}
					}

				}

				catch (FileNotFoundException fnf) {
					JOptionPane.showMessageDialog(null, "No Such File!", "Oops, Error!", JOptionPane.ERROR_MESSAGE);
				}

				catch (HeadlessException hde) {
					hde.printStackTrace();
				}

				catch (IOException ioe) {
					ioe.printStackTrace();
				}

			}
		});
		lPanel.add(btnEnter);

		JButton b = new JButton("Return to Main"); 
		b.setBackground(Color.pink);
		b.setOpaque(true);
		b.setBorderPainted(false);
		b.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				mPanel.setVisible(true);
				lPanel.setVisible(false);
			}
		});
		b.setBounds(0, 0, 90, 44);
		lPanel.add(b);

		//Logs in Admin account
		JButton adminBtn = new JButton("Enter Admin"); 
		adminBtn.setBackground(Color.green);
		adminBtn.setOpaque(true);
		adminBtn.setBorderPainted(false);
		adminBtn.addActionListener(new ActionListener() {

		//Checks if the user input for admin matches.
			public void actionPerformed(ActionEvent e) {

				String UserName = textField.getText();
				@SuppressWarnings("deprecation")
				String PassWord = textField1.getText();

				try {
					BufferedReader BufferedReader = new BufferedReader(new FileReader("UserPassList.txt"));
					String Line;

					while ((Line = BufferedReader.readLine()) != null) {

						String LineArray[] = Line.split(" ");

						System.out.println(LineArray[0]);
						System.out.println(LineArray[1]);

						if (LineArray[0].equals(UserName) && LineArray[1].equals(PassWord)) {
							JOptionPane.showMessageDialog(null, "Successful", "Welcome!",
									JOptionPane.INFORMATION_MESSAGE);
							mPanel.setVisible(true);
							lPanel.setVisible(false);
							BufferedReader.close();

							String string = textField2.getText() + " CREATED ACCOUNT!";
							String string2 = textField.getText() + " LOGGED IN!";
							BufferedWriter writer = new BufferedWriter(new FileWriter("TransactionLog.txt"));
							writer.write(string);
							writer.write(string2);
							writer.newLine();
							writer.close();
						} else {
							JOptionPane.showMessageDialog(null, "Error!", "No match found!", JOptionPane.ERROR_MESSAGE);
						}
					}
				}

				catch (FileNotFoundException ex) {
					JOptionPane.showMessageDialog(null, "Error!", "File does not exist!", JOptionPane.ERROR_MESSAGE);
				}

				catch (HeadlessException ex) {
					ex.printStackTrace();
				}

				catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		});
		adminBtn.setBounds(361, 178, 114, 50);
		lPanel.add(adminBtn);
		lPanel.setVisible(false);

		//Executes and writes the information in the .txt file
		JButton fBtn = new JButton("Finish");
		fBtn.setBackground(Color.pink);
		fBtn.setOpaque(true);
		fBtn.setBorderPainted(false);
		fBtn.setBounds(240, 172, 235, 54);
		fBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				lPanel.setVisible(true);
				rPanel.setVisible(false);

				try {

					BufferedWriter bw = new BufferedWriter(new FileWriter(("UserPassList.txt"), true));
					bw.write(textField2.getText() + " " + textField3.getText());
					bw.newLine();

					bw.close();
				}

				catch (Exception exc) {
					exc.printStackTrace();
				}
				;
			}
		});
		rPanel.add(fBtn);

		JButton b1 = new JButton("Return to Main");
		b1.setBackground(Color.pink);
		b1.setOpaque(true);
		b1.setBorderPainted(false);
		b1.setBounds(0, 0, 90, 44);
		b1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				mPanel.setVisible(true);
				rPanel.setVisible(false);
			}
		});
		rPanel.add(b1);

		//Buttons for the Pages for MTA website
		JButton mtaBtn = new JButton("MTA Widgets");
		mtaBtn.setBackground(Color.pink);
		mtaBtn.setOpaque(true);
		mtaBtn.setBorderPainted(false);
		mtaBtn.setBounds(0, 0, 280, 80);
		mtaBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mPanel.setVisible(false);
			}
		});

		mPanel.add(mtaBtn);

		JButton searchBtn = new JButton("Search");
		searchBtn.setBackground(Color.pink);
		searchBtn.setOpaque(true);
		searchBtn.setBorderPainted(false);
		searchBtn.setBounds(0, 91, 280, 80);
		searchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sPanel.setVisible(true);
				mPanel.setVisible(false);
			}
		});
		mPanel.add(searchBtn);
		mPanel.add(mtaBtn);

		JButton tlButton = new JButton("Transaction Log");
		tlButton.setBackground(Color.pink);
		tlButton.setOpaque(true);
		tlButton.setBorderPainted(false);
		tlButton.setBounds(0, 182, 280, 80);
		tlButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				mPanel.setVisible(false);
				tPanel.setVisible(true);

			}
		});
		mPanel.add(tlButton);

		JButton rBtn = new JButton("Register");
		rBtn.setBackground(Color.pink);
		rBtn.setOpaque(true);
		rBtn.setBorderPainted(false);
		rBtn.setBounds(304, 0, 280, 80);
		rBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rPanel.setVisible(true);
				mPanel.setVisible(false);
			}
		});
		mPanel.add(rBtn);

		JButton logBtn = new JButton("Log in");
		logBtn.setBackground(Color.pink);
        logBtn.setOpaque(true);
        logBtn.setBorderPainted(false);
		logBtn.setBounds(304, 91, 280, 80);
		logBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg) {

				lPanel.setVisible(true);
				mPanel.setVisible(false);

			}
		});
		mPanel.add(logBtn);
	}
}
