//*******************************************************************
//  Programmer(s): Rocio Salguero
//	Hanoi 
//  Class: CPSC Java 223J - 02
// 	Final 3
// 	Due Date:  12/12/16
//	Description: Program that shows steps for Hanoi game  
//  
//*******************************************************************
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.applet.*;

public class Hanoi extends Applet implements ActionListener {
	Label 
		moves = new Label("Enter # of disks:"), 
		peg1 = new Label("peg1"), 
		peg2 = new Label("peg2"), 
		peg3 = new Label("peg3"); 
	TextField 
		input = new TextField(); 
	Button 
		press = new Button("Press Here"); 
	
	boolean buildDisk;
	
	public void paint(Graphics g){
        g.setColor(Color.red);
        g.fillRect(20,130,350,10);
        
        g.fillRect(80,40,10,100);
        g.fillRect(180,40,10,100);
        g.fillRect(290,40,10,100);
	} 
	
	public void init() {
		setLayout(null);
		
		moves.setBounds(0, 0, 100,20);		add(moves); 
		peg1.setBounds(20,150,100,30); 		add(peg1);
		peg2.setBounds(170,150,100,30); 	add(peg2);
		peg3.setBounds(290,150,100,30); 	add(peg3);
		input.setBounds(120,0,30,20);		add(input);
		press.setBounds(350,20,100,30); 	add(press);
		
		press.addActionListener(this);
		
	}
	
	public void actionPerformed(ActionEvent arg0) {
		int disks;
		disks = Integer.parseInt(input.getText());
		
		towerOfHanoi(disks,1,3,2);
		
		
	}
	int i = 0;
	public void towerOfHanoi(int n, int start, int temp, int end) {
		if (n == 1) 
			moveTo(start,end);
		else {
			towerOfHanoi(n-1,start, end,temp);
			moveTo(start,end);
			towerOfHanoi(n-1, temp,start,end);
		}
	}
	
	public void moveTo(int from, int to ) {
		moves.setText(from + "->" + to );	
		System.out.print(from + "->" + to + "\n");
	}
	
}
