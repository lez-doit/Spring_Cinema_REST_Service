package com.example.cinema.models.dto;

public class PurchaseRequest {
    int row;
    int column;

    public PurchaseRequest() {
    }

    public PurchaseRequest(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    @Override
    public String toString() {
        return "PurchaseRequest{" +
                "row=" + row +
                ", column=" + column +
                '}';
    }
}
