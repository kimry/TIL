package com.kimry.baedal.repository;

import com.kimry.baedal.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

    Users save(Users users);

    Optional<Users> findByEmail(String email);

}
