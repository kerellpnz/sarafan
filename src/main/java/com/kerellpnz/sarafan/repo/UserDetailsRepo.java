package com.kerellpnz.sarafan.repo;

import com.kerellpnz.sarafan.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsRepo extends JpaRepository<User, String> {

}
