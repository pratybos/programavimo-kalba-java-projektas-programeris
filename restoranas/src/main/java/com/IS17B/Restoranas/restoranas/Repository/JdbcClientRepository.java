package com.IS17B.Restoranas.restoranas.Repository;

import com.IS17B.Restoranas.restoranas.Model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Optional;

public class JdbcClientRepository implements ClientRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int count() {
        return jdbcTemplate.queryForObject("SELECT count(*) FROM clients", Integer.class);
    }

    @Override
    public int save(Client client) {
        return jdbcTemplate.update("INSERT  INTO clients (id, firstName, lastName, email, phoneNumber) " +
                "VALUES (?, ?, ?, ?, ?)", client.getId(), client.getFirstName(), client.getLastName(), client.getEmail(),
                 client.getPhoneNumber());
    }

    @Override
    public int update(Client client) {
        return jdbcTemplate.update("UPDATE clients SET firstName = ?, lastName = ?," +
                "email = ?, phoneNumber = ? WHERE id =?");
    }

    @Override
    public int deleteById(Integer id) {
        return jdbcTemplate.update("DELETE FROM clients WHERE id = ?", id);
    }

    @Override
    public List<Client> findAll() {
        return jdbcTemplate.query("SELECT * FROM clients",
                (rs,rowNum) -> new Client(rs.getInt("id"), rs.getString("firstName"),
                        rs.getString("lastName"), rs.getString("email"),
                        rs.getInt("phoneNumber")));
    }

    @Override
    public List<Client> findByNameAndId(String name, Integer Id) {
        return null;
    }

    @Override
    public Optional<Client> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public String getFirstNameById(Integer id) {
        return jdbcTemplate.queryForObject("SELECT firstName FROM clients WHERE id = ?",
                new Object[]{id}, String.class);
    }
}
