package org.fiuba.algotres.controllers.javafx;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.fiuba.algotres.JuegoJavafx;
import org.fiuba.algotres.utils.Sound;

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

    private final Sound menuSound = new Sound("src/main/resources/audios/MenuSong.wav");

    private final Sound BotonMovido = new Sound("src/main/resources/audios/OpcionMovida.wav");

    private final Sound BotonSeleccionado = new Sound("src/main/resources/audios/BotonSeleccionado.wav");

    @FXML
    public void initialize() {
        menuSound.playSound(true, -25.0f);
        stackPane.setMouseTransparent(true);

        jugarButton.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                BotonMovido.playSound(false, -20.0f);
            }
        });

        ayudaButton.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                BotonMovido.playSound(false, -20.0f);
            }
        });

        salirButton.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                BotonMovido.playSound(false, -20.0f);
            }
        });

    }

    @FXML
    public void onJugarKeyPressed(KeyEvent keyEvent) throws IOException {
        if (keyEvent.getCode() == KeyCode.ENTER) {
            try {
                BotonSeleccionado.playSound(false, -20.0f);
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ElegirPokemonInicial.fxml"));

                Pane anchorPane = loader.load();
                Scene scene = new Scene(anchorPane);
                Stage gameStage = (Stage) ((Node) keyEvent.getSource()).getScene().getWindow();
                JuegoJavafx.setScene(scene, true);
                gameStage.show();
                menuSound.stopSound();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    protected void onAyudaKeyPressed(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER) {
            BotonSeleccionado.playSound(false, -20.0f);
            Stage ventanaDeAyuda = new Stage();
            ventanaDeAyuda.initModality(Modality.APPLICATION_MODAL);
            ventanaDeAyuda.setTitle("Ayuda");
            ventanaDeAyuda.getIcons().add(new Image("/imagenes/otros/app-logo.png"));

            StackPane stackPane = new StackPane();
            Scene scene = new Scene(stackPane, 400, 280);
            ventanaDeAyuda.setScene(scene);

            ObservableList<String> stylesheets = stackPane.getScene().getStylesheets();
            stylesheets.add(Objects.requireNonNull(getClass().getResource("/fxml/estilos.css")).toExternalForm());

            Label mensaje0 = new Label("Controles");
            Label mensaje1 = new Label("Usa las teclas de direccion para moverte entre los botones");
            Label mensaje2 = new Label("Usa la tecla Enter para acceder a un botón");
            Label mensaje3 = new Label("Usa la tecla Esc para volver atrás");

            Button botonCerrar = new Button("Cerrar");
            botonCerrar.setOnKeyPressed(event -> {
                if (event.getCode() == KeyCode.ENTER || event.getCode() == KeyCode.ESCAPE) {
                    BotonSeleccionado.playSound(false, -20.0f);
                    ventanaDeAyuda.close();
                }
            });

            URL imagenTeclasFlechitas = (JuegoJavafx.class.getResource("/imagenes/otros/teclas_flechas.png"));
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

            URL imagenTeclaEscape = (JuegoJavafx.class.getResource("/imagenes/otros/teclas_esc.png"));
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

            URL imagenTeclaEnter = (JuegoJavafx.class.getResource("/imagenes/otros/teclas_enter.png"));
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

            URL imagenFondoURL = JuegoJavafx.class.getResource("/imagenes/otros/fondo_ayuda.jpg");
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
            BotonSeleccionado.playSound(false, -20.0f);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            stage.getIcons().add(new Image(this.getClass().getResource("/imagenes/otros/app-logo.png").toString()));
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
            stylesheets.add(Objects.requireNonNull(getClass().getResource("/fxml/estilos.css")).toExternalForm());

            dialogPane.lookup(".content.label").getStyleClass().add("content-text");

            URL imagenFondo = (JuegoJavafx.class.getResource("/imagenes/otros/pikachu_triste.gif"));
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

            buttonAceptar.focusedProperty().addListener((observable, oldValue, newValue) -> {
                if (newValue) {
                    BotonMovido.playSound(false, -20.0f);
                }
            });

            buttonCancelar.focusedProperty().addListener((observable, oldValue, newValue) -> {
                if (newValue) {
                    BotonMovido.playSound(false, -20.0f);
                }
            });

            alert.showAndWait().ifPresent(response -> {
                if (response == botonAceptar) {
                    BotonSeleccionado.playSound(false, -20.0f);
                    Platform.exit();
                } else if(response == botonCancelar) {
                    BotonSeleccionado.playSound(false, -20.0f);
                }
            });

        }

    }

}
