package org.tsc.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

@Data
@DynamoDbBean
@Getter
@Setter
@Builder
public class Navigator extends Person {

    private String navigatorId;

    @DynamoDbPartitionKey
    public String getNavigatorId() {
        return navigatorId;
    }

}
