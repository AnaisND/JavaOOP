package anaisnd.example.hotel.domain;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.*;

@Document(collection = "Rezervare")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rezervare {
    @Id
    private ObjectId ID;
    private String CheckIn;
    private String CheckOut;
    private char Stare;
    @DocumentReference
    private Client Clienti;
    @DocumentReference
    private List<Camera> Camere;
}
