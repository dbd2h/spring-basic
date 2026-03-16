package com.example.umc9th.domain.mission.entity;

import com.example.umc9th.domain.mission.entity.mapping.MissionAccept;
import com.example.umc9th.domain.restaurant.entity.Restaurant;
import com.example.umc9th.global.entity.BaseEntity;
import com.example.umc9th.global.enums.Boolean;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Table(name = "mission")
public class Mission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", length = 50, nullable = false)
    private String title;

    @Column(name = "content", length = 100, nullable = false)
    private String content;

    @Column(name = "point_award", nullable = false)
    private Integer point_award;

    @Column(name = "end_time", nullable = false)
    private LocalDate end_time;

    @Column(name = "status", length = 15, nullable = false)
    private String status;

    @Column(name = "inactive_date")
    private LocalDate inactive_date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;

    @OneToMany(mappedBy = "mission")
    private List<MissionAccept> missionAcceptList = new ArrayList<>();
}
