package clases;

import javax.microedition.lcdui.ChoiceGroup;

public class JZChoiceGroup extends ChoiceGroup{

	int indice;
	String nombre;
	
	public JZChoiceGroup(int i, String nom) {
		super(""+nom, ChoiceGroup.POPUP);
		indice=i;
		nombre=nom;
	}

	public int getIndice() {
		return indice;
	}

	public void setIndice(int indice) {
		this.indice = indice;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
