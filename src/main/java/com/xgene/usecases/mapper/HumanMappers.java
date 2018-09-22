package com.xgene.usecases.mapper;

import com.xgene.domains.Human;
import com.xgene.http.builder.HumanCommandBuilder;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
@FunctionalInterface
public interface HumanMappers {
    Human humanCommandBuilderToHuman(HumanCommandBuilder humanCommandBuilder);

    enum HumanMapper {
        ;
        public static final HumanMappers MAPPER = Mappers.getMapper(HumanMappers.class);
    }
}
