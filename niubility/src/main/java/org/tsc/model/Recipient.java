package org.tsc.model;

import lombok.Data;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

import java.util.List;

@Data
@DynamoDbBean
public class Recipient extends Person {

    private String recipientId;
    private List<RecipientNeed> assistanceNeeded;
    private String description;

    @DynamoDbPartitionKey
    public String getRecipientId() {
        return recipientId;
    }
}
