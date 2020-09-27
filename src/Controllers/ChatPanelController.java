package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Random;
import java.util.concurrent.Semaphore;

import Models.LoginPanelModel;
import Views.ChatPanelView;

public class ChatPanelController {

	private Socket socket;
	private PrintWriter out;
	private BufferedReader in;
	private Semaphore sem;

	public ChatPanelController(ChatPanelView chatPanelView, LoginPanelModel loginModel)
			throws UnknownHostException, IOException {
		socket = new Socket("127.0.0.1", 32532);
		out = new PrintWriter(socket.getOutputStream());
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		sem = new Semaphore(1);
		sendJoinMessage(loginModel);
		readMessage(chatPanelView);
		addListeners(chatPanelView, loginModel);
	}

	private void readMessage(ChatPanelView chatPanelView) {
		new Thread(() -> {
			System.out.println("Messages are trying to read from Client " + this.socket.getPort());
			String message;
			try {
				while ((message = in.readLine()) != null) {
					sem.acquire();
					chatPanelView.getConversationBox().append(message + "\n");
					sem.release();

				}
			} catch (IOException | InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			} finally {
				try {
					this.in.close();
					this.socket.close();
					System.out.println("Socket " + this.socket + " is closed");

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();

	}

	private void sendJoinMessage(LoginPanelModel loginModel) {
		out.println(loginModel.getUserName() + " has joined our chat.");
		out.flush();
	}

	public void addListeners(ChatPanelView chatPanelView, LoginPanelModel loginModel) {

		chatPanelView.getSendRandomMessageButton().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (!chatPanelView.getMessageField().getText().equals("")) {
					out.println(loginModel.getUserName() + ": " + chatPanelView.getMessageField().getText());
					out.flush();

				}
				chatPanelView.getMessageField().setText("");
			}
		});

		chatPanelView.getClearMessagesButton().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				chatPanelView.getConversationBox().setText("Welcome To CENG GANG Chat Room \n");
			}
		});
	}

}
