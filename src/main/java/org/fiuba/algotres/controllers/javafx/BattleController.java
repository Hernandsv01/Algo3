package org.fiuba.algotres.controllers.javafx;

import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import org.fiuba.algotres.model.Pokemon;
import org.fiuba.algotres.model.estado.Estado;
import org.fiuba.algotres.model.habilidad.Habilidad;
import org.fiuba.algotres.utils.GeneradorDeMensajes;
import org.fiuba.algotres.utils.enums.BattleState;

import java.net.URL;
import java.util.*;

public class BattleController implements Initializable{
    private static final String UP_KEY = "UP";
    private static final String DOWN_KEY = "DOWN";
    private static final String RIGHT_KEY = "RIGHT";
    private static final String LEFT_KEY = "LEFT";
    private static final String ENTER_KEY = "ENTER";
    private static final String ESCAPE_KEY = "ESCAPE";
    private static final String ACTIVATED_LABEL_COLOR = "red";
    private static final String DEACTIVATED_LABEL_COLOR = "white";
    private static BattleState state;
    private List<Habilidad> habilidades;
    private List<String> colaDeMensajes;

    @FXML
    private AnchorPane rootPane;
    @FXML
    private ImageView imagenClima;
    @FXML
    private ImageView imagenAtacante;
    @FXML
    private ImageView imagenVictima;
    @FXML
    private GridPane optionGrid;
    @FXML
    private TextArea pantallaMensaje;
    @FXML
    private Rectangle blackScreen;

    public static void toggleLabel(Label label){
        String colorAttribute = Arrays.stream(label.getStyle().split(";")).filter(s -> s.contains("-fx-border-color")).toList().get(0);
        if(colorAttribute.contains(ACTIVATED_LABEL_COLOR)){
            label.setStyle(label.getStyle().replace(ACTIVATED_LABEL_COLOR, DEACTIVATED_LABEL_COLOR));
        }else if(colorAttribute.contains(DEACTIVATED_LABEL_COLOR)){
            label.setStyle(label.getStyle().replace(DEACTIVATED_LABEL_COLOR, ACTIVATED_LABEL_COLOR));
        }
    }

    private static Coordinate verifyPosition(int column, int row){
        if((column >= 0 && column < 2) && (row >= 0 && row < 2)){
            return new Coordinate(column, row);
        }
        return null;
    }

    @FXML
    public void onKeyTyped(KeyEvent event){
        String tecla = event.getCode().toString();
        System.out.println("Key pressed: " + tecla);
        System.out.println("Clima actual: " + JavafxController.getCdb().getClima().getNombre());

        switch (tecla) {
            case UP_KEY, DOWN_KEY, RIGHT_KEY, LEFT_KEY -> moveSelector(tecla);
            case ENTER_KEY -> select();
            case ESCAPE_KEY -> goBack();
        }

    }

    private void moveSelector(String tecla){
        BorderPane currentElement = getSelectedGridElement();
        if(currentElement == null) return;
        Coordinate currentPos = new Coordinate(GridPane.getColumnIndex(currentElement), GridPane.getRowIndex(currentElement));

        Coordinate newPos = switch (tecla) {
            case UP_KEY -> verifyPosition(currentPos.posCol, currentPos.posRow - 1);
            case DOWN_KEY -> verifyPosition(currentPos.posCol, currentPos.posRow + 1);
            case RIGHT_KEY -> verifyPosition(currentPos.posCol + 1, currentPos.posRow);
            case LEFT_KEY -> verifyPosition(currentPos.posCol - 1, currentPos.posRow);
            default -> null;
        };

        if(newPos == null){
            return;
        }

        setSelectedGridElement(newPos.posCol(), newPos.posRow());
    }

