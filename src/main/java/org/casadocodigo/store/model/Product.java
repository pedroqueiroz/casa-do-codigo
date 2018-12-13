package org.casadocodigo.store.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Product {

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getPages() {
        return pages;
    }

    public List<Price> getPrices() {
        return prices;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public void setPrices(List<Price> prices) {
        this.prices = prices;
    }

    @Override
    public String toString() {
        return "Product{" +
                "description='" + description + '\'' +
                ", title='" + title + '\'' +
                ", pages=" + pages +
                '}';
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ElementCollection
    private List<Price> prices;

    private String description;
    private String title;
    private int pages;
}
