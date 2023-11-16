package org.fiuba.algotres.controllers.javafx;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import org.fiuba.algotres.model.CampoDeBatalla;
import org.fiuba.algotres.model.habilidad.Habilidad;

import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class BattleController implements Initializable{
    private static final String UP_KEY = "UP";
    private static final String DOWN_KEY = "DOWN";
    private static final String RIGHT_KEY = "RIGHT";
    private static final String LEFT_KEY = "LEFT";
    private static final String ENTER_KEY = "ENTER";
    private static final String ESCAPE_KEY = "ESCAPE";
    private static final String ACTIVATED_LABEL_COLOR = "red";
    private static final String DEACTIVATED_LABEL_COLOR = "white";


    @FXML
    private AnchorPane rootPane;

    @FXML
    private GridPane optionGrid;

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

        if(tecla.equals(UP_KEY) || tecla.equals(DOWN_KEY) || tecla.equals(RIGHT_KEY) || tecla.equals(LEFT_KEY)){
            moveSelector(tecla);
        }else if(tecla.equals(ENTER_KEY)){
            select();
        }else if(tecla.equals(ESCAPE_KEY)){
            goBack();
        }

    }

    private void moveSelector(String tecla){
        BorderPane currentElement = getSelectedGridElement();
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

        setSelectedGridElement(newPos.posCol(), newPos.posRow());
    }

    private void select() {
        BorderPane selectedElement = getSelectedGridElement();
        Coordinate selectedPos = new Coordinate(GridPane.getColumnIndex(selectedElement), GridPane.getRowIndex(selectedElement));

        if(selectedPos.posCol == 0 && selectedPos.posRow == 0){
            loadHabilidades();
        }else if(selectedPos.posCol == 1 && selectedPos.posRow == 0){
            System.out.println("Items todavía no fue implementado");
        }else if(selectedPos.posCol == 0 && selectedPos.posRow == 1){
            System.out.println("Cambiar todavía no fue implementado");
        }else if(selectedPos.posCol == 1 && selectedPos.posRow == 1){
            System.out.println("Rendirse todavía no fue implementado");
        }
    }

    private void goBack() {
    }

    private void loadHabilidades(){
        for(int i = 0; i < getGridElements().size(); i++){
            ((Label)getGridElements().get(i).getCenter()).setText(JavafxController.getCdb().getJugadorActual().getPokemonActual().getHabilidades().get(i).getNombre());
        }
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
                .toList().get(0);
    }

    private void setSelectedGridElement(int col, int row){
        toggleLabel((Label)getSelectedGridElement().getCenter());

        toggleLabel((Label)getGridElements().stream()
                .filter(borderPane -> GridPane.getRowIndex(borderPane) == row && GridPane.getColumnIndex(borderPane) == col)
                .toList().get(0).getCenter());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        rootPane.requestFocus();
    }

    private record Coordinate(int posCol, int posRow) {
    }
}
