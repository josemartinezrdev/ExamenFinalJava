package com.examenfinal.especialidades.infrastructure;

import java.io.IOException;

import com.examenfinal.App;
import com.examenfinal.especialidades.application.CreateEspecialidadUseCase;
import com.examenfinal.especialidades.application.DeleteEspecialidadUseCase;
import com.examenfinal.especialidades.application.FindByIdEspecialidadUseCase;
import com.examenfinal.especialidades.application.UpdateEspecialidadUseCase;
import com.examenfinal.especialidades.domain.entity.Especialidad;
import com.examenfinal.especialidades.domain.service.EspecialidadService;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class EspecialidadController {
    EspecialidadService especialidadService = new EspecialidadRepository();

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

    // Upda

    @FXML
    private VBox updateBox;

    @FXML
    private TextField Uid;
    @FXML
    private TextField UNombre;

    // Del

    @FXML
    private VBox deleteBox;

    @FXML
    private TextField Did;

    // Find by

    @FXML
    private VBox findBox;

    @FXML
    private TextField FindId;

    @FXML
    private Label FNombre;

    public void initialize() {
        this.especialidadService = especialidadService;
    }

    @FXML
    public void back() throws IOException {
        App.setRoot("crud");
    }

    public void ajustarVB(double formAlto, VBox vbox, double vbAlto) {
        formActions.setPrefHeight(0);
        vbox.setPrefHeight(vbAlto);
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
        Especialidad especialidad = new Especialidad();
        especialidad.setNombre(CNombre.getText());
        CreateEspecialidadUseCase createEspecialidadUseCase = new CreateEspecialidadUseCase(especialidadService);
        createEspecialidadUseCase.execute(especialidad);
        CNombre.setText("");
    }

    @FXML
    public void updateEntity() {
        FindByIdEspecialidadUseCase findByIdEspecialidadUseCase = new FindByIdEspecialidadUseCase(especialidadService);
        Especialidad especialidad = findByIdEspecialidadUseCase.execute(Integer.parseInt(Uid.getText()));
        especialidad.setNombre(UNombre.getText());
        UpdateEspecialidadUseCase updateEspecialidadUseCase = new UpdateEspecialidadUseCase(especialidadService);
        updateEspecialidadUseCase.execute(especialidad);
        Uid.setText("");
        UNombre.setText("");
    }

    @FXML
    public void deleteEntity() {
        DeleteEspecialidadUseCase deleteEspecialidadUseCase = new DeleteEspecialidadUseCase(especialidadService);
        deleteEspecialidadUseCase.execute(Integer.parseInt(Did.getText()));
        Did.setText("");
    }

    @FXML
    public void findByIdEntity() {
        FindByIdEspecialidadUseCase findByIdEspecialidadUseCase = new FindByIdEspecialidadUseCase(especialidadService);
        Especialidad especialidad = findByIdEspecialidadUseCase.execute(Integer.parseInt(FindId.getText()));
        if (especialidad != null) {
            FNombre.setText(especialidad.getNombre());
        } else {
            FNombre.setText("Sin datos...");
        }
        FindId.setText(""); 
    }
}
