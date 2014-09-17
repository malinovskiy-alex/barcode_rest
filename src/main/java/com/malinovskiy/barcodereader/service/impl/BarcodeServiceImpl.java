package com.malinovskiy.barcodereader.service.impl;

import com.malinovskiy.barcodereader.domain.BarcodeBean;
import com.malinovskiy.barcodereader.service.BarcodeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by malinovsky on 9/17/2014.
 */
@Service
public class BarcodeServiceImpl implements BarcodeService {
    @Resource
    private List<BarcodeBean> container;

    @Override
    public boolean add(BarcodeBean barcodeBean) {
        return container.add(barcodeBean);
    }

    @Override
    public List<BarcodeBean> getAll() {
        return container;
    }
}
