/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package herencialab;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RegistrarVentas extends VentanaBase {
    private JTextField campoCodigo = new JTextField();
    private JTextField campoVenta = new JTextField();
    private JButton registrar = new JButton("Registrar");
    private JButton salir = new JButton("Salir");

    public RegistrarVentas() {
        initBaseComps();
        initComps();
    }

    private void initComps() {
        JLabel titulo = new JLabel("REGISTRAR VENTAS");
        titulo.setFont(new Font("Arial Black", Font.BOLD, 25));
        titulo.setBounds(180, 40, 400, 30);
        add(titulo);

        JLabel codLabel = new JLabel("Codigo:");
        codLabel.setFont(new Font("Arial Black", Font.PLAIN, 12));
        codLabel.setBounds(200, 100, 200, 30);
        campoCodigo.setBounds(200, 130, 250, 25);

        JLabel ventaLabel = new JLabel("Monto de venta:");
        ventaLabel.setFont(new Font("Arial Black", Font.PLAIN, 12));
        ventaLabel.setBounds(200, 170, 200, 30);
        campoVenta.setBounds(200, 200, 250, 25);

        registrar.setBounds(200, 250, 100, 30);
        salir.setBounds(350, 250, 100, 30);

        add(codLabel);
        add(campoCodigo);
        add(ventaLabel);
        add(campoVenta);
        add(registrar);
        add(salir);

        registrar.addActionListener(e -> registrarVenta());
        salir.addActionListener(e -> {
            this.dispose();
            new MenuPrincipal().setVisible(true);
        });
    }

    private void registrarVenta() {
        try {
            int codigo = Integer.parseInt(campoCodigo.getText());
            double monto = Double.parseDouble(campoVenta.getText());

            Empleado emp = MenuPrincipal.buscarEmpleado(codigo);

            if (emp != null && emp instanceof EmpleadoVentas) {
                ((EmpleadoVentas) emp).registrarVenta(monto);
                JOptionPane.showMessageDialog(null, "Venta registrada correctamente.");
            } else {
                JOptionPane.showMessageDialog(null, "El empleado no es del tipo ventas.");
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Código y monto deben ser numericos.");
        }
    }
}

