/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author eduar
 */
import java.sql.*;

public class empleados {

    static String todos = "SELECT * FROM empleados ORDER BY nombree DESC";
    static String ids = "SELECT codigo FROM empleados ORDER BY codigo";

    int codigo;
    String nombree, puesto, turno, estadoe, nom_usr, nip;

    public empleados() {

    }

    public empleados(int codigo, String nombree, String puesto, 
                     String turno, String estadoe, String nom_usr, String nip) {
        this.codigo = codigo;
        this.nombree = nombree;
        this.puesto = puesto;
        this.turno = turno;
        this.estadoe = estadoe;
        this.nom_usr = nom_usr;
        this.nip = nip;
    }

    public int insertar(Connection con) {
        int resultado = 0;

        try {
            String sql = "INSERT INTO empleados "
                    + "(nombree, puesto, turno, estadoe, nom_usr, nip) "
                    + "VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, nombree);
            ps.setString(2, puesto);
            ps.setString(3, turno);
            ps.setString(4, estadoe);
            ps.setString(5, nom_usr);
            ps.setString(6, nip);

            return ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return resultado;
        }
    }

    public int borrar(Connection con) {
        int resultado = 0;

        try {
            String sql = "DELETE FROM empleados WHERE codigo = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, codigo);

            return ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return resultado;
        }
    }

    public int actualizar(Connection con) {
        int resultado = 0;

        try {
            String sql = "UPDATE empleados SET nombree = ?, puesto = ?, "
                    + "turno = ?, estadoe = ?, nom_usr = ?, nip = ? "
                    + "WHERE codigo = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, nombree);
            ps.setString(2, puesto);
            ps.setString(3, turno);
            ps.setString(4, estadoe);
            ps.setString(5, nom_usr);
            ps.setString(6, nip);
            ps.setInt(7, codigo);

            return ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return resultado;
        }
    }
}