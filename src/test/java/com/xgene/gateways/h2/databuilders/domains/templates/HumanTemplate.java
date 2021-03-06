package com.xgene.gateways.h2.databuilders.domains.templates;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.xgene.domains.Human;

public class HumanTemplate implements TemplateLoader {
    protected static final String ANY_HUMAN = "ANY_HUMAN";
    protected static final String ANY_MUTANT = "ANY_MUTANT";

    @Override public void load() {
        Fixture.of(Human.class).addTemplate(ANY_MUTANT, new Rule() {{
            add("human_id", 1);
            add("name", random("Jean Grey", "Scott Summers", "Warren Worthington"));
            add("mutant", true);
            add("dna", new String[]{"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"});
        }});
        Fixture.of(Human.class).addTemplate(ANY_HUMAN, new Rule() {{
            add("human_id", 2);
            add("name", random("Nick", "Rob", "Jack"));
            add("mutant", false);
            add("dna", new String[]{"ATGCGA","CCGTGC","TTATAT","AGAAGG","CACCTA","TCACTG"});
        }});
    }
}
