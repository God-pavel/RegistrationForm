package springboot.dto;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class LogNoteDTO {
    private String login;
    private String password;
}