package org.fiuba.algotres.controllers.javafx.batalla;

import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
import lombok.Getter;
import lombok.Setter;
import org.fiuba.algotres.JuegoJavafx;
import org.fiuba.algotres.controllers.javafx.seleccion.CambiarPokemonController;
import org.fiuba.algotres.model.Jugador;
import org.fiuba.algotres.model.Pokemon;
import org.fiuba.algotres.model.estado.Estado;
import org.fiuba.algotres.model.habilidad.Habilidad;
import org.fiuba.algotres.persistencia.reportes.GeneradorReporte;
import org.fiuba.algotres.persistencia.reportes.json.GeneradorReporteJSON;
import org.fiuba.algotres.utils.GeneradorDeMensajes;
import org.fiuba.algotres.utils.ImageLoader;
import org.fiuba.algotres.utils.Sound;
import org.fiuba.algotres.utils.enums.BattleState;
import org.fiuba.algotres.utils.enums.CambiarPokemonState;
import org.fiuba.algotres.utils.enums.DefaultImageType;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

@Setter
public class BattleController implements Initializable{
    private static final String UP_KEY = "UP";
    private static final String DOWN_KEY = "DOWN";
    private static final String RIGHT_KEY = "RIGHT";
    private static final String LEFT_KEY = "LEFT";
    private static final String ENTER_KEY = "ENTER";
    private static final String ESCAPE_KEY = "ESCAPE";
    private final String MENSAJE_PANTALLA_DEFAULT = "Elija una opción.";

    private static final Sound changedOption = new Sound("src\\main\\resources\\audios\\OpcionMovida.wav");
    private static final Sound selectedOption = new Sound("src\\main\\resources\\audios\\OpcionSeleccionada.wav");
    private static final Sound backgroundMusic = new Sound("src\\main\\resources\\audios\\MusicaBatalla.wav");
    private static final Sound sonidaAtaque = new Sound("src\\main\\resources\\audios\\SonidoAtaque.wav");

    private static final GeneradorReporte reportadorJSON = new GeneradorReporteJSON();

    @Getter
    private static BattleState state = BattleState.NO_EMPEZADA;

    @FXML
    private ImageView imagenClima;

    // Items atacante
    @FXML
    private Label nombreAtacante;
    @FXML
    private Label numeroVidaAtacante;
    @FXML
    private ProgressBar barraVidaAtacante;
    @FXML
    private ImageView imagenAtacanteParalizado;
    @FXML
    private ImageView imagenAtacanteDormido;
    @FXML
    private ImageView imagenAtacanteEnvenenado;
    @FXML
    private ImageView imagenAtacanteConfuso;
    @FXML
    private ImageView imagenAtacante;
    @FXML
    private ImageView pokebolaAtacanteSuplente1;
    @FXML
    private ImageView pokebolaAtacanteSuplente2;
    @FXML
    private ImageView pokebolaAtacanteSuplente3;
    @FXML
    private ImageView pokebolaAtacanteSuplente4;
    @FXML
    private ImageView pokebolaAtacanteSuplente5;

    // Items victima
    @FXML
    private Label nombreVictima;
    @FXML
    private Label numeroVidaVictima;
    @FXML
    private ProgressBar barraVidaVictima;
    @FXML
    private ImageView imagenVictimaConfuso;
    @FXML
    private ImageView imagenVictimaEnvenenado;
    @FXML
    private ImageView imagenVictimaDormido;
    @FXML
    private ImageView imagenVictimaParalizado;
    @FXML
    private ImageView imagenVictima;
    @FXML
    private ImageView pokebolaVictimaSuplente1;
    @FXML
    private ImageView pokebolaVictimaSuplente2;
    @FXML
    private ImageView pokebolaVictimaSuplente3;
    @FXML
    private ImageView pokebolaVictimaSuplente4;
    @FXML
    private ImageView pokebolaVictimaSuplente5;

    // Interacción usuario
    @FXML
    public InformationPanelController informationPanelController;
    @FXML
    private Rectangle blackScreen;
    private List<ImageView> pokebolaAtacanteSuplenteImages;
    private List<ImageView> pokebolaVictimaSuplenteImages;

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if(state == BattleState.NO_EMPEZADA){
            initializeData();
            FadeTransition fadeOut = new FadeTransition(Duration.seconds(1), blackScreen);
            fadeOut.setFromValue(1.0);
            fadeOut.setToValue(0.0);
            fadeOut.play();
        }
        loadPokebolas();
        renderImages();
        renderHealth(true);
        renderPokebolas();
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

    private static Coordinate verifyPosition(int column, int row){
        if((column >= 0 && column < 2) && (row >= 0 && row < 2)){
            return new Coordinate(column, row);
        }
        return null;
    }

