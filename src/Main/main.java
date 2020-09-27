package Main;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import Controllers.ChatPanelController;
import Controllers.LoginPanelController;
import Models.LoginPanelModel;
import Views.ChatPanelView;
import Views.LoginPanelView;
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JFrame mainFrame = new JFrame();
		mainFrame.setSize(new Dimension(600,600));
			
		LoginPanelView loginView = new LoginPanelView();
		LoginPanelModel loginModel = new LoginPanelModel();
		new LoginPanelController(loginView, loginModel,mainFrame);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.add(loginView);
		mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		mainFrame.setVisible(true);
		
		
		
	}

}
