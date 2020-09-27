package Models;

import java.io.Serializable;

public class GeneralMessageModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Object generalMessageObject;
	private MessageTypes type;
	
	public GeneralMessageModel() {
		
	}
	
	public GeneralMessageModel(Object generalObject,MessageTypes type) {
		this.generalMessageObject = generalObject;
		this.type = type;
	}

	public Object getGeneralMessageObject() {
		return generalMessageObject;
	}

	public void setGeneralMessageObject(Object generalMessageObject) {
		this.generalMessageObject = generalMessageObject;
	}

	public MessageTypes getType() {
		return type;
	}

	public void setType(MessageTypes type) {
		this.type = type;
	}
	
	
}
