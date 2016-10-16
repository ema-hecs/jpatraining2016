package jpatraining.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import java.util.Date;
import java.util.Objects;

@Entity
public class Collaborator {

    @Id
    @SequenceGenerator(name = "collaboratorSeqGen", sequenceName = "COLLABORATOR_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "collaboratorSeqGen")
    private Long id;

    private String lastName;

    private String firstName;

    private Date hiringDate;

    protected Collaborator() { }

    public Collaborator(String firstName, String lastName, Date hiringDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.hiringDate = hiringDate;
    }

    public Long getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Date getHiringDate() {
        return hiringDate;
    }

    public void setHiringDate(Date hiringDate) {
        this.hiringDate = hiringDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Collaborator that = (Collaborator) o;
        if (id != null && that.id != null) {
            return Objects.equals(id, that.id);
        } else {
            return Objects.equals(lastName, that.lastName) &&
                    Objects.equals(firstName, that.firstName)&&
                    Objects.equals(hiringDate, that.hiringDate);
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName, firstName, hiringDate);
    }
}
