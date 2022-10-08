package ru.rsreu.businesssoftdevcourse.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.rsreu.businesssoftdevcourse.model.BreakdownType;
import ru.rsreu.businesssoftdevcourse.model.WorkOrder;

import java.util.HashMap;
import java.util.Map;

@Repository
public class WorkOrdersDaoImpl implements WorkOrdersDao {
    private final SimpleJdbcInsert workOrdersSimpleJdbcInsert;
    private final SimpleJdbcInsert orderBreakDownsSimpleJdbcInsert;

    @Autowired
    public WorkOrdersDaoImpl(
            @Qualifier("workOrdersSimpleJdbcInsert") SimpleJdbcInsert workOrdersSimpleJdbcInsert,
            @Qualifier("orderBreakDownsSimpleJdbcInsert") SimpleJdbcInsert orderBreakDownsSimpleJdbcInsert) {
        this.workOrdersSimpleJdbcInsert = workOrdersSimpleJdbcInsert;
        this.orderBreakDownsSimpleJdbcInsert = orderBreakDownsSimpleJdbcInsert;
    }

    @Override
    @Transactional
    public void save(WorkOrder order) {
        Number orderId = workOrdersSimpleJdbcInsert.execute(formParamsForWorkOrderInsertion(order));
        order.getBreakdowns().forEach(it ->
                orderBreakDownsSimpleJdbcInsert.execute(formParamsForOrder(orderId, it))
        );
    }

    private Map<String, Object> formParamsForWorkOrderInsertion(WorkOrder order) {
        Map<String, Object> result = new HashMap<>();
        result.put("car_manufacturer", order.getCarManufacturer());
        result.put("car_model", order.getCarModel());
        result.put("manufacturing_year", order.getManufacturingYear());
        result.put("client_name", order.getName());
        result.put("cc_number", order.getCcNumber());
        result.put("cc_expiration", order.getCcExpiration());
        result.put("cc_CVV", order.getCcCVV());
        return result;
    }

    private Map<String, Object> formParamsForOrder(Number orderId, BreakdownType type) {
        Map<String, Object> result = new HashMap<>();
        result.put("order_id", orderId);
        result.put("breakdown_type", type.toString());
        return result;
    }
}
