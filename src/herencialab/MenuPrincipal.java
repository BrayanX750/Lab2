/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package herencialab;
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author unwir
 */
public class MenuPrincipal extends ventanaBase {
    public MenuPrincipal(){
        initBaseComps();
        initComps();
    }
    
    public void initComps(){
        JLabel titulo = new JLabel();
        titulo.setText("GESTION DE EMPLEADOS");
        titulo.setFont(new Font("Arial Black", Font.BOLD, 30));
        titulo.setBounds(120, 40, 500, 50);
        
        
        add(titulo);
    
    }
    
    
    public static void main(String[] args){
        MenuPrincipal m = new MenuPrincipal();
        m.setVisible(true);
        
    }
   
    
}
