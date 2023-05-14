package com.example.lab14.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;

public class RecordList {
    ObservableList<Record> records = FXCollections.observableArrayList();

    private RecordList() {}

    private static RecordList instance = null;

    public static RecordList getInstance() {
        if(instance == null){
            instance = new RecordList();
        }
        return instance;
    }

    public boolean delete(LocalDate date, Type type, double value, String desc) {
        for (int i = 0; i < records.size(); i++){
            if(date.compareTo(records.get(i).getDate()) == 0){
                if(value == records.get(i).getValue()){
                    if(type.equals(records.get(i).getType())){
                        if (desc.equalsIgnoreCase(records.get(i).getDescription())){
                            records.remove(i);
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public String getBalance(){
        double counter = 0;
        for (Record record : records) {
            counter += record.getValue();
        }
        return String.valueOf(counter);
    }

    public ObservableList<Record> getIncomes(){
        ObservableList<Record> incomes = FXCollections.observableArrayList();;
        for (Record record : records) {
            if (record.getValue() > 0) {
                incomes.add(record);
            }
        }
        return incomes;
    }

    public ObservableList<Record> getExpenses(){
        ObservableList<Record> expenses = FXCollections.observableArrayList();;
        for (Record record : records) {
            if (record.getValue() < 0) {
                expenses.add(record);
            }
        }
        return expenses;
    }

    public ObservableList<Record> getRecords() {
        return records;
    }

    public void setRecords(ObservableList<Record> records) {
        this.records = records;
    }
}
