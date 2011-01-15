/**
 * Menki Mobile Solutions
 * http://www.menkimobile.com.br
 * 
 * @author Augusto Souza
 *
 */

package com.menki.moip;

//import java.io.Serializable;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

public class PaymentDetails implements Serializable{
	/**
	 * Constants
	 */
	private static final long serialVersionUID = 1L; // Default serial version ID
	private static final String ATTR_BRAND = "brand";
	private static final String ATTR_CREDIT_CARD = "credit_card";
	private static final String ATTR_EXP_DATE = "expiration_date";
	private static final String ATTR_SECURE_CODE = "secure_code";
	private static final String ATTR_OWNER_NAME = "owner_name";
	private static final String ATTR_OWNER_ID_TYPE = "owner_identification_type";
	private static final String ATTR_OWNER_ID_NUM = "owner_identification_number";
	private static final String ATTR_OWNER_PHONE_NUM = "owner_phone_number";
	private static final String ATTR_BORN_DATE = "born_date";
	private static final String ATTR_INSTALLMENTS = "installments";
	private static final String ATTR_PAYMENT_TYPE = "payment_type";
	private static final String ATTR_FULL_NAME = "full_name";
	private static final String ATTR_EMAIL = "email";
	private static final String ATTR_CELL_PHONE = "cell_phone";
	private static final String ATTR_PAYER_ID_TYPE = "payer_identification_type";
	private static final String ATTR_PAYER_ID_NUM = "payer_identification_number";
	private static final String ATTR_ST_ADDRESS = "street_address";
	private static final String ATTR_ST_NUMBER = "street_number";
	private static final String ATTR_ST_COMPLEMENT = "street_complement";
	private static final String ATTR_NEIGHBORHOOD = "neighborhood";
	private static final String ATTR_CITY = "city";
	private static final String ATTR_STATE = "state";
	private static final String ATTR_ZIP_CODE = "zip_code";
	private static final String ATTR_FIXED_PHONE = "fixed_phone";
	
	/**
	 * Attributes
	 */
	private String brand;
	private String creditCardNumber;
	private Date expirationDate;
	private String secureCode;
	private String ownerName;
	private String ownerIdentificationType;
	private String ownerIdentificationNumber;
	private String ownerPhoneNumber;
	private Date bornDate;
	private int installments;
	private String paymentType;
	private String fullName;
	private String email;
	private String cellPhone;
	private String payerIdentificationType;
	private String payerIdentificationNumber;
	private String streetAddress;
	private int streetNumber;
	private String streetComplement;
	private String neighborhood;
	private String city;
	private String state;
	private String zipCode;
	private String fixedPhone;
	private ArrayList<String> changes = new ArrayList<String>();
	private ArrayList<String> errors = new ArrayList<String>();
	private Context context;
	
	public PaymentDetails(Context ctx) {
		super();
		context = ctx;
	}
		
	public Boolean save() {
		if (!isChangesValid()) return false;
		
		Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();

		Iterator<String> itr = changes.iterator();
		while(itr.hasNext()){
			String current = itr.next();
			
			if (current.equals(ATTR_EXP_DATE) || current.equals(ATTR_BORN_DATE)){ // current is a date attribute
				Date date = (Date) getValueOf(current);
				editor.putString(current, date.toString());
			} 
			else if (current.equals(ATTR_INSTALLMENTS) || current.equals(ATTR_ST_NUMBER)){ // current is a int attribute
				editor.putInt(current, (Integer) getValueOf(current));
			}
			else { // current is a string attribute
				editor.putString(current, (String)getValueOf(current));
			}
		}
		
		changes.clear();
		errors.clear();
		
		return true;
	}
	
