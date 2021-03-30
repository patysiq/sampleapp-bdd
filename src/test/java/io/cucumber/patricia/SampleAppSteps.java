package io.cucumber.patricia;

import static org.junit.jupiter.api.Assertions.*;

import io.cucumber.java.pt.*;

import io.cucumber.patricia.services.Settings;

public class SampleAppSteps {

        @Dado("que eu estou no site da SampleApp")
        public void que_eu_estou_no_site_da_SampleApp() {
            Settings.openBrowser("http://sampleapp.tricentis.com/101/app.php");
        }

        @Dado("preencho o formulário Enter Vehicle Data")
        public void preencho_o_formulário_Enter_Vehicle_Data(){
            Settings.cssSelector("select#make option:nth-of-type(2)").click();
            Settings.cssSelector("select#model option:nth-of-type(2)").click();
            //negative test
            Settings.id("cylindercapacity").sendKeys("40000");
            assertEquals("Must be a number between 1 and 2000", Settings.cssSelectors(".error").get(2).getText());
            Settings.id("cylindercapacity").clear();
            Settings.id("cylindercapacity").sendKeys("10");
            //negative test
            Settings.id("engineperformance").sendKeys("40000");
            assertEquals("Must be a number between 1 and 2000", Settings.cssSelectors(".error").get(3).getText());
            Settings.id("engineperformance").clear();
            Settings.id("engineperformance").sendKeys("10");
            //negative test
            Settings.id("dateofmanufacture").sendKeys("10/10/2040");
            assertEquals("Must be today or somewhere in the past", Settings.cssSelectors(".error").get(4).getText());
            Settings.id("dateofmanufacture").clear();
            Settings.id("dateofmanufacture").sendKeys("10/10/2000");
            Settings.cssSelector("select#numberofseats option:nth-of-type(2)").click();
            Settings.cssSelector("select#numberofseatsmotorcycle option:nth-of-type(2)").click();
            Settings.cssSelector("select#fuel option:nth-of-type(2)").click();
            //negative test
            Settings.id("payload").sendKeys("20000");
            assertEquals("Must be a number between 1 and 1000", Settings.cssSelectors(".error").get(8).getText());
            Settings.id("payload").clear(); 
            Settings.id("payload").sendKeys("10"); 
            //negative test
            Settings.id("totalweight").sendKeys("58000");
            assertEquals("Must be a number between 100 and 50000", Settings.cssSelectors(".error").get(9).getText());
            Settings.id("totalweight").clear();
            Settings.id("totalweight").sendKeys("100");
            //negative test
            Settings.id("listprice").sendKeys("1000000");
            assertEquals("Must be a number between 500 and 100000", Settings.cssSelectors(".error").get(10).getText());
            Settings.id("listprice").clear();
            Settings.id("listprice").sendKeys("1000");
            //negative test
            Settings.id("annualmileage").sendKeys("8");
            assertEquals("Must be a number between 100 and 100000", Settings.cssSelectors(".error").get(12).getText());
            Settings.id("annualmileage").clear();
            Settings.id("annualmileage").sendKeys("1000");
        }

        @Dado("preencho o formulário, aba Enter Insurant Data")
        public void preencho_o_formulário_aba_Enter_Insurant_Data() {
            //negative test with characters short
            Settings.id("firstname").sendKeys("a");
            assertEquals("Must be at least 2 characters long and must only contain letters", Settings.cssSelectors(".error").get(13).getText());
            Settings.id("firstname").clear();
            //negative test with numbers
            Settings.id("firstname").sendKeys("3");
            assertEquals("Must be at least 2 characters long and must only contain letters", Settings.cssSelectors(".error").get(13).getText());
            Settings.id("firstname").clear();
            Settings.id("firstname").sendKeys("Tester");
            Settings.id("lastname").sendKeys("Life");
            Settings.id("birthdate").sendKeys("10/10/2000");
            Settings.cssSelector("select#country option:nth-of-type(2)").click();
            Settings.id("zipcode").sendKeys("60000000");
            Settings.id("city").sendKeys("Fortaleza");
            Settings.cssSelector("select#occupation option:nth-of-type(2)").click();
            Settings.cssSelectors(".ideal-check").get(0).click();
        }

        @Dado("preencho o formulário, aba Enter Product Data")
        public void preencho_o_formulário_aba_Enter_Product_Data()throws InterruptedException {
            Settings.id("startdate").sendKeys("10/10/2022");
            Settings.cssSelector("select#insurancesum option:nth-of-type(2)").click();
            Settings.cssSelector("select#meritrating option:nth-of-type(2)").click();
            Settings.cssSelector("select#damageinsurance option:nth-of-type(2)").click();
            Settings.cssSelectors(".ideal-check").get(6).click();
            Settings.cssSelector("select#courtesycar option:nth-of-type(2)").click();
            Thread.sleep(2000);
        }

        @Dado("preencho o formulário, aba Select Price Option")
        public void preencho_o_formulário_aba_Select_Price_Option() {
            Settings.cssSelectors(".ideal-radio").get(4).click();
        }

        @Dado("preencho o formulário, aba Send Quote")
        public void preencho_o_formulário_aba_Send_Quote() {
            Settings.id("email").sendKeys("test@gmail.com");
            Settings.id("username").sendKeys("testename");
            Settings.id("password").sendKeys("Testepassword0");
            Settings.id("confirmpassword").sendKeys("Testepassword0");
        }
        
        @Dado("clico em Send")
        public void clico_em_Send() {
            Settings.id("sendemail").click();
        }

        @Entao("verifico a mensagem {string}")
        public void verifico_a_mensagem(String string) throws InterruptedException{
            Thread.sleep(10000);
            assertEquals(string, Settings.cssSelectors("h2").get(0).getText());
        }

    
}
