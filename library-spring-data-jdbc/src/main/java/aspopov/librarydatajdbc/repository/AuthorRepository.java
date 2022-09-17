package aspopov.librarydatajdbc.repository;

import aspopov.librarydatajdbc.domain.Author;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AuthorRepository extends CrudRepository<Author, Long> {
    List<Author> findAll();
}
