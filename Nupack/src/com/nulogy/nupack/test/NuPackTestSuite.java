package com.nulogy.nupack.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ MarkupCalculatorTest.class, PriceFormatterTest.class,
		ProjectTest.class })
public class NuPackTestSuite {

}
