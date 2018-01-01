package admin;

public class Car {
private String id;
private String wareId;
private int county;
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getWareId() {
	return wareId;
}
public void setWareId(String wareId) {
	this.wareId = wareId;
}
public int getCounty() {
	return county;
}
public void setCounty(int county) {
	this.county = county;
}
public Car(){}
public Car(String id, String wareId, int county) {
	this.id = id;
	this.wareId = wareId;
	this.county = county;
}

}
