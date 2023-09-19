package org.tsc.model;

import lombok.Data;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

@Data
@DynamoDbBean
public class OpiateAddictedRecipient extends Recipient {

    private String opiateUsageHistory;

    private String addictedSubstance;
    private boolean activeUse;
    private String treatmentType;
    private String status;

}
