package org.witpool.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.witpool.common.enums.WitCode;
import org.witpool.common.model.bean.WitResult;
import org.witpool.common.model.po.WitUser;
import org.witpool.common.util.WitUtil;
import org.witpool.persist.WitRepository;
import org.witpool.service.WitService;

@RestController
@RequestMapping("/users")
public class WitUserRest {
    private final static Logger log = LoggerFactory.getLogger(WitUserRest.class);

    @Autowired
    private WitRepository reposit;
    @Autowired
    private WitService service;

    @PostMapping
    public WitResult<WitUser> addUser(@RequestBody WitUser user)
    {
        return WitUtil.success(reposit.save(user));
    }

    @PostMapping(value = "/{number}")
    public WitResult<WitUser> addUsers(@PathVariable("number") Integer num) {
        if (num < 0 || num > 10) {
            log.error("The number should be [0, 10]");
            return WitUtil.failure(WitCode.WIT_ERR_INVALID_PARAM);
        }
        return WitUtil.success(service.addUsers(num));
    }

    @PutMapping
    public WitResult<WitUser> updateUser(@RequestBody WitUser user)
    {
        return WitUtil.success(reposit.save(user));
    }

    @DeleteMapping(value = "/{userId}")
    public WitResult<WitUser> deleteUser(@PathVariable("userId") Integer userId) {
        reposit.delete(userId);
        return WitUtil.success();
    }

    @GetMapping(value = "/{userId}")
    public WitResult<WitUser> getUserByID(@PathVariable("userId") Integer userId) {
        return WitUtil.success(reposit.findOne(userId));
    }

    @GetMapping(value = "/name/{userName}")
    public WitResult<WitUser> getUserByName(@PathVariable("userName") String userName) {
        return WitUtil.success(reposit.findByUserName(userName));
    }

    @GetMapping
    public WitResult<WitUser> getUsers()
    {
        return WitUtil.success(reposit.findAll());
    }
}
