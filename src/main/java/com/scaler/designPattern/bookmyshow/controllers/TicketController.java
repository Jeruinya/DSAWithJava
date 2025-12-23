package com.scaler.designPattern.bookmyshow.controllers;

import com.scaler.designPattern.bookmyshow.dtos.BookTicketRequestDto;
import com.scaler.designPattern.bookmyshow.dtos.BookTicketResponseDto;
import com.scaler.designPattern.bookmyshow.exceptions.ShowSeatNotAvailableException;
import com.scaler.designPattern.bookmyshow.models.Ticket;
import com.scaler.designPattern.bookmyshow.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class TicketController {
    private TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public BookTicketResponseDto bookTicket(BookTicketRequestDto request) throws ShowSeatNotAvailableException {
        Ticket ticket = ticketService.bookTicket(
                request.getShowSeatIds(),
                request.getUserId(),
                request.getShowId()
        );



        return null;
    }
}
