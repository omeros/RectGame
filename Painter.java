package SquareGame;
import Algoquest.Bound;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Painter extends JPanel 
{
	private ArrayList<Bound> arrBound;	
    private Color[] arrColors;
    private ArrayList<Integer> arrColorsCreated;	
    private int x ;
    private int _x1;
    private int _x2;
    private int _y1;
    private int _y2;
	private Color color4;
	private Color color3;
	private Color color2;
	private Color color1;
    private int colorCounter;
	private Bound b;
	private boolean finish;
	private Random rand;
	
	// x1= left, x2= rigth, y1= buttom, y2= top
	public Painter( int x1, int x2, int y1, int y2)
	{
		colorCounter=150;
		arrBound = new ArrayList<Bound>();
		arrColorsCreated = new ArrayList<Integer>();
		color1 = new Color(0,130,190);//,200);      //Blue
		color2 = new Color(90,colorCounter,50);//,200);     //green  or yellow
		color3 = new Color(0,0,0,200);         //  Color.black;                //black
		color4= Color.red;
		_x1=x1; 
		_x2=x2;
		_y1=y1;
		_y2=y2;	
		finish= false;
		colorCounter++;
		arrColors = new Color[12];
		int i;
	
			 arrColors[0]=Color.cyan;
			 arrColors[1]= new Color(166,166,166);
			 arrColors[2]=Color.green;
			 arrColors[3]=Color.red;
			 arrColors[4]=Color.DARK_GRAY;
			 arrColors[5]=Color.YELLOW;
			 arrColors[6]=Color.PINK;
			 arrColors[7]=Color.ORANGE;
			 arrColors[8]=new Color(100,0,130);
			 arrColors[9]=Color.magenta;
			 arrColors[10]=Color.BLUE;
			 arrColors[11]=Color.WHITE;
			 
		  rand = new Random();
		
	}
	public void updateParameters( int x1, int x2, int y1, int y2)
	{
		b = new Bound(x1,x2,y2,y1);
		if (!arrBound.isEmpty()) {
			arrBound.set(0,b);
		}else {
			arrBound.add(b);
		}
	}
	
	public Object[] getArr(){
		if (arrBound!=null)
		{
		     Object[] b=arrBound.toArray();
		//     Bound[] bond = (Bound[])b;
		     return b;
		}
		return null;	
	}
	 //        y2 = Top   ,   y1 =  Bottom
	public void addBound(int x1,int x2, int y1, int y2)
	{
	    Bound b = new Bound (x1,x2,y2,y1);
		arrBound.add(b);
		int x = rand.nextInt(12); 
		boolean isAdded = arrColorsCreated.add(x);

	}
	public void add( Bound b)
	{
		arrBound.add(b);
	}
	public void clear()  // clears the drawing area
	{
		arrBound.clear();
		arrColorsCreated.clear();
		
	}
	public void finish(){
		
		finish=true;
	}
	public void started()
	{
		finish=false;
	}
		public void paintComponent(Graphics g)
		{
		   super.paintComponent(g); 
		   Graphics2D g2d = (Graphics2D) g;
	
		      int i;
		      int L;
		      int R;
		      int T;
		      int B;	
		      g.setColor(color1); 
		      //Fills the specified rectangle.
		      for (i=0;i<arrBound.size();i++) {  	
		    	 L=(int)arrBound.get(i).getLeft();         
		    	 R=(int)arrBound.get(i).getRight(); 
		    	 T=(int)arrBound.get(i).getTop();
		    	 B=(int)arrBound.get(i).getBottom();
		    	 
		    	 if(finish) {  // *******************    finish Flag in On ! *******************************
		    		  
		    			 if (i==0) {
				   		  g.setColor(color1); 
				    	  g.fillRect(L,B,R-L,T-B);  
				    	  g.setColor(Color.black);
				    	  g.drawRect(L,B,R-L,T-B);
				    	 }
		    		  
		    		 if (i==(arrBound.size()-1)&&(i>0) )      //  print the Answer - theMax Bound..
		    		 {
		      			 g.setColor(color3); 
		      		     Stroke stroke1 = new BasicStroke(6f);
		      		     
		      		     float[] dashingPattern2 = {30f, 10f};
		      		     Stroke stroke3 = new BasicStroke(5f, BasicStroke.CAP_BUTT,
		      		         BasicStroke.JOIN_MITER, 1.0f, dashingPattern2, 10.0f);
		                 g2d.setStroke(stroke3);
		    			 g2d.drawRect(L,B,R-L,T-B);      
		    
		    		 }else  if (i<(arrBound.size()-1)&&(i>0) )  {
		    	      // x = rand.nextInt(12);
		    			 int x =  arrColorsCreated.get(i-1);
		    			 System.out.println(" ");
		    			// System.out.println(" i  :  " + i);
		    			 //System.out.println(" arrBound.size()  :  "  + arrBound.size());
		    			 color2 = arrColors[x];             		    			
		    			 g.setColor(color2); 
		    			 g.fillRect(L,B,R-L,T-B);
		    			 g.setColor(Color.black);
			    		 g.drawRect(L,B,R-L,T-B);
		    		 }
		    	 
		      }else {               //********************** not finish yet  *****************
		    	  if (i==0)
		    	  {
		    		  g.setColor(color1); 
			    	  g.fillRect(L,B,R-L,T-B);
			    	  g.setColor(Color.black);
			    	  g.drawRect(L,B,R-L,T-B);
	
		    	  }
			    	 else {
		    		
			          // int x = rand.nextInt(12);
			    	     int x = arrColorsCreated.get(i-1);
		    			 color2 = arrColors[x]; 
		    			 g.setColor(color2);
			    		 g.fillRect(L,B,R-L,T-B);
			    		 g.setColor(Color.black);
			    		 g.drawRect(L,B,R-L,T-B);
		
			    	 }
		    	  
		      }
		    	 
		    	 
		      }
		      
		
		} 
}

