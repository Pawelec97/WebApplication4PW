package pl.pawelec97.webApplication4PW.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.jmx.export.notification.UnableToSendNotificationException;
import pl.pawelec97.webApplication4PW.model.User;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsersDTO {

    private int id;
    private String username;
    private String password;
    private String role;

    public static UsersDTO userToDTO(User user){
        return new UsersDTO(user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getRole());
    }
}
