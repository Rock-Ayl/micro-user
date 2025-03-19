package com.rock.micro.user.db;

import com.rock.micro.base.db.elasticsearch.BaseElasticSearchService;
import com.rock.micro.user.pojo.index.TestIndex;
import com.rock.micro.user.serivce.TestElasticSearchService;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.aggregations.AbstractAggregationBuilder;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class TestElasticSearch {

    @Autowired
    private TestElasticSearchService testElasticSearchService;

    @Test
    void create() {
        //初始化
        TestIndex testIndex = new TestIndex();
        testIndex.setExt("xlsx");
        testIndex.setMd5("vasdhwqojoi");
        testIndex.setName("测试文件2.xlsxxx");
        testIndex.setSize(1900000L);
        //创建
        testElasticSearchService.create(testIndex);
        System.out.println();
    }

    @Test
    void search() {
        //单个查询
        TestIndex one = testElasticSearchService.get(TestIndex.class, "fcca086604d64ea8a6365abc1ebaeb30");
        //批量查询
        List<TestIndex> list = testElasticSearchService.list(TestIndex.class, Arrays.asList("fcca086604d64ea8a6365abc1ebaeb30", "ad48a5967f574b94b4e38b06a60b908e", "1f59707c22d84fe2acffdab8b6870279"));
        System.out.println(12321312);
    }

    @Test
    void rollPage() {
        //布尔查询
        BoolQueryBuilder query = QueryBuilders.boolQuery();
        //聚合搜索
        AbstractAggregationBuilder abstractAggregationBuilder = AggregationBuilders.terms("md5Count").field("md5.keyword");
        //查询
        BaseElasticSearchService.RollPageResult<TestIndex> rollPageResult = testElasticSearchService.rollPage(TestIndex.class, query, abstractAggregationBuilder, null, null);
        System.out.println();
    }

    @Test
    void delete() {
        //删除
        testElasticSearchService.delete(TestIndex.class, "1f59707c22d84fe2acffdab8b6870279");
        System.out.println(123);
    }

    @Test
    void update() {
        //初始化
        TestIndex testIndex = new TestIndex();
        testIndex.setId("ac7eb80e513b4e4c9ad196c9e687862c");
        testIndex.setExt("");
        testIndex.setMd5("cvdsqwd");
        testIndex.setName("测试文件2-comjoisa1xvn.word");
        testIndex.setSize(41239999L);
        //更新
        testElasticSearchService.updateSkipNull(testIndex);
    }

    @Test
    void batchUpdate() {
        //初始化
        TestIndex fileIndex = new TestIndex();
        fileIndex.setId("ac7eb80e513b4e4c9ad196c9e687862c");
        fileIndex.setExt("");
        fileIndex.setMd5("cvdsqwd");
        fileIndex.setName("批量更新1-comjoisa1xvn.word");
        fileIndex.setSize(41239999L);

        //初始化
        TestIndex fileIndex2 = new TestIndex();
        fileIndex2.setId("b138d267485f475f8d0c2290198cf5c9");
        fileIndex2.setExt("vasj1");
        fileIndex2.setMd5("cvdsqwd");
        fileIndex2.setName("批量更新2-comjoisa1xvn.word");
        fileIndex2.setSize(4992319L);

        List<TestIndex> list = new ArrayList<>();
        list.add(fileIndex);
        list.add(fileIndex2);

        //更新
        testElasticSearchService.batchUpdateSkipNull(list);
    }

}
