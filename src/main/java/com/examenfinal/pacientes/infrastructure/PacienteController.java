package com.examenfinal.pacientes.infrastructure;

import java.io.IOException;
import java.sql.Date;

import com.examenfinal.App;
import com.examenfinal.pacientes.application.CreatePacienteUseCase;
import com.examenfinal.pacientes.application.DeletePacienteUseCase;
import com.examenfinal.pacientes.application.FindByIdPacienteUseCase;
import com.examenfinal.pacientes.application.UpdatePacienteUseCase;
import com.examenfinal.pacientes.domain.entity.Paciente;
import com.examenfinal.pacientes.domain.service.PacienteService;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class PacienteController {

    PacienteService pacienteService = new PacienteRepository();

    @FXML
    private VBox formActions;
    @FXML
    private Button createBtn;
    @FXML
    private Button updateBtn;
    @FXML
    private Button deleteBtn;
    @FXML
    private Button findBtn;

    // Create

    @FXML
    private VBox createBox;

    @FXML
    private TextField CNombre;
    @FXML
    private TextField CApellido;
    @FXML
    private TextField CFechaNac;
    @FXML
    private TextField CTelefono;
    @FXML
    private TextField CEmail;
    @FXML
    private TextField CDireccion;

    // Update

    @FXML
    private VBox updateBox;

    @FXML
    private TextField Uid;
    @FXML
    private TextField UNombre;
    @FXML
    private TextField UApellido;
    @FXML
    private TextField UFechaNac;
    @FXML
    private TextField UTelefono;
    @FXML
    private TextField UEmail;
    @FXML
    private TextField UDireccion;

    // Delete

    @FXML
    private VBox deleteBox;

    @FXML
    private TextField Did;

    // Find By Id

    @FXML
    private VBox findBox;

    @FXML
    private TextField FindId;

    @FXML
    private Label FNombre;
    @FXML
    private Label FApellido;
    @FXML
    private Label FFechaNac;
    @FXML
    private Label FTelefono;
    @FXML
    private Label FEmail;
    @FXML
    private Label FDireccion;

    public void initialize() {
        this.pacienteService = pacienteService;
    }

    @FXML
    public void eventAction(javafx.event.ActionEvent event) {
        Object source = event.getSource();
        if (source == createBtn) {
            ajustarVB(0, createBox, 480);
        } else if (source == updateBtn) {
            ajustarVB(0, updateBox, 480);
        } else if (source == deleteBtn) {
            ajustarVB(0, deleteBox, 480);
        } else if (source == findBtn) {
            ajustarVB(0, findBox, 480);
        }
    }

    @FXML
    public void createEntity() {
        Paciente paciente = new Paciente();
        paciente.setNombre(CNombre.getText());
        paciente.setApellido(CApellido.getText());
        paciente.setFechaNacimiento(Date.valueOf(CFechaNac.getText()));
        paciente.setTelefono(CTelefono.getText());
        paciente.setEmail(CEmail.getText());
        paciente.setDireccion(CDireccion.getText());
        CreatePacienteUseCase createPacienteUseCase = new CreatePacienteUseCase(pacienteService);
        createPacienteUseCase.execute(paciente);
        CNombre.setText("");
        CApellido.setText("");
        CFechaNac.setText("");
        CTelefono.setText("");
        CEmail.setText("");
        CDireccion.setText("");
    }

    @FXML
    public void updateEntity() {
        FindByIdPacienteUseCase findByIdPacienteUseCase = new FindByIdPacienteUseCase(pacienteService);
        Paciente paciente = findByIdPacienteUseCase.execute(Integer.parseInt(Uid.getText()));
        paciente.setNombre(UNombre.getText());
        paciente.setApellido(UApellido.getText());
        paciente.setFechaNacimiento(Date.valueOf(UFechaNac.getText()));
        paciente.setTelefono(UTelefono.getText());
        paciente.setEmail(UEmail.getText());
        paciente.setDireccion(UDireccion.getText());
        UpdatePacienteUseCase updatePacienteUseCase = new UpdatePacienteUseCase(pacienteService);
        updatePacienteUseCase.execute(paciente);
        Uid.setText("");
        UNombre.setText("");
        UApellido.setText("");
        UFechaNac.setText("");
        UTelefono.setText("");
        UEmail.setText("");
        UDireccion.setText("");
    }

    @FXML
    public void deleteEntity() {
        DeletePacienteUseCase deletePacienteUseCase = new DeletePacienteUseCase(pacienteService);
        deletePacienteUseCase.execute(Integer.parseInt(Did.getText()));
        Did.setText("");
    }

    @FXML
    public void findByIdEntity() {
        FindByIdPacienteUseCase findByIdPacienteUseCase = new FindByIdPacienteUseCase(pacienteService);
        Paciente paciente = findByIdPacienteUseCase.execute(Integer.parseInt(FindId.getText()));
        if (paciente != null) {
            FNombre.setText(paciente.getNombre());
            FApellido.setText(paciente.getApellido());
            FFechaNac.setText(String.valueOf(paciente.getFechaNacimiento()));
            FTelefono.setText(paciente.getTelefono());
            FEmail.setText(paciente.getEmail());
            FDireccion.setText(paciente.getDireccion());
        } else {
            FNombre.setText("Sin datos...");
            FApellido.setText("...😢");
            FFechaNac.setText("...😢");
            FTelefono.setText("...😢");
            FEmail.setText("...😢");
            FDireccion.setText("...😢");
        }
        FindId.setText("");
    }

    @FXML
    public void back() throws IOException {
        App.setRoot("crud");
    }

    public void ajustarVB(double formAlto, VBox vbox, double vbAlto) {
        formActions.setPrefHeight(0);
        vbox.setPrefHeight(vbAlto);
    }
}
