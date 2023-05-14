package com.example.lab14.model;

import com.example.lab14.HelloApplication;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class RegisterController implements Initializable {

    @FXML
    private Button agregarBTN;
    @FXML
    private Button eliminarBTN;

    @FXML
    private Button verMovimientosBTN;

    @FXML
    private Label balanceLabel;

    @FXML
    private DatePicker datePicker;

    @FXML
    private TextField descripcionTF;

    @FXML
    private TextField montoTF;

    @FXML
    private ComboBox<String> optionsCB;

    @FXML
    void add(ActionEvent event) {
        try {
            double value = 0;
            String description = descripcionTF.getText();
            System.out.println(description);
            LocalDate date = datePicker.getValue();
            Type type = null;
            String option = optionsCB.getValue();
            if(option.equals("INGRESO")) {
                type = Type.INGRESO;
                value = Double.parseDouble(montoTF.getText());
            }else if(option.equals("GASTO")) {
                type = Type.GASTO;
                value = -1 * Double.parseDouble(montoTF.getText());
                System.out.println(value);
            }else {

            }
            Record record = new Record(value, type, description, date);
            RecordList.getInstance().getRecords().add(record);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("¡Registro exitoso!");
            alert.setContentText("El registro ha sido agregado satisfactoriamente..");
            alert.showAndWait();
        } catch (RuntimeException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("¡Error!");
            alert.setContentText("El registro no ha sido agregado.");
            alert.showAndWait();
            ex.printStackTrace();
        }
        balanceLabel.setText(RecordList.getInstance().getBalance());
        montoTF.setText(null);
        descripcionTF.setText(null);
        optionsCB.setPromptText(null);
        datePicker.setPromptText(null);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        balanceLabel.setText(RecordList.getInstance().getBalance());
        ObservableList olist = FXCollections.observableArrayList();
        olist.add("INGRESO");
        olist.add("GASTO");
        optionsCB.setItems(olist);
        optionsCB.setPromptText("Elija una opción");
    }

    @FXML
    void delete(ActionEvent event) {
        try {
            double value = 0;
            String description = descripcionTF.getText();
            LocalDate date = datePicker.getValue();
            Type type = null;
            String option = optionsCB.getValue();
            if(option.equals("INGRESO")) {
                type = Type.INGRESO;
                value = Double.parseDouble(montoTF.getText());
            }else if(option.equals("GASTO")) {
                type = Type.GASTO;
                value = -1*Double.parseDouble(montoTF.getText());
            }else {

            }
            if (RecordList.getInstance().delete(date, type, value, description)) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("¡Eliminación exitosa!");
                alert.setContentText("El registro ha sido eliminado satisfactoriamente.");
                alert.showAndWait();
            }
            else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("¡Error!");
                alert.setContentText("Registro no encontrado.");
                alert.showAndWait();
            }
        } catch (RuntimeException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("¡Error!");
            alert.setContentText("No ha sido posible eliminar el registro.");
            alert.showAndWait();
            ex.printStackTrace();
        }
        balanceLabel.setText(RecordList.getInstance().getBalance());
        montoTF.setText(null);
        descripcionTF.setText(null);
        optionsCB.setPromptText(null);
        datePicker.setPromptText(null);
    }

    @FXML
    void viewRecords(ActionEvent event){
        Stage stage = (Stage) this.montoTF.getScene().getWindow();
        stage.close();
        HelloApplication.openWindow("hello-view.fxml");
    }
}
