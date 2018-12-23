package com.cdac.examiner.request;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CreateUserRequest {

    @XmlElement
    public String name;
    @XmlElement
    public String email;
    @XmlElement
    public String userId;
    @XmlElement
    public String userType;

    public CreateUserRequest() {
    }
}
