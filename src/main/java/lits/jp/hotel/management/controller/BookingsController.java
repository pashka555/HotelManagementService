package lits.jp.hotel.management.controller;

import lits.jp.hotel.management.dtos.BookingsDTO;
import lits.jp.hotel.management.services.BookingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/bookings")
public class BookingsController {

    @Autowired
    BookingsService bookingsService;

    @PostMapping(value = "/booking") // remove /booking
    @ResponseBody
    public BookingsDTO newBooking(@RequestBody BookingsDTO bookingsDTO){

//        if(bookingsService.addBooking(bookingsDTO)!=null){
//            return bookingsService.addBooking(bookingsDTO);}
//        else
            return bookingsService.addBooking(bookingsDTO);
    }


    @GetMapping(value = "/date")
    @ResponseBody
    public List<BookingsDTO> showAllBookingsOnDate(@RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return bookingsService.showAllBookingsOnDate(date);
    }


}
