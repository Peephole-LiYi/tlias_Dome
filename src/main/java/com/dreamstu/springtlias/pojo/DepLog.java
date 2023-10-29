package com.dreamstu.springtlias.pojo;/*
Name: DepLog
CreatDate: 2023/10/29 19:45
*/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepLog {
    private Integer id;
    private LocalDateTime localDateTime;
    private String desp;
}
