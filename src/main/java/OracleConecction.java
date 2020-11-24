import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleConecction {
    private final String dbUrl = "jdbc:oracle:thin:@152.67.62.154:1521/bdulima1_pdb1.subnetpub.vcninfra.oraclevcn.com";
    private final String username = "alumno12";
    private final String password = "PeruLima__2020";

    public OracleConecction(){};

    public Connection conectar(){
        try {
            return DriverManager.getConnection(dbUrl, username, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }
}
