package com.example.umc9th.domain.mission.entity.mapping;

import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.domain.mission.entity.Mission;
import com.example.umc9th.global.entity.BaseEntity;
import com.example.umc9th.global.enums.Boolean;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Table(name = "mission_accept")
public class MissionAccept extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "certification_number", length = 9, nullable = false)
    private String certification_number;

    @Column(name = "is_finish", nullable = false)
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private Boolean is_finish = Boolean.N;

    @Column(name = "is_continue", nullable = false)
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private Boolean is_continue = Boolean.Y;

    @OneToMany(mappedBy = "mission_accept")
    private List<MissionAccept> missionAcceptList = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member", nullable = false)
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission", nullable = false)
    private Mission mission;
}
