package rocnikovka;

import java.io.File;
import java.io.FileInputStream;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Rocnikovka extends Application {

    private final Pole[][] policko1 = new Pole[3][3];
    private final Pole[][] policko2 = new Pole[3][3];
    private final Pole[][] policko3 = new Pole[3][3];

    private char nynejsiHrac = 'X';
    File pozadi = new File("D:/pozadi.gif");
    Label multiStav = new Label(" ");
    Label compEasyStav = new Label(" ");
    Label compHardStav = new Label(" ");

    @Override
    public void start(Stage a) throws Exception {
        FileInputStream obrazekInput = new FileInputStream("D:/uvod.png");
        Image obrazek = new Image(obrazekInput);

        GridPane uvodPane = new GridPane();
        uvodPane.setHgap(15);
        uvodPane.setVgap(15);
        uvodPane.setAlignment(Pos.CENTER);
        uvodPane.setStyle("-fx-background-image: url('file:" + pozadi.getAbsolutePath() + "');");

        GridPane multiPole = new GridPane();
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                policko1[x][y] = new Pole();
                multiPole.add(policko1[x][y], y, x);
            }
        }
        multiPole.setVgap(10);
        multiPole.setHgap(10);
        multiPole.setAlignment(Pos.CENTER);
        multiPole.setStyle("-fx-background-image: url('file:" + pozadi.getAbsolutePath() + "');");

        GridPane compEasyPole = new GridPane();
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                policko2[x][y] = new Pole();
                compEasyPole.add(policko2[x][y], y, x);
            }
        }
        compEasyPole.setVgap(10);
        compEasyPole.setHgap(10);
        compEasyPole.setAlignment(Pos.CENTER);
        compEasyPole.setStyle("-fx-background-image: url('file:" + pozadi.getAbsolutePath() + "');");

        GridPane compHardPole = new GridPane();
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                policko3[x][y] = new Pole();
                compHardPole.add(policko3[x][y], y, x);
            }
        }
        compHardPole.setVgap(10);
        compHardPole.setHgap(10);
        compHardPole.setAlignment(Pos.CENTER);
        compHardPole.setStyle("-fx-background-image: url('file:" + pozadi.getAbsolutePath() + "');");

        Button multiTlacitko = new Button("HRÁČ proti HRÁČI");
        Button compEasyTlacitko = new Button("HRÁČ proti POČÍTAČI\n           (lehká)");
        Button compHardTlacitko = new Button("HRÁČ proti POČÍTAČI\n           (těžká)");
        Button resetTlacitko = new Button("ZNOVU");
        Button domuTlacitko = new Button("DOMŮ");
        Button endTlacitko = new Button("KONEC");

        multiStav.setStyle("-fx-font-size: 30px; -fx-text-fill: aqua");
        multiPole.add(multiStav, 0, 6);
        compEasyStav.setStyle("-fx-font-size: 25px; -fx-text-fill: aqua");
        compEasyPole.add(compEasyStav, 0, 6);
        compHardStav.setStyle("-fx-font-size: 25px; -fx-text-fill: aqua");
        compHardPole.add(compHardStav, 0, 6);

        multiTlacitko.setStyle("-fx-background-color: mediumvioletred; -fx-font-size: 40; -fx-text-fill: black; -fx-font-family: Verdana"); //font size 50, color: blue red green, font fill whitesmoke
        multiTlacitko.setPrefSize(684, 150);

        compEasyTlacitko.setStyle("-fx-background-color: darkturquoise; -fx-font-size: 40; -fx-text-fill: black; -fx-font-family: Verdana");
        compEasyTlacitko.setPrefSize(684, 150);

        compHardTlacitko.setStyle("-fx-background-color: darkblue; -fx-font-size: 40; -fx-text-fill: black; -fx-font-family: Verdana");
        compHardTlacitko.setPrefSize(684, 150);

        resetTlacitko.setStyle("-fx-background-color: darkturquoise; -fx-font-size: 35; -fx-text-fill: black; -fx-font-family: Verdana"); //green
        resetTlacitko.setPrefSize(200, 100);

        domuTlacitko.setStyle("-fx-background-color: darkblue; -fx-font-size: 35; -fx-text-fill: black; -fx-font-family: Verdana"); // gray
        domuTlacitko.setPrefSize(200, 100);

        endTlacitko.setStyle("-fx-background-color: mediumvioletred; -fx-font-size: 35; -fx-text-fill: black; -fx-font-family: Verdana"); //brown
        endTlacitko.setPrefSize(200, 100);

        uvodPane.add(new ImageView(obrazek), 1, 0);
        uvodPane.add(new Label(" \n "), 1, 1);
        uvodPane.add(multiTlacitko, 1, 2);
        uvodPane.add(compEasyTlacitko, 1, 3);
        uvodPane.add(compHardTlacitko, 1, 4);

        Scene uvodScene = new Scene(uvodPane, 300, 300);
        Scene compEasyScene = new Scene(compEasyPole, compEasyPole.getMaxWidth(), compEasyPole.getMaxHeight());
        Scene compHardScene = new Scene(compHardPole, compHardPole.getMaxWidth(), compHardPole.getMaxHeight());
        Scene multiScene = new Scene(multiPole, multiPole.getMaxWidth(), multiPole.getMaxHeight());

        a.setTitle("Piškvorky");
        a.setFullScreen(true);
        a.setScene(uvodScene);
        a.show();

        multiTlacitko.setOnAction(event -> {
            multiStav.setText("Hráč X hraje!");
            multiPole.add(domuTlacitko, 0, 4);
            multiPole.add(resetTlacitko, 1, 4);
            multiPole.add(endTlacitko, 2, 4);

            a.setScene(multiScene);
            a.setFullScreen(true);
        });

        compEasyTlacitko.setOnAction(event -> {
            compEasyPole.add(domuTlacitko, 0, 4);
            compEasyPole.add(resetTlacitko, 1, 4);
            compEasyPole.add(endTlacitko, 2, 4);

            a.setScene(compEasyScene);
            a.setFullScreen(true);
            CompEasy(policko2);
        });

        compHardTlacitko.setOnAction(event -> {
            compHardPole.add(domuTlacitko, 0, 4);
            compHardPole.add(resetTlacitko, 1, 4);
            compHardPole.add(endTlacitko, 2, 4);

            a.setScene(compHardScene);
            a.setFullScreen(true);
            CompHard(policko3);
        });

        resetTlacitko.setOnAction(event -> {
            for (int x = 0; x < 3; x++) {
                for (int y = 0; y < 3; y++) {
                    policko1[x][y].setHrac(' ');
                    policko2[x][y].setHrac(' ');
                    policko3[x][y].setHrac(' ');
                }
            }
            nynejsiHrac = 'X';
            multiStav.setText("Hráč X hraje!");
            compEasyStav.setText(" ");
            compHardStav.setText(" ");
        });

        domuTlacitko.setOnAction(event -> {
            for (int x = 0; x < 3; x++) {
                for (int y = 0; y < 3; y++) {
                    policko1[x][y].setHrac(' ');
                    policko2[x][y].setHrac(' ');
                    policko3[x][y].setHrac(' ');
                }
            }
            a.setScene(uvodScene);
            a.setFullScreen(true);

            nynejsiHrac = 'X';
            multiStav.setText(" ");
            compEasyStav.setText(" ");
            compHardStav.setText(" ");
        });

        endTlacitko.setOnAction(event -> {
            a.close();
        });
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void CompEasy(Pole[][] policko) {
        policko[0][0].setOnMouseClicked(e -> {
            if (policko[0][0].getHrac() == ' ' && compEasyStav.getText() == " ") {
                policko[0][0].setHrac('X');

                if (policko[0][1].getHrac() == 'X' && policko[0][2].getHrac() == ' ') {
                    policko[0][2].setHrac('O');
                } else if (policko[1][0].getHrac() == 'X' && policko[2][0].getHrac() == ' ') {
                    policko[2][0].setHrac('O');
                } else if (policko[1][1].getHrac() == 'X' && policko[2][2].getHrac() == ' ') {
                    policko[2][2].setHrac('O');
                } else if (policko[0][2].getHrac() == 'X' && policko[0][1].getHrac() == ' ') {
                    policko[0][1].setHrac('O');
                } else if (policko[2][0].getHrac() == 'X' && policko[1][0].getHrac() == ' ') {
                    policko[1][0].setHrac('O');
                } else if (policko[2][2].getHrac() == 'X' && policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[0][1].getHrac() == ' ') {
                    policko[0][1].setHrac('O');
                } else if (policko[2][2].getHrac() == ' ') {
                    policko[2][2].setHrac('O');
                } else if (policko[1][0].getHrac() == ' ') {
                    policko[1][0].setHrac('O');
                } else if (policko[0][2].getHrac() == ' ') {
                    policko[0][2].setHrac('O');
                } else if (policko[2][0].getHrac() == ' ') {
                    policko[2][0].setHrac('O');
                } else if (policko[1][2].getHrac() == ' ') {
                    policko[1][2].setHrac('O');
                } else if (policko[2][1].getHrac() == ' ') {
                    policko[2][1].setHrac('O');
                }
            }
            
            compStav(policko2, compEasyStav);
        });

        policko[0][1].setOnMouseClicked(e -> {
            if (policko[0][1].getHrac() == ' ' && compEasyStav.getText() == " ") {
                policko[0][1].setHrac('X');

                if (policko[0][0].getHrac() == 'X' && policko[0][2].getHrac() == ' ') {
                    policko[0][2].setHrac('O');
                } else if (policko[0][2].getHrac() == 'X' && policko[0][0].getHrac() == ' ') {
                    policko[0][0].setHrac('O');
                } else if (policko[1][1].getHrac() == 'X' && policko[2][1].getHrac() == ' ') {
                    policko[2][1].setHrac('O');
                } else if (policko[2][1].getHrac() == 'X' && policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[0][0].getHrac() == ' ') {
                    policko[0][0].setHrac('O');
                } else if (policko[0][2].getHrac() == ' ') {
                    policko[0][2].setHrac('O');
                } else if (policko[2][1].getHrac() == ' ') {
                    policko[2][1].setHrac('O');
                } else if (policko[1][0].getHrac() == ' ') {
                    policko[1][0].setHrac('O');
                } else if (policko[1][2].getHrac() == ' ') {
                    policko[1][2].setHrac('O');
                } else if (policko[2][2].getHrac() == ' ') {
                    policko[2][2].setHrac('O');
                } else if (policko[2][0].getHrac() == ' ') {
                    policko[2][0].setHrac('O');
                }
            }
            
            compStav(policko2, compEasyStav);
        });

        policko[0][2].setOnMouseClicked(e -> {
            if (policko[0][2].getHrac() == ' ' && compEasyStav.getText() == " ") {
                policko[0][2].setHrac('X');

                if (policko[0][1].getHrac() == 'X' && policko[0][0].getHrac() == ' ') {
                    policko[0][0].setHrac('O');
                } else if (policko[1][2].getHrac() == 'X' && policko[2][2].getHrac() == ' ') {
                    policko[2][2].setHrac('O');
                } else if (policko[1][1].getHrac() == 'X' && policko[2][0].getHrac() == ' ') {
                    policko[2][0].setHrac('O');
                } else if (policko[0][0].getHrac() == 'X' && policko[0][1].getHrac() == ' ') {
                    policko[0][1].setHrac('O');
                } else if (policko[2][2].getHrac() == 'X' && policko[1][2].getHrac() == ' ') {
                    policko[1][2].setHrac('O');
                } else if (policko[2][0].getHrac() == 'X' && policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[0][1].getHrac() == ' ') {
                    policko[0][1].setHrac('O');
                } else if (policko[1][2].getHrac() == ' ') {
                    policko[1][2].setHrac('O');
                } else if (policko[0][0].getHrac() == ' ') {
                    policko[0][0].setHrac('O');
                } else if (policko[2][2].getHrac() == ' ') {
                    policko[2][2].setHrac('O');
                } else if (policko[2][0].getHrac() == ' ') {
                    policko[2][0].setHrac('O');
                } else if (policko[1][0].getHrac() == ' ') {
                    policko[1][0].setHrac('O');
                } else if (policko[2][1].getHrac() == ' ') {
                    policko[2][1].setHrac('O');
                }
            }
            
            compStav(policko2, compEasyStav);
        });

        policko[1][0].setOnMouseClicked(e -> {
            if (policko[1][0].getHrac() == ' ' && compEasyStav.getText() == " ") {
                policko[1][0].setHrac('X');

                if (policko[0][0].getHrac() == 'X' && policko[2][0].getHrac() == ' ') {
                    policko[2][0].setHrac('O');
                } else if (policko[2][0].getHrac() == 'X' && policko[0][0].getHrac() == ' ') {
                    policko[0][0].setHrac('O');
                } else if (policko[1][1].getHrac() == 'X' && policko[1][2].getHrac() == ' ') {
                    policko[1][2].setHrac('O');
                } else if (policko[1][2].getHrac() == 'X' && policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[0][0].getHrac() == ' ') {
                    policko[0][0].setHrac('O');
                } else if (policko[2][0].getHrac() == ' ') {
                    policko[2][0].setHrac('O');
                } else if (policko[1][2].getHrac() == ' ') {
                    policko[1][2].setHrac('O');
                } else if (policko[0][1].getHrac() == ' ') {
                    policko[0][1].setHrac('O');
                } else if (policko[2][1].getHrac() == ' ') {
                    policko[2][1].setHrac('O');
                } else if (policko[2][2].getHrac() == ' ') {
                    policko[2][2].setHrac('O');
                } else if (policko[0][2].getHrac() == ' ') {
                    policko[0][2].setHrac('O');
                }
            }
            
            compStav(policko2, compEasyStav);
        });

        policko[1][1].setOnMouseClicked(e -> {
            if (policko[1][1].getHrac() == ' ' && compEasyStav.getText() == " ") {
                policko[1][1].setHrac('X');

                if (policko[0][1].getHrac() == 'X' && policko[2][1].getHrac() == ' ') {
                    policko[2][1].setHrac('O');
                } else if (policko[2][1].getHrac() == 'X' && policko[0][1].getHrac() == ' ') {
                    policko[0][1].setHrac('O');
                } else if (policko[1][0].getHrac() == 'X' && policko[1][2].getHrac() == ' ') {
                    policko[1][2].setHrac('O');
                } else if (policko[1][2].getHrac() == 'X' && policko[1][0].getHrac() == ' ') {
                    policko[1][0].setHrac('O');
                } else if (policko[2][0].getHrac() == 'X' && policko[0][2].getHrac() == ' ') {
                    policko[0][2].setHrac('O');
                } else if (policko[0][2].getHrac() == 'X' && policko[2][0].getHrac() == ' ') {
                    policko[2][0].setHrac('O');
                } else if (policko[0][0].getHrac() == 'X' && policko[2][2].getHrac() == ' ') {
                    policko[2][2].setHrac('O');
                } else if (policko[2][2].getHrac() == 'X' && policko[0][0].getHrac() == ' ') {
                    policko[0][0].setHrac('O');
                } else if (policko[1][0].getHrac() == ' ') {
                    policko[1][0].setHrac('O');
                } else if (policko[1][2].getHrac() == ' ') {
                    policko[1][2].setHrac('O');
                } else if (policko[0][1].getHrac() == ' ') {
                    policko[0][1].setHrac('O');
                } else if (policko[2][1].getHrac() == ' ') {
                    policko[2][1].setHrac('O');
                } else if (policko[0][0].getHrac() == ' ') {
                    policko[0][0].setHrac('O');
                } else if (policko[2][0].getHrac() == ' ') {
                    policko[2][0].setHrac('O');
                } else if (policko[2][2].getHrac() == ' ') {
                    policko[2][2].setHrac('O');
                } else if (policko[0][2].getHrac() == ' ') {
                    policko[0][2].setHrac('O');
                }
            }
            
            compStav(policko2, compEasyStav);
        });

        policko[1][2].setOnMouseClicked(e -> {
            if (policko[1][2].getHrac() == ' ' && compEasyStav.getText() == " ") {
                policko[1][2].setHrac('X');

                if (policko[0][2].getHrac() == 'X' && policko[2][2].getHrac() == ' ') {
                    policko[2][2].setHrac('O');
                } else if (policko[2][2].getHrac() == 'X' && policko[0][2].getHrac() == ' ') {
                    policko[0][2].setHrac('O');
                } else if (policko[1][1].getHrac() == 'X' && policko[1][0].getHrac() == ' ') {
                    policko[1][0].setHrac('O');
                } else if (policko[1][0].getHrac() == 'X' && policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[0][2].getHrac() == ' ') {
                    policko[0][2].setHrac('O');
                } else if (policko[2][2].getHrac() == ' ') {
                    policko[2][2].setHrac('O');
                } else if (policko[1][0].getHrac() == ' ') {
                    policko[1][0].setHrac('O');
                } else if (policko[2][1].getHrac() == ' ') {
                    policko[2][1].setHrac('O');
                } else if (policko[0][1].getHrac() == ' ') {
                    policko[0][1].setHrac('O');
                } else if (policko[0][0].getHrac() == ' ') {
                    policko[0][0].setHrac('O');
                } else if (policko[2][0].getHrac() == ' ') {
                    policko[2][0].setHrac('O');
                }
            }
            
            compStav(policko2, compEasyStav);
        });

        policko[2][0].setOnMouseClicked(e -> {
            if (policko[2][0].getHrac() == ' ' && compEasyStav.getText() == " ") {
                policko[2][0].setHrac('X');

                if (policko[2][1].getHrac() == 'X' && policko[2][2].getHrac() == ' ') {
                    policko[2][2].setHrac('O');
                } else if (policko[1][1].getHrac() == 'X' && policko[0][2].getHrac() == ' ') {
                    policko[0][2].setHrac('O');
                } else if (policko[1][0].getHrac() == 'X' && policko[0][0].getHrac() == ' ') {
                    policko[0][0].setHrac('O');
                } else if (policko[2][2].getHrac() == 'X' && policko[2][1].getHrac() == ' ') {
                    policko[2][1].setHrac('O');
                } else if (policko[0][2].getHrac() == 'X' && policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[0][0].getHrac() == 'X' && policko[1][0].getHrac() == ' ') {
                    policko[1][0].setHrac('O');
                } else if (policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[2][1].getHrac() == ' ') {
                    policko[2][1].setHrac('O');
                } else if (policko[1][0].getHrac() == ' ') {
                    policko[1][0].setHrac('O');
                } else if (policko[2][2].getHrac() == ' ') {
                    policko[2][2].setHrac('O');
                } else if (policko[0][0].getHrac() == ' ') {
                    policko[0][0].setHrac('O');
                } else if (policko[0][2].getHrac() == ' ') {
                    policko[0][2].setHrac('O');
                } else if (policko[1][2].getHrac() == ' ') {
                    policko[1][2].setHrac('O');
                } else if (policko[0][1].getHrac() == ' ') {
                    policko[0][1].setHrac('O');
                }
            }
            
            compStav(policko2, compEasyStav);
        });

        policko[2][1].setOnMouseClicked(e -> {
            if (policko[2][1].getHrac() == ' ' && compEasyStav.getText() == " ") {
                policko[2][1].setHrac('X');

                if (policko[2][0].getHrac() == 'X' && policko[2][2].getHrac() == ' ') {
                    policko[2][2].setHrac('O');
                } else if (policko[2][2].getHrac() == 'X' && policko[2][0].getHrac() == ' ') {
                    policko[2][0].setHrac('O');
                } else if (policko[1][1].getHrac() == 'X' && policko[0][1].getHrac() == ' ') {
                    policko[0][1].setHrac('O');
                } else if (policko[0][1].getHrac() == 'X' && policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[2][2].getHrac() == ' ') {
                    policko[2][2].setHrac('O');
                } else if (policko[2][0].getHrac() == ' ') {
                    policko[2][0].setHrac('O');
                } else if (policko[0][1].getHrac() == ' ') {
                    policko[0][1].setHrac('O');
                } else if (policko[1][0].getHrac() == ' ') {
                    policko[1][0].setHrac('O');
                } else if (policko[1][2].getHrac() == ' ') {
                    policko[1][2].setHrac('O');
                } else if (policko[0][0].getHrac() == ' ') {
                    policko[0][0].setHrac('O');
                } else if (policko[0][2].getHrac() == ' ') {
                    policko[0][2].setHrac('O');
                }
            }
            
            compStav(policko2, compEasyStav);
        });

        policko[2][2].setOnMouseClicked(e -> {
            if (policko[2][2].getHrac() == ' ' && compEasyStav.getText() == " ") {
                policko[2][2].setHrac('X');

                if (policko[2][1].getHrac() == 'X' && policko[2][0].getHrac() == ' ') {
                    policko[2][0].setHrac('O');
                } else if (policko[1][2].getHrac() == 'X' && policko[0][2].getHrac() == ' ') {
                    policko[0][2].setHrac('O');
                } else if (policko[1][1].getHrac() == 'X' && policko[0][0].getHrac() == ' ') {
                    policko[0][0].setHrac('O');
                } else if (policko[0][2].getHrac() == 'X' && policko[1][2].getHrac() == ' ') {
                    policko[1][2].setHrac('O');
                } else if (policko[2][0].getHrac() == 'X' && policko[2][1].getHrac() == ' ') {
                    policko[2][1].setHrac('O');
                } else if (policko[0][0].getHrac() == 'X' && policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[2][1].getHrac() == ' ') {
                    policko[2][1].setHrac('O');
                } else if (policko[1][2].getHrac() == ' ') {
                    policko[1][2].setHrac('O');
                } else if (policko[0][2].getHrac() == ' ') {
                    policko[0][2].setHrac('O');
                } else if (policko[2][0].getHrac() == ' ') {
                    policko[2][0].setHrac('O');
                } else if (policko[0][0].getHrac() == ' ') {
                    policko[0][0].setHrac('O');
                } else if (policko[1][0].getHrac() == ' ') {
                    policko[1][0].setHrac('O');
                } else if (policko[0][1].getHrac() == ' ') {
                    policko[0][1].setHrac('O');
                }
            }
            
            compStav(policko2, compEasyStav);
        });

    }

    public boolean vyhra(char hrac) {
        if (policko1[2][2].getHrac() == hrac && policko1[1][1].getHrac() == hrac && policko1[0][0].getHrac() == hrac) {
            return true;
        }

        if (policko1[2][0].getHrac() == hrac && policko1[1][1].getHrac() == hrac && policko1[0][2].getHrac() == hrac) {
            return true;
        }

        for (int x = 0; x < 3; x++) {
            if (policko1[2][x].getHrac() == hrac && policko1[1][x].getHrac() == hrac && policko1[0][x].getHrac() == hrac) {
                return true;
            }
        }

        for (int x = 0; x < 3; x++) {
            if (policko1[x][2].getHrac() == hrac && policko1[x][1].getHrac() == hrac && policko1[x][0].getHrac() == hrac) {
                return true;
            }
        }

        return false;
    }

    public boolean jePlno() {
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                if (policko1[x][y].getHrac() == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public void CompHard(Pole[][] policko) {
        policko[0][0].setOnMouseClicked(e -> {
            if (policko[0][0].getHrac() == ' ' && compHardStav.getText() == " ") {
                policko[0][0].setHrac('X');

                if (policko[1][1].getHrac() == 'O' && policko[2][1].getHrac() == 'O' && policko[0][1].getHrac() == ' ') {
                    policko[0][1].setHrac('O');
                } else if (policko[2][1].getHrac() == 'O' && policko[1][1].getHrac() == 'O' && policko[0][1].getHrac() == ' ') {
                    policko[0][1].setHrac('O');
                } else if (policko[0][1].getHrac() == 'O' && policko[2][1].getHrac() == 'O' && policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[2][1].getHrac() == 'O' && policko[0][1].getHrac() == 'O' && policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[0][1].getHrac() == 'O' && policko[1][1].getHrac() == 'O' && policko[2][1].getHrac() == ' ') {
                    policko[2][1].setHrac('O');
                } else if (policko[1][1].getHrac() == 'O' && policko[0][1].getHrac() == 'O' && policko[2][1].getHrac() == ' ') {
                    policko[2][1].setHrac('O');

                } else if (policko[1][1].getHrac() == 'O' && policko[1][2].getHrac() == 'O' && policko[1][0].getHrac() == ' ') {
                    policko[1][0].setHrac('O');
                } else if (policko[1][2].getHrac() == 'O' && policko[1][1].getHrac() == 'O' && policko[1][0].getHrac() == ' ') {
                    policko[1][0].setHrac('O');
                } else if (policko[1][0].getHrac() == 'O' && policko[1][2].getHrac() == 'O' && policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[1][2].getHrac() == 'O' && policko[1][0].getHrac() == 'O' && policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[1][0].getHrac() == 'O' && policko[1][1].getHrac() == 'O' && policko[1][2].getHrac() == ' ') {
                    policko[1][2].setHrac('O');
                } else if (policko[1][1].getHrac() == 'O' && policko[1][0].getHrac() == 'O' && policko[1][2].getHrac() == ' ') {
                    policko[1][2].setHrac('O');

                } else if (policko[1][2].getHrac() == 'O' && policko[2][2].getHrac() == 'O' && policko[0][2].getHrac() == ' ') {
                    policko[0][2].setHrac('O');
                } else if (policko[2][2].getHrac() == 'O' && policko[1][2].getHrac() == 'O' && policko[0][2].getHrac() == ' ') {
                    policko[0][2].setHrac('O');
                } else if (policko[0][2].getHrac() == 'O' && policko[2][2].getHrac() == 'O' && policko[1][2].getHrac() == ' ') {
                    policko[1][2].setHrac('O');
                } else if (policko[2][2].getHrac() == 'O' && policko[0][2].getHrac() == 'O' && policko[1][2].getHrac() == ' ') {
                    policko[1][2].setHrac('O');
                } else if (policko[0][2].getHrac() == 'O' && policko[1][2].getHrac() == 'O' && policko[2][2].getHrac() == ' ') {
                    policko[2][2].setHrac('O');
                } else if (policko[1][2].getHrac() == 'O' && policko[0][2].getHrac() == 'O' && policko[2][2].getHrac() == ' ') {
                    policko[2][2].setHrac('O');

                } else if (policko[2][1].getHrac() == 'O' && policko[2][2].getHrac() == 'O' && policko[2][0].getHrac() == ' ') {
                    policko[2][0].setHrac('O');
                } else if (policko[2][2].getHrac() == 'O' && policko[2][1].getHrac() == 'O' && policko[2][0].getHrac() == ' ') {
                    policko[2][0].setHrac('O');
                } else if (policko[2][0].getHrac() == 'O' && policko[2][2].getHrac() == 'O' && policko[2][1].getHrac() == ' ') {
                    policko[2][1].setHrac('O');
                } else if (policko[2][2].getHrac() == 'O' && policko[2][0].getHrac() == 'O' && policko[2][1].getHrac() == ' ') {
                    policko[2][1].setHrac('O');
                } else if (policko[2][0].getHrac() == 'O' && policko[2][1].getHrac() == 'O' && policko[2][2].getHrac() == ' ') {
                    policko[2][2].setHrac('O');
                } else if (policko[2][1].getHrac() == 'O' && policko[2][0].getHrac() == 'O' && policko[2][2].getHrac() == ' ') {
                    policko[2][2].setHrac('O');

                } else if (policko[1][1].getHrac() == 'O' && policko[0][2].getHrac() == 'O' && policko[2][0].getHrac() == ' ') {
                    policko[2][0].setHrac('O');
                } else if (policko[0][2].getHrac() == 'O' && policko[1][1].getHrac() == 'O' && policko[2][0].getHrac() == ' ') {
                    policko[2][0].setHrac('O');
                } else if (policko[2][0].getHrac() == 'O' && policko[0][2].getHrac() == 'O' && policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[0][2].getHrac() == 'O' && policko[2][0].getHrac() == 'O' && policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[2][0].getHrac() == 'O' && policko[1][1].getHrac() == 'O' && policko[0][2].getHrac() == ' ') {
                    policko[0][2].setHrac('O');
                } else if (policko[1][1].getHrac() == 'O' && policko[2][0].getHrac() == 'O' && policko[0][2].getHrac() == ' ') {
                    policko[0][2].setHrac('O');

                } else if (policko[0][1].getHrac() == 'X' && policko[0][2].getHrac() == ' ') {
                    policko[0][2].setHrac('O');
                } else if (policko[0][2].getHrac() == 'X' && policko[0][1].getHrac() == ' ') {
                    policko[0][1].setHrac('O');
                } else if (policko[1][1].getHrac() == 'X' && policko[2][2].getHrac() == ' ') {
                    policko[2][2].setHrac('O');
                } else if (policko[2][2].getHrac() == 'X' && policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[1][0].getHrac() == 'X' && policko[2][0].getHrac() == ' ') {
                    policko[2][0].setHrac('O');
                } else if (policko[2][0].getHrac() == 'X' && policko[1][0].getHrac() == ' ') {
                    policko[1][0].setHrac('O');

                } else if (policko[1][1].getHrac() == ' ' && policko[2][1].getHrac() == 'O' && policko[0][1].getHrac() == ' ') {
                    policko[0][1].setHrac('O');
                } else if (policko[2][1].getHrac() == ' ' && policko[1][1].getHrac() == 'O' && policko[0][1].getHrac() == ' ') {
                    policko[0][1].setHrac('O');
                } else if (policko[0][1].getHrac() == ' ' && policko[2][1].getHrac() == 'O' && policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[2][1].getHrac() == ' ' && policko[0][1].getHrac() == 'O' && policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[0][1].getHrac() == ' ' && policko[1][1].getHrac() == 'O' && policko[2][1].getHrac() == ' ') {
                    policko[2][1].setHrac('O');
                } else if (policko[1][1].getHrac() == ' ' && policko[0][1].getHrac() == 'O' && policko[2][1].getHrac() == ' ') {
                    policko[2][1].setHrac('O');

                } else if (policko[1][1].getHrac() == ' ' && policko[1][2].getHrac() == 'O' && policko[1][0].getHrac() == ' ') {
                    policko[1][0].setHrac('O');
                } else if (policko[1][2].getHrac() == ' ' && policko[1][1].getHrac() == 'O' && policko[1][0].getHrac() == ' ') {
                    policko[1][0].setHrac('O');
                } else if (policko[1][0].getHrac() == ' ' && policko[1][2].getHrac() == 'O' && policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[1][2].getHrac() == ' ' && policko[1][0].getHrac() == 'O' && policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[1][0].getHrac() == ' ' && policko[1][1].getHrac() == 'O' && policko[1][2].getHrac() == ' ') {
                    policko[1][2].setHrac('O');
                } else if (policko[1][1].getHrac() == ' ' && policko[1][0].getHrac() == 'O' && policko[1][2].getHrac() == ' ') {
                    policko[1][2].setHrac('O');

                } else if (policko[1][2].getHrac() == ' ' && policko[2][2].getHrac() == 'O' && policko[0][2].getHrac() == ' ') {
                    policko[0][2].setHrac('O');
                } else if (policko[2][2].getHrac() == ' ' && policko[1][2].getHrac() == 'O' && policko[0][2].getHrac() == ' ') {
                    policko[0][2].setHrac('O');
                } else if (policko[0][2].getHrac() == ' ' && policko[2][2].getHrac() == 'O' && policko[1][2].getHrac() == ' ') {
                    policko[1][2].setHrac('O');
                } else if (policko[2][2].getHrac() == ' ' && policko[0][2].getHrac() == 'O' && policko[1][2].getHrac() == ' ') {
                    policko[1][2].setHrac('O');
                } else if (policko[0][2].getHrac() == ' ' && policko[1][2].getHrac() == 'O' && policko[2][2].getHrac() == ' ') {
                    policko[2][2].setHrac('O');
                } else if (policko[1][2].getHrac() == ' ' && policko[0][2].getHrac() == 'O' && policko[2][2].getHrac() == ' ') {
                    policko[2][2].setHrac('O');

                } else if (policko[2][1].getHrac() == ' ' && policko[2][2].getHrac() == 'O' && policko[2][0].getHrac() == ' ') {
                    policko[2][0].setHrac('O');
                } else if (policko[2][2].getHrac() == ' ' && policko[2][1].getHrac() == 'O' && policko[2][0].getHrac() == ' ') {
                    policko[2][0].setHrac('O');
                } else if (policko[2][0].getHrac() == ' ' && policko[2][2].getHrac() == 'O' && policko[2][1].getHrac() == ' ') {
                    policko[2][1].setHrac('O');
                } else if (policko[2][2].getHrac() == ' ' && policko[2][0].getHrac() == 'O' && policko[2][1].getHrac() == ' ') {
                    policko[2][1].setHrac('O');
                } else if (policko[2][0].getHrac() == ' ' && policko[2][1].getHrac() == 'O' && policko[2][2].getHrac() == ' ') {
                    policko[2][2].setHrac('O');
                } else if (policko[2][1].getHrac() == ' ' && policko[2][0].getHrac() == 'O' && policko[2][2].getHrac() == ' ') {
                    policko[2][2].setHrac('O');

                } else if (policko[1][1].getHrac() == ' ' && policko[0][2].getHrac() == 'O' && policko[2][0].getHrac() == ' ') {
                    policko[2][0].setHrac('O');
                } else if (policko[0][2].getHrac() == ' ' && policko[1][1].getHrac() == 'O' && policko[2][0].getHrac() == ' ') {
                    policko[2][0].setHrac('O');
                } else if (policko[2][0].getHrac() == ' ' && policko[0][2].getHrac() == 'O' && policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[0][2].getHrac() == ' ' && policko[2][0].getHrac() == 'O' && policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[2][0].getHrac() == ' ' && policko[1][1].getHrac() == 'O' && policko[0][2].getHrac() == ' ') {
                    policko[0][2].setHrac('O');
                } else if (policko[1][1].getHrac() == ' ' && policko[2][0].getHrac() == 'O' && policko[0][2].getHrac() == ' ') {
                    policko[0][2].setHrac('O');

                } else if (policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[0][1].getHrac() == ' ') {
                    policko[0][1].setHrac('O');
                } else if (policko[1][0].getHrac() == ' ') {
                    policko[1][0].setHrac('O');

                } else if (policko[0][2].getHrac() == ' ') {
                    policko[0][2].setHrac('O');
                } else if (policko[2][0].getHrac() == ' ') {
                    policko[2][0].setHrac('O');
                } else if (policko[2][2].getHrac() == ' ') {
                    policko[2][2].setHrac('O');
                } else if (policko[1][2].getHrac() == ' ') {
                    policko[1][2].setHrac('O');
                } else if (policko[2][1].getHrac() == ' ') {
                    policko[2][1].setHrac('O');
                }
            }
            
            compStav(policko3, compHardStav);
        });

        policko[0][1].setOnMouseClicked(e -> {
            if (policko[0][1].getHrac() == ' ' && compHardStav.getText() == " ") {
                policko[0][1].setHrac('X');

                if (policko[1][0].getHrac() == 'O' && policko[2][0].getHrac() == 'O' && policko[0][0].getHrac() == ' ') {
                    policko[0][0].setHrac('O');
                } else if (policko[2][0].getHrac() == 'O' && policko[1][0].getHrac() == 'O' && policko[0][0].getHrac() == ' ') {
                    policko[0][0].setHrac('O');
                } else if (policko[0][0].getHrac() == 'O' && policko[2][0].getHrac() == 'O' && policko[1][0].getHrac() == ' ') {
                    policko[1][0].setHrac('O');
                } else if (policko[2][0].getHrac() == 'O' && policko[0][0].getHrac() == 'O' && policko[1][0].getHrac() == ' ') {
                    policko[1][0].setHrac('O');
                } else if (policko[0][0].getHrac() == 'O' && policko[1][0].getHrac() == 'O' && policko[2][0].getHrac() == ' ') {
                    policko[2][0].setHrac('O');
                } else if (policko[1][0].getHrac() == 'O' && policko[0][0].getHrac() == 'O' && policko[2][0].getHrac() == ' ') {
                    policko[2][0].setHrac('O');

                } else if (policko[1][1].getHrac() == 'O' && policko[1][2].getHrac() == 'O' && policko[1][0].getHrac() == ' ') {
                    policko[1][0].setHrac('O');
                } else if (policko[1][2].getHrac() == 'O' && policko[1][1].getHrac() == 'O' && policko[1][0].getHrac() == ' ') {
                    policko[1][0].setHrac('O');
                } else if (policko[1][0].getHrac() == 'O' && policko[1][2].getHrac() == 'O' && policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[1][2].getHrac() == 'O' && policko[1][0].getHrac() == 'O' && policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[1][0].getHrac() == 'O' && policko[1][1].getHrac() == 'O' && policko[1][2].getHrac() == ' ') {
                    policko[1][2].setHrac('O');
                } else if (policko[1][1].getHrac() == 'O' && policko[1][0].getHrac() == 'O' && policko[1][2].getHrac() == ' ') {
                    policko[1][2].setHrac('O');

                } else if (policko[1][2].getHrac() == 'O' && policko[2][2].getHrac() == 'O' && policko[0][2].getHrac() == ' ') {
                    policko[0][2].setHrac('O');
                } else if (policko[2][2].getHrac() == 'O' && policko[1][2].getHrac() == 'O' && policko[0][2].getHrac() == ' ') {
                    policko[0][2].setHrac('O');
                } else if (policko[0][2].getHrac() == 'O' && policko[2][2].getHrac() == 'O' && policko[1][2].getHrac() == ' ') {
                    policko[1][2].setHrac('O');
                } else if (policko[2][2].getHrac() == 'O' && policko[0][2].getHrac() == 'O' && policko[1][2].getHrac() == ' ') {
                    policko[1][2].setHrac('O');
                } else if (policko[0][2].getHrac() == 'O' && policko[1][2].getHrac() == 'O' && policko[2][2].getHrac() == ' ') {
                    policko[2][2].setHrac('O');
                } else if (policko[1][2].getHrac() == 'O' && policko[0][2].getHrac() == 'O' && policko[2][2].getHrac() == ' ') {
                    policko[2][2].setHrac('O');

                } else if (policko[2][1].getHrac() == 'O' && policko[2][2].getHrac() == 'O' && policko[2][0].getHrac() == ' ') {
                    policko[2][0].setHrac('O');
                } else if (policko[2][2].getHrac() == 'O' && policko[2][1].getHrac() == 'O' && policko[2][0].getHrac() == ' ') {
                    policko[2][0].setHrac('O');
                } else if (policko[2][0].getHrac() == 'O' && policko[2][2].getHrac() == 'O' && policko[2][1].getHrac() == ' ') {
                    policko[2][1].setHrac('O');
                } else if (policko[2][2].getHrac() == 'O' && policko[2][0].getHrac() == 'O' && policko[2][1].getHrac() == ' ') {
                    policko[2][1].setHrac('O');
                } else if (policko[2][0].getHrac() == 'O' && policko[2][1].getHrac() == 'O' && policko[2][2].getHrac() == ' ') {
                    policko[2][2].setHrac('O');
                } else if (policko[2][1].getHrac() == 'O' && policko[2][0].getHrac() == 'O' && policko[2][2].getHrac() == ' ') {
                    policko[2][2].setHrac('O');

                } else if (policko[1][1].getHrac() == 'O' && policko[0][2].getHrac() == 'O' && policko[2][0].getHrac() == ' ') {
                    policko[2][0].setHrac('O');
                } else if (policko[0][2].getHrac() == 'O' && policko[1][1].getHrac() == 'O' && policko[2][0].getHrac() == ' ') {
                    policko[2][0].setHrac('O');
                } else if (policko[2][0].getHrac() == 'O' && policko[0][2].getHrac() == 'O' && policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[0][2].getHrac() == 'O' && policko[2][0].getHrac() == 'O' && policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[2][0].getHrac() == 'O' && policko[1][1].getHrac() == 'O' && policko[0][2].getHrac() == ' ') {
                    policko[0][2].setHrac('O');
                } else if (policko[1][1].getHrac() == 'O' && policko[2][0].getHrac() == 'O' && policko[0][2].getHrac() == ' ') {
                    policko[0][2].setHrac('O');

                } else if (policko[1][1].getHrac() == 'O' && policko[0][0].getHrac() == 'O' && policko[2][2].getHrac() == ' ') {
                    policko[2][2].setHrac('O');
                } else if (policko[0][0].getHrac() == 'O' && policko[1][1].getHrac() == 'O' && policko[2][2].getHrac() == ' ') {
                    policko[2][2].setHrac('O');
                } else if (policko[2][2].getHrac() == 'O' && policko[0][0].getHrac() == 'O' && policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[0][0].getHrac() == 'O' && policko[2][2].getHrac() == 'O' && policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[2][2].getHrac() == 'O' && policko[1][1].getHrac() == 'O' && policko[0][0].getHrac() == ' ') {
                    policko[0][0].setHrac('O');
                } else if (policko[1][1].getHrac() == 'O' && policko[2][2].getHrac() == 'O' && policko[0][0].getHrac() == ' ') {
                    policko[0][0].setHrac('O');

                } else if (policko[0][0].getHrac() == 'X' && policko[0][2].getHrac() == ' ') {
                    policko[0][2].setHrac('O');
                } else if (policko[0][2].getHrac() == 'X' && policko[0][0].getHrac() == ' ') {
                    policko[0][0].setHrac('O');
                } else if (policko[1][1].getHrac() == 'X' && policko[2][1].getHrac() == ' ') {
                    policko[2][1].setHrac('O');
                } else if (policko[2][1].getHrac() == 'X' && policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');

                } else if (policko[1][0].getHrac() == ' ' && policko[2][0].getHrac() == 'O' && policko[0][0].getHrac() == ' ') {
                    policko[0][0].setHrac('O');
                } else if (policko[2][0].getHrac() == ' ' && policko[1][0].getHrac() == 'O' && policko[0][0].getHrac() == ' ') {
                    policko[0][0].setHrac('O');
                } else if (policko[0][0].getHrac() == ' ' && policko[2][0].getHrac() == 'O' && policko[1][0].getHrac() == ' ') {
                    policko[1][0].setHrac('O');
                } else if (policko[2][0].getHrac() == ' ' && policko[0][0].getHrac() == 'O' && policko[1][0].getHrac() == ' ') {
                    policko[1][0].setHrac('O');
                } else if (policko[0][0].getHrac() == ' ' && policko[1][0].getHrac() == 'O' && policko[2][0].getHrac() == ' ') {
                    policko[2][0].setHrac('O');
                } else if (policko[1][0].getHrac() == ' ' && policko[0][0].getHrac() == 'O' && policko[2][0].getHrac() == ' ') {
                    policko[2][0].setHrac('O');

                } else if (policko[1][1].getHrac() == ' ' && policko[1][2].getHrac() == 'O' && policko[1][0].getHrac() == ' ') {
                    policko[1][0].setHrac('O');
                } else if (policko[1][2].getHrac() == ' ' && policko[1][1].getHrac() == 'O' && policko[1][0].getHrac() == ' ') {
                    policko[1][0].setHrac('O');
                } else if (policko[1][0].getHrac() == ' ' && policko[1][2].getHrac() == 'O' && policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[1][2].getHrac() == ' ' && policko[1][0].getHrac() == 'O' && policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[1][0].getHrac() == ' ' && policko[1][1].getHrac() == 'O' && policko[1][2].getHrac() == ' ') {
                    policko[1][2].setHrac('O');
                } else if (policko[1][1].getHrac() == ' ' && policko[1][0].getHrac() == 'O' && policko[1][2].getHrac() == ' ') {
                    policko[1][2].setHrac('O');

                } else if (policko[1][2].getHrac() == ' ' && policko[2][2].getHrac() == 'O' && policko[0][2].getHrac() == ' ') {
                    policko[0][2].setHrac('O');
                } else if (policko[2][2].getHrac() == ' ' && policko[1][2].getHrac() == 'O' && policko[0][2].getHrac() == ' ') {
                    policko[0][2].setHrac('O');
                } else if (policko[0][2].getHrac() == ' ' && policko[2][2].getHrac() == 'O' && policko[1][2].getHrac() == ' ') {
                    policko[1][2].setHrac('O');
                } else if (policko[2][2].getHrac() == ' ' && policko[0][2].getHrac() == 'O' && policko[1][2].getHrac() == ' ') {
                    policko[1][2].setHrac('O');
                } else if (policko[0][2].getHrac() == ' ' && policko[1][2].getHrac() == 'O' && policko[2][2].getHrac() == ' ') {
                    policko[2][2].setHrac('O');
                } else if (policko[1][2].getHrac() == ' ' && policko[0][2].getHrac() == 'O' && policko[2][2].getHrac() == ' ') {
                    policko[2][2].setHrac('O');

                } else if (policko[2][1].getHrac() == ' ' && policko[2][2].getHrac() == 'O' && policko[2][0].getHrac() == ' ') {
                    policko[2][0].setHrac('O');
                } else if (policko[2][2].getHrac() == ' ' && policko[2][1].getHrac() == 'O' && policko[2][0].getHrac() == ' ') {
                    policko[2][0].setHrac('O');
                } else if (policko[2][0].getHrac() == ' ' && policko[2][2].getHrac() == 'O' && policko[2][1].getHrac() == ' ') {
                    policko[2][1].setHrac('O');
                } else if (policko[2][2].getHrac() == ' ' && policko[2][0].getHrac() == 'O' && policko[2][1].getHrac() == ' ') {
                    policko[2][1].setHrac('O');
                } else if (policko[2][0].getHrac() == ' ' && policko[2][1].getHrac() == 'O' && policko[2][2].getHrac() == ' ') {
                    policko[2][2].setHrac('O');
                } else if (policko[2][1].getHrac() == ' ' && policko[2][0].getHrac() == 'O' && policko[2][2].getHrac() == ' ') {
                    policko[2][2].setHrac('O');

                } else if (policko[1][1].getHrac() == ' ' && policko[0][2].getHrac() == 'O' && policko[2][0].getHrac() == ' ') {
                    policko[2][0].setHrac('O');
                } else if (policko[0][2].getHrac() == ' ' && policko[1][1].getHrac() == 'O' && policko[2][0].getHrac() == ' ') {
                    policko[2][0].setHrac('O');
                } else if (policko[2][0].getHrac() == ' ' && policko[0][2].getHrac() == 'O' && policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[0][2].getHrac() == ' ' && policko[2][0].getHrac() == 'O' && policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[2][0].getHrac() == ' ' && policko[1][1].getHrac() == 'O' && policko[0][2].getHrac() == ' ') {
                    policko[0][2].setHrac('O');
                } else if (policko[1][1].getHrac() == ' ' && policko[2][0].getHrac() == 'O' && policko[0][2].getHrac() == ' ') {
                    policko[0][2].setHrac('O');

                } else if (policko[1][1].getHrac() == ' ' && policko[0][0].getHrac() == 'O' && policko[2][2].getHrac() == ' ') {
                    policko[2][2].setHrac('O');
                } else if (policko[0][0].getHrac() == ' ' && policko[1][1].getHrac() == 'O' && policko[2][2].getHrac() == ' ') {
                    policko[2][2].setHrac('O');
                } else if (policko[2][2].getHrac() == ' ' && policko[0][0].getHrac() == 'O' && policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[0][0].getHrac() == ' ' && policko[2][2].getHrac() == 'O' && policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[2][2].getHrac() == ' ' && policko[1][1].getHrac() == 'O' && policko[0][0].getHrac() == ' ') {
                    policko[0][0].setHrac('O');
                } else if (policko[1][1].getHrac() == ' ' && policko[2][2].getHrac() == 'O' && policko[0][0].getHrac() == ' ') {
                    policko[0][0].setHrac('O');

                } else if (policko[0][0].getHrac() == ' ') {
                    policko[0][0].setHrac('O');
                } else if (policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[0][2].getHrac() == ' ') {
                    policko[0][2].setHrac('O');
                } else if (policko[2][1].getHrac() == ' ') {
                    policko[2][1].setHrac('O');
                } else if (policko[1][0].getHrac() == ' ') {
                    policko[1][0].setHrac('O');
                } else if (policko[1][2].getHrac() == ' ') {
                    policko[1][2].setHrac('O');
                } else if (policko[2][2].getHrac() == ' ') {
                    policko[2][2].setHrac('O');
                } else if (policko[2][0].getHrac() == ' ') {
                    policko[2][0].setHrac('O');
                }
            }
            
            compStav(policko3, compHardStav);
        });

        policko[0][2].setOnMouseClicked(e -> {
            if (policko[0][2].getHrac() == ' ' && compHardStav.getText() == " ") {
                policko[0][2].setHrac('X');

                if (policko[1][0].getHrac() == 'O' && policko[2][0].getHrac() == 'O' && policko[0][0].getHrac() == ' ') {
                    policko[0][0].setHrac('O');
                } else if (policko[2][0].getHrac() == 'O' && policko[1][0].getHrac() == 'O' && policko[0][0].getHrac() == ' ') {
                    policko[0][0].setHrac('O');
                } else if (policko[0][0].getHrac() == 'O' && policko[2][0].getHrac() == 'O' && policko[1][0].getHrac() == ' ') {
                    policko[1][0].setHrac('O');
                } else if (policko[2][0].getHrac() == 'O' && policko[0][0].getHrac() == 'O' && policko[1][0].getHrac() == ' ') {
                    policko[1][0].setHrac('O');
                } else if (policko[0][0].getHrac() == 'O' && policko[1][0].getHrac() == 'O' && policko[2][0].getHrac() == ' ') {
                    policko[2][0].setHrac('O');
                } else if (policko[1][0].getHrac() == 'O' && policko[0][0].getHrac() == 'O' && policko[2][0].getHrac() == ' ') {
                    policko[2][0].setHrac('O');

                } else if (policko[1][1].getHrac() == 'O' && policko[2][1].getHrac() == 'O' && policko[0][1].getHrac() == ' ') {
                    policko[0][1].setHrac('O');
                } else if (policko[2][1].getHrac() == 'O' && policko[1][1].getHrac() == 'O' && policko[0][1].getHrac() == ' ') {
                    policko[0][1].setHrac('O');
                } else if (policko[0][1].getHrac() == 'O' && policko[2][1].getHrac() == 'O' && policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[2][1].getHrac() == 'O' && policko[0][1].getHrac() == 'O' && policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[0][1].getHrac() == 'O' && policko[1][1].getHrac() == 'O' && policko[2][1].getHrac() == ' ') {
                    policko[2][1].setHrac('O');
                } else if (policko[1][1].getHrac() == 'O' && policko[0][1].getHrac() == 'O' && policko[2][1].getHrac() == ' ') {
                    policko[2][1].setHrac('O');

                } else if (policko[1][1].getHrac() == 'O' && policko[1][2].getHrac() == 'O' && policko[1][0].getHrac() == ' ') {
                    policko[1][0].setHrac('O');
                } else if (policko[1][2].getHrac() == 'O' && policko[1][1].getHrac() == 'O' && policko[1][0].getHrac() == ' ') {
                    policko[1][0].setHrac('O');
                } else if (policko[1][0].getHrac() == 'O' && policko[1][2].getHrac() == 'O' && policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[1][2].getHrac() == 'O' && policko[1][0].getHrac() == 'O' && policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[1][0].getHrac() == 'O' && policko[1][1].getHrac() == 'O' && policko[1][2].getHrac() == ' ') {
                    policko[1][2].setHrac('O');
                } else if (policko[1][1].getHrac() == 'O' && policko[1][0].getHrac() == 'O' && policko[1][2].getHrac() == ' ') {
                    policko[1][2].setHrac('O');

                } else if (policko[2][1].getHrac() == 'O' && policko[2][2].getHrac() == 'O' && policko[2][0].getHrac() == ' ') {
                    policko[2][0].setHrac('O');
                } else if (policko[2][2].getHrac() == 'O' && policko[2][1].getHrac() == 'O' && policko[2][0].getHrac() == ' ') {
                    policko[2][0].setHrac('O');
                } else if (policko[2][0].getHrac() == 'O' && policko[2][2].getHrac() == 'O' && policko[2][1].getHrac() == ' ') {
                    policko[2][1].setHrac('O');
                } else if (policko[2][2].getHrac() == 'O' && policko[2][0].getHrac() == 'O' && policko[2][1].getHrac() == ' ') {
                    policko[2][1].setHrac('O');
                } else if (policko[2][0].getHrac() == 'O' && policko[2][1].getHrac() == 'O' && policko[2][2].getHrac() == ' ') {
                    policko[2][2].setHrac('O');
                } else if (policko[2][1].getHrac() == 'O' && policko[2][0].getHrac() == 'O' && policko[2][2].getHrac() == ' ') {
                    policko[2][2].setHrac('O');

                } else if (policko[1][1].getHrac() == 'O' && policko[0][0].getHrac() == 'O' && policko[2][2].getHrac() == ' ') {
                    policko[2][2].setHrac('O');
                } else if (policko[0][0].getHrac() == 'O' && policko[1][1].getHrac() == 'O' && policko[2][2].getHrac() == ' ') {
                    policko[2][2].setHrac('O');
                } else if (policko[2][2].getHrac() == 'O' && policko[0][0].getHrac() == 'O' && policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[0][0].getHrac() == 'O' && policko[2][2].getHrac() == 'O' && policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[2][2].getHrac() == 'O' && policko[1][1].getHrac() == 'O' && policko[0][0].getHrac() == ' ') {
                    policko[0][0].setHrac('O');
                } else if (policko[1][1].getHrac() == 'O' && policko[2][2].getHrac() == 'O' && policko[0][0].getHrac() == ' ') {
                    policko[0][0].setHrac('O');

                } else if (policko[0][1].getHrac() == 'X' && policko[0][0].getHrac() == ' ') {
                    policko[0][0].setHrac('O');
                } else if (policko[1][2].getHrac() == 'X' && policko[2][2].getHrac() == ' ') {
                    policko[2][2].setHrac('O');
                } else if (policko[1][1].getHrac() == 'X' && policko[2][0].getHrac() == ' ') {
                    policko[2][0].setHrac('O');
                } else if (policko[0][0].getHrac() == 'X' && policko[0][1].getHrac() == ' ') {
                    policko[0][1].setHrac('O');
                } else if (policko[2][2].getHrac() == 'X' && policko[1][2].getHrac() == ' ') {
                    policko[1][2].setHrac('O');
                } else if (policko[2][0].getHrac() == 'X' && policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');

                } else if (policko[1][0].getHrac() == ' ' && policko[2][0].getHrac() == 'O' && policko[0][0].getHrac() == ' ') {
                    policko[0][0].setHrac('O');
                } else if (policko[2][0].getHrac() == ' ' && policko[1][0].getHrac() == 'O' && policko[0][0].getHrac() == ' ') {
                    policko[0][0].setHrac('O');
                } else if (policko[0][0].getHrac() == ' ' && policko[2][0].getHrac() == 'O' && policko[1][0].getHrac() == ' ') {
                    policko[1][0].setHrac('O');
                } else if (policko[2][0].getHrac() == ' ' && policko[0][0].getHrac() == 'O' && policko[1][0].getHrac() == ' ') {
                    policko[1][0].setHrac('O');
                } else if (policko[0][0].getHrac() == ' ' && policko[1][0].getHrac() == 'O' && policko[2][0].getHrac() == ' ') {
                    policko[2][0].setHrac('O');
                } else if (policko[1][0].getHrac() == ' ' && policko[0][0].getHrac() == 'O' && policko[2][0].getHrac() == ' ') {
                    policko[2][0].setHrac('O');

                } else if (policko[1][1].getHrac() == ' ' && policko[2][1].getHrac() == 'O' && policko[0][1].getHrac() == ' ') {
                    policko[0][1].setHrac('O');
                } else if (policko[2][1].getHrac() == ' ' && policko[1][1].getHrac() == 'O' && policko[0][1].getHrac() == ' ') {
                    policko[0][1].setHrac('O');
                } else if (policko[0][1].getHrac() == ' ' && policko[2][1].getHrac() == 'O' && policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[2][1].getHrac() == ' ' && policko[0][1].getHrac() == 'O' && policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[0][1].getHrac() == ' ' && policko[1][1].getHrac() == 'O' && policko[2][1].getHrac() == ' ') {
                    policko[2][1].setHrac('O');
                } else if (policko[1][1].getHrac() == ' ' && policko[0][1].getHrac() == 'O' && policko[2][1].getHrac() == ' ') {
                    policko[2][1].setHrac('O');

                } else if (policko[1][1].getHrac() == ' ' && policko[1][2].getHrac() == 'O' && policko[1][0].getHrac() == ' ') {
                    policko[1][0].setHrac('O');
                } else if (policko[1][2].getHrac() == ' ' && policko[1][1].getHrac() == 'O' && policko[1][0].getHrac() == ' ') {
                    policko[1][0].setHrac('O');
                } else if (policko[1][0].getHrac() == ' ' && policko[1][2].getHrac() == 'O' && policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[1][2].getHrac() == ' ' && policko[1][0].getHrac() == 'O' && policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[1][0].getHrac() == ' ' && policko[1][1].getHrac() == 'O' && policko[1][2].getHrac() == ' ') {
                    policko[1][2].setHrac('O');
                } else if (policko[1][1].getHrac() == ' ' && policko[1][0].getHrac() == 'O' && policko[1][2].getHrac() == ' ') {
                    policko[1][2].setHrac('O');

                } else if (policko[2][1].getHrac() == ' ' && policko[2][2].getHrac() == 'O' && policko[2][0].getHrac() == ' ') {
                    policko[2][0].setHrac('O');
                } else if (policko[2][2].getHrac() == ' ' && policko[2][1].getHrac() == 'O' && policko[2][0].getHrac() == ' ') {
                    policko[2][0].setHrac('O');
                } else if (policko[2][0].getHrac() == ' ' && policko[2][2].getHrac() == 'O' && policko[2][1].getHrac() == ' ') {
                    policko[2][1].setHrac('O');
                } else if (policko[2][2].getHrac() == ' ' && policko[2][0].getHrac() == 'O' && policko[2][1].getHrac() == ' ') {
                    policko[2][1].setHrac('O');
                } else if (policko[2][0].getHrac() == ' ' && policko[2][1].getHrac() == 'O' && policko[2][2].getHrac() == ' ') {
                    policko[2][2].setHrac('O');
                } else if (policko[2][1].getHrac() == ' ' && policko[2][0].getHrac() == 'O' && policko[2][2].getHrac() == ' ') {
                    policko[2][2].setHrac('O');

                } else if (policko[1][1].getHrac() == ' ' && policko[0][0].getHrac() == 'O' && policko[2][2].getHrac() == ' ') {
                    policko[2][2].setHrac('O');
                } else if (policko[0][0].getHrac() == ' ' && policko[1][1].getHrac() == 'O' && policko[2][2].getHrac() == ' ') {
                    policko[2][2].setHrac('O');
                } else if (policko[2][2].getHrac() == ' ' && policko[0][0].getHrac() == 'O' && policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[0][0].getHrac() == ' ' && policko[2][2].getHrac() == 'O' && policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[2][2].getHrac() == ' ' && policko[1][1].getHrac() == 'O' && policko[0][0].getHrac() == ' ') {
                    policko[0][0].setHrac('O');
                } else if (policko[1][1].getHrac() == ' ' && policko[2][2].getHrac() == 'O' && policko[0][0].getHrac() == ' ') {
                    policko[0][0].setHrac('O');

                } else if (policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[0][1].getHrac() == ' ') {
                    policko[0][1].setHrac('O');
                } else if (policko[1][2].getHrac() == ' ') {
                    policko[1][2].setHrac('O');
                } else if (policko[0][0].getHrac() == ' ') {
                    policko[0][0].setHrac('O');
                } else if (policko[2][2].getHrac() == ' ') {
                    policko[2][2].setHrac('O');
                } else if (policko[2][0].getHrac() == ' ') {
                    policko[2][0].setHrac('O');
                } else if (policko[1][0].getHrac() == ' ') {
                    policko[1][0].setHrac('O');
                } else if (policko[2][1].getHrac() == ' ') {
                    policko[2][1].setHrac('O');
                }
            }
            
            compStav(policko3, compHardStav);
        });

        policko[1][0].setOnMouseClicked(e -> {
            if (policko[1][0].getHrac() == ' ' && compHardStav.getText() == " ") {
                policko[1][0].setHrac('X');

                if (policko[0][1].getHrac() == 'O' && policko[0][2].getHrac() == 'O' && policko[0][0].getHrac() == ' ') {
                    policko[0][0].setHrac('O');
                } else if (policko[0][2].getHrac() == 'O' && policko[0][1].getHrac() == 'O' && policko[0][0].getHrac() == ' ') {
                    policko[0][0].setHrac('O');
                } else if (policko[0][0].getHrac() == 'O' && policko[0][2].getHrac() == 'O' && policko[0][1].getHrac() == ' ') {
                    policko[0][1].setHrac('O');
                } else if (policko[0][2].getHrac() == 'O' && policko[0][0].getHrac() == 'O' && policko[0][1].getHrac() == ' ') {
                    policko[0][1].setHrac('O');
                } else if (policko[0][0].getHrac() == 'O' && policko[0][1].getHrac() == 'O' && policko[0][2].getHrac() == ' ') {
                    policko[0][2].setHrac('O');
                } else if (policko[0][1].getHrac() == 'O' && policko[0][0].getHrac() == 'O' && policko[0][2].getHrac() == ' ') {
                    policko[0][2].setHrac('O');

                } else if (policko[1][1].getHrac() == 'O' && policko[2][1].getHrac() == 'O' && policko[0][1].getHrac() == ' ') {
                    policko[0][1].setHrac('O');
                } else if (policko[2][1].getHrac() == 'O' && policko[1][1].getHrac() == 'O' && policko[0][1].getHrac() == ' ') {
                    policko[0][1].setHrac('O');
                } else if (policko[0][1].getHrac() == 'O' && policko[2][1].getHrac() == 'O' && policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[2][1].getHrac() == 'O' && policko[0][1].getHrac() == 'O' && policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[0][1].getHrac() == 'O' && policko[1][1].getHrac() == 'O' && policko[2][1].getHrac() == ' ') {
                    policko[2][1].setHrac('O');
                } else if (policko[1][1].getHrac() == 'O' && policko[0][1].getHrac() == 'O' && policko[2][1].getHrac() == ' ') {
                    policko[2][1].setHrac('O');

                } else if (policko[1][2].getHrac() == 'O' && policko[2][2].getHrac() == 'O' && policko[0][2].getHrac() == ' ') {
                    policko[0][2].setHrac('O');
                } else if (policko[2][2].getHrac() == 'O' && policko[1][2].getHrac() == 'O' && policko[0][2].getHrac() == ' ') {
                    policko[0][2].setHrac('O');
                } else if (policko[0][2].getHrac() == 'O' && policko[2][2].getHrac() == 'O' && policko[1][2].getHrac() == ' ') {
                    policko[1][2].setHrac('O');
                } else if (policko[2][2].getHrac() == 'O' && policko[0][2].getHrac() == 'O' && policko[1][2].getHrac() == ' ') {
                    policko[1][2].setHrac('O');
                } else if (policko[0][2].getHrac() == 'O' && policko[1][2].getHrac() == 'O' && policko[2][2].getHrac() == ' ') {
                    policko[2][2].setHrac('O');
                } else if (policko[1][2].getHrac() == 'O' && policko[0][2].getHrac() == 'O' && policko[2][2].getHrac() == ' ') {
                    policko[2][2].setHrac('O');

                } else if (policko[2][1].getHrac() == 'O' && policko[2][2].getHrac() == 'O' && policko[2][0].getHrac() == ' ') {
                    policko[2][0].setHrac('O');
                } else if (policko[2][2].getHrac() == 'O' && policko[2][1].getHrac() == 'O' && policko[2][0].getHrac() == ' ') {
                    policko[2][0].setHrac('O');
                } else if (policko[2][0].getHrac() == 'O' && policko[2][2].getHrac() == 'O' && policko[2][1].getHrac() == ' ') {
                    policko[2][1].setHrac('O');
                } else if (policko[2][2].getHrac() == 'O' && policko[2][0].getHrac() == 'O' && policko[2][1].getHrac() == ' ') {
                    policko[2][1].setHrac('O');
                } else if (policko[2][0].getHrac() == 'O' && policko[2][1].getHrac() == 'O' && policko[2][2].getHrac() == ' ') {
                    policko[2][2].setHrac('O');
                } else if (policko[2][1].getHrac() == 'O' && policko[2][0].getHrac() == 'O' && policko[2][2].getHrac() == ' ') {
                    policko[2][2].setHrac('O');

                } else if (policko[1][1].getHrac() == 'O' && policko[0][2].getHrac() == 'O' && policko[2][0].getHrac() == ' ') {
                    policko[2][0].setHrac('O');
                } else if (policko[0][2].getHrac() == 'O' && policko[1][1].getHrac() == 'O' && policko[2][0].getHrac() == ' ') {
                    policko[2][0].setHrac('O');
                } else if (policko[2][0].getHrac() == 'O' && policko[0][2].getHrac() == 'O' && policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[0][2].getHrac() == 'O' && policko[2][0].getHrac() == 'O' && policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[2][0].getHrac() == 'O' && policko[1][1].getHrac() == 'O' && policko[0][2].getHrac() == ' ') {
                    policko[0][2].setHrac('O');
                } else if (policko[1][1].getHrac() == 'O' && policko[2][0].getHrac() == 'O' && policko[0][2].getHrac() == ' ') {
                    policko[0][2].setHrac('O');

                } else if (policko[1][1].getHrac() == 'O' && policko[0][0].getHrac() == 'O' && policko[2][2].getHrac() == ' ') {
                    policko[2][2].setHrac('O');
                } else if (policko[0][0].getHrac() == 'O' && policko[1][1].getHrac() == 'O' && policko[2][2].getHrac() == ' ') {
                    policko[2][2].setHrac('O');
                } else if (policko[2][2].getHrac() == 'O' && policko[0][0].getHrac() == 'O' && policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[0][0].getHrac() == 'O' && policko[2][2].getHrac() == 'O' && policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[2][2].getHrac() == 'O' && policko[1][1].getHrac() == 'O' && policko[0][0].getHrac() == ' ') {
                    policko[0][0].setHrac('O');
                } else if (policko[1][1].getHrac() == 'O' && policko[2][2].getHrac() == 'O' && policko[0][0].getHrac() == ' ') {
                    policko[0][0].setHrac('O');

                } else if (policko[0][0].getHrac() == 'X' && policko[2][0].getHrac() == ' ') {
                    policko[2][0].setHrac('O');
                } else if (policko[2][0].getHrac() == 'X' && policko[0][0].getHrac() == ' ') {
                    policko[0][0].setHrac('O');
                } else if (policko[1][1].getHrac() == 'X' && policko[1][2].getHrac() == ' ') {
                    policko[1][2].setHrac('O');
                } else if (policko[1][2].getHrac() == 'X' && policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');

                } else if (policko[0][1].getHrac() == ' ' && policko[0][2].getHrac() == 'O' && policko[0][0].getHrac() == ' ') {
                    policko[0][0].setHrac('O');
                } else if (policko[0][2].getHrac() == ' ' && policko[0][1].getHrac() == 'O' && policko[0][0].getHrac() == ' ') {
                    policko[0][0].setHrac('O');
                } else if (policko[0][0].getHrac() == ' ' && policko[0][2].getHrac() == 'O' && policko[0][1].getHrac() == ' ') {
                    policko[0][1].setHrac('O');
                } else if (policko[0][2].getHrac() == ' ' && policko[0][0].getHrac() == 'O' && policko[0][1].getHrac() == ' ') {
                    policko[0][1].setHrac('O');
                } else if (policko[0][0].getHrac() == ' ' && policko[0][1].getHrac() == 'O' && policko[0][2].getHrac() == ' ') {
                    policko[0][2].setHrac('O');
                } else if (policko[0][1].getHrac() == ' ' && policko[0][0].getHrac() == 'O' && policko[0][2].getHrac() == ' ') {
                    policko[0][2].setHrac('O');

                } else if (policko[1][1].getHrac() == ' ' && policko[2][1].getHrac() == 'O' && policko[0][1].getHrac() == ' ') {
                    policko[0][1].setHrac('O');
                } else if (policko[2][1].getHrac() == ' ' && policko[1][1].getHrac() == 'O' && policko[0][1].getHrac() == ' ') {
                    policko[0][1].setHrac('O');
                } else if (policko[0][1].getHrac() == ' ' && policko[2][1].getHrac() == 'O' && policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[2][1].getHrac() == ' ' && policko[0][1].getHrac() == 'O' && policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[0][1].getHrac() == ' ' && policko[1][1].getHrac() == 'O' && policko[2][1].getHrac() == ' ') {
                    policko[2][1].setHrac('O');
                } else if (policko[1][1].getHrac() == ' ' && policko[0][1].getHrac() == 'O' && policko[2][1].getHrac() == ' ') {
                    policko[2][1].setHrac('O');

                } else if (policko[1][2].getHrac() == ' ' && policko[2][2].getHrac() == 'O' && policko[0][2].getHrac() == ' ') {
                    policko[0][2].setHrac('O');
                } else if (policko[2][2].getHrac() == ' ' && policko[1][2].getHrac() == 'O' && policko[0][2].getHrac() == ' ') {
                    policko[0][2].setHrac('O');
                } else if (policko[0][2].getHrac() == ' ' && policko[2][2].getHrac() == 'O' && policko[1][2].getHrac() == ' ') {
                    policko[1][2].setHrac('O');
                } else if (policko[2][2].getHrac() == ' ' && policko[0][2].getHrac() == 'O' && policko[1][2].getHrac() == ' ') {
                    policko[1][2].setHrac('O');
                } else if (policko[0][2].getHrac() == ' ' && policko[1][2].getHrac() == 'O' && policko[2][2].getHrac() == ' ') {
                    policko[2][2].setHrac('O');
                } else if (policko[1][2].getHrac() == ' ' && policko[0][2].getHrac() == 'O' && policko[2][2].getHrac() == ' ') {
                    policko[2][2].setHrac('O');

                } else if (policko[2][1].getHrac() == ' ' && policko[2][2].getHrac() == 'O' && policko[2][0].getHrac() == ' ') {
                    policko[2][0].setHrac('O');
                } else if (policko[2][2].getHrac() == ' ' && policko[2][1].getHrac() == 'O' && policko[2][0].getHrac() == ' ') {
                    policko[2][0].setHrac('O');
                } else if (policko[2][0].getHrac() == ' ' && policko[2][2].getHrac() == 'O' && policko[2][1].getHrac() == ' ') {
                    policko[2][1].setHrac('O');
                } else if (policko[2][2].getHrac() == ' ' && policko[2][0].getHrac() == 'O' && policko[2][1].getHrac() == ' ') {
                    policko[2][1].setHrac('O');
                } else if (policko[2][0].getHrac() == ' ' && policko[2][1].getHrac() == 'O' && policko[2][2].getHrac() == ' ') {
                    policko[2][2].setHrac('O');
                } else if (policko[2][1].getHrac() == ' ' && policko[2][0].getHrac() == 'O' && policko[2][2].getHrac() == ' ') {
                    policko[2][2].setHrac('O');

                } else if (policko[1][1].getHrac() == ' ' && policko[0][2].getHrac() == 'O' && policko[2][0].getHrac() == ' ') {
                    policko[2][0].setHrac('O');
                } else if (policko[0][2].getHrac() == ' ' && policko[1][1].getHrac() == 'O' && policko[2][0].getHrac() == ' ') {
                    policko[2][0].setHrac('O');
                } else if (policko[2][0].getHrac() == ' ' && policko[0][2].getHrac() == 'O' && policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[0][2].getHrac() == ' ' && policko[2][0].getHrac() == 'O' && policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[2][0].getHrac() == ' ' && policko[1][1].getHrac() == 'O' && policko[0][2].getHrac() == ' ') {
                    policko[0][2].setHrac('O');
                } else if (policko[1][1].getHrac() == ' ' && policko[2][0].getHrac() == 'O' && policko[0][2].getHrac() == ' ') {
                    policko[0][2].setHrac('O');

                } else if (policko[1][1].getHrac() == ' ' && policko[0][0].getHrac() == 'O' && policko[2][2].getHrac() == ' ') {
                    policko[2][2].setHrac('O');
                } else if (policko[0][0].getHrac() == ' ' && policko[1][1].getHrac() == 'O' && policko[2][2].getHrac() == ' ') {
                    policko[2][2].setHrac('O');
                } else if (policko[2][2].getHrac() == ' ' && policko[0][0].getHrac() == 'O' && policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[0][0].getHrac() == ' ' && policko[2][2].getHrac() == 'O' && policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[2][2].getHrac() == ' ' && policko[1][1].getHrac() == 'O' && policko[0][0].getHrac() == ' ') {
                    policko[0][0].setHrac('O');
                } else if (policko[1][1].getHrac() == ' ' && policko[2][2].getHrac() == 'O' && policko[0][0].getHrac() == ' ') {
                    policko[0][0].setHrac('O');

                } else if (policko[0][0].getHrac() == ' ') {
                    policko[0][0].setHrac('O');
                } else if (policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[2][0].getHrac() == ' ') {
                    policko[2][0].setHrac('O');
                } else if (policko[1][2].getHrac() == ' ') {
                    policko[1][2].setHrac('O');
                } else if (policko[0][1].getHrac() == ' ') {
                    policko[0][1].setHrac('O');
                } else if (policko[2][1].getHrac() == ' ') {
                    policko[2][1].setHrac('O');
                } else if (policko[2][2].getHrac() == ' ') {
                    policko[2][2].setHrac('O');
                } else if (policko[0][2].getHrac() == ' ') {
                    policko[0][2].setHrac('O');
                }
            }
            
            compStav(policko3, compHardStav);
        });

        policko[1][1].setOnMouseClicked(e -> {
            if (policko[1][1].getHrac() == ' ' && compHardStav.getText() == " ") {
                policko[1][1].setHrac('X');

                if (policko[1][0].getHrac() == 'O' && policko[2][0].getHrac() == 'O' && policko[0][0].getHrac() == ' ') {
                    policko[0][0].setHrac('O');
                } else if (policko[2][0].getHrac() == 'O' && policko[1][0].getHrac() == 'O' && policko[0][0].getHrac() == ' ') {
                    policko[0][0].setHrac('O');
                } else if (policko[0][0].getHrac() == 'O' && policko[2][0].getHrac() == 'O' && policko[1][0].getHrac() == ' ') {
                    policko[1][0].setHrac('O');
                } else if (policko[2][0].getHrac() == 'O' && policko[0][0].getHrac() == 'O' && policko[1][0].getHrac() == ' ') {
                    policko[1][0].setHrac('O');
                } else if (policko[0][0].getHrac() == 'O' && policko[1][0].getHrac() == 'O' && policko[2][0].getHrac() == ' ') {
                    policko[2][0].setHrac('O');
                } else if (policko[1][0].getHrac() == 'O' && policko[0][0].getHrac() == 'O' && policko[2][0].getHrac() == ' ') {
                    policko[2][0].setHrac('O');

                } else if (policko[0][1].getHrac() == 'O' && policko[0][2].getHrac() == 'O' && policko[0][0].getHrac() == ' ') {
                    policko[0][0].setHrac('O');
                } else if (policko[0][2].getHrac() == 'O' && policko[0][1].getHrac() == 'O' && policko[0][0].getHrac() == ' ') {
                    policko[0][0].setHrac('O');
                } else if (policko[0][0].getHrac() == 'O' && policko[0][2].getHrac() == 'O' && policko[0][1].getHrac() == ' ') {
                    policko[0][1].setHrac('O');
                } else if (policko[0][2].getHrac() == 'O' && policko[0][0].getHrac() == 'O' && policko[0][1].getHrac() == ' ') {
                    policko[0][1].setHrac('O');
                } else if (policko[0][0].getHrac() == 'O' && policko[0][1].getHrac() == 'O' && policko[0][2].getHrac() == ' ') {
                    policko[0][2].setHrac('O');
                } else if (policko[0][1].getHrac() == 'O' && policko[0][0].getHrac() == 'O' && policko[0][2].getHrac() == ' ') {
                    policko[0][2].setHrac('O');

                } else if (policko[1][2].getHrac() == 'O' && policko[2][2].getHrac() == 'O' && policko[0][2].getHrac() == ' ') {
                    policko[0][2].setHrac('O');
                } else if (policko[2][2].getHrac() == 'O' && policko[1][2].getHrac() == 'O' && policko[0][2].getHrac() == ' ') {
                    policko[0][2].setHrac('O');
                } else if (policko[0][2].getHrac() == 'O' && policko[2][2].getHrac() == 'O' && policko[1][2].getHrac() == ' ') {
                    policko[1][2].setHrac('O');
                } else if (policko[2][2].getHrac() == 'O' && policko[0][2].getHrac() == 'O' && policko[1][2].getHrac() == ' ') {
                    policko[1][2].setHrac('O');
                } else if (policko[0][2].getHrac() == 'O' && policko[1][2].getHrac() == 'O' && policko[2][2].getHrac() == ' ') {
                    policko[2][2].setHrac('O');
                } else if (policko[1][2].getHrac() == 'O' && policko[0][2].getHrac() == 'O' && policko[2][2].getHrac() == ' ') {
                    policko[2][2].setHrac('O');

                } else if (policko[2][1].getHrac() == 'O' && policko[2][2].getHrac() == 'O' && policko[2][0].getHrac() == ' ') {
                    policko[2][0].setHrac('O');
                } else if (policko[2][2].getHrac() == 'O' && policko[2][1].getHrac() == 'O' && policko[2][0].getHrac() == ' ') {
                    policko[2][0].setHrac('O');
                } else if (policko[2][0].getHrac() == 'O' && policko[2][2].getHrac() == 'O' && policko[2][1].getHrac() == ' ') {
                    policko[2][1].setHrac('O');
                } else if (policko[2][2].getHrac() == 'O' && policko[2][0].getHrac() == 'O' && policko[2][1].getHrac() == ' ') {
                    policko[2][1].setHrac('O');
                } else if (policko[2][0].getHrac() == 'O' && policko[2][1].getHrac() == 'O' && policko[2][2].getHrac() == ' ') {
                    policko[2][2].setHrac('O');
                } else if (policko[2][1].getHrac() == 'O' && policko[2][0].getHrac() == 'O' && policko[2][2].getHrac() == ' ') {
                    policko[2][2].setHrac('O');

                } else if (policko[0][1].getHrac() == 'X' && policko[2][1].getHrac() == ' ') {
                    policko[2][1].setHrac('O');
                } else if (policko[2][1].getHrac() == 'X' && policko[0][1].getHrac() == ' ') {
                    policko[0][1].setHrac('O');
                } else if (policko[1][0].getHrac() == 'X' && policko[1][2].getHrac() == ' ') {
                    policko[1][2].setHrac('O');
                } else if (policko[1][2].getHrac() == 'X' && policko[1][0].getHrac() == ' ') {
                    policko[1][0].setHrac('O');
                } else if (policko[2][0].getHrac() == 'X' && policko[0][2].getHrac() == ' ') {
                    policko[0][2].setHrac('O');
                } else if (policko[0][2].getHrac() == 'X' && policko[2][0].getHrac() == ' ') {
                    policko[2][0].setHrac('O');
                } else if (policko[0][0].getHrac() == 'X' && policko[2][2].getHrac() == ' ') {
                    policko[2][2].setHrac('O');
                } else if (policko[2][2].getHrac() == 'X' && policko[0][0].getHrac() == ' ') {
                    policko[0][0].setHrac('O');

                } else if (policko[1][0].getHrac() == ' ' && policko[2][0].getHrac() == 'O' && policko[0][0].getHrac() == ' ') {
                    policko[0][0].setHrac('O');
                } else if (policko[2][0].getHrac() == ' ' && policko[1][0].getHrac() == 'O' && policko[0][0].getHrac() == ' ') {
                    policko[0][0].setHrac('O');
                } else if (policko[0][0].getHrac() == ' ' && policko[2][0].getHrac() == 'O' && policko[1][0].getHrac() == ' ') {
                    policko[1][0].setHrac('O');
                } else if (policko[2][0].getHrac() == ' ' && policko[0][0].getHrac() == 'O' && policko[1][0].getHrac() == ' ') {
                    policko[1][0].setHrac('O');
                } else if (policko[0][0].getHrac() == ' ' && policko[1][0].getHrac() == 'O' && policko[2][0].getHrac() == ' ') {
                    policko[2][0].setHrac('O');
                } else if (policko[1][0].getHrac() == ' ' && policko[0][0].getHrac() == 'O' && policko[2][0].getHrac() == ' ') {
                    policko[2][0].setHrac('O');

                } else if (policko[0][1].getHrac() == ' ' && policko[0][2].getHrac() == 'O' && policko[0][0].getHrac() == ' ') {
                    policko[0][0].setHrac('O');
                } else if (policko[0][2].getHrac() == ' ' && policko[0][1].getHrac() == 'O' && policko[0][0].getHrac() == ' ') {
                    policko[0][0].setHrac('O');
                } else if (policko[0][0].getHrac() == ' ' && policko[0][2].getHrac() == 'O' && policko[0][1].getHrac() == ' ') {
                    policko[0][1].setHrac('O');
                } else if (policko[0][2].getHrac() == ' ' && policko[0][0].getHrac() == 'O' && policko[0][1].getHrac() == ' ') {
                    policko[0][1].setHrac('O');
                } else if (policko[0][0].getHrac() == ' ' && policko[0][1].getHrac() == 'O' && policko[0][2].getHrac() == ' ') {
                    policko[0][2].setHrac('O');
                } else if (policko[0][1].getHrac() == ' ' && policko[0][0].getHrac() == 'O' && policko[0][2].getHrac() == ' ') {
                    policko[0][2].setHrac('O');

                } else if (policko[1][2].getHrac() == ' ' && policko[2][2].getHrac() == 'O' && policko[0][2].getHrac() == ' ') {
                    policko[0][2].setHrac('O');
                } else if (policko[2][2].getHrac() == ' ' && policko[1][2].getHrac() == 'O' && policko[0][2].getHrac() == ' ') {
                    policko[0][2].setHrac('O');
                } else if (policko[0][2].getHrac() == ' ' && policko[2][2].getHrac() == 'O' && policko[1][2].getHrac() == ' ') {
                    policko[1][2].setHrac('O');
                } else if (policko[2][2].getHrac() == ' ' && policko[0][2].getHrac() == 'O' && policko[1][2].getHrac() == ' ') {
                    policko[1][2].setHrac('O');
                } else if (policko[0][2].getHrac() == ' ' && policko[1][2].getHrac() == 'O' && policko[2][2].getHrac() == ' ') {
                    policko[2][2].setHrac('O');
                } else if (policko[1][2].getHrac() == ' ' && policko[0][2].getHrac() == 'O' && policko[2][2].getHrac() == ' ') {
                    policko[2][2].setHrac('O');

                } else if (policko[2][1].getHrac() == ' ' && policko[2][2].getHrac() == 'O' && policko[2][0].getHrac() == ' ') {
                    policko[2][0].setHrac('O');
                } else if (policko[2][2].getHrac() == ' ' && policko[2][1].getHrac() == 'O' && policko[2][0].getHrac() == ' ') {
                    policko[2][0].setHrac('O');
                } else if (policko[2][0].getHrac() == ' ' && policko[2][2].getHrac() == 'O' && policko[2][1].getHrac() == ' ') {
                    policko[2][1].setHrac('O');
                } else if (policko[2][2].getHrac() == ' ' && policko[2][0].getHrac() == 'O' && policko[2][1].getHrac() == ' ') {
                    policko[2][1].setHrac('O');
                } else if (policko[2][0].getHrac() == ' ' && policko[2][1].getHrac() == 'O' && policko[2][2].getHrac() == ' ') {
                    policko[2][2].setHrac('O');
                } else if (policko[2][1].getHrac() == ' ' && policko[2][0].getHrac() == 'O' && policko[2][2].getHrac() == ' ') {
                    policko[2][2].setHrac('O');

                } else if (policko[2][2].getHrac() == ' ') {
                    policko[2][2].setHrac('O');
                } else if (policko[1][0].getHrac() == ' ') {
                    policko[1][0].setHrac('O');
                } else if (policko[1][2].getHrac() == ' ') {
                    policko[1][2].setHrac('O');
                } else if (policko[0][1].getHrac() == ' ') {
                    policko[0][1].setHrac('O');
                } else if (policko[2][1].getHrac() == ' ') {
                    policko[2][1].setHrac('O');
                } else if (policko[0][0].getHrac() == ' ') {
                    policko[0][0].setHrac('O');
                } else if (policko[2][0].getHrac() == ' ') {
                    policko[2][0].setHrac('O');
                } else if (policko[0][2].getHrac() == ' ') {
                    policko[0][2].setHrac('O');
                }
            }
            
            compStav(policko3, compHardStav);
        });

        policko[1][2].setOnMouseClicked(e -> {
            if (policko[1][2].getHrac() == ' ' && compHardStav.getText() == " ") {
                policko[1][2].setHrac('X');

                if (policko[1][0].getHrac() == 'O' && policko[2][0].getHrac() == 'O' && policko[0][0].getHrac() == ' ') {
                    policko[0][0].setHrac('O');
                } else if (policko[2][0].getHrac() == 'O' && policko[1][0].getHrac() == 'O' && policko[0][0].getHrac() == ' ') {
                    policko[0][0].setHrac('O');
                } else if (policko[0][0].getHrac() == 'O' && policko[2][0].getHrac() == 'O' && policko[1][0].getHrac() == ' ') {
                    policko[1][0].setHrac('O');
                } else if (policko[2][0].getHrac() == 'O' && policko[0][0].getHrac() == 'O' && policko[1][0].getHrac() == ' ') {
                    policko[1][0].setHrac('O');
                } else if (policko[0][0].getHrac() == 'O' && policko[1][0].getHrac() == 'O' && policko[2][0].getHrac() == ' ') {
                    policko[2][0].setHrac('O');
                } else if (policko[1][0].getHrac() == 'O' && policko[0][0].getHrac() == 'O' && policko[2][0].getHrac() == ' ') {
                    policko[2][0].setHrac('O');

                } else if (policko[0][1].getHrac() == 'O' && policko[0][2].getHrac() == 'O' && policko[0][0].getHrac() == ' ') {
                    policko[0][0].setHrac('O');
                } else if (policko[0][2].getHrac() == 'O' && policko[0][1].getHrac() == 'O' && policko[0][0].getHrac() == ' ') {
                    policko[0][0].setHrac('O');
                } else if (policko[0][0].getHrac() == 'O' && policko[0][2].getHrac() == 'O' && policko[0][1].getHrac() == ' ') {
                    policko[0][1].setHrac('O');
                } else if (policko[0][2].getHrac() == 'O' && policko[0][0].getHrac() == 'O' && policko[0][1].getHrac() == ' ') {
                    policko[0][1].setHrac('O');
                } else if (policko[0][0].getHrac() == 'O' && policko[0][1].getHrac() == 'O' && policko[0][2].getHrac() == ' ') {
                    policko[0][2].setHrac('O');
                } else if (policko[0][1].getHrac() == 'O' && policko[0][0].getHrac() == 'O' && policko[0][2].getHrac() == ' ') {
                    policko[0][2].setHrac('O');

                } else if (policko[1][1].getHrac() == 'O' && policko[2][1].getHrac() == 'O' && policko[0][1].getHrac() == ' ') {
                    policko[0][1].setHrac('O');
                } else if (policko[2][1].getHrac() == 'O' && policko[1][1].getHrac() == 'O' && policko[0][1].getHrac() == ' ') {
                    policko[0][1].setHrac('O');
                } else if (policko[0][1].getHrac() == 'O' && policko[2][1].getHrac() == 'O' && policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[2][1].getHrac() == 'O' && policko[0][1].getHrac() == 'O' && policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[0][1].getHrac() == 'O' && policko[1][1].getHrac() == 'O' && policko[2][1].getHrac() == ' ') {
                    policko[2][1].setHrac('O');
                } else if (policko[1][1].getHrac() == 'O' && policko[0][1].getHrac() == 'O' && policko[2][1].getHrac() == ' ') {
                    policko[2][1].setHrac('O');

                } else if (policko[2][1].getHrac() == 'O' && policko[2][2].getHrac() == 'O' && policko[2][0].getHrac() == ' ') {
                    policko[2][0].setHrac('O');
                } else if (policko[2][2].getHrac() == 'O' && policko[2][1].getHrac() == 'O' && policko[2][0].getHrac() == ' ') {
                    policko[2][0].setHrac('O');
                } else if (policko[2][0].getHrac() == 'O' && policko[2][2].getHrac() == 'O' && policko[2][1].getHrac() == ' ') {
                    policko[2][1].setHrac('O');
                } else if (policko[2][2].getHrac() == 'O' && policko[2][0].getHrac() == 'O' && policko[2][1].getHrac() == ' ') {
                    policko[2][1].setHrac('O');
                } else if (policko[2][0].getHrac() == 'O' && policko[2][1].getHrac() == 'O' && policko[2][2].getHrac() == ' ') {
                    policko[2][2].setHrac('O');
                } else if (policko[2][1].getHrac() == 'O' && policko[2][0].getHrac() == 'O' && policko[2][2].getHrac() == ' ') {
                    policko[2][2].setHrac('O');

                } else if (policko[1][1].getHrac() == 'O' && policko[0][2].getHrac() == 'O' && policko[2][0].getHrac() == ' ') {
                    policko[2][0].setHrac('O');
                } else if (policko[0][2].getHrac() == 'O' && policko[1][1].getHrac() == 'O' && policko[2][0].getHrac() == ' ') {
                    policko[2][0].setHrac('O');
                } else if (policko[2][0].getHrac() == 'O' && policko[0][2].getHrac() == 'O' && policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[0][2].getHrac() == 'O' && policko[2][0].getHrac() == 'O' && policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[2][0].getHrac() == 'O' && policko[1][1].getHrac() == 'O' && policko[0][2].getHrac() == ' ') {
                    policko[0][2].setHrac('O');
                } else if (policko[1][1].getHrac() == 'O' && policko[2][0].getHrac() == 'O' && policko[0][2].getHrac() == ' ') {
                    policko[0][2].setHrac('O');

                } else if (policko[1][1].getHrac() == 'O' && policko[0][0].getHrac() == 'O' && policko[2][2].getHrac() == ' ') {
                    policko[2][2].setHrac('O');
                } else if (policko[0][0].getHrac() == 'O' && policko[1][1].getHrac() == 'O' && policko[2][2].getHrac() == ' ') {
                    policko[2][2].setHrac('O');
                } else if (policko[2][2].getHrac() == 'O' && policko[0][0].getHrac() == 'O' && policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[0][0].getHrac() == 'O' && policko[2][2].getHrac() == 'O' && policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[2][2].getHrac() == 'O' && policko[1][1].getHrac() == 'O' && policko[0][0].getHrac() == ' ') {
                    policko[0][0].setHrac('O');
                } else if (policko[1][1].getHrac() == 'O' && policko[2][2].getHrac() == 'O' && policko[0][0].getHrac() == ' ') {
                    policko[0][0].setHrac('O');

                } else if (policko[0][2].getHrac() == 'X' && policko[2][2].getHrac() == ' ') {
                    policko[2][2].setHrac('O');
                } else if (policko[2][2].getHrac() == 'X' && policko[0][2].getHrac() == ' ') {
                    policko[0][2].setHrac('O');
                } else if (policko[1][1].getHrac() == 'X' && policko[1][0].getHrac() == ' ') {
                    policko[1][0].setHrac('O');
                } else if (policko[1][0].getHrac() == 'X' && policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');

                } else if (policko[1][0].getHrac() == ' ' && policko[2][0].getHrac() == 'O' && policko[0][0].getHrac() == ' ') {
                    policko[0][0].setHrac('O');
                } else if (policko[2][0].getHrac() == ' ' && policko[1][0].getHrac() == 'O' && policko[0][0].getHrac() == ' ') {
                    policko[0][0].setHrac('O');
                } else if (policko[0][0].getHrac() == ' ' && policko[2][0].getHrac() == 'O' && policko[1][0].getHrac() == ' ') {
                    policko[1][0].setHrac('O');
                } else if (policko[2][0].getHrac() == ' ' && policko[0][0].getHrac() == 'O' && policko[1][0].getHrac() == ' ') {
                    policko[1][0].setHrac('O');
                } else if (policko[0][0].getHrac() == ' ' && policko[1][0].getHrac() == 'O' && policko[2][0].getHrac() == ' ') {
                    policko[2][0].setHrac('O');
                } else if (policko[1][0].getHrac() == ' ' && policko[0][0].getHrac() == 'O' && policko[2][0].getHrac() == ' ') {
                    policko[2][0].setHrac('O');

                } else if (policko[0][1].getHrac() == ' ' && policko[0][2].getHrac() == 'O' && policko[0][0].getHrac() == ' ') {
                    policko[0][0].setHrac('O');
                } else if (policko[0][2].getHrac() == ' ' && policko[0][1].getHrac() == 'O' && policko[0][0].getHrac() == ' ') {
                    policko[0][0].setHrac('O');
                } else if (policko[0][0].getHrac() == ' ' && policko[0][2].getHrac() == 'O' && policko[0][1].getHrac() == ' ') {
                    policko[0][1].setHrac('O');
                } else if (policko[0][2].getHrac() == ' ' && policko[0][0].getHrac() == 'O' && policko[0][1].getHrac() == ' ') {
                    policko[0][1].setHrac('O');
                } else if (policko[0][0].getHrac() == ' ' && policko[0][1].getHrac() == 'O' && policko[0][2].getHrac() == ' ') {
                    policko[0][2].setHrac('O');
                } else if (policko[0][1].getHrac() == ' ' && policko[0][0].getHrac() == 'O' && policko[0][2].getHrac() == ' ') {
                    policko[0][2].setHrac('O');

                } else if (policko[1][1].getHrac() == ' ' && policko[2][1].getHrac() == 'O' && policko[0][1].getHrac() == ' ') {
                    policko[0][1].setHrac('O');
                } else if (policko[2][1].getHrac() == ' ' && policko[1][1].getHrac() == 'O' && policko[0][1].getHrac() == ' ') {
                    policko[0][1].setHrac('O');
                } else if (policko[0][1].getHrac() == ' ' && policko[2][1].getHrac() == 'O' && policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[2][1].getHrac() == ' ' && policko[0][1].getHrac() == 'O' && policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[0][1].getHrac() == ' ' && policko[1][1].getHrac() == 'O' && policko[2][1].getHrac() == ' ') {
                    policko[2][1].setHrac('O');
                } else if (policko[1][1].getHrac() == ' ' && policko[0][1].getHrac() == 'O' && policko[2][1].getHrac() == ' ') {
                    policko[2][1].setHrac('O');

                } else if (policko[2][1].getHrac() == ' ' && policko[2][2].getHrac() == 'O' && policko[2][0].getHrac() == ' ') {
                    policko[2][0].setHrac('O');
                } else if (policko[2][2].getHrac() == ' ' && policko[2][1].getHrac() == 'O' && policko[2][0].getHrac() == ' ') {
                    policko[2][0].setHrac('O');
                } else if (policko[2][0].getHrac() == ' ' && policko[2][2].getHrac() == 'O' && policko[2][1].getHrac() == ' ') {
                    policko[2][1].setHrac('O');
                } else if (policko[2][2].getHrac() == ' ' && policko[2][0].getHrac() == 'O' && policko[2][1].getHrac() == ' ') {
                    policko[2][1].setHrac('O');
                } else if (policko[2][0].getHrac() == ' ' && policko[2][1].getHrac() == 'O' && policko[2][2].getHrac() == ' ') {
                    policko[2][2].setHrac('O');
                } else if (policko[2][1].getHrac() == ' ' && policko[2][0].getHrac() == 'O' && policko[2][2].getHrac() == ' ') {
                    policko[2][2].setHrac('O');

                } else if (policko[1][1].getHrac() == ' ' && policko[0][2].getHrac() == 'O' && policko[2][0].getHrac() == ' ') {
                    policko[2][0].setHrac('O');
                } else if (policko[0][2].getHrac() == ' ' && policko[1][1].getHrac() == 'O' && policko[2][0].getHrac() == ' ') {
                    policko[2][0].setHrac('O');
                } else if (policko[2][0].getHrac() == ' ' && policko[0][2].getHrac() == 'O' && policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[0][2].getHrac() == ' ' && policko[2][0].getHrac() == 'O' && policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[2][0].getHrac() == ' ' && policko[1][1].getHrac() == 'O' && policko[0][2].getHrac() == ' ') {
                    policko[0][2].setHrac('O');
                } else if (policko[1][1].getHrac() == ' ' && policko[2][0].getHrac() == 'O' && policko[0][2].getHrac() == ' ') {
                    policko[0][2].setHrac('O');

                } else if (policko[1][1].getHrac() == ' ' && policko[0][0].getHrac() == 'O' && policko[2][2].getHrac() == ' ') {
                    policko[2][2].setHrac('O');
                } else if (policko[0][0].getHrac() == ' ' && policko[1][1].getHrac() == 'O' && policko[2][2].getHrac() == ' ') {
                    policko[2][2].setHrac('O');
                } else if (policko[2][2].getHrac() == ' ' && policko[0][0].getHrac() == 'O' && policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[0][0].getHrac() == ' ' && policko[2][2].getHrac() == 'O' && policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[2][2].getHrac() == ' ' && policko[1][1].getHrac() == 'O' && policko[0][0].getHrac() == ' ') {
                    policko[0][0].setHrac('O');
                } else if (policko[1][1].getHrac() == ' ' && policko[2][2].getHrac() == 'O' && policko[0][0].getHrac() == ' ') {
                    policko[0][0].setHrac('O');

                } else if (policko[0][2].getHrac() == ' ') {
                    policko[0][2].setHrac('O');
                } else if (policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[2][2].getHrac() == ' ') {
                    policko[2][2].setHrac('O');
                } else if (policko[1][0].getHrac() == ' ') {
                    policko[1][0].setHrac('O');
                } else if (policko[2][1].getHrac() == ' ') {
                    policko[2][1].setHrac('O');
                } else if (policko[0][1].getHrac() == ' ') {
                    policko[0][1].setHrac('O');
                } else if (policko[0][0].getHrac() == ' ') {
                    policko[0][0].setHrac('O');
                } else if (policko[2][0].getHrac() == ' ') {
                    policko[2][0].setHrac('O');
                }
            }
            
            compStav(policko3, compHardStav);
        });

        policko[2][0].setOnMouseClicked(e -> {
            if (policko[2][0].getHrac() == ' ' && compHardStav.getText() == " ") {
                policko[2][0].setHrac('X');

                if (policko[0][1].getHrac() == 'O' && policko[0][2].getHrac() == 'O' && policko[0][0].getHrac() == ' ') {
                    policko[0][0].setHrac('O');
                } else if (policko[0][2].getHrac() == 'O' && policko[0][1].getHrac() == 'O' && policko[0][0].getHrac() == ' ') {
                    policko[0][0].setHrac('O');
                } else if (policko[0][0].getHrac() == 'O' && policko[0][2].getHrac() == 'O' && policko[0][1].getHrac() == ' ') {
                    policko[0][1].setHrac('O');
                } else if (policko[0][2].getHrac() == 'O' && policko[0][0].getHrac() == 'O' && policko[0][1].getHrac() == ' ') {
                    policko[0][1].setHrac('O');
                } else if (policko[0][0].getHrac() == 'O' && policko[0][1].getHrac() == 'O' && policko[0][2].getHrac() == ' ') {
                    policko[0][2].setHrac('O');
                } else if (policko[0][1].getHrac() == 'O' && policko[0][0].getHrac() == 'O' && policko[0][2].getHrac() == ' ') {
                    policko[0][2].setHrac('O');

                } else if (policko[1][1].getHrac() == 'O' && policko[2][1].getHrac() == 'O' && policko[0][1].getHrac() == ' ') {
                    policko[0][1].setHrac('O');
                } else if (policko[2][1].getHrac() == 'O' && policko[1][1].getHrac() == 'O' && policko[0][1].getHrac() == ' ') {
                    policko[0][1].setHrac('O');
                } else if (policko[0][1].getHrac() == 'O' && policko[2][1].getHrac() == 'O' && policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[2][1].getHrac() == 'O' && policko[0][1].getHrac() == 'O' && policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[0][1].getHrac() == 'O' && policko[1][1].getHrac() == 'O' && policko[2][1].getHrac() == ' ') {
                    policko[2][1].setHrac('O');
                } else if (policko[1][1].getHrac() == 'O' && policko[0][1].getHrac() == 'O' && policko[2][1].getHrac() == ' ') {
                    policko[2][1].setHrac('O');

                } else if (policko[1][1].getHrac() == 'O' && policko[1][2].getHrac() == 'O' && policko[1][0].getHrac() == ' ') {
                    policko[1][0].setHrac('O');
                } else if (policko[1][2].getHrac() == 'O' && policko[1][1].getHrac() == 'O' && policko[1][0].getHrac() == ' ') {
                    policko[1][0].setHrac('O');
                } else if (policko[1][0].getHrac() == 'O' && policko[1][2].getHrac() == 'O' && policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[1][2].getHrac() == 'O' && policko[1][0].getHrac() == 'O' && policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[1][0].getHrac() == 'O' && policko[1][1].getHrac() == 'O' && policko[1][2].getHrac() == ' ') {
                    policko[1][2].setHrac('O');
                } else if (policko[1][1].getHrac() == 'O' && policko[1][0].getHrac() == 'O' && policko[1][2].getHrac() == ' ') {
                    policko[1][2].setHrac('O');

                } else if (policko[1][2].getHrac() == 'O' && policko[2][2].getHrac() == 'O' && policko[0][2].getHrac() == ' ') {
                    policko[0][2].setHrac('O');
                } else if (policko[2][2].getHrac() == 'O' && policko[1][2].getHrac() == 'O' && policko[0][2].getHrac() == ' ') {
                    policko[0][2].setHrac('O');
                } else if (policko[0][2].getHrac() == 'O' && policko[2][2].getHrac() == 'O' && policko[1][2].getHrac() == ' ') {
                    policko[1][2].setHrac('O');
                } else if (policko[2][2].getHrac() == 'O' && policko[0][2].getHrac() == 'O' && policko[1][2].getHrac() == ' ') {
                    policko[1][2].setHrac('O');
                } else if (policko[0][2].getHrac() == 'O' && policko[1][2].getHrac() == 'O' && policko[2][2].getHrac() == ' ') {
                    policko[2][2].setHrac('O');
                } else if (policko[1][2].getHrac() == 'O' && policko[0][2].getHrac() == 'O' && policko[2][2].getHrac() == ' ') {
                    policko[2][2].setHrac('O');

                } else if (policko[1][1].getHrac() == 'O' && policko[0][0].getHrac() == 'O' && policko[2][2].getHrac() == ' ') {
                    policko[2][2].setHrac('O');
                } else if (policko[0][0].getHrac() == 'O' && policko[1][1].getHrac() == 'O' && policko[2][2].getHrac() == ' ') {
                    policko[2][2].setHrac('O');
                } else if (policko[2][2].getHrac() == 'O' && policko[0][0].getHrac() == 'O' && policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[0][0].getHrac() == 'O' && policko[2][2].getHrac() == 'O' && policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[2][2].getHrac() == 'O' && policko[1][1].getHrac() == 'O' && policko[0][0].getHrac() == ' ') {
                    policko[0][0].setHrac('O');
                } else if (policko[1][1].getHrac() == 'O' && policko[2][2].getHrac() == 'O' && policko[0][0].getHrac() == ' ') {
                    policko[0][0].setHrac('O');

                } else if (policko[2][1].getHrac() == 'X' && policko[2][2].getHrac() == ' ') {
                    policko[2][2].setHrac('O');
                } else if (policko[1][1].getHrac() == 'X' && policko[0][2].getHrac() == ' ') {
                    policko[0][2].setHrac('O');
                } else if (policko[1][0].getHrac() == 'X' && policko[0][0].getHrac() == ' ') {
                    policko[0][0].setHrac('O');
                } else if (policko[2][2].getHrac() == 'X' && policko[2][1].getHrac() == ' ') {
                    policko[2][1].setHrac('O');
                } else if (policko[0][2].getHrac() == 'X' && policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[0][0].getHrac() == 'X' && policko[1][0].getHrac() == ' ') {
                    policko[1][0].setHrac('O');

                } else if (policko[0][1].getHrac() == ' ' && policko[0][2].getHrac() == 'O' && policko[0][0].getHrac() == ' ') {
                    policko[0][0].setHrac('O');
                } else if (policko[0][2].getHrac() == ' ' && policko[0][1].getHrac() == 'O' && policko[0][0].getHrac() == ' ') {
                    policko[0][0].setHrac('O');
                } else if (policko[0][0].getHrac() == ' ' && policko[0][2].getHrac() == 'O' && policko[0][1].getHrac() == ' ') {
                    policko[0][1].setHrac('O');
                } else if (policko[0][2].getHrac() == ' ' && policko[0][0].getHrac() == 'O' && policko[0][1].getHrac() == ' ') {
                    policko[0][1].setHrac('O');
                } else if (policko[0][0].getHrac() == ' ' && policko[0][1].getHrac() == 'O' && policko[0][2].getHrac() == ' ') {
                    policko[0][2].setHrac('O');
                } else if (policko[0][1].getHrac() == ' ' && policko[0][0].getHrac() == 'O' && policko[0][2].getHrac() == ' ') {
                    policko[0][2].setHrac('O');

                } else if (policko[1][1].getHrac() == ' ' && policko[2][1].getHrac() == 'O' && policko[0][1].getHrac() == ' ') {
                    policko[0][1].setHrac('O');
                } else if (policko[2][1].getHrac() == ' ' && policko[1][1].getHrac() == 'O' && policko[0][1].getHrac() == ' ') {
                    policko[0][1].setHrac('O');
                } else if (policko[0][1].getHrac() == ' ' && policko[2][1].getHrac() == 'O' && policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[2][1].getHrac() == ' ' && policko[0][1].getHrac() == 'O' && policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[0][1].getHrac() == ' ' && policko[1][1].getHrac() == 'O' && policko[2][1].getHrac() == ' ') {
                    policko[2][1].setHrac('O');
                } else if (policko[1][1].getHrac() == ' ' && policko[0][1].getHrac() == 'O' && policko[2][1].getHrac() == ' ') {
                    policko[2][1].setHrac('O');

                } else if (policko[1][1].getHrac() == ' ' && policko[1][2].getHrac() == 'O' && policko[1][0].getHrac() == ' ') {
                    policko[1][0].setHrac('O');
                } else if (policko[1][2].getHrac() == ' ' && policko[1][1].getHrac() == 'O' && policko[1][0].getHrac() == ' ') {
                    policko[1][0].setHrac('O');
                } else if (policko[1][0].getHrac() == ' ' && policko[1][2].getHrac() == 'O' && policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[1][2].getHrac() == ' ' && policko[1][0].getHrac() == 'O' && policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[1][0].getHrac() == ' ' && policko[1][1].getHrac() == 'O' && policko[1][2].getHrac() == ' ') {
                    policko[1][2].setHrac('O');
                } else if (policko[1][1].getHrac() == ' ' && policko[1][0].getHrac() == 'O' && policko[1][2].getHrac() == ' ') {
                    policko[1][2].setHrac('O');

                } else if (policko[1][2].getHrac() == ' ' && policko[2][2].getHrac() == 'O' && policko[0][2].getHrac() == ' ') {
                    policko[0][2].setHrac('O');
                } else if (policko[2][2].getHrac() == ' ' && policko[1][2].getHrac() == 'O' && policko[0][2].getHrac() == ' ') {
                    policko[0][2].setHrac('O');
                } else if (policko[0][2].getHrac() == ' ' && policko[2][2].getHrac() == 'O' && policko[1][2].getHrac() == ' ') {
                    policko[1][2].setHrac('O');
                } else if (policko[2][2].getHrac() == ' ' && policko[0][2].getHrac() == 'O' && policko[1][2].getHrac() == ' ') {
                    policko[1][2].setHrac('O');
                } else if (policko[0][2].getHrac() == ' ' && policko[1][2].getHrac() == 'O' && policko[2][2].getHrac() == ' ') {
                    policko[2][2].setHrac('O');
                } else if (policko[1][2].getHrac() == ' ' && policko[0][2].getHrac() == 'O' && policko[2][2].getHrac() == ' ') {
                    policko[2][2].setHrac('O');

                } else if (policko[1][1].getHrac() == ' ' && policko[0][0].getHrac() == 'O' && policko[2][2].getHrac() == ' ') {
                    policko[2][2].setHrac('O');
                } else if (policko[0][0].getHrac() == ' ' && policko[1][1].getHrac() == 'O' && policko[2][2].getHrac() == ' ') {
                    policko[2][2].setHrac('O');
                } else if (policko[2][2].getHrac() == ' ' && policko[0][0].getHrac() == 'O' && policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[0][0].getHrac() == ' ' && policko[2][2].getHrac() == 'O' && policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[2][2].getHrac() == ' ' && policko[1][1].getHrac() == 'O' && policko[0][0].getHrac() == ' ') {
                    policko[0][0].setHrac('O');
                } else if (policko[1][1].getHrac() == ' ' && policko[2][2].getHrac() == 'O' && policko[0][0].getHrac() == ' ') {
                    policko[0][0].setHrac('O');

                } else if (policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[2][1].getHrac() == ' ') {
                    policko[2][1].setHrac('O');
                } else if (policko[1][0].getHrac() == ' ') {
                    policko[1][0].setHrac('O');
                } else if (policko[2][2].getHrac() == ' ') {
                    policko[2][2].setHrac('O');
                } else if (policko[0][0].getHrac() == ' ') {
                    policko[0][0].setHrac('O');
                } else if (policko[0][2].getHrac() == ' ') {
                    policko[0][2].setHrac('O');
                } else if (policko[1][2].getHrac() == ' ') {
                    policko[1][2].setHrac('O');
                } else if (policko[0][1].getHrac() == ' ') {
                    policko[0][1].setHrac('O');
                }
            }
            
            compStav(policko3, compHardStav);
        });

        policko[2][1].setOnMouseClicked(e -> {
            if (policko[2][1].getHrac() == ' ' && compHardStav.getText() == " ") {
                policko[2][1].setHrac('X');

                if (policko[1][0].getHrac() == 'O' && policko[2][0].getHrac() == 'O' && policko[0][0].getHrac() == ' ') {
                    policko[0][0].setHrac('O');
                } else if (policko[2][0].getHrac() == 'O' && policko[1][0].getHrac() == 'O' && policko[0][0].getHrac() == ' ') {
                    policko[0][0].setHrac('O');
                } else if (policko[0][0].getHrac() == 'O' && policko[2][0].getHrac() == 'O' && policko[1][0].getHrac() == ' ') {
                    policko[1][0].setHrac('O');
                } else if (policko[2][0].getHrac() == 'O' && policko[0][0].getHrac() == 'O' && policko[1][0].getHrac() == ' ') {
                    policko[1][0].setHrac('O');
                } else if (policko[0][0].getHrac() == 'O' && policko[1][0].getHrac() == 'O' && policko[2][0].getHrac() == ' ') {
                    policko[2][0].setHrac('O');
                } else if (policko[1][0].getHrac() == 'O' && policko[0][0].getHrac() == 'O' && policko[2][0].getHrac() == ' ') {
                    policko[2][0].setHrac('O');

                } else if (policko[0][1].getHrac() == 'O' && policko[0][2].getHrac() == 'O' && policko[0][0].getHrac() == ' ') {
                    policko[0][0].setHrac('O');
                } else if (policko[0][2].getHrac() == 'O' && policko[0][1].getHrac() == 'O' && policko[0][0].getHrac() == ' ') {
                    policko[0][0].setHrac('O');
                } else if (policko[0][0].getHrac() == 'O' && policko[0][2].getHrac() == 'O' && policko[0][1].getHrac() == ' ') {
                    policko[0][1].setHrac('O');
                } else if (policko[0][2].getHrac() == 'O' && policko[0][0].getHrac() == 'O' && policko[0][1].getHrac() == ' ') {
                    policko[0][1].setHrac('O');
                } else if (policko[0][0].getHrac() == 'O' && policko[0][1].getHrac() == 'O' && policko[0][2].getHrac() == ' ') {
                    policko[0][2].setHrac('O');
                } else if (policko[0][1].getHrac() == 'O' && policko[0][0].getHrac() == 'O' && policko[0][2].getHrac() == ' ') {
                    policko[0][2].setHrac('O');

                } else if (policko[1][1].getHrac() == 'O' && policko[1][2].getHrac() == 'O' && policko[1][0].getHrac() == ' ') {
                    policko[1][0].setHrac('O');
                } else if (policko[1][2].getHrac() == 'O' && policko[1][1].getHrac() == 'O' && policko[1][0].getHrac() == ' ') {
                    policko[1][0].setHrac('O');
                } else if (policko[1][0].getHrac() == 'O' && policko[1][2].getHrac() == 'O' && policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[1][2].getHrac() == 'O' && policko[1][0].getHrac() == 'O' && policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[1][0].getHrac() == 'O' && policko[1][1].getHrac() == 'O' && policko[1][2].getHrac() == ' ') {
                    policko[1][2].setHrac('O');
                } else if (policko[1][1].getHrac() == 'O' && policko[1][0].getHrac() == 'O' && policko[1][2].getHrac() == ' ') {
                    policko[1][2].setHrac('O');

                } else if (policko[1][2].getHrac() == 'O' && policko[2][2].getHrac() == 'O' && policko[0][2].getHrac() == ' ') {
                    policko[0][2].setHrac('O');
                } else if (policko[2][2].getHrac() == 'O' && policko[1][2].getHrac() == 'O' && policko[0][2].getHrac() == ' ') {
                    policko[0][2].setHrac('O');
                } else if (policko[0][2].getHrac() == 'O' && policko[2][2].getHrac() == 'O' && policko[1][2].getHrac() == ' ') {
                    policko[1][2].setHrac('O');
                } else if (policko[2][2].getHrac() == 'O' && policko[0][2].getHrac() == 'O' && policko[1][2].getHrac() == ' ') {
                    policko[1][2].setHrac('O');
                } else if (policko[0][2].getHrac() == 'O' && policko[1][2].getHrac() == 'O' && policko[2][2].getHrac() == ' ') {
                    policko[2][2].setHrac('O');
                } else if (policko[1][2].getHrac() == 'O' && policko[0][2].getHrac() == 'O' && policko[2][2].getHrac() == ' ') {
                    policko[2][2].setHrac('O');

                } else if (policko[1][1].getHrac() == 'O' && policko[0][2].getHrac() == 'O' && policko[2][0].getHrac() == ' ') {
                    policko[2][0].setHrac('O');
                } else if (policko[0][2].getHrac() == 'O' && policko[1][1].getHrac() == 'O' && policko[2][0].getHrac() == ' ') {
                    policko[2][0].setHrac('O');
                } else if (policko[2][0].getHrac() == 'O' && policko[0][2].getHrac() == 'O' && policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[0][2].getHrac() == 'O' && policko[2][0].getHrac() == 'O' && policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[2][0].getHrac() == 'O' && policko[1][1].getHrac() == 'O' && policko[0][2].getHrac() == ' ') {
                    policko[0][2].setHrac('O');
                } else if (policko[1][1].getHrac() == 'O' && policko[2][0].getHrac() == 'O' && policko[0][2].getHrac() == ' ') {
                    policko[0][2].setHrac('O');

                } else if (policko[1][1].getHrac() == 'O' && policko[0][0].getHrac() == 'O' && policko[2][2].getHrac() == ' ') {
                    policko[2][2].setHrac('O');
                } else if (policko[0][0].getHrac() == 'O' && policko[1][1].getHrac() == 'O' && policko[2][2].getHrac() == ' ') {
                    policko[2][2].setHrac('O');
                } else if (policko[2][2].getHrac() == 'O' && policko[0][0].getHrac() == 'O' && policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[0][0].getHrac() == 'O' && policko[2][2].getHrac() == 'O' && policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[2][2].getHrac() == 'O' && policko[1][1].getHrac() == 'O' && policko[0][0].getHrac() == ' ') {
                    policko[0][0].setHrac('O');
                } else if (policko[1][1].getHrac() == 'O' && policko[2][2].getHrac() == 'O' && policko[0][0].getHrac() == ' ') {
                    policko[0][0].setHrac('O');

                } else if (policko[2][0].getHrac() == 'X' && policko[2][2].getHrac() == ' ') {
                    policko[2][2].setHrac('O');
                } else if (policko[2][2].getHrac() == 'X' && policko[2][0].getHrac() == ' ') {
                    policko[2][0].setHrac('O');
                } else if (policko[1][1].getHrac() == 'X' && policko[0][1].getHrac() == ' ') {
                    policko[0][1].setHrac('O');
                } else if (policko[0][1].getHrac() == 'X' && policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');

                } else if (policko[1][0].getHrac() == ' ' && policko[2][0].getHrac() == 'O' && policko[0][0].getHrac() == ' ') {
                    policko[0][0].setHrac('O');
                } else if (policko[2][0].getHrac() == ' ' && policko[1][0].getHrac() == 'O' && policko[0][0].getHrac() == ' ') {
                    policko[0][0].setHrac('O');
                } else if (policko[0][0].getHrac() == ' ' && policko[2][0].getHrac() == 'O' && policko[1][0].getHrac() == ' ') {
                    policko[1][0].setHrac('O');
                } else if (policko[2][0].getHrac() == ' ' && policko[0][0].getHrac() == 'O' && policko[1][0].getHrac() == ' ') {
                    policko[1][0].setHrac('O');
                } else if (policko[0][0].getHrac() == ' ' && policko[1][0].getHrac() == 'O' && policko[2][0].getHrac() == ' ') {
                    policko[2][0].setHrac('O');
                } else if (policko[1][0].getHrac() == ' ' && policko[0][0].getHrac() == 'O' && policko[2][0].getHrac() == ' ') {
                    policko[2][0].setHrac('O');

                } else if (policko[0][1].getHrac() == ' ' && policko[0][2].getHrac() == 'O' && policko[0][0].getHrac() == ' ') {
                    policko[0][0].setHrac('O');
                } else if (policko[0][2].getHrac() == ' ' && policko[0][1].getHrac() == 'O' && policko[0][0].getHrac() == ' ') {
                    policko[0][0].setHrac('O');
                } else if (policko[0][0].getHrac() == ' ' && policko[0][2].getHrac() == 'O' && policko[0][1].getHrac() == ' ') {
                    policko[0][1].setHrac('O');
                } else if (policko[0][2].getHrac() == ' ' && policko[0][0].getHrac() == 'O' && policko[0][1].getHrac() == ' ') {
                    policko[0][1].setHrac('O');
                } else if (policko[0][0].getHrac() == ' ' && policko[0][1].getHrac() == 'O' && policko[0][2].getHrac() == ' ') {
                    policko[0][2].setHrac('O');
                } else if (policko[0][1].getHrac() == ' ' && policko[0][0].getHrac() == 'O' && policko[0][2].getHrac() == ' ') {
                    policko[0][2].setHrac('O');

                } else if (policko[1][1].getHrac() == ' ' && policko[1][2].getHrac() == 'O' && policko[1][0].getHrac() == ' ') {
                    policko[1][0].setHrac('O');
                } else if (policko[1][2].getHrac() == ' ' && policko[1][1].getHrac() == 'O' && policko[1][0].getHrac() == ' ') {
                    policko[1][0].setHrac('O');
                } else if (policko[1][0].getHrac() == ' ' && policko[1][2].getHrac() == 'O' && policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[1][2].getHrac() == ' ' && policko[1][0].getHrac() == 'O' && policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[1][0].getHrac() == ' ' && policko[1][1].getHrac() == 'O' && policko[1][2].getHrac() == ' ') {
                    policko[1][2].setHrac('O');
                } else if (policko[1][1].getHrac() == ' ' && policko[1][0].getHrac() == 'O' && policko[1][2].getHrac() == ' ') {
                    policko[1][2].setHrac('O');

                } else if (policko[1][2].getHrac() == ' ' && policko[2][2].getHrac() == 'O' && policko[0][2].getHrac() == ' ') {
                    policko[0][2].setHrac('O');
                } else if (policko[2][2].getHrac() == ' ' && policko[1][2].getHrac() == 'O' && policko[0][2].getHrac() == ' ') {
                    policko[0][2].setHrac('O');
                } else if (policko[0][2].getHrac() == ' ' && policko[2][2].getHrac() == 'O' && policko[1][2].getHrac() == ' ') {
                    policko[1][2].setHrac('O');
                } else if (policko[2][2].getHrac() == ' ' && policko[0][2].getHrac() == 'O' && policko[1][2].getHrac() == ' ') {
                    policko[1][2].setHrac('O');
                } else if (policko[0][2].getHrac() == ' ' && policko[1][2].getHrac() == 'O' && policko[2][2].getHrac() == ' ') {
                    policko[2][2].setHrac('O');
                } else if (policko[1][2].getHrac() == ' ' && policko[0][2].getHrac() == 'O' && policko[2][2].getHrac() == ' ') {
                    policko[2][2].setHrac('O');

                } else if (policko[1][1].getHrac() == ' ' && policko[0][2].getHrac() == 'O' && policko[2][0].getHrac() == ' ') {
                    policko[2][0].setHrac('O');
                } else if (policko[0][2].getHrac() == ' ' && policko[1][1].getHrac() == 'O' && policko[2][0].getHrac() == ' ') {
                    policko[2][0].setHrac('O');
                } else if (policko[2][0].getHrac() == ' ' && policko[0][2].getHrac() == 'O' && policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[0][2].getHrac() == ' ' && policko[2][0].getHrac() == 'O' && policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[2][0].getHrac() == ' ' && policko[1][1].getHrac() == 'O' && policko[0][2].getHrac() == ' ') {
                    policko[0][2].setHrac('O');
                } else if (policko[1][1].getHrac() == ' ' && policko[2][0].getHrac() == 'O' && policko[0][2].getHrac() == ' ') {
                    policko[0][2].setHrac('O');

                } else if (policko[1][1].getHrac() == ' ' && policko[0][0].getHrac() == 'O' && policko[2][2].getHrac() == ' ') {
                    policko[2][2].setHrac('O');
                } else if (policko[0][0].getHrac() == ' ' && policko[1][1].getHrac() == 'O' && policko[2][2].getHrac() == ' ') {
                    policko[2][2].setHrac('O');
                } else if (policko[2][2].getHrac() == ' ' && policko[0][0].getHrac() == 'O' && policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[0][0].getHrac() == ' ' && policko[2][2].getHrac() == 'O' && policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[2][2].getHrac() == ' ' && policko[1][1].getHrac() == 'O' && policko[0][0].getHrac() == ' ') {
                    policko[0][0].setHrac('O');
                } else if (policko[1][1].getHrac() == ' ' && policko[2][2].getHrac() == 'O' && policko[0][0].getHrac() == ' ') {
                    policko[0][0].setHrac('O');

                } else if (policko[2][0].getHrac() == ' ') {
                    policko[2][0].setHrac('O');
                } else if (policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[2][2].getHrac() == ' ') {
                    policko[2][2].setHrac('O');
                } else if (policko[0][1].getHrac() == ' ') {
                    policko[0][1].setHrac('O');
                } else if (policko[1][0].getHrac() == ' ') {
                    policko[1][0].setHrac('O');
                } else if (policko[1][2].getHrac() == ' ') {
                    policko[1][2].setHrac('O');
                } else if (policko[0][0].getHrac() == ' ') {
                    policko[0][0].setHrac('O');
                } else if (policko[0][2].getHrac() == ' ') {
                    policko[0][2].setHrac('O');
                }
            }
            
            compStav(policko3, compHardStav);
        });

        policko[2][2].setOnMouseClicked(e -> {
            if (policko[2][2].getHrac() == ' ' && compHardStav.getText() == " ") {
                policko[2][2].setHrac('X');

                if (policko[1][0].getHrac() == 'O' && policko[2][0].getHrac() == 'O' && policko[0][0].getHrac() == ' ') {
                    policko[0][0].setHrac('O');
                } else if (policko[2][0].getHrac() == 'O' && policko[1][0].getHrac() == 'O' && policko[0][0].getHrac() == ' ') {
                    policko[0][0].setHrac('O');
                } else if (policko[0][0].getHrac() == 'O' && policko[2][0].getHrac() == 'O' && policko[1][0].getHrac() == ' ') {
                    policko[1][0].setHrac('O');
                } else if (policko[2][0].getHrac() == 'O' && policko[0][0].getHrac() == 'O' && policko[1][0].getHrac() == ' ') {
                    policko[1][0].setHrac('O');
                } else if (policko[0][0].getHrac() == 'O' && policko[1][0].getHrac() == 'O' && policko[2][0].getHrac() == ' ') {
                    policko[2][0].setHrac('O');
                } else if (policko[1][0].getHrac() == 'O' && policko[0][0].getHrac() == 'O' && policko[2][0].getHrac() == ' ') {
                    policko[2][0].setHrac('O');

                } else if (policko[0][1].getHrac() == 'O' && policko[0][2].getHrac() == 'O' && policko[0][0].getHrac() == ' ') {
                    policko[0][0].setHrac('O');
                } else if (policko[0][2].getHrac() == 'O' && policko[0][1].getHrac() == 'O' && policko[0][0].getHrac() == ' ') {
                    policko[0][0].setHrac('O');
                } else if (policko[0][0].getHrac() == 'O' && policko[0][2].getHrac() == 'O' && policko[0][1].getHrac() == ' ') {
                    policko[0][1].setHrac('O');
                } else if (policko[0][2].getHrac() == 'O' && policko[0][0].getHrac() == 'O' && policko[0][1].getHrac() == ' ') {
                    policko[0][1].setHrac('O');
                } else if (policko[0][0].getHrac() == 'O' && policko[0][1].getHrac() == 'O' && policko[0][2].getHrac() == ' ') {
                    policko[0][2].setHrac('O');
                } else if (policko[0][1].getHrac() == 'O' && policko[0][0].getHrac() == 'O' && policko[0][2].getHrac() == ' ') {
                    policko[0][2].setHrac('O');

                } else if (policko[1][1].getHrac() == 'O' && policko[2][1].getHrac() == 'O' && policko[0][1].getHrac() == ' ') {
                    policko[0][1].setHrac('O');
                } else if (policko[2][1].getHrac() == 'O' && policko[1][1].getHrac() == 'O' && policko[0][1].getHrac() == ' ') {
                    policko[0][1].setHrac('O');
                } else if (policko[0][1].getHrac() == 'O' && policko[2][1].getHrac() == 'O' && policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[2][1].getHrac() == 'O' && policko[0][1].getHrac() == 'O' && policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[0][1].getHrac() == 'O' && policko[1][1].getHrac() == 'O' && policko[2][1].getHrac() == ' ') {
                    policko[2][1].setHrac('O');
                } else if (policko[1][1].getHrac() == 'O' && policko[0][1].getHrac() == 'O' && policko[2][1].getHrac() == ' ') {
                    policko[2][1].setHrac('O');

                } else if (policko[1][1].getHrac() == 'O' && policko[1][2].getHrac() == 'O' && policko[1][0].getHrac() == ' ') {
                    policko[1][0].setHrac('O');
                } else if (policko[1][2].getHrac() == 'O' && policko[1][1].getHrac() == 'O' && policko[1][0].getHrac() == ' ') {
                    policko[1][0].setHrac('O');
                } else if (policko[1][0].getHrac() == 'O' && policko[1][2].getHrac() == 'O' && policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[1][2].getHrac() == 'O' && policko[1][0].getHrac() == 'O' && policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[1][0].getHrac() == 'O' && policko[1][1].getHrac() == 'O' && policko[1][2].getHrac() == ' ') {
                    policko[1][2].setHrac('O');
                } else if (policko[1][1].getHrac() == 'O' && policko[1][0].getHrac() == 'O' && policko[1][2].getHrac() == ' ') {
                    policko[1][2].setHrac('O');

                } else if (policko[1][1].getHrac() == 'O' && policko[0][2].getHrac() == 'O' && policko[2][0].getHrac() == ' ') {
                    policko[2][0].setHrac('O');
                } else if (policko[0][2].getHrac() == 'O' && policko[1][1].getHrac() == 'O' && policko[2][0].getHrac() == ' ') {
                    policko[2][0].setHrac('O');
                } else if (policko[2][0].getHrac() == 'O' && policko[0][2].getHrac() == 'O' && policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[0][2].getHrac() == 'O' && policko[2][0].getHrac() == 'O' && policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[2][0].getHrac() == 'O' && policko[1][1].getHrac() == 'O' && policko[0][2].getHrac() == ' ') {
                    policko[0][2].setHrac('O');
                } else if (policko[1][1].getHrac() == 'O' && policko[2][0].getHrac() == 'O' && policko[0][2].getHrac() == ' ') {
                    policko[0][2].setHrac('O');

                } else if (policko[2][1].getHrac() == 'X' && policko[2][0].getHrac() == ' ') {
                    policko[2][0].setHrac('O');
                } else if (policko[1][2].getHrac() == 'X' && policko[0][2].getHrac() == ' ') {
                    policko[0][2].setHrac('O');
                } else if (policko[1][1].getHrac() == 'X' && policko[0][0].getHrac() == ' ') {
                    policko[0][0].setHrac('O');
                } else if (policko[0][2].getHrac() == 'X' && policko[1][2].getHrac() == ' ') {
                    policko[1][2].setHrac('O');
                } else if (policko[2][0].getHrac() == 'X' && policko[2][1].getHrac() == ' ') {
                    policko[2][1].setHrac('O');
                } else if (policko[0][0].getHrac() == 'X' && policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');

                } else if (policko[1][0].getHrac() == ' ' && policko[2][0].getHrac() == 'O' && policko[0][0].getHrac() == ' ') {
                    policko[0][0].setHrac('O');
                } else if (policko[2][0].getHrac() == ' ' && policko[1][0].getHrac() == 'O' && policko[0][0].getHrac() == ' ') {
                    policko[0][0].setHrac('O');
                } else if (policko[0][0].getHrac() == ' ' && policko[2][0].getHrac() == 'O' && policko[1][0].getHrac() == ' ') {
                    policko[1][0].setHrac('O');
                } else if (policko[2][0].getHrac() == ' ' && policko[0][0].getHrac() == 'O' && policko[1][0].getHrac() == ' ') {
                    policko[1][0].setHrac('O');
                } else if (policko[0][0].getHrac() == ' ' && policko[1][0].getHrac() == 'O' && policko[2][0].getHrac() == ' ') {
                    policko[2][0].setHrac('O');
                } else if (policko[1][0].getHrac() == ' ' && policko[0][0].getHrac() == 'O' && policko[2][0].getHrac() == ' ') {
                    policko[2][0].setHrac('O');

                } else if (policko[0][1].getHrac() == ' ' && policko[0][2].getHrac() == 'O' && policko[0][0].getHrac() == ' ') {
                    policko[0][0].setHrac('O');
                } else if (policko[0][2].getHrac() == ' ' && policko[0][1].getHrac() == 'O' && policko[0][0].getHrac() == ' ') {
                    policko[0][0].setHrac('O');
                } else if (policko[0][0].getHrac() == ' ' && policko[0][2].getHrac() == 'O' && policko[0][1].getHrac() == ' ') {
                    policko[0][1].setHrac('O');
                } else if (policko[0][2].getHrac() == ' ' && policko[0][0].getHrac() == 'O' && policko[0][1].getHrac() == ' ') {
                    policko[0][1].setHrac('O');
                } else if (policko[0][0].getHrac() == ' ' && policko[0][1].getHrac() == 'O' && policko[0][2].getHrac() == ' ') {
                    policko[0][2].setHrac('O');
                } else if (policko[0][1].getHrac() == ' ' && policko[0][0].getHrac() == 'O' && policko[0][2].getHrac() == ' ') {
                    policko[0][2].setHrac('O');

                } else if (policko[1][1].getHrac() == ' ' && policko[2][1].getHrac() == 'O' && policko[0][1].getHrac() == ' ') {
                    policko[0][1].setHrac('O');
                } else if (policko[2][1].getHrac() == ' ' && policko[1][1].getHrac() == 'O' && policko[0][1].getHrac() == ' ') {
                    policko[0][1].setHrac('O');
                } else if (policko[0][1].getHrac() == ' ' && policko[2][1].getHrac() == 'O' && policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[2][1].getHrac() == ' ' && policko[0][1].getHrac() == 'O' && policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[0][1].getHrac() == ' ' && policko[1][1].getHrac() == 'O' && policko[2][1].getHrac() == ' ') {
                    policko[2][1].setHrac('O');
                } else if (policko[1][1].getHrac() == ' ' && policko[0][1].getHrac() == 'O' && policko[2][1].getHrac() == ' ') {
                    policko[2][1].setHrac('O');

                } else if (policko[1][1].getHrac() == ' ' && policko[1][2].getHrac() == 'O' && policko[1][0].getHrac() == ' ') {
                    policko[1][0].setHrac('O');
                } else if (policko[1][2].getHrac() == ' ' && policko[1][1].getHrac() == 'O' && policko[1][0].getHrac() == ' ') {
                    policko[1][0].setHrac('O');
                } else if (policko[1][0].getHrac() == ' ' && policko[1][2].getHrac() == 'O' && policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[1][2].getHrac() == ' ' && policko[1][0].getHrac() == 'O' && policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[1][0].getHrac() == ' ' && policko[1][1].getHrac() == 'O' && policko[1][2].getHrac() == ' ') {
                    policko[1][2].setHrac('O');
                } else if (policko[1][1].getHrac() == ' ' && policko[1][0].getHrac() == 'O' && policko[1][2].getHrac() == ' ') {
                    policko[1][2].setHrac('O');

                } else if (policko[1][1].getHrac() == ' ' && policko[0][2].getHrac() == 'O' && policko[2][0].getHrac() == ' ') {
                    policko[2][0].setHrac('O');
                } else if (policko[0][2].getHrac() == ' ' && policko[1][1].getHrac() == 'O' && policko[2][0].getHrac() == ' ') {
                    policko[2][0].setHrac('O');
                } else if (policko[2][0].getHrac() == ' ' && policko[0][2].getHrac() == 'O' && policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[0][2].getHrac() == ' ' && policko[2][0].getHrac() == 'O' && policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[2][0].getHrac() == ' ' && policko[1][1].getHrac() == 'O' && policko[0][2].getHrac() == ' ') {
                    policko[0][2].setHrac('O');
                } else if (policko[1][1].getHrac() == ' ' && policko[2][0].getHrac() == 'O' && policko[0][2].getHrac() == ' ') {
                    policko[0][2].setHrac('O');

                } else if (policko[1][1].getHrac() == ' ') {
                    policko[1][1].setHrac('O');
                } else if (policko[2][1].getHrac() == ' ') {
                    policko[2][1].setHrac('O');
                } else if (policko[1][2].getHrac() == ' ') {
                    policko[1][2].setHrac('O');
                } else if (policko[0][2].getHrac() == ' ') {
                    policko[0][2].setHrac('O');
                } else if (policko[2][0].getHrac() == ' ') {
                    policko[2][0].setHrac('O');
                } else if (policko[0][0].getHrac() == ' ') {
                    policko[0][0].setHrac('O');
                } else if (policko[1][0].getHrac() == ' ') {
                    policko[1][0].setHrac('O');
                } else if (policko[0][1].getHrac() == ' ') {
                    policko[0][1].setHrac('O');
                }
            }
            
            compStav(policko3, compHardStav);
        });
    }

    public class Pole extends Pane {

        private char hrac = ' ';

        public char getHrac() {
            return hrac;
        }

        public void setHrac(char h) {
            hrac = h;

            if (hrac == 'X') {
                File obrazekX = new File("D:/x1.png");
                this.setStyle("-fx-background-image: url('file:" + obrazekX.getAbsolutePath() + "');");
            } else if (hrac == 'O') {
                File obrazekO = new File("D:/o1.png");
                this.setStyle("-fx-background-image: url('file:" + obrazekO.getAbsolutePath() + "');");
            } else if (hrac == ' ') {
                this.setStyle("-fx-border-color: black; -fx-background-color: black");
            }
        }

        private void kliknuti() {
            if (hrac == ' ' && nynejsiHrac != ' ') {
                setHrac(nynejsiHrac);

                if (vyhra(nynejsiHrac)) {
                    multiStav.setText("Hráč " + nynejsiHrac + " vyhrál!");
                    nynejsiHrac = ' ';
                } else if (jePlno()) {
                    multiStav.setText("Remíza!");
                    nynejsiHrac = ' ';
                } else {
                    nynejsiHrac = (nynejsiHrac == 'X') ? 'O' : 'X';
                    multiStav.setText("Hráč " + nynejsiHrac + " hraje!");
                }
            }
        }

        public Pole() {
            this.setStyle("-fx-border-color: black; -fx-background-color: black");
            this.setPrefSize(200, 200);
            this.setOnMouseClicked(event -> kliknuti());
        }

    }

    public void compStav(Pole[][] policko, Label stav) {
        for (int x = 0; x < 3; x++) {
            if (policko[0][x].getHrac() == 'X' && policko[1][x].getHrac() == 'X' && policko[2][x].getHrac() == 'X') {
                stav.setText("Vyhrál/a jsi!");
            } else if (policko[x][0].getHrac() == 'X' && policko[x][1].getHrac() == 'X' && policko[x][2].getHrac() == 'X') {
                stav.setText("Vyhrál/a jsi!");
            } else if (policko[0][2].getHrac() == 'X' && policko[1][1].getHrac() == 'X' && policko[2][0].getHrac() == 'X') {
                stav.setText("Vyhrál/a jsi!");
            } else if (policko[0][0].getHrac() == 'X' && policko[1][1].getHrac() == 'X' && policko[2][2].getHrac() == 'X') {
                stav.setText("Vyhrál/a jsi!");
            } else if (policko[0][x].getHrac() == 'O' && policko[1][x].getHrac() == 'O' && policko[2][x].getHrac() == 'O') {
                stav.setText("Prohrál/a jsi!");
            } else if (policko[x][0].getHrac() == 'O' && policko[x][1].getHrac() == 'O' && policko[x][2].getHrac() == 'O') {
                stav.setText("Prohrál/a jsi!");
            } else if (policko[0][2].getHrac() == 'O' && policko[1][1].getHrac() == 'O' && policko[2][0].getHrac() == 'O') {
                stav.setText("Prohrál/a jsi!");
            } else if (policko[0][0].getHrac() == 'O' && policko[1][1].getHrac() == 'O' && policko[2][2].getHrac() == 'O') {
                stav.setText("Prohrál/a jsi!");
            } else if (stav.getText() == " " && policko[0][0].getHrac() != ' ' && policko[0][1].getHrac() != ' ' && policko[0][2].getHrac() != ' '
                    && policko[1][0].getHrac() != ' ' && policko[1][1].getHrac() != ' ' && policko[1][2].getHrac() != ' '
                    && policko[2][0].getHrac() != ' ' && policko[2][1].getHrac() != ' ' && policko[2][2].getHrac() != ' ') {
                stav.setText("Remíza!");

            }
        }
    }

}
