package components;
//*******************************************************************
//Programmer(s): Rocio Salguero
//Pizza
//Class: CPSC Java 223J - 02
//	Quiz
//	Due Date:  12/12/16
//Description: Pizza program
//
//*******************************************************************


import java.util.*; // for read from console java.util.scanner;
import java.lang.*; //Used for Math operations 
import java.io.*; //file readers .
import java.awt.*; //for components 
import java.awt.List;
import java.awt.event.*; // for action listener 

import javax.swing.*;
import javax.swing.event.*; 
import java.applet.*; 

public class test extends Applet implements ActionListener {

	 //define components 
	Label 
		lblTitle = new Label("Domino's Pizza"), 
		lblDate = new Label(""), 
		lblChoose = new Label("Choose your pizza(Basic $7.00)"), 
		lblCrust = new Label("Select Crust"), 
		lblSize = new Label("Select size($1.00, $2.00, $3.00 extra"), 
		lblNum = new Label("Number os Pizzas"), 
		lblName = new Label("Your Name"), 
		lblPhone = new Label("Phone number"); 

	TextField 
		txtType = new TextField(""), 
		txtName = new TextField(), 
		txtPho = new TextField(); 
	
	Choice 
		chCrust = new Choice(), 
		chNum = new Choice(); 
	
	CheckboxGroup 
		cbMain = new CheckboxGroup();
	Checkbox 
		cbTen = new Checkbox("10\"", cbMain, true), 
		cbTwev = new Checkbox("12\"", cbMain, false),
		cbFour = new Checkbox("14\"", cbMain, false); 
	
	TextArea 
		txtaReciept = new TextArea(); 
	
	Button
		btnSelect = new Button(">>>"), 
		btnRemove = new Button("<<<"), 
		btnNext = new Button("Next"), 
		btnOrder = new Button("Click to order"); 
		
