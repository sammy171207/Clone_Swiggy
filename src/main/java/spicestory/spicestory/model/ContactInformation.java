package spicestory.spicestory.model;


import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactInformation {
    private String email;
   private String mobile;
   private String twitter;
   private String instagram;

}
