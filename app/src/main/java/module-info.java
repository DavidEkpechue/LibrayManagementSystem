module com.app {
    requires java.sql;
    requires transitive javafx.controls;
    requires javafx.fxml;

    opens com.app to javafx.fxml;
    exports com.app;
}
