package com.malinovskiy.barcodereader.controller;

import com.malinovskiy.barcodereader.domain.BarcodeBean;
import com.malinovskiy.barcodereader.service.BarcodeService;
import com.sun.istack.internal.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    @ResponseBody
    public String viewAll(HttpServletRequest request, HttpServletResponse response) {
        return "barcodes.html";
    }

}
