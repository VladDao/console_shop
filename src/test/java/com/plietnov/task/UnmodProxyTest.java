package com.plietnov.task;

import com.plietnov.task.entity.Computer;
import com.plietnov.task.entity.intef.ComputerInterface;
import com.plietnov.task.proxy.ProxyFactory;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class UnmodProxyTest {

    private Computer computer = new Computer();
    private ComputerInterface computerUnmodProxy = ProxyFactory.newInstanceUnmodProxy(computer);
    private ComputerInterface computerMapProxy = ProxyFactory.newInstanceMapProxy(computer);

    @Test(expected = UnsupportedOperationException.class)
    public void setUnmodProxy_addIdToUnmodProxy_UnsupportedOperationException() {
        computerUnmodProxy.setId(1);
    }

    @Test
    public void setMapProxy_setIdToMapProxy_ShouldBeSet() {
        int setId = 777;
        computerMapProxy.setId(777);
        assertNotEquals(computer.getId(), computerMapProxy.getId());
        assertEquals(setId, computerMapProxy.getId());
    }

    @Test
    public void setUnmodProxy_addIdToUnmodProxy_ShouldBeSet() {
        int setId = 777;
        computer.setId(setId);
        computerUnmodProxy = ProxyFactory.newInstanceUnmodProxy(computer);
        assertEquals(computer.getId(), computerUnmodProxy.getId());
        assertNotEquals(computer, computerUnmodProxy);
    }
}
