package clases;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import javax.microedition.lcdui.*;

public class FormaDetalle extends Form implements CommandListener {

	Command atras;
	StringItem txtnombre, txtapellido, txttelefono;
	Principal midlet;
	Alert alerta;
	ListaContactos lc;

	public FormaDetalle(Principal mid, ListaContactos lcont, Contacto contacto) {
		super("Detalle");
		midlet = mid;
		lc=lcont;
		txtnombre = new StringItem("Nombre:", ""+contacto.getNombre());
		txtapellido = new StringItem("Apellido:", ""+contacto.getApellido());
		txttelefono = new StringItem("Telefono:", ""+contacto.getTelefono());
		atras = new Command("Atras", Command.EXIT, 1);
		append(txtnombre);
		append(txtapellido);
		append(txttelefono);
		addCommand(atras);
		setCommandListener(this);
	}

	public void commandAction(Command c, Displayable d) {
		if (c == atras) {
			midlet.pantalla.setCurrent(lc);
			lc.listarContactos();
		} 
	}
}