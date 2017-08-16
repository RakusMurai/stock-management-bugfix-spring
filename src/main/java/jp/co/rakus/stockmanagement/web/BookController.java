package jp.co.rakus.stockmanagement.web;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;

import jp.co.rakus.stockmanagement.domain.Book;
import jp.co.rakus.stockmanagement.service.BookService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

/**
 * 書籍関連処理を行うコントローラー.
 * 
 * @author igamasayuki
 *
 */
@Controller
@RequestMapping("/book")
@Transactional
public class BookController {

	@Autowired
	private BookService bookService;

	private ServletContext context;

	/**
	 * フォームを初期化します.
	 * 
	 * @return フォーム
	 */
	@ModelAttribute
	public BookForm setUpBookForm() {
		return new BookForm();
	}

	@ModelAttribute
	public BookResistForm setUpResistForm() {
		return new BookResistForm();
	}

	/**
	 * 書籍リスト情報を取得し書籍リスト画面を表示します.
	 * 
	 * @param model
	 *            モデル
	 * @return 書籍リスト表示画面
	 */
	@RequestMapping(value = "list")
	public String list(Model model) {
		List<Book> bookList = bookService.findAll();
		model.addAttribute("bookList", bookList);
		return "book/list";
	}

	/**
	 * 書籍詳細情報を取得し書籍詳細画面を表示します.
	 * 
	 * @param id
	 *            書籍ID
	 * @param model
	 *            モデル
	 * @return 書籍詳細画面
	 */
	@RequestMapping(value = "show/{bookId}")
	public String show(@PathVariable("bookId") Integer id, Model model) {
		Book book = bookService.findOne(id);
		model.addAttribute("book", book);
		return "book/show";
	}

	/**
	 * 書籍更新を行います.
	 * 
	 * @param form
	 *            フォーム
	 * @param result
	 *            リザルト情報
	 * @param model
	 *            モデル
	 * @return 書籍リスト画面
	 */
	@RequestMapping(value = "update")
	public String update(@Validated BookForm form, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return show(form.getId(), model);
		}
		Book book = bookService.findOne(form.getId());
		book.setStock(form.getStock());
		bookService.update(book);
		return list(model);
	}

	/**
	 * 新書登録用ページの表示.
	 */
	@RequestMapping(value = "/form")
	public String form(Model model) {
		return "book/form";
	}

	/**
	 * 新書登録.
	 * 
	 * @return
	 */
	@RequestMapping(value = "/save")
	public String save(@Validated BookResistForm form, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return form(model);
		}
		Book book = new Book();
		BeanUtils.copyProperties(form, book);

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date formatDate = null;
		try {
			formatDate = format.parse(form.getSaledate());
		} catch (ParseException e) {
		}
		book.setSaledate(formatDate);
		book.setPrice(Integer.parseInt(form.getPrice()));

		MultipartFile image = form.getImage();
		if (image.isEmpty()) {
			result.rejectValue("image", null, "画像は必須です");
			return form(model);
		}
		String imageName = image.getOriginalFilename();
		book.setImage(imageName);

		try {
			File file = new File(context.getRealPath("\\img\\" + imageName));
			image.transferTo(file);
		} catch (IllegalStateException e) {
			e.printStackTrace();
			return form(model);

		} catch (IOException e) {
			e.printStackTrace();
			return form(model);
		}

		bookService.save(book);
		return "redirect:/book/list";
	}

}
