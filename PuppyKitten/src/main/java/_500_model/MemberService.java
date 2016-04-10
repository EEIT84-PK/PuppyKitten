package _500_model;

import java.util.Arrays;
import java.util.List;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.struts2.components.Bean;

public class MemberService {
	MemberDAO_interface dao;
	
	public MemberService(){
		dao= new MemberDAO();
	}
	
	public MemberBean insert(MemberBean bean){
		dao.insert(bean);
		return bean;
	}
	
	public MemberBean login(String account,String password){
		List<MemberBean> list=dao.select(account);
		for(MemberBean bean:list){		
			byte[] pass=bean.getMEM_PASSWORD();
			byte[] temp=password.getBytes();
			if(Arrays.equals(pass, temp)){
				return bean;	
			}
		}
		return null;
		
	}
	
	
	public static boolean sendemail(String email,String user,String checkcode) {
		String to = email;
		String from = "PuppyKitten84@gmail.com";
		final String username = "PuppyKitten84@gmail.com";
		final String password = "PK123456789";
		String host = "smtp.gmail.com";
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "587");
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			message.setSubject("米沃貓窩會員認證");//主旨
			message.setText(user+"你好!您的驗證碼為"+checkcode);//內文
			Transport.send(message);
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
		return false;
	}
}
	
		  
		
	

