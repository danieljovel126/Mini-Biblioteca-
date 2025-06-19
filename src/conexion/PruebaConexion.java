package conexion;

import java.sql.Connection;

public class PruebaConexion {
    public static void main(String[] args) {
        Connection con = Conexion.obtenerConexion();
        if (con != null) {
            System.out.println("¡Conexión funcionando correctamente!");
        }
    }
}
