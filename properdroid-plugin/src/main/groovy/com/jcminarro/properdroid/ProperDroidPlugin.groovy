package com.jcminarro.properdroid;

import com.android.build.gradle.AppPlugin
import org.codehaus.jettison.json.JSONObject
import org.gradle.api.Plugin
import org.gradle.api.Project

class ProperDroidPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
        def hasApp = project.plugins.withType(AppPlugin)
        project.extensions.create("properdroid", ProperDroidExtension)
        if (hasApp) {
            project.afterEvaluate({
                if (project?.properdroid?.properdroidvalues) {
                    def defaultProperties = project?.properdroid?.properdroidvalues?.default ?: [:]
                    def variants = project.android.applicationVariants
                    variants.each {
                        Map properties = [:]
                        properties += defaultProperties
                        properties += project.properdroid.properdroidvalues["${it.flavorName}"] as Map ?: [:]
                        properties += project.properdroid.properdroidvalues["${it.buildType.name}"] as Map ?: [:]
                        properties += project.properdroid.properdroidvalues["${it.name}"] as Map ?: [:]
                        def assetsDir = new File("$project.projectDir/src/${it.name}/assets/")
                        assetsDir.mkdirs()
                        def properdroidJson = new File(assetsDir, "properdroid.json")
                        properdroidJson.delete()
                        properdroidJson << (properties as JSONObject).toString(2)
                    }
                }
            })
        }
    }
}
