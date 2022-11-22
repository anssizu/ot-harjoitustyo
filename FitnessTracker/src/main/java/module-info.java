module com.anssizu.fitnesstracker {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.anssizu.fitnesstracker to javafx.fxml;
    exports com.anssizu.fitnesstracker;
}
