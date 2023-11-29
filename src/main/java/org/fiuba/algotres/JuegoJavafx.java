package org.fiuba.algotres;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import lombok.Getter;
import org.fiuba.algotres.model.CampoDeBatalla;

import java.io.IOException;

import static org.fiuba.algotres.persistencia.inicializadores.json.JSONInitializer.loadCampoDeBatalla;

public class JuegoJavafx extends Application {
    private static Stage gameStage;
    @Getter
    private static CampoDeBatalla cdb;

    @Override
    public void start(Stage stage) throws Exception {
        gameStage = stage;
        try{
            cdb = loadCampoDeBatalla();
        }catch(Exception e){
            e.printStackTrace();
            return;
        }

        gameStage.setResizable(false);
        gameStage.setTitle("Fede aprobanos por favor");
        gameStage.getIcons().add(new Image("/imagenes/otros/app-logo.png"));

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/pantalla-menu.fxml"));
        StackPane stackPane = loader.load();
        Scene scene = new Scene(stackPane);
        gameStage.setScene(scene);
        gameStage.show();
    }

    public static void setScene(Scene scene, boolean needsFocus) throws IOException {
//        FadeTransition fadeIn = new FadeTransition(Duration.seconds(1), blackScreen);
//        fadeIn.setFromValue(0.0);
//        fadeIn.setToValue(1.0);
//        FadeTransition fadeOut = new FadeTransition(Duration.seconds(1), blackScreen);
//        fadeOut.setFromValue(1.0);
//        fadeOut.setToValue(0.0);

//        fadeIn.setOnFinished(event -> {
        gameStage.setScene(scene);
//            fadeOut.play();
//        });
//        fadeIn.play();

        if(needsFocus){
            scene.getRoot().requestFocus();
        }
        scene.setCursor(Cursor.NONE);
    }
}
