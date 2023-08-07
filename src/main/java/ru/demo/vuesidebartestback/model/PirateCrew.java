package ru.demo.vuesidebartestback.model;

import lombok.Data;

@Data
public class PirateCrew {
    private Long id;
    private String name;
    private String nickname;
    private String email;
    private String position;
}
