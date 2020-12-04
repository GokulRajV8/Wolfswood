package ui;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class AppFrame extends JFrame{

	private static final long serialVersionUID = 1L;
	public volatile Integer panelIndex;

	public AppFrame(String name) {
		super(name);
		this.panelIndex = 0;
		this.setSize(400, 400);
		this.setLayout(null);
		this.setVisible(true);
		this.setResizable(false);
		this.addWindowListener(new WindowAdapter() {
		    @Override
		    public void windowClosing(WindowEvent e) {
		        System.exit(0);
		    }
		});
	}
}