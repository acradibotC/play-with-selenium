/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package org.acradibotc.selenium.unicat;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 *
 * @author Anhnt206
 */
public class UnicatLearningTest {

    public UnicatLearningTest() {
    }
    private static WebDriver myBrowser; //biến con trỏ trỏ vào trình duyệt
    
    @BeforeAll
    public static void setUpClass() {
        System.setProperty("webdriver.chrome.driver", "E:\\selenium-2-go\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        myBrowser = new ChromeDriver(options);
        myBrowser.manage().window().maximize();
    }

//    @Test
//    public void checkRegisterValidAccountGoToLessonDetailByHomePage() throws InterruptedException {
//        String FullName = "Nguyen Hao Nam";
//        String username = "newaccount@test";
//        String password = "random123";
//        String Gmail = "newaccount@gmail.com";
//        String Phone = "0988123456";
//        String DOB = "20-20-2020";
//        String Address = "Hoa Lac Hi-tech Park";
//
//        //Access the home page
//        myBrowser.get("https://unicat.azurewebsites.net/");
//        //Click on "Login"
//        myBrowser.findElement(By.cssSelector("a[href='/user/login']")).click();
//        myBrowser.findElement(By.cssSelector(".text-reset")).click();
//
//        WebElement txtFullName = myBrowser.findElement(By.name("txtFullName"));
//        txtFullName.sendKeys(FullName);
//        WebElement txtUserName = myBrowser.findElement(By.name("txtUserName"));
//        txtUserName.sendKeys(username);
//        WebElement txtGmail = myBrowser.findElement(By.name("txtGmail"));
//        txtGmail.sendKeys(Gmail);
//        WebElement txtPhone = myBrowser.findElement(By.name("txtPhone"));
//        txtPhone.sendKeys(Phone);
//        WebElement txtDob = myBrowser.findElement(By.name("txtDob"));
//        txtDob.sendKeys(DOB);
//        WebElement txtAddress = myBrowser.findElement(By.name("txtAddress"));
//        txtAddress.sendKeys(Address);
//        WebElement txtPassword = myBrowser.findElement(By.name("txtPassWord"));
//        txtPassword.sendKeys(password);
//        WebElement txtRePassword = myBrowser.findElement(By.name("txtRePass"));
//        txtRePassword.sendKeys(password);
//        myBrowser.findElement(By.xpath("//input[@id='login']")).click();
//        Thread.sleep(2000);
//        //Login with user's account
//        txtUserName = myBrowser.findElement(By.xpath("//input[@id='email']"));
//        txtUserName.sendKeys(username);
//        txtPassword = myBrowser.findElement(By.xpath("//input[@id='password']"));
//        txtPassword.sendKeys(password);
//        WebElement btnLogin = myBrowser.findElement(By.xpath("//input[@id='login']"));
//        btnLogin.click();
//
//        //Verify that the user is redirected to Homepage
//        String pageURL = myBrowser.getCurrentUrl();
//        assertEquals("https://unicat.azurewebsites.net/home", pageURL);
//
//        //Click on “Course”
//        WebElement btnCourse = myBrowser.findElement(By.xpath("//ul[@class='main_nav']//a[normalize-space()='Courses']"));
//        btnCourse.click();
//
//        //Verify that the user can view list of courses
//        WebElement lblPage = myBrowser.findElement(By.cssSelector("div[class='home'] li:nth-child(2)"));
//        assertEquals("Courses", lblPage.getText());
//
//        //Select course from the list of course
//        WebElement btnCourseName = myBrowser.findElement(By.cssSelector("a[href='/course?CourseID=2']"));
//        btnCourseName.click();
//
//        //Verify that the course details are displayed
//        lblPage = myBrowser.findElement(By.cssSelector("div[class='home'] li:nth-child(3)"));
//        assertEquals("Course Details", lblPage.getText());
//
//        WebElement btnEnroll = myBrowser.findElement(By.xpath("//button[normalize-space()='Enroll Now']"));
//        btnEnroll.click();
//
//        //Click on "Go to Course" to access the course materials
//        WebElement btnGoToCourse = myBrowser.findElement(By.xpath("//button[@name='courseId']"));
//        btnGoToCourse.click();
//
//        //Verify that the user is redirected to the course page and can access the course materials.
//        pageURL = myBrowser.getCurrentUrl();
//        assertEquals("https://unicat.azurewebsites.net/LessonDetail", pageURL);
//
//        myBrowser.findElement(By.cssSelector(".col-md-9")).click();
//        Thread.sleep(10000);
//        WebElement btnLogOut = myBrowser.findElement(By.xpath("//a[normalize-space()='Log Out']"));
//        btnLogOut.click();
//        pageURL = myBrowser.getCurrentUrl();
//        assertEquals("https://unicat.azurewebsites.net/home", pageURL);
//        Thread.sleep(5000);
//    }

    @Test
    public void checkAccessEnrolledCourseThroughCourseCatalog() throws InterruptedException {

        String username = "linh@test";
        String password = "020601";

        //Access the home page
        myBrowser.get("https://unicat.azurewebsites.net/");
        //Click on "Login"
        myBrowser.findElement(By.cssSelector("a[href='/user/login']")).click();

        //Login with user's account
        WebElement txtUserName = myBrowser.findElement(By.xpath("//input[@id='email']"));
        txtUserName.sendKeys(username);
        WebElement txtPassword = myBrowser.findElement(By.xpath("//input[@id='password']"));
        txtPassword.sendKeys(password);
        WebElement btnLogin = myBrowser.findElement(By.xpath("//input[@id='login']"));
        btnLogin.click();

        //Verify that the user is redirected to Homepage
        String pageURL = myBrowser.getCurrentUrl();
        assertEquals("https://unicat.azurewebsites.net/home", pageURL);

        //Click on “Course”
        WebElement btnCourse = myBrowser.findElement(By.xpath("//ul[@class='main_nav']//a[normalize-space()='Courses']"));
        btnCourse.click();

        //Verify that the user can view list of courses
        WebElement lblPage = myBrowser.findElement(By.cssSelector("div[class='home'] li:nth-child(2)"));
        assertEquals("Courses", lblPage.getText());

        //Select course from the list of course
        WebElement btnCourseName = myBrowser.findElement(By.xpath("//a[normalize-space()='JavaScript Notebook']"));
        btnCourseName.click();

        //Verify that the course details are displayed
        lblPage = myBrowser.findElement(By.cssSelector("div[class='home'] li:nth-child(3)"));
        assertEquals("Course Details", lblPage.getText());

        //Click on "Go to Course" to access the course materials
        WebElement btnGoToCourse = myBrowser.findElement(By.cssSelector("button[value='1']"));
        btnGoToCourse.click();

        //Verify that the user is redirected to the course page and can access the course materials.
        pageURL = myBrowser.getCurrentUrl();
        assertEquals("https://unicat.azurewebsites.net/LessonDetail", pageURL);

        myBrowser.findElement(By.cssSelector(".col-md-9")).click();
        Thread.sleep(10000);
        WebElement btnLogOut = myBrowser.findElement(By.xpath("//a[normalize-space()='Log Out']"));
        btnLogOut.click();
        pageURL = myBrowser.getCurrentUrl();
        assertEquals("https://unicat.azurewebsites.net/home", pageURL);
        Thread.sleep(5000);
    }

    @Test
    public void checkAccessEnrolledCourseThroughUserProfilePage() throws InterruptedException {
        String username = "linh@test";
        String password = "020601";
        //Access the home page
        myBrowser.get("https://unicat.azurewebsites.net/");
        //Click on "Login"
        myBrowser.findElement(By.cssSelector("a[href='/user/login']")).click();

        //Login with user's account
        WebElement txtUserName = myBrowser.findElement(By.xpath("//input[@id='email']"));
        txtUserName.sendKeys(username);
        WebElement txtPassword = myBrowser.findElement(By.xpath("//input[@id='password']"));
        txtPassword.sendKeys(password);
        WebElement btnLogin = myBrowser.findElement(By.xpath("//input[@id='login']"));
        btnLogin.click();

        //Verify that the user is redirected to Homepage
        String pageURL = myBrowser.getCurrentUrl();
        assertEquals("https://unicat.azurewebsites.net/home", pageURL);

        Thread.sleep(2000);
        WebElement btnProfile = myBrowser.findElement(By.cssSelector("a[href='/userprofile?p=profile']"));
        btnProfile.click();

        //Verify that the user is redirected to their profile page.
        WebElement lblPage = myBrowser.findElement(By.cssSelector("div[class='breadcrumbs_container'] li:nth-child(2)"));
        assertEquals("User Profile", lblPage.getText());

        //Verify that the user can view their list of enrolled courses.
        WebElement lblMyCourse = myBrowser.findElement(By.xpath("//div[normalize-space()='My Course']"));
        assertEquals("My Course", lblMyCourse.getText());

        WebElement btnCourseName = myBrowser.findElement(By.xpath("//button[@value='2']"));
        btnCourseName.click();

        //Verify that the user is redirected to the course page and can access the course materials.
        pageURL = myBrowser.getCurrentUrl();
        assertEquals("https://unicat.azurewebsites.net/LessonDetail", pageURL);

        myBrowser.findElement(By.cssSelector(".col-md-9")).click();
        Thread.sleep(10000);
        WebElement btnLogOut = myBrowser.findElement(By.xpath("//a[normalize-space()='Log Out']"));
        btnLogOut.click();
        pageURL = myBrowser.getCurrentUrl();
        assertEquals("https://unicat.azurewebsites.net/home", pageURL);
        Thread.sleep(5000);
    }

    @Test
    public void checkAccessAdminAccount() throws InterruptedException {
        String username = "anhnt";
        String password = "123";
        //Access the home page
        myBrowser.get("https://unicat.azurewebsites.net/");
        //Click on "Login"
        myBrowser.findElement(By.cssSelector("a[href='/user/login']")).click();

        //Login with user's account
        WebElement txtUserName = myBrowser.findElement(By.xpath("//input[@id='email']"));
        txtUserName.sendKeys(username);
        WebElement txtPassword = myBrowser.findElement(By.xpath("//input[@id='password']"));
        txtPassword.sendKeys(password);
        WebElement btnLogin = myBrowser.findElement(By.xpath("//input[@id='login']"));
        btnLogin.click();

        //Verify that the user is redirected to Homepage
        String pageURL = myBrowser.getCurrentUrl();
        assertEquals("https://unicat.azurewebsites.net/home", pageURL);

        Thread.sleep(2000);
        WebElement btnProfile = myBrowser.findElement(By.cssSelector("a[href='/admin/manager/course']"));
        btnProfile.click();

        //Verify that the user is redirected to the admin manager page and can’t access the course materials.
        pageURL = myBrowser.getCurrentUrl();
        assertEquals("https://unicat.azurewebsites.net/admin/manager/course", pageURL);

        WebElement btnLogOut = myBrowser.findElement(By.xpath("//a[normalize-space()='Log Out']"));
        btnLogOut.click();
        pageURL = myBrowser.getCurrentUrl();
        assertEquals("https://unicat.azurewebsites.net/home", pageURL);
        Thread.sleep(5000);
    }

    @AfterAll
    public static void tearDownClass() {
        myBrowser.quit();
    }

}
