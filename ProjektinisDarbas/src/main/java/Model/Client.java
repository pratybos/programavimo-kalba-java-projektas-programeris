package Model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Client {
    @Id
    @GeneratedValue
    private Long id;
    private String vardas;
    private String pavarde;

    public Client() {

    }

    public Client(String vard, String pav){
        this.vardas = vard;
        this.pavarde = pav;
    }
}
