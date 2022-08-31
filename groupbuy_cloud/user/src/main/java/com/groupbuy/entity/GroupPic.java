package com.groupbuy.entity;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Document
@Getter
@Setter
public class GroupPic implements Serializable {
    @Id
//    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer groupPicId;

    @Indexed(unique = true)
    private Integer groupId;

    /**
     * base64
     */
    private String picture;
}
