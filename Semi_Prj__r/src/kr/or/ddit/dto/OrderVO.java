package kr.or.ddit.dto;

import java.util.Date;

public class OrderVO {
	private String orderNo; // 주문번호
	private String orderNoDetail; // 주문 상세번호
	private String id;   // 주문자 아이디
	private String prodId;  // 상품 아이디
	private String prodName; // 상품명
	private String picture; // 이미지
	private Date orderTime; // 주문 시간
	private int orderCost; // 주문 금액
	private int orderQty;   // 주문 수량
	private String orderStatus; // 주문 상태
	
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getOrderNoDetail() {
		return orderNoDetail;
	}
	public void setOrderNoDetail(String orderNoDetail) {
		this.orderNoDetail = orderNoDetail;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getProdId() {
		return prodId;
	}
	public void setProdId(String prodId) {
		this.prodId = prodId;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public Date getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
	public int getOrderCost() {
		return orderCost;
	}
	public void setOrderCost(int orderCost) {
		this.orderCost = orderCost;
	}
	public int getOrderQty() {
		return orderQty;
	}
	public void setOrderQty(int orderQty) {
		this.orderQty = orderQty;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	
}
