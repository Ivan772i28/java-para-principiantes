package clases;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.*;

public class Principal extends JFrame{
	
	JTextArea txt;
	Socket s;
	JTextField consulta;
	
	public Principal(){
		
		consulta=new JTextField();
		txt=new JTextArea();
		consulta.addKeyListener(new KeyListener(){

			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER){
					DataOutputStream dos;
					DataInputStream dis;
					try {
						dos = new DataOutputStream(s.getOutputStream());
						dis=new DataInputStream(s.getInputStream());
						dos.writeUTF(consulta.getText());
						txt.append(""+dis.readUTF()+"\n"+"-------------------------------------------------------");
					} catch (IOException ex) {
						// TODO Auto-generated catch block
						ex.printStackTrace();
					}
				}
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		try {
			s=new Socket("192.168.195.128",4444);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		add(consulta,BorderLayout.NORTH);
		add(new JScrollPane(txt));
	}
	
	public static void main(String arg[]){
		Principal p=new Principal();
		p.setVisible(true);
		p.setBounds(0, 0, 300, 200);
		p.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

}
