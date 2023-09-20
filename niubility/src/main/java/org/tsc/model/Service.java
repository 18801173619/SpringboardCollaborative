package org.tsc.model;

import lombok.*;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

import java.sql.Date;

@Data
@DynamoDbBean
@Getter
@Setter
@NoArgsConstructor
public class Service {

    private String serviceId;
    private Recipient recipient;
    private Date startDate;
    private Date endDate;
    private ProgressEnum progress;
    private ServiceTypeEnum type;

    @DynamoDbPartitionKey
    public String getServiceId() {
        return serviceId;
    }
}
