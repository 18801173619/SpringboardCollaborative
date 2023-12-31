package org.tsc.service;

import org.tsc.model.Navigator;
import org.tsc.model.Organization;
import org.tsc.model.Recipient;
import org.tsc.model.TSCTask;

import java.util.List;

public interface MockService {

    List<Navigator> getNavigators();

    List<Recipient> getReceipients();

    List<Organization> getOrganizations();

    List<TSCTask> getTasks();

}
