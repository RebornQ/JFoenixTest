module com.example.jfoenixtest {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.javafx;
    requires com.jfoenix;

    opens com.example.jfoenixtest to javafx.fxml;
    exports com.example.jfoenixtest;
    exports com.example.jfoenixtest.data;
}