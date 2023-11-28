package org.fiuba.algotres.controllers.javafx;

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


public class PantallaDeVictoriaController implements Initializable {
    
    @FXML
    private Label mensajeVictoria;


    private final Sound backgroundMusic = new Sound("src/main/resources/audios/trompetasdela12.wav");

    @Override
    public void initialize(java.net.URL arg0, ResourceBundle arg1) {
        try {
            stage.setTitle("Pantalla de Victoria");
            stage.setResizable(false);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/pantallaVictoria.fxml"));
            AnchorPane root = loader.load();
            stage.getIcons().add(new Image("/imagenes/otros/app-logo.png"));
            playSound();
            ImageView gifPokemon= setearGifPokemon();
            root.getChildren().add(gifPokemon);            
            Scene scene = new Scene(root);
            stage.setScene(scene);

            stage.show();
            
            

            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }


  // private static String capitalizar(String string){
  //     return string.substring(0, 1).toUpperCase() + string.substring(1);
  // }


   //public void setMensajeVictoria(){
   //    mensajeVictoria.setText("Felicidades " + JavafxController.getCdb().getJugadorActual().getNombre() + " has ganado la partida");
   //}

   @FXML
   public void onKeyTyped(KeyEvent event){
     //callMenuScene();
        stopSound();
   }


    //public void callMenuScene(){
    //        try {
    //            Scene scene = new Scene(new FXMLLoader(getClass().getResource("/fxml/pantalla-menu.fxml")).load());
    //        }catch(IOException e){
    //            throw new RuntimeException("Algo anduvo mal con los archivos FXMLs");
    //        }
    //    }

    public void playSound(){
        backgroundMusic.playSound(false, -10.0f);
    }

    public void stopSound(){
        backgroundMusic.stopSound();
    }

    public ImageView setearGifPokemon(){
    //Que tome el pokemon del jugador ganador
    Image gif = new Image(getClass().getResourceAsStream("/imagenes/pokemons/Tentacool-front.gif"));
    ImageView gifPokemon = new ImageView();
    //Image gif = new Image(getClass().getResourceAsStream("/imagenes/pokemons/"+ capitalizar(JavafxController.getCdb().getJugadorActual().getPokemonActual().getNombre()) +"-front.gif"));
    gifPokemon.setImage(gif);
    gifPokemon.setY(240);
    gifPokemon.setX(50);
    gifPokemon.setScaleY(2.5);
    gifPokemon.setScaleX(1.5);
    return gifPokemon;

    }

   public static void main(String[] args) {
       launch(args);

   }
}