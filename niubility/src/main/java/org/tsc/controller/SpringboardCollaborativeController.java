package org.tsc.controller;

import io.awspring.cloud.dynamodb.DynamoDbTemplate;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tsc.model.*;
import org.tsc.model.builder.RecipientBuilder;
import org.tsc.schema.ResponseSchema;
import org.tsc.service.MockService;
import org.tsc.service.RecipientService;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.ListTablesRequest;
import software.amazon.awssdk.services.dynamodb.model.ListTablesResponse;

import java.util.List;

@RestController
@RequestMapping(value = "/dnn")
@Tag(name = "Tsc Application Api")
public class SpringboardCollaborativeController {

    @Autowired
    DynamoDbTemplate dynamoDbTemplate;

    @Autowired
    private RecipientService recipientService;

    @Autowired
    private MockService mockService;

    Region region = Region.US_EAST_1;

    DynamoDbClient ddb = DynamoDbClient.builder()
            // .credentialsProvider(credentialsProvider)
            .region(region)
            .build();


    @GetMapping("")
    @Operation(summary = "get Dbinfo")
    public List<String> getDBInfo() {
        ListTablesResponse response = null;
        ListTablesRequest request = ListTablesRequest.builder().build();
        response = ddb.listTables(request);

        return response.tableNames();
    }

    @GetMapping(value = "/navigators")
    @Operation(summary = "Get Navigators", description = "get navigators for task assigning")
    @ResponseBody
    public List<Navigator> getNavigators() {
        return mockService.getNavigators();
    }

    @GetMapping(value = "/recipients")
    @Operation(summary = "Get Recipients", description = "get recipients for task assigning")
    @ResponseBody
    public List<Recipient> getReceipients() {
        return mockService.getReceipients();
    }

    @GetMapping(value = "/organizations")
    @Operation(summary = "Get Organizations", description = "get organizations for service providing")
    @ResponseBody
    public List<Organization> getOrganizations() {
        return mockService.getOrganizations();
    }

    @GetMapping(value = "/tasks")
    @Operation(summary = "Get Tasks", description = "get tasks for task assigning")
    @ResponseBody
    public List<TSCTask> getTasks() {
        return mockService.getTasks();
    }


    @PostMapping(value = "/addRecipient")
    @ResponseBody
    @Operation(summary = "Add Recipient", description = "Add Recipient into System")
    public ResponseSchema addRecipient(@RequestBody Recipient recipient) {
        ResponseSchema responseSchema = ResponseSchema.builder().build();
        try {
            recipientService.saveRecipient(recipient);
            responseSchema.setStatus("200");
            responseSchema.setMessage("add recipient success");
        } catch (Exception e) {
            responseSchema.setStatus("400");
            responseSchema.setMessage(e.getMessage());
        }

        return responseSchema;
    }

    @GetMapping("/queryRecipient")
    @ResponseBody
    @Operation(summary = "Query Recipient", description = "Query Recipient from System")
    public Recipient queryRecipient(@RequestParam(value = "id") String id) {
        Recipient recipient = recipientService.getRecipient(id);
        return recipient;
    }

}