	Image img, selected; 
	int index = 0, typeSelected, x = 100, y=100, w=100, h = 100; 
	String [] pics = {"pizza1.png", "pizza2.png", "pizza3.png"};
	String type; 
	
	
	
public void init() {
	//place components on the applet panel 
	setLayout(null); 
	
	//Labels
	Font titleFont = new Font("Time New Roman", Font.BOLD, 26);
	lblTitle.setFont(titleFont); 
	lblChoose.setFont(titleFont);
	lblDate.setFont(titleFont);
	
	Font bold = new Font("Time New Roman", Font.BOLD, 14); 
	
	lblCrust.setFont(bold);
	lblSize.setFont(bold);
	lblNum.setFont(bold);
	lblName.setFont(bold);
	lblPhone.setFont(bold);
	
	
	lblTitle.setBounds(150,10,350,30); 								add(lblTitle);
	lblDate.setBounds(100,70,350,30); 								add(lblDate);
	lblChoose.setBounds(50,130,400,30); 							add(lblChoose);
	lblCrust.setBounds(20,360,150,30); 								add(lblCrust);
	lblSize.setBounds(190,360,250,30); 								add(lblSize);
	lblNum.setBounds(20,450,150,30); 									add(lblNum);
	lblName.setBounds(200,450,150,30); 								add(lblName);
	lblPhone.setBounds(350,450,150,30); 								add(lblPhone);
	
		//Get Date 
		Calendar c = Calendar.getInstance(); 
		int day = c.get(Calendar.DATE); 
		int month = c.get(Calendar.MONTH) + 1; 
		int year = c.get(Calendar.YEAR); 
		
		lblDate.setText("Choose your pizza " + month + "/" + day + "/" + year); 
	
	//TextFields 
	txtType.setBounds(195,270,20,20); 								add(txtType);
	txtName.setBounds(170,480,150,30); 								add(txtName);
	txtPho.setBounds(325,480,150,30); 									add(txtPho);
	
	txtType.setEditable(false);
	txtType.setText(Integer.toString(index+1));
	
	//Choice lists
	chCrust.setBounds(20,400,150,30); 								add(chCrust);
	chNum.setBounds(50,480,50,30); 									add(chNum);
	
		chCrust.add("Hand Tossed");
		chCrust.add("Deep Dish");
		chCrust.add("Thin Crust");
		
		for (int i = 1; i <= 10; i++)
			chNum.add(Integer.toString(i));
	
	//Choice box group 
	cbTen.setBounds(200,400,50,30); 								add(cbTen);
	cbTwev.setBounds(250,400,50,30); 								add(cbTwev);
	cbFour.setBounds(300,400,50,30); 								add(cbFour);
		
	//TextArea
	txtaReciept.setBounds(20,560,500,120); 						add(txtaReciept);
	txtaReciept.setEditable(false);

	//Buttons
	btnNext.setBounds(180,200,50,25); 						add(btnNext);
	btnSelect.setBounds(180,230,50,25); 					add(btnSelect);
	btnRemove.setBounds(180,300,50,25);						add(btnRemove);
	btnOrder.setBounds(20,520,500,30); 							add(btnOrder);				
			
	//add actions listener to the button, which causes actionPerformed 
	//method to execute when the user pressed the button 
	btnNext.addActionListener(this); 
	btnSelect.addActionListener(this);
	btnRemove.addActionListener(this);
	btnOrder.addActionListener(this);
	
	img = getImage(getDocumentBase(), pics[0]);
}	
	
public void paint(Graphics g) {
	g.drawImage(img, 20,200,150,150, this); 
	g.drawImage(selected, 250,200,150,150, this); 
}	


public void actionPerformed(ActionEvent e) {
	if(e.getSource() == btnNext) {
		index ++; 
		index = index % 3; 
		img = getImage(getDocumentBase(), pics[index]);
		repaint(); 
		txtType.setText(Integer.toString(index+1));
	}
	else if(e.getSource() == btnSelect) {
		selected = getImage(getDocumentBase(), pics[index]);
		repaint(); 
		
		typeSelected = index+1; 
		
		if (typeSelected == 1)
			type = "Pacific Veggie";
		else if (typeSelected == 2)
			type = "ExtravgabZZa"; 
		else if(typeSelected == 3)
			type = "6 cheese";
		
	
	}
	else if(e.getSource() == btnRemove) {
		type = ""; 
		typeSelected = -1; 
		selected = getImage(getDocumentBase(), "");
		repaint(); 
	}
	else if(e.getSource() == btnOrder) {
		txtaReciept.setText("");
		
		//Calculate the crust extra
		String crustE = "";
		if (chCrust.getSelectedIndex() == 0)
			crustE = "0.50"; 
		else if (chCrust.getSelectedIndex() == 1)
			crustE = "1.00"; 
		
		//calculate total 
		double total = 7.0; 
			//add crust extra
			if (chCrust.getSelectedIndex() == 0)
				total += 0.5; 
			else if (chCrust.getSelectedIndex() == 1)
				total += 1.0;
			else if(chCrust.getSelectedIndex() == 2)
				total += 0; 
			
			//add size extra
			int size = 10; 
			if(cbTen.getState() == true) {
				total += 1.0; 
				size = 10; 
			}
			else if(cbTwev.getState() == true) {
				total += 2.0;
				size = 12; 
			}
			else if(cbFour.getState() == true) {
				total += 3.0;
				size = 14; 
			}
			total *= (chNum.getSelectedIndex() + 1); 
	
			
			
		String order = txtName.getText() + "," + txtPho.getText() + "\n" + 
						"Basic pizza type " + (typeSelected) + "  " + type + " : 7.00 \n" + 
						"Crust:  "  + chCrust.getSelectedItem() + " " + crustE + "\n" + 
						"Size:   " + size + " inches\n" + 
						"Number of pizzas  " + chNum.getSelectedItem() + "\n" + 
						"Total $ " + String.format( "%.2f", total ) ; 
		
		txtaReciept.setText(order);  
		
		}
	
	
} // END OF ACTION LISTENER 


}
