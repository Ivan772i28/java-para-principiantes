package clases;

import java.util.Vector;

import javax.microedition.io.ConnectionNotFoundException;
import javax.microedition.lcdui.*;

public class ListaContactos extends Form implements CommandListener, ItemStateListener {

	Command salir, Nuevo;
	Principal p;
	Vector contacts=new Vector();

	public ListaContactos(Principal midlet) {
		super("Agenda");
		p = midlet;
		salir = new Command("Salir", Command.EXIT, 0);
		Nuevo = new Command("Nuevo", Command.OK, 1);
		contactosPorDefecto();
		listarContactos();
		addCommand(salir);
		addCommand(Nuevo);
		setCommandListener(this);
		setItemStateListener(this);
	}

	public void contactosPorDefecto() {
		RMSOperaciones rms=new RMSOperaciones();
		rms.abrirZona("AgendaTelefonica");
		Contacto c=rms.listarRegistro(2);
		if(c==null){
			Contacto c1=new Contacto("Java1", "Zone1", "123456");
			Contacto c2=new Contacto("Java2", "Zone2", "123456");
			rms.adicionarRegistro(-1,c1);
			rms.adicionarRegistro(-1,c2);
			rms.cerrarZona();
		}else{
			rms.cerrarZona();
		}
	}
	
	public void listarContactos(){
		this.deleteAll();
		RMSOperaciones rms=new RMSOperaciones();
		rms.abrirZona("AgendaTelefonica");
		contacts.removeAllElements();
		for(int i=1;i<rms.numeroDeRegistros()+1;i++){
			Contacto c=rms.listarRegistro(i);
			if(c!=null){
				contacts.addElement(c);
				JZChoiceGroup cgcontactos=new JZChoiceGroup(i,c.getNombre()+" "+c.getApellido());
				cgcontactos.append("Actualizar", null);
				cgcontactos.append("Eliminar", null);
				cgcontactos.append("Detalles", null);
				cgcontactos.append("Llamar", null);
				cgcontactos.append("Enviar SMS", null);
				append(cgcontactos);
			}
		}
	}

	public void commandAction(Command c, Displayable arg1) {
		if (c == salir) {
			p.destroyApp(true);
			p.notifyDestroyed();
		} else {
			if (c == Nuevo) {
				FormaNuevo fn=new FormaNuevo(p,this);
				p.pantalla.setCurrent(fn);
			}
		}
	}

	public void itemStateChanged(Item item) {
		JZChoiceGroup cgp = (JZChoiceGroup) item;
		switch (cgp.getSelectedIndex()) {
		case 0:
			FormaActualizar fa=new FormaActualizar(p, this, (Contacto)contacts.elementAt(cgp.getIndice()-1));
			p.pantalla.setCurrent(fa);
			break;
		case 1:
			RMSOperaciones rmso=new RMSOperaciones();
			rmso.abrirZona("AgendaTelefonica");
			rmso.eliminarContactos(cgp.getIndice());
			rmso.cerrarZona();
			listarContactos();
			break;
		case 2:
			FormaDetalle fd=new FormaDetalle(p, this,((Contacto)contacts.elementAt(cgp.getIndice()-1)));
			p.pantalla.setCurrent(fd);
			break;
		case 3:
			try {
				p.platformRequest("tel:"+((Contacto)contacts.elementAt(cgp.getSelectedIndex()-1)).getTelefono());
			} catch (ConnectionNotFoundException e) {
				e.printStackTrace();
			}
			break;
		case 4:
			FormaSMS fsms=new FormaSMS(((Contacto)contacts.elementAt(cgp.getIndice()-1)).getTelefono());
			p.pantalla.setCurrent(fsms);
			break;
		}
	}
}
