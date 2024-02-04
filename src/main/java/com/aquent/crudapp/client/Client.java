package com.aquent.crudapp.client;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * The com.aquent.crudapp.client entity corresponding to the "com.aquent.crudapp.client" table in the database.
 */
public class Client {

    private Integer clientId;

    @NotNull
    @Size(min = 1, max = 50, message = "Client name is required (max 50 characters)")
    private String clientName;

    @NotNull
    @Size(min = 1, max = 50, message = "Address is required (max 50 characters)")
    private String clientAddress;

    @NotNull
    @Size(min = 1, max = 50, message = "City is required (max 50 characters)")
    private String city;

    @NotNull
    @Size(min = 2, max = 2, message = "State is required (length of 2 characters required)")
    private String state;

    @NotNull
    @Size(min = 5, max = 5, message = "Zip code is required (length of 5 characters required)")
    private String zipCode;

    @NotNull
    @Size(min = 5, max = 30, message = "Website URI is required (min 5 characters, max 30 characters")
    private String websiteURI;

    @NotNull
    @Size(min = 10, max = 10, message = "Phone Number is required (length of 10 characters required)")
    private String phoneNumber;

    @Size(max = 50, message = "Associated Contact can't have more than 50 characters")
    private String associatedPerson;



    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientAddress() {
        return clientAddress;
    }

    public void setClientAddress(String clientAddress) {
        this.clientAddress = clientAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getWebsiteURI() {
        return websiteURI;
    }

    public void setWebsiteURI(String websiteURI) {
        this.websiteURI = websiteURI;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAssociatedPerson() {
        return associatedPerson;
    }

    public void setAssociatedPerson(String associatedPerson) {
        this.associatedPerson = associatedPerson;
    }

}
