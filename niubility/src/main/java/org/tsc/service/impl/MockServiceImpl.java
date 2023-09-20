package org.tsc.service.impl;


import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.tsc.model.Gender;
import org.tsc.model.Navigator;
import org.tsc.model.Race;
import org.tsc.service.MockService;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Component
@Primary
public class MockServiceImpl implements MockService {


    @Override
    public List<Navigator> getNavigators() {
        Navigator navigator = Navigator.builder().navigatorId(UUID.randomUUID().toString()).build();
        navigator.setFirstName("Mocked First Name");
        navigator.setLastName("Mocked Last Name");
        navigator.setAge(20);
        navigator.setDateOfBirth(DateFormat.getDateInstance().format(System.currentTimeMillis()));
        navigator.setRace(Race.BLACK);
        navigator.setPhoneNumber("123456");
        navigator.setGender(Gender.FEMALE);
        return null;
    }


}
