/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamainworld.RegistroCasos.Interfaz;

import com.datamainworld.RegistroCasos.OracleConecction;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

import javax.swing.*;
import java.sql.*;

/**
 *
 * @author PC
 */
public class EmpleadoE extends javax.swing.JFrame {

    /**
     * Creates new form PersonalDeClientSolution
     */
    private Boolean edit = false;
    private int idEmpleado=-1;

    public EmpleadoE() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    public EmpleadoE(String nameEmpleado) {
        initComponents();
        this.setLocationRelativeTo(null);
        LlenarCampos(nameEmpleado);
        edit = true;
    }

    public void LlenarCampos(String nameEmpleado){
        Connection connection = new OracleConecction().conectar();
        System.out.println("Connected to Oracle database server");
        String query = "SELECT * FROM Empleado WHERE nombre='"+nameEmpleado+"'";
        try{
            //Preparando
            Statement statement = connection.prepareStatement(query);
            ResultSet result = statement.executeQuery(query);
            //Obteniendo
            while (result.next()) {
                idEmpleado = Integer.parseInt(result.getString("cod_empleado"));
                txt_name.setText(result.getString("nombre"));
                txt_dni.setText(result.getString("dni"));
                txt_telf.setText(result.getString("telf"));
                txt_email.setText(result.getString("correo"));
                txt_nac.setText(String.valueOf(result.getDate("fecha_nacimiento")));
                txt_domicilio.setText(result.getString("direcci�n"));
                txt_ingreso.setText(String.valueOf(result.getDate("fecha_ingreso_empresa")));
            }
            connection.close();
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    // FUNCIONES PARA MONGITO

    public MongoClient crearConexion(){
        System.out.println("Prueba conexion MongoDB");
        MongoClient mongo = null;
        mongo = new MongoClient("localhost",27017);
        return mongo;
    }

    public void insertarEmpleado(DB db, String colection, String cod, String nombre, String dni, String telf, String correo, String dom, String area ){
        DBCollection colec = db.getCollection(colection);
        //Crea el documento(registro) e inserta la informaci�n recibida
        BasicDBObject documento = new BasicDBObject();
        documento.put("cod",cod);
        documento.put("nombre", nombre);
        documento.put("dni",dni);
        documento.put("telefono",telf);
        documento.put("correo",correo);
        documento.put("domicilio",dom);
        documento.put("area",area);
        colec.insert(documento);
    }

    public void insertarUsuario(DB db, String colection, String user, String pw, String idEmpleado){
        DBCollection colec = db.getCollection(colection);
        //Crea el documento(registro) e inserta la informaci�n recibida
        BasicDBObject documento = new BasicDBObject();
        documento.put("username", user);
        documento.put("password",pw);
        documento.put("cod_empleado",idEmpleado);
        colec.insert(documento);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_name = new javax.swing.JTextField();
        txt_dni = new javax.swing.JTextField();
        txt_email = new javax.swing.JTextField();
        txt_nac = new javax.swing.JTextField();
        txt_domicilio = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_ingreso = new javax.swing.JTextField();
        txt_telf = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("Nombre:");

        jLabel3.setText("DNI:");

        jLabel4.setText("Correo electr�nico:");

        jLabel5.setText("Fecha de nacimiento:");

        jLabel6.setText("Direcci�n del domicilio:");

        txt_dni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_dniActionPerformed(evt);
            }
        });

        jLabel7.setText("Fecha de ingreso");

