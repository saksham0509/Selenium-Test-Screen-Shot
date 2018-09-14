package myframework;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class PayTMTest {
	PayTM_Home objpaytm;
	MailSend mailsend;
	ComposePage comPage;
  @Test
  public void login() throws InterruptedException {
	  objpaytm.logIn("saksham05109@gmail.com","saksham");
	  mailsend=new MailSend();
	  mailsend.logInMail("saksham0509@gmail.com","sakshamguy22").composeMail();
  }
  @BeforeClass
  public void beforeClass() {
	  objpaytm=new PayTM_Home();
	 
  }

  @AfterClass
  public void afterClass() {
  }

}
