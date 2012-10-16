package urn.ebay.apis.eBLBaseComponents;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.NamedNodeMap;
import java.io.FileInputStream;
import java.io.StringReader;
import java.io.IOException;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 * Information about Coupled Payment transactions. 
 */
public class CoupledPaymentInfoType{


	/**
	 * ID received in the Coupled Payment Request	 
	 */ 
	private String coupledPaymentRequestID;

	/**
	 * ID that uniquely identifies this CoupledPayment. Generated
	 * by PP in Response	  
	 *@Required	 
	 */ 
	private String coupledPaymentID;

	

	/**
	 * Default Constructor
	 */
	public CoupledPaymentInfoType (){
	}	

	/**
	 * Getter for coupledPaymentRequestID
	 */
	 public String getCoupledPaymentRequestID() {
	 	return coupledPaymentRequestID;
	 }
	 
	/**
	 * Setter for coupledPaymentRequestID
	 */
	 public void setCoupledPaymentRequestID(String coupledPaymentRequestID) {
	 	this.coupledPaymentRequestID = coupledPaymentRequestID;
	 }
	 
	/**
	 * Getter for coupledPaymentID
	 */
	 public String getCoupledPaymentID() {
	 	return coupledPaymentID;
	 }
	 
	/**
	 * Setter for coupledPaymentID
	 */
	 public void setCoupledPaymentID(String coupledPaymentID) {
	 	this.coupledPaymentID = coupledPaymentID;
	 }
	 



	private  boolean isWhitespaceNode(Node n) {
		if (n.getNodeType() == Node.TEXT_NODE) {
			String val = n.getNodeValue();
			return val.trim().length() == 0;
		} else if (n.getNodeType() == Node.ELEMENT_NODE ) {
			return (n.getChildNodes().getLength() == 0);
		} else {
			return false;
		}
	}
	
	public CoupledPaymentInfoType(Node node) throws XPathExpressionException {
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		Node childNode = null;
		NodeList nodeList = null;
		childNode = (Node) xpath.evaluate("CoupledPaymentRequestID", node, XPathConstants.NODE);
		if (childNode != null && !isWhitespaceNode(childNode)) {
		    this.coupledPaymentRequestID = childNode.getTextContent();
		}
	
		childNode = (Node) xpath.evaluate("CoupledPaymentID", node, XPathConstants.NODE);
		if (childNode != null && !isWhitespaceNode(childNode)) {
		    this.coupledPaymentID = childNode.getTextContent();
		}
	
	}
 
}