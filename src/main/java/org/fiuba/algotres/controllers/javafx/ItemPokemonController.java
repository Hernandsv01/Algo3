package org.fiuba.algotres.controllers.javafx;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.fiuba.algotres.utils.enums.OpcionesEmergentes;

import java.io.IOException;
import java.util.*;

public abstract class ItemPokemonController {

    public void togglePane(AnchorPane pane, String activatedPane, String desactivatedVolver, String desactivatedProperty) {
        String colorAttribute = Arrays.stream(pane.getStyle().split(";")).filter(s -> s.contains("-fx-border-color")).toList().get(0);
        String nameAttribute = pane.getId();
        if(colorAttribute.contains(activatedPane)){
            if (!Objects.equals(nameAttribute, "botonVolver")) {
                pane.setStyle(pane.getStyle().replace(activatedPane, desactivatedProperty));
            }
            pane.setStyle(pane.getStyle().replace(activatedPane, desactivatedVolver));
        }else if(colorAttribute.contains(desactivatedProperty)){
            pane.setStyle(pane.getStyle().replace(desactivatedProperty, activatedPane));
        }else if(colorAttribute.contains(desactivatedVolver)) {
            pane.setStyle(pane.getStyle().replace(desactivatedVolver, activatedPane));
        }
    }

    public void goBack(String ruta) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(ruta));
            Scene scene = new Scene(loader.load());
            JavafxController.setScene(scene);
        } catch (IOException e) {
            System.out.println("Error en la carga de " + ruta);
        }
    }

    public OpcionesEmergentes confirmarDecision(String text){
        Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION);
        Stage stage = (Stage) confirmation.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image(this.getClass().getResource("/imagenes/otros/app-logo.png").toString()));
        confirmation.setTitle("Confirmacion");
        confirmation.setHeaderText(text);

        Optional<ButtonType> result = confirmation.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            return OpcionesEmergentes.CONFIRMADA;
        }
        return OpcionesEmergentes.DENEGADA;
    }

    public int verifyPosition(int pos, int cantidadDeOpciones){
        if(pos >= 0 && pos < cantidadDeOpciones){
            return pos;
        }
        return -1;
    }
}
