package use_case;

import common.DrinkType;
import common.ReportDto;
import model.Command;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class OrderPickerShould {

    private DrinkType drinkType;
    private OrderPicker orderPicker;
    private int numberOfSugar;
    private boolean isHot;
    private ReportRepository reportRepository;
    private BeverageQuantityCheckerRepository beverageQuantityCheckerRepository;


    @Before
    public void init(){
        drinkType = DrinkType.Coffee;
        numberOfSugar = 0;
        isHot = false;
        double customerMoney = 10;
        reportRepository = mock(ReportRepository.class);
        orderPicker = new OrderPicker(drinkType, numberOfSugar, isHot, customerMoney, reportRepository);
    }

    @Test
    public void update_cash_count__if_command_is_valid(){
        orderPicker.validOrder(drinkType, numberOfSugar, isHot);
        Assert.assertTrue(orderPicker.getCashCount() == drinkType.getDrinkPrice());
    }

    @Test
    public void call_save_report_method(){
        orderPicker.validOrder(drinkType, numberOfSugar, isHot);
        verify(reportRepository).save(Mockito.any(ReportDto.class));
    }

    @Test
    public void call_get_reports_method(){
        orderPicker.getTotalReports();
        verify(reportRepository).getReports();
    }

    @Test
            (expected = AnyReportsFoundException.class)
    public void not_get_reports_if_reports_was_not_stored() {
        List<ReportDto> reportDtoList = orderPicker.getTotalReports();
        orderPicker.printReports(reportDtoList);
    }

    @Test
    public void get_reports_if_reports_was_stored_to_print_them() {
        ReportDto reportDto1 = new ReportDto(0.6);
        ReportDto reportDto2 = new ReportDto(0.9);
        List<ReportDto> reportDtoList = orderPicker.getTotalReports();
        reportDtoList.add(reportDto1);
        reportDtoList.add(reportDto2);
        orderPicker.printReports(reportDtoList);
        Assert.assertTrue(orderPicker.getTotalCash() == 1.5);
        Assert.assertTrue(orderPicker.getSales() ==2);
    }

    @Test
    public void send_notification_if_beverage_quantity_is_not_valid(){
        orderPicker.validOrder(drinkType, numberOfSugar, isHot);
        Command command = new Command(DrinkType.OrangeJuice, 0, false);
        verify(beverageQuantityCheckerRepository).isEmpty(command.getDrinkType().getDrinkName());
    }
}
