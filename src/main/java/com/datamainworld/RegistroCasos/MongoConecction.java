package com.datamainworld.RegistroCasos;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public class MongoConecction {
    public static void main(String[] args) {
        MongoClient mongo = crearConexion();
        // Si no existe la base de datos la creamos
        if (mongo != null){
            DB db = mongo.getDB("BBVA");

            System.out.println("Base de datos creada");
            // Crea una coleccion (tabla) su no existe e inserta el documento(registro) a la coleccon
        }
    }

    public static MongoClient crearConexion(){
        System.out.println("Prueba conexion MongoDB");
        MongoClient mongo = null;
        mongo = new MongoClient("localhost",27017);
        return mongo;
    }

    public static void insertarEmpleado(DB db, String colection, String nombre, String dni, String telf, String correo, String dom, String area ){
        DBCollection colec = db.getCollection(colection);
        //Crea el documento(registro) e inserta la información recibida
        BasicDBObject documento = new BasicDBObject();
        documento.put("nombre", nombre);
        documento.put("dni",dni);
        documento.put("telefono",telf);
        documento.put("correo",correo);
        documento.put("domicilio",dom);
        documento.put("area",area);
        colec.insert(documento);
    }

    public static void insertarUsuario(DB db, String colection, String user, String pw, String idEmpleado){
        DBCollection colec = db.getCollection(colection);
        //Crea el documento(registro) e inserta la información recibida
        BasicDBObject documento = new BasicDBObject();
        documento.put("username", user);
        documento.put("password",pw);
        documento.put("cod_empleado",idEmpleado);
        colec.insert(documento);
    }
}
