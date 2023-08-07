package ru.demo.vuesidebartestback.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.demo.vuesidebartestback.dao.entity.PirateCrewEntity;

public interface PirateCrewDAO extends JpaRepository<PirateCrewEntity, Long> {
}
