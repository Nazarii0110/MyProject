package ua.com.owu.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

/**
 * Created by User on 25.06.2017.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private  String prodname;
    private  String proddescription;
    private int prodprice;
    private String prodpicture;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
    private Category category;



}

