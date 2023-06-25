package com.hostfully.application.service;

import com.hostfully.application.model.Booking;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookingService {
    private final Map<Long, Booking> bookings = new HashMap<>();

    public Booking createBooking(Booking booking) {
        long bookingId = generateBookingId();
        booking.setId(bookingId);
        bookings.put(bookingId, booking);
        return booking;
    }

    public Booking getBooking(Long bookingId) {
        return bookings.get(bookingId);
    }

    public void cancelBooking(Long bookingId) {
        bookings.remove(bookingId);
    }

    public Booking rebookBooking(Long bookingId, Booking booking) {
        bookings.put(bookingId, booking);
        return booking;
    }

    private long generateBookingId() {
        // Generate a unique booking ID here (e.g., using a counter or UUID)
        // Replace the return statement with your actual implementation
        return System.currentTimeMillis();
    }

    public List<Booking> getAllBookings() {
        List<Booking> bookingList = new ArrayList<Booking>(bookings.values());
        return bookingList;
    }
}
