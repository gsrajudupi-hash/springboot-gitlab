package com.ltm.training.gitlab.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ltm.training.gitlab.model.Product;

@Service
public class ProductService {

	private final List<Product> products = List.of(
			//<<<<<<< HEAD  //Marks begining of local changes
			new Product(1L,"Keyboard",new BigDecimal("52.99"),"Input Devices"),
			//======= //divider b/n ur local changes & incoming changes
			//			new Product(1L,"Keyboard",new BigDecimal("54.99"),"Input Devices"),
			//>>>>>>> feature/product-pricing //End of incoming changes
			new Product(2L,"Mouse",new BigDecimal("19.99"),"Input Devices"),
			new Product(3L,"Monitor",new BigDecimal("189.00"),"Output Devices"));

	public List<Product> findAll(){
		return products;
	}

	public Optional<Product> findById(Long id) {
		return products.stream().filter(p -> p.getId().equals(id)).findFirst();
	}


	public List<Product> searchByName(String query) {
	    String searchText = query.toLowerCase(Locale.ROOT);

	    return products.stream()
	            .filter(product -> product.getName() != null
	                    && product.getName()
	                              .toLowerCase(Locale.ROOT)
	                              .contains(searchText))
	            .toList();
	}


}
