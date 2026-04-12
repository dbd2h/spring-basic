package com.example.umc9th.domain.review.repository;

import com.example.umc9th.domain.review.entity.mapping.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface reviewRepository extends JpaRepository<Review,Long> {

    @Modifying(clearAutomatically = true)
    @Query(value = "INSERT INTO review (member_id, restaurant_id, rating, content)" +
    "VALUES (:member_id, :restaurant_id, :rating, :content)",
    nativeQuery = true)
    int insertReview(@Param("member_id") Long member_id,
                     @Param("restaurant_id") Long restaurant_id,
                     @Param("rating") Integer rating,
                     @Param("content") String content);

    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE Review r SET r.answer =  :answer WHERE r.id = :id")
    int reviewAnswer(@Param("answer") String answer, @Param("id") Long id);

    @Query(value = "SELECT r FROM Review r JOIN FETCH r.restaurant WHERE r.restaurant.id = :res_id AND r.id < :idx ORDER BY r.id desc LIMIT 5")
    List<Review> reviewList(@Param("res_id") Long restaurant_id, @Param("idx") Long review_id);
}
