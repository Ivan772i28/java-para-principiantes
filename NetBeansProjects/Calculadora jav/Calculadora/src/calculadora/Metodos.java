/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

/**
 *
 * @author soloj
 */
public class Metodos {
    
   private String cadena;
   private double resultado;
   private boolean suma;
   private boolean resta;
   private boolean multiplicacion;
   private boolean division;
   
   
   public Metodos(){
      
   
       cadena="";
       suma=false;
       resta=false;
       multiplicacion=false;
       division=false;
   
   
   }
   
   public String concatenamiento(String cadena){
   
       this.cadena=this.cadena+cadena;
       return this.cadena;
       
   
   }
   
   public void suma(String cadena){
   
       this.resultado=Double.parseDouble(cadena);
       suma=true;
       this.cadena="";
   
   }
   
    public void resta(String cadena){
   
       this.resultado=Double.parseDouble(cadena);
       resta=true;
       this.cadena="";
   
   }
    
     public void multiplicacion(String cadena){
   
       this.resultado=Double.parseDouble(cadena);
       multiplicacion=true;
       this.cadena="";
   
   }
     
      public void division(String cadena){
   
       this.resultado=Double.parseDouble(cadena);
       division=true;
       this.cadena="";
   
   
   }
////////////////////////////////////////////////////////////////////////////////////////////////
               
   public double resultado(String numero){
   
       if(suma==true){
           
       resultado=resultado+Double.parseDouble(numero);
       
       }
       
       else if(resta==true){
           

       }resultado=resultado-Double.parseDouble(numero);
       
       }
       
           else if(multiplicacion==true){
           
       resultado=resultado*Double.parseDouble(numero);
       
       }
       
           else if(division==true){
           
       resultado=resultado/Double.parseDouble(numero);
       
       }
       
          
           
       resultado=Math.sqrt(Double.parseDouble(numero));
       
       
   
   {
       suma=falsswxae;
       resta=false;
       multiplicacion=false;
       division=false;
      
       
       return = 
       
   
               
    

