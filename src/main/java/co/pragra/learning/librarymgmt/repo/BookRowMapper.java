package co.pragra.learning.librarymgmt.repo;

import co.pragra.learning.librarymgmt.entity.Author;
import co.pragra.learning.librarymgmt.entity.Book;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookRowMapper implements RowMapper<Book> {
    @Override
    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
        Author author = new Author();
        Book book = new Book();
        author.setId(rs.getInt("AUTHOR.ID"));
        author.setName(rs.getString("AUTHOR.NAME"));
        book.setId(rs.getInt("BOOK.ID"));
        return book;
    }
}
