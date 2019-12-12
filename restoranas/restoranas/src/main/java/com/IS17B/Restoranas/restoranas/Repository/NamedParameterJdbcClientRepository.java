package com.IS17B.Restoranas.restoranas.Repository;

import com.IS17B.Restoranas.restoranas.Model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class NamedParameterJdbcClientRepository extends JdbcClientRepository{
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Override
    public int update(Client client){
        return namedParameterJdbcTemplate.update(
                "UPDATE clients SET phoneNumber = ? WHERE id = :id",
                new BeanPropertySqlParameterSource(client));
    }
    @Override
    public Optional<Client> findById(Integer id){
        return namedParameterJdbcTemplate.queryForObject("SELECT * FROM clients WHERE id = :id",
                new MapSqlParameterSource("id", id),
                (rs,rowNum) -> Optional.of(new Client(rs.getInt("id"), rs.getString("firstName"),
                        rs.getString("lastName"), rs.getString("email"),
                        rs.getInt("phoneNumber"))));
    }
}
