package com.example.cinema.models.utils.validators;

import com.example.cinema.models.dto.PurchaseRequest;
import com.example.cinema.models.dto.Token;
import com.example.cinema.models.entities.Seat;
import com.example.cinema.models.services.InfoService;
import com.example.cinema.models.services.PurchaseService;
import com.example.cinema.models.utils.errors.InvalidSeatError;
import com.example.cinema.models.utils.errors.InvalidTokenError;
import org.springframework.stereotype.Service;

@Service
public class PurchaseValidator {
    private final InfoService infoService;
    private final PurchaseService purchaseService;

    public PurchaseValidator(InfoService infoService, PurchaseService purchaseService) {
        this.infoService = infoService;
        this.purchaseService = purchaseService;
    }

    public void validateRequest(PurchaseRequest request) {
        int requestRow = request.getRow();
        int requestColumn = request.getColumn();
        int actualRows = infoService.getTotalRows();
        int actualColumns = infoService.getTotalColumns();

        if (requestRow < 0
                || requestRow > actualRows
                || requestColumn < 0
                || requestColumn > actualColumns) {
            throw new InvalidSeatError("The number of a row or a column is out of bounds!");
        }

        Seat requestedSeat = infoService.getSeatByCoords(requestRow, requestColumn);
        if(requestedSeat.isTaken()) {
            throw new InvalidSeatError("The ticket has been already purchased!");
        }
    }

    public void validateToken(Token token) {
        if(!purchaseService.containsToken(token.getToken())) {
            throw new InvalidTokenError("Wrong token!");
        }
    }
}
