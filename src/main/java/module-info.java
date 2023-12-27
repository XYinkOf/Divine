module ink.divin3 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens ink.divin3 to javafx.fxml;
    exports ink.divin3;
}