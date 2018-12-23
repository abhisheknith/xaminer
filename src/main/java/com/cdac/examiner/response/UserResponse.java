package com.cdac.examiner.response;

import com.cdac.examiner.entities.User;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement
public class UserResponse {
    @XmlElement
    public Integer id;
    @XmlElement
    public String name;
    @XmlElement
    public String email;
    @XmlElement
    public String userId;
    @XmlElement
    public String userType;
    @XmlElement
    public Date createdAt;
    @XmlElement
    public boolean active;

    public UserResponse(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.userId = user.getUserId();
        this.userType = user.getUserType();
        this.createdAt = user.getCreatedAt();
        this.active = user.isActive();
    }

    public UserResponse() {
    }
}
