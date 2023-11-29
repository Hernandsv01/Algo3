package org.fiuba.algotres.controllers.javafx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import org.fiuba.algotres.JuegoJavafx;
import org.fiuba.algotres.model.Jugador;
import org.fiuba.algotres.model.Pokemon;
import org.fiuba.algotres.utils.ImageLoader;
import org.fiuba.algotres.utils.enums.DefaultImageType;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class ElegirPokemonInicialController implements Initializable {
    private static final String UP_KEY = "UP";
    private static final String DOWN_KEY = "DOWN";
    private static final String RIGHT_KEY = "RIGHT";
    private static final String LEFT_KEY = "LEFT";
    private static final String ENTER_KEY = "ENTER";
    private static final String ACTIVATED_PANE_COLOR = "#efb810";
    private static final String DEACTIVATED_PANE_COLOR = "#0f2c64";
    private static final int CANTIDAD_DE_POKEMONS = 6;
    @FXML
    public ImageView Imagen1;
    @FXML
    public Label Nombre1;
    @FXML
    public Label Tipo1;
    @FXML
    public Label Nivel1;
    @FXML
    public Label Vida1;
    @FXML
    public ImageView Imagen2;
    @FXML
    public Label Nombre2;
    @FXML
    public Label Tipo2;
    @FXML
    public Label Nivel2;
    @FXML
    public Label Vida2;
    @FXML
    public ImageView Imagen3;
    @FXML
    public Label Nombre3;
    @FXML
    public Label Tipo3;
    @FXML
    public Label Nivel3;
    @FXML
    public Label Vida3;
    @FXML
    public ImageView Imagen4;
    @FXML
    public Label Nombre4;
    @FXML
    public Label Tipo4;
    @FXML
    public Label Nivel4;
    @FXML
    public Label Vida4;
    @FXML
    public ImageView Imagen5;
    @FXML
    public Label Nombre5;
    @FXML
    public Label Tipo5;
    @FXML
    public Label Nivel5;
    @FXML
    public Label Vida5;
    @FXML
    public ImageView Imagen6;
    @FXML
    public Label Nombre6;
    @FXML
    public Label Tipo6;
    @FXML
    public Label Nivel6;
    @FXML
    public Label Vida6;
    @FXML
    private VBox vBox1;
    @FXML
    private VBox vBox2;

    private static int idJugadorActual = 0;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadPokemonesJugador(idJugadorActual);
        setSelectedSceneElement(0);
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

    private List<AnchorPane> getSceneElements() {
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

    private AnchorPane getSelectedSceneElement(){
        return getSceneElements().stream()
                .filter(anchorPane -> anchorPane.getStyle().contains("-fx-border-color: #efb810"))
                .findFirst().orElse(null);
    }

    private void setSelectedSceneElement(int pos){
        AnchorPane previousElement = getSelectedSceneElement();

        if (previousElement != null) {
            togglePane(previousElement);
        }
        togglePane(getSceneElements().get(pos));
    }

    private void moveSelector(String tecla){
        AnchorPane currentElement = getSelectedSceneElement();
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
        setSelectedSceneElement(newPos);
    }

    private int coordenadas(AnchorPane element) {
        return getSceneElements().indexOf(element);
    }

    private static int verifyPosition(int pos){
        if(pos >= 0 && pos < CANTIDAD_DE_POKEMONS){
            return pos;
        }
        return -1;
    }

    private void select() {
        AnchorPane selectedElement = getSelectedSceneElement();
        int selectedPos = verifyPosition(coordenadas(selectedElement));
        if (selectedPos != -1) {
            //codigo que selecciona el pokemon inicial
            JuegoJavafx.getCdb().getJugadores()[idJugadorActual].cambiarPokemonActual(selectedPos);
            if(idJugadorActual == 0){
                loadPokemonesJugador(1);
                idJugadorActual = 1;
            }else{
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/BattleScreen.fxml"));
                    Scene scene = new Scene(loader.load());
                    JuegoJavafx.setScene(scene, true);
                } catch (IOException e) {
                    System.out.println("Error en la carga de BattleScreen.fxml");
                }
            }
        }
    }

    HashMap<Integer, List<Node>> data = new HashMap<>() {{
        put(0, List.of(Nombre1, Tipo1, Nivel1, Vida1, Imagen1));
        put(1, List.of(Nombre2, Tipo2, Nivel2, Vida2, Imagen2));
        put(2, List.of(Nombre3, Tipo3, Nivel3, Vida3, Imagen3));
        put(3, List.of(Nombre4, Tipo4, Nivel4, Vida4, Imagen4));
        put(4, List.of(Nombre5, Tipo5, Nivel5, Vida5, Imagen5));
        put(5, List.of(Nombre5, Tipo5, Nivel5, Vida5, Imagen5));
    }};

    private void loadPokemonesJugador(int id) {
        Jugador jugadorActual = JuegoJavafx.getCdb().getJugadores()[id];
        List<Pokemon> pokemons = jugadorActual.getPokemons();

        for (int i = 0; i < CANTIDAD_DE_POKEMONS; i++) {
            String name = pokemons.get(i).getNombre();
            String type = pokemons.get(i).getTipos().toString();
            String level = pokemons.get(i).getNivel().toString();
            String lifeActual = pokemons.get(i).getVidaActual().toString();
            String lifeMax = pokemons.get(i).getVidaMaxima().toString();

            ((Label) data.get(i).get(0)).setText(name); //Nombre
            ((Label) data.get(i).get(1)).setText(type.toUpperCase()); //Tipo
            ((Label) data.get(i).get(2)).setText("Nv. " + level); //Nivel
            ((Label) data.get(i).get(3)).setText("PS. " + lifeActual + "/" + lifeMax); //Vida
            ((ImageView) data.get(i).get(4)).setImage(ImageLoader.getJavafxImage("/imagenes/pokemons/" + name + "-portada.png", DefaultImageType.POKEMON));
        }
    }
}
