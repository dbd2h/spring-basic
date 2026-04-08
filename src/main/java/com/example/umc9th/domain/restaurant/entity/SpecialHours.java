package com.example.umc9th.domain.restaurant.entity;

import com.example.umc9th.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Table(name = "special_hours")
public class SpecialHours extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "special_time", nullable = false)
    private LocalDate special_time;

    @Column(name = "open_time", nullable = false)
    private LocalDate open_time;

    @Column(name = "close_time", nullable = false)
    private LocalDate close_time;

    @Column(name = "memo", length = 50)
    private String memo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;
}
