package com.rock.micro.user.pojo.index;

import com.rock.micro.base.data.BaseIndex;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * ES测试实体
 *
 * @Author ayl
 * @Date 2022-03-09
 */
@Getter
@Setter
@Document(indexName = "micro_user_test")
public class TestIndex extends BaseIndex {

    private static final long serialVersionUID = 1L;

    @Field(type = FieldType.Text, searchAnalyzer = "ik_max_word", analyzer = "ik_max_word")
    @ApiModelProperty("文件名称")
    private String name;

    @Field(type = FieldType.Keyword)
    @ApiModelProperty("文件后缀")
    private String ext;

    @Field(type = FieldType.Keyword)
    @ApiModelProperty("文件MD5")
    private String md5;

    @Field(type = FieldType.Long)
    @ApiModelProperty("文件大小")
    private Long size;

}
