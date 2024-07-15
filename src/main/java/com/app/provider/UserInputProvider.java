package com.app.provider;

import java.util.Scanner;

public interface UserInputProvider {
    Scanner sc = new Scanner(System.in);

    static int getInteger() {
        return sc.nextInt();
    }
}
