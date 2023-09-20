package org.tsc.model;

import lombok.*;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

@DynamoDbBean
@Getter
@Setter
@NoArgsConstructor
public class TSCTask {

    private String taskId;

    private TSCAdministrator tscAdministrator;

    private Navigator navigator;

    private TaskProgressEnum taskProgressEnum;

    @DynamoDbPartitionKey
    public String getTaskId() {
        return taskId;
    }
}
