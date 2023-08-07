package ru.demo.vuesidebartestback.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.demo.vuesidebartestback.dao.PirateCrewDAO;
import ru.demo.vuesidebartestback.dao.entity.PirateCrewEntity;
import ru.demo.vuesidebartestback.model.PirateCrew;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("api/crew")
public class PirateCrewController {

    private final PirateCrewDAO pirateCrewDAO;

    @GetMapping
    public List<PirateCrewEntity> crew() throws InterruptedException {
        Thread.sleep(400); // демо ожидание для семинара по VueJS
        return pirateCrewDAO.findAll();
    }

    @GetMapping("{id}")
    public PirateCrewEntity crewMemberById(@PathVariable Long id) {
        Optional<PirateCrewEntity> op = pirateCrewDAO.findById(id);
        return op.orElseThrow();
    }

    @PostMapping
    public void create(@RequestBody PirateCrew crew) {
        PirateCrewEntity crewEntity = PirateCrewEntity.builder()
                .name(crew.getName())
                .nickName(crew.getNickName())
                .email(crew.getEmail())
                .position(crew.getPosition())
                .build();
        pirateCrewDAO.save(crewEntity);
    }

    @PutMapping("{id}")
    public void update(@RequestBody PirateCrew crew) {
        PirateCrewEntity crewEntity = PirateCrewEntity.builder()
                .name(crew.getName())
                .nickName(crew.getNickName())
                .email(crew.getEmail())
                .position(crew.getPosition())
                .id(crew.getId())
                .build();
        pirateCrewDAO.save(crewEntity);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable long id) {
        pirateCrewDAO.deleteById(id);
    }
}