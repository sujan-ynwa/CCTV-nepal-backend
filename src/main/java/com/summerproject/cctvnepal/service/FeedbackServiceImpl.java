package com.summerproject.cctvnepal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.summerproject.cctvnepal.dao.FeedbackRepository;
import com.summerproject.cctvnepal.entity.Feedback;

@Service
public class FeedbackServiceImpl implements FeedbackService {
	
	@Autowired
	FeedbackRepository feedbackRepo;
	
	

	@Override
	public List<Feedback> findAll() {
		
		return feedbackRepo.findAll();
	}

	@Override
	public void insertOrUpdate(Feedback feedbacks) {
		feedbackRepo.save(feedbacks);
	}

	@Override
	public void deleteFeedback(int id) {
		feedbackRepo.deleteById(id);
		
	}

	@Override
	public Feedback findById(int id) {
		Optional<Feedback> result = feedbackRepo.findById(id);
		
		Feedback feedbackObj;
		
		if(result.isPresent()) {
			feedbackObj = result.get();
		}else {
			throw new RuntimeException("sorry we cannot find what you are looking for!!!!");
		}
		
		return feedbackObj;
	}

}
