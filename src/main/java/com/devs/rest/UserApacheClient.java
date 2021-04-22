package com.devs.rest;

import com.devs.reader.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Slf4j
public class UserApacheClient implements UserRestClient {

    private final CloseableHttpClient client;
    private final ObjectMapper objectMapper;


    public UserApacheClient() {
        this.client = HttpClients.createDefault();
        this.objectMapper = new ObjectMapper();

    }

    @Override
    public void sendUsers(List<User> users) {
        users.forEach(this::sendUser);

    }

    private void sendUser(User user) {
        HttpPost httpPost = new HttpPost("http://54.70.230.245:80");
        String json = null;
        try {
            json = objectMapper.writeValueAsString(user);
            StringEntity entity = new StringEntity(json);
            httpPost.setEntity(entity);
            httpPost.setHeader("Accept", "application/json");
            httpPost.setHeader("Content-type", "application/json");
            CloseableHttpResponse response = client.execute(httpPost);
            if (response.getStatusLine().getStatusCode() != 200) {
                log.warn("There was problem with sending request {} - payload {}. Response status {}.", httpPost, json, response);
            }
        } catch (JsonProcessingException e) {
            log.error("Error during serializing user.", e);
        } catch (UnsupportedEncodingException e) {
            log.error("Unsupported type.", e);
        } catch (IOException e) {
            log.error("Http client exception", e);
        }
    }
}
