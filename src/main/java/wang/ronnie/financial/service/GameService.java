package wang.ronnie.financial.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wang.ronnie.financial.persist.db.GameDao;
import wang.ronnie.financial.persist.model.Game;

import java.util.List;

/**
 * Created by ronniewang on 17/6/14.
 */
@Service
public class GameService {

    @Autowired
    private GameDao gameDao;

    public void add(Game game) {

        gameDao.insert(game);
    }

    public List<Game> findByPerson(String person) {

        return gameDao.findByPerson(person);
    }


    public void delete(int id) {

        gameDao.delete(id);
    }
}
