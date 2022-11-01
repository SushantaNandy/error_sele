package webdriver_new;

import java.awt.AWTException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;

import org.bouncycastle.util.Properties;
import org.bouncycastle.util.Store;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class venu_app {
	WebDriver wb;
	public String URL="https://demoapp.skillrary.com/index.php";

	@BeforeTest()
	public void testcase() {
		WebDriverManager.chromedriver().setup();
		wb=new ChromeDriver();
		wb.get(URL);
		
//		//String OutlookMailReader(String mailFolderName,String emailSubjectContent, String emailContent, int lengthOfOTP)
//		{
//
//            
//			//mailFolderName(Eg- "INBOX"), emailSubjectContent(Eg- Mail for OTP),
//			//emailContent(Eg- OTP is 111111), OTP length(Eg- 6)
//			            String hostName = "smtp-mail.outlook.com";//change it according to your mail
//
//			            String username = "****@***.com";//username 
//
//			            String password = "*******";
//
//			            int messageCount;
//
//			            int unreadMsgCount;
//
//			            String emailSubject;
//
//			            Message emailMessage;
//
//			            String searchText=null ;
//
//			            Properties sysProps = System.getProperties();
//
//			            sysProps.setProperty("mail.store.protocol", "imaps");
//
//			            try {
//
//			                Session session = Session.getInstance(sysProps, null);
//
//			                Store store = session.getStore();
//
//			                store.connect(hostName, username, password);
//
//			                Folder emailBox = store.getFolder(mailFolderName);
//
//			                emailBox.open(Folder.READ_WRITE);
//
//			                messageCount = emailBox.getMessageCount();
//
//			                System.out.println("Total Message Count: " + messageCount);
//
//			                unreadMsgCount = emailBox.getNewMessageCount();
//
//			                System.out.println("Unread Emails count:" + unreadMsgCount);
//
//			                for(int i=messageCount; i>(messageCount-unreadMsgCount); i--)
//
//			                {
//
//			                    emailMessage = emailBox.getMessage(i);
//
//			                    emailSubject = emailMessage.getSubject();
//
//			                    if(emailSubject.contains(emailSubjectContent))
//
//			                    {
//
//			                        System.out.println("OTP mail found");
//
//			                        String line;
//
//			                        StringBuffer buffer = new StringBuffer();
//
//			                        BufferedReader reader = new BufferedReader(new InputStreamReader(emailMessage.getInputStream()));
//
//			                        while ((line = reader.readLine()) != null) {
//
//			                            buffer.append(line);
//
//			                        }
//
//			                        String messageContent=emailContent;
//
//			                        String result = buffer.toString().substring(buffer.toString().indexOf(messageContent));
//
//			                        searchText = result.substring(messageContent.length(), messageContent.length()+lengthOfOTP);
//
//			                        System.out.println("Text found : "+ searchText);
//
//			                        emailMessage.setFlag(Flags.Flag.SEEN, true);
//
//			                        break;
//
//			                    }
//
//			                    emailMessage.setFlag(Flags.Flag.SEEN, true);
//
//			                }
//
//			                emailBox.close(true);
//
//			                //store.close();
//
//
//			            } catch (Exception mex) {
//
//			                mex.printStackTrace();
//
//			                System.out.println("OTP Not found ");
//
//			            }
//
//			            return searchText;
//
//			        }
//		
//		
//		   
//		
//	
}
	}

// if we want to get number of dropdown after mouse-over
//// getting the list of options in the dropdown with getOptions()
//List <WebElement> op = s.getOptions();
//int size = op.size();
























