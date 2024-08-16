package clases;

import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;

public class Principal extends MIDlet {

	Display pantalla;
	ListaContactos lc;

	public Principal() {
		pantalla = Display.getDisplay(this);
		lc=new ListaContactos(this);
	}

	public void startApp() {
		pantalla.setCurrent(lc);
	}

	public void pauseApp() {
	}

	public void destroyApp(boolean x) {
	}
}