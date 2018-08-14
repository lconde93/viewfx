package com.vglc.wordstyle;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.DepthTest;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class FXMLController implements Initializable {
    
    @FXML
    private FlowPane flowPane;   
    
    @FXML
    private AnchorPane anchorPane;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        VBox labelVBox1 = new VBox();
        VBox inputVBox = new VBox();
        VBox labelVBox2 = new VBox();
        VBox choiceVBox = new VBox();
        HBox mainHBox = new HBox();
        mainHBox.setSpacing(10);
        labelVBox1.setSpacing(10);
        inputVBox.setSpacing(5);
        labelVBox2.setSpacing(10);
        choiceVBox.setSpacing(5);
        
        String[] stringArray = {"Primera", "Segunda", "Tercera"};
        
        for(int counter = 0; counter < 3; counter ++) {            
            HBox labelHBox1 = new HBox();
            HBox labelHBox2 = new HBox();
            
            labelHBox1.setPrefHeight(14);
            labelHBox2.setPrefHeight(14);
            
            labelHBox1.getChildren().add(new Label("Ingrese la " + stringArray[counter]  + " parte de la palabra."));
            labelHBox2.getChildren().add(new Label("Seleccion el estilo de la " + stringArray[counter] + " parte de la palabra."));
            
            labelHBox1.setAlignment(Pos.CENTER_LEFT);            
            labelHBox2.setAlignment(Pos.CENTER_LEFT);
            
            labelVBox1.getChildren().add(labelHBox1);
            labelVBox1.setAlignment(Pos.CENTER_LEFT);
            
            labelVBox2.getChildren().add(labelHBox2);
            
                        
//            labelVBox1.getChildren().add(new Label("Ingrese la  parte de la palabra."));
            TextField textField = new TextField();
            textField.setId("textField" + counter);
            inputVBox.getChildren().add(textField);
            
            
//            labelVBox2.getChildren().add(new Label("Seleccion el estilo de la  parte de la palabra."));
            ComboBox comboBox = new ComboBox(FXCollections.observableArrayList("Normal", "Cursiva", "Subrayada"));            
            comboBox.setId("choiceBox" + counter);
            comboBox.focusedProperty().addListener((observable, oldValue, newValue) -> {
                if(!newValue && comboBox.getValue() == null) {
                    Alert alert = new Alert(AlertType.WARNING);
                    alert.setTitle("Main Alert");
                    alert.setHeaderText(null);
                    alert.setContentText("Se requiere un valor.");
                    alert.showAndWait();                           
                }
            });
            comboBox.setOnAction(e -> printId(comboBox.getId(), (String)comboBox.getValue()));
            choiceVBox.getChildren().add(comboBox);
            choiceVBox.setAlignment(Pos.CENTER);                                                            
        }        
//        vbox.setAlignment(Pos.CENTER);
        mainHBox.getChildren().add(labelVBox1);
        mainHBox.getChildren().add(inputVBox);
        mainHBox.getChildren().add(labelVBox2);
        mainHBox.getChildren().add(choiceVBox);
        mainHBox.setPadding(new Insets(10, 10, 10, 10));
        this.flowPane.getChildren().add(mainHBox);
    }
    
    private void printId(String id, String value) {
        System.out.println("desde la funcion imprimiendo id: " + id + " - valor: " + value);

    }
}
