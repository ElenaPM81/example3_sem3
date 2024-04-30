package com.example.example3_sem3.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    @Autowired
    UserService userService;
    NotificationService notificationService;

    @Autowired
    private  DataProcessingService dataProcessingService;

    public DataProcessingService getDataProcessingService() {
        return dataProcessingService;
    }


    public void processRegistration(String name, int age, String email) {
        userService.createUser(name, age, email);

        // Отправляем уведомление о создании нового пользователя
        notificationService.sendNotification("Пользователь создан");

        // Обновляем базу данных
        dataProcessingService.updateDatabase();
    }

}