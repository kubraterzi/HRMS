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
@Table(name= "systempersonnels")
@PrimaryKeyJoinColumn(name="id")
@AllArgsConstructor
@NoArgsConstructor
public class SystemPersonnel extends User {

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;
}
