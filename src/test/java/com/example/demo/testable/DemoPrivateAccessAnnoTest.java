package com.example.demo.testable;

import com.alibaba.testable.processor.annotation.EnablePrivateAccess;
import com.example.demo.testable.mock.DemoPrivateAccess;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * 演示私有成员访问功能
 * Demonstrate private member access functionality
 */
@EnablePrivateAccess
class DemoPrivateAccessAnnoTest {

    private DemoPrivateAccess demoPrivateAccess = new DemoPrivateAccess();

    @Test
    void should_able_to_access_private_method() {
        assertEquals("hello - 1", demoPrivateAccess.privateFunc("hello", 1));
    }

    @Test
    void should_able_to_access_private_field() {
        assertEquals(new Integer(1), demoPrivateAccess.count);
    }

    @Test
    void should_able_to_access_private_static_method() {
        assertEquals("hello + 1", DemoPrivateAccess.privateStaticFunc( "hello", 1));
    }

    @Test
    void should_able_to_access_private_static_field() {
        assertEquals(new Integer(2), DemoPrivateAccess.staticCount);
    }

    @Test
    void should_able_to_update_final_field() {
        demoPrivateAccess.pi = 4.11;
        assertEquals(4.11, demoPrivateAccess.pi);
    }

}