        txt_ingreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_ingresoActionPerformed(evt);
            }
        });

        txt_telf.setMinimumSize(new java.awt.Dimension(80, 50));
        txt_telf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_telfActionPerformed(evt);
            }
        });

        jLabel8.setText("Tel�fono:");

        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Personal Engineering");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_nac, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_email)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txt_domicilio))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(9, 9, 9)
                                        .addComponent(txt_ingreso, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(78, 78, 78)
                                .addComponent(txt_telf, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(83, 83, 83)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_dni, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel1)))
                .addContainerGap(33, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_dni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_telf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_nac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_domicilio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txt_ingreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_ingresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_ingresoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_ingresoActionPerformed

    private void txt_dniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_dniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_dniActionPerformed

    private void txt_telfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_telfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_telfActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (this.edit){
            System.out.println("Actualizar datos");
            Connection connection = new OracleConecction().conectar();
            System.out.println("Connected to Oracle database server");
            String sql = "{call ACTUALIZAREMPLEADO(?, ?, ?, ?, ?, ?, ?, ?)}";
            try{
                CallableStatement callableStatement = connection.prepareCall(sql);
                System.out.println("Procedimiento preparado");
                callableStatement.setString(1,Integer.toString(idEmpleado));
                callableStatement.setString(2,txt_dni.getText());
                callableStatement.setString(3,txt_email.getText());
                callableStatement.setString(4,txt_telf.getText());
                callableStatement.setString(5,txt_name.getText());
                callableStatement.setDate(6,Date.valueOf(txt_ingreso.getText()));
                callableStatement.setDate(7,Date.valueOf(txt_nac.getText()));
                System.out.println(txt_nac.getText());
                callableStatement.setString(8,txt_domicilio.getText());
                System.out.println("Parametros establecidos");
                System.out.println("Ejecutando procedimiento...");
                callableStatement.execute();
                JOptionPane.showMessageDialog(null,"Empleado actualizado correctamente");
                connection.close();
            }catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }else{
            System.out.println("Crear uno nuevo");
            String codArea = "2";
            Connection connection = new OracleConecction().conectar();
            System.out.println("Connected to Oracle database server");
            String sql = "INSERT INTO EMPLEADO VALUES (?, ?, ?, ?, ?, ? ,? ,?, ?)";
            String idCall = "select id_empleado.nextval from dual";
            String sqlUser = "INSERT INTO Usuario VALUEs(?, ?, ?, ?)";
            try{
                Statement statement2 = connection.createStatement();
                ResultSet result = statement2.executeQuery(idCall);
                String id="";
                while(result.next()) {
                    id = result.getString(1);
                }
                statement2.close();
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, id);
                statement.setString(2, txt_dni.getText());
                statement.setString(3, txt_email.getText());
                statement.setString(4, txt_telf.getText());
                statement.setString(5, txt_name.getText());
                statement.setString(6, txt_ingreso.getText());
                statement.setString(7, txt_nac.getText());
                statement.setString(8, txt_domicilio.getText());
                statement.setString(9, codArea);
                int rows = statement.executeUpdate();
                if(rows > 0 ){
                    System.out.println("A row has been inserted.");
                }
                //Crear un usuario
                PreparedStatement statement3 = connection.prepareStatement(sqlUser);
                char[] charName = txt_name.getText().toCharArray();
                String user = String.valueOf(charName[0])+String.valueOf(charName[1])+String.valueOf(charName[7])+String.valueOf(charName[8])+String.valueOf(charName[9]);
                user = user.toUpperCase();
                String pw = "123";
                statement3.setString(1,id);
                statement3.setString(2,user);
                statement3.setString(3,pw);
                statement3.setString(4,id);
                int rows2 = statement3.executeUpdate();
                if(rows2 > 0 ){
                    System.out.println("A row has been inserted.");
                }
                statement3.close();

                statement.close();
                connection.close();

                // PARTE MONGODB
                MongoClient mongo = crearConexion();
                // Si no existe la base de datos la creamos
                if (mongo != null){
                    DB db = mongo.getDB("BBVA");
                    System.out.println("Base de datos creada");
                    // Crea una coleccion (tabla) su no existe e inserta el documento(registro) a la coleccon
                    // Example insertarEmpleado(DB db, String colection, String nombre, String dni, String telf, String correo, String dom, String area )
                    String area;
                    if (codArea=="1"){
                        area="Client Solution";
                    }else area="Engineering";
                    insertarEmpleado(db,"empleados",id, txt_name.getText(),txt_dni.getText(),txt_telf.getText(),txt_email.getText(),txt_domicilio.getText(),area);
                    // Example insertarUsuario(DB db, String colection, String user, String pw, String idEmpleado)
                    insertarUsuario(db,"usuarios",user,pw,id);
                }
            }catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
        this.setVisible(false);
        Administrador temp = new Administrador();
        temp.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EmpleadoE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmpleadoE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmpleadoE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmpleadoE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmpleadoE().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField txt_dni;
    private javax.swing.JTextField txt_domicilio;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_ingreso;
    private javax.swing.JTextField txt_nac;
    private javax.swing.JTextField txt_name;
    private javax.swing.JTextField txt_telf;
    // End of variables declaration//GEN-END:variables
}
