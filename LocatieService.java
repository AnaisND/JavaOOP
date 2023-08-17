package anaisnd.example.hotel.serv;

import anaisnd.example.hotel.domain.Locatie;
import anaisnd.example.hotel.repo.LocatieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class LocatieService {

    @Autowired
    private LocatieRepository locatieRepository;
    public List<Locatie> ToateLocatiile(){
        return locatieRepository.findAll();
    }
}
