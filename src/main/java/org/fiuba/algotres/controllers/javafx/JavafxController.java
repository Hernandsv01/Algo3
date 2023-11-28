package org.fiuba.algotres.controllers.javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import lombok.Getter;
import lombok.Setter;
import org.fiuba.algotres.model.CampoDeBatalla;

import java.net.URL;
import java.util.ResourceBundle;

import static org.fiuba.algotres.persistencia.inicializadores.json.JSONInitializer.loadCampoDeBatalla;

public class JavafxController extends Application {
    private static Stage gameStage;
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
        gameStage.getIcons().add(new Image(getClass().getResource("/fxml/pantalla-menu.fxml").toString()));

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/pantalla-menu.fxml"));
        StackPane stackPane = loader.load();
        Scene scene = new Scene(stackPane);
        gameStage.setScene(scene);
        gameStage.show();
    }

    public static CampoDeBatalla getCdb() {
        return cdb;
    }
    public static void setCdb(CampoDeBatalla cdb) {
        JavafxController.cdb = cdb;
    }

    public static void setScene(Scene scene){
        gameStage.setScene(scene);
        scene.getRoot().requestFocus();
        scene.setCursor(Cursor.NONE);
    }
}
