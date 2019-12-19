package com.summerproject.cctvnepal.service;

import java.util.List;

import com.summerproject.cctvnepal.entity.Feedback;

public interface FeedbackService {
	
	public List<Feedback> findAll();
	
	public void insertOrUpdate(Feedback feedbacks);
	
	public void deleteFeedback(int id);
	
	public Feedback findById(int id);

}
