module com.calculator {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.calculator to javafx.fxml;
    exports com.calculator;
}