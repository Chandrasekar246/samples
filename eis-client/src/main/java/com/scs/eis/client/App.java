package com.scs.eis.client;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

/**
 * Employee Information System - Client Application
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        final String uri = "http://localhost:8080/eis-server/employees/xml/employee";
        
        final String body = "<employee> <id>2333</id> <name>alan</name> <joiningDate>2002-09-24</joiningDate> <department>hr</department> </employee>";
        
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_XML);
        
        HttpEntity<String> entity = new HttpEntity<String>(body, headers);
        
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.postForEntity(uri, entity, String.class).getBody();
         
        System.out.println(result);
    }
}
