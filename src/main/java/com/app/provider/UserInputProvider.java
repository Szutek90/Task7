package com.app.provider;

import java.util.Scanner;

public class UserInputProvider {
    static Scanner sc = new Scanner(System.in);

    private UserInputProvider() {}

    public static int getInteger() {
        return sc.nextInt();
    }
}
