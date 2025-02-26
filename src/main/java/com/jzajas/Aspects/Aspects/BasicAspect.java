package com.jzajas.Aspects.Aspects;

import com.jzajas.Aspects.Models.User;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class BasicAspect {

    @Pointcut("com.jzajas.Aspects.Services.createUser() && args(user...)")
    private void userServiceUserCreationOperation(User user) {}

    @Before("userServiceUserCreationOperation(user)")
    public void sendUserCreationMessage(User user) {
        System.out.println("Attempting to create user: " + user);
    }

    @Before("userServiceUserCreationOperation(user)")
    public void sendUserCreationMessageOnlyId(User user) {
        System.out.println("Attempting to create user: " + user.getID());
    }

    @Before("com.jzajas.Aspects.Services.deleteUserById() && args(user...)")
    public void sendUserDeletingMessage(User user) {
        System.out.println("User is being deleted: " + user);
    }
}
