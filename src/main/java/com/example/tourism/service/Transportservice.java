package com.example.tourism.service;


import java.util.List;


import com.example.tourism.entity.Transport;

public interface Transportservice {
	Transport SaveTransp(Transport transport);
    List<Transport>GetAllTransport();
    public void deleteById(long id);
	public Transport getBookById(long id);
}
