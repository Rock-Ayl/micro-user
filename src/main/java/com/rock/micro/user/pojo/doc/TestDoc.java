package com.rock.micro.user.pojo.doc;

import com.rock.micro.base.data.BaseDocument;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * mongo 测试实体
 *
 * @Author ayl
 * @Date 2022-03-10
 */
@Setter
@Getter
@Document(collection = "micro_user_test")
public class TestDoc extends BaseDocument {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("编号")
    private String number;

    @ApiModelProperty("值")
    private String value;

    @ApiModelProperty("类目列表")
    private List<Cat> catList;

    @Data
    public static class Cat {

        @ApiModelProperty("id")
        private String id;

        @ApiModelProperty("名称1")
        private String name;

    }

}
