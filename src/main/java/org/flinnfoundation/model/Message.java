package org.flinnfoundation.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

@Data
@Entity
public class Message {

    @Id
    @GeneratedValue
    private long id;

    private int priority;

    private String messageTag;

    @Lob
    private String text;

}
