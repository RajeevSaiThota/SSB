package com.sslweb.automation.mail;

import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.log4j.Logger;

import com.sslweb.automation.consts.ShoppersStopConstantsWeb;
import com.sslweb.automation.dto.mail.Attachment;
import com.sslweb.automation.dto.mail.MailParam;
import com.sslweb.automation.dto.mail.MailParam.MailConfig;
import com.sslweb.automation.dto.pdfreport.SuitesResult;
import com.sslweb.automation.registry.Registry;
import com.sslweb.automation.registry.RegistryKey;
import com.sslweb.automation.util.PathProvider;

/**
 * 
 * @author sairam.p
 *
 */
public class DefaultMailService {
	
	private MailParam mailParam;
	private MailConfig config;
	private SuitesResult suitesResult;
	private DefaultMailServiceHelper helper;
	
	private static final Logger LOG =Logger.getLogger(DefaultMailService.class.getName());
	
	public DefaultMailService() {
		helper = new DefaultMailServiceHelper();
	}
	
	private void sendMail() {
		if (helper.isMandateDataAvailable(mailParam, suitesResult)) {
			Session session = Session.getDefaultInstance(helper.getMailProperties(config));
			MimeMessage message = new MimeMessage(session);
			try {
				message.setFrom(config.getFrom());
				message.addRecipients(Message.RecipientType.TO, config.getTo());
				message.setSubject(mailParam.getSubject());
				Multipart multipart = new MimeMultipart();
				helper.setBodyText(multipart, suitesResult);
				helper.attachBodyParts(multipart, mailParam.getAttachments());
				message.setContent(multipart);
				Transport transport = session.getTransport(ShoppersStopConstantsWeb.SMTP);
				transport.connect(config.getHost(), config.getFrom().toString(),
						config.getPasscode());
				transport.sendMessage(message, message.getAllRecipients());
				transport.close();
				LOG.info("Mail Sent.");
			} catch (AddressException e) {
				LOG.error("Error occurred with an email addresses supplied are not valid or not active", e);
			} catch (MessagingException e) {
				LOG.error("Error occurred while sending an mail.", e);
			} catch (Exception e) {
				LOG.error("Unknown error occurred while sending email.",e);
			}
		}else {
			LOG.warn("Mail cannot be sent due to lack of mandatory data/permissions. Validation of "+mailParam+" and "+suitesResult+" failed and results in non transporatable mail.");
		}
	}
	
	public DefaultMailService build(){
		new MailContentPreparer().prepare();
		return this;
	}

	private void injectData(MailParam mailParam, SuitesResult suiteResult){
		this.mailParam = Objects.requireNonNull(mailParam,"MailParam cannot be null");
		this.suitesResult = Objects.requireNonNull(suiteResult, "SuitesResult cannot be null");
		this.config = Objects.requireNonNull(mailParam.getMailConfig(),"Mail Config cannot be null");
	}

	public void transport(){
		injectData((MailParam)Registry.getAttribute(RegistryKey.MAIL_PARAM), (SuitesResult)Registry.getAttribute(RegistryKey.TEST_SUITES_RESULT));
		sendMail();
	}
	
	private static class MailContentPreparer {
		
		private static final Logger LOG = Logger.getLogger(MailContentPreparer.class.getName());
		
		public MailParam prepare(){
			LOG.debug("Prearing mail content.");
			Object obj = Registry.getAttribute(RegistryKey.MAIL_PARAM);
			MailParam mailParam = (Objects.nonNull(obj)) ? ((MailParam)obj) : new MailParam();
			mailParam.setAttachments(getAttachments());
			Registry.setAttribute(RegistryKey.MAIL_PARAM, mailParam);
			return mailParam;
		}

		private List<Attachment> getAttachments(){
			Object obj = Registry.getAttribute(RegistryKey.PDF_REPORT_FILE_PATH);
			Path path = (Objects.nonNull(obj)) ? ((Path)obj) : PathProvider.getGenPDFReportFilePath((String)Registry.getAttribute(RegistryKey.DIR_TIMESTAMP_SUFFIX));
			return Arrays.asList(new Attachment(path,path.getFileName()));
		}
		
	}
	
}