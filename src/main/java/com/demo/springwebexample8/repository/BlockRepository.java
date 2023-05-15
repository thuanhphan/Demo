package com.demo.springwebexample8.repository;

import com.demo.springwebexample8.model.Block;
import com.demo.springwebexample8.model.Subscription;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlockRepository extends ReactiveCrudRepository<Block, Integer> {

}
