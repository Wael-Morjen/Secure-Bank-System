package com.project.banksystem.service.impl;

import com.project.banksystem.dto.EmailDetails;

public interface EmailService {
    void sendEmailAlert (EmailDetails emailDetails);
}
