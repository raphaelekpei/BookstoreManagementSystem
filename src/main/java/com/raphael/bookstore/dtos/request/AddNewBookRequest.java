package com.raphael.bookstore.dtos.request;

import com.raphael.bookstore.data.model.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddNewBookRequest {
    private String title;
    private String author;
    private Integer pages;
    private String publisher;
    private Double price;
    private Category category;
    private String ISBN;

}
