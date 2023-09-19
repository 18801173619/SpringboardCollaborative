package org.tsc.model;

import lombok.Data;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

@Data
@DynamoDbBean
public class MentalAbnormalRecipient extends Recipient{

    private boolean inMentalTreatment;
}
