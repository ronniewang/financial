package wang.ronnie.financial.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import wang.ronnie.financial.persist.db.GameDao;
import wang.ronnie.financial.persist.model.Game;

import static org.mockito.Mockito.*;

/**
 * Created by ronniewang on 17/7/26.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GameServiceTest {

    @MockBean
    public GameDao gameDao;

    @Autowired
    private GameService gameService;

    @Test
    public void add() throws Exception {

        Game spy = spy(Game.class);
        doReturn(1).when(gameDao).add(spy);
        gameDao.add(spy);
//        verify(gameDao, times(1));
    }

    @Test
    public void findByPerson() throws Exception {

    }

    @Test
    public void delete() throws Exception {

    }

}