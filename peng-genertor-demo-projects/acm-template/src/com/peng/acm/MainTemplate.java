package com.peng.acm;

import java.util.Scanner;

public class MainTemplate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNext()){
            // 读取输入元素的个数
            int n = scanner.nextInt();

            // 读取数组
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }

            // 处理逻辑问题,根据需要输出
            // 示例
            int sum = 0;
            for (int num : arr) {
                sum += num;
            }

            System.out.println("sum: " + sum);
        }
        scanner.close();
    }
}
