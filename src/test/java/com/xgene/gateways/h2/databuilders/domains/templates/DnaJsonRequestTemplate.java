package com.xgene.gateways.h2.databuilders.domains.templates;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.xgene.http.json.DnaJsonRequest;

public class DnaJsonRequestTemplate implements TemplateLoader {
    protected static final String ANY_REQUEST = "ANY_REQUEST";

    @Override public void load() {
        Fixture.of(DnaJsonRequest.class).addTemplate(ANY_REQUEST, new Rule() {{
            add("dna", new String[]{"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"});
        }});
    }
}
