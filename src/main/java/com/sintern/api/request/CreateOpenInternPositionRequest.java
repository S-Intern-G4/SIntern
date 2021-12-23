package com.sintern.api.request;

import java.util.UUID;

public class CreateOpenInternPositionRequest {

    private UUID companyID;
    private int availablePositions;
    private String department;
    private String description;
    private String name;

    public UUID getCompanyID() {
        return companyID;
    }

    public void setCompanyId(UUID companyID) {
        this.companyID = companyID;
    }

    public int getAvailablePositions() {
        return availablePositions;
    }

    public void setAvailablePositions(int availablePositions) {
        this.availablePositions = availablePositions;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
