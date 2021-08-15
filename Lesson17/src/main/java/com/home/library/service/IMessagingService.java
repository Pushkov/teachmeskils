package com.home.library.service;

import com.home.library.model.EmailAddress;
import com.home.library.model.Reader;

import java.util.List;

public interface IMessagingService {
    List<EmailAddress> createMailingList(String message, List<Reader> readers);
}
