/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author acomesanavila
 */
public class Metodos {

    Connection c = null;
    Statement stmt = null;

    public void conexion() {
        try {
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            c.setAutoCommit(false);
           
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Base de datos conectada");
    }

    public void crearTabla() {
        try {
            stmt = c.createStatement();
            String sql = "CREATE TABLE COMPANY "
                    + "(ID INT PRIMARY KEY     NOT NULL,"
                    + " Nombre          TEXT    NOT NULL, "
                    + " Años            INT     NOT NULL, "
                    + " Direcion        CHAR(50), "
                    + " Salario         REAL)";
            stmt.executeUpdate(sql);
            stmt.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Tabla creada");
    }

    public void insertarDatos() {
        try {
            stmt = c.createStatement();
            String sql = "INSERT INTO COMPANY (ID,Nombre,Años,Direcion,Salario) "
                    + "VALUES (1, 'Paul', 32, 'California', 20000.00 );";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO COMPANY (ID,Nombre,Años,Direcion,Salario) "
                    + "VALUES (2, 'Allen', 25, 'Texas', 15000.00 );";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO COMPANY (ID,Nombre,Años,Direcion,Salario) "
                    + "VALUES (3, 'Teddy', 23, 'Norway', 20000.00 );";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO COMPANY (ID,Nombre,Años,Direcion,Salario) "
                    + "VALUES (4, 'Mark', 25, 'Rich-Mond ', 65000.00 );";
            stmt.executeUpdate(sql);

            stmt.close();
            c.commit();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Datos insertados");
    }

    public void busqueda() {
        try {
            ResultSet rs = stmt.executeQuery("SELECT * FROM COMPANY;");
            while (rs.next()) {
                System.out.println("ID = " + rs.getInt("id"));
                System.out.println("Nombre = " + rs.getString("Nombre"));
                System.out.println("Años = " + rs.getInt("Años"));
                System.out.println("Direcion = " +rs.getString("Direcion"));
                System.out.println("Salario = " +  rs.getFloat("Salario"));
            }
            rs.close();
            stmt.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Busqueda acabada");
    }

    public void update() {
        try {
            String sql = "UPDATE COMPANY set Salario = 25000.00 where ID=1;";
            stmt.executeUpdate(sql);
            c.commit();
            stmt.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Update terminado");
    }

    public void delete() {
        try {
            String sql = "DELETE from COMPANY where ID=2;";
            stmt.executeUpdate(sql);
            c.commit();
            stmt.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Borrado realizado");
    }
    public void cerrarConexion(){
        try {
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
