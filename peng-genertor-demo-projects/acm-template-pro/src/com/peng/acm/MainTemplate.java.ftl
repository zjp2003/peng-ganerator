<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
package com.peng.acm;

import java.util.Scanner;

/**
 * ACM 输入模板（多数之和）
 * @author ${author}
 */
public class MainTemplate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        <#if loop>
        while(scanner.hasNext()){
        </#if>
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

            System.out.println("${outputText}" + sum);
        <#if loop>
            }
        </#if>
        scanner.close();
    }
}
