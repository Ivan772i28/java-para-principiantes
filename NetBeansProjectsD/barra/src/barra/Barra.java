
package barra;

public class Barra {
    /**
     * 
     * este codigo sirver para que la barra al momento de que el tiempo de carga se dirija a otra pantalla
     */
    public static void main(String[] args)
    {
        
        presentacion pre=new presentacion();//este sirve´para cargar otra pantalla
         pre.setVisible(true);
        ventana1 iniciar=new ventana1();
       
        
        try{
            for(int i=0;i<=100;i++){
                Thread.sleep(100);// de cuanto a cuanto va saltando la barra
                pre.porcentaje.setText(Integer.toString(i)+"%");//ese el el porcentaje que recaba la barra
                pre.barra.setValue(i);
              if(i==100){
                  pre.setVisible(false);//si i es igual al 100 se inciara la otra pantalla
                  iniciar.setVisible(true);
              }
            }
        }catch(Exception e){
            
        }
    }
    
}
