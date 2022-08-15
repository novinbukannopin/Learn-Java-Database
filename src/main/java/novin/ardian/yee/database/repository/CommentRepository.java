package novin.ardian.yee.database.repository;

import novin.ardian.yee.database.entity.Comment;

import java.util.List;

/**
 * @author Novin on 15/08/2022
 * @project Learn-Java-Database
 */
public interface CommentRepository {

    void insert(Comment comment);

    Comment findById(Integer id);

    List<Comment> findAll();

    List<Comment> findAllByEmail(String email);
}
