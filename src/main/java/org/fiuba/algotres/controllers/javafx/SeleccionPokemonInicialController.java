package org.fiuba.algotres.controllers.javafx;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import org.fiuba.algotres.model.Jugador;
import org.fiuba.algotres.model.Pokemon;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class SeleccionPokemonInicialController implements Initializable {
    private static final String UP_KEY = "UP";
    private static final String DOWN_KEY = "DOWN";
    private static final String RIGHT_KEY = "RIGHT";
    private static final String LEFT_KEY = "LEFT";
    private static final String ENTER_KEY = "ENTER";
    private static final String ACTIVATED_PANE_COLOR = "#efb810";
    private static final String DEACTIVATED_PANE_COLOR = "#0f2c64";
    private static final int CANTIDAD_DE_POKEMONS = 6;
    public AnchorPane pokemon1;
    public AnchorPane pokemon2;
    public ImageView Imagen4;
    public Label Nombre4;
    public Label Tipo4;
    public Label Nivel4;
    public Label Vida4;
    public ImageView Imagen5;
    public Label Nombre5;
    public Label Tipo5;
    public Label Nivel5;
    public Label Vida5;
    public ImageView Imagen6;

    @FXML
    private VBox vBox1;
    @FXML
    private VBox vBox2;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setSelectedVBoxElement(0);
    }

    @FXML
    public void onKeyTyped(KeyEvent event){
        String tecla = event.getCode().toString();
        System.out.println("Key pressed: " + tecla);

        switch (tecla) {
            case UP_KEY, DOWN_KEY, RIGHT_KEY, LEFT_KEY -> moveSelector(tecla);
            case ENTER_KEY -> select();
        }
    }

    public static void togglePane(AnchorPane pane){
        String colorAttribute = Arrays.stream(pane.getStyle().split(";")).filter(s -> s.contains("-fx-border-color")).toList().get(0);
        if(colorAttribute.contains(ACTIVATED_PANE_COLOR)){
            pane.setStyle(pane.getStyle().replace(ACTIVATED_PANE_COLOR, DEACTIVATED_PANE_COLOR));
        }else if(colorAttribute.contains(DEACTIVATED_PANE_COLOR)){
            pane.setStyle(pane.getStyle().replace(DEACTIVATED_PANE_COLOR, ACTIVATED_PANE_COLOR));
        }
    }

    private List<AnchorPane> getVBoxElements() {
        List<AnchorPane> v1  = vBox1.getChildren().stream()
                .filter(node -> node instanceof AnchorPane)
                .map(node -> (AnchorPane)node)
                .toList();

        List<AnchorPane> v2  = vBox2.getChildren().stream()
                .filter(node -> node instanceof AnchorPane)
                .map(node -> (AnchorPane)node)
                .toList();

        ArrayList<AnchorPane> opcionesPokemons = new ArrayList<>();
        opcionesPokemons.addAll(v1);
        opcionesPokemons.addAll(v2);

        return opcionesPokemons;
    }

    private AnchorPane getSelectedVboxElement(){
        return getVBoxElements().stream()
                .filter(anchorPane -> anchorPane.getStyle().contains("-fx-border-color: #efb810"))
                .findFirst().orElse(null);
    }

    private void setSelectedVBoxElement(int pos){
        AnchorPane previousElement = getSelectedVboxElement();

        if (previousElement != null) {
            togglePane(previousElement);
        }
        togglePane(getVBoxElements().get(pos));
    }

    private void moveSelector(String tecla){
        AnchorPane currentElement = getSelectedVboxElement();
        if(currentElement == null) return;

        int actualPos = coordenadas(currentElement);
        int newPos = switch (tecla) {
            case UP_KEY -> verifyPosition(actualPos - 1);
            case DOWN_KEY -> verifyPosition(actualPos + 1);
            case RIGHT_KEY -> verifyPosition(actualPos + 3);
            case LEFT_KEY -> verifyPosition(actualPos - 3);
            default -> -1;
        };

        if(newPos == -1){
            return;
        }
        setSelectedVBoxElement(newPos);
    }

    private int coordenadas(AnchorPane element) {
        return getVBoxElements().indexOf(element);
    }

    private static int verifyPosition(int pos){
        if(pos >= 0 && pos < CANTIDAD_DE_POKEMONS){
            return pos;
        }
        return -1;
    }

    private void select() {
        AnchorPane selectedElement = getSelectedVboxElement();
        int selectedPos = verifyPosition(coordenadas(selectedElement));
        if (selectedPos != -1) {
            //codigo que selecciona el pokemon inicial
            JavafxController.getCdb().getJugadorActual().cambiarPokemonActual(selectedPos);
        }
    }

    private void loadPokemonesJugadorActual() {
        Jugador jugadorActual = JavafxController.getCdb().getJugadorActual();
        List<Pokemon> pokemons = jugadorActual.getPokemons();

    }
}
