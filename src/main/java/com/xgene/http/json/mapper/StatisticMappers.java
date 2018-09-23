package com.xgene.http.json.mapper;

import com.xgene.domains.Statistic;
import com.xgene.http.json.MutantStatisticResponseJson;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StatisticMappers {
    MutantStatisticResponseJson statisticToJson(Statistic statistic);

    enum StatisticMapper {
        ;

        public static final StatisticMappers MAPPERS = Mappers.getMapper(StatisticMappers.class);
    }
}
