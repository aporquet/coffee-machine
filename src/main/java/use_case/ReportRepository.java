package use_case;

import common.ReportDto;

import java.util.List;

//This repository can be implemented to support many persistences types
//Can also be printed

public interface ReportRepository {

    void save(ReportDto reportDto);

    List<ReportDto> getReports();
}
