package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class WelcomePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private AppFrame parent;
	private JLabel welcomeLabel;
	private JLabel start;
	
	public WelcomePanel(AppFrame parent) {
		this.parent = parent;
		AppFrame parent1 = this.parent;
		this.setBounds(0, 0, 400, 400);
		this.setBackground(new Color(220, 220, 220));
		this.setLayout(null);

		this.welcomeLabel = new JLabel("Welcome to Adder App");
		this.welcomeLabel.setBounds(75, 150, 250, 50);
		this.welcomeLabel.setFont(new Font("Serif", Font.BOLD, 24));
		this.start = new JLabel("Click here to start");
		this.start.setBounds(125, 200, 200, 50);
		this.start.setFont(new Font("Serif", Font.PLAIN, 19));
		this.start.setForeground(Color.RED);
		
		this.start.addMouseListener(new MouseAdapter(){  
		    public void mouseClicked(MouseEvent e){  
		    	parent1.panelIndex = 1;
		    }  
		});
		
		this.add(this.welcomeLabel);
		this.add(this.start);
	}
}
