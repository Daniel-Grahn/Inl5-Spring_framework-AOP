package se.yrgo.services.calls;

import java.util.Collection;

import se.yrgo.domain.*;
import se.yrgo.services.customers.*;
import se.yrgo.services.diary.DiaryManagementService;

public class CallHandlingServiceImpl implements CallHandlingService{

    private CustomerManagementService customerService;
    private DiaryManagementService diaryService;

    public CallHandlingServiceImpl(CustomerManagementService customerService, DiaryManagementService diaryService) {
        this.customerService = customerService;
        this.diaryService = diaryService;
    }

    @Override
    public void recordCall(String customerId, Call newCall, Collection<Action> actions) throws CustomerNotFoundException {
        customerService.recordCall(customerId, newCall);
        for(Action action : actions){
            diaryService.recordAction(action);
        }
    }    
}
