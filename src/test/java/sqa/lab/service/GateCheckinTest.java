package sqa.lab.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class GateCheckinTest {

    @Mock
    private TicketCounter ticketCounter;

    private GateCheckin gateCheckin;

    @BeforeEach
    public void setUp() {
        gateCheckin = new GateCheckin(ticketCounter);
    }

    @Test
    public void testCustomerEntrySuccess() {
        int ticketId = 101;

        // Act
        gateCheckin.customerEntry(ticketId);

        // Assert & Verify
        assertTrue(gateCheckin.getPassengersOnBoard().contains(ticketId));
        verify(ticketCounter).changeTicketStatus(true);
    }

    @Test
    public void testCustomerEntryDuplicate() {
        int ticketId = 101;

        // Entry ครั้งที่ 1 และ ครั้งที่ 2
        gateCheckin.customerEntry(ticketId);
        gateCheckin.customerEntry(ticketId);

        // Verify ว่า ticketCounter ถูกเรียกแค่ 1 ครั้งเท่านั้น
        verify(ticketCounter, times(1)).changeTicketStatus(true);
        assertEquals(1, gateCheckin.getPassengersOnBoard().size());
    }
}