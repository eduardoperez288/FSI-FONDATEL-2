/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author eduar
 */

import java.sql.*;

public class alimentos {

    static String todos = "SELECT * FROM alimentos ORDER BY nombre DESC";
    static String ids = "SELECT idalimentos FROM alimentos ORDER BY idalimentos";

    int idalimentos;
    String nombre, descripcion, foto, categoria, estado;
    double precio;

    public alimentos() {

    }

    public alimentos(int idalimentos, String nombre, String descripcion,
            double precio, String foto, String categoria, String estado) {

        this.idalimentos = idalimentos;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.foto = foto;
        this.categoria = categoria;
        this.estado = estado;
    }

    public int insertar(Connection con) {
        int resultado = 0;

        try {
            String sql = "INSERT INTO alimentos "
                    + "(nombre, descripcion, precio, foto, categoria, estado) "
                    + "VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, nombre);
            ps.setString(2, descripcion);
            ps.setDouble(3, precio);
            ps.setString(4, foto);
            ps.setString(5, categoria);
            ps.setString(6, estado);

            return ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return resultado;
        }
    }

    public int borrar(Connection con) {
        int resultado = 0;

        try {
            String sql = "DELETE FROM alimentos WHERE idalimentos = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idalimentos);

            return ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return resultado;
        }
    }

    public int actualizar(Connection con) {
        int resultado = 0;

        try {
            String sql = "UPDATE alimentos SET nombre = ?, descripcion = ?, "
                    + "precio = ?, foto = ?, categoria = ?, estado = ? "
                    + "WHERE idalimentos = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, nombre);
            ps.setString(2, descripcion);
            ps.setDouble(3, precio);
            ps.setString(4, foto);
            ps.setString(5, categoria);
            ps.setString(6, estado);
            ps.setInt(7, idalimentos);

            return ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return resultado;
        }
    }
}
