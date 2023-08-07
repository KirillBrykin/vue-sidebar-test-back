package ru.demo.vuesidebartestback.model;

import lombok.Data;

@Data
public class PirateCrew {
    private Long id;
    private String name;
    private String nickName;
    private String email;
    private String position;
}
