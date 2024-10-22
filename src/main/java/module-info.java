module org.example.csc311week09 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.csc311week09 to javafx.fxml;
    exports org.example.csc311week09;
}