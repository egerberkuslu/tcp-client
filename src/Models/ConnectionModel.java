package Models;

import java.io.Serializable;
import java.net.Socket;

public class ConnectionModel implements Serializable {


	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int portNo;
	private LoginPanelModel loginModel;

	
	public ConnectionModel() {
		// TODO Auto-generated constructor stub
	}

	public ConnectionModel(int portNo, LoginPanelModel loginModel) {
		super();
		this.portNo = portNo;
		this.loginModel = loginModel;

	}

	public int getPortNo() {
		return portNo;
	}

	public void setSocket(int portNo) {
		this.portNo = portNo;
	}

	public LoginPanelModel getLoginModel() {
		return loginModel;
	}

	public void setLoginModel(LoginPanelModel loginModel) {
		this.loginModel = loginModel;
	}

	
	

}
