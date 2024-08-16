package clases;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import javax.microedition.lcdui.*;

public class FormaActualizar extends Form implements CommandListener {

	Command actualizar, atras;
	TextField txtnombre, txtapellido, txttelefono;
	Principal midlet;
	Alert alerta;
	ListaContactos lc;
	Contacto contacto;

	public FormaActualizar(Principal mid, ListaContactos lcont, Contacto contacto) {
		super("Registro");
		midlet = mid;
		lc=lcont;
		this.contacto=contacto;
		txtnombre = new TextField("Nombre:", ""+contacto.getNombre(), 40, TextField.ANY);
		txtapellido = new TextField("Apellido:", ""+contacto.getApellido(), 40, TextField.ANY);
		txttelefono = new TextField("Telefono:", ""+contacto.getTelefono(), 40, TextField.NUMERIC);
		atras = new Command("Atras", Command.EXIT, 1);
		actualizar = new Command("Actualizar", Command.OK, 2);
		append(txtnombre);
		append(txtapellido);
		append(txttelefono);
		addCommand(actualizar);
		addCommand(atras);
		setCommandListener(this);
	}

	public void commandAction(Command c, Displayable d) {
		if (c == atras) {
			midlet.pantalla.setCurrent(lc);
			lc.listarContactos();
		} else {
			if (c == actualizar) {
				RMSOperaciones rmso = new RMSOperaciones();
				rmso.abrirZona("AgendaTelefonica");
				Contacto contactu=new Contacto(txtnombre.getString(), txtapellido.getString(), txttelefono.getString());
				if(rmso.actualizarRegistro(contacto,contactu)){
					alerta = new Alert("Mensaje", "Se ha actualizo exitosamente",
							null, AlertType.CONFIRMATION);
					alerta.setTimeout(1000);
					midlet.pantalla.setCurrent(alerta, this);
					txtnombre.setString("");
					txtapellido.setString("");
					txttelefono.setString("");
				}else{
					alerta = new Alert("Error", "No se pudo actualizar el registro",
							null, AlertType.CONFIRMATION);
					alerta.setTimeout(1000);
					midlet.pantalla.setCurrent(alerta, this);
				}
				rmso.cerrarZona();
			}
		}
	}
}