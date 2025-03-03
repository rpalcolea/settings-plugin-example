package netflix

import org.gradle.api.Plugin
import org.gradle.api.initialization.Settings

class MySettingsPlugin implements Plugin<Settings> {
    @Override
    void apply(Settings settings) {
        settings.gradle.allprojects {project ->
            def dependencyHandler = project.buildscript.dependencies
            def buildClasspathDependencies = ['com.netflix.nebula:nebula-project-plugin:11.0.0']
            buildClasspathDependencies.each {
                dependencyHandler.add("classpath", it)
            }
        }
    }
}
