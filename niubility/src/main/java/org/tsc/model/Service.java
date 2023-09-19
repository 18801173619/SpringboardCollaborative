package org.tsc.model;

import lombok.Data;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

import java.sql.Date;

@Data
@DynamoDbBean
public class Service {

    private String serviceId;
    private Date startDate;
    private Date endDate;
    private String progress;
    private boolean completed;

    @DynamoDbPartitionKey
    public String getServiceId() {
        return serviceId;
    }
}
