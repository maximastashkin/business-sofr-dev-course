package ru.rsreu.businesssoftdevcourse.dao;

import org.springframework.stereotype.Repository;
import ru.rsreu.businesssoftdevcourse.model.WorkOrder;

public interface WorkOrdersDao {
    void save(WorkOrder order);
}
