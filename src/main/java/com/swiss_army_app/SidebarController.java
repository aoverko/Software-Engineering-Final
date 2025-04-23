package com.swiss_army_app;

import com.swiss_army_app.dashboard.DashboardController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class SidebarController {
    @FXML
    private ImageView dashIcon;

    @FXML
    public void loadDash(MouseEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(DashboardController.class.getResource("/com/swiss_army_app/dashboard/dashboard.fxml"));
        Scene dash = new Scene(fxmlLoader.load());

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(dash);
        stage.show();
    }

    @FXML
    private ImageView logoutIcon;

    @FXML
    public void loadLogout(MouseEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(DashboardController.class.getResource("/com/swiss_army_app/landing_page/landing-page.fxml"));
        Scene logout = new Scene(fxmlLoader.load());

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(logout);
        stage.show();
    }

    @FXML
    private ImageView settingsIcon;

    @FXML
    public void loadSettings(MouseEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(DashboardController.class.getResource("/com/swiss_army_app/settings/settings.fxml"));
        Scene settings = new Scene(fxmlLoader.load());

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(settings);
        stage.show();
    }

}
