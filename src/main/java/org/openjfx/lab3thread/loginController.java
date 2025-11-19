package org.openjfx.lab3thread;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.ArrayList;

public class loginController {
    @FXML
    private AnchorPane loginScreen;

    @FXML
    private Label message;

    @FXML
    private TextField useremail;

    @FXML
    private TextField userpassword;


    @FXML
    protected void onHelloButtonClick(ActionEvent event) throws IOException {
        SharedDataSingleton data = SharedDataSingleton.getInstance();
        data.setActiveUsers("D:\\מדמח תואר שני\\lab1\\users.txt");
        ArrayList<User> users= data.getActiveUsers();

        for (User usr : users) {
            if(useremail.getText().equalsIgnoreCase(usr.getName()) &&
            userpassword.getText().equals(usr.getUserPass())){
                new SceneSwitch(loginScreen, "welcomeScreen.fxml");
                return;
            }
        }
        message.setText("wrong Username or password");

    }
}

