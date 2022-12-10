package prac.prac.practice.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import prac.prac.practice.board.model.service.BoardService;

@Controller
public class BoardController {

	
	@Autowired
	private BoardService boardService;
	//
}
