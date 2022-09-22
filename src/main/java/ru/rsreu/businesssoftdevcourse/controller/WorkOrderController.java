package ru.rsreu.businesssoftdevcourse.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.rsreu.businesssoftdevcourse.model.BreakdownType;
import ru.rsreu.businesssoftdevcourse.model.WorkOrder;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/work_order")
public class WorkOrderController {
    @ModelAttribute("breakdownTypes")
    public List<BreakdownType> bindBreakDownTypes() {
        return Arrays.asList(BreakdownType.values());
    }

    @GetMapping
    public String getOrderForm(Model model) {
        model.addAttribute("workOrder", new WorkOrder());
        return "work_order";
    }

    @PostMapping
    public String processOrder(@Valid @ModelAttribute WorkOrder workOrder, Errors errors) {
        if (errors.hasErrors()) {
            return "work_order";
        }
        return "redirect:/";
    }
}
