package org.fiuba.algotres.controllers.javafx;

import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import org.fiuba.algotres.JuegoJavafx;
import org.fiuba.algotres.utils.ImageLoader;
import org.fiuba.algotres.utils.Sound;
import org.fiuba.algotres.utils.enums.DefaultImageType;

import java.io.IOException;
import java.util.ResourceBundle;


public class PantallaDeVictoriaController implements Initializable {

    @FXML
    private Label mensajeVictoria;
    @FXML
    public Rectangle blackScreen;

    @FXML
    private AnchorPane rootPane;

    @FXML
    private ImageView gifPokemon;


    private final Sound backgroundMusic = new Sound("src/main/resources/audios/trompetasdela12.wav");

    @Override
    public void initialize(java.net.URL arg0, ResourceBundle resource) {
        try {
            backgroundMusic.playSound(false, 0.0f);
            setearGifPokemon();
            setMensajeVictoria();


            FadeTransition fadeOut = new FadeTransition(Duration.seconds(1), blackScreen);
            fadeOut.setFromValue(1.0);
            fadeOut.setToValue(0.0);
            fadeOut.play();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public void setMensajeVictoria() {
        mensajeVictoria.setText("Felicidades " + JuegoJavafx.getCdb().getJugadores()[JuegoJavafx.getCdb().getGanador()].getNombre() + ", has ganado la partida");
    }

    @FXML
    public void onKeyPressed(KeyEvent event) {
        backgroundMusic.stopSound();
        callMenuScene();
    }


    public void callMenuScene() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/pantalla-menu.fxml"));
            Scene scene = new Scene(loader.load());
            JuegoJavafx.setScene(scene, false);
        } catch (IOException e) {
            System.out.println("Error en la carga de BattleScreen.fxml");
        }
    }

    public void setearGifPokemon() {
        gifPokemon.setImage(ImageLoader.getJavafxImage("/imagenes/pokemons/" + JuegoJavafx.getCdb().getJugadores()[JuegoJavafx.getCdb().getGanador()].getPokemonActual().getNombre() + "-front.gif", DefaultImageType.OTRO));
    }
}