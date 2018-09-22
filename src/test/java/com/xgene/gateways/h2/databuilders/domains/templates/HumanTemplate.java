package com.xgene.gateways.h2.databuilders.domains.templates;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.xgene.domains.Human;

public class HumanTemplate implements TemplateLoader {
    protected static final String ANY_HUMAN = "ANY_HUMAN";

    @Override public void load() {
        Fixture.of(Human.class).addTemplate(ANY_HUMAN, new Rule() {{
            add("human_id", 1);
            add("name", random("Jean Grey", "Scott Summers", "Warren Worthington"));
            add("mutant", true);
        }});
    }
}
