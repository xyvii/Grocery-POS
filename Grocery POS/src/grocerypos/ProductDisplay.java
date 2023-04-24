package grocerypos;

import javax.swing.JPanel;

public class ProductDisplay {

	// Creation of products
    public void category(JPanel panel, double[] price, int[] stock) {
        Products prod1 = new Products();
        prod1.productInfo(panel, 10, 36, 11, 40, 159, price[0], stock[0]);

        //-------------------------------------------------------------------------
        Products prod2 = new Products();
        prod2.productInfo(panel, 171, 36, 11, 201, 159, price[1], stock[1]);

        //-------------------------------------------------------------------------
        Products prod3 = new Products();
        prod3.productInfo(panel, 332, 36, 11, 362, 159, price[2], stock[2]);

        //-------------------------------------------------------------------------
        Products prod4 = new Products();
        prod4.productInfo(panel, 493, 36, 11, 523, 159, price[3], stock[3]);

        //-------------------------------------------------------------------------
        Products prod5 = new Products();
        prod5.productInfo(panel,  654, 36, 11, 684, 159, price[4], stock[4]);

        //-------------------------------------------------------------------------
        Products prod6 = new Products();
        prod6.productInfo(panel, 10, 291, 266, 40, 414, price[5], stock[5]);

        //-------------------------------------------------------------------------
        Products prod7 = new Products();
        prod7.productInfo(panel, 171, 291, 266, 201, 414, price[6], stock[6]);

        //-------------------------------------------------------------------------
        Products prod8 = new Products();
        prod8.productInfo(panel, 332, 291, 266, 362, 414,price[7], stock[7]);

        //-------------------------------------------------------------------------
        Products prod9 = new Products();
        prod9.productInfo(panel, 493, 291, 266, 523, 414, price[8], stock[8]);

        //-------------------------------------------------------------------------
        Products prod10 = new Products();
        prod10.productInfo(panel, 654, 291, 266, 684, 414, price[9], stock[9]);
    }
}
