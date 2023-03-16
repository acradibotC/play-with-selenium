/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package org.acradibotc.selenium.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 *
 * @author Anhnt206
 */
public class Selenium2Demo {

    private static WebDriver myBrowser; //biến con trỏ trỏ vào trình duyệt

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Please wait 3s to lauch the browser...");
        Thread.sleep(3000);
        String url = introduction("linh@test","020601");
        System.out.println(url);
    }

    public static String introduction(String username, String password) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--lang=en-GB");
        options.addArguments("--incognito");
//
//        String username = "linh@test";
//        String password = "020601";

        myBrowser = new ChromeDriver(options);
        myBrowser.manage().window().maximize();

        myBrowser.get("https://unicat.azurewebsites.net/Welcome.jsp");
//        Thread.sleep(5000);

        myBrowser.findElement(By.cssSelector("a[href='/user/login']")).click();

        //Login with user's account
        WebElement txtUserName = myBrowser.findElement(By.xpath("//input[@id='email']"));
        txtUserName.sendKeys(username);
        WebElement txtPassword = myBrowser.findElement(By.xpath("//input[@id='password']"));
        txtPassword.sendKeys(password);
//        Thread.sleep(1000);
        WebElement btnLogin = myBrowser.findElement(By.xpath("//input[@id='login']"));
        btnLogin.click();
//        Thread.sleep(1000);

        String currentUrl = myBrowser.getCurrentUrl();
//        //Click on “Course”
//        WebElement btnCourse = myBrowser.findElement(By.xpath("//ul[@class='main_nav']//a[normalize-space()='Courses']"));
//        btnCourse.click();
//
//        //Select course from the list of course
//        WebElement btnCourseName = myBrowser.findElement(By.cssSelector("a[href='/course?CourseID=2']"));
//        btnCourseName.click();
//
//        //Click on "Go to Course" to access the course materials
//        WebElement btnGoToCourse = myBrowser.findElement(By.xpath("//button[@name='courseId']"));
//        btnGoToCourse.click();
//        Thread.sleep(1000);
//
//        //Verify that the user is redirected to the course page and can access the course materials.
//        myBrowser.findElement(By.cssSelector(".col-md-9")).click();
//        Thread.sleep(10000);
//
//        //Log out
//        WebElement btnLogOut = myBrowser.findElement(By.xpath("//a[normalize-space()='Log Out']"));
//        btnLogOut.click();

        //wait to close browser
//        Thread.sleep(5000);
        myBrowser.quit();
        return currentUrl;
    }

    public static void playWithGoogleSearch() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("--remote-allow-origins=*");
        opt.addArguments("--lang=en-GB");
        opt.addArguments("--incognito");

        myBrowser = new ChromeDriver(opt);
        myBrowser.manage().window().maximize();

        myBrowser.get("https://google.com");
        //định vị, đi tìm cái ô search, để nhập keyword CA SĨ MẶT NẠ
        //myBrowser hiện nắm giữ toàn bộ các tag của trang web
        //Google.com đã đc tải về máy mình
        //Các trình duyệt khi đc phát triê người ta đã tính sẵn
        //gọi là các kĩ thuật định vị thẻ - nôm na: câu query để
        //select ra đc 1 cái tag
        // có các loại query sau trong 1 trình duyệt bất kì:
        // query theo id, name, css selector, xPath
        // xPath siêu cool, luôn tìm ra dc 1 tag bất kì trong đống
        // tag lồng nhau của <html><body><div><div>

        //myBrowser sẽ nắm giữ các tag của trang web đc tải về
        //nó cũng hỗ trợ các câu query để tìm tag
        //nó cũng hỗ trợ việc can thiệp vào hoạt động của từng tag
        //click trên tag, input data vào tag...
        //Mỗi tag được xem là 1 object thuộc class webelement
//        WebElement searchBox = myBrowser.findElement(By.name("q"));
        WebElement searchBox = myBrowser.findElement(By.xpath("//input[@title='Search']"));

        searchBox.sendKeys("CA SĨ MẶT NẠ");
        searchBox.submit();

        Thread.sleep(5000);
        myBrowser.quit();
    }

}
