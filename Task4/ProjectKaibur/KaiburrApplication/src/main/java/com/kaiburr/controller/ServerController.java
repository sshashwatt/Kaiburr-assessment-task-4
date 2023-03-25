package com.kaiburr.controller;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.kaiburr.model.Server;
import com.kaiburr.service.ServerService;

@RestController
public class ServerController {

	@Autowired
	private ServerService serverService;
	
	
	
	@GetMapping("/home")
	public ModelAndView homePage() {
		ModelAndView mav= new ModelAndView("index");
		List<Server> servers=serverService.getAllServers();
		mav.addObject("servers", servers);
		
		return mav;
	}
	@GetMapping("/addServer")
	public ModelAndView addServer() {
		ModelAndView mav= new ModelAndView("/addServer");	
		
		return mav;
	}
	
	@RequestMapping(path = "/addServer", method = RequestMethod.POST)
	public ModelAndView addServer(@RequestParam int id,@RequestParam String name,@RequestParam String language,@RequestParam String framework) {
		
		Server server =new Server(id,name,language,framework);
		serverService.addServer(server);
		ModelAndView mav= new ModelAndView("index");
		List<Server> servers=serverService.getAllServers();
		mav.addObject("servers", servers);
		return mav;
	
	}
	
	@GetMapping("/getServerById")
	public ModelAndView getServerById() {
		ModelAndView mav= new ModelAndView("getServerById");
		
		return mav;
	}
	
	@RequestMapping(path = "/getServerById", method = RequestMethod.POST)
	public ModelAndView getServerById(@RequestParam int id) {
		ModelAndView mav= new ModelAndView("index");
		List<Server> server=serverService.getServerById(id);
		System.out.println("-------------------------\n"+server);
		mav.addObject("servers", server);
		return mav;
	}
	
	
	@GetMapping("/getServerByName")
	public ModelAndView getServerByName() {
		ModelAndView mav= new ModelAndView("getServerByName");
		
		return mav;
	}
	
	@RequestMapping(path = "/getServerByName", method = RequestMethod.POST)
	public ModelAndView getServerByName(@RequestParam String name) {
		ModelAndView mav= new ModelAndView("index");
		List<Server> server=serverService.getServerByName(name);
		System.out.println("-------------------------\n"+server);
		mav.addObject("servers", server);
		return mav;
	}
	
	
	
	@GetMapping("/deleteServer")
	public ModelAndView deleteServer() {
		ModelAndView mav= new ModelAndView("deleteServer");
		
		return mav;
	}
	
	@RequestMapping(path = "/deleteServer", method = RequestMethod.POST)
	public ModelAndView deleteServer(@RequestParam int id) {
		ModelAndView mav= new ModelAndView("index");
		serverService.deleteServer(id);
		List<Server> server=serverService.getAllServers();
		System.out.println("-------------------------\n"+server);
		mav.addObject("servers", server);
		return mav;
	}
	
}
