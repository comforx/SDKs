package com.paypal.svcs.types.common;
import java.io.UnsupportedEncodingException;
import com.paypal.core.NVPUtil;
import java.util.Map;

/**
 * 
 */
public class PhoneNumberType{


	/**
	 * 	  
	 *@Required	 
	 */ 
	private String countryCode;

	/**
	 * 	  
	 *@Required	 
	 */ 
	private String phoneNumber;

	/**
	 * 	 
	 */ 
	private String extension;

	

	/**
	 * Constructor with arguments
	 */
	public PhoneNumberType (String countryCode, String phoneNumber){
		this.countryCode = countryCode;
		this.phoneNumber = phoneNumber;
	}	

	/**
	 * Default Constructor
	 */
	public PhoneNumberType (){
	}	

	/**
	 * Getter for countryCode
	 */
	 public String getCountryCode() {
	 	return countryCode;
	 }
	 
	/**
	 * Setter for countryCode
	 */
	 public void setCountryCode(String countryCode) {
	 	this.countryCode = countryCode;
	 }
	 
	/**
	 * Getter for phoneNumber
	 */
	 public String getPhoneNumber() {
	 	return phoneNumber;
	 }
	 
	/**
	 * Setter for phoneNumber
	 */
	 public void setPhoneNumber(String phoneNumber) {
	 	this.phoneNumber = phoneNumber;
	 }
	 
	/**
	 * Getter for extension
	 */
	 public String getExtension() {
	 	return extension;
	 }
	 
	/**
	 * Setter for extension
	 */
	 public void setExtension(String extension) {
	 	this.extension = extension;
	 }
	 


	public String toNVPString() throws UnsupportedEncodingException {
		return toNVPString("");
	}
	
	public String toNVPString(String prefix) throws UnsupportedEncodingException {
		StringBuilder sb = new StringBuilder();
		if (countryCode != null) {
			sb.append(prefix).append("countryCode=").append(NVPUtil.encodeUrl(countryCode));
			sb.append("&");
		}
		if (phoneNumber != null) {
			sb.append(prefix).append("phoneNumber=").append(NVPUtil.encodeUrl(phoneNumber));
			sb.append("&");
		}
		if (extension != null) {
			sb.append(prefix).append("extension=").append(NVPUtil.encodeUrl(extension));
			sb.append("&");
		}
		return sb.toString();
	}
	
	public static PhoneNumberType createInstance(Map<String, String> map, String prefix, int index) {
		PhoneNumberType phoneNumberType = null;
		int i = 0;
		if (index != -1) {
				if (prefix != null && prefix.length() != 0 && !prefix.endsWith(".")) {
					prefix = prefix + "(" + index + ").";
				}
		} else {
			if (prefix != null && prefix.length() != 0 && !prefix.endsWith(".")) {
				prefix = prefix + ".";
			}
		}
			
		if (map.containsKey(prefix + "countryCode")) {
				phoneNumberType = (phoneNumberType == null) ? new PhoneNumberType() : phoneNumberType;
				phoneNumberType.setCountryCode(map.get(prefix + "countryCode"));
		}
		if (map.containsKey(prefix + "phoneNumber")) {
				phoneNumberType = (phoneNumberType == null) ? new PhoneNumberType() : phoneNumberType;
				phoneNumberType.setPhoneNumber(map.get(prefix + "phoneNumber"));
		}
		if (map.containsKey(prefix + "extension")) {
				phoneNumberType = (phoneNumberType == null) ? new PhoneNumberType() : phoneNumberType;
				phoneNumberType.setExtension(map.get(prefix + "extension"));
		}
		return phoneNumberType;
	}
 
}