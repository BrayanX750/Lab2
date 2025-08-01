/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package herencialab;

import java.util.Calendar;

public class EmpleadoVentas extends Empleado {
    private final double[] ventasMensuales;
    private final double tasaComision;

    public EmpleadoVentas(int code, String nombre, double salarioBase, double tasaComision) {
        super(code, nombre, salarioBase);
        this.tasaComision = tasaComision;
        this.ventasMensuales = new double[12];  
    }

    public void registrarVenta(double monto) {
        int mesActual = Calendar.getInstance().get(Calendar.MONTH);
        ventasMensuales[mesActual] += monto;
    }

    public double calcularComisionMesActual() {
        int mesActual = Calendar.getInstance().get(Calendar.MONTH);
        return ventasMensuales[mesActual] * tasaComision;
    }

    @Override
    public double calcularPago(double horasChamba) {
        double pagoBase = (horasChamba / 160.0) * getSalarioBase() * 0.965;
        return pagoBase + calcularComisionMesActual();
    }

    public double calcularVentasAnuales() {
        double total = 0;
        for (double venta : ventasMensuales) {
            total += venta;
        }
        return total;
    }

    @Override
    public String toString() {
        return super.toString() +
               "\nVentas Anuales: " + calcularVentasAnuales();
    }

    public double[] getVentasMensuales() {
        return ventasMensuales;
    }

    public double getTasaComision() {
        return tasaComision;
    }
}
