package clases;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

public class PanelSudoku extends JPanel{
	
	PanelNumeros celdas[][]=new PanelNumeros[9][9];
	Cuadrante cuadrantes[][]=new Cuadrante[3][3];
	
	public PanelSudoku(){
		setLayout(new GridLayout(9,9,5,5));
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				PanelNumeros pn=new PanelNumeros();
				if(i>2 && i<6  ||  j>2 && j<6){
					pn.pintar();
				}
				celdas[i][j]=pn;
				add(celdas[i][j]);
			}
		}
		Cuadrante c1=new Cuadrante();
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				c1.agregarCelda(celdas[i][j]);
			}
		}
		Cuadrante c2=new Cuadrante();
		for(int i=0;i<3;i++){
			for(int j=3;j<6;j++){
				c2.agregarCelda(celdas[i][j]);
			}
		}
		Cuadrante c3=new Cuadrante();
		for(int i=0;i<3;i++){
			for(int j=6;j<9;j++){
				c3.agregarCelda(celdas[i][j]);
			}
		}
		Cuadrante c4=new Cuadrante();
		for(int i=3;i<6;i++){
			for(int j=0;j<3;j++){
				c4.agregarCelda(celdas[i][j]);
			}
		}
		Cuadrante c5=new Cuadrante();
		for(int i=3;i<6;i++){
			for(int j=3;j<6;j++){
				c5.agregarCelda(celdas[i][j]);
			}
		}
		Cuadrante c6=new Cuadrante();
		for(int i=3;i<6;i++){
			for(int j=6;j<9;j++){
				c6.agregarCelda(celdas[i][j]);
			}
		}
		Cuadrante c7=new Cuadrante();
		for(int i=6;i<9;i++){
			for(int j=0;j<3;j++){
				c7.agregarCelda(celdas[i][j]);
			}
		}
		Cuadrante c8=new Cuadrante();
		for(int i=6;i<9;i++){
			for(int j=3;j<6;j++){
				c8.agregarCelda(celdas[i][j]);
			}
		}
		Cuadrante c9=new Cuadrante();
		for(int i=6;i<9;i++){
			for(int j=6;j<9;j++){
				c9.agregarCelda(celdas[i][j]);
			}
		}
	}
	
	public void asignarNumerosLeidos(String n[][]){
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				if(!n[i][j].equalsIgnoreCase("x")){
					celdas[i][j].setNumero(n[i][j]);
					celdas[i][j].setBloqueado(true);
					celdas[i][j].updateUI();
					updateUI();
				}else{
					celdas[i][j].setNumero("");
					celdas[i][j].colocarAyudas();
					celdas[i][j].updateUI();
					updateUI();
				}
			}
		}
		verificar();
	}
	
	public void verificar(){
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				verificarHorizontal(i);
				verificarVertical();
				verificarCuadricula();
			}
		}
	}

	private void verificarCuadricula() {
		
	}

	private void verificarVertical() {
		// TODO Auto-generated method stub
		
	}

	private void verificarHorizontal(int i) {
		ArrayList<String> numerosinvalidos=new ArrayList<String>();
		for(int j=0;j<9;j++){
			if(!celdas[i][j].getNumero().equalsIgnoreCase("")){
				numerosinvalidos.add(celdas[i][j].getNumero());
			}
		}
		for(int j=0;j<9;j++){
			for(int k=0;k<numerosinvalidos.size();k++){
				if(celdas[i][j].getNumero().equalsIgnoreCase(numerosinvalidos.get(k))){
					celdas[i][j].eliminarAyuda(Integer.parseInt(numerosinvalidos.get(k)));
				}
			}
		}
	}
	

}