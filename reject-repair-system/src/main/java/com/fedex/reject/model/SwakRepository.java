package com.fedex.reject.model;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;
@Setter
@Getter
//@NoArgsConstructor
@ToString
@Data
@Entity
@Table(name = "SwakRepository")
@EntityListeners(AuditingEntityListener.class)

public class SwakRepository implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    
    @Column(name = "")
	private int destinationZipCode;
    @Column(name = "")
	private int weigh;
    @Column(name = "")
	private int bookingNumber;
    @Column(name = "")
	private int containerNumber;
    @Column(name = "")
	private String shipmentRoute;
    @Column(name = "")
	private long estimatedTimeCompletion;
    @Column(name = "")
	private long estimatedTimeDeparture;
    @Column(name = "")
	private boolean fullContainerLoad;
    @Column(name = "")
	private boolean paymentStatus;
    @Column(name = "")
	private String shipmentDetails;
    @Column(name = "")
	private long shipmentCutoffTime;
    @Column(name = "")
	private String smartPost;
    @Column(name = "")
	private String itemDescription;
    @Column(name = "")
	private int qty;
    @Column(name = "")
	private int discount;
    @Column(name = "")
	private String billTo;
    @Column(name = "")
	private String email;
    @Column(name = "")
	private String address;
    @Column(name = "")
	private int phoneNumber;
    @Column(name = "")
	private int bussinessNumber;
    @Column(name = "")
	private int fax;
    

	

	public SwakRepository() {
		super();
	}

	public SwakRepository(int destinationZipCode, int weigh, int bookingNumber, int containerNumber, String shipmentRoute,
			long estimatedTimeCompletion, long estimatedTimeDeparture, boolean fullContainerLoad, boolean paymentStatus,
			String shipmentDetails, long shipmentCutoffTime, String smartPost, String itemDescription, int qty,
			int discount, String billTo, String email, String address, int phoneNumber, int bussinessNumber, int fax) {
		super();
		this.destinationZipCode = destinationZipCode;
		this.weigh = weigh;
		this.bookingNumber = bookingNumber;
		this.containerNumber = containerNumber;
		this.shipmentRoute = shipmentRoute;
		this.estimatedTimeCompletion = estimatedTimeCompletion;
		this.estimatedTimeDeparture = estimatedTimeDeparture;
		this.fullContainerLoad = fullContainerLoad;
		this.paymentStatus = paymentStatus;
		this.shipmentDetails = shipmentDetails;
		this.shipmentCutoffTime = shipmentCutoffTime;
		this.smartPost = smartPost;
		this.itemDescription = itemDescription;
		this.qty = qty;
		this.discount = discount;
		this.billTo = billTo;
		this.email = email;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.bussinessNumber = bussinessNumber;
		this.fax = fax;
	}

	

}
