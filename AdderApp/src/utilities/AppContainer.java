package utilities;

import ui.AdderPanel;
import ui.AppFrame;
import ui.PanelIndexer;
import ui.WelcomePanel;

public class AppContainer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AppFrame appFrame = new AppFrame("Adder");
		WelcomePanel welcomePanel = new WelcomePanel(appFrame);
		AdderPanel adderPanel = new AdderPanel(appFrame);
		appFrame.add(welcomePanel);
		appFrame.add(adderPanel);
		
		PanelIndexer panelIndexer = new PanelIndexer(appFrame, welcomePanel, adderPanel);
		panelIndexer.start();
	}

}
