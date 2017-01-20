package components;

//*******************************************************************
//Programmer(s): Rocio Salguero
//Car Rental 
//Class: CPSC Java 223J - 02
//	Exam 2
//	Due Date:  12/12/16
//Description: Program that shows pictures base on month clicked 
//
//*******************************************************************

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.JMenuBar;
import javax.swing.KeyStroke;
import javax.swing.ImageIcon;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JFrame;
import javax.swing.JLabel;


/* MenuDemo.java requires images/middle.gif. */

/*
* This class is just like MenuLookDemo, except the menu items
* actually do something, thanks to event listeners.
*/
public class MenuDemo implements ActionListener  {
  JTextArea output;
  JScrollPane scrollPane;
  String newline = "\n";
  JLabel wIcon;
  BufferedImage wPic;
  String [] pics = {"season1.png","season2.png","season3.png",
		  "season4.png","season5.png","season6.png",
		  "season7.png","season8.png","season9.png",
		  "season10.png","season11.png","season12.png"};
  
  public JMenuBar createMenuBar() {
      JMenuBar menuBar;
      JMenu menu;
      JMenuItem menuItem;
      

      //Create the menu bar.
      menuBar = new JMenuBar();

      //Build the first menu.
      menu = new JMenu("Spring");
      menuBar.add(menu);

      //a group of JMenuItems
      menuItem = new JMenuItem("March",
                               KeyEvent.VK_T);
      //menuItem.setMnemonic(KeyEvent.VK_T); //used constructor instead
      menuItem.addActionListener(this);
      menu.add(menuItem);

      menuItem = new JMenuItem("April",KeyEvent.VK_T);
      menuItem.addActionListener(this);
      menu.add(menuItem);

      menuItem = new JMenuItem("May",KeyEvent.VK_T);
      menuItem.addActionListener(this);
      menu.add(menuItem);


    //Build the second menu.
      menu = new JMenu("Summer");
      menuBar.add(menu);

      //a group of JMenuItems
      menuItem = new JMenuItem("June",
                               KeyEvent.VK_T);
      //menuItem.setMnemonic(KeyEvent.VK_T); //used constructor instead
      menuItem.addActionListener(this);
      menu.add(menuItem);

      menuItem = new JMenuItem("July",KeyEvent.VK_T);
      menuItem.addActionListener(this);
      menu.add(menuItem);

      menuItem = new JMenuItem("August",KeyEvent.VK_T);
      menuItem.addActionListener(this);
      menu.add(menuItem);
      
    //Build the third menu.
      menu = new JMenu("Fall");
      menuBar.add(menu);

      //a group of JMenuItems
      menuItem = new JMenuItem("September",
                               KeyEvent.VK_T);
      //menuItem.setMnemonic(KeyEvent.VK_T); //used constructor instead
      menuItem.addActionListener(this);
      menu.add(menuItem);

      menuItem = new JMenuItem("October",KeyEvent.VK_T);
      menuItem.addActionListener(this);
      menu.add(menuItem);

      menuItem = new JMenuItem("November",KeyEvent.VK_T);
      menuItem.addActionListener(this);
      menu.add(menuItem);
      
    //Build the second menu.
      menu = new JMenu("Winter");
      menuBar.add(menu);

      //a group of JMenuItems
      menuItem = new JMenuItem("December",
                               KeyEvent.VK_T);
      //menuItem.setMnemonic(KeyEvent.VK_T); //used constructor instead
      menuItem.addActionListener(this);
      menu.add(menuItem);

      menuItem = new JMenuItem("Janurary",KeyEvent.VK_T);
      menuItem.addActionListener(this);
      menu.add(menuItem);

      menuItem = new JMenuItem("Feburary",KeyEvent.VK_T);
      menuItem.addActionListener(this);
      menu.add(menuItem);


      return menuBar;
  }

