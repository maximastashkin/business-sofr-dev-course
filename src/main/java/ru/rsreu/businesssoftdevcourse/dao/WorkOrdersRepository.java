package ru.rsreu.businesssoftdevcourse.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.rsreu.businesssoftdevcourse.model.WorkOrder;

@Repository
public interface WorkOrdersRepository extends JpaRepository<WorkOrder, Long> {
}
