package com.springboot.hello.data.dto;

import lombok.*;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ProductDto {
    private Long number;
    private String name;
    private int price;
    private int stock;
}
