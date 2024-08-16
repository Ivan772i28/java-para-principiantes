package clases;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class PanelAyuda extends JPanel implements MouseListener{
	
	int num=0;
	JLabel lnum;
	PanelNumeros pn;
	
	public PanelAyuda(PanelNumeros pnum,int numero){
		
		pn=pnum;
		num=numero;
		setLayout(new BorderLayout());
		if(num!=0){
			lnum=new JLabel(" "+num);
		}else{
			lnum=new JLabel("");
		}
		add(lnum);
		addMouseListener(this);
		
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
		removeAll();
		setLayout(new BorderLayout());
		if(num!=0){
			lnum=new JLabel(" "+num);
		}else{
			lnum=new JLabel("");
		}
		add(lnum);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(num!=0){
			pn.colocarNumero(num);
			pn.updateUI();
		}
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
