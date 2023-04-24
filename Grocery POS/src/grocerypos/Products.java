package grocerypos;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextPane;

public class Products {

    ImageIcon imageIcon;
    JButton button;

    // Make text pane for stocks
    private void stock(JPanel panel, int stock, int x, int y) {
        JTextPane stockPane = new JTextPane();
        stockPane.setText("Stocks: " + stock);
        stockPane.setEditable(false);
        stockPane.setBounds(x, y, 120, 22);
        panel.add(stockPane);
    }
    // Make text pane for price
    private void price(String price, JPanel panel, int x, int y) {
        JTextPane product = new JTextPane();
        product.setText(price);
        product.setEditable(false);
        product.setBounds(x, y, 50, 22);
        panel.add(product);
    }

    // Creation stock and price
    public void productInfo(JPanel panel, int xImgStk, int yImg, int yStk, int xPrc, int yPrc, double price, int stock) {
        stock(panel, stock, xImgStk, yStk);

        price("₱ " + price, panel, xPrc, yPrc);
    }
}
