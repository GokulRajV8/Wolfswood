package ui;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.Image;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;

public class AppFrame extends WindowAdapter{
	
	private Frame frame = new Frame();
	TextArea text = new TextArea();
	
	public AppFrame(String name) {		
		URL url = ClassLoader.getSystemResource("resources/contacts_512dp.png");
		Toolkit kit = Toolkit.getDefaultToolkit();
		Image img = kit.createImage(url);
		frame.setIconImage(img);
		frame.setTitle(name);
		frame.addWindowListener(this);
		frame.add(this.text, BorderLayout.CENTER);
		frame.setSize(250, 250);
		frame.setVisible(true);
	}
	
	public void setText(String result) {
		this.text.setText(result);
	}

	@Override
	public void windowClosing(WindowEvent e) {
		frame.dispose();
	}
}
