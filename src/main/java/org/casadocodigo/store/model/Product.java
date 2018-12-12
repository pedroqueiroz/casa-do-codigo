package org.casadocodigo.store.model;

public class Product {

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    @Override
    public String toString() {
        return "Product{" +
                "description='" + description + '\'' +
                ", title='" + title + '\'' +
                ", pages=" + pages +
                '}';
    }

    private String description;
    private String title;
    private int pages;
}
