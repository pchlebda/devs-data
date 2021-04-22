package com.devs.rest;

import com.devs.reader.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.StandardHttpRequestRetryHandler;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Slf4j
public class UserApacheClient implements UserRestClient {

    public static final String URL = "http://54.70.230.245:80";
    private final ObjectMapper objectMapper;


    public UserApacheClient() {
        this.objectMapper = new ObjectMapper();
    }

    @Override
    public void sendUsers(List<User> users) {
        int count = 0;
        for (User user : users) {
            sendUser(user);
            ++count;
            if (count % 1000 == 0) {
                log.info("Sent {} users.", count);
            }
        }
    }

    private void sendUser(User user) {
        HttpPost httpPost = new HttpPost(URL);
        try {
            final CloseableHttpClient client = HttpClientBuilder
                    .create()
                    .setRetryHandler(new StandardHttpRequestRetryHandler(10, true))
                    .build();
            String json = objectMapper.writeValueAsString(user);
            StringEntity entity = new StringEntity(json);
            httpPost.setEntity(entity);
            httpPost.setHeader("Accept", "application/json");
            httpPost.setHeader("Content-type", "application/json");
            CloseableHttpResponse response = client.execute(httpPost);
            if (response.getStatusLine().getStatusCode() != 200) {
                log.warn("There was problem with sending request {} - payload {}. Response status {}.", httpPost, json, response);
            }
            client.close();
        } catch (JsonProcessingException e) {
            log.error("Error during serializing user.", e);
        } catch (UnsupportedEncodingException e) {
            log.error("Unsupported type.", e);
        } catch (IOException e) {
            log.error("Http client exception", e);
        }
    }
}
