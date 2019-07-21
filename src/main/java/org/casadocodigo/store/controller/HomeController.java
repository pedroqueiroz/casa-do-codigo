package org.casadocodigo.store.controller;

import org.casadocodigo.store.dao.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @Autowired
    private ProductDAO productDao;

    @RequestMapping("/")
    @Cacheable("serveHome")
    public ModelAndView serveHome() {
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("products", productDao.list());

        return modelAndView;
    }
}
