import java.awt.Color;


public class L32 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Picture dol = new Picture("dolphin_swimming.jpg");

		//determine coordinates
		
//		for(int x = 100;x<125;x++){
//			for(int y = 100; y<125;y++){
//				dol.setColor(x,y,0,0,0);
//			}
//		}
//		
//		for(int x = 200; x < 205; x++){
//			for(int y = 100; y < 105; y++){
//				dol.setColor(x, y, 0, 0, 0);
//			}
//		}
//
//		for(int x = 600;x<625;x++){
//			for(int y = 600; y<625;y++){
//				dol.setColor(x,y,0,0,0);
//			}
//		}
		Color c1 = dol.get(106,100);
		Color c2 = dol.get(108,100);
		Color c3 = dol.get(606,600);
		
		int r1 = c1.getRed();
		int g1 = c1.getGreen();
		int b1 = c1.getBlue();
		int r2 = c2.getRed();
		int g2 = c2.getGreen();
		int b2 = c2.getBlue();
		int r3 = c3.getRed();
		int g3 = c3.getGreen();
		int b3 = c3.getBlue();
		
		double dist1 = Math.sqrt(Math.pow(r1-r2, 2)+Math.pow(g1-g2, 2)+Math.pow(b1-b2, 2));
		System.out.println(dist1);
		double dist2 = Math.sqrt(Math.pow(r1-r3, 2)+Math.pow(g1-g3, 2)+Math.pow(b1-b3, 2));
		System.out.println(dist2);
		
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);


		dol.show();
	}

}
