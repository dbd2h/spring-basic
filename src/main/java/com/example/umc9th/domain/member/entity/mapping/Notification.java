package com.example.umc9th.domain.member.entity.mapping;

import com.example.umc9th.domain.member.entity.Event;
import com.example.umc9th.domain.member.entity.Inquiry;
import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.domain.member.enums.NotifySort;
import com.example.umc9th.global.enums.Boolean;
import com.example.umc9th.domain.review.entity.mapping.Review;
import com.example.umc9th.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Table(name = "notification")
public class Notification extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sort", nullable = false)
    @Enumerated(EnumType.STRING)
    private NotifySort sort;

    @Column(name = "content", length = 100, nullable = false)
    private String content;

    @Column(name = "is_read", nullable = false)
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private Boolean is_read = Boolean.N;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_id")
    private Event event;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "review_id")
    private Review review;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inquiry_id")
    private Inquiry inquiry;
}
