package grocerypos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class Cart extends JTable {
    private JLabel lblCart;
    private JLabel lblTotal;
    private JLabel lblCash;
    private JLabel lblTotalAmount;
    private JTextField fldCashAmount;
    private JButton btnCheckout;
    private ArrayList<String> productsInCart = new ArrayList<>();
    private ArrayList<Integer> stocksInCart = new ArrayList<>();
    
    public Cart(JPanel orderPanel) {
        setModel(new DefaultTableModel(
            new Object [] [] {},
            new String [] {"Product", "Quantity", "Price", "Amount"})
        {
        @Override
        public boolean isCellEditable(int row, int column) {
            // Make only the "Quantity" column editable
            return column == 1;
        }});
        
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        
        getTableHeader().setResizingAllowed(false);
        getTableHeader().setReorderingAllowed(false);
        getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        getColumnModel().getColumn(2).setCellRenderer(rightRenderer);
        getColumnModel().getColumn(3).setCellRenderer(rightRenderer);
        
        getModel().addTableModelListener(new TableModelListener() {
            public void tableChanged(TableModelEvent evt) {
                tblShoppingCartChanged(evt);
            }
        });
        this.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblShoppingCartKeyPressed(evt);
            }
        });

        createComponents(orderPanel);
    }
    
    // Creation of cart-related components
    private void createComponents(JPanel orderPanel) {
        lblCart = new JLabel("Cart");
        lblCart.setFont(new java.awt.Font("Segoe UI", 1, 18));
        lblCart.setBounds(5, 0, 261, 30);
        orderPanel.add(lblCart);
        
        lblTotal = new JLabel("Total:");
        lblTotal.setFont(new java.awt.Font("Segoe UI", 1, 14));
        lblTotal.setBounds(5, 530, 261, 20);
        orderPanel.add(lblTotal);
        
        lblCash = new JLabel("Cash Tendered:");
        lblCash.setFont(new java.awt.Font("Segoe UI", 1, 14));
        lblCash.setBounds(5, 570, 261, 20);
        orderPanel.add(lblCash);
        
        lblTotalAmount = new JLabel("PHP 0.00");
        lblTotalAmount.setFont(new java.awt.Font("Segoe UI", 1, 14));
        lblTotalAmount.setBounds(5, 530, 270, 20);
        lblTotalAmount.setHorizontalAlignment(SwingConstants.RIGHT);
        orderPanel.add(lblTotalAmount);
        
        fldCashAmount = new JTextField();
        fldCashAmount.setFont(new java.awt.Font("Segoe UI", 1, 14));
        fldCashAmount.setBounds(199, 570, 80, 20);
        fldCashAmount.setHorizontalAlignment(SwingConstants.CENTER);
        orderPanel.add(fldCashAmount);
        
        btnCheckout = new JButton("Checkout");
        btnCheckout.setBounds(10, 623, 261, 23);
        btnCheckout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnCheckoutActionPerformed(evt);
            }
        });
        orderPanel.add(btnCheckout);
    }
    
    // For faster item deletion
    private void tblShoppingCartKeyPressed(KeyEvent evt) {
        if(evt.getKeyCode() == KeyEvent.VK_DELETE){
            DefaultTableModel model = (DefaultTableModel) getModel();
            int selectedRow = getSelectedRow();
            if (selectedRow != -1) {
                model.removeRow(selectedRow);
            }
        }
        updateTotalPrice();
    }
    
    // Detects when quantity has been edited and updates the table accordingly
    private void tblShoppingCartChanged(TableModelEvent evt) {
        if (evt.getType() == TableModelEvent.UPDATE && evt.getColumn() == 1) {
            int row = evt.getFirstRow();
            String qtyInput = getModel().getValueAt(row, 1).toString();
            String itemName = getModel().getValueAt(row, 0).toString();
            int stock = getStockForItem(itemName);
            
            try {
                int newQuantity = Integer.parseInt(qtyInput);
                double price = Double.parseDouble(getModel().getValueAt(row, 2).toString());
                
                // Checks for valid inputs
                if (newQuantity < 0) {
                    JOptionPane.showMessageDialog(this, "Quantity cannot be negative.", "Invalid Quantity", JOptionPane.WARNING_MESSAGE);
                    getModel().setValueAt(1, row, 1);
                } else if (newQuantity == 0) {
                    ((DefaultTableModel) getModel()).removeRow(row);
                // For stock restrictions
                } else if (newQuantity > stock) {
                    JOptionPane.showMessageDialog(this, "Insufficient stock.", "Out of Stock", JOptionPane.WARNING_MESSAGE);
                    getModel().setValueAt(stock, row, 1);
                    getModel().setValueAt(price * stock, row, 3);
                } else {
                    getModel().setValueAt(price * newQuantity, row, 3);
                }
                updateTotalPrice();
                
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter a valid quantity.");
            }
        }
    }
    
    // Adding items to the cart
    public void addItem(String name, double price, int stock) {
        DefaultTableModel model = (DefaultTableModel) getModel();
        boolean itemFound = false;
        
        // Check if item already exists
        for (int row = 0; row < model.getRowCount(); row++) {
            String itemName = (String) model.getValueAt(row, 0);
            int quantity = Integer.parseInt(model.getValueAt(row, 1).toString());
           
            if (name.equals(itemName)) {
                // Check if there is enough stock to add the item
                if (stock >= quantity + 1) {
                    model.setValueAt(quantity + 1, row, 1);
                    double total = (quantity + 1) * price;
                    model.setValueAt(total, row, 3);
                    itemFound = true;
                    break;
                } else {
                    JOptionPane.showMessageDialog(this, "Sorry, the maximum available stock for this product has been reached.");
                    return;
                }
            }
        }
        // If item is not found, add a new row
        if (!itemFound) {
            productsInCart.add(name);
            stocksInCart.add(stock);
            model.addRow(new Object[] {
                name, "1", price, price
            });
        }
        updateTotalPrice();
    }
    
    // Get the value of stock
    private int getStockForItem(String itemName) {
        for (int i = 0; i < productsInCart.size(); i++) {
            if (productsInCart.get(i).equals(itemName))
                return stocksInCart.get(i);
        }
        return 0;
    }
    
    // Get the total cost of all the items
    private double getTotalCost() {
        double totalCost = 0.00;
        for (int i = 0; i < getRowCount(); i++) {
            totalCost = totalCost + Double.parseDouble(getValueAt(i, 3).toString());
        }     
        return totalCost;
    }
    
    // Updates total price label
    private void updateTotalPrice() {
        DecimalFormat df = new DecimalFormat("0.00");
        double total = getTotalCost();
        lblTotalAmount.setText("PHP " + df.format(total));
    }
    
    // Checkout button pressed
    private void btnCheckoutActionPerformed(ActionEvent evt) {
        
        if (this.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Shopping cart is empty. Please add items to the cart before checking out.", "Empty Shopping Cart", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try {
            double cashTendered = Double.parseDouble(fldCashAmount.getText());
            
            if (cashTendered < getTotalCost()) {
                JOptionPane.showMessageDialog(null, "Payment is insufficient. Please enter a higher amount.", "Insufficient Payment", JOptionPane.ERROR_MESSAGE);
                return;
            }
               
            // If all conditions are met, show receipt
            Receipt r = new Receipt(this, cashTendered);
            
            
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number for cash tendered.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        }
    }

    
}
