package com.devs.reader;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class User {

    @JsonProperty("FirstName")
    private String firstName;
    @JsonProperty("LastName")
    private String lastName;
    @JsonProperty("Email")
    private String email;
    @JsonProperty("param1")
    private List<String> param1;
    @JsonProperty("param2")
    private List<String> param2;
    @JsonProperty("param3")
    private List<String> param3;
    @JsonProperty("param4")
    private List<String> param4;
    @JsonProperty("param5")
    private List<String> param5;
    @JsonProperty("param6")
    private List<String> param6;
    @JsonProperty("param7")
    private List<String> param7;
    @JsonProperty("param8")
    private List<String> param8;
    @JsonProperty("param0")
    private List<String> param0;
}
