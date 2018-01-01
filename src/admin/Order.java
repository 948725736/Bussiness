package admin;

public class Order {
	private String orderId;	//订单号
	
	private String wareId;	//商品编号
	private String wareName;//商品名称
	private int warePrice;	//商品价格
	
	private int quantity;	//商品数量
	private String address;	//发货地址
	private String contact;	//联系人
	private int phone;		//联系电话
	private String remark;	//备注
	
	private String buyerId;	//买家ID
	private String sellerId;//卖家ID
	
	public Order(){}
	
	public Order(String wareId, String wareName, int warePrice, int quantity,
			String address, String contact, int phone, String remark,
			String buyerId, String sellerId) {
		this.wareId = wareId;
		this.wareName = wareName;
		this.warePrice = warePrice;
		this.quantity = quantity;
		this.address = address;
		this.contact = contact;
		this.phone = phone;
		this.remark = remark;
		this.buyerId = buyerId;
		this.sellerId = sellerId;
		
	}


	
	public String getOrderId() {
		return orderId;
	}


	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}


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
	public int getWarePrice() {
		return warePrice;
	}
	public void setWarePrice(int warePrice) {
		this.warePrice = warePrice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}


	public String getBuyerId() {
		return buyerId;
	}


	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
	}


	public String getSellerId() {
		return sellerId;
	}


	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}


	@Override
	public String toString() {
		return 	"订单号:	" + orderId + "\n" +
				"商品编号:" + wareId + "\n" +
				"商品名称:" + wareName + "\n" +
				"商品单价:" + warePrice + "\n" +
				"购买数量:" + quantity + "\n" +
				"发货地址:" + address + "\n" +
				"联系人:	" + contact + "\n" +
				"联系电话:" + phone + "\n" +
				"备注:	" + remark ;
	}

}
