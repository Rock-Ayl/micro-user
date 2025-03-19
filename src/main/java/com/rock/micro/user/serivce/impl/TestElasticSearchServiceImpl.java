package com.rock.micro.user.serivce.impl;

import com.rock.micro.base.db.elasticsearch.BaseElasticSearchServiceImpl;
import com.rock.micro.user.pojo.index.TestIndex;
import com.rock.micro.user.serivce.TestElasticSearchService;
import org.springframework.stereotype.Service;

@Service
public class TestElasticSearchServiceImpl extends BaseElasticSearchServiceImpl<TestIndex> implements TestElasticSearchService {

}