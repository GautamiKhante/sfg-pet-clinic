package guru.springframework.sfgpetclinic.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Specialities")
public class Speciality extends BaseEntity {
    private String description;

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        description = description;
    }
}
