package by.mdhtrnk.demouniversity.dto;

import by.mdhtrnk.demouniversity.entity.Day;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@JsonPropertyOrder({ "firstName", "lastName", "dayOfWeek" })
public class StudentDto {

    private String firstName;
    private String lastName;
    private Day dayOfWeek;
}
