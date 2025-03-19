package com.rock.micro.user.serivce.impl;

import com.rock.micro.base.db.mongo.BaseMongoServiceImpl;
import com.rock.micro.user.pojo.doc.TestDoc;
import com.rock.micro.user.serivce.TestMongoService;
import org.springframework.stereotype.Service;

@Service
public class TestMongoServiceImpl extends BaseMongoServiceImpl<TestDoc> implements TestMongoService {

}