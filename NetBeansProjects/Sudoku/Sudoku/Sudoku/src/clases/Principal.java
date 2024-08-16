package clases;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Random;

import javax.swing.*;

public class Principal extends JFrame{
	
	PanelSudoku ps;
	JMenuBar menu;
	
	public Principal(){
		
		colcarSkin();
		
		setLayout(new FlowLayout());
		
		ps=new PanelSudoku();
		ps.setPreferredSize(new Dimension(510,525));
		
		menu=new JMenuBar();
		JMenu archivo=new JMenu("Archivo");
		JMenuItem abrir=new JMenuItem("Abrir");
		abrir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser selector=new JFileChooser();
				int resultado=selector.showOpenDialog(null);
				if(resultado==JFileChooser.APPROVE_OPTION){
					try {
						String [][]st=new String[9][9];
						File f=selector.getSelectedFile();
						BufferedReader in=new BufferedReader(new FileReader(f));
						String data="";
						data=in.readLine();
						int i=0;
						while(data!=null){
						for(int j=0;j<9;j++){
							st[i][j]=""+data.charAt(j);
						}
						i++;
						data=in.readLine(); 
						}
						ps.asignarNumerosLeidos(st);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		JMenuItem nuevo=new JMenuItem("Nuevo");
		nuevo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					remove(ps);
					ps=new PanelSudoku();
					ps.setPreferredSize(new Dimension(510,525));
					String [][]st=new String[9][9];
					Random r=new Random();
					int x=(int)(r.nextDouble()*5);
					File f=new File(getClass().getResource("/lib/"+x+".txt").toURI());
					BufferedReader in=new BufferedReader(new FileReader(f));
					String data="";
					data=in.readLine();
					int i=0;
					while(data!=null){
					for(int j=0;j<9;j++){
						st[i][j]=""+data.charAt(j);
					}
					i++;
					data=in.readLine(); 
					}
					ps.asignarNumerosLeidos(st);
					add(ps);
					repaint();
					ps.updateUI();
				} catch (URISyntaxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		JMenuItem salir=new JMenuItem("Salir");
		salir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
		JMenu ayuda=new JMenu("Ayuda");
		JMenuItem acercade=new JMenuItem("Acerca de");
		acercade.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Desarrollado por Roger Villamarin para Java Zone");
			}
		});
		
		archivo.add(abrir);
		archivo.add(nuevo);
		archivo.add(salir);
		ayuda.add(acercade);
		menu.add(archivo);
		menu.add(ayuda);
		setJMenuBar(menu);
		
		add(ps);
	}
	
	public void colcarSkin() {
		try {
			 UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
			} catch (ClassNotFoundException e) {
			 e.printStackTrace();
			} catch (InstantiationException e) {
			 e.printStackTrace();
			} catch (IllegalAccessException e) {
			 e.printStackTrace();
			} catch (UnsupportedLookAndFeelException e) {
			 e.printStackTrace();
			}
	}

	public static void main(String arg[]){
		Principal p=new Principal();
		p.setVisible(true);
		p.setBounds(0, 0, 550, 600);
		p.setLocationRelativeTo(null);
		p.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
}
