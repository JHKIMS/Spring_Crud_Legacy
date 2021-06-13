package com.board.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.board.domain.BoardVO;
import com.board.domain.Page;
import com.board.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {

	@Inject
	BoardService service;

	// 게시물 목록
	@GetMapping("/list")
	public void getList(Model model) throws Exception {

		List<BoardVO> list = null;
		list = service.list();

		model.addAttribute("list", list);
	}

	// 게시물 작성
	@GetMapping("/write")
	public void getWrite() throws Exception {
		System.out.println("창 불러오기");
	}

	// 게시물 작성
	@PostMapping("/write")
	public String postWrite(BoardVO vo) throws Exception {
		service.write(vo);
		System.out.println("완료");
		return "redirect:/board/list";
	}

	// 게시물 조회(글 읽기)
	@GetMapping("/view")
	public void getView(@RequestParam("idx") int idx, Model model) throws Exception {
		BoardVO vo = service.view(idx);
		model.addAttribute("view", vo);
	}

	// 게시물 수정(GET)
	@GetMapping("/modify")
	public void getModify(@RequestParam("idx") int idx, Model model) throws Exception {
		BoardVO vo = service.view(idx);
		model.addAttribute("view", vo);
	}

	// 게시물 수정(POST)
	@PostMapping("/modify")
	public String postModify(BoardVO vo) throws Exception {

		service.modify(vo);

		return "redirect:/board/view?idx=" + vo.getIdx();
	}

	// 게시물 삭제
	@GetMapping("/delete")
	public String getDelete(@RequestParam("idx") int idx) throws Exception {
		service.delete(idx);

		return "redirect:/board/list";
	}

	// 게시물 목록 + 페이징 추가
	@GetMapping("/listPage")
	public void getListPage(Model model, @RequestParam("num") int num) throws Exception {

		Page page = new Page(num, service.count());

		List<BoardVO> list = null;
		list = service.listPage(page.getDisplayPost(), page.getPostNum());

		model.addAttribute("list", list);

		model.addAttribute("page", page);

		model.addAttribute("select", num);

	}
	

}
