package jp.co.rakus.stockmanagement.service;

import java.util.List;

import jp.co.rakus.stockmanagement.domain.Book;
import jp.co.rakus.stockmanagement.repository.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 書籍関連サービスクラス.
 * @author igamasayuki
 *
 */
@Service
public class BookService {

	@Autowired
	BookRepository bookRepository;
	
	public List<Book> findAll(){
		return bookRepository.findAll();
	}
	
	public Book findOne(Integer id) {
		return bookRepository.findOne(id);
	}
	
	public Book save(Book book){
		return bookRepository.save(book);
	}
	
	public Book update(Book book){
		return bookRepository.update(book);
	}
	
//	public void delete(Integer id){
//		bookRepository.delete(id);
//	}
}
