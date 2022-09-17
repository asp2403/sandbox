package aspopov.librarydatajdbc.service.converter;

import aspopov.librarydatajdbc.domain.Book;
import aspopov.librarydatajdbc.dto.BookDto;

public interface BookConverter {
    String convertToString(BookDto book);
    String convertToString(Book book);
}
