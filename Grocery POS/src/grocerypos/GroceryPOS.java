package grocerypos;

import java.awt.EventQueue;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import java.awt.Font;

public class GroceryPOS {
    private JFrame frmGroceryPos;
    private JPanel productPanel;
    private JPanel orderPanel;
    private Cart tblShoppingCart;
    private ArrayList<String> productsShown = new ArrayList<>(Arrays.asList("", "", "", "", "", "", "", "", "", ""));
    private ArrayList<Double> pricesShown = new ArrayList<>(Arrays.asList(0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0));
    private ArrayList<Integer> stocksShown = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
    JLabel lblJIM;
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
        frmGroceryPos = new JFrame();
        frmGroceryPos.setTitle("Java International Market (JIM)");
        frmGroceryPos.setBounds(100, 100, 1116, 696);
        frmGroceryPos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmGroceryPos.getContentPane().setLayout(null);

        productPanel = new JPanel();
        productPanel.setBackground(new Color(216, 216, 216));
        productPanel.setBounds(0, 0, 809, 499);
        productPanel.setLayout(null);
        frmGroceryPos.getContentPane().add(productPanel);
        productPanel.setLayout(null);
        
        lblJIM = new JLabel("Java International Market POS");
        lblJIM.setFont(new Font("Swis721 Blk BT", Font.BOLD, 35));
        lblJIM.setBounds(83, 204, 666, 99);
        productPanel.add(lblJIM);

        orderPanel = new JPanel();
        orderPanel.setBackground(new Color(216, 216, 216));
        orderPanel.setBounds(819, 0, 281, 657);
        frmGroceryPos.getContentPane().add(orderPanel);
        orderPanel.setLayout(null);
        
        // ShoppingCart and related components
        tblShoppingCart = new Cart(orderPanel);
        JScrollPane scrollPane = new JScrollPane(tblShoppingCart);
        scrollPane.setBounds(0, 35, 281, 464);
        orderPanel.add(scrollPane);
        
        // Buttons - Products
        createProductButtons();
        createImages();

