package com.lrc.listener;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @param
 * @author lrc
 * @create 2021/12/20
 * @return
 * @description
 **/
public class GlobalAnnotationTransformer implements IAnnotationTransformer {
    //通过实现IAnnotationTransformer接口可以动态的修改@Test注解的属性
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        // 获取@Test注解的RetryAnalyzer属性对象
        IRetryAnalyzer iRetryAnalyzer = annotation.getRetryAnalyzer();
        if (iRetryAnalyzer == null) {
            annotation.setRetryAnalyzer(RetryListener.class);
        }
    }
}
