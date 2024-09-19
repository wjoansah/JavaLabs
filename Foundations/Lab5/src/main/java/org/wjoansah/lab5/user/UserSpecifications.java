package org.wjoansah.lab5.user;

import org.springframework.data.jpa.domain.Specification;

public class UserSpecifications {
    public static Specification<User> isUser(){
       return ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("role"), Role.USER)) ;
    }
}
