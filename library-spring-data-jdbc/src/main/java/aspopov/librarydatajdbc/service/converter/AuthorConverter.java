package aspopov.librarydatajdbc.service.converter;

import aspopov.librarydatajdbc.domain.Author;


public interface AuthorConverter {
    String convertToString(Author author);
}
