module com.app {
    requires transitive javafx.controls;
    requires javafx.fxml;

    opens com.app to javafx.fxml;
    exports com.app;
}