    private void moveSelector(String tecla){
        BorderPane currentElement = informationPanelController.getSelectedGridElement();
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
        informationPanelController.setSelectedGridElement(newPos.posCol(), newPos.posRow());

        if(state == BattleState.SELECCION_HABILIDAD){
            informationPanelController.loadHabilidadInfo();
        }
    }

    private void select() {
        BorderPane selectedElement = informationPanelController.getSelectedGridElement();
        Coordinate selectedPos = null;
        if(selectedElement != null){
            selectedPos = new Coordinate(GridPane.getColumnIndex(selectedElement), GridPane.getRowIndex(selectedElement));
        }

        if(state == BattleState.SELECCION_ACCION) {
            selectedOption.playSound(false, 2.0f);
            if (selectedPos.posCol == 0 && selectedPos.posRow == 0) {
                state = BattleState.SELECCION_HABILIDAD;
                informationPanelController.loadHabilidades();
                informationPanelController.loadHabilidadInfo();
            } else if (selectedPos.posCol == 1 && selectedPos.posRow == 0) {
                callItemScene();
            } else if (selectedPos.posCol == 0 && selectedPos.posRow == 1) {
                callPokemonScene(CambiarPokemonState.CAMBIO_POKEMON_POR_ELECCION, JuegoJavafx.getCdb().getJugadorActual(), null);
            } else if (selectedPos.posCol == 1 && selectedPos.posRow == 1) {
                accionarRendicion();
            }
        }else{
            if(state == BattleState.SELECCION_HABILIDAD){
                activarHabilidadSeleccionada();
                accionar();
            }else if(state == BattleState.ACCIONANDO){
                if(!InformationPanelController.getColaDeMensajes().isEmpty()){
                    informationPanelController.loadNextMessage();
                }else{
                    state = BattleState.SELECCION_ACCION;
                    prepararSiguienteTurno();
                }
            }
        }
    }

    private void prepararSiguienteTurno() {
        verificarVictoria();
        if(state == BattleState.TERMINADA){
            return;
        }
        verificarMuertePokemon();
        informationPanelController.getPantallaMensaje().setText("");

        FadeTransition fadeIn = new FadeTransition(Duration.seconds(1), blackScreen);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);
        FadeTransition fadeOut = new FadeTransition(Duration.seconds(1), blackScreen);
        fadeOut.setFromValue(1.0);
        fadeOut.setToValue(0.0);

        fadeIn.setOnFinished(event -> {
            JuegoJavafx.getCdb().setSiguienteTurno();
            renderImages();
            renderPokebolas();
            fadeOut.play();
        });
        fadeIn.play();

        fadeOut.setOnFinished(event -> {
            informationPanelController.loadAcciones();
            informationPanelController.getPantallaMensaje().setText("Elija una opción");
            informationPanelController.setSelectedGridElement(0, 0);
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
            callPokemonScene(CambiarPokemonState.CAMBIO_POKEMON_MUERTO, JuegoJavafx.getCdb().getJugadorActual(), JuegoJavafx.getCdb().getJugadorActual().getPokemonActual());
        }else if(!JuegoJavafx.getCdb().getJugadores()[JuegoJavafx.getCdb().getSiguienteTurno()].getPokemonActual().estaVivo()){
            callPokemonScene(CambiarPokemonState.CAMBIO_POKEMON_MUERTO, JuegoJavafx.getCdb().getJugadores()[JuegoJavafx.getCdb().getSiguienteTurno()], JuegoJavafx.getCdb().getJugadores()[JuegoJavafx.getCdb().getSiguienteTurno()].getPokemonActual());
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
            InformationPanelController.getColaDeMensajes().add(GeneradorDeMensajes.generarMensajeMuertePrematura(JuegoJavafx.getCdb().getJugadorActual().getPokemonActual()));
            return;
        }

        // Climas
        JuegoJavafx.getCdb().getClima().aplicarEfectos(JuegoJavafx.getCdb().getJugadorActual().getPokemonActual());
        String mensajeClima = GeneradorDeMensajes.generarMensajeClima(JuegoJavafx.getCdb().getClima());
        if(mensajeClima != null){
            InformationPanelController.getColaDeMensajes().add(mensajeClima);
        }
        if(!JuegoJavafx.getCdb().getJugadorActual().getPokemonActual().estaVivo()){
            InformationPanelController.getColaDeMensajes().add(GeneradorDeMensajes.generarMensajeMuertePrematura(JuegoJavafx.getCdb().getJugadorActual().getPokemonActual()));
            return;
        }

        // Accionar
        if(puedeAccionar){
            accionarHabilidad();
        }else{
            InformationPanelController.getColaDeMensajes().add(GeneradorDeMensajes.generarMensajeEstado(estadoInhabilitante, JuegoJavafx.getCdb().getJugadorActual().getPokemonActual(), true));
        }

        if(!JuegoJavafx.getCdb().getJugadores()[JuegoJavafx.getCdb().getSiguienteTurno()].getPokemonActual().estaVivo()){
            InformationPanelController.getColaDeMensajes().add(GeneradorDeMensajes.generarMensajeMuerte(JuegoJavafx.getCdb().getJugadores()[JuegoJavafx.getCdb().getSiguienteTurno()].getPokemonActual()));
        }
    }

