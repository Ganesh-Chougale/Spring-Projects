package com.verligence.PLISM.Repository;

import com.verligence.PLISM.Entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {

}