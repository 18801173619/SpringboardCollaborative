package org.tsc.model;

import lombok.Data;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

@Data
@DynamoDbBean
public class Navigator extends Person {

    private String navigatorId;

    @DynamoDbPartitionKey
    public String getNavigatorId() {
        return navigatorId;
    }

}
