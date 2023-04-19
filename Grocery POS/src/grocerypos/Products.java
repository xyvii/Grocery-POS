package grocerypos;

import java.awt.Component;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

public class Products {

	ImageIcon imageIcon;
	JButton button;
	
	private void image(String fileLoc, JPanel panel, int x, int y) {
		this.imageIcon = new ImageIcon(fileLoc);
		Image img = imageIcon.getImage();
		
		JLabel label = new JLabel();
		label.setSize(120, 120);
		
		Image scaledImage = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(scaledImage);
		
		label.setIcon(scaledIcon);
		label.setBounds(x, y, 120,120);

		panel.add(label);
	}
	private void stock(JPanel panel, int x, int y) {
		int stocks = 20;
		
		JTextPane stockPane = new JTextPane();
		stockPane.setText("Stocks: " + stocks);
		stockPane.setEditable(false);
		stockPane.setBounds(x, y, 120, 22);
		panel.add(stockPane);
	}
	private void price(String price, JPanel panel, int x, int y) {
		JTextPane product = new JTextPane();
		product.setText(price);
		product.setEditable(false);
		product.setBounds(x, y, 50, 22);
		panel.add(product);
	}
	
	public void productInfo(JPanel panel, String fileLoc, int xImgStk, int yImg, int yStk, int xPrc, int yPrc, double price) {
		
		image(fileLoc, panel, xImgStk, yImg);
		stock(panel, xImgStk, yStk);

		price("₱ " + price, panel, xPrc, yPrc);
	}
	
	

}
