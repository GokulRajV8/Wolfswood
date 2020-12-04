package ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import objects.Bar;
import services.ArcSolver;

public class MainPanel extends JPanel implements ActionListener{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Timer timer;
	private double angleDiff1, angleDiff2, angleDiff3, angleDiff4, angleDiff5, angleDiff6;
	private double[] anglex;
	private ArcSolver solver;
	private Bar bar1;
	private Bar bar2;
	private Bar bar3;
	private Bar bar4;
	int c1r;
	int c2r;
	int c3r;
	Color pathColor;
	Color frameColor;
	Color barColor;
	boolean flip;
	long timeBefore;
	long timeAfter;
	long timeTaken;
	long timeStart;
	int iterationSet;
	int fps;
	
	public MainPanel(ArcSolver solver) {
		this.solver = solver;
		timer = new Timer(5, this);
		timeBefore = System.nanoTime();
		timeAfter = 0L;
		timeTaken = 0L;
		timeStart = System.nanoTime();
		timer.start();
		bar1 = new Bar(175, 175, 50);
		bar2 = new Bar(400, 275, 60);
		bar3 = new Bar(700, 175, 85);
		bar4 = new Bar(750, 425, 75);
		c1r = 250;
		c2r = 300;
		c3r = 200;
		pathColor = Color.DARK_GRAY;
		frameColor = Color.RED;
		barColor = Color.WHITE;
		flip = true;
		iterationSet = 0;
		fps = 0;
	}
	
