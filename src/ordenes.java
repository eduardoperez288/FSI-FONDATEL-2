/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author eduar
 */
import java.sql.*;

public class ordenes {

    static String todos = "SELECT * FROM ordenes ORDER BY folio DESC";
    static String ids = "SELECT folio FROM ordenes ORDER BY folio";

    int folio, silla, clientes_codigoc, mesas_numero, alimentos_idalimentos;
    int empleados_codigo_mesero, empleados_codigo_cocinero, empleados_codigo;
    String fecha_hora, observaciones, estadoo;

    public ordenes() {

    }

    public ordenes(int folio, String fecha_hora, String observaciones, String estadoo, 
                   int silla, int clientes_codigoc, int mesas_numero, int alimentos_idalimentos, 
                   int empleados_codigo_mesero, int empleados_codigo_cocinero, int empleados_codigo) {
        this.folio = folio;
        this.fecha_hora = fecha_hora;
        this.observaciones = observaciones;
        this.estadoo = estadoo;
        this.silla = silla;
        this.clientes_codigoc = clientes_codigoc;
        this.mesas_numero = mesas_numero;
        this.alimentos_idalimentos = alimentos_idalimentos;
        this.empleados_codigo_mesero = empleados_codigo_mesero;
        this.empleados_codigo_cocinero = empleados_codigo_cocinero;
        this.empleados_codigo = empleados_codigo;
    }

    public int insertar(Connection con) {
        int resultado = 0;

        try {
            String sql = "INSERT INTO ordenes "
                    + "(fecha_hora, observaciones, estadoo, silla, clientes_codigoc, "
                    + "mesas_numero, alimentos_idalimentos, empleados_codigo_mesero, "
                    + "empleados_codigo_cocinero, empleados_codigo) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, fecha_hora);
            ps.setString(2, observaciones);
            ps.setString(3, estadoo);
            ps.setInt(4, silla);
            ps.setInt(5, clientes_codigoc);
            ps.setInt(6, mesas_numero);
            ps.setInt(7, alimentos_idalimentos);
            ps.setInt(8, empleados_codigo_mesero);
            ps.setInt(9, empleados_codigo_cocinero);
            ps.setInt(10, empleados_codigo);

            return ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return resultado;
        }
    }

    public int borrar(Connection con) {
        int resultado = 0;

        try {
            String sql = "DELETE FROM ordenes WHERE folio = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, folio);

            return ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return resultado;
        }
    }

    public int actualizar(Connection con) {
        int resultado = 0;

        try {
            String sql = "UPDATE ordenes SET fecha_hora = ?, observaciones = ?, estadoo = ?, "
                    + "silla = ?, clientes_codigoc = ?, mesas_numero = ?, "
                    + "alimentos_idalimentos = ?, empleados_codigo_mesero = ?, "
                    + "empleados_codigo_cocinero = ?, empleados_codigo = ? "
                    + "WHERE folio = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, fecha_hora);
            ps.setString(2, observaciones);
            ps.setString(3, estadoo);
            ps.setInt(4, silla);
            ps.setInt(5, clientes_codigoc);
            ps.setInt(6, mesas_numero);
            ps.setInt(7, alimentos_idalimentos);
            ps.setInt(8, empleados_codigo_mesero);
            ps.setInt(9, empleados_codigo_cocinero);
            ps.setInt(10, empleados_codigo);
            ps.setInt(11, folio);

            return ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return resultado;
        }
    }
}
