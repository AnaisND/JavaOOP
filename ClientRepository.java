package anaisnd.example.hotel.repo;
import anaisnd.example.hotel.domain.Client;
import org.bson.types.ObjectId;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends MongoRepository<Client, ObjectId> {
}
