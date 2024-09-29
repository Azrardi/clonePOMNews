package playwright.isqa.LearningTestNG.GroupTest;

/*
* SMOKE -TC 10
* Functional tests - 90
* Regression tests - 95
* Daily Build - 40
* Weekly Build - 100
* Windows/ IOS - OS Base CAT - 50
* Smoketests.xml
* */

import org.testng.annotations.Test;

public class NewTest1 {
    @Test(priority = 1, description = "Test Description For Signup", groups = {"Smoke"})
    public static void SignUp(){
        System.out.println("signUp");

    }
    @Test(priority = 2, description = "Test Description For Login",groups = {"Smoke","functional"})
    public static void Login(){
        System.out.println("login");

    }
    @Test (priority = 3, description = "Test Description For SearchForTheFlight",groups = {"functional"})
    public static void SearchForTheFlight(){
        System.out.println("searchFortheFlight");

    }
    @Test (priority = 4, description = "Test Description For BookTheFlight",groups = {"regression"})
    public static void BookTheFlight(){
        System.out.println("BookTheFlight");

    }
    @Test (priority = 5, description = "Test Description For SaveTheTicket",groups = {"functional"})
    public static void SaveTheTicket(){
        System.out.println("SaveTheTicket");

    }
    @Test (priority = 6, description = "Test Description For LogOut", groups = {"Smoke"})
    public static void LogOut(){
        System.out.println("LogOut");

    }
}
