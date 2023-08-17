package anaisnd.example.hotel.serv;

import anaisnd.example.hotel.domain.Rezervare;
import anaisnd.example.hotel.repo.RezervareRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class RezervareService {

    @Autowired
    private RezervareRepository rezervareRepository;
    public List<Rezervare> ToateRezervarile(){
        return rezervareRepository.findAll();
    }
}