package iteration1;

import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.io.File;

public class GenerateMenu {

	private JFrame frame;
	private JTextField textField;
	private File selectedFile;

	/**
	 * Launch the application.
	 */
	public static void GenerateScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GenerateMenu window = new GenerateMenu();
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
	public GenerateMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblSchoolsFile = new JLabel("Schools File");
		lblSchoolsFile.setBounds(178, 61, 137, 26);
		frame.getContentPane().add(lblSchoolsFile);
		
		textField = new JTextField();
		textField.setBounds(37, 152, 233, 25);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnFind = new JButton("Find");
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser fileChooser = new JFileChooser();
				
				// Initial directory
				fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
				
				// Allows only a certain extension to be chosen.
		        fileChooser.setAcceptAllFileFilterUsed(false);
		        FileNameExtensionFilter filter = new FileNameExtensionFilter("Comma Separated Values", "csv");
		        fileChooser.addChoosableFileFilter(filter);
		        fileChooser.showOpenDialog(null);
				
				int result = fileChooser.showOpenDialog(fileChooser);
				
				// Check if user selects a file
				if (result == JFileChooser.APPROVE_OPTION) {
				    selectedFile = fileChooser.getSelectedFile();
				    textField.setText(selectedFile.getAbsolutePath());
				} else {
					JOptionPane.showMessageDialog(null, "You didn't select a file.", "Warning", JOptionPane.INFORMATION_MESSAGE);
				}

			}
		});
		btnFind.setBounds(282, 152, 117, 25);
		frame.getContentPane().add(btnFind);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (selectedFile.length() != 0) {
					MapAndListGUI mapgui = new MapAndListGUI(selectedFile);
				} else {
					JOptionPane.showMessageDialog(null, "You didn't select a file.", "Warning", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnOk.setBounds(160, 213, 117, 25);
		frame.getContentPane().add(btnOk);
		
		JLabel lblPathWillDisplay = new JLabel("Path will display here:");
		lblPathWillDisplay.setBounds(37, 133, 233, 15);
		frame.getContentPane().add(lblPathWillDisplay);
	}
}
