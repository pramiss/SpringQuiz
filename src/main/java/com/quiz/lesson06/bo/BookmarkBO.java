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
	public boolean isDupliationByUrl(String url) {
		return bookmarkMapper.isDupliationByUrl(url);
	}
	
	// DELETE, input: id, output: x
	public void deleteBookmarkById(int id) {
		bookmarkMapper.deleteBookmarkById(id);
	}
}
