package com.datamainworld.RegistroCasos;

import java.sql.*;

public class JavaOracleTest {
    public static void main(String[] args) {
                        //jdbc:oracle:thin:@localhost:1521:orcl
        String dbUrl = "jdbc:oracle:thin:@152.67.62.154:1521/bdulima1_pdb1.subnetpub.vcninfra.oraclevcn.com";
        String username = "alumno12";
        String password = "PeruLima__2020";

        try {
            Connection connection = DriverManager.getConnection(dbUrl, username, password);
            System.out.println("Connected to Oracle database server");

            //Statement
            /*String sql = "INSERT INTO AREA VALUES (987, 'XXX')";
            Statement statement = connection.createStatement();
            int rows = statement.executeUpdate(sql);*/

            //Prepared statement
            String sql = "INSERT INTO AREA VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "19");
            statement.setString(2, "asdaasdw");
            int rows = statement.executeUpdate();

            if(rows > 0 ){
                System.out.println("A row has been inserted.");
            }
            statement.close();

            String sql2 = "SELECT * FROM AREA";
            Statement statement2 = connection.createStatement();
            ResultSet result = statement2.executeQuery(sql2);

            while(result.next()){
                String id = result.getString(1);
                String name = result.getString("nombre");
                System.out.println("ID: " + id + " Name: " + name);
            }

            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
