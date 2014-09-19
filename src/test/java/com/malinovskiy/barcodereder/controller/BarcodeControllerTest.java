package com.malinovskiy.barcodereder.controller;

import com.malinovskiy.barcodereader.controller.BarcodeController;
import com.malinovskiy.barcodereader.domain.BarcodeBean;
import com.malinovskiy.barcodereader.service.BarcodeService;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * Created by malinovsky on 9/17/2014.
 */
@Ignore
public class BarcodeControllerTest {
    MockMvc mockMvc;
    @InjectMocks
    BarcodeController controller;
    @Mock
    BarcodeService service;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = standaloneSetup(controller).build();
    }

    @Test
    public void testGetAllReturnsJson() throws Exception {
        when(service.getAll()).thenReturn(Arrays.asList(new BarcodeBean("Picked", "AN", "4321"), new BarcodeBean("Arrival", "GN", "1234")));

        this.mockMvc.perform(
                get("/barcodes")
                        .accept(MediaType.APPLICATION_JSON)
        )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[1].barcode").value("1234"));
    }

    @Test
    public void testAddReturnOk() throws Exception {
        this.mockMvc.perform(
                post("/barcodes")
                        .content("{ \"type\" : \"Arrived\", \"locationCode\" : \"AN\", \"barcode\" : \"1234\" }")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
        )
                .andDo(print())
                .andExpect(status().isOk());
    }

}
