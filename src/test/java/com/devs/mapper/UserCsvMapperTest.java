package com.devs.mapper;

import com.devs.reader.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class UserCsvMapperTest {

    private UserMapper testee;

    @BeforeEach
    void beforeEach() {
        testee = new UserCsvMapper();
    }

    @Test
    void shouldParseUserFromLine() {
        //given
        User expectedUser = getExpectedUser();
        String inputLine = getInputLine();

        //when
        User actual = testee.fromCsvLine(inputLine);

        //then
        Assertions.assertEquals(expectedUser, actual);
    }

    private User getExpectedUser() {
        return User.builder()
                .firstName("0DTNFW9L79")
                .lastName("DIXG7QE")
                .email("QMYPV61.06YTOV@domain.com")
                .param0(Arrays.asList("XZ4XM", "BQ1TMY"))
                .param1(Arrays.asList("8VPZPWBMZ", "N67OA"))
                .param2(Arrays.asList("F9U6NZ", "RUT142STO"))
                .param3(Arrays.asList("3TMTM", "O34REAT"))
                .param4(Arrays.asList("GWWQA6H8D", "DQG1PA"))
                .param5(Arrays.asList("CIQDLKH", "1E5BYT7ZB"))
                .param6(Arrays.asList("1G8FOGRYGP", "4TAOJN0"))
                .param7(Arrays.asList("8JZFUS", "XMLO95VV"))
                .param8(Arrays.asList("4MPMSQ", "EEA1O"))
                .build();
    }

    private String getInputLine() {
        return "\"0DTNFW9L79\";\"DIXG7QE\";\"QMYPV61.06YTOV@domain.com\";\"['XZ4XM', 'BQ1TMY']\";\"['8VPZPWBMZ', 'N67OA']\";\"['F9U6NZ', 'RUT142STO']\";\"['3TMTM', 'O34REAT']\";\"['GWWQA6H8D', 'DQG1PA']\";\"['CIQDLKH', '1E5BYT7ZB']\";\"['1G8FOGRYGP', '4TAOJN0']\";\"['8JZFUS', 'XMLO95VV']\";\"['4MPMSQ', 'EEA1O']\"";

    }
}