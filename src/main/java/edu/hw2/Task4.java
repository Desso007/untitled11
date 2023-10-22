package edu.hw2;

public class Task4 {

    public static CallingInfo callingInfo() {
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        if (stackTraceElements.length >= 3) {
            StackTraceElement caller = stackTraceElements[2];
            String className = caller.getClassName();
            String methodName = caller.getMethodName();
            return new CallingInfo(className, methodName);
        }
        return null;
    }

    public static void main(String[] args) {
        CallingInfo info = callingInfo();
        if (info != null) {
            System.out.println("Called from class: " + info.className + ", method: " + info.methodName);
        } else {
            System.out.println("Could not determine the calling class and method.");
        }
    }

    public record CallingInfo(String className, String methodName) {
    }
}
