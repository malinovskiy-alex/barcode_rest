package com.malinovskiy.barcodereader.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by malinovsky on 9/20/2014.
 */
@Controller
@RequestMapping("/")
public class HomeController {
    private static final Logger LOG = Logger.getLogger(BarcodeController.class);

    @RequestMapping(method = RequestMethod.GET)
    public String getStartPage() {
        LOG.info("Request to home page.");
        return "redirect:barcodes";
    }
}
