package org.openjfx.lab3thread;


import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.Objects;

public class SceneSwitch {
    public SceneSwitch(AnchorPane currentScene, String newFXML) throws IOException{
        try {

            AnchorPane nextScene = FXMLLoader.load(Objects.requireNonNull(LoginApplication.class.getResource(newFXML)));
            currentScene.getChildren().removeAll();
            currentScene.getChildren().setAll(nextScene);
        } catch (Exception e) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(newFXML));
            System.out.println(loader.getLocation());
        }
    }

    public static class WelcomeController {
    }
}
