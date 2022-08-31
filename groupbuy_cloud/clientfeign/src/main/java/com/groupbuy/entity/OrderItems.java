package com.groupbuy.entity;
import com.groupbuy.config.Comment;
import javax.persistence.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "order_item")
@Comment("订单详情信息表")
@ApiModel("订单详情信息")
public class OrderItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_item_id")
    @Comment("订单详情主键")
    @ApiModelProperty(value = "订单详情主键")
    private Integer orderItemId;

    //商品ID
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "goods_id")
    @Comment("商品ID")
    @ApiModelProperty(value = "商品ID")
    private Goods good;

    //商品数量
    @Basic
    @Column(name = "goods_number")
    @Comment("商品数量")
    @ApiModelProperty(value = "商品数量")
    private Integer goodsNumber;


    //与订单的关系
    @ManyToOne
    @JoinColumn(name = "order_id")
    @Comment("所属订单")
    @ApiModelProperty(value = "所属订单")
    private Orders orders;
}
