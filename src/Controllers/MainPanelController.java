package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Random;

import Panels.MainPanelView;

public class MainPanelController {
	MainPanelView mainPanelView;
	Socket socket;
	PrintWriter out;
	public MainPanelController(MainPanelView mainPanelView) throws UnknownHostException, IOException {
			this.mainPanelView = mainPanelView;
			socket = new Socket("127.0.0.1", 32532);
			out = new PrintWriter(socket.getOutputStream());
			randomMessageSend();
	}
	
	public void randomMessageSend() {
		mainPanelView.getSendRandomMessageButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Random ran = new Random(); 
				int nxt = ran.nextInt(100); 
				out.println(nxt);
				out.flush();
			}
		});
	}
	
	
}
