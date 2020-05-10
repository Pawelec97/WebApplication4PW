package pl.pawelec97.webApplication4PW.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.pawelec97.webApplication4PW.DTOs.UsersDTO;
import pl.pawelec97.webApplication4PW.model.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Override
    Optional<User> findById(Long aLong);

    Optional<User> findByUsername(String username);
    User findFirstByOrderByIdDesc();

//    @Query("SELECT new pl.pawelec97.webApplication4PW.DTO.UsersDTO(u.id, u.username, u.password, u.role) FROM Users u")
//    List<UsersDTO> retrieveAppUserAsDTO();
//
//    @Query("SELECT new pl.pawelec97.webApplication4PW.DTO.UsersDTO(u.id, u.username, u.password, u.role) FROM Users u where u.id = :userId")
//    User retrieveAppUserAsDTObyId(@Param("userId") Integer userId);

}