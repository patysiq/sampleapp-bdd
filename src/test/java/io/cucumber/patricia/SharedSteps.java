package io.cucumber.patricia;

import io.cucumber.java.pt.*;

import io.cucumber.patricia.services.Settings;

public class SharedSteps {

    @Dado("preencho o formulário, aba {string}")
    public void preencho_o_formulário_aba(String string) {
        Settings.cssSelector("a[name='"+string+"']").click();  
    }

    @Dado("clico em next {int}")
    public void clico_em_next(Integer int1) {
        Settings.cssSelectors("button[class='next']").get(int1).click();
    }
    
    @Dado("clico em next button")
    public void clico_em_next_button() {
        Settings.cssSelector("button[class='next button']").click();
    }

    // @Dado("clico em next para Quote")
    // public void clico_em_next_para_Quote() {
    //     Settings.cssSelectors(".next").get(3).click();
    // }
}
