package SquareGame;
import Algoquest.Bound;


import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Painter extends JPanel 
{
	private ArrayList<Bound> arrBound;	
    private Color[] arrColors;
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
		arrColors = new Color[10];
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
//		arrBound.get(0).setLeft(x1);
//		arrBound.get(0).setRight(x2);
//		arrBound.get(0).setTop(y2);
//		arrBound.get(0).setBottom(y1);	
	}
	
	public Object[] getArr()
	{
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

	}
	public void add( Bound b)
	{
		arrBound.add(b);
	}
	public void clear()  // clears dra wing area
	{
		arrBound.clear();
		
	}
	public void finish()
	{
		
		finish=true;
	}
	public void started()
	{
		finish=false;
	}
		public void paintComponent(Graphics g)
		{
		   super.paintComponent(g); 
	
		      int i;
		      int L;
		      int R;
		      int T;
		      int B;	
		      g.setColor(color1); 
		      //Fills the specified rectangle.
		      for (i=0;i<arrBound.size();i++)
		      {
		    	 // System.out.println("the index is : "+ i);
		    	 L=(int)arrBound.get(i).getLeft();         //<<***** Error ********
		    	 R=(int)arrBound.get(i).getRight(); 
		    	 T=(int)arrBound.get(i).getTop();
		    	 B=(int)arrBound.get(i).getBottom();
		    	 
		    	 if(finish) {  // *******************    finish Flag in On ! *******************************
		    		//  System.out.println("the index  after finish is : "+ i);
		    		  
		    			 if (i==0) {
				    	//	 System.out.println("L" +L+ " R"+R+" T"+T+" B"+B);
			    		  g.setColor(color1); 
				    	  g.fillRect(L,B,R-L,T-B);  
				    //	  System.out.println("the index inside finish  (i=0): "+ i);
				    	 }
		    		  
		    		 if (i==(arrBound.size()-1)&&(i>0) )      //  print the Answer - theMax Bound..
		    		 {
		    		//	 System.out.println("the size of the array is : "+ arrBound.size());
				    //	  System.out.println("the index inside finish  (i=2): "+ i);

		    			 g.setColor(color3); 
		    			 g.fillRect(L,B,R-L,T-B);      
		    			 g.setColor(color1); 
		    			int A=(R-L)/50 ;
		    			 g.fillRect(L+A,B+A,R-L-(10+A),T-B-(10+A));   

		    		//	 System.out.println("L" +L+ " R"+R+" T"+T+" B"+B);
		    		 }else  if (i<(arrBound.size()-1)&&(i>0) ) 
		    		 {
		    			  x = rand.nextInt(10);
		    			 color2 =arrColors[x];              //new Color(90,colorCounter,50);		    			
		    			 g.setColor(color2); 
		    			 g.fillRect(L,B,R-L,T-B);
		    		//	 colorCounter++;
		    	//	 System.out.println("L" +L+ " R"+R+" T"+T+" B"+B);
		    	//	 System.out.println("the index inside finish  (i=1): "+ i);	    		 
		    		 }
		    	 
		      }else {               //********************** not finish yet  *****************
		    	  if (i==0)
		    	  {
		    		  g.setColor(color1); 
			    	  g.fillRect(L,B,R-L,T-B);
		    //	  System.out.println("L" +L+ " R"+R+" T"+T+" B"+B);
		    //	  System.out.println("the index outer finish  (i=0): "+ i);
		    	  }
			    	 else {
		    			// color2 = new Color(90, colorCounter,50);
			    		 int x = rand.nextInt(10);
		    			 color2 =arrColors[x]; 
		    			 g.setColor(color2);
		    		//	 colorCounter++;			    		 
			    		 g.fillRect(L,B,R-L,T-B);
			    //		 System.out.println("the index outer finish  (i>0): "+ i);
			    //		 System.out.println("L" +L+ " R"+R+" T"+T+" B"+B);
			    	 }
		    	  
		      }
		    	 
		    	 
		      }
		      
		  //   g.fillRect(150,200,400,250);    // big rectangle
		     // g.setColor(color2);
		    //  g.fillRect(120,300,100,50);   // small rectangle    
		} 
}

