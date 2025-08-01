/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package herencialab;

import javax.swing.*;
import java.awt.*;

public class BuscarEmpleado extends VentanaBase {
    private JTextField campoCodigo = new JTextField();
    private JTextArea areaResultado = new JTextArea(); 
    private JButton buscar = new JButton("Buscar");
    private JButton salir = new JButton("Salir");

    public BuscarEmpleado() {
        initBaseComps();
        initComps();
    }

    private void initComps() {
        JLabel titulo = new JLabel("BUSCAR EMPLEADO");
        titulo.setFont(new Font("Arial Black", Font.BOLD, 25));
        titulo.setBounds(180, 20, 400, 30);
        add(titulo);

        JLabel codLabel = new JLabel("Código del empleado:");
        codLabel.setFont(new Font("Arial Black", Font.PLAIN, 12));
        codLabel.setBounds(200, 80, 200, 30);
        campoCodigo.setBounds(200, 110, 250, 25);

        buscar.setBounds(200, 150, 100, 30);
        salir.setBounds(350, 150, 100, 30);

        areaResultado.setBounds(100, 200, 500, 220);
        areaResultado.setEditable(false);
        areaResultado.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scroll = new JScrollPane(areaResultado);
        scroll.setBounds(100, 200, 500, 220);
        add(scroll);

        add(codLabel);
        add(campoCodigo);
        add(buscar);
        add(salir);

        buscar.addActionListener(e -> buscarEmpleado());
        salir.addActionListener(e -> {
            this.dispose();
            new MenuPrincipal().setVisible(true);
        });
    }

    private void buscarEmpleado() {
        try {
            int codigo = Integer.parseInt(campoCodigo.getText());
            Empleado emp = MenuPrincipal.buscarEmpleado(codigo);

            if (emp != null) {
                areaResultado.setText(emp.toString());
            } else {
                areaResultado.setText("Empleado no encontrado.");
            }

        } catch (NumberFormatException e) {
            areaResultado.setText("Código inválido.");
        }
    }
}

