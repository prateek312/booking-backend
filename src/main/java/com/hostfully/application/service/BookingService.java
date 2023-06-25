package com.hostfully.application.service;

import com.hostfully.application.util.OverlappingIntervalException;
import com.hostfully.application.model.Blocking;
import com.hostfully.application.model.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookingService {

    @Autowired
    private BlockingService blockingService;
    private final Map<Long, Booking> bookings = new HashMap<>();

    public Booking createBooking(Booking booking) {
        long bookingId = generateBookingId();
        booking.setId(bookingId);

        if (isIntervalOverlapping(booking)) {
            throw new OverlappingIntervalException("The booking interval is overlapping with an existing booking or blocked dates.");
        }

        bookings.put(bookingId, booking);
        return booking;
    }

    private boolean isIntervalOverlapping(Booking newBooking) {

        for (Booking existingBooking : bookings.values()) {
            if (isOverlapWithBooking(existingBooking, newBooking)) {
                return true;
            }
        }

        final List<Blocking> blockings = blockingService.getAllBlockings();
        for (Blocking existingBlocking : blockings) {
            if (isOverlapWithBlocking(existingBlocking, newBooking)) {
                return true;
            }
        }
        return false;
    }

    private boolean isOverlapWithBlocking(Blocking blocking, Booking newBooking) {
        return (blocking.getStartDate().compareTo(newBooking.getStartDate()) <= 0 && blocking.getEndDate().compareTo(newBooking.getStartDate()) >= 0)
                || (newBooking.getStartDate().compareTo(blocking.getStartDate()) <= 0 && newBooking.getEndDate().compareTo(blocking.getStartDate()) >= 0);
    }

    private boolean isOverlapWithBooking(Booking booking1, Booking booking2) {
        // Check if the start or end date of one booking falls within the start and end date of the other booking
        return (booking1.getStartDate().compareTo(booking2.getStartDate()) <= 0 && booking1.getEndDate().compareTo(booking2.getStartDate()) >= 0)
                || (booking2.getStartDate().compareTo(booking1.getStartDate()) <= 0 && booking2.getEndDate().compareTo(booking1.getStartDate()) >= 0);
    }


    public Booking getBooking(Long bookingId) {
        return bookings.get(bookingId);
    }

    public void cancelBooking(Long bookingId) {
        bookings.remove(bookingId);
    }

    public Booking rebookBooking(Long bookingId, Booking booking) {
        if (isIntervalOverlapping(booking)) {
            throw new OverlappingIntervalException("The booking interval is overlapping with an existing booking or blocked dates.");
        }
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
