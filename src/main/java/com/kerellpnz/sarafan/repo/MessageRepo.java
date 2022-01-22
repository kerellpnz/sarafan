package com.kerellpnz.sarafan.repo;

import com.kerellpnz.sarafan.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepo extends JpaRepository<Message, Long> {
}
