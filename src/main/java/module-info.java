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
    requires annotations;
    requires java.net.http;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.core;
    requires java.sql;


    opens com.swiss_army_app.sidebar to javafx.fxml;
    opens com.swiss_army_app.landing_page to javafx.fxml;
    opens com.swiss_army_app.settings to javafx.fxml;
    opens com.swiss_army_app.dashboard to javafx.fxml;
    opens com.swiss_army_app.daily_verse to javafx.fxml;
    opens com.swiss_army_app.other to javafx.fxml;
    opens com.swiss_army_app.sports_stats to javafx.fxml;
    opens com.swiss_army_app.tip_calculator to javafx.fxml;
    opens com.swiss_army_app.word_game to javafx.fxml;

    exports com.swiss_army_app.sidebar;
    exports com.swiss_army_app.landing_page;
    exports com.swiss_army_app.settings;
    exports com.swiss_army_app.dashboard;
    exports com.swiss_army_app.daily_verse;
    exports com.swiss_army_app.other;
    exports com.swiss_army_app.sports_stats;
    exports com.swiss_army_app.tip_calculator;
    exports com.swiss_army_app.word_game;
}
