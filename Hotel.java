package anaisnd.example.hotel.domain;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.*;

@Document(collection = "Hotel")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hotel {
    @Id
    private ObjectId ID;
    private String Nume;
    private int Stele;
    private char Restaurant;
    private char Animale_companie;
    private String Detalii;
    @DocumentReference
    private List<Manager> Manageri;
    @DocumentReference
    private Locatie Locatie_;
    @DocumentReference
    private List<Camera> Camere;

}
