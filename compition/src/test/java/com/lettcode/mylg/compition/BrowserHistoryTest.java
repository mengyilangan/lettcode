package com.lettcode.mylg.compition;

import org.junit.jupiter.api.Test;

class BrowserHistoryTest {
    @Test
    void testVisit() {
        BrowserHistory browserHistory = new BrowserHistory("leetcode.com");
        browserHistory.visit("google.com");       // 你原本在浏览 "leetcode.com" 。访问 "google.com"
        browserHistory.visit("facebook.com");     // 你原本在浏览 "google.com" 。访问 "facebook.com"
        browserHistory.visit("youtube.com");      // 你原本在浏览 "facebook.com" 。访问 "youtube.com"
        System.out.println(browserHistory.back(1));                   // 你原本在浏览 "youtube.com" ，后退到 "facebook.com" 并返回 "facebook.com"
        System.out.println(browserHistory.back(1));                   // 你原本在浏览 "facebook.com" ，后退到 "google.com" 并返回 "google.com"
        System.out.println(browserHistory.forward(1));                // 你原本在浏览 "google.com" ，前进到 "facebook.com" 并返回 "facebook.com"
        browserHistory.visit("linkedin.com");     // 你原本在浏览 "facebook.com" 。 访问 "linkedin.com"
        System.out.println(browserHistory.forward(2));                // 你原本在浏览 "linkedin.com" ，你无法前进任何步数。
        System.out.println(browserHistory.back(2));                   // 你原本在浏览 "linkedin.com" ，后退两步依次先到 "facebook.com" ，然后到 "google.com" ，并返回 "google.com"
        System.out.println(browserHistory.back(7));                   // 你原本在浏览 "google.com"， 你只能后退一步到 "leetcode.com" ，并返回 "leetcode.com"
    }
}
