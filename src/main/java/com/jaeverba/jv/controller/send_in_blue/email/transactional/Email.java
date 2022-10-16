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

import javax.annotation.processing.Filer;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@ToString
public class Email {
    private final SendSmtpEmailSender sender;
    private final List<SendSmtpEmailTo> toList;
    private final SendSmtpEmailReplyTo replyTo;
    private final String mensaje;
    private final String template;

    //Constructor para envio de email sencillo
    private Email(
            SendSmtpEmailSender sender,
            List<SendSmtpEmailTo> toList,
            SendSmtpEmailReplyTo replyTo,
            String mensaje,
            String template
    ) {
        this.sender = sender;
        this.toList = toList;
        this.replyTo = replyTo;
        this.mensaje = mensaje;
        this.template = template;
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

        File archivo = null;
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;

        //if (archivo.exists()) System.out.println("el arcjivo existe");
        //else System.out.println("el archivo no existe");

        String template = "";

        try {
            archivo = new File("recursos/html/plantillas/correos/contactme_email_confirmation.html");
            fileReader = new FileReader(archivo);
            bufferedReader = new BufferedReader(fileReader);
            String linea;

            while ((linea = bufferedReader.readLine()) != null) {
                template += linea;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (archivo != null) {
                    fileReader.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }



        return new Email(sender, toList, replyTo, solicitud.getMensaje(), template);
    }

    public Boolean send() {
        ApiClient defaultClient = Configuration.getDefaultApiClient();

        //TODO: API-KEY a ser borrada o cambiada para git
        ApiKeyAuth apiKey = (ApiKeyAuth) defaultClient.getAuthentication("api-key");
        apiKey.setApiKey("api-key");

        TransactionalEmailsApi api = new TransactionalEmailsApi();

        SendSmtpEmail sendSmtpEmail = new SendSmtpEmail();

        sendSmtpEmail.setSender(this.sender);
        sendSmtpEmail.setTo(this.toList);

        sendSmtpEmail.setHtmlContent(this.template);
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
