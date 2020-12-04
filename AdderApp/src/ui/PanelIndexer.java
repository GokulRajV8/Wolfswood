package ui;

import javax.swing.JPanel;

public class PanelIndexer extends Thread {
	
	private AppFrame frame;
	private JPanel[] panels;
	
	public PanelIndexer(AppFrame frame, JPanel... panels) {
		this.frame = frame;
		this.panels = panels;
	}
	
	public void run() {
		while(true) {
			if(frame.panelIndex == 0) {
				this.panels[0].setVisible(true);
				this.panels[1].setVisible(false);
			}
			else {
				this.panels[0].setVisible(false);
				this.panels[1].setVisible(true);
			}
		}
	}

}
