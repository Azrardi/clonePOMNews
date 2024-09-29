package playwright.isqa.LearningTestNG;

import org.testng.annotations.Test;

/*
* Parameter In TensNG
* --------------------------------
* How to Defince the priority?
* Can we pass negatice values to priority
* Whats happen when same priority is provided to multiple
* --------------------------------
* FlighgtBookingTests
* 1. Signup
* 2.Login
* 3.SearchForTheFlight
* 4. BookTheFlight
* 5. SaveTheTicket
* 6.LogOut
* */


public class PrioritizeTestWithTestNG {

    @Test(priority = 1, description = "Test Description For Signup")
    public static void SignUp(){
        System.out.println("signUp");

    }
    @Test(priority = 2, description = "Test Description For Login")
    public static void Login(){
        System.out.println("login");

    }
    @Test (priority = 3, description = "Test Description For SearchForTheFlight")
    public static void SearchForTheFlight(){
        System.out.println("searchFortheFlight");

    }
    @Test (priority = 4, description = "Test Description For BookTheFlight")
    public static void BookTheFlight(){
        System.out.println("BookTheFlight");

    }
    @Test (priority = 5, description = "Test Description For SaveTheTicket")
    public static void SaveTheTicket(){
        System.out.println("SaveTheTicket");

    }
    @Test (priority = 6, description = "Test Description For LogOut")
    public static void LogOut(){
        System.out.println("LogOut");

    }
}
