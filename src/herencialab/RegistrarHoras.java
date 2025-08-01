/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package herencialab;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RegistrarHoras extends VentanaBase {
    private JTextField campoCodigo = new JTextField();
    private JTextField campoHoras = new JTextField();
    private JButton registrar = new JButton("Registrar");
    private JButton salir = new JButton("Salir");

    public RegistrarHoras() {
        initBaseComps();
        initComps();
    }

    private void initComps() {
        JLabel titulo = new JLabel("REGISTRAR HORAS");
        titulo.setFont(new Font("Arial Black", Font.BOLD, 25));
        titulo.setBounds(200, 40, 400, 30);
        add(titulo);

        JLabel codLabel = new JLabel("Código:");
        codLabel.setFont(new Font("Arial Black", Font.PLAIN, 12));
        codLabel.setBounds(200, 100, 200, 30);
        campoCodigo.setBounds(200, 130, 250, 25);

        JLabel horasLabel = new JLabel("Horas trabajadas:");
        horasLabel.setFont(new Font("Arial Black", Font.PLAIN, 12));
        horasLabel.setBounds(200, 170, 200, 30);
        campoHoras.setBounds(200, 200, 250, 25);

        registrar.setBounds(200, 250, 100, 30);
        salir.setBounds(350, 250, 100, 30);

        add(codLabel);
        add(campoCodigo);
        add(horasLabel);
        add(campoHoras);
        add(registrar);
        add(salir);

        registrar.addActionListener(e -> registrarHoras());
        salir.addActionListener(e -> {
            this.dispose();
            new MenuPrincipal().setVisible(true);
        });
    }

    private void registrarHoras() {
        try {
            int codigo = Integer.parseInt(campoCodigo.getText());
            int horas = Integer.parseInt(campoHoras.getText());

            Empleado emp = MenuPrincipal.buscarEmpleado(codigo);

            if (emp != null) {
                emp.registrarHorasTrabajadas(horas);
                JOptionPane.showMessageDialog(null, "Horas registradas correctamente.");
            } else {
                JOptionPane.showMessageDialog(null, "Empleado no encontrado.");
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Código y horas deben ser numéricos.");
        }
    }
}
