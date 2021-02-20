package com.bng.zbp.controller;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.text.Document;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class Mailer {
	@Autowired
	@Value("{$smtpServer}")
	private String smtpServer;
	private final static Logger logger = LoggerFactory.getLogger(Mailer.class);
	Properties emailProperties;
	Session mailSession;
	private void setMailServerProperties() {
		String emailPort = "587";
		emailProperties = System.getProperties();
		emailProperties.put("mail.smtp.port", emailPort);
		emailProperties.put("mail.smtp.auth", "true");
		emailProperties.put("mail.smtp.starttls.enable", "true");
	}
	private MimeMessage createEmailMessage(String emailSubject,String to,String emailBody) throws AddressException, MessagingException {
		String[] toEmails = { to };
		mailSession = Session.getDefaultInstance(emailProperties, null);
		MimeMessage emailMessage = new MimeMessage(mailSession);
		for (int i = 0; i < toEmails.length; i++) {
			emailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmails[i]));
		}
		emailMessage.setSubject(emailSubject);
		emailMessage.setContent(emailBody, "text/html");
		return emailMessage;
	}
	private void sendEmail(MimeMessage emailMessage) throws AddressException, MessagingException {
		String emailHost = "smtp.gmail.com";
		String fromUser = "reach@blackngreen.com";
		String fromUserEmailPassword = "reach123";
		Transport transport = mailSession.getTransport("smtp");
		transport.connect(emailHost, fromUser, fromUserEmailPassword);
		transport.sendMessage(emailMessage, emailMessage.getAllRecipients());
		transport.close();
		System.out.println("Email sent successfully.");
	}
	public  String sendEmail(String from, String to,String subject,String url,String name,String template) {
		Mailer javaEmail = new Mailer();
		String  content="<table class='m_5003591963639980197wrapper-table' cellpadding='5' cellspacing='0' width='100%' border='0' style='border-collapse:collapse;color:#444;font-family:&quot;Segoe UI&quot;,Segoe,&quot;Avenir Next&quot;,&quot;Open Sans&quot;,sans-serif;font-size:14px;line-height:1.5;background-color:#eee;background-repeat:no-repeat' bgcolor='#eeeeee'>\n" + 
				"   <tbody>\n" + 
				"      <tr style='border-color:transparent'>\n" + 
				"         <td align='center' style='border-collapse:collapse;border-color:transparent'>\n" + 
				"            <table cellpadding='0' cellspacing='0' width='600px' id='m_5003591963639980197bodyTable' border='0' bgcolor='#ffffff' style='border-collapse:collapse;color:#444;font-family:&quot;Segoe UI&quot;,Segoe,&quot;Avenir Next&quot;,&quot;Open Sans&quot;,sans-serif;font-size:14px;line-height:1.5'>\n" + 
				"               <tbody>\n" + 
				"                  <tr style='border-color:transparent'>\n" + 
				"                     <td border='0' cellpadding='0' cellspacing='0' style='border-collapse:collapse;border-color:transparent'>\n" + 
				"                        <table cellpadding='0' cellspacing='0' style='border-collapse:collapse;color:#444;font-family:&quot;Segoe UI&quot;,Segoe,&quot;Avenir Next&quot;,&quot;Open Sans&quot;,sans-serif;font-size:14px;line-height:1.5;width:100%' border='0' width='100%'>\n" + 
				"                           <tbody>\n" + 
				"                              <tr style='border-color:transparent'>\n" + 
				"                                 <th width='600' style='border-color:transparent;font-weight:400;text-align:left;vertical-align:top' cellpadding='0' cellspacing='0' class='m_5003591963639980197tc' align='left' valign='top'>\n" + 
				"                                    <table border='0' width='100%' cellpadding='0' cellspacing='0' style='border-collapse:collapse;color:#444;font-family:&quot;Segoe UI&quot;,Segoe,&quot;Avenir Next&quot;,&quot;Open Sans&quot;,sans-serif;font-size:14px;line-height:1.5;background-color:#fff' bgcolor='#ffffff'>\n" + 
				"                                       <tbody>\n" + 
				"                                          <tr style='border-color:transparent'>\n" + 
				"                                             <td cellpadding='0' cellspacing='0' style='border-collapse:collapse;border-color:transparent'>\n" + 
				"                                                <table width='100%' cellpadding='0' cellspacing='0' style='border-collapse:collapse;color:#444;font-family:&quot;Segoe UI&quot;,Segoe,&quot;Avenir Next&quot;,&quot;Open Sans&quot;,sans-serif;font-size:14px;line-height:1.5;background-color:#fff' bgcolor='#ffffff'>\n" + 
				"                                                   <tbody>\n" + 
				"                                                      <tr style='border-color:transparent'>\n" + 
				"                                                         <td class='m_5003591963639980197expander' colspan='1' width='100%' height='0' style='border-collapse:collapse;border-color:transparent'></td>\n" + 
				"                                                      </tr>\n" + 
				"                                                      <tr class='m_5003591963639980197content-row' style='border-color:transparent'>\n" + 
				"                                                         <td class='m_5003591963639980197content-cell' width='600' style='border-collapse:collapse;border-color:transparent;vertical-align:top' valign='top'>\n" + 
				"                                                            <div style='color:#444;font-family:&quot;Segoe UI&quot;,Segoe,&quot;Avenir Next&quot;,&quot;Open Sans&quot;,sans-serif;font-size:14px;line-height:1.5;display:block;height:300;width:100%' height='300' width='100%'><img border='0' width='600' height='auto' class='m_5003591963639980197sp-img CToWUd' align='left' alt='Would you like to make a profit from your web push subscribers?' src='http://52.36.94.173/reach/first.png' style='text-decoration:none;border:0;height:auto;line-height:100%;outline:0;margin:0;display:block'></div>\n" + 
				"                                                         </td>\n" + 
				"                                                      </tr>\n" + 
				"                                                      <tr style='border-color:transparent'>\n" + 
				"                                                         <td class='m_5003591963639980197expander' colspan='1' width='100%' height='0' style='border-collapse:collapse;border-color:transparent'></td>\n" + 
				"                                                      </tr>\n" + 
				"                                                   </tbody>\n" + 
				"                                                </table>\n" + 
				"                                             </td>\n" + 
				"                                          </tr>\n" + 
				"                                       </tbody>\n" + 
				"                                    </table>\n" + 
				"                                 </th>\n" + 
				"                              </tr>\n" + 
				"                           </tbody>\n" + 
				"                        </table>\n" + 
				"                     </td>\n" + 
				"                  </tr>\n" + 
				"                  <tr style='border-color:transparent'>\n" + 
				"                     <td border='0' cellpadding='0' cellspacing='0' style='border-collapse:collapse;border-color:transparent'>\n" + 
				"                        <table cellpadding='0' cellspacing='0' style='border-collapse:collapse;color:#444;font-family:&quot;Segoe UI&quot;,Segoe,&quot;Avenir Next&quot;,&quot;Open Sans&quot;,sans-serif;font-size:14px;line-height:1.5;width:100%' border='0' width='100%'>\n" + 
				"                           <tbody>\n" + 
				"                              <tr style='border-color:transparent'>\n" + 
				"                                 <th width='600' style='border-color:transparent;font-weight:400;text-align:left;vertical-align:top' cellpadding='0' cellspacing='0' class='m_5003591963639980197tc' align='left' valign='top'>\n" + 
				"                                    <table border='0' width='100%' cellpadding='0' cellspacing='0' style='border-collapse:collapse;color:#444;font-family:&quot;Segoe UI&quot;,Segoe,&quot;Avenir Next&quot;,&quot;Open Sans&quot;,sans-serif;font-size:14px;line-height:1.5;background-color:#fff' bgcolor='#ffffff'>\n" + 
				"                                       <tbody>\n" + 
				"                                          <tr style='border-color:transparent'>\n" + 
				"                                             <td cellpadding='0' cellspacing='0' style='border-collapse:collapse;border-color:transparent'>\n" + 
				"                                                <table width='100%' cellpadding='0' cellspacing='0' id='m_5003591963639980197w' style='border-collapse:collapse;color:#333;font-family:&quot;Segoe UI&quot;,Segoe,&quot;Avenir Next&quot;,&quot;Open Sans&quot;,sans-serif;font-size:14px;line-height:1.5;font-weight:normal;margin:0'>\n" + 
				"                                                   <tbody>\n" + 
				"                                                      <tr style='border-color:transparent'>\n" + 
				"                                                         <td class='m_5003591963639980197expander' colspan='3' width='100%' height='30' style='border-collapse:collapse;border-color:transparent'></td>\n" + 
				"                                                      </tr>\n" + 
				"                                                      <tr class='m_5003591963639980197content-row' style='border-color:transparent'>\n" + 
				"                                                         <td class='m_5003591963639980197gutter' style='border-collapse:collapse;border-color:transparent;width:30px!important' width='30' height='100%'></td>\n" + 
				"                                                         <td class='m_5003591963639980197content-cell' width='540' style='border-collapse:collapse;border-color:transparent;vertical-align:top' valign='top'>\n" + 
				"                                                            <p style='font-size:inherit;line-height:inherit;margin:0 0 10px;color:#333;font-family:&quot;Segoe UI&quot;,Segoe,&quot;Avenir Next&quot;,&quot;Open Sans&quot;,sans-serif;font-weight:normal;padding:0'><span style='font-size:16px'><strong>Hey </strong>"+name+"</span></p>\n" + 
				"                                                            <p style='font-size:inherit;line-height:inherit;margin:0 0 10px;color:#333;font-family:&quot;Segoe UI&quot;,Segoe,&quot;Avenir Next&quot;,&quot;Open Sans&quot;,sans-serif;font-weight:normal;padding:0'><span style='font-weight:400;font-size:16px'>We would like to see  <span class='il'>you</span> take the full advantage of our portal. To do so as a genuine user, please validate yourself for the below points</span></p>\n" + 
				"                                                         </td>\n" + 
				"                                                         <td class='m_5003591963639980197gutter' style='border-collapse:collapse;border-color:transparent;width:30px!important' width='30' height='100%'></td>\n" + 
				"                                                      </tr>\n" + 
				"                                                      <tr style='border-color:transparent'>\n" + 
				"                                                         <td class='m_5003591963639980197expander' colspan='3' width='100%' height='10' style='border-collapse:collapse;border-color:transparent'></td>\n" + 
				"                                                      </tr>\n" + 
				"                                                   </tbody>\n" + 
				"                                                </table>\n" + 
				"                                             </td>\n" + 
				"                                          </tr>\n" + 
				"                                       </tbody>\n" + 
				"                                    </table>\n" + 
				"                                 </th>\n" + 
				"                              </tr>\n" + 
				"                           </tbody>\n" + 
				"                        </table>\n" + 
				"                     </td>\n" + 
				"                  </tr>\n" + 
				"                  <tr style='border-color:transparent'>\n" + 
				"                     <td border='0' cellpadding='0' cellspacing='0' style='border-collapse:collapse;border-color:transparent'>\n" + 
				"                        <table cellpadding='0' cellspacing='0' style='border-collapse:collapse;color:#444;font-family:&quot;Segoe UI&quot;,Segoe,&quot;Avenir Next&quot;,&quot;Open Sans&quot;,sans-serif;font-size:14px;line-height:1.5;width:100%' border='0' width='100%'>\n" + 
				"                           <tbody>\n" + 
				"                              <tr style='border-color:transparent'>\n" + 
				"                                 <th width='600' style='border-color:transparent;font-weight:400;text-align:left;vertical-align:top' cellpadding='0' cellspacing='0' class='m_5003591963639980197tc' align='left' valign='top'>\n" + 
				"                                    <table border='0' width='100%' cellpadding='0' cellspacing='0' style='border-collapse:collapse;color:#444;font-family:&quot;Segoe UI&quot;,Segoe,&quot;Avenir Next&quot;,&quot;Open Sans&quot;,sans-serif;font-size:14px;line-height:1.5;background-color:#fff' bgcolor='#ffffff'>\n" + 
				"                                       <tbody>\n" + 
				"                                          <tr style='border-color:transparent'>\n" + 
				"                                             <td cellpadding='0' cellspacing='0' style='border-collapse:collapse;border-color:transparent'>\n" + 
				"                                                <table width='100%' cellpadding='0' cellspacing='0' id='m_5003591963639980197w' style='border-collapse:collapse;color:#444;font-family:&quot;Segoe UI&quot;,Segoe,&quot;Avenir Next&quot;,&quot;Open Sans&quot;,sans-serif;font-size:14px;line-height:1.5;font-weight:normal;margin:0'>\n" + 
				"                                                   <tbody>\n" + 
				"                                                      <tr style='border-color:transparent'>\n" + 
				"                                                         <td class='m_5003591963639980197expander' colspan='3' width='100%' height='10' style='border-collapse:collapse;border-color:transparent'></td>\n" + 
				"                                                      </tr>\n" + 
				"                                                      <tr class='m_5003591963639980197content-row' style='border-color:transparent'>\n" + 
				"                                                         <td class='m_5003591963639980197gutter' style='border-collapse:collapse;border-color:transparent;width:30px!important' width='30' height='100%'></td>\n" + 
				"                                                         <td class='m_5003591963639980197content-cell' width='540' style='border-collapse:collapse;border-color:transparent;vertical-align:top' valign='top'>\n" + 
				"                                                            <p style='font-size:inherit;line-height:inherit;margin:0 0 10px;color:inherit;font-family:&quot;Segoe UI&quot;,Segoe,&quot;Avenir Next&quot;,&quot;Open Sans&quot;,sans-serif;font-weight:normal;padding:0;text-align:center' align='center'><span style='font-size:24px'><strong>How to Activate your account ?</strong></span></p>\n" + 
				"                                                         </td>\n" + 
				"                                                         <td class='m_5003591963639980197gutter' style='border-collapse:collapse;border-color:transparent;width:30px!important' width='30' height='100%'></td>\n" + 
				"                                                      </tr>\n" + 
				"                                                      <tr style='border-color:transparent'>\n" + 
				"                                                         <td class='m_5003591963639980197expander' colspan='3' width='100%' height='0' style='border-collapse:collapse;border-color:transparent'></td>\n" + 
				"                                                      </tr>\n" + 
				"                                                   </tbody>\n" + 
				"                                                </table>\n" + 
				"                                             </td>\n" + 
				"                                          </tr>\n" + 
				"                                       </tbody>\n" + 
				"                                    </table>\n" + 
				"                                 </th>\n" + 
				"                              </tr>\n" + 
				"                           </tbody>\n" + 
				"                        </table>\n" + 
				"                     </td>\n" + 
				"                  </tr>\n" + 
				"                  <tr style='border-color:transparent'>\n" + 
				"                     <td border='0' cellpadding='0' cellspacing='0' style='border-collapse:collapse;border-color:transparent'>\n" + 
				"                        <table cellpadding='0' cellspacing='0' style='border-collapse:collapse;color:#444;font-family:&quot;Segoe UI&quot;,Segoe,&quot;Avenir Next&quot;,&quot;Open Sans&quot;,sans-serif;font-size:14px;line-height:1.5;width:100%' border='0' width='100%'>\n" + 
				"                           <tbody>\n" + 
				"                              <tr style='border-color:transparent'>\n" + 
				"                                 <th width='300' style='border-color:transparent;font-weight:400;text-align:left;vertical-align:top' cellpadding='0' cellspacing='0' class='m_5003591963639980197tc' align='left' valign='top'>\n" + 
				"                                    <table border='0' width='100%' cellpadding='0' cellspacing='0' style='border-collapse:collapse;color:#444;font-family:&quot;Segoe UI&quot;,Segoe,&quot;Avenir Next&quot;,&quot;Open Sans&quot;,sans-serif;font-size:14px;line-height:1.5;background-color:#fff' bgcolor='#ffffff'>\n" + 
				"                                       <tbody>\n" + 
				"                                          <tr style='border-color:transparent'>\n" + 
				"                                             <td cellpadding='0' cellspacing='0' style='border-collapse:collapse;border-color:transparent'>\n" + 
				"                                                <table width='100%' cellpadding='0' cellspacing='0' id='m_5003591963639980197w' style='border-collapse:collapse;color:#444;font-family:&quot;Segoe UI&quot;,Segoe,&quot;Avenir Next&quot;,&quot;Open Sans&quot;,sans-serif;font-size:14px;line-height:1.5;font-weight:normal;margin:0'>\n" + 
				"                                                   <tbody>\n" + 
				"                                                      <tr style='border-color:transparent'>\n" + 
				"                                                         <td class='m_5003591963639980197expander' colspan='3' width='100%' height='10' style='border-collapse:collapse;border-color:transparent'></td>\n" + 
				"                                                      </tr>\n" + 
				"                                                      <tr class='m_5003591963639980197content-row' style='border-color:transparent'>\n" + 
				"                                                         <td class='m_5003591963639980197gutter' style='border-collapse:collapse;border-color:transparent;width:30px!important' width='30' height='100%'></td>\n" + 
				"                                                         <td class='m_5003591963639980197content-cell' width='240' style='border-collapse:collapse;border-color:transparent;vertical-align:top' valign='top'>\n" + 
				"                                                            <p style='font-size:inherit;line-height:inherit;margin:0 0 10px;color:inherit;font-family:&quot;Segoe UI&quot;,Segoe,&quot;Avenir Next&quot;,&quot;Open Sans&quot;,sans-serif;font-weight:normal;padding:0'><span style='font-size:18px'><strong>1. Click and   <span class='il'>Verify</span> your presence</strong></span></p>\n" + 
				"                                                            <p style='font-size:inherit;line-height:inherit;margin:0 0 10px;color:inherit;font-family:&quot;Segoe UI&quot;,Segoe,&quot;Avenir Next&quot;,&quot;Open Sans&quot;,sans-serif;font-weight:normal;padding:0'><span style='font-weight:400;font-size:16px'>To assure our portal is in the right hands, we will require verification from genuine sources.</span></p>\n" + 
				"                                                         </td>\n" + 
				"                                                         <td class='m_5003591963639980197gutter' style='border-collapse:collapse;border-color:transparent;width:30px!important' width='30' height='100%'></td>\n" + 
				"                                                      </tr>\n" + 
				"                                                      <tr style='border-color:transparent'>\n" + 
				"                                                         <td class='m_5003591963639980197expander' colspan='3' width='100%' height='0' style='border-collapse:collapse;border-color:transparent'></td>\n" + 
				"                                                      </tr>\n" + 
				"                                                   </tbody>\n" + 
				"                                                </table>\n" + 
				"                                             </td>\n" + 
				"                                          </tr>\n" + 
				"                                       </tbody>\n" + 
				"                                    </table>\n" + 
				"                                 </th>\n" + 
				"                                 <th width='300' style='border-color:transparent;font-weight:400;text-align:left;vertical-align:top' cellpadding='0' cellspacing='0' class='m_5003591963639980197tc' align='left' valign='top'>\n" + 
				"                                    <table border='0' width='100%' cellpadding='0' cellspacing='0' style='border-collapse:collapse;color:#444;font-family:&quot;Segoe UI&quot;,Segoe,&quot;Avenir Next&quot;,&quot;Open Sans&quot;,sans-serif;font-size:14px;line-height:1.5;background-color:#fff' bgcolor='#ffffff'>\n" + 
				"                                       <tbody>\n" + 
				"                                          <tr style='border-color:transparent'>\n" + 
				"                                             <td cellpadding='0' cellspacing='0' style='border-collapse:collapse;border-color:transparent'>\n" + 
				"                                                <table width='100%' cellpadding='0' cellspacing='0' style='border-collapse:collapse;color:#444;font-family:&quot;Segoe UI&quot;,Segoe,&quot;Avenir Next&quot;,&quot;Open Sans&quot;,sans-serif;font-size:14px;line-height:1.5'>\n" + 
				"                                                   <tbody>\n" + 
				"                                                      <tr style='border-color:transparent'>\n" + 
				"                                                         <td class='m_5003591963639980197expander' colspan='3' width='100%' height='0' style='border-collapse:collapse;border-color:transparent'></td>\n" + 
				"                                                      </tr>\n" + 
				"                                                      <tr class='m_5003591963639980197content-row' style='border-color:transparent'>\n" + 
				"                                                         <td class='m_5003591963639980197gutter' style='border-collapse:collapse;border-color:transparent;width:30px!important' width='30' height='100%'></td>\n" + 
				"                                                         <td class='m_5003591963639980197content-cell' width='240' style='border-collapse:collapse;border-color:transparent;vertical-align:top' valign='top'>\n" + 
				"                                                            <div style='color:#444;font-family:&quot;Segoe UI&quot;,Segoe,&quot;Avenir Next&quot;,&quot;Open Sans&quot;,sans-serif;font-size:14px;line-height:1.5;display:block;height:199;text-align:center;width:100%' height='199' align='center' width='100%'>\n" + 
				"                                                              \n" + 
				"                                                                  <center><img border='0' width='199' height='auto' class='m_5003591963639980197sp-img m_5003591963639980197small_img CToWUd' align='center' alt='' src='http://52.36.94.173/reach/second.png' style='text-decoration:none;border:0;height:auto;line-height:100%;outline:0;display:block'></center>\n" + 
				"                                                               \n" + 
				"                                                            </div>\n" + 
				"                                                         </td>\n" + 
				"                                                         <td class='m_5003591963639980197gutter' style='border-collapse:collapse;border-color:transparent;width:30px!important' width='30' height='100%'></td>\n" + 
				"                                                      </tr>\n" + 
				"                                                      <tr style='border-color:transparent'>\n" + 
				"                                                         <td class='m_5003591963639980197expander' colspan='3' width='100%' height='15' style='border-collapse:collapse;border-color:transparent'></td>\n" + 
				"                                                      </tr>\n" + 
				"                                                   </tbody>\n" + 
				"                                                </table>\n" + 
				"                                             </td>\n" + 
				"                                          </tr>\n" + 
				"                                       </tbody>\n" + 
				"                                    </table>\n" + 
				"                                 </th>\n" + 
				"                              </tr>\n" + 
				"                           </tbody>\n" + 
				"                        </table>\n" + 
				"                     </td>\n" + 
				"                  </tr>\n" + 
				"                  <tr style='border-color:transparent'>\n" + 
				"                     <td border='0' cellpadding='0' cellspacing='0' style='border-collapse:collapse;border-color:transparent'>\n" + 
				"                        <table cellpadding='0' cellspacing='0' style='border-collapse:collapse;color:#444;font-family:&quot;Segoe UI&quot;,Segoe,&quot;Avenir Next&quot;,&quot;Open Sans&quot;,sans-serif;font-size:14px;line-height:1.5;width:100%' border='0' width='100%'>\n" + 
				"                           <tbody>\n" + 
				"                              <tr style='border-color:transparent'>\n" + 
				"                                 <th width='600' style='border-color:transparent;font-weight:400;text-align:left;vertical-align:top' cellpadding='0' cellspacing='0' class='m_5003591963639980197tc' align='left' valign='top'>\n" + 
				"                                    <table border='0' width='100%' cellpadding='0' cellspacing='0' style='border-collapse:collapse;color:#444;font-family:&quot;Segoe UI&quot;,Segoe,&quot;Avenir Next&quot;,&quot;Open Sans&quot;,sans-serif;font-size:14px;line-height:1.5;background-color:#fff' bgcolor='#ffffff'>\n" + 
				"                                       <tbody>\n" + 
				"                                          <tr style='border-color:transparent'>\n" + 
				"                                             <td cellpadding='0' cellspacing='0' style='border-collapse:collapse;border-color:transparent'>\n" + 
				"                                                <table class='m_5003591963639980197separator' width='100%' cellpadding='0' cellspacing='0' style='border-collapse:collapse;color:#444;font-family:&quot;Segoe UI&quot;,Segoe,&quot;Avenir Next&quot;,&quot;Open Sans&quot;,sans-serif;font-size:14px;line-height:1.5;height:10px;padding-bottom:0;padding-left:0;padding-right:0;padding-top:0' height='10'>\n" + 
				"                                                   <tbody>\n" + 
				"                                                      <tr style='border-color:transparent'>\n" + 
				"                                                         <td height='10' style='border-collapse:collapse;border-color:transparent'></td>\n" + 
				"                                                      </tr>\n" + 
				"                                                   </tbody>\n" + 
				"                                                </table>\n" + 
				"                                             </td>\n" + 
				"                                          </tr>\n" + 
				"                                       </tbody>\n" + 
				"                                    </table>\n" + 
				"                                 </th>\n" + 
				"                              </tr>\n" + 
				"                           </tbody>\n" + 
				"                        </table>\n" + 
				"                     </td>\n" + 
				"                  </tr>\n" + 
				"                  <tr style='border-color:transparent'>\n" + 
				"                     <td border='0' cellpadding='0' cellspacing='0' style='border-collapse:collapse;border-color:transparent'>\n" + 
				"                        <table cellpadding='0' cellspacing='0' style='border-collapse:collapse;color:#444;font-family:&quot;Segoe UI&quot;,Segoe,&quot;Avenir Next&quot;,&quot;Open Sans&quot;,sans-serif;font-size:14px;line-height:1.5;width:100%' border='0' width='100%'>\n" + 
				"                           <tbody>\n" + 
				"                              <tr style='border-color:transparent'>\n" + 
				"                                 <th width='300' style='border-color:transparent;font-weight:400;text-align:left;vertical-align:top' cellpadding='0' cellspacing='0' class='m_5003591963639980197tc' align='left' valign='top'>\n" + 
				"                                    <table border='0' width='100%' cellpadding='0' cellspacing='0' style='border-collapse:collapse;color:#444;font-family:&quot;Segoe UI&quot;,Segoe,&quot;Avenir Next&quot;,&quot;Open Sans&quot;,sans-serif;font-size:14px;line-height:1.5;background-color:#fff' bgcolor='#ffffff'>\n" + 
				"                                       <tbody>\n" + 
				"                                          <tr style='border-color:transparent'>\n" + 
				"                                             <td cellpadding='0' cellspacing='0' style='border-collapse:collapse;border-color:transparent'>\n" + 
				"                                                <table width='100%' cellpadding='0' cellspacing='0' style='border-collapse:collapse;color:#444;font-family:&quot;Segoe UI&quot;,Segoe,&quot;Avenir Next&quot;,&quot;Open Sans&quot;,sans-serif;font-size:14px;line-height:1.5'>\n" + 
				"                                                   <tbody>\n" + 
				"                                                      <tr style='border-color:transparent'>\n" + 
				"                                                         <td class='m_5003591963639980197expander' colspan='1' width='100%' height='0' style='border-collapse:collapse;border-color:transparent'></td>\n" + 
				"                                                      </tr>\n" + 
				"                                                      <tr class='m_5003591963639980197content-row' style='border-color:transparent'>\n" + 
				"                                                         <td class='m_5003591963639980197content-cell' width='300' style='border-collapse:collapse;border-color:transparent;vertical-align:top' valign='top'>\n" + 
				"                                                            <div style='color:#444;font-family:&quot;Segoe UI&quot;,Segoe,&quot;Avenir Next&quot;,&quot;Open Sans&quot;,sans-serif;font-size:14px;line-height:1.5;display:block;height:199;text-align:center;width:100%' height='199' align='center' width='100%'>\n" + 
				"                                                               \n" + 
				"                                                                  <center><img border='0' width='199' height='auto' class='m_5003591963639980197sp-img m_5003591963639980197small_img CToWUd' align='center' alt='' src='http://52.36.94.173/reach/third.png' style='text-decoration:none;border:0;height:auto;line-height:100%;outline:0;display:block'></center>\n" + 
				"                                                              \n" + 
				"                                                            </div>\n" + 
				"                                                         </td>\n" + 
				"                                                      </tr>\n" + 
				"                                                      <tr style='border-color:transparent'>\n" + 
				"                                                         <td class='m_5003591963639980197expander' colspan='1' width='100%' height='0' style='border-collapse:collapse;border-color:transparent'></td>\n" + 
				"                                                      </tr>\n" + 
				"                                                   </tbody>\n" + 
				"                                                </table>\n" + 
				"                                             </td>\n" + 
				"                                          </tr>\n" + 
				"                                       </tbody>\n" + 
				"                                    </table>\n" + 
				"                                 </th>\n" + 
				"                                 <th width='300' style='border-color:transparent;font-weight:400;text-align:left;vertical-align:top' cellpadding='0' cellspacing='0' class='m_5003591963639980197tc' align='left' valign='top'>\n" + 
				"                                    <table border='0' width='100%' cellpadding='0' cellspacing='0' style='border-collapse:collapse;color:#444;font-family:&quot;Segoe UI&quot;,Segoe,&quot;Avenir Next&quot;,&quot;Open Sans&quot;,sans-serif;font-size:14px;line-height:1.5;background-color:#fff' bgcolor='#ffffff'>\n" + 
				"                                       <tbody>\n" + 
				"                                          <tr style='border-color:transparent'>\n" + 
				"                                             <td cellpadding='0' cellspacing='0' style='border-collapse:collapse;border-color:transparent'>\n" + 
				"                                                <table width='100%' cellpadding='0' cellspacing='0' id='m_5003591963639980197w' style='border-collapse:collapse;color:#444;font-family:&quot;Segoe UI&quot;,Segoe,&quot;Avenir Next&quot;,&quot;Open Sans&quot;,sans-serif;font-size:14px;line-height:1.5;font-weight:normal;margin:0'>\n" + 
				"                                                   <tbody>\n" + 
				"                                                      <tr style='border-color:transparent'>\n" + 
				"                                                         <td class='m_5003591963639980197expander' colspan='3' width='100%' height='30' style='border-collapse:collapse;border-color:transparent'></td>\n" + 
				"                                                      </tr>\n" + 
				"                                                      <tr class='m_5003591963639980197content-row' style='border-color:transparent'>\n" + 
				"                                                         <td class='m_5003591963639980197gutter' style='border-collapse:collapse;border-color:transparent;width:30px!important' width='30' height='100%'></td>\n" + 
				"                                                         <td class='m_5003591963639980197content-cell' width='240' style='border-collapse:collapse;border-color:transparent;vertical-align:top' valign='top'>\n" + 
				"                                                            <p style='font-size:inherit;line-height:inherit;margin:0 0 10px;color:inherit;font-family:&quot;Segoe UI&quot;,Segoe,&quot;Avenir Next&quot;,&quot;Open Sans&quot;,sans-serif;font-weight:normal;padding:0'><span style='font-size:18px'><strong>2. Add credits to your account</strong></span></p>\n" + 
				"                                                            <p style='font-size:inherit;line-height:inherit;margin:0 0 10px;color:inherit;font-family:&quot;Segoe UI&quot;,Segoe,&quot;Avenir Next&quot;,&quot;Open Sans&quot;,sans-serif;font-weight:normal;padding:0'><span style='font-weight:400;font-size:16px'>To ease your activities on this portal. You will need credits or balance, to make sure your campaigns and other activities do not get hampered.</span></p>\n" + 
				"                                                         </td>\n" + 
				"                                                         <td class='m_5003591963639980197gutter' style='border-collapse:collapse;border-color:transparent;width:30px!important' width='30' height='100%'></td>\n" + 
				"                                                      </tr>\n" + 
				"                                                      <tr style='border-color:transparent'>\n" + 
				"                                                         <td class='m_5003591963639980197expander' colspan='3' width='100%' height='20' style='border-collapse:collapse;border-color:transparent'></td>\n" + 
				"                                                      </tr>\n" + 
				"                                                   </tbody>\n" + 
				"                                                </table>\n" + 
				"                                             </td>\n" + 
				"                                          </tr>\n" + 
				"                                       </tbody>\n" + 
				"                                    </table>\n" + 
				"                                 </th>\n" + 
				"                              </tr>\n" + 
				"                           </tbody>\n" + 
				"                        </table>\n" + 
				"                     </td>\n" + 
				"                  </tr>\n" + 
				"                  <tr style='border-color:transparent'>\n" + 
				"                     <td border='0' cellpadding='0' cellspacing='0' style='border-collapse:collapse;border-color:transparent'>\n" + 
				"                        <table cellpadding='0' cellspacing='0' style='border-collapse:collapse;color:#444;font-family:&quot;Segoe UI&quot;,Segoe,&quot;Avenir Next&quot;,&quot;Open Sans&quot;,sans-serif;font-size:14px;line-height:1.5;width:100%' border='0' width='100%'>\n" + 
				"                           <tbody>\n" + 
				"                              <tr style='border-color:transparent'>\n" + 
				"                                 <th width='600' style='border-color:transparent;font-weight:400;text-align:left;vertical-align:top' cellpadding='0' cellspacing='0' class='m_5003591963639980197tc' align='left' valign='top'>\n" + 
				"                                    <table border='0' width='100%' cellpadding='0' cellspacing='0' style='border-collapse:collapse;color:#444;font-family:&quot;Segoe UI&quot;,Segoe,&quot;Avenir Next&quot;,&quot;Open Sans&quot;,sans-serif;font-size:14px;line-height:1.5;background-color:#fff' bgcolor='#ffffff'>\n" + 
				"                                       <tbody>\n" + 
				"                                          <tr style='border-color:transparent'>\n" + 
				"                                             <td cellpadding='0' cellspacing='0' style='border-collapse:collapse;border-color:transparent'>\n" + 
				"                                                <table class='m_5003591963639980197separator' width='100%' cellpadding='0' cellspacing='0' style='border-collapse:collapse;color:#444;font-family:&quot;Segoe UI&quot;,Segoe,&quot;Avenir Next&quot;,&quot;Open Sans&quot;,sans-serif;font-size:14px;line-height:1.5;height:10px;padding-bottom:0;padding-left:0;padding-right:0;padding-top:0' height='10'>\n" + 
				"                                                   <tbody>\n" + 
				"                                                      <tr style='border-color:transparent'>\n" + 
				"                                                         <td height='10' style='border-collapse:collapse;border-color:transparent'></td>\n" + 
				"                                                      </tr>\n" + 
				"                                                   </tbody>\n" + 
				"                                                </table>\n" + 
				"                                             </td>\n" + 
				"                                          </tr>\n" + 
				"                                       </tbody>\n" + 
				"                                    </table>\n" + 
				"                                 </th>\n" + 
				"                              </tr>\n" + 
				"                           </tbody>\n" + 
				"                        </table>\n" + 
				"                     </td>\n" + 
				"                  </tr>\n" + 
				"                  <tr style='border-color:transparent'>\n" + 
				"                     <td border='0' cellpadding='0' cellspacing='0' style='border-collapse:collapse;border-color:transparent'>\n" + 
				"                        <table cellpadding='0' cellspacing='0' style='border-collapse:collapse;color:#444;font-family:&quot;Segoe UI&quot;,Segoe,&quot;Avenir Next&quot;,&quot;Open Sans&quot;,sans-serif;font-size:14px;line-height:1.5;width:100%' border='0' width='100%'>\n" + 
				"                           <tbody>\n" + 
				"                              <tr style='border-color:transparent'>\n" + 
				"                                 <th width='300' style='border-color:transparent;font-weight:400;text-align:left;vertical-align:top' cellpadding='0' cellspacing='0' class='m_5003591963639980197tc' align='left' valign='top'>\n" + 
				"                                    <table border='0' width='100%' cellpadding='0' cellspacing='0' style='border-collapse:collapse;color:#444;font-family:&quot;Segoe UI&quot;,Segoe,&quot;Avenir Next&quot;,&quot;Open Sans&quot;,sans-serif;font-size:14px;line-height:1.5;background-color:#fff' bgcolor='#ffffff'>\n" + 
				"                                       <tbody>\n" + 
				"                                          <tr style='border-color:transparent'>\n" + 
				"                                             <td cellpadding='0' cellspacing='0' style='border-collapse:collapse;border-color:transparent'>\n" + 
				"                                                <table width='100%' cellpadding='0' cellspacing='0' id='m_5003591963639980197w' style='border-collapse:collapse;color:#444;font-family:&quot;Segoe UI&quot;,Segoe,&quot;Avenir Next&quot;,&quot;Open Sans&quot;,sans-serif;font-size:14px;line-height:1.5;font-weight:normal;margin:0'>\n" + 
				"                                                   <tbody>\n" + 
				"                                                      <tr style='border-color:transparent'>\n" + 
				"                                                         <td class='m_5003591963639980197expander' colspan='3' width='100%' height='30' style='border-collapse:collapse;border-color:transparent'></td>\n" + 
				"                                                      </tr>\n" + 
				"                                                      <tr class='m_5003591963639980197content-row' style='border-color:transparent'>\n" + 
				"                                                         <td class='m_5003591963639980197gutter' style='border-collapse:collapse;border-color:transparent;width:30px!important' width='30' height='100%'></td>\n" + 
				"                                                         <td class='m_5003591963639980197content-cell' width='240' style='border-collapse:collapse;border-color:transparent;vertical-align:top' valign='top'>\n" + 
				"                                                            <p style='font-size:inherit;line-height:inherit;margin:0 0 10px;color:inherit;font-family:&quot;Segoe UI&quot;,Segoe,&quot;Avenir Next&quot;,&quot;Open Sans&quot;,sans-serif;font-weight:normal;padding:0'><span style='font-size:18px'><strong>3. Start creating campaigns using the portal</strong></span></p>\n" + 
				"                                                            <p style='font-size:inherit;line-height:inherit;margin:0 0 10px;color:inherit;font-family:&quot;Segoe UI&quot;,Segoe,&quot;Avenir Next&quot;,&quot;Open Sans&quot;,sans-serif;font-weight:normal;padding:0'><span style='font-weight:400;font-size:16px'>Once all the procedures are done, you can launch your rocket and just wait for the ball to roll in your court!</span></p>\n" + 
				"                                                         </td>\n" + 
				"                                                         <td class='m_5003591963639980197gutter' style='border-collapse:collapse;border-color:transparent;width:30px!important' width='30' height='100%'></td>\n" + 
				"                                                      </tr>\n" + 
				"                                                      <tr style='border-color:transparent'>\n" + 
				"                                                         <td class='m_5003591963639980197expander' colspan='3' width='100%' height='0' style='border-collapse:collapse;border-color:transparent'></td>\n" + 
				"                                                      </tr>\n" + 
				"                                                   </tbody>\n" + 
				"                                                </table>\n" + 
				"                                             </td>\n" + 
				"                                          </tr>\n" + 
				"                                       </tbody>\n" + 
				"                                    </table>\n" + 
				"                                 </th>\n" + 
				"                                 <th width='300' style='border-color:transparent;font-weight:400;text-align:left;vertical-align:top' cellpadding='0' cellspacing='0' class='m_5003591963639980197tc' align='left' valign='top'>\n" + 
				"                                    <table border='0' width='100%' cellpadding='0' cellspacing='0' style='border-collapse:collapse;color:#444;font-family:&quot;Segoe UI&quot;,Segoe,&quot;Avenir Next&quot;,&quot;Open Sans&quot;,sans-serif;font-size:14px;line-height:1.5;background-color:#fff' bgcolor='#ffffff'>\n" + 
				"                                       <tbody>\n" + 
				"                                          <tr style='border-color:transparent'>\n" + 
				"                                             <td cellpadding='0' cellspacing='0' style='border-collapse:collapse;border-color:transparent'>\n" + 
				"                                                <table width='100%' cellpadding='0' cellspacing='0' style='border-collapse:collapse;color:#444;font-family:&quot;Segoe UI&quot;,Segoe,&quot;Avenir Next&quot;,&quot;Open Sans&quot;,sans-serif;font-size:14px;line-height:1.5'>\n" + 
				"                                                   <tbody>\n" + 
				"                                                      <tr style='border-color:transparent'>\n" + 
				"                                                         <td class='m_5003591963639980197expander' colspan='1' width='100%' height='0' style='border-collapse:collapse;border-color:transparent'></td>\n" + 
				"                                                      </tr>\n" + 
				"                                                      <tr class='m_5003591963639980197content-row' style='border-color:transparent'>\n" + 
				"                                                         <td class='m_5003591963639980197content-cell' width='300' style='border-collapse:collapse;border-color:transparent;vertical-align:top' valign='top'>\n" + 
				"                                                            <div style='color:#444;font-family:&quot;Segoe UI&quot;,Segoe,&quot;Avenir Next&quot;,&quot;Open Sans&quot;,sans-serif;font-size:14px;line-height:1.5;display:block;height:198;text-align:center;width:100%' height='198' align='center' width='100%'>\n" + 
				"                                                                  <center><img border='0' width='198' height='auto' class='m_5003591963639980197sp-img m_5003591963639980197small_img CToWUd' align='center' alt='' src='http://52.36.94.173/reach/four.png' style='text-decoration:none;border:0;height:auto;line-height:100%;outline:0;display:block'></center>\n" + 
				"                                                            </div>\n" + 
				"                                                         </td>\n" + 
				"                                                      </tr>\n" + 
				"                                                      <tr style='border-color:transparent'>\n" + 
				"                                                         <td class='m_5003591963639980197expander' colspan='1' width='100%' height='0' style='border-collapse:collapse;border-color:transparent'></td>\n" + 
				"                                                      </tr>\n" + 
				"                                                   </tbody>\n" + 
				"                                                </table>\n" + 
				"                                             </td>\n" + 
				"                                          </tr>\n" + 
				"                                       </tbody>\n" + 
				"                                    </table>\n" + 
				"                                 </th>\n" + 
				"                              </tr>\n" + 
				"                           </tbody>\n" + 
				"                        </table>\n" + 
				"                     </td>\n" + 
				"                  </tr>\n" + 
				"                  <tr style='border-color:transparent'>\n" + 
				"                     <td border='0' cellpadding='0' cellspacing='0' style='border-collapse:collapse;border-color:transparent'>\n" + 
				"                        <table cellpadding='0' cellspacing='0' style='border-collapse:collapse;color:#444;font-family:&quot;Segoe UI&quot;,Segoe,&quot;Avenir Next&quot;,&quot;Open Sans&quot;,sans-serif;font-size:14px;line-height:1.5;width:100%' border='0' width='100%'>\n" + 
				"                           <tbody>\n" + 
				"                              <tr style='border-color:transparent'>\n" + 
				"                                 <th width='600' style='border-color:transparent;font-weight:400;text-align:left;vertical-align:top' cellpadding='0' cellspacing='0' class='m_5003591963639980197tc' align='left' valign='top'>\n" + 
				"                                    <table border='0' width='100%' cellpadding='0' cellspacing='0' style='border-collapse:collapse;color:#444;font-family:&quot;Segoe UI&quot;,Segoe,&quot;Avenir Next&quot;,&quot;Open Sans&quot;,sans-serif;font-size:14px;line-height:1.5;background-color:#fff' bgcolor='#ffffff'>\n" + 
				"                                       <tbody>\n" + 
				"                                          <tr style='border-color:transparent'>\n" + 
				"                                             <td cellpadding='0' cellspacing='0' style='border-collapse:collapse;border-color:transparent'>\n" + 
				"                                                <table class='m_5003591963639980197separator' width='100%' cellpadding='0' cellspacing='0' style='border-collapse:collapse;color:#444;font-family:&quot;Segoe UI&quot;,Segoe,&quot;Avenir Next&quot;,&quot;Open Sans&quot;,sans-serif;font-size:14px;line-height:1.5;height:20px;padding-bottom:0;padding-left:0;padding-right:0;padding-top:0' height='20'>\n" + 
				"                                                   <tbody>\n" + 
				"                                                      <tr style='border-color:transparent'>\n" + 
				"                                                         <td height='20' style='border-collapse:collapse;border-color:transparent'></td>\n" + 
				"                                                      </tr>\n" + 
				"                                                   </tbody>\n" + 
				"                                                </table>\n" + 
				"                                             </td>\n" + 
				"                                          </tr>\n" + 
				"                                       </tbody>\n" + 
				"                                    </table>\n" + 
				"                                    <table border='0' width='100%' cellpadding='0' cellspacing='0' style='border-collapse:collapse;color:#444;font-family:&quot;Segoe UI&quot;,Segoe,&quot;Avenir Next&quot;,&quot;Open Sans&quot;,sans-serif;font-size:14px;line-height:1.5;background-color:#fff' bgcolor='#ffffff'>\n" + 
				"                                       <tbody>\n" + 
				"                                          <tr style='border-color:transparent'>\n" + 
				"                                             <td cellpadding='0' cellspacing='0' style='border-collapse:collapse;border-color:transparent'>\n" + 
				"                                                <table width='100%' cellpadding='0' cellspacing='0' style='border-collapse:collapse;color:#444;font-family:&quot;Segoe UI&quot;,Segoe,&quot;Avenir Next&quot;,&quot;Open Sans&quot;,sans-serif;font-size:14px;line-height:1.5'>\n" + 
				"                                                   <tbody>\n" + 
				"                                                      <tr style='border-color:transparent'>\n" + 
				"                                                         <td class='m_5003591963639980197expander' colspan='3' width='100%' height='0' style='border-collapse:collapse;border-color:transparent'></td>\n" + 
				"                                                      </tr>\n" + 
				"                                                      <tr class='m_5003591963639980197content-row' style='border-color:transparent'>\n" + 
				"                                                         <td class='m_5003591963639980197gutter' style='border-collapse:collapse;border-color:transparent;width:30px!important' width='30' height='100%'></td>\n" + 
				"                                                         <td class='m_5003591963639980197content-cell' width='540' style='border-collapse:collapse;border-color:transparent;vertical-align:top' valign='top'>\n" + 
				"                                                            <center>\n" + 
				"                                                               <table cellpadding='0' border='0' cellspacing='0' style='border-collapse:collapse;color:#444;font-family:&quot;Segoe UI&quot;,Segoe,&quot;Avenir Next&quot;,&quot;Open Sans&quot;,sans-serif;font-size:14px;line-height:1.5;border:0;margin-left:auto;margin-right:auto;background:#f65858;border-radius:5px' height='40' class='m_5003591963639980197sp-button m_5003591963639980197raised'>\n" + 
				"                                                                  <tbody>\n" + 
				"                                                                     <tr style='border-color:transparent'>\n" + 
				"                                                                        <td class='m_5003591963639980197sp-button-side-padding' style='border-collapse:collapse;border-color:transparent;border-style:none;border-width:0;width:21px;border:0;padding:0' width='21'>&nbsp;&nbsp;</td>\n" + 
				"                                                                        <td class='m_5003591963639980197sp-button-text' style='border-collapse:collapse;border-color:transparent;border-style:none;border-width:0;border:0;padding:0;border-radius:5px;height:40px;text-align:center;vertical-align:middle;width:auto' height='40' align='center' valign='middle' width='auto'>\n" + 
				"                                                                           <table cellpadding='0' border='0' cellspacing='0' width='100%' style='border-collapse:collapse;color:#444;font-family:&quot;Segoe UI&quot;,Segoe,&quot;Avenir Next&quot;,&quot;Open Sans&quot;,sans-serif;font-size:14px;line-height:1.5;border:0'>\n" + 
				"                                                                              <tbody>\n" + 
				"                                                                                 <tr style='border-color:transparent'>\n" + 
				"                                                                                    <td align='center' style='border-collapse:collapse;border-color:transparent;line-height:1;border:0;padding:0'><a style='text-decoration:none;color:#fff;display:block;font-family:&quot;Segoe UI&quot;,Segoe,&quot;Avenir Next&quot;,&quot;Open Sans&quot;,sans-serif;font-size:16px;font-weight:bold' href='"+url+"' target='_blank' data-saferedirecturl='https://www.google.com/url?q="+url+"'><span class='il'>Verify</span> Account</a></td>\n" + 
				"                                                                                 </tr>\n" + 
				"                                                                              </tbody>\n" + 
				"                                                                           </table>\n" + 
				"                                                                        </td>\n" + 
				"                                                                        <td class='m_5003591963639980197sp-button-side-padding' style='border-collapse:collapse;border-color:transparent;border-style:none;border-width:0;width:21px;border:0;padding:0' width='21'>&nbsp;&nbsp;</td>\n" + 
				"                                                                     </tr>\n" + 
				"                                                                  </tbody>\n" + 
				"                                                               </table>\n" + 
				"                                                            </center>\n" + 
				"                                                         </td>\n" + 
				"                                                         <td class='m_5003591963639980197gutter' style='border-collapse:collapse;border-color:transparent;width:30px!important' width='30' height='100%'></td>\n" + 
				"                                                      </tr>\n" + 
				"                                                      <tr style='border-color:transparent'>\n" + 
				"                                                         <td class='m_5003591963639980197expander' colspan='3' width='100%' height='40' style='border-collapse:collapse;border-color:transparent'></td>\n" + 
				"                                                      </tr>\n" + 
				"                                                   </tbody>\n" + 
				"                                                </table>\n" + 
				"                                             </td>\n" + 
				"                                          </tr>\n" + 
				"                                       </tbody>\n" + 
				"                                    </table>\n" + 
				"                                 </th>\n" + 
				"                              </tr>\n" + 
				"                           </tbody>\n" + 
				"                        </table>\n" + 
				"                     </td>\n" + 
				"                  </tr>\n" + 
				"                  <tr style='border-color:transparent'>\n" + 
				"                     <td border='0' cellpadding='0' cellspacing='0' style='border-collapse:collapse;border-color:transparent'>\n" + 
				"                        <table cellpadding='0' cellspacing='0' style='border-collapse:collapse;color:#444;font-family:&quot;Segoe UI&quot;,Segoe,&quot;Avenir Next&quot;,&quot;Open Sans&quot;,sans-serif;font-size:14px;line-height:1.5;width:100%' border='0' width='100%'>\n" + 
				"                           <tbody>\n" + 
				"                              <tr style='border-color:transparent'>\n" + 
				"                                 <th width='600' style='border-color:transparent;font-weight:400;text-align:left;vertical-align:top' cellpadding='0' cellspacing='0' class='m_5003591963639980197tc' align='left' valign='top'>\n" + 
				"                                    <table border='0' width='100%' cellpadding='0' cellspacing='0' style='border-collapse:collapse;color:#444;font-family:&quot;Segoe UI&quot;,Segoe,&quot;Avenir Next&quot;,&quot;Open Sans&quot;,sans-serif;font-size:14px;line-height:1.5;background-color:#333' bgcolor='#333333'>\n" + 
				"                                       <tbody>\n" + 
				"                                          <tr style='border-color:transparent'>\n" + 
				"                                             <td cellpadding='0' cellspacing='0' style='border-collapse:collapse;border-color:transparent'>\n" + 
				"                                                <table width='100%' cellpadding='0' cellspacing='0' id='m_5003591963639980197w' style='border-collapse:collapse;color:#eee;font-family:&quot;Segoe UI&quot;,Segoe,&quot;Avenir Next&quot;,&quot;Open Sans&quot;,sans-serif;font-size:14px;line-height:1.5;background-color:#333;font-weight:normal;margin:0' bgcolor='#333333'>\n" + 
				"                                                   <tbody>\n" + 
				"                                                      <tr style='border-color:transparent'>\n" + 
				"                                                         <td class='m_5003591963639980197expander' colspan='3' width='100%' height='20' style='border-collapse:collapse;border-color:transparent'></td>\n" + 
				"                                                      </tr>\n" + 
				"                                                      <tr class='m_5003591963639980197content-row' style='border-color:transparent'>\n" + 
				"                                                         <td class='m_5003591963639980197gutter' style='border-collapse:collapse;border-color:transparent;width:30px!important' width='30' height='100%'></td>\n" + 
				"                                                         <td class='m_5003591963639980197content-cell' width='540' style='border-collapse:collapse;border-color:transparent;vertical-align:top' valign='top'>\n" + 
				"                                                            <p style='font-size:inherit;line-height:inherit;margin:0 0 10px;color:#eee;font-family:&quot;Segoe UI&quot;,Segoe,&quot;Avenir Next&quot;,&quot;Open Sans&quot;,sans-serif;font-weight:normal;padding:0;text-align:center' align='center'><span style='font-size:16px'>Best wishes, Reach Team</span><br><a href='' rel='noopener' style='text-decoration:none;color:#0089bf' target='_blank' data-saferedirecturl=''>reach.com</a></p>\n" + 
				"                                                         </td>\n" + 
				"                                                         <td class='m_5003591963639980197gutter' style='border-collapse:collapse;border-color:transparent;width:30px!important' width='30' height='100%'></td>\n" + 
				"                                                      </tr>\n" + 
				"                                                      <tr style='border-color:transparent'>\n" + 
				"                                                         <td class='m_5003591963639980197expander' colspan='3' width='100%' height='1' style='border-collapse:collapse;border-color:transparent'></td>\n" + 
				"                                                      </tr>\n" + 
				"                                                   </tbody>\n" + 
				"                                                </table>\n" + 
				"                                             </td>\n" + 
				"                                          </tr>\n" + 
				"                                       </tbody>\n" + 
				"                                    </table>\n" + 
				"                                \n" + 
				"                                    <table border='0' width='100%' cellpadding='0' cellspacing='0' style='border-collapse:collapse;color:#444;font-family:&quot;Segoe UI&quot;,Segoe,&quot;Avenir Next&quot;,&quot;Open Sans&quot;,sans-serif;font-size:14px;line-height:1.5;background-color:#eee' bgcolor='#eeeeee'>\n" + 
				"                                       <tbody>\n" + 
				"                                          <tr style='border-color:transparent'>\n" + 
				"                                             <td cellpadding='0' cellspacing='0' style='border-collapse:collapse;border-color:transparent'>\n" + 
				"                                                <table width='100%' cellpadding='0' cellspacing='0' id='m_5003591963639980197w' style='border-collapse:collapse;color:#444;font-family:&quot;Segoe UI&quot;,Segoe,&quot;Avenir Next&quot;,&quot;Open Sans&quot;,sans-serif;font-size:14px;line-height:1.5;background-color:#eee;font-weight:normal;margin:0' bgcolor='#eeeeee'>\n" + 
				"                                                   <tbody>\n" + 
				"                                                      <tr style='border-color:transparent'>\n" + 
				"                                                         <td class='m_5003591963639980197expander' colspan='3' width='100%' height='10' style='border-collapse:collapse;border-color:transparent'></td>\n" + 
				"                                                      </tr>\n" + 
				"                                                      <tr class='m_5003591963639980197content-row' style='border-color:transparent'>\n" + 
				"                                                         <td class='m_5003591963639980197gutter' style='border-collapse:collapse;border-color:transparent;width:30px!important' width='30' height='100%'></td>\n" + 
				"                                                         <td class='m_5003591963639980197content-cell' width='540' style='border-collapse:collapse;border-color:transparent;vertical-align:top' valign='top'>\n" + 
				"                                                            <p style='font-size:inherit;line-height:inherit;margin:0 0 10px;color:inherit;font-family:&quot;Segoe UI&quot;,Segoe,&quot;Avenir Next&quot;,&quot;Open Sans&quot;,sans-serif;font-weight:normal;padding:0;text-align:center' align='center'>You recieved this email as you are the client of .<br> </p>\n" + 
				"                                                         </td>\n" + 
				"                                                         <td class='m_5003591963639980197gutter' style='border-collapse:collapse;border-color:transparent;width:30px!important' width='30' height='100%'></td>\n" + 
				"                                                      </tr>\n" + 
				"                                                      <tr style='border-color:transparent'>\n" + 
				"                                                         <td class='m_5003591963639980197expander' colspan='3' width='100%' height='15' style='border-collapse:collapse;border-color:transparent'></td>\n" + 
				"                                                      </tr>\n" + 
				"                                                   </tbody>\n" + 
				"                                                </table>\n" + 
				"                                             </td>\n" + 
				"                                          </tr>\n" + 
				"                                       </tbody>\n" + 
				"                                    </table>\n" + 
				"                                 </th>\n" + 
				"                              </tr>\n" + 
				"                           </tbody>\n" + 
				"                        </table>\n" + 
				"                     </td>\n" + 
				"                  </tr>\n" + 
				"               </tbody>\n" + 
				"            </table>\n" + 
				"            <table width='600px' style='border-collapse:collapse;color:#444;font-family:&quot;Segoe UI&quot;,Segoe,&quot;Avenir Next&quot;,&quot;Open Sans&quot;,sans-serif;font-size:14px;line-height:1.5'></table>\n" + 
				"         </td>\n" + 
				"      </tr>\n" + 
				"   </tbody>\n" + 
				"</table>";
		String template2="Your OTP is "+url;
		String message="";
		if(template=="verify") {
			 message=content;
		}else if(template=="forget") {
			 message=template2;
		}
		
		try {
			//logger.info("message"+message);
			javaEmail.setMailServerProperties();
			javaEmail.sendEmail(javaEmail.createEmailMessage(subject,to,message));
			logger.info("Email sent: From-"+from+",To- "+to+",Subject- "+subject);
		} catch (Exception e) {
			logger.info("could not send email: From- "+from+",To-"+to+",subject-"+subject+",message-"+message);
			e.printStackTrace();
		}
		return "ok";
	}
}
