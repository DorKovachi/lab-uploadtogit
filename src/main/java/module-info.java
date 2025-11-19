module org.openjfx.lab3thread {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.openjfx.lab3thread to javafx.fxml;
    exports org.openjfx.lab3thread;
}