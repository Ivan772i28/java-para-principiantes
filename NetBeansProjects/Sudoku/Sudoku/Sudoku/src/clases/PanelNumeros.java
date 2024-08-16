package clases;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.border.BevelBorder;

public class PanelNumeros extends JPanel implements MouseListener{

	String numero="";
	JLabel lnumero;
	boolean pintado=false;
	boolean bloqueado=false;
	PanelAyuda payudas[][]=new PanelAyuda[3][3];
	
	public PanelNumeros(){
		setLayout(new BorderLayout());
		setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		setBackground(Color.WHITE);
		lnumero=new JLabel("   "+numero);
		lnumero.setFont(new Font("Arial", Font.BOLD,20));
		add(lnumero);
	}
	
	public void colocarNumero(int n){
		numero=""+n;
		removeAll();
		setLayout(new BorderLayout());
		lnumero.setText("   "+numero);
		add(lnumero);
		addMouseListener(this);
	}
	
	public void eliminarAyuda(int num){
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				if(payudas[i][j]!=null){
					System.out.println(payudas[i][j].getNum()+"--"+num);
					if(payudas[i][j].getNum()==num){
						payudas[i][j].setNum(0);
					}
				}
			}
		}
	}
	
	public void colocarAyudas(){
		if(bloqueado==false){
			numero="";
			removeAll();
			setLayout(new GridLayout(3,3,1,1));
			int n=1;
			for(int i=0;i<3;i++){
				for(int j=0;j<3;j++){
					PanelAyuda p=new PanelAyuda(this,n);
					payudas[i][j]=p;
					p.setLayout(new BorderLayout());
					if(pintado){
						p.setBackground(Color.LIGHT_GRAY);
					}else{
						p.setBackground(Color.WHITE);
					}
					JLabel l=new JLabel(" "+n);
					p.add(l);
					add(payudas[i][j]);
					n++;
				}
			}
		}
	}
	
	public void pintar(){
		setBackground(Color.LIGHT_GRAY);
		pintado=true;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
		lnumero.setText("   "+numero);
	}
	
	public PanelAyuda[][] getPayudas() {
		return payudas;
	}

	public void setPayudas(PanelAyuda[][] payudas) {
		this.payudas = payudas;
	}
	
	public boolean isBloqueado() {
		return bloqueado;
	}

	public void setBloqueado(boolean bloqueado) {
		this.bloqueado = bloqueado;
	}
	

	@Override
	public void mouseClicked(MouseEvent e) {
		colocarAyudas();
		updateUI();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
