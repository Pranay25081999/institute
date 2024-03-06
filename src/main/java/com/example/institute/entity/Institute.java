package com.example.institute.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="institutetable")
public class Institute {
  @Id
  @NotNull
  private int instituteId;
  @NotNull
  @Size(min=3,max = 30)
  private String instituteName;
  @Email
  @NotNull
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

    public int getInstituteId() {
        return instituteId;
    }

    public void setInstituteId(int instituteId) {
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
@NotNull
    private String instituteMobileNumber;
    @NotNull
    @Size(max=50)
  private String institueAddress;
    @NotNull
  private String instituteWebSite;

}
