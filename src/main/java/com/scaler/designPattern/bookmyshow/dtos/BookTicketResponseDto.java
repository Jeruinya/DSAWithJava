package com.scaler.designPattern.bookmyshow.dtos;

import com.scaler.designPattern.bookmyshow.models.Ticket;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookTicketResponseDto {
    private ResponseStatus responseStatus;
    private Ticket ticket;
}

