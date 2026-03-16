package com.example.umc9th.domain.member.entity;


import com.example.umc9th.domain.member.entity.mapping.Notification;
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
@Table(name = "event")
public class Event extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", length = 100, nullable = false)
    private String title;

    @Column(name = "content", length = 1000, nullable = false)
    private String content;

    @Column(name = "is_continue", nullable = false)
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private Boolean is_continue = Boolean.N;

    @Column(name = "closing_time", nullable = false)
    private LocalDate closing_time;

    @OneToMany(mappedBy = "event")
    private List<Notification> notificationList = new ArrayList<>();
}
