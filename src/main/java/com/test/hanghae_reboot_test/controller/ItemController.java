package com.test.hanghae_reboot_test.controller;

import com.test.hanghae_reboot_test.dto.response.PostItemRequest;
import com.test.hanghae_reboot_test.dto.response.PostItemResponse;
import com.test.hanghae_reboot_test.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;

    @PostMapping("/post")
    public ResponseEntity<PostItemResponse> createPost(@RequestBody PostItemRequest req){
        PostItemResponse response = itemService.create(req);
        return ResponseEntity.ok(response);
    }
}
