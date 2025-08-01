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
public class VentanaBase extends JFrame {
    public VentanaBase(){
      initBaseComps();
    }
    
    public void initBaseComps(){
        setSize(700, 520);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(new Color(0xFFE5CC));
    
    }
}
