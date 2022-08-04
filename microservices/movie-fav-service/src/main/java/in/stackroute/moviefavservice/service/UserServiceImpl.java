package in.stackroute.moviefavservice.service;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import in.stackroute.moviefavservice.dto.IdentityResponse;

@Service
public class UserServiceImpl implements UserService {

    private static final String URL = "http://movie-fav-service/users/validate";

    @LoadBalanced
    private RestTemplate restTemplate;

    public UserServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public IdentityResponse validateToken(String token) {

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + token);

        HttpEntity<String> request = new HttpEntity<>(headers);

        ResponseEntity<IdentityResponse> response =
                restTemplate.exchange(URL, HttpMethod.POST, request, IdentityResponse.class);

        return response.getBody();

    }



}
