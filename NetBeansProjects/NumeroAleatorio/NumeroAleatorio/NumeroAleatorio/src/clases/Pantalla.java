package clases;

import java.util.Random;

import javax.microedition.lcdui.*;
import javax.microedition.midlet.MIDlet;
import javax.microedition.midlet.MIDletStateChangeException;

public class Pantalla extends Form implements CommandListener{

	Command generar, salir;
	Principal p;
	Alert alerta;
	public Pantalla(Principal prin) {
		super("Java Zone");
		p=prin;
		generar=new Command("Generar Numero", Command.OK, 2);
		salir=new Command("Salir", Command.CANCEL, 1);
		addCommand(generar);
		addCommand(salir);
		setCommandListener(this);
	}

	public void commandAction(Command arg0, Displayable arg1) {
		Command c=(Command)arg0;
		if(c.equals(salir)){
			try {
				p.destroyApp(true);
				p.notifyDestroyed();
			} catch (MIDletStateChangeException e) {
				e.printStackTrace();
			}
		}else{
			if(c.equals(generar)){
				 Random r=new Random();
				 r.setSeed(System.currentTimeMillis());
				 int inicio=10;
				 int fin=50;
				 long rangox = (long)fin - (long)inicio + 1;
				 long fx = (long)(rangox * r.nextDouble());
				 int n=(int)(fx + (long)inicio); 
				alerta=new Alert("Numero Aleatorio entre 10 y 50", ""+n, null, AlertType.CONFIRMATION);
				alerta.setTimeout(Alert.FOREVER);
				p.d.setCurrent(alerta, this);
			}
		}
	}
}