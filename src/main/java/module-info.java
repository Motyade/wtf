module org.example.inglab1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.inglab1 to javafx.fxml;
    exports org.example.inglab1;
}