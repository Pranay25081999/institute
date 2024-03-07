package com.example.institute.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.UUID;

@Entity
@Table(name="institutetable")
public class Institute {

  @Id
  private String instituteId;
  private String instituteName;
  private String instituteEmail;

    @Override
    public String toString() {
        return "Institute{" +
                "instituteId=" + instituteId +
                ", instituteName='" + instituteName + '\'' +
                ", instituteEmail='" + instituteEmail + '\'' +
                ", instituteMobileNumber='" + instituteMobileNumber + '\'' +
                ", institueAddress='" + institueAddress + '\'' +
                ", instituteWebSite='" + instituteWebSite + '\'' +
                '}';
    }

    public String getInstituteId() {
        return instituteId;
    }

    public void setInstituteId(String instituteId) {
        this.instituteId = instituteId;
    }

    public String getInstituteName() {
        return instituteName;
    }

    public void setInstituteName(String instituteName) {
        this.instituteName = instituteName;
    }

    public String getInstituteEmail() {
        return instituteEmail;
    }

    public void setInstituteEmail(String instituteEmail) {
        this.instituteEmail = instituteEmail;
    }

    public String getInstituteMobileNumber() {
        return instituteMobileNumber;
    }

    public void setInstituteMobileNumber(String instituteMobileNumber) {
        this.instituteMobileNumber = instituteMobileNumber;
    }

    public String getInstitueAddress() {
        return institueAddress;
    }

    public void setInstitueAddress(String institueAddress) {
        this.institueAddress = institueAddress;
    }

    public String getInstituteWebSite() {
        return instituteWebSite;
    }

    public void setInstituteWebSite(String instituteWebSite) {
        this.instituteWebSite = instituteWebSite;
    }
    private String instituteMobileNumber;

  private String institueAddress;
  private String instituteWebSite;

}
