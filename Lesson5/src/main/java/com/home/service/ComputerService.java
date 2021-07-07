package com.home.service;

import com.home.model.Computer;

public interface ComputerService {
    void on(Computer computer);

    void info(Computer computer);

    void off(Computer computer);

    void crashed(Computer computer);

    boolean hasResource(Computer computer);
}
