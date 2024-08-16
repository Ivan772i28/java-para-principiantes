package clases;

import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;

import java.awt.event.KeyEvent;

import chrriis.common.UIUtils;
import chrriis.dj.nativeswing.swtimpl.NativeInterface;
import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;

import javax.swing.JTextField;
import java.awt.Font;
import java.awt.SystemColor;
import java.util.ArrayList;

public class principal extends JFrame {

	JTextField txt = null;
	ArrayList<JWebBrowser> navegadores=new ArrayList<JWebBrowser>();
	JTabbedPane pestañas=new JTabbedPane();
	
	public static void main(String[] args) {
		
		UIUtils.setPreferredLookAndFeel();
	    NativeInterface.open();
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try
				{
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());}
				catch (Exception e)
				{
					e.printStackTrace();
				}
				principal thisClass = new principal();
			}
		});
		 NativeInterface.runEventPump();
	}

	public principal() {
		super();
		
		JWebBrowser navegador1 = new JWebBrowser();
		JWebBrowser navegador2 = new JWebBrowser();
		JWebBrowser navegador3 = new JWebBrowser();
		
		navegadores.add(navegador1);
		navegadores.add(navegador2);
		navegadores.add(navegador3);
		
		JPanel pdireccion=new JPanel();
		pdireccion.setLayout(new BorderLayout());
		
		txt = new JTextField();
		txt.setText("http://www.google.com");
		txt.setForeground(SystemColor.textHighlight);
		txt.setFont(new Font("Dialog", Font.PLAIN, 18));
		txt.addKeyListener(new java.awt.event.KeyAdapter() {   
			public void keyPressed(java.awt.event.KeyEvent e) {    
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
				{
					if (e.getSource()==txt)
					{
						navegadores.get(pestañas.getSelectedIndex()).navigate(txt.getText());
					}
				 }
			}
		});
		
		pdireccion.add(txt);
		
		add(pdireccion,BorderLayout.NORTH);
		for(int i=0;i<navegadores.size();i++){
			
			navegadores.get(i).navigate(txt.getText());
			navegadores.get(i).setStatusBarVisible(false);
			navegadores.get(i).setBarsVisible(false);
			navegadores.get(i).setButtonBarVisible(false);
				
			JPanel panelPrincipal=new JPanel();
			panelPrincipal.setLayout(new BorderLayout());
			panelPrincipal.add(navegadores.get(i));
			pestañas.addTab("Pestaña "+(i+1), panelPrincipal);
		}
		add(pestañas);
		this.setBounds(0, 0, 800, 600);
		this.setLocationRelativeTo(null);
		this.setTitle("JavaZone Browser");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
}  
