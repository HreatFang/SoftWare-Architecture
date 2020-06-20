package org.csu.mypetstore.persistence;

import org.csu.mypetstore.domain.LineItem;
import java.util.List;

public interface LineItemMapper {
    // 根据订单ID得到订单中的商品项
    List<LineItem> getLineItemsByOrderId(int orderId);

    // 插入商品项
    boolean insertLineItem(LineItem lineItem);
}
