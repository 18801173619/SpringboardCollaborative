package org.tsc.model;

import lombok.*;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

import java.util.List;

@Data
@DynamoDbBean
@Getter
@Setter
@NoArgsConstructor
public class OpiateAddictedRecipient extends Recipient {

    private List<OpiateHistory> opiateHistoryList;
    private String addictedSubstance;
    private boolean activeUse;
    private String treatmentType;
    private String status;

}
