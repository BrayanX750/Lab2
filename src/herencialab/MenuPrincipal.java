/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package herencialab;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
/**
 *
 * @author unwir
 */
public class MenuPrincipal extends VentanaBase {
    public static ArrayList<Empleado> empleados = new ArrayList<>();
    
    
    
    public MenuPrincipal(){
        initBaseComps();
        initComps();
    }
    
    public void initComps(){
        JLabel titulo = new JLabel();
        titulo.setText("GESTION DE EMPLEADOS");
        titulo.setFont(new Font("Arial Black", Font.BOLD, 30));
        titulo.setBounds(130, 40, 500, 50);
        
        
        add(titulo);
        
        JPanel opciones = new JPanel();
        opciones.setLayout(new GridLayout(7, 0, 10, 5));
        opciones.setBounds(230, 120, 200, 300);
        
        JButton crearEmp = new JButton("Crear Empleado");
        crearEmp.setFont(new Font("Arial Black", Font.PLAIN, 12));
        crearEmp.setBounds(opciones.getWidth(), opciones.getHeight(), 65, 30);
        
        crearEmp.addActionListener(e -> {
            this.dispose();
            CrearEmpleado crearE = new CrearEmpleado();
            crearE.setVisible(true);
        });
        
        
        
        
        
        
        JButton rH = new JButton("Registrar Horas");
        rH.setFont(new Font("Arial Black", Font.PLAIN, 12));
        rH.setBounds(opciones.getWidth() + 10, opciones.getHeight(), 65, 30);
        
        
        JButton rV = new JButton("Registrar Ventas");
        rV.setFont(new Font("Arial Black", Font.PLAIN, 12));
        rV.setBounds(opciones.getWidth(), opciones.getHeight(), 65, 30);
        
        JButton actF = new JButton("Actualizar Contrato");
        actF.setFont(new Font("Arial Black", Font.PLAIN, 12));
        actF.setBounds(opciones.getWidth() + 10, opciones.getHeight(), 65, 30);
        
        JButton cPM = new JButton("Calcular Pago");
        cPM.setFont(new Font("Arial Black", Font.PLAIN, 12));
        cPM.setBounds(opciones.getWidth(), opciones.getHeight(), 65, 30);
        
        JButton repE = new JButton("Generar Reportes");
        repE.setFont(new Font("Arial Black", Font.PLAIN, 12));
        repE.setBounds(opciones.getWidth(), opciones.getHeight(), 65, 30);
        
        JButton buscE = new JButton("Buscar Empleados");
        buscE.setFont(new Font("Arial Black", Font.PLAIN, 12));
        buscE.setBounds(opciones.getWidth(), opciones.getHeight(), 65, 30);
        
        JButton[] botOpc = {crearEmp, rH, rV, actF, cPM, repE, buscE};
        
        for(JButton bots: botOpc){
            opciones.add(bots);
        }
        
        add(opciones);
 
    }
    
    public static Empleado buscarEmpleado(int code){
        for(Empleado a: empleados){
            if(a.getCode() == code){
                return a;
            }
        }
        return null;
    }
    
    public static boolean crearEmpleado(String tipo, int cod, String name, double salario, double tasaCom){
        if(buscarEmpleado(cod) == null){
            switch(tipo){
                case "venta":
                empleados.add(new EmpleadoVentas(cod, name, salario, tasaCom));
                break;
                case "temporal":     
                
                break;
                    
            
            }
            
            return true;
        }
    
        return false;
    }
    
    
    
    
    
    public static void main(String[] args){
        MenuPrincipal m = new MenuPrincipal();
        m.setVisible(true);
        
    }
   
    
}
