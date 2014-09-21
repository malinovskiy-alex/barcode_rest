package com.malinovskiy.barcodereader.integration;

import com.malinovskiy.barcodereader.domain.BarcodeBean;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.List;

/**
 * Created by malinovsky on 9/20/2014.
 */
public class BarcodesPageIT {

    private static Logger LOG = Logger.getLogger(BarcodesPageIT.class);

    private static WebDriver driver;
    private static final String APP_URL = "http://localhost:9090";

    @BeforeClass
    public static void setUp() throws Exception {
        driver = new ChromeDriver();
    }

    @Test
    public void testGetAllAfterPost() throws InterruptedException {
        BarcodeBean bean = new BarcodeBean("KH", "Arrived", "1234556");
        int result = postBean(bean);
        assert result == 200;
        driver.get(APP_URL + "/barcodes");
        List<WebElement> rows = driver.findElement(By.id("barcodes")).findElements(By.tagName("tr"));
        assert 2 == rows.size();
    }

    @AfterClass
    public static void tearDown() throws Exception {
        driver.quit();
    }

    private int postBean(BarcodeBean bean) {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpPost postRequest = new HttpPost(APP_URL + "/barcodes");
            StringEntity input = new StringEntity(bean.toString());
            input.setContentType("application/json");
            postRequest.setEntity(input);
            HttpResponse response = httpClient.execute(postRequest);
            return response.getStatusLine().getStatusCode();
        } catch (IOException e) {
            LOG.error("Unable to post barcode bean.");
            return 400;
        }
    }

}
