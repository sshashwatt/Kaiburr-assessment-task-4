package com.kaiburr.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.kaiburr.model.Server;
import com.kaiburr.repository.ServerRepository;

@Service
public class ServerService {
	
	@Autowired
	private ServerRepository serverRepository;
	
	public List<Server> getAllServers(){
		
		List<Server> servers= serverRepository.findAll();
		return servers;
	}
	
	public	List<Server> getServerById(long id) {
		List<Server> server= serverRepository.findById(id);
		return server;
	}
	
	public String addServer(Server server) {
		serverRepository.insert(server);
		return "Server added :" + server;
	}
	
	public String deleteServer(long id) {
		serverRepository.deleteById(id);
		return "Server deleted : "+ serverRepository.findById(id);
	}
	
	public List<Server> getServerByName(String name) {
		List<Server> servers= serverRepository.findByName(name);
		return servers;
	}
}
