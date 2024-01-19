package com.js.board.controller;
//http://localhost:8090/updateBoardList.admin
import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.js.Action;
import com.js.Result;
import com.js.board.dao.BoardDAO;
import com.js.board.domain.BoardDTO;
import com.js.board.domain.BoardVO;

public class UpdateBoardListController implements Action{
	@Override
	public Result execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		BoardDAO boardDAO = new BoardDAO();
		BoardDTO boardDTO = new BoardDTO();
		Result result = new Result();
		BoardVO boardVO = new BoardVO();
		
		Long boardId = Long.valueOf(req.getParameter("boardId"));
		
		boardDTO = boardDAO.select(boardId);
		
		String boardContent = boardDTO.getBoardContent();
		String boardRegisterDate = boardDTO.getBoardRegisterDate();

		req.setAttribute("boardId", boardId);
		req.setAttribute("boardContent", boardContent);
		req.setAttribute("boardRegisterDate", boardRegisterDate);
		
		result.setPath("templates/manager-doeunn/inquiriesAnswer.jsp");
		
		return result;
	}
}
