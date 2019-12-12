package com.IS17B.Restoranas.restoranas.Service;

import com.IS17B.Restoranas.restoranas.Model.Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    JdbcTemplate jdbcTemplate;
    public List<Client> findAll() {
        String sql = "SELECT * FROM clients";
        RowMapper<Client> rm = new RowMapper<Client>() {
            @Override
            public Client mapRow(ResultSet resultSet, int i) throws SQLException {
                Client clients = new Client(resultSet.getInt("id"),
                        resultSet.getString("firstName"),
                        resultSet.getString("lastName"),
                        resultSet.getString("email"),
                        resultSet.getInt("phoneNumber"));
                return clients;
            }
        };
        return jdbcTemplate.query(sql, rm);
    }
}
