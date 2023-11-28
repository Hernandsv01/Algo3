package org.fiuba.algotres.controllers.javafx;

import org.fiuba.algotres.utils.enums.Sound;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class PantallaDeVictoria extends Application {
    
    @FXML
    private Label mensajeVictoria;

    

    private final Sound backgroundMusic = new Sound("src/main/resources/audios/trompetasdela12.wav");

    @Override
    public void start(Stage stage ) {
        try {
            stage.setTitle("Pantalla de Victoria");
            stage.setResizable(false);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/pantallaVictoria.fxml"));
            AnchorPane root = loader.load();
            ImageView imagenVictoria = setearPantallaVitcoria();
            ImageView gifEntrenador = setearEntrenadorPokemon();
            ImageView gifPokemon = setearGifPokemon();
            //ImageView gifFirework = setearGifFirework();
            root.getChildren().add(imagenVictoria);
            root.getChildren().add(gifEntrenador);
            root.getChildren().add(gifPokemon);
            //root.getChildren().add(gifFirework);
            imagenVictoria.toBack();
            stage.getIcons().add(new Image("/imagenes/otros/app-logo.png"));
            playSound();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            

            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
    
    
    public ImageView setearPantallaVitcoria(){
        Image imagen = new Image(getClass().getResourceAsStream("/imagenes/otros/fondoPantallaVictoria.png"));
        ImageView imagenVictoria = new ImageView();
        imagenVictoria.setImage(imagen);
        
        return imagenVictoria;
    }

    public ImageView setearEntrenadorPokemon(){
        Image gif = new Image(getClass().getResourceAsStream("/imagenes/otros/entrenador.gif"));
        ImageView gifEntrenador = new ImageView();
        gifEntrenador.setImage(gif);
        gifEntrenador.setScaleY(4.5);
        gifEntrenador.setScaleX(4.5);
        gifEntrenador.setX(530);
        gifEntrenador.setY(260);
        return gifEntrenador;

    }

    public ImageView setearGifPokemon(){
        //Que tome el pokemon del jugador ganador
        Image gif = new Image(getClass().getResourceAsStream("/imagenes/pokemons/Paras-front.gif"));
        //Image gif = new Image(getClass().getResourceAsStream("/imagenes/pokemons/"+ capitalizar(JavafxController.getCdb().getJugadorActual().getPokemonActual().getNombre()) +"-front.gif"));
        ImageView gifPokemon = new ImageView();
        gifPokemon.setImage(gif);
        gifPokemon.setY(240);
        gifPokemon.setX(50);
        gifPokemon.setScaleY(2.5);
        gifPokemon.setScaleX(1.5);
        return gifPokemon;

    }

    private static String capitalizar(String string){
        return string.substring(0, 1).toUpperCase() + string.substring(1);
    }


   //public void setMensajeVictoria(){
   //    mensajeVictoria.setText("Felicidades " + JavafxController.getCdb().getJugadorActual().getNombre() + " has ganado la partida");
   //}

    public void playSound(){
        backgroundMusic.playSound(false, -10.0f);
    }

    public void stopSound(){
        backgroundMusic.stopSound();
    }

   public static void main(String[] args) {
       launch(args);

   }
}