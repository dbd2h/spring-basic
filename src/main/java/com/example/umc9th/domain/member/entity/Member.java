package com.example.umc9th.domain.member.entity;

import com.example.umc9th.domain.member.entity.mapping.MemberFood;
import com.example.umc9th.domain.member.entity.mapping.Notification;
import com.example.umc9th.domain.member.enums.Gender;
import com.example.umc9th.global.enums.Boolean;
import com.example.umc9th.domain.mission.entity.mapping.MissionAccept;
import com.example.umc9th.domain.restaurant.entity.Restaurant;
import com.example.umc9th.domain.review.entity.mapping.Review;
import com.example.umc9th.global.entity.BaseEntity;
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
@Table(name = "member")
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 20, nullable = false)
    private String name;

    @Column(name= "nickname", length = 20, nullable = false)
    private String nickname;

    @Column(name = "gender", nullable = false)
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private Gender gender = Gender.NONE;

    @Column(name = "birth", nullable = false)
    private LocalDate birth;

    @Column(name= "address", length = 100, nullable = false)
    private String address;

    @Column(name= "email", length = 100)
    private String email;

    @Column(name= "phone_number", length = 11)
    private String phone_number;

    @Column(name = "point", nullable = false)
    @Builder.Default
    private Integer point = 0;

    @Column(name= "status", length = 15, nullable = false)
    @Builder.Default
    private String status = "active";

    @Column(name= "inactive_date")
    private LocalDate inactive_date;

    @Column(name = "notify_event",  nullable = false)
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private Boolean notify_event = Boolean.N;

    @Column(name = "notify_review",  nullable = false)
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private Boolean notify_review = Boolean.N;

    @Column(name = "notify_inquiry",  nullable = false)
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private Boolean notify_inquiry = Boolean.N;

    @OneToMany(mappedBy = "member")
    private List<MemberFood> memberFoodList = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<PointHistory> pointUsageList = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<MissionAccept> missionAcceptList = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Restaurant> restaurantList = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Notification> notificationList = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Review> reviewList = new ArrayList<>();
}
