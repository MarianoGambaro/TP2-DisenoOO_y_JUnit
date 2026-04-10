package tp2.ej3;

import tp2.ej1.Inscripcion;
import tp2.ej2.Ticket;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBExport implements Exportador {

    private String url;
    private String usuario;
    private String clave;

// meti los parametros dentro del constructor para aplicar la inyeccion de dependencias
    public DBExport(String url, String usuario, String clave){
        this.url = url;
        this.usuario = usuario;
        this.clave = clave;
    }

    @Override
    public void exportarPago(Ticket ticket) {
        try(Connection con = DriverManager.getConnection(url, usuario, clave)){

            String sql = "INSERT INTO pagos (fecha, monto) VALUES (?, ?)";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setObject(1, ticket.getFecha());
            stmt.setObject(2, ticket.getMonto());


            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void exportarInsc(Inscripcion insc) {
        try(Connection con = DriverManager.getConnection(url, usuario, clave)){

            String sql = "INSERT INTO inscripciones (fecha, id_participante, id_concurso) VALUES (?, ?, ?)";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setObject(1, insc.getFechaInscripcion());
            stmt.setObject(2, insc.getParticipante().getId());
            stmt.setObject(3, insc.getConcurso().getId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

