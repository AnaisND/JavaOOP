package anaisnd.example.hotel.serv;

import anaisnd.example.hotel.domain.Utilizator;
import anaisnd.example.hotel.repo.UtilizatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class UtilizatorService {

    @Autowired
    private UtilizatorRepository utilizatorRepository;
    public List<Utilizator> TotiUtilizatorii(){
        return utilizatorRepository.findAll();
    }
}
