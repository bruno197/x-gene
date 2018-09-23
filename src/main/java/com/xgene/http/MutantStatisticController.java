package com.xgene.http;

import com.xgene.domains.Statistic;
import com.xgene.http.json.MutantStatisticResponseJson;
import com.xgene.http.json.mapper.StatisticMappers.StatisticMapper;
import com.xgene.usecases.DnaStatistic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stats")
public class MutantStatisticController {

    @Autowired
    private DnaStatistic dnaStatistic;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<MutantStatisticResponseJson> checkHumanDna() {
        final Statistic statistic = dnaStatistic.checkstats();

        final MutantStatisticResponseJson mutantStatisticResponseJson = buildMutantStatisticJson(statistic);
        return new ResponseEntity<>(mutantStatisticResponseJson, HttpStatus.OK);
    }

    private MutantStatisticResponseJson buildMutantStatisticJson(final Statistic statistic) {
        return StatisticMapper.MAPPERS.statisticToJson(statistic);
    }
}
