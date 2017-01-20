//*******************************************************************
//  Programmer(s): Rocio Salguero
//	Car Rental 
//  Class: CPSC Java 223J - 02
// 	Exam 1
// 	Due Date:  12/12/16
//	Description: Program that lets people rent a car. 
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
			lblTitle = new Label("Avis Rent a Car"), 
			lblType = new Label("Type of cars"), 
			lblCompants = new Label("Subcompants (Hyundai Accent or similar). $24.95/day"),
			lblSelected = new Label("Selected Car"),
			lblInter = new Label("Intermediate (Chev, Cruze, or similar). $30.95/day"), 
			lblFull = new Label("Full Size (Chrysler, Impala or similar). $35.95/day"), 
			lblNum = new Label("Number of days(1-7)");
		
		Choice 
			chNum = new Choice(); 
		
		TextArea 
			txtaReciept = new TextArea(); 
		
		Button
			btnNextSub = new Button("Next Car>>"), 
			btnNextInter = new Button("Next Car>>"), 
			btnNextFull = new Button("Next Car>>"), 
			btnResSub = new Button("Reserve"), 
			btnResInter = new Button("Reserve"), 
			btnResFull = new Button("Reserve"), 
			btnReciept = new Button("Press to see report"); 
				
		Image imgSub, imgSubSel, imgInter, imgInterSel, imgFull, imgFullSel; 
		
		String [] full = {"full1.png","full2.png","full3.png"};
		String [] inter = {"inter1.png","inter2.png","inter3.png"};
		String [] sub = {"sub1.png","sub2.png","sub3.png"};
		
		int subIndex = 0, interIndex = 0, fullIndex = 0; 
		
		//can only rent one car so tests whether other cars were selected and replaces. 
		boolean selSub, selInter, selFull; 
		int x =20, y = 20, h=100,w=100;
	public void init() {
		//place components on the applet panel 
		setLayout(null); 
		
		//Labels
		Font titleFont = new Font("Time New Roman", Font.BOLD, 26);
		lblTitle.setFont(titleFont); 
		lblType.setFont(titleFont); 
		
		lblTitle.setBounds(120,20,250,30); 								add(lblTitle);
		lblType.setBounds(20,50,180,30); 								add(lblType); 
		lblCompants.setBounds(20,90,300,30); 							add(lblCompants); 
		lblSelected.setBounds(350,90,200,30); 							add(lblSelected); 
		lblInter.setBounds(20,220,300,30); 								add(lblInter); 
		lblFull.setBounds(20,350,300,30); 								add(lblFull); 
		lblNum.setBounds(20,480,100,30); 									add(lblNum); 
		
		//Choice lists
		chNum.setBounds(20,510,50,50); 									add(chNum);
			for (int i = 1; i <= 7; i++)
				chNum.add(Integer.toString(i));
			
		//TextArea
		txtaReciept.setBounds(320,510,150,150); 							add(txtaReciept);
		txtaReciept.setEditable(false);
		
		//buttons 
		btnNextSub.setBounds(180,130,80,30); 								add(btnNextSub);	
		btnNextInter.setBounds(180,250,80,30); 							add(btnNextInter);	
		btnNextFull.setBounds(180,380,80,30); 							add(btnNextFull);	
		btnResSub.setBounds(180,170,80,30); 								add(btnResSub);	
		btnResInter.setBounds(180,290,80,30); 							add(btnResInter);	
		btnResFull.setBounds(180,420,80,30); 								add(btnResFull);	
		btnReciept.setBounds(190,510,130,30); 								add(btnReciept);	
			
		imgSub = getImage(getDocumentBase(), sub[0]);
		imgInter = getImage(getDocumentBase(), inter[0]);
		imgFull = getImage(getDocumentBase(), full[0]);
		
		//Add action listeners 
		btnNextSub.addActionListener(this); 
		btnNextInter.addActionListener(this); 	
		btnNextFull.addActionListener(this); 
		btnResSub.addActionListener(this); 
		btnResInter.addActionListener(this); 
		btnResFull.addActionListener(this); 	
		btnReciept.addActionListener(this); 	
		
	}	
		
	public void paint(Graphics g) {
		g.drawImage(imgSub, 20,130,150,100, this); 
		g.drawImage(imgSubSel, 320,130,150,100, this); 
		g.drawImage(imgInter, 20,250,150,100, this); 
		g.drawImage(imgInterSel, 320,250,150,100, this); 
		g.drawImage(imgFull, 20,380,150,100, this); 
		g.drawImage(imgFullSel, 320,380,150,100, this); 
	}	
	
	
	public void actionPerformed(ActionEvent e) {
	
		if(e.getSource() == btnNextFull) {
			fullIndex++; 
			fullIndex = fullIndex % 3; 
			imgFull = getImage(getDocumentBase(), full[fullIndex]);
			repaint(); 
			
		}
		else if(e.getSource() == btnResFull) {
			if (selInter == true) {
				//make the other choices blank
				imgInterSel = getImage(getDocumentBase(), "");
				repaint(); 
				selInter = false; 
			}
			else if (selSub == true) {
				//make the other choices blank
				imgSubSel = getImage(getDocumentBase(), "");
				repaint(); 
				selSub = false; 
			}
			
			selFull = true; 
			imgFullSel = getImage(getDocumentBase(), full[fullIndex]);
			repaint(); 
		}
		
		else if (e.getSource() == btnNextInter) {
			interIndex++; 
			interIndex = interIndex % 3; 
			imgInter = getImage(getDocumentBase(), inter[interIndex]);
			repaint(); 
		}
		else if (e.getSource() == btnResInter) {
			if (selFull == true) {
				//make the other choices blank
				imgFullSel = getImage(getDocumentBase(), "");
				repaint(); 
				selFull = false; 
			}
			else if (selSub == true) {
				//make the other choices blank
				imgSubSel = getImage(getDocumentBase(), "");
				repaint(); 
				selSub = false; 
			}
			
			selInter = true; 
			imgInterSel = getImage(getDocumentBase(), inter[interIndex]);
			repaint(); 
		}
		
		else if (e.getSource() == btnNextSub) {
			subIndex++; 
			subIndex = subIndex % 3; 
			imgSub = getImage(getDocumentBase(), sub[subIndex]);
			repaint(); 
		}
		else if (e.getSource() == btnResSub) {
			if (selFull == true) {
				//make the other choices blank
				imgFullSel = getImage(getDocumentBase(), "");
				repaint(); 
				selFull = false; 
			}
			else if (selInter == true) {
				//make the other choices blank
				imgInterSel = getImage(getDocumentBase(), "");
				repaint(); 
				selInter = false; 
			}
			
			selSub = true; 
			imgSubSel = getImage(getDocumentBase(), sub[subIndex]);
			repaint(); 
		}
		//Total 
		else if (e.getSource() == btnReciept) {
			
			String type = "", model = "";
			double total; 
			
			total = 0; 
			
			if ( selSub == true) {
				type = "Subcompacts"; 
				if(subIndex == 0) 
					model = " Hyndai"; 
				else if (subIndex == 1) 
					model = "Camery"; 
				else if (subIndex == 2) 
					model = "Sub"; 
				
				total = 24.95;
			}
			else if (selInter == true) {
				type = "Intermediate"; 
				if(subIndex == 0) 
					model = " Chev"; 
				else if (subIndex == 1) 
					model = "Cruze"; 
				else if (subIndex == 2) 
					model = "Other"; 
				
				total = 30.95;
			}
			else if (selFull == true) {
				type = "Full Size"; 
				if(subIndex == 0) 
					model = " Chrysler"; 
				else if (subIndex == 1) 
					model = "Impala"; 
				else if (subIndex == 2) 
					model = "Other"; 
				
				total = 35.95;
			}
			
			total *= Double.parseDouble(chNum.getSelectedItem());
			
			//add to text area. 
			txtaReciept.setText("Car Type: " + type + 
						"\nCar Model: " + model +
						"\nNo. of days: " + chNum.getSelectedItem() +
						"\nTotal Pay: " + total);
		}
		
	} // END OF ACTION LISTENER 
	


}
