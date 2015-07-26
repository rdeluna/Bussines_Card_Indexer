import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;



import javax.swing.JOptionPane;

import java.sql.*;
import java.util.Collection;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.CardLayout;
import javax.swing.JPanel;


public class BCI {

	private JFrame frmBci;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BCI window = new BCI();
					window.frmBci.setVisible(true);
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
		frmBci = new JFrame();
		frmBci.setTitle("BCI");
		frmBci.setBounds(100, 100, 999, 451);
		frmBci.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBci.getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel();
		frmBci.getContentPane().add(panel, "name_482648056783477");
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cards in DB");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(68, 286, 200, 50);
		panel.add(lblNewLabel);
		
		JLabel lblDBCount = new JLabel("0");
		lblDBCount.setHorizontalAlignment(SwingConstants.CENTER);
		lblDBCount.setBounds(301, 286, 200, 50);
		panel.add(lblDBCount);
		
		JButton btnAdd = new JButton("Add Card");
		btnAdd.setBounds(625, 48, 257, 74);
		panel.add(btnAdd);
		
		JButton btnSearchCards = new JButton("Search Cards");
		btnSearchCards.setBounds(625, 157, 257, 74);
		panel.add(btnSearchCards);
		
		JButton btnUpdateDelete = new JButton("Update / Delete Cards");
		btnUpdateDelete.setBounds(625, 262, 257, 74);
		panel.add(btnUpdateDelete);
		
		JPanel panel_1 = new JPanel();
		frmBci.getContentPane().add(panel_1, "name_482653337944652");
		
		JPanel panel_2 = new JPanel();
		frmBci.getContentPane().add(panel_2, "name_482658595854250");
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
				

				lblDBCount.setText(String.valueOf(records));
				rst.close();
				pst.close();
		}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null, "Get number of cards failed..." + e);
			}
		
	}
}
