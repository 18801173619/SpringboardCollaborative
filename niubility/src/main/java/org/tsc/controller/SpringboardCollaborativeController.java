package org.tsc.controller;

import io.awspring.cloud.dynamodb.DynamoDbTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.ListTablesRequest;
import software.amazon.awssdk.services.dynamodb.model.ListTablesResponse;

import java.util.List;

@RestController
public class SpringboardCollaborativeController {

    @Autowired
    DynamoDbTemplate dynamoDbTemplate;

    Region region = Region.US_EAST_1;

    DynamoDbClient ddb = DynamoDbClient.builder()
            // .credentialsProvider(credentialsProvider)
            .region(region)
            .build();


    @GetMapping("/dnn")
    public List<String> getDBInfo() {
        ListTablesResponse response = null;
        ListTablesRequest request = ListTablesRequest.builder().build();
        response = ddb.listTables(request);

        return response.tableNames();
    }
}
