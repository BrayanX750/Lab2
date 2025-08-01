/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package herencialab;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.*;

public class CrearEmpleado extends VentanaBase {
    private ArrayList<Empleado> empleadosM = MenuPrincipal.empleados;

    private JTextField code = new JTextField();
    private JTextField nombre  = new JTextField();
    private JTextField salarioBase  = new JTextField();
    private JComboBox<String> tipo = new JComboBox<>(new String[]{"venta", "temporal"});
    private JTextField extraInput = new JTextField();
    private JLabel extraLabel = new JLabel();

    private JButton registrar = new JButton("Registrar");
    private JButton salir = new JButton("Salir");

    public CrearEmpleado() {
        initBaseComps();
        initComps();
    }

    private void initComps() {
        JLabel titulo = new JLabel("REGISTRAR EMPLEADO");
        titulo.setFont(new Font("Arial Black", Font.BOLD, 30));
        titulo.setBounds(140, 40, 500, 50);
        add(titulo);

        JLabel codetit = new JLabel("Codigo");
        codetit.setFont(new Font("Arial Black", Font.PLAIN, 12));
        codetit.setBounds(230, 110, 80, 50);
        code.setBounds(230, 150, 200, 20);
        add(codetit);
        add(code);

        JLabel nomtit = new JLabel("Nombre");
        nomtit.setFont(new Font("Arial Black", Font.PLAIN, 12));
        nomtit.setBounds(230, 160, 80, 50);
        nombre.setBounds(230, 200, 200, 20);
        add(nomtit);
        add(nombre);

        JLabel salTit = new JLabel("Salario Base");
        salTit.setFont(new Font("Arial Black", Font.PLAIN, 12));
        salTit.setBounds(230, 210, 120, 50);
        salarioBase.setBounds(230, 250, 200, 20);
        add(salTit);
        add(salarioBase);

        JLabel tipoTit = new JLabel("Tipo Empleado");
        tipoTit.setFont(new Font("Arial Black", Font.PLAIN, 12));
        tipoTit.setBounds(230, 260, 130, 50);
        tipo.setBounds(230, 300, 200, 20);
        add(tipoTit);
        add(tipo);

        extraLabel.setFont(new Font("Arial Black", Font.PLAIN, 12));
        extraLabel.setBounds(230, 310, 200, 50);
        extraInput.setBounds(230, 350, 200, 20);
        add(extraLabel);
        add(extraInput);

        tipo.addActionListener(e -> actualizarCamposExtra());
        actualizarCamposExtra();

        registrar.setFont(new Font("Arial Black", Font.PLAIN, 12));
        registrar.setForeground(Color.green);
        registrar.setBounds(180, 400, 150, 30);
        registrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                registrarUser();
            }
        });
        add(registrar);

        salir.setFont(new Font("Arial Black", Font.PLAIN, 12));
        salir.setForeground(Color.red);
        salir.setBounds(350, 400, 150, 30);
        salir.addActionListener(e -> {
            this.dispose();
            new MenuPrincipal().setVisible(true);
        });
        add(salir);
    }

    private void actualizarCamposExtra() {
        String seleccionado = (String) tipo.getSelectedItem();
        if (seleccionado.equals("venta")) {
            extraLabel.setText("Tasa de Comision (0.05 = 5%)");
            extraLabel.setVisible(true);
            extraInput.setVisible(true);
        } else if (seleccionado.equals("temporal")) {
            extraLabel.setText("Año fin contrato (YYYY)");
            extraLabel.setVisible(true);
            extraInput.setVisible(true);
        } else {
            extraLabel.setVisible(false);
            extraInput.setVisible(false);
        }
    }

    public void registrarUser() {
        try {
            int codigo = Integer.parseInt(code.getText());
            String nom = nombre.getText();
            double salario = Double.parseDouble(salarioBase.getText());
            String tipoEmp = (String) tipo.getSelectedItem();

            if (MenuPrincipal.buscarEmpleado(codigo) != null) {
                JOptionPane.showMessageDialog(null, "ERROR: Codigo ya existe");
                return;
            }

            if (tipoEmp.equals("venta")) {
                double tasa = Double.parseDouble(extraInput.getText());
                empleadosM.add(new EmpleadoVentas(codigo, nom, salario, tasa));
            } else if (tipoEmp.equals("temporal")) {
                int anio = Integer.parseInt(extraInput.getText());
                Calendar fin = Calendar.getInstance();
                fin.set(Calendar.YEAR, anio);
                empleadosM.add(new EmpleadoTemporal(codigo, nom, salario, fin));
            }

            JOptionPane.showMessageDialog(null, "Empleado registrado exitosamente");
            this.dispose();
            new MenuPrincipal().setVisible(true);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERROR: Datos inválidos o incompletos");
        }
    }
}
