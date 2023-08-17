package anaisnd.example.hotel.serv;

import anaisnd.example.hotel.domain.Hotel;
import anaisnd.example.hotel.repo.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;
    public List<Hotel> ToateHotelurile(){
        return hotelRepository.findAll();
    }
}
