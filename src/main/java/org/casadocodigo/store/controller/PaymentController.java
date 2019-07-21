package org.casadocodigo.store.controller;

import org.casadocodigo.store.model.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping
public class PaymentController {

    @Autowired
    private ShoppingCart cart;

    @RequestMapping(value = "/checkout", method = RequestMethod.POST)
    public ModelAndView checkout(RedirectAttributes model) {
        System.out.println(cart.getTotalPrice());

        model.addFlashAttribute("successMessage", "Payment has been successfully processed!");

        return new ModelAndView("redirect:/products");
    }
}
