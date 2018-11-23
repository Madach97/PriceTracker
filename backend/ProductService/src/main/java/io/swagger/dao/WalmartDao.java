package io.swagger.dao;

import com.EbucketList.api.models.WalmartResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import io.swagger.dao.dao.EcommerceDao;

import java.net.MalformedURLException;
import java.net.URL;

@Configuration
@Component
public class WalmartDao implements EcommerceDao{

    private final String baseUrl = "https://api.walmartlabs.com/v1/items/";

    @Value("${WALMART_API_KEY}")
    String apiKey;

    public WalmartResponse getItem(String productUrl) throws MalformedURLException {
        String[] components = productUrl.split("/");
        String itemId = components[components.length - 1];
        System.out.println("url: " + productUrl + " walmartResponse id: " + itemId);

        String urlString  = baseUrl+"/"+itemId+"?format=json&apiKey=" + apiKey;
        System.out.println(urlString);
        System.out.println(apiKey);
//        URI uri = UriComponentsBuilder.fromHttpUrl(baseUrl)
//                .path(itemId)
//                .queryParam("format", "json")
//                .queryParam("apiKey", apiKey)
//                .build().toUri();
//
//        System.out.println("URI value " + uri.toString());
//        URL url = uri.toURL();
//        System.out.println("URL value: " + url.toString());
        URL url = new URL(urlString);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<WalmartResponse> response = restTemplate.getForEntity(url.toString(), WalmartResponse.class);
        WalmartResponse walmartResponse = response.getBody();
        return walmartResponse;

    }


}

