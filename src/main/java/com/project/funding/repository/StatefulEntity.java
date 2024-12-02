package com.project.funding.repository;

public interface StatefulEntity <T extends State> {
    T getState();
    void setState(T state);
}
