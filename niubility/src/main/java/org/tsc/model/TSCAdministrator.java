package org.tsc.model;

import lombok.Data;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

@Data
@DynamoDbBean
public class TSCAdministrator extends Person {

    private String adminId;

    @DynamoDbPartitionKey
    public String getAdminId() {
        return adminId;
    }
}
