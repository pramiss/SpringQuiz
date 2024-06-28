package com.quiz.lesson06.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson06.domain.Bookmark;
import com.quiz.lesson06.mapper.BookmarkMapper;

@Service
public class BookmarkBO {

	@Autowired
	private BookmarkMapper bookmarkMapper;
	
	// SELECT, input: X, output: List<Bookmark>
	public List<Bookmark> getBookmarkList() {
		return bookmarkMapper.selectBookmarkList();
	}
	
	// INSERT, input: params, output: rowCount
	public int addBookmark(String name, String url) {
		return bookmarkMapper.insertBookmark(name, url);
	}
	
	// is_dupli, input: url, output: boolean
	public boolean isDupliationUrl(String url) {
		Bookmark bookmark = bookmarkMapper.selectBookmarkByUrl(url);
		
		// null이면 중복 아님 -> false
		// null 아니면 중복임 -> true
		return bookmark != null ? true : false;
	}
	
	// DELETE, input: id, output: rowCount
	public int deleteBookmarkById(int id) {
		return bookmarkMapper.deleteBookmarkById(id);
	}
}
