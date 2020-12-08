package com.datamainworld.RegistroCasos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class PruebaFuncion {
    public static void main(String[] args) {
        Connection connection = new OracleConecction().conectar();
        System.out.println("Conectado a la BD.");
        String sqlFuncion = "{? = call Prueba(?)}";
        try {
            CallableStatement callableStatement = connection.prepareCall(sqlFuncion);
            System.out.println("Funcion preparada");

            callableStatement.registerOutParameter(1, Types.INTEGER);

            String a = "7";

            callableStatement.setString(2,a);
            System.out.println("Ejecutando funcion con parametro "+a+"...");
            callableStatement.execute();

            int output = callableStatement.getInt(1);

            System.out.println("Resultado de la funcion: " + output);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
