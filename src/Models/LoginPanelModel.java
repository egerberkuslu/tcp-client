package Models;

import java.io.Serializable;

public class LoginPanelModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1307322031752981337L;
	private String userName;
	private boolean isAnon;
	
	public LoginPanelModel() {
		userName = "";
		isAnon = false;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public boolean isAnon() {
		return isAnon;
	}

	public void setAnon(boolean isAnon) {
		this.isAnon = isAnon;
	}
	
	
}
