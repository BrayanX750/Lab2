/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package herencialab;

import java.util.Calendar;

public class EmpleadoTemporal extends Empleado {
    
private Calendar fechaFinContrato;
public EmpleadoTemporal(int code, String nombre,double salarioBase, Calendar fechaFinContrato){
    super(code,nombre,salarioBase);
    setRango(1);
    this.fechaFinContrato=fechaFinContrato;
}

@Override
public double calcularPago(double horasChamba){
    Calendar hoy=Calendar.getInstance();
    if(!hoy.after(fechaFinContrato)){
        
        return(horasChamba/160.0)*getSalarioBase();
    }else{
        return 0.0;
    }
}

public void acctualizarFechaSinContrato(Calendar nuevaFecha){
    this.fechaFinContrato=fechaFinContrato;
}

@Override
public String toString(){
    return super.toString()+
            "/nFecha de fin de contrato: "+fechaFinContrato.getTime();
    
}

public Calendar getFechaFinContrato(){
    return fechaFinContrato;
}

}
