package co.pragra.learning.librarymgmt.repo;

import co.pragra.learning.librarymgmt.entity.Author;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
@Repository
public class AuthorRepo implements Repo<Author>{
    protected NamedParameterJdbcTemplate template;

    public AuthorRepo(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    @Override
    public Author create(Author author) {
        String sql = "INSERT INTO AUTHOR VSLUES(:id,:name)";
        author.setId(getNextId());
        int update = template.update(sql, new BeanPropertySqlParameterSource(author));
        if(update == 1){
            log.debug("Authhor - [{}] has been inserted successfully", author);
            return author;
        }
        else{
            log.error("Couldn't insert record for author");
            return null;
        }
    }


    @Override
    public List<Author> getAll(Map<String, Object> params) {
        String sql = "SELECT * FROM AUTHOR";
        return template.query(sql, new BeanPropertyRowMapper<>(Author.class));
    }

    @Override
    public Optional<Author> getById(int id) {
        String sql = "SELECT * FROM AUTHOR WHERE ID =:id";
        try{
            return Optional.of(getId(id, sql));
        }
        catch (EmptyResultDataAccessException e){
            return null;
        }
    }


    @Override
    public Author update(Author author) {
        String sql="UPDATE AUTHOR SET NAME = :name WHERE ID = :id";
        int update = template.update(sql, new BeanPropertySqlParameterSource(author));
        if(update == 1){
            log.debug("Authhor - [{}] has been updated successfully", author);
            return author;
        }
        else{
            log.error("Couldn't update record for author");
            return null;
        }
    }

    @Override
    public Author deleteById(int id) {
        String sql = "SELECT * FROM AUTHOR WHERE ID = :id";
        Author author;
        try{
            author = getId(id, sql);
            String sqld = "Delete from author where id = :id";
            int update = template.update(sqld, Collections.singletonMap("id",id));
            if(update == 1){
                log.debug("Authhor - [{}] has been deleted successfully", author);
                return author;
            }
            else{
                log.error("Couldn't delete record for author");
                return null;
            }

        }catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    private int getNextId() {
        return template.queryForObject("Select next value for AUTHORSEQ", Collections.EMPTY_MAP,Integer.class);
    }

    private Author getId(int id, String sql) {
        return template.queryForObject(sql, Collections.singletonMap("id", id), new BeanPropertyRowMapper<>(Author.class));
    }
}
