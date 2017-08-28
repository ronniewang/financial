package wang.ronnie.financial.blog;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.apache.commons.io.FileUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wang.ronnie.financial.model.JsonArrayResponse;

import java.io.File;
import java.io.IOException;

/**
 * Created by ronniewang on 17/8/10.
 */
@RestController
@RequestMapping("/category")
public class CategoryController {

    private File categoryJson = new ClassPathResource("category.json").getFile();

    public CategoryController() throws IOException {

    }

    @RequestMapping("/all")
    JsonArrayResponse<Object> all() throws CategoryException {

        String text;
        JSONArray objects;
        try {
            text = FileUtils.readFileToString(categoryJson, "utf-8");
            objects = JSON.parseArray(text);
        } catch (Exception e) {
            throw new CategoryException("JSON_ERROR", "parse json file error");
        }
        return new JsonArrayResponse<>(objects);
    }
}
