package clases;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import javax.microedition.lcdui.*;

public class FormaNuevo extends Form implements CommandListener {

	Command guardar, atras;
	TextField txtnombre, txtapellido, txttelefono;
	Principal midlet;
	Alert alerta;
	ListaContactos lc;

	public FormaNuevo(Principal mid, ListaContactos lcont) {
		super("Registro");
		midlet = mid;
		lc=lcont;
		txtnombre = new TextField("Nombre:", "", 40, TextField.ANY);
		txtapellido = new TextField("Apellido:", "", 40, TextField.ANY);
		txttelefono = new TextField("Telefono:", "", 40, TextField.NUMERIC);
		atras = new Command("Atras", Command.EXIT, 1);
		guardar = new Command("Guardar", Command.OK, 2);
		append(txtnombre);
		append(txtapellido);
		append(txttelefono);
		addCommand(guardar);
		addCommand(atras);
		setCommandListener(this);
	}

	public void commandAction(Command c, Displayable d) {
		if (c == atras) {
			midlet.pantalla.setCurrent(lc);
			lc.listarContactos();
		} else {
			if (c == guardar) {
				RMSOperaciones rmso = new RMSOperaciones();
				rmso.abrirZona("AgendaTelefonica");
				Contacto contacto=new Contacto(txtnombre.getString(), txtapellido.getString(), txttelefono.getString());
				rmso.adicionarRegistro(-1,contacto);
				rmso.cerrarZona();
				alerta = new Alert("Mensaje", "Se ha guardado exitosamente",
						null, AlertType.CONFIRMATION);
				alerta.setTimeout(1000);
				midlet.pantalla.setCurrent(alerta, this);
				txtnombre.setString("");
				txtapellido.setString("");
				txttelefono.setString("");
			}
		}
	}
}