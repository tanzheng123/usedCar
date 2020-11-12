package com.yajun.dao;

import com.yajun.domain.Orders;
import com.yajun.vo.OrdersVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface OrdersDao {

    @Insert({ "INSERT INTO orders (car_info_id, appoint_time, user_id, amount, status, order_no, pay_time, refund_time) " ,
            "VALUES (#{carInfoId}, #{appointTime, jdbcType=TIMESTAMP}, #{userId}, #{amount}, #{status}, #{orderNo}, #{payTime, jdbcType=TIMESTAMP}, #{refundTime, jdbcType=TIMESTAMP}) " })
    @Options(useGeneratedKeys = true, keyProperty = "id")
    public Long insetOrders(Orders orders);

    @Select({"<script>","SELECT cb.brand_name brandName,cm.make_name makeName,cp.purpose,cs.style_disname styleDisname,",
            "cs.style_name styleName,ci.*,orders.id orderId, orders.status orderStatus " ,
            "FROM orders orders " ,
            "LEFT JOIN car_info ci on ci.id = orders.car_info_id " ,
            "LEFT JOIN car_brand cb on cb.id = ci.brand_id " ,
            "LEFT JOIN car_make cm ON cm.id = ci.make_id " ,
            "LEFT JOIN car_purpose cp ON cp.id = ci.purpose_id " ,
            "LEFT JOIN car_style cs ON cs.id = ci.car_style_id WHERE orders.user_id = #{userId} AND ci.status = #{orderStatus}</script>"})
    public List<OrdersVo> selectOrders(Long userId, Integer orderStatus);

    @Select({"<script>SELECT * from orders WHERE car_info_id = #{carInfoId} AND user_id = #{userId} AND `status` = #{status}</script>"})
    public Orders selectOrdersByCarInfoIdAndUserId(Long carInfoId, Long userId, Integer status);

    @Select({"<script>SELECT * from orders WHERE id = #{orderId} </script>"})
    public Orders selectOrdersById(Long orderId);

    @Update({"UPDATE orders SET status=#{status} WHERE id=#{orderId} AND status != #{status}"})
    public int updateStatus(Long orderId, Integer status);

    @Update({"UPDATE orders SET status=#{status} WHERE order_no=#{orderNo} AND status != #{status}"})
    public int updateStatusByOrderNo(String orderNo, Integer status);

    @Select({"<script>","SELECT cb.brand_name brandName,cm.make_name makeName,cp.purpose,cs.style_disname styleDisname,",
            "cs.style_name styleName,ci.*,orders.id orderId, orders.status orderStatus " ,
            "FROM orders orders " ,
            "LEFT JOIN car_info ci on ci.id = orders.car_info_id " ,
            "LEFT JOIN car_brand cb on cb.id = ci.brand_id " ,
            "LEFT JOIN car_make cm ON cm.id = ci.make_id " ,
            "LEFT JOIN car_purpose cp ON cp.id = ci.purpose_id " ,
            "LEFT JOIN car_style cs ON cs.id = ci.car_style_id WHERE orders.user_id = #{userId} AND ci.status IN <foreach collection='orderStatusList' item='orderStatus' open='(' separator=',' close=')'>#{orderStatus}</foreach> </script>"})
    public List<OrdersVo> selectOrdersByStatusList(Long userId, List<Integer> orderStatusList);
}
