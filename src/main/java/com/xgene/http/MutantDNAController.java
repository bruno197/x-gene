package com.xgene.http;

import com.xgene.domains.Human;
import com.xgene.http.builder.HumanCommandBuilder;
import com.xgene.http.json.DnaJsonRequest;
import com.xgene.usecases.CreateHuman;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/mutant")
public class MutantDNAController {

    @Autowired
    private CreateHuman createHuman;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @Validated
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity checkHumanDna(
            @RequestBody @Valid final DnaJsonRequest request) {
        Human human = createHuman.create(HumanCommandBuilder.fromRequest(request));
        if(human.isMutant()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }
}
