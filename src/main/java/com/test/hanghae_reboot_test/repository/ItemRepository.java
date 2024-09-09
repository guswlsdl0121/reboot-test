package com.test.hanghae_reboot_test.repository;

import com.test.hanghae_reboot_test.entity.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Long> {
}
