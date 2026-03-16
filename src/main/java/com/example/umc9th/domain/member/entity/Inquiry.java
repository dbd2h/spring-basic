package com.example.umc9th.domain.member.entity;

import com.example.umc9th.global.entity.BaseEntity;
import com.example.umc9th.global.enums.Boolean;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Table(name = "inquiry")
public class Inquiry extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", length = 100, nullable = false)
    private String title;

    @Column(name = "inquiry_sort", length = 100, nullable = false)
    private String inquiry_sort;

    @Column(name = "content", length = 1000, nullable = false)
    private String content;

    @CreatedDate
    @Column(name = "inquiry_date", nullable = false)
    private LocalDateTime inquiry_date;

    @Column(name = "is_accepted", nullable = false)
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private Boolean is_accepted = Boolean.N;

    @Column(name="answer", length = 1000)
    private String answer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @OneToMany(mappedBy = "inquiry")
    private List<InquiryImage> inquiryImageList = new ArrayList<>();
}
