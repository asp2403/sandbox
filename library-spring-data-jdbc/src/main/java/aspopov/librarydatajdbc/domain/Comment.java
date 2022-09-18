package aspopov.librarydatajdbc.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

public class Comment {

//    @Id
    @Column("id_comment")
    private Long id;

    @Column("comment_text")
    private String text;

    public Comment(String text) {
        this.text = text;
    }

    public Comment() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
