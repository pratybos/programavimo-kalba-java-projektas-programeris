package com.IS17B.Restoranas.restoranas.model;

import javax.persistence.*;

@Entity
@Table(name="TBL_ORDERS")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="order_name")
    private String orderName;
    
    @Column(name="client_name")
    private String clientName;

	@Column(name="phone_number")
	private String phoneNumber;

	@Column(name="full_price")
	private Double fullPrice;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Double getFullPrice() {
		return fullPrice;
	}

	public void setFullPrice(Double fullPrice) {
		this.fullPrice = fullPrice;
	}


}