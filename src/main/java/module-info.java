module com.examenfinal {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;
    requires transitive java.sql;

    opens com.examenfinal to javafx.fxml;
    opens com.examenfinal.pacientes.infrastructure to javafx.fxml;
    opens com.examenfinal.especialidades.infrastructure to javafx.fxml;

    exports com.examenfinal;
    exports com.examenfinal.pacientes.infrastructure;
    exports com.examenfinal.especialidades.infrastructure;

    exports com.examenfinal.pacientes.domain.entity;
    exports com.examenfinal.especialidades.domain.entity;
}
