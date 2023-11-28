package org.fiuba.algotres.controllers.javafx;

import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import org.fiuba.algotres.model.CampoDeBatalla;
import org.fiuba.algotres.model.Pokemon;
import org.fiuba.algotres.model.estado.Estado;
import org.fiuba.algotres.model.habilidad.Ataque;
import org.fiuba.algotres.model.habilidad.Habilidad;
import org.fiuba.algotres.utils.GeneradorDeMensajes;
import org.fiuba.algotres.utils.Sound;
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

    private final Sound changedOption = new Sound("src\\main\\resources\\audios\\OpcionMovida.wav");
    private final Sound selectedOption = new Sound("src\\main\\resources\\audios\\OpcionSeleccionada.wav");
    private final Sound backgroundMusic = new Sound("src\\main\\resources\\audios\\Megalovania.wav");

    private final double DEFAULT_LABEL_WIDTH = 120;

    private final String MENSAJE_PANTALLA_DEFAULT = "Elija una opción.";

    private BattleState state;

    private List<Habilidad> habilidades;
    private List<String> colaDeMensajes;

    @FXML
    private AnchorPane rootPane;
    @FXML
    private ImageView imagenClima;

    @FXML
    public Label nombreAtacante;
    @FXML
    public Label numeroVidaAtacante;
    @FXML
    public ProgressBar barraVidaAtacante;
    @FXML
    public ImageView imagenEstadoAtacante;
    @FXML
    private ImageView imagenAtacante;

    @FXML
    public Label nombreVictima;
    @FXML
    public Label numeroVidaVictima;
    @FXML
    public ProgressBar barraVidaVictima;
    @FXML
    public ImageView imagenEstadoVictima;
    @FXML
    private ImageView imagenVictima;

    @FXML
    public HBox informationBox;
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

        changedOption.playSound(false, 2.0f);
        setSelectedGridElement(newPos.posCol(), newPos.posRow());

        if(state == BattleState.SELECCION_HABILIDAD){
            loadHabilidadInfo();
        }
    }

    private void select() {
        BorderPane selectedElement = getSelectedGridElement();
        Coordinate selectedPos = null;
        if(selectedElement != null){
            selectedPos = new Coordinate(GridPane.getColumnIndex(selectedElement), GridPane.getRowIndex(selectedElement));
        }

        if(state == BattleState.SELECCION_ACCION) {
            selectedOption.playSound(false, 2.0f);
            if (selectedPos.posCol == 0 && selectedPos.posRow == 0) {
                state = BattleState.SELECCION_HABILIDAD;
                loadHabilidades();
                loadHabilidadInfo();
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
                accionarRendicion();
            }
        }else{
            if(state == BattleState.SELECCION_HABILIDAD){
                state = BattleState.ACCIONANDO;
                boolean llamadaPantallaPokemon = activarHabilidadSeleccionada();
                loadAcciones();
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
        renderHealth(false);
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
            renderImages();
            renderHealth(true);
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
            accionarRendicion();
        }else if(state == BattleState.SELECCION_HABILIDAD){
            state = BattleState.SELECCION_ACCION;
            loadAcciones();
            setSelectedGridElement(0, 0);
            pantallaMensaje.setText(MENSAJE_PANTALLA_DEFAULT);
        }
    }

    private void loadHabilidades(){
        ObservableList<Node> elementos = informationBox.getChildren();
        elementos.clear();
        elementos.addAll(optionGrid, pantallaMensaje);
        optionGrid.setPrefWidth(optionGrid.getPrefWidth() + 120);
        pantallaMensaje.setPrefWidth(pantallaMensaje.getPrefWidth() - 120);
        getGridElements().forEach(borderPane -> ((Label)borderPane.getCenter()).setPrefWidth(DEFAULT_LABEL_WIDTH + 20));

        habilidades.clear();
        for(int i = 0; i < getGridElements().size(); i++){
            Habilidad habilidad = JavafxController.getCdb().getJugadorActual().getPokemonActual().getHabilidades().get(i);
            ((Label)getGridElements().get(i).getCenter()).setText(habilidad.getNombre());
            habilidades.add(habilidad);
        }
    }

    private void loadAcciones(){
        ObservableList<Node> elementos = informationBox.getChildren();
        elementos.clear();
        elementos.addAll(pantallaMensaje, optionGrid);

        double totalWidth = optionGrid.getPrefWidth() + pantallaMensaje.getPrefWidth();
        optionGrid.setPrefWidth(totalWidth / 2);
        pantallaMensaje.setPrefWidth(totalWidth / 2);
        getGridElements().forEach(borderPane -> ((Label)borderPane.getCenter()).setPrefWidth(DEFAULT_LABEL_WIDTH));

        ((Label)getGridElements().get(0).getCenter()).setText("Habilidad");
        ((Label)getGridElements().get(1).getCenter()).setText("Cambiar");
        ((Label)getGridElements().get(2).getCenter()).setText("Items");
        ((Label)getGridElements().get(3).getCenter()).setText("Rendirse");
    }

    private void loadNextMessage() {
        pantallaMensaje.setText(colaDeMensajes.remove(0));
    }

    private void loadHabilidadInfo(){
        int posicionHabilidad = getGridElements().indexOf(getSelectedGridElement());
        Habilidad habilidad = habilidades.get(posicionHabilidad);
        String mensaje = "Usos: " + habilidad.getUsos() + "\n";
        if(habilidad instanceof Ataque){
            mensaje += "Tipo: " + ((Ataque) habilidad).getTipo();
        }
        pantallaMensaje.setText(mensaje);
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

    private void accionarRendicion(){
        Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION);
        confirmation.setTitle("Confirmation");
        confirmation.setHeaderText("Estas seguro que te querés rendir?");

        confirmation.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                JavafxController.getCdb().getJugadorActual().rendirse();
                // Llamar a scene de fin de juego
            }
        });
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

    private void renderImages(){
        CampoDeBatalla cdb = JavafxController.getCdb();
        imagenClima.setImage(new Image(
                getClass().getResourceAsStream("/imagenes/climas/" + capitalizar(cdb.getClima().getNombre()) + ".gif")
        ));

        numeroVidaAtacante.setText(
                cdb.getJugadorActual().getPokemonActual().getVidaActual() + "/" +
                cdb.getJugadorActual().getPokemonActual().getVidaMaxima()
        );
        barraVidaAtacante.setProgress((double) cdb.getJugadorActual().getPokemonActual().getVidaActual() /cdb.getJugadorActual().getPokemonActual().getVidaMaxima());
        if(!cdb.getJugadorActual().getPokemonActual().getEstados().isEmpty()){
            imagenEstadoAtacante.setImage(new Image(
                    getClass().getResourceAsStream("/imagenes/estados/" + capitalizar(cdb.getJugadorActual().getPokemonActual().getEstados().get(0).getNombre()) + ".gif")
            ));
        }else{
            imagenEstadoAtacante.setImage(new Image(
                    getClass().getResourceAsStream("/imagenes/estados/SinEstado.gif")
            ));
        }
        imagenAtacante.setImage(new Image(
                getClass().getResourceAsStream("/imagenes/pokemons/" + capitalizar(cdb.getJugadorActual().getPokemonActual().getNombre()) + "-back.gif")
        ));

        numeroVidaVictima.setText(
                cdb.getJugadores()[cdb.getSiguienteTurno()].getPokemonActual().getVidaActual() + "/" +
                cdb.getJugadores()[cdb.getSiguienteTurno()].getPokemonActual().getVidaMaxima()
        );
        barraVidaVictima.setProgress((double) cdb.getJugadores()[cdb.getSiguienteTurno()].getPokemonActual().getVidaActual() /cdb.getJugadores()[cdb.getSiguienteTurno()].getPokemonActual().getVidaMaxima());
        if(!cdb.getJugadores()[cdb.getSiguienteTurno()].getPokemonActual().getEstados().isEmpty()){
            imagenEstadoVictima.setImage(new Image(
                    getClass().getResourceAsStream("/imagenes/estados/" + capitalizar(cdb.getJugadores()[cdb.getSiguienteTurno()].getPokemonActual().getEstados().get(0).getNombre()) + ".gif")
            ));
        }else{
            imagenEstadoVictima.setImage(new Image(
                    getClass().getResourceAsStream("/imagenes/estados/SinEstado.gif")
            ));
        }
        imagenVictima.setImage(new Image(
                getClass().getResourceAsStream("/imagenes/pokemons/" + capitalizar(cdb.getJugadores()[cdb.getSiguienteTurno()].getPokemonActual().getNombre()) + "-front.gif")
        ));
    }

    private void renderHealth(boolean transicionRapida){
        nombreAtacante.setText(JavafxController.getCdb().getJugadorActual().getPokemonActual().getNombre());
        nombreVictima.setText(JavafxController.getCdb().getJugadores()[JavafxController.getCdb().getSiguienteTurno()].getPokemonActual().getNombre());

        numeroVidaAtacante.setText(
                JavafxController.getCdb().getJugadorActual().getPokemonActual().getVidaActual() + "/" +
                JavafxController.getCdb().getJugadorActual().getPokemonActual().getVidaMaxima()
        );
        numeroVidaVictima.setText(
                JavafxController.getCdb().getJugadores()[JavafxController.getCdb().getSiguienteTurno()].getPokemonActual().getVidaActual() + "/" +
                JavafxController.getCdb().getJugadores()[JavafxController.getCdb().getSiguienteTurno()].getPokemonActual().getVidaMaxima()
        );

        double vidaFinalAtacante = (double) JavafxController.getCdb().getJugadorActual().getPokemonActual().getVidaActual() /JavafxController.getCdb().getJugadorActual().getPokemonActual().getVidaMaxima();
        double vidaFinalVictima = (double) JavafxController.getCdb().getJugadores()[JavafxController.getCdb().getSiguienteTurno()].getPokemonActual().getVidaActual() /JavafxController.getCdb().getJugadores()[JavafxController.getCdb().getSiguienteTurno()].getPokemonActual().getVidaMaxima();

        if(transicionRapida){
            barraVidaAtacante.setProgress(vidaFinalAtacante);
            barraVidaVictima.setProgress(vidaFinalVictima);
        }

        Timeline timelineAtacante = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(barraVidaAtacante.progressProperty(), barraVidaAtacante.getProgress())),
                new KeyFrame(Duration.seconds(1), new KeyValue(barraVidaAtacante.progressProperty(), vidaFinalAtacante))
        );
        Timeline timelineVictima = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(barraVidaVictima.progressProperty(), barraVidaVictima.getProgress())),
                new KeyFrame(Duration.seconds(1), new KeyValue(barraVidaVictima.progressProperty(), vidaFinalVictima))
        );
        timelineAtacante.play();
        timelineVictima.play();
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        backgroundMusic.playSound(true, -10.0f);
        state = BattleState.SELECCION_ACCION;
        habilidades = new ArrayList<>();
        colaDeMensajes = new ArrayList<>();
        renderImages();
        renderHealth(true);
        System.out.println("Inicializado!");
    }

//    public void callPokemonScene(){
//        try {
//            Scene scene = new Scene(new FXMLLoader(getClass().getResource("/fxml/BattleScreen.fxml")).load());
//        }catch(IOException e){
//            throw new RuntimeException("Algo anduvo mal con los archivos FXMLs");
//        }
//    }

}
