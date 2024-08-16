package clases;

import java.util.ArrayList;

public class Cuadrante{
	
	ArrayList<PanelNumeros> celdas=new ArrayList<PanelNumeros>();
	
	public Cuadrante(){
		
	}
	
	public void agregarCelda(PanelNumeros pn){
		celdas.add(pn);
	}

	public ArrayList<PanelNumeros> getCeldas() {
		return celdas;
	}

	public void setCeldas(ArrayList<PanelNumeros> celdas) {
		this.celdas = celdas;
	}
	
	

}
