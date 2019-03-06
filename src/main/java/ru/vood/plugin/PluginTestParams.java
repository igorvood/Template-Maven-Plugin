package ru.vood.plugin;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import ru.vood1.PluginTines;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

@Mojo(name = "setname", defaultPhase = LifecyclePhase.GENERATE_SOURCES, threadSafe = true)
public class PluginTestParams extends AbstractMojo {

    @Parameter(property = "driverClassName")
    private String driverClassName;

/*
    @Parameter(property = "someDataClass")
    private SomeDataClass someDataClass;
*/

    @Parameter(property = "filename")
    private String filename;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        System.out.println("------>" + driverClassName);
//        System.out.println("------>" + someDataClass);ru.vood:plugin.
        System.out.println("------>" + filename);

        PluginParamsXml pluginParamsXml = null;
        StringBuilder sb = new StringBuilder();
        try {
            pluginParamsXml = new PluginParamsXml();
            Files.lines(Paths.get(filename), StandardCharsets.UTF_8).forEach(sb::append);
            System.out.println("------>\n" + sb + "\n");
            final PluginTines pluginTines = pluginParamsXml.xmlToObj(sb.toString());
            System.out.println("pluginTines------>" + toString(pluginTines));
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String toString(PluginTines pluginTines) {
/*
        System.out.println("pluginTines.getTableClassList().getGeneratingClassesAndTableLISTTypes().getClass() -> " +
                pluginTines.getTableClassList().getGeneratingClassesAndTableLISTs().getClass());
*/
        return "PluginTines{" +
                "username='" + pluginTines.getUsername() + '\'' +
                ", password='" + pluginTines.getPassword() + '\'' +
                ", tableClassList=" + pluginTines.getTableClassList().getLists() +
                '}';
    }

/*
    private PluginTines createPluginTines() {
        PluginTines pluginTines = new PluginTines();
        pluginTines.setPassword("setPassword");
        pluginTines.setUsername("setUsername");
        final TableClassListType value = new TableClassListType();
        pluginTines.setTableClassList(value);
        return pluginTines;
    }
*/

}
