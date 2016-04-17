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

public class MemberService {
	MemberDAO_interface dao;

	public MemberService() {
		dao = new MemberDAO();
	}

	public MemberBean update(MemberBean bean) {
		MemberBean dbMemberBean = dao.selectMemberByMemId(bean.getMEM_ID());
		dbMemberBean.setMEM_ADD(bean.getMEM_ADD());
		dbMemberBean.setMEM_BIRTHDAY(bean.getMEM_BIRTHDAY());
		dbMemberBean.setMEM_EMAIL(bean.getMEM_EMAIL());
		dbMemberBean.setMEM_IDCARD(bean.getMEM_IDCARD());
		dbMemberBean.setMEM_NAME(bean.getMEM_NAME());
		dbMemberBean.setMEM_PHONE(bean.getMEM_PHONE());
		dao.update(dbMemberBean);
		return bean;

	}
	public MemberBean insert(MemberBean bean) {
		dao.insert(bean);
		return bean;
	}

	public MemberBean login(String account, String password) {
		List<MemberBean> list = dao.select(account);
		for (MemberBean bean : list) {
			byte[] pass = bean.getMEM_PASSWORD();
			byte[] temp = password.getBytes();
			if (Arrays.equals(pass, temp)) {
				return bean;
			}
		}
		return null;

	}
   
	
    //更改密碼
	public Boolean cheangePassword(String newPassword,Integer id){
		MemberBean memberBean=selectMemberById(id);
		if(memberBean!=null){
			memberBean.setMEM_PASSWORD(newPassword.getBytes());
            dao.update(memberBean);
            return true;
		}else{
			return false;
		}
	}
	//確認密碼是否正確
	public Boolean checkpassword(String password,Integer id){
		MemberBean memberBean=dao.selectMemberByMemId(id);
		byte[] temp=memberBean.getMEM_PASSWORD();
		String pwd=new String(temp);
		if(memberBean!=null&&password.equals(pwd)){
			return false;
		}else{
		return true;
		
	}
	
	}
	// 確認帳號是否存在
	public Boolean checkAccount(String account) {
		MemberBean memberBean = dao.selectMemberByAccount(account);
		if (memberBean != null && account.equals(memberBean.getMEM_ACCOUNT())) {
			return true;
		} else {
			return false;
		}

	}

	public List<MemberBean> selectmember() {
		return dao.selectmember();
	}

	public MemberBean selectMemberById(final Integer memId) {

		return dao.selectMemberByMemId(memId);
	}

	

	// email寄信
	public static boolean sendemail(String email, String user, String checkcode) {
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
			message.setSubject("米沃貓窩會員認證");// 主旨
			message.setText(user + "你好!您的驗證碼為" + checkcode);// 內文
			Transport.send(message);
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
		return false;
	}
}
