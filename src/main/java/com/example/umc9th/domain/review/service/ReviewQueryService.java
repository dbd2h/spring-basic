package com.example.umc9th.domain.review.service;

import com.example.umc9th.domain.review.dto.ReviewResponseDto;
import com.example.umc9th.domain.review.entity.mapping.QReview;
import com.example.umc9th.domain.review.entity.mapping.Review;
import com.example.umc9th.domain.review.repository.ReviewRepository;
import com.querydsl.core.BooleanBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewQueryService {

    private final ReviewRepository reviewRepository;

    public List<ReviewResponseDto> searchReview(String query, String type)
    {

        // Q클래스 정의
        QReview review = QReview.review;

        //BooleanBuilder 정의
        BooleanBuilder builder = new BooleanBuilder();

        //BooleanBuilder 사용

        //동적 쿼리: 검색 조건
        if(type.equals("name"))
        {
            builder.and(review.restaurant.name.contains(query));
        }
        if(type.equals("rating"))
        {
            builder.and(review.rating.goe(Integer.parseInt(query)));
        }
        if(type.equals("both"))
        {

            // & 기준 변환
            String firstQuery = query.split("&")[0];
            String secondQuery = query.split("&")[1];

            // 동적 쿼리
            builder.and(review.restaurant.name.contains(firstQuery));
            builder.and(review.rating.goe(Integer.parseInt(secondQuery)));

        }

        List<Review> reviewList = reviewRepository.searchReview(builder);

        return reviewList.stream()
                .map(r -> new ReviewResponseDto(
                        r.getId(),
                        r.getContent(),
                        r.getRating(),
                        r.getRestaurant().getName()
                ))
                .toList();
    }
}
