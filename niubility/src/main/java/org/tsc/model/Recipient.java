package org.tsc.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

import java.util.List;

@Data
@DynamoDbBean
@NoArgsConstructor
public class Recipient extends Person {

    private String recipientId;
    private List<RecipientNeed> assistanceNeeded;
    private String description;

    @DynamoDbPartitionKey
    public String getRecipientId() {
        return recipientId;
    }
}