	private Object getValueOf(String attr) {
		if (attr.equals(ATTR_BRAND)) 
			return getBrand();
		else if (attr.equals(ATTR_CREDIT_CARD)) 
			return getCreditCardNumber();
		else if (attr.equals(ATTR_EXP_DATE))
			return getExpirationDate();
		else if (attr.equals(ATTR_SECURE_CODE)) 
			return getSecureCode();
		else if (attr.equals(ATTR_OWNER_NAME)) 
			return getOwnerName();
		else if (attr.equals(ATTR_OWNER_ID_TYPE)) 
			return getOwnerIdentificationType();
		else if (attr.equals(ATTR_OWNER_ID_NUM)) 
			return getOwnerIdentificationNumber();
		else if (attr.equals(ATTR_OWNER_PHONE_NUM)) 
			return getOwnerPhoneNumber();
		else if (attr.equals(ATTR_BORN_DATE)) 
			return getBornDate();
		else if (attr.equals(ATTR_INSTALLMENTS)) 
			return getInstallments();
		else if (attr.equals(ATTR_PAYMENT_TYPE)) 
			return getPayerIdentificationType();
		else if (attr.equals(ATTR_FULL_NAME)) 
			return getFullName();
		else if (attr.equals(ATTR_EMAIL)) 
			return getEmail();
		else if (attr.equals(ATTR_CELL_PHONE)) 
			return getCellPhone();
		else if (attr.equals(ATTR_PAYER_ID_TYPE)) 
			return getPayerIdentificationType();
		else if (attr.equals(ATTR_PAYER_ID_NUM)) 
			return getPayerIdentificationNumber();
		else if (attr.equals(ATTR_ST_ADDRESS)) 
			return getStreetAddress();
		else if (attr.equals(ATTR_ST_NUMBER)) 
			return getStreetNumber();
		else if (attr.equals(ATTR_ST_COMPLEMENT)) 
			return getStreetComplement();
		else if (attr.equals(ATTR_NEIGHBORHOOD)) 
			return getNeighborhood();
		else if (attr.equals(ATTR_CITY)) 
			return getCity();
		else if (attr.equals(ATTR_STATE)) 
			return getState();
		else if (attr.equals(ATTR_ZIP_CODE)) 
			return getZipCode();
		else if (attr.equals(ATTR_FIXED_PHONE)) 
			return getFixedPhone();
		else 
			return null;
	}

	public Boolean isChangesValid() {
		if(false) errors.add("");
		
		//TODO: Implement this method, that must check if for any of the changed attributes the new value is valid.
		
		return errors.isEmpty();
	}

