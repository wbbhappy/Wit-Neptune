package org.witpool.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.witpool.common.model.po.WitUser;
import org.witpool.persist.WitRepository;
import java.util.ArrayList;
import java.util.List;

@Service
public class WitService {
    @Autowired
    private WitRepository reposit;
    
    @Transactional
    public List<WitUser> addUsers(int num) {
        List<WitUser> users = new ArrayList<WitUser>();
        for (int i = 0; i < num; i++) {
            WitUser usr = new WitUser();
            usr.setUserName("wituser" + i);
            usr.setPassword("user@12" + i);
            usr.setEmail("wituser" + i + "@witpool.org");
            usr.setCellPhone("123456789" + i);
            users.add(reposit.save(usr));
        }
        return users;
    }
}
