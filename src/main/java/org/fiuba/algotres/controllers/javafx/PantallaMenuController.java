package org.fiuba.algotres.controllers.javafx;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;

public class PantallaMenuController {

    @FXML
    Button jugarButton;

    @FXML
    Button ayudaButton;

    @FXML
    Button salirButton;

    @FXML
    StackPane stackPane;

    String estiloBotonVentana = "-fx-font-size: 12; " +
            "-fx-background-color: #698ce2; " +
            "-fx-border-color: #2d4586; " +
            "-fx-border-width: 2px; " +
            "-fx-font-family: 'PKMN RBYGSC Regular'; "
            ;

    String estiloBotonActualVentana = "-fx-background-color: #7661cc; ";

    String estiloTituloVentana = "-fx-font-size: 22px; " +
            "-fx-font-family: 'PKMN RBYGSC Regular'; "
            ;

    String estiloTextoVentana = "-fx-font-size: 13px; " +
            "-fx-font-family: 'PKMN RBYGSC Regular'; "
            ;

    // Otros campos y métodos del controlador

    @FXML
    public void initialize() {
        // Desactivar la interactividad del ratón para el StackPane
        stackPane.setMouseTransparent(true);
    }

    @FXML
    public void onJugarKeyPressed(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("escena-batalla.fxml"));
                Parent nuevaEscena = loader.load();
                Scene scene = new Scene(nuevaEscena);
                Stage stage = (Stage) ((Node) keyEvent.getSource()).getScene().getWindow();
                stage.setScene(scene);
            } catch (Exception e) {
                System.out.println("Ups");
            }
        }
    }

    @FXML
    protected void onAyudaKeyPressed(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER) {
            Stage ventanaDeAyuda = new Stage();
            ventanaDeAyuda.initModality(Modality.APPLICATION_MODAL);
            ventanaDeAyuda.setTitle("Ayuda");

            StackPane stackPane = new StackPane();
            Scene scene = new Scene(stackPane, 400, 280);
            ventanaDeAyuda.setScene(scene);

            ObservableList<String> stylesheets = stackPane.getScene().getStylesheets();
            stylesheets.add(Objects.requireNonNull(getClass().getResource("estilos.css")).toExternalForm());

            Label mensaje0 = new Label("Controles");
            Label mensaje1 = new Label("Usa las teclas de direccion para moverte entre los botones");
            Label mensaje2 = new Label("Usa la tecla Enter para acceder a un botón");
            Label mensaje3 = new Label("Usa la tecla Esc para volver atrás");

            Button botonCerrar = new Button("Cerrar");
            botonCerrar.setOnKeyPressed(event -> {
                if (event.getCode() == KeyCode.ENTER || event.getCode() == KeyCode.ESCAPE) {
                    ventanaDeAyuda.close();
                }
            });

            URL imagenTeclasFlechitas = (PantallaMenu.class.getResource("imagenes/otros/teclas_flechas.png"));
            Label LabelimagenTeclasFlechitas = new Label();
            LabelimagenTeclasFlechitas.setStyle("-fx-background-image: url('" + imagenTeclasFlechitas + "'); " +
                    "-fx-background-size: cover; " +
                    "-fx-background-position: center; " +
                    "-fx-background-repeat: no-repeat; " +
                    "-fx-pref-width: 120px; " +
                    "-fx-pref-height: 120px; " +
                    "-fx-translate-x: 120px; " +
                    "-fx-translate-y: -70px; "
            );

            URL imagenTeclaEscape = (PantallaMenu.class.getResource("imagenes/otros/teclas_esc.png"));
            Label LabelimagenTeclaEscape = new Label();
            LabelimagenTeclaEscape.setStyle("-fx-background-image: url('" + imagenTeclaEscape + "'); " +
                    "-fx-background-size: cover; " +
                    "-fx-background-position: center; " +
                    "-fx-background-repeat: no-repeat; " +
                    "-fx-pref-width: 60px; " +
                    "-fx-pref-height: 60px; " +
                    "-fx-translate-x: 120px; " +
                    "-fx-translate-y: 55px; "
            );

            URL imagenTeclaEnter = (PantallaMenu.class.getResource("imagenes/otros/teclas_enter.png"));
            Label LabelimagenTeclaEnter = new Label();
            LabelimagenTeclaEnter.setStyle("-fx-background-image: url('" + imagenTeclaEnter + "'); " +
                    "-fx-background-size: cover; " +
                    "-fx-background-position: center; " +
                    "-fx-background-repeat: no-repeat; " +
                    "-fx-pref-width: 50px; " +
                    "-fx-pref-height: 50px; " +
                    "-fx-translate-x: 120px; " +
                    "-fx-translate-y: 0px; "
            );

            URL imagenFondoURL = PantallaMenu.class.getResource("imagenes/otros/fondo_ayuda.jpg");
            String estiloFondo = "-fx-background-image: url('" + imagenFondoURL + "'); " +
                    "-fx-background-size: cover; " +
                    "-fx-background-position: center; ";

            stackPane.setStyle(estiloFondo);

            botonCerrar.getStyleClass().add("button-window");
            StackPane.setAlignment(botonCerrar, Pos.CENTER);
            botonCerrar.setTranslateY(100);

            StackPane.setAlignment(mensaje0, Pos.CENTER);
            mensaje0.setTranslateY(-120);
            mensaje0.getStyleClass().add("content-text");
            mensaje0.setStyle("-fx-font-size: 20px;");

            mensaje1.setWrapText(true);
            mensaje1.setMaxWidth(250);
            mensaje1.setTranslateY(-70);
            mensaje1.setTranslateX(-70);
            mensaje1.getStyleClass().add("content-text");

            mensaje2.setWrapText(true);
            mensaje2.setMaxWidth(250);
            mensaje2.setTranslateY(-0);
            mensaje2.setTranslateX(-70);
            mensaje2.getStyleClass().add("content-text");

            mensaje3.setWrapText(true);
            mensaje3.setMaxWidth(250);
            mensaje3.setTranslateY(55);
            mensaje3.setTranslateX(-70);
            mensaje3.getStyleClass().add("content-text");

            stackPane.getChildren().addAll(
                    mensaje0,
                    mensaje1,
                    mensaje2,
                    mensaje3,
                    LabelimagenTeclasFlechitas,
                    LabelimagenTeclaEnter,
                    LabelimagenTeclaEscape,
                    botonCerrar
            );

            ventanaDeAyuda.showAndWait();
        }
    }

    @FXML
    protected void onSalirKeyPressed(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Salir");
            alert.setHeaderText(null);
            alert.setContentText("¿Estás seguro que deseas salir?");

            ButtonType botonAceptar = new ButtonType("Aceptar");
            ButtonType botonCancelar = new ButtonType("Cancelar");

            alert.getButtonTypes().setAll(botonAceptar, botonCancelar);

            DialogPane dialogPane = alert.getDialogPane();
            dialogPane.setMouseTransparent(true);
            dialogPane.setPrefWidth(350);
            dialogPane.setPrefHeight(225);

            ObservableList<String> stylesheets = dialogPane.getStylesheets();
            stylesheets.add(Objects.requireNonNull(getClass().getResource("estilos.css")).toExternalForm());

            dialogPane.lookup(".content.label").getStyleClass().add("content-text");

            URL imagenFondo = (PantallaMenu.class.getResource("imagenes/otros/pikachu_triste.gif"));
            dialogPane.setStyle("-fx-background-image: url('" + imagenFondo + "'); " +
                    "-fx-background-size: 150 100; " +
                    "-fx-background-repeat: no-repeat; " +
                    "-fx-background-position: center center; " +
                    "-fx-background-color: #a1baff;");

            Button buttonAceptar = (Button) dialogPane.lookupButton(botonAceptar);
            Button buttonCancelar = (Button) dialogPane.lookupButton(botonCancelar);

            buttonAceptar.getStyleClass().add("button-window");
            buttonCancelar.getStyleClass().add("button-window");

            dialogPane.setOnKeyPressed(e -> {
                if (e.getCode() == KeyCode.ESCAPE) {
                    alert.setResult(botonCancelar);
                }
            });

            alert.showAndWait().ifPresent(response -> {
                if (response == botonAceptar) {
                    Platform.exit();
                }
            });

        }

    }

}
