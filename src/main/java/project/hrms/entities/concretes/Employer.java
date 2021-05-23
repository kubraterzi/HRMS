package project.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Data
@Entity
@PrimaryKeyJoinColumn(name="user_id")
@NoArgsConstructor
@AllArgsConstructor
@Table(name="employers")
public class Employer extends User {

    @Column(name="website")
    private String website;

    @Column(name="phone_number")
    private String phoneNumber;

    @Column(name="is_verified")
    private boolean isVerified;

    @Column(name="company_name")
    private String companyName;

}
