package com.luc.framework.core.util;

import com.sun.istack.internal.NotNull;

/** 实现了该接口的类，具备分页操作的参数 rowStart pageIndex pageSize
 * @author: lucheng
 * @data: 2021/12/10 17:49
 * @version: 1.0
 */
public interface PaginationParams {

    Integer getPageIndex();

    void setPageIndex(@NotNull Integer pageIndex);

    Integer getPageSize();

    void setPageSize(@NotNull Integer pageSize);

    default Integer getRowStart() {
        Integer pageSize = this.getPageSize();
        if(pageSize == null || pageSize == 0) {
            return 0;
        }

        Integer pageIndex = this.getPageIndex();

        if(pageIndex == null || pageIndex == 0) {
            return 0;
        }
        return (pageIndex - 1) * pageSize;

    }

}
