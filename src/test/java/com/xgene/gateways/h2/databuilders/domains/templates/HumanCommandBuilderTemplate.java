package com.xgene.gateways.h2.databuilders.domains.templates;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.xgene.http.builder.HumanCommandBuilder;

public class HumanCommandBuilderTemplate implements TemplateLoader {
    protected static final String ANY_HUMAN_BUILDER = "ANY_HUMAN_BUILDER";

    @Override public void load() {
        Fixture.of(HumanCommandBuilder.class).addTemplate(ANY_HUMAN_BUILDER, new Rule() {{
            add("human_id", 1);
            add("name", random("Jean Grey", "Scott Summers", "Warren Worthington"));
            add("mutant", true);
        }});
    }
}
