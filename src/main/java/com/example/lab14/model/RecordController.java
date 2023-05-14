package com.example.lab14.model;

import com.example.lab14.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;

public class RecordController implements Initializable {
    @FXML
    private Label balanceLB;

    @FXML
    private TableColumn<Record, Double> cantidadTC;

    @FXML
    private TableColumn<Record, String> descripcionTC;

    @FXML
    private TableColumn<Record, LocalDate> fechaTC;

    @FXML
    private Button gastosBTN;

    @FXML
    private Button ingresosBTN;

    @FXML
    private Button menuPrincipalBTN;

    @FXML
    private TableView<Record> recordsTV;

    @FXML
    private Button vistaCombinadaBtn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cantidadTC.setCellValueFactory(new PropertyValueFactory<>("value"));
        descripcionTC.setCellValueFactory(new PropertyValueFactory<>("description"));
        fechaTC.setCellValueFactory(new PropertyValueFactory<>("date"));
        recordsTV.setItems(RecordList.getInstance().getRecords());
        recordsTV.getSortOrder().add(fechaTC);
        balanceLB.setText(String.valueOf(RecordList.getInstance().getBalance()));
        fechaTC.setSortType(TableColumn.SortType.DESCENDING);
    }

    @FXML
    void back2MainMenu(ActionEvent event) {
        Stage stage = (Stage) this.menuPrincipalBTN.getScene().getWindow();
        stage.close();
        HelloApplication.openWindow("register.fxml");
    }

    @FXML
    void showBoth(ActionEvent event) {
        recordsTV.setItems(RecordList.getInstance().getRecords());
        recordsTV.getSortOrder().add(fechaTC);
        fechaTC.setSortType(TableColumn.SortType.DESCENDING);
    }

    @FXML
    void showExpenses(ActionEvent event) {
        recordsTV.setItems(RecordList.getInstance().getExpenses());
        recordsTV.getSortOrder().add(fechaTC);
        fechaTC.setSortType(TableColumn.SortType.DESCENDING);
    }

    @FXML
    void showIncomes(ActionEvent event) {
        recordsTV.setItems(RecordList.getInstance().getIncomes());
        recordsTV.getSortOrder().add(fechaTC);
        fechaTC.setSortType(TableColumn.SortType.DESCENDING);
    }

}