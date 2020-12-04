package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AdderPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private AppFrame parent;
	private JLabel number1Label;
	private JLabel number2Label;
	private JLabel resultLabel;
	private JLabel resultData;
	private JButton addButton;
	private JLabel goBack;
	private JTextField number1Data;
	private JTextField number2Data;
	
	public AdderPanel(AppFrame parent) {
		this.parent = parent;
		AppFrame parent1 = this.parent;
		this.setBounds(0, 0, 400, 400);
		this.setBackground(new Color(220, 220, 220));
		this.setLayout(null);
		
		this.number1Label = new JLabel("Number 1:");
		this.number2Label = new JLabel("Number 2:");
		this.number1Data = new JTextField();
		this.number2Data = new JTextField();
		this.resultLabel = new JLabel("Result: ");
		this.resultData = new JLabel("0.0");
		this.addButton = new JButton("Add");
		this.goBack = new JLabel("Go back");
		this.number1Label.setBounds(100, 75, 100, 25);
		this.number1Label.setFont(new Font("Serif", Font.BOLD, 18));
		this.number2Label.setBounds(100, 125, 100, 25);
		this.number2Label.setFont(new Font("Serif", Font.BOLD, 18));
		this.number1Data.setBounds(200, 75, 100, 25);
		this.number2Data.setBounds(200, 125, 100, 25);
		this.resultLabel.setBounds(100, 175, 100, 25);
		this.resultLabel.setFont(new Font("Serif", Font.BOLD, 18));
		this.resultData.setBounds(200, 175, 200, 25);
		this.resultData.setFont(new Font("Serif", Font.BOLD, 18));
		this.addButton.setBounds(200, 225, 100, 25);
		this.goBack.setBounds(150, 290, 100, 25);
		this.goBack.setFont(new Font("Serif", Font.BOLD, 24));
		this.goBack.setForeground(Color.RED);
		
		this.addButton.addMouseListener(new MouseAdapter(){  
		    public void mouseClicked(MouseEvent e){  
		    	resultData.setText(String.valueOf(Float.parseFloat(number1Data.getText()) + Float.parseFloat(number2Data.getText())));
		    }  
		});
		
		this.goBack.addMouseListener(new MouseAdapter(){  
		    public void mouseClicked(MouseEvent e){
		    	number1Data.setText("");
		    	number2Data.setText("");
		    	resultData.setText("0.0");
		    	parent1.panelIndex = 0;
		    }  
		});
		
		this.add(number1Label);
		this.add(number2Label);
		this.add(number1Data);
		this.add(number2Data);
		this.add(resultLabel);
		this.add(resultData);
		this.add(addButton);
		this.add(goBack);
	}

}
