package aspopov.librarydatajdbc.service;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class ShellCommands {
    private final AuthorService authorService;
    private final GenreService genreService;
    private final BookService bookService;

    public ShellCommands(AuthorService authorService, GenreService genreService, BookService bookService) {
        this.authorService = authorService;
        this.genreService = genreService;
        this.bookService = bookService;
    }

    @ShellMethod(value = "Get All Authors", key = {"authors", "a"})
    String getAllAuthors() {
        return authorService.findAll();
    }

    @ShellMethod(value = "Get All Genres", key = {"genres", "g"})
    String getAllGenres() {
        return genreService.findAll();
    }

    @ShellMethod(value = "Get All Books", key = {"books", "b"})
    String getAllBooks() {
        return bookService.findAll();
    }

    @ShellMethod(value = "Get Book", key = {"get-book", "gb"})
    String getBook(long id) {
        return bookService.findById(id);
    }

    @ShellMethod(value = "Add Comment", key = {"add-comment", "ac"})
    String addComment(long bookId, String commentText) {
        return bookService.addComment(bookId, commentText);
    }

    @ShellMethod(value = "Delete Comment", key = {"del-comment", "dc"})
    String deleteComment(long bookId, int commentIndex) {
        return bookService.deleteComment(bookId, commentIndex - 1);
    }

    @ShellMethod(value = "Add Book", key = {"add-book", "ab"})
    String addBook(long idAuthor, long idGenre, String title) {
        return bookService.addBook(idAuthor, idGenre, title);
    }

    @ShellMethod(value = "Update Book", key = {"update-book", "ub"})
    String updateBook(long idBook, long idAuthor, long idGenre, String title) {
        return bookService.updateBook(idBook, idAuthor, idGenre, title);
    }

    @ShellMethod(value = "Delete Book", key = {"del-book", "db"})
    String deleteBook(long idBook) {
        return bookService.deleteBook(idBook);
    }
}
