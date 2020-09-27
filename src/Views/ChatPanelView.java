package Views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.TextComponent;
import java.awt.TextField;
import java.io.IOException;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JPanel;

import Controllers.ChatPanelController;

public class ChatPanelView extends JPanel{
	
	private JButton sendMessageButton;
	private TextArea conversationBox;
	private TextField messageField;
	private JButton clearMessagesButton;


	public ChatPanelView() {
		init();
	}
	
	public void init() {
		this.setLayout(new GridLayout(2,0));		
		this.setBackground(Color.BLACK);
		
		sendMessageButton = new JButton("Mesaj Gönder");
		conversationBox = new TextArea();
		messageField = new TextField();
		messageField.setText("Your Messages Here");
		clearMessagesButton = new JButton("Mesajlari Temizle");
		conversationBox.append("Welcome To CENG GANG Chat Room \n");
		conversationBox.setBackground(Color.black);
		conversationBox.setForeground(Color.green);
		JPanel messagesPanel = new JPanel();
		messagesPanel.setLayout(new GridLayout(1,0));
		messagesPanel.setBackground(Color.BLACK);
		messagesPanel.add(conversationBox);

		
		JPanel othersPanel = new JPanel();
		othersPanel.setBackground(Color.BLACK);
		messageField.setPreferredSize( new Dimension( 200, 24 ) );
		
		othersPanel.add(messageField);
		othersPanel.add(sendMessageButton);
		othersPanel.add(clearMessagesButton);
		this.setFocusable(true);
		this.requestFocusInWindow();
		this.add(messagesPanel);
		this.add(othersPanel);
		
		
		this.setVisible(true);
		conversationBox.setEditable(false);

		
	}
	
	public JButton getSendRandomMessageButton() {
		return sendMessageButton;
	}

	public void setSendRandomMessageButton(JButton sendRandomMessageButton) {
		this.sendMessageButton = sendRandomMessageButton;
	}

	public TextArea getConversationBox() {
		return conversationBox;
	}

	public void setConversationBox(TextArea conversationBox) {
		this.conversationBox = conversationBox;
	}

	public TextField getMessageField() {
		return messageField;
	}

	public void setMessageField(TextField messageField) {
		this.messageField = messageField;
	}

	public JButton getClearMessagesButton() {
		return clearMessagesButton;
	}

	public void setClearMessagesButton(JButton clearMessagesButton) {
		this.clearMessagesButton = clearMessagesButton;
	}

	




	
}
