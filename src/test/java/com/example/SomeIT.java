package com.example;

import java.io.IOException;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.testng.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.jboss.shrinkwrap.resolver.api.maven.PomEquippedResolveStage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SomeIT extends Arquillian {

    @Deployment
    public static Archive<?> createDeploymentPackage() throws IOException {
        PomEquippedResolveStage pom = Maven.resolver().loadPomFromFile( "pom.xml" );

        return ShrinkWrap.create(WebArchive.class, "test.war")
                .addClass(SomeIT.class)
                .addAsLibraries( pom.resolve( "org.testng:testng" ).withTransitivity().asFile() );
    }

    @Test
    public void shouldAlwaysFail() {
        Assert.assertFalse( true );
    }
}
