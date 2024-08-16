package clases;

import javax.microedition.lcdui.Display;
import javax.microedition.midlet.MIDlet;
import javax.microedition.midlet.MIDletStateChangeException;

public class Principal extends MIDlet {

	Pantalla p;
	Display d;
	public Principal() {
		p=new Pantalla(this);
		d=Display.getDisplay(this);
	}

	protected void destroyApp(boolean arg0) throws MIDletStateChangeException {
	}

	protected void pauseApp() {
	}

	protected void startApp() throws MIDletStateChangeException {
		d.setCurrent(p);
	}
}
