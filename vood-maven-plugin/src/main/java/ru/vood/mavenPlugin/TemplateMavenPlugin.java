package ru.vood.mavenPlugin;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;

@Mojo(name = "setname", defaultPhase = LifecyclePhase.GENERATE_SOURCES, threadSafe = true)
public class TemplateMavenPlugin  extends AbstractMojo {

    

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {

    }
}
