package org.example;


public class Main {
    public static void main(String[] args) {
        String requestData = "435435";

        Dept dept = Dept.valueOfDefault("CENTER_"+ requestData);

        StringBuilder st = new StringBuilder();
        System.out.println(st.append(dept.getCode()).append(" ").append(dept.getAccount()));
    }
}