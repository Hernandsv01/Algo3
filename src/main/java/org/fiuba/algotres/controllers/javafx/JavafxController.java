package org.fiuba.algotres.controllers.javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
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
        gameStage.getIcons().add(new Image("/imagenes/otros/app-logo.png"));

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/BattleScreen.fxml"));
        AnchorPane anchorPane = loader.load();
        Scene scene = new Scene(anchorPane);
        scene.getRoot().requestFocus();
        gameStage.setScene(scene);
        gameStage.show();
    }

    public static CampoDeBatalla getCdb() {
        return cdb;
    }
    public static void setCdb(CampoDeBatalla cdb) {
        JavafxController.cdb = cdb;
    }
}
