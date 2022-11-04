package ru.rsreu.businesssoftdevcourse.dao;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;
import ru.rsreu.businesssoftdevcourse.model.WorkOrder;

@Repository
public interface WorkOrdersDao extends CassandraRepository<WorkOrder, String> {
}
