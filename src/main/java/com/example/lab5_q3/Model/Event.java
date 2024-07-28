package com.example.lab5_q3.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;


@Data
@AllArgsConstructor
public class Event {
    private String id;
    private int capacity;
   // @JsonFormat(pattern="yyyy-MM-dd")
    private Date startDate;
   // @JsonFormat(pattern="yyyy-MM-dd")
    private Date endDate;
}