	/**
	 * Getters and Setters
	 */
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		if (!brand.equals(getBrand())) {
			changes.add(ATTR_BRAND);
			this.brand = brand;
		}
	}
	public String getCreditCardNumber() {
		return creditCardNumber;
	}
	public void setCreditCardNumber(String creditCardNumber) {
		if (!creditCardNumber.equals(getCreditCardNumber())) {
			changes.add(ATTR_CREDIT_CARD);
			this.creditCardNumber = creditCardNumber;
		}
	}
	public Date getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(Date expirationDate) {
		if (!expirationDate.equals(getExpirationDate())) {
			changes.add(ATTR_EXP_DATE);
			this.expirationDate = expirationDate;
		}
	}
	public String getSecureCode() {
		return secureCode;
	}
	public void setSecureCode(String secureCode) {
		if (!secureCode.equals(getSecureCode())) {
			changes.add(ATTR_SECURE_CODE);
			this.secureCode = secureCode;
		}
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		if (!ownerName.equals(getOwnerName())) {
			changes.add(ATTR_OWNER_NAME);
			this.ownerName = ownerName;
		}
	}
	public String getOwnerIdentificationType() {
		return ownerIdentificationType;
	}
	public void setOwnerIdentificationType(String ownerIdentificationType) {
		if (!ownerIdentificationType.equals(getOwnerIdentificationType())) {
			changes.add(ATTR_OWNER_ID_TYPE);
			this.ownerIdentificationType = ownerIdentificationType;
		}
	}
	public String getOwnerIdentificationNumber() {
		return ownerIdentificationNumber;
	}
	public void setOwnerIdentificationNumber(String ownerIdentificationNumber) {
		if (!ownerIdentificationNumber.equals(getOwnerIdentificationNumber())) {
			changes.add(ATTR_OWNER_ID_NUM);
			this.ownerIdentificationNumber = ownerIdentificationNumber;
		}
	}
	public String getOwnerPhoneNumber() {
		return ownerPhoneNumber;
	}
	public void setOwnerPhoneNumber(String ownerPhoneNumber) {
		if (!ownerPhoneNumber.equals(getOwnerPhoneNumber())) {
			changes.add(ATTR_OWNER_PHONE_NUM);
			this.ownerPhoneNumber = ownerPhoneNumber;
		}
	}
	public Date getBornDate() {
		return bornDate;
	}
	public void setBornDate(Date bornDate) {
		if (!bornDate.equals(getBornDate())) {
			changes.add(ATTR_BORN_DATE);
			this.bornDate = bornDate;
		}
	}
	public int getInstallments() {
		return installments;
	}
	public void setInstallments(int installments) {
		if (installments != getInstallments()) {
			changes.add(ATTR_INSTALLMENTS);
			this.installments = installments;
		}
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		if (!paymentType.equals(getPaymentType())) {
			changes.add(ATTR_PAYMENT_TYPE);
			this.paymentType = paymentType;
		}
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		if (!fullName.equals(getFullName())) {
			changes.add(ATTR_FULL_NAME);
			this.fullName = fullName;
		}
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		if (!email.equals(getEmail())) {
			changes.add(ATTR_EMAIL);
			this.email = email;
		}
	}
	public String getCellPhone() {
		return cellPhone;
	}
	public void setCellPhone(String cellPhone) {
		if (!cellPhone.equals(getCellPhone())) {
			changes.add(ATTR_CELL_PHONE);
			this.cellPhone = cellPhone;
		}
	}
	public String getPayerIdentificationType() {
		return payerIdentificationType;
	}
	public void setPayerIdentificationType(String payerIdentificationType) {
		if (!payerIdentificationType.equals(getPayerIdentificationType())) {
			changes.add(ATTR_PAYER_ID_TYPE);
			this.payerIdentificationType = payerIdentificationType;
		}
	}
	public String getPayerIdentificationNumber() {
		return payerIdentificationNumber;
	}
	public void setPayerIdentificationNumber(String payerIdentificationNumber) {
		if (!payerIdentificationNumber.equals(getPayerIdentificationNumber())) {
			changes.add(ATTR_PAYER_ID_NUM);
			this.payerIdentificationNumber = payerIdentificationNumber;
		}
	}
	public String getStreetAddress() {
		return streetAddress;
	}
	public void setStreetAddress(String streetAddress) {
		if (!streetAddress.equals(getStreetAddress())) {
			changes.add(ATTR_ST_ADDRESS);
			this.streetAddress = streetAddress;
		}
	}
	public int getStreetNumber() {
		return streetNumber;
	}
	public void setStreetNumber(int streetNumber) {
		if (streetNumber != getStreetNumber()) {
			changes.add(ATTR_ST_NUMBER);
			this.streetNumber = streetNumber;
		}
	}
	public String getStreetComplement() {
		return streetComplement;
	}
	public void setStreetComplement(String streetComplement) {
		if (!streetComplement.equals(getStreetComplement())) {
			changes.add(ATTR_ST_COMPLEMENT);
			this.streetComplement = streetComplement;
		}
	}
	public String getNeighborhood() {
		return neighborhood;
	}
	public void setNeighborhood(String neighborhood) {
		if (!neighborhood.equals(getNeighborhood())) {
			changes.add(ATTR_NEIGHBORHOOD);
			this.neighborhood = neighborhood;
		}
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		if (!city.equals(getCity())) {
			changes.add(ATTR_CITY);
			this.city = city;
		}
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		if (!state.equals(getState())) {
			changes.add(ATTR_STATE);
			this.state = state;
		}
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		if (!zipCode.equals(getZipCode())) {
			changes.add(ATTR_ZIP_CODE);
			this.zipCode = zipCode;
		}
	}
	public String getFixedPhone() {
		return fixedPhone;
	}
	public void setFixedPhone(String fixedPhone) {
		if (!fixedPhone.equals(getFixedPhone())) {
			changes.add(ATTR_FIXED_PHONE);
			this.fixedPhone = fixedPhone;
		}
	}
}