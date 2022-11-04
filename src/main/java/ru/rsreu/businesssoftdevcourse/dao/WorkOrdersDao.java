package ru.rsreu.businesssoftdevcourse.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ru.rsreu.businesssoftdevcourse.model.WorkOrder;

@Repository
public interface WorkOrdersDao extends MongoRepository<WorkOrder, String> {
}
