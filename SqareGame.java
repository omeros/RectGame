package SquareGame;

import Algoquest.Algoquest;
import Algoquest.Bound;
import Algoquest.BoundList;
import Algoquest.BoundNode;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class SqareGame  extends JFrame //Throws IOException
{
	private JPanel panel1;
	private Painter panel2;
	private Painter panel3;
	private JPanel panel4;

	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	private JLabel label5;
	
	private JLabel label6;
	private JLabel label7;
	private JLabel label8;
	private JLabel label9;
	private JLabel label10;

	private  JTextField textField1;	
	private  JTextField textField2;	
	private  JTextField textField3;	
	private  JTextField textField4;		
	private  JTextField textField5;	
	private  JTextField textField6;	
	private  JTextField textField7;	
	private  JTextField textField8;	
	private BorderLayout layout;
	private GridBagLayout grid;
	private GridBagConstraints g;
    private JButton add;
    private JButton add2;  
    private JButton clear;     
    private JButton max;  
    private JButton random;
    private JButton exit;




	
	public SqareGame()
	{
		layout = new BorderLayout();
		grid = new GridBagLayout();
		g = new GridBagConstraints();
		
		setLayout(layout); 
		panel1 = new JPanel();
		panel4 = new JPanel();

		panel2 = new Painter(100,500,200,400);
		panel1.setBackground(Color.gray);
		Icon img2 = new ImageIcon("C:/util/plus2.png");
		Icon img3 = new ImageIcon("C:/util/ok5.png");	
		Icon img4 = new ImageIcon("C:/util/exit6.png");
		Icon img5 = new ImageIcon("C:/util/new3.png");
		Icon img6 = new ImageIcon("C:/util/random.png");

		add= new JButton( img2 );
		add2= new JButton( img2 );
		clear= new JButton(img5);
		max= new JButton(img3);
		random= new JButton(img6);
		exit= new JButton(img4);


		
		textField1 = new JTextField(5);
		textField2 = new JTextField(5);
		textField3 = new JTextField(5);
		textField4 = new JTextField(5);
		textField5 = new JTextField(5);
		textField6 = new JTextField(5);
		textField7 = new JTextField(5);
		textField8 = new JTextField(5);
				
		label1 = new JLabel("x1  ");
		label2 = new JLabel("  x2");
		label3 = new JLabel("  y1");
		label4 = new JLabel("  y2");
		label5 = new JLabel(" add Big Square ");
		
		label6 = new JLabel("x1  ");
		label7 = new JLabel("  x2");
		label8 = new JLabel("  y1");
		label9 = new JLabel("  y2");
		label10 = new JLabel("  add Small Square  ");
		
    	panel1.setLayout(grid);
    	g.weightx=0;
		g.weighty=0;
		
		g.gridx=0;
		g.gridy=0;
		
		panel1.add(label1,g);		
		g.gridx=1;
		g.gridy=0;					
		panel1.add(textField1,g);
		
				
		g.gridx=2;
		panel1.add(label2,g);
		g.gridx=3;
		panel1.add(textField2,g);		
		
		g.gridx=4;
		panel1.add(label3,g);
		g.gridx=5;
		panel1.add(textField3,g);

		g.gridx=6;
		panel1.add(label4,g);
		g.gridx=7;
		panel1.add(textField4,g);
		g.gridx=8;
		panel1.add(label5,g);
		g.gridx=9;
		panel1.add(add,g);
		
		
		g.gridx=0;
		g.gridy=1;					
		panel1.add(label6,g);		
		g.gridx=1;
		g.gridy=1;
		panel1.add(textField5,g);
		
		g.gridx=2;
		g.gridy=1;					
		panel1.add(label7,g);		
		g.gridx=3;
		g.gridy=1;
		panel1.add(textField6,g);
		
		g.gridx=4;
		g.gridy=1;					
		panel1.add(label8,g);		
		g.gridx=5;
		g.gridy=1;
		panel1.add(textField7,g);
		
		g.gridx=6;
		g.gridy=1;					
		panel1.add(label9,g);		
		g.gridx=7;
		g.gridy=1;
		panel1.add(textField8,g);
				
		g.gridx=8;
		g.gridy=1;
		panel1.add(label10,g);
		g.gridx=9;
		g.gridy=1;
		panel1.add(add2,g);
		
		g.gridx=10;
		g.gridy=0;
		panel1.add(clear,g);
		
		g.gridx=11;
		g.gridy=1;
		panel1.add(max,g);
		
		g.gridx=10;
		g.gridy=1;
		panel1.add(random,g);
		
		g.gridx=11;
		g.gridy=0;
		panel1.add(exit,g);
		
		ButtonsHandler handler1 = new ButtonsHandler();
		add.addActionListener(handler1);
		add2.addActionListener(handler1);
		clear.addActionListener(handler1);
		max.addActionListener(handler1);
		random.addActionListener(handler1);
		exit.addActionListener(handler1);


		add(panel1,BorderLayout.NORTH);
		add(panel2,BorderLayout.CENTER);
		
	}
	 /************************ Handler the Buttons ************************************************************/
		private class ButtonsHandler implements ActionListener
	 /*********************************************************************************************************/
		{
			
			int x1;
			int x2;
			int y1;
			int y2;
			public void actionPerformed(ActionEvent event)
			{
				
		   		if(event.getSource()==add)            //               Add Button
				{
		   			x1=Integer.parseInt(textField1.getText());
		   			x2=Integer.parseInt(textField2.getText());
		   			y1=Integer.parseInt(textField3.getText());
		   			y2=Integer.parseInt(textField4.getText());		
		   			panel2.updateParameters(x1,x2,y1,y2);		   	
			   		panel2.repaint();
			   		setSize(1280, 701); 
		    		setSize(1280, 700);
				}
		  		if(event.getSource()==add2)                //                add small bounds  
						{
				   			x1=Integer.parseInt(textField5.getText());
				   			x2=Integer.parseInt(textField6.getText());
				   			y1=Integer.parseInt(textField7.getText());
				   			y2=Integer.parseInt(textField8.getText());		
				   			//Bound b = new Bound (x1,x2,y2,y1);
				   			panel2.addBound(x1,x2,y1,y2);		   	
					   		panel2.repaint();
					   		setSize(1280, 701); 
				    		setSize(1280, 700);
						}
		  		if(event.getSource()==clear)                // clear (new) Button
				{
		  			panel2.clear();	
		  			panel2.started();
		  			panel2.repaint();
			   		setSize(1280, 701); 
		    		setSize(1280, 700);
				}
		  		if(event.getSource()==max)                // The Answer  
				{
			       panel2.finish();
			      
		  	       Algoquest a= new Algoquest();    
		  	       BoundList list2;
		  	       Bound out;
		  	       Object[] bon = panel2.getArr();
		  	       System.out.println(" ");
		  	       
		  	     System.out.println("The BigBound's coordinates  :  ");
		  	       Bound[] b = intoBound(bon);
		  	       double x1=b[0].getLeft();
		  	     System.out.print("L  " + x1);
		  	       double x2=b[0].getRight();
		  	     System.out.print("  R  " + x2);		  
		  	       double y2=b[0].getTop();
		  	     System.out.print("  T  " + y2);
			       double y1=b[0].getBottom();
			  	     System.out.print("  B " + y1);
		  	   System.out.println(" ");
		  	   		  	   
		  	       Bound[] f = cutTheMotherFucker(b);
		  	       System.out.println("The small Bounds coordinates  :  ");

		  	       for( int i=0; i<f.length;i++)
		  	       {
				  	      String s=  f[i].toString();
			     	      System.out.println("  " + s);

		  	       }
		  	       
		  	      SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");  
			  	  Date date1 = new Date(); 
		  	       
		  	       
		  	       
		  	       list2=a.findMax(x1,x2,y2,y1,f);       /** The Algoquest Algorithm ===============*/
		           out=a.findTheMaxBound(list2);
		           
		             System.out.println("    ");
		    	     System.out.println("The Algorhitm's answer  :  ");
			  	     
			  	   double s1=out.getLeft();
			  	   System.out.print("L  " + s1);
			  	   double s2=out.getRight();
			  	   System.out.print("  R  " + s2);		  
			  	   double w2=out.getTop();
			  	   System.out.print("  T " + w2);
				   double w1=out.getBottom();
				   System.out.print("  B " + w1);
			  	   System.out.println(" ");
			       System.out.println(" ");
			  	   double ans=out.getSize();
			  	   System.out.print("it's size is : " + ans + " pixels");
			  	   System.out.println(" ");
			  	   Date date2 = new Date();  
			  	   long date3 = date2.getTime() - date1.getTime();
			  	   System.out.println("and it took " + (date3/1000) + "  seconds ");  
//			  	  System.out.println("and it took " + formatter.format(date3) + "seconds "); 
			  	
		           panel2.add(out);		  			
		  			panel2.repaint();
			   		setSize(1280, 701); 
		    		setSize(1280, 700);
				}
		  		if(event.getSource()==random)                // add small bounds in random size and location 
				{
		  			Random rand = new Random();
		  			int R = rand.nextInt(1280);
		  			int L = rand.nextInt(R);		  					  			
		  			int T = rand.nextInt(700);
		  			int B = rand.nextInt(T);
		  		
		  			panel2.addBound(L,R,B,T);
		  			panel2.repaint();
			   		setSize(1280, 701); 
		    		setSize(1280, 700);
				}
		  		
		  		if(event.getSource()==exit)                // add small bounds  
				{
		  			System.exit(0); 
				}
		   		
		}
		}
	public Bound[] intoBound(Object[] b)
	{
		int i;
		int x = b.length;
		Bound[] bon = new Bound [x];
		for(i=0 ; i<x; i++)
		{
			bon[i]= new Bound((Bound)b[i]);
		}
		return bon;
	}
	public Bound[] cutTheMotherFucker( Bound[] b)
	{
		Bound[] bon = new Bound[b.length-1];
		int i;
		for( i=0;i<b.length-1;i++)
		{
			bon[i]=b[i+1];
		}
		return bon ;
	}
		

}
