package com.aquent.crudapp.client;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

/**
 * Spring JDBC implementation of {@link ClientDao}.
 */
@Component
public class JdbcClientDao implements ClientDao {

    private static final String SQL_LIST_CLIENTS = "SELECT * FROM client ORDER BY client_name, client_id";
    private static final String SQL_READ_CLIENT = "SELECT * FROM client WHERE client_id = :clientId";
    private static final String SQL_DELETE_CLIENT = "DELETE FROM client WHERE client_id = :clientId";
    private static final String SQL_UPDATE_CLIENT = "UPDATE client SET (client_name, client_address, city, state, zip_code, website_uri, phone_number, associated_person)"
                                                  + " = (:clientName, :clientAddress, :city, :state, :zipCode, :websiteURI, :phoneNumber, :associatedPerson)"
                                                  + " WHERE client_id = :clientId";
    private static final String SQL_CREATE_CLIENT = "INSERT INTO client (client_name, client_address, city, state, zip_code, website_uri, phone_number, associated_person)"
                                                  + " VALUES (:clientName, :clientAddress, :city, :state, :zipCode, :websiteURI, :phoneNumber, :associatedPerson)";




    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public JdbcClientDao(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<Client> listClients() {
        return namedParameterJdbcTemplate.getJdbcOperations().query(SQL_LIST_CLIENTS, new ClientRowMapper());
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public Client readClient(Integer clientId) {
        return namedParameterJdbcTemplate.queryForObject(SQL_READ_CLIENT, Collections.singletonMap("clientId", clientId), new ClientRowMapper());
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
    public void deleteClient(Integer clientId) {
        namedParameterJdbcTemplate.update(SQL_DELETE_CLIENT, Collections.singletonMap("clientId", clientId));
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
    public void updateClient(Client client) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(SQL_UPDATE_CLIENT, new BeanPropertySqlParameterSource(client), keyHolder);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
    public Integer createClient(Client client) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(SQL_CREATE_CLIENT, new BeanPropertySqlParameterSource(client), keyHolder);
        return keyHolder.getKey().intValue();
    }

    /**
     * Row mapper for com.aquent.crudapp.client records.
     */
    private static final class ClientRowMapper implements RowMapper<Client> {

        @Override
        public Client mapRow(ResultSet rs, int rowNum) throws SQLException {
            Client client = new Client();
            client.setClientId(rs.getInt("client_id"));
            client.setClientName(rs.getString("client_name"));
            client.setClientAddress(rs.getString("client_address"));
            client.setCity(rs.getString("city"));
            client.setState(rs.getString("state"));
            client.setZipCode(rs.getString("zip_code"));
            client.setWebsiteURI(rs.getString("website_uri"));
            client.setPhoneNumber(rs.getString("phone_number"));
            client.setAssociatedPerson(rs.getString("associated_person"));
            return client;
        }
    }
}
