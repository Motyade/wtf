package org.example.inglab1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SlotMachine extends Application {
    private SlotMachineController slotMachineController;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SlotMachine.class.getResource("slot-machine-controller.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        slotMachineController = fxmlLoader.getController();
        slotMachineController.setScene(scene);
        stage.setTitle("SlotMachine");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }


}