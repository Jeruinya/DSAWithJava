package com.scaler.designPattern.bookmyshow.services;

import com.scaler.designPattern.bookmyshow.exceptions.ShowSeatNotAvailableException;
import com.scaler.designPattern.bookmyshow.models.*;
import com.scaler.designPattern.bookmyshow.repositories.ShowSeatRepository;
import com.scaler.designPattern.bookmyshow.repositories.TicketRepository;
import com.scaler.designPattern.bookmyshow.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {
    private ShowSeatRepository showSeatRepository;
    private TicketRepository ticketRepository;
    private UserRepository userRepository;

    @Autowired
    public TicketService(ShowSeatRepository showSeatRepository,
                         TicketRepository ticketRepository,
                         UserRepository userRepository) {
        this.showSeatRepository = showSeatRepository;
        this.ticketRepository = ticketRepository;
        this.userRepository = userRepository;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
   public Ticket bookTicket(List<Long> showSeatIds,
                            Long userId,
                            Long showId) throws ShowSeatNotAvailableException {
       // 1. Fetch show seats from the DB
       List<ShowSeat> showSeats = showSeatRepository.findAllByIdIn(showSeatIds);

       // 2. Check status of those show seats

       for (ShowSeat showSeat: showSeats) {
           if (!showSeat.getState().equals(ShowSeatState.AVAILABLE)) {
               throw new ShowSeatNotAvailableException(showSeat.getId());
           }
       }

       // 3. If any of them is not in AVAIALBLE state throw exception
       // 4. Take a lock
       // 5. Again check if all are available./
       for (ShowSeat showSeat: showSeats) {
           showSeat.setState(ShowSeatState.LOCKED);
           showSeatRepository.save(showSeat);
       }

       // 6. If yes, create a new object of ticket and store
       Ticket ticket = new Ticket();

       Optional<User> userOptional = userRepository.findById(userId);

       if (userOptional.isEmpty()) {

       }

       ticket.setBookedBy(userOptional.get());
       ticket.setTicketStatus(TicketStatus.PENDING);
       ticket.setShowSeats(showSeats);

       return ticketRepository.save(ticket);
    }
}
