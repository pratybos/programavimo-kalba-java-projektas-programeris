package com.IS17B.Restoranas.restoranas.Service;

import com.IS17B.Restoranas.restoranas.Model.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class TableService{
    @Autowired
JdbcTemplate jdbcTemplate;
        public List<Table> findAll() {
            String sql = "SELECT * FROM tables";
            RowMapper<Table> rm = new RowMapper<Table>() {
                @Override
                public Table mapRow(ResultSet resultSet, int i) throws SQLException {
                    Table tables = new Table(resultSet.getInt("id"),
                            resultSet.getInt("idEmployee"),
                            resultSet.getInt("idClient"));
                    return tables;
                }
            };
            return jdbcTemplate.query(sql, rm);
        }
}

