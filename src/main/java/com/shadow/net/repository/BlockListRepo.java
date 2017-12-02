package com.shadow.net.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.shadow.net.model.BlockList;

public interface BlockListRepo extends MongoRepository<BlockList, String> {

    @Override
    List<BlockList> findAll();

    @Override
    BlockList findOne(String sourceIP);

}
