package com.malinovskiy.barcodereader.controller;

import com.malinovskiy.barcodereader.domain.BarcodeBean;
import com.malinovskiy.barcodereader.service.BarcodeService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by malinovsky on 9/17/2014.
 */
@Controller
@RequestMapping("/barcodes")
public class BarcodeController {
    private static final Logger LOG = Logger.getLogger(BarcodeController.class);

    @Autowired
    private BarcodeService barcodeService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<BarcodeBean> addBarcode(@RequestBody BarcodeBean barcodeBean) {
        barcodeService.add(barcodeBean);
        LOG.info(barcodeBean + " was added.");
        return new ResponseEntity<BarcodeBean>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    public String viewAll(HttpServletRequest request) {
        request.setAttribute("barcodes", barcodeService.getAll());
        return "barcodes";
    }

}
