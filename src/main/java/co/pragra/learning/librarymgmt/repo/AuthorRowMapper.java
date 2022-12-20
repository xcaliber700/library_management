//package co.pragra.learning.librarymgmt.repo;
//
//import co.pragra.learning.librarymgmt.entity.Author;
//import org.springframework.jdbc.core.RowMapper;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//public class AuthorRowMapper implements RowMapper<Author> {
//
//    @Override
//    public Author mapRow(ResultSet rs, int rowNum) throws SQLException {
//        return Author.builder()
//                .id(rs.getInt("id"))
//                .publishedName(rs.getString("name"))
//                .build();
//    }
//}
