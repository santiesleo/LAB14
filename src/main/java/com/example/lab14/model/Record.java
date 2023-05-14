package com.example.lab14.model;

import java.time.LocalDate;
import java.util.Date;

public class Record {
    private double value;
    private Type type;
    private String description;
    private LocalDate date;

    public Record(double value, Type type, String description, LocalDate date) {
        this.value = value;
        this.type = type;
        this.description = description;
        this.date = date;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
