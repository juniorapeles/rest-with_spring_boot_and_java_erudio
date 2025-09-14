package br.com.junior.rest_with_spring_boot_and_java_erudio.data.dto.v1;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class BookDTO implements Serializable {

    private Long id;
    private String author;
    private LocalDateTime launchDate;
    private BigDecimal price;
    private String title;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDateTime getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(LocalDateTime launchDate) {
        this.launchDate = launchDate;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
