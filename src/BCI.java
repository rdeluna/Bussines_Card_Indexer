import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;



import java.sql.*;
import java.util.Collection;


public class BCI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BCI window = new BCI();
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
	Connection connection = null;
	
	
	public BCI() {
		initialize();
		connection = SqliteConnection.dbConnector();
		
		
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 999, 451);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnAddCard = new JButton("Add Card");
		btnAddCard.setBounds(638, 48, 187, 62);
		frame.getContentPane().add(btnAddCard);
		
		JButton btnSearchCard = new JButton("Search for a Card");
		btnSearchCard.setBounds(638, 168, 187, 62);
		frame.getContentPane().add(btnSearchCard);
		
		JButton btnRemoveCard = new JButton("Remove a Card");
		btnRemoveCard.setBounds(638, 277, 187, 62);
		frame.getContentPane().add(btnRemoveCard);
	}
}
