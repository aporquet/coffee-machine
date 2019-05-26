package use_case;

import common.DrinkType;
import common.ReportDto;
import model.Command;
import model.MoneyManager;
import model.Sender;

import java.util.List;

public class OrderPicker {

    private DrinkType drinkType;
    private int numberOfSugar;
    private boolean isHot;
    private double customerMoney;
    private double cashCount;
    private ReportRepository reportRepository;
    private double totalCash;
    private int sales;
    private BeverageQuantityCheckerRepository beverageQuantityCheckerRepository;
    private EmailNotifierRepository emailNotifierRepository;


    public OrderPicker(DrinkType drinkType, int numberOfSugar, boolean isHot, double customerMoney, ReportRepository reportRepository){
        this.drinkType = drinkType;
        this.numberOfSugar = numberOfSugar;
        this.isHot = isHot;
        this.customerMoney = customerMoney;
        this.reportRepository = reportRepository;
    }

    public void validOrder(DrinkType drinkType, int numberOfSugar, boolean isHot){
        Command command = new Command(drinkType, numberOfSugar, isHot);
        MoneyManager moneyManager = new MoneyManager(customerMoney);
        moneyManager.checkCommand(command);
        if (moneyManager.isValidCommand()){
            cashCount += command.getDrinkType().getDrinkPrice();
        }
        if(beverageQuantityCheckerRepository.isEmpty(command.getDrinkType().getDrinkName()) == true){
            emailNotifierRepository.notifyMissingDrink(command.getDrinkType().getDrinkName());
            Sender sender = new Sender(command, moneyManager);
            sender.messageLackOfDrink(command);
        }else{
            Sender sender = new Sender(command, moneyManager);
            sender.messageCommandValidation(command, moneyManager);
            ReportDto reportDto = new ReportDto(cashCount);
            reportRepository.save(reportDto);
        }
    }

    public List<ReportDto> getTotalReports(){
        List<ReportDto> reportDtoList = reportRepository.getReports();
        return reportDtoList;
    }

    public void printReports(List<ReportDto> reportDtoList){
        if (reportDtoList.size() > 0){
            for (ReportDto reportDto : reportDtoList){
                totalCash += reportDto.getCashCount();
            }
            sales = reportDtoList.size();
            System.out.println("Earnings : "+totalCash);
            System.out.println("Commands :"+sales);
        }else{
            throw new AnyReportsFoundException();
        }
    }

    public double getCashCount(){
        return cashCount;
    }

    public double getTotalCash() {
        return totalCash;
    }

    public double getSales() {
        return sales;
    }
}
