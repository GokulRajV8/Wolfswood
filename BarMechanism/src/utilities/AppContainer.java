package utilities;

import services.ArcSolver;
import ui.MainFrame;
import ui.MainPanel;

public class AppContainer {
	
	private static MainFrame mainFrame;
	private static MainPanel mainPanel;
	private static ArcSolver solver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solver = new ArcSolver();
		mainFrame = new MainFrame();
		mainPanel = new MainPanel(solver);
		mainFrame.setVisible(true);
		mainFrame.add(mainPanel);
	}

}
