package com.example.cinema.models.controllers;

import com.example.cinema.models.dto.*;
import com.example.cinema.models.entities.Room;
import com.example.cinema.models.services.InfoService;
import com.example.cinema.models.services.PurchaseService;
import com.example.cinema.models.utils.validators.PasswordValidator;
import com.example.cinema.models.utils.validators.PurchaseValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("")
public class CinemaController {

  private final InfoService infoService;
  private final PurchaseService purchaseService;
  private final PurchaseValidator purchaseValidator;
  private final PasswordValidator passwordValidator;

  @Autowired
  public CinemaController(
      PurchaseService purchaseService,
      InfoService infoService,
      PurchaseValidator purchaseValidator,
      PasswordValidator passwordValidator) {
    this.purchaseService = purchaseService;
    this.infoService = infoService;
    this.purchaseValidator = purchaseValidator;
    this.passwordValidator = passwordValidator;
  }

  @GetMapping("/seats")
  public Room getSeats() {
    return infoService.getRoom();
  }

  @PostMapping("/purchase")
  public ResponseEntity<PurchaseResponse> purchase(@RequestBody PurchaseRequest purchaseRequest) {
    purchaseValidator.validateRequest(purchaseRequest);

    int row = purchaseRequest.getRow();
    int column = purchaseRequest.getColumn();

    return new ResponseEntity<>(purchaseService.purchaseSeat(row, column), HttpStatus.OK);
  }

  @PostMapping("/return")
  public ResponseEntity<RefundResponse> refund(@RequestBody Token token) {
    purchaseValidator.validateToken(token);

    return new ResponseEntity<>(purchaseService.refundTicket(token.getToken()), HttpStatus.OK);
  }

  @GetMapping("/stats")
  public ResponseEntity<CinemaStatistic> getStatistic(
      @RequestParam(value = "password", required = false) String password) {
    passwordValidator.validate(password);
    return new ResponseEntity<>(infoService.collectStatistic(), HttpStatus.OK);
  }
}
