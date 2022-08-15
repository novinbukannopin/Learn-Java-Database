package novin.ardian.yee.database;

import novin.ardian.yee.database.entity.Comment;
import novin.ardian.yee.database.repository.CommentRepository;
import novin.ardian.yee.database.repository.CommentRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author Novin on 15/08/2022
 * @project Learn-Java-Database
 */
public class RepositoryTest {

    private CommentRepository commentRepository;

    @BeforeEach
    void setUp() {
        commentRepository = new CommentRepositoryImpl();
    }

    @Test
    void testInsert() {
        Comment comment = new Comment("novin@novin.com", "hallooo");
        commentRepository.insert(comment);

        Assertions.assertNotNull(comment.getId());
        System.out.println(comment.getId());
    }

    @Test
    void testFindById() {
        Comment comment = commentRepository.findById(1802);
        System.out.println(comment.getId());
        System.out.println(comment.getEmail());
        System.out.println(comment.getComment());
        Assertions.assertNotNull(comment);

        Comment notFound = commentRepository.findById(10000);
        Assertions.assertNull(notFound);
    }

    @Test
    void testAll() {
        List<Comment> comments = commentRepository.findAll();
        System.out.println(comments.size());
    }

    @Test
    void testFindByEmail() {
        List<Comment> comments = commentRepository.findAllByEmail("novin@novin.com");
        System.out.println(comments.size());
    }
}
