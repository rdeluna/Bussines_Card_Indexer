import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;



import javax.swing.JOptionPane;

import java.sql.*;
import java.util.Collection;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;


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
		
		JLabel lblNewLabel = new JLabel("Total cards in DB");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(50, 289, 200, 50);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblcardCount = new JLabel("");
		lblcardCount.setHorizontalAlignment(SwingConstants.CENTER);
		lblcardCount.setBounds(293, 289, 200, 50);
		frame.getContentPane().add(lblcardCount);
		connection = SqliteConnection.dbConnector();
		
		try 
		{
				String querry = "select count(*) from cards"; // use sql to get a count of the total record for table cards
				PreparedStatement pst = connection.prepareStatement(querry); //assign the prepared statement
				ResultSet rst =pst.executeQuery(); //execute with extreme prejudice
				int records = 0;
				while(rst.next()) // loop through records returned
				{
					records = rst.getInt(1); // get the count which is a int from record 1 and assign it to records
					
					
				}
				
				
				
				
				lblcardCount.setText(String.valueOf(records)); //update the screen
				

				
				rst.close();
				pst.close();
		}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null, "Get number of cards failed..." + e);
			}
		
	}
}
