package sprtingboot.springRest;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class StaticRestTemplate {
    private static final String BASE_URL = "http://94.198.50.185:7081/api/users";
    private static RestTemplate restTemplate = new RestTemplate();
    private static HttpHeaders headers = new HttpHeaders();

    public void connectionResult() {
        RequestCallback requestCallback = restTemplate.httpEntityCallback(new HttpEntity<>(headers), String.class);
        ResponseExtractor<ResponseEntity<String>> responseExtractor = restTemplate.responseEntityExtractor(String.class);
        ResponseEntity<String> responseEntity = restTemplate.execute(BASE_URL, HttpMethod.GET, requestCallback, responseExtractor);
        headers.put(HttpHeaders.COOKIE, responseEntity.getHeaders().get(HttpHeaders.SET_COOKIE));
    }

    public List allUsers() {
        HttpEntity<String> result = new HttpEntity<>(headers);
        ResponseEntity<List> resp = restTemplate.exchange(BASE_URL, HttpMethod.GET, result, List.class);
        return resp.getBody();
    }
    public String addUser(User user) {
        HttpEntity<User> request = new HttpEntity<>(user, headers);
        ResponseEntity<String> responses = restTemplate.exchange(BASE_URL, HttpMethod.POST, request, String.class);
        return responses.getBody();
    }
    public String deleteUser(Long id) {
        HttpEntity<User> request = new HttpEntity<>(headers);
        ResponseEntity<String> responses = restTemplate.exchange(BASE_URL + "/" + id, HttpMethod.DELETE, request, String.class);
        return responses.getBody();
    }
    public String updateUser(User user) {
        headers.set("X-HTTP-Method-Override", "PATCH");
        HttpEntity<User> request = new HttpEntity<>(user, headers);
        ResponseEntity<String> response = restTemplate.exchange(BASE_URL, HttpMethod.POST, request, String.class);
        return response.getBody();
    }




}
