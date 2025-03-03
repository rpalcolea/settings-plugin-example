package netflix

import org.gradle.api.NamedDomainObjectContainer
import org.gradle.api.Plugin
import org.gradle.api.Project
import nebula.plugin.responsible.FacetDefinition
import nebula.plugin.responsible.NebulaFacetPlugin
import nebula.plugin.responsible.TestFacetDefinition
import org.gradle.api.plugins.JavaPlugin

class MyProjectPlugin implements Plugin<Project> {
    @Override
    void apply(Project project) {
        project.plugins.withType(JavaPlugin).configureEach {
            project.getPlugins().apply(NebulaFacetPlugin.class)
            NamedDomainObjectContainer<FacetDefinition> facetDefinitions = (NamedDomainObjectContainer<FacetDefinition>) project.getExtensions().getByName("facets")
            TestFacetDefinition smokeTestFacet = new TestFacetDefinition("smokeTest")
            smokeTestFacet.setTestTaskName("smokeTest")
            smokeTestFacet.setIncludeInCheckLifecycle(true)
            smokeTestFacet.setParentSourceSet("test")
            facetDefinitions.add(smokeTestFacet)
        }
    }
}
