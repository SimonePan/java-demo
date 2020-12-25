package com.example.demo.testable;

import com.alibaba.testable.core.accessor.PrivateAccessor;
import com.example.demo.testable.mock.DemoPrivateAccess;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * 演示私有成员访问功能
 * Demonstrate private member access functionality
 */
class DemoPrivateAccessUtilTest {

    private DemoPrivateAccess demoPrivateAccess = new DemoPrivateAccess();

    @Test
    public void should_able_to_access_private_method() {
        assertEquals("hello - 1", PrivateAccessor.invoke(demoPrivateAccess, "privateFunc", "hello", 1));
    }

    @Test
    void should_able_to_access_private_field() {
        PrivateAccessor.set(demoPrivateAccess, "count", 3);
        assertEquals(new Integer(3), PrivateAccessor.get(demoPrivateAccess, "count"));
    }

    @Test
    void should_able_to_access_private_static_method() {
        assertEquals("hello + 1", PrivateAccessor.invokeStatic(DemoPrivateAccess.class, "privateStaticFunc", "hello", 1));
    }

    @Test
    void should_able_to_access_private_static_field() {

        PrivateAccessor.setStatic(DemoPrivateAccess.class, "staticCount", 3);
        assertEquals(new Integer(3), PrivateAccessor.getStatic(DemoPrivateAccess.class, "staticCount"));
    }

    @Test
    public void should_able_to_update_final_field() {
        PrivateAccessor.set(demoPrivateAccess, "pi", 3.11);
        assertEquals(Double.valueOf(3.11), PrivateAccessor.get(demoPrivateAccess, "pi"));
    }

}
