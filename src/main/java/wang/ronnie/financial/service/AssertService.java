package wang.ronnie.financial.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wang.ronnie.financial.persist.db.AssertDao;
import wang.ronnie.financial.persist.model.Assert;

import java.util.List;

/**
 * Created by ronniewang on 17/6/14.
 */
@Service
public class AssertService {

    @Autowired
    private AssertDao assertDao;

    public void add(Assert a) {

        assertDao.insert(a);
    }

    public void delete(int id) {

        assertDao.delete(id);
    }

    public List<Assert> all(int id) {

        return assertDao.findById(id);
    }
}
