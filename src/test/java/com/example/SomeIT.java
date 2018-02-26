/*
/*/
//*

package com.example;

import java.io.IOException;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.testng.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class SomeIT extends Arquillian {

    @Deployment
    public static Archive<?> createDeploymentPackage() throws IOException {
        return ShrinkWrap.create(WebArchive.class, "test.war")
           .addClass(SomeIT.class);
    }

    @Test
    public void shouldAlwaysFail() {
        Assert.assertFalse(true);
    }

    @Test(expectedExceptions = IllegalStateException.class)
    public void testHomePageHasAHeader() {
        throw new IllegalStateException("");
    }

    @Test
    public void foo() {
        System.out.println("Hello:::::::::::::::::::::");
        throw new SkipException("Skipping this exception");
    }
}

