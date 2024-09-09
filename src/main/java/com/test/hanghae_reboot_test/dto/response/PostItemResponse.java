package com.test.hanghae_reboot_test.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PostItemResponse {
    private Long id;
    private String username;
    private String title;
    private String content;
    private int price;
}
