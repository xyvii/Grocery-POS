package grocerypos;

import java.awt.Font;
import javax.swing.*;
import java.util.Random;

import javax.swing.SwingConstants;

public class Receipt extends JFrame {
        private JPanel titlePanel =  new JPanel();
        private JPanel itemsPanel = new JPanel();
        private JPanel totalsPanel = new JPanel();
        private JPanel footerPanel = new JPanel();

    public Receipt(JTable data, double cashTendered) {
        createHeader();
        createTotals(data, cashTendered);
        createFooter();
        getContentPane().setLayout(null);
        titlePanel.setBounds(10, 11, 360, 170);
        getContentPane().add(titlePanel);
        
        JLabel brake = new JLabel("  *  *  *  *  *  *  *  *  *  *  *  *  ", SwingConstants.CENTER);
        brake.setFont(new Font("Monospaced", Font.ITALIC, 12));
        brake.setBounds(0, 132, 360, 38);
        titlePanel.add(brake);
        itemsPanel.setBounds(10, 187, 360, 220);
        getContentPane().add(itemsPanel);
        itemsPanel.setLayout(null);
        JScrollPane scrollPane = new JScrollPane(data);
        scrollPane.setBounds(0, 0, 360, 220);
        itemsPanel.add(scrollPane);
        totalsPanel.setBounds(10, 418, 360, 117);
        getContentPane().add(totalsPanel);
        totalsPanel.setLayout(null);
        
        JLabel brake_1 = new JLabel("  *  *  *  *  *  *  *  *  *  *  *  *  ", SwingConstants.CENTER);
        brake_1.setFont(new Font("Monospaced", Font.ITALIC, 12));
        brake_1.setBounds(0, 0, 360, 29);
        totalsPanel.add(brake_1);
        
        // Set the editable column to false
        data.setEnabled(false);
        
        footerPanel.setBounds(10, 546, 360, 110);
        getContentPane().add(footerPanel);
        
        JLabel thankYou = new JLabel("Thank You! :)");
        thankYou.setHorizontalAlignment(SwingConstants.CENTER);
        thankYou.setBounds(0, 88, 360, 22);
        footerPanel.add(thankYou);
        thankYou.setFont(new Font("Serif", Font.BOLD, 15));
        
        JLabel thankYouBreak = new JLabel("  *  *  *  *  *  *  *  *  *  *  *  *  ", SwingConstants.CENTER);
        thankYouBreak.setFont(new Font("Monospaced", Font.ITALIC, 12));
        thankYouBreak.setBounds(0, 0, 360, 29);
        footerPanel.add(thankYouBreak);      
                        
        
        
        setTitle("Receipt");
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(396,706);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    // Create a divider
    private JLabel createBrake(){
        JLabel brake = new JLabel("  *  *  *  *  *  *  *  *  *  *  *  *  ", SwingConstants.CENTER);
        brake.setBounds(0, 87, 360, 38);
        brake.setFont(new Font("Monospaced", Font.ITALIC, 12));
        return brake;
    }
    
    // Creation of the header of the receipt
    private void createHeader(){
        String  address = "Lorem ipsum 26, dolor 12";

        //title panel
        titlePanel.setAlignmentX(CENTER_ALIGNMENT);
        JLabel shopName = new JLabel("JIM", SwingConstants.CENTER);
        shopName.setBounds(0, 3, 360, 38);
        shopName.setFont(new Font("Serif", Font.BOLD, 25));
        shopName.setAlignmentX(CENTER_ALIGNMENT);
        shopName.setHorizontalTextPosition(SwingConstants.CENTER);

        JLabel subName = new JLabel("GROCERY STORE", SwingConstants.CENTER);
        subName.setBounds(0, 24, 360, 38);
        subName.setFont(new Font("Serif", Font.PLAIN, 10));
        JLabel addressLabel = new JLabel("Address: " + address , SwingConstants.CENTER);
        addressLabel.setBounds(0, 45, 360, 38);
        addressLabel.setFont(new Font("Monospaced", Font.ITALIC, 12));
        JLabel phoneLabel = new JLabel("Tel: 0969-420-696", SwingConstants.CENTER);
        phoneLabel.setBounds(0, 66, 360, 38);
        phoneLabel.setFont(new Font("Monospaced", Font.ITALIC, 12));

        JLabel cashReceipt = new  JLabel("CASH RECEIPT", SwingConstants.CENTER);
        cashReceipt.setBounds(0, 108, 360, 38);
        cashReceipt.setFont(new Font("Monospaced", Font.ITALIC, 15));
        titlePanel.setLayout(null);

        titlePanel.add(shopName);
        titlePanel.add(subName);
        titlePanel.add(addressLabel);
        titlePanel.add(phoneLabel);
        titlePanel.add(createBrake());
        titlePanel.add(cashReceipt);
    }
    
    // Get the total value of the prices of the products
    private void createTotals(JTable data,double cashTendered){
        double total=0;
        int length = data.getRowCount();
        for ( int i = 0; i < length; i ++) {
            total += (double)data.getValueAt(i, 3);
        }

        double change = cashTendered - total;
        
        // Making and setting the necessary JLabels
        JLabel totalTitle = new JLabel("Grand Total:   ");
        totalTitle.setBounds(0, 22, 105, 47);
        totalsPanel.add(totalTitle);
        totalTitle.setFont(new Font("Monospaced", Font.ITALIC, 12));
        JLabel t = new JLabel("PHP " + String.valueOf(total));
        t.setHorizontalAlignment(SwingConstants.RIGHT);
        t.setBounds(115, 19, 245, 47);
        totalsPanel.add(t);
        t.setFont(new Font("Serif", Font.BOLD, 20));
        
        JLabel changeTitle = new JLabel("Change:   ");
        changeTitle.setBounds(0, 69, 105, 48);
        totalsPanel.add(changeTitle);
        changeTitle.setFont(new Font("Monospaced", Font.ITALIC, 12));
        JLabel c =new JLabel("PHP " + String.valueOf(change));
        c.setHorizontalAlignment(SwingConstants.RIGHT);
        c.setBounds(115, 66, 245, 48);
        totalsPanel.add(c);
        c.setFont(new Font("Serif", Font.BOLD, 20));
        
        totalsPanel.setAlignmentX(CENTER_ALIGNMENT);
    }
    
    // Create footer of the receipt
    private void createFooter(){
        Random rando = new Random();
        int id = rando.nextInt(999999, 10000000);
        JLabel idCode = new JLabel("Trans.ID: " + String.valueOf(id));
        idCode.setHorizontalAlignment(SwingConstants.CENTER);
        idCode.setBounds(0, 28, 360, 33);
        idCode.setFont(new Font("Monospaced", Font.PLAIN, 13));

        JLabel dateTime = new JLabel( "Timestamp:  "+ String.valueOf(java.time.LocalDateTime.now()));
        dateTime.setHorizontalAlignment(SwingConstants.CENTER);
        dateTime.setBounds(0, 55, 360, 33);
        dateTime.setFont(new Font("Monospaced", Font.PLAIN, 13));

        footerPanel.setAlignmentX(CENTER_ALIGNMENT);
        footerPanel.setLayout(null);
        footerPanel.add(idCode);
        footerPanel.add(dateTime);
    }
}
