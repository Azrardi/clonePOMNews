package playwright.isqa.LearningTestNG.GroupTest;

import org.testng.annotations.Test;

public class newTest2 {
    @Test(priority = 1, description = "Test Description For CheckUpdate", groups = {"Smoke", "regression"})
    public static void CheckUpdate(){
        System.out.println("Check Update");

    }
    @Test(priority = 2, description = "Test Description For CheckStatus",groups = {"regression"})
    public static void CheckStatus(){
        System.out.println("Check Status");

    }
    @Test (priority = 3, description = "Test Description For CheckName", groups = {"functional"})
    public static void CheckName(){
        System.out.println("Check Name");

    }
    @Test (priority = 4, description = "Test Description For Chech Email", groups = {"functional","Smoke"})
    public static void CheckEmail() {
        System.out.println("Check Email");
    }
}
