package com.devs.mapper;

import com.devs.reader.User;

import java.util.Arrays;
import java.util.List;

public class UserCsvMapper implements UserMapper {

    public static final String DELIMITER = ";";
    public static final int FIRST_NAME_INDEX = 0;
    public static final int LAST_NAME_INDEX = 1;
    public static final int EMAIL_INDEX = 2;
    public static final int PARAM_0_INDEX = 3;
    public static final int PARAM_1_INDEX = 4;
    public static final int PARAM_2_INDEX = 5;
    public static final int PARAM_3_INDEX = 6;
    public static final int PARAM_4_INDEX = 7;
    public static final int PARAM_5_INDEX = 8;
    public static final int PARAM_6_INDEX = 9;
    public static final int PARAM_7_INDEX = 10;
    public static final int PARAM_8_INDEX = 11;

    @Override
    public User fromCsvLine(String line) {
        String[] array = line.split(DELIMITER);
        return User.builder()
                .firstName(replaceQuotation(array[FIRST_NAME_INDEX].replaceAll("\"", "")))
                .lastName(replaceQuotation(array[LAST_NAME_INDEX]))
                .email(replaceQuotation(array[EMAIL_INDEX]))
                .param0(readAsList(array[PARAM_0_INDEX]))
                .param1(readAsList(array[PARAM_1_INDEX]))
                .param2(readAsList(array[PARAM_2_INDEX]))
                .param3(readAsList(array[PARAM_3_INDEX]))
                .param4(readAsList(array[PARAM_4_INDEX]))
                .param5(readAsList(array[PARAM_5_INDEX]))
                .param6(readAsList(array[PARAM_6_INDEX]))
                .param7(readAsList(array[PARAM_7_INDEX]))
                .param8(readAsList(array[PARAM_8_INDEX]))
                .build();
    }

    private String replaceQuotation(String word) {
        return word.replaceAll("\"", "").replaceAll("\\s+", "");
    }

    private List<String> readAsList(final String list) {
        String[] array = list.replaceAll("\"", "")
                .replaceAll("\\[", "")
                .replaceAll("\\]", "")
                .replaceAll("\'", "")
                .replaceAll("\\s+", "")
                .split(",");
        return Arrays.asList(array);
    }
}
