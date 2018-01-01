package admin;

public class Order {
	private String orderId;	//������
	
	private String wareId;	//��Ʒ���
	private String wareName;//��Ʒ����
	private int warePrice;	//��Ʒ�۸�
	
	private int quantity;	//��Ʒ����
	private String address;	//������ַ
	private String contact;	//��ϵ��
	private int phone;		//��ϵ�绰
	private String remark;	//��ע
	
	private String buyerId;	//���ID
	private String sellerId;//����ID
	
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
		return 	"������:	" + orderId + "\n" +
				"��Ʒ���:" + wareId + "\n" +
				"��Ʒ����:" + wareName + "\n" +
				"��Ʒ����:" + warePrice + "\n" +
				"��������:" + quantity + "\n" +
				"������ַ:" + address + "\n" +
				"��ϵ��:	" + contact + "\n" +
				"��ϵ�绰:" + phone + "\n" +
				"��ע:	" + remark ;
	}

}
