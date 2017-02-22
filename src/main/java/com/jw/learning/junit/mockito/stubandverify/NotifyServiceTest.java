package com.jw.learning.junit.mockito.stubandverify;
import static org.mockito.Mockito.*;
import org.junit.*;


public class NotifyServiceTest {  
    private NotifyService notifyService;  
    private UserCenter uc;  
    private MessageCenter mc;  
  
    @Before  
    public void setUp() {  
        notifyService = new NotifyService();  
        uc = mock(UserCenter.class);  
        mc = mock(MessageCenter.class);  
        notifyService.setUc(uc);  
        notifyService.setMc(mc);  
    }  
  
    @Test  
    public void testSendMessage() {  
        long userId = 1L;  
        String email = "foo@bar";  
        when(uc.getUser(userId)).thenReturn(createUserWithEmail(email));  
        notifyService.sendMessage(userId, "hello");  
        verify(mc).sendEmail(eq(email), eq("hello"));  
    }  
  
    private User createUserWithEmail(String email) {  
        User user = new User();  
        user.setEmail(email);  
        return user;  
    }  
  
}  