package org.casadocodigo.store.controller;

import org.casadocodigo.store.model.PaymentData;
import org.casadocodigo.store.model.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping
public class PaymentController {

    private static final String PAYMENT_GATEWAY = "http://book-payment.herokuapp.com/payment";

    @Autowired
    private ShoppingCart cart;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/checkout", method = RequestMethod.POST)
    public ModelAndView checkout(RedirectAttributes model) {
        try {
            String response = restTemplate.postForObject(PAYMENT_GATEWAY, new PaymentData(cart.getTotalPrice()), String.class);
            model.addFlashAttribute("successMessage", response);
        } catch (HttpClientErrorException e) {
            model.addFlashAttribute("errorMessage", "Valor maior que o permitido");
        }


        return new ModelAndView("redirect:/products");
    }
}
