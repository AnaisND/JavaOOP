package anaisnd.example.hotel.serv;

import anaisnd.example.hotel.domain.Client;
import anaisnd.example.hotel.repo.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;
    public List<Client> TotiClientii(){
        return clientRepository.findAll();
    }
}
