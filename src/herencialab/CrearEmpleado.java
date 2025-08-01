/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package herencialab;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author unwir
 */
public class CrearEmpleado extends VentanaBase {
    private ArrayList<Empleado> empleadosM = MenuPrincipal.empleados;
    
    private JTextField code = new JTextField();
    private JTextField nombre  = new JTextField();
    private JTextField salarioBase  = new JTextField();
    private JComboBox<String> tipo = new JComboBox(new String[]{"venta", "temporal"});
    
    private JButton registrar = new JButton("Registrar");
    private JButton salir = new JButton("Salir");
    
    
    
    public CrearEmpleado(){
        initBaseComps();
        initComps();
    }
    
    
    private void initComps(){
        JLabel titulo = new JLabel();
        titulo.setText("REGISTRAR EMPLEADO");
        titulo.setFont(new Font("Arial Black", Font.BOLD, 30));
        titulo.setBounds(140, 40, 500, 50);
        
        
        add(titulo);
        
        JLabel codetit = new JLabel();
        codetit.setText("Codigo");
        codetit.setFont(new Font("Arial Black", Font.PLAIN, 12));
        codetit.setBounds(230, 110, 80, 50);
        code.setBounds(230, 150, 200, 20);
       
        add(codetit);
        add(code);
        
        JLabel nomtit = new JLabel();
        nomtit.setText("Nombre");
        nomtit.setFont(new Font("Arial Black", Font.PLAIN, 12));
        nomtit.setBounds(230, 110 + 50, 80, 50);
        nombre.setBounds(230, 150 + 50, 200, 20);
       
        add(nomtit);
        add(nombre);
        
        JLabel salTit = new JLabel();
        salTit.setText("Salario Base");
        salTit.setFont(new Font("Arial Black", Font.PLAIN, 12));
        salTit.setBounds(230, 110 + 100, 120, 50);
        salarioBase.setBounds(230, 150 + 100, 200, 20);
       
        add(salTit);
        add(salarioBase);
        
        
                
        JLabel tipoTit = new JLabel();
        tipoTit.setText("Tipo Empleado");
        tipoTit.setFont(new Font("Arial Black", Font.PLAIN, 12));
        tipoTit.setBounds(230, 110 + 100, 130, 50);
        tipo.setBounds(230, 150 + 100, 200, 20);
       
        add(tipoTit);
        add(tipo);

        registrar.setFont(new Font("Arial Black", Font.PLAIN, 12));
        registrar.setForeground(Color.green);
        registrar.setBounds(220, 300, 200, 20);
        
        
        
        
        salir.setFont(new Font("Arial Black", Font.PLAIN, 12));
        salir.setForeground(Color.red);
        salir.setBounds(220 + 50, 300, 200, 20);
        
        
    }
    
    public void registrarUser(){
        int codigo = Integer.parseInt(code.getText());
           
        
        if(MenuPrincipal.buscarEmpleado(codigo) == null){
            
        
        
        }else{
            JOptionPane.showMessageDialog(null, "ERROR, CODIGO DE EMPLEADO YA EXISTE");
        }
        
        
        
    
    }
    
    
    
    
    
    
}
