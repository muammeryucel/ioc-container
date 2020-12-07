package com.company.foo;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcFooRepository {

    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<Foo> fooRowMapper = (rs, rowNum)->new Foo(rs.getLong(1), rs.getString(2));

    public JdbcFooRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Foo get(Long id) {
        return jdbcTemplate.queryForObject("select * from foo where id=?", fooRowMapper, id);
    }

    public List<Foo> findAll() {
        return jdbcTemplate.query("select * from foo", fooRowMapper);
    }

    public void create(Foo foo) {

        Long id = jdbcTemplate.queryForObject("select seq_foo.nextval", Long.class);
        foo.setId(id);
        jdbcTemplate.update("insert into foo values(?,?)", foo.getId(), foo.getName());
    }

    public void update(Foo foo) {
        jdbcTemplate.update("update foo set name=? where id=?", foo.getName(), foo.getId());
    }

    public void delete(Long id) {
        jdbcTemplate.update("delete from foo where id=?",id);
    }
}
