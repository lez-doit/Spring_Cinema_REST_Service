package com.example.cinema.models.services;

import com.example.cinema.models.configuration.SecurityConfiguration;
import com.example.cinema.models.dto.PurchaseResponse;
import com.example.cinema.models.dto.RefundResponse;
import com.example.cinema.models.dto.Ticket;
import com.example.cinema.models.entities.Room;
import com.example.cinema.models.entities.Seat;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class PurchaseService {
  private final Room room;
  private final InfoService infoService;
  private Map<String, Seat> tokens;

  public PurchaseService(Room room, InfoService infoService) {
    this.room = room;
    this.infoService = infoService;
    tokens = new HashMap<>();
  }

  public PurchaseResponse purchaseSeat(int row, int column) {
    Seat seat = infoService.getSeatByCoords(row, column);
    int price = seat.getPrice();
    seat.setTaken(true);

    Ticket ticket = new Ticket(row, column, price);

    String token = SecurityConfiguration.TokenGenerator.generateToken();
    tokens.put(token, seat);

    return new PurchaseResponse(token, ticket);
  }

  public boolean containsToken(String token) {
    return tokens.containsKey(token);
  }

  public RefundResponse refundTicket(String token) {
    Seat seat = tokens.get(token);

    Ticket ticket = new Ticket(seat.getRow(), seat.getColumn(), seat.getPrice());
    seat.setTaken(false);
    tokens.remove(token);

    return new RefundResponse(ticket);
  }
}
