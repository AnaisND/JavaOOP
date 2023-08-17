package anaisnd.example.hotel.controllers;

import anaisnd.example.hotel.domain.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import anaisnd.example.hotel.serv.HotelService;
import java.util.*;

@RestController
@RequestMapping("/data/ho")
public class HotelController {

    @Autowired
    private HotelService hotelService;
    @GetMapping
    public ResponseEntity<List<Hotel>> getToateHotelurile(){
        return new ResponseEntity<List<Hotel>>(hotelService.ToateHotelurile(), HttpStatus.OK);
    }
}
