package com.home.library.service;

import com.home.library.model.Reader;

import java.util.List;

public interface IMessagingService {
    void sendMessageToReaders(String message, List<Reader> readers);
}
