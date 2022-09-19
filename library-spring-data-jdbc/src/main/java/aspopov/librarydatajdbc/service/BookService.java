package aspopov.librarydatajdbc.service;

public interface BookService {
    String findAll();
    String findById(long id);
    String addBook(long idAuthor, long idGenre, String title);
    String addComment(long bookId, String commentText);
    String deleteComment(long bookId, int commentIndex);
    String deleteBook(long bookId);
    String updateBook(long idBook, long idAuthor, long idGenre, String title);
}
