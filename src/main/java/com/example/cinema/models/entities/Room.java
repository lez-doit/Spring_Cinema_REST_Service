package com.example.cinema.models.entities;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private static final Room instance = new Room();
    private int totalRows;
    private int totalColumns;
    private List<Seat> availableSeats;

    public Room(int totalRows, int totalColumns, List<Seat> availableSeats) {
        this.totalRows = totalRows;
        this.totalColumns = totalColumns;
        this.availableSeats = availableSeats;
    }

    public Room() {
        this.totalRows = 9;
        this.totalColumns = 9;
        availableSeats = new ArrayList<>();

        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                int price = (i+1 <= 4) ? 10 : 8;
                availableSeats.add(new Seat(i+1, j+1, price));
            }
        }
    }

    public static Room getInstance() {
        return instance;
    }

    public int getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }

    public int getTotalColumns() {
        return totalColumns;
    }

    public void setTotalColumns(int totalColumns) {
        this.totalColumns = totalColumns;
    }

    public List<Seat> getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(List<Seat> availableSeats) {
        this.availableSeats = availableSeats;
    }

    @Override
    public String toString() {
        return "Room{" +
                "totalRows=" + totalRows +
                ", totalColumns=" + totalColumns +
                ", availableSeats=" + availableSeats +
                '}';
    }
}
