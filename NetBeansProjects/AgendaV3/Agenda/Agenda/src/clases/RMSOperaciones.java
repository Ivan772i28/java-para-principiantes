package clases;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import javax.microedition.rms.*;

public class RMSOperaciones {

	RecordStore rs;

	public RMSOperaciones() {
	}

	public boolean abrirZona(String nombreZona) {
		try {
			rs = RecordStore.openRecordStore(nombreZona, true);
			return true;
		} catch (RecordStoreException e) {
			e.toString();
			return false;
		}
	}

	public boolean adicionarRegistro(int indice,Contacto c) {
		try {
			byte[] mensaje;
			ByteArrayOutputStream baos=new ByteArrayOutputStream();
			DataOutputStream dos=new DataOutputStream(baos);
			dos.writeUTF(c.getNombre());
			dos.writeUTF(c.getApellido());
			dos.writeUTF(c.getTelefono());
			mensaje = baos.toByteArray();
			if(indice!=-1){
				rs.setRecord(indice,mensaje, 0, mensaje.length);
			}else{
				rs.addRecord(mensaje, 0, mensaje.length);
			}
			System.out.println(c.getNombre()+"-"+c.getApellido());
			return true;
		} catch (RecordStoreException e) {
			e.toString();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean adicionarRegistro(String valor) {
		byte[] mensaje;
		mensaje = valor.getBytes();
		try {
			rs.addRecord(mensaje, 0, mensaje.length);
			return true;
		} catch (RecordStoreException e) {
			e.toString();
			return false;
		}
	}

	public String listarRegistro() {
		byte[] reg = new byte[100];
		int tam;
		String buffer = "";
		try {
			for (int i = 1; i <= rs.getNumRecords(); i++) {
				tam = rs.getRecordSize(i);
				reg = rs.getRecord(i);
				buffer += "\n" + i + new String(reg, 0, tam);
			}

		} catch (RecordStoreException e) {
			System.out.println("Error de Lectura 1");
		}
		return buffer;
	}
	
	public int numeroDeRegistros(){
		try {
			return rs.getNumRecords();
		} catch (RecordStoreNotOpenException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public void eliminarContactos(){
		try {
			for(int i=1;i<rs.getNumRecords()+1;i++){
				rs.deleteRecord(i);
			}
		} catch (RecordStoreNotOpenException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidRecordIDException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RecordStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void eliminarContactos(int i){
		try {
			rs.deleteRecord(i);
		} catch (RecordStoreNotOpenException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidRecordIDException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RecordStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean actualizarRegistro(Contacto c, Contacto cact){
		try {
			String n=c.getNombre()+" "+c.getApellido();
			for(int i=1;i<rs.getNumRecords()+1;i++){
				byte[] reg = new byte[100];
				reg=rs.getRecord(i);
				ByteArrayInputStream bais= new ByteArrayInputStream(reg);
				DataInputStream dis=new DataInputStream(bais);
				String nom=dis.readUTF();
				String ape=dis.readUTF();
				System.out.println(n+"--"+nom+" "+ape);
				if(n.equalsIgnoreCase(nom+" "+ape)){
					System.out.println(i);	
					adicionarRegistro(i, cact);
					return true;
				}
			}
			return false;
		} catch (RecordStoreNotOpenException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		} catch (InvalidRecordIDException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (RecordStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public Contacto listarRegistro(int r) {
		byte[] reg = new byte[100];
		Contacto c=null;
		ByteArrayInputStream bais;
		DataInputStream dis;
		String[] datos = new String[3];
		try {
			reg = rs.getRecord(r);
			bais = new ByteArrayInputStream(reg);
			dis = new DataInputStream(bais);
			c=new Contacto(dis.readUTF(), dis.readUTF(), dis.readUTF());
		} catch (RecordStoreException e) {
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}

	public boolean cerrarZona() {
		try {
			rs.closeRecordStore();
			return true;
		} catch (RecordStoreException e) {
			e.toString();
			return false;
		}
	}
}