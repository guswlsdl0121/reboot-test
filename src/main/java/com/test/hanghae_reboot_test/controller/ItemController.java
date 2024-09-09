package com.test.hanghae_reboot_test.controller;

import com.test.hanghae_reboot_test.dto.response.GetItemResponse;
import com.test.hanghae_reboot_test.dto.response.PostItemRequest;
import com.test.hanghae_reboot_test.dto.response.PostItemResponse;
import com.test.hanghae_reboot_test.service.ItemService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class ItemController {
    private final ItemService itemService;

    @PostMapping()
    public ResponseEntity<PostItemResponse> createPost(@RequestBody PostItemRequest req){
        PostItemResponse response = itemService.create(req);
        return ResponseEntity.ok(response);
    }

    @GetMapping("")
    public ResponseEntity<List<GetItemResponse>> getAllPosts() {
        List<GetItemResponse> response = itemService.getAll();
        return ResponseEntity.ok(response);
    }
}

