package ua.com.owu.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 24.06.2017.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Category {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String catname;
    private String description;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "category",cascade = {CascadeType.MERGE , CascadeType.REMOVE} )
    private List<Product> products = new ArrayList<Product>();
  //  private String picture;



}
