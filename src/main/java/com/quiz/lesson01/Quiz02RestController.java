package com.quiz.lesson01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/lesson01/quiz02")
@RestController
public class Quiz02RestController {

	// http://localhost:8080/lesson01/quiz02/1
	@RequestMapping("/1")
	public List<Map<String, Object>> quiz02_1() {
		List<Map<String, Object>> movieList = new ArrayList<>();

		Map<String, Object> movie1 = new HashMap<>();
		movie1.put("rate", 15);
		movie1.put("director", "봉준호");
		movie1.put("time", 131);
		movie1.put("title", "기생충");
		movieList.add(movie1);
		
		Map<String, Object> movie2 = new HashMap<>();
		movie2.put("rate", 0);
		movie2.put("director", "로베르토 베니니");
		movie2.put("time", 116);
		movie2.put("title", "인생은 아름다워");
		movieList.add(movie2);
		
		Map<String, Object> movie3 = new HashMap<>();
		movie3.put("rate", 12);
		movie3.put("director", "크리스토퍼 놀란");
		movie3.put("time", 147);
		movie3.put("title", "인셉션");
		movieList.add(movie3);
		
		Map<String, Object> movie4 = new HashMap<>();
		movie4.put("rate", 19);
		movie4.put("director", "윤종빈");
		movie4.put("time", 133);
		movie4.put("title", "범죄와의 전쟁 : 나쁜놈들 전성시대");
		movieList.add(movie4);
		
		Map<String, Object> movie5 = new HashMap<>();
		movie5.put("rate", 15);
		movie5.put("director", "프란시스 로렌스");
		movie5.put("time", 137);
		movie5.put("title", "헝거게임");
		movieList.add(movie5);
		
		return movieList;
	} //-- quiz02_1
	
	// http://localhost:8080/lesson01/quiz02/2
	@RequestMapping("/2")
	public List<Quiz02Board> quiz02_2() {
		List<Quiz02Board> boardList = new ArrayList<>();

		Quiz02Board b = new Quiz02Board();
		b.setTitle("안녕하세요 가입인사 드립니다.");
		b.setUser("marobiana");
		b.setContent("안녕하세요. 가입했어요. 앞으로 잘 부탁드립니다. 활동 열심히 하겠습니다.");
		boardList.add(b);

		// 스택(b 변수)는 재활용 가능
		// 이전 b객체는 힙영역에 남아서 List에 연결되어 있음
		b = new Quiz02Board();
		b.setTitle("헐 대박");
		b.setUser("bada");
		b.setContent("오늘 목요일이었어... 금요일인줄");
		boardList.add(b);

		b = new Quiz02Board();
		b.setTitle("오늘 데이트 한 이야기 해드릴게요.");
		b.setUser("dulumary");
		b.setContent("...");
		boardList.add(b);

		return boardList;
	} //-- quiz02_2
	
	// http://localhost:8080/lesson01/quiz02/3
	@RequestMapping("/3")
	public ResponseEntity<Quiz02Board> quiz02_3() {
		Quiz02Board board = new Quiz02Board();
		board.setTitle("안녕하세요 가입인사 드립니다.");
		board.setUser("marobiana");
		board.setContent("안녕하세요. 가입했어요. 앞으로 잘 부탁드립니다. 활동 열심히 하겠습니다.");

		return new ResponseEntity<>(board, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
