package org.tsc.model;

import lombok.*;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

@Data
@DynamoDbBean
@Getter
@Setter
@NoArgsConstructor
public class MentalAbnormalRecipient extends Recipient{


    private boolean inMentalTreatment;
}
