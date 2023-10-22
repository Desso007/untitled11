package edu.hw2;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

public class Task4test {



    @Test
    public void testCallingInfoFromMyClass() {
        MyClass myClass = new MyClass();
        Task4.CallingInfo info = myClass.callingMethod();
        assertEquals(info.className(), "edu.hw2.Task4test$MyClass", "Class name should be 'edu.hw2.Task4test$MyClass'");
        assertEquals(info.methodName(), "callingMethod", "Method name should be 'callingMethod'");
    }

    static class MyClass {
        public Task4.CallingInfo callingMethod() {
            return Task4.callingInfo();
        }
    }
}
