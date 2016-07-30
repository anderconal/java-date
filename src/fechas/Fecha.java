package fechas;


import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alumno
 */
public class Fecha {
  
    public static void main(String[] args) {

        String fecha=JOptionPane.showInputDialog
        ("INTRODUZCA FECHA EN FORMATO dd/mm/aaaa: ");
                
        GregorianCalendar gc=new GregorianCalendar();
        
        String dia=fecha.substring(0, 2);
        int diaInt=Integer.parseInt(dia);
        String mes=fecha.substring(fecha.indexOf("/")+1,fecha.lastIndexOf('/'));
        int mesInt=Integer.parseInt(mes);
        String año=fecha.substring(fecha.lastIndexOf("/")+1);
        int añoInt=Integer.parseInt(año);

        gc.set(Calendar.DAY_OF_MONTH, diaInt);
        gc.set(Calendar.MONTH, mesInt-1);
        gc.set(Calendar.YEAR, añoInt);
        
        JOptionPane.showMessageDialog
        (null, "La fecha introducida es "+mostrar(gc),"FECHA",JOptionPane.PLAIN_MESSAGE);
        
        JOptionPane.showMessageDialog(null, "Ahora, añadimos 30 días. Si la fecha cae en Sábado o Domingo, pasarla al "
                + "lunes siguiente");
        
        gc.add(Calendar.DAY_OF_MONTH, 30);
        
        JOptionPane.showMessageDialog(null, "La fecha resultante es "
         +mostrar(gc),"FECHA",JOptionPane.PLAIN_MESSAGE);
        if(gc.get(Calendar.DAY_OF_WEEK)==Calendar.SATURDAY||
           gc.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY){            
            
           gc.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);   
           
           JOptionPane.showMessageDialog(null, "La fecha resultante es "
           +mostrar(gc),"FECHA",JOptionPane.PLAIN_MESSAGE);
           
           
        }
        JOptionPane.showMessageDialog(null, "Modificamos la fecha para que "
                + "apunte al siguiente día 15","FECHA",JOptionPane.PLAIN_MESSAGE);
        
        if(gc.get(Calendar.DAY_OF_MONTH)<15){
            gc.set(Calendar.DAY_OF_MONTH, 15);
        }else{
            gc.set(gc.get(Calendar.YEAR), gc.get(Calendar.MONTH)+1,15);
        }
               
        JOptionPane.showMessageDialog(null, "La fecha resultante es "
           +mostrar(gc),"FECHA",JOptionPane.PLAIN_MESSAGE);       
        
        String[]trimestre={"PRIMER TRIMESTRE","SEGUNDO TRIMESTRE","TERCER TRIMESTRE","CUARTO TRIMESTRE"};
        String trimestres="";
        
        switch (gc.get(Calendar.MONTH)) {
            case 0:case 1:case 2:
                trimestres=trimestre[0];
                break;
            case 3:case 4:case 5:
                trimestres=trimestre[1];
                break;
            case 6:case 7:case 8:
                trimestres=trimestre[2];
                break;
            case 9:case 10: case 11:
                trimestres=trimestre[3];
        }
        
        boolean laborable;
        String yesNo;
        if (gc.get(Calendar.DAY_OF_WEEK)==Calendar.SATURDAY||
            gc.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY) {
          laborable=false;  
          yesNo="NO";
        }else{
            laborable=true;
            yesNo="SÍ";
        }
        
        JOptionPane.showMessageDialog(null, "TRIMESTRE: "+trimestres+" ¿ES LABORABLE? "+yesNo);
        
        int año1=2015,mes1=0,dia1=1;
      
        GregorianCalendar gd=new GregorianCalendar(año1,mes1,dia1);
        
        long milis1=gd.getTimeInMillis();
        long milis2=gc.getTimeInMillis();
        long diferencia=milis2-milis1;
        long diffDays = diferencia / (24 * 60 * 60 * 1000);
        
        JOptionPane.showMessageDialog(null, "HAN PASADO "+diffDays+" DESDE "+mostrar(gd)+" Y "+mostrar(gc));
        
        int año2=2015,mes2=11,dia2=31;
        GregorianCalendar ge=new GregorianCalendar(año2,mes2,dia2);
        long milis3=ge.getTimeInMillis();
        long milis4=gc.getTimeInMillis();
        long diferencia1=milis3-milis4;
        long diferenciaDias=diferencia1/(24*60*60*1000);
        
        JOptionPane.showMessageDialog(null, "QUEDAN "+diferenciaDias+" HASTA "+mostrar(ge)+" DESDE "+mostrar(gc));
        
        int diferencia2=gc.getActualMaximum(Calendar.DAY_OF_MONTH)-gc.get(Calendar.DAY_OF_MONTH);
        
        JOptionPane.showMessageDialog(null, "HAY "+diferencia2+" DÍAS DESDE "+mostrar(gc)+" HASTA FIN DE MES");
        
        boolean bisiesto;
        String yesNo1;
        if (gc.get(Calendar.YEAR)%4==0) {
            bisiesto=true;
            yesNo1="SÍ";
        }else{
            bisiesto=false;
            yesNo1="NO";
        }
        
        JOptionPane.showMessageDialog(null, "EL AÑO "+gc.get(Calendar.YEAR)+" "+yesNo1+" ES BISIESTO");
               
    }
    
    private static String mostrar(GregorianCalendar gc){       
        String[]dias={"Domingo","Lunes","Martes","Miércoles","Jueves","Viernes","Sábado"};
        String fecha=+gc.get(Calendar.DAY_OF_MONTH)+"-"+gc.get(Calendar.MONTH)
                +"-"+gc.get(Calendar.YEAR)+"("+dias[gc.get(Calendar.DAY_OF_WEEK)-1]+")";
        return fecha;
    }
    
}
