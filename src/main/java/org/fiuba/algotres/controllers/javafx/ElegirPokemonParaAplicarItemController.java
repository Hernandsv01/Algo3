package org.fiuba.algotres.controllers.javafx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import org.fiuba.algotres.JuegoJavafx;
import org.fiuba.algotres.model.Jugador;
import org.fiuba.algotres.model.Pokemon;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class ElegirPokemonParaAplicarItemController implements Initializable {
    private static final String UP_KEY = "UP";
    private static final String DOWN_KEY = "DOWN";
    private static final String RIGHT_KEY = "RIGHT";
    private static final String LEFT_KEY = "LEFT";
    private static final String ENTER_KEY = "ENTER";
    private static final String ESCAPE_KEY = "ESCAPE";
    private static final String ACTIVATED_PANE_COLOR = "#efb810";
    private static final String DESACTIVATED_VOLVER_PANE_COLOR = "#610000";
    private static final String DEACTIVATED_POKEMON_COLOR = "#0f2c64";
    private static final int CANTIDAD_DE_OPCIONES = 7;
    private static final int OPCIONES_POR_COLUMNA = 3;

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
    @FXML
    public AnchorPane botonVolver;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadPokemonesJugadorActual();
        setSelectedSceneElement(0);
    }

    @FXML
    public void onKeyTyped(KeyEvent event) throws IOException {
        String tecla = event.getCode().toString();
        System.out.println("Key pressed: " + tecla);

        switch (tecla) {
            case UP_KEY, DOWN_KEY, RIGHT_KEY, LEFT_KEY -> moveSelector(tecla);
            case ENTER_KEY -> select();
            case ESCAPE_KEY -> goBack();
        }
    }

    public static void togglePane(AnchorPane pane){
        String colorAttribute = Arrays.stream(pane.getStyle().split(";")).filter(s -> s.contains("-fx-border-color")).toList().get(0);
        String nameAttribute = pane.getId();
        if(colorAttribute.contains(ACTIVATED_PANE_COLOR)){
            if (!Objects.equals(nameAttribute, "botonVolver")) {
                pane.setStyle(pane.getStyle().replace(ACTIVATED_PANE_COLOR, DEACTIVATED_POKEMON_COLOR));
            }
            pane.setStyle(pane.getStyle().replace(ACTIVATED_PANE_COLOR, DESACTIVATED_VOLVER_PANE_COLOR));
        }else if(colorAttribute.contains(DEACTIVATED_POKEMON_COLOR)){
            pane.setStyle(pane.getStyle().replace(DEACTIVATED_POKEMON_COLOR, ACTIVATED_PANE_COLOR));
        }else if(colorAttribute.contains(DESACTIVATED_VOLVER_PANE_COLOR)) {
            pane.setStyle(pane.getStyle().replace(DESACTIVATED_VOLVER_PANE_COLOR, ACTIVATED_PANE_COLOR));
        }
    }

    private List<AnchorPane> getSceneElements() {
        ArrayList<AnchorPane> v1  = new ArrayList<>(vBox1.getChildren().stream()
                .filter(node -> node instanceof AnchorPane)
                .map(node -> (AnchorPane) node)
                .toList());

        ArrayList<AnchorPane> v2  = new ArrayList<>(vBox2.getChildren().stream()
                .filter(node -> node instanceof AnchorPane)
                .map(node -> (AnchorPane)node)
                .toList());

        v1.addAll(v2);
        v1.add(botonVolver);
        return v1;
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
        int newPos;
        switch (tecla) {
            case UP_KEY -> newPos = verifyPosition(actualPos - 1);
            case DOWN_KEY -> newPos = verifyPosition(actualPos + 1);
            case RIGHT_KEY -> {
                if (actualPos == CANTIDAD_DE_OPCIONES - 2) {
                    newPos = verifyPosition(actualPos + 1);
                } else {
                    newPos = verifyPosition(actualPos + OPCIONES_POR_COLUMNA);
                }
            }
            case LEFT_KEY -> {
                if (actualPos == CANTIDAD_DE_OPCIONES - 1) {
                    newPos = verifyPosition(actualPos - 1);
                } else {
                    newPos = verifyPosition(actualPos - OPCIONES_POR_COLUMNA);
                }
            }
            default -> newPos = -1;
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
        if(pos >= 0 && pos < CANTIDAD_DE_OPCIONES){
            return pos;
        }
        return -1;
    }

    private void select() {
        AnchorPane selectedElement = getSelectedSceneElement();
        String selectedElementId = selectedElement.getId();
        int selectedPos = verifyPosition(coordenadas(selectedElement));
        if (selectedPos != -1) {
            if (!Objects.equals(selectedElementId, "botonVolver")) {
                //codigo que aplique item
//                Item itemElegido = JavafxController.getCdb().getJugadorActual().getItems().get(selectedPos);
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/BattleScreen.fxml"));
                    Scene scene = new Scene(loader.load());
                    JuegoJavafx.setScene(scene);
                } catch (IOException e) {
                    System.out.println("Error en la carga de BattleScreen.fxml");
                }
            } else {
                goBack();
            }
        }
    }

    private void goBack() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ElegirItem.fxml"));
            Scene scene = new Scene(loader.load());
            JuegoJavafx.setScene(scene);
        } catch (IOException e) {
            System.out.println("Error en la carga de ElegirItem.fxml");
        }
    }

    private List<Label> getLabel(String tipo) {
        ArrayList<Label> list = new ArrayList<>();

        switch (tipo) {
            case "Nombre":
                list.add(Nombre1);
                list.add(Nombre2);
                list.add(Nombre3);
                list.add(Nombre4);
                list.add(Nombre5);
                list.add(Nombre6);

            case "Tipo":
                list.add(Tipo1);
                list.add(Tipo2);
                list.add(Tipo3);
                list.add(Tipo4);
                list.add(Tipo5);
                list.add(Tipo6);

            case "Nivel":
                list.add(Nivel1);
                list.add(Nivel2);
                list.add(Nivel3);
                list.add(Nivel4);
                list.add(Nivel5);
                list.add(Nivel6);

            case "Vida":
                list.add(Vida1);
                list.add(Vida2);
                list.add(Vida3);
                list.add(Vida4);
                list.add(Vida5);
                list.add(Vida6);
        }
        return list;
    }

    private List<ImageView> getImages() {
        ArrayList<ImageView> list = new ArrayList<>();
        list.add(Imagen1);
        list.add(Imagen2);
        list.add(Imagen3);
        list.add(Imagen4);
        list.add(Imagen5);
        list.add(Imagen6);
        return list;
    }

    private void loadPokemonesJugadorActual() {
        Jugador jugadorActual = JuegoJavafx.getCdb().getJugadorActual();
        List<Pokemon> pokemons = jugadorActual.getPokemons();
        List<Label> labelsNombre = getLabel("Nombre");
        List<Label> labelsTipo = getLabel("Tipo");
        List<Label> labelsNivel = getLabel("Nivel");
        List<Label> labelsVida = getLabel("Vida");
        List<ImageView> images = getImages();

        for (int i = 0; i < CANTIDAD_DE_OPCIONES -1; i++) {
            String name = pokemons.get(i).getNombre();
            String type = pokemons.get(i).getTipos().toString();
            String level = pokemons.get(i).getNivel().toString();
            String lifeActual = pokemons.get(i).getVidaActual().toString();
            String lifeMax = pokemons.get(i).getVidaMaxima().toString();

            labelsNombre.get(i).setText(name);
            labelsNivel.get(i).setText("Nv. " + level);
            labelsTipo.get(i).setText(type.toUpperCase());
            labelsVida.get(i).setText("PS. " + lifeActual + "/" + lifeMax);

            try {
                images.get(i).setImage(new Image(getClass().getResourceAsStream("/imagenes/pokemons/" + name + "-portada.png")));
            } catch (Exception e) {
              e.printStackTrace();
            }
        }
    }
}
