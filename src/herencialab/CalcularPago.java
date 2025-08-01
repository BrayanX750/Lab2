/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package herencialab;

import javax.swing.*;
import java.awt.*;

public class CalcularPago extends VentanaBase {
    private JTextField campoCodigo = new JTextField();
    private JButton calcular = new JButton("Calcular");
    private JButton salir = new JButton("Salir");

    public CalcularPago() {
        initBaseComps();
        initComps();
    }

    private void initComps() {
        JLabel titulo = new JLabel("CALCULAR PAGO");
        titulo.setFont(new Font("Arial Black", Font.BOLD, 25));
        titulo.setBounds(200, 40, 400, 30);
        add(titulo);

        JLabel codLabel = new JLabel("Código del empleado:");
        codLabel.setFont(new Font("Arial Black", Font.PLAIN, 12));
        codLabel.setBounds(200, 110, 200, 30);
        campoCodigo.setBounds(200, 140, 250, 25);

        calcular.setBounds(200, 200, 100, 30);
        salir.setBounds(350, 200, 100, 30);

        add(codLabel);
        add(campoCodigo);
        add(calcular);
        add(salir);

        calcular.addActionListener(e -> calcularPagoEmpleado());
        salir.addActionListener(e -> {
            this.dispose();
            new MenuPrincipal().setVisible(true);
        });
    }

    private void calcularPagoEmpleado() {
        try {
            int codigo = Integer.parseInt(campoCodigo.getText());
            Empleado emp = MenuPrincipal.buscarEmpleado(codigo);

            if (emp != null) {
                double pago = emp.calcularPago(emp.getHorasChamba());
                JOptionPane.showMessageDialog(null, "Pago mensual: Lps. " + String.format("%.2f", pago));
            } else {
                JOptionPane.showMessageDialog(null, "Empleado no encontrado.");
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El codigo debe ser numerico.");
        }
    }
}

