
package triangulos;
import javax.swing.*;
/**
 *
 * @author Carolina EM
 */
public class Triangulos {

    
    public static void main(String[] args) {
        int opcion;
        do{
        TrianguloEquilatero tEq = new TrianguloEquilatero();
        tEq.capturar();
        tEq.calcular();
        JOptionPane.showMessageDialog(null,tEq.mostrar());
        
        TrianguloIsoseles tIso= new TrianguloIsoseles();
        tIso.capturar();
        tIso.calcular();
        JOptionPane.showMessageDialog(null, tIso.mostrar());
        
        TrianguloEscaleno tEsca = new TrianguloEscaleno();
        tEsca.capturar();
        tEsca.calcular();
        JOptionPane.showMessageDialog(null, tEsca.mostrar());
        
        TrianguloRectangulo tRec = new TrianguloRectangulo ();
        tRec.capturar();
        tRec.calcular();
        JOptionPane.showMessageDialog(null, tRec.mostrar());
        
            opcion=Integer.parseInt(JOptionPane.showInputDialog("1. REPETIR\n2. SALIR"));
        }while(opcion == 1);        
        System.exit(0);
    }
    
}

interface FigGeo{
    public void capturar();
    public String mostrar();
    public void calcular();
    
}

abstract class Triangulo implements FigGeo{
    double area,perimetro;
    public abstract void capturar();
    public String mostrar(){
        return "";
    }
    public abstract void calcular();
}

class TrianguloEquilatero extends Triangulo{
    
    double lado,area,perimetro;
    
    
    public void capturar(){
        
        try{
        lado=Double.parseDouble(JOptionPane.showInputDialog(null,"--Triangulo Equilatero-- Ingrese el valor del lado: "));
        while (lado<=0){
            JOptionPane.showMessageDialog(null, "ERROR VALOR NO VALIDO!!");
            lado=Double.parseDouble(JOptionPane.showInputDialog("Ingrese el valor del lado: "));
        }
        }catch(Exception e){
            
        }
    }

    public void calcular(){
        this.area=(Math.sqrt(3)/4)*Math.pow(lado,2);
        super.area=this.area;
        perimetro=(lado*3);
    }
    
    public String mostrar(){
        String s="Los valores del triangulo equilatero son: "+"\nLado: "+lado+"\nArea: "+area+"\nPerimetro: "+perimetro;
        return s;
        
    }
}

class TrianguloIsoseles extends Triangulo{
    
    double ladoIgual,area,base,perimetro;
    
    public void capturar(){
        ladoIgual=Double.parseDouble(JOptionPane.showInputDialog(null,"--Triangulo isoseles-- Ingrese el valor de los lados IGUALES: "));
        while(ladoIgual<=0){
            JOptionPane.showMessageDialog(null, "ERROR VALOR NO VALIDO!!","",2);
            ladoIgual=Double.parseDouble(JOptionPane.showInputDialog(null,"Ingrese el valor de los lados IGUALES: ",""));
        }
        base=Double.parseDouble(JOptionPane.showInputDialog(null,"Ingrese el valor de la base: ","Triangul Isoseles"));
        while(base>=ladoIgual || base<=0){
            JOptionPane.showMessageDialog(null, "ERROR VALOR NO VALIDO!!","",2);
            base=Double.parseDouble(JOptionPane.showInputDialog(null,"Ingrese el valor de la base: ",""));
        }
    }
    
    public void calcular(){
        area= (base*(Math.sqrt(Math.pow(ladoIgual,2)-(Math.pow(base,2)/4)))/2);
        perimetro=((ladoIgual*ladoIgual)+base);
    }
    
    public String mostrar(){
        String s="Los valores del triangulo isoceles son: "+"\nLados Igual: "+ladoIgual+"\nBase: "+base+"\nArea: "+area+"\nPerimetro: "+perimetro;
        return s;
        
    }
}

class TrianguloEscaleno extends Triangulo{
    
    double a,b,c,area,s;
    
    public void capturar(){
    a=Double.parseDouble(JOptionPane.showInputDialog(null,"--Triangulo Escaleno-- Ingrese el valor del lado 1: "));
    b=Double.parseDouble(JOptionPane.showInputDialog(null,"Ingrese el valor del lado 2: "));
    c=Double.parseDouble(JOptionPane.showInputDialog(null,"Ingrese el valor del lado 3: "));
    while(a<=0){
        JOptionPane.showMessageDialog(null, "ERROR VALOR NO VALIDO!!","",2);
        a=Double.parseDouble(JOptionPane.showInputDialog(null,"Ingrese el valor del lado 1: ",""));
    }
    while(b<=0){
        JOptionPane.showMessageDialog(null, "ERROR VALOR NO VALIDO!!","",2);
        b=Double.parseDouble(JOptionPane.showInputDialog(null,"Ingrese el valor del lado 2: ",""));
    }
    while(c<=0){
        JOptionPane.showMessageDialog(null, "ERROR VALOR NO VALIDO!!","",2);
        c=Double.parseDouble(JOptionPane.showInputDialog(null,"Ingrese el valor del lado 3: ",""));
    }
    }
    
    public void calcular(){
       
        s=(a+b+c/2);
        
        area=Math.sqrt(s*(s-a)*(s-b)*(s-c));
        perimetro=(a+b+c);
    }
    public String mostrar(){
    String s="Los valores del triangulo escaleno son: "+"\nLado 1: "+a+"\nLado 2: "+b+"\nLado 3: "+c+"\nArea: "+area+"\nPerimetro: "+perimetro;
    return s;
    
    }
}

class TrianguloRectangulo extends Triangulo{
    
    double base,altura,area;
    public void capturar(){
        base=Double.parseDouble(JOptionPane.showInputDialog(null,"--Triangulo rectangulo-- Ingrese el valor de la base: "));
        altura=Double.parseDouble(JOptionPane.showInputDialog(null,"Ingrese el valor de la altura: "));
           while(base<=0){
               JOptionPane.showMessageDialog(null, "ERROR VALOR NO VALIDO!!","",2);
               base=Double.parseDouble(JOptionPane.showInputDialog(null,"Ingrese el valor de la base: ","Triangulo rectangulo"));
           }
           while(altura<=0){
               JOptionPane.showMessageDialog(null, "ERROR VALOR NO VALIDO!!","",2);
               altura=Double.parseDouble(JOptionPane.showInputDialog(null,"Ingrese el valor de la altura: ","Triangulo Rectangulo"));
           }
    
    }
    public void calcular(){
        area=(base*altura)/2;
    }
    
    public String mostrar(){
        String s="Los valores del triangulo rectangulo son: "+"\nBase: "+base+"\nAltura: "+altura+"\nArea: "+area;
        return s;
        
    }
}
        
    
    

