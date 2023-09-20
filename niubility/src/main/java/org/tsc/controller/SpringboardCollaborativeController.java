package org.tsc.controller;

import io.awspring.cloud.dynamodb.DynamoDbTemplate;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tsc.model.Navigator;
import org.tsc.model.Organization;
import org.tsc.model.Recipient;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.ListTablesRequest;
import software.amazon.awssdk.services.dynamodb.model.ListTablesResponse;

import java.util.List;

@RestController
@Tag(name = "Tsc Application Api")
public class SpringboardCollaborativeController {

    @Autowired
    DynamoDbTemplate dynamoDbTemplate;

    Region region = Region.US_EAST_1;

    DynamoDbClient ddb = DynamoDbClient.builder()
            // .credentialsProvider(credentialsProvider)
            .region(region)
            .build();


    @GetMapping("/dnn")
    @Operation(summary = "get Dbinfo")
    public List<String> getDBInfo() {
        ListTablesResponse response = null;
        ListTablesRequest request = ListTablesRequest.builder().build();
        response = ddb.listTables(request);

        return List.of("sfsdf");
    }

    @PostMapping(value = "/navigators")
    @Operation(summary = "Get Navigators", description = "get navigators for task assigning")
    public List<Navigator> getNavigators(@RequestParam (value = "host") String host) {
        return List.of(new Navigator());
    }


    @PostMapping(value = "/recipients")
    @Operation(summary = "Get Recipients", description = "get recipients for task assigning")
    public List<Recipient> getReceipients(@RequestBody EmailGetawayBean email) {
        return List.of(new Recipient());
    }

    @PostMapping(value = "/organizations")
    @Operation(summary = "Get Organizations", description = "get organizations for task assigning")
    public List<Organization> getOrganizations(@RequestBody EmailGetawayBean email) {
        return List.of(new Organization());
    }

    @Data
    public class EmailGetawayBean {
        String host, port, email, password, report_name;
    }

}
