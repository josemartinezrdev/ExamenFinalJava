package com.examenfinal.pacientes.infrastructure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.examenfinal.pacientes.domain.entity.Paciente;
import com.examenfinal.pacientes.domain.service.PacienteService;

public class PacienteRepository implements PacienteService {

    private Connection connection;

    public PacienteRepository() {
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
    public void createPaciente(Paciente paciente) {
        try {
            String query = """
                    INSERT INTO pacientes (nombre, apellido, fechaNacimiento, telefono, email, direccion)
                    VALUES (?,?,?,?,?,?)
                    """;
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, paciente.getNombre());
            ps.setString(2, paciente.getApellido());
            ps.setDate(3, paciente.getFechaNacimiento());
            ps.setString(4, paciente.getTelefono());
            ps.setString(5, paciente.getEmail());
            ps.setString(6, paciente.getDireccion());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updatePaciente(Paciente paciente) {
        try {
            String query = """
                    UPDATE pacientes SET nombre = ?, apellido = ?, fechaNacimiento = ?, telefono = ?, email = ?,
                    direccion = ? WHERE id = ?
                    """;
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, paciente.getNombre());
            ps.setString(2, paciente.getApellido());
            ps.setDate(3, paciente.getFechaNacimiento());
            ps.setString(4, paciente.getTelefono());
            ps.setString(5, paciente.getEmail());
            ps.setString(6, paciente.getDireccion());
            ps.setInt(7, paciente.getId());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletePaciente(int id) {
        try {
            String query = """
                    DELETE FROM pacientes WHERE id = ?
                    """;
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Paciente> findAllPacientes() {
        List<Paciente> pacientes = new ArrayList<>();
        try {
            String query = """
                    SELECT id, nombre, apellido, fechaNacimiento, telefono, email, direccion
                    """;
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                pacientes.add(new Paciente(rs.getInt("id"), rs.getString("nombre"), rs.getString("apellido"),
                        rs.getDate("fechaNacimiento"), rs.getString("telefono"), rs.getString("email"),
                        rs.getString("direccion")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pacientes;
    }

    @Override
    public Paciente findByIdPaciente(int id) {
        try {
            String query = """
                    SELECT id, nombre, apellido, fechaNacimiento, telefono, email, direccion FROM pacientes WHERE id = ?
                    """;
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new Paciente(rs.getInt("id"), rs.getString("nombre"), rs.getString("apellido"),
                        rs.getDate("fechaNacimiento"), rs.getString("telefono"), rs.getString("email"),
                        rs.getString("direccion"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
