package org.tsc.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Builder
@Getter
@Setter
public class OpiateHistory {

    private Date startDate;
    private Date endDate;
    private String substance;

}
