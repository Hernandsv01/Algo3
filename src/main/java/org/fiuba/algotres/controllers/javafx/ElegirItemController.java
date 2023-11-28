package org.fiuba.algotres.controllers.javafx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import lombok.Getter;
import lombok.Setter;
import org.fiuba.algotres.model.Jugador;
import org.fiuba.algotres.model.item.Item;
import org.fiuba.algotres.utils.enums.BattleState;
import org.fiuba.algotres.utils.enums.OpcionesEmergentes;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class ElegirItemController implements Initializable {
    private static final String UP_KEY = "UP";
    private static final String DOWN_KEY = "DOWN";
    private static final String RIGHT_KEY = "RIGHT";
    private static final String LEFT_KEY = "LEFT";
    private static final String ENTER_KEY = "ENTER";
    private static final String ESCAPE_KEY = "ESCAPE";
    private static final String ACTIVATED_PANE_COLOR = "#efb810";
    private static final String DESACTIVATED_ITEM_PANE_COLOR = "#574329";
    private static final String DESACTIVATED_VOLVER_PANE_COLOR = "#610000";
    private static final int CANTIDAD_DE_OPCIONES = 9;
    private static final int OPCIONES_POR_COLUMNA = 4;
    @Getter @Setter
    private BattleState state;
    @FXML
    public Label mensajeInferior;
    @FXML
    public Label cantidadHiperPocion;
    @FXML
    public Label cantidadPocion;
    @FXML
    public Label cantidadDefensaX;
    @FXML
    public Label cantidadCuraTodo;
    @FXML
    public Label cantidadMegaPocion;
    @FXML
    public Label cantidadPocionMolestaAlumnos;
    @FXML
    public Label cantidadAtaqueX;
    @FXML
    public Label cantidadRevivir;
    @FXML
    private VBox vBox1;
    @FXML
    private VBox vBox2;
    @FXML
    public AnchorPane botonVolver;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadItemsJugadorActual();
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
                pane.setStyle(pane.getStyle().replace(ACTIVATED_PANE_COLOR, DESACTIVATED_ITEM_PANE_COLOR));
            }
            pane.setStyle(pane.getStyle().replace(ACTIVATED_PANE_COLOR, DESACTIVATED_VOLVER_PANE_COLOR));
        }else if(colorAttribute.contains(DESACTIVATED_ITEM_PANE_COLOR)){
            pane.setStyle(pane.getStyle().replace(DESACTIVATED_ITEM_PANE_COLOR, ACTIVATED_PANE_COLOR));
        }else if(colorAttribute.contains(DESACTIVATED_VOLVER_PANE_COLOR)) {
            pane.setStyle(pane.getStyle().replace(DESACTIVATED_VOLVER_PANE_COLOR, ACTIVATED_PANE_COLOR));
        }
    }

    private List<AnchorPane> getSceneElements() {
        List<AnchorPane> v1 = new ArrayList<>(vBox1.getChildren().stream()
                .filter(node -> node instanceof AnchorPane)
                .map(pane -> ((AnchorPane) pane).getChildren().get(0))
                .map(node -> (AnchorPane) node)
                .toList());
        List<AnchorPane> v2 = new ArrayList<>(vBox2.getChildren().stream()
                .filter(node -> node instanceof AnchorPane)
                .map(pane -> ((AnchorPane) pane).getChildren().get(0))
                .map(node -> (AnchorPane) node)
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
        int selectedPos = verifyPosition(pos);
        String itemElegidoNombre = "";
        if (selectedPos > -1 && selectedPos < CANTIDAD_DE_OPCIONES - 1) {
            itemElegidoNombre = JavafxController.getCdb().getJugadorActual().getItems().get(selectedPos).getNombre();
            System.out.println(itemElegidoNombre);
        }
        loadMessage(itemElegidoNombre);
        togglePane(getSceneElements().get(pos));
    }

    private void moveSelector(String tecla){
        AnchorPane currentElement = getSelectedSceneElement();
        if(currentElement == null) return;

        int actualPos = coordenadas(currentElement);
        int newPos;
        switch (tecla) {
            case UP_KEY ->
                newPos = verifyPosition(actualPos - 1);
            case DOWN_KEY ->
                newPos = verifyPosition(actualPos + 1);
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

    private int verifyPosition(int pos){
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
                //codigo que selecciona el item a usar
                Item itemElegido = JavafxController.getCdb().getJugadorActual().getItems().get(selectedPos);
                OpcionesEmergentes result = confirmarDecision(itemElegido.getNombre());
                if (result == OpcionesEmergentes.CONFIRMADA) {
                    try {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ElegirPokemonParaAplicarItem.fxml"));


                        Scene scene = new Scene(loader.load());
                        JavafxController.setScene(scene);

                        ElegirPokemonParaAplicarItemController controller = loader.getController();
                        controller.setItemElegido(itemElegido);
                    } catch (IOException e) {
                        System.out.println("Error en la carga de ElegirPokemonParaAplicarItem.fxml");
                    } catch (NullPointerException e) {
                        System.out.println("no hay controller");
                    }
                }
            } else {
                goBack();
            }
        }
    }

    private OpcionesEmergentes confirmarDecision(String nombreItem){
        Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION);
        Stage stage = (Stage) confirmation.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image(this.getClass().getResource("/imagenes/otros/app-logo.png").toString()));
        confirmation.setTitle("Confirmacion");
        confirmation.setHeaderText("Estas seguro que deseas elegir " + nombreItem + "?");

        Optional<ButtonType> result = confirmation.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            return OpcionesEmergentes.CONFIRMADA;
        }
        return OpcionesEmergentes.DENEGADA;
    }

    private void goBack() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/BattleScreen.fxml"));
            Scene scene = new Scene(loader.load());
            JavafxController.setScene(scene);
        } catch (IOException e) {
            System.out.println("Error en la carga de BattleScreen.fxml");
        }
    }

    private void loadMessage(String nombre) {
        String message = nombre;
        switch (nombre) {
            case "Pocion" -> message += " cura 20 PS. de tu Pokemon.";
            case "Mega Pocion" -> message += " cura 50 PS. de tu Pokemon.";
            case "Hiper Pocion" -> message += " cura 100 PS. de tu Pokemon.";
            case "Pocion Molesta Alumnos" -> message += " cura 33% de la vida maxima de tu Pokemon.";
            case "Ataque X" -> message += " aumenta 10% el ataque de tu Pokemon.";
            case "Defensa X" -> message += " aumenta 10% el defensa de tu Pokemon.";
            case "Revivir" -> message += " trae de vuelta al combate a un Pokemon muerto.";
            case "Cura Todo" -> message += " elimina todos los efectos negativos de tu Pokemon.";
            default -> message = "Desea volver atras?";
        }
        mensajeInferior.setText(message);
    }

    private List<Label> getLabelsCantidad() {
        ArrayList<Label> list = new ArrayList<>();
        list.add(cantidadPocion);
        list.add(cantidadHiperPocion);
        list.add(cantidadDefensaX);
        list.add(cantidadCuraTodo);
        list.add(cantidadMegaPocion);
        list.add(cantidadPocionMolestaAlumnos);
        list.add(cantidadAtaqueX);
        list.add(cantidadRevivir);
        return list;
    }

    private void loadItemsJugadorActual() {
        Jugador jugadorActual = JavafxController.getCdb().getJugadorActual();
        List<Item> items = jugadorActual.getItems();
        List<Label> labelsNombre = getLabelsCantidad();

        for (int i = 0; i < CANTIDAD_DE_OPCIONES - 1; i++) {
            int cant = items.get(i).getCantidad();
            labelsNombre.get(i).setText(Integer.toString(cant));

        }
    }
}
