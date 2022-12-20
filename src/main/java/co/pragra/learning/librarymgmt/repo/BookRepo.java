//package co.pragra.learning.librarymgmt.repo;
//
//import co.pragra.learning.librarymgmt.entity.Book;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.jdbc.core.BeanPropertyRowMapper;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//import java.util.Map;
//import java.util.Optional;
//
//@Repository
//@Slf4j
//public class BookRepo implements Repo<Book>{
//    private JdbcTemplate template;
//
//    public BookRepo(JdbcTemplate template) {
//        this.template = template;
//    }
//
//    public void createSchema(){
//        try {
//        template.execute("CREATE TABLE BOOK (ID INT, ISBN VARCHAR (30), TITLE VARCHAR (100), CATEGORY VARCHAR (30), AUTHORID INT, PUBLISHDATE DATE, CREATEDATE DATE)");
//        template.execute("CREATE TABLE AUTHOR (ID INT, NAME VARCHAR (100));");
//    }
//    catch(Exception ex){
//        log.error(ex.getMessage());
//    }
//}
//    @Override
//    public Book create(Book book) {
//        String sql = "INSERT INTO BOOK VALUES(?,?,?,?,?,?,?)";
//        book.setId(getNextId());
//        int update = template.update(sql,
//                book.getId(),
//                book.getIsbn(),
//                book.getTitle(),
//                book.getCategory(),
//                book.getAuthor().getId(),
//                book.getPublishDate(),
//                book.getCreateDate()
//        );
//        if(update ==1){
//            log.debug("Book -[{}] has been inserted successfully into the database", book);
//        }else{
//            log.error("Couldn't insert record for book");
//        }
//        //Query from database and return it;
//        return null;
//    }
//
//    @Override
//    public List<Book> getAll(Map<String, Object> params) {
//        String sql = "SELECT * FROM BOOK";
//        return template.query(sql,new BeanPropertyRowMapper<>(Book.class));
//
//    }
//
//    @Override
//    public Optional<Book> getById(int id) {
//        String sql = "SELECT * FROM BOOK WHERE ID =?";
//        return Optional.of(template.queryForObject(sql, new BeanPropertyRowMapper<>(Book.class),id));
//
//    }
//
//    @Override
//    public Book update(Book book) {
//        return null;
//    }
//
//    @Override
//    public Book deleteById(int id) {
//        return null;
//    }
//    public int getNextId(){
//        return template.queryForObject("select next value for BOOKSEQ",Integer.class);
//    }
//}
