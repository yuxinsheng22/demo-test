package com.yuxinsheng.demotest.test.test1;

import java.util.Arrays;
import java.util.List;

/**
 * @author yuxinsheng
 * @date 2018/10/31 15:18
 */
public enum CampaignStatus {


    ACTIVE(1), PAUSED(2), ARCHIVED(3), DELETED(4), UNKNOWN(5), DRAFT(6), PUBLISHING(7), PUBLISHING_AND_PAUSED(8), PUBLISH_FAILED(9);
//    @JsonCreator
//    public static AdCampaignDto.CampaignStatus fromValue(String value) {
//        for (CampaignStatus status : CampaignStatus.values()) {
//            if (status.name().equals(value)) {
//                return status;
//            }
//        }
//        return UNKNOWN;
//    }

    private int index;

    CampaignStatus(int index) {
        this.index = index;
    }

    public static CampaignStatus fromIndex(int index) {
        for (CampaignStatus status : CampaignStatus.values()) {
            if (status.index == index) {
                return status;
            }
        }
        return UNKNOWN;
    }

    public static List<Integer> reportStatuses() {
        return Arrays.asList(CampaignStatus.ACTIVE.ordinal(), CampaignStatus.PAUSED.ordinal()/*, CampaignStatus.DRAFT.ordinal()
					, CampaignStatus.PUBLISHING.ordinal(), CampaignStatus.PUBLISHING_AND_PAUSED.ordinal()
					, CampaignStatus.PUBLISH_FAILED.ordinal()*/);
    }

    public static List<Integer> overviewStatuses() {
        return Arrays.asList(CampaignStatus.ACTIVE.ordinal(), CampaignStatus.PAUSED.ordinal(), CampaignStatus.DRAFT.ordinal()
                , CampaignStatus.PUBLISHING.ordinal(), CampaignStatus.PUBLISHING_AND_PAUSED.ordinal()
                , CampaignStatus.PUBLISH_FAILED.ordinal());
    }

    public static void main(String[] args) {
        System.out.println(CampaignStatus.fromIndex(1));
    }
}
