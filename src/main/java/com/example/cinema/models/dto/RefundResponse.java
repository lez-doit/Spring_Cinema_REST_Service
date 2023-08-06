package com.example.cinema.models.dto;

public class RefundResponse {
    Ticket returnedTicket;

    public RefundResponse(Ticket returnedTicket) {
        this.returnedTicket = returnedTicket;
    }

    public Ticket getReturnedTicket() {
        return returnedTicket;
    }

    public void setReturnedTicket(Ticket returnedTicket) {
        this.returnedTicket = returnedTicket;
    }

    @Override
    public String toString() {
        return "RefundResponse{" +
                "returnedTicket=" + returnedTicket +
                '}';
    }
}
