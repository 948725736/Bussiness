package admin;

public class Ware {
private String wareId;
private String wareName;
private int price;
private int stock;//���
private String desc;
private String sellerId;
public String getWareId() {
	return wareId;
}
public void setWareId(String wareId) {
	this.wareId = wareId;
}
public String getWareName() {
	return wareName;
}
public void setWareName(String wareName) {
	this.wareName = wareName;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public int getStock() {
	return stock;
}
public void setStock(int stock) {
	this.stock = stock;
}
public String getDesc() {
	return desc;
}
public void setDesc(String desc) {
	this.desc = desc;
}
public String getSellerId() {
	return sellerId;
}
public void setSellerId(String sellerId) {
	this.sellerId = sellerId;
}

public Ware(String wareId, String wareName, int price, int stock, String desc, String sellerId) {
	super();
	this.wareId = wareId;
	this.wareName = wareName;
	this.price = price;
	this.stock = stock;
	this.desc = desc;
	this.sellerId = sellerId;
}
public String toString(){
	return  "��Ʒ��ţ�	" + wareId + "\n" +
			"��Ʒ���ƣ�	" + wareName + "\n" +
			"��Ʒ�۸�	" + price + "\n" +
			"������        	" + desc + "\n" +
			"��棺        	" + stock ;
}

}
