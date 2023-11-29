package org.fiuba.algotres.controllers.javafx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import org.fiuba.algotres.JuegoJavafx;
import org.fiuba.algotres.model.Jugador;
import org.fiuba.algotres.model.Pokemon;
import org.fiuba.algotres.utils.GeneradorDeMensajes;
import org.fiuba.algotres.utils.ImageLoader;
import org.fiuba.algotres.utils.enums.DefaultImageType;
import org.fiuba.algotres.utils.enums.OpcionesEmergentes;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class CambiarPokemonController extends ItemPokemonController implements Initializable {
    private static final String UP_KEY = "UP";
    private static final String DOWN_KEY = "DOWN";
    private static final String RIGHT_KEY = "RIGHT";
    private static final String LEFT_KEY = "LEFT";
    private static final String ENTER_KEY = "ENTER";
    private static final String ESCAPE_KEY = "ESCAPE";
    private static final String ACTIVATED_PANE_COLOR = "#efb810";
    private static final String DESACTIVATED_POKEMON_COLOR = "#0f2c64";
    private static final String DESACTIVATED_VOLVER_PANE_COLOR = "#610000";
    private static final int CANTIDAD_DE_OPCIONES = 6;
    @FXML
    public ProgressBar BarraActual;
    @FXML
    public ImageView EstadoActual;
    @FXML
    public ImageView ImagenActual;
    @FXML
    public Label NombreActual;
    @FXML
    public Label TipoActual;
    @FXML
    public Label NivelActual;
    @FXML
    public Label VidaActual;
    @FXML
    public ImageView Estado1;
    @FXML
    public ImageView Imagen1;
    @FXML
    public Label Nombre1;
    @FXML
    public Label Tipo1;
    @FXML
    public Label Nivel1;
    @FXML
    public Label Vida1;
    @FXML
    public ProgressBar Barra1;
    @FXML
    public ImageView Estado2;
    @FXML
    public ImageView Imagen2;
    @FXML
    public Label Nombre2;
    @FXML
    public Label Tipo2;
    @FXML
    public Label Nivel2;
    @FXML
    public Label Vida2;
    @FXML
    public ProgressBar Barra2;
    @FXML
    public ImageView Estado3;
    @FXML
    public ImageView Imagen3;
    @FXML
    public Label Nombre3;
    @FXML
    public Label Tipo3;
    @FXML
    public Label Nivel3;
    @FXML
    public Label Vida3;
    @FXML
    public ProgressBar Barra3;
    @FXML
    public ImageView Estado4;
    @FXML
    public ImageView Imagen4;
    @FXML
    public Label Nombre4;
    @FXML
    public Label Tipo4;
    @FXML
    public Label Nivel4;
    @FXML
    public Label Vida4;
    @FXML
    public ProgressBar Barra4;
    @FXML
    public ImageView Estado5;
    @FXML
    public ImageView Imagen5;
    @FXML
    public Label Nombre5;
    @FXML
    public Label Tipo5;
    @FXML
    public Label Nivel5;
    @FXML
    public Label Vida5;
    @FXML
    public ProgressBar Barra5;
    @FXML
    public AnchorPane botonVolver;
    @FXML
    private VBox vBox1;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadPokemonesJugadorActual();
        setSelectedSceneElement(0);
    }

    @FXML
    public void onKeyTyped(KeyEvent event) throws IOException {
        String tecla = event.getCode().toString();
        System.out.println("Key pressed: " + tecla);

        switch (tecla) {
            case UP_KEY, DOWN_KEY, RIGHT_KEY, LEFT_KEY -> moveSelector(tecla);
            case ENTER_KEY -> select();
            case ESCAPE_KEY -> goBack("/fxml/BattleScreen.fxml");
        }
    }

    private List<AnchorPane> getSceneElements() {
        List<AnchorPane> v1 = new ArrayList<>(vBox1.getChildren().stream()
                .filter(node -> node instanceof AnchorPane)
                .map(node -> (AnchorPane) node)
                .toList());
        v1.add(botonVolver);
        return v1;
    }

    private AnchorPane getSelectedSceneElement(){
        return getSceneElements().stream()
                .filter(anchorPane -> anchorPane.getStyle().contains("-fx-border-color: #efb810"))
                .findFirst().orElse(null);
    }

    private void setSelectedSceneElement(int pos){
        AnchorPane previousElement = getSelectedSceneElement();

        if (previousElement != null) {
            togglePane(previousElement, ACTIVATED_PANE_COLOR, DESACTIVATED_VOLVER_PANE_COLOR, DESACTIVATED_POKEMON_COLOR);
        }
        togglePane(getSceneElements().get(pos), ACTIVATED_PANE_COLOR, DESACTIVATED_VOLVER_PANE_COLOR, DESACTIVATED_POKEMON_COLOR);
    }

    private void moveSelector(String tecla){
        AnchorPane currentElement = getSelectedSceneElement();
        if(currentElement == null) return;

        int actualPos = coordenadas(currentElement);
        int newPos = 0;
        switch (tecla) {
            case UP_KEY -> newPos = verifyPosition(actualPos - 1, CANTIDAD_DE_OPCIONES);
            case DOWN_KEY -> newPos = verifyPosition(actualPos + 1, CANTIDAD_DE_OPCIONES);
            case RIGHT_KEY -> {
                if (actualPos == CANTIDAD_DE_OPCIONES - 2) {
                newPos = verifyPosition(actualPos + 1, CANTIDAD_DE_OPCIONES);
                }
            }
            case LEFT_KEY -> newPos = verifyPosition(actualPos, CANTIDAD_DE_OPCIONES);
            default -> newPos = -1;
        };

        if(newPos == -1){
            return;
        }
        setSelectedSceneElement(newPos);
    }

    private int coordenadas(AnchorPane element) {
        return getSceneElements().indexOf(element);
    }

    private void select() {
        AnchorPane selectedElement = getSelectedSceneElement();
        String selectedElementId = selectedElement.getId();
        int selectedPos = verifyPosition(coordenadas(selectedElement), CANTIDAD_DE_OPCIONES);
        if (selectedPos != -1) {
            if (!Objects.equals(selectedElementId, "botonVolver")) {
                //codigo que aplique item
                Pokemon pokemon = JuegoJavafx.getCdb().getJugadorActual().getPokemons().get(selectedPos+1);
                if (pokemon.getVidaActual() <= 0) {
                    return;
                }
                OpcionesEmergentes result = confirmarDecision("Estas seguro que deseas elegir a " + pokemon.getNombre() + " para ingresar a la batalla?");
                if (result == OpcionesEmergentes.CONFIRMADA) {
                    try {
                        JuegoJavafx.getCdb().getJugadorActual().cambiarPokemonActual(selectedPos+1);
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/BattleScreen.fxml"));
                        Scene scene = new Scene(loader.load());
                        JuegoJavafx.setScene(scene, true);

                        BattleController battleController = loader.getController();
                        battleController.getColaDeMensajes().add(pokemon.getNombre() + " entra a la batalla!");
                        battleController.accionar();
                    } catch (IOException e) {
                        System.out.println("Error en la carga de BattleScreen.fxml");
                    }
                } else {
                    goBack("/fxml/BattleScreen.fxml");
                }
            }
        }
    }

    private List<Label> getLabel(String tipo) {
        ArrayList<Label> list = new ArrayList<>();

        switch (tipo) {
            case "Nombre":
                list.add(NombreActual);
                list.add(Nombre1);
                list.add(Nombre2);
                list.add(Nombre3);
                list.add(Nombre4);
                list.add(Nombre5);

            case "Tipo":
                list.add(TipoActual);
                list.add(Tipo1);
                list.add(Tipo2);
                list.add(Tipo3);
                list.add(Tipo4);
                list.add(Tipo5);

            case "Nivel":
                list.add(NivelActual);
                list.add(Nivel1);
                list.add(Nivel2);
                list.add(Nivel3);
                list.add(Nivel4);
                list.add(Nivel5);

            case "Vida":
                list.add(VidaActual);
                list.add(Vida1);
                list.add(Vida2);
                list.add(Vida3);
                list.add(Vida4);
                list.add(Vida5);
        }
        return list;
    }

    private List<ProgressBar> getLifeBars() {
        ArrayList<ProgressBar> list = new ArrayList<>();
        list.add(BarraActual);
        list.add(Barra1);
        list.add(Barra2);
        list.add(Barra3);
        list.add(Barra4);
        list.add(Barra5);
        return list;
    }

    private List<ImageView> getImages(String tipo) {
        ArrayList<ImageView> list = new ArrayList<>();
        switch (tipo) {
            case "Portada":
                list.add(ImagenActual);
                list.add(Imagen1);
                list.add(Imagen2);
                list.add(Imagen3);
                list.add(Imagen4);
                list.add(Imagen5);
            case "Estado":
                list.add(EstadoActual);
                list.add(Estado1);
                list.add(Estado2);
                list.add(Estado3);
                list.add(Estado4);
                list.add(Estado5);
        }
        return list;
    }

    private void loadPokemonesJugadorActual() {
        Jugador jugadorActual = JuegoJavafx.getCdb().getJugadorActual();
        List<Pokemon> pokemons = jugadorActual.getPokemons();
        List<Label> labelsNombre = getLabel("Nombre");
        List<Label> labelsTipo = getLabel("Tipo");
        List<Label> labelsNivel = getLabel("Nivel");
        List<Label> labelsVida = getLabel("Vida");
        List<ProgressBar> lifeBars = getLifeBars();
        List<ImageView> imagesPortadas = getImages("Portada");
        List<ImageView> imagesEstados = getImages("Estado");

        for (int i = 0; i < CANTIDAD_DE_OPCIONES; i++) {
            String name = pokemons.get(i).getNombre();
            String type = pokemons.get(i).getTipos().toString();
            String level = pokemons.get(i).getNivel().toString();
            int lifeActual = pokemons.get(i).getVidaActual();
            int lifeMax = pokemons.get(i).getVidaMaxima();
            ProgressBar bar = lifeBars.get(i);

            labelsNombre.get(i).setText(name);
            labelsNivel.get(i).setText("Nv. " + level);
            labelsTipo.get(i).setText(type.toUpperCase());
            labelsVida.get(i).setText("PS. " + lifeActual + "/" + lifeMax);
            bar.setProgress((double) lifeActual/lifeMax);

            try {
                imagesPortadas.get(i).setImage(ImageLoader.getJavafxImage("/imagenes/pokemons/" + name + "-portada.png", DefaultImageType.POKEMON));
            } catch (Exception e) {
              e.printStackTrace();
            }

            if (!pokemons.get(i).getEstados().isEmpty()) {
                switch (pokemons.get(i).getEstados().get(0).getNombre()) {
                    case "Paralizado" -> imagesEstados.get(i).setImage(ImageLoader.getJavafxImage("imagenes/estados/Paralizado.gif", DefaultImageType.ESTADO));
                    case "Envenenado" -> imagesEstados.get(i).setImage(ImageLoader.getJavafxImage("imagenes/estados/Envenenado.gif", DefaultImageType.ESTADO));
                    case "Dormido" -> imagesEstados.get(i).setImage(ImageLoader.getJavafxImage("imagenes/estados/Dormido.gif", DefaultImageType.ESTADO));
                    case "Confuso" -> imagesEstados.get(i).setImage(ImageLoader.getJavafxImage("imagenes/estados/Confuso.gif", DefaultImageType.ESTADO));
                    default -> imagesEstados.get(i).setImage(ImageLoader.getJavafxImage("imagenes/estados/SinEstado.gif", DefaultImageType.ESTADO));
                }
            }
        }
    }
}
