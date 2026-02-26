package DBase;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionDB {
    public static Connection MySQL8() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/usuarios_db?useSSL=false&allowPublicKeyRetrieval=true";
        
        return DriverManager.getConnection(url, "root", "123");
    }
}
