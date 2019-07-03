package springboot.dto;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class RegNoteDTO {

    private String firstName;
    private String lastName;
    private String email;
    private String login;
    private String password;

}