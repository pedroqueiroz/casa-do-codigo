package org.casadocodigo.store.controller;

import org.casadocodigo.store.dao.ProductDAO;
import org.casadocodigo.store.model.CartItem;
import org.casadocodigo.store.model.PriceType;
import org.casadocodigo.store.model.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/cart")
public class ShoppingCartController {

    @Autowired
    private ProductDAO productDao;

    @Autowired
    private ShoppingCart cart;

    @RequestMapping("/add")
    public ModelAndView add(Integer productId, PriceType priceType) {
        ModelAndView modelAndView = new ModelAndView("redirect:/products");

        CartItem cartItem = createItem(productId, priceType);

        cart.add(cartItem);

        return modelAndView;
    }

    private CartItem createItem(Integer productId, PriceType priceType) {
        return new CartItem(productDao.findById(productId), priceType);
    }
}
