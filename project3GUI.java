package project3;

/**
 * project3GUI instantiates the GUI that drives the program, where the actionPerformed method (clicking on the "Perform Sort" button) instantiates the logic that produces the 
 * results. Separate ifInteger and ifFraction methods are executed depending on the values of the JRadioButtons, and within those methods, the generic SearchTree class and 
 * possibly also the Fraction class are accessed. However, all of the classes and flow begin here in project3GUI within the GUI itself. 
 */
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class project3GUI extends JFrame implements ActionListener {

	JFrame frame = new JFrame();
	private JLabel instructions = new JLabel("Original List", SwingConstants.LEFT);
	private JLabel result = new JLabel("Sorted List", SwingConstants.LEFT);
	private static JTextField expressionToSend = new JTextField(20);
	private JButton evaluate = new JButton("Perform Sort");
	private static JTextField answer = new JTextField(20);
	private JPanel topPanel = new JPanel();
	private JPanel bottomPanel = new JPanel();
	private JPanel middlePanel = new JPanel();
	private JPanel bottomLeft;
    private JPanel bottomRight; 
    private JRadioButton ascending = new JRadioButton("Ascending", true);
    private JRadioButton descending = new JRadioButton("Descending");
    private JRadioButton integer = new JRadioButton("Integer", true);
    private JRadioButton fraction = new JRadioButton("Fraction");
    	
    
    project3GUI() {
		super("Binary Search Tree Sort");
		topPanel = new JPanel(new FlowLayout());
		bottomPanel = new JPanel(new FlowLayout());
		middlePanel = new JPanel(new FlowLayout());
		bottomLeft = new JPanel(new GridLayout());
		bottomRight = new JPanel(new GridLayout());
		setLayout(new GridLayout(5, 5, 5, 5));
		evaluate.addActionListener(this);
		answer.setEditable(false);
		add(topPanel);
		add(bottomPanel);
		add(middlePanel);
		bottomLeft.setBorder(BorderFactory.createTitledBorder("Sort Order"));
		bottomRight.setBorder(BorderFactory.createTitledBorder("Numeric Type"));
		ButtonGroup bottomL = new ButtonGroup();
		ButtonGroup bottomR = new ButtonGroup();
	    bottomL.add(ascending);
	    bottomL.add(descending);
	    bottomLeft.add(ascending);
	    bottomLeft.add(descending);
		bottomR.add(integer);
	    bottomR.add(fraction);
	    bottomRight.add(integer);
	    bottomRight.add(fraction);
	    add(bottomLeft);
	    add(bottomRight);
		topPanel.add(instructions);
		topPanel.add(expressionToSend);
		middlePanel.add(evaluate);
		bottomPanel.add(result);
		bottomPanel.add(answer);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		if(integer.isSelected()) {
			
		String[] randomList = expressionToSend.getText().split(" ");	
		answer.setText(ifInteger(randomList));
		}
		
		else {
			
		String[] randomList = expressionToSend.getText().split("( )|(/)");
		answer.setText(ifFraction(randomList));
		}
	}

	public String ifInteger(String [] randomList) {
	try {
		int [] list = new int [randomList.length];
		for(int i = 0; i < randomList.length; i++) {
			list[i] = Integer.parseInt(randomList[i]);
		} 
		
		SearchTree tree = new SearchTree(list[0]);
		for(int i = 1; i < list.length; i++) {
			tree.insertValue(tree.root, list[i]);
		}
	
	if(ascending.isSelected()) {
		return tree.inOrderTraversal(tree.root);
	}
	
	else {
		return tree.inOrderTraversalDescending(tree.root);
	}
	
	}
	
	catch(NumberFormatException invalidInput) {
        
		JOptionPane.showMessageDialog(null, "Non Numeric Input");
	}
	return null;
}
	
	public String ifFraction(String [] randomList) {
		int placeholder = 0; 
		
		try {
		Fraction [] fractionArray = new Fraction[randomList.length/2];
		 for (int i = 0; i < randomList.length; i = i + 2) {
             fractionArray[placeholder] = new Fraction(Integer.parseInt(randomList[i]), Integer.parseInt(randomList[i + 1]));
             placeholder++;
         }
		 
		 SearchTree tree = new SearchTree(fractionArray[0]);
         for (int i = 1; i < fractionArray.length; i++) {
             tree.insertValueFraction(tree.root, fractionArray[i]);
         }
         
         if (ascending.isSelected()) {
             return tree.inOrderTraversalFraction(tree.root);
         }
         
         else {
        	 return tree.inOrderTraversalDescendingFraction(tree.root);
         }
         
     }
		
		catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
         JOptionPane.showMessageDialog(null, "Non Numeric Input");
     }
		return null;
	}
	
	
	public static void main (String [] args) {
		project3GUI gui = new project3GUI();
		gui.setVisible(true);
		gui.setSize(500, 400); 
		
	}
	
}
