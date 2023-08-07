package ru.demo.vuesidebartestback.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.demo.vuesidebartestback.dao.entity.PirateEntity;

public interface PirateDAO extends JpaRepository<PirateEntity, Long> {
}
