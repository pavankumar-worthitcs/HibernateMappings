package com.wcs.HibernateMapping.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "idCardId"
)
public class IdCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCardId;
    private String idCardNumber;

    @OneToOne
    private Employee employee;


    public IdCard(Long idCardId, String idCardNumber) {
        this.idCardId = idCardId;
        this.idCardNumber = idCardNumber;
    }

    public IdCard() {
    }

    public Long getIdCardId() {
        return idCardId;
    }

    public void setIdCardId(Long idCardId) {
        this.idCardId = idCardId;
    }

    public String getIdCardNumber() {
        return idCardNumber;
    }

    public void setIdCardNumber(String idCardNumber) {
        this.idCardNumber = idCardNumber;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "IdCard{" +
                "idCardId=" + idCardId +
                ", idCardNumber='" + idCardNumber + '\'' +
                '}';
    }
}
