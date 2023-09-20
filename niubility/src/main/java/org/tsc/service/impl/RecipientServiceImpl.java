package org.tsc.service.impl;

import io.awspring.cloud.dynamodb.DynamoDbOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tsc.model.Recipient;
import org.tsc.service.RecipientService;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.model.PageIterable;
import software.amazon.awssdk.enhanced.dynamodb.model.QueryConditional;
import software.amazon.awssdk.enhanced.dynamodb.model.QueryEnhancedRequest;

@Service
public class RecipientServiceImpl implements RecipientService {

    @Autowired
    private DynamoDbOperations dynamoDbOperations;

    @Override
    public Recipient saveRecipient(Recipient recipient) {
        Recipient saved = dynamoDbOperations.save(recipient);
        return saved;
    }

    @Override
    public Recipient getRecipient(String id) {
        PageIterable<Recipient> recipients = dynamoDbOperations.query(
                QueryEnhancedRequest.builder()
                        .queryConditional(
                                QueryConditional.keyEqualTo(Key.builder().partitionValue(id).build()))
                        .build(),
                Recipient.class);
        return recipients.items().stream().findFirst().orElse(null);
    }

    @Override
    public Recipient updateRecipient(Recipient recipient) {
        Recipient updated = dynamoDbOperations.update(recipient);
        return updated;
    }

    @Override
    public void deleteRecipient(Recipient recipient) {
        dynamoDbOperations.delete(recipient);
    }
}
