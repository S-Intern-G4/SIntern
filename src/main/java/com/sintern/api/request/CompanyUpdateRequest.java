package com.sintern.api.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

public class CompanyUpdateRequest {
    private UUID id;

    @NotNull(message = "Name is required")
    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 100, message = "Name should have between 2 and 100 characters")
    private String name;

    @NotNull(message = "Address is required")
    @NotBlank(message = "Address is required")
    @Size(min = 2, max = 100, message = "Address should have between 2 and 100 characters")
    private String address;

    private String domain;

    public CompanyUpdateRequest(UUID uuid, String name, String address, String domain) {
        this.id = uuid;
        this.name = name;
        this.address = address;
        this.domain = domain;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    @Override
    public String toString() {
        return "CompanyDTO{" +
                "uuid=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", domain='" + domain + '\'' +
                '}';
    }
}
