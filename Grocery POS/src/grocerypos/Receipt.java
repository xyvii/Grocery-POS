package grocerypos;

import java.awt.Font;
import javax.swing.*;
import java.awt.*;
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
        itemsPanel.setBounds(10, 187, 360, 220);
        getContentPane().add(itemsPanel);
        itemsPanel.setLayout(null);
        JScrollPane scrollPane = new JScrollPane(data);
        scrollPane.setBounds(0, 0, 360, 220);
        itemsPanel.add(scrollPane);
        totalsPanel.setBounds(10, 418, 360, 117);
        getContentPane().add(totalsPanel);
        totalsPanel.setLayout(null);
        
                
        footerPanel.setBounds(10, 546, 360, 83);
        getContentPane().add(footerPanel);
        
                JLabel thankYou = new JLabel("Thank You! :)");
                thankYou.setBounds(0, 61, 360, 22);
                footerPanel.add(thankYou);
                thankYou.setFont(new Font("Serif", Font.BOLD, 15));
                
                
                        

        setTitle("Receipt");
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(396,679);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    private JLabel createBrake(){
        JLabel brake = new JLabel("  *  *  *  *  *  *  *  *  *  *  *  *  ", SwingConstants.CENTER);
        brake.setFont(new Font("Monospaced", Font.ITALIC, 12));
        return brake;
    }
    
    private void createHeader(){
        String  address = "Lorem ipsum 26, dolor 12";

        //title panel
        titlePanel.setAlignmentX(CENTER_ALIGNMENT);
        titlePanel.setLayout(new GridLayout( 7,  1, 0, -17));
        JLabel shopName = new JLabel("JIM", SwingConstants.CENTER);
        shopName.setFont(new Font("Serif", Font.BOLD, 25));
        shopName.setAlignmentX(CENTER_ALIGNMENT);
        shopName.setHorizontalTextPosition(SwingConstants.CENTER);

        JLabel subName = new JLabel("GROCERY STORE", SwingConstants.CENTER);
        subName.setFont(new Font("Serif", Font.PLAIN, 10));
        JLabel addressLabel = new JLabel("Address: " + address , SwingConstants.CENTER);
        addressLabel.setFont(new Font("Monospaced", Font.ITALIC, 12));
        JLabel phoneLabel = new JLabel("Tel: 0969-420-696", SwingConstants.CENTER);
        phoneLabel.setFont(new Font("Monospaced", Font.ITALIC, 12));

        JLabel cashReceipt = new  JLabel("CASH RECEIPT", SwingConstants.CENTER);
        cashReceipt.setFont(new Font("Monospaced", Font.ITALIC, 15));


        titlePanel.add(shopName);
        titlePanel.add(subName);
        titlePanel.add(addressLabel);
        titlePanel.add(phoneLabel);
        titlePanel.add(createBrake());
        titlePanel.add(cashReceipt);
    }
    
    private void createTotals(JTable data,double cashTendered){
        double total=0;
        int length = data.getRowCount();
        for ( int i = 0; i < length; i ++) {
            total += (double)data.getValueAt(i, 3);
        }

        double change = cashTendered - total;
        
        JLabel totalTitle = new JLabel("Grand Total:   ");
        totalTitle.setBounds(159, 0, 105, 47);
        totalsPanel.add(totalTitle);
        totalTitle.setFont(new Font("Monospaced", Font.ITALIC, 12));
        JLabel t = new JLabel(String.valueOf(total));
        t.setBounds(274, 0, 86, 47);
        totalsPanel.add(t);
        t.setFont(new Font("Serif", Font.BOLD, 20));
        
        JLabel changeTitle = new JLabel("Change:   ");
        changeTitle.setBounds(159, 58, 105, 48);
        totalsPanel.add(changeTitle);
        changeTitle.setFont(new Font("Monospaced", Font.ITALIC, 12));
        JLabel c =new JLabel(String.valueOf(change));
        c.setBounds(274, 58, 86, 48);
        totalsPanel.add(c);
        c.setFont(new Font("Serif", Font.BOLD, 20));
        
        totalsPanel.setAlignmentX(CENTER_ALIGNMENT);
    }
    
    private void createFooter(){
        Random rando = new Random();
        int id = rando.nextInt(999999, 10000000);
        JLabel idCode = new JLabel("Trans.ID: " + String.valueOf(id));
        idCode.setBounds(0, 1, 319, 33);
        idCode.setFont(new Font("Monospaced", Font.PLAIN, 13));

        JLabel dateTime = new JLabel( "Timestamp:  "+String.valueOf(java.time.LocalDateTime.now()));
        dateTime.setBounds(0, 28, 360, 33);
        dateTime.setFont(new Font("Monospaced", Font.PLAIN, 13));

        footerPanel.setAlignmentX(CENTER_ALIGNMENT);
        footerPanel.setLayout(null);
        footerPanel.add(idCode);
        footerPanel.add(dateTime);
    }
}
