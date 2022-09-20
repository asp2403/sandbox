package aspopov.librarydatajdbc.service.converter;

import aspopov.librarydatajdbc.domain.Book;
import aspopov.librarydatajdbc.dto.BookDto;
import aspopov.librarydatajdbc.repository.AuthorRepository;
import aspopov.librarydatajdbc.repository.GenreRepository;
import org.springframework.stereotype.Component;

import java.util.stream.IntStream;

@Component
public class BookConverterImpl implements BookConverter {
    private final static String TEMPLATE = "%d: %s \"%s\" (%s) (Комментарии: %d)";

    private final AuthorRepository authorRepository;
    private final GenreRepository genreRepository;

    public BookConverterImpl(AuthorRepository authorRepository, GenreRepository genreRepository) {
        this.authorRepository = authorRepository;
        this.genreRepository = genreRepository;
    }

    @Override
    public String convertToString(BookDto bookDto) {
        return String.format(TEMPLATE, bookDto.getId(), bookDto.getAuthorName(), bookDto.getTitle(), bookDto.getGenreName(), bookDto.getCommentCount());
    }

    @Override
    public String convertToString(Book book) {
        var sb = new StringBuilder();
        var author = authorRepository.findById(book.getAuthor().getId()).orElseThrow();
        var genre = genreRepository.findById(book.getGenre().getId()).orElseThrow();
        sb.append(String.format("%d: %s \"%s\" (%s)", book.getId(), author.getName(), book.getTitle(), genre.getName()));
        sb.append(System.lineSeparator())
                .append("-----------------------------").append(System.lineSeparator())
                .append("Комментарии:").append(System.lineSeparator());
        IntStream.range(0, book.getComments().size()).forEach(
            i -> {
                var comment = book.getComments().get(i);
                sb.append(String.format("<%d> %s", i + 1, comment.getText())).append(System.lineSeparator());
            }
        );
        return sb.toString();
    }
}
