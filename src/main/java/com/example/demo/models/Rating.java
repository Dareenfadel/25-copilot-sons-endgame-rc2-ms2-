package com.example.demo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Document(collection = "ratings")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rating {

    @Id
    private String id;
    private Long entityId;
    private String entityType;
    private Integer score;
    private String comment;
    private LocalDateTime ratingDate;
}
