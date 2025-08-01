/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package herencialab;

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;

public class ActualizarContrato extends VentanaBase {
    private JTextField campoCodigo = new JTextField();
    private JTextField campoNuevoAnio = new JTextField();
    private JButton actualizar = new JButton("Actualizar");
    private JButton salir = new JButton("Salir");

    public ActualizarContrato() {
        initBaseComps();
        initComps();
    }

    private void initComps() {
        JLabel titulo = new JLabel("ACTUALIZAR CONTRATO");
        titulo.setFont(new Font("Arial Black", Font.BOLD, 25));
        titulo.setBounds(150, 40, 500, 30);
        add(titulo);

        JLabel codLabel = new JLabel("Codigo del empleado:");
        codLabel.setFont(new Font("Arial Black", Font.PLAIN, 12));
        codLabel.setBounds(200, 100, 200, 30);
        campoCodigo.setBounds(200, 130, 250, 25);

        JLabel anioLabel = new JLabel("Nuevo año de finalizacion:");
        anioLabel.setFont(new Font("Arial Black", Font.PLAIN, 12));
        anioLabel.setBounds(200, 170, 250, 30);
        campoNuevoAnio.setBounds(200, 200, 250, 25);

        actualizar.setBounds(200, 250, 100, 30);
        salir.setBounds(350, 250, 100, 30);

        add(codLabel);
        add(campoCodigo);
        add(anioLabel);
        add(campoNuevoAnio);
        add(actualizar);
        add(salir);

        actualizar.addActionListener(e -> actualizarContrato());
        salir.addActionListener(e -> {
            this.dispose();
            new MenuPrincipal().setVisible(true);
        });
    }

    private void actualizarContrato() {
        try {
            int codigo = Integer.parseInt(campoCodigo.getText());
            int nuevoAnio = Integer.parseInt(campoNuevoAnio.getText());

            Empleado emp = MenuPrincipal.buscarEmpleado(codigo);

            if (emp != null && emp instanceof EmpleadoTemporal) {
                Calendar nuevaFecha = Calendar.getInstance();
                nuevaFecha.set(Calendar.YEAR, nuevoAnio);
                ((EmpleadoTemporal) emp).acctualizarFechaSinContrato(nuevaFecha);
                JOptionPane.showMessageDialog(null, "Contrato actualizado.");
            } else {
                JOptionPane.showMessageDialog(null, "El empleado no es temporal.");
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Los datos deben ser numericos.");
        }
    }
}

