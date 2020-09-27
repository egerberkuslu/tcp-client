package Views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.TextField;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import Controllers.LoginPanelController;

public class LoginPanelView extends JPanel{
    TextField userNameField;  
    JButton loginButton;
    JRadioButton setAnonRadioButton;
	LoginPanelController controller;
	
	public LoginPanelView() {
		init();	
	}
	
	
	public void init() {
		
		this.setBackground(Color.BLACK);
		loginButton = new JButton("Login");
		userNameField = new TextField("");
		userNameField.setPreferredSize( new Dimension( 200, 24 ) );
		setAnonRadioButton = new JRadioButton("Login as Anonymous");
		this.add(userNameField);
		this.add(setAnonRadioButton);
		this.add(loginButton);
		this.setVisible(true);

	}


	public TextField getUserNameField() {
		return userNameField;
	}


	public void setUserNameField(TextField userNameField) {
		this.userNameField = userNameField;
	}


	public JButton getLoginButton() {
		return loginButton;
	}


	public void setLoginButton(JButton loginButton) {
		this.loginButton = loginButton;
	}


	public JRadioButton getAnonRadioButton() {
		return setAnonRadioButton;
	}


	public void setSetAnonRadioButton(JRadioButton setAnonRadioButton) {
		this.setAnonRadioButton = setAnonRadioButton;
	}
}
