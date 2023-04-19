package grocerypos;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.ScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

public class GroceryPOS {

	private JFrame frmGroceryPos;
	private JPanel productPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GroceryPOS window = new GroceryPOS();
					window.frmGroceryPos.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GroceryPOS() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		int stock = 20;
		
		frmGroceryPos = new JFrame();
		frmGroceryPos.setTitle("Grocery POS");
		frmGroceryPos.setBounds(100, 100, 1116, 696);
		frmGroceryPos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGroceryPos.getContentPane().setLayout(null);
		
		productPanel = new JPanel();
		productPanel.setBackground(new Color(216, 216, 216));
		productPanel.setBounds(0, 0, 809, 499);
		productPanel.setLayout(null);
		frmGroceryPos.getContentPane().add(productPanel);
		productPanel.setLayout(null);
		
		JPanel orderPanel = new JPanel();
		orderPanel.setBackground(new Color(216, 216, 216));
		orderPanel.setBounds(819, 0, 281, 657);
		frmGroceryPos.getContentPane().add(orderPanel);
		orderPanel.setLayout(null);
		
		// Button for checkout
		JButton checkoutBtn = new JButton("Checkout");
		checkoutBtn.setBounds(10, 623, 261, 23);
		orderPanel.add(checkoutBtn);
		
		//-------------------------------------------------------------------------
		// Make sure to edit the file name and change it to whatever name you put if yo uwant to see images
		String[] meatLoc = {"Chicken.jpg","beef.jpg", "pork.jpeg", "turkey.jpg", "lamb.jpg", "duck.jpg", "sausage.jpeg", "crab.jpg", "oyster.png", "scallop.png"};
		String[] meatName = {"Chicken", "Beef", "Pork", "Turkey", "Lamb", "Duck", "Sausage", "Crab", "Oyster", "Scallop"};
		double[] meatPrice = {250.00, 350.00, 250.00, 370.00, 620.00, 190.00, 140.00, 840.00, 360.00, 210.00};
		JButton meat = new JButton("Meat & Seafoods");
		catBtnClicked(meat, 10, 533, 153, 99, meatLoc, meatName, meatPrice);
		//-------------------------------------------------------------------------
		String[] dairyLoc = {"milk.jpg", "butter.png","yogurt.jpg", "cheese.jpg", "custard.png", "condensed_milk.jpg", "evaporated_milk.jpg", "sour cream.jpg", "yakult.jpg", "buttermilk.jpg"};
		String[] dairyName = {"Milk", "Butter", "Yogurt", "Cheese", "Custard", "Condensed Milk", "Evaporated Milk", "Sour Cream", "Yakult", "Buttermilk"};
		double[] dairyPrice = {80.00, 95.00, 200.00, 145.00, 250.00, 55.00, 55.00, 130.00, 55.00, 160.00};
		JButton dairy = new JButton("Dairy");
		catBtnClicked(dairy, 220, 533, 153, 99, dairyLoc, dairyName, dairyPrice);
		//-------------------------------------------------------------------------
		String[] fruitLoc = {"apple.jpg", "avocado.jpg", "banana.jpg", "durian.jpg", "mango.jpg", "orange.jpg", "papaya.jpg", "pineapple.jpg", "strawberry.jpg", "watermelon.jpg"};
		String[] fruitName = {"Apple", "Avocado", "Banana", "Durian", "Mango", "Orange", "Papaya", "Pineapple", "Strawberry", "Watermelon"};
		double[] fruitPrice = {162.00, 70.00, 70.00, 50.00, 170.00, 70.00, 50.00, 59.00, 300.00, 80.00};
		
		JButton fruit = new JButton("Fruit");
		catBtnClicked(fruit, 425, 533, 153, 99, fruitLoc, fruitName, fruitPrice);
		//-------------------------------------------------------------------------
		String[] vegeLoc = {"asparagus.jpg", "broccoli.jpg", "cabbage.jpg", "carrot.jpg", "garlic.jpg", "onion.jpg", "potato.jpg", "pumpkin.jpg", "spinach.jpg", "spring_onion.jpg"};
		String[] vegeName = {"Asparagus", "Broccoli", "Cabbage", "Carrot", "Garlic", "Onion", "Potato", "Pumpkin", "Spinach", "Spring Onion"};
		double[] vegePrice = {240.00, 200.00, 80.00, 100.00, 150.00, 170.00, 110.00, 69.00, 70.00, 180.00};
		
		JButton veggie = new JButton("Vegetables");
		catBtnClicked(veggie, 633, 533, 153, 99, vegeLoc, vegeName, vegePrice);
		//-------------------------------------------------------------------------
	}
	
	// 
	public void productButton(String name, int x, int y) {
		JButton btn = new JButton(name);
		btn.setBounds(x, y, 120, 22);
		productPanel.add(btn);
	}
	
	// THIS IS ONLY FOR CATEGORY BUTTONS
	private void catBtnClicked(JButton button, int x, int y, int width, int height, String[] fileLoc, String[] prodName, double[] price) {
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProductDisplay meat = new ProductDisplay();
				meat.category(productPanel, fileLoc, price);
				productButton(prodName[0], 10, 183);
				productButton(prodName[1], 10, 438);
				productButton(prodName[2], 171, 183);
				productButton(prodName[3], 171, 438);
				productButton(prodName[4], 332, 183);
				productButton(prodName[5], 332, 438);
				productButton(prodName[6], 493, 183);
				productButton(prodName[7], 493, 438);
				productButton(prodName[8], 654, 183);
				productButton(prodName[9], 654, 438);
			}
		});
		button.setBounds(x, y, width, height);
		frmGroceryPos.getContentPane().add(button);
	}
}