    private void select() {
        BorderPane selectedElement = getSelectedGridElement();
        Coordinate selectedPos = null;
        if(selectedElement != null){
            selectedPos = new Coordinate(GridPane.getColumnIndex(selectedElement), GridPane.getRowIndex(selectedElement));
        }

        if(state == BattleState.SELECCION_ACCION) {
            if (selectedPos.posCol == 0 && selectedPos.posRow == 0) {
                state = BattleState.SELECCION_HABILIDAD;
                loadHabilidades();
            } else if (selectedPos.posCol == 1 && selectedPos.posRow == 0) {
                System.out.println("Items todavía no fue implementado");
//                state = BattleState.SELECCION_ITEM;
                // Llamar a scene de items
                // Comenzar cola de mensajes
            } else if (selectedPos.posCol == 0 && selectedPos.posRow == 1) {
                System.out.println("Cambiar todavía no fue implementado");
//                state = BattleState.SELECCION_POKEMON;
                // Llamar a scene de selección de pokemons
                // Comenzar cola de mensajes
            } else if (selectedPos.posCol == 1 && selectedPos.posRow == 1) {
                System.out.println("Rendirse todavía no fue implementado");
//                state = BattleState.CONFIRMACION_RENDICION;
                // Crear popup preguntando si está seguro
            }
        }else{
            if(state == BattleState.SELECCION_HABILIDAD){
                state = BattleState.ACCIONANDO;
                boolean llamadaPantallaPokemon = activarHabilidadSeleccionada();
                disableGrid();
                loadNextMessage();
                if(llamadaPantallaPokemon){
                    // Llamar pagina pokemon
                }
            }else if(state == BattleState.CONFIRMACION_RENDICION){
                // Verificar si popup fue confirmado o negado
                //      Negado se vuelve al estado de seleccion de opción
                //      Aceptado se rinde y se llama a scene de victoria

            }else if(state == BattleState.ACCIONANDO){
                if(!colaDeMensajes.isEmpty()){
                    loadNextMessage();
                }else{
                    state = BattleState.SELECCION_ACCION;
                    prepararSiguienteTurno();
                }
            }
        }
    }

    private void prepararSiguienteTurno() {
        pantallaMensaje.setText("");

        FadeTransition fadeIn = new FadeTransition(Duration.seconds(1), blackScreen);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);
        FadeTransition fadeOut = new FadeTransition(Duration.seconds(1), blackScreen);
        fadeOut.setFromValue(1.0);
        fadeOut.setToValue(0.0);

        fadeIn.setOnFinished(event -> {
            JavafxController.getCdb().setSiguienteTurno();
            render();
            fadeOut.play();
        });
        fadeIn.play();

