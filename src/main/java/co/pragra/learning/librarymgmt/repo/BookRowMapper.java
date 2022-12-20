//package co.pragra.learning.librarymgmt.repo;
//
//import co.pragra.learning.librarymgmt.entity.Author;
//import co.pragra.learning.librarymgmt.entity.Book;
//import org.springframework.jdbc.core.RowMapper;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//public class BookRowMapper implements RowMapper<Book> {
//    @Override
//    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
//        Author author = new Author();
//        Book book = new Book();
//        author.setId(rs.getInt("AUTHOR.ID"));
//        author.setPublishedName(rs.getString("AUTHOR.NAME"));
//        book.setId(rs.getInt("BOOK.ID"));
//        book.setCategory(rs.getString("BOOK.CATEGORY"));
//        book.setTitle(rs.getString("BOOK.TITLE"));
//        book.setIsbn(rs.getString("BOOK.ISBN"));
//        book.setCreateDate(rs.getDate("BOOK.CREATEDATE"));
//        book.setPublishDate(rs.getDate("BOOK.PUBLISHDATE"));
//        book.setAuthor(author);
//        return book;
//    }
//}
