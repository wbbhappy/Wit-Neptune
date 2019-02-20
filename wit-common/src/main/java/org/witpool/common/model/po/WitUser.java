package org.witpool.common.model.po;

import org.hibernate.validator.constraints.NotBlank;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class WitUser {
    @Id
    @GeneratedValue
    private Integer userId;
    @NotBlank(message = "userNameis required")
    private String userName;
    @NotBlank(message = "password is required")
    private String password;
    @NotBlank(message = "email is required")
    private String email;
    private String cellPhone;

    public WitUser() {
    }

    public Integer getUserId()
    {
        return userId;
    }
    public void setUserId(Integer userId)
    {
        this.userId = userId;
    }
    public String getUserName()
    {
        return userName;
    }
    public void setUserName(String userName)
    {
        this.userName = userName;
    }
    public String getPassword()
    {
        return password;
    }
    public void setPassword(String password)
    {
        this.password = password;
    }
    public String getCellPhone()
    {
        return cellPhone;
    }
    public void setCellPhone(String cellPhone)
    {
        this.cellPhone = cellPhone;
    }
    public String getEmail()
    {
        return email;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("WitAccount [userId=");
        builder.append(userId);
        builder.append(", userName=");
        builder.append(userName);
        builder.append(", password=");
        builder.append(password);
        builder.append(", cellPhone=");
        builder.append(cellPhone);
        builder.append(", email=");
        builder.append(email);
        builder.append("]");
        return builder.toString();
    }
}
