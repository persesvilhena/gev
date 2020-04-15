package br.com.projeto.gui;

import java.awt.GraphicsConfiguration;
import javax.swing.JFrame;

public class Window {


	

		
		static GraphicsConfiguration gc;
		public static void main(String[] args){
			JFrame frame= new JFrame(gc);	
			frame.setVisible(true);
		}
	
}
