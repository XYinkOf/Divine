module ink.divine {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens ink.divine to javafx.fxml;
    exports ink.divine;
}