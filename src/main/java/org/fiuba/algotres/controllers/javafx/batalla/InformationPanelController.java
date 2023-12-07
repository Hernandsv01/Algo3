package org.fiuba.algotres.controllers.javafx.batalla;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import lombok.Getter;
import org.fiuba.algotres.JuegoJavafx;
import org.fiuba.algotres.model.habilidad.Ataque;
import org.fiuba.algotres.model.habilidad.Habilidad;
import org.fiuba.algotres.utils.enums.BattleState;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

@Getter
public class InformationPanelController implements Initializable {
    private static final String ACTIVATED_LABEL_COLOR = "red";
    private static final String DEACTIVATED_LABEL_COLOR = "white";
    private final double DEFAULT_LABEL_WIDTH = 120;
    private List<Habilidad> habilidades;
    @Getter
    private static List<String> colaDeMensajes;
    @FXML
    private TextArea pantallaMensaje;
    @FXML
    private GridPane optionGrid;
    @FXML
    private HBox informationPanel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if(BattleController.getState() == BattleState.NO_EMPEZADA){
            colaDeMensajes = new ArrayList<>();
        }
        habilidades = new ArrayList<>();
    }

    public static void toggleLabel(Label label){
        String colorAttribute = Arrays.stream(label.getStyle().split(";")).filter(s -> s.contains("-fx-border-color")).toList().get(0);
        if(colorAttribute.contains(ACTIVATED_LABEL_COLOR)){
            label.setStyle(label.getStyle().replace(ACTIVATED_LABEL_COLOR, DEACTIVATED_LABEL_COLOR));
        }else if(colorAttribute.contains(DEACTIVATED_LABEL_COLOR)){
            label.setStyle(label.getStyle().replace(DEACTIVATED_LABEL_COLOR, ACTIVATED_LABEL_COLOR));
        }
    }

    public void loadHabilidades(){
        ObservableList<Node> elementos = informationPanel.getChildren();
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

    public void loadAcciones(){
        ObservableList<Node> elementos = informationPanel.getChildren();
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

    public void loadNextMessage() {
        pantallaMensaje.setText(colaDeMensajes.remove(0));
    }

    public void loadHabilidadInfo(){
        int posicionHabilidad = getGridElements().indexOf(getSelectedGridElement());
        Habilidad habilidad = habilidades.get(posicionHabilidad);
        String mensaje = "Usos: " + habilidad.getUsos() + "\n";
        if(habilidad instanceof Ataque){
            mensaje += "Tipo: " + ((Ataque) habilidad).getTipo();
        }
        pantallaMensaje.setText(mensaje);
    }

    public List<BorderPane> getGridElements(){
        return getOptionGrid().getChildren().stream()
                .filter(node -> node instanceof BorderPane)
                .map(node -> (BorderPane)node)
                .toList();
    }
    public BorderPane getSelectedGridElement(){
        return getGridElements().stream()
                .filter(borderPane -> borderPane.getCenter().getStyle().contains("-fx-border-color: red"))
                .findFirst().orElse(null);
    }

    public void setSelectedGridElement(int col, int row){
        BorderPane previousElement = getSelectedGridElement();
        if(previousElement != null) {
            toggleLabel((Label)previousElement.getCenter());
        }

        toggleLabel((Label)getGridElements().stream()
                .filter(borderPane -> GridPane.getRowIndex(borderPane) == row && GridPane.getColumnIndex(borderPane) == col)
                .toList().get(0).getCenter());
    }

    public void disableGrid(){
        toggleLabel((Label)getSelectedGridElement().getCenter());
        getGridElements().forEach(borderPane -> ((Label)borderPane.getCenter()).setText(""));
    }
}
