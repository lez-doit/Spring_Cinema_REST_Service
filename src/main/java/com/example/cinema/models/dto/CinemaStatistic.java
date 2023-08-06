package com.example.cinema.models.dto;

public class CinemaStatistic {
  int currentIncome;
  int numberOfAvailableSeats;
  int numberOfPurchasedTickets;

  public CinemaStatistic(
      int currentIncome, int numberOfAvailableSeats, int numberOfPurchasedTickets) {
    this.currentIncome = currentIncome;
    this.numberOfAvailableSeats = numberOfAvailableSeats;
    this.numberOfPurchasedTickets = numberOfPurchasedTickets;
  }

    public int getCurrentIncome() {
        return currentIncome;
    }

    public void setCurrentIncome(int currentIncome) {
        this.currentIncome = currentIncome;
    }

    public int getNumberOfAvailableSeats() {
        return numberOfAvailableSeats;
    }

    public void setNumberOfAvailableSeats(int numberOfAvailableSeats) {
        this.numberOfAvailableSeats = numberOfAvailableSeats;
    }

    public int getNumberOfPurchasedTickets() {
        return numberOfPurchasedTickets;
    }

    public void setNumberOfPurchasedTickets(int numberOfPurchasedTickets) {
        this.numberOfPurchasedTickets = numberOfPurchasedTickets;
    }

    @Override
    public String toString() {
        return "CinemaStatistic{" +
                "currentIncome=" + currentIncome +
                ", numberOfAvailableSeats=" + numberOfAvailableSeats +
                ", numberOfPurchasedTickets=" + numberOfPurchasedTickets +
                '}';
    }
}
