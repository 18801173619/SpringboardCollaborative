package org.tsc.service;

import org.tsc.model.Recipient;

public interface RecipientService {

    Recipient saveRecipient(Recipient recipient);

    Recipient getRecipient(String id);

    Recipient updateRecipient(Recipient recipient);

    void deleteRecipient(Recipient recipient);

    //TODO: calculate statistics
}
