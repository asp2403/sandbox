package aspopov.librarydatajdbc.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;

import java.util.ArrayList;
import java.util.List;

public class Book {
    @Id
    @Column("id_book")
    private Long id;

    private String title;

    @Column("id_author")
    AggregateReference<Author, Long> author;

    @Column("id_genre")
    AggregateReference<Genre, Long> genre;

    @MappedCollection(idColumn = "id_book", keyColumn = "comment_no")
    List<Comment> comments = new ArrayList<>();

    public void addComment(String commentText) {
        comments.add(new Comment(commentText));
    }

    public List<Comment> getComments() {
        return comments;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public AggregateReference<Author, Long> getAuthor() {
        return author;
    }

    public void setAuthor(AggregateReference<Author, Long> author) {
        this.author = author;
    }

    public AggregateReference<Genre, Long> getGenre() {
        return genre;
    }

    public void setGenre(AggregateReference<Genre, Long> genre) {
        this.genre = genre;
    }
}
