package beans;

public class Ship {

	private Integer ID;
	private String name;
	private Integer size;
	private Integer xCoordinate = 0;
	private Integer yCoordinate = 0;
	private Boolean isHorizontal = true;
	private Integer health;
	
	public Ship(Integer ID, String name, Integer size) {
		super();
		this.ID = ID;
		this.name = name;
		this.size = size;
		this.health = size;
	}
	
	public String getName() {
		return name;
	}
	public Integer getSize() {
		return size;
	}
	public Integer getxCoordinate() {
		return xCoordinate;
	}
	public void setxCoordinate(Integer xCoordinate) {
		this.xCoordinate = xCoordinate;
	}
	public Integer getyCoordinate() {
		return yCoordinate;
	}
	public void setyCoordinate(Integer yCoordinate) {
		this.yCoordinate = yCoordinate;
	}
	public Boolean getIsHorizontal() {
		return isHorizontal;
	}
	public void setIsHorizontal(Boolean isHorizontal) {
		this.isHorizontal = isHorizontal;
	}
	public void setHealth(Integer health) {
		this.health = health;
	}
	public Integer getHealth() {
		return this.health;
	}
	public Integer getID() {
		return ID;
	}
}
