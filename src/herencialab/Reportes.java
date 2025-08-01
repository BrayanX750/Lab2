/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package herencialab;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Reportes extends VentanaBase {
    private JTextArea areaTexto = new JTextArea();
    private JScrollPane scroll = new JScrollPane(areaTexto);
    private JButton salir = new JButton("Salir");
    private ArrayList<Empleado> empleados = MenuPrincipal.empleados;

    public Reportes() {
        initBaseComps();
        initComps();
        mostrarReporte();
    }

    private void initComps() {
        JLabel titulo = new JLabel("REPORTE DE EMPLEADOS");
        titulo.setFont(new Font("Arial Black", Font.BOLD, 26));
        titulo.setBounds(170, 20, 400, 30);
        add(titulo);

        areaTexto.setEditable(false);
        areaTexto.setFont(new Font("Courier New", Font.PLAIN, 13));
        scroll.setBounds(50, 70, 600, 330);
        add(scroll);

        salir.setFont(new Font("Arial Black", Font.PLAIN, 12));
        salir.setForeground(Color.red);
        salir.setBounds(270, 420, 150, 30);
        salir.addActionListener(e -> {
            this.dispose();
            new MenuPrincipal().setVisible(true);
        });
        add(salir);
    }

    private void mostrarReporte() {
        StringBuilder reporte = new StringBuilder();

        int temporal = 0, ventas = 0;

        

        reporte.append("\n===== EMPLEADOS TEMPORALES =====\n");
        for (Empleado emp : empleados) {
            if (emp instanceof EmpleadoTemporal) {
                reporte.append(emp.toString()).append("\n----------------------------\n");
                temporal++;
            }
        }

        reporte.append("\n===== EMPLEADOS DE VENTAS =====\n");
        for (Empleado emp : empleados) {
            if (emp instanceof EmpleadoVentas) {
                reporte.append(emp.toString()).append("\n----------------------------\n");
                ventas++;
            }
        }

        reporte.append("\n========= TOTALES =========\n");
      
        reporte.append("Total Temporal: ").append(temporal).append("\n");
        reporte.append("Total Ventas: ").append(ventas).append("\n");

        areaTexto.setText(reporte.toString());
    }
}

