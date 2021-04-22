package com.devs;

import com.devs.mapper.UserCsvMapper;
import com.devs.predicates.UserMatchingPredicate;
import com.devs.reader.CompressedFileReader;
import com.devs.reader.CsvUserReader;
import com.devs.reader.User;
import com.devs.reader.UserReader;
import com.devs.reader.ZippedFileReader;
import com.devs.rest.UserApacheClient;
import com.devs.rest.UserRestClient;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Slf4j
public class Main {

    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            log.warn("Please provide 2 arguments path to .zip file and password");
        } else {
            UserReader userReader = new CsvUserReader(new UserCsvMapper(), new UserMatchingPredicate());
            CompressedFileReader compressedFileReader = new ZippedFileReader();
            InputStream inputStream = compressedFileReader.getInputStream(args[0], args[1].toCharArray());
            List<User> matchingUsers = userReader.readAllUsersMatching(inputStream);
            UserRestClient userRestClient = new UserApacheClient();
            userRestClient.sendUsers(matchingUsers);
        }
    }

}
