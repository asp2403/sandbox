package aspopov.librarydatajdbc.service;

import aspopov.librarydatajdbc.domain.Author;
import aspopov.librarydatajdbc.domain.Book;
import aspopov.librarydatajdbc.domain.Genre;
import aspopov.librarydatajdbc.repository.AuthorRepository;
import aspopov.librarydatajdbc.repository.BookRepository;
import aspopov.librarydatajdbc.repository.GenreRepository;
import aspopov.librarydatajdbc.service.converter.BookConverter;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final BookConverter bookConverter;
    private final AuthorRepository authorRepository;
    private final GenreRepository genreRepository;

    public BookServiceImpl(BookRepository bookRepository, BookConverter bookConverter, AuthorRepository authorRepository, GenreRepository genreRepository) {
        this.bookRepository = bookRepository;
        this.bookConverter = bookConverter;
        this.authorRepository = authorRepository;
        this.genreRepository = genreRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public String findAll() {
        var books = bookRepository.findAllBookDto();
        return books.stream().map(book -> bookConverter.convertToString(book)).collect(Collectors.joining(System.lineSeparator()));
    }

    @Override
    @Transactional(readOnly = true)
    public String findById(long id) {
        var book = bookRepository.findById(id);
        return book.map(b -> bookConverter.convertToString(b)).orElse("Книга не найдена!");
    }

    @Override
    @Transactional
    public String addBook(long idAuthor, long idGenre, String title) {
        try {
            var author = authorRepository.findById(idAuthor).orElseThrow();
            var genre = genreRepository.findById(idGenre).orElseThrow();
            var book = new Book();
            book.setTitle(title);
            book.setAuthor(AggregateReference.to(idAuthor));
            book.setGenre(AggregateReference.to(idGenre));
            book = bookRepository.save(book);
            return bookConverter.convertToString(book);
        } catch (Exception e) {
            return "Автор или жанр не найдены!";
        }
    }

    @Override
    @Transactional
    public String addComment(long bookId, String commentText) {
        var book = bookRepository.findById(bookId);
        return book.map(b -> {
            b.addComment(commentText);
            b = bookRepository.save(b);
            return bookConverter.convertToString(b);
        }).orElse("Книга не найдена!");
    }
}
