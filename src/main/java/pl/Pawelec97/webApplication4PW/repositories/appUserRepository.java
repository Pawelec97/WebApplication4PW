package pl.pawelec97.webApplication4PW.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pawelec97.webApplication4PW.model.AppUser;

import java.util.Optional;

public interface AppUserRepository extends JpaRepository<AppUser,Integer> {

    public Optional<AppUser> findByUsername(String username);
}
