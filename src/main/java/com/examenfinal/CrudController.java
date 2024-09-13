package com.examenfinal;

import java.io.IOException;

import javafx.fxml.FXML;

public class CrudController {
    @FXML
    public void funPacientes() throws IOException {
        App.setRoot("pacientes");
    }

    @FXML
    public void funEspecialidades() throws IOException {
        App.setRoot("especialidades");
    }

    @FXML
    public void funMedicos() throws IOException {
    }

    @FXML
    public void funCitas() throws IOException {
    }

    @FXML
    public void back() {
        System.exit(0);
    }
}
