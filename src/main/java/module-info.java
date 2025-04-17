module com.swiss_army_app {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;

//    opens com.swiss_army_app to javafx.fxml;
//    opens com.swiss_army_app.settings to javafx.fxml;
//    exports com.swiss_army_app;
    exports com.swiss_army_app.settings;
    opens com.swiss_army_app.landing_page to javafx.fxml;
    exports com.swiss_army_app.landing_page;
}
