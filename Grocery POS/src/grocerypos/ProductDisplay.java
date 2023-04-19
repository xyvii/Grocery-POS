package grocerypos;

import javax.swing.JPanel;

public class ProductDisplay {

	
	public void category(JPanel panel, String[] fileLoc, double[] price) {
		Products prod1 = new Products();
	
		// Make sure to edit the fileLoc on where the image is located in your pc
		prod1.productInfo(panel, "E:\\folder1\\folder2\\folder3\\Grocery POS\\" + fileLoc[0], 10, 36, 11, 40, 159, price[0]);

		//-------------------------------------------------------------------------
		Products prod2 = new Products();
		
		prod2.productInfo(panel, fileLoc[1], 10, 291, 266, 40, 414, price[1]);
	
		//-------------------------------------------------------------------------
		Products prod3 = new Products();
	
		prod3.productInfo(panel, fileLoc[2], 171, 36, 11, 201, 159, price[2]);
	
		//-------------------------------------------------------------------------
		Products prod4 = new Products();
	
		prod4.productInfo(panel, fileLoc[3], 171, 291, 266, 201, 414, price[3]);
	
		//-------------------------------------------------------------------------
		Products prod5 = new Products();
	
		prod5.productInfo(panel, fileLoc[4], 332, 36, 11, 362, 159, price[4]);
	
		//-------------------------------------------------------------------------
		/* x += 161
		 * y += 255 */
		Products prod6 = new Products();

		prod6.productInfo(panel, fileLoc[5], 332, 291, 266, 362, 414, price[5]);

		//-------------------------------------------------------------------------
		Products prod7 = new Products();
	
		prod7.productInfo(panel, fileLoc[6], 493, 36, 11, 523, 159, price[6]);
	
		//-------------------------------------------------------------------------
		Products prod8 = new Products();
	
		prod8.productInfo(panel, fileLoc[7], 493, 291, 266, 523, 414,price[7]);

		//-------------------------------------------------------------------------
		Products prod9 = new Products();
	
		prod9.productInfo(panel, fileLoc[8], 654, 36, 11, 684, 159, price[8]);

		//-------------------------------------------------------------------------
		Products prod10 = new Products();
	
		prod10.productInfo(panel, fileLoc[9], 654, 291, 266, 684, 414, price[9]);		//pr10.productButton("Scallop", 654, 438);
	}
	
}
