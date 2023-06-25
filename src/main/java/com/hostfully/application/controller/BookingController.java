package com.hostfully.application.controller;

import com.hostfully.application.model.Booking;
import com.hostfully.application.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping
    public Booking createBooking(@RequestBody Booking booking) {
        return bookingService.createBooking(booking);
    }

    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }

    @GetMapping(value = "/{bookingId}")
    public Booking getBooking(@PathVariable("bookingId") Long bookingId) {
        return bookingService.getBooking(bookingId);
    }

    @DeleteMapping(value = "/{bookingId}")
    public void cancelBooking(@PathVariable("bookingId") Long bookingId) {
        bookingService.cancelBooking(bookingId);
    }

    @PutMapping(value = "/{bookingId}/rebook")
    public Booking rebookBooking(@PathVariable("bookingId") Long bookingId, @RequestBody Booking booking) {
        return bookingService.rebookBooking(bookingId, booking);
    }
}
