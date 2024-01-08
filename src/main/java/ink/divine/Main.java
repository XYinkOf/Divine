package ink.divine;

import ink.divine.waypoints.Waypoint;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        Pane root = new Pane();
        Scene scene = new Scene(root, 800, 600);
        primaryStage.setScene(scene);
        String version = "Divine - Version 0.0.2.3";
        primaryStage.setTitle(version);
        primaryStage.show();

        Image image = new Image(new FileInputStream("src/main/resources/ink/divine/assets/images/divineLogo.gif"));
        ImageView imageView = new ImageView(image);
        imageView.setX(25);
        imageView.setY(25);
        imageView.setFitHeight(100);
        imageView.setFitWidth(100);
        root.getChildren().add(imageView);

        Label title = new Label(version);
        title.setLayoutX(150);
        title.setLayoutY(50);
        title.setStyle("-fx-font-size: 24px;");
        root.getChildren().add(title);

        Label waypointLabel = new Label("Enter Soopy Waypoints: ");
        waypointLabel.setLayoutX(35);
        waypointLabel.setLayoutY(150);
        waypointLabel.setStyle("-fx-font-size: 18px;");
        root.getChildren().add(waypointLabel);
        TextArea waypointTextArea = new TextArea();
        waypointTextArea.setLayoutX(35);
        waypointTextArea.setLayoutY(175);
        waypointTextArea.setPrefSize(300, 300);
        waypointTextArea.setWrapText(true);
        waypointTextArea.setStyle("-fx-font-size: 10px;");
        root.getChildren().add(waypointTextArea);

        Button submitButton = new Button("Submit");
        submitButton.setLayoutX(35);
        submitButton.setLayoutY(500);
        submitButton.setStyle("-fx-font-size: 18px;");
        submitButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Waypoint[] waypoints = Waypoint.parseWaypoints(waypointTextArea.getText());
                for (Waypoint waypoint : waypoints) {
                    int[] coords = calc((int) waypoint.x, (int) waypoint.z);
                    Line line = new Line(coords[0], coords[1], coords[0], coords[1]);
                    line.setStrokeWidth(4);
                    line.setStyle("-fx-stroke: rgb(" + waypoint.r + ", " + waypoint.g + ", " + waypoint.b + ");");
                    root.getChildren().add(line);
                }
            }
        });
        root.getChildren().add(submitButton);

        Image map = new Image(new FileInputStream("src/main/resources/ink/divine/assets/images/map.png"));
        ImageView mapImageView = new ImageView(map);
        mapImageView.setX(400);
        mapImageView.setY(125);
        mapImageView.setFitHeight(350);
        mapImageView.setFitWidth(350);
        root.getChildren().add(mapImageView);

    }

    public int[] calc(int x, int z) {
        int[] coords = new int[2];

        coords[0] = 750*x/824;
        coords[1] = 475*z/824;

        return coords;
    }

    public static void main(String[] args) {
        launch();
    }
}

