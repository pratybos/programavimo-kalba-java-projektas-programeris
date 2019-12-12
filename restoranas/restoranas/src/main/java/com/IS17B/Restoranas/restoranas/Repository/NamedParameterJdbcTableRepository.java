package com.IS17B.Restoranas.restoranas.Repository;

import com.IS17B.Restoranas.restoranas.Model.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class NamedParameterJdbcTableRepository extends JdbcTableRepository{
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Override
    public int update(Table table){
        return namedParameterJdbcTemplate.update(
                "UPDATE tables SET idEmployee = ?, idClient = ? WHERE id = :id",
                new BeanPropertySqlParameterSource(table));
    }
    @Override
    public Optional<Table> findById(Integer id){
        return namedParameterJdbcTemplate.queryForObject("SELECT * FROM tables WHERE id = :id",
                new MapSqlParameterSource("id", id),
                (rs,rowNum) -> Optional.of(new Table(rs.getInt("id"), rs.getInt("idEmployee"),
                        rs.getInt("idClient"))));
    }
}