  public Container createContentPane() throws IOException {
      //Create the content-pane-to-be.
      JPanel contentPane = new JPanel(new BorderLayout());
      contentPane.setOpaque(true);

      //Create a scrolled text area.
      output = new JTextArea(5, 30);
      output.setEditable(false);
      JTextArea o = new JTextArea(5,20); 
      o.setLineWrap(true);
      
      
      //Add the text area to the content pane.
      output.setLayout(null);
     
      output.setBounds(240, 20, 200, 200);
      output.setLineWrap(true);
      output.setWrapStyleWord(true);
      
      o.setLayout(null);
      o.setBounds(200, 200, 100, 100);
      
      wPic = getImage(pics[0]);
      wIcon = new JLabel(new ImageIcon(wPic));
      wIcon.setLayout(null);
      wIcon.setBounds(20, 20, 200, 200);
             
      contentPane.add(output);
      contentPane.add(wIcon);
      contentPane.add(o);       

      return contentPane;
  }

  public void actionPerformed(ActionEvent e) {
      JMenuItem source = (JMenuItem)(e.getSource());
      
      String s;
      int season = 0, month = 0;
      output.setCaretPosition(output.getDocument().getLength());
      
      if (source.getText() == "Janurary") {
    	  season = 2;
    	  month = 1;
      }
      else if (source.getText() == "Feburary") {
    	  season = 3;
    	  month = 2;
      }
      else if (source.getText() == "March") {
    	  season = 1;
    	  month = 3;
      }
      else if (source.getText() == "April") {
    	  season = 2;
    	  month = 4;
      }
      else if (source.getText() == "May") {
    	  season = 3;
    	  month = 5;
      }
      else if (source.getText() == "June") {
    	  season = 1;
    	  month = 6;
      }
      else if (source.getText() == "July") {
    	  season = 2;
    	  month = 7;
      }
      else if (source.getText() == "August") {
    	  season = 3;
    	  month = 8;
      }
      else if (source.getText() == "September") {
    	  season = 1;
    	  month = 9;
      }
      else if (source.getText() == "October") {
    	  season = 2;
    	  month = 10;
      }
      else if (source.getText() == "November") {
    	  season = 3;
    	  month = 11;
      }
      else if (source.getText() == "December") {
    	  season = 1;
    	  month = 12;
      }
      
      s = source.getText() + " Is the " + season + 
    		  " month of the season and the " + month + 
    		  " month of the year.";
    		 
      output.setText(s);
      
      wPic = getImage(pics[month-1]);
      wIcon.setIcon(new ImageIcon(wPic));
      
  }

  // Returns just the class name -- no package info.
  protected String getClassName(Object o) {
      String classString = o.getClass().getName();
      int dotIndex = classString.lastIndexOf(".");
      return classString.substring(dotIndex+1);
  }

  private BufferedImage getImage(String filename) {
  	// This time, you can use an InputStream to load
  	try {
  	        // Grab the InputStream for the image.                    
  	        InputStream in = getClass().getResourceAsStream(filename);

  	    // Then read it in.
  	    return ImageIO.read(in);
  	} catch (IOException e) {
  	    System.out.println("The image was not loaded.");
  	    //System.exit(1);
  	}
  	    return null;
  	}
  
  /**
   * Create the GUI and show it.  For thread safety,
   * this method should be invoked from the
   * event-dispatching thread.
   * @throws IOException 
   */
  private static void createAndShowGUI() throws IOException {
      //Create and set up the window.
      JFrame frame = new JFrame("MenuDemo");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      //Create and set up the content pane.
      MenuDemo demo = new MenuDemo();
      frame.setJMenuBar(demo.createMenuBar());
      frame.setContentPane(demo.createContentPane());
       
      //Display the window.
      frame.setSize(500, 500);
      frame.setVisible(true);
  }

  public static void main(String[] args) {
      //Schedule a job for the event-dispatching thread:
      //creating and showing this application's GUI.
      javax.swing.SwingUtilities.invokeLater(new Runnable() {
          public void run() {
              try {
					createAndShowGUI();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
          }
      });
  }
}
