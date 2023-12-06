package org.fiuba.algotres.controllers.javafx;

import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.fiuba.algotres.JuegoJavafx;
import org.fiuba.algotres.model.CampoDeBatalla;
import org.fiuba.algotres.model.Jugador;
import org.fiuba.algotres.model.Pokemon;
import org.fiuba.algotres.model.estado.Estado;
import org.fiuba.algotres.model.habilidad.Ataque;
import org.fiuba.algotres.model.habilidad.Habilidad;
import org.fiuba.algotres.utils.GeneradorDeMensajes;
import org.fiuba.algotres.utils.ImageLoader;
import org.fiuba.algotres.utils.Sound;
import org.fiuba.algotres.utils.enums.BattleState;
import org.fiuba.algotres.utils.enums.CambiarPokemonState;
import org.fiuba.algotres.utils.enums.DefaultImageType;

import java.io.IOException;
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

    private static final Sound changedOption = new Sound("src\\main\\resources\\audios\\OpcionMovida.wav");
    private static final Sound selectedOption = new Sound("src\\main\\resources\\audios\\OpcionSeleccionada.wav");
    private static final Sound backgroundMusic = new Sound("src\\main\\resources\\audios\\MusicaBatalla.wav");
    private static final Sound sonidaAtaque = new Sound("src\\main\\resources\\audios\\SonidoAtaque.wav");

    private final double DEFAULT_LABEL_WIDTH = 120;

    private final String MENSAJE_PANTALLA_DEFAULT = "Elija una opción.";

    private static BattleState state = BattleState.NO_EMPEZADA;
    private List<Habilidad> habilidades;
    private static List<String> colaDeMensajes;

    @FXML
    private AnchorPane rootPane;
    @FXML
    private ImageView imagenClima;

    // Items atacante
    @FXML
    public Label nombreAtacante;
    @FXML
    public Label numeroVidaAtacante;
    @FXML
    public ProgressBar barraVidaAtacante;
    @FXML
    public ImageView imagenAtacanteParalizado;
    @FXML
    public ImageView imagenAtacanteDormido;
    @FXML
    public ImageView imagenAtacanteEnvenenado;
    @FXML
    public ImageView imagenAtacanteConfuso;
    @FXML
    private ImageView imagenAtacante;
    private final List<ImageView> pokebolasAtacante = new ArrayList<>();
    @FXML
    public ImageView pokebolaAtacanteSuplente1;
    @FXML
    public ImageView pokebolaAtacanteSuplente2;
    @FXML
    public ImageView pokebolaAtacanteSuplente3;
    @FXML
    public ImageView pokebolaAtacanteSuplente4;
    @FXML
    public ImageView pokebolaAtacanteSuplente5;

    // Items victima
    @FXML
    public Label nombreVictima;
    @FXML
    public Label numeroVidaVictima;
    @FXML
    public ProgressBar barraVidaVictima;
    @FXML
    public ImageView imagenVictimaConfuso;
    @FXML
    public ImageView imagenVictimaEnvenenado;
    @FXML
    public ImageView imagenVictimaDormido;
    @FXML
    public ImageView imagenVictimaParalizado;
    @FXML
    private ImageView imagenVictima;
    private final List<ImageView> pokebolasVictima = new ArrayList<>();
    @FXML
    public ImageView pokebolaVictimaSuplente1;
    @FXML
    public ImageView pokebolaVictimaSuplente2;
    @FXML
    public ImageView pokebolaVictimaSuplente3;
    @FXML
    public ImageView pokebolaVictimaSuplente4;
    @FXML
    public ImageView pokebolaVictimaSuplente5;

    // Interacción usuario
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
        System.out.println("Clima actual: " + JuegoJavafx.getCdb().getClima().getNombre());

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
                callItemScene();
            } else if (selectedPos.posCol == 0 && selectedPos.posRow == 1) {
                callPokemonScene(CambiarPokemonState.CAMBIO_POKEMON_POR_ELECCION, JuegoJavafx.getCdb().getJugadorActual());
            } else if (selectedPos.posCol == 1 && selectedPos.posRow == 1) {
                accionarRendicion();
            }
        }else{
            if(state == BattleState.SELECCION_HABILIDAD){
                activarHabilidadSeleccionada();
                accionar();
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
        verificarVictoria();
        if(state == BattleState.TERMINADA){
            return;
        }
        verificarMuertePokemon();
        pantallaMensaje.setText("");

        FadeTransition fadeIn = new FadeTransition(Duration.seconds(1), blackScreen);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);
        FadeTransition fadeOut = new FadeTransition(Duration.seconds(1), blackScreen);
        fadeOut.setFromValue(1.0);
        fadeOut.setToValue(0.0);

        fadeIn.setOnFinished(event -> {
            JuegoJavafx.getCdb().setSiguienteTurno();
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

    public void verificarVictoria(){
        if(JuegoJavafx.getCdb().getGanador() != -1){
            state = BattleState.TERMINADA;
            callVictoryScene();
        }
    }

    public void verificarMuertePokemon(){
        if(!JuegoJavafx.getCdb().getJugadorActual().getPokemonActual().estaVivo()){
            callPokemonScene(CambiarPokemonState.CAMBIO_POKEMON_MUERTO, JuegoJavafx.getCdb().getJugadorActual());
        }else if(!JuegoJavafx.getCdb().getJugadores()[JuegoJavafx.getCdb().getSiguienteTurno()].getPokemonActual().estaVivo()){
            callPokemonScene(CambiarPokemonState.CAMBIO_POKEMON_MUERTO, JuegoJavafx.getCdb().getJugadores()[JuegoJavafx.getCdb().getSiguienteTurno()]);
        }
    }

    private void activarHabilidadSeleccionada(){
        // Estados
        boolean puedeAccionar = true;
        Estado estadoInhabilitante = null;
        List<Estado> estados = JuegoJavafx.getCdb().getJugadorActual().getPokemonActual().getEstados();
        for (Estado estado : estados) {
            puedeAccionar = estado.accionar();
            if (!puedeAccionar && estadoInhabilitante == null) {
                estadoInhabilitante = estado;
            }
        }
        if(!JuegoJavafx.getCdb().getJugadorActual().getPokemonActual().estaVivo()){
            colaDeMensajes.add(GeneradorDeMensajes.generarMensajeMuertePrematura(JuegoJavafx.getCdb().getJugadorActual().getPokemonActual()));
            return;
        }

        // Climas
        JuegoJavafx.getCdb().getClima().aplicarEfectos(JuegoJavafx.getCdb().getJugadorActual().getPokemonActual());
        String mensajeClima = GeneradorDeMensajes.generarMensajeClima(JuegoJavafx.getCdb().getClima());
        if(mensajeClima != null){
            colaDeMensajes.add(mensajeClima);
        }
        if(!JuegoJavafx.getCdb().getJugadorActual().getPokemonActual().estaVivo()){
            colaDeMensajes.add(GeneradorDeMensajes.generarMensajeMuertePrematura(JuegoJavafx.getCdb().getJugadorActual().getPokemonActual()));
            return;
        }

        // Accionar
        if(puedeAccionar){
            accionarHabilidad();
        }else{
            colaDeMensajes.add(GeneradorDeMensajes.generarMensajeEstado(estadoInhabilitante, JuegoJavafx.getCdb().getJugadorActual().getPokemonActual(), true));
        }

        if(!JuegoJavafx.getCdb().getJugadores()[JuegoJavafx.getCdb().getSiguienteTurno()].getPokemonActual().estaVivo()){
            colaDeMensajes.add(GeneradorDeMensajes.generarMensajeMuerte(JuegoJavafx.getCdb().getJugadores()[JuegoJavafx.getCdb().getSiguienteTurno()].getPokemonActual()));
        }
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
            Habilidad habilidad = JuegoJavafx.getCdb().getJugadorActual().getPokemonActual().getHabilidades().get(i);
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
        Pokemon atacante = JuegoJavafx.getCdb().getJugadorActual().getPokemonActual();
        Pokemon victima = JuegoJavafx.getCdb().getJugadores()[JuegoJavafx.getCdb().getSiguienteTurno()].getPokemonActual();

        habilidad.accionarHabilidad(atacante, victima);
        sonidaAtaque.playSound(false, 0);
        colaDeMensajes.add(GeneradorDeMensajes.generarMensajeEfectoHabilidad(habilidad, atacante, victima));
    }

    private void accionarRendicion(){
        Alert confirmacion = new Alert(Alert.AlertType.CONFIRMATION);
        confirmacion.setTitle("Confirmacion");
        confirmacion.setHeaderText("Estas seguro que te querés rendir?");
        Stage stage = (Stage) confirmacion.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image(this.getClass().getResource("/imagenes/otros/app-logo.png").toString()));

        confirmacion.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                JuegoJavafx.getCdb().getJugadorActual().rendirse();
                callVictoryScene();
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
        CampoDeBatalla cdb = JuegoJavafx.getCdb();
        imagenClima.setImage(ImageLoader.getJavafxImage("/imagenes/climas/" + capitalizar(cdb.getClima().getNombre()) + ".gif", DefaultImageType.CLIMA));

        // IMAGENES ATACANTE
        numeroVidaAtacante.setText(
                cdb.getJugadorActual().getPokemonActual().getVidaActual() + "/" +
                cdb.getJugadorActual().getPokemonActual().getVidaMaxima()
        );
        barraVidaAtacante.setProgress((double) cdb.getJugadorActual().getPokemonActual().getVidaActual() /cdb.getJugadorActual().getPokemonActual().getVidaMaxima());
        // Estados atacante
        if (cdb.getJugadorActual().getPokemonActual().getEstados().stream().filter(estado -> estado.getNombre().equals("paralizado")).toList().isEmpty()) {
            imagenAtacanteParalizado.setImage(ImageLoader.getJavafxImage("/imagenes/estados/SinEstado.gif", DefaultImageType.ESTADO));
        } else {
            imagenAtacanteParalizado.setImage(ImageLoader.getJavafxImage("/imagenes/estados/Paralizado.gif", DefaultImageType.ESTADO));
        }
        if (cdb.getJugadorActual().getPokemonActual().getEstados().stream().filter(estado -> estado.getNombre().equals("envenenado")).toList().isEmpty()) {
            imagenAtacanteEnvenenado.setImage(ImageLoader.getJavafxImage("/imagenes/estados/SinEstado.gif", DefaultImageType.ESTADO));
        } else {
            imagenAtacanteEnvenenado.setImage(ImageLoader.getJavafxImage("/imagenes/estados/Envenenado.gif", DefaultImageType.ESTADO));
        }
        if (cdb.getJugadorActual().getPokemonActual().getEstados().stream().filter(estado -> estado.getNombre().equals("dormido")).toList().isEmpty()) {
            imagenAtacanteDormido.setImage(ImageLoader.getJavafxImage("/imagenes/estados/SinEstado.gif", DefaultImageType.ESTADO));
        } else {
            imagenAtacanteDormido.setImage(ImageLoader.getJavafxImage("/imagenes/estados/Dormido.gif", DefaultImageType.ESTADO));
        }
        if (cdb.getJugadorActual().getPokemonActual().getEstados().stream().filter(estado -> estado.getNombre().equals("confuso")).toList().isEmpty()) {
            imagenAtacanteConfuso.setImage(ImageLoader.getJavafxImage("/imagenes/estados/SinEstado.gif", DefaultImageType.ESTADO));
        } else {
            imagenAtacanteConfuso.setImage(ImageLoader.getJavafxImage("/imagenes/estados/Confuso.gif", DefaultImageType.ESTADO));
        }
        imagenAtacante.setImage(ImageLoader.getJavafxImage("/imagenes/pokemons/" + capitalizar(cdb.getJugadorActual().getPokemonActual().getNombre()) + "-back.gif", DefaultImageType.POKEMON));

        // IMAGENES VICTIMA
        numeroVidaVictima.setText(
                cdb.getJugadores()[cdb.getSiguienteTurno()].getPokemonActual().getVidaActual() + "/" +
                cdb.getJugadores()[cdb.getSiguienteTurno()].getPokemonActual().getVidaMaxima()
        );
        barraVidaVictima.setProgress((double) cdb.getJugadores()[cdb.getSiguienteTurno()].getPokemonActual().getVidaActual() /cdb.getJugadores()[cdb.getSiguienteTurno()].getPokemonActual().getVidaMaxima());
        // Estados victima
        if (cdb.getJugadores()[cdb.getSiguienteTurno()].getPokemonActual().getEstados().stream().filter(estado -> estado.getNombre().equals("paralizado")).toList().isEmpty()) {
            imagenVictimaParalizado.setImage(ImageLoader.getJavafxImage("/imagenes/estados/SinEstado.gif", DefaultImageType.ESTADO));
        } else {
            imagenVictimaParalizado.setImage(ImageLoader.getJavafxImage("/imagenes/estados/Paralizado.gif", DefaultImageType.ESTADO));
        }
        if (cdb.getJugadores()[cdb.getSiguienteTurno()].getPokemonActual().getEstados().stream().filter(estado -> estado.getNombre().equals("envenenado")).toList().isEmpty()) {
            imagenVictimaEnvenenado.setImage(ImageLoader.getJavafxImage("/imagenes/estados/SinEstado.gif", DefaultImageType.ESTADO));
        } else {
            imagenVictimaEnvenenado.setImage(ImageLoader.getJavafxImage("/imagenes/estados/Envenenado.gif", DefaultImageType.ESTADO));
        }
        if (cdb.getJugadores()[cdb.getSiguienteTurno()].getPokemonActual().getEstados().stream().filter(estado -> estado.getNombre().equals("dormido")).toList().isEmpty()) {
            imagenVictimaDormido.setImage(ImageLoader.getJavafxImage("/imagenes/estados/SinEstado.gif", DefaultImageType.ESTADO));
        } else {
            imagenVictimaDormido.setImage(ImageLoader.getJavafxImage("/imagenes/estados/Dormido.gif", DefaultImageType.ESTADO));
        }
        if (cdb.getJugadores()[cdb.getSiguienteTurno()].getPokemonActual().getEstados().stream().filter(estado -> estado.getNombre().equals("confuso")).toList().isEmpty()) {
            imagenVictimaConfuso.setImage(ImageLoader.getJavafxImage("/imagenes/estados/SinEstado.gif", DefaultImageType.ESTADO));
        } else {
            imagenVictimaConfuso.setImage(ImageLoader.getJavafxImage("/imagenes/estados/Confuso.gif", DefaultImageType.ESTADO));
        }
        imagenVictima.setImage(ImageLoader.getJavafxImage("/imagenes/pokemons/" + capitalizar(cdb.getJugadores()[cdb.getSiguienteTurno()].getPokemonActual().getNombre()) + "-front.gif", DefaultImageType.POKEMON));
    }

    private void renderHealth(boolean transicionRapida){
        nombreAtacante.setText(JuegoJavafx.getCdb().getJugadorActual().getPokemonActual().getNombre());
        nombreVictima.setText(JuegoJavafx.getCdb().getJugadores()[JuegoJavafx.getCdb().getSiguienteTurno()].getPokemonActual().getNombre());

        numeroVidaAtacante.setText(
                JuegoJavafx.getCdb().getJugadorActual().getPokemonActual().getVidaActual() + "/" +
                JuegoJavafx.getCdb().getJugadorActual().getPokemonActual().getVidaMaxima()
        );
        numeroVidaVictima.setText(
                JuegoJavafx.getCdb().getJugadores()[JuegoJavafx.getCdb().getSiguienteTurno()].getPokemonActual().getVidaActual() + "/" +
                JuegoJavafx.getCdb().getJugadores()[JuegoJavafx.getCdb().getSiguienteTurno()].getPokemonActual().getVidaMaxima()
        );

        double vidaFinalAtacante = (double) JuegoJavafx.getCdb().getJugadorActual().getPokemonActual().getVidaActual() / JuegoJavafx.getCdb().getJugadorActual().getPokemonActual().getVidaMaxima();
        double vidaFinalVictima = (double) JuegoJavafx.getCdb().getJugadores()[JuegoJavafx.getCdb().getSiguienteTurno()].getPokemonActual().getVidaActual() / JuegoJavafx.getCdb().getJugadores()[JuegoJavafx.getCdb().getSiguienteTurno()].getPokemonActual().getVidaMaxima();

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

//    public void renderPokebolas(){
//        pokebolasAtacante.add(pokebolaAtacanteSuplente1);
//        pokebolasAtacante.add(pokebolaAtacanteSuplente2);
//        pokebolasAtacante.add(pokebolaAtacanteSuplente3);
//        pokebolasAtacante.add(pokebolaAtacanteSuplente4);
//        pokebolasAtacante.add(pokebolaAtacanteSuplente5);
//
//        pokebolasVictima.add(pokebolaVictimaSuplente1);
//        pokebolasVictima.add(pokebolaVictimaSuplente2);
//        pokebolasVictima.add(pokebolaVictimaSuplente3);
//        pokebolasVictima.add(pokebolaVictimaSuplente4);
//        pokebolasVictima.add(pokebolaVictimaSuplente5);
//
//        for (int i = 1; i <= pokebolasAtacante.size(); i++) {
//            if(!JuegoJavafx.getCdb().getJugadorActual().getPokemons().get(i).estaVivo()){
//                pokebolasAtacante.get(i-1).setImage(ImageLoader.getJavafxImage("/imagenes/otros/pokeballMuerto.png", DefaultImageType.OTRO));
//            }
//        }
//    }

    private static String capitalizar(String string){
        return string.substring(0, 1).toUpperCase() + string.substring(1);
    }

    private record Coordinate(int posCol, int posRow) {
    }

    public void accionar() {
        state = BattleState.ACCIONANDO;
        loadAcciones();
        disableGrid();
        if(!colaDeMensajes.isEmpty()){
            loadNextMessage();
        }else{
            state = BattleState.SELECCION_ACCION;
            prepararSiguienteTurno();
        }

        renderHealth(false);
    }

    public void initializeData(){
        if(!backgroundMusic.isPlaying()){
            backgroundMusic.playSound(true, -10.0f);
        }
        state = BattleState.SELECCION_ACCION;
        colaDeMensajes = new ArrayList<>();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if(state == BattleState.NO_EMPEZADA){
            initializeData();
            FadeTransition fadeOut = new FadeTransition(Duration.seconds(1), blackScreen);
            fadeOut.setFromValue(1.0);
            fadeOut.setToValue(0.0);
            fadeOut.play();
        }
//        renderPokebolas();
        renderImages();
        renderHealth(true);
        habilidades = new ArrayList<>();
        barraVidaAtacante.styleProperty().bind(
                javafx.beans.binding.Bindings.createStringBinding(() -> {
                    if (barraVidaAtacante.getProgress() > 0.75) {
                        return "-fx-accent: #00fc00;";
                    } else if (barraVidaAtacante.getProgress() > 0.25) {
                        return "-fx-accent: yellow;";
                    } else {
                        return "-fx-accent: red;";
                    }
                }, barraVidaAtacante.progressProperty())
        );
        barraVidaVictima.styleProperty().bind(
                javafx.beans.binding.Bindings.createStringBinding(() -> {
                    if (barraVidaVictima.getProgress() > 0.75) {
                        return "-fx-accent: #00fc00;";
                    } else if (barraVidaVictima.getProgress() > 0.25) {
                        return "-fx-accent: yellow;";
                    } else {
                        return "-fx-accent: red;";
                    }
                }, barraVidaVictima.progressProperty())
        );
        blackScreen.setOpacity(0);
        System.out.println("Inicializado!");
    }

    public void callPokemonScene(CambiarPokemonState state, Jugador jugador){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/CambiarPokemonJugador.fxml"));
            Pane pane = loader.load();
            ((CambiarPokemonController)loader.getController()).setState(state);
            ((CambiarPokemonController)loader.getController()).setJugadorActual(jugador);

            Scene scene = new Scene(pane);
            JuegoJavafx.setScene(scene, true);
        }catch(IOException e){
            throw new RuntimeException("Algo anduvo mal con el archivo de cambiar pokemon");
        }
    }
    public void callItemScene(){
        try {
            Scene scene = new Scene(new FXMLLoader(getClass().getResource("/fxml/ElegirItem.fxml")).load());
            JuegoJavafx.setScene(scene, true);
        }catch(IOException e){
            throw new RuntimeException("Algo anduvo mal con el archivo de items");
        }
    }
    public void callVictoryScene(){
        FadeTransition fadeOut = new FadeTransition(Duration.seconds(1), blackScreen);
        fadeOut.setFromValue(0.0);
        fadeOut.setToValue(1.0);
        fadeOut.setOnFinished(actionEvent -> {
            backgroundMusic.stopSound();
            try {
                Scene scene = new Scene(new FXMLLoader(getClass().getResource("/fxml/pantallaVictoria.fxml")).load());
                JuegoJavafx.setScene(scene, true);
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("Algo anduvo mal con el archivo de victoria");
            }
        });
        fadeOut.play();
    }

    public List<String> getColaDeMensajes(){
        return colaDeMensajes;
    }
}
