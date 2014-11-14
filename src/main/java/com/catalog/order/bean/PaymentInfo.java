package com.catalog.order.bean;

public class PaymentInfo {
	private String cardNumber;
	private String nameOnCard;
	private String expiryMonth;
	private String expiryYear;
	private String cvv;
	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getNameOnCard() {
		return nameOnCard;
	}

	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}

	public String getExpiryMonth() {
		return expiryMonth;
	}

	public void setExpiryMonth(String expiryMonth) {
		this.expiryMonth = expiryMonth;
	}

	public String getExpiryYear() {
		return expiryYear;
	}

	public void setExpiryYear(String expiryYear) {
		this.expiryYear = expiryYear;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	@Override
	public String toString() {
		return "PaymentInfo [cardNumber=" + cardNumber + ", nameOnCard="
				+ nameOnCard + ", expiryMonth=" + expiryMonth + ", expiryYear="
				+ expiryYear + ", cvv=" + cvv + "]";
	}

	
	
	
}
