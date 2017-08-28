package wang.ronnie.converter.creator;

import org.junit.Test;

/**
 * Created by ronniewang on 17/8/7.
 */
public class UlCreatorTest {

    @Test
    public void render() throws Exception {

        String content = UlCreator.ul().start()
                .li("list1")
                .ul(UlCreator.ul().start()
                        .li("sub 1-1")
                        .li("sub 1-2")
                        .end())
                .li("list2")
                .ul(UlCreator.ul().start()
                        .li("sub2-1")
                        .li("sub2-2")
                        .ul(UlCreator.ul().start()
                                .li("sub2-2-1")
                                .li("sub2-2-2")
                                .end())
                        .end())
                .end()
                .render();
        System.out.println(content);
    }

}