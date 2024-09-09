package com.test.hanghae_reboot_test.service;

import com.test.hanghae_reboot_test.dto.response.GetItemResponse;
import com.test.hanghae_reboot_test.dto.response.PostItemRequest;
import com.test.hanghae_reboot_test.dto.response.PostItemResponse;
import com.test.hanghae_reboot_test.entity.Item;
import com.test.hanghae_reboot_test.repository.ItemRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
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

    public List<GetItemResponse> getAll() {
        Iterable<Item> items = itemRepository.findAll();
        return StreamSupport.stream(items.spliterator(), false)
                .map(item -> new GetItemResponse(
                        item.getId(),
                        item.getTitle(),
                        item.getUsername(),
                        item.getPrice()
                ))
                .collect(Collectors.toList());
    }

    public PostItemResponse update(Long id, PostItemRequest req) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("해당 id의 Item을 찾을 수 없습니다 (id : " + id + ")"));

        Item updatedItem = Item.builder()
                .id(item.getId())
                .username(req.getUsername())
                .title(req.getTitle())
                .content(req.getContent())
                .price(req.getPrice())
                .build();

        Item savedItem = itemRepository.save(updatedItem);

        return new PostItemResponse(
                savedItem.getId(),
                savedItem.getUsername(),
                savedItem.getTitle(),
                savedItem.getContent(),
                savedItem.getPrice()
        );
    }

    public void delete(Long id) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("해당 id의 Item을 찾을 수 없습니다 (id : " + id + ")"));

        itemRepository.delete(item);
    }
}

