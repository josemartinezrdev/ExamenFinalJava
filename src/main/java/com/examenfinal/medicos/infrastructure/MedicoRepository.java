package com.examenfinal.medicos.infrastructure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import com.examenfinal.medicos.domain.entity.Medico;
import com.examenfinal.medicos.domain.service.MedicoService;

public class MedicoRepository implements MedicoService {
    private Connection connection;

    public MedicoRepository() {
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
    public void createMedico(Medico medico) {
        try {
            String query = """
                    INSERT INTO medicos (nombre, horaInicio, horaFin, idespecialidad)
                    VALUES (?,?,?,?)
                    """;
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, medico.getNombre());
            ps.setString(2, medico.getHoraInicio());
            ps.setString(3, medico.getHoraFin());
            ps.setInt(4, medico.getIdespecialidad());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateMedico(Medico medico) {
        try {
            String query = """
                    UPDATE medicos SET nombre = ?, horaInicio = ?, horaFin = ?, idespecialidad = ? WHERE id = ?
                    """;
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, medico.getNombre());
            ps.setString(2, medico.getHoraInicio());
            ps.setString(3, medico.getHoraFin());
            ps.setInt(4, medico.getIdespecialidad());
            ps.setInt(5, medico.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteMedico(int id) {
        try {
            String query = """
                    DELETE FROM medicos WHERE id = ?
                    """;
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Medico findByIdMedico(int id) {
        try {
            String query = """
                    SELECT id, nombre, horaInicio, horaFin, idespecialidad FROM medicos WHERE id = ?
                    """;
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new Medico(rs.getInt("id"), rs.getString("nombre"), rs.getString("horaInicio"),
                        rs.getString("horaFin"), rs.getInt("idespecialidad"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
