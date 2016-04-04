package ua.krem.spittr.data;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Description:
 * ====================================
 *
 * @author Sergiy
 * @since 4/4/2016
 */
public class Spitter {

    private Long id;

    public Spitter() {}

    public Spitter(String username, String password, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Spitter(Long id, String username, String password, String firstName, String lastName) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @NotNull
    @Size(min = 5, max = 16)
    private String username;

    @NotNull
    @Size(min = 5, max = 25)
    private String password;

    @NotNull
    @Size(min = 2, max = 30)
    private String firstName;

    @NotNull
    @Size(min = 2, max = 30)
    private String lastName;

    public Long getId()                                                 {return id;}
    public void setId(Long id)                                          {this.id = id;}
    public String getUsername()                                         {return username;}
    public void setUsername(String username)                            {this.username = username;}
    public String getPassword()                                         {return password;}
    public void setPassword(String password)                            {this.password = password;}
    public String getFirstName()                                        {return firstName;}
    public void setFirstName(String firstName)                          {this.firstName = firstName;}
    public String getLastName()                                         {return lastName;}
    public void setLastName(String lastName)                            {this.lastName = lastName;}

    @Override
    public String toString() {
        return "Spitter{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object that) {
        return EqualsBuilder.reflectionEquals(this, that, "username");
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this, "username");
    }
}
