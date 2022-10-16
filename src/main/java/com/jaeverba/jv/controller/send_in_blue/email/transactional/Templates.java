package com.jaeverba.jv.controller.send_in_blue.email.transactional;

import org.springframework.stereotype.Controller;

@Controller
public class Templates {
    public String templateCoreo() {
        return "templates/correos/contactme_email_confirmation.html";
    }
}
