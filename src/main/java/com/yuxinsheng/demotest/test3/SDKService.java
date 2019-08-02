package com.yuxinsheng.demotest.test3;

import com.madhouse.performad.ads.sdk.twitter.TwitterAds;
import com.madhouse.performad.ads.sdk.twitter.api.TwitterAdsAccountApi;
import com.madhouse.performad.ads.sdk.twitter.internal.models4j.TwitterException;

public class SDKService {
    public static void main(String[] args) throws TwitterException {
        TwitterAds twitterAds = null;
        TwitterAdsAccountApi adsAccountApi = twitterAds.getAccountApi();
        adsAccountApi.getUserAccountPermissions("");
    }
}