        //-------------------------------------------------------------------------
        // Make sure to edit the file name and change it to whatever name you put if you want to see images
        String[] meatLoc = {"beef.jpg", "Chicken.jpg",  "crab.jpg", "duck.jpg", "lamb.jpg", "oyster.png", "pork.jpeg", "sausage.jpeg", "scallop.png", "turkey.jpg",};
        String[] meatName = {"Beef", "Chicken", "Crab", "Duck", "Lamb", "Oyster", "Pork", "Sausage", "Scallop", "Turkey"};
        double[] meatPrice = {350.00, 250.00, 840.00, 190.00, 620.00, 360.00, 250.00, 140.00, 210.00, 370.00};
        int[] meatStock = {57, 41, 36, 44, 86, 40, 97, 73, 92, 12};
        JButton meat = new JButton("Meat & Seafoods");
        catBtnClicked(meat, 10, 533, 153, 99, meatLoc, meatName, meatPrice, meatStock);
        //-------------------------------------------------------------------------
        String[] dairyLoc = {"butter.png", "buttermilk.jpg", "cheese.jpg", "condensed_milk.jpg", "custard.png", "evaporated_milk.jpg", "milk.jpg", "sour cream.jpg", "yakult.jpg", "yogurt.jpg"};
        String[] dairyName = {"Butter", "Buttermilk", "Cheese", "Condensed Milk", "Custard", "Evaporated Milk", "Milk", "Sour Cream", "Yakult", "Yogurt",};
        double[] dairyPrice = {95.00, 160.00, 145.00, 55.00, 250.00, 55.00, 80.00, 130.00, 55.00, 200.00};
        int[] dairyStock = {87, 73, 93, 44, 18, 82, 64, 30, 61, 23};
        JButton dairy = new JButton("Dairy");
        catBtnClicked(dairy, 220, 533, 153, 99, dairyLoc, dairyName, dairyPrice, dairyStock);
        //-------------------------------------------------------------------------
        String[] fruitLoc = {"apple.jpg", "avocado.jpg", "banana.jpg", "durian.jpg", "mango.jpg", "orange.jpg", "papaya.jpg", "pineapple.jpg", "strawberry.jpg", "watermelon.jpg"};
        String[] fruitName = {"Apple", "Avocado", "Banana", "Durian", "Mango", "Orange", "Papaya", "Pineapple", "Strawberry", "Watermelon"};
        double[] fruitPrice = {162.00, 70.00, 70.00, 50.00, 170.00, 70.00, 50.00, 59.00, 300.00, 80.00};
        int[] fruitStock = {71, 61, 11, 22, 35, 77, 68, 30, 24, 100};
        JButton fruit = new JButton("Fruit");
        catBtnClicked(fruit, 425, 533, 153, 99, fruitLoc, fruitName, fruitPrice, fruitStock);
        //-------------------------------------------------------------------------
        String[] vegeLoc = {"asparagus.jpg", "broccoli.jpg", "cabbage.jpg", "carrot.jpg", "garlic.jpg", "onion.jpg", "potato.jpg", "pumpkin.jpg", "spinach.jpg", "spring_onion.jpg"};
        String[] vegeName = {"Asparagus", "Broccoli", "Cabbage", "Carrot", "Garlic", "Onion", "Potato", "Pumpkin", "Spinach", "Spring Onion"};
        double[] vegePrice = {240.00, 200.00, 80.00, 100.00, 150.00, 170.00, 110.00, 69.00, 70.00, 180.00};
        int[] vegeStock = {62, 86, 99, 96, 16, 32, 25, 57, 92, 21};
        JButton veggie = new JButton("Vegetables");
        catBtnClicked(veggie, 633, 533, 153, 99, vegeLoc, vegeName, vegePrice, vegeStock);
        //-------------------------------------------------------------------------
    }

    // Function to CREATE product buttons
    private void createProductButtons() {
        for (int i = 0; i <= 9; i++) {
            int x, y;
            int index = i;
            
            // Calculate the x and y coordinates
            if (i <= 4) {
                x = 10 + (i * 161);
                y = 183;
            } else {
                x = 10 +((i-5) * 161);
                y = 438;
            }
            
            JButton btn = new JButton();
            btn.setBounds(x, y, 120, 22);
            btn.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent evt) {
                    tblShoppingCart.addItem(productsShown.get(index), pricesShown.get(index), stocksShown.get(index));
                }
            });
            btn.setVisible(false);
            productPanel.add(btn);
        }
    }
    
    // Function to UPDATE product buttons
    private void updateProductButtons(String[] prodName, double[] price, int[] stock) {
        for (int i = 0; i < prodName.length; i++) {
            productsShown.set(i, prodName[i]);
            pricesShown.set(i, price[i]);
            stocksShown.set(i, stock[i]);
            
            JButton btn = (JButton) productPanel.getComponent(i);
            btn.setText(prodName[i]);
            btn.setVisible(true);
        }
    }
    
    
    private void createImages() {
        for (int i = 0; i <= 9; i++) {
            int x, y;
            
            if (i <= 4) {
                x = 10 + (i * 161);
                y = 36;
            } else {
                x = 10 +((i-5) * 161);
                y = 291;
            }
            
            JLabel lbl = new JLabel();
            lbl.setSize(120, 120);
            lbl.setBounds(x, y, 120,120);
            productPanel.add(lbl);
    	}
    }
    
    private void updateImages(String[] prodLoc) {
        for (int i = 0; i < prodLoc.length; i++) {
            JLabel lbl = (JLabel) productPanel.getComponent(i + 10);
            
            ImageIcon imageIcon = new ImageIcon(prodLoc[i]);
            Image img = imageIcon.getImage();
            
            Image scaledImage = img.getScaledInstance(lbl.getWidth(), lbl.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(scaledImage);
            
            lbl.setIcon(scaledIcon);
        }
    }

    // THIS IS ONLY FOR CATEGORY BUTTONS
    private void catBtnClicked(JButton button, int x, int y, int width, int height, String[] fileLoc, String[] prodName, double[] price, int[] stock) {
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	productPanel.remove(lblJIM);
                ProductDisplay products = new ProductDisplay();
                products.category(productPanel, price, stock);
                updateProductButtons(prodName, price, stock);
                updateImages(fileLoc);
            }
        });
        button.setBounds(x, y, width, height);
        frmGroceryPos.getContentPane().add(button);
    }
}
