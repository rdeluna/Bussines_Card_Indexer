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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class BCI {

	private JFrame frmBci;
	private JPanel panel_AddCard;
	private JPanel panel_SearchCard;
	private JPanel panel_UpdateDelete;
	private JLabel lblDBCount;
	
	
	

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
		
		final JPanel panel = new JPanel();
		frmBci.getContentPane().add(panel, "name_482648056783477");
		panel.setLayout(null);
		panel.setVisible(true);
		
		final JPanel panel_AddCard = new JPanel();
		frmBci.getContentPane().add(panel_AddCard, "name_482653337944652");
		panel_AddCard.setLayout(null);
		panel_AddCard.setVisible(false);
		
		final JPanel panel_SearchCard = new JPanel();
		frmBci.getContentPane().add(panel_SearchCard, "name_482658595854250");
		panel_SearchCard.setVisible(false);
		
		final JPanel panel_UpdateDelete = new JPanel();
		frmBci.getContentPane().add(panel_UpdateDelete, "name_492082829524984");
		panel_UpdateDelete.setVisible(false);
		
		
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
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			panel_AddCard.setVisible(true);
				panel.setVisible(false);
				
			}
		});

		
		JButton btnSearchCards = new JButton("Search Cards");
		btnSearchCards.setBounds(625, 157, 257, 74);
		panel.add(btnSearchCards);
		
		JButton btnUpdateDelete = new JButton("Update / Delete Cards");
		btnUpdateDelete.setBounds(625, 262, 257, 74);
		panel.add(btnUpdateDelete);
		

		
		JButton btnNewButton = new JButton("return");
		btnNewButton.setBounds(518, 278, 187, 66);
		panel_AddCard.add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(true);
				panel_AddCard.setVisible(false);
				
				
			}
		});

		

		
		connection = SqliteConnection.dbConnector();
		
		lblDBCount.setText(String.valueOf(rCount()));
		
	}
	
	public int rCount()
	{
		int records = 0;
		try 
		{
				String querry = "select count(*) from cards"; // use sql to get a count of the total record for table cards
				PreparedStatement pst = connection.prepareStatement(querry); //assign the prepared statement
				ResultSet rst =pst.executeQuery(); //execute with extreme prejudice
				
				while(rst.next()) // loop through records returned
				{
					records = rst.getInt(1); // get the count which is a int from record 1 and assign it to records
					
					
				}
				

				
				

				rst.close();
				pst.close();
		}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null, "Get number of cards failed..." + e);
				
			}
		
		return records;
		
	}
	
}
