package com.trustcoodes.jobAppSimpleLogic.ReviewLayer.Service;

import com.trustcoodes.jobAppSimpleLogic.ReviewLayer.Entity.ReviewEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface ReviewService {

    List<ReviewEntity> findAllReview(Long id);

    ReviewEntity findReviewById(Long id, Long reviewEntityId);

    boolean addReview(Long id, ReviewEntity reviewEntity);

    boolean removeReviewById(Long id);

    boolean updateReviewById(Long id, ReviewEntity reviewEntity);
}
