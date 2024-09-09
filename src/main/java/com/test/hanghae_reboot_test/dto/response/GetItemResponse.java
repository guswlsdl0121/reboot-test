package com.test.hanghae_reboot_test.dto.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class GetItemResponse {
    private final Long id;
    private final String title;
    private final String username;
    private final int price;
}
