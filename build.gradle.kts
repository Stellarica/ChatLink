plugins {
	kotlin("jvm") version "1.8.0"
	kotlin("plugin.serialization") version "1.8.0"
	java
	alias(libs.plugins.quilt.loom)
}
group = property("maven_group")!!
version = property("version")!!

repositories {
	maven("https://maven.nucleoid.xyz")
}

dependencies {
	minecraft(libs.minecraft)
	mappings(variantOf(libs.quilt.mappings) { classifier("intermediary-v2") })
	modImplementation(libs.quilt.loader)
	modImplementation(libs.quilted.fabric.api)
	modImplementation(libs.quilt.kotlin)

	modImplementation(libs.placeholder)
	include(libs.placeholder)
}

tasks {

	processResources {
		inputs.property("version", project.version)
		filesMatching("quilt.mod.json") {
			expand(mutableMapOf("version" to project.version))
		}
	}

	jar {
		from("LICENSE")
	}

	compileKotlin {
		kotlinOptions.jvmTarget = "17"
	}
}

java {
	withSourcesJar()
}
