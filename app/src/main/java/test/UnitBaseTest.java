package test;

import org.junit.Assert;

/**
 * @ProjectName: DemoApp
 * @Desc:
 * @Author: YangShuang
 * @Date: 2023/12/18
 */
public class UnitBaseTest {
    UnitBase mUnitBase = new UnitBase();

    @org.junit.Test
    public void testAdd() {
        int a = 1;
        int b = 2;
        int result = mUnitBase.add(a, b);
        Assert.assertEquals(result, 5);
    }

    // @org.junit.Test
    // public void testAdd2() {
    //     int result = mUnitBase.add(a, b);
    //     Assert.assertEquals(result, 5);
    // }
}
