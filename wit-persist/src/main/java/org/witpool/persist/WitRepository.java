package org.witpool.persist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.witpool.common.model.po.WitUser;
import java.util.List;

public interface WitRepository extends JpaRepository<WitUser, Integer> {
    public List<WitUser> findByUserName(String userName);
}