        fadeOut.setOnFinished(event -> {
            loadAcciones();
            pantallaMensaje.setText("Elija una opción");
            setSelectedGridElement(0, 0);
        });
    }

    /**
     *
     * @return true si hay que llamar a la pantalla de selección pokemon
     */
    private boolean activarHabilidadSeleccionada(){
        // Estados
        boolean puedeAccionar = true;
        Estado estadoInhabilitante = null;
        List<Estado> estados = JavafxController.getCdb().getJugadorActual().getPokemonActual().getEstados();
        for (Estado estado : estados) {
            puedeAccionar = estado.accionar();
            if (!puedeAccionar && estadoInhabilitante == null) {
                estadoInhabilitante = estado;
            }
        }
        if(!JavafxController.getCdb().getJugadorActual().getPokemonActual().estaVivo()){
            colaDeMensajes.add(GeneradorDeMensajes.generarMensajeMuertePrematura(JavafxController.getCdb().getJugadorActual().getPokemonActual()));
            return true;
        }

        // Climas
        JavafxController.getCdb().getClima().aplicarEfectos(JavafxController.getCdb().getJugadorActual().getPokemonActual());
        String mensajeClima = GeneradorDeMensajes.generarMensajeClima(JavafxController.getCdb().getClima());
        if(mensajeClima != null){
            colaDeMensajes.add(mensajeClima);
        }
        if(!JavafxController.getCdb().getJugadorActual().getPokemonActual().estaVivo()){
            colaDeMensajes.add(GeneradorDeMensajes.generarMensajeMuertePrematura(JavafxController.getCdb().getJugadorActual().getPokemonActual()));
            return true;
        }

        // Accionar
        if(puedeAccionar){
            accionarHabilidad();
        }else{
            colaDeMensajes.add(GeneradorDeMensajes.generarMensajeEstado(estadoInhabilitante, JavafxController.getCdb().getJugadorActual().getPokemonActual(), true));
        }

        return false;
    }

    private void goBack() {
        if(state == BattleState.SELECCION_ACCION || state == BattleState.ACCIONANDO) {
            // Opción salir al menú
        }else if(state == BattleState.SELECCION_HABILIDAD || state == BattleState.CONFIRMACION_RENDICION){
            state = BattleState.SELECCION_ACCION;
            loadAcciones();
            setSelectedGridElement(0, 0);
        }
    }

    private void loadHabilidades(){
        habilidades.clear();
        for(int i = 0; i < getGridElements().size(); i++){
            Habilidad habilidad = JavafxController.getCdb().getJugadorActual().getPokemonActual().getHabilidades().get(i);
            ((Label)getGridElements().get(i).getCenter()).setText(habilidad.getNombre());
            habilidades.add(habilidad);
        }
    }

    private void loadAcciones(){
        ((Label)getGridElements().get(0).getCenter()).setText("Habilidad");
        ((Label)getGridElements().get(1).getCenter()).setText("Cambiar");
        ((Label)getGridElements().get(2).getCenter()).setText("Items");
        ((Label)getGridElements().get(3).getCenter()).setText("Rendirse");
    }

    private void accionarHabilidad(){
        int posicionHabilidad = getGridElements().indexOf(getSelectedGridElement());
        if(posicionHabilidad == -1) return;
        Habilidad habilidad = habilidades.get(posicionHabilidad);
        Pokemon atacante = JavafxController.getCdb().getJugadorActual().getPokemonActual();
        Pokemon victima = JavafxController.getCdb().getJugadores()[JavafxController.getCdb().getSiguienteTurno()].getPokemonActual();

        habilidad.accionarHabilidad(atacante, victima);
        colaDeMensajes.add(GeneradorDeMensajes.generarMensajeEfectoHabilidad(habilidad, atacante, victima));
    }

    private List<BorderPane> getGridElements(){
        return optionGrid.getChildren().stream()
                        .filter(node -> node instanceof BorderPane)
                        .map(node -> (BorderPane)node)
                        .toList();
    }

    private BorderPane getSelectedGridElement(){
        return getGridElements().stream()
                .filter(borderPane -> borderPane.getCenter().getStyle().contains("-fx-border-color: red"))
                .findFirst().orElse(null);
    }

    private void setSelectedGridElement(int col, int row){
        BorderPane previousElement = getSelectedGridElement();
        if(previousElement != null) {
            toggleLabel((Label)previousElement.getCenter());
        }

        toggleLabel((Label)getGridElements().stream()
                .filter(borderPane -> GridPane.getRowIndex(borderPane) == row && GridPane.getColumnIndex(borderPane) == col)
                .toList().get(0).getCenter());
    }

    private void disableGrid(){
        toggleLabel((Label)getSelectedGridElement().getCenter());
        getGridElements().forEach(borderPane -> ((Label)borderPane.getCenter()).setText(""));
    }

    private void loadNextMessage() {
        pantallaMensaje.setText(colaDeMensajes.remove(0));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        state = BattleState.SELECCION_ACCION;
        habilidades = new ArrayList<>();
        colaDeMensajes = new ArrayList<>();
        render();
        System.out.println("Inicializado!");
    }

    private void render(){
        imagenClima.setImage(new Image(
                getClass().getResourceAsStream("/imagenes/climas/" + capitalizar(JavafxController.getCdb().getClima().getNombre()) + ".gif")
        ));
        imagenAtacante.setImage(new Image(
                getClass().getResourceAsStream("/imagenes/pokemons/" + capitalizar(JavafxController.getCdb().getJugadorActual().getPokemonActual().getNombre()) + "-back.gif")
        ));
        imagenVictima.setImage(new Image(
                getClass().getResourceAsStream("/imagenes/pokemons/" + capitalizar(JavafxController.getCdb().getJugadores()[JavafxController.getCdb().getSiguienteTurno()].getPokemonActual().getNombre()) + "-front.gif")
        ));
    }

    private static String capitalizar(String string){
        return string.substring(0, 1).toUpperCase() + string.substring(1);
    }

    private record Coordinate(int posCol, int posRow) {
    }

    private void accionarItem() {

    }

    private void accionarCambioPokemon() {

    }
}
