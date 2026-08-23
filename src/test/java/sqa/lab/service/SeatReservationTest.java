package sqa.lab.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class SeatReservationTest {

    @Mock
    private SeatDAO seatDAO;

    private SeatReservation seatReservation;

    @BeforeEach
    public void setUp() {
        seatReservation = new SeatReservation(seatDAO);
    }

    @Test
    public void testGetAvailableSeats() throws SQLException {
        // Arrange
        List<String> mockSeats = Arrays.asList("A1", "A2", "B1");
        when(seatDAO.fetchAvailableSeats()).thenReturn(mockSeats);

        // Act
        List<String> availableSeats = seatReservation.getAvailableSeats();

        // Assert
        assertEquals(3, availableSeats.size());
        assertEquals("A1", availableSeats.get(0));
    }
}