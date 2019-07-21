package org.casadocodigo.store.controller;

import org.casadocodigo.store.dao.ProductDAO;
import org.casadocodigo.store.infrastructure.FileSaver;
import org.casadocodigo.store.model.PriceType;
import org.casadocodigo.store.model.Product;
import org.casadocodigo.store.validation.ProductValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.lang.annotation.Retention;
import java.util.Objects;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductDAO productDAO;

    @Autowired
    private FileSaver fileSaver;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(new ProductValidator());
    }

    @RequestMapping("/form")
    public ModelAndView getProductForm(Product product) {
        ModelAndView modelAndView = new ModelAndView("products/form");

        modelAndView.addObject("priceTypes", PriceType.values());

        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST)
    @CacheEvict(value = "serveHome", allEntries = true)
    public ModelAndView add(MultipartFile summary, @Valid Product product, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return getProductForm(product);
        }

        if (!Objects.equals(summary.getOriginalFilename(), "")) {
            product.setSummaryPath(fileSaver.write("summary-files", summary));
        }

        productDAO.add(product);

        redirectAttributes.addFlashAttribute("successMessage", "Product was added successfully!");

        return new ModelAndView("redirect:/products");
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView listProducts() {
        ModelAndView modelAndView = new ModelAndView("products/listing");

        modelAndView.addObject("products", productDAO.list());

        return modelAndView;
    }

    @RequestMapping("/details/{id}")
    public ModelAndView showDetails(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("products/details");

        Product product = productDAO.findById(id);

        modelAndView.addObject("product", product);

        return modelAndView;
    }
}
