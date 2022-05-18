package org.example;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    TextField[][] textFields = new TextField[9][9];

    @Override
    public void start(Stage stage) {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        // Insert data into the grid
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                TextField t = new TextField();
                t.setAlignment(Pos.CENTER);
                textFields[c][r] = t;
                grid.add(t, c, r);
            }
        }

        // Add "Clear" button to the grid
        Button btn = new Button("Clear");
        HBox hbBox = new HBox(10);
        hbBox.getChildren().add(btn);
        hbBox.setAlignment(Pos.BOTTOM_LEFT);
        grid.add(hbBox, 0, 9, 3, 1);

        // Add functionality to the Clear button
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                for (int r = 0; r < 9; r++) {
                    for (int c = 0; c < 9; c++) {
                        textFields[c][r].setText("");
                        textFields[c][r].setStyle("-fx-background-color:rgb(255, 255, 255)");
                    }
                }
            }
        });

        // Add "Solve" button to the grid
        btn = new Button("Solve");
        hbBox = new HBox(10);
        hbBox.getChildren().add(btn);
        hbBox.setAlignment(Pos.BOTTOM_RIGHT);
        grid.add(hbBox, 6, 9, 3, 1);

        // Add functionality to the Solve button
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                /*Transfer all the numbers(integer) from our interface to partial board.*/
                Solver s = new Solver();
                Board partial = new Board();
                for (int r = 0; r < 9; r++) {
                    for (int c = 0; c < 9; c++) {
                        try {
                            Integer i = Integer.valueOf(textFields[c][r].getText().trim());
                            partial.set(c, r, i);
                        } catch (NumberFormatException e) {
                        }
                    }
                }
                Board solution = s.solve(partial);

                /*Update the UI based on the result.*/
                for (int r = 0; r < 9; r++) {
                    for (int c = 0; c < 9; c++) {
                        if (textFields[c][r].getText().trim().equals("")) {
                            if (solution == null) {
                                textFields[c][r].setStyle("-fx-background-color:rgb(255, 204, 204)");
                            } else {
                                textFields[c][r].setStyle("-fx-background-color:rgb(204, 255, 204)");
                                textFields[c][r].setText("" + solution.get(c, r));
                            }
                        } else {
                            textFields[c][r].setStyle("-fx-background-color:rgb(255, 255, 255)");
                        }
                    }
                }
            }
        });

        Scene scene = new Scene(grid, 400, 400);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}