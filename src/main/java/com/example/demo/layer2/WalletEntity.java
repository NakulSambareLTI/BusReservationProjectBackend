package com.example.demo.layer2;


import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the CUSTOMER_WALLET database table.
 * 
 */
@Entity
@Table(name="CUSTOMER_WALLET")
public class WalletEntity  {
	

	@Id
//	@SequenceGenerator(name="CUSTOMER_WALLET_WALLETID_GENERATOR", sequenceName="WALLET_ID")
	@GeneratedValue //(strategy=GenerationType.SEQUENCE, generator="CUSTOMER_WALLET_WALLETID_GENERATOR")
	@Column(name="WALLET_ID")
	private Integer walletId;

	@Column(name="REGISTERED_EMAIL")
	private String registeredEmail;

	@Column(name="WALLET_AMOUNT")
	private Long walletAmount;

	@Column(name="WALLET_PIN")
	private String walletPin;

	public WalletEntity() {
		super();
		System.out.println("walletEntity() empty constructor...");
	}
	

	public WalletEntity(Integer walletId, String registeredEmail, Long walletAmount, String walletPin) {
		super();
		this.walletId = walletId;
		this.registeredEmail = registeredEmail;
		this.walletAmount = walletAmount;
		this.walletPin = walletPin;
	}


	public Integer getWalletId() {
		return this.walletId;
	}

	public void setWalletId(Integer walletId) {
		this.walletId = walletId;
	}

	public String getRegisteredEmail() {
		return this.registeredEmail;
	}

	public void setRegisteredEmail(String registeredEmail) {
		this.registeredEmail = registeredEmail;
	}

	public Long getWalletAmount() {
		return this.walletAmount;
	}

	public void setWalletAmount(Long walletAmount) {
		this.walletAmount = walletAmount;
	}

	public String getWalletPin() {
		return this.walletPin;
	}

	public void setWalletPin(String walletPin) {
		this.walletPin = walletPin;
	}

}