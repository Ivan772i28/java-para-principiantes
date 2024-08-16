
package metodos;
import alumno.alumno;
import java.io.FileWriter;
import java.util.*;

public class metodos {
    Vector vprincipal =new Vector();
    
    public void guardar (alumno unAlumno){
        vprincipal.addElement(unalumno);
        
    }
    public void guardarArchivo(alumno alumno){
        try{
            FileWriter fw= new FileWriter("alumno.txt",true);
            BufferredWriter bw = new BufferredWriter(fw);
            printWriter pw= new printWriter(bw);
            pw.print(alumno.getNombre());
            pw.print("|"+alumno.getApepat());
            pw.print("|"+alumno.getApemat());
            pw.print("|"+alumno.getCurp()t());
            pw.print("|"+alumno.getCarrera());
             

        }catch(Exception e)
        
    }
}
