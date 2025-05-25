package com.reactiveproductapp.mapper;

import com.reactiveproductapp.dto.ProductDTO;
import com.reactiveproductapp.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product toEntity(ProductDTO productDTO);

    ProductDTO toDTO(Product entity);
}
