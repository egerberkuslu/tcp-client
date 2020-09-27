package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Random;
import java.util.concurrent.Semaphore;

import javax.swing.SwingUtilities;

import Models.ConnectionModel;
import Models.GeneralMessageModel;
import Models.LoginPanelModel;
import Models.MessageTypes;
import Views.ChatPanelView;

public class ChatPanelController {

	private Socket socket;
	private BufferedReader in;
	private Semaphore sem;
	private ObjectOutputStream objectOutput;

	public ChatPanelController(ChatPanelView chatPanelView, LoginPanelModel loginModel)
			throws UnknownHostException, IOException {
		socket = new Socket("localhost", 32533);
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		sem = new Semaphore(1);
		objectOutput = new ObjectOutputStream(socket.getOutputStream());
		sendJoinMessage(loginModel);
		readMessage(chatPanelView);
		addListeners(chatPanelView, loginModel);
	}

	private void readMessage(ChatPanelView chatPanelView) {
		new Thread(() -> {
			// System.out.println("Messages are trying to read from Client " +
			// this.socket.getPort());
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
		// out.println(loginModel.getUserName() + " has joined our chat.");
		try {
			objectOutput.writeObject(new GeneralMessageModel(new ConnectionModel(this.socket.getPort(), loginModel),
					MessageTypes.LoginMessage));
			objectOutput.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void sendMessage(GeneralMessageModel generalMessage) {
		// TODO Auto-generated method stub
		try {
			objectOutput.writeObject(generalMessage);
			objectOutput.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block

		}
	}

	public void addListeners(ChatPanelView chatPanelView, LoginPanelModel loginModel) {
		
		chatPanelView.getSendRandomMessageButton().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (!chatPanelView.getMessageField().getText().equals("")) {
					sendMessage(new GeneralMessageModel(chatPanelView.getMessageField().getText(),
							MessageTypes.normalMessage));
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

		chatPanelView.getMessageField().addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent arg0) {
				if (chatPanelView.getMessageField().getText().equals("")) {
					chatPanelView.getMessageField().setText("Your Messages Here");
				} else {
					if (chatPanelView.getMessageField().getText().equals("Your Messages Here")) {
						chatPanelView.getMessageField().setText("");
					}
				}

			}

			@Override
			public void focusGained(FocusEvent arg0) {
				if (chatPanelView.getMessageField().getText().equals("Your Messages Here")) {
					chatPanelView.getMessageField().setText("");
				}
			}
		});
	
	}

}
