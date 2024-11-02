package org.example.inglab1;


import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;
import java.util.Random;

public class SlotMachineController {

    @FXML
    private Button spinButton;
    private ArrayList<ImageView> imageViewsInReels = new ArrayList<>();

    private Scene scene;
    private AnchorPane pane;

    public void onStartAnimation() {
        pane.getChildren().removeAll(imageViewsInReels);
        imageViewsInReels.clear();
        spinButton.setDisable(true);
        onStartFirstReel();
        onStartSecondReel();
        onStartThirdReel();
    }

    public void setScene(Scene scene) {
        this.scene = scene;
        this.pane = (AnchorPane) scene.getRoot();
    }

    private void onStartFirstReel() {
        Thread reelThread = new Thread() {
            private int countScrolls = 15;

            @Override
            public void run() {
                while (countScrolls > 1) {

                    ImageView imageView = onCreateRandomImage(300, 180);

                    Platform.runLater(() -> {
                        pane.getChildren().addFirst(imageView);
                    });

                    onMoveImageView(imageView, 400, countScrolls, 15);

                    Platform.runLater(() -> {
                        pane.getChildren().remove(imageView);
                    });

                    countScrolls--;
                }

                ImageView imageView = onCreateRandomImage(300, 180);

                Platform.runLater(() -> {
                    pane.getChildren().addFirst(imageView);
                });

                onMoveImageView(imageView, 280, 1, 15);
                imageViewsInReels.add(imageView);
            }
        };
        reelThread.setDaemon(true);
        reelThread.start();
    }

    private ImageView onCreateRandomImage(int x, int y) {
        Random random = new Random();
        Image image = new Image(String.valueOf(SlotMachine.class.getResource("images/" + (random.nextInt(4) + 1) + ".png")));
        ImageView imageView = new ImageView(image);

        imageView.setX(x);
        imageView.setY(y);
        imageView.setFitWidth(50);
        imageView.setFitHeight(50);

        return imageView;
    }

    ;

    private void onMoveImageView(ImageView imageView, int endY, int countScrolls, int delay) {
        while (imageView.getY() <= endY) {
            Platform.runLater(() -> {
                imageView.setY(imageView.getY() + 2);
            });

            try {
                Thread.sleep(delay / countScrolls);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void onStartSecondReel() {
        Thread reelThread = new Thread() {
            private int countScrolls = 20;

            @Override
            public void run() {
                while (countScrolls > 1) {

                    ImageView imageView = onCreateRandomImage(475, 180);

                    Platform.runLater(() -> {
                        pane.getChildren().addFirst(imageView);
                    });

                    onMoveImageView(imageView, 400, countScrolls, 20);

                    Platform.runLater(() -> {
                        pane.getChildren().remove(imageView);
                    });

                    countScrolls--;
                }

                ImageView imageView = onCreateRandomImage(475, 180);

                Platform.runLater(() -> {
                    pane.getChildren().addFirst(imageView);
                });

                onMoveImageView(imageView, 280, 1, 20);
                imageViewsInReels.add(imageView);
            }
        };
        reelThread.setDaemon(true);
        reelThread.start();
    }

    private void onStartThirdReel() {
        Thread reelThread = new Thread() {
            private int countScrolls = 25;

            @Override
            public void run() {
                while (countScrolls > 1) {

                    ImageView imageView = onCreateRandomImage(650, 180);

                    Platform.runLater(() -> {
                        pane.getChildren().addFirst(imageView);
                    });

                    onMoveImageView(imageView, 400, countScrolls, 25);

                    Platform.runLater(() -> {
                        pane.getChildren().remove(imageView);
                    });

                    countScrolls--;
                }

                ImageView imageView = onCreateRandomImage(650, 180);

                Platform.runLater(() -> {
                    pane.getChildren().addFirst(imageView);
                });

                onMoveImageView(imageView, 280, 1, 25);
                imageViewsInReels.add(imageView);

                Platform.runLater(() -> {
                    spinButton.setDisable(false);
                });
            }
        };
        reelThread.setDaemon(true);
        reelThread.start();
    }

}