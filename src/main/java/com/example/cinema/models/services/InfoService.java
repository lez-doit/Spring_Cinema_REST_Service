package com.example.cinema.models.services;

import com.example.cinema.models.dto.CinemaStatistic;
import com.example.cinema.models.entities.Room;
import com.example.cinema.models.entities.Seat;
import org.springframework.stereotype.Service;

@Service
public class InfoService {
  private final Room room;

  public InfoService(Room room) {
    this.room = room;
  }

  public Room getRoom() {
    return room;
  }

  public Seat getSeatByCoords(int row, int col) {
    for (Seat seat : room.getAvailableSeats()) {
      if (seat.getRow() == row && seat.getColumn() == col) {
        return seat;
      }
    }
    return null;
  }

  public int getTotalRows() {
    return room.getTotalRows();
  }

  public int getTotalColumns() {
    return room.getTotalColumns();
  }

  public CinemaStatistic collectStatistic() {
    int income = 0;
    int sold = 0;
    int available = 0;

    for (Seat seat : room.getAvailableSeats()) {
        if(seat.isTaken()) {
            sold++;
            income += seat.getPrice();
        } else {
          available++;
        }
    }

    return new CinemaStatistic(income, available, sold);
  }
}
