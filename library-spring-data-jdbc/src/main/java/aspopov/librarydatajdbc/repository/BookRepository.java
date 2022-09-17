package aspopov.librarydatajdbc.repository;

import aspopov.librarydatajdbc.domain.Book;
import aspopov.librarydatajdbc.dto.BookDto;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;


import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {
    @Query("select b.id_book as id, title, a.name as author_name, g.name as genre_name, count(c.id_comment) as comment_count " +
            "from book b " +
            "inner join author a on a.id_author = b.id_author " +
            "inner join genre g on g.id_genre = b.id_genre " +
            "inner join comment c on c.id_book = b.id_book " +
            "group by b.id_book"
    )
    List<BookDto> findAllBookDto();

}
