package Main;

import java.awt.Dimension;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import Controllers.MainPanelController;
import Panels.MainPanelView;
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JFrame mainFrame = new JFrame();
		mainFrame.setSize(new Dimension(300,400));
		MainPanelView anaEkran = new MainPanelView();
		mainFrame.add(anaEkran.init());
		mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		mainFrame.setVisible(true);
		
		
		
	}

}
