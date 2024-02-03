package com.aquent.crudapp.client;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Client operations.
 */
@Service
public interface ClientService {

    /**
     * Retrieves all of the com.aquent.crudapp.client records.
     *
     * @return list of com.aquent.crudapp.client records
     */
    List<Client> listClients();

    /**
     * Creates a new com.aquent.crudapp.client record.
     *
     * @param client the values to save
     * @return the new com.aquent.crudapp.client ID
     */
    Integer createClient(Client client);

    /**
     * Retrieves a com.aquent.crudapp.client record by ID.
     *
     * @param id the com.aquent.crudapp.client ID
     * @return the com.aquent.crudapp.client record
     */
    Client readClient(Integer id);

    /**
     * Updates an existing com.aquent.crudapp.client record.
     *
     * @param client the new values to save
     */
    void updateClient(Client client);

    /**
     * Deletes a com.aquent.crudapp.client record by ID.
     *
     * @param id the com.aquent.crudapp.client ID
     */
    void deleteClient(Integer id);

    /**
     * Validates populated com.aquent.crudapp.client data.
     *
     * @param client the values to validate
     * @return list of error messages
     */
    List<String> validateClient(Client client);
}
