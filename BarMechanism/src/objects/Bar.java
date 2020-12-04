package objects;

public class Bar {
	
	public int x;
	public int y;
	public int x1;
	public int y1;
	public int r;
	public Double angle;
	public boolean state;
	
	public Bar(int x, int y, int r){
		this.x = x;
		this.y = y;
		this.r = r;
		this.angle = 0.0;
		this.state = false;
		this.update();
	}
	public void update() {
		this.x1 = this.x + (int)Math.ceil(this.r * Math.cos(this.angle));
        this.y1 = this.y + (int)Math.ceil(this.r * Math.sin(this.angle));
	}

}
