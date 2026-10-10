package com.springRest.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class BookDto {
	
    private Integer id;
	
    @NotBlank(message = "name is required")
	private String name;
	
    @NotNull(message = "price is required")
	private Double price;
	
    @NotBlank(message = "author is required")
	private String author;
	
    @NotNull(message = "quantity is required")
	private Integer qty;

}
