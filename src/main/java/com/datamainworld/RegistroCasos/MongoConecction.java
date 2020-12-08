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
            DB db = mongo.getDB("Pruebas");

            System.out.println("Base de datos creada");
            // Crea una coleccion (tabla) su no existe e inserta el documento(registro) a la coleccon
            insertarUsuario(db,"usuarios","Name1","Pais1");
            insertarUsuario(db,"usuarios","Name2","Pais2");
        }
    }

    public static MongoClient crearConexion(){
        System.out.println("Prueba conexion MongoDB");
        MongoClient mongo = null;
        mongo = new MongoClient("localhost",27017);
        return mongo;
    }

    public static void insertarUsuario(DB db, String colection, String nombre, String pais){
        DBCollection colec = db.getCollection(colection);
        //Crea el documento(registro) e inserta la información recibida
        BasicDBObject documento = new BasicDBObject();
        documento.put("nombre", nombre);
        documento.put("pais",pais);
        colec.insert(documento);
    }
}
