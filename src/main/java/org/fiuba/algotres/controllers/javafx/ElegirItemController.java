package org.fiuba.algotres.controllers.javafx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import lombok.Getter;
import lombok.Setter;
import org.fiuba.algotres.JuegoJavafx;
import org.fiuba.algotres.model.Jugador;
import org.fiuba.algotres.model.item.Item;
import org.fiuba.algotres.utils.Sound;
import org.fiuba.algotres.utils.enums.BattleState;
import org.fiuba.algotres.utils.enums.OpcionesEmergentes;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class ElegirItemController extends ItemPokemonController implements Initializable {
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
    private static final Sound changedOption = new Sound("src\\main\\resources\\audios\\OpcionMovida.wav");
    private static final Sound selectedOption = new Sound("src\\main\\resources\\audios\\OpcionSeleccionada.wav");
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
            case ESCAPE_KEY -> goBack("/fxml/batalla/BattleScreen.fxml");
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
            togglePane(previousElement, ACTIVATED_PANE_COLOR, DESACTIVATED_VOLVER_PANE_COLOR, DESACTIVATED_ITEM_PANE_COLOR);
        }
        int selectedPos = verifyPosition(pos, CANTIDAD_DE_OPCIONES);
        String itemElegidoNombre = "Boton Volver";
        if (selectedPos > -1 && selectedPos < CANTIDAD_DE_OPCIONES - 1) {
            itemElegidoNombre = JuegoJavafx.getCdb().getJugadorActual().getItems().get(selectedPos).getNombre();
        }
        loadMessage(itemElegidoNombre);
        togglePane(getSceneElements().get(pos), ACTIVATED_PANE_COLOR, DESACTIVATED_VOLVER_PANE_COLOR, DESACTIVATED_ITEM_PANE_COLOR);
    }

    private void moveSelector(String tecla){
        AnchorPane currentElement = getSelectedSceneElement();
        if(currentElement == null) return;

        int actualPos = coordenadas(currentElement);
        int newPos;
        switch (tecla) {
            case UP_KEY ->
                newPos = verifyPosition(actualPos - 1, CANTIDAD_DE_OPCIONES);
            case DOWN_KEY ->
                newPos = verifyPosition(actualPos + 1, CANTIDAD_DE_OPCIONES);
            case RIGHT_KEY -> {
                if (actualPos == CANTIDAD_DE_OPCIONES - 2) {
                    newPos = verifyPosition(actualPos + 1, CANTIDAD_DE_OPCIONES);
                } else {
                    newPos = verifyPosition(actualPos + OPCIONES_POR_COLUMNA, CANTIDAD_DE_OPCIONES);
                }
            }
            case LEFT_KEY -> {
                if (actualPos == CANTIDAD_DE_OPCIONES - 1) {
                    newPos = verifyPosition(actualPos - 1, CANTIDAD_DE_OPCIONES);
                } else {
                    newPos = verifyPosition(actualPos - OPCIONES_POR_COLUMNA, CANTIDAD_DE_OPCIONES);
                }
            }
            default -> newPos = -1;
        };

        if(newPos == -1){
            return;
        }

        changedOption.playSound(false, 2.0f);
        setSelectedSceneElement(newPos);
    }

    private int coordenadas(AnchorPane element) {
        return getSceneElements().indexOf(element);
    }

    private void select() {
        AnchorPane selectedElement = getSelectedSceneElement();
        String selectedElementId = selectedElement.getId();
        int selectedPos = verifyPosition(coordenadas(selectedElement), CANTIDAD_DE_OPCIONES);
        if (selectedPos != -1) {
            if (!Objects.equals(selectedElementId, "botonVolver")) {
                //codigo que selecciona el item a usar
                selectedOption.playSound(false, 2.0f);
                Item itemElegido = JuegoJavafx.getCdb().getJugadorActual().getItems().get(selectedPos);
                OpcionesEmergentes result = confirmarDecision("Estas seguro que deseas elegir " + itemElegido.getNombre() + "?");
                if (result == OpcionesEmergentes.CONFIRMADA) {
                    try {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ElegirPokemonParaAplicarItem.fxml"));
                        Scene scene = new Scene(loader.load());
                        JuegoJavafx.setScene(scene, true);
                        ElegirPokemonParaAplicarItemController controller = loader.getController();
                        controller.setItemElegido(itemElegido);
                    } catch (IOException e) {
                        System.out.println("Error en la carga de ElegirPokemonParaAplicarItem.fxml");
                    }
                }
            } else {
                goBack("/fxml/batalla/BattleScreen.fxml");
            }
        }
    }

    private HashMap<String, String> getMessages() {
        return new HashMap<>(){{
            put("Pocion", "Pocion cura 20 PS. de tu Pokemon.");
            put("Mega Pocion", "Mega Pocion cura 50 PS. de tu Pokemon.");
            put("Hiper Pocion", "Hiper Pocion cura 100 PS. de tu Pokemon.");
            put("Pocion Molesta Alumnos", "Pocion Molesta Alumnos cura 33% de la vida maxima de tu Pokemon.");
            put("Ataque X", "Ataque X aumenta 10% el ataque de tu Pokemon.");
            put("Defensa X", "Defensa X aumenta 10% el defensa de tu Pokemon.");
            put("Revivir", "Revivir trae de vuelta al combate a un Pokemon muerto.");
            put("Cura Todo", "Cura Todo elimina todos los efectos negativos de tu Pokemon.");
        }};
    }

    private void loadMessage(String nombre) {
        HashMap<String, String> messages = getMessages();
        mensajeInferior.setText(messages.getOrDefault(nombre, "Desea volver atras?"));
    }

    private List<Label> getData() {
        return new ArrayList<>(List.of(
                cantidadPocion,
                cantidadHiperPocion,
                cantidadDefensaX,
                cantidadCuraTodo,
                cantidadMegaPocion,
                cantidadPocionMolestaAlumnos,
                cantidadAtaqueX,
                cantidadRevivir));
    }

    private void loadItemsJugadorActual() {
        Jugador jugadorActual = JuegoJavafx.getCdb().getJugadorActual();
        List<Item> items = jugadorActual.getItems();
        List<Label> dataCantidades = getData();

        for (int i = 0; i < CANTIDAD_DE_OPCIONES - 1; i++) {
            int cant = items.get(i).getCantidad();
            dataCantidades.get(i).setText(Integer.toString(cant));
        }
    }
}
