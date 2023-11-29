package org.fiuba.algotres.controllers.javafx;

import java.io.IOException;
import java.util.ResourceBundle;

import org.fiuba.algotres.utils.Sound;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition.ParameterDefinition.Initial;


public class PantallaDeVictoriaController  implements Initializable  {
    
    @FXML
    public Label mensajeVictoria;

    @FXML
    private AnchorPane rootPane;

    @FXML
    private ImageView gifPokemon;



    private final Sound backgroundMusic = new Sound("src/main/resources/audios/trompetasdela12.wav");

    @Override
    public void initialize(java.net.URL arg0, ResourceBundle resource ) {
        try {
            playSound();
            setearGifPokemon();  
            setMensajeVictoria();         

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }


   public void setMensajeVictoria(){
       mensajeVictoria.setText("Felicidades " + JavafxController.getCdb().getJugadorActual().getNombre() + " has ganado la partida");
   }

   @FXML
   public void onKeyPressed(KeyEvent event){
     stopSound();
     callMenuScene();
   }


    public void callMenuScene(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/pantalla-menu.fxml"));
            Scene scene = new Scene(loader.load());
            JavafxController.setScene(scene);
        } catch (IOException e) {
            System.out.println("Error en la carga de BattleScreen.fxml");
        }
        }

    public void playSound(){
        backgroundMusic.playSound(false, -10.0f);
    }

    public void stopSound(){
        backgroundMusic.stopSound();
    }

    public void setearGifPokemon(){
    try{gifPokemon.setImage( new Image(getClass().getResourceAsStream("/imagenes/pokemons/"+ JavafxController.getCdb().getJugadorActual().getPokemonActual().getNombre() +"-front.gif")));}
    catch(Exception e){
        System.out.println("No se pudo cargar el gif");
    }
    }
}