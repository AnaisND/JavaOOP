package anaisnd.example.hotel.domain;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Document(collection = "Locatie")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Locatie {
    @Id
    private ObjectId ID;
    private String Tara;
    private String Adresa;
}
