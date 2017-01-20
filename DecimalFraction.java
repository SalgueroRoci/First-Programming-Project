/*
	Programmer: Rocio Salguero
	Date: April 12, 2013
	FileName: DecimalFraction
*/

import java.awt.event.*;
import java.awt.*;
import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.BoxLayout;
import javax.swing.JTabbedPane;
import javax.swing.ImageIcon;


public class DecimalFraction extends Frame implements ActionListener
{
	//declare components for Fraction to Decimal method used in ActionPerformed
	double numerator, denominator;
	String num, dom;

	//declare components for Decimal to Fraction method used in ActionPerformed
	String inputNumber;
	int numer, denomi, deciPlaces;
	double input, whole;

	ImageIcon icon = new ImageIcon("math.png");

	JTabbedPane tabbedPane = new JTabbedPane();
		//components to show for Decimal to Fraction Calculator
		Panel deciFrac = new Panel();
			Panel flowDeci = new Panel();
				Label decimalLabel = new Label("Input decimal to convert");
				TextField deciInputNumberField = new TextField(10);
				Button deciCalcButton = new Button("Calculate");
			Label deciOutputLabel = new Label("Click the calculation button to see fraction");

		//components to show for Fraction to Decimal Calculator
		Panel fracDeci = new Panel();
			Panel gridFrac = new Panel();
				TextField numText = new TextField(10);
				Label line = new Label("------------------------------------------------------------------------------------------------------------------------");
				TextField domText = new TextField(10);
				Button fracCalcButton = new Button("Calculate");
			Label fracOutputLabel = new Label("Click the calculation button to see your decimal.");



	//Decimal to Fraction calculations
	public void fractionCalc()
	{
		//original input number as string and double and converted back to string (to find decimal places)
		String startNumber = deciInputNumberField.getText();
		input = Double.parseDouble(startNumber);
		inputNumber = Double.toString(Math.abs(input));

		//finding number of decimal places (deciPlaces)
		int integerPlaces = inputNumber.indexOf('.');
		deciPlaces = inputNumber.length() - integerPlaces - 1;

		//finding whole number
		double temp = input % 1;
		if(input > 0) { whole = input - temp; } else{ whole = input + temp; }
		int wholeNumber = (int)whole; //converts into an integer, keeps negative sign value

		//finding numerator
		double nu = Math.round(temp * Math.pow(10, deciPlaces));
		numer = (int)Math.abs(nu); //converts to integer, taking away sign value

		//finding denominator
		denomi = (int)Math.pow(10, deciPlaces);

		//finding final fraction (final numerator and denominator)
		int finalNum = numer / findGCD(numer,denomi);
		int finalDom = denomi / findGCD(numer, denomi);

		deciOutputLabel.setText("Your decimal  " + input + "  to Fraction is  " + wholeNumber + "  and  " + finalNum + " / " + finalDom );
	}
	//part of Decimal to fractiong, finding the GCD
	public int findGCD(int numer,int denomi)
	{
		if(denomi == 0){
	            return numer;
	    }
	    return findGCD(denomi, numer % denomi);
	}



	//Fraction to Decimal calculations
	public void decimalCalc()
	{
		num = numText.getText();
		dom = domText.getText();
		numerator = Integer.parseInt(num);
		denominator = Integer.parseInt(dom);

		double decimal = numerator / denominator ; //output decimal (no formatting)

		fracOutputLabel.setText("Your fraction " + numerator + " / " + denominator + " is " + decimal + " in decimal format" );
	}



	public void actionPerformed(ActionEvent e)
	{
		Object ob = e.getSource();
		if(ob == deciCalcButton)
		{
			try
			{
				fractionCalc();
				if (input == 0 || deciPlaces > 9) throw new IllegalArgumentException();
			}
			catch (IllegalArgumentException g)
			{
				if (deciPlaces > 9) {
					deciOutputLabel.setText("Please input number less than 9 digits.");
				}
				else {
					deciOutputLabel.setText("Please enter a decimal in field.");
				}
				deciInputNumberField.setText("");
				deciInputNumberField.requestFocus();
			}
		} //end of decimal to fraction calculator


		if(ob == fracCalcButton)
		{
			try
			{
				decimalCalc(); //calculating method for decimal
				if (denominator == 0) throw new IllegalArgumentException(); //new error message if dividing by zero
			}
			catch (IllegalArgumentException g)
			{
				int testNum = num.length();
				int testDom = dom.length();
				if (testNum > 10 || testDom > 10) {
					fracOutputLabel.setText("Please input a proper whole numer (that is under ten digits!)");
				}
				else {
					fracOutputLabel.setText("Cannot divide by zero!");
				}

				numText.setText("");
				domText.setText("");
				numText.requestFocus();
			}
		} //end of Fraction to decimal calculations

	} //end of Action Event perform


	public DecimalFraction()
	{
		//decimal to fraction Panel
		deciFrac.setLayout(new BorderLayout());
			flowDeci.setLayout(new FlowLayout());
				flowDeci.add(decimalLabel);
				flowDeci.add(deciInputNumberField);
				flowDeci.add(deciCalcButton);
					deciCalcButton.addActionListener(this);
		deciFrac.add(flowDeci, BorderLayout.CENTER);
		deciFrac.add(deciOutputLabel, BorderLayout.SOUTH);

		//fraction to decimal Panel
		fracDeci.setLayout(new BorderLayout());
			gridFrac.setLayout(new BoxLayout(gridFrac, BoxLayout.Y_AXIS));
				gridFrac.add(numText);
				gridFrac.add(line);
				gridFrac.add(domText);
				gridFrac.add(fracCalcButton);
					fracCalcButton.addActionListener(this);
		fracDeci.add(gridFrac, BorderLayout.CENTER);
		fracDeci.add(fracOutputLabel, BorderLayout.SOUTH);

		//adds both panels to main tab panel
		tabbedPane.addTab("Decimal to Fraction",icon ,deciFrac);
		tabbedPane.addTab("Fraction to Decimal",icon ,fracDeci);

		//adds all components to main frame
		this.setLayout(new BorderLayout());
		add(tabbedPane, BorderLayout.CENTER);

		//overriding the windowClosing() method will allow he user to click the close button
		addWindowListener(
			new WindowAdapter()
			{
				public void windowClosing(WindowEvent e)
				{
					System.exit(0);
				}
			}
		);

	}


	public static void main(String[]args)
	{
		DecimalFraction f = new DecimalFraction();
			f.setBounds(20,20,500,180);
			f.setTitle("Fraction and Decimal Calculator");
			f.setVisible(true);
			f.setResizable (false);
	}


}
