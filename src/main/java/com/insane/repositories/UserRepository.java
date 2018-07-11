package com.insane.repositories;

import com.insane.users.TypeOfSubscription;
import com.insane.users.User;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

@Component
public class UserRepository {

    // Quick fake repository with custom users in it

    private static final Map<String, User> users = new HashMap<>();
    private GregorianCalendar gregorianCalendar = new GregorianCalendar();

    @PostConstruct
    public void initData () throws DatatypeConfigurationException {
        User mark = new User();
        mark.setName("Mark");
        mark.setAge(21);
        gregorianCalendar.setTime(new Date(1990,12,10));
        mark.setBirthday(DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar));
        mark.setFrom("Russia");
        mark.setPhone(987142587);
        mark.setTypeOfSubscription(TypeOfSubscription.NONE);

        User merry = new User();
        merry.setName("Merry");
        merry.setAge(14);
        gregorianCalendar.setTime(new Date(2004,2,13));
        merry.setBirthday(DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar));
        merry.setFrom("Sweden");
        merry.setPhone(398207001);
        merry.setTypeOfSubscription(TypeOfSubscription.SUBSCRIBED);

        User harrison = new User();
        harrison.setName("Harrison");
        harrison.setAge(89);
        gregorianCalendar.setTime(new Date(1921,10,1));
        harrison.setBirthday(DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar));
        harrison.setFrom("Slovenia");
        harrison.setPhone(102345672);
        harrison.setTypeOfSubscription(TypeOfSubscription.PRIVILEGED);

        users.put(mark.getName(), mark);
        users.put(merry.getName(), merry);
        users.put(harrison.getName(), harrison);
    }

    public User findUser (String name) {
        return users.get(name);
    }
}
