package com.talentyco.common.entity.product;

import com.talentyco.common.entity.Brand;
import com.talentyco.common.entity.Category;
import com.talentyco.common.entity.IdBasedEntity;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "products")
public class Product extends IdBasedEntity {

    @Column(unique = true, length = 255, nullable = false)
    private String name;

    @Column(unique = true, length = 255, nullable = false)
    private String alias;

    @Column(name = "short_decription", length = 512, nullable = false)
    private String shortDecription;

    @Column(name = "full_decription", length = 4096, nullable = false)
    private String fullDecription;

    @Column(name = "created_time")
    private Date createdTime;

    @Column(name = "updated_time")
    private Date updatedTime;

    private boolean enabled;

    @Column(name = "in_stock")
    private boolean inStock;

    private float cost;
    private float price;

    @Column(name = "discount_persent")
    private float discountPercent;

    private float length;
    private float width;
    private float height;
    private float weight;

    @Column(name = "main_image", nullable = false)
    private String mainImage;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ProductImage> images = new HashSet<>();

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductDetail> details = new ArrayList<>();

}


