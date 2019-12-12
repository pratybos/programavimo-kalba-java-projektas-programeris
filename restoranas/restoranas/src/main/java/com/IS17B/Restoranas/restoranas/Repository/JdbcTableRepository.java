package com.IS17B.Restoranas.restoranas.Repository;

import com.IS17B.Restoranas.restoranas.Model.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Optional;

public class JdbcTableRepository implements TableRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int count() {
        return jdbcTemplate.queryForObject("SELECT count(*) FROM tables", Integer.class);
    }

    @Override
    public int save(Table table) {
        return jdbcTemplate.update("INSERT  INTO tables (id, idEmployee, idClient) VALUES (?, ?, ?)",
                table.getId(), table.getIdEmployee(), table.getIdClient());
    }

    @Override
    public int update(Table table) {
        return jdbcTemplate.update("UPDATE tables SET idEmployee = ?, idClient = ? idClient WHERE id =?");
    }

    @Override
    public int deleteById(Integer id) {
        return jdbcTemplate.update("DELETE FROM tables WHERE id = ?", id);
    }

    @Override
    public List<Table> findAll() {
        return jdbcTemplate.query("SELECT * FROM tables",
                (rs, rowNum) -> new Table(rs.getInt("id"), rs.getInt("idEmployee"),
                        rs.getInt("idClient")));
    }

    @Override
    public List<Table> findByNameAndId(String name, Integer Id) {
        return null;
    }

    @Override
    public Optional<Table> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public String getFirstNameById(Integer id) {
        return null;
    }

}
