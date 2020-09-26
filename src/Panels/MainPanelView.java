package Panels;

import java.awt.Color;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JPanel;

import Controllers.MainPanelController;

public class MainPanelView extends JPanel{
	
	private  JButton sendRandomMessageButton;
	
	public MainPanelView() {
	}
	
	public JPanel init() {
		JPanel anaPanel = new JPanel();
		anaPanel.setBackground(Color.BLACK);
		sendRandomMessageButton = new JButton("Rastgele");
		anaPanel.add(sendRandomMessageButton);
		anaPanel.setVisible(true);
		try {
			new MainPanelController(this);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return anaPanel;
		
	}
	
	public JButton getSendRandomMessageButton() {
		return sendRandomMessageButton;
	}

	public void setSendRandomMessageButton(JButton sendRandomMessageButton) {
		this.sendRandomMessageButton = sendRandomMessageButton;
	}

	
}
