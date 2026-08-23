package sqa.lab.service;

import java.sql.SQLException;
import java.util.List;

public class SeatReservation {
    private SeatDAO seatDAO;

    public SeatReservation(SeatDAO seatDAO) {
        this.seatDAO = seatDAO;
    }

    public List<String> getAvailableSeats() throws SQLException {
        return seatDAO.fetchAvailableSeats();
    }
}