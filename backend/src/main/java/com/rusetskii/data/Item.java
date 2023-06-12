package com.rusetskii.data;

import jakarta.persistence.*;
import lombok.*;
import org.apache.solr.client.solrj.beans.Field;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "ITEMS")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "itemId", unique = true, nullable = false)
    private Long id;
    @Field
    private String title;
    @Field
    private String description;
    @Field
    private Date dateCreated;
    @Field
    private Date dateUpdated;

    @Override
    public String toString() {
        return id + " " + title + " " + description;
    }
}
