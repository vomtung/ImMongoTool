package com.vomtung.immongo;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
/**
 * 
 * @author vominhtung
 *
 */
public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JTextField sourceJSONURLTextField;
	private JPasswordField sourcePasswordTextField;
	private JTextField sourceUserNameTextField;
	private JTextField destinationURLTextField;
	private JTextField destinationCollectionTextField;
	private JTextField destinationUserNameTextField;
	private JTextField destinationPortTextField;
	private JPasswordField destinationPasswordField;
	private JButton btnImport;
	private JTextField destinationDataBase;
	private JTextArea loggingTextArea;
	private JScrollPane loggingScrollPanel;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					MainFrame frame = new MainFrame();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 743, 535);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 32, 707, 215);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("SourceDB", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblConnectionUrl = new JLabel("Connection URL");
		lblConnectionUrl.setBounds(10, 11, 92, 14);
		panel.add(lblConnectionUrl);
		
		sourceJSONURLTextField = new JTextField();
		sourceJSONURLTextField.setBounds(112, 8, 580, 20);
		panel.add(sourceJSONURLTextField);
		sourceJSONURLTextField.setColumns(10);
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setBounds(10, 56, 69, 14);
		panel.add(lblUserName);
		
		sourcePasswordTextField = new JPasswordField();
		sourcePasswordTextField.setBounds(112, 96, 339, 20);
		panel.add(sourcePasswordTextField);
		
		sourceUserNameTextField = new JTextField();
		sourceUserNameTextField.setBounds(112, 53, 339, 20);
		panel.add(sourceUserNameTextField);
		sourceUserNameTextField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(10, 99, 69, 14);
		panel.add(lblPassword);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Destination MongoDB", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblUrl = new JLabel("URL");
		lblUrl.setBounds(10, 11, 46, 14);
		panel_1.add(lblUrl);
		
		destinationURLTextField = new JTextField();
		destinationURLTextField.setBounds(86, 8, 606, 20);
		panel_1.add(destinationURLTextField);
		destinationURLTextField.setColumns(10);
		
		JLabel lblCollection = new JLabel("Collection");
		lblCollection.setBounds(10, 95, 62, 14);
		panel_1.add(lblCollection);
		
		destinationCollectionTextField = new JTextField();
		destinationCollectionTextField.setBounds(86, 92, 606, 20);
		panel_1.add(destinationCollectionTextField);
		destinationCollectionTextField.setColumns(10);
		
		JLabel lblUserName_1 = new JLabel("User Name");
		lblUserName_1.setBounds(10, 126, 83, 14);
		panel_1.add(lblUserName_1);
		
		destinationUserNameTextField = new JTextField();
		destinationUserNameTextField.setBounds(86, 123, 606, 20);
		panel_1.add(destinationUserNameTextField);
		destinationUserNameTextField.setColumns(10);
		
		JLabel lblPort = new JLabel("Port");
		lblPort.setBounds(10, 36, 46, 14);
		panel_1.add(lblPort);
		
		destinationPortTextField = new JTextField();
		destinationPortTextField.setBounds(86, 33, 103, 20);
		panel_1.add(destinationPortTextField);
		destinationPortTextField.setColumns(10);
		
		JLabel lblPassword_1 = new JLabel("Password");
		lblPassword_1.setBounds(10, 157, 83, 14);
		panel_1.add(lblPassword_1);
		
		destinationPasswordField = new JPasswordField();
		destinationPasswordField.setBounds(86, 154, 606, 20);
		panel_1.add(destinationPasswordField);
		
		JLabel lblDatabase = new JLabel("Database");
		lblDatabase.setBounds(10, 67, 83, 14);
		panel_1.add(lblDatabase);
		
		destinationDataBase = new JTextField();
		destinationDataBase.setBounds(86, 64, 606, 20);
		panel_1.add(destinationDataBase);
		destinationDataBase.setColumns(10);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 727, 21);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("New menu");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("New menu item");
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("New menu item");
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("New menu item");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_1 = new JMenu("Help");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("About");
		mnNewMenu_1.add(mntmNewMenuItem_3);
		
		btnImport = new JButton("Import");
		btnImport.setBounds(593, 462, 89, 23);
		contentPane.add(btnImport);
		
		loggingTextArea = new JTextArea();
		//loggingTextArea.setBounds(10, 263, 707, 188);
		//contentPane.add(loggingTextArea);
		
		loggingScrollPanel= new JScrollPane (loggingTextArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		loggingScrollPanel.setBounds(10, 263, 707, 188);
		contentPane.add(loggingScrollPanel);
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public JTextField getSourceJSONURLTextField() {
		return sourceJSONURLTextField;
	}

	public JPasswordField getSourcePasswordTextField() {
		return sourcePasswordTextField;
	}

	public JTextField getSourceUserNameTextField() {
		return sourceUserNameTextField;
	}

	public JTextField getDestinationURLTextField() {
		return destinationURLTextField;
	}

	public JTextField getDestinationCollectionTextField() {
		return destinationCollectionTextField;
	}

	public JTextField getDestinationUserNameTextField() {
		return destinationUserNameTextField;
	}

	public JTextField getDestinationPortTextField() {
		return destinationPortTextField;
	}

	public JPasswordField getDestinationPasswordField() {
		return destinationPasswordField;
	}

	public JTextField getDestinationDataBase() {
		return destinationDataBase;
	}
	
	public JTextArea getLoggingTextArea() {
		return loggingTextArea;
	}

	public JButton getBtnImport() {
		return btnImport;
	}
}
