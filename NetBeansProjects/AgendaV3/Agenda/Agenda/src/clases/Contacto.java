package clases;

public class Contacto {
	
	String nombre;
	String apellido;
	String telefono;
	
	public Contacto(String n, String a, String t){
		nombre=n;
		apellido=a;
		telefono=t;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

}
