package com.example.umc9th.domain.review.repository;

import com.example.umc9th.domain.review.entity.mapping.Review;
import com.querydsl.core.types.Predicate;

import java.util.List;

public interface ReviewQueryDsl {
    List<Review> searchReview(
            Predicate predicate
    );
}
