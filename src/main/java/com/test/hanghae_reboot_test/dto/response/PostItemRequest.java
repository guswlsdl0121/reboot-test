package com.test.hanghae_reboot_test.dto.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class PostItemRequest {
    private String username;
    private String title;
    private String content;
    private int price;
}
