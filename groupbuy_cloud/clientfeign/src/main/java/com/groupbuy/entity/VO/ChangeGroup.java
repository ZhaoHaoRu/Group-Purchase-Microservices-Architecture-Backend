package com.groupbuy.entity.VO;

import lombok.Data;

import java.util.List;

@Data
public class ChangeGroup {

    private Integer groupId;

    private String groupTitle;

    private String groupInfo;

    private String category;

    private String startTime;

    private Integer duration;

    private List<ChangeGoods> goods;
}
