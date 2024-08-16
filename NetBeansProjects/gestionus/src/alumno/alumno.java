/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alumno;

public class alumno {
    String nombre;
    String Apepat;
    String Apemat;
    String Curp;
    String Carrera;

    public alumno(String nombre, String Apepat, String Apemat, String Curp, String Carrera) {
        this.nombre = nombre;
        this.Apepat = Apepat;
        this.Apemat = Apemat;
        this.Curp = Curp;
        this.Carrera = Carrera;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApepat() {
        return Apepat;
    }

    public void setApepat(String Apepat) {
        this.Apepat = Apepat;
    }

    public String getApemat() {
        return Apemat;
    }

    public void setApemat(String Apemat) {
        this.Apemat = Apemat;
    }

    public String getCurp() {
        return Curp;
    }

    public void setCurp(String Curp) {
        this.Curp = Curp;
    }

    public String getCarrera() {
        return Carrera;
    }

    public void setCarrera(String Carrera) {
        this.Carrera = Carrera;
    }
    
    
}
