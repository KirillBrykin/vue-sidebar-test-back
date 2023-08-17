package ru.demo.vuesidebartestback.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.demo.vuesidebartestback.dao.PirateDAO;
import ru.demo.vuesidebartestback.dao.entity.PirateEntity;
import ru.demo.vuesidebartestback.model.Pirate;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("api/crew")
public class PirateCrewController {

    private final PirateDAO pirateDAO;

    @GetMapping
    @PreAuthorize("hasRole('client_role_user')")
    public List<PirateEntity> crew() throws InterruptedException {
        Thread.sleep(400); // демо ожидание для семинара по VueJS
        return pirateDAO.findAll();
    }

    @GetMapping("{id}")
    @PreAuthorize("hasRole('client_role_admin')")
    public PirateEntity crewPirateById(@PathVariable Long id) {
        Optional<PirateEntity> op = pirateDAO.findById(id);
        return op.orElseThrow();
    }

    @PostMapping
    @PreAuthorize("hasRole('client_role_admin')")
    public void create(@RequestBody Pirate pirate) {
        PirateEntity pirateEntity = PirateEntity.builder()
                .name(pirate.getName())
                .nickName(pirate.getNickName())
                .email(pirate.getEmail())
                .position(pirate.getPosition())
                .build();
        pirateDAO.save(pirateEntity);
    }

    @PutMapping("{id}")
    @PreAuthorize("hasRole('client_role_admin')")
    public void update(@RequestBody Pirate pirate) {
        PirateEntity pirateEntity = PirateEntity.builder()
                .name(pirate.getName())
                .nickName(pirate.getNickName())
                .email(pirate.getEmail())
                .position(pirate.getPosition())
                .id(pirate.getId())
                .build();
        pirateDAO.save(pirateEntity);
    }

    @DeleteMapping("{id}")
    @PreAuthorize("hasRole('client_role_admin')")
    public void delete(@PathVariable long id) {
        pirateDAO.deleteById(id);
    }
}