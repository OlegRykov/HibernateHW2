package com.controller;

import com.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class ProductController {
    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(path = "/showAllProducts", method = RequestMethod.GET)
    public String showAllProduct(Model uiModel) {
        uiModel.addAttribute("productList", productService.showProductList());
        return "show-all-product";
    }

    @RequestMapping(value = "/showAllProducts-{filter}", method = RequestMethod.GET)
    public String showFilterProducts (Model uiModel,@PathVariable("filter") String filter){
        uiModel.addAttribute("productList", productService.showFilterList(filter));
        return "show-all-product";
    }
}
