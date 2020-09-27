package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import Models.LoginPanelModel;
import Views.LoginPanelView;
import Views.ChatPanelView;

public class LoginPanelController {
	private LoginPanelView loginPanelView;
	private LoginPanelModel loginPanelModel;

	public LoginPanelController(LoginPanelView loginPanelView,LoginPanelModel loginPanelModel,JFrame mainFrame) {
		this.setLoginPanelView(loginPanelView);
		this.setLoginPanelModel(loginPanelModel);
		addLoginEvent(mainFrame);
	}

	public LoginPanelView getLoginPanelView() {
		return loginPanelView;
	}

	public void setLoginPanelView(LoginPanelView loginPanelView) {
		this.loginPanelView = loginPanelView;
	}
	
	
	public void addLoginEvent(JFrame mainFrame) {
		this.getLoginPanelView().getLoginButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(getLoginPanelView().getAnonRadioButton().isSelected() || loginPanelView.getUserNameField().getText().equals("")) {
					loginPanelModel.setUserName("Anonymous");
					loginPanelModel.setAnon(true);
				} else {
					loginPanelModel.setUserName(getLoginPanelView().getUserNameField().getText());
					loginPanelModel.setAnon(false);
				}
				login(mainFrame);
				
			}
		});
	}
	
	public void login(JFrame mainFrame) {
		mainFrame.getContentPane().removeAll();
		ChatPanelView chatView = new ChatPanelView();

			try {
				new ChatPanelController(chatView,loginPanelModel);
				mainFrame.add(chatView);
				mainFrame.revalidate();
				mainFrame.repaint();
				mainFrame.pack();
				//System.out.println("Logged as " + loginPanelModel.getUserName());
			} catch (UnknownHostException e) {
				//System.out.println("Couldnt' connect to the server!!!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				//System.out.println("Couldnt' connect to the server!!!");

			}
			
	}

	public LoginPanelModel getLoginPanelModel() {
		return loginPanelModel;
	}

	public void setLoginPanelModel(LoginPanelModel loginPanelModel) {
		this.loginPanelModel = loginPanelModel;
	}
}
