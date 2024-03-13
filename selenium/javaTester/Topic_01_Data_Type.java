package javaTester;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;

public class Topic_01_Data_Type {
    /* Kieu dữ liệu trong Java- 2 nhóm kiểu dữ liêu
        Kiểu dữ liệu nguyên thủy (Primitive Type)
            Số nguyên: byte - short - int - long
                byte bNumber = 40;
                short sNumber = 3000;
                int iNumber = 6098776;
                long lNumber = 234567890;
            Số thực: float - double
                float fNumber = 9.99f;
                double dNumber = 35.800987d
            Kí tự: char : đại diện cho 1 kí tự, kí tự sẽ nằm trong nháy đơn
                Eg: char c ='l'
            Logic : boolean chỉ nhận 2 giá trị : true or false
                boolean status = true
                boolean status = false
        Kiểu dữ liệu tham chiếu ( Reference Type)
            String - chuỗi kí tự , sẽ nằm trong nháy đơn
                Eg: string name = "Nhu"
            Class
                Eg: FirefoxDriver firefoxDriver = new FirefoxDriver();
                Select select = new Select(firefoxDriver.findElement(By.className("")));
            Interface
                WebDriver driver;
                JavascriptExecutor jsExcutor;
            Object
                Object name = " Nhu"
            Array: mảng kiểu nguyễn thủy or tham chiếu
                int[] studentName= {15, 20, 8}
                string[] studentName = {"Nhu", "Auto"}
            Collection : List/ Set/ Queue
                List<string> studentAdress = new ArrayList<string>(); đối với arar trong quá trình chạy ko thể thêm,
            chỉnh sửa hoặc xóa element, phải khai báo số lương element ngay từ đầu
                List<string> studentCity = new LinkList<>();collection có thể thêm mới sửa xóa trực tiếp trong quá trình chạy
                List<string> studentPhone = new Vector<>();collection có thể thêm mới sửa xóa trực tiếp trong quá trình chạy
    Khai báo 1 biến để lưu trữ 1 loaui dữ liệu nào đó
        Access Modifier : Phạm vi truy cập (public/ private/ protected/ default)
        Kiểu dữ liệu
        Tên biến
        Giá trị của biến - gán vào với phép =
        Nếu như ko gán, nó sẽ có dữ liệu mặc định ( có thể =0 hoặc = null)
        Eg : public int student = 200;
     */

}
   /* icon C: class
        m: method
        i : interface
        E enum
        R: record
        A: Annotation
        F: biến final
         */
// Selenium version: 1x/ 2.x/ 3.x/ 4.x
// 8 loai locator
// Selenium Locator = HTML attribue
//Id/Class/Name/ = Trung vs 3 attribue cua HTML
// LinkText/Partial LinkText: HTML Link (the a)
//TagName:HTML Tagname
// Css/ Xpath

/* Selenium version 4.x( dung test gioa dien nguoi dung -GUI ( graphic user interface),Co them
 *Class- Relative
 *above/ bellow/near/ leftof/ rightof
 *UI testing : FUI: function UI
 */
//TestNG: Order testcase theo alphabet ( 0-9, a-z)
/* tìm element với Css
driver.findElement(By.cssSelector("input/div/span[id/class/name ='FirtName'")
tìm element với Xpath
driver.findElement(By.xpath(xpathExpression"//input/div/span[@id/class/name ='FirtName'")
 */