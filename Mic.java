//CENG497 LAB4
//Ecem Emiroðlu
//201611018

import java.awt.*;
import java.awt.event.*;



public class Mic extends Frame implements ActionListener,MouseListener{
	 static final int windowWidth = 800;
	 static final int windowHeight = 800;
	 int x = 250;
	 int y = 300;
	 int r0=5;
	 int dx = 300;
	 int dy = 300;
	 public static void main(String[] args) {
	 Mic mic =new Mic();
	 mic.setSize(windowWidth,windowHeight);
	 mic.setVisible(true);
	 mic.setBackground(Color.red);
	 }
	 public Mic() {
	 addWindowListener(new MyFinishWindow());
	 setTitle("Mickey");
	 
	 
	//menu kýsmý:
			MenuBar menu_bar = new MenuBar();
				
			Menu def = new Menu("File");
			def.add(new MenuItem("Set Default"));
			def.addActionListener(this);
			
			
			menu_bar.add(def);
			setMenuBar(menu_bar);
			//https://www.javatpoint.com/java-awt-panel
	        Panel panel=new Panel();  
	        panel.setBounds(0,40,windowWidth ,40);  
			
	        //https://beginnersbook.com/2015/06/java-awt-tutorial/
			Button button_s = new Button();
			button_s.setLabel("Smaller");
			button_s.addActionListener(this);
			Button button_b = new Button();
			button_b.addActionListener(this);
			button_b.setLabel("Bigger");
			
			panel.add(button_s);
			panel.add(button_b);
			
			panel.setBackground(Color.black); 
			
			add(panel);
			setLayout(null);
			//addWindowListener(new MyFinishWindow());
			addMouseListener(this);
	 // create menu
	 // end program when window is closed
	 // add mouse event handler
	 // set layout
	 // add control panel
	 // add buttons
	 }
	 public void paint(Graphics g) {
		 //ifler koyarak büyük küçük set default ve hareket algýlayacak
		 Graphics2D g2d = (Graphics2D) g;
		 
		 drawCircle(g2d,(dx-8*r0),(dy-8*r0),3*r0);
		 drawCircle(g2d,dx,dy,9*r0);
		 drawCircle(g2d,(dx+8*r0),(dy-8*r0),3*r0);
		 
		 
			
		/*	drawCircle(g2d,x+(dx-160),y+(dy-100),40);
			drawCircle(g2d,x+dx,y+dy,150);
			drawCircle(g2d,x+(dx+160),y+(dy-100),40);*/
			/*drawCircle(g2d, x+50,y+50,50);
			drawCircle(g2d, x+200,y+200,100);*/
	 }
	 private void drawCircle(Graphics2D g2d, int x, int y, int r) {
			
			g2d.fillOval(x - r, y - r, 2*r, 2*r);
			
			
		}
	 
	 public class MyFinishWindow extends WindowAdapter
	   {
	     public void windowClosing(WindowEvent e)
	     {
	       System.exit(0);
	     }
	   }

	 public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
			String str = e.getActionCommand();
			//System.out.println(str);
			if(str.equals("Set Default")) {
				r0=5;
				dx=300;
				dy=300;
				repaint();
				
			}
			else if(str.equals("Smaller")) {
				System.out.println("Button 1 clicked.");	
				r0=r0-2;
				repaint();
			}
			else if(str.equals("Bigger")) {

				System.out.println("Button 2 clicked.");	
				r0=r0+2;
				
				repaint();
			}
	 } 
	 
	 public void mouseClicked(MouseEvent e) {
		 	
	        int xe=e.getX();
	        int ye=e.getY();
	        System.out.println(xe);
			System.out.println(ye);
			
			dx=xe;
			dy=ye;
			repaint();

	    }
	 public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
}
