package com.biedaalt.familyChat.Service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biedaalt.familyChat.Model.Messege;
import com.biedaalt.familyChat.Repository.MessegeRepository;

@Service
public class MessageService {

	
	private MessegeRepository messageRepository;
	@Autowired
	public MessageService(MessegeRepository messageRepository) {
		super();
		this.messageRepository = messageRepository;
	}

	public void addMessege(Messege message) {
		
		this.messageRepository.save(message);
		// TODO Auto-generated method stub
		
	}

	public Collection<Messege> getMessage() {
		// TODO Auto-generated method stub
		return this.messageRepository.findAll();
		
	}
	
	
}
