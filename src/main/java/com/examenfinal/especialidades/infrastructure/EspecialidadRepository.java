package com.examenfinal.especialidades.infrastructure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import com.examenfinal.especialidades.domain.entity.Especialidad;
import com.examenfinal.especialidades.domain.service.EspecialidadService;

public class EspecialidadRepository implements EspecialidadService {

    private Connection connection;

    public EspecialidadRepository() {
        try {
            Properties pr = new Properties();
            pr.load(getClass().getClassLoader().getResourceAsStream("db.properties"));
            String url = pr.getProperty("url");
            String user = pr.getProperty("user");
            String password = pr.getProperty("password");
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createEspecialidad(Especialidad especialidad) {
        try {
            String query = """
                    INSERT INTO especialidades (nombre) VALUES (?)
                    """;
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, especialidad.getNombre());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateEspecialidad(Especialidad especialidad) {
        try {
            String query = """
                    UPDATE especialidades SET nombre = ? WHERE id = ?
                    """;
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, especialidad.getNombre());
            ps.setInt(2, especialidad.getId());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteEspecialidad(int id) {
        try {
            String query = """
                    DELETE FROM especialidades WHERE id = ?
                    """;
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Especialidad findByIdEspecialidad(int id) {
        try {
            String query = """
                    SELECT id, nombre FROM especialidades WHERE id = ?
                    """;
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new Especialidad(rs.getInt("id"), rs.getString("nombre"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
