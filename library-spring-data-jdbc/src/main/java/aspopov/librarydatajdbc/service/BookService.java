package aspopov.librarydatajdbc.service;

import aspopov.librarydatajdbc.domain.Book;

public interface BookService {
    String findAll();
    String findById(long id);
    String addBook(long idAuthor, long idGenre, String title);
    String addComment(long bookId, String commentText);
}
