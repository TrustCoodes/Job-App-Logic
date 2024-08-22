package com.trustcoodes.jobAppSimpleLogic.ReviewLayer.Service;

import com.trustcoodes.jobAppSimpleLogic.ReviewLayer.Entity.ReviewEntity;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public interface ReviewService {

    List<ReviewEntity> findAllReview(Long id);

    ReviewEntity findReviewById(Long id, Long reviewEntityId);

    boolean addReview(Long id, ReviewEntity reviewEntity);

    boolean removeReviewById(Long id, Long reviewEntityId);

    boolean updateReviewById(ReviewEntity reviewEntity, Long id, Long reviewEntityId);
}
