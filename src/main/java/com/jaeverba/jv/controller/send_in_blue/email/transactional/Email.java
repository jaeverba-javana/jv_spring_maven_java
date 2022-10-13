package com.jaeverba.jv.controller.send_in_blue.email.transactional;

import com.jaeverba.jv.entities.Solicitud;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import sendinblue.ApiClient;
import sendinblue.ApiException;
import sendinblue.Configuration;
import sendinblue.auth.ApiKeyAuth;
import sibApi.TransactionalEmailsApi;
import sibModel.*;

import java.util.ArrayList;
import java.util.List;

@ToString
public class Email {
    private final SendSmtpEmailSender sender;
    private final List<SendSmtpEmailTo> toList;
    private final SendSmtpEmailReplyTo replyTo;
    private final String mensaje;

    //Constructor para envio de email sencillo
    private Email(
            SendSmtpEmailSender sender,
            List<SendSmtpEmailTo> toList,
            SendSmtpEmailReplyTo replyTo,
            String mensaje
    ) {
        this.sender = sender;
        this.toList = toList;
        this.replyTo = replyTo;
        this.mensaje = mensaje;
    }


    public static Email emailContactMeConfirm(Solicitud solicitud) {
        SendSmtpEmailSender sender = new SendSmtpEmailSender();
        sender.setEmail("jaeverba@gmail.com");
        sender.setName("Javier Vergara");

        List<SendSmtpEmailTo> toList = new ArrayList<SendSmtpEmailTo>();
            SendSmtpEmailTo to = new SendSmtpEmailTo();
            to.setEmail(solicitud.getEmail());
            to.setName(solicitud.getNombres());
            toList.add(to);

        SendSmtpEmailReplyTo replyTo = new SendSmtpEmailReplyTo();
        replyTo.setEmail("jaeverba@gmail.com");
        replyTo.setName("Javier Vergara");



        return new Email(sender, toList, replyTo, solicitud.getMensaje());
    }

    public Boolean send() {
        ApiClient defaultClient = Configuration.getDefaultApiClient();

        ApiKeyAuth apiKey = (ApiKeyAuth) defaultClient.getAuthentication("api-key");
        apiKey.setApiKey("Apikey");

        TransactionalEmailsApi api = new TransactionalEmailsApi();

        SendSmtpEmail sendSmtpEmail = new SendSmtpEmail();
        sendSmtpEmail.setSender(this.sender);
        sendSmtpEmail.setTo(this.toList);

        sendSmtpEmail.setHtmlContent(this.mensaje);
        sendSmtpEmail.setSubject("sujeto");

        sendSmtpEmail.setReplyTo(this.replyTo);

        try {
            CreateSmtpEmail response = api.sendTransacEmail(sendSmtpEmail);


            //CreateSmtpEmail result = apiInstance.sendTransacEmail(sendSmtpEmail);
            System.out.println(response);

            return true;
        } catch (ApiException e) {
            System.err.println("Exception when calling TransactionalEmailsApi#sendTransacEmail");
            e.printStackTrace();

            return false;
        }

    }
}
