package Models;

public class LoginPanelModel {
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