    private void goBack() {
        if(state == BattleState.SELECCION_ACCION || state == BattleState.ACCIONANDO) {
            accionarRendicion();
        }else if(state == BattleState.SELECCION_HABILIDAD){
            state = BattleState.SELECCION_ACCION;
            informationPanelController.loadAcciones();
            informationPanelController.setSelectedGridElement(0, 0);
            informationPanelController.getPantallaMensaje().setText(MENSAJE_PANTALLA_DEFAULT);
        }
    }

    private void accionarHabilidad(){
        int posicionHabilidad = informationPanelController.getGridElements().indexOf(informationPanelController.getSelectedGridElement());
        if(posicionHabilidad == -1) return;
        Habilidad habilidad = informationPanelController.getHabilidades().get(posicionHabilidad);
        Pokemon atacante = JuegoJavafx.getCdb().getJugadorActual().getPokemonActual();
        Pokemon victima = JuegoJavafx.getCdb().getJugadores()[JuegoJavafx.getCdb().getSiguienteTurno()].getPokemonActual();

        habilidad.accionarHabilidad(atacante, victima);
        sonidaAtaque.playSound(false, 0);
        InformationPanelController.getColaDeMensajes().add(GeneradorDeMensajes.generarMensajeEfectoHabilidad(habilidad, atacante, victima));
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
                renderHealth(false);
                callVictoryScene();
            }
        });
    }

    private void renderImages() {
        imagenClima.setImage(ImageLoader.getJavafxImage("/imagenes/climas/" + capitalizar(JuegoJavafx.getCdb().getClima().getNombre()) + ".gif", DefaultImageType.CLIMA));
        renderPokemonImages(JuegoJavafx.getCdb().getJugadorActual().getPokemonActual(), true);
        renderPokemonImages(JuegoJavafx.getCdb().getJugadores()[JuegoJavafx.getCdb().getSiguienteTurno()].getPokemonActual(), false);
        renderHealth(true);
        renderPokebolas();
    }

    private void renderPokemonImages(Pokemon pokemon, boolean isAttacker) {
        String[] statuses = {"paralizado", "envenenado", "dormido", "confuso"};

        for (String status : statuses) {
            ImageView imageView = getImageViewByCombination(status, isAttacker);
            boolean hasStatus = pokemon.getEstados().stream().anyMatch(estado -> estado.getNombre().equals(status));

            String imagePath = hasStatus ? status.substring(0, 1).toUpperCase() + status.substring(1) + ".gif" : "SinEstado.gif";
            String imageUrl = "/imagenes/estados/" + imagePath;
            imageView.setImage(ImageLoader.getJavafxImage(imageUrl, DefaultImageType.ESTADO));
        }

        String pokemonImage = "/imagenes/pokemons/" + capitalizar(pokemon.getNombre()) + (isAttacker ? "-back" : "-front") + ".gif";
        ImageView pokemonImageView = isAttacker ? imagenAtacante : imagenVictima;
        pokemonImageView.setImage(ImageLoader.getJavafxImage(pokemonImage, DefaultImageType.POKEMON));
    }

    private ImageView getImageViewByCombination(String status, boolean isAttacker) {
        if (isAttacker) {
            return switch (status) {
                case "paralizado" -> imagenAtacanteParalizado;
                case "envenenado" -> imagenAtacanteEnvenenado;
                case "dormido" -> imagenAtacanteDormido;
                case "confuso" -> imagenAtacanteConfuso;
                default -> null;
            };
        } else {
            return switch (status) {
                case "paralizado" -> imagenVictimaParalizado;
                case "envenenado" -> imagenVictimaEnvenenado;
                case "dormido" -> imagenVictimaDormido;
                case "confuso" -> imagenVictimaConfuso;
                default -> null;
            };
        }
    }

    private void renderHealth(boolean transicionRapida) {
        Pokemon attacker = JuegoJavafx.getCdb().getJugadorActual().getPokemonActual();
        Pokemon victim = JuegoJavafx.getCdb().getJugadores()[JuegoJavafx.getCdb().getSiguienteTurno()].getPokemonActual();

        updateHealthBar(numeroVidaAtacante, barraVidaAtacante, attacker.getVidaActual(), attacker.getVidaMaxima(), transicionRapida);
        updateHealthBar(numeroVidaVictima, barraVidaVictima, victim.getVidaActual(), victim.getVidaMaxima(), transicionRapida);
    }

    private void updateHealthBar(Label label, ProgressBar progressBar, int currentHealth, int maxHealth, boolean quickTransition) {
        double healthFraction = (double) currentHealth / maxHealth;

        if (quickTransition) {
            progressBar.setProgress(healthFraction);
            System.out.println("Barra de vida cambiada rapido! Progreso: " + progressBar.getProgress());
        } else {
            Timeline timeline = new Timeline(
                    new KeyFrame(Duration.ZERO, new KeyValue(progressBar.progressProperty(), progressBar.getProgress())),
                    new KeyFrame(Duration.seconds(1), new KeyValue(progressBar.progressProperty(), healthFraction))
            );
            timeline.play();
        }

        label.setText(currentHealth + "/" + maxHealth);
    }

    private void renderPokebolas() {
        for (int i = 0; i < 5; i++) {
            renderPokebola(i, JuegoJavafx.getCdb().getJugadorActual().getPokemons(), pokebolaAtacanteSuplenteImages.get(i));
            renderPokebola(i, JuegoJavafx.getCdb().getJugadores()[JuegoJavafx.getCdb().getSiguienteTurno()].getPokemons(), pokebolaVictimaSuplenteImages.get(i));
        }
    }

    private void renderPokebola(int index, List<Pokemon> pokemons, ImageView imageView) {
        if (!pokemons.get(index).estaVivo()) {
            imageView.setImage(ImageLoader.getJavafxImage("/imagenes/otros/pokeballMuerto.png", DefaultImageType.OTRO));
        } else {
            imageView.setImage(ImageLoader.getJavafxImage("/imagenes/otros/pokeballVivo.png", DefaultImageType.OTRO));
        }
    }


    private static String capitalizar(String string){
        return string.substring(0, 1).toUpperCase() + string.substring(1);
    }

    private record Coordinate(int posCol, int posRow) {
    }

    public void accionar() {
        state = BattleState.ACCIONANDO;
        informationPanelController.loadAcciones();
        informationPanelController.disableGrid();
        if(!InformationPanelController.getColaDeMensajes().isEmpty()){
            informationPanelController.loadNextMessage();
        }else{
            state = BattleState.SELECCION_ACCION;
            prepararSiguienteTurno();
        }

        renderHealth(false);
    }

    public void initializeData(){
        if(!backgroundMusic.isPlaying()){
            backgroundMusic.playSound(true, -14.0f);
        }
        state = BattleState.SELECCION_ACCION;
    }

    public void agregarMensaje(String mensaje){
        InformationPanelController.getColaDeMensajes().add(mensaje);
    }

    public void loadPokebolas(){
        pokebolaAtacanteSuplenteImages = new ArrayList<>();
        pokebolaAtacanteSuplenteImages.add(pokebolaAtacanteSuplente1);
        pokebolaAtacanteSuplenteImages.add(pokebolaAtacanteSuplente2);
        pokebolaAtacanteSuplenteImages.add(pokebolaAtacanteSuplente3);
        pokebolaAtacanteSuplenteImages.add(pokebolaAtacanteSuplente4);
        pokebolaAtacanteSuplenteImages.add(pokebolaAtacanteSuplente5);

        pokebolaVictimaSuplenteImages = new ArrayList<>();
        pokebolaVictimaSuplenteImages.add(pokebolaVictimaSuplente1);
        pokebolaVictimaSuplenteImages.add(pokebolaVictimaSuplente2);
        pokebolaVictimaSuplenteImages.add(pokebolaVictimaSuplente3);
        pokebolaVictimaSuplenteImages.add(pokebolaVictimaSuplente4);
        pokebolaVictimaSuplenteImages.add(pokebolaVictimaSuplente5);
    }

    public void callPokemonScene(CambiarPokemonState state, Jugador jugador, Pokemon pokemonMuerto){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/CambiarPokemonJugador.fxml"));
            Pane pane = loader.load();
            ((CambiarPokemonController)loader.getController()).setState(state);
            ((CambiarPokemonController)loader.getController()).setPokemonUsado(pokemonMuerto);
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
        
        reportadorJSON.GenerarReporte(JuegoJavafx.getCdb());
        fadeOut.play();
    }
}
