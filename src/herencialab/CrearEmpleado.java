/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package herencialab;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;

public class CrearEmpleado extends VentanaBase {
    private ArrayList<Empleado> empleadosM = MenuPrincipal.empleados;

    private JTextField code = new JTextField();
    private JTextField nombre = new JTextField();
    private JTextField salarioBase = new JTextField();
    private JComboBox<String> tipo = new JComboBox<>(new String[]{"venta", "temporal"});

    private JTextField campoComision = new JTextField();
    private JLabel labelComision = new JLabel("Tasa de comisión");

    private JDateChooser calendarioFecha = new JDateChooser();
    private JLabel labelFecha = new JLabel("Fecha fin de contrato");

    private JButton registrar = new JButton("Registrar");
    private JButton salir = new JButton("Salir");

    public CrearEmpleado() {
        initBaseComps();
        initComps();
        initListeners();
    }

    private void initComps() {
        JLabel titulo = new JLabel("REGISTRAR EMPLEADO");
        titulo.setFont(new Font("Arial Black", Font.BOLD, 30));
        titulo.setBounds(140, 40, 500, 50);
        add(titulo);

        JLabel codetit = new JLabel("Código");
        codetit.setFont(new Font("Arial Black", Font.PLAIN, 12));
        codetit.setBounds(230, 110, 80, 20);
        code.setBounds(230, 130, 200, 20);
        add(codetit);
        add(code);

        JLabel nomtit = new JLabel("Nombre");
        nomtit.setFont(new Font("Arial Black", Font.PLAIN, 12));
        nomtit.setBounds(230, 160, 80, 20);
        nombre.setBounds(230, 180, 200, 20);
        add(nomtit);
        add(nombre);

        JLabel salTit = new JLabel("Salario Base");
        salTit.setFont(new Font("Arial Black", Font.PLAIN, 12));
        salTit.setBounds(230, 210, 120, 20);
        salarioBase.setBounds(230, 230, 200, 20);
        add(salTit);
        add(salarioBase);

        JLabel tipoTit = new JLabel("Tipo Empleado");
        tipoTit.setFont(new Font("Arial Black", Font.PLAIN, 12));
        tipoTit.setBounds(230, 260, 130, 20);
        tipo.setBounds(230, 280, 200, 20);
        add(tipoTit);
        add(tipo);

        labelComision.setFont(new Font("Arial Black", Font.PLAIN, 12));
        labelComision.setBounds(230, 310, 200, 20);
        campoComision.setBounds(230, 330, 200, 20);
        add(labelComision);
        add(campoComision);

        labelFecha.setFont(new Font("Arial Black", Font.PLAIN, 12));
        labelFecha.setBounds(230, 310, 200, 20);
        calendarioFecha.setBounds(230, 330, 200, 20);
        add(labelFecha);
        add(calendarioFecha);

        registrar.setFont(new Font("Arial Black", Font.PLAIN, 12));
        registrar.setForeground(Color.green);
        registrar.setBounds(150, 400, 150, 30);
        add(registrar);

        salir.setFont(new Font("Arial Black", Font.PLAIN, 12));
        salir.setForeground(Color.red);
        salir.setBounds(350, 400, 150, 30);
        add(salir);

        actualizarCampoExtra();
    }

    private void initListeners() {
        tipo.addActionListener(e -> actualizarCampoExtra());

        registrar.addActionListener(e -> registrarUser());

        salir.addActionListener(e -> {
            this.dispose();
            new MenuPrincipal().setVisible(true);
        });
    }

    private void actualizarCampoExtra() {
        String seleccionado = (String) tipo.getSelectedItem();

        if (seleccionado.equals("venta")) {
            labelComision.setVisible(true);
            campoComision.setVisible(true);
            labelFecha.setVisible(false);
            calendarioFecha.setVisible(false);
        } else if (seleccionado.equals("temporal")) {
            labelComision.setVisible(false);
            campoComision.setVisible(false);
            labelFecha.setVisible(true);
            calendarioFecha.setVisible(true);
        }
    }

    private void registrarUser() {
        try {
            int codigo = Integer.parseInt(code.getText());
            String nom = nombre.getText();
            double salario = Double.parseDouble(salarioBase.getText());
            String tipoEmpleado = (String) tipo.getSelectedItem();

            if (MenuPrincipal.buscarEmpleado(codigo) != null) {
                JOptionPane.showMessageDialog(null, "ERROR: Código ya existe.");
                return;
            }

            Empleado nuevo;
            switch (tipoEmpleado) {
                case "venta":
                    double tasa = Double.parseDouble(campoComision.getText());
                    nuevo = new EmpleadoVentas(codigo, nom, salario, tasa);
                    break;
                case "temporal":
                    Calendar fecha = calendarioFecha.getCalendar();
                    if (fecha == null) {
                        JOptionPane.showMessageDialog(null, "Selecciona una fecha válida.");
                        return;
                    }
                    nuevo = new EmpleadoTemporal(codigo, nom, salario, fecha);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Tipo inválido.");
                    return;
            }

            MenuPrincipal.empleados.add(nuevo);
            JOptionPane.showMessageDialog(null, "Empleado registrado correctamente.");
            this.dispose();
            new MenuPrincipal().setVisible(true);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Verifica que todos los datos sean válidos.");
        }
    }
}
