package com.test.hanghae_reboot_test.service;

import com.test.hanghae_reboot_test.dto.response.PostItemRequest;
import com.test.hanghae_reboot_test.dto.response.PostItemResponse;
import com.test.hanghae_reboot_test.entity.Item;
import com.test.hanghae_reboot_test.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    public PostItemResponse create(PostItemRequest req) {
        Item item = Item.builder()
                .username(req.getUsername())
                .title(req.getTitle())
                .content(req.getContent())
                .price(req.getPrice())
                .build();

        Item savedItem = itemRepository.save(item);

        return new PostItemResponse(
                savedItem.getId(),
                savedItem.getUsername(),
                savedItem.getTitle(),
                savedItem.getContent(),
                savedItem.getPrice()
        );
    }
}