    @Override
    public void paintComponent(Graphics g){
	
    	//Graphics
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        RenderingHints rh = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHints(rh);
        this.setBackground(Color.BLACK);
        
        //Driver
        g2d.setColor(barColor);
        bar1.update();
        g2d.drawLine(bar1.x, bar1.y, bar1.x1, bar1.y1);
        g2d.setColor(pathColor);
        g2d.drawOval(bar1.x - bar1.r, bar1.y - bar1.r, 2 * bar1.r, 2 * bar1.r);
        
        //Mechanism 1
        g2d.setColor(barColor);
        anglex = solver.solve(bar2.x, bar2.y, bar2.r, bar1.x1, bar1.y1, c1r);
        if(anglex[0] == -1)
        	g2d.drawString("Mechanism Impossible", 500, 20);
        if(!bar2.state){
        	bar2.angle = anglex[flip?1:0];
        	bar2.state = true;
        }else{
        	angleDiff1 = Math.abs(bar2.angle - anglex[0]);
        	angleDiff2 = Math.abs(bar2.angle - anglex[1]);
        	angleDiff3 = Math.abs(bar2.angle - anglex[0] - 6.28318530718);
        	angleDiff4 = Math.abs(bar2.angle - anglex[1] - 6.28318530718);
        	angleDiff5 = Math.abs(bar2.angle - anglex[0] + 6.28318530718);
        	angleDiff6 = Math.abs(bar2.angle - anglex[1] + 6.28318530718);
        	if(((angleDiff1 < angleDiff2) && (angleDiff1 < angleDiff4) && (angleDiff1 < angleDiff6)) ||
        	   ((angleDiff3 < angleDiff2) && (angleDiff3 < angleDiff4) && (angleDiff3 < angleDiff6)) ||
        	   ((angleDiff5 < angleDiff2) && (angleDiff5 < angleDiff4) && (angleDiff5 < angleDiff6))) {
        		bar2.angle = anglex[0];
        	}
        	else {
        		bar2.angle = anglex[1];
        	}
        }
        bar2.update();
        g2d.drawLine(bar1.x1, bar1.y1, bar2.x1, bar2.y1);
        g2d.drawLine(bar2.x, bar2.y, bar2.x1, bar2.y1);        
        g2d.setColor(pathColor);
        g2d.drawOval(bar2.x - bar2.r, bar2.y - bar2.r, 2 * bar2.r, 2 * bar2.r);
        g2d.setColor(frameColor);
        g2d.drawLine(bar1.x, bar1.y, bar2.x, bar2.y);
        
        //Mechanism 2
        g2d.setColor(barColor);
        anglex = solver.solve(bar3.x, bar3.y, bar3.r, bar2.x1, bar2.y1, c2r);
        if(anglex[0] == -1)
        	g2d.drawString("Mechanism Impossible", 500, 40);
        if(!bar3.state){
        	bar3.angle = anglex[!flip?1:0];
        	bar3.state = true;
        }else{
        	angleDiff1 = Math.abs(bar3.angle - anglex[0]);
        	angleDiff2 = Math.abs(bar3.angle - anglex[1]);
        	angleDiff3 = Math.abs(bar3.angle - anglex[0] - 6.28318530718);
        	angleDiff4 = Math.abs(bar3.angle - anglex[1] - 6.28318530718);
        	angleDiff5 = Math.abs(bar3.angle - anglex[0] + 6.28318530718);
        	angleDiff6 = Math.abs(bar3.angle - anglex[1] + 6.28318530718);
        	if(((angleDiff1 < angleDiff2) && (angleDiff1 < angleDiff4) && (angleDiff1 < angleDiff6)) ||
        	   ((angleDiff3 < angleDiff2) && (angleDiff3 < angleDiff4) && (angleDiff3 < angleDiff6)) ||
        	   ((angleDiff5 < angleDiff2) && (angleDiff5 < angleDiff4) && (angleDiff5 < angleDiff6))) {
        		bar3.angle = anglex[0];
        	}
        	else {
        		bar3.angle = anglex[1];
        	}
        }
        bar3.update();
        g2d.drawLine(bar2.x1, bar2.y1, bar3.x1, bar3.y1);
        g2d.drawLine(bar3.x, bar3.y, bar3.x1, bar3.y1);        
        g2d.setColor(pathColor);
        g2d.drawOval(bar3.x - bar3.r, bar3.y - bar3.r, 2 * bar3.r, 2 * bar3.r);
        g2d.setColor(frameColor);
        g2d.drawLine(bar2.x, bar2.y, bar3.x, bar3.y);
        
        //Mechanism 3
        g2d.setColor(barColor);
        anglex = solver.solve(bar4.x, bar4.y, bar4.r, bar3.x1, bar3.y1, c3r);
        if(anglex[0] == -1)
        	g2d.drawString("Mechanism Impossible", 500, 60);
        if(!bar4.state){
        	bar4.angle = anglex[!flip?1:0];
        	bar4.state = true;
        }else{
        	angleDiff1 = Math.abs(bar4.angle - anglex[0]);
        	angleDiff2 = Math.abs(bar4.angle - anglex[1]);
        	angleDiff3 = Math.abs(bar4.angle - anglex[0] - 6.28318530718);
        	angleDiff4 = Math.abs(bar4.angle - anglex[1] - 6.28318530718);
        	angleDiff5 = Math.abs(bar4.angle - anglex[0] + 6.28318530718);
        	angleDiff6 = Math.abs(bar4.angle - anglex[1] + 6.28318530718);
        	if(((angleDiff1 < angleDiff2) && (angleDiff1 < angleDiff4) && (angleDiff1 < angleDiff6)) ||
        	   ((angleDiff3 < angleDiff2) && (angleDiff3 < angleDiff4) && (angleDiff3 < angleDiff6)) ||
        	   ((angleDiff5 < angleDiff2) && (angleDiff5 < angleDiff4) && (angleDiff5 < angleDiff6))) {
        		bar4.angle = anglex[0];
        	}
        	else {
        		bar4.angle = anglex[1];
        	}
        }
        bar4.update();
        g2d.drawLine(bar3.x1, bar3.y1, bar4.x1, bar4.y1);
        g2d.drawLine(bar4.x, bar4.y, bar4.x1, bar4.y1);        
        g2d.setColor(pathColor);
        g2d.drawOval(bar4.x - bar4.r, bar4.y - bar4.r, 2 * bar4.r, 2 * bar4.r);
        g2d.setColor(frameColor);
        g2d.drawLine(bar3.x, bar3.y, bar4.x, bar4.y);
        
        //Monitor
        if(iterationSet == 30) {
        	timeAfter = System.nanoTime();
        	timeTaken = timeAfter - timeBefore;
        	fps = (int)(30000000000L / timeTaken);
        	iterationSet = 0;
        	timeBefore = timeAfter;
        }
        g2d.setColor(Color.PINK);
        g2d.drawString("FPS: " + fps, 15, 20);
        g2d.drawString("Angle " + bar1.angle.floatValue(), 15, 40);
        
        //Update
        bar1.angle = bar1.angle + ((System.nanoTime() - timeStart)/1000000000.0) * 1.5;
        if(bar1.angle > 6.28)
        	bar1.angle = 0.0;
        iterationSet ++;
        timeStart = System.nanoTime();
    }
    public void actionPerformed(ActionEvent e) {
    	repaint();
    }
}
