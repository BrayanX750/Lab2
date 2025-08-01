/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package herencialab;

import java.util.Calendar;

/**
 *
 * @author unwir
 */
public class Empleado {
    private int code;
    private int horasChamba;
    private String nombre;
    private Calendar fechaCreacion;
    private double salarioBase;
    private String rango = "nulo";
    
    
    public Empleado(int code, String nombre, double salarioBase){
        this.code = code;
        horasChamba = 0;
        this.nombre = nombre;
        this.salarioBase = salarioBase;
        fechaCreacion = Calendar.getInstance();
    }

    public int getCode() {
        return code;
    }

    public int getHorasChamba() {
        return horasChamba;
    }

    public void registrarHorasTrabajadas(int horasChamba) {
        this.horasChamba += horasChamba;
    }

    public String getNombre() {
        return nombre;
    }

    public Calendar getFechaCreacion() {
        return fechaCreacion;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }
    
    
    public double calcularPago(double horasChamba){
       return ((horasChamba/160) * this.salarioBase) * 0.965;
    }
    
    public void setRango(int tipo){
        switch(tipo){
           case 0:
               rango = "temporal";
               break;
           case 1:
               rango =  "ventas";
               break;
           default:
               rango = "nulo";
               break;
        }  
    }
    
    
    public String getRango(){
        return rango;
    }
    
    @Override
    public String toString(){
        return "Codigo: " + code +
               "\nNombre: " + nombre +
               "\nHoras Trabajadas: " + horasChamba + 
               "\nFecha de Entrada: " + fechaCreacion.getTime() +
               "\nSalario Base: " + salarioBase;
    }

}
