package com.demo.server.common;

// Import Java Packages
import java.time.LocalDateTime;

public class ApiResponse 
{
    // Instances
    private final boolean success;
    private final String message;

    // Constructor
    public ApiResponse(boolean success, String message) 
    {
        this.success = success;
        this.message = message;
    }

    // Set & Get
    public boolean isSuccess() 
    {
        return this.success;
    }

    public String getMessage() 
    {
        return this.message;
    }

    public String getTimeStamp()
    {
        return LocalDateTime.now().toString();
    }

}
