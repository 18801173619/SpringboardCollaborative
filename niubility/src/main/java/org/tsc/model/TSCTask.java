package org.tsc.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

@DynamoDbBean
@Getter
@Setter
@Builder
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
