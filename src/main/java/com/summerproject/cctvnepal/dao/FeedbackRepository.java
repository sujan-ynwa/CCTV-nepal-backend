package com.summerproject.cctvnepal.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.summerproject.cctvnepal.entity.Feedback;

@RepositoryRestResource(path= "feedbacks")
public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {

}
