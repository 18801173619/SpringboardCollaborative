package org.tsc.model;

import lombok.Builder;
import lombok.Data;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

@Data
@DynamoDbBean
@Builder
public class MentalAbnormalRecipient extends Recipient{

    private boolean inMentalTreatment;
}
