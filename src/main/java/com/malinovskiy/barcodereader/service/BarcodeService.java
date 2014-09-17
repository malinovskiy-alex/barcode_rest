package com.malinovskiy.barcodereader.service;

import com.malinovskiy.barcodereader.domain.BarcodeBean;

import java.util.List;

/**
 * Created by malinovsky on 9/17/2014.
 */

public interface BarcodeService {
    boolean add(BarcodeBean barcodeBean);

    List<BarcodeBean> getAll();
}
